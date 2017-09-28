package com.fujfu.pojo.award;

public class AwardLogVO {
    private Integer id;

    private Integer typeId;

    private Integer userId;

    private Integer recomUser;

    private Byte status;

    private String investId;

    private Integer created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRecomUser() {
        return recomUser;
    }

    public void setRecomUser(Integer recomUser) {
        this.recomUser = recomUser;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getInvestId() {
        return investId;
    }

    public void setInvestId(String investId) {
        this.investId = investId == null ? null : investId.trim();
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }
}