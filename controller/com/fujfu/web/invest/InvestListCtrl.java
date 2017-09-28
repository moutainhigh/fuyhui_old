package com.fujfu.web.invest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.PDFUtil;
import com.fujfu.common.util.StringUtil;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.apply.ApplyRecoverVO;
import com.fujfu.pojo.apply.UserRecoverSumPOJO;
import com.fujfu.pojo.invest.LoanInvestListPOJO;
import com.fujfu.pojo.invest.LoanInvestmentVO;
import com.fujfu.pojo.loan.LoanPOJO;
import com.fujfu.pojo.loan.LoanApplyVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.invest.LoanInvestmentServ;
import com.fujfu.service.loan.LoanApplyServ;
import com.fujfu.service.loan.LoanTypeServ;
import com.fujfu.service.recover.RecoverServ;
import com.fujfu.service.repay.RepayServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.web.BaseController;
import com.fujfu.web.constant.FeeProperties;

@Controller
@RequestMapping("/invest/")
public class InvestListCtrl extends BaseController {

	private static final long serialVersionUID = 1L;

	@Resource
	private LoanApplyServ loanApplyServ;
	@Resource
	private LoanTypeServ loanTypeServ;
	@Resource
	private LoanInvestmentServ loanInvestmentServ;
	@Resource
	private RepayServ repayServ;
	@Resource
	private RecoverServ recoverServ;
	@Autowired
	private UserServ userServ;

	/**
	 * 投资列表接口
	 * 
	 * @param type
	 *            1 金猪 2 金桔
	 * @param loanType
	 * @param period
	 * @param pageSize
	 * @param pageNum
	 * @param rateSort
	 * @param amountSort
	 * @param progressSort
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "investList", method = RequestMethod.POST)
	public Object investList(HttpSession session, HttpServletRequest request, String loanType, String period,
			String pageSize, String pageNum, String rateSort, String amountSort, String progressSort, String type) {
		UserVO userInf = (UserVO) getSession("user_inf");
		int isInside = 0;
		if (userInf != null) {
			userInf = userServ.getUserByUserId(userInf.getUserId());
			if (userInf.getIsInside() == 1) {
				isInside = 1;
			}
		}
		// 暂时未做定时任务，在此时将放款终审通过的标的且开始时间小于等于当前时间的标的状态改为放款中
		List<LoanApplyVO> loanApplyList = loanApplyServ.listLoanApplyByStatus(2);
		if (loanApplyList.size() > 0) {
			int currenTime = DateUtil.getUnixTime();
			for (LoanApplyVO loanApply : loanApplyList) {
				if (loanApply.getStartTime() <= currenTime) {
					PDFUtil.runCreProductPdf(loanApply, request, loanTypeServ.findLoanTypeById(loanApply.getLoanType()),
							userServ.getUserByUserId(loanApply.getUserId()),
							userServ.getUserByUserId(loanApply.getGuaranteeCompanyId()));					
					loanApply.setStatus((byte) 7);
					loanApplyServ.updateLoanApply(loanApply);
				}
			}
		}

		/*
		 * // 超过投资截止时间，将状态改成流标 List<LoanApplyVO> loanApplyFailList =
		 * loanApplyServ.listLoanApplyByStatus(7); if(loanApplyFailList.size() >
		 * 0){ int currenTime = DateUtil.getUnixTime(); for(LoanApplyVO loanApply
		 * : loanApplyFailList){ if(loanApply.getEndTime()<currenTime){
		 * loanApply.setStatus((byte)20);
		 * loanApplyServ.updateLoanApply(loanApply); } } }
		 */

