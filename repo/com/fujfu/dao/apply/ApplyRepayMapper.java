package com.fujfu.dao.apply;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.apply.ApplyRepayVO;
import com.fujfu.pojo.apply.ApplyRepayPlanPOJO;
import com.fujfu.pojo.apply.ApplyRepayPOJO;
import com.fujfu.pojo.apply.UserRepaySumPOJO;
import com.fujfu.pojo.invest.AllApplyRepayListPOJO;

public interface ApplyRepayMapper {
	int deleteByPrimaryKey(Integer id);

	int insertSelective(ApplyRepayVO record);

	ApplyRepayVO selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ApplyRepayVO record);

	ApplyRepayPOJO findRepayById(@Param("id")int id);

	/**
	 * 根据标的id和还款期数查询当期还款计划
	 * 
	 * @param applyId
	 * @param repayPeriod
	 * @return
	 */
	ApplyRepayVO findRepayByApplyidAndRepayperiod(@Param("applyId") int applyId, @Param("repayPeriod") int repayPeriod);

	/**
	 * 根据标的的id以及费用名查询费率
	 * 
	 * @param applyId
	 * @param feeBase
	 * @param feeName
	 * @return
	 */
	BigDecimal findRateByApplyidAndFeename(@Param("applyId") int applyId, @Param("feeBase") String feeBase,
			@Param("feeName") String feeName);

	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
	/**
	 * 分页查询
	 * 
	 * @param applyRepay
	 * @param page
	 * @return
	 */
	List<ApplyRepayVO> findApplyRepay(@Param("applyRepay") ApplyRepayPOJO applyRepay, @Param("page") Page page);

	/**
	 * 分页查询总记录数
	 * 
	 * @return
	 */
	int countApplyRepay(@Param("applyRepay") ApplyRepayPOJO applyRepay, @Param("page") Page page);
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
	
	
	
	/**
	 * 后台管理系统查询所有还款记录
	 * 
	 * @return
	 */
	List<AllApplyRepayListPOJO> findAllApplyRepayList(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo,
			@Param("page") Page page);

	/**
	 * 后台管理系统查询所有还款记录总记录数
	 * 
	 * @return
	 */
	int countApplyRepayList(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo, @Param("page") Page page);

	int countUserApplyRepayTradeDetai(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo,
			@Param("userId") Integer userId);

	// 前台我的借款查询相关汇总
	UserRepaySumPOJO findUserRepaySumMap(@Param("status") String status, @Param("userId") Integer userId,@Param("applyId") Integer applyId);

	/**>>>>>>>>>>>>>还款计划>>>>>>>>>>>>>>>*/
	List<ApplyRepayPlanPOJO> findApplyRepayPlanByApplyId(@Param("applyId")String applyId, @Param("startNum")int startNum);

	List<ApplyRepayPlanPOJO> findAllApplyRepayPlanByApplyId(@Param("applyId")String applyId);

	int countApplyRepayPlanByApplyId(@Param("applyId")String applyId);

	int countRepaymentReminder();

	List<ApplyRepayVO> findRepaymentReminder(@Param("page")Page page);

	/**
	 * 根据标的id查询最新一期未还的还款计划
	 * @param applyId
	 * @return
	 */
	ApplyRepayVO findApplyRepayByApplyId(@Param("applyId")int applyId);
	
	/**
	 * 根据标的id查询所有未还的
	 * @param applyId
	 * @return
	 */
	List<ApplyRepayVO> findAllApplyRepayByApplyId(@Param("applyId")int applyId);
	
	/**
 	  * 批量更新还款计划表中的状态为已还
 	  * @param applyRepayList
 	  * @return
 	  */
 	 int batchUpdateStatus(List<ApplyRepayVO> applyRepayList);
 	 
 	 /**
 	  * 根据标的id和期数查询当期之前是否存在未还的
 	  * @param applyId
 	  * @param period
 	  * @return
 	  */
 	ApplyRepayVO isExistNotRepayByPeriod(@Param("applyId")int applyId,@Param("period")int period);

}