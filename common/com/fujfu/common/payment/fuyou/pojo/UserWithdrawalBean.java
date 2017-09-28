package com.fujfu.common.payment.fuyou.pojo;

/**
 * 用户提现实体类
 * @author huangjizhong
 *
 */
public class UserWithdrawalBean {

	private String mchnt_cd = "";       	//商户代码                  
	private String mchnt_txn_ssn = "";  	//流水号    
	private String page_notify_url = "";  	//商户返回地址
	private String amt = "";    			//提现金额    
	private String login_id = "";    		//用户登录名
	private String back_notify_url = "";	//商户后台通知地址	
	private String signature="";        	//签名数据    
	
	private String action = "";
	
	/**
	 * 注册时请求的明文
	 * @return
	 */
	public String regSignVal(){
		String src = amt + "|" + back_notify_url + "|" + login_id +"|"
	+ mchnt_cd + "|" + mchnt_txn_ssn + "|" + page_notify_url;
		return src;
	}
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public String getPage_notify_url() {
		return page_notify_url;
	}

	public void setPage_notify_url(String page_notify_url) {
		this.page_notify_url = page_notify_url;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getBack_notify_url() {
		return back_notify_url;
	}

	public void setBack_notify_url(String back_notify_url) {
		this.back_notify_url = back_notify_url;
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
	
	public String getAmt() {
		return amt;
	}
	
	public void setAmt(String amt) {
		this.amt = amt;
	}
	
	public String getSignature() {
		return signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
	
