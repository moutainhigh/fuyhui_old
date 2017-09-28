package com.fujfu.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.AdminVO;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(AdminVO record);

    int insertSelective(AdminVO record);

    AdminVO selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(AdminVO record);

    int updateByPrimaryKey(AdminVO record);
    
    AdminVO adminLogin(AdminVO admin);
    
    /**
     * 分页查询
     * @param page
     * @return
     */
    List<AdminVO> findAdmin(@Param("admin")AdminVO admin,@Param("page")Page page);
    
    /**
     * 分页查询总记录数
     * @return
     */
    int countAdmin(@Param("admin")AdminVO admin,@Param("page")Page page);
    
    /**
     * 根据管理员id查出该管理员的所有权限信息
     * @param adminId
     * @return
     */
    List<String> selectPurviewsByAdminId(@Param("adminId") int adminId);
}