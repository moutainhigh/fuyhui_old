package com.fujfu.dao.recommend;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.pojo.recommend.RecommendSettingDetailVO;

public interface RecommendSettingDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecommendSettingDetailVO record);

    int insertSelective(RecommendSettingDetailVO record);

    RecommendSettingDetailVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecommendSettingDetailVO record);

    int updateByPrimaryKey(RecommendSettingDetailVO record);
    
    RecommendSettingDetailVO searchRewardMoney(@Param("investMoney")BigDecimal investMoney);
    
    List<RecommendSettingDetailVO> searchRewardMoneyAll();
}