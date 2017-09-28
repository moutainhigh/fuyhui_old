package com.fujfu.service.recommend.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.StringUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.recommend.RecommendFriendshipMapper;
import com.fujfu.dao.recommend.RecommendSettingDetailMapper;
import com.fujfu.dao.recommend.RecommendSettingMapper;
import com.fujfu.pojo.recommend.RecommenFriendsPOJO;
import com.fujfu.pojo.recommend.RecommendFriendshipVO;
import com.fujfu.pojo.recommend.RecommendDTO;
import com.fujfu.pojo.recommend.RecommendSettingVO;
import com.fujfu.pojo.recommend.RecommendSettingDetailVO;
import com.fujfu.service.recommend.RecommendSer;
import com.fujfu.web.admin.recommend.RecommendSettingUpdateVo;

/**author peter 20170329*/
@Service("recommendSer")
public class RecommendSerImpl implements RecommendSer {
	@Resource
	public RecommendFriendshipMapper recommendFriendshipMapper;
	@Resource
	public RecommendSettingMapper recommendSettingMapper;
	@Resource
	RecommendSettingDetailMapper recommendSettingDetailMapper;

	
	
	/**
	 * 用户注册添加好友关系
	 * @param recommendUserId
	 * @param rRecommedUserId
	 * @return 1成功 -1，0失败
	 */
	@Override
	public int registRecommend(Integer recommendUserId,Integer rRecommedUserId){
		
		
		/**查找推荐配置项*/
		RecommendSettingVO recommendSetting =  recommendSettingMapper.selectByPrimaryKey(1);
		
		if(recommendSetting == null){
			return -1;
		}
		
		RecommendFriendshipVO recommendFriendship = new RecommendFriendshipVO();
		//推荐人ID
		recommendFriendship.setRecommendUserId(recommendUserId);
		//被推荐人ID
		recommendFriendship.setRecommendRefUserId(rRecommedUserId);
		//投资金额
		recommendFriendship.setInvestAmount(BigDecimal.ZERO);
		//投资时间	
		//recommendFriendship.setInvestTime(0);		
		Long time = System.currentTimeMillis();
		Date date = new Date(time);
		
		int eletime = (int)(time/1000);
		//有效期
		int term = DateUtil.getUnixTimeNextMonths(date, recommendSetting.getTerm());
		recommendFriendship.setRewardTerm(term);
		//注册时间
		recommendFriendship.setRegistTime(eletime);
		//状态
		recommendFriendship.setStatus("1");
		//新增时间
		recommendFriendship.setCreated(eletime);
		
		int i = recommendFriendshipMapper.insertSelective(recommendFriendship);
		
		return i;
	}
	
	
	/**
	 * 根据被推荐人查找推荐人且未投资放款，且新增奖励计划
	 * @param recommendUserId
	 * @param rRecommedUserId 
	 * @return 1成功 -1，0失败
	 */
	@Override
	public int LoanRecommend(Integer rRecommedUserId,Integer investLoanId,String investLoadName,BigDecimal investMoney,Integer investTime){
		
		/**查找未被奖励的被推荐人*/
		RecommendFriendshipVO  recommendFriendship = recommendFriendshipMapper.selectRecommedUserUnLoan(rRecommedUserId, investTime);
		
		if (recommendFriendship == null){
			return 0;
		}
		
		/**更新新增奖励计划*/
		//投资金额
		recommendFriendship.setInvestAmount(investMoney);
		//投资时间
		recommendFriendship.setInvestTime(investTime);
		//标的ID
		recommendFriendship.setInvestLoanId(investLoanId);
		//标的名称
		recommendFriendship.setInvestLoanName(investLoadName);	
		//更新时间
		recommendFriendship.setUpdated(DateUtil.getUnixTime());
		int i = recommendFriendshipMapper.updateByPrimaryKeySelective(recommendFriendship);
		
		return i;
		
	}
	
	
	/**
	 * 推荐设置
	 * @param recommendSettingUpdateVo
	 * @return 1成功 -1，0失败
	 */
	@Override
	public int updateSetting(RecommendSettingUpdateVo recommendSettingUpdateVo){
		//主设置
		RecommendSettingVO recommendSetting =  recommendSettingMapper.selectByPrimaryKey(Integer.valueOf(recommendSettingUpdateVo.getId()));
		if(recommendSetting == null){
			return -1;
		}
		//档次一
		RecommendSettingDetailVO recommendSettingDetail1 =  recommendSettingDetailMapper.selectByPrimaryKey(Integer.valueOf(recommendSettingUpdateVo.getId1()));
		if(recommendSettingDetail1 == null){
			return -1;
		}		
		//档次二
		RecommendSettingDetailVO recommendSettingDetail2 =  recommendSettingDetailMapper.selectByPrimaryKey(Integer.valueOf(recommendSettingUpdateVo.getId2()));
		if(recommendSettingDetail2 == null){
			return -1;
		}		
		//档次三
		RecommendSettingDetailVO recommendSettingDetail3 =  recommendSettingDetailMapper.selectByPrimaryKey(Integer.valueOf(recommendSettingUpdateVo.getId3()));
		if(recommendSettingDetail3 == null){
			return -1;
		}		
		//档次四
		RecommendSettingDetailVO recommendSettingDetail4 =  recommendSettingDetailMapper.selectByPrimaryKey(Integer.valueOf(recommendSettingUpdateVo.getId4()));
		if(recommendSettingDetail4 == null){
			return -1;
		}		
		
		//有效期
		recommendSetting.setTerm(Integer.valueOf(recommendSettingUpdateVo.getTerm()));
		recommendSetting.setUpdated(DateUtil.getUnixTime());
		/**更新主设置*/
		recommendSettingMapper.updateByPrimaryKeySelective(recommendSetting);
		
		//档次金额最小值
		recommendSettingDetail1.setLevelMinAmount(new BigDecimal(recommendSettingUpdateVo.getLevelMinMount1()));
		//档次金额最大值
		recommendSettingDetail1.setLevelMaxAmount(new BigDecimal(recommendSettingUpdateVo.getLevelMaxMount1()));
		//档次金额
		recommendSettingDetail1.setAmount(new BigDecimal(recommendSettingUpdateVo.getLevelRewardMount1()));
		recommendSettingDetail1.setUpdated(DateUtil.getUnixTime());
		//更新档次一金额
		recommendSettingDetailMapper.updateByPrimaryKeySelective(recommendSettingDetail1);
		
		//档次金额最小值
		recommendSettingDetail2.setLevelMinAmount(new BigDecimal(recommendSettingUpdateVo.getLevelMinMount2()));
		//档次金额最大值
		recommendSettingDetail2.setLevelMaxAmount(new BigDecimal(recommendSettingUpdateVo.getLevelMaxMount2()));
		//档次金额
		recommendSettingDetail2.setAmount(new BigDecimal(recommendSettingUpdateVo.getLevelRewardMount2()));
		recommendSettingDetail2.setUpdated(DateUtil.getUnixTime());
		//更新档次一金额
		recommendSettingDetailMapper.updateByPrimaryKeySelective(recommendSettingDetail2);
		
		
		//档次金额最小值
		recommendSettingDetail3.setLevelMinAmount(new BigDecimal(recommendSettingUpdateVo.getLevelMinMount3()));
		//档次金额最大值
		recommendSettingDetail3.setLevelMaxAmount(new BigDecimal(recommendSettingUpdateVo.getLevelMaxMount3()));
		//档次金额
		recommendSettingDetail3.setAmount(new BigDecimal(recommendSettingUpdateVo.getLevelRewardMount3()));
		recommendSettingDetail3.setUpdated(DateUtil.getUnixTime());
		//更新档次一金额
		recommendSettingDetailMapper.updateByPrimaryKeySelective(recommendSettingDetail3);
		
		
		//档次金额最小值
		recommendSettingDetail4.setLevelMinAmount(new BigDecimal(recommendSettingUpdateVo.getLevelMinMount4()));
		//档次金额最大值
		recommendSettingDetail4.setLevelMaxAmount(new BigDecimal(recommendSettingUpdateVo.getLevelMaxMount4()));
		//档次金额
		recommendSettingDetail4.setAmount(new BigDecimal(recommendSettingUpdateVo.getLevelRewardMount4()));
		recommendSettingDetail4.setUpdated(DateUtil.getUnixTime());
		//更新档次一金额
		recommendSettingDetailMapper.updateByPrimaryKeySelective(recommendSettingDetail4);
				
		return 1;
		
	}


