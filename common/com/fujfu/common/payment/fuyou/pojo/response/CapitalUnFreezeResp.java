package com.fujfu.common.payment.fuyou.pojo.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fujfu.common.payment.fuyou.util.FyUtil;

/**
 * 资金解冻-响应实体类
 * @author hjz
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = FyUtil.XML_ROOT)
public class CapitalUnFreezeResp extends BaseResponse{
	
	@XmlElement(name = FyUtil.XML_PLAIN)
    private CapitalUnFreezeResp response;

	@XmlElement(name = FyUtil.XML_SIGNATURE)
    private String signature;
	
	public CapitalUnFreezeResp getResponse() {
		return response;
	}
	
	public void setResponse(CapitalUnFreezeResp response) {
		this.response = response;
	}
	
	public String getSignature() {
		return signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}
}
