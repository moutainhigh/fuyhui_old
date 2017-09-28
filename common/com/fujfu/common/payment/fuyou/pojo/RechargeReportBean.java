package com.fujfu.common.payment.fuyou.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fujfu.common.payment.fuyou.util.FyUtil;

/**
 * 通知接口充值通知实体类
 * @author huangfeng
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = FyUtil.XML_ROOT)

public class RechargeReportBean {
	
	private String mchnt_cd;       	//商户代码    
	
	
	private String mchnt_txn_ssn;  	//流水号
	private String mchnt_txn_dt;    //交易日期  

	private String mobile_no;   	//手机号码
	private String amt;    			//充值金额
	private String remark;          //备注
	
	private String signature;       //签名数据

	
	private String action;
	
	/**
	 * 注册时请求的明文
	 * @return
	 */
	public String regSignVal(){
		String src = amt+ "|"+mchnt_cd + "|"+ mchnt_txn_dt + "|"+ mchnt_txn_ssn+ "|"+mobile_no+"|"+ remark;
		return src;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
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
	
	public String getMchnt_txn_dt() {
		return mchnt_txn_dt;
	}

	public void setMchnt_txn_dt(String mchnt_txn_dt) {
		this.mchnt_txn_dt = mchnt_txn_dt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
	
