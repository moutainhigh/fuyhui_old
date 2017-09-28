package com.fujfu.pojo.loan;

import java.math.BigDecimal;

public class LoanTypeVO {
    private Integer id;

    private String name;

    private String category;

    private BigDecimal quotaMin;

    private BigDecimal quotaMax;

    private BigDecimal proAmount;

    private Float aprMin;

    private Float aprMax;

    private Byte periodMin;

    private Short periodMax;

    private Byte validity;

    private Integer status;

    private String url;

    private Integer mtime;

    private Integer created;
    
    private String productSource;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public BigDecimal getQuotaMin() {
        return quotaMin;
    }

    public void setQuotaMin(BigDecimal quotaMin) {
        this.quotaMin = quotaMin;
    }

    public BigDecimal getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(BigDecimal quotaMax) {
        this.quotaMax = quotaMax;
    }

    public BigDecimal getProAmount() {
        return proAmount;
    }

    public void setProAmount(BigDecimal proAmount) {
        this.proAmount = proAmount;
    }

    public Float getAprMin() {
        return aprMin;
    }

    public void setAprMin(Float aprMin) {
        this.aprMin = aprMin;
    }

    public Float getAprMax() {
        return aprMax;
    }

    public void setAprMax(Float aprMax) {
        this.aprMax = aprMax;
    }

    public Byte getPeriodMin() {
        return periodMin;
    }

    public void setPeriodMin(Byte periodMin) {
        this.periodMin = periodMin;
    }

    public Short getPeriodMax() {
        return periodMax;
    }

    public void setPeriodMax(Short periodMax) {
        this.periodMax = periodMax;
    }

    public Byte getValidity() {
        return validity;
    }

    public void setValidity(Byte validity) {
        this.validity = validity;
    }

    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getMtime() {
        return mtime;
    }

    public void setMtime(Integer mtime) {
        this.mtime = mtime;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

	public String getProductSource() {
		return productSource;
	}

	public void setProductSource(String productSource) {
		this.productSource = productSource;
	}

}