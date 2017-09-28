package com.fujfu.service.account;

import com.fujfu.common.payment.fuyou.pojo.UserWithdrawalBean;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.UserWithdrawalVO;
import com.fujfu.pojo.account.UserWithdrawalDTO;

/**
 * 用户提现接口
 * @author Administrator
 *
 */
public interface WithdrawalServ {

	public UserWithdrawalBean withdrawal(UserWithdrawalBean reqData) throws Exception;
	
	/**
	 * 条件查询提现记录
	 * @param userWithdrawal
	 * @param page
	 * @return
	 */
	public Page findUserWithdrawal(UserWithdrawalDTO userWithdrawalQuery,Page page);
	
	/**
	 * 添加提现记录
	 * @param userWithdrawal
	 * @return
	 */
	public int addUserWithdrawal(UserWithdrawalVO userWithdrawal);
	
	/**
	 * 更新提现记录
	 * @param userWithdrawal
	 * @return
	 */
	public int updateUserWithdrawal(UserWithdrawalVO userWithdrawal);
	
	/**
	 * 根据流水号更新提现记录
	 * @return
	 */
	public int updateUserWithdrawalBySSN(String ssn,String statu);
	
	 public int countUserwithdrawalTradeDetai(UserWithdrawalDTO userWithdrawalQuery,Integer userId);
	 
	 /**
	  * 查询最大提现编号
	  * @return
	  */
	 public String findMaxWithdrawalNumber(String nowDateStr);	
	 public UserWithdrawalVO selectBybillno(String ssn) throws Exception;
}
