package com.fujfu.pojo.admin;
/*huangfeng
 * 查询条件 投资 借款 还款 回款都有涉及
 */

public class LoanInvestPOJO {
	private String username;
	private String id; //债权编号
	private Integer apply_id ;//借款编号
	private Integer invest_id;
	private Integer user_id;
	private String status;//fu_loan_apply 的status
	
	private String farstatus;//fu_apply_recover 的status 
	
	private String busitype;//1 金猪 2 金桔

	public String getBusitype() {
		return busitype;
	}

	public void setBusitype(String busitype) {
		this.busitype = busitype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getApply_id() {
		return apply_id;
	}

	public void setApply_id(Integer apply_id) {
		this.apply_id = apply_id;
	}

	public Integer getInvest_id() {
		return invest_id;
	}

	public void setInvest_id(Integer invest_id) {
		this.invest_id = invest_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFarstatus() {
		return farstatus;
	}

	public void setFarstatus(String farstatus) {
		this.farstatus = farstatus;
	}
	
	

}
