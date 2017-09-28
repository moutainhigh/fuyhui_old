package com.fujfu.web.account;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fujfu.common.payment.fuyou.pojo.CapitalFreezeBean;
import com.fujfu.common.payment.fuyou.pojo.CapitalUnFreezeBean;
import com.fujfu.common.payment.fuyou.pojo.QueryBalanceBean;
import com.fujfu.common.payment.fuyou.pojo.QueryReOrWithDetailsBean;
import com.fujfu.common.payment.fuyou.pojo.QueryTransactionDetailsBean;
import com.fujfu.common.payment.fuyou.pojo.TransBmuBean;
import com.fujfu.common.payment.fuyou.pojo.TransBuBean;
import com.fujfu.common.payment.fuyou.pojo.TransBuFreeze2FreezeBean;
import com.fujfu.common.payment.fuyou.pojo.response.CapitalFreezeResp;
import com.fujfu.common.payment.fuyou.pojo.response.CapitalUnFreezeResp;
import com.fujfu.common.payment.fuyou.pojo.response.QueryBalanceResp;
import com.fujfu.common.payment.fuyou.pojo.response.QueryReOrWithDetailsBeanResp;
import com.fujfu.common.payment.fuyou.pojo.response.QueryTransactionDetailsBeanResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBmuResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBuFreeze2FreezeResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBuResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.DateUtil;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.CapitalMgtServ;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.web.BaseController;

/**
 * 资金管理控制器类
 * @author huangjizhong
 * @update 2016-6-28
 *
 */
@Controller
@RequestMapping("/fy/*")
public class CapitalMgtCtrl extends BaseController {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(CapitalMgtCtrl.class);
	
	@Autowired 
	private CapitalMgtServ service;  
	
	@Autowired
	private UserServ userServ;
	
	@Autowired
	private UserAccountServ uActServ;
	
	/**
	 * 转账(商户与个人之间)
	 * 
	 */
	@RequestMapping("transBmu")
	public ModelAndView transBmu(HttpServletRequest request, HttpServletResponse response, 
			TransBmuBean reqData, TransBmuResp respData, Model model) {	
		
		Double amount = Double.valueOf(reqData.getAmt())*100;
		String amt = (new Double(amount)).intValue()+"";
		reqData.setAmt(amt);
		
		respData = service.transferBmu(reqData, null, null, "转账", "转账");
		
		String respCode = respData.getResponse().getResp_code();
		if(respCode.equals(FyUtil.SUCCESS)){
			model.addAttribute("transBmu", "bmu资金划拨成功,金额" + amount/100 + "元");
			return new ModelAndView("success.jsp");		
		}
		//数据处理
		model.addAttribute("code", respCode);
		return new ModelAndView("fail.jsp");	
	}
	
	/**
	 * 划拨(个人与个人之间)
	 * 
	 */
	@RequestMapping("transBu")
	public ModelAndView transBu(HttpServletRequest request, HttpServletResponse response,
			TransBuBean reqData, TransBuResp respData, Model model) {	
		
		Double amount = Double.valueOf(reqData.getAmt())*100;
		String amt = (new Double(amount)).intValue()+"";
		reqData.setAmt(amt);
		
		respData = service.transferBu(reqData, null, null, "还款", "还款");
		
		String respCode = respData.getResponse().getResp_code();
		if(respCode.equals(FyUtil.SUCCESS)){
			model.addAttribute("transBu", "资金划拨成功,金额" + amount/100 + "元");
			return new ModelAndView("success.jsp");		
		}
		//数据处理
		model.addAttribute("code", respCode);
		return new ModelAndView("fail.jsp");	
	}
	
	/**
	 * 资金冻结
	 * 
	 */
	@RequestMapping("freeze")
	public ModelAndView capitalFreeze(HttpServletRequest request, HttpServletResponse response, 
			CapitalFreezeBean reqData, CapitalFreezeResp respData, Model model) {	
		
		Double amount = Double.valueOf(reqData.getAmt())*100;
		String amt = (new Double(amount)).intValue()+"";
		reqData.setAmt(amt);
		
		respData = service.capitalFreeze(reqData, null, null, "冻结", "冻结");
		String respCode = respData.getResponse().getResp_code();
		if(respCode.equals(FyUtil.SUCCESS)){
			model.addAttribute("capitalFreeze", "资金冻结成功,金额" + amount/100 + "元");
			return new ModelAndView("success.jsp");		
		}
		//数据处理
		model.addAttribute("code", respCode);
		return new ModelAndView("fail.jsp");	
	}
	
	/**
	 * 资金解冻
	 * 
	 */
	@RequestMapping("unfreeze")
	public ModelAndView capitalUnFreeze(HttpServletRequest request, HttpServletResponse response, 
			CapitalUnFreezeBean reqData, CapitalUnFreezeResp respData, Model model) {
		
		Double amount = Double.valueOf(reqData.getAmt())*100;
		String amt = (new Double(amount)).intValue()+"";
		reqData.setAmt(amt);
		
		respData = service.capitalUnFreeze(reqData, null, null, "解冻", "解冻");
		String respCode = respData.getResponse().getResp_code();
		if(respCode.equals(FyUtil.SUCCESS)){
			model.addAttribute("capitalUnFreeze", "资金解冻成功,金额" + amount/100 + "元");
			return new ModelAndView("success.jsp");		
		}
		//数据处理
		model.addAttribute("code", respCode);
		return new ModelAndView("fail.jsp");	
	}
	
