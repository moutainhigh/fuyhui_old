package com.fujfu.service.loan.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.loan.LoanTypeMapper;
import com.fujfu.pojo.loan.LoanTypeVO;
import com.fujfu.service.loan.LoanTypeServ;
@Service("loanTypeSer")
public class LoanTypeServImpl implements LoanTypeServ {
	@Resource
	public LoanTypeMapper loanTypeMapper;
	@Override
	public int addLoanType(LoanTypeVO loanType) {
		return loanTypeMapper.insertSelective(loanType);
	}

	@Override
	public int updateLoanType(LoanTypeVO loanType) {
		return loanTypeMapper.updateByPrimaryKeySelective(loanType);
	}

	@Override
	public int delLoanType(int id) {
		return loanTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<LoanTypeVO> listAllLoanType() {
		return loanTypeMapper.listAllLoanType();
	}

	@Override
	public Page findLoanTypeByCondition(LoanTypeVO loanType, Page page) {
		page.setTotalCount(loanTypeMapper.countLoanType(loanType));
		page.setItems(loanTypeMapper.findLoanType(loanType, page));
		return page;
	}

	@Override
	public LoanTypeVO findLoanTypeById(int id) {
		return loanTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer findloanTypeIdByName(String name) {
		// TODO Auto-generated method stub
		return loanTypeMapper.findloanTypeIdByName(name);
	}

}
