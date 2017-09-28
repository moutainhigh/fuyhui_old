package com.fujfu.service.recover;

import java.util.List;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.apply.ApplyRecoverVO;
import com.fujfu.pojo.apply.RecoverImportExcelPOJO;
import com.fujfu.pojo.apply.UserRecoverSumPOJO;

public interface RecoverServ {

	/**
	 * 后台管理系统查询所有收款记录
	 * 
	 * @param
	 * @return
	 */
	public Page findAllApplyRecoverListByCondition(LoanInvestPOJO loanInvestQueryVo, Page page);

	/**
	 * 前台管理系统查询所有收款记录
	 * 
	 * @param
	 * @return
	 */
	// 前台管理查询借款信息
	public List<ApplyRecoverVO> findloanRecoverListByConditionAndNum(LoanInvestPOJO loanInvestQueryVo, int pageNum,
			int pageSize);

	public int getcountRecoverList(LoanInvestPOJO loanInvestQueryVo);

	public int countUserRecoverTradeDetai(LoanInvestPOJO loanInvestQueryVo, Integer userId);

	// 前台我的债权查询相关汇总
	public UserRecoverSumPOJO findUserRecoverSumMap(String status, Integer userId);

	// 前台我的债权查询相关汇总
	public UserRecoverSumPOJO findUserRecoverSumMap1(String status, Integer userId, Integer investId);

	/**
	 * 根据apply_id和userid查询fu_apply_recover表的用户回款计划分组记录
	 */
	public List<ApplyRecoverVO> findRecoverGroupByUserid(Integer applyId, Integer userId);

	public List<RecoverImportExcelPOJO> recoverImportExcelList(Integer applyId, Integer period);
}
