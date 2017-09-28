package com.fujfu.pojo.account;

import com.fujfu.pojo.account.SiteAccountLogVO;

public class SiteAccountLogDTO extends SiteAccountLogVO {
	private String feeName;
	private String userName;
	public String getFeeName() {
		return feeName;
	}
	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
