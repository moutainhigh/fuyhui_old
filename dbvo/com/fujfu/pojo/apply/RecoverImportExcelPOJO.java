package com.fujfu.pojo.apply;

public class RecoverImportExcelPOJO{  
    private String  repay_done_time;
    private String  listingCode;

    private String  recoverPeriod;
    private String  StagingCode;
    private String  cardId;
	private String  valuedate;
    private String  maturitydate;
    private String repay_req_time;

	private String  realName;
    private String  cardTypeName;

    private String  recover_money;
    
    private String  recover_capital;
    private String  recover_interest;
    private String  overdueInterest;
    private String  serialno1;//银行/第三方流水号
    private String  cashingPassage;//兑付通道(银行/第三方)
    private String  serialno2;//合作方兑付流水号
    private String  loanName;//
    public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
    public String getRecoverPeriod() {
		return recoverPeriod;
	}
	public void setRecoverPeriod(String recoverPeriod) {
		this.recoverPeriod = recoverPeriod;
	}
    public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	public String getRepay_req_time() {
		return repay_req_time;
	}
	public void setRepay_req_time(String repay_req_time) {
		this.repay_req_time = repay_req_time;
	}
	public String getRepay_done_time() {
		return repay_done_time;
	}
	public void setRepay_done_time(String repay_done_time) {
		this.repay_done_time = repay_done_time;
	}
	public String getListingCode() {
		return listingCode;
	}
	public void setListingCode(String listingCode) {
		this.listingCode = listingCode;
	}
	
	public String getStagingCode() {
		return StagingCode;
	}
	public void setStagingCode(String stagingCode) {
		StagingCode = stagingCode;
	}
	public String getValuedate() {
		return valuedate;
	}
	public void setValuedate(String valuedate) {
		this.valuedate = valuedate;
	}
	public String getMaturitydate() {
		return maturitydate;
	}
	public void setMaturitydate(String maturitydate) {
		this.maturitydate = maturitydate;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCardTypeName() {
		return cardTypeName;
	}
	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}

	public String getRecover_money() {
		return recover_money;
	}
	public void setRecover_money(String recover_money) {
		this.recover_money = recover_money;
	}
	public String getRecover_capital() {
		return recover_capital;
	}
	public void setRecover_capital(String recover_capital) {
		this.recover_capital = recover_capital;
	}
	public String getRecover_interest() {
		return recover_interest;
	}
	public void setRecover_interest(String recover_interest) {
		this.recover_interest = recover_interest;
	}
	public String getOverdueInterest() {
		return overdueInterest;
	}
	public void setOverdueInterest(String overdueInterest) {
		this.overdueInterest = overdueInterest;
	}
	public String getSerialno1() {
		return serialno1;
	}
	public void setSerialno1(String serialno1) {
		this.serialno1 = serialno1;
	}
	public String getCashingPassage() {
		return cashingPassage;
	}
	public void setCashingPassage(String cashingPassage) {
		this.cashingPassage = cashingPassage;
	}
	public String getSerialno2() {
		return serialno2;
	}
	public void setSerialno2(String serialno2) {
		this.serialno2 = serialno2;
	}

	
}