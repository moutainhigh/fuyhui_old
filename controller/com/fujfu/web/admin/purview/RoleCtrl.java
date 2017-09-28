package com.fujfu.web.admin.purview;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.AdminVO;
import com.fujfu.pojo.admin.PurviewVO;
import com.fujfu.pojo.admin.RoleVO;
import com.fujfu.pojo.admin.RoleAdminVO;
import com.fujfu.pojo.admin.RoleAdminPOJO;
import com.fujfu.pojo.admin.RolePurviewVO;
import com.fujfu.pojo.admin.RolePurviewPOJO;
import com.fujfu.service.admin.AdminServ;
import com.fujfu.service.admin.PurviewServ;
import com.fujfu.service.admin.RoleServ;
import com.fujfu.web.BaseController;
@Controller
@RequestMapping("/admin/")
public class RoleCtrl extends BaseController {
	private static final long serialVersionUID = 1L;
	@Resource
	private RoleServ roleServ;
	@Resource
	private PurviewServ purviewServ;
	@Resource
	private AdminServ adminServ;
	
	/**
	 * 后台角色管理入口
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("role/index")
	public String index(Page page,RoleVO role,Model model){	
		Page roleList = roleServ.findRoleByCondition(role,page);
		model.addAttribute("roleList", roleList);
		return "views/admin/purview/roleList.jsp";
	}
	
	/**
	 * 进入添加界面
	 * @return
	 */
	@RequestMapping("role/enterAdd")
	public String enterAdd(){
		return "views/admin/purview/addRole.jsp";
	}
	
	/**
	 * 后台角色管理-新增
	 * @param model
	 * @param username
	 * @param realname
	 * @param password
	 * @param created
	 * @return
	 */
	@RequestMapping("role/add")
	public String add(Model model,RoleVO role){
		role.setCreated(DateUtil.getUnixTime());
		int result = roleServ.addRole(role);
		if(result>0){
			model.addAttribute("msg","添加角色成功");
		}else{
			model.addAttribute("msg","添加角色失败");
		}	
		return "redirect:/admin/role/index";
	}
	
	/**
	 * 进入修改界面
	 * @return
	 */
	@RequestMapping("role/enterUpdate")
	public String enterUpdate(Model model,HttpServletRequest request){
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		RoleVO role = roleServ.findRoleById(roleId);
		model.addAttribute("role", role);
		return "views/admin/purview/updateRole.jsp";
	}
	
	/**
	 * 后台角色管理-修改
	 * @param model
	 * @param username
	 * @param realname
	 * @param password
	 * @return
	 */
	@RequestMapping("role/update")
	public String update(Model model,RoleVO role){	
		int result = roleServ.updateRole(role);
		if(result>0){
			model.addAttribute("msg","修改角色成功");
		}else{
			model.addAttribute("msg","修改角色失败");
		}			
		return "redirect:/admin/role/index";
	}
	
	/**
	 * 后台角色管理-删除
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("role/delete")
	public String delete(Model model, HttpServletRequest request){
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		int result = roleServ.delAdmin(roleId);
		if(result>0){
			model.addAttribute("msg","删除角色成功");
		}else{
			model.addAttribute("msg","删除角色失败");
		}		
		return "redirect:/admin/role/index";
	}
	
	/**>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
	/**
	 * 进入管理员角色查询界面
	 * @return
	 */
	@RequestMapping("roleAdmin/listRoleAdmin")
	public String enterListRoleAdmin(Page page,Model model,HttpServletRequest request){
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		Page roleAdminList = roleServ.findRoleByAdminId(adminId, page);
		model.addAttribute("roleAdminList", roleAdminList);
		model.addAttribute("adminId", adminId);
		return "views/admin/purview/roleAdminList.jsp";
	}
	
