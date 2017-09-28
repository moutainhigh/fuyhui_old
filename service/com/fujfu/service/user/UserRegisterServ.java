package com.fujfu.service.user;

import com.fujfu.pojo.user.UserVO;

/** 
 * 用户注册服务类
 *
 * @author hjz
 * @update 2016-8-5
 */


public interface UserRegisterServ {

	/** 用户注册 */
	public int userRegister(UserVO bean);
	
	
	/** 检查用户名是否存在 */
	public int checkUsername(String username);
	
	
	/** 检查手机号码是否存 在 */
	public int checkMobile(String mobile);
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	