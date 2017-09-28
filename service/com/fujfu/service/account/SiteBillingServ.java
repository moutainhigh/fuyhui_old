package com.fujfu.service.account;

import java.math.BigDecimal;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.SiteBillingDTO;
import com.fujfu.pojo.user.UserVO;

/**
 * 充值接口类
 */
public interface SiteBillingServ {
	public int addSiteBilling(UserVO OutUser,UserVO inUser,String fySerialno,BigDecimal amt,String siteBusiType,String siteBusiRem,String message);
	public int updateBusiStatus(Integer statu,String ssn);
	
	/**
	 * 条件查询平台账单信息
	 * 
	 * @return
	 */
	public Page findSiteBillingByCondition(SiteBillingDTO siteBillingQueryVo, Page page);
	
}
