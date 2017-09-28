package com.fujfu.pojo.account;

import java.math.BigDecimal;

public class PoundageInfoVO {
    private Integer id;

    private Integer relativeid;

    private String relativetype;

    private BigDecimal poundageatm;

    private Integer createTime;

    private Integer userId;

    private Integer status;
    
    private String txn_ssn;
    private BigDecimal total;
    private BigDecimal cash;
    private BigDecimal frost; 
    private Integer feeid;
 
	public Integer getFeeid() {
		return feeid;
	}

	public void setFeeid(Integer feeid) {
		this.feeid = feeid;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getCash() {
		return cash;
	}

	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}

	public BigDecimal getFrost() {
		return frost;
	}

	public void setFrost(BigDecimal frost) {
		this.frost = frost;
	}

	public String getTxn_ssn() {
		return txn_ssn;
	}

	public void setTxn_ssn(String txn_ssn) {
		this.txn_ssn = txn_ssn;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRelativeid() {
        return relativeid;
    }

    public void setRelativeid(Integer relativeid) {
        this.relativeid = relativeid;
    }

    public String getRelativetype() {
        return relativetype;
    }

    public void setRelativetype(String relativetype) {
        this.relativetype = relativetype == null ? null : relativetype.trim();
    }

    public BigDecimal getPoundageatm() {
        return poundageatm;
    }

    public void setPoundageatm(BigDecimal poundageatm) {
        this.poundageatm = poundageatm;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}