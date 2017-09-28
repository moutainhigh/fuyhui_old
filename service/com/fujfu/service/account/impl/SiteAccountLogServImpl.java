package com.fujfu.service.account.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.account.SiteAccountLogMapper;
import com.fujfu.pojo.account.SiteAccountLogVO;
import com.fujfu.service.account.SiteAccountLogServ;
@Service("siteAccountLogSer")
public class SiteAccountLogServImpl implements SiteAccountLogServ {
	@Resource
	private SiteAccountLogMapper siteAccountLogMapper;
	@Override
	public int addSiteAccountLog(SiteAccountLogVO siteAccountLog) {
		return siteAccountLogMapper.insertSelective(siteAccountLog);
	}

	@Override
	public int updateSiteAccountLog(SiteAccountLogVO siteAccountLog) {
		return siteAccountLogMapper.updateByPrimaryKeySelective(siteAccountLog);
	}

	@Override
	public Page findSiteAccountLog(int feeId,Page page) {
		page.setTotalCount(siteAccountLogMapper.countSiteAccountLog(feeId));
		page.setItems(siteAccountLogMapper.findSiteAccountLog(feeId,page));
		return page;
	}

}
