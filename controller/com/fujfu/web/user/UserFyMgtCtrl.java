package com.fujfu.web.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fujfu.common.payment.fuyou.pojo.ChangeCardBean;
import com.fujfu.common.payment.fuyou.pojo.ChangeMobileBean;
import com.fujfu.common.payment.fuyou.pojo.PasswordMgtBean;
import com.fujfu.common.payment.fuyou.pojo.QueryChgCardBean;
import com.fujfu.common.payment.fuyou.pojo.QueryUserInfoBean;
import com.fujfu.common.payment.fuyou.pojo.UserArtifRegBean;
import com.fujfu.common.payment.fuyou.pojo.UserRegBean;
import com.fujfu.common.payment.fuyou.pojo.response.ChangeMobileResp;
import com.fujfu.common.payment.fuyou.pojo.response.QueryChgCardResp;
import com.fujfu.common.payment.fuyou.pojo.response.QueryUserInfoResp;
import com.fujfu.common.payment.fuyou.pojo.response.UserRegResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.FbdUtil;
import com.fujfu.common.util.FyReturnCode;
import com.fujfu.common.util.StringUtil;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.comuanda.AusersVO;
import com.fujfu.pojo.gat.GatApproveVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.comuanda.AusersServ;
import com.fujfu.service.gat.GatApproveSer;
import com.fujfu.service.user.UserFyMgtServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.service.util.MD5Utils;
import com.fujfu.web.BaseController;
import com.fujfu.web.util.PropertiesUtil;

/**
 * 富友用户管理 - 控制器类
 * 
 * @author hjz
 *
 */
