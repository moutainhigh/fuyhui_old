package com.fujfu.dao.comuanda;

import org.apache.ibatis.annotations.Param;

import com.fujfu.pojo.comuanda.AusersVO;

public interface AusersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(AusersVO record);

    int insertSelective(AusersVO record);

    AusersVO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(AusersVO record);

    int updateByPrimaryKey(AusersVO record);

	AusersVO getAuserByMobile(@Param(value = "mobile")String mobile);
	AusersVO getAuserByUserName(@Param(value = "username")String username);
}