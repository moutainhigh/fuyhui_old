package com.fujfu.web.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fujfu.common.util.StringUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.UserAccountLogPOJO;
import com.fujfu.pojo.account.UserAccountLogVO;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.apply.UserRepaySumPOJO;
import com.fujfu.pojo.invest.AllApplyRepayListPOJO;
import com.fujfu.pojo.invest.LoanApplyListPOJO;
import com.fujfu.pojo.loan.LoanPOJO;
import com.fujfu.pojo.loan.UserGuarnatySumPOJO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.UserAccountLogServ;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.loan.LoanApplyServ;
import com.fujfu.service.repay.RepayServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.web.BaseController;

/**
 * 用户账户中心控制器
 */
@Controller
@RequestMapping("/account/")
public class UserAccountCtrl extends BaseController {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserAccountServ acctServ;
	@Resource
	private LoanApplyServ loanApplyServ;
	@Autowired
	private UserServ userServ;
	@Autowired
	private RepayServ repayServ;
	
	@Autowired
	private UserAccountLogServ userAccountLogServ;
	/**
	 * 用户账户中心
	 */
	@RequestMapping("center")
	public ModelAndView center(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		UserVO userInf = (UserVO) getSession("user_inf");
		Integer userid = Integer.valueOf(userInf.getUserId());
		UserAccountVO userAccount = acctServ.selectByUserId(userid);
		model.addAttribute("userAccount", userAccount);
		return new ModelAndView("views/userAccount/index.jsp");
	}

	/**
	 * 跳转到借款中心我的借款页面详情
	 * 
	 * @return
	 */
	@RequestMapping("/enterMyborrowInfo")
	@ResponseBody
	public Object enterMyborrowInfo(HttpSession session, String applyId,String pageNum ,String pageSize) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
		//user = userServ.getUserByUserId(1000000115);
		// 定义返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		if (user != null) {
			if (StringUtils.isEmpty(pageNum)) {
				pageNum = "1";
			}
			// 判断当前页是否有值，没有则设置默认值
			LoanPOJO loan =loanApplyServ.findInvestmentById(Integer.parseInt(applyId));
			user=userServ.getUserByUserId(user.getUserId());
			LoanInvestPOJO loanInvestQueryVo = new LoanInvestPOJO();
			loanInvestQueryVo.setApply_id(Integer.parseInt(applyId));
			Page page =new Page();
			page.setPageNum(Integer.parseInt(pageNum));
			page.setPageSize(Integer.parseInt(pageSize));
			page =repayServ.findAllApplyRepayListByCondition(loanInvestQueryVo, page);
			ArrayList<AllApplyRepayListPOJO> repayList = (ArrayList<AllApplyRepayListPOJO>) page.getItems();
			UserVO borUser =userServ.getUserByUserId(loan.getUserId());
			//获取 已还金额  逾期金额  待还金额
			
			//页数小 所以强制转换
			int totalnum =(int) page.getTotalCount();

			int totalPage = totalnum % Integer.parseInt(pageSize) == 0 ? totalnum / Integer.parseInt(pageSize) : totalnum / Integer.parseInt(pageSize) + 1;
			map.put("flag", "1");
			map.put("orderNumber", loan.getOrderNumber());
			map.put("apr", StringUtil.handleApr(loan.getApr()));
			map.put("card_id", StringUtil.handleCardId(borUser.getCardId()));
			map.put("amount", loan.getAmount());
			map.put("purpose", loan.getPurpose());
			map.put("mobile", StringUtil.handlePhone(borUser.getMobile()));
			map.put("period", loan.getPeriod());
			map.put("realname", StringUtil.handleName(borUser.getRealname()));
			
			//获取已还总金额
			UserRepaySumPOJO userRepaySum2 = new UserRepaySumPOJO();
			userRepaySum2 =repayServ.findUserRepaySumMap("1", user.getUserId(),Integer.parseInt(applyId));//0指已还
			map.put("restAmount",userRepaySum2.getSumReceipts());//已还金额
			
			//获取待还总金额
			UserRepaySumPOJO userRepaySum1 = new UserRepaySumPOJO();
			userRepaySum1 =repayServ.findUserRepaySumMap("0", user.getUserId(),Integer.parseInt(applyId));//0指未还
			
			map.put("prePayAmount",  userRepaySum1.getSumReceipts());//待还金额
			map.put("overdueAmount",0);//逾期金额
			
			

