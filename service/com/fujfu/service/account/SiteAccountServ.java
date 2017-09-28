package com.fujfu.service.account;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.SiteAccountVO;

public interface SiteAccountServ {
	public int addSiteAccount(SiteAccountVO siteAccount);
	public int updateSiteAccount(SiteAccountVO siteAccount);
	public Page findSiteAccount(Page page);
	public SiteAccountVO findSiteAccountByFeeName(String feeName);
	public SiteAccountVO findSiteAccountByFeeId(Integer feeId);
}
