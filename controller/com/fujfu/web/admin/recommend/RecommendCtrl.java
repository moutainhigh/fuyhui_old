package com.fujfu.web.admin.recommend;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.dao.recommend.RecommendSettingDetailMapper;
import com.fujfu.dao.recommend.RecommendSettingMapper;
import com.fujfu.pojo.recommend.RecommendDTO;
import com.fujfu.pojo.recommend.RecommendSettingVO;
import com.fujfu.pojo.recommend.RecommendSettingDetailVO;
import com.fujfu.service.recommend.RecommendSer;
import com.fujfu.web.BaseController;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.tag.Page;


@Controller
@RequestMapping("/recommend/")
public class RecommendCtrl extends BaseController {
	private static final long serialVersionUID = 1L;
	@Resource
	RecommendSer recommendSer;
	@Resource
	RecommendSettingMapper recommendSettingMapper;
	@Resource
	RecommendSettingDetailMapper recommendSettingDetailMapper;	
	

	/**
	 * 更新推荐设置
	 * */
	@RequestMapping("settingUpdate")
	public String settingUpdate(RecommendSettingUpdateVo recommendSettingUpdateVo,Model model){

		
		int i = recommendSer.updateSetting(recommendSettingUpdateVo);
		model.addAttribute("recommendSettingUpdateVo",recommendSettingUpdateVo);
		if(i == 0){
			model.addAttribute("msg","更新失败");
		} else {
			model.addAttribute("msg","更新成功");
		}
		return "views/admin/recommend/recommendSetting.jsp";			

	}
	
	/**
	 * 查询推荐查询
	 * */
	@RequestMapping("settingQuery")
	public String settingQuery(RecommendSettingUpdateVo recommendSettingUpdateVo,Model model){
		
		RecommendSettingVO recommendSetting  = recommendSettingMapper.selectByPrimaryKey(1);
		if(recommendSetting == null){
			 recommendSettingUpdateVo = new RecommendSettingUpdateVo();
			 return "views/admin/recommend/recommendSetting.jsp";
		}
		
		//有效期
		recommendSettingUpdateVo.setTerm(String.valueOf(recommendSetting.getTerm()));
		recommendSettingUpdateVo.setId(String.valueOf(recommendSetting.getId()));
		
		List<RecommendSettingDetailVO> recommendSettingDetailList =  recommendSettingDetailMapper.searchRewardMoneyAll();
		
		int i = 0;
		for(RecommendSettingDetailVO recommendSettingDetail:recommendSettingDetailList){
			i++;
			if (i == 1){
				//档次最小金额
				recommendSettingUpdateVo.setLevelMinMount1(String.valueOf(recommendSettingDetail.getLevelMinAmount().doubleValue()));
				//档次最大金额
				recommendSettingUpdateVo.setLevelMaxMount1(String.valueOf(recommendSettingDetail.getLevelMaxAmount().doubleValue()));
				//档次最小金额
				recommendSettingUpdateVo.setLevelRewardMount1(String.valueOf(recommendSettingDetail.getAmount().doubleValue()));
				//id号
				recommendSettingUpdateVo.setId1(String.valueOf(recommendSettingDetail.getId()));
				
			} else if (i == 2){
				//档次最小金额
				recommendSettingUpdateVo.setLevelMinMount2(String.valueOf(recommendSettingDetail.getLevelMinAmount().doubleValue()));
				//档次最大金额
				recommendSettingUpdateVo.setLevelMaxMount2(String.valueOf(recommendSettingDetail.getLevelMaxAmount().doubleValue()));
				//档次最小金额
				recommendSettingUpdateVo.setLevelRewardMount2(String.valueOf(recommendSettingDetail.getAmount().doubleValue()));
				//id号
				recommendSettingUpdateVo.setId2(String.valueOf(recommendSettingDetail.getId()));				
				
			} else if (i == 3){
				//档次最小金额
				recommendSettingUpdateVo.setLevelMinMount3(String.valueOf(recommendSettingDetail.getLevelMinAmount().doubleValue()));
				//档次最大金额
				recommendSettingUpdateVo.setLevelMaxMount3(String.valueOf(recommendSettingDetail.getLevelMaxAmount().doubleValue()));
				//档次最小金额
				recommendSettingUpdateVo.setLevelRewardMount3(String.valueOf(recommendSettingDetail.getAmount().doubleValue()));
				//id号
				recommendSettingUpdateVo.setId3(String.valueOf(recommendSettingDetail.getId()));				
				
			} else if (i == 4){ 
				//档次最小金额
				recommendSettingUpdateVo.setLevelMinMount4(String.valueOf(recommendSettingDetail.getLevelMinAmount().doubleValue()));
				//档次最大金额
				recommendSettingUpdateVo.setLevelMaxMount4(String.valueOf(recommendSettingDetail.getLevelMaxAmount().doubleValue()));
				//档次最小金额
				recommendSettingUpdateVo.setLevelRewardMount4(String.valueOf(recommendSettingDetail.getAmount().doubleValue()));
				//id号
				recommendSettingUpdateVo.setId4(String.valueOf(recommendSettingDetail.getId()));
			}
		}
		
		model.addAttribute("recommendSettingUpdateVo",recommendSettingUpdateVo);
		
		return "views/admin/recommend/recommendSetting.jsp";		
	}
	
	/**
	 * 推荐奖励汇总
	 */
	@RequestMapping("recommendRewardList")
	public String recommendRewardList(Page page,Model model){
		Page recommendRewardList = recommendSer.findRecommendReward(page);
		model.addAttribute("recommendRewardList", recommendRewardList);
		return "views/admin/recommend/recommendRewardList.jsp";
	}
	/**
	 * 好友详情
	 */
	@RequestMapping("recommendRewardDetail")
	public String recommendRewardDetail(String uid,Page page,Model model){
		Page recommendRewardDetail = recommendSer.findRecommendRewardDetailByUid(uid, page);
		model.addAttribute("recommendRewardDetail", recommendRewardDetail);
		model.addAttribute("uid", uid);
		return "views/admin/recommend/recommendRewardDetail.jsp";
	}
	
	@RequestMapping("getRecommendedList")
	public String getRecommendedList(HttpServletRequest request, Page page, String busername, String startTime, String endTime,
			Model model) {
		RecommendDTO recommendQueryVo = new RecommendDTO();
		if (StringUtils.isNotEmpty(startTime)) {
			try {
				recommendQueryVo.setStartTime(DateUtil.dateTimeStamp(startTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(endTime)) {
			try {
				recommendQueryVo.setEndTime(DateUtil.dateTimeStamp(endTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(busername)) {
			recommendQueryVo.setBusername(busername);
		}
		Page recommendedList = recommendSer.findRecommendedByCondition(recommendQueryVo, page);
		model.addAttribute("recommendedList", recommendedList);
		return "views/admin/recommend/recommendedList.jsp";

	}


}