			map.put("content", repayList);
			map.put("totalPage", totalPage);
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}
	/**
	 * 跳转到借款中心我的借款页面
	 * 
	 * @return
	 */
	@RequestMapping("/enterMyborrow")
	@ResponseBody
	public Object enterMyborrow(HttpSession session, String pageNum, String userid) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
		//user = userServ.getUserByUserId(1000000115);
		// 定义返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		if (user != null) {
			// 判断当前页是否有值，没有则设置默认值
			if (StringUtils.isEmpty(pageNum)) {
				pageNum = "1";
			}
			LoanInvestPOJO loanInvestQueryVo = new LoanInvestPOJO();

			if (StringUtils.isNotEmpty(user.getUserId().toString())) {
				loanInvestQueryVo.setUser_id(user.getUserId());
			}

			List<LoanApplyListPOJO> applyList = loanApplyServ.findloanApplyListByConditionAndNum(loanInvestQueryVo,
					Integer.parseInt(pageNum));
			int totalNum = loanApplyServ.getcountApplyList(loanInvestQueryVo);
			int totalPage = totalNum % 10 == 0 ? totalNum / 10 : totalNum / 10 + 1;
			
			//获取累计借款总额
			UserRepaySumPOJO userRepaySum = new UserRepaySumPOJO();
			userRepaySum =repayServ.findUserRepaySumMap("", user.getUserId(),0);//空指全部
			
			//获取待还总金额
			UserRepaySumPOJO userRepaySum1 = new UserRepaySumPOJO();
			userRepaySum1 =repayServ.findUserRepaySumMap("0", user.getUserId(),0);//0指未还
			
			//获取已还总金额
			UserRepaySumPOJO userRepaySum2 = new UserRepaySumPOJO();
			userRepaySum2 =repayServ.findUserRepaySumMap("1", user.getUserId(),0);//0指已还
			
			
			map.put("flag", "1");
			map.put("content", applyList);
			map.put("totalPage", totalPage);
			map.put("sumMoney", userRepaySum.getSumCapital());//累计本金 为 借款总金额
			map.put("sumStillMoney", userRepaySum1.getSumReceipts());//累计未还款金额 
			map.put("sumHasMoney", userRepaySum2.getSumReceipts());//累计已还款金额 
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}

	/**
	 * 前台交易记录入口
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("transactionRecordList")
	@ResponseBody
	public Object transactionRecordList(HttpSession session, String pageNum, String userId, String type, String date) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
		//user = userServ.getUserByUserId(1000000087);
		// 定义返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		// 判断当前页是否有值，没有则设置默认值
		if (user != null) {
			if (StringUtils.isEmpty(pageNum)) {
				pageNum = "1";
			}
			user = userServ.getUserByUserId(user.getUserId());
			UserAccountVO userAccount = new UserAccountVO();
			userAccount= acctServ.selectByUserId(user.getUserId());
			UserAccountLogPOJO userAccountLogQuery = new UserAccountLogPOJO();
			userAccountLogQuery.setUserId(user.getUserId());
			if(!"0".equals(type)){
				userAccountLogQuery.setType(type);
			}
			List<UserAccountLogVO> userAccountLogList = userAccountLogServ.findUserAllUserAccountLog(userAccountLogQuery,
					Integer.parseInt(pageNum));
			int  userAccountLogNum = userAccountLogServ.countUseAccountLog(userAccountLogQuery);
			int totalPage = userAccountLogNum % 7 == 0 ? userAccountLogNum / 7 : userAccountLogNum / 7 + 1;
			map.put("flag", "1");
			map.put("content", userAccountLogList);
			map.put("totalPage", totalPage);
			map.put("getTotal", userAccount.getTotal());
			map.put("getCash", userAccount.getCash());
			map.put("getFrost", userAccount.getFrost());
			return map;
		}else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
		
	}
	
	/**
	 * 跳转到机构中心我的担保页面
	 * 
	 * @return
	 */
	@RequestMapping("/enterMyIsn")
	@ResponseBody
	public Object enterMyIsn(HttpSession session, String pageNum, String userid,String pageSize) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
		user = userServ.getUserByUserId(1000000116);
		// 定义返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		if (user != null) {
			// 判断当前页是否有值，没有则设置默认值
			if (StringUtils.isEmpty(pageNum)) {
				pageNum = "1";
			}
			if (StringUtils.isEmpty(pageSize)) {
				pageSize = "8";
			}
			List<LoanApplyListPOJO> applyList = loanApplyServ.findUserLoanApplyByGuaranteeCompanyId(user.getUserId(), Integer.parseInt(pageSize), Integer.parseInt(pageNum));
			int totalNum = loanApplyServ.countLoanApplyByGuaranteeCompanyId(user.getUserId());
			int totalPage = totalNum % Integer.parseInt(pageSize) == 0 ? totalNum / Integer.parseInt(pageSize) : totalNum / Integer.parseInt(pageSize) + 1;
			UserGuarnatySumPOJO userGuarnatySum =loanApplyServ.findUserGuarnatySumMap(user.getUserId());
			BigDecimal S1 =new BigDecimal("0");
			BigDecimal S2 =new BigDecimal("0");
			map.put("flag", "1");
			map.put("content", applyList);
			map.put("totalPage", totalPage);
			map.put("userGuarnatySum", userGuarnatySum.getSumGuarnatyAtm());
			map.put("ydiankSum", S1);
			map.put("wdiankSum", S2);
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}
}
