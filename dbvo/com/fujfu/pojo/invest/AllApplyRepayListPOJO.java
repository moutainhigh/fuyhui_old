package com.fujfu.pojo.invest;

import java.math.BigDecimal;

public class AllApplyRepayListPOJO {
    private Integer id;
    private Byte status;
    private Byte repayStatus;

    private String userName;
    private String corpName;
	private String realname;

    private Integer applyId;

    private String repayType;

    private BigDecimal repayMoney;

    private BigDecimal repayRemain;
    
    private String repayFee;

    private String webPayDoneTime;//网站垫付时间
    private String repayDoneTime;//还款实际时间
    private String repay_req_time;//还款要求的时间
    private BigDecimal repayInterest;//利息
    private BigDecimal repayCapital;//本金
    private Integer repayPeriod;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getRepayDoneTime() {
		return repayDoneTime;
	}

	public void setRepayDoneTime(String repayDoneTime) {
		this.repayDoneTime = repayDoneTime;
	}

	public String getRepay_req_time() {
		return repay_req_time;
	}

	public void setRepay_req_time(String repay_req_time) {
		this.repay_req_time = repay_req_time;
	}

	public Integer getRepayPeriod() {
		return repayPeriod;
	}

	public void setRepayPeriod(Integer repayPeriod) {
		this.repayPeriod = repayPeriod;
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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Byte getRepayStatus() {
		return repayStatus;
	}

	public void setRepayStatus(Byte repayStatus) {
		this.repayStatus = repayStatus;
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
		this.repayType = repayType;
	}

	public BigDecimal getRepayMoney() {
		return repayMoney;
	}

	public void setRepayMoney(BigDecimal repayMoney) {
		this.repayMoney = repayMoney;
	}

	public BigDecimal getRepayRemain() {
		return repayRemain;
	}

	public void setRepayRemain(BigDecimal repayRemain) {
		this.repayRemain = repayRemain;
	}

	public String getRepayFee() {
		return repayFee;
	}

	public void setRepayFee(String repayFee) {
		this.repayFee = repayFee;
	}

	public String getWebPayDoneTime() {
		return webPayDoneTime;
	}

	public void setWebPayDoneTime(String webPayDoneTime) {
		this.webPayDoneTime = webPayDoneTime;
	}


}