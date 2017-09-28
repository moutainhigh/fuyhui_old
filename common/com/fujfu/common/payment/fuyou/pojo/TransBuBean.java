package com.fujfu.common.payment.fuyou.pojo;

/**
 * 划拨(个人与个人之间)
 * @author huangjizhong
 *
 */
public class TransBuBean {

	private String mchnt_cd = "";       //商户代码                  
	private String mchnt_txn_ssn = "";  //流水号                    
	private String out_cust_no = "";    //付款登录账户    
	private String in_cust_no = "";    	//收款登录账户
	private String amt = "";    		//转账金额
	private String contract_no = "";    //预授权合同号
	private String rem = "";    		//备注
	private String signature="";        //签名数据      
	
	/**
	 * 注册时请求的明文
	 * @return
	 */
	public String regSignVal(){
		String str = amt + "|" +contract_no+"|"+in_cust_no+"|"
					 + mchnt_cd + "|" + mchnt_txn_ssn+"|"
					 + out_cust_no +"|"+ rem;
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

	public String getOut_cust_no() {
		return out_cust_no;
	}

	public void setOut_cust_no(String out_cust_no) {
		this.out_cust_no = out_cust_no;
	}

	public String getIn_cust_no() {
		return in_cust_no;
	}

	public void setIn_cust_no(String in_cust_no) {
		this.in_cust_no = in_cust_no;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getContract_no() {
		return contract_no;
	}

	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}

	public String getRem() {
		return rem;
	}

	public void setRem(String rem) {
		this.rem = rem;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
	