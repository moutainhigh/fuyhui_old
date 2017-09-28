package com.fujfu.common.payment.fuyou.pojo;

/**
 * 更换银行卡结果查询实体类
 * @author huangjizhong
 *
 */
public class QueryChgCardBean {

	private String mchnt_cd;      //商户代码                  
	private String mchnt_txn_ssn; //流水号                    
	private String login_id; 	  //个人用户
	private String txn_ssn;       //交易流水
	private String signature;     //签名数据       
	
	/**
	 * 注册时请求的明文
	 * @return
	 */
	public String regSignVal(){
		String str = login_id+"|"+ mchnt_cd + "|" + mchnt_txn_ssn + "|" + txn_ssn;
		return str;
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

	public String getTxn_ssn() {
		return txn_ssn;
	}

	public void setTxn_ssn(String txn_ssn) {
		this.txn_ssn = txn_ssn;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
