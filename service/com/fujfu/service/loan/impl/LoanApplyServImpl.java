package com.fujfu.service.loan.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.loan.LoanApplyMapper;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.invest.LoanApplyListPOJO;
import com.fujfu.pojo.loan.LoanPOJO;
import com.fujfu.pojo.loan.LoanApplyVO;
import com.fujfu.pojo.loan.UserGuarnatySumPOJO;
import com.fujfu.service.loan.LoanApplyServ;
@Service("loanApplySer")
public class LoanApplyServImpl implements LoanApplyServ {
	@Resource
	public LoanApplyMapper loanApplyMapper;
	@Override
	public int addLoanApply(LoanApplyVO loanApply) {
		return loanApplyMapper.insertSelective(loanApply);
	}

	@Override
	public int updateLoanApply(LoanApplyVO loanApply) {
		return loanApplyMapper.updateByPrimaryKeySelective(loanApply);
	}

	@Override
	public int delLoanApply(int id) {
		return loanApplyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<LoanApplyVO> listLoanApplyByStatus(int status) {
		return loanApplyMapper.listLoanApplyByStatus(status);
	}

	@Override
	public List<LoanApplyVO> listLoanApplyByFStatus(int status) {
		return loanApplyMapper.listLoanApplyByFStatus(status);
	}
	
	@Override
	public LoanApplyVO selectByPrimaryKey(int id) {
		return loanApplyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<LoanPOJO> listInvest(int isInside,String loanType,String period,int pageSize,int pageNum,String rateSort,String amountSort,String progressSort,String type) {
		int startPeriod = 0;
		int endPeriod = 0;
		if(StringUtils.isNotEmpty(period)){
			if(period.equals("1")){
				endPeriod = 90;
			}
			if(period.equals("2")){
				startPeriod = 90;
				endPeriod = 120;
			}
			if(period.equals("3")){
				startPeriod = 120;
				endPeriod = 360;
			}
			if(period.equals("4")){
				startPeriod = 360;
				endPeriod = 720;
			}
			if(period.equals("5")){
				startPeriod = 720;
				endPeriod = 1080;
			}
		}
		return loanApplyMapper.findInvest(isInside, loanType, startPeriod, endPeriod, pageSize*(pageNum-1), pageSize, rateSort, amountSort, progressSort,type);
	}

	@Override
	public int countInvest(int isInside, String loanType, String period,String type) {
		int startPeriod = 0;
		int endPeriod = 0;
		if(StringUtils.isNotEmpty(period)){
			if(period.equals("1")){
				endPeriod = 90;
			}
			if(period.equals("2")){
				startPeriod = 90;
				endPeriod = 120;
			}
			if(period.equals("3")){
				startPeriod = 120;
				endPeriod = 360;
			}
			if(period.equals("4")){
				startPeriod = 360;
				endPeriod = 720;
			}
			if(period.equals("5")){
				startPeriod = 720;
				endPeriod = 1080;
			}
		}
		return loanApplyMapper.countInvest(isInside, loanType, startPeriod, endPeriod,type);
	}

	@Override
	public LoanPOJO findInvestmentById(int id) {
		return loanApplyMapper.finInvestmentById(id);
	}

	@Override
	public Page findLoanByCondition(LoanPOJO loan, Page page) {
		page.setTotalCount(loanApplyMapper.countLoan(loan));
		page.setItems(loanApplyMapper.findLoan(loan,page));
		return page;
	}
	@Override
	public Page findloanApplyListByCondition(LoanInvestPOJO loanInvestQueryVo,Page page){
		page.setTotalCount(loanApplyMapper.countApplyList(loanInvestQueryVo, page));
		page.setItems(loanApplyMapper.findAllLoanApply(loanInvestQueryVo,page));
		return page;		
	}
	@Override
	public List<LoanApplyListPOJO> findloanApplyListByConditionAndNum(LoanInvestPOJO loanInvestQueryVo,int pageNum) {
		return loanApplyMapper.findloanApplyListByConditionAndNum(loanInvestQueryVo, 10*(pageNum-1));
	}
	@Override
	public int getcountApplyList(LoanInvestPOJO loanInvestQueryVo){
		Page page= new Page();
	 return loanApplyMapper.countApplyList(loanInvestQueryVo,page);
	}
	@Override
	public int updateLoanApplyStatusByApplyId(int applyId,int status) {
		return loanApplyMapper.updateLoanApplyStatusByApplyId(applyId,status);
	}

	@Override
	public int countUserLoanApplyTradeDetai(LoanInvestPOJO loanInvestQueryVo, Integer userId) {
		// TODO Auto-generated method stub
		return loanApplyMapper.countUserLoanApplyTradeDetai(loanInvestQueryVo, userId);
	}
	
	@Override
	public List<LoanPOJO> finLoanListByType(int isInside, String loanType,int pageSize,int pageNum) {		
		return loanApplyMapper.finLoanListByType(isInside,loanType, pageSize*(pageNum-1), pageSize);
	}

	@Override
	public List<LoanApplyListPOJO> findUserLoanApplyByGuaranteeCompanyId(Integer guaranteeCompanyId, int pageSize,
			int pageNum) {
		// TODO Auto-generated method stub
		return loanApplyMapper.findUserLoanApplyByGuaranteeCompanyId(guaranteeCompanyId, pageSize,  pageSize*(pageNum-1));
	}

	@Override
	public int countLoanApplyByGuaranteeCompanyId(Integer guaranteeCompanyId) {
		// TODO Auto-generated method stub
		return loanApplyMapper.countLoanApplyByGuaranteeCompanyId(guaranteeCompanyId);
	}

	@Override
	public UserGuarnatySumPOJO findUserGuarnatySumMap(Integer guaranteeCompanyId) {
		// TODO Auto-generated method stub
		return loanApplyMapper.findUserGuarnatySumMap(guaranteeCompanyId);
	}

	@Override
	public String findMaxApplyOrderNumber(String nowDateStr) {
		// TODO Auto-generated method stub
		return  loanApplyMapper.findMaxApplyOrderNumber(nowDateStr);
	}

	@Override
	public int updateLoanApplyByVersion(LoanApplyVO loanApply) {
		return loanApplyMapper.updateByVersionAndPrimaryKeySelective(loanApply);
	}
}
