package com.fujfu.dao.invest;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.invest.InvestImportExcelPOJO;
import com.fujfu.pojo.invest.InvestRecordPOJO;
import com.fujfu.pojo.invest.LoanInvestListPOJO;
import com.fujfu.pojo.invest.LoanInvestmentVO;

public interface LoanInvestmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanInvestmentVO record);

    int insertSelective(LoanInvestmentVO record);

    LoanInvestmentVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanInvestmentVO record);

    int updateByPrimaryKey(LoanInvestmentVO record);
    
    /**
     * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     */
    BigDecimal selectNowAmtByApplyId(@Param("applyId")int applyId);
    
    List<LoanInvestmentVO> findLenderByApplyId(int id);
    
    List<LoanInvestmentVO> findInvestByApplyId(@Param("applyId")int applyId);
    
    List<LoanInvestmentVO> findInvestByApplyIdSum(@Param("applyId")int applyId);    
    
	List<InvestRecordPOJO> findInvestByApplyIdAndNum(@Param("applyId")String applyId,@Param("startNum")int startNum);
	
	int countInvestRecodByApplyId(@Param("applyId")String applyId);
	
	List<LoanInvestListPOJO> findAllInvestNum(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo, @Param("page") Page page);
	/**
	 * 分页查询总记录数
	 * 
	 * @return
	 */
	int countInvestList(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo, @Param("page") Page page);
	//前台查询申请投资记录
	int countloanInvestListByConditionAndNum(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo, @Param("page") Page page);
	List<LoanInvestListPOJO> findloanInvestListByConditionAndNum(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo, @Param("pageNum") int pageNumm);
    //前台查询我的债权
	int countInvestList1(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo, @Param("page") Page page);	
	List<LoanInvestListPOJO> findloanInvestListByConditionAndNum1(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo, @Param("pageNum") int pageNum);

	int countUserInvestTradeDetai(@Param("loanInvestQueryVo")LoanInvestPOJO loanInvestQueryVo,@Param("userId") Integer userId);

	/**
	 * 统计根据标的id未放款的条数
	 * @param applyId
	 * @return
	 */
	int countInvestByApplyIdAndIsLoans(@Param("applyId")int applyId);

	/**
	 * 根据标的order_number查询fu_loan_investment表的最大claimNumber记录
	 * @param orderNumber
	 * @return
	 */
	String findMaxInvestClaimNumber(@Param("orderNumber")String orderNumber);
	
	/**
	 * 根据applyid查出最小投资金额
	 * @param applyId
	 * @return
	 */
	BigDecimal findMinInvestByApplyId(@Param("applyId")int applyId);
	
	/**
	 * 	<!-- 根据apply_id查询fu_loan_investment表的用户投资分组记录 -->
	 * @param applyId
	 * @return
	 */
	List<LoanInvestmentVO> findInvestGroupByUserid(@Param("applyId")int applyId);
	
	List<InvestImportExcelPOJO> InvestImportExcelList(@Param("applyId")int applyId);
	
}