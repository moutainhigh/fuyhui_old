package com.fujfu.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.RolePurviewVO;
import com.fujfu.pojo.admin.RolePurviewPOJO;

public interface RolePurviewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePurviewVO record);

    int insertSelective(RolePurviewVO record);

    RolePurviewVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePurviewVO record);

    int updateByPrimaryKey(RolePurviewVO record);
    
    /**
     * 总记录数
     * @return
     */
    int countPurviewByRoleId(@Param("roleId")int roleId);
    
    /**
     * 
     * @param page
     * @return
     */
    List<RolePurviewPOJO> findPurviewByRoleId(@Param("roleId")int roleId,@Param("page")Page page);
    
    /**
     * 根据角色id查询出所有的权限信息
     * @param roleId
     * @return
     */
    List<RolePurviewVO> findPurviewIdByRoleId(@Param("roleId")int roleId);
    
    /**
     * 根据id查询出拓展角色权限信息
     * @param id
     * @return
     */
	RolePurviewPOJO findRolePurviewVoById(@Param("id")int id);
    
}