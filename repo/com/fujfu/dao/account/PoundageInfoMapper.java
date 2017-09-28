package com.fujfu.dao.account;

import com.fujfu.pojo.account.PoundageInfoVO;

public interface PoundageInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PoundageInfoVO record);

    int insertSelective(PoundageInfoVO record);

    PoundageInfoVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoundageInfoVO record);

    int updateByPrimaryKey(PoundageInfoVO record);
    
    PoundageInfoVO selectByPrimaryTxnSsn(String txnSsn);
}