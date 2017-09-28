package com.fujfu.dao.award;

import java.util.List;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.award.AwardLogVO;

public interface AwardLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AwardLogVO record);

    int insertSelective(AwardLogVO record);

    AwardLogVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AwardLogVO record);

    int updateByPrimaryKey(AwardLogVO record);

	int countAwardLog(AwardLogVO awardLog);

	List<AwardLogVO> findAwardLog(AwardLogVO awardLog, Page page);
}