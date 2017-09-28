package com.fujfu.service.repay.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.user.UserPayForListMapper;
import com.fujfu.pojo.user.PayForListPOJO;
import com.fujfu.service.repay.UserPayForListServ;


@Service
public class UserPayForListServImpl implements UserPayForListServ {
	
	@Resource
	private UserPayForListMapper userPayForListMapper;	

	@Override
	public Page findPayForListByCondition(PayForListPOJO payForListQueryVo, Page page) {
		// TODO Auto-generated method stub
		page.setTotalCount(userPayForListMapper.countPayForListByCondition(payForListQueryVo, page));
		page.setItems(userPayForListMapper.findPayForListByCondition(payForListQueryVo, page));
		return page;
	}

}
