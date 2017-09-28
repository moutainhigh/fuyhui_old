package com.fujfu.dao.account;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.UserRechargeVO;
import com.fujfu.pojo.account.UserRechargeDTO;
import com.fujfu.pojo.account.UserRechargePOJO;

public interface UserRechargeMapper {
    int deleteByPrimaryKey(Integer rechargeId);

    int insert(UserRechargeVO record);

    int insertSelective(UserRechargeVO record);

    UserRechargeVO selectByPrimaryKey(Integer rechargeId);

    int updateByPrimaryKeySelective(UserRechargeVO record);

    int updateByPrimaryKey(UserRechargeVO record);

	int countUserRecharge(@Param("userRechargeQuery")UserRechargeDTO userRechargeQuery);

	List<UserRechargePOJO> findUserRecharge(@Param("userRechargeQuery")UserRechargeDTO userRechargeQuery, @Param("page")Page page);

	int updateUserRechargeBySSN(@Param("ssn")String ssn,@Param("statu")int statu);
	int countUserRechargeTradeDetai(@Param("userRechargeQuery")UserRechargeDTO userRechargeQuery,@Param("userId") Integer userId);
	int countUserAllTradeDetai(@Param("userRechargeQuery")UserRechargeDTO userRechargeQuery,@Param("userId") Integer userId);
	//借款人前台交易明细查所有
	int countUserAllTradeDetaiJk(@Param("userRechargeQuery")UserRechargeDTO userRechargeQuery,@Param("userId") Integer userId);

	/**
	 * 查询fu_user_recharge表的最大RechargeNumber记录
	 * @param RechargeNumber
	 * @return
	 */
	String findMaxRechargeNumber(@Param("nowDateStr")String nowDateStr);
	
	List<UserRechargeVO> selectByQueryCondition(@Param("userRechargeQuery")UserRechargeDTO userRechargeQuery);
	
	UserRechargeVO selectBybillno(@Param("ssn")String ssn);
}