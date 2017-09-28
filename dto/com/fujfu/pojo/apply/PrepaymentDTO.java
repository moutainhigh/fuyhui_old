package com.fujfu.pojo.apply;

import java.math.BigDecimal;

/**
 * 提前还款serviceBean
 * @author jorden
 *
 */
public class PrepaymentDTO {
	private BigDecimal repayMoney; //待还本金
	private BigDecimal profit; //预期收益
	private BigDecimal pSerFee; //提前还款服务费
	private BigDecimal financeSerfee; //当前融资服务费
	private BigDecimal totalRepay; //提前还款总额
	
	public BigDecimal getRepayMoney() {
		return repayMoney;
	}
	public void setRepayMoney(BigDecimal repayMoney) {
		this.repayMoney = repayMoney;
	}
	public BigDecimal getProfit() {
		return profit;
	}
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}
	public BigDecimal getpSerFee() {
		return pSerFee;
	}
	public void setpSerFee(BigDecimal pSerFee) {
		this.pSerFee = pSerFee;
	}
	public BigDecimal getFinanceSerfee() {
		return financeSerfee;
	}
	public void setFinanceSerfee(BigDecimal financeSerfee) {
		this.financeSerfee = financeSerfee;
	}
	public BigDecimal getTotalRepay() {
		return totalRepay;
	}
	public void setTotalRepay(BigDecimal totalRepay) {
		this.totalRepay = totalRepay;
	}
}
