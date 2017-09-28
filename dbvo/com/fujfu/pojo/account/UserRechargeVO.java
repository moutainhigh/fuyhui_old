package com.fujfu.pojo.account;

import java.math.BigDecimal;

public class UserRechargeVO {
    private Integer rechargeId;

    private Integer userId;

    private String billno;

    private BigDecimal money;

    private Integer type;

    private String bankCode;

    private String dcflag;

    private String paymentBillno;

    private String bankBillno;

    private Integer status;

    private Integer createTime;

    private Integer handleTime;
    
    private BigDecimal fee;

    private String rechargeNumber;
       
	public String getRechargeNumber() {
		return rechargeNumber;
	}

	public void setRechargeNumber(String rechargeNumber) {
		this.rechargeNumber = rechargeNumber;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public Integer getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(Integer rechargeId) {
        this.rechargeId = rechargeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getDcflag() {
        return dcflag;
    }

    public void setDcflag(String dcflag) {
        this.dcflag = dcflag == null ? null : dcflag.trim();
    }

    public String getPaymentBillno() {
        return paymentBillno;
    }

    public void setPaymentBillno(String paymentBillno) {
        this.paymentBillno = paymentBillno == null ? null : paymentBillno.trim();
    }

    public String getBankBillno() {
        return bankBillno;
    }

    public void setBankBillno(String bankBillno) {
        this.bankBillno = bankBillno == null ? null : bankBillno.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Integer handleTime) {
        this.handleTime = handleTime;
    }
}