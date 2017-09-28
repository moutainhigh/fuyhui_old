package com.fujfu.service.award.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.award.AwardTypeMapper;
import com.fujfu.pojo.award.AwardTypeVO;
import com.fujfu.service.award.AwardTypeServ;
@Service("awardTypeSer")
public class AwardTypeServImpl implements AwardTypeServ {
	@Resource
	public AwardTypeMapper awardTypeMapper;
	@Override
	public int addAwardType(AwardTypeVO awardType) {
		return awardTypeMapper.insertSelective(awardType);
	}

	@Override
	public int updateAwardType(AwardTypeVO awardType) {
		return awardTypeMapper.updateByPrimaryKeySelective(awardType);
	}

	@Override
	public int delAwardType(int awardTypeId) {
		return awardTypeMapper.deleteByPrimaryKey(awardTypeId);
	}

	@Override
	public Page findAwardTypeByCondition(AwardTypeVO awardType, Page page) {
		page.setTotalCount(awardTypeMapper.countAwardType(awardType));
		page.setItems(awardTypeMapper.findAwardType(awardType, page));
		return page;
	}

}
