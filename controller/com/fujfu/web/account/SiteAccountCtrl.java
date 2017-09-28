package com.fujfu.web.account;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.common.util.tag.Page;
import com.fujfu.service.account.SiteAccountLogServ;
import com.fujfu.service.account.SiteAccountServ;
import com.fujfu.web.BaseController;

@Controller
@RequestMapping("/siteAccount/")
public class SiteAccountCtrl extends BaseController{
	private static final long serialVersionUID = 1L;
	@Resource
	private SiteAccountLogServ siteAccountLogServ;
	@Resource
	private SiteAccountServ siteAccountServ;
	@RequestMapping("siteAccountIndex")
	public String siteAccountIndex(Page page,Model model){
		Page siteAccountList = siteAccountServ.findSiteAccount(page);
		model.addAttribute("siteAccountList", siteAccountList);
		return "views/admin/account/siteAccountList.jsp";
	}
	
	@RequestMapping("siteAccountLogIndex")
	public String siteAccountLogIndex(Page page,Model model,String feeId){
		Page siteAccountLogList = siteAccountLogServ.findSiteAccountLog(Integer.parseInt(feeId),page);
		model.addAttribute("feeId",feeId);
		model.addAttribute("siteAccountLogList", siteAccountLogList);
		return "views/admin/account/siteAccountLogList.jsp";
	}
}
