package com.fujfu.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.admin.RoleAdminMapper;
import com.fujfu.dao.admin.RoleMapper;
import com.fujfu.dao.admin.RolePurviewMapper;
import com.fujfu.pojo.admin.RoleVO;
import com.fujfu.pojo.admin.RoleAdminVO;
import com.fujfu.pojo.admin.RoleAdminPOJO;
import com.fujfu.pojo.admin.RolePurviewVO;
import com.fujfu.pojo.admin.RolePurviewPOJO;
import com.fujfu.service.admin.RoleServ;
@Service("roleSer")
public class RoleServImpl implements RoleServ{
	@Resource
	public RoleMapper roleMapper;
	
	@Resource
	public RoleAdminMapper roleAdminMapper;
	
	@Resource
	public RolePurviewMapper rolePurviewMapper;
	
	@Override
	public int addRole(RoleVO role) {
		return roleMapper.insertSelective(role);
	}

	@Override
	public int updateRole(RoleVO role) {
		return roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public int delAdmin(int roleId) {
		return roleMapper.deleteByPrimaryKey(roleId);
	}

	@Override
	public Page findRoleByCondition(RoleVO role,Page page) {
		page.setTotalCount(roleMapper.countRole(role, page));
		page.setItems(roleMapper.findRole(role,page));
		return page;
	}

	@Override
	public int addRoleAdmin(RoleAdminVO roleAdmin) {
		return roleAdminMapper.insertSelective(roleAdmin);
	}

	@Override
	public int updateRoleAdmin(RoleAdminVO roleAdmin) {
		return roleAdminMapper.updateByPrimaryKeySelective(roleAdmin);
	}

	@Override
	public int delRoleAdmin(int roleAdminId) {
		return roleAdminMapper.deleteByPrimaryKey(roleAdminId);
	}

	@Override
	public Page findRoleByAdminId(int adminId,Page page) {
		page.setTotalCount(roleAdminMapper.countRoleByAdminId(adminId));
		page.setItems(roleAdminMapper.findRoleByAdminId(adminId, page));
		return page;
	}

	@Override
	public int addRolePurview(RolePurviewVO rolePurview) {
		return rolePurviewMapper.insertSelective(rolePurview);
	}

	@Override
	public int updateRolePurview(RolePurviewVO rolePurView) {
		return rolePurviewMapper.updateByPrimaryKeySelective(rolePurView);
	}

	@Override
	public int delRolePurview(int rolePurViewId) {
		return rolePurviewMapper.deleteByPrimaryKey(rolePurViewId);
	}

	@Override
	public Page findPurviewByRoleId(int roleId,Page page) {
		page.setTotalCount(rolePurviewMapper.countPurviewByRoleId(roleId));
		page.setItems(rolePurviewMapper.findPurviewByRoleId(roleId, page));
		return page;
	}

	@Override
	public RoleVO findRoleById(int roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public RoleAdminPOJO findRoleAdminVoById(int id) {
		return roleAdminMapper.findRoleAdminVoById(id);
	}

	@Override
	public RolePurviewPOJO findRolePurviewVoById(int id) {
		return rolePurviewMapper.findRolePurviewVoById(id);
	}

	@Override
	public List<RolePurviewVO> findPurviewIdByRoleId(int roleId) {
		return rolePurviewMapper.findPurviewIdByRoleId(roleId);
	}

	@Override
	public List<RoleVO> listAllRole() {
		return roleMapper.listAllRole();
	}

	@Override
	public List<RoleVO> findNotOwnRoleByAdminId(int adminId) {
		return roleMapper.findNotOwnRoleByAdminId(adminId);
	}

}
