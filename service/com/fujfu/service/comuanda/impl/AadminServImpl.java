package com.fujfu.service.comuanda.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.dao.comuanda.AadminMapper;
import com.fujfu.pojo.comuanda.AadminVO;
import com.fujfu.service.comuanda.AadminServ;
@Service("aadminSer")
public class AadminServImpl implements AadminServ{
	@Resource
	public AadminMapper aadminMapper;
	@Override
	public int addAadmin(AadminVO aadmin) {
		return aadminMapper.insertSelective(aadmin);
	}

	@Override
	public int updateAadmin(AadminVO aadmin) {
		return aadminMapper.updateByPrimaryKeySelective(aadmin);
	}

	@Override
	public int delAadmin(int aadminId) {
		return aadminMapper.deleteByPrimaryKey(aadminId);
	}

	@Override
	public AadminVO findAadminById(int aadminId) {
		return aadminMapper.selectByPrimaryKey(aadminId);
	}

}
