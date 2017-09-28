package com.fujfu.web.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujfu.common.util.PDFUtil;
import com.fujfu.common.util.PropertyFileUtil;
import com.fujfu.common.util.SmsTypeUtil;
import com.fujfu.common.util.StringUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.AdminVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.admin.AdminServ;
import com.fujfu.service.common.CommonServ;
import com.fujfu.service.user.UserRegisterServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.web.BaseController;

/**
 * common控制器
 * 
 * @author hjz
 *
 */
@Controller
@RequestMapping("/user/*")
public class CommonCtrl extends BaseController {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CommonCtrl.class);
	@Resource
	private UserServ userServ;
	@Resource
	private CommonServ commonServ;	
	@Autowired
	private UserRegisterServ regService;
	@Autowired
	private AdminServ adminServ;

	/**
	 * 发送手机验证码
	 * 
	 * @throws IOException
	 * 
	 */
	@RequestMapping(value = "sendMsg")
	@ResponseBody
	public Object sendMsg(String mobile, String type,String userId,String code) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		log.info("mobile = " + mobile + " ,type = " + type);
		
		if (SmsTypeUtil.FBD_LENDER.equals(type) && StringUtils.isNumeric(userId)) { // type=12,fbd 分期支付
			
			UserVO user = userServ.getUserByUserId(Integer.parseInt(userId));
			if(user==null) {
				map.put("flag", "0");
				map.put("msg", "发送失败");
				log.info("map = " + map);
				return map;
			}
			int sendTimes = commonServ.regSendTimes(user.getMobile(), type);
			log.info("分期支付，号码 = " + user.getMobile() + " ,发送次数 = " + sendTimes);
			if (sendTimes < 5) {
				// 发送手机验证码
				int result2 = commonServ.sendMsg(user.getMobile(), type);
				if (result2 > 0) {
					map.put("flag", "1");
					map.put("msg", "短信发送成功");
					log.info("map = " + map);
					return map;
				}
			} else {
				map.put("flag", "0");
				map.put("msg", "操作太频繁，请稍后再试");
				log.info("map = " + map);
				return map;
			}
		} 
        if(SmsTypeUtil.P2P_GAI_PWD.equals(type) && StringUtils.isNumeric(userId)){//修改手机号码时发送短信。因为界面上的mobile是隐藏中间几个数字显示的
        	mobile =userServ.getUserByUserId(Integer.parseInt(userId)).getMobile();
        	int sendTimes = commonServ.regSendTimes(mobile, type);
			log.info("p2p找回密码，号码 = " + mobile + " ,发送次数 = " + sendTimes);
			if (sendTimes < 5) {
				// 发送手机验证码
				int result2 = commonServ.sendMsg(mobile, type);
				if (result2 > 0) {
					map.put("flag", "1");
					map.put("msg", "短信发送成功");
					log.info("map = " + map);
					return map;
				}
			} else {
				map.put("flag", "0");
				map.put("msg", "操作太频繁，请稍后再试");
				log.info("map = " + map);
				return map;
			}
		

        }
		if (StringUtils.isNotEmpty(mobile) && StringUtil.checkMobile(mobile)) {

			// type=10,fbd,p2p注册验证码
			if (SmsTypeUtil.REG.equals(type)) {
				String scode =  (String) getSession("code");
				if(!code.toLowerCase().equals(scode.toLowerCase())){
					map.put("flag", "0");
					map.put("msg", "请重新输入图形验证码");
					log.info("map = " + map);
					return map;
				}
				// 验证手机号是否已被注册
				int result = regService.checkMobile(mobile);
				if (result > 0) {
					map.put("flag", "0");
					map.put("msg", "您的号码已经注册");
					log.info("map = " + map);
					return map;
				}

				// 检查手机号码已发短信次数
				int sendTimes = commonServ.regSendTimes(mobile, type);
				log.info("注册, 号码 = " + mobile + " ,发送次数 = " + sendTimes);
				if (sendTimes < 5) {
					// 发送手机验证码
					int result2 = commonServ.sendMsg(mobile, type);
					if (result2 > 0) {
						map.put("flag", "1");
						map.put("msg", "短信发送成功");
						log.info("map = " + map);
						return map;
					}
				} else {
					map.put("flag", "0");
					map.put("msg", "操作太频繁，请稍后再试");
					log.info("map = " + map);
					return map;
				}

			} else if (SmsTypeUtil.FBD_CARD.equals(type)) { // type=11,fbd绑卡验证码

				int sendTimes = commonServ.regSendTimes(mobile, type);
				log.info("绑卡，号码 = " + mobile + " ,发送次数 = " + sendTimes);
				if (sendTimes < 5) {
					// 发送手机验证码
					int result2 = commonServ.sendMsg(mobile, type);
					if (result2 > 0) {
						map.put("flag", "1");
						map.put("msg", "短信发送成功");
						log.info("map = " + map);
						return map;
					}
				} else {
					map.put("flag", "0");
					map.put("msg", "操作太频繁，请稍后再试");
					log.info("map = " + map);
					return map;
				}
			} else if (SmsTypeUtil.FBD_FIND_PWD.equals(type)) {// type=13,fbd忘记密码
				//判断是否是注册用户
				int result = regService.checkMobile(mobile);
				if (result <= 0) {
					map.put("flag", "0");
					map.put("msg", "您的号码未注册");
					log.info("map = " + map);
					return map;
				}
				int sendTimes = commonServ.regSendTimes(mobile, type);
				log.info("fbd找回密码，号码 = " + mobile + " ,发送次数 = " + sendTimes);
				if (sendTimes < 5) {
					// 发送手机验证码
					int result2 = commonServ.sendMsg(mobile, type);
					if (result2 > 0) {
						map.put("flag", "1");
						map.put("msg", "短信发送成功");
						log.info("map = " + map);
						return map;
					}
				} else {
					map.put("flag", "0");
					map.put("msg", "操作太频繁，请稍后再试");
					log.info("map = " + map);
					return map;
				}
			}
			else if (SmsTypeUtil.P2P_FIND_PWD.equals(type)) { // type=30,p2p忘记密码

				String scode =  (String) getSession("code");
				if(!code.toLowerCase().equals(scode.toLowerCase())){
					map.put("flag", "0");
					map.put("msg", "请重新输入图形验证码");
					log.info("map = " + map);
					return map;
				}
				int sendTimes = commonServ.regSendTimes(mobile, type);
				log.info("p2p找回密码，号码 = " + mobile + " ,发送次数 = " + sendTimes);
				if (sendTimes < 5) {
					// 发送手机验证码
					int result2 = commonServ.sendMsg(mobile, type);
					if (result2 > 0) {
						map.put("flag", "1");
						map.put("msg", "短信发送成功");
						log.info("map = " + map);
						return map;
					}
				} else {
					map.put("flag", "0");
					map.put("msg", "操作太频繁，请稍后再试");
					log.info("map = " + map);
					return map;
				}
			}
			else if (SmsTypeUtil.ADMIN_LOGIN.equals(type)) { // type=14,p2p忘记密码
				// 验证手机号是否存在
				AdminVO admin = new AdminVO();
				admin.setUsername(mobile);
				int result = adminServ.CoutAdminByCondition(admin, new Page());
				if (result == 0) {
					map.put("flag", "0");
					map.put("msg", "您的号码不存在");
					log.info("map = " + map);
					return map;
				}

				// 检查手机号码已发短信次数
				int sendTimes = commonServ.regSendTimes(mobile, type);
				log.info("注册, 号码 = " + mobile + " ,发送次数 = " + sendTimes);
				
					// 发送手机验证码
					int result2 = commonServ.sendMsg(mobile, type);
					if (result2 > 0) {
						map.put("flag", "1");
						map.put("msg", "短信发送成功");
						log.info("map = " + map);
						return map;
					}
			

			}
		} else {
			map.put("flag", "0");
			map.put("msg", "发送失败");
			log.info("map = " + map);
		}
		return map;
	}

	/**
	 * 验证验证码
	 * 
	 * @param mobile
	 *            --用户手机
	 * @param checkCode
	 *            --用户输入的验证码
	 * 
	 */
	@RequestMapping(value = "signup/checkcode", method = RequestMethod.POST)
	@ResponseBody
	public Object checkCode(HttpServletRequest request, HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		String mobile = request.getParameter("mobile");
		String authCode = request.getParameter("authCode");
		String type = request.getParameter("type");
		
		if (StringUtils.isNotEmpty(mobile) && StringUtils.isNotEmpty(authCode) && StringUtils.isNumeric(authCode)
				&& StringUtil.checkMobile(mobile)) {
			int flag = commonServ.checkCode(mobile, authCode, type);
			if (flag > 0) {
				map.put("flag", "1");
			} else {
				map.put("flag", "0");
			}
		} else {
			map.put("flag", "0");
		}
		return map;
	}
	/**
	 * 验证验证码
	 * 
	 * @param mobile
	 *            --用户手机号码已存在 ，在修改手机号码功能时 隐藏了中间4位号码
	 * @param checkCode
	 *            --用户输入的验证码
	 * 
	 */
	@RequestMapping(value = "signup/checkcode1", method = RequestMethod.POST)
	@ResponseBody
	public Object checkCode1(HttpServletRequest request, HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		String userId = request.getParameter("userId");
		String authCode = request.getParameter("authCode");
		String type = request.getParameter("type");
		String mobile =userServ.getUserByUserId(Integer.parseInt(userId)).getMobile();
		if (StringUtils.isNotEmpty(mobile) && StringUtils.isNotEmpty(authCode) && StringUtils.isNumeric(authCode)
				&& StringUtil.checkMobile(mobile)) {
			int flag = commonServ.checkCode(mobile, authCode, type);
			if (flag > 0) {
				map.put("flag", "1");
			} else {
				map.put("flag", "0");
			}
		} else {
			map.put("flag", "0");
		}
		return map;
	}
	
	/**
	 * 验证合同pdf是否存在
	 * 
	 * @param mobile
	 *            --用户手机号码已存在 ，在修改手机号码功能时 隐藏了中间4位号码
	 * @param checkCode
	 *            --用户输入的验证码
	 * 
	 */
	@RequestMapping(value = "checkContactPdf", method = RequestMethod.POST)
	@ResponseBody
	public Object checkContactPdf(HttpServletRequest request, HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		String contactFile = request.getParameter("contactFile");
		String file1 =PropertyFileUtil.getProperty("filePath")+contactFile;
		log.info("查询路径"+file1);
		if (StringUtils.isNotEmpty(file1)) {
			boolean flag = PDFUtil.checkFile1(file1);
			
			if (flag) {
				map.put("flag", "1");
			} else {
				map.put("flag", "0");
			}
		} else {
			map.put("flag", "0");
		}
//		map.put("flag", "1");
		return map;
	}
	
}
