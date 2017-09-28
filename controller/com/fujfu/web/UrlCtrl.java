package com.fujfu.web;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fujfu.common.payment.fuyou.pojo.UserRechargeBean;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.apply.UserRecoverSumPOJO;
import com.fujfu.pojo.common.SelCodeVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.UserAccountLogServ;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.common.SelCodeServ;
import com.fujfu.service.recover.RecoverServ;
import com.fujfu.web.account.CapitalMgtCtrl;
/**
 * Url跳转控制器
 * 
 * @author admin
 *
 */
@Controller
public class UrlCtrl extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(CapitalMgtCtrl.class);

	@Resource
	private SelCodeServ selCodeServ;
	@Resource
	private UserAccountServ userAccountServ;
	@Resource
	private RecoverServ recoverServ;
	@Resource
	private UserAccountLogServ userAccountLogServ;

	/**
	 * 跳转到首页
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView goIndex(HttpServletRequest request, Model model) {
		return new ModelAndView("/views/index.jsp");
	}

	@RequestMapping("/")
	public ModelAndView goIndex2(HttpServletRequest request, Model model) {
		return new ModelAndView("/views/index.jsp");
	}

	@RequestMapping("/fy/r")
	public ModelAndView r(HttpServletRequest request, Model model) {
		return new ModelAndView("/forwardForm.jsp");
	}

	@ResponseBody
	@RequestMapping("/new")
	public Object er(Model model, String username, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		if ("aa".equals(username) && "aa".equals(password)) {
			map.put("msg", "success.");
		} else {
			map.put("msg", "用户名或密码错误.");
		}
		return map;
	}

	/**
	 * 跳转到404页面
	 * 
	 * @return
	 */
	@RequestMapping("/error/404")
	public ModelAndView go404(HttpServletRequest request, Model model) {
		return new ModelAndView("/views/error/404.html");
	}

	/**
	 * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	 * >>>>
	 */
	/**
	 * 跳转到注册页面
	 * 
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView goRegister(HttpServletRequest request, Model model) {
		return new ModelAndView("/views/user/register.jsp");
	}

	/**
	 * 跳转到投资页面
	 * 
	 * @return
	 */
	@RequestMapping("/enterInvest")
	public String enterInvest() {
		return "views/invest/investList.jsp";
	}

	/**
	 * 跳转到登陆页面
	 * 
	 * @return
	 */
	@RequestMapping("/enterLogin")
	public String enterLogin() {
		return "views/login.html";
	}

	/**>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>我的账户>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>**/
	/**
	 * 跳转到投资人我的账户页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/myAccount/enterUserAccount")
	public String enterUserAccount(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
			// 更新用户账户
		try{
//			updateUserAccount(user);
		}catch(Exception e){
			log.info(e.getMessage());
		}
			// 跳转
			String returnUrl = "";
			String userType = user.getUserType();
			if (userType.equals("1")) {
				returnUrl = "redirect:/myAccount/enterBUserAccount";
			}
			if (userType.equals("2")) {
				returnUrl = "redirect:/myAccount/enterBorrowTraderecord";
			}
			if (userType.equals("3")) {
				returnUrl = "redirect:/myAccount/enterGuaranteeProject";
			}
			return returnUrl;
	}
	/**
	 * 跳转到借款人我的账户页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/myAccount/enterBUserAccount")
	public String enterBUserAccount(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
			UserAccountVO userAccount = userAccountServ.selectByUserId(user.getUserId());
			UserRecoverSumPOJO userRecoverSum = new UserRecoverSumPOJO();
			//获取代收金额
			userRecoverSum =recoverServ.findUserRecoverSumMap("0", user.getUserId());//0指未还
			BigDecimal sumReceipts= userRecoverSum.getSumReceipts();//代收金额
			userAccount.setAwaitIncome(sumReceipts);
			//获取累计收益
			userRecoverSum =recoverServ.findUserRecoverSumMap("1", user.getUserId());//1指已还
			BigDecimal sumInterest =userRecoverSum.getSumInterest();//获取累计利息
			log.info("SumInterest==="+sumInterest);

			//UserAccountLogQuery userAccountLogQuery = new UserAccountLogQuery();
			//userAccountLogQuery.setUserId(user.getUserId());
			//userAccountLogQuery.setType("A");//A代表收取手续费，目前'4204'投资服务费
			//BigDecimal  shouqfee = new BigDecimal(userAccountLogServ.findSumMoneyBy(userAccountLogQuery));
			//log.info("投资服务费="+shouqfee);

			//userAccountLogQuery.setType("A1");//A1代表返回手续费 3002一种
			//BigDecimal  tuiqfee = new BigDecimal(userAccountLogServ.findSumMoneyBy(userAccountLogQuery));
			BigDecimal sumIncome = sumInterest;//累计收益=累计利息		
			userAccount.setSumIncome(sumIncome);
			userAccount.setTotal(userAccount.getTotal().add(sumReceipts));//账户中心资产总额要等于 可用余额+冻结金额+代收金额
			model.addAttribute("userAccount", userAccount);
			return "views/userAccount/index.jsp";
	}
	/**
	 * 跳转到担保机构我的账户页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/myAccount/enterGuaranteeProject")
	public String enterGuaranteeProject(HttpSession session, Model model) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
			UserAccountVO userAccount = userAccountServ.selectByUserId(user.getUserId());
			model.addAttribute("userAccount", userAccount);
			return "views/institutionsCenter/guaranteeProject.jsp";
	}
	/**>>>>>>>>>>>>>>>>>>>>>>>>投资人个人中心>>>>>>>>>>>>>>>>>>>>>>>>>>>>**/
	/**
	 * 跳转到理财中心我的债券
	 * @return
	 */
	@RequestMapping("/myAccount/enterMycreditor")
	public String enterMycreditor() {
		return "views/userAccount/mycreditor.jsp";
	}
	/**
	 * 跳转到理财中心申请中页面
	 * @return
	 */
	@RequestMapping("/myAccount/enterApplyDuring")
	public String enterApplyDuring() {
		return "views/userAccount/applyDuring.jsp";
	}
	/**
	 * 跳转到借款中心申请中页面
	 * @return
	 */
	@RequestMapping("/myAccount/enterBorrowDuring")
	public String enterBorrowDuring() {
		return "views/userAccount/borrowDuring.jsp";
	}

	/**
	 * 跳转到我的奖励邀请好友页面
	 * @return
	 */
	@RequestMapping("/myAccount/enterInvitefriend")
	public String enterInvitefriend() {
		return "views/userAccount/invitefriend.jsp";
	}

	/**
	 * 跳转到我的奖励优惠券页面
	 * @return
	 */
	@RequestMapping("/myAccount/enterCoupons")
	public String enterCoupons() {
		return "views/userAccount/coupons.jsp";
	}

	/**
	 * 跳转到交易中心-交易明细
	 * @return
	 */
	@RequestMapping("/myAccount/enterTraderecord")
	public String enterTraderecord() {
		return "views/userAccount/traderecord.jsp";
	}

	/**
	 * 跳转到消息中心-站内信息
	 * @return
	 */
	@RequestMapping("/myAccount/enterSiteinfo")
	public String enterSiteinfo() {
		return "views/userAccount/siteinfo.jsp";
	}

	/**
	 * 跳转到安全信息-个人基本信息
	 * @return
	 */
	@RequestMapping("/myAccount/enterPersonalinfos")
	public String enterPersonalinfos() {
		return "views/userAccount/personalinfos.jsp";
	}

	/**
	 * 跳转到安全信息-个人基本信息-手机修改成功
	 * @return
	 */
	@RequestMapping("/myAccount/personalErrors")
	public String personalErrors() {
		return "views/userAccount/personalError.jsp";
	}

	/**
	 * 跳转到项目追踪
	 * @return
	 */
	@RequestMapping("/myAccount/enterProduct")
	public String enterProduct() {
		return "views/product/projecttrack.jsp";
	}
	
	/**
	 * 跳转到富友开通托管账户
	 * @return
	 */
	@RequestMapping("/myAccount/enterEscrowAccount")
	public ModelAndView enterEscrowAccount(HttpServletRequest request, HttpServletResponse response,
			UserRechargeBean reqData, Model model) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		// 把城市选择框代码和银行代码加载到页面中
		List<SelCodeVO> citycodelist1 = selCodeServ.findSelCodeByStyle("city", "1");
		List<SelCodeVO> bankcodelist = selCodeServ.findSelCodeByStyle("bank", "1");
		model.addAttribute("citycodelist1", citycodelist1);
		model.addAttribute("bankcodelist", bankcodelist);
		model.addAttribute("user", user_inf);
		return new ModelAndView("views/userAccount/escrowAccount.jsp");

	}
	
	/**>>>>>>>>>>>>>>>>>>>>>>>>借款人个人中心>>>>>>>>>>>>>>>>>>>>>>>>>>>>**/
	/**
	 * 跳转到借款人账户中心_借款项目
	 * @return
	 */
	@RequestMapping("/myAccount/enterBorrowerProject")
	public String enterBorrowerProject() {
		return "views/borrowerCenter/borrowerProject.jsp";
	}

	/**
	 * 跳转到借款人账户中心_逾期项目
	 * @return
	 */
	@RequestMapping("/myAccount/enterDelayProject")
	public String enterDelayProject() {
		return "views/borrowerCenter/delayProject.jsp";
	}

	/**
	 * 跳转到借款人账户中心_借款项目详情
	 * @return
	 */
	@RequestMapping("/myAccount/enterBorrowerDetail")
	public String enterBorrowerDetail() {
		return "views/borrowerCenter/borrowerDetail.jsp";
	}

	/**
	 * 跳转到借款人账户中心_借款人交易明细
	 * @return
	 */
	@RequestMapping("/myAccount/enterBorrowTraderecord")
	public String enterBorrowTraderecord() {
		return "views/borrowerCenter/borrowTraderecord.jsp";
	}

	/**
	 * 跳转到借款人账户中心_借款人提现
	 * @return
	 */
	@RequestMapping("/myAccount/enterBorrowWithdrawal")
	public String enterBorrowWithdrawal() {
		return "views/borrowerCenter/borrowWithdrawal.jsp";
	}

	/**
	 * 跳转到借款人账户中心_借款人充值
	 * @return
	 */
	@RequestMapping("/myAccount/enterBorrowRecharge")
	public String enterBorrowRecharge() {
		return "views/borrowerCenter/borrowRecharge.jsp";
	}

	/**
	 * 跳转到借款人账户中心_安全信息
	 * @return
	 */
	@RequestMapping("/myAccount/enterBorrowPersonalinfos")
	public String enterBorrowPersonalinfos() {
		return "views/borrowerCenter/borrowPersonalinfos.jsp";
	}

	/**
	 * 跳转到借款人账户中心_站内信
	 * @return
	 */
	@RequestMapping("/myAccount/enterBorrowSiteinfo")
	public String enterBorrowSiteinfo() {
		return "views/borrowerCenter/borrowSiteinfo.jsp";
	}

	/**>>>>>>>>>>>>>>>>>>>>>>>>机构个人中心>>>>>>>>>>>>>>>>>>>>>>>>>>>>**/
	/**
	 * 跳转到机构中心账户中心_担保项目详情
	 * @return
	 */
	@RequestMapping("/myAccount/enterGuaranteeDetail")
	public String enterGuaranteeDetail() {
		return "views/institutionsCenter/guaranteeDetail.jsp";
	}

	/**
	 * 跳转到机构中心账户中心_待垫付
	 * 
	 * @return
	 */
	@RequestMapping("/myAccount/enterDaiAdvances")
	public String enterDaiAdvances() {
		return "views/institutionsCenter/daiAdvances.jsp";
	}

	/**
	 * 跳转到机构中心账户中心_交易明细
	 * 
	 * @return
	 */
	@RequestMapping("/myAccount/enterInsTraderecord")
	public String enterInsTraderecord() {
		return "views/institutionsCenter/insTraderecord.jsp";
	}

