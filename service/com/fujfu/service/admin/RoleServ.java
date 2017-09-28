package com.fujfu.service.admin;

import java.util.List;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.RoleVO;
import com.fujfu.pojo.admin.RoleAdminVO;
import com.fujfu.pojo.admin.RoleAdminPOJO;
import com.fujfu.pojo.admin.RolePurviewVO;
import com.fujfu.pojo.admin.RolePurviewPOJO;

public interface RoleServ {
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public int addRole(RoleVO role);
	
	/**
	 * 更新角色信息
	 * @param role
	 * @return
	 */
	public int updateRole(RoleVO role);
	
	/**
	 * 根据id删除角色
	 * @param roleId
	 * @return
	 */
	public int delAdmin(int roleId);
	
	/**
	 * 条件查询角色信息
	 * @param page
	 * @return
	 */
	public Page findRoleByCondition(RoleVO role,Page page);
	
	/**
	 * 列出所有角色
	 * @param page
	 * @return
	 */
	public List<RoleVO> listAllRole();
	
	/**
	 * 根据id查找角色信息
	 * @param roleId
	 * @return
	 */
	public RoleVO findRoleById(int roleId);
	
	/**>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
	/**
	 * 根据管理员id查询出该管理员未拥有的角色
	 * @param adminId
	 * @return
	 */
	public List<RoleVO> findNotOwnRoleByAdminId(int adminId);
	
	/**
	 * 添加管理员角色
	 * @param roleAdmin
	 * @return
	 */
	public int addRoleAdmin(RoleAdminVO roleAdmin);
	
	/**
	 * 更新管理员角色
	 * @param roleAdmin
	 * @return
	 */
	public int updateRoleAdmin(RoleAdminVO roleAdmin);
	
	/**
	 * 删除管理员角色
	 * @param roleAdminId
	 * @return
	 */
	public int delRoleAdmin(int roleAdminId);
	
	/**
	 * 根据管理员id列出角色
	 * @return
	 */
	public Page findRoleByAdminId(int adminId,Page page);
	
	/**
	 * 根据管理员id查询角色
	 * @param id
	 * @return
	 */
	public RoleAdminPOJO findRoleAdminVoById(int id);
	
	/**>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>/*
	/**
	 * 添加角色权限
	 * @param rolePurview
	 * @return
	 */
	public int addRolePurview(RolePurviewVO rolePurview);
	
	/**
	 * 更新角色权限
	 * @param rolePurView
	 * @return
	 */
	public int updateRolePurview(RolePurviewVO rolePurView);
	
	/**
	 * 删除角色权限
	 * @param rolePurViewId
	 * @return
	 */
	public int delRolePurview(int rolePurViewId);
	
	/**
	 * 根据角色id查询角色权限
	 * @param page
	 * @return
	 */
	public Page findPurviewByRoleId(int roleId,Page page);
	
	/**
	 * 根据id查询角色权限
	 * @param id
	 * @return
	 */
	public RolePurviewPOJO findRolePurviewVoById(int id);
	
	/**
	 * 根据角色id查找权限
	 * @param roleId
	 * @return
	 */
	public List<RolePurviewVO> findPurviewIdByRoleId(int roleId);
	
}
