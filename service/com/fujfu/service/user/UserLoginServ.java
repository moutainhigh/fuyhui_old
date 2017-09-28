package com.fujfu.service.user;

import com.fujfu.pojo.user.UserVO;

/** 
 * 用户登录服务类
 *
 * @author huangjizhong
 * @update 2016-3-10
 * @revise huangjizhong <huangjizhong@huangjizhong.com>
 */
public interface UserLoginServ {
	/**
	 * 用户登录
	 * @param username - 用户名
	 * @param password - 密码
	 * @return
	 * 		User
	 */
	public UserVO userLogin(String username,String password);
}
	
	
	
	
	
	
	
	
	
	
	
	
	