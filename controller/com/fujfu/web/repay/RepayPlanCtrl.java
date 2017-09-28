package com.fujfu.web.repay;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujfu.pojo.apply.ApplyRepayPlanPOJO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.repay.RepayServ;
import com.fujfu.web.BaseController;

@Controller
public class RepayPlanCtrl extends BaseController {
	private static final long serialVersionUID = 1L;
	@Resource
	private RepayServ repayServ;

	@RequestMapping("getRepayPlan")
	@ResponseBody
	public Object getRepayPlan(HttpSession session,String applyId, String pageNum) {
		// 定义返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		UserVO userInf = (UserVO) getSession("user_inf");
		if (userInf != null) {
			// 判断当前页是否有值，没有则设置默认值
			if (StringUtils.isEmpty(pageNum)) {
				pageNum = "1";
			}
			if (StringUtils.isNotEmpty(applyId)) {
				List<ApplyRepayPlanPOJO> applyRecoverList = repayServ.findApplyRepayPlanByApplyId(applyId,Integer.parseInt(pageNum));
				List<ApplyRepayPlanPOJO> allApplyRepayList = repayServ.findAllApplyRepayPlanByApplyId(applyId);
				int totalNum = repayServ.countApplyRepayPlanByApplyId(applyId);
				int totalPage = totalNum % 8 == 0 ? totalNum / 8 : totalNum / 8 + 1;
				
				BigDecimal totalRepayed = new BigDecimal(0);// 总计已还
				BigDecimal toatlRepaying = new BigDecimal(0);// 总计待还
				for(ApplyRepayPlanPOJO av : allApplyRepayList){
					if(av.getStatus()==0){
						toatlRepaying = 
								toatlRepaying.add(
										av.getRepayCapital().add(av.getRepayInterest())
								);
					}else{
						totalRepayed = 
								totalRepayed.add(
										new BigDecimal(av.getRepayDoneCapital()).add(new BigDecimal(av.getRepayDoneInterest()))
								);
					}
				}

				map.put("flag", "1");
				map.put("content", applyRecoverList);
				map.put("totalPage", totalPage);
				map.put("totalRepayed", totalRepayed);
				map.put("toatlRepaying", toatlRepaying);
			}
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
		}
		return map;
	}
}
