package com.fujfu.common.util.tag;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.tagext.TagSupport;

public class DateTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	private long value;// 时间戳(输入)
	private String dTime;// 日期时间(输出)
	private String pattern;// 日期格式

	/**
	 * 时间戳转换成日期时间
	 * 
	 * @return
	 */
	@Override
	public int doStartTag() {
		try {
			String timeStr = value + "000";
			long timeL = Long.parseLong(timeStr);
			Date timeDate = new Date(timeL);
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			dTime = sdf.format(timeDate);
			pageContext.getOut().println(dTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public String getdTime() {
		return dTime;
	}

	public void setdTime(String dTime) {
		this.dTime = dTime;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}