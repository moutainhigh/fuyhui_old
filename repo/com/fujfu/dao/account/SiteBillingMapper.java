package com.fujfu.dao.account;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.SiteBillingVO;
import com.fujfu.pojo.account.SiteBillingDTO;

public interface SiteBillingMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(SiteBillingVO record);

    SiteBillingVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SiteBillingVO record);
    
    int updateBusiStatusBySSN(@Param("statu")Integer statu,@Param("updateDate")Integer updateDate, @Param("ssn")String ssn);
    
    /**
	 * 条件查询平台账单信息
	 * 
	 * @return
	 */
	 List<SiteBillingVO> findSiteBillingByCondition(@Param("siteBillingQueryVo")SiteBillingDTO siteBillingQueryVo, @Param("page")Page page);
	 /**
		 * 分页查询总记录数
		 * 
		 * @return
		 */
	int countSiteBilling(@Param("siteBillingQueryVo")SiteBillingDTO siteBillingQueryVo);

}