package com.fujfu.dao.admin;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.RoleVO;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleVO record);

    int insertSelective(RoleVO record);

    RoleVO selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(RoleVO record);

    int updateByPrimaryKey(RoleVO record);
    
    /**
     * 列出所有角色
     * @return
     */
    List<RoleVO> listAllRole();
    
	/**
     * 分页查询
     * @param page
     * @return
     */
	List<RoleVO> findRole(@Param("role")RoleVO role,@Param("page")Page page);
	
	/**
     * 分页查询总记录数
     * @return
     */
	int countRole(@Param("role")RoleVO role,@Param("page")Page page);
	
	/**
	 * 根据管理员id查询出该管理员未拥有的角色
	 * @param adminId
	 * @return
	 */
	List<RoleVO> findNotOwnRoleByAdminId(@Param("adminId")int adminId);
}