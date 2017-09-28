package com.fujfu.dao.account;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.SiteAccountVO;

public interface SiteAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SiteAccountVO record);

    int insertSelective(SiteAccountVO record);

    SiteAccountVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SiteAccountVO record);
    
    int updateByPrimaryKey(SiteAccountVO record);

	int countSiteAccount();

	List<SiteAccountVO> findSiteAccount(@Param("page")Page page);

	SiteAccountVO findSiteAccountByFeeName(@Param("feeName")String feeName);
	SiteAccountVO findSiteAccountByFeeId(@Param("feeId")Integer feeId);
}