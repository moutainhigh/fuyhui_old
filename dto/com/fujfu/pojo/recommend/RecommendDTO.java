package com.fujfu.pojo.recommend;

public class RecommendDTO {
	private String busername; //被推荐人姓名
	private int startTime; //开始时间
	private int endTime;	//结束时间
	
	public String getBusername() {
		return busername;
	}
	public void setBusername(String busername) {
		this.busername = busername;
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
	
}
