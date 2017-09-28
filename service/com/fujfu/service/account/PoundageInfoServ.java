package com.fujfu.service.account;

import com.fujfu.pojo.account.PoundageInfoVO;

/**
 * 用户手续费接口
 * @author hf
 *
 */
public interface PoundageInfoServ {

	
	
	/**
	 * 添加手续费记录
	 * @param userWithdrawal
	 * @return
	 */
	public int addPoundageInfo(PoundageInfoVO poundageInfo);
	
	public PoundageInfoVO selectByPrimaryTxnSsn(String txnSsn);
	
}
