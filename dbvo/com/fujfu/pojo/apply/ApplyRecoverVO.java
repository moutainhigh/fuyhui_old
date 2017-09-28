package com.fujfu.pojo.apply;

import java.math.BigDecimal;

public class ApplyRecoverVO {
    private Integer id;

    private Byte status;

    private Integer userId;

    private Integer applyId;

    private BigDecimal recoverMoney;

    private BigDecimal recoverInterest;

    private BigDecimal recoverCapital;

    private BigDecimal recoverRemain;

    private Integer recoverPeriod;

    private Integer recoverReqTime;

    private Integer recoverDoneTime;

    private String recoverFee;

    private BigDecimal recoverTotal;

    private String uniqueNo;

    private Integer addTime;

    private Long relayFee;

    private Long aheadFee;

    private Integer investId;

    private Integer ordid;

    private Integer webPayDoneTime;

    private Boolean isPnrPay;

    private String orignRecoverData;

    private Integer aheadPayDoneTime;
    
    private String recoverDoneTimeStr;

    private Integer valueDate;
    
    private Integer maturityDate;
    private String batchSerialno;
    private BigDecimal repayDoneCapital;    
    private BigDecimal repayDoneInterest;
    
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
    public String getBatchSerialno() {
		return batchSerialno;
	}

	public void setBatchSerialno(String batchSerialno) {
		this.batchSerialno = batchSerialno;
	}

	public String getRecoverDoneTimeStr() {
		return recoverDoneTimeStr;
	}

	public void setRecoverDoneTimeStr(String recoverDoneTimeStr) {
		this.recoverDoneTimeStr = recoverDoneTimeStr;
	}

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

    public BigDecimal getRecoverMoney() {
        return recoverMoney;
    }

    public void setRecoverMoney(BigDecimal recoverMoney) {
        this.recoverMoney = recoverMoney;
    }

    public BigDecimal getRecoverInterest() {
        return recoverInterest;
    }

    public void setRecoverInterest(BigDecimal recoverInterest) {
        this.recoverInterest = recoverInterest;
    }

    public BigDecimal getRecoverCapital() {
        return recoverCapital;
    }

    public void setRecoverCapital(BigDecimal recoverCapital) {
        this.recoverCapital = recoverCapital;
    }

    public BigDecimal getRecoverRemain() {
        return recoverRemain;
    }

    public void setRecoverRemain(BigDecimal recoverRemain) {
        this.recoverRemain = recoverRemain;
    }

    public Integer getRecoverPeriod() {
        return recoverPeriod;
    }

    public void setRecoverPeriod(Integer recoverPeriod) {
        this.recoverPeriod = recoverPeriod;
    }

    public Integer getRecoverReqTime() {
        return recoverReqTime;
    }

    public void setRecoverReqTime(Integer recoverReqTime) {
        this.recoverReqTime = recoverReqTime;
    }

    public Integer getRecoverDoneTime() {
        return recoverDoneTime;
    }

    public void setRecoverDoneTime(Integer recoverDoneTime) {
        this.recoverDoneTime = recoverDoneTime;
    }

    public String getRecoverFee() {
        return recoverFee;
    }

    public void setRecoverFee(String recoverFee) {
        this.recoverFee = recoverFee == null ? null : recoverFee.trim();
    }

    public BigDecimal getRecoverTotal() {
        return recoverTotal;
    }

    public void setRecoverTotal(BigDecimal recoverTotal) {
        this.recoverTotal = recoverTotal;
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

    public Long getRelayFee() {
        return relayFee;
    }

    public void setRelayFee(Long relayFee) {
        this.relayFee = relayFee;
    }

    public Long getAheadFee() {
        return aheadFee;
    }

    public void setAheadFee(Long aheadFee) {
        this.aheadFee = aheadFee;
    }

    public Integer getInvestId() {
        return investId;
    }

    public void setInvestId(Integer investId) {
        this.investId = investId;
    }

    public Integer getOrdid() {
        return ordid;
    }

    public void setOrdid(Integer ordid) {
        this.ordid = ordid;
    }

    public Integer getWebPayDoneTime() {
        return webPayDoneTime;
    }

    public void setWebPayDoneTime(Integer webPayDoneTime) {
        this.webPayDoneTime = webPayDoneTime;
    }

    public Boolean getIsPnrPay() {
        return isPnrPay;
    }

    public void setIsPnrPay(Boolean isPnrPay) {
        this.isPnrPay = isPnrPay;
    }

    public String getOrignRecoverData() {
        return orignRecoverData;
    }

    public void setOrignRecoverData(String orignRecoverData) {
        this.orignRecoverData = orignRecoverData == null ? null : orignRecoverData.trim();
    }

    public Integer getAheadPayDoneTime() {
        return aheadPayDoneTime;
    }

    public void setAheadPayDoneTime(Integer aheadPayDoneTime) {
        this.aheadPayDoneTime = aheadPayDoneTime;
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
    
}