package com.fujfu.service.repay.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fujfu.common.payment.fuyou.CapitalMgt;
import com.fujfu.common.payment.fuyou.pojo.TransBmuBean;
import com.fujfu.common.payment.fuyou.pojo.TransBuBean;
import com.fujfu.common.payment.fuyou.pojo.response.TransBmuResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBuResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.SmsTypeUtil;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.account.SiteAccountLogMapper;
import com.fujfu.dao.account.SiteAccountMapper;
import com.fujfu.dao.account.UserAccountLogMapper;
import com.fujfu.dao.account.UserAccountMapper;
import com.fujfu.dao.apply.ApplyRecoverMapper;
import com.fujfu.dao.apply.ApplyRepayMapper;
import com.fujfu.dao.fee.SiteFeeTypeMapper;
import com.fujfu.dao.invest.LoanInvestmentMapper;
import com.fujfu.dao.loan.LoanApplyMapper;
import com.fujfu.dao.user.UserMapper;
import com.fujfu.pojo.account.SiteAccountLogVO;
import com.fujfu.pojo.account.SiteAccountVO;
import com.fujfu.pojo.account.UserAccountLogVO;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.apply.ApplyRecoverVO;
import com.fujfu.pojo.apply.ApplyRecoverPOJO;
import com.fujfu.pojo.apply.ApplyRepayVO;
import com.fujfu.pojo.apply.ApplyRepayPlanPOJO;
import com.fujfu.pojo.apply.ApplyRepayPOJO;
import com.fujfu.pojo.apply.PrepaymentDTO;
import com.fujfu.pojo.apply.UserRepaySumPOJO;
import com.fujfu.pojo.fee.SiteFeeTypePOJO;
import com.fujfu.pojo.invest.LoanInvestmentVO;
import com.fujfu.pojo.loan.LoanApplyVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.SiteBillingServ;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.common.CommonServ;
import com.fujfu.service.lender.impl.LenderServImpl;
import com.fujfu.service.repay.RepayServ;
@Service("repaySer")
public class RepayServImpl implements RepayServ {
	@Resource
	public UserAccountServ userAccountServ;
	@Resource
	public ApplyRecoverMapper applyRecoverMapper;
	@Resource
	public ApplyRepayMapper applyRepayMapper;
	@Resource
	public UserAccountMapper userAccountMapper;
	@Resource
	public UserAccountLogMapper userAccountLogMapper;
	@Resource
	public UserMapper userBeanMapper;
	@Resource
	public LoanApplyMapper loanApplyMapper;
	@Resource
	public SiteFeeTypeMapper siteFeeTypeMapper;
	@Resource
	public LoanInvestmentMapper loanInvestMapper;
	@Resource
	private SiteAccountLogMapper siteAccountLogMapper;
	@Resource
	private SiteAccountMapper siteAccountMapper;
	@Resource
	private SiteBillingServ siteBillingServ;
	@Resource
	private CommonServ commonServ;
	private static Logger log = Logger.getLogger(LenderServImpl.class);

	@Override
	public Page findApplyRepayByCondition(ApplyRepayPOJO applyRepay, Page page) {
		page.setTotalCount(applyRepayMapper.countApplyRepay(applyRepay, page));
		page.setItems(applyRepayMapper.findApplyRepay(applyRepay, page));
		return page;
	}
	
	@Override
	public Page findAllApplyRepayListByCondition(LoanInvestPOJO loanInvestQueryVo,Page page) {
		page.setTotalCount(applyRepayMapper.countApplyRepayList(loanInvestQueryVo, page));
		page.setItems(applyRepayMapper.findAllApplyRepayList(loanInvestQueryVo, page));
		return page;
	}

	@Override
	public Page findAllApplyRecoverListByCondition(LoanInvestPOJO loanInvestQueryVo, Page page) {
		page.setTotalCount(applyRecoverMapper.countApplyRecover(loanInvestQueryVo, page));
		page.setItems(applyRecoverMapper.findAllRecoverByRecoverperiod(loanInvestQueryVo, page));		
		return page;
	}

	@Override
	public ApplyRepayVO findRepayByApplyidAndRepayperiod(int applyId, int repayPeriod) {
		return applyRepayMapper.findRepayByApplyidAndRepayperiod(applyId, repayPeriod);
	}

