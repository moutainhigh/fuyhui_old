package com.fujfu.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujfu.dao.user.UserMapper;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.user.UserLoginServ;
/** 
 * 用户登录服务类
 *
 * @author huangjizhong
 * @update 2016-3-10
 * @revise huangjizhong <huangjizhong@huangjizhong.com>
 */


@Service
public class UserLoginServImpl implements UserLoginServ {

	
	@Autowired
	private UserMapper dao;
	
	/**
	 * 检查用户和密码是否正确
	 * @param username - 用户名
	 * @param password - 密码
	 * @return
	 * 		User
	 */
	@Override
	public UserVO userLogin(String username,String password) {
		UserVO user = dao.userLogin(username, password);
		return user;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	