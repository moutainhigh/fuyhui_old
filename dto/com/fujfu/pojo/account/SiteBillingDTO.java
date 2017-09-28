package com.fujfu.pojo.account;

public class SiteBillingDTO {
	
	private int startTime;
	private int endTime;
	private String outUsername;
	private Integer outUserid;
	private String inUsername;
	private Integer inUserid;
	private String siteBusiType;
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
	public String getOutUsername() {
		return outUsername;
	}
	public void setOutUsername(String outUsername) {
		this.outUsername = outUsername;
	}
	public Integer getOutUserid() {
		return outUserid;
	}
	public void setOutUserid(Integer outUserid) {
		this.outUserid = outUserid;
	}
	public String getInUsername() {
		return inUsername;
	}
	public void setInUsername(String inUsername) {
		this.inUsername = inUsername;
	}
	public Integer getInUserid() {
		return inUserid;
	}
	public void setInUserid(Integer inUserid) {
		this.inUserid = inUserid;
	}
	public String getSiteBusiType() {
		return siteBusiType;
	}
	public void setSiteBusiType(String siteBusiType) {
		this.siteBusiType = siteBusiType;
	}


	

}
