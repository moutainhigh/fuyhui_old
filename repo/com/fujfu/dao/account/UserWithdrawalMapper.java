package com.fujfu.dao.account;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.UserWithdrawalVO;
import com.fujfu.pojo.account.UserWithdrawalDTO;
import com.fujfu.pojo.account.UserWithdrawalPOJO;

public interface UserWithdrawalMapper {
    int deleteByPrimaryKey(Integer withdrawalId);

    int insert(UserWithdrawalVO record);

    int insertSelective(UserWithdrawalVO record);

    UserWithdrawalVO selectByPrimaryKey(Integer withdrawalId);

    int updateByPrimaryKeySelective(UserWithdrawalVO record);

    int updateByPrimaryKey(UserWithdrawalVO record);

	int countUserWithdeawal(@Param("userWithdrawalQuery")UserWithdrawalDTO userWithdrawalQuery);

	List<UserWithdrawalPOJO> findUserWithdeawal(@Param("userWithdrawalQuery")UserWithdrawalDTO userWithdrawalQuery, @Param("page")Page page);

	int updateUserWithdrawalBySSN(@Param("ssn")String ssn,@Param("statu")String statu);
	
	int countUserwithdrawalTradeDetai(@Param("userWithdrawalQuery")UserWithdrawalDTO userWithdrawalQuery,@Param("userId") Integer userId);
	
	/**
	 * 查询fu_user_withdrawal表的最大withdrawal_number记录
	 * @param RechargeNumber
	 * @return
	 */
	String findMaxWithdrawalNumber(@Param("nowDateStr")String nowDateStr);
	
	UserWithdrawalVO selectBybillno(@Param("ssn")String ssn);
}