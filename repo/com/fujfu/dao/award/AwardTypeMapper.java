package com.fujfu.dao.award;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.award.AwardTypeVO;

public interface AwardTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AwardTypeVO record);

    int insertSelective(AwardTypeVO record);

    AwardTypeVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AwardTypeVO record);

    int updateByPrimaryKey(AwardTypeVO record);

	int countAwardType(@Param("awardType")AwardTypeVO awardType);

	List<AwardTypeVO> findAwardType(@Param("awardType")AwardTypeVO awardType, @Param("page")Page page);
	
	List<AwardTypeVO> findAwardTypeList(@Param("awardType")AwardTypeVO awardType,@Param("currentTime")Integer currentTime);
}