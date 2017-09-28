package com.fujfu.common.payment.fuyou.pojo.response;

/**
 * 富友响应参数-实体类基类
 * @author hjz
 *
 */
public class BaseResponse {
	private String resp_code;//返回码
	private String mchnt_cd;//商户代码
	private String mchnt_txn_ssn;//流水号
	
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
	
}
