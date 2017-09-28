package com.fujfu.service.common.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fujfu.common.util.DateUtil;
import com.fujfu.dao.common.TokenMapper;
import com.fujfu.pojo.common.TokenVO;
import com.fujfu.service.common.TokenServ;

/** 
 * 
 */


@Service
public class TokenServImpl implements TokenServ{

	private Logger log = Logger.getLogger(CommonServImpl.class);
	
	@Autowired
	private TokenMapper mapper;

	@Override
	public boolean isValid(Integer userId) {
		
		TokenVO token = mapper.selectByPrimaryKey(userId);
		if(token != null && token.getLastActivity() > DateUtil.getUnixTime())
		{
			return true;
		} else {
			mapper.deleteByUserId(userId);	
			return false;
		}
	}


	@Override
	public int deleteByUserId(Integer userId) {
		return mapper.deleteByUserId(userId);
	}


	@Override
	public int insert(TokenVO record) {
		return mapper.insert(record);
	}


	@Override
	public int insertSelective(TokenVO record) {
		return mapper.insertSelective(record);
	}


	@Override
	public TokenVO selectByPrimaryKey(Integer userId) {
		return mapper.selectByPrimaryKey(userId);
	}

	@Override
	public int updateByPrimaryKeySelective(TokenVO record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TokenVO record) {
		return mapper.updateByPrimaryKey(record);
	}


	@Override
	public boolean isLogin(Integer userId) {
		TokenVO token = mapper.selectByPrimaryKey(userId);
		if(token != null)
		{
			return true;
		} else {
			return false;
		}
	}
}
	
	
