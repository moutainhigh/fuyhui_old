package com.fujfu.pojo.user;

import java.math.BigDecimal;

public class PayForPOJO {
	/**
	 * 担保人垫资记录
	 */
	// 担保公司名称
	private String payForName;
	// 借款编号
	private Integer appyId;
	// 借款标题
	private String appyName;
	// 垫付期数
	private Integer payForPeriod;
	// 垫付日期
	private Integer payForTime;
	// 垫付金额
	private BigDecimal money;

	public String getPayForName() {
		return payForName;
	}

	public void setPayForName(String payForName) {
		this.payForName = payForName;
	}

	public Integer getAppyId() {
		return appyId;
	}

	public void setAppyId(Integer appyId) {
		this.appyId = appyId;
	}

	public String getAppyName() {
		return appyName;
	}

	public void setAppyName(String appyName) {
		this.appyName = appyName;
	}

	public Integer getPayForPeriod() {
		return payForPeriod;
	}

	public void setPayForPeriod(Integer payForPeriod) {
		this.payForPeriod = payForPeriod;
	}

	public Integer getPayForTime() {
		return payForTime;
	}

	public void setPayForTime(Integer payForTime) {
		this.payForTime = payForTime;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

}
