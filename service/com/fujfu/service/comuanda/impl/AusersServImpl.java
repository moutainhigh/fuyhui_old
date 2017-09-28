package com.fujfu.service.comuanda.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.dao.comuanda.AusersMapper;
import com.fujfu.pojo.comuanda.AusersVO;
import com.fujfu.service.comuanda.AusersServ;
@Service("ausersSer")
public class AusersServImpl implements AusersServ {
	@Resource
	public AusersMapper ausersMapper;
	@Override
	public int addAusers(AusersVO ausers) {
		return ausersMapper.insertSelective(ausers);
	}

	@Override
	public int updateAusers(AusersVO ausers) {
		return ausersMapper.updateByPrimaryKeySelective(ausers);
	}

	@Override
	public int delAusers(int userId) {
		return ausersMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public AusersVO findAusers(int userId) {
		return ausersMapper.selectByPrimaryKey(userId);
	}

	@Override
	public AusersVO getAuserByMobile(String mobile) {
		return ausersMapper.getAuserByMobile(mobile);
	}
	@Override
	public AusersVO getAuserByUserName(String username) {
		return ausersMapper.getAuserByUserName(username);
	}

}
