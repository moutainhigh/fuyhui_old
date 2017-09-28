package com.fujfu.service.comuanda;

import com.fujfu.pojo.comuanda.AusersVO;

public interface AusersServ {
	/**
	 * 添加用户
	 * @param ausers
	 * @return
	 */
	public int addAusers(AusersVO ausers);
	/**
	 * 更新用户
	 * @param ausers
	 * @return
	 */
	public int updateAusers(AusersVO ausers);
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	public int delAusers(int userId);
	/**
	 * 根据id查询用户信息
	 * @param userId
	 * @return
	 */
	public AusersVO findAusers(int userId);
	
	/**
	 * 根据用户手机号查询用户信息
	 * 
	 * @param mobile
	 * @return
	 */
	public AusersVO getAuserByMobile(String mobile);
	/**
	 * 根据用户名查询用户信息
	 * 
	 * @param username
	 * @return
	 */
	public AusersVO getAuserByUserName(String username); 
}
