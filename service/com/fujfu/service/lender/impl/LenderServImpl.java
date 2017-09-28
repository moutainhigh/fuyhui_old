package com.fujfu.service.lender.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.dao.account.UserAccountMapper;
import com.fujfu.dao.apply.ApplyRecoverMapper;
import com.fujfu.dao.apply.ApplyRepayMapper;
import com.fujfu.dao.invest.LoanInvestmentMapper;
import com.fujfu.dao.loan.LoanApplyMapper;
import com.fujfu.dao.user.UserMapper;
import com.fujfu.pojo.apply.ApplyRecoverVO;
import com.fujfu.pojo.apply.ApplyRepayVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.lender.LenderServ;

@Service("lenderSer")
public class LenderServImpl implements LenderServ {
	@Resource
	public LoanApplyMapper loanApplyMapper;
	@Resource
	public UserMapper userBeanMapper;
	@Resource
	public ApplyRepayMapper applyRepayMapper;
	@Resource
	public ApplyRecoverMapper applyRecoverMapper;
	@Resource
	public LoanInvestmentMapper investMapper;
	@Resource
	public UserAccountMapper userAccountMapper;

	@Override
	public List<UserVO> findInvestorByBidId(Long applyId) {
		return userBeanMapper.findInvestorByBidId(applyId);
	}

	@Override
	public int addPaymentRecord(ApplyRepayVO applyRepay) {
		return applyRepayMapper.insertSelective(applyRepay);
	}

	@Override
	public int addRecoverRecord(ApplyRecoverVO applyRecover) {
		return applyRecoverMapper.insertSelective(applyRecover);
	}
}
