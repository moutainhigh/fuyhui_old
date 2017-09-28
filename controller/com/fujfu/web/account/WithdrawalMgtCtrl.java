package com.fujfu.web.account;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fujfu.common.payment.fuyou.pojo.UserRechargeBean;
import com.fujfu.common.payment.fuyou.pojo.UserWithdrawalBean;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.payment.fuyou.util.SecurityUtils;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.StringUtil;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.pojo.account.PoundageInfoVO;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.fee.SiteFeeTypePOJO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.CapitalMgtServ;
import com.fujfu.service.account.PoundageInfoServ;
import com.fujfu.service.account.SiteAccountLogServ;
import com.fujfu.service.account.SiteAccountServ;
import com.fujfu.service.account.SiteBillingServ;
import com.fujfu.service.account.UserAccountLogServ;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.account.WithdrawalServ;
import com.fujfu.service.common.CommonServ;
import com.fujfu.service.common.SelCodeServ;
import com.fujfu.service.fee.SiteFeeServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.web.BaseController;

/**
 * 提现控制器
 */
@Controller
@RequestMapping("/account/*")
public class WithdrawalMgtCtrl extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(WithdrawalMgtCtrl.class);
	@Autowired
	private WithdrawalServ service;

	@Autowired
	private UserServ userServ;

	@Autowired
	private SelCodeServ selCodeServ;
	@Autowired
	private WithdrawalServ withdrawalServ;
	@Autowired
	private SiteFeeServ siteFeeServ;
	@Autowired
	private UserAccountServ acctServ;
	@Resource
	private UserAccountLogServ userAccountLogServ;
	@Resource
	private CommonServ commonServ;
	@Autowired
	private PoundageInfoServ poundageInfoServ;
	@Autowired
	private CapitalMgtServ capitalMgtServ;
	@Resource
	private SiteAccountLogServ siteAccountLogServ;
	@Resource
	private SiteAccountServ siteAccountServ;
	@Resource
	private SiteBillingServ siteBillingServ;
	/**
	 * 资金提现
	 * 
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("withdrawal")
	public ModelAndView withdrawal(HttpServletRequest request, HttpServletResponse response, UserWithdrawalBean reqData,
			Model model) throws Exception {
		UserVO user_inf = (UserVO) getSession("user_inf");
		user_inf = userServ.getUserByUserId(user_inf.getUserId());
		if (user_inf == null) {
			model.addAttribute("msg", "请先登录");
			return new ModelAndView("msg.jsp");
		}
		// updateUserAccount(user_inf);

		
		SiteFeeTypePOJO siteFeeTypeVo = new SiteFeeTypePOJO();
		if ("1".endsWith(user_inf.getUserType())) {
			siteFeeTypeVo = siteFeeServ.queryChageMode(null, "投资人提现手续费", "1");// 获取手续费
		} else if ("2".endsWith(user_inf.getUserType())) {
			siteFeeTypeVo = siteFeeServ.queryChageMode(null, "借款人提现手续费", "2");// 获取手续费
		} else {
			siteFeeTypeVo = siteFeeServ.queryChageMode(null, "机构提现手续费", "3");// 获取手续费
		}
		BigDecimal fee = UserAccountUtil.getPoundageAmt(siteFeeTypeVo,
				new BigDecimal(reqData.getAmt()));
		BigDecimal amtB =new BigDecimal(reqData.getAmt());//提现金额
		BigDecimal  amt = (amtB.subtract(fee)).multiply(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP);//去掉小数位		
		reqData.setAmt(amt.toString());
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		reqData.setBack_notify_url(FyUtil.TX_BEHIND);
		reqData.setPage_notify_url(FyUtil.TX_INDEX);
		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss") + UserAccountUtil.getManyNumber(4));
		reqData.setLogin_id(user_inf.getJzhloginid());
		// reqData = service.withdrawal(reqData);
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		reqData.setAction(FyUtil.WITHDRAWAL);
		
		// 保存数据到中间表 主要是 提现内扣时手续费没法取到。所以保存到中间表
				PoundageInfoVO poundageInfo = new PoundageInfoVO();
				poundageInfo.setUserId(user_inf.getUserId());
				poundageInfo.setCreateTime(DateUtil.getUnixTime());
				poundageInfo.setPoundageatm(fee);
				// poundageInfo.setRelativeid("");
				poundageInfo.setRelativetype("withDrawal");
				poundageInfo.setStatus(1);
				poundageInfo.setTxn_ssn(reqData.getMchnt_txn_ssn());
				if (siteFeeTypeVo != null) {
					poundageInfo.setFeeid(siteFeeTypeVo.getChargeFeeId());
				} else {
					poundageInfo.setFeeid(0);

				}
				poundageInfoServ.addPoundageInfo(poundageInfo);	
		//保存数据到对账表fu_site_billing
		siteBillingServ.addSiteBilling(null, user_inf, reqData.getMchnt_txn_ssn(), amtB,"提现", "提现",reqData.regSignVal());
		
		System.out.println(signatureStr);
		model.addAttribute("data", reqData);
		return new ModelAndView("views/admin/account/withdrawal.jsp");
	}


	/**
	 * 异步回调地址
	 * 
	 */
	@RequestMapping("txBehind")
	public ModelAndView behind(HttpServletRequest request, HttpServletResponse response, UserRechargeBean reqData,
				Model model) {
	
			reqData.setAmt("1000");
			reqData.setMchnt_txn_ssn("201606280001");
	
			// 数据处理
			return new ModelAndView("");
		}

	/**
	 * 进入提现页面
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("enterWithdrawal")
	public String enterWithdrawal(Model model, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
		if (user == null) {
			model.addAttribute("msg", "请先登录");
			return "msg.jsp";
		}
		user = userServ.getUserByUserId(user.getUserId());
		UserAccountVO userAccountInfo = acctServ.selectByUserId(user.getUserId());
		if (user != null && StringUtils.isNotEmpty(user.getCapAcntNo())) {
			model.addAttribute("bankName", selCodeServ.selectByitemno("bank", user.getParent_bank_id()).getItemname());
			user.setRealname(StringUtil.handleName(user.getRealname()));
			user.setCapAcntNo(StringUtil.handleBankNo1(user.getCapAcntNo()));
			model.addAttribute("userAccountInfo", user);
			model.addAttribute("userAccountamt", userAccountInfo.getCash());

			// 收取手续费String chargeItem, String feeName, String userType
			SiteFeeTypePOJO siteFeeTypeVo = siteFeeServ.queryChageMode(null, "投资人提现手续费", "1");
			if (siteFeeTypeVo != null) {
				if (siteFeeTypeVo.getFormulaType() == 1) {
					model.addAttribute("formulaType", 1);
					model.addAttribute("interestRate", siteFeeTypeVo.getInterestRate().divide(new BigDecimal(100)));
				} else {
					model.addAttribute("formulaType", 2);
					model.addAttribute("fee", siteFeeTypeVo.getAmount());
				}
			} else {
				model.addAttribute("formulaType", 2);
				model.addAttribute("fee", 0);
			}
		}
		return "views/userAccount/withdrawal.jsp";
	}

	/**
	 * 跳转到借款人账户中心_借款人提现
	 * 
	 * @return
	 */
	@RequestMapping("/enterBorrowWithdrawal")
	public String enterBorrowWithdrawal(Model model, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
		if (user == null) {
			model.addAttribute("msg", "请先登录");
			return "msg.jsp";
		}
		user = userServ.getUserByUserId(user.getUserId());
		UserAccountVO userAccountInfo = acctServ.selectByUserId(user.getUserId());
		if (user != null && StringUtils.isNotEmpty(user.getCapAcntNo())) {
			model.addAttribute("bankName", selCodeServ.selectByitemno("bank", user.getParent_bank_id()).getItemname());
			user.setRealname(StringUtil.handleName(user.getRealname()));
			user.setCapAcntNo(StringUtil.handleBankNo1(user.getCapAcntNo()));
			model.addAttribute("userAccountInfo", user);
			model.addAttribute("userAccountamt", userAccountInfo.getCash());
			
			// 收取手续费String chargeItem, String feeName, String userType
			SiteFeeTypePOJO siteFeeTypeVo = siteFeeServ.queryChageMode(null, "借款人提现手续费", "2");
			if (siteFeeTypeVo != null) {
				if (siteFeeTypeVo.getFormulaType() == 1) {
					model.addAttribute("formulaType", 1);
					model.addAttribute("interestRate", siteFeeTypeVo.getInterestRate().divide(new BigDecimal(100)));
				} else {
					model.addAttribute("formulaType", 2);
					model.addAttribute("fee", siteFeeTypeVo.getAmount());
				}
			} else {
				model.addAttribute("formulaType", 2);
				model.addAttribute("fee", 0);
			}
		}
		return "views/borrowerCenter/borrowWithdrawal.jsp";
	}

	/**
	 * 跳转到机构账户中心_借款人提现
	 * 
	 * @return
	 */
	@RequestMapping("/enterInsWithdrawal")
	public String enterInsWithdrawal(Model model, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
		if (user == null) {
			model.addAttribute("msg", "请先登录");
			return "msg.jsp";
		}
		user = userServ.getUserByUserId(user.getUserId());
		UserAccountVO userAccountInfo = acctServ.selectByUserId(user.getUserId());
		if (user != null && StringUtils.isNotEmpty(user.getCapAcntNo())) {
			model.addAttribute("bankName", selCodeServ.selectByitemno("bank", user.getParent_bank_id()).getItemname());
			model.addAttribute("userAccountInfo", user);
			model.addAttribute("userAccountamt", userAccountInfo.getCash());
			// 收取手续费String chargeItem, String feeName, String userType
			SiteFeeTypePOJO siteFeeTypeVo = siteFeeServ.queryChageMode(null, "机构提现手续费", "3");
			if (siteFeeTypeVo != null) {
				if (siteFeeTypeVo.getFormulaType() == 1) {
					model.addAttribute("formulaType", 1);
					model.addAttribute("interestRate", siteFeeTypeVo.getInterestRate().divide(new BigDecimal(100)));
				} else {
					model.addAttribute("formulaType", 2);
					model.addAttribute("fee", siteFeeTypeVo.getAmount());
				}
			} else {
				model.addAttribute("formulaType", 2);
				model.addAttribute("fee", 0);
			}
		}
		return "views/institutionsCenter/insWithdrawal.jsp";
	}

	

}
