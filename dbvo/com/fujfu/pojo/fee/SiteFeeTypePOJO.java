package com.fujfu.pojo.fee;

import java.math.BigDecimal;

public class SiteFeeTypePOJO {
	private Integer id;
	private Integer chargeUser;
	private String chargeItem;
	private String chargeTime;
	private String feeName;
	private String billingStartTime;
	private Integer billingExtension;
	private Integer billingPeriod;
	private Integer created;
	private String userType;
	private Integer formulaType;
    private BigDecimal amount;
    private BigDecimal interestRate; 
    private Integer chargeFeeId;
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getChargeUser() {
		return chargeUser;
	}
	public void setChargeUser(Integer chargeUser) {
		this.chargeUser = chargeUser;
	}
	public String getChargeItem() {
		return chargeItem;
	}
	public void setChargeItem(String chargeItem) {
		this.chargeItem = chargeItem;
	}
	public String getFeeName() {
		return feeName;
	}
	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}
	public String getBillingStartTime() {
		return billingStartTime;
	}
	public void setBillingStartTime(String billingStartTime) {
		this.billingStartTime = billingStartTime;
	}
	public Integer getBillingExtension() {
		return billingExtension;
	}
	public void setBillingExtension(Integer billingExtension) {
		this.billingExtension = billingExtension;
	}
	public Integer getBillingPeriod() {
		return billingPeriod;
	}
	public void setBillingPeriod(Integer billingPeriod) {
		this.billingPeriod = billingPeriod;
	}
	public Integer getCreated() {
		return created;
	}
	public void setCreated(Integer created) {
		this.created = created;
	}
	public String getChargeTime() {
		return chargeTime;
	}
	public void setChargeTime(String chargeTime) {
		this.chargeTime = chargeTime;
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
	public Integer getChargeFeeId() {
		return chargeFeeId;
	}
	public void setChargeFeeId(Integer chargeFeeId) {
		this.chargeFeeId = chargeFeeId;
	}
}
