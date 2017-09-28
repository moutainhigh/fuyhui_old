package com.fujfu.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.RoleAdminVO;
import com.fujfu.pojo.admin.RoleAdminPOJO;

public interface RoleAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleAdminVO record);

    int insertSelective(RoleAdminVO record);

    RoleAdminVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleAdminVO record);

    int updateByPrimaryKey(RoleAdminVO record);
    
    /**
     * 总记录数
     * @return
     */
    int countRoleByAdminId(@Param("adminId")int adminId);
    
    /**
     * 分页列出该管理员角色
     * @param page
     * @return
     */
    List<RoleAdminPOJO> findRoleByAdminId(@Param("adminId")int adminId,@Param("page")Page page);
    
    /**
     * 根据id查出对应的管理员角色
     * @param id
     * @return
     */
    RoleAdminPOJO findRoleAdminVoById(@Param("id")int id);
}