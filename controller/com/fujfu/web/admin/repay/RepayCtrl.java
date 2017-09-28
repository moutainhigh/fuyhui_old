package com.fujfu.web.admin.repay;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujfu.common.payment.fuyou.CapitalMgt;
import com.fujfu.common.payment.fuyou.pojo.QueryBalanceBean;
import com.fujfu.common.payment.fuyou.pojo.TransBmuBean;
import com.fujfu.common.payment.fuyou.pojo.TransBuBean;
import com.fujfu.common.payment.fuyou.pojo.response.QueryBalanceResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBmuResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBuResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.SmsTypeUtil;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.SiteAccountLogVO;
import com.fujfu.pojo.account.SiteAccountVO;
import com.fujfu.pojo.account.UserAccountLogVO;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.apply.ApplyRecoverVO;
import com.fujfu.pojo.apply.ApplyRepayVO;
import com.fujfu.pojo.apply.ApplyRepayPOJO;
import com.fujfu.pojo.apply.PrepaymentDTO;
import com.fujfu.pojo.fee.SiteFeeTypePOJO;
import com.fujfu.pojo.loan.LoanPOJO;
import com.fujfu.pojo.loan.LoanApplyVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.CapitalMgtServ;
import com.fujfu.service.account.SiteAccountLogServ;
import com.fujfu.service.account.SiteAccountServ;
import com.fujfu.service.account.SiteBillingServ;
import com.fujfu.service.account.UserAccountLogServ;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.common.CommonServ;
import com.fujfu.service.fee.SiteFeeServ;
import com.fujfu.service.invest.LoanInvestmentServ;
import com.fujfu.service.lender.impl.LenderServImpl;
import com.fujfu.service.loan.LoanApplyServ;
import com.fujfu.service.repay.RepayServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.web.BaseController;

@Controller
@RequestMapping("/repay/")
public class RepayCtrl extends BaseController {
	private static final long serialVersionUID = 1L;
	@Resource
	private RepayServ repayServ;
	@Resource
	private UserAccountServ userAccountServ;
	@Resource
	private LoanApplyServ loanApplyServ;
	@Resource
	private UserServ userServ;
	@Resource
	private SiteFeeServ siteFeeServ;
	@Resource
	private UserAccountLogServ userAccountLogServ;
	@Resource
	private CapitalMgtServ capitalMgtServ;
	@Resource
	private SiteAccountLogServ siteAccountLogServ;
	@Resource
	private SiteAccountServ siteAccountServ;
	@Resource
	private CommonServ commonServ;
	@Resource
	private LoanInvestmentServ loanInvestmentServ;
	@Resource
	private SiteBillingServ siteBillingServ;
	private static Logger log = Logger.getLogger(LenderServImpl.class);

	@RequestMapping("advanceRepay")
	public String advanceRepay(Page page, Model model) {
		ApplyRepayPOJO applyRepay = new ApplyRepayPOJO();
		applyRepay.setStatus((byte)1);
		Page repayList = repayServ.findApplyRepayByCondition(applyRepay, page);
		model.addAttribute("repayList", repayList);
		return "/views/admin/repay/advanceRepayList.jsp";
	}
	
	/**
	 * 还款提醒
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("repaymentReminder")
	public String repaymentReminder(Page page, Model model) {
		Page repayList = repayServ.findRepaymentReminder(page);
		model.addAttribute("repayList", repayList);
		return "/views/admin/repay/repaymentReminderList.jsp";
	}
	
	/**
	 * 提前还款详情
	 * @param model
	 * @return
	 */
	@RequestMapping("prepaymentDetail")
	public String prepaymentDetail(Model model,String id){
		LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(Integer.parseInt(id));
		PrepaymentDTO prepayment = repayServ.getPrepaymentDetail(loanApply);
		if(prepayment.getRepayMoney() == null){
			model.addAttribute("msg", "未配置提前还款服务费或配置的不是比例");
			return "/views/admin/repay/prepaymentDetail.jsp";
		}
		UserVO user = userServ.getUserByUserId(loanApply.getUserId());
		// 获取借款人可用余额
		BigDecimal balance = userAccountServ.selectByUserId(loanApply.getUserId()).getCash();
		model.addAttribute("loan", loanApply);
		model.addAttribute("corpName", user.getCorpName());
		model.addAttribute("balance", balance);
		model.addAttribute("prepaymentDetail", prepayment);
		return "/views/admin/repay/prepaymentDetail.jsp";
	}
	
