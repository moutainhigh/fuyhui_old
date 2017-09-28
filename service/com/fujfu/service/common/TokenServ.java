package com.fujfu.service.common;

import com.fujfu.pojo.common.TokenVO;

/** 
 */

public interface TokenServ {
	
	int deleteByUserId(Integer userId);

    int insert(TokenVO record);

    int insertSelective(TokenVO record);

    TokenVO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TokenVO record);

    int updateByPrimaryKey(TokenVO record);
    
    public boolean isValid(Integer userId);
    
    public boolean isLogin(Integer userId);
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	