@Controller
@RequestMapping("/fy/*")
public class UserFyMgtCtrl extends BaseController {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UserFyMgtCtrl.class);

	@Autowired
	private UserFyMgtServ fyMgtServ;

	@Autowired
	private UserServ userServ;

	@Autowired
	private UserAccountServ acctServ;
	@Resource
	private AusersServ ausersServ;
	@Resource
	private GatApproveSer gatApproveSer;
	/**
	 * 入口页面
	 * 
	 */
	@RequestMapping("regist")
	public ModelAndView regist(HttpServletRequest request, HttpServletResponse response) {
		//
		return new ModelAndView("views/user/fyRegister.jsp");
	}

	/**
	 * 註冊2.0
	 * 
	 */
	@RequestMapping("register")
	public String register(HttpServletRequest request, HttpServletResponse response, UserRegBean reqData,
			UserRegResp respData, QueryUserInfoResp userInfRsp, Model model, UserVO user) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		user_inf = userServ.getUserByUserId(user_inf.getUserId());
		String dateStr = DateUtil.getCurrentDate("yyyyMMddHHmmss") + UserAccountUtil.getManyNumber(4);
		reqData.setMchnt_txn_ssn(dateStr);

		// 因为user的手机号码中间四位隐藏所以需要重新放
		user.setMobile(user_inf.getMobile());
		if (user_inf == null) {
		}
		// 组装富友请求数据到reqData
		// 先查询富友是否已经注册 没有则发送到富友进行注册，有则根据返回的数据更新数据库
		QueryUserInfoBean queryUserInfoBean = new QueryUserInfoBean();
		QueryUserInfoResp queryUserInfoResp = new QueryUserInfoResp();
		queryUserInfoBean.setUser_ids(user_inf.getMobile());
		queryUserInfoResp = fyMgtServ.queryUserInfo(queryUserInfoBean);
		String queryUserInfoRespCode = queryUserInfoResp.getResponse().getResp_code();
		queryUserInfoResp = queryUserInfoResp.getResponse().getRespList().get(0);
		if ("0000".equals(queryUserInfoRespCode)
				&& ("".equals(queryUserInfoResp.getMobile_no()) || queryUserInfoResp.getMobile_no() == null)) {
			// 组装富友请求数据到reqData

			reqData.setMchnt_txn_ssn(dateStr);// 根据表单提交的user组装reqData
			reqData.setMchnt_cd(FyUtil.MCHNT_CD);// 商户代码
			reqData.setCust_nm(user.getRealname());// 客户名称
			reqData.setCertif_tp(user.getCardType().toString());// 证件类型
			reqData.setCertif_id(user.getCardId());// 身份证号码
			reqData.setMobile_no(user_inf.getMobile());// 手机号码
			// reqData.setEmail(user.getEmail());//邮箱
			reqData.setCity_id(user.getCity_id());// 开户行地区代码
			reqData.setParent_bank_id(user.getParent_bank_id());// 开户行行别
			// reqData.setBank_nm("");//开户行支行名称
			reqData.setCapAcntNo(user.getCapAcntNo());// 帐号
			reqData.setPassword(MD5Utils.MD5Encrypt(reqData.getPassword()));

			// reqData.setPassword("123456");//提现密码，不填默认为手机号后6位
			// reqData.setLpassword("123456");//登录密码，不填默认为手机号后6位
			reqData.setRem("");// 备注
			// 富友注册
			try {
				respData = fyMgtServ.userRegister(reqData);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				model.addAttribute("code", queryUserInfoRespCode);
				return "fail.jsp";
			}
			String respCode = respData.getResponse().getResp_code();
			log.info("resp code = " + respCode);// response code = 0000表示成功
			if ("0000".equals(respCode)) {
				user.setUserId(user_inf.getUserId());
				// 因为user和reqData 里面都有password，从form表单里面获取到的password都是一样，
				// 为了避免更新user表的
				user.setPassword(user_inf.getPassword());
				// 注册时保存金账户的登录id 此时是手机号码
				user.setJzhloginid(user.getMobile());
				userServ.updateUser(user);
				return "redirect:/account/center";
			}
		} else if ("0000".equals(queryUserInfoRespCode)
				&& (!"".equals(queryUserInfoResp.getMobile_no()) && queryUserInfoResp.getMobile_no() != null)) {

			// 因为user(用户密码)和reqData
			// （富友密码）里面都有password，从form表单里面获取到的password都是一样， 为了避免更新user表的
			user.setPassword(user_inf.getPassword());

			user.setRealname(queryUserInfoResp.getCust_nm());
			user.setJzhloginid(queryUserInfoResp.getLogin_id());
			user.setCardId(queryUserInfoResp.getCertif_id());
			user.setEmail(queryUserInfoResp.getEmail());
			user.setCity_id(queryUserInfoResp.getCity_id());
			user.setParent_bank_id(queryUserInfoResp.getParent_bank_id());
			user.setBank_nm(queryUserInfoResp.getBank_nm());
			user.setCapAcntNo(queryUserInfoResp.getCapAcntNo());
			userServ.updateUser(user);
			return "redirect:/account/center";
		}
		model.addAttribute("code", queryUserInfoRespCode);
		return "fail.jsp";
	}

	/**
	 * 公司註冊2.0
	 * 
	 */
	@RequestMapping("africregister")
	public String artifregister(HttpServletRequest request, HttpServletResponse response, UserArtifRegBean reqData,
			UserRegResp respData, QueryUserInfoResp userInfRsp, UserVO user, Model model) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		String dateStr = DateUtil.getCurrentDate("yyyyMMddHHmmss") + UserAccountUtil.getManyNumber(4);
		reqData.setMchnt_txn_ssn(dateStr);// 根据表单提交的user组装reqData
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);// 商户代码
		reqData.setCust_nm(user.getCorpName());// 企业名称
		reqData.setArtif_nm(user.getRealname());// 法人姓名
		reqData.setCertif_id(user.getCardId());// 身份证号码
		reqData.setMobile_no(user.getMobile());// 手机号码
		reqData.setEmail(user.getEmail());// 邮箱
		if(StringUtils.isNotEmpty(user.getCity_id())){
		reqData.setCity_id(user.getCity_id());// 开户行地区代码
		}else{
			model.addAttribute("msg", "开户行地区代码不能为空");
			return PropertiesUtil.MESSAGE_URL;
		}
		
		reqData.setParent_bank_id(user.getParent_bank_id());// 开户行行别
		reqData.setBank_nm(user.getBank_nm());// 开户行支行名称
		reqData.setCapAcntNo(user.getCapAcntNo());// 帐号
		reqData.setPassword("");// 提现密码，不填默认为手机号后6位
		reqData.setLpassword("");// 登录密码，不填默认为手机号后6位
		reqData.setRem("");// 备注
		if (user_inf == null) {
			// model.addAttribute("msg","请先登录");
			// return new ModelAndView("msg.jsp");
		}
		int count =userServ.checkUserCorpNameExist(user.getCorpName());//校验法人姓名唯一
		if(count>0){
			model.addAttribute("msg", "企业名称已被注册");
			return PropertiesUtil.MESSAGE_URL;
		}
		 count =userServ.checkCardIdExist("1", user.getCardId());//校验法人姓名唯一
		if(count>0){
			model.addAttribute("msg", "证件号已被注册");
			return PropertiesUtil.MESSAGE_URL;
		}
		count=userServ.checkUserActnoExist(user.getCapAcntNo());
		if(count>0){
			model.addAttribute("msg", "银行卡号已被使用");
			return PropertiesUtil.MESSAGE_URL;
		}
		
		// 先查询富友是否已经注册 没有则发送到富友进行注册，有则根据返回的数据更新数据库
		QueryUserInfoBean queryUserInfoBean = new QueryUserInfoBean();
		QueryUserInfoResp queryUserInfoResp = new QueryUserInfoResp();
		queryUserInfoBean.setUser_ids(user.getMobile());
		queryUserInfoResp = fyMgtServ.queryUserInfo(queryUserInfoBean);
		String queryUserInfoRespCode = queryUserInfoResp.getResponse().getResp_code();
		queryUserInfoResp = queryUserInfoResp.getResponse().getRespList().get(0);
		if ("0000".equals(queryUserInfoRespCode)
				&& ("".equals(queryUserInfoResp.getMobile_no()) || queryUserInfoResp.getMobile_no() == null)) {
			// 富友注册
			respData = fyMgtServ.userArtifRegister(reqData);
			String respCode = respData.getResponse().getResp_code();
			log.info("resp code = " + respCode);// response code = 0000表示成功
			if ("0000".equals(respCode)) {
				QueryUserInfoBean inf = new QueryUserInfoBean();
				inf.setMchnt_txn_dt(DateUtil.getCurrentDate("yyyyMMdd"));// yyyymmdd
				inf.setMchnt_txn_ssn(dateStr);
				inf.setUser_ids(reqData.getMobile_no());

				// FY查询操作，获取富友用户信息。
				userInfRsp = fyMgtServ.queryUserInfo(inf);

				// 插入记录-用户信息表
				QueryUserInfoResp info = userInfRsp.getResponse().getRespList().get(0);

				// 先添加至account,再从account中取出用户信息添加至fuyhui
				String ss = MD5Utils.MD5Encrypt(
						info.getMobile_no().substring(info.getMobile_no().length() - 6, info.getMobile_no().length()));
				AusersVO ausers = new AusersVO();
				ausers.setUsername(info.getMobile_no());
				ausers.setMobile(info.getMobile_no());
				ausers.setPassword(MD5Utils.MD5Encrypt(FbdUtil.PWD_SALT + ss));
				ausers.setCreated(DateUtil.getUnixTime());
				int result1 = ausersServ.addAusers(ausers);

				user.setUserId(ausers.getUserId());
				user.setUsername(info.getMobile_no());

				user.setPassword(MD5Utils.MD5Encrypt(FbdUtil.PWD_SALT + ss));
				// user.setRealname(info.getCust_nm());// 客户姓名
				user.setCreated(DateUtil.getUnixTime());// 创建时间
				user.setCardId(info.getCertif_id());// 证件号
				user.setMobile(info.getMobile_no());// 手机号
				user.setEmail(info.getEmail()); // 邮箱
				user.setCity_id(info.getCity_id());// 开户行地区代码
				user.setParent_bank_id(info.getParent_bank_id());// 开户行行别
				user.setBank_nm(info.getBank_nm());// 开户行支行名称
				user.setCapAcntNo(info.getCapAcntNo());// 帐号
				user.setJzhloginid(info.getMobile_no());
				user.setCardType(1);
				userServ.insertUser(user);

				// 插入记录-用户账户表
				UserAccountVO act = new UserAccountVO();
				act.setUserId(user.getUserId());
				acctServ.insert(act);
				return "redirect:/admin/user/index?userType=" + user.getUserType();
			}
			model.addAttribute("msg", FyReturnCode.codeType.get(respCode));
			return PropertiesUtil.MESSAGE_URL;
		} else if ("0000".equals(queryUserInfoRespCode)
				&& (!"".equals(queryUserInfoResp.getMobile_no()) && queryUserInfoResp.getMobile_no() != null)) {
			model.addAttribute("msg", "用户已开户");

			return PropertiesUtil.MESSAGE_URL;
		}
		Object value = FyReturnCode.codeType.get(queryUserInfoRespCode);
		if (value != null) {
			model.addAttribute("msg", FyReturnCode.codeType.get(queryUserInfoRespCode));
		} else {
			model.addAttribute("msg", "交易失败");
		}
		return PropertiesUtil.MESSAGE_URL;
	}

	/**
	 * 个人註冊2.0接口
	 * 
	 */
	@RequestMapping("registerjiekou")
	@ResponseBody
	public Object registerjiekou(HttpServletRequest request, HttpServletResponse response, UserRegBean reqData,
			UserRegResp respData, QueryUserInfoResp userInfRsp, Model model, UserVO user) {
		Map<String, Object> map = new HashMap<String, Object>();

		UserVO user_inf = (UserVO) getSession("user_inf");
		if (user_inf == null) {
			map.put("flag", "2");
			map.put("msg", "请先登录");
			return map;
		}
		UserVO user1 = userServ.getUserByUserId(user_inf.getUserId());
		//判断手机号是否已提交港澳台开户审批中
		//校验是否有审批中的开户申请记录
		GatApproveVO gatApprove = new GatApproveVO();
		gatApprove.setMobile(user1.getMobile());
		int count1 =gatApproveSer.countGatApproveByStatus(gatApprove);
		if(count1>0){
			map.put("flag", "2");
			map.put("msg", "手机号正在进行港澳台开户审批");
			return map;
		}
		
		if (user.getCardType() == 1) {//如果是身份则直接发送到富友进行开户
			String dateStr = DateUtil.getCurrentDate("yyyyMMddHHmmss") + UserAccountUtil.getManyNumber(4);
			reqData.setMchnt_txn_ssn(dateStr);

			// 因为user的手机号码中间四位隐藏所以需要重新放
			user.setMobile(user1.getMobile());

			// 组装富友请求数据到reqData
			// 先查询富友是否已经注册 没有则发送到富友进行注册，有则根据返回的数据更新数据库
//			QueryUserInfoBean queryUserInfoBean = new QueryUserInfoBean();
//			QueryUserInfoResp queryUserInfoResp = new QueryUserInfoResp();
//			queryUserInfoBean.setUser_ids(user1.getMobile());
//			queryUserInfoResp = fyMgtServ.queryUserInfo(queryUserInfoBean);
//			String queryUserInfoRespCode = queryUserInfoResp.getResponse().getResp_code();
//			queryUserInfoResp = queryUserInfoResp.getResponse().getRespList().get(0);
//			if ("0000".equals(queryUserInfoRespCode)
//					&& ("".equals(queryUserInfoResp.getMobile_no()) || queryUserInfoResp.getMobile_no() == null)) {
				// 组装富友请求数据到reqData

				reqData.setMchnt_txn_ssn(dateStr);// 根据表单提交的user组装reqData
				reqData.setMchnt_cd(FyUtil.MCHNT_CD);// 商户代码
				reqData.setCust_nm(user.getRealname());// 客户名称
				if ("1".equals(user.getCardType().toString())) {
					reqData.setCertif_tp("0");// 证件类型
				} else {
					reqData.setCertif_tp("7");// 证件类型
				}
				reqData.setCertif_id(user.getCardId());// 身份证号码
				reqData.setMobile_no(user1.getMobile());// 手机号码
				// reqData.setEmail(user.getEmail());//邮箱
				reqData.setCity_id(user.getCity_id());// 开户行地区代码
				reqData.setParent_bank_id(user.getParent_bank_id());// 开户行行别
				// reqData.setBank_nm(user.getBank_nm());//开户行支行名称
				reqData.setCapAcntNo(user.getCapAcntNo());// 帐号
				reqData.setPassword(MD5Utils.MD5Encrypt(reqData.getPassword()));

				// reqData.setPassword("123456");//提现密码，不填默认为手机号后6位
				// reqData.setLpassword("123456");//登录密码，不填默认为手机号后6位
				reqData.setRem("");// 备注
				// 富友注册
				try {
					respData = fyMgtServ.userRegister(reqData);
				} catch (Exception e) {
					map.put("flag", "2");
					map.put("msg", "交易失败");
					return map;
				}
				String respCode = respData.getResponse().getResp_code();
				log.info("resp code = " + respCode);// response code = 0000表示成功
				if ("0000".equals(respCode)) {
					user.setUserId(user1.getUserId());
					// 因为user和reqData 里面都有password，从form表单里面获取到的password都是一样，
					// 为了避免更新user表的
					user.setPassword(user1.getPassword());
					// 注册时保存金账户的登录id 此时是手机号码
					user.setJzhloginid(user.getMobile());
					user.setIsInside(0);//是否内部会员
					userServ.updateUser(user);
					user_inf = userServ.getUserByUserId(user_inf.getUserId());
					user_inf.setRealname(StringUtil.handleName(user_inf.getRealname()));
					user_inf.setCardId(StringUtil.handleCardId(user_inf.getCardId()));
					user_inf.setUsername(StringUtil.handlePhone(user_inf.getMobile()));
					user_inf.setCapAcntNo(StringUtil.handleBankNo1(user_inf.getCapAcntNo()));
					user_inf.setMobile(StringUtil.handlePhone(user_inf.getMobile()));// 手机号

					addSession("user_inf", user_inf);

					map.put("flag", "1");
					map.put("msg", "开通富友账户成功");
				} else {
					map.put("flag", "2");
					Object value = FyReturnCode.codeType.get(respCode);
					if (value != null) {
						map.put("msg", FyReturnCode.codeType.get(respCode));
					} else {
						map.put("msg", "交易失败");
					}
				}
			/*} else if ("0000".equals(queryUserInfoRespCode)
					&& (!"".equals(queryUserInfoResp.getMobile_no()) && queryUserInfoResp.getMobile_no() != null)) {
				if (StringUtils.isNotEmpty(user1.getCapAcntNo())) {
					map.put("flag", "2");
					map.put("msg", "您已开通富友账户，请勿重复点击");
				} else {
					// 因为user(用户密码)和reqData
					// （富友密码）里面都有password，从form表单里面获取到的password都是一样，
					// 为了避免更新user表的
					user.setUserId(user1.getUserId());
					user.setPassword(user1.getPassword());

					user.setRealname(queryUserInfoResp.getCust_nm());
					user.setJzhloginid(queryUserInfoResp.getLogin_id());
					user.setCardId(queryUserInfoResp.getCertif_id());
					user.setEmail(queryUserInfoResp.getEmail());
					user.setCity_id(queryUserInfoResp.getCity_id());
					user.setParent_bank_id(queryUserInfoResp.getParent_bank_id());
					user.setBank_nm(queryUserInfoResp.getBank_nm());
					user.setCapAcntNo(queryUserInfoResp.getCapAcntNo());
					user.setIsInside(0);//是否内部会员
					userServ.updateUser(user);

					user_inf.setRealname(StringUtil.handleName(user.getRealname()));
					user_inf.setCardId(StringUtil.handleCardId(user.getCardId()));
					user_inf.setUsername(StringUtil.handlePhone(user.getMobile()));
					user_inf.setCapAcntNo(StringUtil.handleBankNo1(user.getCapAcntNo()));
					user_inf.setMobile(StringUtil.handlePhone(user.getMobile()));// 手机号

					addSession("user_inf", user_inf);
					map.put("flag", "1");

					map.put("msg", "开通富友账户成功");
				}
			} else {
				map.put("flag", "2");
				Object value = FyReturnCode.codeType.get(queryUserInfoRespCode);
				if (value != null) {
					map.put("msg", FyReturnCode.codeType.get(queryUserInfoRespCode));
				} else {
					map.put("msg", "交易失败");
				}
			}*/
			return map;
		} else {//如果证件类型不为身份证 ，则进行后台审批后再进行开户
			 gatApprove = new GatApproveVO();
			gatApprove.setUserId(user1.getUserId());
			int count =gatApproveSer.countGatApproveByStatus(gatApprove);
			if(count>0){
				map.put("flag", "2");
				map.put("msg", "已存在正在审批的港澳台开户记录");
				return map;
			}			
			gatApprove.setUserId(user1.getUserId());
			gatApprove.setCardType(user.getCardType());
			gatApprove.setCardId(user.getCardId());
			gatApprove.setCardIdPic(user.getCardPic());
			gatApprove.setCard2Pic(user.getCard2Pic());
			gatApprove.setMobile(user1.getMobile());
			gatApprove.setRealname(user.getRealname());
			gatApprove.setBank(user.getParent_bank_id());
			gatApprove.setCardNumber(user.getCapAcntNo());
			gatApprove.setBankCardPic(user.getBankCardPic());
			gatApprove.setProvince(Integer.parseInt(user.getCountry_id()));
			gatApprove.setCity(Integer.parseInt(user.getCity_id()));
			gatApprove.setBranch(user.getBank_nm());
			gatApprove.setCashPassword(MD5Utils.MD5Encrypt(reqData.getPassword()));
			gatApprove.setApproveStatus("1");
			gatApprove.setCreated(DateUtil.getUnixTime());
			gatApprove.setUpdated(DateUtil.getUnixTime());
			gatApproveSer.addGatApprove(gatApprove);
			map.put("flag", "2");
			map.put("msg", "已提交,将在1-2个工作日进行审核");
			return map;
		}
	}

	/**
	 * 查詢用户信息
	 * 
	 */
	@RequestMapping("queryInfo")
	public ModelAndView queryInfo(HttpServletRequest request, HttpServletResponse response, QueryUserInfoBean reqData,
			QueryUserInfoResp respData, Model model) {

		respData = fyMgtServ.queryUserInfo(reqData);
		if (respData.getResponse().getResp_code().equals(FyUtil.SUCCESS)) {
			model.addAttribute("info", respData.getResponse().getRespList().get(0));
			return new ModelAndView("success.jsp");
		}
		// 数据处理
		model.addAttribute("code", respData.getResponse().getResp_code());
		return new ModelAndView("fail.jsp");
	}

	/**
	 * 用户修改手机号
	 * 
	 */
	@RequestMapping("chgMobile")

	public ModelAndView chgMobile(HttpServletRequest request, HttpServletResponse response, ChangeMobileBean reqData,
			Model model, String per_userids) {
		UserVO userInf = (UserVO) getSession("user_inf");
		UserVO user = userServ.getUserByUserId(userInf.getUserId());

		// 设置登录号
		reqData.setLogin_id(user.getJzhloginid());
		reqData = fyMgtServ.changeMobile(reqData);
		model.addAttribute("reqData", reqData);
		return new ModelAndView("views/user/chgMobile.jsp");
	}

	/**
	 * 用户修改手机号回调地址
	 * 
	 */
	@RequestMapping("chgMobileIndex")
	public String chgMobileIndex(HttpServletRequest request, HttpServletResponse response, ChangeMobileResp reqData,
			Model model) {
		UserVO userInf = (UserVO) getSession("user_inf");
		if (userInf == null) {
			List<UserVO> userlist = userServ.getUserByjzhLoginId(reqData.getLogin_id());
			if (userlist.size() > 0) {
				userInf = userlist.get(0);
			}
		} else {
			log.info("修改手机回调失败，无法获取用户信息，无法更新用户信息到系统。富友登录号=" + reqData.getLogin_id() + "用户新手机号码="
					+ reqData.getNew_mobile() + "修改流水号" + reqData.getMchnt_txn_ssn());
		}

		if (reqData.getResp_code().equals(FyUtil.SUCCESS)) {
			// 验签
			UserVO user = new UserVO();
			user.setUserId(userInf.getUserId());
			user.setMobile(reqData.getNew_mobile());
			userServ.updateUser(user);
			AusersVO ausers = new AusersVO();
			ausers.setUserId(user.getUserId());
			ausers.setMobile(reqData.getNew_mobile());
			ausersServ.updateAusers(ausers);
			userInf.setMobile(StringUtil.handlePhone(reqData.getNew_mobile()));// 手机号
			addSession("userInf", userInf);
			return "redirect:/myAccount/personalErrors";
		} else {
			Object value = FyReturnCode.codeType.get(reqData.getResp_code());
			if (value != null) {
				model.addAttribute("code", FyReturnCode.codeType.get(reqData.getResp_code()));
			} else {
				model.addAttribute("code", "交易失败");
			}
			return "fail.jsp";
		}

	}

	/**
	 * 用户密码管理
	 * 
	 */
	@RequestMapping("pwdMgt")

	public ModelAndView pwdMgt(HttpServletRequest request, HttpServletResponse response, PasswordMgtBean reqData,
			Model model) {
		UserVO userInf = (UserVO) getSession("user_inf");
		reqData.setLogin_id(userInf.getJzhloginid());
		reqData.setBusi_tp("3");
		reqData = fyMgtServ.passwordMgt(reqData);
		model.addAttribute("reqData", reqData);
		return new ModelAndView("views/user/passwordMgt.jsp");
	}

	/**
	 * 用户密码管理回调地址
	 * 
	 */
	@RequestMapping("pwdMgtIndex")

	public String pwdMgtIndex(HttpServletRequest request, HttpServletResponse response, ChangeMobileResp reqData,
			Model model) {
		// String code =reqData.getResponse().getResp_code();

		return "redirect:/myAccount/enterUserAccount";

	}

	/**
	 * 更换银行卡
	 * 
	 */
	@RequestMapping("chgCard")
	public ModelAndView chgCard(HttpServletRequest request, HttpServletResponse response, ChangeCardBean reqData,
			Model model) {
		reqData = fyMgtServ.changeCard(reqData);
		model.addAttribute("reqData", reqData);
		return new ModelAndView("views/user/chgCard.jsp");
	}

	/**
	 * 更换银行卡回调地址
	 * 
	 */
	@RequestMapping("chgCardIndex")
	public ModelAndView chgCardIndex(HttpServletRequest request, HttpServletResponse response, ChangeMobileResp reqData,
			Model model) {
		return new ModelAndView("success.jsp");
	}

	/**
	 * 查询更换银行卡
	 * 
	 */
	@RequestMapping("queryChgCard")
	public ModelAndView queryChgCard(HttpServletRequest request, HttpServletResponse response, QueryChgCardBean reqData,
			QueryChgCardResp respData, Model model) {
		respData = fyMgtServ.queryChgCard(reqData);
		model.addAttribute("queryChgCard", respData.getResponse());
		return new ModelAndView("success.jsp");
	}
}
