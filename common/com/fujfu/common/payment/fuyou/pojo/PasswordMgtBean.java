package com.fujfu.common.payment.fuyou.pojo;

/**
 * 更换手机号实体类
 * @author huangjizhong
 *
 */
public class PasswordMgtBean {

	private String mchnt_cd;      	//商户代码                  
	private String mchnt_txn_ssn; 	//流水号                    
	private String login_id;        //用户登录ID 
	private String busi_tp;        	//业务类型-1:重置登录密码,2:修改登录密码,3:支付密码重置
	private String back_url; //商户返回地址
	private String signature;     	//签名数据       
	
	private String action;     		//请求地址
	
	/**
	 * 注册时请求的明文
	 * @return
	 */
	public String regSignVal(){
		String str = busi_tp+"|"+login_id+"|"+mchnt_cd+"|"+mchnt_txn_ssn;
		return str;
	}

	public String getBusi_tp() {
		return busi_tp;
	}

	public void setBusi_tp(String busi_tp) {
		this.busi_tp = busi_tp;
	}

	public String getMchnt_cd() {
		return mchnt_cd;
	}

	public void setMchnt_cd(String mchnt_cd) {
		this.mchnt_cd = mchnt_cd;
	}

	public String getMchnt_txn_ssn() {
		return mchnt_txn_ssn;
	}

	public void setMchnt_txn_ssn(String mchnt_txn_ssn) {
		this.mchnt_txn_ssn = mchnt_txn_ssn;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getback_url() {
		return back_url;
	}

	public void setback_url(String back_url) {
		this.back_url = back_url;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
}
