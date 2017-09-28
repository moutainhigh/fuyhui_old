package com.fujfu.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujfu.dao.user.UserMapper;
import com.fujfu.pojo.user.UserVO;

/** 
 * 用户找回密码服务类
 *
 * @author huangjizhong
 * @update 2016-3-10
 * @revise huangjizhong <huangjizhong@huangjizhong.com>
 */


@Service
public class UserForgetServ {


	
	@Autowired
	private UserMapper dao;
	
	
	/**
	 * 检查用户名是否存在
	 * @param username - 用户名
	 * @return
	 * 		存在 - 1 <br>
	 * 		不存在 - 0
	 */
	public int checkUserExist(String username) {
		int existUser = dao.checkUserExist(username);
		return existUser;
	}
	
	
	/**
	 * 检查用户名与手机是否匹配
	 * @param mobile - 手机
	 * @param username - 用户名
	 * @return
	 * 		匹配 - 0 <br>
	 * 		不匹配 - 1
	 */
	public int checkUserMatchMobile(String mobile, String username) {
		int match = dao.checkUserMatchMobile(mobile, username);
		return match == 0 ? 1 : 0;
	}
	
	
	/**
	 * update password
	 * 
	 */
	public void updatePassword(UserVO bean) {
		dao.updatePassword(bean);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	