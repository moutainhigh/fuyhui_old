package com.fujfu.common.payment.fuyou;

import com.fujfu.common.payment.fuyou.http.WebUtils;
import com.fujfu.common.payment.fuyou.pojo.UserRechargeBean;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.payment.fuyou.util.SecurityUtils;


/**
 * 用户充值管理类
 * @author hjz
 */

public class RechargeMgt {
	

	/**
	 * 快捷充值(form表单形式)
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static UserRechargeBean fastRecharge(UserRechargeBean reqData) throws Exception {
		String inputStr=reqData.regSignVal();
		String signatureStr=SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		reqData.setAction(FyUtil.FAST_RECHARGE);
		System.out.println(signatureStr);
		
		String backStr=WebUtils.sendHttp(FyUtil.FAST_RECHARGE,reqData);
		
		//验签
		//boolean b=SecurityUtils.verifySign(""","");//验签结果
		//System.out.println(b);
		
		//XML转化XMLbean 
		//返回XMLbean
		
		return reqData;
	}
	
	/**
	 * 网银充值
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static UserRechargeBean webRecharge(UserRechargeBean reqData) throws Exception {
		String inputStr=reqData.regSignVal();
		String signatureStr=SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		reqData.setAction(FyUtil.WEB_RECHARGE);
		System.out.println(signatureStr);
		
		//String backStr=WebUtils.sendHttp(FyUtil.WEB_RECHARGE,reqData);
		
		//验签
		//boolean b=SecurityUtils.verifySign(""","");//验签结果
		//System.out.println(b);
		
		//XML转化XMLbean 
		//返回XMLbean
		
		return reqData;
	}
	
	
}
