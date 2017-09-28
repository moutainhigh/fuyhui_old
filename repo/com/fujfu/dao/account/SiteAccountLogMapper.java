package com.fujfu.dao.account;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.pojo.SiteAccountLogPojo;
import com.fujfu.pojo.account.SiteAccountLogVO;

public interface SiteAccountLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SiteAccountLogVO record);

    int insertSelective(SiteAccountLogVO record);

    SiteAccountLogVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SiteAccountLogVO record);

    int updateByPrimaryKey(SiteAccountLogVO record);

	int countSiteAccountLog(@Param("feeId")int feeId);

	List<SiteAccountLogPojo> findSiteAccountLog(@Param("feeId")int feeId,@Param("page")Page page);
}