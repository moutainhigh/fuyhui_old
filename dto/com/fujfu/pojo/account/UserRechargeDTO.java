package com.fujfu.pojo.account;

/**
 * 充值记录查询条件实体类
 * @author Administrator
 *
 */
public class UserRechargeDTO {
	private String username;// 用户名
	private String billno;// 流水号
	private int startTime;// 充值开始时间
	private int endTime;// 充值结束时间
	private String status;// 状态
	private int allStartTime;// 充值开始时间
	private int allEndTime;// 充值结束时间
	private String userID;// 用户id
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getAllStartTime() {
		return allStartTime;
	}

	public void setAllStartTime(int allStartTime) {
		this.allStartTime = allStartTime;
	}

	public int getAllEndTime() {
		return allEndTime;
	}

	public void setAllEndTime(int allEndTime) {
		this.allEndTime = allEndTime;
	}

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
