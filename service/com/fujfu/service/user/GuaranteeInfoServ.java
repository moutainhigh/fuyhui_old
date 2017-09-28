package com.fujfu.service.user;


import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.LoanInvestPOJO;

/** 
 * 用户担保信息服务类
 *
 * @author huangf
 * @update 2016-12-10
 * @revise 
 */
public interface GuaranteeInfoServ {
	/**
	 * 担保记录查询
	 * @param
	 * @param 
	 * @return
	 * 		
	 */
	public Page findGuaranteeByVo(LoanInvestPOJO loanInvestQueryVo,Page page);
}
	
	
	
	
	
	
	
	
	
	
	
	
	