	/**
	 * 点击账户中心时余额查询
	 * 
	 */
	@RequestMapping("balance")
	public String balance(HttpServletRequest request, HttpServletResponse response, 
			QueryBalanceBean reqData, Model model) {	
		// 查询余额
		UserVO userInf = (UserVO) getSession("user_inf");
		userInf = userServ.getUserByUserId(userInf.getUserId());
		reqData.setCust_no(userInf.getJzhloginid());
		reqData.setMchnt_txn_dt(DateUtil.getCurrentDate("yyyyMMdd"));
		
		QueryBalanceResp respData = service.queryBalance(reqData);
		String respCode = respData.getResponse().getResp_code();
		if(respCode.equals(FyUtil.SUCCESS)){
			respData = respData.getResponse().getRespList().get(0);
			// 更新账户表
			UserAccountVO ua = new UserAccountVO();
			ua.setUserId(userInf.getUserId());
			ua.setTotal(new BigDecimal(Integer.valueOf(respData.getCt_balance()) / 100));
			ua.setFrost(new BigDecimal(Integer.valueOf(respData.getCf_balance()) / 100));
			ua.setCash(new BigDecimal(Integer.valueOf(respData.getCa_balance()) / 100));
			uActServ.updateByPrimaryKeySelective(ua);				
		}
		
		//数据处理
		model.addAttribute("code", respCode);
		return "redirect:/myAccount/enterUserAccount";
	}
	/**
	 * 点击账户中心时余额查询测试
	 * 
	 */
	@RequestMapping("balance1")
	public String balance1(HttpServletRequest request, HttpServletResponse response, 
			QueryBalanceBean reqData, Model model) {	
		// 查询余额
		reqData.setCust_no("18692003840");
		reqData.setMchnt_txn_dt(DateUtil.getCurrentDate("yyyyMMdd"));
		
		QueryBalanceResp respData = service.queryBalance(reqData);
		String respCode = respData.getResponse().getResp_code();
		if(respCode.equals(FyUtil.SUCCESS)){
			respData = respData.getResponse().getRespList().get(0);
			
		}
		
		//数据处理
		model.addAttribute("code", respCode);
		return "redirect:/myAccount/enterUserAccount";
	}
	
	/**
	 * 冻结到冻结
	 * 
	 */
	@RequestMapping("freeze2f")
	public ModelAndView freeze2f(TransBuFreeze2FreezeBean reqData, Model model) {	
		
		
		TransBuFreeze2FreezeResp respData = service.freeze2f(reqData, null, null, "放款冻结到冻结", "放款冻结到冻结");
		String respCode = respData.getResponse().getResp_code();
		if(respCode.equals(FyUtil.SUCCESS)){
			double freezeAmt = (Double.valueOf(respData.getResponse().getAmt()).doubleValue())/100;
			model.addAttribute("capitalUnFreeze", "资金冻结-冻结成功,金额" + freezeAmt + "元");
			return new ModelAndView("success.jsp");		
		}
		//数据处理
		model.addAttribute("code", respCode);
		return new ModelAndView("fail.jsp");	
	}
	
	/**
	 * 查询充值提现交易明细
	 * 
	 */
	@RequestMapping("reOrWithDetails")
	public QueryReOrWithDetailsBeanResp reOrWithDetails(HttpServletRequest request, HttpServletResponse response, 
			QueryReOrWithDetailsBean reqData, Model model) {	
		// 查询余额
		UserVO userInf = (UserVO) getSession("user_inf");
		//userInf = userServ.getUserByUserId(userInf.getUserId());
		//reqData.setCust_no(userInf.getJzhloginid());
		reqData.setEnd_time("2017-01-16 00:00:00");
		reqData.setPage_no("1");
		reqData.setPage_size("10");
		reqData.setStart_time("2017-01-01 00:00:00");
		reqData.setTxn_st("1");
		
		QueryReOrWithDetailsBeanResp respData = service.QueryReOrWithDetails(reqData);
		String respCode = respData.getResponse().getResp_code();
		if(respCode.equals(FyUtil.SUCCESS)){
			
		}
		return respData;
	
	}
	
	/**
	 * 查询交易明细
	 * 
	 */
	@RequestMapping("transactionDetails")
	public QueryTransactionDetailsBeanResp transactionDetails(HttpServletRequest request, HttpServletResponse response, 
			QueryTransactionDetailsBean reqData, Model model) {	
		// 查询余额
		UserVO userInf = (UserVO) getSession("user_inf");
		//userInf = userServ.getUserByUserId(userInf.getUserId());
		//reqData.setCust_no(userInf.getJzhloginid());
		
		reqData.setPage_no("");
		reqData.setPage_size("");		
		reqData.setTxn_st("");
		reqData.setStart_day("20170101");
		reqData.setEnd_day("20170116");
		reqData.setRemark("");
		QueryTransactionDetailsBeanResp respData = service.QueryTransactionDetails(reqData);
		String respCode = respData.getResponse().getResp_code();
		if(respCode.equals(FyUtil.SUCCESS)){
			
		}
		return respData;
	
	}
}
	