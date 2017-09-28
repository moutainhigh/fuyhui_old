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
public class QueryTransactionDetailsBeanResp extends BaseResponse{
	
	@XmlElement(name = FyUtil.XML_PLAIN)
    private QueryTransactionDetailsBeanResp response;

	@XmlElement(name = FyUtil.XML_SIGNATURE)
    private String signature;			//数据签名
	
	@XmlElementWrapper(name = FyUtil.RESULTS)
    @XmlElement(name = FyUtil.RESULT)
    private List<QueryTransactionDetailsBeanResp> respList;	//账户详细信息
	
	private String busi_tp;			//业务类型
	private String total_number;		//总记录数
	private String ext_tp;		//扩展类型
	private String txn_date;		//交易日期
	private String txn_time;		//交易时分
	private String src_tp;    //交易请求方式1 接口；2 单笔；3 批量上传；
	private String mchnt_ssn;		//交易流水
	private String txn_amt;		//交易金额
	private String txn_amt_suc; //成功交易金额
	private String contract_no; //合同号
	private String out_fuiou_acct_no; //出账用户虚拟账户
	private String out_cust_no; //出账用户名
	private String out_artif_nm; //出账用户名称
	private String in_fuiou_acct_no;		//入账用户虚拟账户
	private String in_cust_no;		//入账用户名
	private String in_artif_nm;		//入账用户名称
	private String remark;		//备注
	private String txn_rsp_cd;		//返回码
	private String rsp_cd_desc;		//返回码描述
	public QueryTransactionDetailsBeanResp getResponse() {
		return response;
	}
	public void setResponse(QueryTransactionDetailsBeanResp response) {
		this.response = response;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public List<QueryTransactionDetailsBeanResp> getRespList() {
		return respList;
	}
	public void setRespList(List<QueryTransactionDetailsBeanResp> respList) {
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
	public String getSrc_tp() {
		return src_tp;
	}
	public void setSrc_tp(String src_tp) {
		this.src_tp = src_tp;
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
	public String getTxn_amt_suc() {
		return txn_amt_suc;
	}
	public void setTxn_amt_suc(String txn_amt_suc) {
		this.txn_amt_suc = txn_amt_suc;
	}
	public String getContract_no() {
		return contract_no;
	}
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}
	public String getOut_fuiou_acct_no() {
		return out_fuiou_acct_no;
	}
	public void setOut_fuiou_acct_no(String out_fuiou_acct_no) {
		this.out_fuiou_acct_no = out_fuiou_acct_no;
	}
	public String getOut_cust_no() {
		return out_cust_no;
	}
	public void setOut_cust_no(String out_cust_no) {
		this.out_cust_no = out_cust_no;
	}
	public String getOut_artif_nm() {
		return out_artif_nm;
	}
	public void setOut_artif_nm(String out_artif_nm) {
		this.out_artif_nm = out_artif_nm;
	}
	public String getIn_fuiou_acct_no() {
		return in_fuiou_acct_no;
	}
	public void setIn_fuiou_acct_no(String in_fuiou_acct_no) {
		this.in_fuiou_acct_no = in_fuiou_acct_no;
	}
	public String getIn_cust_no() {
		return in_cust_no;
	}
	public void setIn_cust_no(String in_cust_no) {
		this.in_cust_no = in_cust_no;
	}
	public String getIn_artif_nm() {
		return in_artif_nm;
	}
	public void setIn_artif_nm(String in_artif_nm) {
		this.in_artif_nm = in_artif_nm;
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
