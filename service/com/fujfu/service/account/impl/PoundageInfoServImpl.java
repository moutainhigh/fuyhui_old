package com.fujfu.service.account.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.dao.account.PoundageInfoMapper;
import com.fujfu.pojo.account.PoundageInfoVO;
import com.fujfu.service.account.PoundageInfoServ;

/** 
 * 手续费服务类-实现类
 * @author huangf
 */


@Service("PoundageInfoSer")
public class PoundageInfoServImpl implements PoundageInfoServ{
	@Resource
	private PoundageInfoMapper poundageInfoMapper;

	@Override
	public int addPoundageInfo(PoundageInfoVO poundageInfo) {
		return poundageInfoMapper.insertSelective(poundageInfo);		
	}

	@Override
	public PoundageInfoVO selectByPrimaryTxnSsn(String txnSsn) {
		// TODO Auto-generated method stub
		return poundageInfoMapper.selectByPrimaryTxnSsn(txnSsn);
	}

}
	
	