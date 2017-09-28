package com.fujfu.pojo.invest;

import java.math.BigDecimal;

public class LoanApplyListPOJO {
    private Integer id;
    private String realname;
    private String guarantee_company_name;

    private BigDecimal amount;
    private Float apr;
    private Integer period;
    private Integer loan_time;
    private Integer repay_status; //fu_loan_apply 表的status
    private String order_number;
    private Integer repay_period;//还款期数
    private BigDecimal repay_money;//还款金额
    private  String name ;//借款标题
    private String ydiank;//已垫付金额
    private String wdiank;//未垫付金额
    private String loanTimeStr;//loan_time时间的String
    private BigDecimal alreadyRepayMoney;//已还金额
    private BigDecimal waiRepayMoney;//待还金额
    private String  corpName; //公司名称
    private String   userName;//用户名
    
    private String   isLoans;//状态 is_loans
    private Integer actPeriod;//实际期限
	public Integer getActPeriod() {
		return actPeriod;
	}
	public void setActPeriod(Integer actPeriod) {
		this.actPeriod = actPeriod;
	}
	public String getIsLoans() {
		return isLoans;
	}
	public void setIsLoans(String isLoans) {
		this.isLoans = isLoans;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public BigDecimal getAlreadyRepayMoney() {
		return alreadyRepayMoney;
	}
	public void setAlreadyRepayMoney(BigDecimal alreadyRepayMoney) {
		this.alreadyRepayMoney = alreadyRepayMoney;
	}
	public BigDecimal getWaiRepayMoney() {
		return waiRepayMoney;
	}
	public void setWaiRepayMoney(BigDecimal waiRepayMoney) {
		this.waiRepayMoney = waiRepayMoney;
	}
	public String getLoanTimeStr() {
		return loanTimeStr;
	}
	public void setLoanTimeStr(String loanTimeStr) {
		this.loanTimeStr = loanTimeStr;
	}
	public String getYdiank() {
		return ydiank;
	}
	public void setYdiank(String ydiank) {
		this.ydiank = ydiank;
	}
	public String getWdiank() {
		return wdiank;
	}
	public void setWdiank(String wdiank) {
		this.wdiank = wdiank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public Integer getRepay_period() {
		return repay_period;
	}
	public void setRepay_period(Integer repay_period) {
		this.repay_period = repay_period;
	}
	public BigDecimal getRepay_money() {
		return repay_money;
	}
	public void setRepay_money(BigDecimal repay_money) {
		this.repay_money = repay_money;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getGuarantee_company_name() {
		return guarantee_company_name;
	}
	public void setGuarantee_company_name(String guarantee_company_name) {
		this.guarantee_company_name = guarantee_company_name;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Float getApr() {
		return apr;
	}
	public void setApr(Float apr) {
		this.apr = apr;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public Integer getLoan_time() {
		return loan_time;
	}
	public void setLoan_time(Integer loan_time) {
		this.loan_time = loan_time;
	}
	public Integer getRepay_status() {
		return repay_status;
	}
	public void setRepay_status(Integer repay_status) {
		this.repay_status = repay_status;
	}
	

   
}