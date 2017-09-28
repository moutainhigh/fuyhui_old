package com.fujfu.pojo.account;

import java.math.BigDecimal;

public class SiteBillingVO {
    private Integer id;

    private String fySerialno;

    private String outRealname;

    private String outUsername;

    private Integer outUserid;

    private String inRealname;

    private String inUsername;

    private Integer inUserid;

    private BigDecimal amt;

    private String siteBusiType;

    private Integer busiStatus;

    private Integer auditResults;

    private Integer auditStatus;

    private String siteBusiRem;

    private Integer created;

    private Integer updated;
    private String message;
    private String createdStr;

    public String getCreatedStr() {
		return createdStr;
	}

	public void setCreatedStr(String createdStr) {
		this.createdStr = createdStr;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFySerialno() {
        return fySerialno;
    }

    public void setFySerialno(String fySerialno) {
        this.fySerialno = fySerialno == null ? null : fySerialno.trim();
    }

    public String getOutRealname() {
        return outRealname;
    }

    public void setOutRealname(String outRealname) {
        this.outRealname = outRealname == null ? null : outRealname.trim();
    }

    public String getOutUsername() {
        return outUsername;
    }

    public void setOutUsername(String outUsername) {
        this.outUsername = outUsername == null ? null : outUsername.trim();
    }

    public Integer getOutUserid() {
        return outUserid;
    }

    public void setOutUserid(Integer outUserid) {
        this.outUserid = outUserid;
    }

    public String getInRealname() {
        return inRealname;
    }

    public void setInRealname(String inRealname) {
        this.inRealname = inRealname == null ? null : inRealname.trim();
    }

    public String getInUsername() {
        return inUsername;
    }

    public void setInUsername(String inUsername) {
        this.inUsername = inUsername == null ? null : inUsername.trim();
    }

    public Integer getInUserid() {
        return inUserid;
    }

    public void setInUserid(Integer inUserid) {
        this.inUserid = inUserid;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getSiteBusiType() {
        return siteBusiType;
    }

    public void setSiteBusiType(String siteBusiType) {
        this.siteBusiType = siteBusiType == null ? null : siteBusiType.trim();
    }

    public Integer getBusiStatus() {
        return busiStatus;
    }

    public void setBusiStatus(Integer busiStatus) {
        this.busiStatus = busiStatus;
    }

    public Integer getAuditResults() {
        return auditResults;
    }

    public void setAuditResults(Integer auditResults) {
        this.auditResults = auditResults;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getSiteBusiRem() {
        return siteBusiRem;
    }

    public void setSiteBusiRem(String siteBusiRem) {
        this.siteBusiRem = siteBusiRem == null ? null : siteBusiRem.trim();
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