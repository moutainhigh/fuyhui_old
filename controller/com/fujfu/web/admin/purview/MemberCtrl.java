package com.fujfu.web.admin.purview;

import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.AdminVO;
import com.fujfu.pojo.comuanda.AadminVO;
import com.fujfu.service.admin.AdminServ;
import com.fujfu.service.comuanda.AadminServ;
import com.fujfu.service.util.MD5Utils;
import com.fujfu.web.BaseController;
@Controller
@RequestMapping("/admin/")
public class MemberCtrl extends BaseController{
	private static final long serialVersionUID = 1L;
	@Resource
	private AdminServ adminServ;
	@Resource
	private AadminServ aadminServ;
	/**
	 * 后台用户管理入口
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("member/index")
	public String index(HttpServletRequest request, Page page, AdminVO admin, Model model) {
		/*boolean b = isPermissions.isPermissions(request);
		if (b) {*/
			Page adminList = adminServ.findAdminByCondition(admin, page);
			model.addAttribute("adminList", adminList);
			return "views/admin/purview/adminList.jsp";
		/*} else {
			model.addAttribute("msg","权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}*/
	}
	
	/**
	 * 进入添加界面
	 * @return
	 */
	@RequestMapping("member/enterAdd")
	public String enterAdd(HttpServletRequest request, Model model){
		/*boolean b = isPermissions.isPermissions(request);
		if(b){*/
			return "views/admin/purview/addAdmin.jsp";
		/*}else{
			model.addAttribute("msg","权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}*/
		
	}
	
	/**
	 * 后台用户管理-新增
	 * @param model
	 * @param username
	 * @param realname
	 * @param password
	 * @param created
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("member/add")
	public String add(HttpServletRequest request, Model model, AdminVO admin) throws ParseException {
//		boolean b = isPermissions.isPermissions(request);
		int created = DateUtil.getUnixTime();
		String defaultPassword = MD5Utils.MD5Encrypt("12345678");
//		if (b) {
			AadminVO aadmin = new AadminVO();
			aadmin.setPassword(defaultPassword);
			aadmin.setUsername(admin.getUsername());
			aadmin.setRealname(admin.getRealname());
			aadmin.setUniqid(admin.getUniqid());
			aadmin.setCreated(created);
			aadmin.setStatus(0);
			int result = aadminServ.addAadmin(aadmin);
			if (result > 0) {
				admin.setAdminId(aadmin.getAdminId());
				admin.setPassword(defaultPassword);
				admin.setCreated(created);
				admin.setStatus(0);
				adminServ.addAdmin(admin);
				model.addAttribute("msg", "添加管理员成功");
			} else {
				model.addAttribute("msg", "添加管理员失败");
			}
			return "redirect:/admin/member/index";
		/*} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}*/
	}
	
	/**
	 * 进入修改界面
	 * @return
	 */
	@RequestMapping("member/enterUpdate")
	public String enterUpdate(Model model, HttpServletRequest request) {
		/*boolean b = isPermissions.isPermissions(request);
		if (b) {*/
			int adminId = Integer.parseInt(request.getParameter("adminId"));
			AdminVO admin = adminServ.findAdminById(adminId);
			model.addAttribute("admin", admin);
			return "views/admin/purview/updateAdmin.jsp";
		/*} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}*/
	}
	
	/**
	 * 后台用户管理-修改
	 * @param model
	 * @param username
	 * @param realname
	 * @param password
	 * @return
	 */
	@RequestMapping("member/update")
	public String update(HttpServletRequest request, Model model, AdminVO admin) {
		/*boolean b = isPermissions.isPermissions(request);
		if (b) {*/
			int result = adminServ.updateAdmin(admin);
			if (result > 0) {
				AadminVO aadmin = new AadminVO();
				aadmin.setAdminId(admin.getAdminId());
				aadmin.setPassword(admin.getPassword());
				admin.setStatus(admin.getStatus());
				aadmin.setUsername(admin.getUsername());
				aadmin.setRealname(admin.getRealname());
				aadmin.setUniqid(admin.getUniqid());
				aadminServ.updateAadmin(aadmin);
				model.addAttribute("msg", "修改管理员成功");
			} else {
				model.addAttribute("msg", "修改管理员失败");
			}
			return "redirect:/admin/member/index";
		/*} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}*/
	}
	
	/**
	 * 后台用户管理-删除
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("member/delete")
	public String delete(Model model, HttpServletRequest request) {
		/*boolean b = isPermissions.isPermissions(request);
		if (b) {*/
			int adminId = Integer.parseInt(request.getParameter("adminId"));
			int result = adminServ.delAdmin(adminId);
			if (result > 0) {
				aadminServ.delAadmin(adminId);
				model.addAttribute("msg", "删除管理员成功");
			} else {
				model.addAttribute("msg", "删除管理员失败");
			}
			return "redirect:/admin/member/index";
		/*} else {
			model.addAttribute("msg", "权限不足");
			return PropertiesUtil.MESSAGE_URL;
		}*/
	}
}
