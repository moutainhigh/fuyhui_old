package com.fujfu.service.user.impl;

import org.springframework.stereotype.Service;

import com.fujfu.common.payment.fuyou.UserMgt;
import com.fujfu.common.payment.fuyou.pojo.ChangeCardBean;
import com.fujfu.common.payment.fuyou.pojo.ChangeMobileBean;
import com.fujfu.common.payment.fuyou.pojo.PasswordMgtBean;
import com.fujfu.common.payment.fuyou.pojo.QueryChgCardBean;
import com.fujfu.common.payment.fuyou.pojo.QueryUserInfoBean;
import com.fujfu.common.payment.fuyou.pojo.UserArtifRegBean;
import com.fujfu.common.payment.fuyou.pojo.UserRegBean;
import com.fujfu.common.payment.fuyou.pojo.response.QueryChgCardResp;
import com.fujfu.common.payment.fuyou.pojo.response.QueryUserInfoResp;
import com.fujfu.common.payment.fuyou.pojo.response.UserRegResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.service.user.UserFyMgtServ;

/** 
 * 用户富友服务类实现类
 *
 * @author huangjizhong
 * @update 2016.06.24
 */


@Service
public class UserFyMgtServImpl implements  UserFyMgtServ{

	/**
	 * 开户2.0
	 * @throws Exception 
	 */
	@Override
	public UserRegResp userRegister(UserRegBean reqData) throws Exception {
		UserRegResp respData = null;
		
			reqData.setMchnt_cd(FyUtil.MCHNT_CD);
			respData = UserMgt.regist(reqData);
		
		return respData;
	}
	
	/**
	 * 法人开户2.0
	 */
	@Override
	public UserRegResp userArtifRegister(UserArtifRegBean reqData) {
		UserRegResp respData = null;
		try {
			reqData.setMchnt_cd(FyUtil.MCHNT_CD);
			reqData.setEmail(reqData.getEmail());
			reqData.setRem(reqData.getRem());
			respData = UserMgt.regist(reqData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respData;
	}

	/**
	 * 用户信息查询
	 */
	@Override
	public QueryUserInfoResp queryUserInfo(QueryUserInfoBean bean) {
		QueryUserInfoResp resp = new QueryUserInfoResp();
		try {
			bean.setVer(FyUtil.VER);
			bean.setMchnt_cd(FyUtil.MCHNT_CD);
			bean.setMchnt_txn_dt(DateUtil.getCurrentDate("yyyyMMdd"));//yyyymmdd
			bean.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
			resp = UserMgt.queryInfo(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	/**
	 *  用户修改手机号  
	 */
	@Override
	public ChangeMobileBean changeMobile(ChangeMobileBean reqData) {
		try {
			reqData.setMchnt_cd(FyUtil.MCHNT_CD);
			reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
			reqData = UserMgt.changeMobile(reqData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reqData;
	}
	
	/**
	 *  用户密码管理
	 */
	@Override
	public PasswordMgtBean passwordMgt(PasswordMgtBean reqData) {
		try {
			reqData.setMchnt_cd(FyUtil.MCHNT_CD);
			reqData.setMchnt_txn_ssn("FYCS"+DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
			reqData = UserMgt.passwordMgt(reqData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reqData;
	}
	
	/**
	 *  用户更换银行卡
	 */
	@Override
	public ChangeCardBean changeCard(ChangeCardBean reqData) {
		try {
			reqData.setMchnt_cd(FyUtil.MCHNT_CD);
			reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
			reqData = UserMgt.changeCard(reqData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reqData;
	}
	
	/**
	 *  用户更换银行卡
	 */
	@Override
	public QueryChgCardResp queryChgCard(QueryChgCardBean reqData) {
		QueryChgCardResp respData = new QueryChgCardResp();
		try {
			reqData.setMchnt_cd(FyUtil.MCHNT_CD);
			reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
			reqData.setTxn_ssn("20160711161908");//更换卡时的流水号
			respData = UserMgt.queryChgCard(reqData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respData;
	}

}
	
	