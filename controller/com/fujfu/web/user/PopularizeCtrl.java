package com.fujfu.web.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.user.PopularizePOJO;
import com.fujfu.service.user.PopularizeServ;
import com.fujfu.web.BaseController;
@Controller
@RequestMapping("/popularize/")
public class PopularizeCtrl extends BaseController {

	private static final long serialVersionUID = 1L;
	@Resource
	private PopularizeServ popularizeServ;
	
	@RequestMapping("index")
	public String index(Page page, Model model, PopularizePOJO popularizeVo){
		Page popularizeList = popularizeServ.findPopularizeByCondition(popularizeVo, page);
		model.addAttribute("popularizeList", popularizeList);
		return "/views/user/popularizeList.jsp";
	}
	
	@RequestMapping("userIndex")
	public String userIndex(Page page, Model model, String inviterId){
		Page detailList = popularizeServ.findUsersByInviterId(Integer.parseInt(inviterId), page);
		model.addAttribute("inviterId",inviterId);
		model.addAttribute("detailList", detailList);
		return "/views/user/detailList.jsp";
	}

}
