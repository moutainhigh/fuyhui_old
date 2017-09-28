package com.fujfu.dao.apply;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.apply.ApplyRecoverVO;
import com.fujfu.pojo.apply.ApplyRecoverPOJO;
import com.fujfu.pojo.apply.RecoverImportExcelPOJO;
import com.fujfu.pojo.apply.UserRecoverSumPOJO;

public interface ApplyRecoverMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ApplyRecoverVO record);

    ApplyRecoverVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApplyRecoverVO record);

    /**
     * 根据标的id和回款期数查询当期回款计划
     * @param applyId
     * @param recoverPeriod
     * @return
     */
    List<ApplyRecoverVO> findRepayByApplyidAndRecoverperiod(@Param("applyId")int applyId,@Param("recoverPeriod")int recoverPeriod);
    /**
   	 * 后台管理系统查询所有收款记录
   	 * 
   	 * @return
   	 */
    
    List<ApplyRecoverVO> findAllRecoverByRecoverperiod(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo, @Param("page") Page page);
    
    /**
	 * 后台管理系统查询所有收款记录总记录数
	 * 
	 * @return
	 */
	int countApplyRecover(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo, @Param("page") Page page);
	
	 /**
   	 * 前台管理系统查询所有收款记录
   	 * 
   	 * @return
   	 */
    List<ApplyRecoverVO> findloanRecoverListByConditionAndNum(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    /**
     * 根据标的id查询回款计划
     * @param applyId
     * @return
     */
	List<ApplyRecoverPOJO> findRepayByApplyId(@Param("applyId")String applyId,@Param("startNum")int startNum);
	
	List<ApplyRecoverPOJO> findAllRepayByApplyId(@Param("applyId")String applyId);

	/**
	 * 根据标的id统计回款计划
	 * @param applyId
	 * @return
	 */
	int countRepayByApplyId(@Param("applyId")String applyId);
	int countUserRecoverTradeDetai(@Param("loanInvestQueryVo")LoanInvestPOJO loanInvestQueryVo,@Param("userId") Integer userId);

	//前台我的债权查询相关汇总
	UserRecoverSumPOJO  findUserRecoverSumMap(@Param("status") String status,@Param("userId") Integer userId);
	//前台我的债权查询相关汇总
	UserRecoverSumPOJO  findUserRecoverSumMap1(@Param("status") String status,@Param("userId") Integer userId,@Param("investId") Integer investId);
	
	List<ApplyRecoverVO> findRecoverGroupByUserid(@Param("applyId")Integer applyId, @Param("userId")Integer userId);
	
	List<RecoverImportExcelPOJO> recoverImportExcelList(@Param("applyId")Integer applyId,@Param("period")Integer period);

	/**
	 * 根据标的id查询所有未还的
	 * @param applyId
	 * @return
	 */
	List<ApplyRecoverVO> findAllApplyRecoverByApplyId(@Param("applyId")int applyId);
	
	/**
 	  * 批量更新回款计划表中的状态为已还
 	  * @param applyRepayList
 	  * @return
 	  */
 	 int batchUpdateStatus(List<ApplyRecoverVO> applyRecoverList);
	
}