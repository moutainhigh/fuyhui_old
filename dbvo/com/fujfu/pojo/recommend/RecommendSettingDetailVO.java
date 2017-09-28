package com.fujfu.pojo.recommend;

import java.math.BigDecimal;

public class RecommendSettingDetailVO {
    private Integer id;

    private Integer themeId;

    private String theme;

    private BigDecimal levelMinAmount;

    private BigDecimal levelMaxAmount;

    private BigDecimal amount;

    private Integer created;

    private Integer updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public BigDecimal getLevelMinAmount() {
        return levelMinAmount;
    }

    public void setLevelMinAmount(BigDecimal levelMinAmount) {
        this.levelMinAmount = levelMinAmount;
    }

    public BigDecimal getLevelMaxAmount() {
        return levelMaxAmount;
    }

    public void setLevelMaxAmount(BigDecimal levelMaxAmount) {
        this.levelMaxAmount = levelMaxAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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