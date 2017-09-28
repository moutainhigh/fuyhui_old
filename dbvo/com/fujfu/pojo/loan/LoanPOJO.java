package com.fujfu.pojo.loan;
/**
 * 标的实体类
 * @author jorden
 *
 */
public class LoanPOJO {
	private String id; // id
    private Integer userId;
	private String loanName; // 标的名
	private String apr; // 利率
	private String period; // 借款期限
	private String amount; // 金额
	private String investProgress = "0"; // 进度
	private String status; // 状态
	private String category; // 标的类型
	private String loanTime; // 放款时间
	private String paymentOptions; // 还款方式
	private String guaranteeCompany; // 担保公司
	private String guaranteeCompanyId; // 担保公司id
	private String orderNumber; // 编号
	private String startTime; // 投资开始时间
	private String endTime; // 投资截止时间
	private String investMin; // 最低起投金额
	private String remainAmount;// 剩余可投金额
	private String description;//项目描述
	
	private String realName;// 真实姓名
	private String tel;// 电话号码
	private String idCard;// 身份证号
	private String created;// 申请时间
	
	private String proAmount;// 递投金额
	
	private String projectSource;// 项目来源
	private String purpose;//借款用途
	
	private String companyName;// 公司名称
	private int isLoans;// 放款状态
	private String isCreatctra;// 是否已生成合同
	private String productUrl;// 合同模板及产品募集书目录
	
	private String dueTime; // 到期时间
	private String guaranteeMode;// 保障方式
	
	private Integer completeTime;// 筹款完成时间
	private String actPeriod; // 实际期限
	
	public String getActPeriod() {
		return actPeriod;
	}
	public void setActPeriod(String actPeriod) {
		this.actPeriod = actPeriod;
	}
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	public String getIsCreatctra() {
		return isCreatctra;
	}
	public void setIsCreatctra(String isCreatctra) {
		this.isCreatctra = isCreatctra;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	public String getApr() {
		return apr;
	}
	public void setApr(String apr) {
		this.apr = apr;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getInvestProgress() {
		return investProgress;
	}
	public void setInvestProgress(String investProgress) {
		this.investProgress = investProgress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentOptions() {
		return paymentOptions;
	}
	public void setPaymentOptions(String paymentOptions) {
		this.paymentOptions = paymentOptions;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getInvestMin() {
		return investMin;
	}
	public void setInvestMin(String investMin) {
		this.investMin = investMin;
	}
	public String getRemainAmount() {
		return remainAmount;
	}
	public void setRemainAmount(String remainAmount) {
		this.remainAmount = remainAmount;
	}
	public String getGuaranteeCompany() {
		return guaranteeCompany;
	}
	public void setGuaranteeCompany(String guaranteeCompany) {
		this.guaranteeCompany = guaranteeCompany;
	}
	public String getLoanTime() {
		return loanTime;
	}
	public void setLoanTime(String loanTime) {
		this.loanTime = loanTime;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getProAmount() {
		return proAmount;
	}
	public void setProAmount(String proAmount) {
		this.proAmount = proAmount;
	}
	public String getProjectSource() {
		return projectSource;
	}
	public void setProjectSource(String projectSource) {
		this.projectSource = projectSource;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getGuaranteeCompanyId() {
		return guaranteeCompanyId;
	}
	public void setGuaranteeCompanyId(String guaranteeCompanyId) {
		this.guaranteeCompanyId = guaranteeCompanyId;
	}
	public int getIsLoans() {
		return isLoans;
	}
	public void setIsLoans(int isLoans) {
		this.isLoans = isLoans;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDueTime() {
		return dueTime;
	}
	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
	}
	public String getGuaranteeMode() {
		return guaranteeMode;
	}
	public void setGuaranteeMode(String guaranteeMode) {
		this.guaranteeMode = guaranteeMode;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Integer getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(Integer completeTime) {
		this.completeTime = completeTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}	
