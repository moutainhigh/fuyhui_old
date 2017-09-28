package com.fujfu.service.invest.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.invest.LoanInvestmentMapper;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.invest.InvestImportExcelPOJO;
import com.fujfu.pojo.invest.InvestRecordPOJO;
import com.fujfu.pojo.invest.LoanInvestListPOJO;
import com.fujfu.pojo.invest.LoanInvestmentVO;
import com.fujfu.service.invest.LoanInvestmentServ;
@Service("investSer")
public class LoanInvestmentServImpl implements LoanInvestmentServ {
	@Resource
	public LoanInvestmentMapper loanInvestMapper;
	
	@Override
	public List<InvestRecordPOJO> findInvestByApplyIdAndNum(String applyId,int pageNum) {
		return loanInvestMapper.findInvestByApplyIdAndNum(applyId,10*(pageNum-1));
	}
	@Override
	public int countInvestRecodByApplyId(String applyId) {
		return loanInvestMapper.countInvestRecodByApplyId(applyId);
	}
	@Override
	public int addLoanInvestment(LoanInvestmentVO loanInvestment) {
		return loanInvestMapper.insertSelective(loanInvestment);
	}
	@Override
	public BigDecimal selectNowAmtByApplyId(int applyId) {
		return loanInvestMapper.selectNowAmtByApplyId(applyId);
	}
	@Override
	public Page findloanInvestListByCondition(LoanInvestPOJO loanInvestQueryVo,Page page){
		page.setTotalCount(loanInvestMapper.countInvestList(loanInvestQueryVo, page));
		page.setItems(loanInvestMapper.findAllInvestNum(loanInvestQueryVo, page));
		return page;
	}
	@Override
	public LoanInvestmentVO selectLoanApplyByApplyId(int applyId) {
		return loanInvestMapper.selectByPrimaryKey(applyId);
	}
	@Override
	public List<LoanInvestmentVO> findInvestByApplyId(int applyId) {
		return loanInvestMapper.findInvestByApplyId(applyId);
	}
	
	@Override
	public List<LoanInvestmentVO> findInvestSumByApplyId(int applyId) {
		return loanInvestMapper.findInvestByApplyIdSum(applyId);
	}	
	@Override
	public List<LoanInvestListPOJO> findloanInvestListByConditionAndNum(LoanInvestPOJO loanInvestQueryVo, int startNum) {
		return loanInvestMapper.findloanInvestListByConditionAndNum(loanInvestQueryVo, 7*(startNum-1));
	}
	@Override
	public int getcountloanInvestListByConditionAndNum(LoanInvestPOJO loanInvestQueryVo) {
		Page page= new Page();
		 return loanInvestMapper.countloanInvestListByConditionAndNum(loanInvestQueryVo,page);
	}
	@Override
	public int getcountInvestList(LoanInvestPOJO loanInvestQueryVo) {
		Page page= new Page();
		 return loanInvestMapper.countInvestList(loanInvestQueryVo,page);
	}
	@Override
	public List<LoanInvestListPOJO> findloanInvestListByConditionAndNum1(LoanInvestPOJO loanInvestQueryVo, int startNum) {
		return loanInvestMapper.findloanInvestListByConditionAndNum1(loanInvestQueryVo, 7*(startNum-1));
	}
	@Override
	public int getcountInvestList1(LoanInvestPOJO loanInvestQueryVo) {
		Page page= new Page();
		 return loanInvestMapper.countInvestList1(loanInvestQueryVo,page);
	}
	@Override
	public int countUserInvestTradeDetai(LoanInvestPOJO loanInvestQueryVo, Integer userId) {
		return loanInvestMapper.countUserInvestTradeDetai(loanInvestQueryVo, userId);	
	}
	@Override
	public int updateInvest(LoanInvestmentVO loanInvestment) {
		return loanInvestMapper.updateByPrimaryKeySelective(loanInvestment);
	}
	@Override
	public boolean isLoansByApplyId(int applyId) {
		if(loanInvestMapper.countInvestByApplyIdAndIsLoans(applyId)==0){
			return true;
		}
		return false;
	}
	@Override
	public String findMaxInvestClaimNumber(String orderNumber) {
		return loanInvestMapper.findMaxInvestClaimNumber(orderNumber);
	}
	@Override
	public BigDecimal findMinInvestByApplyId(int applyId) {
		return loanInvestMapper.findMinInvestByApplyId(applyId);
	}
	@Override
	public List<LoanInvestmentVO> findInvestGroupByUserid(int applyId) {
		// TODO Auto-generated method stub
		return loanInvestMapper.findInvestGroupByUserid(applyId);
	}
	@Override
	public List<InvestImportExcelPOJO> InvestImportExcelList(int applyId) {
		// TODO Auto-generated method stub
		return loanInvestMapper.InvestImportExcelList(applyId);
	}
	

}
