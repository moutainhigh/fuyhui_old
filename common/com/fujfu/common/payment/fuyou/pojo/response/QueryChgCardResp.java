package com.fujfu.common.payment.fuyou.pojo.response;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fujfu.common.payment.fuyou.util.FyUtil;

/**
 * 更换银行卡查询-响应实体类
 * @author hjz
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = FyUtil.XML_ROOT)
public class QueryChgCardResp extends BaseResponse{
	
	@XmlElement(name = FyUtil.XML_PLAIN)
    private QueryChgCardResp response;

	@XmlElement(name = FyUtil.XML_SIGNATURE)
    private String signature;	//数据签名
	
	private String desc_code;	//返回码说明
	private String login_id;	//个人用户
	private String txn_ssn;		//交易流水
	private String bank_nm;		//开户行支行名称
	private String card_no;		//银行卡号
	private String examine_st;	//审核状态 0：待审核，1：审核成功，2：审核失败
	private String remark;		//备注
	
	public String getDesc_code() {
		return desc_code;
	}

	public void setDesc_code(String desc_code) {
		this.desc_code = desc_code;
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

	public String getBank_nm() {
		return bank_nm;
	}

	public void setBank_nm(String bank_nm) {
		this.bank_nm = bank_nm;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getExamine_st() {
		return examine_st;
	}

	public void setExamine_st(String examine_st) {
		this.examine_st = examine_st;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public QueryChgCardResp getResponse() {
		return response;
	}

	public void setResponse(QueryChgCardResp response) {
		this.response = response;
	}

	public String getSignature() {
		return signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}
}
