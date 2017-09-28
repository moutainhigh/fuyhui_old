package com.fujfu.common.payment.fuyou;

import org.apache.log4j.Logger;

import com.fujfu.common.payment.fuyou.http.WebUtils;
import com.fujfu.common.payment.fuyou.pojo.ChangeCardBean;
import com.fujfu.common.payment.fuyou.pojo.ChangeMobileBean;
import com.fujfu.common.payment.fuyou.pojo.PasswordMgtBean;
import com.fujfu.common.payment.fuyou.pojo.QueryChgCardBean;
import com.fujfu.common.payment.fuyou.pojo.QueryUserInfoBean;
import com.fujfu.common.payment.fuyou.pojo.UserArtifRegBean;
import com.fujfu.common.payment.fuyou.pojo.UserRegBean;
import com.fujfu.common.payment.fuyou.pojo.response.QueryChgCardResp;
import com.fujfu.common.payment.fuyou.pojo.response.QueryUserInfoResp;
import com.fujfu.common.payment.fuyou.pojo.response.UserRegResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.payment.fuyou.util.SecurityUtils;
import com.fujfu.common.util.XMLUtil;


/**
 * 富友支付接口类，用户管理类
 * @author 
 */

public class UserMgt {
	
	private static Logger log = Logger.getLogger(UserMgt.class);
	
	/**
	 * 用户注册
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static UserRegResp regist(UserRegBean reqData) throws Exception {
		String inputStr=reqData.regSignVal();
		String signatureStr=SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		log.info("signature = " + signatureStr);
		

		String backXML = WebUtils.sendHttp(FyUtil.REGISTER,reqData);
		UserRegResp respData = XMLUtil.toBean(UserRegResp.class, backXML);
		log.info("backXMLjiequ = "+XMLUtil.getSignData(backXML));
		log.info("inputStrjiami = "+SecurityUtils.sign(XMLUtil.getSignData(backXML)));
		boolean flag = SecurityUtils.verifySign(
						XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
		
		if(flag){
			return respData;
		}
		return null;
	}
	
	/**
	 * 法人注册
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static UserRegResp regist(UserArtifRegBean reqData) throws Exception {
		String inputStr=reqData.regSignVal();
		String signatureStr=SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		log.info("signature = " + signatureStr);
		
		String backXML = WebUtils.sendHttp(FyUtil.ARTIFREGISTER,reqData);
		UserRegResp respData = XMLUtil.toBean(UserRegResp.class, backXML);
		boolean flag = SecurityUtils.verifySign(
						XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
		
		if(flag){
			return respData;
		}
		return null;
	}
	
	/**
	 * 用户查询
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static QueryUserInfoResp queryInfo(QueryUserInfoBean reqData) throws Exception {
		
		//请求明文
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		log.info("signature = " + signatureStr);
		
		String backXML = WebUtils.sendHttp(FyUtil.QUERY_USER_INFO, reqData);
		QueryUserInfoResp respData = XMLUtil.toBean(QueryUserInfoResp.class, backXML);
		//boolean b=SecurityUtils.verifySign("","");//验签结果
		//System.out.println(b);
		return respData;
	}
	
	/**
	 * 用户修改手机号
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static ChangeMobileBean changeMobile(ChangeMobileBean reqData) throws Exception {
		
		//请求明文
		reqData.setPage_notify_url(FyUtil.CHG_MOBILE_INDEX);
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setAction(FyUtil.CHG_MOBILE);
		reqData.setSignature(signatureStr);
		log.info("signature = " + signatureStr);
		return reqData;
	}
	
	/**
	 * 用户富友密码管理
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static PasswordMgtBean passwordMgt(PasswordMgtBean reqData) throws Exception {
		
		//请求明文
		reqData.setback_url(FyUtil.PWD_MGT_INDEX);
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setAction(FyUtil.PWD_MGT);
		reqData.setSignature(signatureStr);
		return reqData;
	}
	
	/**
	 * 更换银行卡
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static ChangeCardBean changeCard(ChangeCardBean reqData) throws Exception {
		
		//请求明文
		reqData.setPage_notify_url(FyUtil.CHG_CARD_INDEX);
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setAction(FyUtil.CHG_CARD);
		reqData.setSignature(signatureStr);
		return reqData;
	}
	
	/**
	 * 更换银行卡查询
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static QueryChgCardResp queryChgCard(QueryChgCardBean reqData) throws Exception {
		
		//请求明文
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		log.info("signature = " + signatureStr);
		
		String backXML = WebUtils.sendHttp(FyUtil.QUERY_CHG_CARD, reqData);
		QueryChgCardResp respData = XMLUtil.toBean(QueryChgCardResp.class, backXML);
		//boolean b=SecurityUtils.verifySign("","");//验签结果
		return respData;
	}
	
}
