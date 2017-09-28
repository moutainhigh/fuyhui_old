package com.fujfu.common.payment.fuyou.pojo.response;


/**
 * 更换银行卡-响应实体类
 * @author hjz
 *
 */
public class ChangeCardResp extends BaseResponse{
	
	private String resp_desc;	//响应消息
	private String signature;	//数据签名
	
	public String getResp_desc() {
		return resp_desc;
	}
	
	public void setResp_desc(String resp_desc) {
		this.resp_desc = resp_desc;
	}
	
	public String getSignature() {
		return signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
