package com.fujfu.web.admin.purview;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.PurviewVO;
import com.fujfu.service.admin.PurviewServ;
import com.fujfu.web.BaseController;
@Controller
@RequestMapping("/admin/")
public class PurviewCtrl extends BaseController {
	private static final long serialVersionUID = 1L;
	@Resource
	private PurviewServ purviewServ;
	/**
	 * 后台权限管理入口
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("purview/index")
	public String index(Page page,PurviewVO purview,Model model){	
		Page purviewList = purviewServ.findPurviewByCondition(purview, page);
		model.addAttribute("purviewList", purviewList);
		return "views/admin/purview/purviewList.jsp";
	}
	
	/**
	 * 进入添加界面
	 * @return
	 */
	@RequestMapping("purview/enterAdd")
	public String enterAdd(){
		return "views/admin/purview/addPurview.jsp";
	}
	
	/**
	 * 后台权限管理-新增
	 * @param model
	 * @param username
	 * @param realname
	 * @param password
	 * @param created
	 * @return
	 */
	@RequestMapping("purview/add")
	public String add(Model model,PurviewVO purview){
		purview.setCreated(DateUtil.getUnixTime());
		int result = purviewServ.addPurview(purview);
		if(result>0){
			model.addAttribute("msg","添加权限成功");
		}else{
			model.addAttribute("msg","添加权限失败");
		}	
		return "redirect:/admin/purview/index";
	}
	/**
	 * 进入修改界面
	 * @return
	 */
	@RequestMapping("purview/enterUpdate")
	public String enterUpdate(Model model,HttpServletRequest request){
		int purviewId = Integer.parseInt(request.getParameter("purviewId"));
		PurviewVO purview = purviewServ.findPurviewById(purviewId);
		model.addAttribute("purview", purview);
		return "views/admin/purview/updatePurview.jsp";
	}
	/**
	 * 后台权限管理-修改
	 * @param model
	 * @param username
	 * @param realname
	 * @param password
	 * @return
	 */
	@RequestMapping("purview/update")
	public String update(Model model,PurviewVO purview){	
		int result = purviewServ.updatePurview(purview);
		if(result>0){
			model.addAttribute("msg","修改权限成功");
		}else{
			model.addAttribute("msg","修改权限失败");
		}			
		return "redirect:/admin/purview/index";
	}
	
	/**
	 * 后台权限管理-删除
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("purview/delete")
	public String delete(Model model, HttpServletRequest request){
		int purviewId = Integer.parseInt(request.getParameter("purviewId"));
		int result = purviewServ.delPurview(purviewId);
		if(result>0){
			model.addAttribute("msg","删除权限成功");
		}else{
			model.addAttribute("msg","删除权限失败");
		}		
		return "redirect:/admin/purview/index";
	}
}
