package com.fujfu.dao.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.common.NotifyAutoVO;

public interface NotifyAutoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NotifyAutoVO record);

    int insertSelective(NotifyAutoVO record);

    NotifyAutoVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NotifyAutoVO record);

    int updateByPrimaryKey(NotifyAutoVO record);

	int countNotifyAuto(@Param("notifyAuto")NotifyAutoVO notifyAuto, @Param("page")Page page);

	List<NotifyAutoVO> findNotifyAuto(@Param("notifyAuto")NotifyAutoVO notifyAuto, @Param("page")Page page);
}