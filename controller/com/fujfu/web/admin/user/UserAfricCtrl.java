package com.fujfu.web.admin.user;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.UserRechargeDTO;
import com.fujfu.pojo.account.UserWithdrawalDTO;
import com.fujfu.pojo.admin.AdminVO;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.common.SelCodeVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.pojo.user.UserPOJO;
import com.fujfu.service.account.RechargeServ;
import com.fujfu.service.account.WithdrawalServ;
import com.fujfu.service.admin.AdminServ;
import com.fujfu.service.common.SelCodeServ;
import com.fujfu.service.comuanda.AadminServ;
import com.fujfu.service.invest.LoanInvestmentServ;
import com.fujfu.service.loan.LoanApplyServ;
import com.fujfu.service.repay.RepayServ;
import com.fujfu.service.user.GuaranteeInfoServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.web.BaseController;
import com.fujfu.web.util.PropertiesUtil;

@Controller
@RequestMapping("/admin/")
public class UserAfricCtrl extends BaseController {
	private static final long serialVersionUID = 1L;
	@Resource
	private UserServ userServ;
	@Resource
	private AdminServ adminServ;
	@Resource
	private AadminServ aadminServ;
	@Resource
	private SelCodeServ selCodeServ;
	@Resource
	private LoanInvestmentServ loanInvestmentServ;
	@Resource
	private LoanApplyServ loanApplyServ;
	@Resource
	private RepayServ repayServ;
	@Resource
	private GuaranteeInfoServ guaranteeInfoServ;
	@Autowired
	private WithdrawalServ withdrawalServ;
	@Autowired
	private RechargeServ rechargeServ;

