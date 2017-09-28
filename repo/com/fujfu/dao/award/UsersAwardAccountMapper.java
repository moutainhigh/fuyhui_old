package com.fujfu.dao.award;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.award.UsersAwardAccountVO;

public interface UsersAwardAccountMapper {
    int deleteByPrimaryKey(String id);

    int insert(UsersAwardAccountVO record);

    int insertSelective(UsersAwardAccountVO record);

    UsersAwardAccountVO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UsersAwardAccountVO record);

    int updateByPrimaryKey(UsersAwardAccountVO record);
    
    List<UsersAwardAccountVO> findAwardAccountList(@Param("usersAwardAccount")UsersAwardAccountVO usersAwardAccount,@Param("tranAmount")BigDecimal tranAmount);    
    
    
    List<UsersAwardAccountVO> findAwardAccountListByPage(@Param("usersAwardAccount")UsersAwardAccountVO usersAwardAccount, @Param("page") Page page); 
    
    int findCountAwardAccountList(@Param("usersAwardAccount")UsersAwardAccountVO usersAwardAccount); 
    
    List<UsersAwardAccountVO> findAvailAwardAccountList(@Param("usersAwardAccount")UsersAwardAccountVO usersAwardAccount); 
    
    
    List<UsersAwardAccountVO> findPastAwardAccountList(@Param("usersAwardAccount")UsersAwardAccountVO usersAwardAccount); 
    
    
    List<UsersAwardAccountVO> findUsedAwardAccountList(@Param("usersAwardAccount")UsersAwardAccountVO usersAwardAccount); 
    
}