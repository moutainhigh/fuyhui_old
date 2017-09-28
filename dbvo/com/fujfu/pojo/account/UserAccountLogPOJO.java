package com.fujfu.pojo.account;

/**
 * 交易明细记录查询条件实体类
 * @author huangfeng
 *
 */
public class UserAccountLogPOJO {

	private String type;// 状态
	private int startTime;// 开始时间
	private int endTime;// 结束时间
	private int userId; //用户编号
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
