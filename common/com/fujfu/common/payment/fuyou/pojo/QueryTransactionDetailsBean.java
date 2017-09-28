package com.fujfu.common.payment.fuyou.pojo;

/**
 * 余额查询实体类
 * @author huangjizhong
 *
 */
public class QueryTransactionDetailsBean {

	private String mchnt_cd;      //商户代码                  
	private String mchnt_txn_ssn; //流水号
	private String busi_tp; //PWPC 转账 PW13 预授权 PWCF 预授权撤销 PW03 划拨 PW14 转账冻结 PW15 划拨冻结 PWDJ 冻结 PWJD 解冻 PW19 冻结付款到冻结
	private String txn_ssn; //交易流水
	private String start_day; //起始时间
	private String end_day; //截止时间
	private String cust_no; //用户
	private String txn_st; //1 交易成功 2 交易失败
	private String page_no; //页码大于零的整数；默认为1;
	private String page_size; //每页条数 [10,100]之间整数; 默认值:10;最大值:100;
	private String signature; //签名数据
	private String remark;//交易备注	
    

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


	public String getBusi_tp() {
		return busi_tp;
	}


	public void setBusi_tp(String busi_tp) {
		this.busi_tp = busi_tp;
	}


	public String getTxn_ssn() {
		return txn_ssn;
	}


	public void setTxn_ssn(String txn_ssn) {
		this.txn_ssn = txn_ssn;
	}


	public String getStart_day() {
		return start_day;
	}


	public void setStart_day(String start_day) {
		this.start_day = start_day;
	}


	public String getEnd_day() {
		return end_day;
	}


	public void setEnd_day(String end_day) {
		this.end_day = end_day;
	}


	public String getCust_no() {
		return cust_no;
	}


	public void setCust_no(String cust_no) {
		this.cust_no = cust_no;
	}


	public String getTxn_st() {
		return txn_st;
	}


	public void setTxn_st(String txn_st) {
		this.txn_st = txn_st;
	}


	public String getPage_no() {
		return page_no;
	}


	public void setPage_no(String page_no) {
		this.page_no = page_no;
	}


	public String getPage_size() {
		return page_size;
	}


	public void setPage_size(String page_size) {
		this.page_size = page_size;
	}


	public String getSignature() {
		return signature;
	}


	public void setSignature(String signature) {
		this.signature = signature;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	/**
	 * 注册时请求的明文
	 * @return
	 */
	public String regSignVal(){
		String str = busi_tp+"|"+cust_no+"|"+end_day+"|"+mchnt_cd+"|"+mchnt_txn_ssn+"|"+page_no+"|"+page_size+"|"+remark+"|"+start_day+"|"+txn_ssn+"|"+txn_st;
		return str;
	}
	
}
