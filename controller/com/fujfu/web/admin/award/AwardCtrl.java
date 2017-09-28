package com.fujfu.web.admin.award;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.award.AwardTypeVO;
import com.fujfu.service.award.AwardAccountLogServ;
import com.fujfu.service.award.AwardAccountServ;
import com.fujfu.service.award.AwardTypeServ;
import com.fujfu.service.award.AwardUserAddServ;
import com.fujfu.web.BaseController;
@Controller
@RequestMapping("/award/")
public class AwardCtrl extends BaseController {
	private static final long serialVersionUID = 1L;
	@Resource
	private AwardTypeServ awardTypeServ;
	@Resource
	private AwardUserAddServ awardUserAddServ;
	@Resource
	AwardAccountServ awardAccountServ;
	@Resource
	AwardAccountLogServ awardAccountLogServ;	
	/**
	 * 进入到红包列表页面
	 * @param page
	 * @param awardType
	 * @param model
	 * @return
	 */
	@RequestMapping("awardTypeIndex")
	public String index(Page page,AwardTypeVO awardType,Model model){
		Page awardTypeList = awardTypeServ.findAwardTypeByCondition(awardType, page);
		for(int i = 0;i<awardTypeList.getItems().size();i++){
			AwardTypeVO awardType1 = (AwardTypeVO)awardTypeList.getItems().get(i);
			int currentTime = DateUtil.getUnixTime();
			if(currentTime>awardType1.getEndTime()){
				//已过期
				awardType1.setDueStatus(2);
			} else {
				if(awardType1.getStartTime() <currentTime){
					//未生效
					awardType1.setDueStatus(1);
				} else {
					//已生效
					awardType1.setDueStatus(0);
				}
				
			}	
		}
		model.addAttribute("awardTypeList", awardTypeList);
		return "views/admin/award/awardTypeList.jsp";
	}
	
	/**
	 * 进入添加界面
	 * @return
	 */
	@RequestMapping("enterAwardTypeAdd")
	public String enterAdd(){
		return "views/admin/award/addAwardType.jsp";
	}
	
	
	
	
	/**
	 * 添加红包
	 * @param model
	 * @param awardType
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="addAwardType",method = RequestMethod.POST)
	public Object add(AwardTypeVO awardType){
		Map<String, Object> map = new HashMap<String, Object>();
		awardType.setCreated(DateUtil.getUnixTime());
		int result = awardTypeServ.addAwardType(awardType);
		if(result>0){
			map.put("flag", "1");
			map.put("msg", "添加红包成功");
		}else{
			map.put("flag", "0");
			map.put("msg", "添加红包失败");
		}	
		return map;
	}
	
	/**
	 * 红包开启或者关闭
	 * @param request
	 * @param model
	 * @param awardType
	 * @return
	 */
	@RequestMapping("updateAwardType")
	public String update(HttpServletRequest request, Model model, AwardTypeVO awardType) {
		int result = awardTypeServ.updateAwardType(awardType);
		if (result > 0) {
			if(awardType.getStatus()==0){
				model.addAttribute("msg", "开始红包成功");
			}else{
				model.addAttribute("msg", "关闭红包成功");
			}
			
		} else {
			model.addAttribute("msg", "操作失败");
		}
		return "redirect:/award/awardTypeIndex";
	}
	
	
	/**
	 * 查询用户红包记录
	 * @param model
	 * @param awardType
	 * @return
	 */
	@RequestMapping("findAwardAccountList")
	public Object findAwardAccountList(Page page,  Model model,String mobile){
		System.out.println("查询开始。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
		
		//Page userPayForList = userPayForList.;
		Page awardAccountList = awardAccountServ.findAwardAccountListByPage(page,mobile);
		model.addAttribute("awardAccountList", awardAccountList);
		//model.addAttribute("payForListQueryVo",payForListQueryVo);
		if (awardAccountList.getItems().size() == 0){
			model.addAttribute("msg","查无记录，请重新输入查询条件");
		}
		return "views/admin/award/awardAccountList.jsp";
	}
	
	/**
	 * 
	 * @param model
	 * @param awardType
	 * @return
	 */
	@RequestMapping("findAwardAccountLogList")
	public Object findAwardAccountLogList(Page page,  Model model,String mobile){
		System.out.println("查询开始。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
		
		//Page userPayForList = userPayForList.;
		Page awardAccountLogList = awardAccountLogServ.findAwardAccountLogListByPage(page,mobile);
		model.addAttribute("awardAccountLogList", awardAccountLogList);
		//model.addAttribute("payForListQueryVo",payForListQueryVo);
		if (awardAccountLogList.getItems().size() == 0){
			model.addAttribute("msg","查无记录，请重新输入查询条件");
		}
		return "views/admin/award/awardAccountLogList.jsp";
	}
	
}
