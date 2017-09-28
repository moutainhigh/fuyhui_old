package com.fujfu.pojo.account;

import java.math.BigDecimal;

public class UserWithdrawalVO {
    private Integer withdrawalId;

    private Integer userId;

    private BigDecimal amount;

    private Integer status;

    private Integer bankId;

    private String fee;

    private Integer createTime;

    private Integer handleTime;

    private String memo;

    private String billno;
    
    private String withdrawalNumber;

    public String getWithdrawalNumber() {
		return withdrawalNumber;
	}

	public void setWithdrawalNumber(String withdrawalNumber) {
		this.withdrawalNumber = withdrawalNumber;
	}

	public Integer getWithdrawalId() {
        return withdrawalId;
    }

    public void setWithdrawalId(Integer withdrawalId) {
        this.withdrawalId = withdrawalId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee == null ? null : fee.trim();
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}
   
}