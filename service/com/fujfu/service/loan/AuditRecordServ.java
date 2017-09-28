package com.fujfu.service.loan;

import java.util.List;

import com.fujfu.pojo.loan.AuditRecordVO;

public interface AuditRecordServ {
	/**
     * 根据标的id查询标的审核记录
     * @param applyId
     * @return
     */
	public List<AuditRecordVO> findAuditRecordByApplyId(Integer applyId);
	
	/**
	 * 添加审核记录
	 * @param auditRecord
	 * @return
	 */
	public int addAuditRecord(AuditRecordVO auditRecord);
}
