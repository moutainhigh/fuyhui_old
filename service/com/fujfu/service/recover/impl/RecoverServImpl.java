package com.fujfu.service.recover.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.account.UserAccountMapper;
import com.fujfu.dao.apply.ApplyRecoverMapper;
import com.fujfu.dao.apply.ApplyRepayMapper;
import com.fujfu.dao.loan.LoanApplyMapper;
import com.fujfu.dao.user.UserMapper;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.apply.ApplyRecoverVO;
import com.fujfu.pojo.apply.RecoverImportExcelPOJO;
import com.fujfu.pojo.apply.UserRecoverSumPOJO;
import com.fujfu.service.recover.RecoverServ;
@Service("RecoverSer")
public class RecoverServImpl implements RecoverServ {
	@Resource
	public ApplyRecoverMapper applyRecoverMapper;
	@Resource
	public ApplyRepayMapper applyRepayMapper;
	@Resource
	public UserAccountMapper userAccountMapper;
	@Resource
	public UserMapper userBeanMapper;
	@Resource
	public LoanApplyMapper loanApplyMapper;
	

	@Override
	public Page findAllApplyRecoverListByCondition(LoanInvestPOJO loanInvestQueryVo, Page page) {
		page.setTotalCount(applyRecoverMapper.countApplyRecover(loanInvestQueryVo, page));
		page.setItems(applyRecoverMapper.findAllRecoverByRecoverperiod(loanInvestQueryVo, page));		
		return page;
	}


	@Override
	public List<ApplyRecoverVO> findloanRecoverListByConditionAndNum(LoanInvestPOJO loanInvestQueryVo, int pageNum,int pageSize) {
		return applyRecoverMapper.findloanRecoverListByConditionAndNum(loanInvestQueryVo, pageSize*(pageNum-1),pageSize);
	}


	@Override
	public int getcountRecoverList(LoanInvestPOJO loanInvestQueryVo) {
		Page page =new Page();
		return applyRecoverMapper.countApplyRecover(loanInvestQueryVo, page);
	}


	@Override
	public int countUserRecoverTradeDetai(LoanInvestPOJO loanInvestQueryVo, Integer userId) {
		// TODO Auto-generated method stub
		return applyRecoverMapper.countUserRecoverTradeDetai(loanInvestQueryVo, userId);
	}


	@Override
	public UserRecoverSumPOJO findUserRecoverSumMap(String status, Integer userId) {
		// TODO Auto-generated method stub
		return applyRecoverMapper.findUserRecoverSumMap(status, userId);
	}
	@Override
	public UserRecoverSumPOJO findUserRecoverSumMap1(String status, Integer userId,Integer investId) {
		// TODO Auto-generated method stub
		return applyRecoverMapper.findUserRecoverSumMap1(status, userId,investId);
	}


	@Override
	public List<ApplyRecoverVO> findRecoverGroupByUserid(Integer applyId,Integer userId) {
		// TODO Auto-generated method stub
		return applyRecoverMapper.findRecoverGroupByUserid(applyId, userId);
	}


	@Override
	public List<RecoverImportExcelPOJO> recoverImportExcelList(Integer applyId, Integer period) {
		// TODO Auto-generated method stub
		return applyRecoverMapper.recoverImportExcelList(applyId, period);
	}


	
}
