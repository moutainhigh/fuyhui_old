package com.fujfu.service.account.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujfu.dao.account.UserAccountLogMapper;
import com.fujfu.pojo.account.UserAccountLogVO;
import com.fujfu.pojo.account.UserAccountLogPOJO;
import com.fujfu.service.account.UserAccountLogServ;

/**
 * 用户账户接口实现类
 */
@Service
public class UserAccountLogServImpl implements UserAccountLogServ {

	@Autowired
	private UserAccountLogMapper mapper;

	@Override
	public int insert(UserAccountLogVO record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(UserAccountLogVO record) {
		return mapper.insertSelective(record);
	}

	@Override
	public UserAccountLogVO selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAccountLogVO> findUserAllUserAccountLog(UserAccountLogPOJO userAccountLogQuery, int pageNum) {
		// TODO Auto-generated method stub
		return mapper.findUserAllUserAccountLog(userAccountLogQuery, 7*(pageNum-1));
	}

	@Override
	public int countUseAccountLog(UserAccountLogPOJO userAccountLogQuery) {
		// TODO Auto-generated method stub
		return mapper.countUseAccountLog(userAccountLogQuery);
	} 
	
	@Override
	public int updateByApplyId(Integer applyId, Integer status, Integer type) {
		// TODO Auto-generated method stub
		return mapper.updateByApplyId(status, applyId, type);
	}
	 /**
	  * 查询最大编号
	  * @return
	  */

	@Override
	public String findMaxBusiNumber(String nowDateStr) {
		// TODO Auto-generated method stub
		return mapper.findMaxBusiNumber(nowDateStr);
	}

	@Override
	public String findSumMoneyBy(UserAccountLogPOJO userAccountLogQuery) {
		// TODO Auto-generated method stub
		return mapper.findSumMoneyBy(userAccountLogQuery);
	}
		 
	
}
