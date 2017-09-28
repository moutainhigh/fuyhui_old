package com.fujfu.web.account;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
import com.fujfu.common.payment.fuyou.pojo.UserRechargeBean1;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.payment.fuyou.util.SecurityUtils;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.StringUtil;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.pojo.account.PoundageInfoVO;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.fee.SiteFeeTypePOJO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.PoundageInfoServ;
import com.fujfu.service.account.SiteAccountLogServ;
import com.fujfu.service.account.SiteAccountServ;
import com.fujfu.service.account.SiteBillingServ;
import com.fujfu.service.account.UserAccountLogServ;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.common.CommonServ;
import com.fujfu.service.common.SelCodeServ;
import com.fujfu.service.fee.SiteFeeServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.web.BaseController;

/**
 * 充值控制器
 */
@Controller
@RequestMapping("/account/*")
public class RechargeMgtCtrl extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(RechargeMgtCtrl.class);

	@Autowired
	private UserServ userServ;

	@Autowired
	private SelCodeServ selCodeServ;

	@Autowired
	private SiteFeeServ siteFeeServ;
	@Autowired
	private PoundageInfoServ poundageInfoServ;
	@Autowired
	private UserAccountServ acctServ;

	@Resource
	private UserAccountLogServ userAccountLogServ;
	@Resource
	private CommonServ commonServ;
	@Resource
	private UserAccountServ userAccountServ;
	@Resource
	private SiteAccountLogServ siteAccountLogServ;
	@Resource
	private SiteAccountServ siteAccountServ;
	@Resource
	private SiteBillingServ siteBillingServ;

	/**
	 * 跳转到账户中心_充值
	 * 
	 * @return
	 */
	@RequestMapping("/enterRecharge")
	public String enterRecharge(Model model, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
		if (user == null) {
			model.addAttribute("msg", "请先登录");
			return "msg.jsp";
		}
		user = userServ.getUserByUserId(user.getUserId());

		// 收取手续费String chargeItem, String feeName, String userType
		SiteFeeTypePOJO siteFeeTypeVo = siteFeeServ.queryChageMode(null, "个人快捷充值手续费", "1");
		UserAccountVO userAccountInfo = acctServ.selectByUserId(user.getUserId());
		if (user != null && StringUtils.isNotEmpty(user.getCapAcntNo())) {
			user.setRealname(StringUtil.handleName(user.getRealname()));
			user.setCapAcntNo(StringUtil.handleBankNo1(user.getCapAcntNo()));
			model.addAttribute("userAccountInfo", user);
			model.addAttribute("bankName", selCodeServ.selectByitemno("bank", user.getParent_bank_id()).getItemname());
			model.addAttribute("userAccountamt", userAccountInfo.getCash());
			// 如果有配置手续费
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
			SiteFeeTypePOJO siteFeeTypeVo1 = siteFeeServ.queryChageMode(null, "个人网银充值手续费", "1");

			// 如果有配置手续费
			if (siteFeeTypeVo1 != null) {
				if (siteFeeTypeVo1.getFormulaType() == 1) {
					model.addAttribute("formulaType1", 1);
					model.addAttribute("interestRate1", siteFeeTypeVo1.getInterestRate().divide(new BigDecimal(100)));
				} else {
					model.addAttribute("formulaType1", 2);
					model.addAttribute("fee1", siteFeeTypeVo1.getAmount());
				}
			} else {
				model.addAttribute("formulaType1", 2);
				model.addAttribute("fee1", 0);
			}
		}
		return "views/userAccount/recharge.jsp";
	}

	/**
	 * 跳转到借款人账户中心_借款项目
	 * 
	 * @return
	 */

	@RequestMapping("/enterBorrowRecharge")
	public String enterBorrowRecharge(Model model, HttpSession session) {

		UserVO user = (UserVO) session.getAttribute("user_inf");
		if (user == null) {
			model.addAttribute("msg", "请先登录");
			return "msg.jsp";
		}
		user = userServ.getUserByUserId(user.getUserId());
		// 收取手续费String chargeItem, String feeName, String userType
		SiteFeeTypePOJO siteFeeTypeVo = siteFeeServ.queryChageMode(null, "借款人企业网银充值手续费", "2");
		UserAccountVO userAccountInfo = acctServ.selectByUserId(user.getUserId());

		if (user != null && StringUtils.isNotEmpty(user.getCapAcntNo())) {
			model.addAttribute("bankName", selCodeServ.selectByitemno("bank", user.getParent_bank_id()).getItemname());
			model.addAttribute("userAccountInfo", user);
			model.addAttribute("userAccountamt", userAccountInfo.getCash());
			// 如果有配置手续费
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
			SiteFeeTypePOJO siteFeeTypeVo1 = siteFeeServ.queryChageMode(null, "借款人个人网银充值手续费", "2");

			// 如果有配置手续费
			if (siteFeeTypeVo1 != null) {
				if (siteFeeTypeVo1.getFormulaType() == 1) {
					model.addAttribute("formulaType1", 1);
					model.addAttribute("interestRate1", siteFeeTypeVo1.getInterestRate().divide(new BigDecimal(100)));
				} else {
					model.addAttribute("formulaType1", 2);
					model.addAttribute("fee1", siteFeeTypeVo1.getAmount());
				}
			} else {
				model.addAttribute("formulaType1", 2);
				model.addAttribute("fee1", 0);
			}
		}
		return "views/borrowerCenter/borrowRecharge.jsp";
	}

	/**
	 * 跳转到担保人账户中心_chongzhi
	 * 
	 * @return
	 */

	@RequestMapping("/enterInsRecharge")
	public String enterInsRecharge(Model model, HttpSession session) {

		UserVO user = (UserVO) session.getAttribute("user_inf");
		if (user == null) {
			model.addAttribute("msg", "请先登录");
			return "msg.jsp";
		}
		user = userServ.getUserByUserId(user.getUserId());
		// 收取手续费String chargeItem, String feeName, String userType
		SiteFeeTypePOJO siteFeeTypeVo = siteFeeServ.queryChageMode(null, "机构企业网银充值手续费", "3");
		UserAccountVO userAccountInfo = acctServ.selectByUserId(user.getUserId());

		if (user != null && StringUtils.isNotEmpty(user.getCapAcntNo())) {
			model.addAttribute("bankName", selCodeServ.selectByitemno("bank", user.getParent_bank_id()).getItemname());
			model.addAttribute("userAccountInfo", user);
			model.addAttribute("userAccountamt", userAccountInfo.getCash());
			// 如果有配置手续费
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
			// 充值中的个人网银充值手续费
			SiteFeeTypePOJO siteFeeTypeVo1 = siteFeeServ.queryChageMode(null, "机构个人网银充值手续费", "3");

			// 如果有配置手续费
			if (siteFeeTypeVo1 != null) {
				if (siteFeeTypeVo1.getFormulaType() == 1) {
					model.addAttribute("formulaType1", 1);
					model.addAttribute("interestRate1", siteFeeTypeVo1.getInterestRate().divide(new BigDecimal(100)));
				} else {
					model.addAttribute("formulaType1", 2);
					model.addAttribute("fee1", siteFeeTypeVo1.getAmount());
				}
			} else {
				model.addAttribute("formulaType1", 2);
				model.addAttribute("fee1", 0);
			}
		}
		return "views/institutionsCenter/insRecharge.jsp";
	}

	/**
	 * 快捷充值(个人)
	 * 
	 */
	@RequestMapping("fastRecharge")
	public ModelAndView fastRechrg(HttpServletRequest request, HttpServletResponse response, UserRechargeBean reqData,
			Model model) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		if (user_inf == null) {
			model.addAttribute("msg", "请先登录");
			return new ModelAndView("msg.jsp");
		}
		user_inf = userServ.getUserByUserId(user_inf.getUserId());
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isEmpty(reqData.getAmt())) {
			map.put("respMsg", "请输入充值金额");
			return null;
		}
		// 根据充值金额算手续费 算出充值总额
		BigDecimal amt = new BigDecimal(reqData.getAmt());
		// 收取手续费String chargeItem, String feeName, String userType
		SiteFeeTypePOJO siteFeeTypeVo = new SiteFeeTypePOJO();
		if ("1".endsWith(user_inf.getUserType())) {
			siteFeeTypeVo = siteFeeServ.queryChageMode(null, "个人快捷充值手续费", "1");// 获取手续费
			// 目前快捷充值只支持投资人（个人）
			// } else if ("2".endsWith(user_inf.getUserType())) {
			// siteFeeTypeVo = siteFeeServ.queryChageMode(null, "借款人充值手续费",
			// "2");// 获取手续费
			// } else {
			// siteFeeTypeVo = siteFeeServ.queryChageMode(null, "机构充值手续费",
			// "3");// 获取手续费
		}
		BigDecimal fee = UserAccountUtil.getPoundageAmt(siteFeeTypeVo, amt);
		BigDecimal amt1 = amt.add(fee);
		BigDecimal amt2 = amt1.multiply(new BigDecimal("100"));
		BigDecimal amt3 = amt2.divide(new BigDecimal("1"), 0, BigDecimal.ROUND_HALF_UP);

		// 组装请求报文
		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss") + UserAccountUtil.getManyNumber(4));
		reqData.setAmt(amt3.toString());

		reqData.setLogin_id(user_inf.getJzhloginid());
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		reqData.setBack_notify_url(FyUtil.FAST_BEHIND);
		reqData.setPage_notify_url(FyUtil.FAST_INDEX);
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		reqData.setAction(FyUtil.FAST_RECHARGE);
		// 保存数据到中间表 主要是 充值外扣时手续费没法取到。所以保存到中间表
		PoundageInfoVO poundageInfo = new PoundageInfoVO();
		poundageInfo.setUserId(user_inf.getUserId());
		poundageInfo.setCreateTime(DateUtil.getUnixTime());
		poundageInfo.setPoundageatm(fee);
		// poundageInfo.setRelativeid("");
		poundageInfo.setRelativetype("Recharge");
		poundageInfo.setStatus(1);
		poundageInfo.setTxn_ssn(reqData.getMchnt_txn_ssn());
		if (siteFeeTypeVo != null) {
			poundageInfo.setFeeid(siteFeeTypeVo.getChargeFeeId());
		} else {
			poundageInfo.setFeeid(0);

		}
		poundageInfoServ.addPoundageInfo(poundageInfo);
		
		//保存数据到对账表fu_site_billing
		siteBillingServ.addSiteBilling(null, user_inf, reqData.getMchnt_txn_ssn(), amt1,"充值", "个人快捷充值",reqData.regSignVal());
		
		// 数据处理
		model.addAttribute("data", reqData);
		return new ModelAndView("views/admin/account/recharge.jsp");
	}

	/**
	 * 网银充值(个人)
	 * 
	 */
	@RequestMapping("webRecharge")
	public ModelAndView webRecharge(HttpServletRequest request, HttpServletResponse response, UserRechargeBean reqData,
			Model model) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		user_inf = userServ.getUserByUserId(user_inf.getUserId());

		// 根据充值金额算手续费 算出充值总额
		BigDecimal amt = new BigDecimal(reqData.getAmt());
		// 收取手续费String chargeItem, String feeName, String userType
		SiteFeeTypePOJO siteFeeTypeVo = new SiteFeeTypePOJO();
		if ("1".endsWith(user_inf.getUserType())) {
			siteFeeTypeVo = siteFeeServ.queryChageMode(null, "个人网银充值手续费", "1");// 获取手续费
			// } else if ("2".endsWith(user_inf.getUserType())) {
			// siteFeeTypeVo = siteFeeServ.queryChageMode(null, "借款人充值手续费",
			// "2");// 获取手续费
			// } else {
			// siteFeeTypeVo = siteFeeServ.queryChageMode(null, "机构充值手续费",
			// "3");// 获取手续费
		}
		BigDecimal fee = UserAccountUtil.getPoundageAmt(siteFeeTypeVo, amt);
		BigDecimal amt1 = amt.add(fee);
		BigDecimal amt2 = amt1.multiply(new BigDecimal("100"));
		BigDecimal amt3 = amt2.divide(new BigDecimal("1"), 0, BigDecimal.ROUND_HALF_UP);
		// 组装请求报文
		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss") + UserAccountUtil.getManyNumber(4));
		reqData.setAmt(amt3.toString());
		reqData.setLogin_id(user_inf.getJzhloginid());
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		reqData.setBack_notify_url(FyUtil.WEB_BEHIND);
		reqData.setPage_notify_url(FyUtil.WEB_INDEX);
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		reqData.setAction(FyUtil.WEB_RECHARGE);
		// 保存数据到中间表 主要是 充值外扣时手续费没法取到。所以保存到中间表，同时保存实时的账户信息
		PoundageInfoVO poundageInfo = new PoundageInfoVO();
		poundageInfo.setUserId(user_inf.getUserId());
		poundageInfo.setCreateTime(DateUtil.getUnixTime());
		poundageInfo.setPoundageatm(fee);
		// poundageInfo.setRelativeid("");
		poundageInfo.setRelativetype("Recharge");
		poundageInfo.setStatus(1);
		poundageInfo.setTxn_ssn(reqData.getMchnt_txn_ssn());
		if (siteFeeTypeVo != null) {
			poundageInfo.setFeeid(siteFeeTypeVo.getChargeFeeId());
		} else {
			poundageInfo.setFeeid(0);
		}
		poundageInfoServ.addPoundageInfo(poundageInfo);
		
		//保存数据到对账表fu_site_billing
		siteBillingServ.addSiteBilling(null, user_inf, reqData.getMchnt_txn_ssn(), amt1,"充值", "个人网银充值",reqData.regSignVal());
		// 数据处理
		model.addAttribute("data", reqData);
		return new ModelAndView("views/admin/account/recharge.jsp");
	}

	/**
	 * 网银充值(公司用)
	 * 
	 */
	@RequestMapping("webRecharge1")
	public ModelAndView webRecharge1(HttpServletRequest request, HttpServletResponse response,
			UserRechargeBean1 reqData, Model model) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		user_inf = userServ.getUserByUserId(user_inf.getUserId());

		// 根据充值金额算手续费 算出充值总额
		BigDecimal amt = new BigDecimal(reqData.getAmt());
		// 收取手续费String chargeItem, String feeName, String userType
		SiteFeeTypePOJO siteFeeTypeVo = new SiteFeeTypePOJO();
		if ("2".equals(user_inf.getUserType())) {
			if ("B2C".equals(reqData.getOrder_pay_type())) {// 个人网银
				siteFeeTypeVo = siteFeeServ.queryChageMode(null, "借款人个人网银充值手续费", "2");// 获取手续费
			} else {// 企业网银
				siteFeeTypeVo = siteFeeServ.queryChageMode(null, "借款人企业网银充值手续费", "2");// 获取手续费
			}
		} else {
			if ("B2C".equals(reqData.getOrder_pay_type())) {// 个人网银
				siteFeeTypeVo = siteFeeServ.queryChageMode(null, "机构个人网银充值手续费", "3");// 获取手续费
			} else {// 企业网银
				siteFeeTypeVo = siteFeeServ.queryChageMode(null, "机构企业网银充值手续费", "3");// 获取手续费
			}
		}

		BigDecimal fee = UserAccountUtil.getPoundageAmt(siteFeeTypeVo, amt);
		BigDecimal amt1 = amt.add(fee);
		BigDecimal amt2 = amt1.multiply(new BigDecimal("100"));
		BigDecimal amt3 = amt2.divide(new BigDecimal("1"), 0, BigDecimal.ROUND_HALF_UP);
		// 组装请求报文

		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss") + UserAccountUtil.getManyNumber(4));
		reqData.setAmt(amt3.toString());
		reqData.setLogin_id(user_inf.getJzhloginid());
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		reqData.setBack_notify_url(FyUtil.WEB_BEHIND);
		reqData.setPage_notify_url(FyUtil.WEB_INDEX);
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		reqData.setAction(FyUtil.WEB_RECHARGE1);

		// 保存数据到中间表 主要是 充值外扣时手续费没法取到。所以保存到中间表，同时保存实时的账户信息
		PoundageInfoVO poundageInfo = new PoundageInfoVO();
		poundageInfo.setUserId(user_inf.getUserId());
		poundageInfo.setCreateTime(DateUtil.getUnixTime());
		poundageInfo.setPoundageatm(fee);
		// poundageInfo.setRelativeid("");
		poundageInfo.setRelativetype("Recharge");
		poundageInfo.setStatus(1);
		poundageInfo.setTxn_ssn(reqData.getMchnt_txn_ssn());
		if (siteFeeTypeVo != null) {
			poundageInfo.setFeeid(siteFeeTypeVo.getChargeFeeId());
		} else {
			poundageInfo.setFeeid(0);

		}
		poundageInfoServ.addPoundageInfo(poundageInfo);
		
		//保存数据到对账表fu_site_billing
		if ("B2C".equals(reqData.getOrder_pay_type())) {// 个人网银
			siteBillingServ.addSiteBilling(null, user_inf, reqData.getMchnt_txn_ssn(), amt1,"充值", "个人网银充值(企业)",reqData.regSignVal());
		} else {// 企业网银
			siteBillingServ.addSiteBilling(null, user_inf, reqData.getMchnt_txn_ssn(), amt1,"充值", "企业网银充值(企业)",reqData.regSignVal());
		}
		// 数据处理
		model.addAttribute("data", reqData);
		return new ModelAndView("views/admin/account/recharge1.jsp");
	}

	/**
	 * 快捷异步回调地址
	 * 
	 */
	@RequestMapping("fastBehind")
	public ModelAndView fastBehind(HttpServletRequest request, HttpServletResponse response, UserRechargeBean reqData,
			Model model) {
		log.info("》》》》》》》》》》》》》》》》》》》》==" + "收到快捷异步回调");
		reqData.setAmt("1000");
		reqData.setMchnt_txn_ssn("201606280001");

		// 数据处理
		return new ModelAndView("");
	}

	/**
	 * 网银异步回调地址
	 * 
	 */
	@RequestMapping("webBehind")
	public ModelAndView webBehind(HttpServletRequest request, HttpServletResponse response, UserRechargeBean reqData,
			Model model) {

		reqData.setAmt("1000");
		reqData.setMchnt_txn_ssn("201606280001");

		// 数据处理
		return new ModelAndView("");
	}

	

}
