package com.fujfu.pojo.invest;

import java.math.BigDecimal;

public class LoanInvestListPOJO {  
    private Integer id; //             借款id
    private String username;          //用户真实姓名
    private String order_number;      //借款编号
    private String userId; //             借款id
  
	private BigDecimal money;        //债权金额
    private Float apr;            //利率
    private Integer period;     //投资期限
    private String start_time; // 投资时间
    private Integer repay_status;   //far.status
    private Float investProgress;   //借款金额到位比例
    private Integer invest_id;  //投资id
	private BigDecimal expectinterest;// 投资预期利息
    private BigDecimal recover_money;// 回款金额
    private Integer recover_period; //回款期数
    private String recover_req_time;//下次回款日期
    private BigDecimal sumReMoney;//代收本息
    private Integer hasPeriod; //已还期数
    private Integer status;//状态 fla 的status
    private String nestRepayDate;//下一还款日
    private String finishDate;//结清日期
    private String claimNumber;//投资债权编号
    private String  loan_date;//投资日期字符串yyyymmdd
    private String  actPeriod;//实际期限
    private String name ; //项目名称
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getActPeriod() {
		return actPeriod;
	}
	public void setActPeriod(String actPeriod) {
		this.actPeriod = actPeriod;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
    public String getLoan_date() {
		return loan_date;
	}
	public void setLoan_date(String loan_date) {
		this.loan_date = loan_date;
	}
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	public BigDecimal getSumReMoney() {
		return sumReMoney;
	}
	public void setSumReMoney(BigDecimal sumReMoney) {
		this.sumReMoney = sumReMoney;
	}
	public Integer getHasPeriod() {
		return hasPeriod;
	}
	public void setHasPeriod(Integer hasPeriod) {
		this.hasPeriod = hasPeriod;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getNestRepayDate() {
		return nestRepayDate;
	}
	public void setNestRepayDate(String nestRepayDate) {
		this.nestRepayDate = nestRepayDate;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	public BigDecimal getRecover_money() {
		return recover_money;
	}
	public void setRecover_money(BigDecimal recover_money) {
		this.recover_money = recover_money;
	}
	public Integer getRecover_period() {
		return recover_period;
	}
	public void setRecover_period(Integer recover_period) {
		this.recover_period = recover_period;
	}
	
	public String getRecover_req_time() {
		return recover_req_time;
	}
	public void setRecover_req_time(String recover_req_time) {
		this.recover_req_time = recover_req_time;
	}
	public BigDecimal getExpectinterest() {
		return expectinterest;
	}
	public void setExpectinterest(BigDecimal expectinterest) {
		this.expectinterest = expectinterest;
	}

	public Integer getInvest_id() {
		return invest_id;
	}
	public void setInvest_id(Integer invest_id) {
		this.invest_id = invest_id;
	}
	public Float getInvestProgress() {
		return investProgress;
	}
	public void setInvestProgress(Float investProgress) {
		this.investProgress = investProgress;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
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

	
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public Integer getRepay_status() {
		return repay_status;
	}
	public void setRepay_status(Integer repay_status) {
		this.repay_status = repay_status;
	}

   
}