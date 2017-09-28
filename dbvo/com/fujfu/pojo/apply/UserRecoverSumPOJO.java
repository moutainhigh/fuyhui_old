package com.fujfu.pojo.apply;

import java.math.BigDecimal;

public class UserRecoverSumPOJO {
	private BigDecimal sumReceipts; // 累计收益
	private BigDecimal sumInterest; // 累计利息
	private BigDecimal sumCapital; // 累计本金
	public BigDecimal getSumReceipts() {
		return sumReceipts;
	}
	public void setSumReceipts(BigDecimal sumReceipts) {
		this.sumReceipts = sumReceipts;
	}
	public BigDecimal getSumInterest() {
		return sumInterest;
	}
	public void setSumInterest(BigDecimal sumInterest) {
		this.sumInterest = sumInterest;
	}
	public BigDecimal getSumCapital() {
		return sumCapital;
	}
	public void setSumCapital(BigDecimal sumCapital) {
		this.sumCapital = sumCapital;
	}
}