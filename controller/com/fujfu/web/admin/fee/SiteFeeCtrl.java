package com.fujfu.web.admin.fee;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.SiteAccountVO;
import com.fujfu.pojo.fee.SiteFeeVO;
import com.fujfu.service.account.SiteAccountServ;
import com.fujfu.service.fee.SiteFeeServ;
import com.fujfu.web.BaseController;
import com.fujfu.web.constant.FeeProperties;

@Controller
@RequestMapping("/siteFee/")
public class SiteFeeCtrl extends BaseController{
	private static final long serialVersionUID = 1L;
	@Resource
	private SiteFeeServ siteFeeServ;
	@Resource
	private SiteAccountServ siteAccountServ;
	
	/**
	 * 列出所有费用信息
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("siteFeeList")
	public String siteFeeList(Page page,Model model){	
		Page siteFeePageList = siteFeeServ.listAllSiteFee(page);
		List<SiteFeeVO> feeList = siteFeePageList.getItems();
		for(SiteFeeVO siteFee : feeList){
			String feeBase = FeeProperties.DROPDOWN_FEE_BASE.get(siteFee.getFeeBase());
			siteFee.setFeeBase(feeBase);
		}
		model.addAttribute("siteFeeList", siteFeePageList);
		return "views/admin/fee/siteFeeList.jsp";
	}
	/**
	 * 进入到费用添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("enterAdd")
	public String add(Model model){
		// 费用名
		model.addAttribute("feeList", FeeProperties.FEE);
		return "views/admin/fee/addSiteFee.jsp";
	}
	
	/**
	 * 费用新增
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("add")
	@Transactional
	public String add(Model model,SiteFeeVO siteFee) throws ParseException{
		siteFee.setCreated(DateUtil.getUnixTime());
		if(siteFeeServ.isContainFeeName(siteFee.getFeeName())){
			model.addAttribute("msg","请勿重复添加该费用！");
		}else{
			int result = siteFeeServ.addSiteFee(siteFee);
			// 初始化siteAccount表
			SiteAccountVO siteAccount = new SiteAccountVO();
			siteAccount.setFeeId(siteFee.getFeeId()+"");
			siteAccount.setName(siteFee.getFeeName());
			siteAccount.setCreated(DateUtil.getUnixTime());
			int result2 = siteAccountServ.addSiteAccount(siteAccount);
			if(result>0 && result2>0){
				model.addAttribute("msg","添加成功");
			}else{
				model.addAttribute("msg","添加失败");
			}
		}	
		return "redirect:/siteFee/siteFeeList";
	}
	/**
	 * 进入到费用修改页面
	 * @param model
	 * @return
	 */
	@RequestMapping("enterUpdate")
	public String enterUpdate(Model model,String feeId,HttpServletRequest request){
		SiteFeeVO siteFee = siteFeeServ.findSiteFeeById(Integer.parseInt(feeId));
		model.addAttribute("siteFee", siteFee);
		return "views/admin/fee/updateSiteFee.jsp";
	}
	
	/**
	 * 费用修改
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("update")
	public String update(Model model,SiteFeeVO siteFee) throws ParseException{
		int result = siteFeeServ.updateSiteFee(siteFee);
		if(result>0){
			model.addAttribute("msg","修改成功");
		}else{
			model.addAttribute("msg","修改失败");
		}	
		return "redirect:/siteFee/siteFeeList";
	}
	/**
	 * 费用删除
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(Model model,String feeId,HttpServletRequest request){	
		int result = siteFeeServ.delSiteFee(Integer.parseInt(feeId));
		if(result>0){
			model.addAttribute("msg","删除成功");
		}else{
			model.addAttribute("msg","删除失败");
		}		
		return "redirect:/siteFee/siteFeeList";
	}
}
