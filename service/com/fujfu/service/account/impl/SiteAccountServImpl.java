package com.fujfu.service.account.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.account.SiteAccountMapper;
import com.fujfu.pojo.account.SiteAccountVO;
import com.fujfu.service.account.SiteAccountServ;
@Service("siteAccountSer")
public class SiteAccountServImpl implements SiteAccountServ {
	@Resource
	private SiteAccountMapper siteAccountMapper;
	@Override
	public int addSiteAccount(SiteAccountVO siteAccount) {
		return siteAccountMapper.insertSelective(siteAccount);
	}

	@Override
	public int updateSiteAccount(SiteAccountVO siteAccount) {
		return siteAccountMapper.updateByPrimaryKeySelective(siteAccount);
	}

	@Override
	public Page findSiteAccount(Page page) {
		page.setTotalCount(siteAccountMapper.countSiteAccount());
		page.setItems(siteAccountMapper.findSiteAccount(page));
		return page;
	}

	@Override
	public SiteAccountVO findSiteAccountByFeeName(String feeName) {
		return siteAccountMapper.findSiteAccountByFeeName(feeName);
	}
	@Override
	public SiteAccountVO findSiteAccountByFeeId(Integer feeId) {
		return siteAccountMapper.findSiteAccountByFeeId(feeId);
	}
}
