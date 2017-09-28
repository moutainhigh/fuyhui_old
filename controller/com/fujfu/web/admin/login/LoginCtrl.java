package com.fujfu.web.admin.login;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujfu.pojo.admin.AdminVO;
import com.fujfu.service.admin.AdminServ;
import com.fujfu.service.common.CommonServ;
import com.fujfu.service.util.MD5Utils;
import com.fujfu.web.BaseController;
import com.fujfu.web.util.PropertiesUtil;
@Controller
@RequestMapping("/admin/")
public class LoginCtrl extends BaseController{
	
	private static final long serialVersionUID = -8716523702947365413L;
	@Resource
	private AdminServ adminServ;
	@Resource
	private CommonServ commonServ;
	/**
	 * 进入登录页面
	 * @param session
	 * @return
	 */
	@RequestMapping("index")
	public String getLogin(){
		// 如果session里面有admin，则表示已登录，直接跳转至主界面，否则跳转至登录界面
		if(getSession("admin")!=null){
			return "redirect:"+PropertiesUtil.ADMIN_HOME_URL;
		}else{
			return PropertiesUtil.ADMIN_LOGIN_URL;
		}
	}
	
	/**
	 * 进入首页
	 * @param session
	 * @return
	 */
	@RequestMapping("home")
	public String getHome(){
		return "views/home.jsp";
	}
	
	/**
	 * 后台用户登录
	 * @param session
	 * @param username
	 * @param password
	 * @return 成功返回跳转地址，失败则返回错误提示信息
	 */
	@ResponseBody
	@RequestMapping(value="login",method = RequestMethod.POST)
	public Object adminLogin(HttpServletRequest request){
		// 获取前端传过来的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		Map<String, Object> map = new HashMap<String, Object>();
		int flag =commonServ.checkCode(username, code, "14");
		if(flag!=1){
			map.put("msg", "手机验证码错误");
			return map;
		}		
		// 后台校验是否为空
		if((username==null || username.length()<=0)
				||(password==null || password.length()<=0)){
			map.put("msg", "用户名或密码不能为空");
			return map;
		}
		// 登录
		AdminVO admin = new AdminVO();
		admin.setUsername(username);
		admin.setPassword(MD5Utils.MD5Encrypt(password));
		AdminVO a = adminServ.adminLogin(admin);
		if( a != null){
			map.put("msg", "登录成功");
			map.put("url", request.getContextPath()+PropertiesUtil.ADMIN_HOME_URL);
			addSession("admin", a);
		}else{
			map.put("msg", "用户名或密码错误");
		}
		return map;
	}
	
	/**
	 * 用户登出
	 * @param session
	 * @return
	 */
	@RequestMapping("loginOut")
	public String adminLoginOut(HttpSession session){
		removeSession("admin");
		return PropertiesUtil.ADMIN_LOGIN_URL;
	}
	
	/**
	 * 修改密码
	 * @param session
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("changePwd")
	public Object updateAdminPwd(HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取前端传过来的参数
		String adminPwd = request.getParameter("newpwd");
		AdminVO admin = (AdminVO) getSession("admin");
		admin.setPassword(MD5Utils.MD5Encrypt(adminPwd));
		adminServ.updateAdmin(admin);
		removeSession("admin");
		map.put("msg", "修改密码成功");
		map.put("url", PropertiesUtil.ADMIN_LOGIN_URL);
		return map;
	}
}
