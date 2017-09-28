package com.fujfu.pojo.apply;

import java.math.BigDecimal;

public class ApplyRepayVO {
    private Integer id;

    private Byte status;

    private Byte repayStatus;

    private Integer userId;

    private Integer applyId;

    private String repayType;

    private BigDecimal repayMoney;

    private BigDecimal repayInterest;

    private BigDecimal repayCapital;

    private BigDecimal repayRemain;

    private Byte repayPeriod;

    private Integer repayReqTime;

    private Integer repayDoneTime;

    private BigDecimal repayTotal;

    private String repayFee;

    private String uniqueNo;

    private Integer addTime;

    private Integer webPayDoneTime;

    private Byte isRepaying;
    
    private Integer valueDate;
    
    private Integer maturityDate;
    
    private BigDecimal repayDoneCapital;
    
    private BigDecimal repayDoneInterest;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getRepayStatus() {
        return repayStatus;
    }

    public void setRepayStatus(Byte repayStatus) {
        this.repayStatus = repayStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType == null ? null : repayType.trim();
    }

    public BigDecimal getRepayMoney() {
        return repayMoney;
    }

    public void setRepayMoney(BigDecimal repayMoney) {
        this.repayMoney = repayMoney;
    }

    public BigDecimal getRepayInterest() {
        return repayInterest;
    }

    public void setRepayInterest(BigDecimal repayInterest) {
        this.repayInterest = repayInterest;
    }

    public BigDecimal getRepayCapital() {
        return repayCapital;
    }

    public void setRepayCapital(BigDecimal repayCapital) {
        this.repayCapital = repayCapital;
    }

    public BigDecimal getRepayRemain() {
        return repayRemain;
    }

    public void setRepayRemain(BigDecimal repayRemain) {
        this.repayRemain = repayRemain;
    }

    public Byte getRepayPeriod() {
        return repayPeriod;
    }

    public void setRepayPeriod(Byte repayPeriod) {
        this.repayPeriod = repayPeriod;
    }

    public Integer getRepayReqTime() {
        return repayReqTime;
    }

    public void setRepayReqTime(Integer repayReqTime) {
        this.repayReqTime = repayReqTime;
    }

    public Integer getRepayDoneTime() {
        return repayDoneTime;
    }

    public void setRepayDoneTime(Integer repayDoneTime) {
        this.repayDoneTime = repayDoneTime;
    }

    public BigDecimal getRepayTotal() {
        return repayTotal;
    }

    public void setRepayTotal(BigDecimal repayTotal) {
        this.repayTotal = repayTotal;
    }

    public String getRepayFee() {
        return repayFee;
    }

    public void setRepayFee(String repayFee) {
        this.repayFee = repayFee == null ? null : repayFee.trim();
    }

    public String getUniqueNo() {
        return uniqueNo;
    }

    public void setUniqueNo(String uniqueNo) {
        this.uniqueNo = uniqueNo == null ? null : uniqueNo.trim();
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getWebPayDoneTime() {
        return webPayDoneTime;
    }

    public void setWebPayDoneTime(Integer webPayDoneTime) {
        this.webPayDoneTime = webPayDoneTime;
    }

    public Byte getIsRepaying() {
        return isRepaying;
    }

    public void setIsRepaying(Byte isRepaying) {
        this.isRepaying = isRepaying;
    }

	public Integer getValueDate() {
		return valueDate;
	}

	public void setValueDate(Integer valueDate) {
		this.valueDate = valueDate;
	}

	public Integer getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Integer maturityDate) {
		this.maturityDate = maturityDate;
	}

	public BigDecimal getRepayDoneCapital() {
		return repayDoneCapital;
	}

	public void setRepayDoneCapital(BigDecimal repayDoneCapital) {
		this.repayDoneCapital = repayDoneCapital;
	}

	public BigDecimal getRepayDoneInterest() {
		return repayDoneInterest;
	}

	public void setRepayDoneInterest(BigDecimal repayDoneInterest) {
		this.repayDoneInterest = repayDoneInterest;
	}
	
}