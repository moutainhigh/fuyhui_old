package com.fujfu.web.invest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujfu.common.fee.FixedLoanInrestUtil;
import com.fujfu.common.fee.FixedLoanInrestVo;
import com.fujfu.common.payment.fuyou.pojo.CapitalFreezeBean;
import com.fujfu.common.payment.fuyou.pojo.QueryBalanceBean;
import com.fujfu.common.payment.fuyou.pojo.response.CapitalFreezeResp;
import com.fujfu.common.payment.fuyou.pojo.response.QueryBalanceResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.SmsTypeUtil;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.dao.award.UsersAwardActionMapper;
import com.fujfu.pojo.account.UserAccountLogVO;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.award.UsersAwardAccountVO;
import com.fujfu.pojo.award.UsersAwardActionVO;
import com.fujfu.pojo.invest.LoanInvestmentVO;
import com.fujfu.pojo.loan.LoanApplyVO;
import com.fujfu.pojo.loan.LoanTypeVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.CapitalMgtServ;
import com.fujfu.service.account.SiteBillingServ;
import com.fujfu.service.account.UserAccountLogServ;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.award.AwardUserAddServ;
import com.fujfu.service.common.CommonServ;
import com.fujfu.service.invest.LoanInvestmentServ;
import com.fujfu.service.loan.LoanApplyServ;
import com.fujfu.service.loan.LoanTypeServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.web.BaseController;

