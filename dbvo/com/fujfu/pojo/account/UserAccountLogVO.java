package com.fujfu.pojo.account;

import java.math.BigDecimal;

public class UserAccountLogVO {
    private Integer id;

    private Integer userId;

    private Integer type;

    private BigDecimal money;

    private String remark;

    private BigDecimal total;

    private BigDecimal noTender;

    private BigDecimal cash;

    private BigDecimal frost;

    private BigDecimal awaitIncome;

    private BigDecimal awaitRepay;

    private Integer addTime;
    
    private String addTimeStr;

	private Integer status;

    private Integer applyId;

    private Integer from;

    private String to;

    private String memo;

    private String data;

    private Long trxId;

    private Integer ordid;
    
    private String busiNumber;

    public String getBusiNumber() {
		return busiNumber;
	}

	public void setBusiNumber(String busiNumber) {
		this.busiNumber = busiNumber;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Integer getAddTime() {
		return addTime;
	}

	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}

    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to == null ? null : to.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public Long getTrxId() {
        return trxId;
    }

    public void setTrxId(Long trxId) {
        this.trxId = trxId;
    }

    public Integer getOrdid() {
        return ordid;
    }

    public void setOrdid(Integer ordid) {
        this.ordid = ordid;
    }

    public String getAddTimeStr() {
		return addTimeStr;
	}

	public void setAddTimeStr(String addTimeStr) {
		this.addTimeStr = addTimeStr;
	}
}