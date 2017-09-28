package com.fujfu.service.common;

/** 
 * 公共服务接口类
 *
 * @author hjz
 */

public interface CommonServ {
	
	/**	 检查验证码是否正确  */
	public int checkCode(String mobile, String code, String type);
	
	/** 发送短信验证码 */
	public int sendMsg(String mobile, String type);
	
	/** 注册，验证码发送次数 */
	public int regSendTimes(String mobile, String type);
	//站内信
	public int sendRepMsg(String mobile, String type,String str1,String str2,String str3,String str4);
	
	public int sendall(String mobile, String type,String str1,String str2,String str3,String str4);
	//站内信
	public int sendRepMobiMsg(String mobile, String type,String str1,String str2,String str3,String str4);
}
	
	
	
	
	
	
	
	
	
	
	
	
	