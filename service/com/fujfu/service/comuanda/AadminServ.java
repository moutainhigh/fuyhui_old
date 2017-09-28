package com.fujfu.service.comuanda;

import com.fujfu.pojo.comuanda.AadminVO;

public interface AadminServ {
	/**
	 * 添加管理员
	 * @param aadmin
	 * @return
	 */
	public int addAadmin(AadminVO aadmin);
	/**
	 * 更新管理员信息
	 * @param aadmin
	 * @return
	 */
	public int updateAadmin(AadminVO aadmin);
	/**
	 * 根据id删除管理员
	 * @param adminId
	 * @return
	 */
	public int delAadmin(int adminId);
	/**
	 * 根据id查询管理员信息
	 * @param adminId
	 * @return
	 */
	public AadminVO findAadminById(int adminId);
}
