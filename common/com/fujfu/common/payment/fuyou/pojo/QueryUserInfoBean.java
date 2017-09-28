package com.fujfu.common.payment.fuyou.pojo;

/**
 * 用户信息查询实体类
 * @author huangjizhong
 *
 */
public class QueryUserInfoBean {

	private String mchnt_cd="";     //商户代码                  
	private String mchnt_txn_ssn="";//流水号                    
	private String mchnt_txn_dt="";  //交易日期         
	private String user_ids="";    //待查询的登录帐户列表              
	private String signature="";    //签名数据  
	private String ver="";    //签名数据  接口文档的版本号
	
	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
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

	public String getMchnt_txn_dt() {
		return mchnt_txn_dt;
	}

	public void setMchnt_txn_dt(String mchnt_txn_dt) {
		this.mchnt_txn_dt = mchnt_txn_dt;
	}

	public String getUser_ids() {
		return user_ids;
	}

	public void setUser_ids(String user_ids) {
		this.user_ids = user_ids;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * 注册时请求的明文
	 * @return
	 */
	public String regSignVal(){
		String str = mchnt_cd + "|" + mchnt_txn_dt + "|"
		 + mchnt_txn_ssn + "|" + user_ids + "|" + ver;
		return str;
	}
	
}