	/**
	 * 后台管理担保记录入口
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("user/loanDoGuarantee")
	public String loanDoGuarantee(HttpServletRequest request, Model model, Page page, String username, String id,
			String apply_id) {
		// boolean b = isPermissions.isPermissions(request);
		boolean b = true;
		if (b) {
			LoanInvestPOJO loanInvestQueryVo = new LoanInvestPOJO();
			if (StringUtils.isNotEmpty(username)) {
				loanInvestQueryVo.setUsername(username);
			}
			// if (StringUtils.isNotEmpty(id)) {
			// loanInvestQueryVo.setId(Integer.parseInt(id));
			// }
			if (StringUtils.isNotEmpty(apply_id)) {
				loanInvestQueryVo.setApply_id(Integer.parseInt(apply_id));
			}
			Page guaranteeList = guaranteeInfoServ.findGuaranteeByVo(loanInvestQueryVo, page);
			model.addAttribute("guaranteeList", guaranteeList);
			return "views/admin/user/guaranteeList.jsp";
		} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}
	}

	/**
	 * 后台管理投资记录入口
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("user/loanInvestList")
	public String loanInvestList(HttpServletRequest request, Model model, Page page, String username, String id,
			String apply_id) {
		// boolean b = isPermissions.isPermissions(request);
		boolean b = true;
		if (b) {
			LoanInvestPOJO loanInvestQueryVo = new LoanInvestPOJO();
			if (StringUtils.isNotEmpty(username)) {
				loanInvestQueryVo.setUsername(username);
			}
			if (StringUtils.isNotEmpty(id)) {
				loanInvestQueryVo.setId(id);
			}
			if (StringUtils.isNotEmpty(apply_id)) {
				loanInvestQueryVo.setApply_id(Integer.parseInt(apply_id));
			}
			Page InvestList = loanInvestmentServ.findloanInvestListByCondition(loanInvestQueryVo, page);
			model.addAttribute("InvestList", InvestList);
			return "views/admin/user/loanInvestList.jsp";
		} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}
	}

	/**
	 * 后台管理借款记录入口
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("user/loanDoApplyList")
	public String loanDoApplyList(HttpServletRequest request, Model model, Page page, String userName, String id,
			String applyid) {
		// boolean b = isPermissions.isPermissions(request);
		boolean b = true;
		if (b) {
			LoanInvestPOJO loanInvestQueryVo = new LoanInvestPOJO();
			if (StringUtils.isNotEmpty(userName)) {
				loanInvestQueryVo.setUsername(userName);
			}
			if (StringUtils.isNotEmpty(id)) {
				loanInvestQueryVo.setId(id);
			}
			if (StringUtils.isNotEmpty(applyid)) {
				loanInvestQueryVo.setApply_id(Integer.parseInt(applyid));
			}

			Page applyList = loanApplyServ.findloanApplyListByCondition(loanInvestQueryVo, page);
			model.addAttribute("applyList", applyList);
			return "views/admin/user/loanApplyList.jsp";
		} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}
	}

	/**
	 * 后台管理还款记录入口
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("user/allApplyRepayList")
	public String AllApplyRepayListPOJO(HttpServletRequest request, Model model, Page page, String username, String id,
			String apply_id) {
		// boolean b = isPermissions.isPermissions(request);
		boolean b = true;
		if (b) {
			LoanInvestPOJO loanInvestQueryVo = new LoanInvestPOJO();
			if (StringUtils.isNotEmpty(username)) {
				loanInvestQueryVo.setUsername(username);
			}
			// if (StringUtils.isNotEmpty(id)) {
			// loanInvestQueryVo.setId(Integer.parseInt(id));
			// }
			if (StringUtils.isNotEmpty(apply_id)) {
				loanInvestQueryVo.setApply_id(Integer.parseInt(apply_id));
			}

			Page applyRepayList = repayServ.findAllApplyRepayListByCondition(loanInvestQueryVo, page);
			model.addAttribute("applyRepayList", applyRepayList);
			return "views/admin/user/allApplyRepayList.jsp";
		} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}
	}

	/**
	 * 后台管理收款记录入口
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("user/allApplyRecoverList")
	public String allApplyRecoverList(HttpServletRequest request, Model model, Page page, String username,
			String applyid, String userid) {
		// boolean b = isPermissions.isPermissions(request);
		boolean b = true;
		if (b) {
			LoanInvestPOJO loanInvestQueryVo = new LoanInvestPOJO();
			if (StringUtils.isNotEmpty(username)) {
				loanInvestQueryVo.setUsername(username);
			}
			// if (StringUtils.isNotEmpty(id)) {
			// loanInvestQueryVo.setId(Integer.parseInt(id));
			// }
			if (StringUtils.isNotEmpty(applyid)) {
				loanInvestQueryVo.setApply_id(Integer.parseInt(applyid));
			}
			if (StringUtils.isNotEmpty(userid)) {
				loanInvestQueryVo.setUser_id(Integer.parseInt(userid));
			}

			Page applyRecoverList = repayServ.findAllApplyRecoverListByCondition(loanInvestQueryVo, page);
			model.addAttribute("applyRecoverList", applyRecoverList);
			return "views/admin/user/allApplyRecoverList.jsp";
		} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}
	}

	/**
	 * 后台企业用户管理入口
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("user/index")
	public String index(HttpServletRequest request, Page page, AdminVO admin, Model model, String userType, String mobile,
			String corpName, String userName) {
		// boolean b = isPermissions.isPermissions(request);
		boolean b = true;
		if (b) {
			UserPOJO userQueryVo = new UserPOJO();
			userQueryVo.setUserType(userType);

			if (StringUtils.isNotEmpty(mobile)) {
				userQueryVo.setMobile(mobile);
			}
			if (StringUtils.isNotEmpty(corpName)) {
				userQueryVo.setCorpName(corpName);
			}
			if (StringUtils.isNotEmpty(userName)) {
				userQueryVo.setUserName(userName);
			}
			Page userList = userServ.findUserByCondition(userQueryVo, page);
			model.addAttribute("userList", userList);
			model.addAttribute("userType", userType);
			return "views/admin/user/africuserList.jsp";
		} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}
	}

	/**
	 * 进入添加界面
	 * 
	 * @return
	 */
	@RequestMapping("user/enterAdd")
	public String enterAdd(HttpServletRequest request, Model model, String userType) {
		// boolean b = isPermissions.isPermissions(request);
		boolean b = true;
		if (b) {
			// 把城市选择框代码和银行代码加载到页面中
			List<SelCodeVO> citycodelist1 = selCodeServ.findSelCodeByStyle("city", "1");
			List<SelCodeVO> bankcodelist = selCodeServ.findSelCodeByStyle("bank", "1");
			model.addAttribute("citycodelist1", citycodelist1);
			model.addAttribute("bankcodelist", bankcodelist);
			model.addAttribute("userType", userType);
			return "views/admin/user/addAfricuser.jsp";
		} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}

	}

	/**
	 * 选择省份后根据省份信息获取下级市县信息
	 * 
	 * @return
	 */
	@RequestMapping("user/getcityidList")
	@ResponseBody
	public Object getcityidList(HttpServletRequest request, String itemno, String itemno1, HttpSession session,
			Model model) {

		List<SelCodeVO> citycodelist2 = selCodeServ.findSelCodeByBelongItemno("city", itemno);
		String optionHTML = "";
		SelCodeVO selcode = new SelCodeVO();
		for (Iterator<SelCodeVO> it = citycodelist2.iterator(); it.hasNext();) {
			selcode = it.next();
			if (selcode.getItemno().equals(itemno1)) {
				optionHTML = optionHTML + "<option value=\"" + selcode.getItemno() + "\"" + " selected>"
						+ selcode.getItemname() + "</option>\n\t\t";
			} else {
				optionHTML = optionHTML + "<option value=\"" + selcode.getItemno() + "\">" + selcode.getItemname()
						+ "</option>\n\t\t";
			}
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("citycodelist2", optionHTML);
		return map;

	}

	/**
	 * 进入修改界面
	 * 
	 * @return
	 */
	@RequestMapping("user/enterUpdate")
	public String enterUpdate(Model model, HttpServletRequest request) {
		// boolean b = isPermissions.isPermissions(request);
		boolean b = true;
		if (b) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			UserVO user = userServ.getUserByUserId(userId);
			user.setCity_name(selCodeServ.selectByitemno("city", user.getCity_id()).getItemname());
			user.setCountry_name(selCodeServ.selectByitemno("city", user.getCountry_id()).getItemname());
			user.setParent_bank_name(selCodeServ.selectByitemno("bank", user.getParent_bank_id()).getItemname());

			// 把城市选择框代码和银行代码加载到页面中
			List<SelCodeVO> citycodelist1 = selCodeServ.findSelCodeByStyle("city", "1");
			List<SelCodeVO> bankcodelist = selCodeServ.findSelCodeByStyle("bank", "1");
			model.addAttribute("citycodelist1", citycodelist1);
			model.addAttribute("bankcodelist", bankcodelist);

			model.addAttribute("user", user);
			return "views/admin/user/updateAfricuser.jsp";
		} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}
	}

	/**
	 * 进入企业详情界面
	 * 
	 * @return
	 */
	@RequestMapping("user/enterUserInfo")
	public String enterUserInfo(Model model, HttpServletRequest request) {
		// boolean b = isPermissions.isPermissions(request);
		boolean b = true;
		if (b) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			UserVO user = userServ.getUserByUserId(userId);

			user.setCity_name(selCodeServ.selectByitemno("city", user.getCity_id()).getItemname());
			user.setCountry_name(selCodeServ.selectByitemno("city", user.getCountry_id()).getItemname());
			user.setParent_bank_name(selCodeServ.selectByitemno("bank", user.getParent_bank_id()).getItemname());

			model.addAttribute("user", user);
			return "views/admin/user/africUserInfo.jsp";
		} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}
	}

	/**
	 * 后台用户管理-修改
	 * 
	 * @param model
	 * @param username
	 * @param realname
	 * @param password
	 * @return
	 */
	@RequestMapping("user/update")
	public String update(HttpServletRequest request, Model model, UserVO user) {
		// boolean b = isPermissions.isPermissions(request);
		boolean b = true;
		if (b) {
			int result = userServ.updateUser(user);
			if (result > 0) {

				model.addAttribute("msg", "修改用户信息成功");
			} else {
				model.addAttribute("msg", "修改用户信息失败");
			}
			return "redirect:/admin/user/index?userType=2";
		} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}
	}

	/**
	 * 后台用户管理-删除
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("user/delete")
	public String delete(Model model, HttpServletRequest request) {
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		int result = adminServ.delAdmin(adminId);
		if (result > 0) {
			aadminServ.delAadmin(adminId);
			model.addAttribute("msg", "删除管理员成功");
		} else {
			model.addAttribute("msg", "删除管理员失败");
		}
		return "redirect:/admin/member/index";
	}

	// 后台提现记录查询
	@RequestMapping("withdrawal/index")
	public String withdrawalindex(HttpServletRequest request, Page page, String username, String billno, String status,
			String startTime, String endTime, Model model) {
		UserWithdrawalDTO userWithdrawalQuery = new UserWithdrawalDTO();
		if (StringUtils.isNotEmpty(startTime)) {
			try {
				userWithdrawalQuery.setStartTime(DateUtil.dateTimeStamp(startTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(endTime)) {
			try {
				userWithdrawalQuery.setEndTime(DateUtil.dateTimeStamp(endTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(username)) {
			userWithdrawalQuery.setUsername(username);
		}
		if (StringUtils.isNotEmpty(billno)) {
			userWithdrawalQuery.setBillno(billno);
		}
		if (StringUtils.isNotEmpty(status)) {
			userWithdrawalQuery.setStatus(status);
		}
		Page userWithdrawalList = withdrawalServ.findUserWithdrawal(userWithdrawalQuery, page);
		model.addAttribute("userWithdrawalList", userWithdrawalList);
		return "views/admin/account/userWithdrawalList.jsp";

	}

	// 后台充值记录查询
	@RequestMapping("recharge/index")
	public String rechargeindex(HttpServletRequest request, Page page, String username, String billno, String status,
			String startTime, String endTime, Model model) {
		UserRechargeDTO userRechargeQuery = new UserRechargeDTO();
		if (StringUtils.isNotEmpty(startTime)) {
			try {
				userRechargeQuery.setStartTime(DateUtil.dateTimeStamp(startTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(endTime)) {
			try {
				userRechargeQuery.setEndTime(DateUtil.dateTimeStamp(endTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(username)) {
			userRechargeQuery.setUsername(username);
		}
		if (StringUtils.isNotEmpty(billno)) {
			userRechargeQuery.setBillno(billno);
		}
		if (StringUtils.isNotEmpty(status)) {
			userRechargeQuery.setStatus(status);
		}
		Page userRechargeList = rechargeServ.findUserRechargeByCondition(userRechargeQuery, page);
		model.addAttribute("userRechargeList", userRechargeList);
		return "views/admin/account/userRechargeList.jsp";

	}

	/**
	 * 查询用户企业名称是否已注册
	 * 
	 * @param model
	 * @param mobile
	 * @return
	 */
	@RequestMapping("user/checkUserCorpNameExist")
	@ResponseBody
	public Object checkCardIdExist(HttpServletRequest request, String corpName) {

		Map<String, Object> map = new HashMap<String, Object>();

		int count = userServ.checkUserCorpNameExist(corpName);
		if (count > 0) {
			map.put("flag", "1");
			map.put("countFlag", "1");
		} else {

			map.put("flag", "1");
			map.put("countFlag", "0");

		}
		return map;

	}
}
