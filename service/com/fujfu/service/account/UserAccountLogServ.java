package com.fujfu.service.account;

import java.util.List;

import com.fujfu.pojo.account.UserAccountLogVO;
import com.fujfu.pojo.account.UserAccountLogPOJO;

/**
 * 用户账户流水接口类
 */
public interface UserAccountLogServ {

	public int insert(UserAccountLogVO record);

	public int insertSelective(UserAccountLogVO record);

	public UserAccountLogVO selectByPrimaryKey(Integer id);

	/**
	 * 前台账户中心交易明细查询
	 * 
	 * @return
	 */
	public List<UserAccountLogVO> findUserAllUserAccountLog(UserAccountLogPOJO userAccountLogQuery, int pageNum);

	public int countUseAccountLog(UserAccountLogPOJO userAccountLogQuery);

	public int updateByApplyId(Integer applyId, Integer status, Integer type);

	public String findMaxBusiNumber(String nowDateStr);

	public String findSumMoneyBy(UserAccountLogPOJO userAccountLogQuery);
}
