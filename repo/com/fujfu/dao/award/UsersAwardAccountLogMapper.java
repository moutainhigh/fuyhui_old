package com.fujfu.dao.award;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.award.UsersAwardAccountLogVO;


public interface UsersAwardAccountLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UsersAwardAccountLogVO record);

    int insertSelective(UsersAwardAccountLogVO record);

    UsersAwardAccountLogVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UsersAwardAccountLogVO record);

    int updateByPrimaryKey(UsersAwardAccountLogVO record);
    
    List<UsersAwardAccountLogVO> findAwardAccountLogListByPage(@Param("usersAwardAccountLog")UsersAwardAccountLogVO usersAwardAccountLog, @Param("page") Page page); 
    
    int findCountAwardLogAccountList(@Param("usersAwardAccountLog")UsersAwardAccountLogVO usersAwardAccountLog);     
    
}