	@Override
	public BigDecimal findRateByApplyidAndFeename(int applyId, String feeBase, String feeName) {
		return applyRepayMapper.findRateByApplyidAndFeename(applyId, feeBase, feeName);
	}

	@Override
	public List<ApplyRecoverVO> findRepayByApplyidAndRecoverperiod(int applyId, int recoverPeriod) {
		return applyRecoverMapper.findRepayByApplyidAndRecoverperiod(applyId, recoverPeriod);
	}

	@Override
	public int updateByPrimaryKeySelective(ApplyRecoverVO record) {
		return applyRecoverMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(ApplyRepayVO record) {
		return applyRepayMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<ApplyRecoverPOJO> findRepayByApplyId(String applyId, int pageNum) {
		return applyRecoverMapper.findRepayByApplyId(applyId,8*(pageNum-1));
	}

	@Override
	public int countRepayByApplyId(String applyId) {
		return applyRecoverMapper.countRepayByApplyId(applyId);
	}

	@Override
	public int countUserApplyRepayTradeDetai(LoanInvestPOJO loanInvestQueryVo, Integer userId) {
		// TODO Auto-generated method stub
		return applyRepayMapper.countUserApplyRepayTradeDetai(loanInvestQueryVo, userId);
	}
	@Override
	public UserRepaySumPOJO findUserRepaySumMap(String status, Integer userId,Integer applyId) {
		// TODO Auto-generated method stub
		return applyRepayMapper.findUserRepaySumMap(status, userId,applyId);
	}
	@Override
	public ApplyRepayPOJO findRepayById(int id) {
		return applyRepayMapper.findRepayById(id);
	}

	@Override
	public List<ApplyRecoverPOJO> findAllRepayByApplyId(String applyId) {
		return applyRecoverMapper.findAllRepayByApplyId(applyId);
	}

	@Override
	public List<ApplyRepayPlanPOJO> findApplyRepayPlanByApplyId(String applyId, int pageNum) {
		return applyRepayMapper.findApplyRepayPlanByApplyId(applyId,8*(pageNum-1));
	}

	@Override
	public List<ApplyRepayPlanPOJO> findAllApplyRepayPlanByApplyId(String applyId) {
		return applyRepayMapper.findAllApplyRepayPlanByApplyId(applyId);
	}

	@Override
	public int countApplyRepayPlanByApplyId(String applyId) {
		return applyRepayMapper.countApplyRepayPlanByApplyId(applyId);
	}

	@Override
	public Page findRepaymentReminder(Page page) {
		page.setTotalCount(applyRepayMapper.countRepaymentReminder());
		page.setItems(applyRepayMapper.findRepaymentReminder(page));
		return page;
	}

	@Override
	public PrepaymentDTO getPrepaymentDetail(LoanApplyVO loanApply) {
		PrepaymentDTO prepayment = new PrepaymentDTO();
		ApplyRepayVO applyRepay = applyRepayMapper.findApplyRepayByApplyId(loanApply.getId());
		//剩余本金，目前支持的还款剩余本金即为借款金额
		BigDecimal repayMoney = loanApply.getAmount();
		BigDecimal apr = (new BigDecimal(loanApply.getApr()).setScale(2,BigDecimal.ROUND_HALF_UP))
				.divide(new BigDecimal(36500),10, BigDecimal.ROUND_HALF_UP);
		int days = DateUtil.getTimeDifference(applyRepay.getValueDate(), DateUtil.getUnixTime());
		if(days<0){
			days=0;
		}
		//当期预期收益(当期预期收益=剩余未还本金×预期年化收益÷365天×当期实际天数（计头不计尾）)
		BigDecimal profit = repayMoney.multiply(apr).multiply(new BigDecimal(days)).setScale(2,BigDecimal.ROUND_HALF_UP);
		SiteFeeTypePOJO siteFeeTypeVo = siteFeeTypeMapper.queryChageMode(null, "提前还款服务费", "2");
		if(siteFeeTypeVo.getInterestRate()!=null){
			//提前还款服务费
			BigDecimal pSerFee = repayMoney.multiply(siteFeeTypeVo.
					getInterestRate().divide(new BigDecimal(100), 4, BigDecimal.ROUND_HALF_UP)).setScale(2,BigDecimal.ROUND_HALF_UP);
			BigDecimal totalRepay = repayMoney.add(profit).add(pSerFee).setScale(2,BigDecimal.ROUND_HALF_UP);
			prepayment.setRepayMoney(repayMoney);
			prepayment.setProfit(profit);
			prepayment.setpSerFee(pSerFee);
			prepayment.setFinanceSerfee(new BigDecimal(0));
			prepayment.setTotalRepay(totalRepay);
		}
		return prepayment;
	}

	@Override
	public boolean prepayment(LoanApplyVO loanApply, PrepaymentDTO prepayment) throws Exception {
		log.info("1:"+prepayment.getProfit());
		// 还款结果标识
		boolean flag = true;
		int applyId = loanApply.getId(); 
		// 借款人用户信息
		UserVO lender = userBeanMapper.getUserByUserId(loanApply.getUserId());
		int lenderId = lender.getUserId();
		// 根据标的id查询最新一期未还的还款计划
		ApplyRepayVO applyRepay = applyRepayMapper.findApplyRepayByApplyId(applyId);
		List<LoanInvestmentVO> investList = loanInvestMapper.findInvestByApplyIdSum(applyId);
		// 计算出投资人投资占比,投资本金
		Map<Integer,List<BigDecimal>> proportMap = new HashMap<Integer,List<BigDecimal>>();
		for(LoanInvestmentVO loanInvest : investList){
			List<BigDecimal> list = new ArrayList<BigDecimal>();
			list.add(loanInvest.getMoney());
			list.add(loanInvest.getMoney().divide(loanApply.getAmount(), 4, BigDecimal.ROUND_HALF_UP));
			proportMap.put(loanInvest.getUserId(), list);
		}
		
		// 提前还款服务费
		int amt = prepayment.getpSerFee().multiply(new BigDecimal(100))
				.intValue();
		TransBmuBean transBmuBean = new TransBmuBean();
		// 付款登录账户
		transBmuBean.setOut_cust_no(lender.getJzhloginid());
		// 收款登录账户
		transBmuBean.setIn_cust_no(FyUtil.MCHNT_USER_ID);
		// 转账金额
		transBmuBean.setAmt(String.valueOf(amt));
		// 进行转账操作
		TransBmuResp tbr = null;
		if(amt>0){
			tbr = CapitalMgt.transferBmu(transBmuBean, lender, null, "提前还款服务费",loanApply.getOrderNumber() );
		}
		if (tbr != null) {
			if (FyUtil.SUCCESS.equals(tbr.getResponse().getResp_code())) {
				
				// 更新借款人用户账户表
				userAccountServ.updateUserAccount(lender);
				// 成功修改对账表信息
				siteBillingServ.updateBusiStatus(0, tbr.getResponse().getMchnt_txn_ssn());
				UserAccountVO userAccount = userAccountMapper.selectByUserId(lenderId);// 查询本地账户信息
				// 借款人提前还款服务费记录
				UserAccountLogVO userAccountLog = new UserAccountLogVO();
				userAccountLog.setUserId(lenderId);
				userAccountLog.setType(4309);
				userAccountLog.setMoney(prepayment.getpSerFee());
				userAccountLog.setTotal(userAccount.getTotal());
				userAccountLog.setFrost(userAccount.getFrost());
				userAccountLog.setCash(userAccount.getCash());
				userAccountLog.setAddTime(DateUtil.getUnixTime());
				userAccountLog.setApplyId(loanApply.getId());
				userAccountLog.setTo(FyUtil.MCHNT_USER_ID);
				userAccountLog.setMemo(loanApply.getName());
				// 生成提前还款服务费编号
				String oldMaxBusiNumber = userAccountLogMapper
						.findMaxBusiNumber("TRHKF" + DateUtil.getCurrentDate("yyyyMMdd"));
				log.info("oldMaxBusiNumber==" + oldMaxBusiNumber);
				String busiNumber = UserAccountUtil.getBusiNumber(oldMaxBusiNumber, "TRHKF");
				log.info("busiNumber==" + busiNumber);
				userAccountLog.setBusiNumber(busiNumber);
				userAccountLogMapper.insertSelective(userAccountLog);
				
				
				SiteFeeTypePOJO siteFeeTypeVo = siteFeeTypeMapper.queryChageMode(null, "提前还款服务费", "2");
				// 平台收益记录
				SiteAccountLogVO siteAccountLog = new SiteAccountLogVO();
				siteAccountLog.setFeeId(siteFeeTypeVo.getChargeFeeId());
				siteAccountLog.setUserId(lenderId);
				siteAccountLog.setMoney(prepayment.getpSerFee());
				siteAccountLog.setCreated(DateUtil.getUnixTime());
				siteAccountLogMapper.insertSelective(siteAccountLog);
				
				// 总收益更新
				SiteAccountVO siteAccount = siteAccountMapper.findSiteAccountByFeeName("提前还款服务费");
				siteAccount.setIncome(siteAccount.getIncome().add(prepayment.getpSerFee()));
				siteAccountMapper.updateByPrimaryKeySelective(siteAccount);
			}else{
				flag = false;
			}
		} else {
			flag = false;
			// 失败修改 对账表信息
			siteBillingServ.updateBusiStatus(1, tbr.getMchnt_txn_ssn());
		}
		
		
		
		// 划拨
		// 查出当期回款计划
		List<ApplyRecoverVO> applyRecoverList = applyRecoverMapper.findRepayByApplyidAndRecoverperiod(loanApply.getId(), applyRepay.getRepayPeriod()); 
		for(ApplyRecoverVO applyRecover : applyRecoverList){
			int investmentUserId = applyRecover.getUserId();
			// 根据用户id查询投资人用户信息
			UserVO invester = userBeanMapper.getUserByUserId(investmentUserId);
			log.info("2:"+prepayment.getProfit());
			BigDecimal transferMoney = prepayment.getProfit().multiply(proportMap.get(investmentUserId).get(1)).
					add(proportMap.get(investmentUserId).get(0)).
					setScale(2, BigDecimal.ROUND_HALF_UP);
			// 转账金额,已分为单位(首先取小数点后面两位，然后再乘100，再转为整型)
			int transferAmt = transferMoney.multiply(new BigDecimal(100))
					.intValue();
			TransBuBean reqData = new TransBuBean();
			// 付款登录账户
			reqData.setOut_cust_no(lender.getJzhloginid());
			// 收款登录账户
			reqData.setIn_cust_no(invester.getJzhloginid());
			// 转账金额
			reqData.setAmt(String.valueOf(transferAmt));
			// 进行划拨操作
			TransBuResp transBuResp = null;
			if(transferAmt>0){
				transBuResp = CapitalMgt.transferBu(reqData, lender, invester, "提前还款", loanApply.getOrderNumber());
			}
			if (transBuResp != null) {
				// 若转账成功
				if (FyUtil.SUCCESS.equals(transBuResp.getResponse().getResp_code())) {
					// 更新投资人人用户账户表
					userAccountServ.updateUserAccount(invester);
					// 转账成功修改对账表信息
					siteBillingServ.updateBusiStatus(0, transBuResp.getResponse().getMchnt_txn_ssn());
					applyRecover.setValueDate(applyRepay.getValueDate());
					applyRecover.setMaturityDate(applyRepay.getRepayReqTime());
					applyRecover.setBatchSerialno(reqData.getMchnt_txn_ssn());
					/*applyRecover.setStatus((byte) 1);
					applyRecover.setRecoverDoneTime(DateUtil.getUnixTime());*/
					applyRecoverMapper.updateByPrimaryKeySelective(applyRecover);
					
					UserAccountVO userAccount = userAccountMapper.selectByUserId(investmentUserId);// 查询本地账户信息
					// 投资人回款成功记录
					UserAccountLogVO userAccountLog = new UserAccountLogVO();
					userAccountLog.setUserId(investmentUserId);
					userAccountLog.setType(4206);
					userAccountLog.setMoney(transferMoney);
					userAccountLog.setTotal(userAccount.getTotal());
					userAccountLog.setFrost(userAccount.getFrost());
					userAccountLog.setCash(userAccount.getCash());
					userAccountLog.setAddTime(DateUtil.getUnixTime());
					userAccountLog.setApplyId(loanApply.getId());
					userAccountLog.setFrom(lenderId);
					userAccountLog.setMemo(loanApply.getName());
					// 生成投资人回款成功编号
					String oldMaxBusiNumber = userAccountLogMapper
							.findMaxBusiNumber("THK" + DateUtil.getCurrentDate("yyyyMMdd"));
					log.info("oldMaxBusiNumber==" + oldMaxBusiNumber);
					String busiNumber = UserAccountUtil.getBusiNumber(oldMaxBusiNumber, "THK");
					log.info("busiNumber==" + busiNumber);
					userAccountLog.setBusiNumber(busiNumber);
					userAccountLogMapper.insertSelective(userAccountLog);
					
					// 站内信 发送给投资人 收到的回款金额
					commonServ.sendall(invester.getMobile(), SmsTypeUtil.P2P_RECOVERMONEY_SUC, loanApply.getName(),
							transferMoney.toString(), proportMap.get(investmentUserId).get(0).toString(),
							prepayment.getProfit().multiply(proportMap.get(investmentUserId).get(1)).toString());
					//更新实还金额
					applyRecover.setRepayDoneCapital(proportMap.get(investmentUserId).get(0));
					applyRecover.setRepayDoneInterest(prepayment.getProfit().multiply(proportMap.get(investmentUserId).get(1)));
					applyRecoverMapper.updateByPrimaryKeySelective(applyRecover);
				}else{
					flag = false;
				}
			} else {
				flag = false;
				// 划拨失败修改 对账表信息
				siteBillingServ.updateBusiStatus(1, reqData.getMchnt_txn_ssn());
				continue;
			}
		}
		
		// 更新借款人用户账户表
		userAccountServ.updateUserAccount(lender);
		// 借款人还款成功记录
		UserAccountVO userAccount2 = userAccountMapper.selectByUserId(lenderId);// 查询本地账户信息
		UserAccountLogVO userAccountLog2 = new UserAccountLogVO();
		userAccountLog2.setUserId(lenderId);
		userAccountLog2.setType(4307);
		userAccountLog2.setMoney(prepayment.getRepayMoney().add(prepayment.getProfit()));
		userAccountLog2.setTotal(userAccount2.getTotal());
		userAccountLog2.setFrost(userAccount2.getFrost());
		userAccountLog2.setCash(userAccount2.getCash());
		userAccountLog2.setAddTime(DateUtil.getUnixTime());
		userAccountLog2.setApplyId(loanApply.getId());
		userAccountLog2.setMemo(loanApply.getName());
		// 生成借款人还款成功编号
		String oldMaxBusiNumber2 = userAccountLogMapper
				.findMaxBusiNumber("RHK" + DateUtil.getCurrentDate("yyyyMMdd"));
		log.info("oldMaxBusiNumber2==" + oldMaxBusiNumber2);
		String busiNumber2 = UserAccountUtil.getBusiNumber(oldMaxBusiNumber2, "RHK");
		log.info("busiNumber2==" + busiNumber2);
		userAccountLog2.setBusiNumber(busiNumber2);
		userAccountLogMapper.insertSelective(userAccountLog2);
		
		SiteFeeTypePOJO siteFeeTypeVo2 = siteFeeTypeMapper.queryChageMode(null, "投资服务费", "1");
		BigDecimal actDays = new BigDecimal(DateUtil.getTimeDifference(applyRepay.getValueDate(), DateUtil.getUnixTime()));
		BigDecimal days = new BigDecimal(DateUtil.getTimeDifference(applyRepay.getValueDate(), applyRepay.getMaturityDate()));
		BigDecimal pro = actDays.divide(days, 4, BigDecimal.ROUND_HALF_UP);
		
		//转账投资服务费
		for(ApplyRecoverVO applyRecover : applyRecoverList){
			int investmentUserId = applyRecover.getUserId();
			// 根据用户id查询投资人用户信息
			UserVO invester = userBeanMapper.getUserByUserId(investmentUserId);
			
			BigDecimal transferMoney = applyRecover.getRecoverInterest().multiply(pro).multiply(siteFeeTypeVo2.getInterestRate().divide(new BigDecimal(100), 4, BigDecimal.ROUND_HALF_UP)).
					setScale(2, BigDecimal.ROUND_HALF_UP);
			log.info("transferMoney:"+transferMoney);
			// 转账金额,已分为单位(首先取小数点后面两位，然后再乘100，再转为整型)
			int transferAmt = transferMoney.multiply(new BigDecimal(100))
					.intValue();
			TransBmuBean reqData = new TransBmuBean();
			// 付款登录账户
			reqData.setOut_cust_no(invester.getJzhloginid());
			// 收款登录账户
			reqData.setIn_cust_no(FyUtil.MCHNT_USER_ID);
			// 转账金额
			reqData.setAmt(String.valueOf(transferAmt));
			// 进行转账操作
			TransBmuResp transBmuResp = null;
			if(transferAmt>0){
				transBmuResp = CapitalMgt.transferBmu(reqData, invester, null, "投资服务费",loanApply.getOrderNumber());
			}
			if (transBmuResp != null) {
				if (FyUtil.SUCCESS.equals(transBmuResp.getResponse().getResp_code())) {
					// 更新投资人人用户账户表
					userAccountServ.updateUserAccount(invester);
					// 成功修改 对账表信息
					siteBillingServ.updateBusiStatus(0, transBmuResp.getResponse().getMchnt_txn_ssn());
					UserAccountVO userAccount = userAccountMapper.selectByUserId(investmentUserId);// 查询本地账户信息
					// 投资人投资服务费记录
					UserAccountLogVO userAccountLog = new UserAccountLogVO();
					userAccountLog.setUserId(investmentUserId);
					userAccountLog.setType(4204);
					userAccountLog.setMoney(transferMoney);
					userAccountLog.setTotal(userAccount.getTotal().add(transferMoney));
					userAccountLog.setFrost(userAccount.getFrost());
					userAccountLog.setCash(userAccount.getCash());
					userAccountLog.setAddTime(DateUtil.getUnixTime());
					userAccountLog.setApplyId(loanApply.getId());
					userAccountLog.setTo(FyUtil.MCHNT_USER_ID);
					userAccountLog.setMemo(loanApply.getName());
					// 生成投资人投资服务费编号
					String oldMaxBusiNumber = userAccountLogMapper
							.findMaxBusiNumber("TCF" + DateUtil.getCurrentDate("yyyyMMdd"));
					log.info("oldMaxBusiNumber==" + oldMaxBusiNumber);
					String busiNumber = UserAccountUtil.getBusiNumber(oldMaxBusiNumber, "TCF");
					log.info("busiNumber==" + busiNumber);
					userAccountLog.setBusiNumber(busiNumber);
					userAccountLogMapper.insertSelective(userAccountLog);
					
					// 平台收益记录
					SiteAccountLogVO siteAccountLog = new SiteAccountLogVO();
					siteAccountLog.setFeeId(siteFeeTypeVo2.getChargeFeeId());
					siteAccountLog.setUserId(investmentUserId);
					siteAccountLog.setMoney(transferMoney);
					siteAccountLog.setCreated(DateUtil.getUnixTime());
					siteAccountLogMapper.insertSelective(siteAccountLog);
	
					// 总收益更新
					SiteAccountVO siteAccount = siteAccountMapper.findSiteAccountByFeeName("投资服务费");
					siteAccount.setIncome(siteAccount.getIncome().add(transferMoney));
					siteAccountMapper.updateByPrimaryKeySelective(siteAccount);
				}else{
					flag = false;
				}
			} else {
				if(transferAmt>0){
					flag = false;
					// 失败修改 对账表信息
					siteBillingServ.updateBusiStatus(1, reqData.getMchnt_txn_ssn());
				}
				continue;
			}
		}
		
		if(flag){
			log.info("3:"+prepayment.getProfit());
			//将提前还款的当期实际还款本金和实际还款利息
			applyRepay.setRepayDoneCapital(prepayment.getRepayMoney());
			applyRepay.setRepayDoneInterest(prepayment.getProfit());
			applyRepay.setMaturityDate(DateUtil.getUnixTime());
			applyRepayMapper.updateByPrimaryKeySelective(applyRepay);
			// 将状态为未还的还款计划改为已还
			List<ApplyRepayVO> applyRepayList = applyRepayMapper.findAllApplyRepayByApplyId(applyId);
			applyRepayMapper.batchUpdateStatus(applyRepayList);
			// 将状态为未还的回款计划改为已还
			List<ApplyRecoverVO> allApplyRecoverList = applyRecoverMapper.findAllApplyRecoverByApplyId(applyId);
			applyRecoverMapper.batchUpdateStatus(allApplyRecoverList);
			// 将标的状态改为已还清
			loanApplyMapper.updateLoanApplyStatusByApplyId(applyId, 10);
		}
		return flag;
	}

	@Override
	public ApplyRepayVO isExistNotRepayByPeriod(int applyId, int period) {
		return applyRepayMapper.isExistNotRepayByPeriod(applyId, period);
	}
}
