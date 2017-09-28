package com.fujfu.pojo.recommend;

import java.math.BigDecimal;

public class RecommendSettingVO {
    private Integer id;

    private String theme;

    private Integer startTime;

    private Integer endTime;

    private String status;

    private Integer term;

    private BigDecimal monthLimit;

    private Integer created;

    private Integer updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public BigDecimal getMonthLimit() {
        return monthLimit;
    }

    public void setMonthLimit(BigDecimal monthLimit) {
        this.monthLimit = monthLimit;
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