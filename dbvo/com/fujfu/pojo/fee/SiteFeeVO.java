package com.fujfu.pojo.fee;

import java.math.BigDecimal;

public class SiteFeeVO {
    private Integer feeId;

    private String feeBase;

    private String feeName;

    private String feeDesc;

    private Double feeMax;

    private BigDecimal feeMin;

    private Integer formulaType;

    private BigDecimal amount;

    private BigDecimal interestRate;

    private String alculation;

    private Boolean status;

    private Integer created;

    public Integer getFeeId() {
        return feeId;
    }

    public void setFeeId(Integer feeId) {
        this.feeId = feeId;
    }

    public String getFeeBase() {
        return feeBase;
    }

    public void setFeeBase(String feeBase) {
        this.feeBase = feeBase == null ? null : feeBase.trim();
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName == null ? null : feeName.trim();
    }

    public String getFeeDesc() {
        return feeDesc;
    }

    public void setFeeDesc(String feeDesc) {
        this.feeDesc = feeDesc == null ? null : feeDesc.trim();
    }

    public Double getFeeMax() {
        return feeMax;
    }

    public void setFeeMax(Double feeMax) {
        this.feeMax = feeMax;
    }

    public BigDecimal getFeeMin() {
        return feeMin;
    }

    public void setFeeMin(BigDecimal feeMin) {
        this.feeMin = feeMin;
    }

    public Integer getFormulaType() {
        return formulaType;
    }

    public void setFormulaType(Integer formulaType) {
        this.formulaType = formulaType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getAlculation() {
        return alculation;
    }

    public void setAlculation(String alculation) {
        this.alculation = alculation == null ? null : alculation.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }
}