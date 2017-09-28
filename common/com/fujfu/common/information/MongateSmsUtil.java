package com.fujfu.common.information;

import org.apache.log4j.Logger;

import com.fujfu.common.information.mongate.Wmgw;
import com.fujfu.common.util.StringUtil;

/**
 * 短信接口 - 梦网
 * 
 * @author HJZ
 * @update 2016-08-05
 */
public class MongateSmsUtil {

	private static final String USER_ID = "H11031";
	private static final String PASSWORD = "110809";
	private static final int MOBILE_COUNT = 1;
	private static Wmgw ws = null;

	private static final Logger log = Logger.getLogger(MongateSmsUtil.class);

	/**
	 * 群发不能超过100人/次
	 * 
	 * @param mobileArr[]
	 *            手机号码[]
	 * @param content
	 *            短信内容
	 */
	public static String sendMsgMult(String[] mobileArr, String content) {
		String resp = null;
		String mobile = MongateSmsUtil.arrToStr(mobileArr);
		resp = MongateSmsUtil.mongateSendSubmit(USER_ID, PASSWORD, mobile, content, mobileArr.length, "*", "");
		return resp;
	}

	/**
	 * 发送短信
	 * 
	 * @param mobile
	 *            手机号码
	 * @param content
	 *            短信内容
	 */
	public static String sendMsg(String mobile, String content) {
		String resp = "";
		try {
			resp = MongateSmsUtil.mongateSendSubmit(USER_ID, PASSWORD, mobile, content, MOBILE_COUNT, "*", "");
		} catch (Exception e) {
			log.info("Send Msg fail, message = " + e.getMessage());
			resp = "";
		}
		return resp;
	}

	/**
	 * @return 帐户剩余可发送条数
	 */
	public static int queryBalance() {
		return MongateSmsUtil.mongateQueryBalance(USER_ID, PASSWORD);
	}

	public static String mongateSendSubmit(String userId, String password, String pszMobis, String pszMsg,
			int iMobiCount, String pszSubPort, String msgId) {
		if (ws == null) {
			ws = new Wmgw();
		}
		String resp = ws.getWmgwSoap().mongateSendSubmit(userId, password, pszMobis, pszMsg, iMobiCount, pszSubPort,
				msgId);
		return resp;
	}

	public static int mongateQueryBalance(String userId, String password) {
		if (ws == null) {
			ws = new Wmgw();
		}
		return ws.getWmgwSoap().mongateQueryBalance(userId, password);
	}

	/**
	 * 相同信息内容的号码一定要打包发送<br>
	 * 如果对于相同的信息一条一条发送，系统将会自动停止用户帐号。<br>
	 * <br>
	 * 
	 * @param mobileArr
	 * @return 目标号码，用英文逗号(,)分隔，最大100个号码
	 */
	public static String arrToStr(String[] mobileArr) {
		if (mobileArr.length > 100) {
			return null;
		}

		StringBuffer mobile = new StringBuffer();
		for (int i = 0; i < mobileArr.length; i++) {

			if (mobile.length() > 0) {
				mobile.append(",").append(mobileArr[i]);
			} else {
				mobile.append(mobileArr[i]);
			}
		}
		return mobile.toString();
	}

	public static void main(String[] args) {

		// MongateSmsUtil.sendMsgMult(new
		// String[]{"15220201237","153","154"},StringUtil.getRandom(6));
		MongateSmsUtil.sendMsg("13243865803", "验证码" + StringUtil.getRandom(6));
		// System.out.println(MongateSmsUtil.queryBalance());
	}
}
