package com.fujfu.service.account.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.payment.fuyou.RechargeMgt;
import com.fujfu.common.payment.fuyou.pojo.UserRechargeBean;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.account.UserRechargeMapper;
import com.fujfu.pojo.account.UserRechargeVO;
import com.fujfu.pojo.account.UserRechargeDTO;
import com.fujfu.service.account.RechargeServ;

/**
 * 充值接口实现类
 */
@Service("rechargeSer")
public class RechargeServImpl implements RechargeServ {
	@Resource
	public UserRechargeMapper userRechargeMapper;

	/**
	 * 快捷充值
	 * 
	 * @throws Exception
	 */
	@Override
	public UserRechargeBean fastRecharge(UserRechargeBean reqData) throws Exception {
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		reqData.setBack_notify_url(FyUtil.FAST_BEHIND);
		reqData.setPage_notify_url(FyUtil.FAST_INDEX);
		RechargeMgt.fastRecharge(reqData);
		return reqData;
	}

	/**
	 * 网银充值
	 * 
	 * @throws Exception
	 */
	@Override
	public UserRechargeBean webRecharge(UserRechargeBean reqData) throws Exception {
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		reqData.setBack_notify_url(FyUtil.FAST_BEHIND);
		reqData.setPage_notify_url(FyUtil.FAST_INDEX);
		RechargeMgt.webRecharge(reqData);
		return reqData;
	}

	@Override
	public Page findUserRechargeByCondition(UserRechargeDTO userRechargeQuery, Page page) {
		page.setTotalCount(userRechargeMapper.countUserRecharge(userRechargeQuery));
		page.setItems(userRechargeMapper.findUserRecharge(userRechargeQuery, page));
		return page;
	}

	@Override
	public int addUserRecharge(UserRechargeVO userRecharge) {
		return userRechargeMapper.insertSelective(userRecharge);
	}

	@Override
	public int updateRecharge(UserRechargeVO userRecharge) {
		return userRechargeMapper.updateByPrimaryKeySelective(userRecharge);
	}

	@Override
	public int updateUserRechargeBySSN(String ssn, String statu) {
		return userRechargeMapper.updateUserRechargeBySSN(ssn, Integer.parseInt(statu));
	}

	@Override
	public int countUserRechargeTradeDetai(UserRechargeDTO userRechargeQuery, Integer userId) {
		// TODO Auto-generated method stub
		return userRechargeMapper.countUserRechargeTradeDetai(userRechargeQuery, userId);
	}

	@Override
	public int countUserAllTradeDetai(UserRechargeDTO userRechargeQuery, Integer userId) {
		// TODO Auto-generated method stub
		return userRechargeMapper.countUserAllTradeDetai(userRechargeQuery, userId);
	}

	@Override
	public int countUserAllTradeDetaiJk(UserRechargeDTO userRechargeQuery, Integer userId) {
		// TODO Auto-generated method stub
		return userRechargeMapper.countUserAllTradeDetaiJk(userRechargeQuery, userId);
	}

	/**
	 * 查询最大充值编号
	 * 
	 * @return
	 */
	@Override
	public String findMaxRechargeNumber(String nowDateStr) {
		// TODO Auto-generated method stub
		return userRechargeMapper.findMaxRechargeNumber(nowDateStr);
	}

	@Override
	public List<UserRechargeVO> selectByQueryCondition(UserRechargeDTO userRechargeQuery) {
		// TODO Auto-generated method stub
		return userRechargeMapper.selectByQueryCondition(userRechargeQuery);
	}

	@Override
	public UserRechargeVO selectBybillno(String ssn) throws Exception {
		// TODO Auto-generated method stub
		return userRechargeMapper.selectBybillno(ssn);
	}

}
