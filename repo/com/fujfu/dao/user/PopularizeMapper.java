package com.fujfu.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.user.PopularizeVO;
import com.fujfu.pojo.user.PopularizePOJO;

public interface PopularizeMapper {
    int deleteByPrimaryKey(Integer popularizeId);

    int insert(PopularizeVO record);

    int insertSelective(PopularizeVO record);

    PopularizeVO selectByPrimaryKey(Integer popularizeId);

    int updateByPrimaryKeySelective(PopularizeVO record);

    int updateByPrimaryKey(PopularizeVO record);
    
    List<PopularizePOJO> findPopularizeByCondition(@Param("popularizeVo")PopularizePOJO popularizeVo,@Param("page")Page page);
   
    int countPopularize(@Param("popularizeVo")PopularizePOJO popularizeVo);
    
    List<PopularizePOJO> findUsersByInviterId(@Param("inviterId")int inviterId,@Param("page")Page page);
    
    int countUsersByInviterId(@Param("inviterId")int inviterId);
    
}