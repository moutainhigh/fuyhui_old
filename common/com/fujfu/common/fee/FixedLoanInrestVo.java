package com.fujfu.common.fee;

import java.util.ArrayList;

import java.math.BigDecimal;



public class FixedLoanInrestVo {
	
	//起始日期（yyyyMMdd）
	private String startDate;
	
	// 结束日期（yyyyMMdd）
	//结束日期
	private String endDate;
	
	
	//指定还款日
	private Integer payDay;
	
	
	//线下分期放款日
	private String offLineLoanDate;
	

	//总的本金金额
	private BigDecimal totalCaptital;
	
	//总过得利息金额
	private BigDecimal totalIntrest;
	
	//总的本息和
	private BigDecimal totalRepayment;
	
	//利息周期方式（利息月份间隔数，0代表一次性）
	private int perIntrestDuration;
	
	//p
	
	//总的利息还款期数
	private int totalPeriod;
	
	//利息计划明细
	private ArrayList<FixedLoanInrestSubVo> periodDetail;
	
	//年化利率
	private BigDecimal rate;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getTotalCaptital() {
		return totalCaptital;
	}

	public void setTotalCaptital(BigDecimal totalCaptital) {
		this.totalCaptital = totalCaptital;
	}

	public BigDecimal getTotalIntrest() {
		return totalIntrest;
	}

	public void setTotalIntrest(BigDecimal totalIntrest) {
		this.totalIntrest = totalIntrest;
	}

	public BigDecimal getTotalRepayment() {
		return totalRepayment;
	}

	public void setTotalRepayment(BigDecimal totalRepayment) {
		this.totalRepayment = totalRepayment;
	}

	public int getPerIntrestDuration() {
		return perIntrestDuration;
	}

	public void setPerIntrestDuration(int perIntrestDuration) {
		this.perIntrestDuration = perIntrestDuration;
	}

	public int getTotalPeriod() {
		return totalPeriod;
	}

	public void setTotalPeriod(int totalPeriod) {
		this.totalPeriod = totalPeriod;
	}

	public ArrayList<FixedLoanInrestSubVo> getPeriodDetail() {
		return periodDetail;
	}

	public void setPeriodDetail(ArrayList<FixedLoanInrestSubVo> periodDetail) {
		this.periodDetail = periodDetail;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Integer getPayDay() {
		return payDay;
	}

	public void setPayDay(Integer payDay) {
		this.payDay = payDay;
	}

	public String getOffLineLoanDate() {
		return offLineLoanDate;
	}

	public void setOffLineLoanDate(String offLineLoanDate) {
		this.offLineLoanDate = offLineLoanDate;
	}




}
