package com.fujfu.pojo.common;

public class TokenVO {
    private Integer userId;

    private String mobile;

    private String tokenId;

    private Integer lastActivity;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId == null ? null : tokenId.trim();
    }

    public Integer getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Integer lastActivity) {
        this.lastActivity = lastActivity;
    }
}