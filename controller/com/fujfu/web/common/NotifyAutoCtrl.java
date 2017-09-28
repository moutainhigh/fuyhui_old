package com.fujfu.web.common;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.common.NotifyAutoVO;
import com.fujfu.service.common.NotifyAutoServ;
import com.fujfu.web.BaseController;
import com.fujfu.web.constant.FeeProperties;
@Controller
@RequestMapping("/notifyAuto/")
public class NotifyAutoCtrl extends BaseController {
	private static final long serialVersionUID = 1L;
	@Resource
	private NotifyAutoServ notifyAutoServ;
	
	/**进入列表界面
	 */
	@RequestMapping("index")
	public String index(String name,Page page, Model model){
		NotifyAutoVO notifyAuto = new NotifyAutoVO();
		if (StringUtils.isNotEmpty(name)) {
			notifyAuto.setName(name);
		}
		Page notifyAutoList = notifyAutoServ.findNotifyAutoByCondition(notifyAuto, page);
		model.addAttribute("notifyAutoList", notifyAutoList);
		return "/views/admin/message/notifyAutoList.jsp";
	}
	
	/**
	 * 进入添加界面
	 */
	@RequestMapping("enterAdd")
	public String enterAdd(Model model){
		// 通知时间点
		model.addAttribute("sendTimeList", FeeProperties.NOTIFY_TIME);
		return "views/admin/message/addNotifyAuto.jsp";
	}
	
	/**
	 * 添加
	 * @return 
	 */
	@RequestMapping("add")
	public String add(Model model,NotifyAutoVO notifyAuto){
		notifyAuto.setCtime(DateUtil.getUnixTime());
		int result = notifyAutoServ.addNotifyAuto(notifyAuto);
		if(result>0){
			model.addAttribute("msg","添加模板信息成功");
		}else{
			model.addAttribute("msg","添加模板信息失败");
		}	
		return "redirect:/notifyAuto/index";
	}
	/**
	 * 进入修改界面
	 */
	@RequestMapping("enterUpdate")
	public String enterUpdate(Model model,String id){
		NotifyAutoVO notifyAuto = notifyAutoServ.findNotifyAutoById(Integer.parseInt(id));
		// 通知时间点
		model.addAttribute("sendTimeList", FeeProperties.NOTIFY_TIME);
		model.addAttribute("notifyAuto", notifyAuto);
		return "views/admin/message/updateNotifyAuto.jsp";
	}
	
	/**
	 * 修改
	 * @return 
	 */
	@RequestMapping("update")
	public String update(Model model,NotifyAutoVO notifyAuto){
		int result = notifyAutoServ.updateNotifyAuto(notifyAuto);
		if(result>0){
			model.addAttribute("msg","修改模板信息成功");
		}else{
			model.addAttribute("msg","修改模板信息失败");
		}	
		return "redirect:/notifyAuto/index";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public String delete(Model model,String id){
		int result = notifyAutoServ.delNotifyAutoById(Integer.parseInt(id));
		if(result>0){
			model.addAttribute("msg","删除模板信息成功");
		}else{
			model.addAttribute("msg","删除模板信息失败");
		}	
		return "redirect:/notifyAuto/index";
	}
}
