package com.fujfu.web.user;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.FbdUtil;
import com.fujfu.common.util.SmsTypeUtil;
import com.fujfu.common.util.StringUtil;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.common.SelCodeVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.award.AwardUserAddServ;
import com.fujfu.service.common.CommonServ;
import com.fujfu.service.common.SelCodeServ;
import com.fujfu.service.comuanda.AusersServ;
import com.fujfu.service.recommend.RecommendSer;
import com.fujfu.service.user.UserLoginServ;
import com.fujfu.service.user.UserRegisterServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.service.util.MD5Utils;
import com.fujfu.web.BaseController;

/**
 * 用户注册控制器类
 * 
 * @author hjz
 * @update 2016-8-5
 *
 */
@Controller
@RequestMapping("/user/*")
public class UserRegisterCtrl extends BaseController {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UserRegisterCtrl.class);

	@Autowired
	private AusersServ ausersServ;

	@Autowired
	private UserRegisterServ service;

	@Autowired
	private UserLoginServ loginService;

	@Autowired
	private UserServ userServ;

	@Resource
	private UserAccountServ userAccountServ;
	
	@Resource
	private AwardUserAddServ awardUserAddServ;	

	@Autowired
	private CommonServ commonServ;

	@Resource
	private SelCodeServ selCodeServ;
	@Resource
	private RecommendSer recommendSer;	
	
	
	/**
	 * 用户注册
	 * 
	 */
	@RequestMapping("register")
	@ResponseBody
