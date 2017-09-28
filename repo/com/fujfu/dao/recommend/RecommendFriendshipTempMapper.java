package com.fujfu.dao.recommend;

import java.util.List;

import com.fujfu.pojo.recommend.RecommendFriendshipVO;

public interface RecommendFriendshipTempMapper {
	int countRecommendFriendship();
	int deleteByPrimaryKey(Integer id);
	int insertSelective(RecommendFriendshipVO record);
	RecommendFriendshipVO selectByPrimaryKey(Integer id);
	List<RecommendFriendshipVO> findAllRecommendFriendshipTemp();
}