package com.fujfu.dao.award;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.pojo.award.UsersAwardActionVO;

public interface UsersAwardActionMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(UsersAwardActionVO record);

    UsersAwardActionVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UsersAwardActionVO record);
    
    /**
     * 根据状态查询红包处理情况
     * @param statusList
     * @return
     */
    List<UsersAwardActionVO> findAwardActionByStatus(@Param("status")int status,@Param("startTime")int startTime,@Param("endTime")int endTime);

}