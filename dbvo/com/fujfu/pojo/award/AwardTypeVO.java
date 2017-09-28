package com.fujfu.pojo.award;

import java.math.BigDecimal;

public class AwardTypeVO {
    private Integer id;

    private String theme;

    private Integer startTime;

    private Integer endTime;

    private String activeObject;

    private String type;

    private BigDecimal amount;

    private String origin;

    private Integer term;

    private Integer status;

    private Long minAmount;

    private String limitProduct;

    private String limitTerm;

    private Integer created;
    
    private Integer dueStatus;

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

    public String getActiveObject() {
        return activeObject;
    }

    public void setActiveObject(String activeObject) {
        this.activeObject = activeObject == null ? null : activeObject.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Long minAmount) {
        this.minAmount = minAmount;
    }

    public String getLimitProduct() {
        return limitProduct;
    }

    public void setLimitProduct(String limitProduct) {
        this.limitProduct = limitProduct == null ? null : limitProduct.trim();
    }

    public String getLimitTerm() {
		return limitTerm;
	}

	public void setLimitTerm(String limitTerm) {
		this.limitTerm = limitTerm;
	}

	public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

	public Integer getDueStatus() {
		return dueStatus;
	}

	public void setDueStatus(Integer dueStatus) {
		this.dueStatus = dueStatus;
	}
    
}