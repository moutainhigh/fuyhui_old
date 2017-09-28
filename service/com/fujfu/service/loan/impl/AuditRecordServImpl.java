package com.fujfu.service.loan.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.dao.loan.AuditRecordMapper;
import com.fujfu.pojo.loan.AuditRecordVO;
import com.fujfu.service.loan.AuditRecordServ;
@Service("auditRecordSer")
public class AuditRecordServImpl implements AuditRecordServ {
	@Resource
	private AuditRecordMapper auditRecordMapper;
	@Override
	public List<AuditRecordVO> findAuditRecordByApplyId(Integer applyId) {
		return auditRecordMapper.findAuditRecordByApplyId(applyId);
	}
	@Override
	public int addAuditRecord(AuditRecordVO auditRecord) {
		return auditRecordMapper.insertSelective(auditRecord);
	}

}
