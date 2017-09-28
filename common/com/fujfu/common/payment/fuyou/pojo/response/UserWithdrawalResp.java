package com.fujfu.common.payment.fuyou.pojo.response;

/**
 * 提现-响应实体类
 * @author hjz
 *
 */
public class UserWithdrawalResp extends BaseResponse{
	
	private String resp_desc;	//响应消息
	private String login_id;	//交易用户
	private String amt;			//交易金额
	private String signature;	//数据签名
	
	public String getSignature() {
		return signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public String getResp_desc() {
		return resp_desc;
	}
	
	public void setResp_desc(String resp_desc) {
		this.resp_desc = resp_desc;
	}
	
	public String getLogin_id() {
		return login_id;
	}
	
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	
	public String getAmt() {
		return amt;
	}
	
	public void setAmt(String amt) {
		this.amt = amt;
	}
	
}
