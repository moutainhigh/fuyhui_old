package com.fujfu.service.award.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.award.AwardLogMapper;
import com.fujfu.pojo.award.AwardLogVO;
import com.fujfu.service.award.AwardLogServ;
@Service("awardLogSer")
public class AwardLogServImpl implements AwardLogServ {
	@Resource
	public AwardLogMapper awardLogMapper;
	@Override
	public int addAwardLog(AwardLogVO awardLog) {
		return awardLogMapper.insertSelective(awardLog);
	}

	@Override
	public int updateAwardLog(AwardLogVO awardLog) {
		return awardLogMapper.updateByPrimaryKeySelective(awardLog);
	}

	@Override
	public int delAwardLog(int awardLogId) {
		return awardLogMapper.deleteByPrimaryKey(awardLogId);
	}

	@Override
	public Page findAwardLogByCondition(AwardLogVO awardLog, Page page) {
		page.setTotalCount(awardLogMapper.countAwardLog(awardLog));
		page.setItems(awardLogMapper.findAwardLog(awardLog, page));
		return page;
	}

}
