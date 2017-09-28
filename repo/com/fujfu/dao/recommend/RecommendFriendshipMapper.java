package com.fujfu.dao.recommend;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.recommend.RecommenFriendsPOJO;
import com.fujfu.pojo.recommend.RecommendFriendshipVO;
import com.fujfu.pojo.recommend.RecommendDTO;
import com.fujfu.pojo.recommend.RecommendRewardPOJO;
import com.fujfu.pojo.recommend.RecommendPOJO;

public interface RecommendFriendshipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecommendFriendshipVO record);

    int insertSelective(RecommendFriendshipVO record);

    RecommendFriendshipVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecommendFriendshipVO record);

    int updateByPrimaryKey(RecommendFriendshipVO record);
    
    RecommendFriendshipVO selectRecommedUserUnLoan(@Param("recommendRefUserId")Integer recommendRefUserId,@Param("investTime")Integer investTime);
    
    List<RecommendFriendshipVO> selectPreparedRecommed();

    int countRecommendReward();

	List<RecommendRewardPOJO> findRecommendReward(@Param("page")Page page);
    //根据用户id查询所有推荐好友的信息
    int countRecommenFriendsList(@Param("userid") Integer userid);	
	List<RecommenFriendsPOJO> selectRecommenFriendsListByUserid( @Param("userid") Integer userid,@Param("startNum") int startNum,@Param("pageSize") int pageSize);
	
	
	int countRecommendRewardDetailByUid(@Param("uid")String uid);
	
	List<RecommenFriendsPOJO> findRecommendRewardDetailByUid(@Param("uid")String uid,@Param("page")Page page);

	int countRecommendedByCondition(@Param("recommendQueryVo")RecommendDTO recommendQueryVo);

	List<RecommendPOJO> findRecommendedByCondition(@Param("recommendQueryVo")RecommendDTO recommendQueryVo, @Param("page")Page page);
	
	//根据条件查询总奖励金额
    String selectSumAmountByQueryCondition(@Param("userId") Integer userId,@Param("rewardTime") Integer rewardTime,@Param("status") String status);	
}