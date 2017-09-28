package com.fujfu.pojo.fee;

import java.math.BigDecimal;

public class SiteFeeTypeVO {
    private Integer chargeTypeId;

    private String chargeItem;

    private String chargeTime;

    private Integer chargeFeeId;

    private String billingStartTime;

    private Integer billingExtension;

    private Integer billingExtensionType;

    private Integer billingPeriod;

    private Integer billingPeriodType;

    private Integer created;

    private Integer chargeUser;
    
    private String userType;
    
    private Integer formulaType;

    private BigDecimal amount;

    private BigDecimal interestRate;

    public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getChargeTypeId() {
        return chargeTypeId;
    }

    public void setChargeTypeId(Integer chargeTypeId) {
        this.chargeTypeId = chargeTypeId;
    }

    public String getChargeItem() {
        return chargeItem;
    }

    public void setChargeItem(String chargeItem) {
        this.chargeItem = chargeItem == null ? null : chargeItem.trim();
    }

    public String getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(String chargeTime) {
        this.chargeTime = chargeTime == null ? null : chargeTime.trim();
    }

    public Integer getChargeFeeId() {
        return chargeFeeId;
    }

    public void setChargeFeeId(Integer chargeFeeId) {
        this.chargeFeeId = chargeFeeId;
    }

    public String getBillingStartTime() {
        return billingStartTime;
    }

    public void setBillingStartTime(String billingStartTime) {
        this.billingStartTime = billingStartTime == null ? null : billingStartTime.trim();
    }

    public Integer getBillingExtension() {
        return billingExtension;
    }

    public void setBillingExtension(Integer billingExtension) {
        this.billingExtension = billingExtension;
    }

    public Integer getBillingExtensionType() {
        return billingExtensionType;
    }

    public void setBillingExtensionType(Integer billingExtensionType) {
        this.billingExtensionType = billingExtensionType;
    }

    public Integer getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(Integer billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public Integer getBillingPeriodType() {
        return billingPeriodType;
    }

    public void setBillingPeriodType(Integer billingPeriodType) {
        this.billingPeriodType = billingPeriodType;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

	public Integer getChargeUser() {
		return chargeUser;
	}

	public void setChargeUser(Integer chargeUser) {
		this.chargeUser = chargeUser;
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
}