		// 定义返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		// 判断每页条数和当前页是否有值，没有则设置默认值
		if (StringUtils.isEmpty(pageSize)) {
			pageSize = "12";
		}
		if (StringUtils.isEmpty(pageNum)) {
			pageNum = "1";
		}		
			List<LoanPOJO> investList = loanApplyServ.listInvest(isInside, loanType, period, Integer.parseInt(pageSize),
					Integer.parseInt(pageNum), rateSort, amountSort, progressSort,type);
			int totalNum = loanApplyServ.countInvest(isInside, loanType, period,type);
			int totalPage = totalNum % (Integer.parseInt(pageSize)) == 0 ? totalNum / (Integer.parseInt(pageSize))
					: totalNum / (Integer.parseInt(pageSize)) + 1;
			map.put("flag", "1");
			map.put("content", investList);
			map.put("totalPage", totalPage);
			return map;		
	}

	/**
	 * 产品类型接口
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "investTypeList", method = RequestMethod.POST)
	public Object investTypeList() {
		// 定义返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", "1");
		map.put("content", FeeProperties.LOAN_CATEGORY);
		return map;
	}

	/**
	 * 前台投资记录入口
	 * 认购中
	 * @param busitype 1金猪  2金桔
	 * @param model
	 * @return
	 */
	@RequestMapping("/loanInvestList")
	@ResponseBody
	public Object loanInvestList(HttpSession session, String pageNum, String userid, String status,String busitype) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
		// user =userServ.getUserByUserId(1000000060);
		// 定义返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		if (user != null) {
			// 判断当前页是否有值，没有则设置默认值
			if (StringUtils.isEmpty(pageNum)) {
				pageNum = "1";
			}
			LoanInvestPOJO loanInvestQueryVo = new LoanInvestPOJO();

			loanInvestQueryVo.setUser_id(user.getUserId());
			loanInvestQueryVo.setStatus(status);
			loanInvestQueryVo.setBusitype(busitype);
			List<LoanInvestListPOJO> InvestList = loanInvestmentServ.findloanInvestListByConditionAndNum(loanInvestQueryVo,
					Integer.parseInt(pageNum));
			int totalNum = loanInvestmentServ.getcountloanInvestListByConditionAndNum(loanInvestQueryVo);
			int totalPage = totalNum % 7 == 0 ? totalNum / 7 : totalNum / 7 + 1;
			map.put("flag", "1");
			map.put("content", InvestList);
			map.put("totalPage", totalPage);
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}

	/**
	 * 前台回款记录入口
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("ApplyRecoverList")
	@ResponseBody
	public Object ApplyRecoverList(HttpSession session, String pageNum, String userid, String pageSize) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
		// user =userServ.getUserByUserId(1000000060);
		// 定义返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		if (user != null) {
			// 判断当前页是否有值，没有则设置默认值
			if (StringUtils.isEmpty(pageNum)) {
				pageNum = "1";
			}
			if (StringUtils.isEmpty(pageSize)) {
				pageSize = "12";
			}
			LoanInvestPOJO loanInvestQueryVo = new LoanInvestPOJO();
			loanInvestQueryVo.setUser_id(user.getUserId());
			List<ApplyRecoverVO> RecoverList = recoverServ.findloanRecoverListByConditionAndNum(loanInvestQueryVo,
					Integer.parseInt(pageNum), Integer.parseInt(pageSize));
			int totalNum = recoverServ.getcountRecoverList(loanInvestQueryVo);
			int totalPage = totalNum % 7 == 0 ? totalNum / 7 : totalNum / 7 + 1;
			map.put("flag", "1");
			map.put("content", RecoverList);
			map.put("totalPage", totalPage);
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}

	/**
	 * 前台我的债权记录入口
	 * 
	 * @param busitype 1金猪 2 金桔
	 * @param model
	 * @return
	 */
	@RequestMapping("loanInvestRecoverList")
	@ResponseBody
	public Object loanInvestRecoverList(HttpSession session, String pageNum, String userid, String status,String busitype) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
		// 定义返回的json对象
		// user =userServ.getUserByUserId(1000000112);
		Map<String, Object> map = new HashMap<String, Object>();
		if (user != null) {
			// 判断当前页是否有值，没有则设置默认值
			if (StringUtils.isEmpty(pageNum)) {
				pageNum = "1";
			}
			LoanInvestPOJO loanInvestQueryVo = new LoanInvestPOJO();

			loanInvestQueryVo.setUser_id(user.getUserId());
			loanInvestQueryVo.setStatus(status);
			loanInvestQueryVo.setBusitype(busitype);
			List<LoanInvestListPOJO> InvestList = loanInvestmentServ.findloanInvestListByConditionAndNum1(loanInvestQueryVo,
					Integer.parseInt(pageNum));
			int totalNum = loanInvestmentServ.getcountInvestList1(loanInvestQueryVo);
			int totalPage = totalNum % 7 == 0 ? totalNum / 7 : totalNum / 7 + 1;
			// //获取累计收益
			// UserRecoverSumPOJO userRecoverSum = new UserRecoverSumPOJO();
			// userRecoverSum =recoverServ.findUserRecoverSumMap("1",
			// user.getUserId());//1指已还
			// if(userRecoverSum==null){
			// userRecoverSum = new UserRecoverSumPOJO();
			// userRecoverSum.setSumCapital(new BigDecimal("0"));
			// }
			// //获取待还金额和利息
			// UserRecoverSumPOJO userRecoverSum1 = new UserRecoverSumPOJO();
			// userRecoverSum1 =recoverServ.findUserRecoverSumMap("0",
			// user.getUserId());//0指未还
			// if(userRecoverSum1==null){
			// userRecoverSum1=new UserRecoverSumPOJO();
			// userRecoverSum1.setSumInterest(new BigDecimal("0"));
			// userRecoverSum1.setSumReceipts(new BigDecimal("0"));
			// }

			map.put("flag", "1");
			map.put("content", InvestList);
			map.put("totalPage", totalPage);
			// map.put("getSumCapital", userRecoverSum.getSumReceipts());//累计收益
			// map.put("getSumInterest",
			// userRecoverSum1.getSumInterest());//待还利息
			// map.put("getSumReceipts", userRecoverSum1.getSumCapital());//待还本金

			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}

	/**
	 * 前台我的债权详情入口
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("loanInvestRecoverInfo")
	@ResponseBody
	public Object loanInvestRecoverInfo(HttpSession session, String applyId, String investId, String pageNum,
			String pageSize) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
		// user = userServ.getUserByUserId(1000000112);
		// 定义返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		if (user != null) {
			if (StringUtils.isEmpty(pageNum)) {
				pageNum = "1";
			}
			if (StringUtils.isEmpty(pageSize)) {
				pageSize = "12";
			}
			// 判断当前页是否有值，没有则设置默认值
			LoanPOJO loan = loanApplyServ.findInvestmentById(Integer.parseInt(applyId));
			user = userServ.getUserByUserId(user.getUserId());
			LoanInvestPOJO loanInvestQueryVo = new LoanInvestPOJO();
			UserVO borUser = userServ.getUserByUserId(loan.getUserId());

			loanInvestQueryVo.setUser_id(user.getUserId());
			loanInvestQueryVo.setInvest_id(Integer.parseInt(investId));
			List<ApplyRecoverVO> RecoverList = recoverServ.findloanRecoverListByConditionAndNum(loanInvestQueryVo,
					Integer.parseInt(pageNum), Integer.parseInt(pageSize));
			int totalNum = recoverServ.getcountRecoverList(loanInvestQueryVo);

			// 获取 已还金额 逾期金额 待还金额

			int totalPage = totalNum % Integer.parseInt(pageSize) == 0 ? totalNum / Integer.parseInt(pageSize)
					: totalNum / Integer.parseInt(pageSize) + 1;
			map.put("flag", "1");
			map.put("orderNumber", loan.getOrderNumber());
			map.put("apr", loan.getApr());
			map.put("card_id", StringUtil.handleCardId(borUser.getCardId()));
			map.put("amount", loan.getAmount());
			map.put("purpose", loan.getPurpose());
			map.put("mobile", StringUtil.handlePhone(borUser.getMobile()));
			map.put("period", loan.getPeriod());
			map.put("realname", StringUtil.handleName(borUser.getRealname()));

			// 获取已还总金额
			UserRecoverSumPOJO userRecoverSum = new UserRecoverSumPOJO();
			userRecoverSum = recoverServ.findUserRecoverSumMap1("1", user.getUserId(), Integer.parseInt(investId));// 1指已还
			if (userRecoverSum == null) {
				userRecoverSum = new UserRecoverSumPOJO();
				userRecoverSum.setSumReceipts(new BigDecimal("0"));
			}
			// 获取待还总额
			UserRecoverSumPOJO userRecoverSum1 = new UserRecoverSumPOJO();
			userRecoverSum1 = recoverServ.findUserRecoverSumMap1("0", user.getUserId(), Integer.parseInt(investId));// 0指未还
			if (userRecoverSum1 == null) {
				userRecoverSum1 = new UserRecoverSumPOJO();
				userRecoverSum1.setSumReceipts(new BigDecimal("0"));
			}
			LoanInvestmentVO loanInvestment = loanInvestmentServ.selectLoanApplyByApplyId(Integer.parseInt(investId));

			map.put("getSumReceipts", userRecoverSum.getSumReceipts());
			map.put("getSumReceipts1", userRecoverSum1.getSumReceipts());
			map.put("getInvestMoney", loanInvestment.getMoney());
			map.put("content", RecoverList);
			map.put("totalPage", totalPage);
			return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}

}
