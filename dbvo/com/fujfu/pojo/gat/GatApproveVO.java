package com.fujfu.pojo.gat;

public class GatApproveVO {
    private Integer id;

    private Integer userId;

    private Integer cardType;

    private String cardId;

    private String cardIdPic;

    private String mobile;

    private String realname;

    private String bank;

    private String cardNumber;

    private String bankCardPic;

    private Integer province;

    private Integer city;

    private String branch;

    private String cashPassword;

    private String approveStatus;

    private String approveRemark;

    private String approveUser;

    private Integer created;

    private Integer updated;
    private String cardTypeName;
    private String bankName;
    private String cityName;
    private String provinceName;
    private String card2Pic; //证件反面图片url
    
    public String getCard2Pic() {
		return card2Pic;
	}

	public void setCard2Pic(String card2Pic) {
		this.card2Pic = card2Pic;
	}

	public String getCardTypeName() {
		return cardTypeName;
	}

	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getCardIdPic() {
        return cardIdPic;
    }

    public void setCardIdPic(String cardIdPic) {
        this.cardIdPic = cardIdPic == null ? null : cardIdPic.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public String getBankCardPic() {
        return bankCardPic;
    }

    public void setBankCardPic(String bankCardPic) {
        this.bankCardPic = bankCardPic == null ? null : bankCardPic.trim();
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch == null ? null : branch.trim();
    }

    public String getCashPassword() {
        return cashPassword;
    }

    public void setCashPassword(String cashPassword) {
        this.cashPassword = cashPassword == null ? null : cashPassword.trim();
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus == null ? null : approveStatus.trim();
    }

    public String getApproveRemark() {
        return approveRemark;
    }

    public void setApproveRemark(String approveRemark) {
        this.approveRemark = approveRemark == null ? null : approveRemark.trim();
    }

    public String getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(String approveUser) {
        this.approveUser = approveUser == null ? null : approveUser.trim();
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