package com.fujfu.service.account;

import java.math.BigDecimal;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.UserAccountPOJO;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.user.UserVO;

/**
 * 用户账户接口类
 */
public interface UserAccountServ {

	public int insert(UserAccountVO record);

	public UserAccountPOJO selectByPrimaryKey(int id);

	public int updateByPrimaryKey(UserAccountVO record);

	/**
	 * 根据标的id查询出借款人账户可用余额
	 */
	public BigDecimal findUserCashByApplyId(int applyId);

	/**
	 * 更新用户账户
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(UserAccountVO record);

	public UserAccountVO selectByUserId(Integer userId);

	public Page findUserAccountByCondition(UserAccountPOJO userAccountVo, Page page);
	
	public void updateUserAccount(UserVO user);

}
