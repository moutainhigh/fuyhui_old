package com.fujfu.dao.comuanda;

import com.fujfu.pojo.comuanda.AadminVO;

public interface AadminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(AadminVO record);

    int insertSelective(AadminVO record);

    AadminVO selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(AadminVO record);

    int updateByPrimaryKey(AadminVO record);
}