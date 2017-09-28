package com.fujfu.service.award.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujfu.common.payment.fuyou.pojo.QueryBalanceBean;
import com.fujfu.common.payment.fuyou.pojo.TransBmuBean;
import com.fujfu.common.payment.fuyou.pojo.response.QueryBalanceResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBmuResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.DateUtil;
import com.fujfu.dao.award.AwardTypeMapper;
import com.fujfu.dao.award.UsersAwardAccountLogMapper;
import com.fujfu.dao.award.UsersAwardAccountMapper;
import com.fujfu.dao.award.UsersAwardActionMapper;
import com.fujfu.dao.loan.LoanApplyMapper;
import com.fujfu.pojo.account.SiteAccountLogVO;
import com.fujfu.pojo.account.UserAccountLogVO;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.award.AwardTypeVO;
import com.fujfu.pojo.award.UsersAwardAccountVO;
import com.fujfu.pojo.award.UsersAwardActionVO;
import com.fujfu.pojo.award.UsersAwardAccountLogVO;
import com.fujfu.pojo.loan.LoanApplyVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.CapitalMgtServ;
import com.fujfu.service.account.SiteAccountLogServ;
import com.fujfu.service.account.SiteBillingServ;
import com.fujfu.service.account.UserAccountLogServ;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.award.AwardUserAddServ;
import com.fujfu.service.fee.SiteFeeServ;
import com.fujfu.service.user.UserServ;

@Service("awardUserAddServ")
public class AwardUserAddServImpl implements AwardUserAddServ {
	// 活动类型
	@Resource
	AwardTypeMapper awardTypeMapper;
	
	@Resource
	UsersAwardActionMapper usersAwardActionMapper;

	// 用户权益账户
	@Resource
	UsersAwardAccountMapper usersAwardAccountMapper;

	@Resource
	private CapitalMgtServ capitalMgtServ;

	@Resource
	private UserServ userServ;

	@Resource
	private UserAccountServ userAccountServ;

	@Resource
	UsersAwardAccountLogMapper usersAwardAccountLogMapper;

	@Resource
	private UserAccountLogServ userAccountLogServ;

	@Resource
	LoanApplyMapper loanApplyMapper;
	@Resource
	private SiteBillingServ siteBillingServ;

	@Autowired
	private SiteFeeServ siteFeeServ;

	@Resource
	private SiteAccountLogServ siteAccountLogServ;

	//
	/** 新增赠用户权益 */
	@Override
	public int addUserAward(String origin, String type, Integer userId, String mobile, String remark) {

		AwardTypeVO awardType = new AwardTypeVO();
		// 类型
		awardType.setType(type);
		// 状态
		awardType.setStatus(0);

		// 来源
		awardType.setOrigin(origin);

		List<AwardTypeVO> awardTypeList = awardTypeMapper.findAwardTypeList(awardType, DateUtil.getUnixTime());
		if (awardTypeList.size() == 0) {
			return -1;
		}

		/** 多少个红包活动，送多少红包 */
		for (AwardTypeVO awardType1 : awardTypeList) {

			UsersAwardAccountVO usersAwardAccount = new UsersAwardAccountVO();

			/** 新增用户权益表 */
			// 权益ID
			usersAwardAccount.setId(this.getId());
			// 用户ID
			usersAwardAccount.setUserId(userId);
			// 手机号码
			usersAwardAccount.setMobile(mobile);
			// 主题ID
			usersAwardAccount.setThemeId(awardType1.getId());
			// 主题
			usersAwardAccount.setTheme(awardType1.getTheme());
			// 类型
			usersAwardAccount.setType(awardType1.getType());
			// 初始金额
			usersAwardAccount.setInitAmount(awardType1.getAmount());
			// 剩余金额
			usersAwardAccount.setRemainAmount(awardType1.getAmount());
			// 来源
			usersAwardAccount.setOrigin(awardType1.getOrigin());
			// 备注
			usersAwardAccount.setRemark(remark);
			// 有效期
			// private Integer term;
			usersAwardAccount.setTerm(DateUtil.getUnixTimeNextDays(new Date(), awardType1.getTerm()));
			usersAwardAccount.setCreated(DateUtil.getUnixTime());
			usersAwardAccountMapper.insertSelective(usersAwardAccount);
		}
		return 0;
	}

