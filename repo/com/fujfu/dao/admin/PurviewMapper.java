package com.fujfu.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.PurviewVO;

public interface PurviewMapper {
    int deleteByPrimaryKey(Integer purviewId);

    int insert(PurviewVO record);

    int insertSelective(PurviewVO record);

    PurviewVO selectByPrimaryKey(Integer purviewId);

    int updateByPrimaryKeySelective(PurviewVO record);

    int updateByPrimaryKey(PurviewVO record);
    
    /**
     * 列出所有权限信息
     * @return
     */
    List<PurviewVO> listAllPurview();
    
    /**
     * 分页查询
     * @param page
     * @return
     */
    List<PurviewVO> findPurview(@Param("purview")PurviewVO purview,@Param("page")Page page);
    /**
     * 分页查询总记录数
     * @return
     */
    int countPurview(@Param("purview")PurviewVO purview,@Param("page")Page page);
    
    /**
     * 根据roleId查询该角色未拥有的权限
     * @param roleId
     * @return
     */
    List<PurviewVO> findNotOwnPurviewByRoleId(@Param("roleId")int roleId);
}