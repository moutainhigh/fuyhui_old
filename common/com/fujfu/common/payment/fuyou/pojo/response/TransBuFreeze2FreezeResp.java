package com.fujfu.common.payment.fuyou.pojo.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fujfu.common.payment.fuyou.util.FyUtil;

/**
 * 冻结到冻结接口- 响应实体类
 * @author huangjizhong
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = FyUtil.XML_ROOT)
public class TransBuFreeze2FreezeResp extends BaseResponse {
	
	@XmlElement(name = FyUtil.XML_PLAIN)
    private TransBuFreeze2FreezeResp response;

	@XmlElement(name = FyUtil.XML_SIGNATURE)
    private String signature;
	
	private String amt;
	
	private String suc_amt;
	
	public TransBuFreeze2FreezeResp getResponse() {
		return response;
	}
	
	public void setResponse(TransBuFreeze2FreezeResp response) {
		this.response = response;
	}
	
	public String getSignature() {
		return signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getSuc_amt() {
		return suc_amt;
	}

	public void setSuc_amt(String suc_amt) {
		this.suc_amt = suc_amt;
	}
}