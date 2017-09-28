package com.fujfu.job.recommend.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fujfu.common.payment.fuyou.CapitalMgt;
import com.fujfu.common.payment.fuyou.pojo.QueryTransactionDetailsBean;
import com.fujfu.common.payment.fuyou.pojo.TransBmuBean;
import com.fujfu.common.payment.fuyou.pojo.response.QueryTransactionDetailsBeanResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBmuResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.DateUtil;
import com.fujfu.dao.award.UsersAwardAccountMapper;
import com.fujfu.dao.award.UsersAwardActionMapper;
import com.fujfu.dao.user.UserMapper;
import com.fujfu.job.recommend.RewardActionJob;
import com.fujfu.pojo.award.UsersAwardAccountVO;
import com.fujfu.pojo.award.UsersAwardActionVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.CapitalMgtServ;

public class RewardActionJobImpl implements RewardActionJob {
	@Autowired 
	private CapitalMgtServ service; 
	@Autowired
	private UserMapper mapper;
	@Autowired
	UsersAwardActionMapper usersAwardActionMapper;
	@Autowired
	UsersAwardAccountMapper usersAwardAccountMapper;
	
	@Override
	public void rewardAction() throws Exception {
		System.out.println("异常红包处理");
		int startTime = DateUtil.getUnixTime()-259200;
		int endTime = DateUtil.getUnixTime()+259200;
		// 找出发送红包失败、冻结失败的红包记录
		List<UsersAwardActionVO> sendFailList = usersAwardActionMapper.findAwardActionByStatus(1,startTime,endTime);
		List<UsersAwardActionVO> frozenFailList = usersAwardActionMapper.findAwardActionByStatus(2,startTime,endTime);
		
		// 红包退回处理
		handle(sendFailList, "PWPC", endTime, endTime);
		handle(frozenFailList, "PWDJ", endTime, endTime);
	}
	
	/**
	 * 红包退回处理
	 * @param list
	 * @param busiTp
	 * @param startTime
	 * @param endTime
	 * @throws Exception
	 */
	private void handle(List<UsersAwardActionVO> list,String busiTp,int startTime,int endTime) throws Exception{
		if(list.size()==0){
			System.out.println("没有要处理的异常红包");
			return;
		}
		
		for(UsersAwardActionVO usersAwardAction : list){
			// 根据交易流水去富友查询交易状态
			QueryTransactionDetailsBean reqData = new QueryTransactionDetailsBean();
			reqData.setBusi_tp(busiTp);
			reqData.setTxn_st(usersAwardAction.getFySerialno());
			reqData.setStart_day(DateUtil.timeMillisToStr(startTime,"yyyyMMdd"));
			reqData.setEnd_day(DateUtil.timeMillisToStr(startTime,"yyyyMMdd"));
			QueryTransactionDetailsBeanResp respData = service.QueryTransactionDetails(reqData);
			String respCode = respData.getResponse().getResp_code();
			if(respCode.equals(FyUtil.SUCCESS)){
				UserVO user = mapper.getUserByUserId(usersAwardAction.getInvesterId());
				UsersAwardAccountVO usersAwardAccount = usersAwardAccountMapper.selectByPrimaryKey(usersAwardAction.getRewardId());
				
				int amt = usersAwardAccount.getInitAmount().multiply(new BigDecimal(100))
						.intValue();
				TransBmuBean transBmuBean = new TransBmuBean();
				// 付款登录账户
				transBmuBean.setOut_cust_no(user.getJzhloginid());
				// 收款登录账户
				transBmuBean.setIn_cust_no(FyUtil.MCHNT_USER_ID);
				// 转账金额
				transBmuBean.setAmt(String.valueOf(amt));
				// 进行转账操作
				TransBmuResp tbr = null;
				if(amt>0){
					tbr = CapitalMgt.transferBmu(transBmuBean, user, null, "红包退回","" );
				}
				if (tbr != null) {
					if (FyUtil.SUCCESS.equals(tbr.getResponse().getResp_code())) {
						UsersAwardActionVO usersAward = new UsersAwardActionVO();
						usersAwardAction.setId(usersAwardAction.getId());
						usersAwardAction.setStatus(3);
						usersAwardActionMapper.updateByPrimaryKeySelective(usersAward);
					}
				}
			}
			continue;
		}
	}
}
