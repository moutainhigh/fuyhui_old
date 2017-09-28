package com.fujfu.dao.fee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.fee.SiteFeeVO;

public interface SiteFeeMapper {
    int deleteByPrimaryKey(Integer feeId);

    int insert(SiteFeeVO record);

    int insertSelective(SiteFeeVO record);

    SiteFeeVO selectByPrimaryKey(Integer feeId);

    int updateByPrimaryKeySelective(SiteFeeVO record);

    int updateByPrimaryKey(SiteFeeVO record);

    /**
     * 总记录数
     * @return
     */
	int countSiteFee();

	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	List<SiteFeeVO> listAllSiteFeeByPage(@Param("page")Page page);

	List<SiteFeeVO> listAllSiteFee();
	
	/**
     * 根据费用名查询是否该费用是否已被添加
     * @param feeName
     * @return
     */
	int countSiteFeeByName(@Param("feeName")String feeName);

	SiteFeeVO findSiteFeeByFeeName(@Param("feeName")String feeName);
}