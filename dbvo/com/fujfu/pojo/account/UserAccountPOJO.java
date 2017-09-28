package com.fujfu.pojo.account;

import java.math.BigDecimal;

public class UserAccountPOJO {
	private Integer id;

	private String userName;
	
	private String realName;
	
	private String userType;
	
    private BigDecimal total;

    private BigDecimal cash;

    private BigDecimal frost;

    private BigDecimal awaitIncome;

    private BigDecimal awaitRepay;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getCash() {
		return cash;
	}

	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}

	public BigDecimal getFrost() {
		return frost;
	}

	public void setFrost(BigDecimal frost) {
		this.frost = frost;
	}

	public BigDecimal getAwaitIncome() {
		return awaitIncome;
	}

	public void setAwaitIncome(BigDecimal awaitIncome) {
		this.awaitIncome = awaitIncome;
	}

	public BigDecimal getAwaitRepay() {
		return awaitRepay;
	}

	public void setAwaitRepay(BigDecimal awaitRepay) {
		this.awaitRepay = awaitRepay;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
