package com.fujfu.web.admin.payforlist;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.user.PayForListPOJO;
import com.fujfu.service.repay.UserPayForListServ;
import com.fujfu.web.BaseController;



@Controller
@RequestMapping("/user/")
public class PayForListCtrl  extends BaseController{
	
	/**
	 * 查询担保商垫资列表
	 */

	private static final long serialVersionUID = 1L;

	@Resource
	UserPayForListServ userPayForList;	
	
	@RequestMapping("payfor")
	public String searchPayForList(Page page, PayForListPOJO payForListQueryVo, Model model){
		
		System.out.println("查询开始。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
		
		//Page userPayForList = userPayForList.;
		Page paforList = userPayForList.findPayForListByCondition(payForListQueryVo, page);
		model.addAttribute("userPayForList", paforList);
		model.addAttribute("payForListQueryVo",payForListQueryVo);
		if (paforList.getItems().size() == 0){
			model.addAttribute("msg","查无记录，请重新输入查询条件");
		}
		return "views/admin/repay/userPayForList.jsp";
	}
	
}
