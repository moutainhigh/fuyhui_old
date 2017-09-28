package com.fujfu.service.account;

import com.fujfu.common.payment.fuyou.pojo.RechargeReportBean;
import com.fujfu.common.payment.fuyou.pojo.response.RechargeReportResp;

/**
 * 富友通知接口类
 */
public interface FyReportServ {

	public RechargeReportResp rechargeReport(RechargeReportBean bean);
}
