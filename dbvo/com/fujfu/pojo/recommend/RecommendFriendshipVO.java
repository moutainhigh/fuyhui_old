package com.fujfu.pojo.recommend;

import java.math.BigDecimal;

public class RecommendFriendshipVO {
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
        this.investLoanName = investLoanName == null ? null : investLoanName.trim();
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
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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