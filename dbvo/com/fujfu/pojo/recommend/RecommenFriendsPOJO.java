package com.fujfu.pojo.recommend;

import java.math.BigDecimal;

public class RecommenFriendsPOJO {
	private Integer id;

	private Integer recommendUserId;

	private Integer recommendRefUserId;

	private Integer registTime;

	private Integer rewardTerm;

	private Integer investLoanId;

	private String investLoanName;

	private BigDecimal investAmount;

	private Integer investTime;

	private Integer loanTime;

	private BigDecimal rewardAmount;

	private Integer rewardTime;

	private String status;

	private String remark;

	private Integer created;

	private Integer updated;

	private String userName;
	private String realName;
	private String investTimeStr;
	private String registTimeStr;
	private String rewardTermStr;

	public String getInvestTimeStr() {
		return investTimeStr;
	}

	public void setInvestTimeStr(String investTimeStr) {
		this.investTimeStr = investTimeStr;
	}

	public String getRegistTimeStr() {
		return registTimeStr;
	}

	public void setRegistTimeStr(String registTimeStr) {
		this.registTimeStr = registTimeStr;
	}

	public String getRewardTermStr() {
		return rewardTermStr;
	}

	public void setRewardTermStr(String rewardTermStr) {
		this.rewardTermStr = rewardTermStr;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRecommendUserId() {
		return recommendUserId;
	}

	public void setRecommendUserId(Integer recommendUserId) {
		this.recommendUserId = recommendUserId;
	}

	public Integer getRecommendRefUserId() {
		return recommendRefUserId;
	}

	public void setRecommendRefUserId(Integer recommendRefUserId) {
		this.recommendRefUserId = recommendRefUserId;
	}

	public Integer getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Integer registTime) {
		this.registTime = registTime;
	}

	public Integer getRewardTerm() {
		return rewardTerm;
	}

	public void setRewardTerm(Integer rewardTerm) {
		this.rewardTerm = rewardTerm;
	}

	public Integer getInvestLoanId() {
		return investLoanId;
	}

	public void setInvestLoanId(Integer investLoanId) {
		this.investLoanId = investLoanId;
	}

	public String getInvestLoanName() {
		return investLoanName;
	}

	public void setInvestLoanName(String investLoanName) {
		this.investLoanName = investLoanName;
	}

	public BigDecimal getInvestAmount() {
		return investAmount;
	}

	public void setInvestAmount(BigDecimal investAmount) {
		this.investAmount = investAmount;
	}

	public Integer getInvestTime() {
		return investTime;
	}

	public void setInvestTime(Integer investTime) {
		this.investTime = investTime;
	}

	public Integer getLoanTime() {
		return loanTime;
	}

	public void setLoanTime(Integer loanTime) {
		this.loanTime = loanTime;
	}

	public BigDecimal getRewardAmount() {
		return rewardAmount;
	}

	public void setRewardAmount(BigDecimal rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	public Integer getRewardTime() {
		return rewardTime;
	}

	public void setRewardTime(Integer rewardTime) {
		this.rewardTime = rewardTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	public Integer getUpdated() {
		return updated;
	}

	public void setUpdated(Integer updated) {
		this.updated = updated;
	}

}