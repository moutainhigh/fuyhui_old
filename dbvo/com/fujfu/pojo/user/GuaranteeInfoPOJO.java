package com.fujfu.pojo.user;

import java.math.BigDecimal;

public class GuaranteeInfoPOJO {
	/**
	 * 后台管理担保记录实体类
	 */
	private String realName;
	private Integer applyid;
	private String applyName;
	private BigDecimal amount;
	private Short period;
	private Integer created;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getApplyid() {
		return applyid;
	}

	public void setApplyid(Integer applyid) {
		this.applyid = applyid;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Short getPeriod() {
		return period;
	}

	public void setPeriod(Short period) {
		this.period = period;
	}

	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}
}