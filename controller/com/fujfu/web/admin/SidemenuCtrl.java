package com.fujfu.web.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.SidemenuVO;
import com.fujfu.service.admin.SidemenuServ;
import com.fujfu.web.BaseController;
@Controller
@RequestMapping("/admin/")
public class SidemenuCtrl extends BaseController {
	@Resource
	private SidemenuServ sitemenuServ;
	
	/**
	 * 后台网站目录入口
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("sitemenu/index")
	public String index(Page page,Model model){	
		Page sitemenuList = sitemenuServ.listAllsidemenu(page);
		model.addAttribute("sitemenuList", sitemenuList);
		return "/views/admin/sitemenuList.jsp";
	}
	
	
	/**
	 * 后台权限管理-新增
	 * @param model
	 * @param pid
	 * @param cssClass
	 * @param name
	 * @param url
	 * @param purviewFlag
	 * @param created
	 * @return
	 */
	@RequestMapping("sitemenu/add")
	public String add(Model model,String pid,String cssClass,String name,String url,String purviewFlag,String created){
		SidemenuVO sidemenu = new SidemenuVO();
		sidemenu.setPid(Integer.parseInt(pid));
		sidemenu.setCssClass(cssClass);
		sidemenu.setName(name);
		sidemenu.setUrl(url);
		sidemenu.setPurviewFlag(purviewFlag);
		sidemenu.setCreated(Integer.parseInt(created));
		
		int result = sitemenuServ.addSidemenu(sidemenu);
		if(result>0){
			model.addAttribute("msg","添加目录成功");
			return "views/admin/addPurview.jsp";
		}else{
			model.addAttribute("msg","添加目录失败");
			return "views/admin/sitemenuList.jsp";
		}	
	}
	
	/**
	 * 后台目录修改
	 * @param model
	 * @param pid
	 * @param cssClass
	 * @param name
	 * @param url
	 * @param purviewFlag
	 * @return
	 */
	@RequestMapping("sitemenu/update")
	public String update(Model model,String pid,String cssClass,String name,String url,String purviewFlag){	
		SidemenuVO sidemenu = new SidemenuVO();
		sidemenu.setPid(Integer.parseInt(pid));
		sidemenu.setCssClass(cssClass);
		sidemenu.setName(name);
		sidemenu.setUrl(url);
		sidemenu.setPurviewFlag(purviewFlag);
		
		int result = sitemenuServ.updateSidemenu(sidemenu);
		if(result>0){
			model.addAttribute("msg","修改目录成功");
			return "views/admin/updatePurview.jsp";
		}else{
			model.addAttribute("msg","修改目录失败");
			return "views/admin/sitemenuList.jsp";
		}			
	}
	
	/**
	 * 后台目录删除
	 * @param model
	 * @param sidebarId
	 * @return
	 */
	@RequestMapping("sitemenu/delete")
	public String delete(Model model,String sidebarId){	
		int result = sitemenuServ.delSidemenu(Integer.parseInt(sidebarId));
		if(result>0){
			model.addAttribute("msg","修改目录成功");
		}else{
			model.addAttribute("msg","删除目录失败");
		}		
		return "views/admin/sitemenuList.jsp";
	}

}