	public String getId() {
		String id = "HB" + DateUtil.getCurrentDate("yyMMddHHmmss");
		String ranNum = String.valueOf(new Random().nextInt(1000) + 1);
		String ranNumPrefix = "";
		for (int i = 0; i < 3 - ranNum.length(); i++) {
			ranNumPrefix = "0" + ranNumPrefix;
		}
		id = id + ranNumPrefix + ranNum;
		/* 判断是否已存在 */
		UsersAwardAccountVO usersAwardAccount = usersAwardAccountMapper.selectByPrimaryKey(id);
		if (usersAwardAccount != null) {
			ranNum = String.valueOf(new Random().nextInt(1000) + 1);
			ranNumPrefix = "";
			for (int i = 0; i < 3 - ranNum.length(); i++) {
				ranNumPrefix = "0" + ranNumPrefix;
			}
			id = id + ranNumPrefix + ranNum;
		}
		return id;
	}

	/** 用户权益使用 */
	@Override
	public int useUserAward(String awardId, BigDecimal tranAmount, Integer userId, Integer loanId, String remark) {

		/** 查询用户基本信息 */
		UserVO user = userServ.getUserByUserId(userId);
		if (user == null) {
			return -1;
		}
		UsersAwardAccountVO usersAwardAccount = usersAwardAccountMapper.selectByPrimaryKey(awardId);
		if (usersAwardAccount == null) {
			return -1;
		}
		if (usersAwardAccount.getRemainAmount().compareTo(BigDecimal.ZERO) == 0) {
			return -1;
		}

		/**
		 * 查询贷款基本信息
		 */
		LoanApplyVO loanApply = loanApplyMapper.selectByPrimaryKey(loanId);
		if (loanApply == null) {
			return -1;
		}

		/** 获取投资人款人富友账户ID */
		UserVO lender = userServ.getUserByUserId(userId);
		String amtStr = usersAwardAccount.getInitAmount().multiply(new BigDecimal(100)).intValue() + "";
		TransBmuBean transBmuBean = new TransBmuBean();

		transBmuBean.setAmt(amtStr);// 金额
		transBmuBean.setOut_cust_no(FyUtil.MCHNT_USER_ID);// 转出账户
		transBmuBean.setIn_cust_no(lender.getJzhloginid());// 转入账户

		// 进行转账操作
		TransBmuResp transBuResp = null;
		try {
			/* 执行资金划转 转入投资人资金账户 */
			transBuResp = capitalMgtServ.transferBmu(transBmuBean, null, lender, "平台充值", "红包奖励");
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		if (transBuResp == null) {
			return -1;
		}

		if (!FyUtil.SUCCESS.equals(transBuResp.getResponse().getResp_code())) {
			UsersAwardActionVO usersAwardAction = new UsersAwardActionVO();
			usersAwardAction.setRewardId(awardId);
			usersAwardAction.setInvesterId(userId);
			usersAwardAction.setFySerialno(transBuResp.getResponse().getMchnt_txn_ssn());
			usersAwardAction.setStatus(1);
			usersAwardAction.setCreated(DateUtil.getUnixTime());
			usersAwardActionMapper.insertSelective(usersAwardAction);
			
			// 转账失败修改 对账表信息
			siteBillingServ.updateBusiStatus(1, transBuResp.getResponse().getMchnt_txn_ssn());
			return -1;

		}
		// 转账成功修改 对账表信息
		siteBillingServ.updateBusiStatus(0, transBuResp.getResponse().getMchnt_txn_ssn());

		/** 更新用户账户余额信息 */
		// 查询余额
		QueryBalanceBean reqData = new QueryBalanceBean();
		reqData.setCust_no(lender.getJzhloginid());
		QueryBalanceResp resp = capitalMgtServ.queryBalance(reqData);

		// 查询担保机构账户信息
		UserAccountVO ua = userAccountServ.selectByUserId(lender.getUserId());// 查询本地账户信息
		if (ua == null) {
			return -1;
		}

		// 更新账户表
		String respCode = resp.getResponse().getResp_code();
		if (respCode.equals(FyUtil.SUCCESS)) {
			resp = resp.getResponse().getRespList().get(0);// 返回金额单位为分
			if (StringUtils.isNotEmpty(resp.getCt_balance())) {
				ua.setTotal(new BigDecimal(resp.getCt_balance()).divide(new BigDecimal(100)));
			}
			if (StringUtils.isNotEmpty(resp.getCf_balance())) {
				ua.setFrost(new BigDecimal(resp.getCf_balance()).divide(new BigDecimal(100)));
			}
			if (StringUtils.isNotEmpty(resp.getCa_balance())) {
				ua.setCash(new BigDecimal(resp.getCa_balance()).divide(new BigDecimal(100)));
			}
		}
		userAccountServ.updateByPrimaryKeySelective(ua);
		int curentTime = DateUtil.getUnixTime();
		// 红包
		UserAccountLogVO userAccountLog = new UserAccountLogVO();
		userAccountLog.setUserId(userId);
		userAccountLog.setType(1032);
		userAccountLog.setMoney(usersAwardAccount.getInitAmount());
		userAccountLog.setTotal(ua.getTotal());
		userAccountLog.setFrost(ua.getFrost());
		userAccountLog.setCash(ua.getCash());
		userAccountLog.setAddTime(curentTime);
		userAccountLog.setApplyId(loanId);
		// ?
		userAccountLog.setFrom(0000);
		// userAccountLog.setTo(guaranteeId + "");
		userAccountLog.setMemo("红包赠送");
		userAccountLogServ.insertSelective(userAccountLog);

		/** 更新红包记录 */
		usersAwardAccount.setUpdated(curentTime);
		usersAwardAccount.setRemainAmount(new BigDecimal(0.00));
		usersAwardAccount.setStatus("2");
		usersAwardAccountMapper.updateByPrimaryKeySelective(usersAwardAccount);

		/** 添加红包使用记录 */
		UsersAwardAccountLogVO usersAwardAccountLog = new UsersAwardAccountLogVO();

		usersAwardAccountLog.setUserId(lender.getUserId());
		usersAwardAccountLog.setVocherId(usersAwardAccount.getId());
		usersAwardAccountLog.setOrigin(usersAwardAccount.getOrigin());
		usersAwardAccountLog.setUsername(user.getRealname());
		usersAwardAccountLog.setMobile(user.getMobile());
		usersAwardAccountLog.setLoanId(loanId);
		usersAwardAccountLog.setLoanName(loanApply.getName());
		usersAwardAccountLog.setTheme(usersAwardAccount.getTheme());
		usersAwardAccountLog.setThemeId(usersAwardAccount.getThemeId());
		usersAwardAccountLog.setType(usersAwardAccount.getType());
		usersAwardAccountLog.setInitAmount(usersAwardAccount.getInitAmount());
		usersAwardAccountLog.setRemainAmount(new BigDecimal(0.00));
		usersAwardAccountLog.setTranAmount(tranAmount);
		usersAwardAccountLog.setStatus("1");
		usersAwardAccountLog.setRemark(remark);
		usersAwardAccountLog.setTerm(usersAwardAccount.getTerm());
		usersAwardAccountLog.setCreated(curentTime);
		usersAwardAccountLogMapper.insertSelective(usersAwardAccountLog);

		/** 添加平台账单记录 */
		SiteAccountLogVO siteAccountLog = new SiteAccountLogVO();
		siteAccountLog.setFeeId(siteFeeServ.findSiteFeeByFeeName("红包支出").getFeeId());
		siteAccountLog.setUserId(lender.getUserId());
		siteAccountLog.setMoney(usersAwardAccount.getInitAmount());
		siteAccountLog.setCreated(DateUtil.getUnixTime());
		siteAccountLogServ.addSiteAccountLog(siteAccountLog);
		return 0;

	}

	/** 查询用户当前该使用红包 */
	@Override
	public List<UsersAwardAccountVO> searchUserAward(Integer userId, BigDecimal tranAmount) {

		UsersAwardAccountVO usersAwardAccount = new UsersAwardAccountVO();
		usersAwardAccount.setUserId(userId);
		usersAwardAccount.setType("1");

		usersAwardAccount.setTerm(DateUtil.getUnixTime());

		List<UsersAwardAccountVO> usersAwardAccountList = usersAwardAccountMapper
				.findAwardAccountList(usersAwardAccount, tranAmount);

		return usersAwardAccountList;

	}

	@Override
	public List<UsersAwardAccountVO> searchUserAward(Integer userId, String searchType) {

		List<UsersAwardAccountVO> usersAwardAccountList = new ArrayList<UsersAwardAccountVO>();
		UsersAwardAccountVO usersAwardAccount = new UsersAwardAccountVO();
		usersAwardAccount.setUserId(userId);
		usersAwardAccount.setType("1");
		usersAwardAccount.setTerm(DateUtil.getUnixTime());
		/* 查询未使用未过期红包 */
		if ("1".equals(searchType)) {

			usersAwardAccountList = usersAwardAccountMapper.findAvailAwardAccountList(usersAwardAccount);

			/* 查询已使用红包 */
		} else if ("2".equals(searchType)) {

			usersAwardAccountList = usersAwardAccountMapper.findUsedAwardAccountList(usersAwardAccount);

			/* 查询未使用过期红包 */
		} else if ("3".equals(searchType)) {

			usersAwardAccountList = usersAwardAccountMapper.findPastAwardAccountList(usersAwardAccount);

		}

		return usersAwardAccountList;

	}

}
