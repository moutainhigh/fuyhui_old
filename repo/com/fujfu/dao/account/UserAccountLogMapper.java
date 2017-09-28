package com.fujfu.dao.account;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.pojo.account.UserAccountLogVO;
import com.fujfu.pojo.account.UserAccountLogPOJO;

public interface UserAccountLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAccountLogVO record);

    int insertSelective(UserAccountLogVO record);

    UserAccountLogVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAccountLogVO record);

    int updateByPrimaryKey(UserAccountLogVO record);
    
  //前台查询交易记录
  	List<UserAccountLogVO> findUserAllUserAccountLog(@Param("userAccountLogQuery")UserAccountLogPOJO userAccountLogQuery, @Param("pageNum") int pageNum);
  	int countUseAccountLog(@Param("userAccountLogQuery")UserAccountLogPOJO userAccountLogQuery);
  	int updateByApplyId(@Param("status") Integer status,@Param("applyId") Integer applyId,@Param("type") Integer type);
  	
  	/**
	 * 查询fu_user_account_log表的最大BusiNumber记录
	 * @param BusiNumber
	 * @return
	 */
	String findMaxBusiNumber(@Param("nowDateStr")String nowDateStr);
	
	String findSumMoneyBy(@Param("userAccountLogQuery")UserAccountLogPOJO userAccountLogQuery);
    
}