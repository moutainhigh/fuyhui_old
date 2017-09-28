package com.fujfu.common.payment.fuyou.pojo.response;

/**
 * 充值-响应实体类
 * @author hjz
 *
 */
public class UserRechargeResp {
	
	private String resp_desc;	//响应消息
	private String login_id;	//交易用户
	private String amt;			//充值金额
	private String signature; 	//数据签名
	
	private String resp_code;//返回码
	private String mchnt_cd;//商户代码
	private String mchnt_txn_ssn;//流水号
	private String rem;//流水号
	public String getRem() {
		return rem;
	}
	public void setRem(String rem) {
		this.rem = rem;
	}
	public String getResp_code() {
		return resp_code;
	}
	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
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
	
	public String getSignature() {
		return signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}
	//快捷验签字段
	public String regSignVal(){
		String src = amt+"|"+ login_id + "|"+ mchnt_cd +"|" +mchnt_txn_ssn+"|"+resp_code+"|"+resp_desc;
		return src;
	}
	//网银验签字段
	public String regWebSignVal(){
		String src = amt+"|"+ login_id + "|"+ mchnt_cd +"|" +mchnt_txn_ssn+"|"+rem +"|"+resp_code;
		return src;
	}
	//提现验签字段
	public String regTxSignVal(){
		String src = amt+"|"+ login_id + "|"+ mchnt_cd +"|" +mchnt_txn_ssn+"|"+resp_code;
		return src;
	}
}
