package com.fujfu.pojo.user;

public class UserVO {
	private Integer userId;

	private String username;

	private String password;

	private String realname;

	private String affix;

	private Integer cardType;

	private String cardId;

	private String mobile;

	private String email;

	private Byte status;

	private Boolean everUpdUsername;

	private Boolean vip;

	private Integer score;

	private Byte errornum;

	private Integer isLock;

	private Integer lockTime;

	private String uniqid;

	private String appUniqid;

	private String payPassword;

	private String target;

	private String avatar;

	private String regIp;

	private String country;

	private String province;

	private String city;

	private Integer loginTimes;

	private Integer lastLoginTime;

	private String regArea;

	private Integer created;

	private String city_id; // 开户行地区市县代码

	private String parent_bank_id;// 开户行行别

	private String bank_nm;// 开户行支行名称

	private String capAcntNo;// 帐号

	private String userType;// 客户类型1个人，2企业，3担保

	private String corpName;// 企业名称

	private String city_name;// 城市名称

	private String country_id;// 省份代码

	private String country_name;// 企业名称

	private String parent_bank_name;// 开户行行名

	private String corpIntro; // 公司介绍

	private String busSituation; // 经营情况

	private String jzhloginid; // 金账户登录号

	private Integer userNameStatus; // 用户名只能改一次，所以加字段

	private String address; // 地址

	private String countryCode1; // 常用地址 省份代码

	private String countryCode2; // 常用地址 城市代码

	private String countryCode3; // 家庭住址 县城代码

	private String startUserName; // 注册时的用户名，一般为手机号

	private Integer isInside; // 是否内部员工

	private String contactPerson; // 联系人姓名

	private String contactMobile; // 联系人手机号码

	private String assessmentResult; // 风险测评结果

	private String cardPic; // 证件图片url

	private String bankCardPic; // 银行卡图片url

	private String card2Pic; // 证件反面图片url

	public String getCardPic() {
		return cardPic;
	}

	public void setCardPic(String cardPic) {
		this.cardPic = cardPic;
	}

	public String getBankCardPic() {
		return bankCardPic;
	}

	public void setBankCardPic(String bankCardPic) {
		this.bankCardPic = bankCardPic;
	}

	public String getAssessmentResult() {
		return assessmentResult;
	}

	public void setAssessmentResult(String assessmentResult) {
		this.assessmentResult = assessmentResult;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getStartUserName() {
		return startUserName;
	}

	public void setStartUserName(String startUserName) {
		this.startUserName = startUserName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountryCode1() {
		return countryCode1;
	}

	public void setCountryCode1(String countryCode1) {
		this.countryCode1 = countryCode1;
	}

	public String getCountryCode2() {
		return countryCode2;
	}

	public void setCountryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
	}

	public String getCountryCode3() {
		return countryCode3;
	}

	public void setCountryCode3(String countryCode3) {
		this.countryCode3 = countryCode3;
	}

	public Integer getUserNameStatus() {
		return userNameStatus;
	}

	public void setUserNameStatus(Integer userNameStatus) {
		this.userNameStatus = userNameStatus;
	}

	public String getJzhloginid() {
		return jzhloginid;
	}

	public void setJzhloginid(String jzhloginid) {
		this.jzhloginid = jzhloginid;
	}

	public String getCorpIntro() {
		return corpIntro;
	}

	public void setCorpIntro(String corpIntro) {
		this.corpIntro = corpIntro;
	}

	public String getBusSituation() {
		return busSituation;
	}

	public void setBusSituation(String busSituation) {
		this.busSituation = busSituation;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getParent_bank_name() {
		return parent_bank_name;
	}

	public void setParent_bank_name(String parent_bank_name) {
		this.parent_bank_name = parent_bank_name;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getParent_bank_id() {
		return parent_bank_id;
	}

	public void setParent_bank_id(String parent_bank_id) {
		this.parent_bank_id = parent_bank_id;
	}

	public String getBank_nm() {
		return bank_nm;
	}

	public void setBank_nm(String bank_nm) {
		this.bank_nm = bank_nm;
	}

	public String getCapAcntNo() {
		return capAcntNo;
	}

	public void setCapAcntNo(String capAcntNo) {
		this.capAcntNo = capAcntNo;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Boolean getEverUpdUsername() {
		return everUpdUsername;
	}

	public void setEverUpdUsername(Boolean everUpdUsername) {
		this.everUpdUsername = everUpdUsername;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Byte getErrornum() {
		return errornum;
	}

	public void setErrornum(Byte errornum) {
		this.errornum = errornum;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	public Integer getLockTime() {
		return lockTime;
	}

	public void setLockTime(Integer lockTime) {
		this.lockTime = lockTime;
	}

	public String getUniqid() {
		return uniqid;
	}

	public void setUniqid(String uniqid) {
		this.uniqid = uniqid == null ? null : uniqid.trim();
	}

	public String getAppUniqid() {
		return appUniqid;
	}

	public void setAppUniqid(String appUniqid) {
		this.appUniqid = appUniqid == null ? null : appUniqid.trim();
	}

	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword == null ? null : payPassword.trim();
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target == null ? null : target.trim();
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar == null ? null : avatar.trim();
	}

	public String getRegIp() {
		return regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp == null ? null : regIp.trim();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country == null ? null : country.trim();
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	public Integer getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}

	public Integer getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Integer lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getRegArea() {
		return regArea;
	}

	public void setRegArea(String regArea) {
		this.regArea = regArea == null ? null : regArea.trim();
	}

	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname == null ? null : realname.trim();
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId == null ? null : cardId.trim();
	}

	public String getAffix() {
		return affix;
	}

	public void setAffix(String affix) {
		this.affix = affix == null ? null : affix.trim();
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public Integer getIsInside() {
		return isInside;
	}

	public void setIsInside(Integer isInside) {
		this.isInside = isInside;
	}

	public String getCard2Pic() {
		return card2Pic;
	}

	public void setCard2Pic(String card2Pic) {
		this.card2Pic = card2Pic;
	}

}