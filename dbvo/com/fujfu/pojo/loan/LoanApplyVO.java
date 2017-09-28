package com.fujfu.pojo.loan;

import java.math.BigDecimal;

public class LoanApplyVO {
    private Integer id;

    private Integer userId;

    private String orderNumber;

    private String name;

    private BigDecimal amount;

    private BigDecimal handAmount;

    private BigDecimal investMin;

    private BigDecimal investMax;

    private Float apr;

    private Float aprReward;

    private Integer period;

    private Integer loanType;

    private String purpose;

    private Integer paymentOptions;

    private Byte status;

    private Integer created;

    private Integer mtime;

    private Integer startTime;

    private Integer endTime;

    private Integer loanTime;

    private Integer guaranteeCompanyId;

    private String description;
    
    private Integer raiseDays;

    private Integer transmitted;
    
    private String url;
    
    private String projectSource;
    
    private Byte isLoans;
    
    private Byte isFrozen;
    
    private String contract;
    
    private String guaranteeMode;
    
    private Float financeServiceFee;
    
    private Float investServiceFee;
    
	private BigDecimal proAmount;
    
    private String fristAdvice;
    
    private String lastAdvice;
    
   
    
    private String productManager;
    
    private String underlyAssets;
    
    private String isCreatctra;// 是否已生成合同
    
    private String productUrl;// 合同模板及产品募集书目录
	
    private Integer dueTime;
    
    private Integer actPeriod;
    
    private Integer isInside;
    
    private Integer completeTime;
    
    private BigDecimal amountInvested;
    
    private Integer version;
    
    private Integer installmentDate;//分期还款日
    
    private Integer lineloanDate;//线下还款日
    
    private BigDecimal recordSize; //备案规模
    
    private String signedNumber;//原签订编号
	
	public Integer getLineloanDate() {
		return lineloanDate;
	}
	public void setLineloanDate(Integer lneloanDate) {
		this.lineloanDate = lneloanDate;
	}
	public Integer getInstallmentDate() {
		return installmentDate;
	}
	public void setInstallmentDate(Integer installmentDate) {
		this.installmentDate = installmentDate;
	}
	
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	
	
	public String getIsCreatctra() {
		return isCreatctra;
	}
	public void setIsCreatctra(String isCreatctra) {
		this.isCreatctra = isCreatctra;
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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getHandAmount() {
        return handAmount;
    }

    public void setHandAmount(BigDecimal handAmount) {
        this.handAmount = handAmount;
    }

    public BigDecimal getInvestMin() {
        return investMin;
    }

    public void setInvestMin(BigDecimal investMin) {
        this.investMin = investMin;
    }

    public BigDecimal getInvestMax() {
        return investMax;
    }

    public void setInvestMax(BigDecimal investMax) {
        this.investMax = investMax;
    }

    public Float getApr() {
        return apr;
    }

    public void setApr(Float apr) {
        this.apr = apr;
    }

    public Float getAprReward() {
        return aprReward;
    }

    public void setAprReward(Float aprReward) {
        this.aprReward = aprReward;
    }

    public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public Integer getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(Integer paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getMtime() {
        return mtime;
    }

    public void setMtime(Integer mtime) {
        this.mtime = mtime;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Integer loanTime) {
        this.loanTime = loanTime;
    }

    public Integer getGuaranteeCompanyId() {
        return guaranteeCompanyId;
    }

    public void setGuaranteeCompanyId(Integer guaranteeCompanyId) {
        this.guaranteeCompanyId = guaranteeCompanyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public Integer getRaiseDays() {
		return raiseDays;
	}

	public void setRaiseDays(Integer raiseDays) {
		this.raiseDays = raiseDays;
	}

	public Integer getTransmitted() {
		return transmitted;
	}

	public void setTransmitted(Integer transmitted) {
		this.transmitted = transmitted;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getProjectSource() {
		return projectSource;
	}

	public void setProjectSource(String projectSource) {
		this.projectSource = projectSource;
	}

	public Byte getIsLoans() {
		return isLoans;
	}

	public void setIsLoans(Byte isLoans) {
		this.isLoans = isLoans;
	}

	public Byte getIsFrozen() {
		return isFrozen;
	}

	public void setIsFrozen(Byte isFrozen) {
		this.isFrozen = isFrozen;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getGuaranteeMode() {
		return guaranteeMode;
	}

	public void setGuaranteeMode(String guaranteeMode) {
		this.guaranteeMode = guaranteeMode;
	}

	public Float getFinanceServiceFee() {
		return financeServiceFee;
	}

	public void setFinanceServiceFee(Float financeServiceFee) {
		this.financeServiceFee = financeServiceFee;
	}

	public Float getInvestServiceFee() {
		return investServiceFee;
	}

	public void setInvestServiceFee(Float investServiceFee) {
		this.investServiceFee = investServiceFee;
	}

	public BigDecimal getProAmount() {
		return proAmount;
	}

	public void setProAmount(BigDecimal proAmount) {
		this.proAmount = proAmount;
	}

	public String getFristAdvice() {
		return fristAdvice;
	}

	public void setFristAdvice(String fristAdvice) {
		this.fristAdvice = fristAdvice;
	}

	public String getLastAdvice() {
		return lastAdvice;
	}

	public void setLastAdvice(String lastAdvice) {
		this.lastAdvice = lastAdvice;
	}

	public String getProductManager() {
		return productManager;
	}

	public void setProductManager(String productManager) {
		this.productManager = productManager;
	}

	public String getUnderlyAssets() {
		return underlyAssets;
	}

	public void setUnderlyAssets(String underlyAssets) {
		this.underlyAssets = underlyAssets;
	}
	public Integer getDueTime() {
		return dueTime;
	}
	public void setDueTime(Integer dueTime) {
		this.dueTime = dueTime;
	}
	public Integer getActPeriod() {
		return actPeriod;
	}
	public void setActPeriod(Integer actPeriod) {
		this.actPeriod = actPeriod;
	}
	public Integer getIsInside() {
		return isInside;
	}
	public void setIsInside(Integer isInside) {
		this.isInside = isInside;
	}
	public Integer getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(Integer completeTime) {
		this.completeTime = completeTime;
	}
	
	public BigDecimal getAmountInvested() {
		return amountInvested;
	}
	public void setAmountInvested(BigDecimal amountInvested) {
		this.amountInvested = amountInvested;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public BigDecimal getRecordSize() {
		return recordSize;
	}
	public void setRecordSize(BigDecimal recordSize) {
		this.recordSize = recordSize;
	}
	public String getSignedNumber() {
		return signedNumber;
	}
	public void setSignedNumber(String signedNumber) {
		this.signedNumber = signedNumber;
	}
}