package com.fujfu.service.account;

import java.util.List;

import com.fujfu.common.payment.fuyou.pojo.UserRechargeBean;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.UserRechargeVO;
import com.fujfu.pojo.account.UserRechargeDTO;

/**
 * 充值接口类
 */
public interface RechargeServ {

	/**
	 * 快捷充值
	 * 
	 * @throws Exception
	 * 
	 */
	public UserRechargeBean fastRecharge(UserRechargeBean reqData) throws Exception;

	/**
	 * 网银充值
	 * 
	 * @throws Exception
	 * 
	 */
	public UserRechargeBean webRecharge(UserRechargeBean reqData) throws Exception;

	/**
	 * 条件查询充值记录
	 * 
	 * @return
	 */
	public Page findUserRechargeByCondition(UserRechargeDTO userRechargeQuery, Page page);

	/**
	 * 添加充值记录
	 * 
	 * @param userRechargeQuery
	 * @return
	 */
	public int addUserRecharge(UserRechargeVO userRecharge);

	/**
	 * 更新充值记录
	 * 
	 * @param userRecharge
	 * @return
	 */
	public int updateRecharge(UserRechargeVO userRecharge);

	/**
	 * 根据流水号更新充值记录
	 * 
	 * @return
	 */
	public int updateUserRechargeBySSN(String ssn, String statu);

	/**
	 * 前台账户中心交易明细查询查充值记录
	 * 
	 * @return
	 */
	public int countUserRechargeTradeDetai(UserRechargeDTO userRechargeQuery, Integer userId);

	/**
	 * 投资人前台账户中心交易明细查询查所有
	 * 
	 * @return
	 */
	public int countUserAllTradeDetai(UserRechargeDTO userRechargeQuery, Integer userId);

	/**
	 * 借款人前台账户中心交易明细查询所有
	 * 
	 * @return
	 */
	public int countUserAllTradeDetaiJk(UserRechargeDTO userRechargeQuery, Integer userId);

	/**
	 * 查询最大充值编号
	 * 
	 * @return
	 */
	public String findMaxRechargeNumber(String nowDateStr);

	public List<UserRechargeVO> selectByQueryCondition(UserRechargeDTO userRechargeQuery) throws Exception;

	public UserRechargeVO selectBybillno(String ssn) throws Exception;
}
