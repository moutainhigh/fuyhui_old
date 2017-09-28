package com.fujfu.pojo.apply;

import java.math.BigDecimal;

public class ApplyRecoverPOJO {
	private int repayPeriod; // 期数
	private String repayReqTime; // 还款日期
	private BigDecimal repayCapital; // 本金
	private BigDecimal repayInterest; // 利息
	private int status; // 状态

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
