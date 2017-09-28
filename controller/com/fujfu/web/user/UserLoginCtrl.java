package com.fujfu.web.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.StringUtil;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.comuanda.AusersServ;
import com.fujfu.service.user.UserLoginServ;
import com.fujfu.service.user.UserRegisterServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.service.util.MD5Utils;
import com.fujfu.web.BaseController;




@Controller
@RequestMapping("/user/*")
public class UserLoginCtrl extends BaseController{

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UserLoginCtrl.class);
	 
	@Autowired
	private UserLoginServ service;  
	@Autowired
	private AusersServ ausersServ;
	@Autowired
	private UserRegisterServ userRegisterServ;
	@Resource
	private UserServ userServ;
	/**
	 * 用户登录
	 * 
	 */	 
	@RequestMapping("login")
	@ResponseBody
	public Object login(String mobile, String password,HttpSession session,String code){
		log.info("moblie="+mobile+",password="+password+"");
		Map<String,String> map = new HashMap<String,String>();
		//fuyhui中没有该用户信息但是account有该用户信息,则添加该用户基本信息至fuyhui中
//		int count = userRegisterServ.checkMobile(mobile);
//		int count1 = userRegisterServ.checkUsername(mobile);//mobile指用戶名
//		if(count<=0&&count1<=0){
//			if (ausersServ.getAuserByMobile(mobile) != null) {
//				AusersVO ausers = ausersServ.getAuserByMobile(mobile);
//				UserVO user = new UserVO();
//				user.setUserId(ausers.getUserId());
//				user.setUsername(ausers.getUsername());
//				user.setPassword(ausers.getPassword());
//				user.setStatus(ausers.getStatus());
//				user.setMobile(ausers.getMobile());
//				user.setTarget(ausers.getTarget());
//				user.setCreated(ausers.getCreated());
//				userRegisterServ.userRegister(user);
//			}else if(ausersServ.getAuserByUserName(mobile) != null){//mobile指用戶名
//				AusersVO ausers = ausersServ.getAuserByUserName(mobile);
//				UserVO user = new UserVO();
//				user.setUserId(ausers.getUserId());
//				user.setUsername(ausers.getUsername());
//				user.setPassword(ausers.getPassword());
//				user.setStatus(ausers.getStatus());
//				user.setMobile(ausers.getMobile());
//				user.setTarget(ausers.getTarget());
//				user.setCreated(ausers.getCreated());
//				userRegisterServ.userRegister(user);
//				
//			}
//		}
		
		UserVO user = service.userLogin(mobile, MD5Utils.MD5Encrypt(/*FbdUtil.PWD_SALT + */password));
		if(user == null) {
			//查询是否是密码错误
			UserVO  userSel=userServ.getUserByMobile(mobile);
			if(userSel!=null){
				//密码错误修改错误次数并更新锁定时间
				int loginTimes = userSel.getLoginTimes();//错误次数
				UserVO userUp =new UserVO();
				userUp.setUserId(userSel.getUserId());
				if(loginTimes>=3){
					map.put("isneedCode","1"); //1需要图形验证码
				}
				if(loginTimes>=9){
					userUp.setIsLock(1);//是否锁定，0：未锁；1：锁定
				}
				userUp.setLastLoginTime(DateUtil.getUnixTime());//最后一次登录时间
				userUp.setLockTime(DateUtil.getUnixTime());//锁定时间
				userUp.setLoginTimes(userSel.getLoginTimes()+1);//已经登陆错误次数
				userServ.updateUser(userUp);
				
				map.put("flag", "0");
				map.put("msg", "用户名或密码错误");
				map.put("url", "");
				return map;
			}			
			map.put("flag", "0");
			map.put("msg", "用户名或密码错误");
			map.put("url", "");
			return map;
		}else{//密码没问题
			//查询密码错误次数是否锁定且锁定是否过期，
			UserVO  userSel=userServ.getUserByMobile(mobile);			
			Date lockDate=DateUtil.timeMillisToDate(userSel.getLockTime());
			Date nowDate =DateUtil.timeMillisToDate(DateUtil.getUnixTime());
			//锁定且未过期的 不许登录
			if(userSel.getIsLock()==1&&(nowDate.getTime() - lockDate.getTime())/(1000*60)<=30){
				map.put("flag", "0");
				map.put("msg", "账号已锁定，请30分钟后再试");
				map.put("url", "");
				return map;
			}//锁定且已过期的
			else if(userSel.getIsLock()==1&&(nowDate.getTime() - lockDate.getTime())/(1000*60)>30){
				UserVO userUp =new UserVO();
				userUp.setUserId(userSel.getUserId());
				userUp.setIsLock(0);//是否锁定，0：未锁；1：锁定
				userUp.setLastLoginTime(DateUtil.getUnixTime());//最后一次登录时间
				userUp.setLockTime(0);//锁定时间
				userUp.setLoginTimes(0);//已经登陆错误次数
				userServ.updateUser(userUp);
			}else{//未锁定
				if(userSel.getLoginTimes()>=3&&StringUtils.isEmpty(code)){
					map.put("flag", "0");
					map.put("isneedCode","1"); //1需要图形验证码
					map.put("msg", "请输入图形验证码");
					map.put("url", "");
					return map;
				}else if(userSel.getLoginTimes()>=3&&StringUtils.isNotEmpty(code)){
					String scode =  (String) getSession("code");
					if(!code.toLowerCase().equals(scode.toLowerCase())){
						map.put("flag", "0");
						map.put("msg", "验证码错误，请重新输入图形验证码");
						log.info("map = " + map);
						return map;
				}
		
				}
			}
			//未锁定的可以登录，
			//验证通过修改锁定状态，并清空密码错误次数
			UserVO userUp =new UserVO();
			userUp.setUserId(userSel.getUserId());
			userUp.setIsLock(0);//是否锁定，0：未锁；1：锁定
			userUp.setLastLoginTime(DateUtil.getUnixTime());//最后一次登录时间
			userUp.setLockTime(0);//锁定时间
			userUp.setLoginTimes(0);//已经登陆错误次数
			userServ.updateUser(userUp);
		}
		
		
		//设置前端展示的用户相关信息（加*号的）
		if(user.getUsername().equals(user.getMobile())){//用户名
			  user.setUsername(StringUtil.handlePhone(mobile));
			}else{
				user.setUsername(StringUtil.getHandleUserName(user.getUsername()));
			}
		if(!StringUtil.isEmpty(user.getCardId())){//证件号
		user.setCardId(StringUtil.handleCardId(user.getCardId()));
		}
		user.setMobile(StringUtil.handlePhone(mobile));//手机号
		if(!StringUtil.isEmpty(user.getCapAcntNo())){//银行卡号
		user.setCapAcntNo(StringUtil.handleBankNo1(user.getCapAcntNo()));
		}
		if(!StringUtil.isEmpty(user.getRealname())){//真实姓名
			user.setRealname(StringUtil.handleName(user.getRealname()));
			}
		session.setAttribute("user_inf", user);
		map.put("flag", "1");
		map.put("msg", "登录成功");
		map.put("url", "");
		return map;
		
	}
	@RequestMapping("loginWithUrl")
	@ResponseBody
	public Object loginWithUrl(HttpSession session, String url){
		if(StringUtils.isNotEmpty(url)){
			session.setAttribute("url", url);
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("flag", "1");
		return map;
		
	}
	
	@RequestMapping("logout")  
	public String logout(String mobile, HttpSession session){	
		log.info("logout [mobile = " + mobile + "]");
		session.removeAttribute("user_inf");
		session.removeAttribute("url");
		return "redirect:/enterLogin";
	}
	 
}
	
	
	
	
	
	
	
	
	
	
	
	
	