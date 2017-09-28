package com.fujfu.service.award.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.award.UsersAwardAccountMapper;
import com.fujfu.pojo.award.UsersAwardAccountVO;
import com.fujfu.service.award.AwardAccountServ;

@Service
public class AwardAccountServImpl implements AwardAccountServ {
	
	@Resource
	UsersAwardAccountMapper usersAwardAccountMapper;	
	@Override
	public Page findAwardAccountListByPage(Page page,String mobile) {
		UsersAwardAccountVO usersAwardAccount = new UsersAwardAccountVO();
		usersAwardAccount.setMobile(mobile);
		page.setTotalCount(usersAwardAccountMapper.findCountAwardAccountList(usersAwardAccount));
		page.setItems(usersAwardAccountMapper.findAwardAccountListByPage(usersAwardAccount, page));
		return page;		
	}
}
