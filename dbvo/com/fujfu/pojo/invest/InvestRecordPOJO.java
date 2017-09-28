package com.fujfu.pojo.invest;

import com.fujfu.common.util.StringUtil;

/**
 * 投资记录实体类
 * @author jorden
 *
 */
public class InvestRecordPOJO {
	private String mobile;// 手机号码
	private String userName; // 用户名
	private String amount; // 投资金额
	private String investTime; // 投资时间
	
	public String getUserName() {
		if(this.mobile.equals(this.userName)){
			return StringUtil.handlePhone(mobile);
		}else{
			return StringUtil.getHandleUserName(userName);
		}
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getInvestTime() {
		return investTime;
	}
	public void setInvestTime(String investTime) {
		this.investTime = investTime;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
