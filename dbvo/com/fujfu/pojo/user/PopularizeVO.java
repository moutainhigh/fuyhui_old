package com.fujfu.pojo.user;

import java.math.BigDecimal;

public class PopularizeVO {
	private Integer popularizeId;

	private Integer userId;

	private Integer inviterId;

	private BigDecimal repayTips;

	private BigDecimal investTips;

	private Byte type;

	private String remark;

	private Integer adminId;

	private Boolean status;

	private Integer created;

	private Integer mtime;

	public Integer getPopularizeId() {
		return popularizeId;
	}

	public void setPopularizeId(Integer popularizeId) {
		this.popularizeId = popularizeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getInviterId() {
		return inviterId;
	}

	public void setInviterId(Integer inviterId) {
		this.inviterId = inviterId;
	}

	public BigDecimal getRepayTips() {
		return repayTips;
	}

	public void setRepayTips(BigDecimal repayTips) {
		this.repayTips = repayTips;
	}

	public BigDecimal getInvestTips() {
		return investTips;
	}

	public void setInvestTips(BigDecimal investTips) {
		this.investTips = investTips;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	public Integer getMtime() {
		return mtime;
	}

	public void setMtime(Integer mtime) {
		this.mtime = mtime;
	}
}