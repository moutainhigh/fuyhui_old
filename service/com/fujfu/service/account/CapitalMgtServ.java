package com.fujfu.service.account;

import com.fujfu.common.payment.fuyou.pojo.CapitalFreezeBean;
import com.fujfu.common.payment.fuyou.pojo.CapitalUnFreezeBean;
import com.fujfu.common.payment.fuyou.pojo.QueryBalanceBean;
import com.fujfu.common.payment.fuyou.pojo.QueryReOrWithDetailsBean;
import com.fujfu.common.payment.fuyou.pojo.QueryTransactionDetailsBean;
import com.fujfu.common.payment.fuyou.pojo.TransBmuBean;
import com.fujfu.common.payment.fuyou.pojo.TransBuBean;
import com.fujfu.common.payment.fuyou.pojo.TransBuFreeze2FreezeBean;
import com.fujfu.common.payment.fuyou.pojo.response.CapitalFreezeResp;
import com.fujfu.common.payment.fuyou.pojo.response.CapitalUnFreezeResp;
import com.fujfu.common.payment.fuyou.pojo.response.QueryBalanceResp;
import com.fujfu.common.payment.fuyou.pojo.response.QueryReOrWithDetailsBeanResp;
import com.fujfu.common.payment.fuyou.pojo.response.QueryTransactionDetailsBeanResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBmuResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBuFreeze2FreezeResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBuResp;
import com.fujfu.pojo.user.UserVO;

/**
 * 资金管理接口类
 */
public interface CapitalMgtServ {

	/**	资金冻结 */
	public CapitalFreezeResp capitalFreeze(CapitalFreezeBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem);
	
	/**	资金解冻 */
	public CapitalUnFreezeResp capitalUnFreeze(CapitalUnFreezeBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem);
	
	/**	转账(商户与个人之间) 登记流水*/
	public TransBmuResp transferBmu(TransBmuBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem);
	
//	/**	转账(商户与个人之间) */
//	public TransBmuResp transferBmu(TransBmuBean reqData);
	
	/**	划拨(个人与个人之间) */
	public TransBuResp transferBu(TransBuBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem);
	
	/** 用户余额查询 */
	public QueryBalanceResp queryBalance(QueryBalanceBean reqData);
	
	/** 冻结到冻结接口  */
	public TransBuFreeze2FreezeResp freeze2f(TransBuFreeze2FreezeBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem);
	
	/** 用户充值提现查询  */
	public QueryReOrWithDetailsBeanResp QueryReOrWithDetails(QueryReOrWithDetailsBean reqData);
	
	/** 用户充值提现查询  */
	public QueryTransactionDetailsBeanResp QueryTransactionDetails(QueryTransactionDetailsBean reqData);
}
