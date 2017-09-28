package com.fujfu.service.admin.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.admin.SidemenuMapper;
import com.fujfu.pojo.admin.SidemenuVO;
import com.fujfu.service.admin.SidemenuServ;
@Service("sidemenuSer")
public class SidemenuServImpl implements SidemenuServ {
	@Resource
	public SidemenuMapper sidemenuMapper;
	@Override
	public int addSidemenu(SidemenuVO sidemenu) {
		return sidemenuMapper.insert(sidemenu);
	}

	@Override
	public int updateSidemenu(SidemenuVO sidemenu) {
		return sidemenuMapper.updateByPrimaryKey(sidemenu);
	}

	@Override
	public int delSidemenu(int sidemenuId) {
		return sidemenuMapper.deleteByPrimaryKey(sidemenuId);
	}

	@Override
	public Page listAllsidemenu(Page page) {
		page.setTotalCount(sidemenuMapper.countSidemenu());
		page.setItems(sidemenuMapper.listAllSidemenu(page));
		return page;
	}
	
}
