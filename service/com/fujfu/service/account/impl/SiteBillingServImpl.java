package com.fujfu.service.account.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.account.SiteBillingMapper;
import com.fujfu.pojo.account.SiteBillingVO;
import com.fujfu.pojo.account.SiteBillingDTO;
import com.fujfu.pojo.user.UserVO;

import com.fujfu.service.account.SiteBillingServ;

/**
 * 充值接口实现类
 */
@Service("SiteBillingSer")
public class SiteBillingServImpl implements SiteBillingServ {
	@Resource
	public SiteBillingMapper siteBillingMapper;

	/**
	 * OutUser 出账用户信息
	 * inUser 入账用户信息
	 * fySerialno 发送富友流水
	 * amt 交易金额
	 * siteBusiType 平台交易类型
	 * siteBusiRem 平台交易备注
	 * message 报文
	 */
	@Override
	public int addSiteBilling(UserVO OutUser, UserVO inUser, String fySerialno, BigDecimal amt,
			String siteBusiType, String siteBusiRem,String message) {
		// TODO Auto-generated method stub
		SiteBillingVO siteBilling = new SiteBillingVO();
		siteBilling.setFySerialno(fySerialno);
		siteBilling.setAmt(amt);
		if(OutUser!=null){
		  siteBilling.setOutUserid(OutUser.getUserId());
		  siteBilling.setOutRealname(OutUser.getRealname());
		  siteBilling.setOutUsername(OutUser.getJzhloginid());
		}else{
			if(!"充值".equals(siteBusiType)&&!"提现".equals(siteBusiType)&&!"投资冻结".equals(siteBusiType)&&!"放款解冻".equals(siteBusiType)){
				siteBilling.setOutRealname("");
				//siteBilling.setOutUserid();
				siteBilling.setOutUsername(FyUtil.MCHNT_USER_ID);
			}
		}
		if(inUser!=null){
		  siteBilling.setInUserid(inUser.getUserId());
		  siteBilling.setInRealname(inUser.getRealname());
		  siteBilling.setInUsername(inUser.getJzhloginid());
		}else{
			if(!"充值".equals(siteBusiType)&&!"提现".equals(siteBusiType)&&!"投资冻结".equals(siteBusiType)&&!"放款解冻".equals(siteBusiType)){
				//siteBilling.setOutRealname("");
				//siteBilling.setOutUserid();
				siteBilling.setInUsername(FyUtil.MCHNT_USER_ID);
			}
		}
		siteBilling.setSiteBusiRem(siteBusiRem);
		siteBilling.setSiteBusiType(siteBusiType);
		siteBilling.setCreated(DateUtil.getUnixTime());
		siteBilling.setMessage(message);
		return siteBillingMapper.insertSelective(siteBilling);
	}

	@Override
	public int updateBusiStatus(Integer statu, String ssn) {
		// TODO Auto-generated method stub
		Integer updateDate =DateUtil.getUnixTime();
		return siteBillingMapper.updateBusiStatusBySSN(statu,updateDate, ssn);
	}

	@Override
	public Page findSiteBillingByCondition(SiteBillingDTO siteBillingQueryVo, Page page) {
		// TODO Auto-generated method stub
		page.setTotalCount(siteBillingMapper.countSiteBilling(siteBillingQueryVo));
		page.setItems(siteBillingMapper.findSiteBillingByCondition(siteBillingQueryVo, page));
		return page;
	}
	
	

}
