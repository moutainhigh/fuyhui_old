package com.fujfu.dao.recommend;

import com.fujfu.pojo.recommend.RecommendSettingVO;

public interface RecommendSettingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecommendSettingVO record);

    int insertSelective(RecommendSettingVO record);

    RecommendSettingVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecommendSettingVO record);

    int updateByPrimaryKey(RecommendSettingVO record);
}