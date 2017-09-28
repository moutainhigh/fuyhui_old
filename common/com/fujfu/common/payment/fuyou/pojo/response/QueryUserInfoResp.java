package com.fujfu.common.payment.fuyou.pojo.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fujfu.common.payment.fuyou.util.FyUtil;

/**
 * 用户信息查询-响应实体类
 * @author hjz
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = FyUtil.XML_ROOT)
public class QueryUserInfoResp extends BaseResponse{
	
	@XmlElement(name = FyUtil.XML_PLAIN)
    private QueryUserInfoResp response;

	@XmlElement(name = FyUtil.XML_SIGNATURE)
    private String signature;			//数据签名
	
	@XmlElementWrapper(name = FyUtil.RESULTS)
    @XmlElement(name = FyUtil.RESULT)
    private List<QueryUserInfoResp> respList;	//用户详细信息
	
	private String mobile_no;			//手机号码
	private String cust_nm;				//客户姓名
	private String certif_id;			//身份证号码
	private String email;				//邮箱地址
	private String city_id;				//开户行地区代码
	private String parent_bank_id;		//开户行行别
	private String bank_nm;				//开户行支行名称
	private String capAcntNo;			//帐号
	private String card_pwd_verify_st;	//卡密认证状态
	private String id_nm_verify_st;		//账户信息验证状态
	private String contract_st;			//账户生效状态
	private String user_st;				//用户状态
	private String login_id;				//金账户登录号
	
	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public List<QueryUserInfoResp> getRespList() {
		return respList;
	}

	public void setRespList(List<QueryUserInfoResp> respList) {
		this.respList = respList;
	}
	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getBank_nm() {
		return bank_nm;
	}

	public void setBank_nm(String bank_nm) {
		this.bank_nm = bank_nm;
	}

	public String getCapAcntNo() {
		return capAcntNo;
	}

	public void setCapAcntNo(String capAcntNo) {
		this.capAcntNo = capAcntNo;
	}

	public String getCard_pwd_verify_st() {
		return card_pwd_verify_st;
	}

	public void setCard_pwd_verify_st(String card_pwd_verify_st) {
		this.card_pwd_verify_st = card_pwd_verify_st;
	}

	public String getId_nm_verify_st() {
		return id_nm_verify_st;
	}

	public void setId_nm_verify_st(String id_nm_verify_st) {
		this.id_nm_verify_st = id_nm_verify_st;
	}

	public String getContract_st() {
		return contract_st;
	}

	public void setContract_st(String contract_st) {
		this.contract_st = contract_st;
	}

	public String getUser_st() {
		return user_st;
	}

	public void setUser_st(String user_st) {
		this.user_st = user_st;
	}

	public QueryUserInfoResp getResponse() {
		return response;
	}
	
	public void setResponse(QueryUserInfoResp response) {
		this.response = response;
	}
	
	public String getSignature() {
		return signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}
}
