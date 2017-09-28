package com.fujfu.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.user.PayForPOJO;
import com.fujfu.pojo.user.PayForListPOJO;

public interface UserPayForListMapper {
	
	
	/**
	 * 分页查询担保人垫资列表
	 * 
	 * @param page
	 * @return
	 */
	List<PayForPOJO> findPayForListByCondition(@Param("payForListQueryVo") PayForListPOJO payForListQueryVo, @Param("page") Page page);	
	
	/**
	 * 分页查询担保人垫资列表总记录数
	 * 
	 * @return
	 */
	int countPayForListByCondition(@Param("payForListQueryVo") PayForListPOJO payForListQueryVo, @Param("page") Page page);
	

}
