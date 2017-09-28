package com.fujfu.service.award.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.award.UsersAwardAccountLogMapper;
import com.fujfu.pojo.award.UsersAwardAccountLogVO;
import com.fujfu.service.award.AwardAccountLogServ;

@Service
public class AwardAccountLogServImpl implements AwardAccountLogServ {
	@Resource
	UsersAwardAccountLogMapper usersAwardAccountLogMapper;	
	@Override
	public Page findAwardAccountLogListByPage( Page page,String mobile) {
		UsersAwardAccountLogVO usersAwardAccountLog = new UsersAwardAccountLogVO();
		usersAwardAccountLog.setMobile(mobile);
		usersAwardAccountLogMapper.findCountAwardLogAccountList(usersAwardAccountLog);
		page.setTotalCount(usersAwardAccountLogMapper.findCountAwardLogAccountList(usersAwardAccountLog));
		page.setItems(usersAwardAccountLogMapper.findAwardAccountLogListByPage(usersAwardAccountLog, page));
		return page;				
	}	
}
