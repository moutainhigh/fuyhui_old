package com.fujfu.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.SidemenuVO;

public interface SidemenuMapper {
    int deleteByPrimaryKey(Integer sidebarId);

    int insert(SidemenuVO record);

    int insertSelective(SidemenuVO record);

    SidemenuVO selectByPrimaryKey(Integer sidebarId);

    int updateByPrimaryKeySelective(SidemenuVO record);

    int updateByPrimaryKey(SidemenuVO record);
    
    /**
     * 总记录数
     * @return
     */
    int countSidemenu();
    
    /**
     * 
     * @param page
     * @return
     */
    List<SidemenuVO> listAllSidemenu(@Param("page")Page page);
}