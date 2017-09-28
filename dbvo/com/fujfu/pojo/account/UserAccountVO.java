package com.fujfu.pojo.account;

import java.math.BigDecimal;

public class UserAccountVO {
    private Integer id;

    private Integer userId;

    private BigDecimal total;  //资产总额

    private BigDecimal noTender;

    private BigDecimal cash; //可用余额

    private BigDecimal frost; //冻结金额

    private BigDecimal awaitIncome;//待收金额

    private BigDecimal awaitRepay;//待還金額

    private Integer hasRepayment;//
    
    private BigDecimal sumIncome;//累计收益
    

    public BigDecimal getSumIncome() {
		return sumIncome;
	}

	public void setSumIncome(BigDecimal sumIncome) {
		this.sumIncome = sumIncome;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getNoTender() {
        return noTender;
    }

    public void setNoTender(BigDecimal noTender) {
        this.noTender = noTender;
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

    public Integer getHasRepayment() {
        return hasRepayment;
    }

    public void setHasRepayment(Integer hasRepayment) {
        this.hasRepayment = hasRepayment;
    }
}