@Controller
public class InvestCtrl extends BaseController {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(InvestCtrl.class);
	@Resource
	UsersAwardActionMapper usersAwardActionMapper;
	@Resource
	private LoanInvestmentServ loanInvestmentServ;
	@Resource
	private LoanApplyServ loanApplyServ;
	@Resource
	private UserServ userServ;
	@Resource
	private UserAccountServ userAccountServ;
	@Resource
	private UserAccountLogServ userAccountLogServ;
	@Resource
	private CapitalMgtServ capitalMgtServ;
	@Resource
	private LoanTypeServ loanTypeServ;
	@Resource
	private CommonServ commonServ;
	@Resource
	private AwardUserAddServ awardUserAddServ;
	@Resource
	private SiteBillingServ siteBillingServ;
	@RequestMapping("/invest")
	@ResponseBody
	public Object invest(String id, String investMoney, String rewardId, String rewardMoney) {
		// 返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		UserVO userInf = (UserVO) getSession("user_inf");
		// 用户登录时进行投资条件判断
		if (userInf == null) {
			return returnMessage(map, "2", "请登录！");
		}
		userInf = userServ.getUserByUserId(userInf.getUserId());
		// 判断是否是投资用户
		if (!userInf.getUserType().equals("1")) {
			return returnMessage(map, "0", "非认购用户不能认购!");
		}
		if(StringUtils.isEmpty(userInf.getJzhloginid())){
			return returnMessage(map, "0", "您尚未开通富友托管账户!");
		}
		BigDecimal money = new BigDecimal(0);// 投资金额
		BigDecimal actualMoney = new BigDecimal(0);// 实际扣减金额
		int applyId = 0;// 标的id
		BigDecimal cash = new BigDecimal(0);// 可用余额
		if (StringUtils.isNotEmpty(investMoney) && StringUtils.isNotEmpty(id)) {
			money = new BigDecimal(investMoney);
			applyId = Integer.parseInt(id);
		} else {
			return returnMessage(map, "0", "认购失败,系统异常!");
		}

		if (StringUtils.isNotEmpty(rewardId) && StringUtils.isNotEmpty(rewardMoney)) {
			actualMoney = money.subtract(new BigDecimal(rewardMoney));
		} else {
			actualMoney = money;
		}
		// 根据标的id获取标的信息
		LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(applyId);
		int currenTime = DateUtil.getUnixTime();
		// 判断当前时间是否小于投资截止时间
		if (loanApply.getEndTime() < currenTime) {
			return returnMessage(map, "0", "已过认购截止时间！");
		}
		// 计算剩余可投金额
		BigDecimal remainAmt = loanApply.getAmount().subtract(loanApply.getAmountInvested());
		// 投资金额大于项目剩余可投金额
		if (money.compareTo(remainAmt) > 0) {
			return returnMessage(map, "0", "当前剩余认购金额为：" + remainAmt + "元!");
		}
		if (money.compareTo(remainAmt) < 0) {
			// 剩下一笔可投资金额小于最小投资金额必须要一次投完剩余的
			if (remainAmt.compareTo(loanApply.getInvestMin()) < 0) {
				if (money.compareTo(remainAmt) != 0) {
					return returnMessage(map, "0", "剩余认购金额低于最低认购金额，您必须一次认购完" + remainAmt.doubleValue() + "元");
				}
			} else {
				BigDecimal investMin = loanApply.getInvestMin();
				// 大于投资最小金额且小于最大投资金额
				if (investMin.compareTo(money) > 0) {
					return returnMessage(map, "0", "认购金额低于最低认购金额!");
				}
				BigDecimal proAmount = loanApply.getProAmount();
				if (money.subtract(investMin).doubleValue() % proAmount.doubleValue() != 0) {
					return returnMessage(map, "0", "认购金额 " + investMin + "元起，且为" + proAmount + " 元的整数倍递增!");
				}
			}
		}
		
		// 判断是否余额足够，否则提醒充值
		// 查询余额
		QueryBalanceBean reqBalance = new QueryBalanceBean();
		reqBalance.setCust_no(userInf.getJzhloginid());
		QueryBalanceResp respBalance = capitalMgtServ.queryBalance(reqBalance);
		if (respBalance.getResponse() != null) {
			respBalance = respBalance.getResponse().getRespList().get(0);// 返回金额单位为分
			cash = StringUtils.isNotEmpty(respBalance.getCa_balance())
					? new BigDecimal(Integer.parseInt(respBalance.getCa_balance()) / 100) : new BigDecimal(0);
		}else{
			return returnMessage(map, "0", "系统异常!");
		}

		if (cash.compareTo(actualMoney) < 0) {
			return returnMessage(map, "0", "可用余额不足，请充值!");
		}



		// 更新标的信息
		loanApply.setAmountInvested(loanApply.getAmountInvested().add(money));
		int result = loanApplyServ.updateLoanApplyByVersion(loanApply);
		if (result > 0) {
			// 转账红包
			/* 红包使用 */
			if (StringUtils.isNotEmpty(rewardId) && StringUtils.isNotEmpty(rewardMoney)) {
				int i = awardUserAddServ.useUserAward(rewardId, money, userInf.getUserId(), loanApply.getId(), "投资红包使用");
				if (i == -1) {
					return returnMessage(map, "0", "认购失败,系统异常!");
				}
			}	
			
			// 以下掉单情况未考虑
			String amtStr = money.multiply(new BigDecimal(100)).intValue() + ""; // 冻结金额分
			CapitalFreezeBean freeze = new CapitalFreezeBean();
			freeze.setCust_no(userInf.getJzhloginid());// 用户id
			freeze.setAmt(amtStr);
			CapitalFreezeResp caFreResp = capitalMgtServ.capitalFreeze(freeze, userInf, null, "投资冻结", loanApply.getOrderNumber());
			if (caFreResp.getResponse() != null) {
				String caFreRespCode = caFreResp.getResponse().getResp_code();
				if (caFreRespCode.equals(FyUtil.SUCCESS)) {
					
					// 冻结成功修改 对账表信息
					siteBillingServ.updateBusiStatus(0, caFreResp.getResponse().getMchnt_txn_ssn());
					// 查询余额
					QueryBalanceBean reqData = new QueryBalanceBean();
					reqData.setCust_no(userInf.getJzhloginid());
					QueryBalanceResp resp = capitalMgtServ.queryBalance(reqData);

					LoanInvestmentVO loanInvestment = new LoanInvestmentVO();

					// 更新账户表
					if (resp.getResponse() != null) {
						String respCode = resp.getResponse().getResp_code();
						if (respCode.equals(FyUtil.SUCCESS)) {
							resp = resp.getResponse().getRespList().get(0);// 返回金额单位为分
							// 插入投资记录表
							loanInvestment.setUserId(userInf.getUserId());
							loanInvestment.setApplyId(applyId);
							loanInvestment.setMoney(money);
							loanInvestment.setInvestTime(DateUtil.getUnixTime());
							// 生成投资债权编号
							LoanTypeVO loanType = loanTypeServ.findLoanTypeById(loanApply.getLoanType());

							String claimNumber = "";
							String oldMaxclaimNumber = loanInvestmentServ
									.findMaxInvestClaimNumber(loanApply.getOrderNumber());
							log.info("oldMaxclaimNumber==" + oldMaxclaimNumber);
							if ("".equals(oldMaxclaimNumber) || oldMaxclaimNumber == null) {
								claimNumber = loanApply.getOrderNumber() + "001";
							} else {
								claimNumber = UserAccountUtil.getInvestmentClaimNumber(oldMaxclaimNumber,
										loanType.getName());

							}
							log.info("claimNumber==" + claimNumber);

							loanInvestment.setClaimNumber(claimNumber);// 投资债权编号
							loanInvestmentServ.addLoanInvestment(loanInvestment);

							// 更新用户账户
							updateUserAccount(userInf);

							// 记录投资冻结记录
							UserAccountVO userAccount = userAccountServ.selectByUserId(userInf.getUserId());// 查询本地账户信息
							UserAccountLogVO userAccountLog = new UserAccountLogVO();
							userAccountLog.setUserId(userInf.getUserId());
							userAccountLog.setType(4201);
							userAccountLog.setMoney(money.setScale(2, BigDecimal.ROUND_HALF_UP));
							userAccountLog.setTotal(userAccount.getTotal());
							userAccountLog.setFrost(userAccount.getFrost());
							userAccountLog.setCash(userAccount.getCash());
							userAccountLog.setAddTime(DateUtil.getUnixTime());
							userAccountLog.setApplyId(applyId);
							// userAccountLog.setFrom();
							// userAccountLog.setTo();
							userAccountLog.setMemo(loanApply.getName());
							// 保存债权编号到交易明细表
							userAccountLog.setBusiNumber(claimNumber);
							userAccountLogServ.insertSelective(userAccountLog);

							// 完成后判断是否已经投满，若满修改标的状态
							if (loanApply.getAmount()
									.compareTo(loanInvestmentServ.selectNowAmtByApplyId(applyId)) == 0) {
								loanApply.setCompleteTime(DateUtil.getUnixTime());
								loanApply.setStatus((byte) 8);
								loanApplyServ.updateLoanApply(loanApply);
							}
							// 投资完发送投资成功站内信
							commonServ.sendall(userInf.getMobile(), SmsTypeUtil.P2P_INVEST_SUC,
									DateUtil.getCurrentDate("yyyy-MM-dd"), loanApply.getName(), money.toString(), "");
							
							return returnMessage(map, "1", "认购成功，金额" + money + "元!");
						}
					}
				}else{
					loanApply.setAmountInvested(loanApply.getAmountInvested().subtract(money));
					loanApplyServ.updateLoanApply(loanApply);
					
					UsersAwardActionVO usersAwardAction = new UsersAwardActionVO();
					usersAwardAction.setRewardId(rewardId);
					usersAwardAction.setInvesterId(userInf.getUserId());
					usersAwardAction.setFySerialno(caFreResp.getResponse().getMchnt_txn_ssn());
					usersAwardAction.setStatus(2);
					usersAwardAction.setCreated(DateUtil.getUnixTime());
					usersAwardActionMapper.insertSelective(usersAwardAction);
					// 冻结失败修改 对账表信息
					siteBillingServ.updateBusiStatus(1, caFreResp.getResponse().getMchnt_txn_ssn());
				}
			}
			
			
		} else {
			return returnMessage(map, "0", "认购失败,系统异常!");
		}
		return map;
	}

