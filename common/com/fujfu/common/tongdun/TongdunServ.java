package com.fujfu.common.tongdun;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

/**
 * 同盾接口服务类
 * @author 
 *
 */
public class TongdunServ {
	
	private static final Logger log = Logger.getLogger(TongdunServ.class);

	/***
	 * 实名认证(姓名-身份证)
	 * @return
	 */
	public static String verifyCardId(String cardId, String realname) {
		List<NameValuePair> parameterList = new ArrayList<>();
		parameterList.add(new BasicNameValuePair("id_number", cardId));
		parameterList.add(new BasicNameValuePair("name", realname));
		String result = null;
		try {
			result = TongdunUtil.invoke(parameterList, UrlUtil.REALNAME);
		} catch (IOException e) {
			result = null;
			log.info("exception = " + e.getMessage());
		}
		return result;
	}
	
    /***
     * 银行卡验证(卡号-手机号)
     * @return
     */
    public static String verifyBankCard(String card, String mobile){
        List<NameValuePair> parameterList = new ArrayList<>();
        parameterList.add(new BasicNameValuePair("type", "card.mobile"));
        parameterList.add(new BasicNameValuePair("card", card));
        parameterList.add(new BasicNameValuePair("mobile", mobile));
        String result = null;
		try {
			result = TongdunUtil.invoke(parameterList, UrlUtil.BANK);
		} catch (IOException e) {
			result = null;
			log.info("exception = " + e.getMessage());
		}
		return result;
    }
}
