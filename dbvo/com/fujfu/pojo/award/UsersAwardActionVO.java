package com.fujfu.pojo.award;

public class UsersAwardActionVO {
    private Integer id;

    private String rewardId;

    private Integer investerId;

    private String fySerialno;

    private Integer status;

    private Integer created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRewardId() {
		return rewardId;
	}

	public void setRewardId(String rewardId) {
		this.rewardId = rewardId;
	}

	public Integer getInvesterId() {
        return investerId;
    }

    public void setInvesterId(Integer investerId) {
        this.investerId = investerId;
    }

    public String getFySerialno() {
        return fySerialno;
    }

    public void setFySerialno(String fySerialno) {
        this.fySerialno = fySerialno == null ? null : fySerialno.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }
}