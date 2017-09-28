package com.fujfu.service.user.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fujfu.dao.user.UserMapper;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.user.UserRegisterServ;


/** 
 * 用户注册服务类
 *
 * @author hjz
 * @update 2016-8-5
 */


@Service
public class UserRegisterServImpl implements UserRegisterServ {

	private Logger log = Logger.getLogger(UserRegisterServ.class);
	
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int userRegister(UserVO bean) {
		return userMapper.insertSelective(bean);
	}
	
	
	/**
	 * 检查用户名是否存在
	 * @param username - 用户名
	 * @return
	 * 		存在 - 1 <br>
	 * 		不存在 - 0
	 */
	@Override
	public int checkUsername(String username) {
		//log.info("username = "+username);
		int existUser = userMapper.checkUsername(username);
		return existUser;
	}
	
	
	/**
	 * 检查手机号码是否存在
	 * @param mobile - 手机号码
	 * @return
	 * 		存在 - 1 <br>
	 * 		不存在 - 0
	 */
	@Override
	public int checkMobile(String mobile) {
		int existMobile = userMapper.checkMobile(mobile);
		return existMobile;
	}

}
	