	/**
	 * 进入管理员角色新增界面
	 * @return
	 */
	@RequestMapping("roleAdmin/enterAdd")
	public String enterRoleAdminAdd(Model model,String adminId){
		List<RoleVO> roleList = roleServ.findNotOwnRoleByAdminId(Integer.parseInt(adminId));
		AdminVO admin = adminServ.findAdminById(Integer.parseInt(adminId));
		model.addAttribute("roleList", roleList);
		model.addAttribute("admin", admin);
		return "views/admin/purview/addRoleAdmin.jsp";
	}
	
	/**
	 * 新增管理员角色
	 * @param model
	 * @param page
	 * @param id
	 * @param adminId
	 * @param roleId
	 * @return
	 */
	@RequestMapping("roleAdmin/add")
	public String roleAdminAdd(Model model,Page page,RoleAdminVO roleAdmin){
		String msg = "";
		roleAdmin.setCreated(DateUtil.getUnixTime());
		int result = roleServ.addRoleAdmin(roleAdmin);
		if(result>0){
			msg = "添加管理员角色成功";
		}else{
			msg = "添加管理员角色失败";
		}	
		Page roleAdminList = roleServ.findRoleByAdminId(roleAdmin.getAdminId(), page);
		model.addAttribute("msg", msg);
		model.addAttribute("adminId", roleAdmin.getAdminId());
		model.addAttribute("roleAdminList", roleAdminList);
		return "views/admin/purview/roleAdminList.jsp";
	}
	
	/**
	 * 进入管理员角色修改界面
	 * @return
	 */
	@RequestMapping("roleAdmin/enterUpdate")
	public String enterRoleAdmiUpdate(Model model,String id){
		RoleAdminPOJO roleAdminVo = roleServ.findRoleAdminVoById(Integer.parseInt(id));
		model.addAttribute("roleAdminVo", roleAdminVo);
		return "views/admin/purview/updateRoleAdmin.jsp";
	}
	
	/**
	 * 修改管理员角色
	 * @param model
	 * @param page
	 * @param id
	 * @param adminId
	 * @param roleId
	 * @return
	 */
	@RequestMapping("roleAdmin/update")
	public String roleAdminUpdate(Model model,Page page,RoleAdminVO roleAdmin){
		String msg = "";
		int result = roleServ.updateRoleAdmin(roleAdmin);
		if(result>0){
			msg = "修改管理员角色成功";
		}else{
			msg = "修改管理员角色失败";
		}
		Page roleAdminList = roleServ.findRoleByAdminId(roleAdmin.getAdminId(), page);
		model.addAttribute("msg", msg);
		model.addAttribute("roleAdminList", roleAdminList);
		return "views/admin/purview/roleAdminList.jsp";
	}
	
	/**
	 * 后台管理员角色-删除
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("roleAdmin/delete")
	public String roleAdminDelete(Model model,Page page,String id,String adminId){
		String msg = "";
		int result = roleServ.delRoleAdmin(Integer.parseInt(id));
		if(result>0){
			msg = "删除管理员角色成功";
		}else{
			msg = "删除管理员角色失败";
		}
		Page roleAdminList = roleServ.findRoleByAdminId(Integer.parseInt(adminId), page);
		model.addAttribute("msg", msg);
		model.addAttribute("roleAdminList", roleAdminList);
		model.addAttribute("adminId", adminId);
		return "views/admin/purview/roleAdminList.jsp";
	}
	
	@RequestMapping("roleAdmin/findNotOwnRoleByAdminId")
	@ResponseBody
	public List<RoleVO> findAllRole(HttpServletRequest request){
		String adminId = request.getParameter("adminId");
		List<RoleVO> roleList = roleServ.findNotOwnRoleByAdminId(Integer.parseInt(adminId));
		return roleList;
	}
	
	/**>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
	/**>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
	/**
	 * 进入角色权限查询界面
	 * @return
	 */
	@RequestMapping("rolePurview/listRolePurview")
	public String enterListRolePurview(Page page,Model model,HttpServletRequest request){
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		Page rolePurviewList = roleServ.findPurviewByRoleId(roleId, page);
		model.addAttribute("rolePurviewList", rolePurviewList);
		model.addAttribute("roleId", roleId);
		return "views/admin/purview/rolePurviewList.jsp";
	}
	
