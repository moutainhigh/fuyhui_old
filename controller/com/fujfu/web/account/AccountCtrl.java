package com.fujfu.web.account;



import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.SiteBillingDTO;
import com.fujfu.pojo.account.UserAccountPOJO;
import com.fujfu.service.account.SiteBillingServ;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.web.BaseController;

/**
 * 用户账户中心控制器
 */
@Controller
@RequestMapping("/backAccount/")
public class AccountCtrl extends BaseController{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private UserAccountServ userAccountServ;
	@Resource
	private SiteBillingServ siteBillingServ;
	/**
	 * 个人用户账户情况
	 * @param request
	 * @param page
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping("personal/index")
	public String personalAccount(HttpServletRequest request,Page page,String userName,Model model){
		UserAccountPOJO userAccountVo = new UserAccountPOJO();
		userAccountVo.setUserType("1");
		userAccountVo.setUserName(userName);
		Page userAccountList = userAccountServ.findUserAccountByCondition(userAccountVo, page);
		model.addAttribute("userAccountList",userAccountList);
		return "/views/admin/account/accountList.jsp";
	}
	
	/**
	 * 企业用户账户情况
	 * @param request
	 * @param page
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping("corporate/index")
	public String corporateAccount(HttpServletRequest request,Page page,String userName,Model model){
		UserAccountPOJO userAccountVo = new UserAccountPOJO();
		userAccountVo.setUserType("2");
		userAccountVo.setUserName(userName);
		Page userAccountList = userAccountServ.findUserAccountByCondition(userAccountVo, page);
		model.addAttribute("userAccountList",userAccountList);
		return "/views/admin/account/corporateAccountList.jsp";
	}
	
	/**
	 * 担保机构账户情况
	 * @param request
	 * @param page
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping("institution/index")
	public String institutionAccount(HttpServletRequest request,Page page,String userName,Model model){
		UserAccountPOJO userAccountVo = new UserAccountPOJO();
		userAccountVo.setUserType("3");
		userAccountVo.setUserName(userName);
		Page userAccountList = userAccountServ.findUserAccountByCondition(userAccountVo, page);
		model.addAttribute("userAccountList",userAccountList);
		return "/views/admin/account/institutionAccountList.jsp";
	}
	
	/**
	 * 平台账账单情况
	 * @param request
	 * @param page
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping("siteBillingList/index")
	public String siteBillingList(HttpServletRequest request,Page page,String outUsername,String inUsername,String siteBusiType, String startTime, String endTime,Model model){
		SiteBillingDTO siteBillingQueryVo = new SiteBillingDTO();
		if (StringUtils.isNotEmpty(startTime)) {
			try {
				siteBillingQueryVo.setStartTime(DateUtil.dateTimeStampyyyyMMdd1(startTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(endTime)) {
			try {
				siteBillingQueryVo.setEndTime(DateUtil.dateTimeStampyyyyMMdd1(endTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(outUsername)) {
			siteBillingQueryVo.setOutUsername(outUsername);
		}
		if (StringUtils.isNotEmpty(inUsername)) {
			siteBillingQueryVo.setInUsername(inUsername);
		}
		if (StringUtils.isNotEmpty(siteBusiType)) {
			siteBillingQueryVo.setSiteBusiType(siteBusiType);
		}
		Page siteBillingList = siteBillingServ.findSiteBillingByCondition(siteBillingQueryVo, page);
		model.addAttribute("siteBillingList", siteBillingList);
		model.addAttribute("startTime", startTime);
		model.addAttribute("endTime", endTime);
		model.addAttribute("outUsername", outUsername);
		model.addAttribute("inUsername", inUsername);
		model.addAttribute("siteBusiType", siteBusiType);
		return "/views/admin/account/siteBillingList.jsp";
	}

}

