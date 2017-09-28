package com.fujfu.pojo.account;

import java.math.BigDecimal;

public class SiteAccountVO {
    private Integer id;

    private String feeId;

    private String name;

    private BigDecimal total;

    private BigDecimal income;

    private BigDecimal expend;

    private Integer created;

    private Byte noShow;

    private Byte type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId == null ? null : feeId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getExpend() {
        return expend;
    }

    public void setExpend(BigDecimal expend) {
        this.expend = expend;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Byte getNoShow() {
        return noShow;
    }

    public void setNoShow(Byte noShow) {
        this.noShow = noShow;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}