	/**
	 * 投资时返回的json对象
	 * 
	 * @param flag
	 * @param msg
	 * @return
	 */
	private Map<String, Object> returnMessage(Map<String, Object> map, String flag, String msg) {
		map.put("flag", flag);
		map.put("msg", msg);
		return map;
	}


	
	/**
	 *投资利息试算
	 * 
	 * @param model
	 * @param awardType
	 * @return
	 */
	@RequestMapping("/calulateIntrest")
	@ResponseBody
	public Object calulateIntrest(String id,String InvestMoney) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserVO userInf = (UserVO) getSession("user_inf");

		if(userInf == null){
			map.put("flag", "2");
			map.put("msg", "请登录！");
			return map;						
		}
		
		if(id == null||"".equals(id)){
			map.put("flag", "0");
			map.put("msg", "标的ID不可为空");
			return map;					
		}
		

		if(InvestMoney == null||"".equals(InvestMoney)){
			map.put("flag", "0");
			map.put("msg", "投资金额不可为空");
			return map;					
		}		
		
		LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(Integer.valueOf(id));
		
		
		/*胜算利息*/
		FixedLoanInrestVo fixedLoanInrestVo  = new FixedLoanInrestVo();
		//起始日期（yyyyMMdd）
		String startDate = DateUtil.timeMillisToStr(loanApply.getStartTime(), "yyyyMMdd");
		fixedLoanInrestVo.setStartDate(startDate);
		// 结束日期（yyyyMMdd）
		//结束日期
		String endDate = DateUtil.timeMillisToStr(loanApply.getDueTime(), "yyyyMMdd");
		fixedLoanInrestVo.setEndDate(endDate);
		//总的本金金额
		fixedLoanInrestVo.setTotalCaptital(new BigDecimal(InvestMoney));
		//利息周期方式（1-按月，3-按季，0-一次性还本息）
		int paymentOptions = loanApply.getPaymentOptions();
		if (paymentOptions == 1){
			fixedLoanInrestVo.setPerIntrestDuration(1);
		} else if (paymentOptions == 2){
			fixedLoanInrestVo.setPerIntrestDuration(0);
		} else if (paymentOptions == 5){
			fixedLoanInrestVo.setPerIntrestDuration(3);
		}
		
