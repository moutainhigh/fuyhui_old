package com.fujfu.service.lender;

import java.util.List;

import com.fujfu.pojo.apply.ApplyRecoverVO;
import com.fujfu.pojo.apply.ApplyRepayVO;
import com.fujfu.pojo.user.UserVO;

public interface LenderServ {
	
	/**
	 * 根据标的id查询出该标的的投资人信息
	 * @return
	 */
	public List<UserVO> findInvestorByBidId(Long applyId);
	
	/**
	 * 添加还款计划
	 * @return
	 */
	public int addPaymentRecord(ApplyRepayVO applyRepay);
	
	/**
	 * 添加回款计划
	 * @param applyRecover
	 * @return
	 */
	public int addRecoverRecord(ApplyRecoverVO applyRecover);
	
}
