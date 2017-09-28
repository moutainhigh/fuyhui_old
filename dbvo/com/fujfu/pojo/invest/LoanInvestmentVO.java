package com.fujfu.pojo.invest;

import java.math.BigDecimal;

public class LoanInvestmentVO {
    private Integer id;

    private Integer userId;

    private Integer applyId;

    private BigDecimal money;

    private String awardId;

    private Integer type;

    private Integer investTime;

    private Byte status;

    private Long trxId;

    private Integer isUnfreeze;

    private Integer isLoans;

    private Integer caStatus;
    private String claimNumber;//投资债权编号
    
    public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
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

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId == null ? null : awardId.trim();
    }

    public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getInvestTime() {
        return investTime;
    }

    public void setInvestTime(Integer investTime) {
        this.investTime = investTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getTrxId() {
        return trxId;
    }

    public void setTrxId(Long trxId) {
        this.trxId = trxId;
    }

	public Integer getIsUnfreeze() {
		return isUnfreeze;
	}

	public void setIsUnfreeze(Integer isUnfreeze) {
		this.isUnfreeze = isUnfreeze;
	}

	public Integer getIsLoans() {
		return isLoans;
	}

	public void setIsLoans(Integer isLoans) {
		this.isLoans = isLoans;
	}

	public Integer getCaStatus() {
		return caStatus;
	}

	public void setCaStatus(Integer caStatus) {
		this.caStatus = caStatus;
	}
}