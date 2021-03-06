package com.fujfu.common.payment.fuyou.pojo.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fujfu.common.payment.fuyou.util.FyUtil;

/**
 * 转账(商户与个人之间) -响应实体类
 * @author huangjizhong
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = FyUtil.XML_ROOT)
public class TransBmuResp extends BaseResponse {
	
	@XmlElement(name = FyUtil.XML_PLAIN)
    private TransBmuResp response;

	@XmlElement(name = FyUtil.XML_SIGNATURE)
    private String signature;
	
	public TransBmuResp getResponse() {
		return response;
	}
	
	public void setResponse(TransBmuResp response) {
		this.response = response;
	}
	
	public String getSignature() {
		return signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}
}