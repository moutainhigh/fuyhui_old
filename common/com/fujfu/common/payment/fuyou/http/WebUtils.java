package com.fujfu.common.payment.fuyou.http;

import org.apache.log4j.Logger;

import com.fujfu.common.payment.fuyou.util.FyUtil;

public class WebUtils {
	
	private static Logger log = Logger.getLogger(WebUtils.class);
	
	public static String sendHttp(String url, Object parameters) throws Exception  {
		String outStr="";
		try {
			outStr = HttpClientHelper.doHttp(url,FyUtil.CHAR_SET,parameters, FyUtil.TIME_OUT);
			if(outStr==null){
				throw new Exception("请求接口失败!");
			}
			log.info("backXml = "+outStr);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("请求接口失败!");
		}
		return outStr;
	}
}