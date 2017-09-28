package com.fujfu.service.account.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.payment.fuyou.CapitalMgt;
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
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.CapitalMgtServ;
import com.fujfu.service.account.SiteBillingServ;

/**
 * 资金管理实现类
 * @author hjz
 *
 */
@Service
public class CapitalMgtServImpl implements CapitalMgtServ {
	@Resource
	private SiteBillingServ siteBillingServ;

	/**	
	 * 资金冻结 
	 */
	@Override
	public CapitalFreezeResp capitalFreeze(CapitalFreezeBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem) {
		CapitalFreezeResp respData = new CapitalFreezeResp();
		try {
			respData = CapitalMgt.capitalFreeze(reqData, outUser, inUser, siteBusiType,  siteBusiRem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respData;
	}
//	/**	
//	 * 资金冻结 
//	 */
//	@Override
//	public CapitalFreezeResp capitalFreeze(CapitalFreezeBean reqData) {
//		CapitalFreezeResp respData = new CapitalFreezeResp();
//		try {
//			respData = CapitalMgt.capitalFreeze(reqData);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return respData;
//	}
	/**	
	 * 资金解冻记流水
	 */
	@Override
	public CapitalUnFreezeResp capitalUnFreeze(CapitalUnFreezeBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem) {
		CapitalUnFreezeResp respData = new CapitalUnFreezeResp();
		try {
			respData = CapitalMgt.capitalUnFreeze(reqData, outUser, inUser, siteBusiType,  siteBusiRem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respData;
	}
//	/**	
//	 * 资金解冻
//	 */
//	@Override
//	public CapitalUnFreezeResp capitalUnFreeze(CapitalUnFreezeBean reqData) {
//		CapitalUnFreezeResp respData = new CapitalUnFreezeResp();
//		try {
//			respData = CapitalMgt.capitalUnFreeze(reqData);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return respData;
//	}
	/**	
	 * 转账(商户与个人之间 登记流水) 
	 */
	@Override
	public TransBmuResp transferBmu(TransBmuBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem) {
		TransBmuResp respData = new TransBmuResp();
		//保存对账信息
		try {
			respData = CapitalMgt.transferBmu(reqData, outUser, inUser, siteBusiType, siteBusiRem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respData;
	}
	
//	/**	
//	 * 转账(商户与个人之间) 
//	 */
//	@Override
//	public TransBmuResp transferBmu(TransBmuBean reqData) {
//		TransBmuResp respData = new TransBmuResp();
//		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
//		//reqData.setContract_no("201607081706");//预授权合同号-付款用户为个人用户时该字段有效
//		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
//		try {
//			respData = CapitalMgt.transferBmu(reqData);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return respData;
//	}
	/**	
	 * 划拨(个人与个人之间) 
	 */
	@Override
	public TransBuResp transferBu(TransBuBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem) {
		TransBuResp respData = new TransBuResp();
		try {
			respData = CapitalMgt.transferBu(reqData, outUser, inUser, siteBusiType, siteBusiRem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respData;
	}

	/**
	 * 查询余额
	 */
	@Override
	public QueryBalanceResp queryBalance(QueryBalanceBean reqData) {
		QueryBalanceResp resp = new QueryBalanceResp();
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		reqData.setMchnt_txn_dt(DateUtil.getCurrentDate("yyyyMMdd"));//yyyymmdd
		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
		try {
			resp = CapitalMgt.queryBalance(reqData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	/**
	 * 资金冻结到冻结	
	 */
	@Override
	public TransBuFreeze2FreezeResp freeze2f(TransBuFreeze2FreezeBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem) {
		TransBuFreeze2FreezeResp resp = new TransBuFreeze2FreezeResp();
		try {
			resp = CapitalMgt.freeze2freeze(reqData, outUser, inUser, siteBusiType, siteBusiRem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@Override
	public QueryReOrWithDetailsBeanResp QueryReOrWithDetails(QueryReOrWithDetailsBean reqData) {
		// TODO Auto-generated method stub
		QueryReOrWithDetailsBeanResp resp = new QueryReOrWithDetailsBeanResp();
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
		reqData.setVer(FyUtil.VER);
		try {
			resp = CapitalMgt.queryReOrWithDetails(reqData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	
	@Override
	public QueryTransactionDetailsBeanResp QueryTransactionDetails(QueryTransactionDetailsBean reqData) {
		// TODO Auto-generated method stub
		QueryTransactionDetailsBeanResp resp = new QueryTransactionDetailsBeanResp();
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
		try {
			resp = CapitalMgt.queryTransactionDetails(reqData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
}
