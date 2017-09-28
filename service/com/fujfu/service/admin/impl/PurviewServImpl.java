package com.fujfu.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.admin.PurviewMapper;
import com.fujfu.pojo.admin.PurviewVO;
import com.fujfu.service.admin.PurviewServ;
@Service("purviewSer")
public class PurviewServImpl implements PurviewServ{
	@Resource
	public PurviewMapper purviewMapper;
	@Override
	public int addPurview(PurviewVO purview) {
		return purviewMapper.insertSelective(purview);
	}

	@Override
	public int updatePurview(PurviewVO purview) {
		return purviewMapper.updateByPrimaryKeySelective(purview);
	}

	@Override
	public int delPurview(int purviewId) {
		return purviewMapper.deleteByPrimaryKey(purviewId);
	}

	@Override
	public Page findPurviewByCondition(PurviewVO purview,Page page) {
		page.setTotalCount(purviewMapper.countPurview(purview, page));
		page.setItems(purviewMapper.findPurview(purview, page));
		return page;
	}

	@Override
	public PurviewVO findPurviewById(int purviewId) {
		return purviewMapper.selectByPrimaryKey(purviewId);
	}

	@Override
	public List<PurviewVO> listAllPurview() {
		return purviewMapper.listAllPurview();
	}
	
	@Override
	public List<PurviewVO> findNotOwnPurviewByRoleId(int roleId) {
		return purviewMapper.findNotOwnPurviewByRoleId(roleId);
	}
}
