package com.fujfu.service.account;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.SiteAccountLogVO;

public interface SiteAccountLogServ {
	public int addSiteAccountLog(SiteAccountLogVO siteAccountLog);
	public int updateSiteAccountLog(SiteAccountLogVO siteAccountLog);
	public Page findSiteAccountLog(int feeId,Page page);
}
