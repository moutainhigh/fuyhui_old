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
public class QueryBalanceResp extends BaseResponse{
	
	@XmlElement(name = FyUtil.XML_PLAIN)
    private QueryBalanceResp response;

	@XmlElement(name = FyUtil.XML_SIGNATURE)
    private String signature;			//数据签名
	
	@XmlElementWrapper(name = FyUtil.RESULTS)
    @XmlElement(name = FyUtil.RESULT)
    private List<QueryBalanceResp> respList;	//账户详细信息
	
	private String User_id;			//用户名
	private String ct_balance;		//账面总余额	
	private String ca_balance;		//可用余额
	private String cf_balance;		//冻结余额
	private String cu_balance;		//未转结余额
	
	
	public QueryBalanceResp getResponse() {
		return response;
	}

	public void setResponse(QueryBalanceResp response) {
		this.response = response;
	}

	public List<QueryBalanceResp> getRespList() {
		return respList;
	}

	public void setRespList(List<QueryBalanceResp> respList) {
		this.respList = respList;
	}

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

	public String getCt_balance() {
		return ct_balance;
	}

	public void setCt_balance(String ct_balance) {
		this.ct_balance = ct_balance;
	}

	public String getCa_balance() {
		return ca_balance;
	}

	public void setCa_balance(String ca_balance) {
		this.ca_balance = ca_balance;
	}

	public String getCf_balance() {
		return cf_balance;
	}

	public void setCf_balance(String cf_balance) {
		this.cf_balance = cf_balance;
	}

	public String getCu_balance() {
		return cu_balance;
	}

	public void setCu_balance(String cu_balance) {
		this.cu_balance = cu_balance;
	}

	public String getSignature() {
		return signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}
}
