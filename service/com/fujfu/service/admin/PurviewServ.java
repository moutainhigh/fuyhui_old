package com.fujfu.service.admin;

import java.util.List;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.PurviewVO;

public interface PurviewServ {
	/**
	 * 添加权限
	 * @param purview
	 * @return
	 */
	public int addPurview(PurviewVO purview);
	
	/**
	 * 更新权限信息
	 * @param purview
	 * @return
	 */
	public int updatePurview(PurviewVO purview);
	
	/**
	 * 删除权限
	 * @param purviewId
	 * @return
	 */
	public int delPurview(int purviewId);
	
	/**
	 * 条件查询权限
	 * @param page
	 * @return
	 */
	public Page findPurviewByCondition(PurviewVO purview,Page page);
	
	/**
	 * 列出所有权限
	 * @param page
	 * @return
	 */
	public List<PurviewVO> listAllPurview();

	/**
	 * 根据id查权限
	 * @param purviewId
	 * @return
	 */
	public PurviewVO findPurviewById(int purviewId);
	
	/**
	 * 根据roleId查询该角色未拥有的权限
	 * @param roleId
	 * @return
	 */
	public List<PurviewVO> findNotOwnPurviewByRoleId(int roleId);
}
