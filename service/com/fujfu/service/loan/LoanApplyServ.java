package com.fujfu.service.loan;

import java.util.List;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.loan.LoanPOJO;
import com.fujfu.pojo.loan.LoanApplyVO;
import com.fujfu.pojo.loan.UserGuarnatySumPOJO;
import com.fujfu.pojo.invest.LoanApplyListPOJO;

public interface LoanApplyServ {
	/**
	 * 添加标的
	 */
	public int addLoanApply(LoanApplyVO loanApply);

	/**
	 * 更新标的
	 */
	public int updateLoanApply(LoanApplyVO loanApply);
	
	/**
	 * 更新版本标的
	 */
	public int updateLoanApplyByVersion(LoanApplyVO loanApply);

	/**
	 * 删除标的
	 */
	public int delLoanApply(int id);

	/**
	 * 根据状态列出所有的借款申请
	 */
	public List<LoanApplyVO> listLoanApplyByStatus(int status);

	/**
	 * 根据非某状态列出所有的借款申请
	 */
	public List<LoanApplyVO> listLoanApplyByFStatus(int status);

	/**
	 * 根据id查询标的信息
	 */
	public LoanApplyVO selectByPrimaryKey(int id);

	/**
	 * 根据标的id修改标的状态
	 */
	public int updateLoanApplyStatusByApplyId(int applyId, int status);

	/**
	 * 投资列表
	 */
	public List<LoanPOJO> listInvest(int isInside,String loanType, String period, int pageSize, int pageNum, String rateSort,
			String amountSort, String progressSort,String type);

	/**
	 * 记录数
	 */
	public int countInvest(int isInside,String loanType, String period,String type);

	/**
	 * 根据id查找标的详情
	 */
	public LoanPOJO findInvestmentById(int id);

	/**
	 * 条件查询标的信息
	 */
	public Page findLoanByCondition(LoanPOJO loan, Page page);
	
	/**
	 * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	 */
	
	
	/**
	 * 后台管理查询借款记录
	 * 
	 * @param loan
	 * @param page
	 * @return
	 */
	public Page findloanApplyListByCondition(LoanInvestPOJO loanInvestQueryVo, Page page);
	
	
	
	// 前台管理查询借款信息
	public List<LoanApplyListPOJO> findloanApplyListByConditionAndNum(LoanInvestPOJO loanInvestQueryVo, int pageNum);

	public int getcountApplyList(LoanInvestPOJO loanInvestQueryVo);

	public int countUserLoanApplyTradeDetai(LoanInvestPOJO loanInvestQueryVo, Integer userId);

	public List<LoanPOJO> finLoanListByType(int isInside,String loanType, int pageSize, int pageNum);

	public List<LoanApplyListPOJO> findUserLoanApplyByGuaranteeCompanyId(Integer guaranteeCompanyId, int pageSize,
			int pageNum);

	public int countLoanApplyByGuaranteeCompanyId(Integer guaranteeCompanyId);
	//前台担保机构查询担保总金额
	public UserGuarnatySumPOJO findUserGuarnatySumMap(Integer guaranteeCompanyId);
	/**
	 * 查询最大投资债权编号
	 * @return
	 */
	public String findMaxApplyOrderNumber(String nowDateStr);

}
