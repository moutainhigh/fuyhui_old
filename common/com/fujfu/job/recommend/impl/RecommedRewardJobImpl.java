package com.fujfu.job.recommend.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fujfu.common.payment.fuyou.pojo.QueryBalanceBean;
import com.fujfu.common.payment.fuyou.pojo.TransBmuBean;
import com.fujfu.common.payment.fuyou.pojo.response.QueryBalanceResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBmuResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.DateUtil;
import com.fujfu.dao.award.UsersAwardAccountLogMapper;
import com.fujfu.dao.recommend.RecommendFriendshipMapper;
import com.fujfu.dao.recommend.RecommendFriendshipTempMapper;
import com.fujfu.dao.recommend.RecommendSettingDetailMapper;
import com.fujfu.job.recommend.RecommedRewardJob;
import com.fujfu.pojo.account.SiteAccountLogVO;
import com.fujfu.pojo.account.UserAccountLogVO;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.recommend.RecommendFriendshipVO;
import com.fujfu.pojo.recommend.RecommendSettingDetailVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.CapitalMgtServ;
import com.fujfu.service.account.SiteAccountLogServ;
import com.fujfu.service.account.SiteBillingServ;
import com.fujfu.service.account.UserAccountLogServ;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.fee.SiteFeeServ;
import com.fujfu.service.invest.LoanInvestmentServ;
import com.fujfu.service.user.UserServ;

public class RecommedRewardJobImpl implements RecommedRewardJob {

	private static Logger logger = LoggerFactory.getLogger(RecommedRewardJobImpl.class);

	@Autowired
	private RecommendFriendshipMapper recommendFriendshipMapper;
	@Autowired
	private RecommendFriendshipTempMapper recommendFriendshipTempMapper;
	@Autowired
	private RecommendSettingDetailMapper recommendSettingDetailMapper;
	@Autowired
	private CapitalMgtServ capitalMgtServ;
	@Autowired
	private UserServ userServ;
	@Autowired
	private UserAccountServ userAccountServ;
	@Autowired
	UsersAwardAccountLogMapper usersAwardAccountLogMapper;
	@Autowired
	private UserAccountLogServ userAccountLogServ;
	@Autowired
	private SiteBillingServ siteBillingServ;
	@Autowired
	private SiteFeeServ siteFeeServ;

	@Autowired
	private SiteAccountLogServ siteAccountLogServ;
	@Autowired
	private LoanInvestmentServ loanInvestmentServ;

	@Override
	public void reward() {
		List<RecommendFriendshipVO> recommendFriendshipList = recommendFriendshipMapper.selectPreparedRecommed();
		logger.info("RecommnedReward batch start");
		logger.info("loop excute start ..................");

		if (recommendFriendshipList != null && recommendFriendshipList.size() > 0) {
			// 取出关系表中所有的id
			List<Integer> idList = new ArrayList<Integer>();
			for (RecommendFriendshipVO recommendFriendship : recommendFriendshipList) {
				idList.add(recommendFriendship.getId());
			}			
			if (recommendFriendshipTempMapper.countRecommendFriendship() > 0) {
				List<RecommendFriendshipVO> recommendFriendshipTempList = recommendFriendshipTempMapper
						.findAllRecommendFriendshipTemp();
				// 取出临时表中所有的id
				List<Integer> idTempList = new ArrayList<Integer>();
				for (RecommendFriendshipVO recommendFriendship : recommendFriendshipTempList) {
					idTempList.add(recommendFriendship.getId());
				}
				boolean existData = false;
				// 如果关系表中包含临时表中的id
				for (Integer i : idTempList) {
					if (idList.contains(i)) {
						existData = true;
						break;
					}
				}
				if (existData) {
					return;
				}
			}
			// 插入记录
			for (RecommendFriendshipVO recommendFriendship : recommendFriendshipList) {
				recommendFriendshipTempMapper.insertSelective(recommendFriendship);
			}
			work(recommendFriendshipList);			
		}

		logger.info("RecommnedReward batch end");
	}

	public void updateFalile(RecommendFriendshipVO recommendFriendship, String remark) {
		recommendFriendship.setStatus("3");
		recommendFriendship.setRemark(remark);
		recommendFriendship.setUpdated(DateUtil.getUnixTime());
		recommendFriendshipMapper.updateByPrimaryKeySelective(recommendFriendship);
	}

