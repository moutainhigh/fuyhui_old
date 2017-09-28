package com.fujfu.pojo.apply;

import java.math.BigDecimal;

public class ApplyRepayPlanPOJO {
	private int repayPeriod; // 期数
	private String repayReqTime; // 还款日期
	private BigDecimal repayCapital; // 本金
	private BigDecimal repayInterest; // 利息
	private int status; // 状态
	private String repayDoneCapital; // 实际本金
	private String repayDoneInterest; // 实际利息
	private String repayDoneTime;//实际还款日期
	
	public String getRepayDoneCapital() {
		return repayDoneCapital;
	}

	public void setRepayDoneCapital(String repayDoneCapital) {
		this.repayDoneCapital = repayDoneCapital;
	}

	public String getRepayDoneInterest() {
		return repayDoneInterest;
	}

	public void setRepayDoneInterest(String repayDoneInterest) {
		this.repayDoneInterest = repayDoneInterest;
	}

	public String getRepayDoneTime() {
		return repayDoneTime;
	}

	public void setRepayDoneTime(String repayDoneTime) {
		this.repayDoneTime = repayDoneTime;
	}

	public int getRepayPeriod() {
		return repayPeriod;
	}

	public void setRepayPeriod(int repayPeriod) {
		this.repayPeriod = repayPeriod;
	}

	public String getRepayReqTime() {
		return repayReqTime;
	}

	public void setRepayReqTime(String repayReqTime) {
		this.repayReqTime = repayReqTime;
	}

	public BigDecimal getRepayCapital() {
		return repayCapital;
	}

	public void setRepayCapital(BigDecimal repayCapital) {
		this.repayCapital = repayCapital;
	}

	public BigDecimal getRepayInterest() {
		return repayInterest;
	}

	public void setRepayInterest(BigDecimal repayInterest) {
		this.repayInterest = repayInterest;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
