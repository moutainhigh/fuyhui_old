package com.fujfu.common.payment.fuyou.pojo.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fujfu.common.payment.fuyou.util.FyUtil;

/**
 * 余额查询-响应实体类
 * @author hjz
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = FyUtil.XML_ROOT)
public class QueryReOrWithDetailsBeanResp extends BaseResponse{
	
	@XmlElement(name = FyUtil.XML_PLAIN)
    private QueryReOrWithDetailsBeanResp response;

	@XmlElement(name = FyUtil.XML_SIGNATURE)
    private String signature;			//数据签名
	
	@XmlElementWrapper(name = FyUtil.RESULTS)
    @XmlElement(name = FyUtil.RESULT)
    private List<QueryReOrWithDetailsBeanResp> respList;	//账户详细信息
	
	private String busi_tp;			//业务类型
	private String total_number;		//总记录数
	private String ext_tp;		//扩展类型
	private String txn_date;		//充值提现日期
	private String txn_time;		//充值提现时分
	private String mchnt_ssn;		//充值提现流水
	private String txn_amt;		//充值提现金额
	private String fuiou_acct_no;		//用户虚拟账户
	private String cust_no;		//用户名
	private String artif_nm;		//用户名称
	private String remark;		//备注
	private String txn_rsp_cd;		//返回码
	private String rsp_cd_desc;		//返回码描述
	public QueryReOrWithDetailsBeanResp getResponse() {
		return response;
	}
	public void setResponse(QueryReOrWithDetailsBeanResp response) {
		this.response = response;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public List<QueryReOrWithDetailsBeanResp> getRespList() {
		return respList;
	}
	public void setRespList(List<QueryReOrWithDetailsBeanResp> respList) {
		this.respList = respList;
	}
	public String getBusi_tp() {
		return busi_tp;
	}
	public void setBusi_tp(String busi_tp) {
		this.busi_tp = busi_tp;
	}
	public String getTotal_number() {
		return total_number;
	}
	public void setTotal_number(String total_number) {
		this.total_number = total_number;
	}
	public String getExt_tp() {
		return ext_tp;
	}
	public void setExt_tp(String ext_tp) {
		this.ext_tp = ext_tp;
	}
	public String getTxn_date() {
		return txn_date;
	}
	public void setTxn_date(String txn_date) {
		this.txn_date = txn_date;
	}
	public String getTxn_time() {
		return txn_time;
	}
	public void setTxn_time(String txn_time) {
		this.txn_time = txn_time;
	}
	public String getMchnt_ssn() {
		return mchnt_ssn;
	}
	public void setMchnt_ssn(String mchnt_ssn) {
		this.mchnt_ssn = mchnt_ssn;
	}
	public String getTxn_amt() {
		return txn_amt;
	}
	public void setTxn_amt(String txn_amt) {
		this.txn_amt = txn_amt;
	}
	public String getFuiou_acct_no() {
		return fuiou_acct_no;
	}
	public void setFuiou_acct_no(String fuiou_acct_no) {
		this.fuiou_acct_no = fuiou_acct_no;
	}
	public String getCust_no() {
		return cust_no;
	}
	public void setCust_no(String cust_no) {
		this.cust_no = cust_no;
	}
	public String getArtif_nm() {
		return artif_nm;
	}
	public void setArtif_nm(String artif_nm) {
		this.artif_nm = artif_nm;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTxn_rsp_cd() {
		return txn_rsp_cd;
	}
	public void setTxn_rsp_cd(String txn_rsp_cd) {
		this.txn_rsp_cd = txn_rsp_cd;
	}
	public String getRsp_cd_desc() {
		return rsp_cd_desc;
	}
	public void setRsp_cd_desc(String rsp_cd_desc) {
		this.rsp_cd_desc = rsp_cd_desc;
	}
	
	

}
