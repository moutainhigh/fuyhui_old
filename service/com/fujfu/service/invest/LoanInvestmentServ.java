package com.fujfu.service.invest;

import java.math.BigDecimal;
import java.util.List;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.invest.InvestImportExcelPOJO;
import com.fujfu.pojo.invest.InvestRecordPOJO;
import com.fujfu.pojo.invest.LoanInvestListPOJO;
import com.fujfu.pojo.invest.LoanInvestmentVO;

public interface LoanInvestmentServ {

	/**
	 * 更新投资记录
	 * 
	 * @param loanInvestment
	 * @return
	 */
	public int updateInvest(LoanInvestmentVO loanInvestment);

	/**
	 * 根据标的id查出该标的的每笔投资情况
	 * 
	 * @param applyId
	 * @return
	 */
	public List<LoanInvestmentVO> findInvestByApplyId(int applyId);
	
	/**
	 * 查询出最小投资金额
	 * @param applyId
	 * @return
	 */
	public BigDecimal findMinInvestByApplyId(int applyId);

	/**
	 * 根据标的id查询该标的是否已经全部放款完毕
	 * 
	 * @param applyId
	 * @return
	 */
	public boolean isLoansByApplyId(int applyId);

	/**
	 * 根据申请id查询投资记录
	 * 
	 * @param applyId
	 * @return
	 */
	public List<InvestRecordPOJO> findInvestByApplyIdAndNum(String applyId, int pageNum);

	/**
	 * 根据申请id统计投资记录条数
	 * 
	 * @param applyId
	 * @return
	 */
	public int countInvestRecodByApplyId(String applyId);

	/**
	 * 添加投资记录
	 * 
	 * @param loanInvestment
	 * @return
	 */
	public int addLoanInvestment(LoanInvestmentVO loanInvestment);

	/**
	 * 根据标的id查询已投资金额
	 * 
	 * @param applyId
	 * @return
	 */
	public BigDecimal selectNowAmtByApplyId(int applyId);

	/**
	 * 根据标的id查询标的信息
	 * 
	 * @param applyId
	 * @return
	 */
	public LoanInvestmentVO selectLoanApplyByApplyId(int applyId);

	/**
	 * 后台管理系统查询所有投资记录
	 * 
	 * @param
	 * @return
	 */
	public Page findloanInvestListByCondition(LoanInvestPOJO loanInvestQueryVo, Page page);

	// 前台管理查询借款信息
	public List<LoanInvestListPOJO> findloanInvestListByConditionAndNum(LoanInvestPOJO loanInvestQueryVo, int pageNum);
	
	public int getcountloanInvestListByConditionAndNum(LoanInvestPOJO loanInvestQueryVo);
	public int getcountInvestList(LoanInvestPOJO loanInvestQueryVo);

	// 前台管理查询我的债权
	public List<LoanInvestListPOJO> findloanInvestListByConditionAndNum1(LoanInvestPOJO loanInvestQueryVo, int pageNum);

	public int getcountInvestList1(LoanInvestPOJO loanInvestQueryVo);
	
	
	public List<LoanInvestmentVO> findInvestSumByApplyId(int applyId);	

	public int countUserInvestTradeDetai(LoanInvestPOJO loanInvestQueryVo, Integer userId);
	/**
	 * 根据标的表的orderNumber查询最大投资债权编号
	 * @return
	 */
	public String findMaxInvestClaimNumber(String orderNumber);
	/**
	* 根据apply_id查询fu_loan_investment表的用户投资分组记录 
	*/
	public List<LoanInvestmentVO> findInvestGroupByUserid(int applyId);
	
	public List<InvestImportExcelPOJO> InvestImportExcelList(int applyId);

}
