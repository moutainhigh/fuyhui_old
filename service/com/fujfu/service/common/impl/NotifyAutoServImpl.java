package com.fujfu.service.common.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.common.NotifyAutoMapper;
import com.fujfu.pojo.common.NotifyAutoVO;
import com.fujfu.service.common.NotifyAutoServ;
@Service("notifyAutoSer")
public class NotifyAutoServImpl implements NotifyAutoServ {
	@Resource
	public NotifyAutoMapper notifyAutoMapper;
	@Override
	public int addNotifyAuto(NotifyAutoVO notifyAuto) {
		return notifyAutoMapper.insertSelective(notifyAuto);
	}

	@Override
	public int updateNotifyAuto(NotifyAutoVO notifyAuto) {
		return notifyAutoMapper.updateByPrimaryKeySelective(notifyAuto);
	}

	@Override
	public Page findNotifyAutoByCondition(NotifyAutoVO notifyAuto, Page page) {
		page.setTotalCount(notifyAutoMapper.countNotifyAuto(notifyAuto, page));
		page.setItems(notifyAutoMapper.findNotifyAuto(notifyAuto, page));
		return page;
	}

	@Override
	public NotifyAutoVO findNotifyAutoById(int id) {
		return notifyAutoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int delNotifyAutoById(int id) {
		return notifyAutoMapper.deleteByPrimaryKey(id);
	}

}