	/**
	 * 提前还款处理
	 * @param model
	 * @param id
	 * @param prepayment
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "prepayment",method = RequestMethod.POST)
	@ResponseBody
	public Object prepayment(String id,PrepaymentDTO prepayment) throws Exception{
		LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(Integer.parseInt(id));
		// 获取借款人可用余额
		BigDecimal balance = userAccountServ.selectByUserId(loanApply.getUserId()).getCash();
		// 返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		if(prepayment.getTotalRepay().compareTo(balance)>0){
			map.put("flag", 0);
			map.put("msg", "余额不足！");
			return map;
		}
		
		boolean flag = repayServ.prepayment(loanApply, prepayment);
		if(flag){
			map.put("flag", 1);
			map.put("msg", "提前还款成功！");
		}else{
			map.put("flag", 0);
			map.put("msg", "提前还款失败！");
		}
		return map;
	}
	
	/**
	 * 还款详情
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("detail")
	public String repayDetail(Model model, String id, String per) {
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(per)) {
			Map<String, Object> map = getRepayDetail(Integer.parseInt(id), Integer.parseInt(per));
			LoanPOJO loan = (LoanPOJO) map.get("loan");
			if(loan.getIsLoans()!=3){
				model.addAttribute("msg", "改项目还未解冻，无法进行还款！");
				return "redirect:/repay/advanceRepay";
			}
			model.addAttribute("platformRemain", map.get("platformRemain"));
			model.addAttribute("guaranteeCompanyRemain", map.get("guaranteeCompanyRemain"));
			model.addAttribute("lenderRemain", map.get("lenderRemain"));
			model.addAttribute("loan", map.get("loan"));
			model.addAttribute("applyRepay", map.get("applyRepay"));
			model.addAttribute("lenderRepay", map.get("lenderRepay"));
			model.addAttribute("platformRepay", map.get("platformRepay"));
			model.addAttribute("guaranteeRepay", map.get("guaranteeRepay"));
			model.addAttribute("id", id);
			return "/views/admin/repay/repayDetail.jsp";
		} else {
			model.addAttribute("msg", "缺少参数!");
			return "redirect:/repay/advanceRepay";
		}
	}

	/*
	 * 垫付还款与正常还款整合
	 */
	@RequestMapping("advanceRepayment")
	public String advanceRepayment(Model model, String id, String per) {
		// 判断参数是否为空
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(per)) {
			int period = Integer.parseInt(per);
			// 还款详情
			Map<String, Object> map = getRepayDetail(Integer.parseInt(id), period);
			ApplyRepayVO applyRepay = (ApplyRepayVO) map.get("applyRepay");
			int applyId = applyRepay.getApplyId();
			if (map.get("flag") != null && map.get("flag").equals("0")) {
				// 逾期
				applyRepay.setStatus((byte) 3);
				repayServ.updateByPrimaryKeySelective(applyRepay);
				model.addAttribute("msg", "已逾期!");
				return "redirect:/repay/advanceRepay";
			} else {
				if(repayServ.isExistNotRepayByPeriod(applyId, period)!=null){
					model.addAttribute("msg", "该项目第"+period+"前存在未还款的期数！");
					return "redirect:/repay/advanceRepay";
				}
				// 根据标的id查询出该标的的信息
				LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(applyId);
				// 从标的信息中取出借款人id
				int lenderId = loanApply.getUserId();
				UserVO lender = userServ.getUserByUserId(lenderId);
				// 从用户信息中中取出借款人金账户
				String lJzhloginid = lender.getJzhloginid();
				// 获取担保机构的userId
				int guaranteeId = userAccountServ.selectByUserId(Integer.parseInt((String) map.get("guaranteeCompanyId"))).getUserId();
				UserVO guarantee = userServ.getUserByUserId(guaranteeId);
				// 从用户信息中中取出担保机构金账户
				String gJzhloginid = guarantee.getJzhloginid();

				// 查询该标的投资收益服务费
				// SiteFeeTypePOJO siteFeeTypeVo =
				// siteFeeServ.queryChageMode(loanApply.getLoanType() + "",
				// "投资服务费", "1");
				SiteFeeTypePOJO siteFeeTypeVo = siteFeeServ.queryChageMode("", "投资服务费", "1");

				if (siteFeeTypeVo != null && siteFeeTypeVo.getFormulaType() == 1) {
					// 借款人扣款金额
					BigDecimal lenderRepay = (BigDecimal) map.get("lenderRepay");
					// 担保机构扣款金额
					BigDecimal guaranteeRepay = (BigDecimal) map.get("guaranteeRepay");
					// 平台扣款金额
					BigDecimal platformRepay = (BigDecimal) map.get("platformRepay");

					// 借款人、平台是否转账
					boolean isTransLenderRepay = true;
					boolean isTransPlatformRepay = true;
					// 正常还款
					if (lenderRepay.compareTo(new BigDecimal(0)) > 0 && guaranteeRepay.compareTo(new BigDecimal(0)) == 0
							&& platformRepay.compareTo(new BigDecimal(0)) == 0) {
						// 还款
						if (repayment(applyRepay, siteFeeTypeVo, loanApply,
								(List<ApplyRecoverVO>) map.get("applyRecoverList"), lJzhloginid)) {
							model.addAttribute("msg", "还款成功！");
						} else {
							model.addAttribute("msg", "还款失败！");
						}
						return "redirect:/repay/advanceRepay";
					}
//					// 担保机构垫付还款
//					if (lenderRepay.compareTo(new BigDecimal(0)) > 0 && guaranteeRepay.compareTo(new BigDecimal(0)) > 0
//							&& platformRepay.compareTo(new BigDecimal(0)) == 0) {
//						// 借款人账户转账至担保机构金额
//						int transferAmt = lenderRepay.setScale(2, BigDecimal.ROUND_HALF_UP)
//								.multiply(new BigDecimal(100)).intValue();
//						// 借款人转账至担保机构账户
//						TransBuBean transReqData = new TransBuBean();
//						// 付款登录账户
//						transReqData.setOut_cust_no(lJzhloginid);
//						// 收款登录账户
//						transReqData.setIn_cust_no(gJzhloginid);
//						// 转账金额
//						transReqData.setAmt(String.valueOf(transferAmt));
//						// 进行转账操作
//						TransBuResp transBuResp = null;
//						try {
//							transBuResp = CapitalMgt.transferBu(transReqData, lender, guarantee, "借款人转担保机构", loanApply.getOrderNumber());
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//						if (transBuResp != null) {
//							// 若转账成功
//							if (FyUtil.SUCCESS.equals(transBuResp.getResponse().getResp_code())) {
//								// 划拨成功修改 对账表信息
//								siteBillingServ.updateBusiStatus(0, transBuResp.getResponse().getMchnt_txn_ssn());
//								// 更新借款人用户账户表
//								updateUserAccount(lender);
//								// 更新担保机构用户账户表
//								updateUserAccount(guarantee);
//								// 还款
//								if (repayment(applyRepay, siteFeeTypeVo, loanApply,
//										(List<ApplyRecoverVO>) map.get("applyRecoverList"), gJzhloginid)) {
//									model.addAttribute("msg", "还款成功！");
//								} else {
//									model.addAttribute("msg", "还款失败！");
//								}
//								if (guaranteeRepay.compareTo(new BigDecimal(0)) > 0) {
//									// 查询担保机构账户信息
//									UserAccountVO userAccount = userAccountServ.selectByUserId(guarantee.getUserId());// 查询本地账户信息
//									// 生成担保机构垫付记录
//									UserAccountLogVO userAccountLog = new UserAccountLogVO();
//									userAccountLog.setUserId(guarantee.getUserId());
//									userAccountLog.setType(4401);
//									userAccountLog.setMoney(guaranteeRepay);
//									userAccountLog.setTotal(userAccount.getTotal());
//									userAccountLog.setFrost(userAccount.getFrost());
//									userAccountLog.setCash(userAccount.getCash());
//									userAccountLog.setAddTime(DateUtil.getUnixTime());
//									userAccountLog.setApplyId(applyId);
//									// userAccountLog.setFrom(lenderId);
//									userAccountLog.setTo(guaranteeId + "");
//									userAccountLog.setMemo("正常垫付");
//									userAccountLogServ.insertSelective(userAccountLog);
//								}
//							} else {
//								// 划拨失败修改 对账表信息
//								siteBillingServ.updateBusiStatus(1, transBuResp.getResponse().getMchnt_txn_ssn());
//								log.info("借款人转账给担保机构操作失败！流水号：" + transBuResp.getMchnt_txn_ssn());
//								model.addAttribute("msg", "借款人转账给担保机构操作失败！流水号：" + transBuResp.getMchnt_txn_ssn());
//							}
//						} else {
//							log.info("垫付时借款人转账给担保机构,转账接口请求失败！");
//							model.addAttribute("msg", "垫付时借款人转账给担保机构,转账接口请求失败！");
//						}
//						return "redirect:/repay/advanceRepay";
//					}
//					// 担保机构和平台垫付还款
//					if (lenderRepay.compareTo(new BigDecimal(0)) > 0 && guaranteeRepay.compareTo(new BigDecimal(0)) > 0
//							&& platformRepay.compareTo(new BigDecimal(0)) > 0) {
//						// 借款人账户转账至担保机构金额
//						int transferAmt = lenderRepay.setScale(2, BigDecimal.ROUND_HALF_UP)
//								.multiply(new BigDecimal(100)).intValue();
//						// 借款人转账至担保机构账户
//						TransBuBean transReqData = new TransBuBean();
//						// 付款登录账户
//						transReqData.setOut_cust_no(lJzhloginid);
//						// 收款登录账户
//						transReqData.setIn_cust_no(gJzhloginid);
//						// 转账金额
//						transReqData.setAmt(String.valueOf(transferAmt));
//						// 进行转账操作
//						TransBuResp transBuResp = null;
//						try {
//							transBuResp = CapitalMgt.transferBu(transReqData, lender, guarantee, "借款人到担保机构",loanApply.getOrderNumber() );
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//						if (transBuResp != null) {
//							// 若转账成功
//							if (FyUtil.SUCCESS.equals(transBuResp.getResponse().getResp_code())) {
//								// 划拨成功修改 对账表信息
//								siteBillingServ.updateBusiStatus(0, transBuResp.getResponse().getMchnt_txn_ssn());
//								// 更新借款人用户账户表
//								updateUserAccount(lender);
//								// 更新担保机构用户账户表
//								updateUserAccount(guarantee);
//							} else {
//								// 划拨失败修改 对账表信息
//								siteBillingServ.updateBusiStatus(1, transBuResp.getResponse().getMchnt_txn_ssn());
//								isTransLenderRepay = false;
//								log.info("借款人转账给担保机构操作失败！流水号：" + transBuResp.getMchnt_txn_ssn());
//								model.addAttribute("msg", "借款人转账给担保机构操作失败！流水号：" + transBuResp.getMchnt_txn_ssn());
//							}
//						} else {
//							isTransLenderRepay = false;
//							log.info("垫付时借款人转账给担保机构,转账接口请求失败！");
//							model.addAttribute("msg", "垫付时借款人转账给担保机构,转账接口请求失败！");
//						}
//
//						// 平台账户转账至担保机构金额
//						int transferAmt2 = platformRepay.setScale(2, BigDecimal.ROUND_HALF_UP)
//								.multiply(new BigDecimal(100)).intValue();
//						// 平台账户转账至担保机构
//						TransBmuBean transBmuBean = new TransBmuBean();
//						// 付款登录账户
//						transBmuBean.setOut_cust_no(FyUtil.MCHNT_USER_ID);
//						// 收款登录账户
//						transBmuBean.setIn_cust_no(gJzhloginid);
//						// 转账金额
//						transBmuBean.setAmt(String.valueOf(transferAmt2));
//						// 进行转账操作
//						TransBmuResp transBmuResp = null;
//						try {
//							transBmuResp = CapitalMgt.transferBmu(transBmuBean, null, guarantee, "平台到担保机构", loanApply.getOrderNumber());
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//						if (transBmuResp != null) {
//							// 若转账成功
//							if (FyUtil.SUCCESS.equals(transBmuResp.getResponse().getResp_code())) {
//								// 更新担保机构用户账户表
//								updateUserAccount(guarantee);
//							} else {
//								isTransPlatformRepay = false;
//								log.info("平台转账给担保机构操作失败！流水号：" + transBuResp.getMchnt_txn_ssn());
//								model.addAttribute("msg", "平台转账给担保机构操作失败！流水号：" + transBuResp.getMchnt_txn_ssn());
//							}
//						} else {
//							isTransPlatformRepay = false;
//							log.info("垫付时平台转账给担保机构,转账接口请求失败！");
//							model.addAttribute("msg", "垫付时平台转账给担保机构,转账接口请求失败！");
//						}
//
//						if (isTransLenderRepay && isTransPlatformRepay) {
//							// 还款
//							if (repayment(applyRepay, siteFeeTypeVo, loanApply,
//									(List<ApplyRecoverVO>) map.get("applyRecoverList"), gJzhloginid)) {
//								model.addAttribute("msg", "还款成功！");
//							} else {
//								model.addAttribute("msg", "还款失败！");
//							}
//							if (guaranteeRepay.compareTo(new BigDecimal(0)) > 0) {
//								// 查询担保机构账户信息
//								UserAccountVO userAccount = userAccountServ.selectByUserId(guarantee.getUserId());// 查询本地账户信息
//								// 生成担保机构垫付记录
//								UserAccountLogVO userAccountLog = new UserAccountLogVO();
//								userAccountLog.setUserId(guarantee.getUserId());
//								userAccountLog.setType(4401);
//								userAccountLog.setMoney(guaranteeRepay);
//								userAccountLog.setTotal(userAccount.getTotal());
//								userAccountLog.setFrost(userAccount.getFrost());
//								userAccountLog.setCash(userAccount.getCash());
//								userAccountLog.setAddTime(DateUtil.getUnixTime());
//								userAccountLog.setApplyId(applyId);
//								// userAccountLog.setFrom(lenderId);
//								userAccountLog.setTo(guaranteeId + "");
//								userAccountLog.setMemo("正常垫付");
//								userAccountLogServ.insertSelective(userAccountLog);
//							}
//							if (platformRepay.compareTo(new BigDecimal(0)) > 0) {
//								// 平台垫付
//								// 生成担保机构垫付记录
//								UserAccountLogVO userAccountLog = new UserAccountLogVO();
//								userAccountLog.setUserId(0);
//								userAccountLog.setType(4401);
//								userAccountLog.setMoney(platformRepay);
//								userAccountLog.setAddTime(DateUtil.getUnixTime());
//								userAccountLog.setApplyId(applyId);
//								// userAccountLog.setFrom(lenderId);
//								userAccountLog.setTo(guaranteeId + "");
//								userAccountLog.setMemo("正常垫付");
//								userAccountLogServ.insertSelective(userAccountLog);
//							}
//						}
//						return "redirect:/repay/advanceRepay";
//					}
				} else {
					model.addAttribute("msg", "未配置投资服务费或配置的不是比例!");
				}
			}
		} else {
			model.addAttribute("msg", "缺少参数!");
		}
		return "redirect:/repay/advanceRepay";
	}

	/**
	 * 获取还款详情
	 * 
	 * @param aid
	 * @param per
	 * @return
	 */
	private Map<String, Object> getRepayDetail(int id, int per) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 根据标的id查询还款记录
		ApplyRepayPOJO applyRepay = repayServ.findRepayById(id);
		int applyId = applyRepay.getApplyId();
		// 获取还款金额
		BigDecimal totalApplyRepay = applyRepay.getRepayMoney();
		// 根据标的id和还款期数查询回款记录
		List<ApplyRecoverVO> applyRecoverList = repayServ.findRepayByApplyidAndRecoverperiod(applyId, per);
		// 计算当期回款总额
		BigDecimal totalApplyRecover = new BigDecimal(0);
		for (ApplyRecoverVO applyRecover : applyRecoverList) {
			totalApplyRecover = totalApplyRecover.add(applyRecover.getRecoverMoney());
		}
		// 当期的，回款计划表金额Repay与还款计划表Recover金额是否相等
		if (!((totalApplyRepay.setScale(2, BigDecimal.ROUND_HALF_UP))
				.equals(totalApplyRecover.setScale(2, BigDecimal.ROUND_HALF_UP)))) {
			// 补齐相差的金额
			BigDecimal recoverMoney = applyRecoverList.get(applyRecoverList.size() - 1).getRecoverMoney();
			BigDecimal differ = totalApplyRepay.subtract(totalApplyRecover);
			applyRecoverList.get(applyRecoverList.size() - 1).setRecoverMoney(recoverMoney.add(differ));
		}
		// 获取借款详情
		LoanPOJO loan = loanApplyServ.findInvestmentById(applyRepay.getApplyId());
		// 获取借款人可用余额
		BigDecimal lenderRemain = userAccountServ.selectByUserId(applyRepay.getUserId()).getCash();
		// 获取担保机构可用余额
		BigDecimal guaranteeCompanyRemain = userAccountServ
				.selectByUserId(Integer.parseInt(loan.getGuaranteeCompanyId())).getCash();
		// 获取平台可用余额
		QueryBalanceBean reqData = new QueryBalanceBean();
		reqData.setCust_no(FyUtil.MCHNT_USER_ID);
		QueryBalanceResp resp = capitalMgtServ.queryBalance(reqData);
		BigDecimal platformRemain = null;
		if (resp != null) {
			String respCode = resp.getResponse().getResp_code();
			if (respCode.equals(FyUtil.SUCCESS)) {
				resp = resp.getResponse().getRespList().get(0);
				platformRemain = new BigDecimal(resp.getCa_balance()).divide(new BigDecimal(100), 4,
						BigDecimal.ROUND_HALF_UP);
			} else {
				map.put("msg", "查询平台可用余额失败！");
			}
		} else {
			map.put("msg", "调用余额查询接口失败！");
		}

		// 借款人扣款金额
		BigDecimal lenderRepay = null;
		// 担保机构扣款金额
		BigDecimal guaranteeRepay = null;
		// 平台扣款金额
		BigDecimal platformRepay = null;

		// 根据标的id查询出该标的的信息
		LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(applyId);

		BigDecimal minMoney = loanInvestmentServ.findMinInvestByApplyId(applyId);
		// 计算出最小还款金额
		BigDecimal minRepay = lenderRemain.multiply(minMoney).divide(loanApply.getAmount(), 4,
				BigDecimal.ROUND_HALF_UP);

		if (lenderRemain.compareTo(new BigDecimal(0)) >= 0 && lenderRemain.compareTo(minRepay) < 0) {
			// 还款人余额介于0-最低还款额之间
			if (guaranteeCompanyRemain.compareTo(new BigDecimal(0)) >= 0
					&& guaranteeCompanyRemain.compareTo(minRepay) < 0) {
				// 担保机构余额介于0-最低还款额之间
				// 平台全额还款
				if (platformRemain.compareTo(totalApplyRepay) < 0 || platformRemain.compareTo(minRepay) < 0) {
					// 平台余额小于应还金额或者小于0
					// 逾期
					map.put("flag", "0");
				} else {
					lenderRepay = new BigDecimal(0);
					guaranteeRepay = new BigDecimal(0);
					platformRepay = totalApplyRepay;
				}
			} else if (guaranteeCompanyRemain.compareTo(minRepay) >= 0
					&& guaranteeCompanyRemain.compareTo(totalApplyRepay) < 0) {
				// 担保机构余额介于最低还款额与应还金额之间
				// 平台部分还款
				if (platformRemain.compareTo(totalApplyRepay.subtract(guaranteeCompanyRemain)) < 0
						|| platformRemain.compareTo(minRepay) < 0) {
					// 平台余额小于剩余还款金额或者小于0
					// 逾期
					map.put("flag", "0");
				} else {
					lenderRepay = new BigDecimal(0);
					guaranteeRepay = guaranteeCompanyRemain;
					platformRepay = totalApplyRepay.subtract(guaranteeCompanyRemain);
				}
			} else {
				// 担保机构余额大于应还金额
				lenderRepay = new BigDecimal(0);
				guaranteeRepay = totalApplyRepay;
				platformRepay = new BigDecimal(0);
			}
		} else if (lenderRemain.compareTo(minRepay) >= 0 && lenderRemain.compareTo(totalApplyRepay) < 0) {
			// 还款人余额介于最低还款额与应还金额之间
			if (guaranteeCompanyRemain.compareTo(new BigDecimal(0)) >= 0
					&& guaranteeCompanyRemain.compareTo(minRepay) < 0) {
				// 担保机构余额介于0-最低还款额之间
				// 平台部分还款
				if (platformRemain.compareTo(totalApplyRepay.subtract(lenderRemain)) < 0
						|| platformRemain.compareTo(minRepay) < 0) {
					// 平台余额小于应还金额或者小于0
					// 逾期
					map.put("flag", "0");
				} else {
					lenderRepay = lenderRemain;
					guaranteeRepay = new BigDecimal(0);
					platformRepay = totalApplyRepay.subtract(lenderRemain);
				}
			} else if (guaranteeCompanyRemain.compareTo(minRepay) >= 0
					&& guaranteeCompanyRemain.compareTo(totalApplyRepay.subtract(lenderRemain)) < 0) {
				// 担保机构余额介于最低还款额与剩余应还金额之间
				// 平台部分还款
				if (platformRemain
						.compareTo(totalApplyRepay.subtract(lenderRemain).subtract(guaranteeCompanyRemain)) < 0
						|| platformRemain.compareTo(minRepay) < 0) {
					// 平台余额小于剩余还款金额或者小于0
					// 逾期
					map.put("flag", "0");
				} else {
					lenderRepay = lenderRemain;
					guaranteeRepay = guaranteeCompanyRemain;
					platformRepay = totalApplyRepay.subtract(lenderRemain).subtract(guaranteeCompanyRemain);
				}
			} else {
				// 担保机构余额大于应还金额
				lenderRepay = lenderRemain;
				guaranteeRepay = totalApplyRepay.subtract(lenderRemain);
				platformRepay = new BigDecimal(0);
			}
		} else {
			// 正常还款
			lenderRepay = totalApplyRepay;
			guaranteeRepay = new BigDecimal(0);
			platformRepay = new BigDecimal(0);
		}
		map.put("lenderRemain", lenderRemain);
		map.put("guaranteeCompanyRemain", guaranteeCompanyRemain);
		map.put("platformRemain", platformRemain);
		map.put("lenderRepay", lenderRepay);
		map.put("guaranteeRepay", guaranteeRepay);
		map.put("platformRepay", platformRepay);
		map.put("loan", loan);
		map.put("applyRepay", applyRepay);
		map.put("applyRecoverList", applyRecoverList);
		map.put("guaranteeCompanyId", loan.getGuaranteeCompanyId());
		return map;
	}

	/**
	 * 还款
	 * 
	 * @param applyRepay
	 *            该条还款记录
	 * @param money
	 *            总计还款金额
	 * @param applyRecoverList
	 *            回款计划list集合
	 * @param loanApply
	 *            还款标的
	 * @param period
	 *            还款期数
	 * @param outCustNo
	 *            付款方账户
	 */
	private boolean repayment(ApplyRepayVO applyRepay, SiteFeeTypePOJO siteFeeTypeVo, LoanApplyVO loanApply,
			List<ApplyRecoverVO> applyRecoverList, String outCustNo) {
		// 还款结果标识
		boolean flag = true;
		int applyId = applyRepay.getApplyId();
		// 进行还款操作
		// 当前时间
		int currentTime = DateUtil.getUnixTime();
		// 根据标的id查询出该标的的信息
		// LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(applyId);
		// 从标的信息中取出借款人id
		int lenderId = loanApply.getUserId();
		UserVO lender = userServ.getUserByUserId(lenderId);

		// 查询该标的投资收益服务费
		BigDecimal feeRate = new BigDecimal(0);
		// 总收益
		BigDecimal totalInterest = new BigDecimal(0);
		// 付给平台的利息(分)
		BigDecimal totalInterestForPlat = new BigDecimal(0);
		// 是否当前全部还完
		boolean isAllRepay = true;
		// 获取费率
		if (siteFeeTypeVo != null && siteFeeTypeVo.getFormulaType() == 1) {
			feeRate = siteFeeTypeVo.getInterestRate().divide(new BigDecimal(100), 4, BigDecimal.ROUND_HALF_UP);
		}
		// feeRate = new BigDecimal(loanApply.getInvestServiceFee()).divide(new
		// BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
		for (ApplyRecoverVO applyRecover : applyRecoverList) {
			totalInterest = totalInterest.add(applyRecover.getRecoverInterest());
		}
		// 需转给平台的钱
		totalInterestForPlat = totalInterest.multiply(feeRate);
		for (ApplyRecoverVO applyRecover : applyRecoverList) {
			if (applyRecover.getStatus() == 0) {
				// 从每笔回款信息中取出投资人用户id
				int investmentUserId = applyRecover.getUserId();
				// 根据用户id查询投资人用户信息
				UserVO user = userServ.getUserByUserId(investmentUserId);
				// 从投资人用户信息中取出投资人金账户
				String jzhloginid = user.getJzhloginid();

				// 回款计划中取出利息
				BigDecimal recoverInterest = applyRecover.getRecoverInterest();
				// 该笔支付给平台的费用
				BigDecimal interestForPlat = recoverInterest.multiply(feeRate);
				// 除去转给平台后剩余收款金额(元)
				BigDecimal remainMoney = applyRecover.getRecoverMoney().subtract(interestForPlat);
				// 转账金额,已分为单位(首先取小数点后面两位，然后再乘100，再转为整型)
				int transferAmt = (remainMoney.setScale(2, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100))
						.intValue();
				TransBuBean reqData = new TransBuBean();
				// 付款登录账户
				reqData.setOut_cust_no(outCustNo);
				// 收款登录账户
				reqData.setIn_cust_no(jzhloginid);
				// 转账金额
				reqData.setAmt(String.valueOf(transferAmt));
				// 进行转账操作
				TransBuResp transBuResp = null;
				if(transferAmt>0){
					try {
						transBuResp = CapitalMgt.transferBu(reqData, lender, user, "还款", loanApply.getOrderNumber());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (transBuResp != null) {
					// 若转账成功
					if (FyUtil.SUCCESS.equals(transBuResp.getResponse().getResp_code())) {
						// 还款划拨成功修改 对账表信息
						siteBillingServ.updateBusiStatus(0, transBuResp.getResponse().getMchnt_txn_ssn());
						log.info("还款转账给投资人成功");
						// 将status设置为1，表示已还
						applyRecover.setValueDate(applyRepay.getValueDate());
						applyRecover.setMaturityDate(applyRepay.getRepayReqTime());
						applyRecover.setBatchSerialno(reqData.getMchnt_txn_ssn());
						applyRecover.setStatus((byte) 1);
						applyRecover.setRecoverDoneTime(currentTime);
						//更新实还金额
						applyRecover.setRepayDoneCapital(applyRecover.getRecoverCapital());
						applyRecover.setRepayDoneInterest(applyRecover.getRecoverInterest());

						// 调用更新
						int result = repayServ.updateByPrimaryKeySelective(applyRecover);
						if (result > 0) {
							log.info("更改回款计划表中的该期还款状态为已还");
						}

						// 站内信 发送给投资人 收到的回款金额
						commonServ.sendall(user.getMobile(), SmsTypeUtil.P2P_RECOVERMONEY_SUC, loanApply.getName(),
								applyRecover.getRecoverMoney().toString(), applyRecover.getRecoverCapital().toString(),
								applyRecover.getRecoverInterest().toString());
						// 更新投资人人用户账户表
						updateUserAccount(user);

						// 记录回款成功
						UserAccountVO userAccount = userAccountServ.selectByUserId(user.getUserId());// 查询本地账户信息
						// 回款成功记录
						UserAccountLogVO userAccountLog = new UserAccountLogVO();
						userAccountLog.setUserId(user.getUserId());
						userAccountLog.setType(4203);
						userAccountLog.setMoney(applyRecover.getRecoverMoney());
						userAccountLog.setTotal(userAccount.getTotal().add(interestForPlat));
						userAccountLog.setFrost(userAccount.getFrost());
						userAccountLog.setCash(userAccount.getCash().add(interestForPlat));
						userAccountLog.setAddTime(DateUtil.getUnixTime());
						userAccountLog.setApplyId(applyId);
						userAccountLog.setFrom(lenderId);
						// userAccountLog.setTo(FyUtil.MCHNT_USER_ID);
						userAccountLog.setMemo(loanApply.getName());
						// 生成回款成功编号
						String oldMaxBusiNumber = userAccountLogServ
								.findMaxBusiNumber("THK" + DateUtil.getCurrentDate("yyyyMMdd"));
						log.info("oldMaxBusiNumber==" + oldMaxBusiNumber);
						String busiNumber = UserAccountUtil.getBusiNumber(oldMaxBusiNumber, "THK");
						log.info("busiNumber==" + busiNumber);
						userAccountLog.setBusiNumber(busiNumber);
						userAccountLogServ.insertSelective(userAccountLog);

						// 记录
						UserAccountVO userAccount2 = userAccountServ.selectByUserId(user.getUserId());// 查询本地账户信息
						// 投资服务费记录
						UserAccountLogVO userAccountLog2 = new UserAccountLogVO();
						userAccountLog2.setUserId(user.getUserId());
						userAccountLog2.setType(4204);	
						userAccountLog2.setMoney(interestForPlat.setScale(2, BigDecimal.ROUND_HALF_UP));
						userAccountLog2.setTotal(userAccount2.getTotal());
						userAccountLog2.setFrost(userAccount2.getFrost());
						userAccountLog2.setCash(userAccount2.getCash());
						userAccountLog2.setAddTime(DateUtil.getUnixTime());
						userAccountLog2.setApplyId(applyId);
						// userAccountLog.setFrom(lenderId);
						userAccountLog2.setTo(FyUtil.MCHNT_USER_ID);
						userAccountLog2.setMemo(loanApply.getName());
						// 生成投资服务费编号
						oldMaxBusiNumber = userAccountLogServ
								.findMaxBusiNumber("TCF" + DateUtil.getCurrentDate("yyyyMMdd"));
						log.info("oldMaxBusiNumber==" + oldMaxBusiNumber);
						busiNumber = UserAccountUtil.getBusiNumber(oldMaxBusiNumber, "TCF");
						log.info("busiNumber==" + busiNumber);
						userAccountLog.setBusiNumber(busiNumber);
						userAccountLogServ.insertSelective(userAccountLog2);

						// 平台收益记录
						SiteAccountLogVO siteAccountLog = new SiteAccountLogVO();
						siteAccountLog.setFeeId(siteFeeTypeVo.getChargeFeeId());
						siteAccountLog.setUserId(investmentUserId);
						siteAccountLog.setMoney(interestForPlat);
						siteAccountLog.setCreated(DateUtil.getUnixTime());
						siteAccountLogServ.addSiteAccountLog(siteAccountLog);

						// 总收益更新
						SiteAccountVO siteAccount = siteAccountServ.findSiteAccountByFeeName("投资服务费");
						siteAccount.setIncome(siteAccount.getIncome().add(interestForPlat));
						siteAccountServ.updateSiteAccount(siteAccount);
					} else {
						// 还款划拨失败修改 对账表信息
						siteBillingServ.updateBusiStatus(1, transBuResp.getResponse().getMchnt_txn_ssn());
						isAllRepay = false;
						flag = false;
						log.info("借款人转账至投资人操作失败！流水号：" + reqData.getMchnt_txn_ssn());
						continue;
					}
				} else {
					isAllRepay = false;
					flag = false;
					log.info("转账接口请求失败，请联系技术进行核实！");
					continue;
				}
			}
		}
		if (isAllRepay) {
			// 将累加的手续费划给平台
			TransBmuBean transBReqData = new TransBmuBean();
			// 付款登录账户
			transBReqData.setOut_cust_no(outCustNo);
			// 平台账户
			transBReqData.setIn_cust_no(FyUtil.MCHNT_USER_ID);
			// 转账金额(即服务费)
			transBReqData.setAmt(String.valueOf(totalInterestForPlat.multiply(new BigDecimal(100)).intValue()));
			// 进行转账操作,调用转账接口
			TransBmuResp transBmuResp = null;
			try {
				transBmuResp = CapitalMgt.transferBmu(transBReqData, lender, null, "投资服务费", loanApply.getOrderNumber());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (transBmuResp != null) {
				// 若转账成功
				if (FyUtil.SUCCESS.equals(transBmuResp.getResponse().getResp_code())) {
					// 转账成功修改 对账表信息
					siteBillingServ.updateBusiStatus(0, transBmuResp.getResponse().getMchnt_txn_ssn());
					log.info("借款人转给平台投资服务费成功");
					// 更新借款人用户账户表
					updateUserAccount(lender);

					// 记录借款人还款记录
					UserAccountVO userAccount = userAccountServ.selectByUserId(lender.getUserId());// 查询本地账户信息
					// 还款成功记录
					UserAccountLogVO userAccountLog = new UserAccountLogVO();
					userAccountLog.setUserId(lender.getUserId());
					userAccountLog.setType(4303);
					userAccountLog.setMoney(applyRepay.getRepayMoney());
					userAccountLog.setTotal(userAccount.getTotal());
					userAccountLog.setFrost(userAccount.getFrost());
					userAccountLog.setCash(userAccount.getCash());
					userAccountLog.setAddTime(DateUtil.getUnixTime());
					userAccountLog.setApplyId(applyId);
					// userAccountLog.setFrom(lenderId);
					// userAccountLog.setTo(FyUtil.MCHNT_USER_ID);
					userAccountLog.setMemo(loanApply.getName());
					// 生成还款成功编号
					String oldMaxBusiNumber = userAccountLogServ
							.findMaxBusiNumber("RHK" + DateUtil.getCurrentDate("yyyyMMdd"));
					log.info("oldMaxBusiNumber==" + oldMaxBusiNumber);
					String busiNumber = UserAccountUtil.getBusiNumber(oldMaxBusiNumber, "RHK");
					log.info("busiNumber==" + busiNumber);
					userAccountLog.setBusiNumber(busiNumber);
					userAccountLogServ.insertSelective(userAccountLog);

					// // 站内信 发送给借款人 还款成功
					// commonServ.sendall(lender.getMobile(),
					// SmsTypeUtil.P2P_REPAY_SUC,
					// DateUtil.getCurrentDate("yyyy-MM-dd"),
					// loanApply.getName(),
					// applyRepay.getRepayMoney().toString());

					// 将还款计划表中的状态改为已还款
					applyRepay.setStatus((byte) 1);
					applyRepay.setRepayDoneCapital(applyRepay.getRepayCapital());
					applyRepay.setRepayDoneInterest(applyRepay.getRepayInterest());
					applyRepay.setRepayDoneTime(currentTime);
					// 调用更新
					int result = repayServ.updateByPrimaryKeySelective(applyRepay);
					if (result > 0) {
						log.info("更改回款计划表中状态为还款成功，applyRepayId:" + applyRepay.getId());
					}
					// 站内信 发送给投资人 收到的回款金额
					commonServ.sendall(lender.getMobile(), SmsTypeUtil.P2P_REPAY_SUC, loanApply.getName(),
							applyRepay.getRepayMoney().toString(), applyRepay.getRepayCapital().toString(),
							applyRepay.getRepayInterest().toString());
					
				} else {
					// 转账失败修改 对账表信息
					siteBillingServ.updateBusiStatus(1, transBmuResp.getResponse().getMchnt_txn_ssn());
					flag = false;
					// 将还款计划表中的状态改为投资服务费未收取
					applyRepay.setStatus((byte) 2);
					// 调用更新
					int result = repayServ.updateByPrimaryKeySelective(applyRepay);
					if (result > 0) {
						log.info("更改回款计划表中的状态投资服务费未收取成功，applyRepayId:" + applyRepay.getId());
					}
				}
			} else {
				flag = false;
				log.info("转账接口请求失败！");
			}
			// 判断还需还款金额，若为0表示还款完毕，更新fu_loan_apply,status=10
			if (applyRepay.getRepayRemain().compareTo(new BigDecimal(0)) == 0) {
				int result = loanApplyServ.updateLoanApplyStatusByApplyId(loanApply.getId(), (byte) 10);
				if (result > 0) {
					log.info("更改标的" + loanApply.getId() + "状态为已还清");
				}
			}
		}
		return flag;
	}
}
