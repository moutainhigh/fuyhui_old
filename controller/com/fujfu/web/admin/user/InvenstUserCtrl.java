package com.fujfu.web.admin.user;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.pojo.common.SelCodeVO;
import com.fujfu.pojo.user.UserVO;
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
public class InvenstUserCtrl extends BaseController{
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
	 * 进入详情界面
	 * @return
	 */
	@RequestMapping("user/InvenstUserInfo")
	public String enterUserInfo(Model model, HttpServletRequest request) {
		//boolean b = isPermissions.isPermissions(request);
		boolean b=true;
		if (b) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			UserVO user = userServ.getUserByUserId(userId);
			SelCodeVO  cityNameCode=selCodeServ.selectByitemno("city", user.getCity_id());
			if(cityNameCode!=null){
				user.setCity_name(cityNameCode.getItemname());
			}else{
				user.setCity_name("");
			}
			SelCodeVO countryNameCode=selCodeServ.selectByitemno("city", user.getCountry_id());
			if(countryNameCode!=null){
				user.setCountry_name(countryNameCode.getItemname());
			}else{
				user.setCountry_name("");
			}
			SelCodeVO parentBankCode=selCodeServ.selectByitemno("bank", user.getParent_bank_id());
			if(parentBankCode!=null){
				user.setParent_bank_name(parentBankCode.getItemname());
			}else{
				user.setParent_bank_name("");
			}
			model.addAttribute("user", user);
			return "views/admin/user/invenstUserInfo.jsp";
		} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}
	}
	

}
