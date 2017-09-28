package com.fujfu.common.payment.fuyou.pojo.response;


/**
 * 更换手机号-响应实体类
 * @author hjz
 *
 */
public class ChangeMobileResp extends BaseResponse{
	
	private String resp_desc;	//响应消息
	private String login_id;	//交易用户
	private String new_mobile;	//新手机号
	private String signature;	//数据签名
	
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
	public String getNew_mobile() {
		return new_mobile;
	}
	public void setNew_mobile(String new_mobile) {
		this.new_mobile = new_mobile;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	
}
