package com.fujfu.service.account.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.payment.fuyou.WithdrawMgt;
import com.fujfu.common.payment.fuyou.pojo.UserWithdrawalBean;
import com.fujfu.common.payment.fuyou.util.FyUtil;import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.account.UserWithdrawalMapper;
import com.fujfu.pojo.account.UserWithdrawalVO;
import com.fujfu.pojo.account.UserWithdrawalDTO;
import com.fujfu.service.account.WithdrawalServ;

/** 
 * 资金提现服务类-实现类
 * @author huangjizhong
 */


@Service("withdrawalSer")
public class WithdrawalServImpl implements  WithdrawalServ{
	@Resource
	private UserWithdrawalMapper userWithdeawalMapper;
	@Override
	public UserWithdrawalBean withdrawal(UserWithdrawalBean reqData) 
			throws Exception {
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		reqData.setBack_notify_url(FyUtil.TX_BEHIND);
		reqData.setPage_notify_url(FyUtil.TX_INDEX);
		reqData.setMchnt_txn_ssn( DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
		WithdrawMgt.withdrawal(reqData);
		return reqData;
	}

	@Override
	public Page findUserWithdrawal(UserWithdrawalDTO userWithdrawalQuery, Page page) {
		page.setTotalCount(userWithdeawalMapper.countUserWithdeawal(userWithdrawalQuery));
		page.setItems(userWithdeawalMapper.findUserWithdeawal(userWithdrawalQuery,page));
		return page;
	}

	@Override
	public int addUserWithdrawal(UserWithdrawalVO userWithdrawal) {
		return userWithdeawalMapper.insertSelective(userWithdrawal);
	}

	@Override
	public int updateUserWithdrawal(UserWithdrawalVO userWithdrawal) {
		return userWithdeawalMapper.updateByPrimaryKeySelective(userWithdrawal);
	}

	@Override
	public int updateUserWithdrawalBySSN(String ssn, String statu) {
		return userWithdeawalMapper.updateUserWithdrawalBySSN(ssn,statu);
	}
	
	@Override
	public int  countUserwithdrawalTradeDetai(UserWithdrawalDTO userWithdrawalQuery,Integer userId) {
		// TODO Auto-generated method stub
		return userWithdeawalMapper.countUserwithdrawalTradeDetai(userWithdrawalQuery, userId);	
	}

	@Override
	public String findMaxWithdrawalNumber(String nowDateStr) {
		// TODO Auto-generated method stub
		return userWithdeawalMapper.findMaxWithdrawalNumber(nowDateStr);
	}

	@Override
	public UserWithdrawalVO selectBybillno(String ssn) throws Exception {
		// TODO Auto-generated method stub
		return userWithdeawalMapper.selectBybillno(ssn);
	}

}
	
	