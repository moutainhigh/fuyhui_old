package com.fujfu.web.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fujfu.common.util.FbdUtil;
import com.fujfu.common.util.SmsTypeUtil;
import com.fujfu.common.util.StringUtil;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.common.CommonServ;
import com.fujfu.service.comuanda.AusersServ;
import com.fujfu.service.user.UserForgetServ;
import com.fujfu.service.user.UserRegisterServ;
import com.fujfu.service.util.MD5Utils;

@Controller
@RequestMapping("/user/*")
public class UserForgetCtrl {

	private static Logger log = Logger.getLogger(UserForgetCtrl.class);

	@Autowired
	private UserForgetServ service;

	@Autowired
	private UserRegisterServ regService;
	
	@Autowired
	private AusersServ ausersServ;

	@Autowired
	private CommonServ commonServ;

	@RequestMapping("/forget2")
	public ModelAndView index(HttpServletRequest request) {
		return new ModelAndView("views/findpwd.html");

	}

	@RequestMapping("/forget")
	@ResponseBody
	public Object add(HttpServletRequest request, String mobile, String picCode, String authCode, String password, String step) {
		log.info("forget[mobile=" + mobile + ",picCode=" + picCode + ",authCode=" + authCode + ",password=" + password);
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtil.isEmpty(step)) {
				return new ModelAndView("views/findpwd.html");
		} 
		if("1".contains(step)){ //第一步
			if(!StringUtil.checkMobile(mobile) || StringUtil.isEmpty(picCode) || StringUtil.isEmpty(authCode) ){
				return new ModelAndView("views/findpwd.html");
			}
			
			int count = regService.checkMobile(mobile);
			if(count<=0){
				map.put("flag", "0");
				map.put("msg", "手机不是注册号码");
				return map;
			}
			
			String code = (String) request.getSession().getAttribute("code");
	    	log.info("forget, session code = " + code);
	    	
	    	if(!picCode.equalsIgnoreCase(code)){
	    		map.put("flag", "0");
				map.put("msg", "图形验证码错误");
				return map;
	    	}
			
			int result1 = commonServ.checkCode(mobile, authCode,SmsTypeUtil.P2P_FIND_PWD);
			if(result1 <= 0){
				map.put("flag", "0");
				map.put("msg", "短信验证码错误");
				return map;
			}		
			map.put("flag", "1");
			map.put("msg", "提交成功");
			return map;
			
			
		} else if ("2".equals(step)) { //第二步
			if(!StringUtil.checkMobile(mobile) || StringUtil.isEmpty(password) || StringUtil.isEmpty(authCode)){
				map.put("flag", "0");
				map.put("msg", "请填写正确的信息");
				return map;
			}
			
			int result1 = commonServ.checkCode(mobile, authCode,SmsTypeUtil.P2P_FIND_PWD);
			if(result1 <= 0){
				map.put("flag", "0");
				map.put("msg", "短信验证码错误");
				return map;
			}		
			
			UserVO bean = new UserVO();
			bean.setMobile(mobile);
			bean.setPassword(MD5Utils.MD5Encrypt(FbdUtil.PWD_SALT + password));
			service.updatePassword(bean);
			
//			// 同时修改account中的密码
//			AusersVO ausers = new AusersVO();
//			ausers.setUserId(ausersServ.getAuserByMobile(mobile).getUserId());
//			ausers.setPassword(MD5Utils.MD5Encrypt(FbdUtil.PWD_SALT + password));
//			ausersServ.updateAusers(ausers);
		}	
		map.put("flag", "1");
		map.put("msg", "密码修改成功");
		return map;
	}

}