	/**
	 * 进入角色权限新增界面
	 * @return
	 */
	@RequestMapping("rolePurview/enterAdd")
	public String enterRolePurviewAdd(Model model,String roleId){
		List<PurviewVO> purviewList = purviewServ.findNotOwnPurviewByRoleId(Integer.parseInt(roleId));
		RoleVO role = roleServ.findRoleById(Integer.parseInt(roleId));
		model.addAttribute("roleId", roleId);
		model.addAttribute("purviewList", purviewList);
		model.addAttribute("role", role);
		return "views/admin/purview/addRolePurview.jsp";
	}
	
	/**
	 * 新增角色权限
	 * @param model
	 * @param page
	 * @param id
	 * @param adminId
	 * @param roleId
	 * @return
	 */
	@RequestMapping("rolePurview/add")
	public String rolePurviewAdd(Model model,Page page,RolePurviewVO rolePurview){
		rolePurview.setCreated(DateUtil.getUnixTime());
		int result = roleServ.addRolePurview(rolePurview);
		if(result>0){
			model.addAttribute("msg","添加角色权限成功");
		}else{
			model.addAttribute("msg","添加角色权限失败");
		}	
		Page rolePurviewList = roleServ.findPurviewByRoleId(rolePurview.getRoleId(), page);
		model.addAttribute("rolePurviewList", rolePurviewList);
		model.addAttribute("roleId", rolePurview.getRoleId());
		return "views/admin/purview/rolePurviewList.jsp";
	}
	
	/**
	 * 进入角色权限修改界面
	 * @return
	 */
	@RequestMapping("rolePurview/enterUpdate")
	public String enterRolePurviewUpdate(Model model,String id){
		RolePurviewPOJO rolePurviewVo = roleServ.findRolePurviewVoById(Integer.parseInt(id));
		model.addAttribute("rolePurviewVo", rolePurviewVo);
		return "views/admin/purview/updateRolePurview.jsp";
	}
	
	/**
	 * 修改角色权限
	 * @param model
	 * @param page
	 * @param id
	 * @param adminId
	 * @param roleId
	 * @return
	 */
	@RequestMapping("rolePurview/update")
	public String rolePurviewUpdate(Model model,Page page,RolePurviewVO rolePurview){
		int result = roleServ.updateRolePurview(rolePurview);
		if(result>0){
			model.addAttribute("msg","修改角色权限成功");
		}else{
			model.addAttribute("msg","修改角色权限失败");
		}
		Page rolePurviewList = roleServ.findPurviewByRoleId(rolePurview.getRoleId(), page);
		model.addAttribute("rolePurviewList", rolePurviewList);
		return "views/admin/purview/rolePurviewList.jsp";
	}
	
	/**
	 * 后台角色权限-删除
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("rolePurview/delete")
	public String rolePurviewDelete(Model model,Page page,String id,String roleId){	
		int result = roleServ.delRolePurview(Integer.parseInt(id));
		if(result>0){
			model.addAttribute("msg","删除角色权限成功");
		}else{
			model.addAttribute("msg","删除角色权限失败");
		}
		Page rolePurviewList = roleServ.findPurviewByRoleId(Integer.parseInt(roleId), page);
		model.addAttribute("rolePurviewList", rolePurviewList);
		model.addAttribute("roleId", roleId);
		return "views/admin/purview/rolePurviewList.jsp";
	}
	
	/**
	 * 根据roleId查询该角色未拥有的权限
	 * @return
	 */
	@RequestMapping("rolePurview/findNotOwnPurviewByRoleId")
	@ResponseBody
	public List<PurviewVO> findAllPurview(HttpServletRequest request){
		String roleId = request.getParameter("roleId");
		List<PurviewVO> purviewList = purviewServ.findNotOwnPurviewByRoleId(Integer.parseInt(roleId));
		return purviewList;
	}
}
