package com.fujfu.common.payment.fuyou.pojo.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fujfu.common.payment.fuyou.util.FyUtil;

/**
 * 充值通知-响应实体类
 * @author huangfeng
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = FyUtil.XML_ROOT)
public class RechargeReportResp1 extends BaseResponse{
	
	@XmlElement(name = FyUtil.XML_PLAIN)
	private RechargeReportResp response;

//	private String resp_code;	//响应码
//	private String mchnt_cd;	//商户代码
//	private String mchnt_txn_ssn;			//流水号
	
	@XmlElement(name = FyUtil.XML_SIGNATURE) 
	private String signature; 	//数据签名

	public RechargeReportResp getResponse() {
		return response;
	}

	public void setResponse(RechargeReportResp response) {
		this.response = response;
	}
	
	
	public String getSignature() {
		return signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}
}