	private void work(List<RecommendFriendshipVO> recommendFriendshipTempList) {
		for (RecommendFriendshipVO recommendFriendship : recommendFriendshipTempList) {
			RecommendSettingDetailVO recommendSettingDetail = recommendSettingDetailMapper
					.searchRewardMoney(recommendFriendship.getInvestAmount());
			if (recommendSettingDetail != null) {
				// 奖励金额
				BigDecimal rewardMoney = recommendSettingDetail.getAmount();

				/* 获取推荐人富友账户ID */
				UserVO referrer = userServ.getUserByUserId(recommendFriendship.getRecommendUserId());

				String amtStr = rewardMoney.multiply(new BigDecimal(100)).intValue() + "";

				TransBmuBean transBmuBean = new TransBmuBean();

				transBmuBean.setAmt(amtStr);// 金额
				transBmuBean.setOut_cust_no(FyUtil.MCHNT_USER_ID);// 转出账户
				transBmuBean.setIn_cust_no(referrer.getJzhloginid());// 转入账户

				/** 未实名奖励失败 */
				if (StringUtils.isNotEmpty(referrer.getJzhloginid())) {
					LoanInvestPOJO loanInvestQueryVo = new LoanInvestPOJO();
					loanInvestQueryVo.setUser_id(recommendFriendship.getRecommendUserId());
					Integer investCount = loanInvestmentServ.getcountInvestList1(loanInvestQueryVo);
					if (investCount > 0) {
						/* 发送富友进行转账操作 */
						TransBmuResp transBuResp = null;
						try {
							/* 执行资金划转 转入推荐人资金账户 */
							transBuResp = capitalMgtServ.transferBmu(transBmuBean, null, referrer, "平台充值", "推荐奖励");
						} catch (Exception e) {
							e.printStackTrace();
							updateFalile(recommendFriendship, "调用富友异常");
							continue;
						}

						if (transBuResp != null) {
							if (FyUtil.SUCCESS.equals(transBuResp.getResponse().getResp_code())) {
								// 转账成功修改 对账表信息
								siteBillingServ.updateBusiStatus(0, transBuResp.getResponse().getMchnt_txn_ssn());

								/** 更新奖励成功 */
								// 状态
								recommendFriendship.setStatus("2");
								// 备注
								recommendFriendship.setRemark("奖励成功");
								// 奖励金额
								recommendFriendship.setRewardAmount(rewardMoney);
								// 奖励时间
								recommendFriendship.setRewardTime(DateUtil.getUnixTime());
								// 更新时间
								recommendFriendship.setUpdated(DateUtil.getUnixTime());
								recommendFriendshipMapper.updateByPrimaryKeySelective(recommendFriendship);

								/** 更新用户账户余额信息 */
								// 查询余额
								QueryBalanceBean reqData = new QueryBalanceBean();
								reqData.setCust_no(referrer.getJzhloginid());
								QueryBalanceResp resp = capitalMgtServ.queryBalance(reqData);

								// 查找推荐人账户
								UserAccountVO ua = userAccountServ.selectByUserId(referrer.getUserId());// 查询本地账户信息

								// 更新推荐人账户表
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
									userAccountServ.updateByPrimaryKeySelective(ua);

									// 插入流水
									int curentTime = DateUtil.getUnixTime();
									/**/
									UserAccountLogVO userAccountLog = new UserAccountLogVO();
									userAccountLog.setUserId(recommendFriendship.getRecommendUserId());
									userAccountLog.setType(1033);
									userAccountLog.setMoney(rewardMoney);
									userAccountLog.setTotal(ua.getTotal());
									userAccountLog.setFrost(ua.getFrost());
									userAccountLog.setCash(ua.getCash());
									userAccountLog.setAddTime(curentTime);
									userAccountLog.setApplyId(recommendFriendship.getInvestLoanId());
									userAccountLog.setFrom(0000);
									// userAccountLog.setTo(guaranteeId
									// +
									// "");
									userAccountLog.setMemo("推荐赠送");
									userAccountLogServ.insertSelective(userAccountLog);

									/** 添加平台账单 */

									SiteAccountLogVO siteAccountLog = new SiteAccountLogVO();
									siteAccountLog.setFeeId(siteFeeServ.findSiteFeeByFeeName("推荐支出").getFeeId());
									siteAccountLog.setUserId(referrer.getUserId());
									siteAccountLog.setMoney(rewardMoney);
									siteAccountLog.setCreated(DateUtil.getUnixTime());
									siteAccountLogServ.addSiteAccountLog(siteAccountLog);

									// 删除临时记录
									recommendFriendshipTempMapper.deleteByPrimaryKey(recommendFriendship.getId());
								}

							} else {
								// 转账失败修改 对账表信息
								siteBillingServ.updateBusiStatus(1, transBuResp.getResponse().getMchnt_txn_ssn());
								updateFalile(recommendFriendship, "调用富友异常");
								continue;
							}
						}

					} else {
						updateFalile(recommendFriendship, "未投资奖励失败");
					}
				} else {
					updateFalile(recommendFriendship, "未实名奖励失败");
				}

			} else {
				updateFalile(recommendFriendship, "参数配置错误");
			}

		}
	}
}
