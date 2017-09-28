package com.fujfu.pojo.account;

/**
 * 提现记录查询条件实体类
 * @author Administrator
 *
 */
public class UserWithdrawalDTO {
	private String username;// 用户名
	private String billno;// 流水号
	private int startTime;// 提现开始时间
	private int endTime;// 提现结束时间
	private String status;// 状态
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