//	@Transactional
	public Object add(String mobile, String password, String authCode, String picCode, String referees) {
		int created = DateUtil.getUnixTime();
		log.info("register [ mobile = " + mobile + ",password = " + password + ", checkCode = " + picCode + ",authCode="
				+ authCode + "referees = " + referees);
		if (StringUtil.isEmpty(mobile) || StringUtil.isEmpty(password) || !StringUtil.checkMobile(mobile)) {
			return new ModelAndView("views/register.html");
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtil.is11Number(mobile)) {
			map.put("flag", "0");
			map.put("msg", "手机号码错误，请重新输入");
			return map;
		}

//		if (ausersServ.getAuserByMobile(mobile) != null) {
//			map.put("flag", "0");
//			map.put("msg", "手机号已经注册");
//			return map;
//		}

		int result = commonServ.checkCode(mobile, authCode, SmsTypeUtil.REG);
		if (result <= 0) {
			map.put("flag", "0");
			map.put("msg", "短信验证码错误");
			return map;
		}

//		// 先添加至account,再从account中取出用户信息添加至fuyhui
//		AusersVO ausers = new AusersVO();
//		ausers.setUsername(mobile);
//		ausers.setMobile(mobile);
//		ausers.setPassword(MD5Utils.MD5Encrypt(FbdUtil.PWD_SALT + password));
//		ausers.setTarget("P2P_PC");
//		ausers.setCreated(created);
//		// 添加至account的user表中,返回userId并设置到ausers
//		int result1 = ausersServ.addAusers(ausers);
//
//		UserVO uesrBean = new UserVO();
//		uesrBean.setUserId(ausers.getUserId());
//		uesrBean.setUsername(ausers.getUsername());
//		uesrBean.setMobile(ausers.getMobile());
//		uesrBean.setPassword(ausers.getPassword());
//		uesrBean.setTarget(ausers.getTarget());
//		uesrBean.setUserType("1");
//		uesrBean.setCreated(ausers.getCreated());
//		uesrBean.setStartUserName(ausers.getUsername());
//		// 添加至fuyhui的user表中,返回userId并设置到userbean
//		int result2 = service.userRegister(uesrBean);
		
		UserVO uesrBean = new UserVO();
		uesrBean.setUsername(mobile);
		uesrBean.setMobile(mobile);
		uesrBean.setPassword(MD5Utils.MD5Encrypt(FbdUtil.PWD_SALT + password));
		uesrBean.setTarget("P2P_PC");
		uesrBean.setUserType("1");
		uesrBean.setCreated(created);
		uesrBean.setStartUserName(mobile);
		int result2 = service.userRegister(uesrBean);
		
		UserAccountVO userAccount = new UserAccountVO();
		userAccount.setUserId(uesrBean.getUserId());

		int popResult = 0;
		// 添加至fuyhui的userAccount表中
		int result3 = userAccountServ.insert(userAccount);

		// 添加推荐表
		if (!StringUtils.isEmpty(referees)) {
			int userid = 0;
			if (!StringUtil.checkMobile(referees)) {
				map.put("flag", "0");
				map.put("msg", "推荐码必须为手机号码");
				return map;
			}
			// 是手机号码,根据手机号码查出userId
			userid =  userServ.getUserByMobile(referees).getUserId();
			popResult = recommendSer.registRecommend(Integer.valueOf(userid), uesrBean.getUserId());
			
			/**update by peter 20170329 */
			
			if (popResult > 0 /*&& result1 > 0*/ && result2 > 0 && result3 > 0) {
				UserVO user = loginService.userLogin(uesrBean.getUsername(), uesrBean.getPassword());
				//前台展示 显示部分隐藏
				user.setMobile(StringUtil.handlePhone(mobile));//手机号码
				if(mobile.endsWith(uesrBean.getUsername())){//用户名
				  user.setUsername(StringUtil.handlePhone(mobile));
				}else{
					user.setUsername(StringUtil.getHandleUserName(uesrBean.getUsername()));
				}
				addSession("user_inf", user);
				map.put("flag", "1");
				map.put("userId", user.getUserId());
				map.put("msg", "注册成功");
				
				/**update by peter20170306*/
				/**送红包*/
				awardUserAddServ.addUserAward("1","1", user.getUserId(),mobile,"注册送红包");
				
				log.info("map = " + map);
			} else {
				map.put("flag", "0");
				map.put("msg", "注册失败");
			}
		} else if (/*result1 > 0 && */result2 > 0 && result3 > 0) {
			UserVO user = loginService.userLogin(uesrBean.getUsername(), uesrBean.getPassword());
			user.setMobile(StringUtil.handlePhone(mobile));
			if(mobile.endsWith(uesrBean.getUsername())){//用户名
				  user.setUsername(StringUtil.handlePhone(mobile));
				}else{
					user.setUsername(StringUtil.getHandleUserName(uesrBean.getUsername()));
				}
			addSession("user_inf", user);
			map.put("flag", "1");
			map.put("userId", user.getUserId());
			map.put("msg", "注册成功");
			log.info("map = " + map);
			/**送红包*/
			/**update by peter20170306*/
			awardUserAddServ.addUserAward("1","1", user.getUserId(),mobile,"注册送红包");
			
		} else {
			map.put("flag", "0");
			map.put("msg", "注册失败");
		}
		return map;
	}

	/**
	 * 验证用户名 和 手机号码
	 * 
	 * @param type
	 *            -- 1，用户名 <br>
	 *            -- 2 ，手机
	 * @param value
	 * 
	 */
	@RequestMapping(value = "/signup/checkisonly")
	@ResponseBody
	public Object checkisonly(String type, String value) {
		int flag = 1; // 默认存在
		Map<Object, Object> map = new HashMap<Object, Object>();
		if (StringUtils.isEmpty(type) || StringUtils.isEmpty(value) || !StringUtil.checkMobile(value)) {
			map.put("flag", "0");
			map.put("msg", "手机号码不合法");
			return map;
		}
		if ("2".equals(type)) {
			if (userServ.getUserByMobile(value) == null) {
				flag = 0;
			}
		}
		System.out.println("flag = " + flag);
		map.put("flag", String.valueOf(flag));
		return map;
	}

	@RequestMapping(value = "checkReferees", method = RequestMethod.POST)
	@ResponseBody
	public Object checkReferees(String referees) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		// 如果是手机号
		if (StringUtil.checkMobile(referees)) {
			if (userServ.getUserByMobile(referees) != null) {
				map.put("flag", "1");
				map.put("msg", "推荐码正确");
			} else {
				map.put("flag", "0");
				map.put("msg", "推荐码有误");
			}
		} else if (StringUtils.isNumeric(referees) && referees.length() < 11) {// userId
			if (userServ.getUserByUserId(Integer.parseInt(referees)) != null) {
				map.put("flag", "1");
				map.put("msg", "推荐码正确");
			} else {
				map.put("flag", "0");
				map.put("msg", "推荐码有误");
			}
		} else {
			map.put("flag", "0");
			map.put("msg", "推荐码非法");
		}
		return map;
	}

	/**
	 * 选择省份后根据省份信息获取下级市县信息
	 * @return
	 */
	@RequestMapping("user/getcityidList")
	@ResponseBody
	public Object getcityidList(HttpServletRequest request,String itemno,String itemno1, HttpSession session, Model model){
		
		List<SelCodeVO> citycodelist2 = selCodeServ.findSelCodeByBelongItemno("city", itemno);
		String optionHTML="";
		SelCodeVO selcode =new SelCodeVO();
		 for(Iterator<SelCodeVO>    it    =    citycodelist2.iterator();    it.hasNext();    )    { 
			 selcode=it.next();
			 if(selcode.getItemno().equals(itemno1)){
				 optionHTML = optionHTML + "<option value=\"" + selcode.getItemno() + "\"" + " selected>" +  selcode.getItemname() + "</option>\n\t\t";
				 }else{
			     optionHTML = optionHTML + "<option value=\"" + selcode.getItemno() + "\">" + selcode.getItemname() + "</option>\n\t\t";
			 }
		   }
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("citycodelist2", optionHTML);
		return map;
		
	}
}