	@Override
	public Page findRecommendReward(Page page) {
		page.setTotalCount(recommendFriendshipMapper.countRecommendReward());
		page.setItems(recommendFriendshipMapper.findRecommendReward(page));
		return page;
	}

	@Override
	public Map<String, Object> selectRecommenFriendsListByUserid(Integer userid, Integer startNum, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		int totalNum = recommendFriendshipMapper.countRecommenFriendsList(userid);
		// TODO Auto-generated method stub
		List<RecommenFriendsPOJO> list = recommendFriendshipMapper.selectRecommenFriendsListByUserid(userid,  startNum, pageSize);
		for(RecommenFriendsPOJO recommenFriends:list){
			if(StringUtils.isNotEmpty(recommenFriends.getUserName())){
			recommenFriends.setUserName(StringUtil.handlePhone(recommenFriends.getUserName()));
			}
			if(StringUtils.isNotEmpty(recommenFriends.getRealName())){
			recommenFriends.setRealName(StringUtil.handleName(recommenFriends.getRealName()));
			}else{
				recommenFriends.setRealName("");
			}
			
		}
		int totalPage = totalNum % (pageSize) == 0 ? totalNum / (pageSize)
				: totalNum / (pageSize) + 1;
		map.put("totalPage", totalPage);
		map.put("content", list);

		return map;
	}


	@Override
	public Page findRecommendRewardDetailByUid(String uid,Page page) {
		page.setTotalCount(recommendFriendshipMapper.countRecommendRewardDetailByUid(uid));
		page.setItems(recommendFriendshipMapper.findRecommendRewardDetailByUid(uid,page));
		return page;
	}


	@Override
	public Page findRecommendedByCondition(RecommendDTO recommendQueryVo, Page page) {
		page.setTotalCount(recommendFriendshipMapper.countRecommendedByCondition(recommendQueryVo));
		page.setItems(recommendFriendshipMapper.findRecommendedByCondition(recommendQueryVo,page));
		return page;
	}
	@Override
	public String selectSumAmountByQueryCondition(Integer userid, Integer rewardTime, String status) {
		// TODO Auto-generated method stub
		return recommendFriendshipMapper.selectSumAmountByQueryCondition(userid, rewardTime, status);
	}
}
