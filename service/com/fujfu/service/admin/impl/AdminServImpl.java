package com.fujfu.service.admin.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.admin.AdminMapper;
import com.fujfu.pojo.admin.AdminVO;
import com.fujfu.service.admin.AdminServ;

@Service("adminSer")
public class AdminServImpl implements AdminServ{
	@Resource
	public AdminMapper adminMapper;
	@Override
	public int addAdmin(AdminVO admin) {
		return adminMapper.insertSelective(admin);
	}

	@Override
	public int updateAdmin(AdminVO admin) {
		return adminMapper.updateByPrimaryKeySelective(admin);
	}

	@Override
	public int delAdmin(int adminId) {
		return adminMapper.deleteByPrimaryKey(adminId);
	}

	@Override
	public AdminVO adminLogin(AdminVO admin) {
		return adminMapper.adminLogin(admin);
	}

	@Override
	public Page findAdminByCondition(AdminVO admin,Page page) {
		page.setTotalCount(adminMapper.countAdmin(admin,page));
		page.setItems(adminMapper.findAdmin(admin,page));
		return page;
	}

	@Override
	public AdminVO findAdminById(int adminId) {
		return adminMapper.selectByPrimaryKey(adminId);
	}

	@Override
	@Transactional
	public void addtest(AdminVO admin1) {
		adminMapper.insertSelective(admin1);
		throw new RuntimeException("test");
	}

	@Override
	public int CoutAdminByCondition(AdminVO admin, Page page) {
		// TODO Auto-generated method stub
		return adminMapper.countAdmin(admin,page);
	}
}
