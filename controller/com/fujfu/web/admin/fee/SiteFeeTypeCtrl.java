package com.fujfu.web.admin.fee;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.fee.SiteFeeVO;
import com.fujfu.pojo.fee.SiteFeeTypeVO;
import com.fujfu.pojo.fee.SiteFeeTypePOJO;
import com.fujfu.pojo.loan.LoanTypeVO;
import com.fujfu.service.fee.SiteFeeServ;
import com.fujfu.service.loan.LoanTypeServ;
import com.fujfu.web.BaseController;
import com.fujfu.web.constant.FeeProperties;

@Controller
@RequestMapping("/siteFeeType/")
public class SiteFeeTypeCtrl extends BaseController{
	private static final long serialVersionUID = 1L;
	@Resource
	private SiteFeeServ siteFeeServ;
	@Resource
	private LoanTypeServ loanTypeServ;
	
	/**
	 * 列出所有收费信息
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("siteFeeTypeList")
	public String siteFeeList(Page page,Model model){	
		Page siteFeeTypePageList = siteFeeServ.listAllSiteFeeTypeVo(page);
		List<SiteFeeTypePOJO> feeTypeVoList = siteFeeTypePageList.getItems();
		for(SiteFeeTypePOJO siteFeeTypeVo : feeTypeVoList){
			String chargeTime = FeeProperties.DROPDOWN_CHARGE_TIME.get(siteFeeTypeVo.getChargeTime());
			siteFeeTypeVo.setChargeTime(chargeTime);
		}
		model.addAttribute("siteFeeTypeList", siteFeeTypePageList);
		return "views/admin/fee/siteFeeTypeList.jsp";
	}
	/**
	 * 进入到收费添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("enterAdd")
	public String enterAdd(Model model){
		List<LoanTypeVO> loanTypeList = loanTypeServ.listAllLoanType();
		List<SiteFeeVO> siteFeeList = siteFeeServ.listAllSiteFee();
		// 收费项目
		model.addAttribute("loanTypeList", loanTypeList);
		// 收费方式
		model.addAttribute("formulaTypeList", FeeProperties.DROPDOWN_FORMULA_TYPE);
		// 所有费用
		model.addAttribute("siteFeeList", siteFeeList);
		// 用户类型
		model.addAttribute("userTypeList", FeeProperties.USER_TYPE);

		return "views/admin/fee/addSiteFeeType.jsp";
	}
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping("add")
	public String add(Model model, SiteFeeTypeVO siteFeeType) {
		if (siteFeeServ.isContainFeeChargeMode(siteFeeType.getChargeItem(), siteFeeType.getChargeFeeId(),
				siteFeeType.getUserType())) {
			model.addAttribute("msg", "已存在相同的收费方式,请勿重复添加！");
		} else {
			siteFeeType.setCreated(DateUtil.getUnixTime());
			int result = siteFeeServ.addSiteFeeType(siteFeeType);
			if (result > 0) {
				model.addAttribute("msg", "添加成功");
			} else {
				model.addAttribute("msg", "添加失败");
			}

		}
		return "redirect:/siteFeeType/siteFeeTypeList";
	}
	/**
	 * 进入到收费修改页面
	 * @param model
	 * @return
	 */
	@RequestMapping("enterUpdate")
	public String enterUpdate(Model model,HttpServletRequest request){
		int chargeTypeId = Integer.parseInt(request.getParameter("id"));
		SiteFeeTypeVO siteFeeType = siteFeeServ.findSiteFeeTypeById(chargeTypeId);
		List<LoanTypeVO> loanTypeList = loanTypeServ.listAllLoanType();
		List<SiteFeeVO> siteFeeList = siteFeeServ.listAllSiteFee();
		model.addAttribute("loanTypeList", loanTypeList);
		model.addAttribute("siteFeeList", siteFeeList);
		model.addAttribute("siteFeeType", siteFeeType);
		model.addAttribute("formulaTypeList", FeeProperties.DROPDOWN_FORMULA_TYPE);
		model.addAttribute("userTypeList", FeeProperties.USER_TYPE);
		return "views/admin/fee/updateSiteFeeType.jsp";
	}
	/**
	 * 修改
	 * @return
	 */
	@RequestMapping("update")
	public String update(Model model,SiteFeeTypeVO siteFeeType){
			if(siteFeeType.getFormulaType()==1){
				siteFeeType.setAmount(null);
			}else{
				siteFeeType.setInterestRate(null);
			}
			int result = siteFeeServ.updateSiteFeeType(siteFeeType);
			if(result>0){
				model.addAttribute("msg","修改成功");
			}else{
				model.addAttribute("msg","修改失败");
			}	
			return "redirect:/siteFeeType/siteFeeTypeList";
	}
	/**
	 * 收费删除
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(Model model,HttpServletRequest request){	
		int chargeTypeId = Integer.parseInt(request.getParameter("id"));
		int result = siteFeeServ.delSiteFeeType(chargeTypeId);
		if(result>0){
			model.addAttribute("msg","删除成功");
		}else{
			model.addAttribute("msg","删除失败");
		}		
		return "redirect:/siteFeeType/siteFeeTypeList";
	}
}
