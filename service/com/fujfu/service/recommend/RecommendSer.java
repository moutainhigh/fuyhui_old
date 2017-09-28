package com.fujfu.service.recommend;

import java.math.BigDecimal;
import com.fujfu.common.util.tag.Page;
import java.util.Map;

import com.fujfu.web.admin.recommend.RecommendSettingUpdateVo;

import com.fujfu.pojo.recommend.RecommendDTO;


public interface RecommendSer {
	public int registRecommend(Integer recommendUserId,Integer rRecommedUserId);
	
	public int LoanRecommend(Integer rRecommedUserId,Integer investLoanId,String investLoadName,BigDecimal investMoney,Integer investTime);
	/**
	 * 前台根据userid查询推荐好友详细
	 * @param 
	 * @return
	 */
	public	Map<String, Object> selectRecommenFriendsListByUserid( Integer userid, Integer startNum, Integer pageSize);

	/**
	 * 推荐奖励查询分页
	 * @param page
	 * @return
	 */
	public Page findRecommendReward(Page page);
	
	/**
	 * 推荐奖励 好友详情查询
	 * @param page
	 * @return
	 */
	public Page findRecommendRewardDetailByUid(String uid,Page page);
	
	public int updateSetting(RecommendSettingUpdateVo recommendSettingUpdateVo);

	public Page findRecommendedByCondition(RecommendDTO recommendQueryVo, Page page);
	//根据用户id查询所有推荐好友的信息
	public String selectSumAmountByQueryCondition(Integer userid,Integer rewardTime,String status);
		
	
}
