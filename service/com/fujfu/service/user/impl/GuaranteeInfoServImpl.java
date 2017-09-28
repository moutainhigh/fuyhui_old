package com.fujfu.service.user.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.user.GuaranteeInfoMapper;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.service.user.GuaranteeInfoServ;

/** 
 * 用户担保信息服务类
 *
 * @author huangf
 * @update 2016-12-10
 * @revise 
 */
@Service
public class GuaranteeInfoServImpl implements GuaranteeInfoServ{
	/**
	 * 担保记录查询
	 * @param
	 * @param 
	 * @return
	 * 		
	 */
	@Resource
	private GuaranteeInfoMapper guaranteeInfoMapper;
	@Override
	public Page findGuaranteeByVo(LoanInvestPOJO loanInvestQueryVo,Page page) {
		page.setItems(guaranteeInfoMapper.findGuaranteeInfo(loanInvestQueryVo, page));
		page.setTotalCount(guaranteeInfoMapper.countGuaranteeInfo(loanInvestQueryVo, page));
		return page;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	