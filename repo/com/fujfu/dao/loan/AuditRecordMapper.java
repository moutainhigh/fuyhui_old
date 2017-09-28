package com.fujfu.dao.loan;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.pojo.loan.AuditRecordVO;

public interface AuditRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(AuditRecordVO record);

    AuditRecordVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuditRecordVO record);
    
    /**
     * 根据标的id查询标的审核记录
     * @param applyId
     * @return
     */
    List<AuditRecordVO> findAuditRecordByApplyId(@Param("applyId")Integer applyId);
}