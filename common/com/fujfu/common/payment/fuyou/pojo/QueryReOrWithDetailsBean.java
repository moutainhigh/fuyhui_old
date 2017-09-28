package com.fujfu.common.payment.fuyou.pojo;

/**
 * 余额查询实体类
 * @author huangjizhong
 *
 */
public class QueryReOrWithDetailsBean {

	private String ver; //接口文档的版本号
	private String mchnt_cd;      //商户代码                  
	private String mchnt_txn_ssn; //流水号
	private String busi_tp; //PW11 充值,PWTX 提现,PWTP 退票
	private String txn_ssn; //交易流水
	private String start_time; //起始时间
	private String end_time; //截止时间
	private String cust_no; //用户
	private String txn_st; //1 交易成功 2 交易失败
	private String page_no; //页码大于零的整数；默认为1;
	private String page_size; //每页条数 [10,100]之间整数; 默认值:10;最大值:100;
	private String signature; //签名数据

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

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
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

	/**
	 * 注册时请求的明文
	 * @return
	 */
	public String regSignVal(){
		String str = busi_tp+"|"+cust_no+"|"+end_time+"|"+mchnt_cd+"|"+mchnt_txn_ssn+"|"+page_no+"|"+page_size+"|"+start_time+"|"+txn_ssn+"|"+txn_st+"|"+ver;
		return str;
	}
	
}
