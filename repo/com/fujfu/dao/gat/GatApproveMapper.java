package com.fujfu.dao.gat;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.gat.GatApproveVO;

public interface GatApproveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GatApproveVO record);

    int insertSelective(GatApproveVO record);

    GatApproveVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GatApproveVO record);

    int updateByPrimaryKey(GatApproveVO record);
    
	int countGatApprove(@Param("gatApprove")GatApproveVO gatApprove);
	
	List<GatApproveVO> queryGatApprove(@Param("gatApprove")GatApproveVO gatApprove, @Param("page")Page page); 
	
	//前台展示控制状态查询
	int countGatApproveByStatus(@Param("gatApprove")GatApproveVO gatApprove);
	
	//前台查询证件号是否已使用
	int countGatApproveByUserId(@Param("userID")String userID);
}