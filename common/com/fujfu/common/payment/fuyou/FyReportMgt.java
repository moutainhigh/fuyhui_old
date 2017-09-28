package com.fujfu.common.payment.fuyou;

import org.apache.log4j.Logger;
import com.fujfu.common.payment.fuyou.pojo.RechargeReportBean;
import com.fujfu.common.payment.fuyou.pojo.response.RechargeReportResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.payment.fuyou.util.SecurityUtils;
import com.fujfu.common.util.XMLUtil;


/**
 * 富友支付接口类，富友通知类
 * @author huangfeng
 */

public class FyReportMgt {
	
	private static Logger log = Logger.getLogger(FyReportMgt.class);
	
	/**
	 * 充值通知
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static RechargeReportResp recharge(RechargeReportBean reqData) throws Exception {
		RechargeReportResp resq =new RechargeReportResp();
		RechargeReportResp resq1 =new RechargeReportResp();
		String sss= reqData.getMchnt_cd();
		resq1.setMchnt_cd(sss);
		resq1.setMchnt_txn_ssn(reqData.getMchnt_txn_ssn());
		resq1.setResp_code("0000");
		resq.setResponse(resq1);		
		
		
		return resq;
	}
	
	/**
	 * 提现通知
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static String withdrawal(RechargeReportBean reqData) throws Exception {
		RechargeReportResp resq =new RechargeReportResp();
		RechargeReportResp resq1 =new RechargeReportResp();
		String sss= reqData.getMchnt_cd();
		resq1.setMchnt_cd(sss);
		resq1.setMchnt_txn_ssn(reqData.getMchnt_txn_ssn());
		resq1.setResp_code("0000");
		resq.setResponse(resq1);		
		String inputStr=reqData.regSignVal();
		log.info("inputStr = " + inputStr);

		boolean flag = SecurityUtils.verifySign(
				inputStr,reqData.getSignature());//验签结果
		if(flag){						
			//验签成功进行相应业务逻辑处理
			resq.getResponse().setResp_code("0000");
			//保存数据库
			
			
		}
		String respxml =XMLUtil.bToXml(resq,FyUtil.CHAR_SET);//根据返回bean生产xml；
		String respxmlStr=XMLUtil.getSignData(respxml);//截取部分xml进行签名
		String signatureStr=SecurityUtils.sign(respxmlStr);
		resq.setSignature(signatureStr);
		String returnrespxml =XMLUtil.bToXml(resq,FyUtil.CHAR_SET);//根据返回bean生产xml；
		log.info("returnrespxml = " + returnrespxml);

		return returnrespxml;
	}
	
	
	
}
