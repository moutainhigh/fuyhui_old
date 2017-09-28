package com.fujfu.pojo.user;

/**
 * desc:担保人查询输入 author:peter
 */
public class PayForListPOJO {
	// 担保公司名称
	private String payForName;
	// 借款编号
	private String appyId;

	public String getPayForName() {
		return payForName;
	}

	public void setPayForName(String payForName) {
		this.payForName = payForName;
	}

	public String getAppyId() {
		return appyId;
	}

	public void setAppyId(String appyId) {
		this.appyId = appyId;
	}

}
