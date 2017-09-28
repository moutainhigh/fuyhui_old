package com.fujfu.web.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fujfu.common.payment.fuyou.pojo.UserRechargeBean;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.FbdUtil;
import com.fujfu.common.util.PDFDemo;
import com.fujfu.common.util.PropertyFileUtil;
import com.fujfu.common.util.SmsTypeUtil;
import com.fujfu.common.util.StringUtil;
import com.fujfu.common.util.UploadUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.common.SelCodeVO;
import com.fujfu.pojo.comuanda.AusersVO;
import com.fujfu.pojo.gat.GatApproveVO;
import com.fujfu.pojo.loan.LoanPOJO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.pojo.user.UserPOJO;
import com.fujfu.service.common.CommonServ;
import com.fujfu.service.common.SelCodeServ;
import com.fujfu.service.comuanda.AusersServ;
import com.fujfu.service.gat.GatApproveSer;
import com.fujfu.service.loan.LoanApplyServ;
import com.fujfu.service.loan.LoanTypeServ;
import com.fujfu.service.recommend.RecommendSer;
import com.fujfu.service.user.UserServ;
import com.fujfu.service.util.MD5Utils;
import com.fujfu.web.BaseController;

@Controller
@RequestMapping("/user/")
public class UserCtrl extends BaseController {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserServ userServ;
	@Resource
	private AusersServ ausersServ;
	@Resource
	private LoanApplyServ loanApplyServ;
	@Resource
	private LoanTypeServ loanTypeServ;
	@Resource
	private SelCodeServ selCodeServ;
	@Resource
	private CommonServ commonServ;
	@Resource
	private RecommendSer recommendSer;
	@Resource
	GatApproveSer gatApproveSer;
	@RequestMapping("index")
	public String index(HttpServletRequest request, Page page, String mobile, String startTime, String endTime,
			Model model) {
		UserPOJO userQueryVo = new UserPOJO();
		userQueryVo.setUserType("1");
		if (StringUtils.isNotEmpty(startTime)) {
			try {
				userQueryVo.setStartTime(DateUtil.dateTimeStamp(startTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(endTime)) {
			try {
				userQueryVo.setEndTime(DateUtil.dateTimeStamp(endTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(mobile)) {
			userQueryVo.setMobile(mobile);
		}
		Page userList = userServ.findUserByCondition(userQueryVo, page);
		
		
		model.addAttribute("mobile", mobile);
		model.addAttribute("startTime", startTime);
		model.addAttribute("endTime", endTime);
		model.addAttribute("userList", userList);
		
		return "views/admin/user/userList.jsp";

	}

	/**
	 * 更改锁定状态
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("changeLockStatus")
	public String changeLockStatus(Model model, String userid, String target) {
		UserVO user = new UserVO();
		user.setUserId(Integer.parseInt(userid));
		user.setIsLock(0);
		user.setLoginTimes(0);
		user.setLockTime(0);
		int result = userServ.updateUser(user);
		if (result > 0) {
			model.addAttribute("msg", "解锁成功");
		} else {
			model.addAttribute("msg", "解锁失败");
		}
		return "redirect:/user/index?target=" + target;
	}
	
	/**
	 * 更改是否内部用户
	 * @param model
	 * @param userId
	 * @param isInside
	 * @return
	 */
	@RequestMapping("changeInsideStatus")
	public String changeInsideStatus(Model model, String userId, String isInside) {
		UserVO user = new UserVO();
		user.setUserId(Integer.parseInt(userId));
		user.setIsInside(Integer.parseInt(isInside));
		int result = userServ.updateUser(user);
		if (result > 0) {
			model.addAttribute("msg", "更改状态成功");
		} else {
			model.addAttribute("msg", "更改状态失败");
		}
		return "redirect:/user/index";
	}

	/**
	 * 更改用戶名
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("updateUserName")
	public String updateUserName(HttpServletRequest request, String username) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		int count1 = userServ.checkUsername(username);// mobile指用戶名
		if (count1 > 0) {
			return "";
		}else{
		UserVO user = new UserVO();
		user.setUserId(user_inf.getUserId());
		user.setUsername(username);
		user.setUserNameStatus(1);
		userServ.updateUser(user);

		// 更新到a_user表
		AusersVO ausers = new AusersVO();
		ausers.setUserId(user.getUserId());
		ausers.setUsername(user.getUsername());
		ausersServ.updateAusers(ausers);
		user_inf.setUsername(StringUtil.getHandleUserName(username));
		addSession("user_inf", user_inf);
		if ("1".equals(user_inf.getUserType())) {
			return "views/userAccount/personalinfos.jsp";
		} else if ("2".equals(user_inf.getUserType())) {
			return "views/borrowerCenter/borrowPersonalinfos.jsp";
		} else {
			return "views/institutionsCenter/insPersonalinfos.jsp";
		}
		}

	}

	/**
	 * 更改用戶名
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("updateUserNamejiek")
	@ResponseBody
	public Object updateUserNamejiek(HttpServletRequest request, String username) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		Map<String, Object> map = new HashMap<String, Object>();
		if (user_inf != null) {
			int count1 = userServ.checkUsername(username);// mobile指用戶名
			if (count1 > 0) {
				map.put("flag", "0");
				map.put("msg", "用户名已被使用");
			}

			UserVO user = new UserVO();
			user.setUserId(user_inf.getUserId());
			user.setUsername(username);
			user.setUserNameStatus(1);
			userServ.updateUser(user);

			// 更新到a_user表
			AusersVO ausers = new AusersVO();
			ausers.setUserId(user.getUserId());
			ausers.setUsername(user.getUsername());
			ausersServ.updateAusers(ausers);
			user_inf.setUsername(StringUtil.getHandleUserName(username));
			addSession("user_inf", user_inf);
			map.put("flag", "1");
			map.put("msg", "修改成功");
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");

		}
		return map;
	}

	/**
	 * 更改密碼
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("updateUserPassWord")
	@ResponseBody
	public Object updateUserPassWord(String userid, String oldpwd, String newpwd) {

		UserVO user_inf = (UserVO) getSession("user_inf");
		Map<String, Object> map = new HashMap<String, Object>();
		if (user_inf != null) {
			user_inf =userServ.getUserByUserId(Integer.parseInt(userid));
			String passWord = user_inf.getPassword();
			String oldPassWord = MD5Utils.MD5Encrypt(FbdUtil.PWD_SALT + oldpwd);
			String newPassWord = MD5Utils.MD5Encrypt(FbdUtil.PWD_SALT + newpwd);

			if (!passWord.equals(oldPassWord)) {
				map.put("flag", "0");
				map.put("msg", "原密码错误");
				map.put("url", "");
			} else {

				UserVO user = new UserVO();
				user.setUserId(Integer.parseInt(userid));
				user.setPassword(newPassWord);
				userServ.updateUser(user);

				AusersVO ausers = new AusersVO();
				ausers.setUserId(user.getUserId());
				ausers.setPassword(newPassWord);
				ausersServ.updateAusers(ausers);

				map.put("flag", "1");
				map.put("msg", "更新成功");
				commonServ.sendRepMobiMsg(user_inf.getMobile(), SmsTypeUtil.P2P_PASSWORD_UPD, DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"), "", "","");
				// map.put("url", "views/userAccount/personalinfos.jsp");
				map.put("url", "");
			}
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");

		}
		return map;
	}

	@RequestMapping("updateUserMobile")
	@ResponseBody
	public Object updateUserMobile(String userid, String newMobile) {

		Map<String, String> map = new HashMap<String, String>();

		UserVO user = new UserVO();
		user.setUserId(Integer.parseInt(userid));
		user.setMobile(newMobile);
		userServ.updateUser(user);

		AusersVO ausers = new AusersVO();
		ausers.setUserId(user.getUserId());
		ausers.setMobile(newMobile);
		ausersServ.updateAusers(ausers);

		map.put("flag", "1");
		map.put("msg", "更新成功");
		// map.put("url", "views/userAccount/personalinfos.jsp");
		map.put("url", "");

		return map;

	}

	@RequestMapping("getApplyLoanList")
	@ResponseBody
	public Object getApplyLoanList(HttpSession session, String pageNum, String pageSize, String loanType) {		
		UserVO userInf = (UserVO) getSession("user_inf");
		int isInside = 0;
		if (userInf != null) {
			userInf = userServ.getUserByUserId(userInf.getUserId());
			if(userInf.getIsInside()==1){
				isInside = 1;
			}
		}
		Integer loanTypeid=0;
        if(StringUtils.isNotEmpty(loanType)){
		  loanTypeid=loanTypeServ.findloanTypeIdByName(loanType);
        }
		if (StringUtils.isEmpty(pageNum)) {
			pageNum = "1";
		}
		if (StringUtils.isEmpty(pageSize)) {
			pageSize = "3";
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		String loanTypeidStr ="";
		if(loanTypeid>0){
			loanTypeidStr=loanTypeid.toString();
		}
		ArrayList<LoanPOJO> list = (ArrayList<LoanPOJO>) loanApplyServ.finLoanListByType(isInside, loanTypeidStr, Integer.parseInt(pageSize),
				Integer.parseInt(pageNum));

		map.put("flag", "1");
		map.put("content", list);
		return map;

	}

	
	/**
	 * 更改图像
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("updateAvatar1")
	@ResponseBody
	public Object updateAvatar1(final MultipartFile apkFile, HttpServletResponse response, HttpServletRequest request,
			Model model) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		Map<String, Object> map = new HashMap<String, Object>();
		String absolutePath =PropertyFileUtil.getProperty("filePath")+File.separator+"avatar";
		String originalName = apkFile.getOriginalFilename();
		UserVO user = new UserVO();
		if (apkFile.getSize() > 1024*1024) {
			map.put("msg", "图片不能大于1M");
			map.put("flag", 0);
		} else {
			if (!StringUtil.isEmpty(originalName)) {
				String[] stringArr = originalName.split("\\.");
				String s1 = stringArr[1];
				try {
					boolean BO = UploadUtil.uploadFile(absolutePath, apkFile.getInputStream(), originalName,
							user_inf.getUserId() + "avatar");
					System.out.println("BO"+BO);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				user.setUserId(user_inf.getUserId());
				user.setAvatar( File.separator+"avatar"+File.separator+user_inf.getUserId() + "avatar." + s1);
				userServ.updateUser(user);
				user_inf.setAvatar( File.separator+"avatar"+File.separator+user_inf.getUserId() + "avatar." + s1);
				addSession("user_inf", user_inf);
				map.put("flag", 1);
			}else{
				map.put("flag", 0);
			}
		}
		return map;
	}

	/**
	 * 获取个人信息状态
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("getPersonStatus")
	@ResponseBody
	public Object getPersonStatus(HttpServletResponse response, HttpServletRequest request, Model model) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		// user_inf =userServ.getUserByUserId(1000000113);

		Map<String, Object> map = new HashMap<String, Object>();

		if (user_inf != null) {
			UserVO user = new UserVO();
			user = userServ.getUserByUserId(user_inf.getUserId());
			// 获取头像状态 0为未设置 1为已设置
			if (StringUtils.isEmpty(user.getAvatar())) {
				map.put("avatarFlag", "0");
			} else {
				map.put("avatarFlag", "1");
			}
			// 获取用户名是否可修改userNameStatus
			map.put("userNameFlag", user.getUserNameStatus());
			// 登录密码手机号码默认为已设置
			map.put("loginpasswordFlag", 1);
			map.put("MobilFlag", 1);
			// 邮箱
			if (StringUtils.isEmpty(user.getEmail())) {
				map.put("emailFlag", "0");
			} else {
				map.put("emailFlag", "1");
			}
			// 实名认证和 绑卡都是发送到富友
			if (StringUtils.isEmpty(user.getCapAcntNo())) {//判断是否已经开户
				GatApproveVO gatApprove=new GatApproveVO();
				gatApprove.setUserId(user.getUserId());
				//判断是否存在正在审批中的记录
				int countByStatus  = gatApproveSer.countGatApproveByStatus(gatApprove);
				if(countByStatus>0){
					map.put("cardFlag", "2");
					map.put("acntNoFlag", "2");
					map.put("tixPassWordFlag", "2");
					map.put("GatApproveFlag", "2");
				}else{
					//查询是否存在已审批拒绝的记录
					countByStatus=gatApproveSer.countGatApproveByUserId(user.getUserId().toString());
					if(countByStatus>0){
						map.put("cardFlag", "3");
						map.put("acntNoFlag", "3");
						map.put("tixPassWordFlag", "3");
						map.put("GatApproveFlag", "3");
					}else{
				       map.put("cardFlag", "0");
				       map.put("acntNoFlag", "0");
				       map.put("tixPassWordFlag", "0");
				       map.put("GatApproveFlag", "0");
					}
				}

			} else {
				map.put("cardFlag", "1");
				map.put("acntNoFlag", "1");
				map.put("tixPassWordFlag", "1");
				map.put("GatApproveFlag", "1");
			}
			// 提现密码直接连富友修改 默认为已设置

			// 常用地址
			if (StringUtils.isEmpty(user.getAddress())) {
				map.put("ArdessFlag", "0");
			} else {
				map.put("ArdessFlag", "1");
			}
			map.put("CropNameFlag", "1");// 企业名称
			map.put("RealNameFlag", "1");// 法人姓名
			map.put("provinceFlag", "1");// 企业开户省区
			map.put("fuyouFlag", "1");// 富友账户
			//风险测评结果
			if (StringUtils.isNotEmpty(user.getAssessmentResult())) {
				map.put("assessmentResult", user.getAssessmentResult());
			} else {
				map.put("assessmentResult", "0");
			}
			
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}

	}

	/**
	 * 更改邮箱
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("updateUserEmail")
	@ResponseBody
	public Object updateUserEmail(HttpServletRequest request, String email) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		Map<String, Object> map = new HashMap<String, Object>();
		if (user_inf != null) {
			if (!StringUtil.isEmpty(email)) {
				int countUser = userServ.getCountByEmail(email);
				if (countUser > 0) {
					map.put("flag", "0");
					map.put("msg", "邮箱已使用");
					return map;
				}
			} else {
				map.put("flag", "0");
				map.put("msg", "邮箱不能为空");
			}

			UserVO user = new UserVO();
			user.setUserId(user_inf.getUserId());
			user.setEmail(email);
			userServ.updateUser(user);
			user_inf.setEmail(email);
			addSession("user_inf", user_inf);
			map.put("flag", "1");
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}

	/**
	 * 更改常住地址
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("updatedress")
	@ResponseBody
	public Object updateAdress(HttpServletRequest request) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		// user_inf =userServ.getUserByUserId(1000000113);

		String countryCode1 = request.getParameter("countryCode1");
		String countryCode2 = request.getParameter("countryCode2");
		String countryCode3 = request.getParameter("countryCode3");
		String address = request.getParameter("address");

		Map<String, Object> map = new HashMap<String, Object>();
		if (user_inf != null) {
			UserVO user = new UserVO();
			user.setUserId(user_inf.getUserId());
			user.setAddress(address);
			user.setCountryCode1(countryCode1);
			user.setCountryCode2(countryCode2);
			user.setCountryCode3(countryCode3);
			userServ.updateUser(user);

			user_inf.setAddress(address);
			user_inf.setCountryCode1(countryCode1);
			user_inf.setCountryCode2(countryCode2);
			user_inf.setCountryCode3(countryCode3);
			addSession("user_inf", user_inf);
			map.put("flag", "1");
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}

	@RequestMapping("/enterEscrowbefore")
	@ResponseBody
	public Object enterEscrowAccount(HttpServletRequest request, HttpServletResponse response, UserRechargeBean reqData,
			Model model) {

		Map<String, Object> map = new HashMap<String, Object>();
		// 把城市选择框代码和银行代码加载到页面中
		List<SelCodeVO> citycodelist1 = selCodeServ.findSelCodeByStyle("city", "1");
		List<SelCodeVO> bankcodelist = selCodeServ.findSelCodeByStyle("bank", "1");
		map.put("citycodelist1", citycodelist1);
		map.put("bankcodelist", bankcodelist);
		return map;

	}

	/**
	 * 选择省份后根据省份信息获取下级市县信息
	 * 
	 * @return
	 */
	@RequestMapping("/getcityidList1")
	@ResponseBody
	public Object getcityidList(HttpServletRequest request, String itemno, String itemno1, HttpSession session,
			Model model) {
		List<SelCodeVO> citycodelist2 = selCodeServ.findSelCodeByBelongItemno("city", itemno);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("citycodelist2", citycodelist2);
		return map;

	}

	/**
	 * 下载
	 * 
	 * @return
	 */
	@RequestMapping("cotractDownLoad")
	public Object cotractDownLoad(HttpServletResponse response, HttpServletRequest request) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		String filename = "test.pdf";
		if (user_inf != null) {
			filename = request.getParameter("filename");
		} else {
			filename = "test.pdf";
		}
		if (StringUtils.isEmpty(filename)) {

		}
		String absolutePath = request.getSession().getServletContext().getRealPath("") + File.separator + "fyh"
				+ File.separator + "pfd";
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + filename);

		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(absolutePath + "\\" + filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		OutputStream os = null;
		try {
			os = response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] b = new byte[2048];
		int length;
		try {
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 这里主要关闭。
		try {
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;

	}

	/**
	 * 生成PDF
	 * 
	 * @return
	 */
	@RequestMapping("createPdf")
	@ResponseBody
	public Object createPdf(HttpServletResponse response, HttpServletRequest request) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		String filename = "";
		if (user_inf != null) {
			filename = user_inf.getUserId().toString() + DateUtil.getCurrentDate("yyyyMMddHHmmss") + ".pdf";
		} else {
			filename = "test.pdf";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		String textInfo = request.getParameter("textInfo");
		PDFDemo pdfDemo = new PDFDemo();
		String absolutePath = request.getSession().getServletContext().getRealPath("") + File.separator + "fyh"
				+ File.separator + "pfd";
		File parent = null;
		parent = new File(absolutePath);// 文件绝对路径
		if (!parent.exists()) {
			parent.mkdirs();
		}
		try {
			pdfDemo.writePdf1(absolutePath + "\\" + filename, "", textInfo);
			addSession("filename", filename);
			map.put("msg", "1");
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("msg", "2");
		return map;

	}
	/**
	 * 更新风险测评结果
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("updateAssessmentResult")
	@ResponseBody
	public Object updateAssessmentResult(HttpServletRequest request, String assessmentResult) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		Map<String, Object> map = new HashMap<String, Object>();
		if (user_inf != null) {
			
			UserVO user = new UserVO();
			user.setUserId(user_inf.getUserId());
			user.setAssessmentResult(assessmentResult);
			userServ.updateUser(user);
			map.put("flag", "1");
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}
	/**
	 * 查询风险测评结果
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("getAssessmentResult")
	@ResponseBody
	public Object getAssessmentResult(HttpServletRequest request) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		Map<String, Object> map = new HashMap<String, Object>();
		if (user_inf != null) {
			UserVO user =userServ.getUserByUserId(user_inf.getUserId());
			if(StringUtils.isNotEmpty(user.getAssessmentResult())){
				map.put("flag", "1");
				map.put("assessmentResultflag", "1");
			}else{
				map.put("flag", "1");
				map.put("assessmentResultflag", "0");
			}			
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}
	
	/**
	 * 前台好友详情列表展示接口
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("getRecommenFriendsListByUserid")
	@ResponseBody
	public Object getRecommenFriendsListByUserid(HttpServletRequest request, String pageNum, String pageSize) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		// 判断当前页是否有值，没有则设置默认值
		if (StringUtils.isEmpty(pageNum)) {
			pageNum = "1";
		}
		if (StringUtils.isEmpty(pageSize)) {
			pageSize = "8";
		}
		// user_inf=userServ.getUserByUserId(1000000309);
		Map<String, Object> map = new HashMap<String, Object>();
		if (user_inf != null) {
			UserVO user = userServ.getUserByUserId(user_inf.getUserId());
			map = recommendSer.selectRecommenFriendsListByUserid(user.getUserId(),
					Integer.parseInt(pageSize) * (Integer.parseInt(pageNum) - 1), Integer.parseInt(pageSize));
			map.put("flag", "1");
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}
	/**
	 * 前台推荐方式展示
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("getRecommenFriendsShow")
	@ResponseBody
	public Object getRecommenFriendsShow(HttpServletRequest request) {
		UserVO user_inf = (UserVO) getSession("user_inf");		
		// user_inf=userServ.getUserByUserId(1000000304);
		Map<String, Object> map = new HashMap<String, Object>();
		if (user_inf != null) {
			UserVO user = userServ.getUserByUserId(user_inf.getUserId());
			Integer rewardTime;
			try {
				rewardTime = DateUtil.convert2int(DateUtil.getCurrentDate("yyyy-MM-dd"), "yyyy-MM-dd");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				map.put("flag", "0");
				map.put("msg", "系统异常");
				return map ;
			}
			String loginurl=PropertyFileUtil.getProperty("loginUrl");
			String aWardYesterday = recommendSer.selectSumAmountByQueryCondition(user.getUserId(), rewardTime, "2");
			String aWardSum= recommendSer.selectSumAmountByQueryCondition(user.getUserId(), null, "2");
			map.put("flag", "1");
			map.put("mobil", user.getMobile());
			map.put("aWardYesterday", aWardYesterday);
			map.put("aWardSum", aWardSum);
			map.put("loginUrl", loginurl);
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}
	
	/**
	 * 查询用户是否有未审批完成的港澳台开户记录
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("getCountGatApprove")
	@ResponseBody
	public Object getCountGatApprove(HttpServletRequest request) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		Map<String, Object> map = new HashMap<String, Object>();
		if (user_inf != null) {
			GatApproveVO gatApprove = new GatApproveVO();
			gatApprove.setUserId(user_inf.getUserId());
			int count =gatApproveSer.countGatApproveByStatus(gatApprove);
			if(count>0){
				map.put("flag", "1");
				map.put("countFlag", "1");
			}else{
				map.put("flag", "1");
				map.put("countFlag", "0");
			}			
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}
	
	/**
	 * 查询用户证件号是否已注册
	 * 
	 * @param model
	 * @param mobile
	 * @return结果1：证件号已存在；2：存在审批中的记录 0 通过
	 */
	@RequestMapping("checkCardIdExist")
	@ResponseBody
	public Object checkCardIdExist(HttpServletRequest request,String cardid,String cardType) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
			
			int count =userServ.checkCardIdExist(cardType, cardid);
			if(count>0){
				map.put("flag", "1");
				map.put("countFlag", "1");
			}else{
				//校验是否有审批中的开户申请记录
				GatApproveVO gatApprove = new GatApproveVO();
				gatApprove.setCardId(cardid);
				count=gatApproveSer.countGatApproveByStatus(gatApprove);
				if(count>0){
					map.put("flag", "1");
					map.put("countFlag", "2");//存在审批中的记录
				}else{
				map.put("flag", "1");
				map.put("countFlag", "0");
				}
			}			
			return map;
		
	}
	/**
	 * 港澳台查询用户银行卡是否已注册
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("checkAcctNoExist")
	@ResponseBody
	public Object checkAcctNoExist(HttpServletRequest request,String acctNo) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
			
			int count =userServ.checkUserActnoExist(acctNo);
			if(count>0){
				map.put("flag", "0");
				return map;
			}else{
				//校验是否有审批中的开户申请记录
				GatApproveVO gatApprove = new GatApproveVO();
				gatApprove.setCardNumber(acctNo);
				int count1 =gatApproveSer.countGatApproveByStatus(gatApprove);
				if(count1>0){
					map.put("flag", "0");
					return map;
				}
				map.put("flag", "1");
			}			
			return map;
		
	}
	
	
	/**
	 * 查询风险测评结果
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("updateUserSession")
	@ResponseBody
	public Object updateUserSession(HttpServletRequest request) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		Map<String, Object> map = new HashMap<String, Object>();
		if (user_inf != null) {
			UserVO user =userServ.getUserByUserId(user_inf.getUserId());
			if(user.getUsername().equals(user.getMobile())){//用户名
				user_inf.setUsername(StringUtil.handlePhone(user.getMobile()));
				}else{
					user_inf.setUsername(StringUtil.getHandleUserName(user.getUsername()));
				}
			if(!StringUtil.isEmpty(user.getCardId())){//证件号
				user_inf.setCardId(StringUtil.handleCardId(user.getCardId()));
			}
			user_inf.setMobile(StringUtil.handlePhone(user.getMobile()));//手机号
			if(!StringUtil.isEmpty(user.getCapAcntNo())){//银行卡号
				user_inf.setCapAcntNo(StringUtil.handleBankNo1(user.getCapAcntNo()));
			}
			if(!StringUtil.isEmpty(user.getRealname())){//真实姓名
				user_inf.setRealname(StringUtil.handleName(user.getRealname()));
				}
			map.put("flag", "1");
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "请先登录");
			return map;
		}
	}
}
