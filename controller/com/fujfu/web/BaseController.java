package com.fujfu.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fujfu.common.payment.fuyou.pojo.QueryBalanceBean;
import com.fujfu.common.payment.fuyou.pojo.QueryReOrWithDetailsBean;
import com.fujfu.common.payment.fuyou.pojo.response.QueryBalanceResp;
import com.fujfu.common.payment.fuyou.pojo.response.QueryReOrWithDetailsBeanResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.account.UserRechargeVO;
import com.fujfu.pojo.account.UserRechargeDTO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.CapitalMgtServ;
import com.fujfu.service.account.RechargeServ;
import com.fujfu.service.account.UserAccountServ;
@Controller
public class BaseController implements Serializable{
	@Resource
	private UserAccountServ userAccountServ;
	@Resource
	private CapitalMgtServ capitalMgtServ;
	@Autowired
	private RechargeServ rechargeServ;
	private static final long serialVersionUID = 8695834026800952113L;
	
	/**
	 * 设置session
	 * @param sessionName
	 * @param obj
	 */
	public void addSession(String sessionName, Object obj) {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
		HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();  
		request.getSession().setAttribute(sessionName, obj);
		
	}
	
	/**
	 * 获取session
	 * @param sessionName
	 */
	public Object getSession(String sessionName) {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
		HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();  
		HttpSession session = request.getSession(true);
		return session.getAttribute(sessionName);
	}
	
	/**
	 * 销毁session
	 * @param sessionName
	 */
	public void removeSession(String sessionName) {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
		HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();  
		Enumeration<String> em = request.getSession().getAttributeNames();
		        while (em.hasMoreElements()) {
		            request.getSession().removeAttribute(em.nextElement().toString());
		        }
		        request.getSession().removeAttribute(sessionName);
		        request.getSession().invalidate();
	}
	
	/**
	 * 更新用户账户信息
	 * @param user
	 * @return
	 */
	public void updateUserAccount(UserVO user) {
		if (StringUtils.isNotEmpty(user.getJzhloginid())) {
			// 查询余额
			QueryBalanceBean reqData = new QueryBalanceBean();
			reqData.setCust_no(user.getJzhloginid());
			QueryBalanceResp resp = capitalMgtServ.queryBalance(reqData);

			// 更新账户表
			UserAccountVO ua = new UserAccountVO();
			String respCode = resp.getResponse().getResp_code();
			if (respCode.equals(FyUtil.SUCCESS)) {
				resp = resp.getResponse().getRespList().get(0);// 返回金额单位为分
				ua.setUserId(user.getUserId());
				if (StringUtils.isNotEmpty(resp.getCt_balance())) {
					ua.setTotal(new BigDecimal(resp.getCt_balance()).divide(new BigDecimal(100)));
				}
				if (StringUtils.isNotEmpty(resp.getCf_balance())) {
					ua.setFrost(new BigDecimal(resp.getCf_balance()).divide(new BigDecimal(100)));
				}
				if (StringUtils.isNotEmpty(resp.getCa_balance())) {
					ua.setCash(new BigDecimal(resp.getCa_balance()).divide(new BigDecimal(100)));
				}
				userAccountServ.updateByPrimaryKeySelective(ua);
			}
			
		}
	}
	
	/**
	 * 原充值提现通知是异步，所以主动查询
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public void updateUserAccount1(UserVO user) throws Exception {
		if (StringUtils.isNotEmpty(user.getJzhloginid())) {
			//查询用户下所有未收到通知的充值提现记录
			UserRechargeDTO userRechargeQuery=new UserRechargeDTO();
			userRechargeQuery.setUserID(user.getUserId().toString());
			userRechargeQuery.setStatus("0");
			List<UserRechargeVO>  rechargeList =rechargeServ.selectByQueryCondition(userRechargeQuery);
			for(UserRechargeVO recharge:rechargeList){
				QueryReOrWithDetailsBean reqData =new QueryReOrWithDetailsBean();
				reqData.setBusi_tp("PW11");
				reqData.setCust_no(user.getJzhloginid());
				reqData.setMchnt_cd(FyUtil.MCHNT_CD);
				reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss") + UserAccountUtil.getManyNumber(4));
				reqData.setTxn_ssn(recharge.getBillno());
				reqData.setTxn_st("1");
				QueryReOrWithDetailsBeanResp respData = capitalMgtServ.QueryReOrWithDetails(reqData);
				String respCode = respData.getResponse().getResp_code();
				if (respCode.equals(FyUtil.SUCCESS)) {
					respData = respData.getResponse().getRespList().get(0);// 返回金额单位为分
					
				}
			}
		}
			
			
	}
	
	/**
	 * 判断登录状态
	 * @param session
	 * @param model
	 */
	public boolean isLogin(HttpSession session, Model model){
		UserVO user = (UserVO) session.getAttribute("user_inf");
		if (user != null) {
			return true;
		}
		return false;
	}
		
}