		// 年利率
		Double apr = Double.parseDouble(String.valueOf(loanApply.getApr()));	
		//分期还款日
		fixedLoanInrestVo.setPayDay(loanApply.getInstallmentDate());
		//线下放款日
		if(loanApply.getLineloanDate() != null ){
		fixedLoanInrestVo.setOffLineLoanDate(DateUtil.timeMillisToStr(loanApply.getLineloanDate(), "yyyyMMdd"));		
		}
		fixedLoanInrestVo.setRate(new BigDecimal(apr));
		//计算结果
		fixedLoanInrestVo = FixedLoanInrestUtil.calulate(fixedLoanInrestVo);
		
		Map<String, Object> content = new HashMap<String, Object>();
		
		content.put("totalIntrest", fixedLoanInrestVo.getTotalIntrest());
		content.put("loanName", loanApply.getName());
		content.put("rate", apr);
		content.put("term", loanApply.getPeriod());

		map.put("flag", "1");
		map.put("content", content);
		return map;
	}	
	
	
	
	/**
	 * 查询用户投资可使用红包
	 * 
	 * @param model
	 * @param awardType
	 * @return
	 */
	@RequestMapping("/availRedAward")
	@ResponseBody
	public Object availRedAward(BigDecimal tranAmount) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserVO userInf = (UserVO) getSession("user_inf");

		if(userInf == null){
			map.put("flag", "2");
			map.put("msg", "请登录！");
			return map;						
		}
		
		List<UsersAwardAccountVO> usersAwardAccountList =  awardUserAddServ.searchUserAward(userInf.getUserId(), tranAmount);


		map.put("flag", "1");
		if (usersAwardAccountList == null){
			map.put("size", 0);
		} else {
			map.put("size", usersAwardAccountList.size());
		}
		map.put("content", usersAwardAccountList);
		return map;
	}

	/**
	 * 查询用户红包结果
	 * 
	 * @param model
	 * @param awardType
	 * @return
	 */
	@RequestMapping("/searchRedAward")
	@ResponseBody
	public Object searchRedAward(String flag) {
		Map<String, Object> map = new HashMap<String, Object>();
		if ("".equals(flag)) {
			map.put("flag", "2");
			map.put("msg", "查询标识不可为空");
		}
		UserVO userInf = (UserVO) getSession("user_inf");
		List<UsersAwardAccountVO> usersAwardAccountList = awardUserAddServ.searchUserAward(userInf.getUserId(), flag);
		map.put("flag", "1");
		map.put("content", usersAwardAccountList);
		map.put("totalAccount", usersAwardAccountList.size());
		return map;
	}

}
