package com.fujfu.dao.common;

import com.fujfu.pojo.common.TokenVO;

public interface TokenMapper {
    int deleteByUserId(Integer userId);

    int insert(TokenVO record);

    int insertSelective(TokenVO record);

    TokenVO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TokenVO record);

    int updateByPrimaryKey(TokenVO record);
    
    public boolean isValid(String userId);
    
}