package com.fujfu.service.account.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.payment.fuyou.FyReportMgt;
import com.fujfu.common.payment.fuyou.pojo.RechargeReportBean;
import com.fujfu.common.payment.fuyou.pojo.response.RechargeReportResp;
import com.fujfu.dao.account.UserAccountMapper;
import com.fujfu.service.account.FyReportServ;

/**
 * 用户账户接口实现类
 */
@Service("FyReportSer")
public class FyReportServImpl implements FyReportServ {

	@Resource
	private UserAccountMapper mapper;

	@Override
	public RechargeReportResp rechargeReport(RechargeReportBean reqData) {
		// TODO Auto-generated method stub
		RechargeReportResp respData = new RechargeReportResp();
		try {
			respData=FyReportMgt.recharge(reqData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return respData;
	} 
	
	

}
