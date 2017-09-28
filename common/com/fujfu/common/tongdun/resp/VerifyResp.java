package com.fujfu.common.tongdun.resp;

public class VerifyResp {

	private String success;

	private String result;

	private String display;

	private String reason_code;
	
	private String reason_desc;
	
	public String getReason_code() {
		return reason_code;
	}

	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}

	public String getReason_desc() {
		return reason_desc;
	}

	public void setReason_desc(String reason_desc) {
		this.reason_desc = reason_desc;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}
	
}
