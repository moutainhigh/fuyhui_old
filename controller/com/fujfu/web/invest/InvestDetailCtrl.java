package com.fujfu.web.invest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujfu.common.util.StringUtil;
import com.fujfu.pojo.invest.InvestRecordPOJO;
import com.fujfu.pojo.loan.LoanPOJO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.invest.LoanInvestmentServ;
import com.fujfu.service.loan.LoanApplyServ;
import com.fujfu.web.BaseController;

@Controller
@RequestMapping("/invest/")
public class InvestDetailCtrl extends BaseController {

	private static final long serialVersionUID = 1L;
	@Resource
	private LoanApplyServ loanApplyServ;
	@Resource
	private LoanInvestmentServ loanInvestmentServ;
	@Resource
	private UserAccountServ userAccountServ;
	
	/**
	 * 进入标的详情页
	 * @return
	 */
	@RequestMapping("/enterInvestDetail")
	public String enterInvestDetail(String id,HttpSession session,Model model) {
		if(StringUtils.isNotEmpty(id)){
			LoanPOJO investment = loanApplyServ.findInvestmentById(Integer.parseInt(id));
			investment.setApr(StringUtil.handleApr(investment.getApr()));//預計年化收益小數位調整
			UserVO user = (UserVO) session.getAttribute("user_inf");
			if(user!=null && userAccountServ.selectByUserId(user.getUserId())!=null){
				model.addAttribute("balance",userAccountServ.selectByUserId(user.getUserId()).getCash());
			}
			model.addAttribute("investment", investment);
		}
		return "views/invest/investDetail.jsp";
	}

	/**
	 * 进入标的详情页
	 * @return
	 */
	@RequestMapping("/enterKumquatDetail")
	public String enterKumquatDetail(String id,HttpSession session,Model model) {
		if(StringUtils.isNotEmpty(id)){
			LoanPOJO investment = loanApplyServ.findInvestmentById(Integer.parseInt(id));
			investment.setApr(StringUtil.handleApr(investment.getApr()));//預計年化收益小數位調整
			UserVO user = (UserVO) session.getAttribute("user_inf");
			if(user!=null && userAccountServ.selectByUserId(user.getUserId())!=null){
				model.addAttribute("balance",userAccountServ.selectByUserId(user.getUserId()).getCash());
			}
			model.addAttribute("investment", investment);
		}
		return "views/kumquat/kumquatDetail.jsp";
	}
	/**
	 * 投资记录接口
	 * @param applyId
	 * @param pageNum
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/investRecord")
	public Object investRecord(String applyId,String pageNum){
		// 定义返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		// 判断当前页是否有值，没有则设置默认值
		if (StringUtils.isEmpty(pageNum)) {
			pageNum = "1";
		}
		if(StringUtils.isNotEmpty(applyId)){
			List<InvestRecordPOJO> loanInvestmentList = loanInvestmentServ.findInvestByApplyIdAndNum(applyId,Integer.parseInt(pageNum));
			int totalNum = loanInvestmentServ.countInvestRecodByApplyId(applyId);
			int totalPage =  totalNum%10==0 ? totalNum/10 : totalNum/10 +1;
			map.put("flag", "1");
			map.put("content", loanInvestmentList);
			map.put("totalPage",totalPage);
		}
		return map;
	}
}
