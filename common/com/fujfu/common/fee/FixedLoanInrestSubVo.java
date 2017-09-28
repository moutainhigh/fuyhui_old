package com.fujfu.common.fee;

import java.math.BigDecimal;

public class FixedLoanInrestSubVo {
	//利息当期期数
	private int period;
	
	//当期期利息
	private BigDecimal perIntrest;
	
	//当期开始时间
	private String startDate;
	
	//档期结束时间(yyyyMMdd)
	private String endDate;
	
	//当期剩余利息
	private BigDecimal remainIntrest;
	
	//剩余本息和 
	private BigDecimal remainSum;
	
	//本期应还金额
	private BigDecimal perSum;	
	
	//本期应还本金
	private BigDecimal perCapital;

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public BigDecimal getPerIntrest() {
		return perIntrest;
	}

	public void setPerIntrest(BigDecimal perIntrest) {
		this.perIntrest = perIntrest;
	}


	public BigDecimal getRemainIntrest() {
		return remainIntrest;
	}

	public void setRemainIntrest(BigDecimal remainIntrest) {
		this.remainIntrest = remainIntrest;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getRemainSum() {
		return remainSum;
	}

	public void setRemainSum(BigDecimal remainSum) {
		this.remainSum = remainSum;
	}

	public BigDecimal getPerSum() {
		return perSum;
	}

	public void setPerSum(BigDecimal perSum) {
		this.perSum = perSum;
	}

	public BigDecimal getPerCapital() {
		return perCapital;
	}

	public void setPerCapital(BigDecimal perCapital) {
		this.perCapital = perCapital;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	
	



	

}
