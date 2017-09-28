package com.fujfu.web.admin.gat;


import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.gat.GatApproveMapper;
import com.fujfu.pojo.gat.GatApproveVO;
import com.fujfu.service.gat.GatApproveSer;


@Controller
@RequestMapping("/gat/")
public class GatCtrl{

	
	private static final long serialVersionUID = 1L;
	@Resource
	GatApproveMapper gatApproveMapper;	
	
	@Resource
	GatApproveSer gatApproveSer;		
	

	
	
	@RequestMapping("searchGatList")	
	public String searchGatList(Page page,Model model,String mobile,String first,String approveStatus) {
		
		
		GatApproveVO queryGatApprove = new GatApproveVO();
		queryGatApprove.setMobile(mobile);
		queryGatApprove.setApproveStatus(approveStatus);
		page.setTotalCount(gatApproveMapper.countGatApprove(queryGatApprove));
		page.setItems(gatApproveMapper.queryGatApprove(queryGatApprove, page));
		
		
		if (page.getItems().size() == 0 && !"1".equals(first)){
			model.addAttribute("msg","查无记录，请重新输入查询条件");
		}		
		model.addAttribute("gatApproveList", page);
		model.addAttribute("mobile",mobile);		
		model.addAttribute("approveStatus",approveStatus);
		return "views/admin/gat/gatApprove.jsp";
	}	
	
	
	@RequestMapping("approve")
	public String approve(Page page,Model model,String flag,String id,String mobile,String approveStatus) {
		String i = "";
		//审批通过
		if("1".equals(flag)){
			 i = gatApproveSer.approvePass(id);
		//审批不通过	
		} else {
			 i = gatApproveSer.approveFail(id);
		}
		
		if (!i.equals("1")){
			model.addAttribute("msg",i);
		} else {
			model.addAttribute("msg","操作成功");
		}
		
		GatApproveVO queryGatApprove = new GatApproveVO();
		queryGatApprove.setMobile(mobile);
		page.setTotalCount(gatApproveMapper.countGatApprove(queryGatApprove));
		page.setItems(gatApproveMapper.queryGatApprove(queryGatApprove, page));		
		model.addAttribute("gatApproveList", page);
		model.addAttribute("mobile",mobile);				
		model.addAttribute("approveStatus",approveStatus);
		return "views/admin/gat/gatApprove.jsp";
	}
	

	
}
