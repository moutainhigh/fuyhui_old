package com.fujfu.pojo.recommend;

import java.math.BigDecimal;

public class RecommendRewardPOJO {
	private Integer recommendUserId;
	private String userName;
	private String realName;
	private Integer totalNum;
	private Integer effectNum;
	private BigDecimal totalMoney;
	
	public Integer getRecommendUserId() {
		return recommendUserId;
	}
	public void setRecommendUserId(Integer recommendUserId) {
		this.recommendUserId = recommendUserId;
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
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Integer getEffectNum() {
		return effectNum;
	}
	public void setEffectNum(Integer effectNum) {
		this.effectNum = effectNum;
	}
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	
}
