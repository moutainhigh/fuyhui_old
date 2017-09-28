package com.fujfu.web.admin.news;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.news.NewsCategoryVO;
import com.fujfu.pojo.news.NewsCategoryPOJO;
import com.fujfu.service.news.NewsCategoryServ;
import com.fujfu.web.BaseController;

@Controller
@RequestMapping("/newsCategory/")
public class NewsCategoryCtrl extends BaseController {
	private static final long serialVersionUID = 1L;
	@Resource
	private NewsCategoryServ newsCategoryServ;
	
	/**进入列表界面
	 */
	@RequestMapping("index")
	public String index(String name, Page page,String startTime,String endTime, Model model) {
		NewsCategoryVO newsCategory = new NewsCategoryVO();
		if (StringUtils.isNotEmpty(name)) {
			newsCategory.setName(name);
		}
 		Page newsCategoryList = newsCategoryServ.findNewsCategoryByCondition(newsCategory, page);
		model.addAttribute("newsCategoryList", newsCategoryList);
		return "views/admin/news/newsCategoryList.jsp";
	}
	
	/**
	 * 进入添加界面
	 */
	@RequestMapping("enterAdd")
	public String enterAdd(Model model){
		List<NewsCategoryPOJO> newsCategoryNameList= newsCategoryServ.listAllNewsCategory();
		model.addAttribute("newsCategoryNameList", newsCategoryNameList);
		return "views/admin/news/addNewsCategory.jsp";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("add")
	public String add(Model model,NewsCategoryVO newsCategory){
		newsCategory.setCreated(DateUtil.getUnixTime());
		int result = newsCategoryServ.addNewsCategory(newsCategory);
		if(result>0){
			model.addAttribute("msg","添加类别成功");
		}else{
			model.addAttribute("msg","添加类别失败");
		}	
		return "redirect:/newsCategory/index";
	}
	
	/**
	 * 进入修改界面
	 */
	@RequestMapping("enterUpdate")
	public String enterUpdate(Model model,String id){
		NewsCategoryPOJO newsCategory = newsCategoryServ.findNewsCategoryById(new Short(id));
		model.addAttribute("newsCategory", newsCategory);
		return "views/admin/news/updateNewsCategory.jsp";
	}
	
	@RequestMapping("listAllNewsCategory")
	@ResponseBody
	public List<NewsCategoryPOJO> listAllNewsCategory(){
		List<NewsCategoryPOJO> newsCategoryList= newsCategoryServ.listAllNewsCategory();
		return newsCategoryList;
	}
	
	/**
	 * 更新
	 */
	@RequestMapping("update")
	public String update(Model model,NewsCategoryVO newsCategory){	
		int result = newsCategoryServ.updateNewsCategory(newsCategory);
		if(result>0){
			model.addAttribute("msg","修改类别成功");
		}else{
			model.addAttribute("msg","修改类别失败");
		}			
		return "redirect:/newsCategory/index";
	}
	
	/**
	 * 逻辑删除
	 */
	@RequestMapping("delete")
	public String delete(Model model,String id){	
		NewsCategoryVO newsCategory = new NewsCategoryVO();
		newsCategory.setId(new Short(id));
		newsCategory.setStatus((short)-1);
		int result = newsCategoryServ.updateNewsCategory(newsCategory);
		if(result>0){
			model.addAttribute("msg","删除权限成功");
		}else{
			model.addAttribute("msg","删除权限失败");
		}			
		return "redirect:/newsCategory/index";
	}
	
	/**
	 * 审核通过
	 */
	@RequestMapping("changeStatus")
	public String changeStatus(Model model,String id){	
		NewsCategoryVO newsCategory = new NewsCategoryVO();
		newsCategory.setId(new Short(id));
		newsCategory.setStatus((short)1);
		int result = newsCategoryServ.updateNewsCategory(newsCategory);
		if(result>0){
			model.addAttribute("msg","审核已通过");
		}else{
			model.addAttribute("msg","审核通过失败");
		}			
		return "redirect:/newsCategory/index";
	}
}
