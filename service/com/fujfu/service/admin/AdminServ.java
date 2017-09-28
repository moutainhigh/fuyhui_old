package com.fujfu.service.admin;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.AdminVO;

public interface AdminServ {
	/**
	 * 添加管理员
	 * @param admin
	 * @return
	 */
	public int addAdmin(AdminVO admin);
	
	/**
	 * 更新管理员信息
	 * @param admin
	 * @return
	 */
	public int updateAdmin(AdminVO admin);
	
	/**
	 * 根据id删除管理员
	 * @param adminId
	 * @return
	 */
	public int delAdmin(int adminId);
	
	/**
	 * 管理员后台登录
	 * @param admin
	 * @return
	 */
	public AdminVO adminLogin(AdminVO admin);
	
	/**
	 * 条件查询管理员
	 * @return
	 */
	public Page findAdminByCondition(AdminVO admin,Page page);
	
	/**
	 * 根据id查询管理员信息
	 * @param adminId
	 * @return
	 */
	public AdminVO findAdminById(int adminId);
	
	public void addtest(AdminVO admin1);
	
	public int CoutAdminByCondition(AdminVO admin,Page page);
}