//	/**
//	 * 跳转到机构中心账户中心_提现
//	 * 
//	 * @return
//	 */
//	@RequestMapping("/myAccount/enterInsWithdrawal")
//	public String enterInsWithdrawal() {
//		return "views/institutionsCenter/insWithdrawal.jsp";
//	}

//	/**
//	 * 跳转到机构中心账户中心_充值
//	 * 
//	 * @return
//	 */
//	@RequestMapping("/myAccount/enterInsRecharge")
//	public String enterInsRecharge() {
//		return "views/institutionsCenter/insRecharge.jsp";
//	}

	/**
	 * 跳转到机构中心账户中心_安全信息
	 * 
	 * @return
	 */
	@RequestMapping("/myAccount/enterInsPersonalinfos")
	public String enterInsPersonalinfos() {
		return "views/institutionsCenter/insPersonalinfos.jsp";
	}

	/**
	 * 跳转到机构中心账户中心_站内信息
	 * 
	 * @return
	 */
	@RequestMapping("/myAccount/enterInsSiteinfo")
	public String enterInsSiteinfo() {
		return "views/institutionsCenter/insSiteinfo.jsp";
	}
/**>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>**/	
	
	
	
	
	/**
	 * 跳转到关于我们
	 * 
	 * @return
	 */
	@RequestMapping("/enterCompanyIntroduction")
	public String enterCompanyIntroduction() {
		return "views/about/CompanyIntroduction.jsp";
	}

	@RequestMapping("/enterContactUs")
	public String enterContactUs() {
		return "views/about/contactUs.jsp";
	}

	@RequestMapping("/enterMediaCoverage")
	public String enterMediaCoverage() {
		return "views/about/mediaCoverage.jsp";
	}

	@RequestMapping("/enterPerformanceReport")
	public String enterPerformanceReport() {
		return "views/about/performanceReport.jsp";
	}

	@RequestMapping("/enterTeamIntroduction")
	public String enterTeamIntroduction() {
		return "views/about/teamIntroduction.jsp";
	}

	@RequestMapping("/enterWebsiteAnnouncement")
	public String enterWebsiteAnnouncement() {
		return "views/about/websiteAnnouncement.jsp";
	}

	/**
	 * 跳转到帮助中心
	 * 
	 * @return
	 */
	@RequestMapping("/enterHelpCenter")
	public String enterHelpCenter() {
		return "views/helpCenter/helpCenter.jsp";
	}
	/**
	 * 跳转到帮助中心
	 * 
	 * @return
	 */
	@RequestMapping("/enterNewGuideline")
	public String enterNewGuideline() {
		return "views/guideline/newGuideline.jsp";
	}
	

	
	/**
	 * 跳转到投资人债券详情
	 * @return
	 */
	@RequestMapping("/enterCreditorDetail")
	public String enterCreditorDetail() {
		return "views/userAccount/creditorDetail.jsp";
	}
	
	/**
	 * 跳转到投资人协议详情
	 * @return
	 */
	@RequestMapping("/enterInvestAgreement")
	public String enterInvestAgreement() {
		return "views/agreement/invest_agreement.jsp";
	}
	/**
	 * 跳转到注册协议详情
	 * @return
	 */
	@RequestMapping("/enterregisteragreement")
	public String enterregisteragreement() {
		return "views/agreement/register_agreement.jsp";
	}
	/**
	 * 网站公告详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/enterWebsiteAnnoundetails")
	public String enterWebsiteAnnoundetails(String id) {
		return "views/about/websiteAnnoundetails"+id+".jsp";
	}
	/**
	 * 媒体报道详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/enterMediaCovedetail")
	public String enterMediaCovedetail(String id) {
		return "views/about/mediaCovedetail"+id+".jsp";
	}
	
	@RequestMapping("/enterRiskEvaluation")
	public String enterRiskEvaluation() {
		return "views/userAccount/riskEvaluation.jsp";
	}
	@RequestMapping("/enterInvestWindow")
	public String enterInvestWindow() {
		return "views/invest/investWindow.jsp";
	}
	
	
	@RequestMapping("/enterKumquatList")
	public String enterKumquatList() {
		return "views/kumquat/kumquatList.jsp";
	}
	@RequestMapping("/enterKumquatWindow")
	public String enterKumquatWindow() {
		return "views/kumquat/kumquatWindow.jsp";
	}
	@RequestMapping("/enterRegisterRedPacket")
	public String enterRegisterRedPacket() {
		return "views/activities/registerRedPacket.jsp";
	}
	@RequestMapping("/enterCelebrate")
	public String enterCelebrate() {
		return "views/activities/celebrate.jsp";
	}
	@RequestMapping("/enterIntFriend")
	public String enterIntFriend() {
		return "views/activities/intFriend.jsp";
	}
	@RequestMapping("/enterSecurityPage")
	public String enterSecurityPage() {
		return "views/security/securityPage.jsp";
	}
	
	@RequestMapping("/enterContacts")
	public String enterContacts() {
		return "views/activities/contacts.jsp";
	}
	@RequestMapping("/enterNewWelfare")
	public String enterNewWelfare() {
		return "views/activities/newWelfare.jsp";
	}
	@RequestMapping("/enterRaiseInterest")
	public String enterRaiseInterest() {
		return "views/activities/raiseInterest.jsp";
	}
}
