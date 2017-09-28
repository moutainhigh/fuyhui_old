package com.fujfu.service.focus.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.focus.FocusPicMapper;
import com.fujfu.pojo.focus.FocusPicVO;
import com.fujfu.service.focus.FocusPicServ;

@Service
public class FocusPicServImpl implements FocusPicServ {
	@Resource
	public FocusPicMapper focusPicMapper;

	@Override
	public Page findFocusPicByCondition(FocusPicVO focusPic, Page page) {
		page.setTotalCount(focusPicMapper.countFocusPic(focusPic, page));
		page.setItems(focusPicMapper.findFocusPic(focusPic, page));
		return page;
	}

	@Override
	public int add(FocusPicVO focusPic) {
		return focusPicMapper.insertSelective(focusPic);
	}

	@Override
	public int update(FocusPicVO focusPic) {
		return focusPicMapper.updateByPrimaryKeySelective(focusPic);
	}

	@Override
	public FocusPicVO getFocusPicById(Integer id) {
		return focusPicMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<FocusPicVO> findBannerByDevice(Integer displayDevice) {
		return focusPicMapper.findBannerByDevice(displayDevice);
	}
	
}
 