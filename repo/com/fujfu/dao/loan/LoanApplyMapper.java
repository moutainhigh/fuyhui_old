package com.fujfu.dao.loan;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.invest.LoanApplyListPOJO;
import com.fujfu.pojo.loan.LoanPOJO;
import com.fujfu.pojo.loan.LoanApplyVO;
import com.fujfu.pojo.loan.UserGuarnatySumPOJO;

public interface LoanApplyMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(LoanApplyVO record);

	int insertSelective(LoanApplyVO record);

	LoanApplyVO selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(LoanApplyVO record);
	
	int updateByVersionAndPrimaryKeySelective(LoanApplyVO loanApply);

	int updateByPrimaryKeyWithBLOBs(LoanApplyVO record);

	int updateByPrimaryKey(LoanApplyVO record);

	List<LoanApplyVO> listLoanApplyByStatus(@Param("status") int status);

	List<LoanApplyVO> listLoanApplyByFStatus(@Param("status") int status);

	List<LoanApplyVO> findAllFullBid();

	List<LoanPOJO> findInvest(@Param("isInside") int isInside,@Param("loanType") String loanType, @Param("startPeriod") int startPeriod,
			@Param("endPeriod") int endPeriod, @Param("startNum") int startNum, @Param("pageSize") int pageSize,
			@Param("rateSort") String rateSort, @Param("amountSort") String amountSort,
			@Param("progressSort") String progressSort,@Param("type") String type);

	int countInvest(@Param("isInside") int isInside,@Param("loanType") String loanType, @Param("startPeriod") int startPeriod,
			@Param("endPeriod") int endPeriod,@Param("type") String type);

	LoanPOJO finInvestmentById(@Param("id") int id);

	int countLoan(@Param("loan") LoanPOJO loan);

	List<LoanPOJO> findLoan(@Param("loan") LoanPOJO loan, @Param("page") Page page);

	List<LoanApplyListPOJO> findAllLoanApply(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo,
			@Param("page") Page page);

	/**
	 * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	 */

	/**
	 * 分页查询总记录数
	 * 
	 * @return
	 */
	int countApplyList(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo, @Param("page") Page page);

	int updateLoanApplyStatusByApplyId(@Param("applyId") int applyId, @Param("status") int status);

	List<LoanApplyListPOJO> findloanApplyListByConditionAndNum(
			@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo, @Param("pageNum") int pageNum);

	int countUserLoanApplyTradeDetai(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo,
			@Param("userId") Integer userId);

	List<LoanPOJO> finLoanListByType(@Param("isInside")int isInside,@Param("loanType") String loanType, @Param("startNum") int startNum,
			@Param("pageSize") int pageSize);

	// 前台担保机构查询担保记录
	List<LoanApplyListPOJO> findUserLoanApplyByGuaranteeCompanyId(@Param("guaranteeCompanyId") Integer guaranteeCompanyId,
			@Param("pageSize") int pageSize, @Param("pageNum") int pageNum);

	int countLoanApplyByGuaranteeCompanyId(@Param("guaranteeCompanyId") Integer guaranteeCompanyId);
	//前台担保机构查询担保总金额
	UserGuarnatySumPOJO findUserGuarnatySumMap(@Param("guaranteeCompanyId") Integer guaranteeCompanyId);
	/**
	 * 查询fu_loan_apply表的最大OrderNumber记录
	 * @param orderNumber
	 * @return
	 */
	String findMaxApplyOrderNumber(@Param("nowDateStr")String nowDateStr);
	
	List<LoanApplyVO> findErrorApply();
}