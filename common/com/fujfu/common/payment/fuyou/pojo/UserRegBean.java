package com.fujfu.common.payment.fuyou.pojo;

/**
 * 用户注册实体类
 * @author huangjihzong
 *
 */
public class UserRegBean {

	private String mchnt_cd="";     //商户代码                  
	private String mchnt_txn_ssn="";//流水号                    
	private String cust_nm="";      //客户名称   
	private String certif_tp="";    //证件类型 0:身份证7：其他证件
	private String certif_id="";    //身份证号码/证件              
	private String mobile_no="";    //手机号                    
	private String email="";        //邮箱地址                  
	private String rem="";          //备注        
	private String city_id="";      //开户区县代码  
	private String  parent_bank_id="";//开户银行总行号
	private String  bank_nm="";//开户行支行名称
	private String capAcntNo="";    //账号                      


	private String capAcntNm="";    //账号户名                  
	private String lpassword="";    //登录密码                  
	private String password="";     //提现密码                  
	private String signature="";    //签名数据       
	
	public String getCertif_tp() {
		return certif_tp;
	}

	public void setCertif_tp(String certif_tp) {
		this.certif_tp = certif_tp;
	}
	public String getBank_nm() {
		return bank_nm;
	}

	public void setBank_nm(String bank_nm) {
		this.bank_nm = bank_nm;
	}

	public void setSignature(String signature) {
		this.signature = signature;
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

	public String getCust_nm() {
		return cust_nm;
	}

	public void setCust_nm(String cust_nm) {
		this.cust_nm = cust_nm;
	}

	public String getCertif_id() {
		return certif_id;
	}

	public void setCertif_id(String certif_id) {
		this.certif_id = certif_id;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRem() {
		return rem;
	}

	public void setRem(String rem) {
		this.rem = rem;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getParent_bank_id() {
		return parent_bank_id;
	}

	public void setParent_bank_id(String parent_bank_id) {
		this.parent_bank_id = parent_bank_id;
	}

	public String getCapAcntNo() {
		return capAcntNo;
	}

	public void setCapAcntNo(String capAcntNo) {
		this.capAcntNo = capAcntNo;
	}

	public String getCapAcntNm() {
		return capAcntNm;
	}

	public void setCapAcntNm(String capAcntNm) {
		this.capAcntNm = capAcntNm;
	}

	public String getLpassword() {
		return lpassword;
	}

	public void setLpassword(String lpassword) {
		this.lpassword = lpassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSignature() {
		return signature;
	}
	
	/**
	 * 注册时请求的明文
	 * @return
	 */
	public String regSignVal(){
		String src = bank_nm+"|"+capAcntNm+"|"+capAcntNo+"|"+certif_id+"|"+city_id+"|"
					+cust_nm+"|"+email+"|"+lpassword+"|"+mchnt_cd+"|"+mchnt_txn_ssn+"|"
					+mobile_no+"|"+parent_bank_id+"|"+password+"|"+rem;
		return src;
	}
	
}
	