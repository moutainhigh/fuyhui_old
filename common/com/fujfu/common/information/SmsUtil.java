package com.fujfu.common.information;

import java.util.UUID;

import com.fujfu.common.information.smslib.ArrayOfMessageData;
import com.fujfu.common.information.smslib.GsmsResponse;
import com.fujfu.common.information.smslib.MTPacks;
import com.fujfu.common.information.smslib.MessageData;
import com.fujfu.common.information.smslib.WebService;
import com.fujfu.common.util.StringUtil;


/**
 * 短信接口公用类
 * 
 * @author huangjizhong
 * @update 2016-3-9
 * @revise huangjizhong <huangjizhong@fujfu.com>
 */
public class SmsUtil {
	
	private static String account = "ddw@ddw";   		  //玄武接口400
	private static String password = "fujfu!123456"; //玄武接口400
	private static WebService service = new WebService();
	    
	public static GsmsResponse sendSms(String[] mobile , String content) {
		GsmsResponse ret = postSMS(service,account,password,mobile,content);
		return ret;
	}
	
	private static GsmsResponse postSMS(WebService service, String account, String password,String[] mobile,String content){
		ArrayOfMessageData messageDatas = new ArrayOfMessageData();
		MTPacks pack = new MTPacks();
		
		MessageData messageData = null;
		//组发
		/*int size = 5; //组发数
		for(int i =0; i< size; i++){
			messageData = new MessageData();
			messageData.setContent("祝您生活愉快！"+i);	//短信内容
			messageData.setPhone("1379819466"+i); //手机号码
			messageData.setVipFlag(true); //vip号码
			messageData.setCustomMsgID("121");	//短信扩展码
			messageDatas.getMessageData().add(messageData);
		}*/
		
		//群发
		for(int i=0; i< mobile.length; i++){
			messageData = new MessageData();
			messageData.setContent(content); //短信内容
			messageData.setPhone(mobile[i]); //短信号码
			messageData.setVipFlag(true); //vip号码
			messageDatas.getMessageData().add(messageData);
		}

		String batchId = UUID.randomUUID().toString();
		
		pack.setMsgType(1);//1短信发送 2彩信发送    
		pack.setSendType(0);//0群发 1 组发      ***********确定是群发还是组发
		pack.setMsgs(messageDatas);
		pack.setDistinctFlag(true); //是否过滤重复号码
		pack.setBatchID(batchId);
		pack.setCustomNum("13801");//扩展号
		
		GsmsResponse resp = service.getWebServiceSoap().post(account, password, pack);
		//System.out.println("result:"+resp.getResult());
		//System.out.println("message:"+resp.getMessage());
		return resp;
	}

		public static void main(String[] args) {
			SmsUtil.sendSms(new String[]{"15220201237"}, StringUtil.getRandom(6));
		}
}
