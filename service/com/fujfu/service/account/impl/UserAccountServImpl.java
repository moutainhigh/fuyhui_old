package com.fujfu.service.account.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.fujfu.common.payment.fuyou.pojo.QueryBalanceBean;
import com.fujfu.common.payment.fuyou.pojo.response.QueryBalanceResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.account.UserAccountMapper;
import com.fujfu.pojo.account.UserAccountPOJO;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.CapitalMgtServ;
import com.fujfu.service.account.UserAccountServ;

/**
 * 用户账户接口实现类
 */
@Service("userAccountSer")
public class UserAccountServImpl implements UserAccountServ {
	@Resource
	private CapitalMgtServ capitalMgtServ;
	
	@Resource
	private UserAccountMapper mapper; 

	@Override
	public int updateByPrimaryKey(UserAccountVO record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(UserAccountVO record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public UserAccountVO selectByUserId(Integer userId) {
		return mapper.selectByUserId(userId);
	}

	@Override
	public Page findUserAccountByCondition(UserAccountPOJO userAccountVo, Page page) {
		page.setTotalCount(mapper.countUserAccount(userAccountVo, page));
		page.setItems(mapper.findUserAccount(userAccountVo, page));
		return page;
	}

	@Override
	public BigDecimal findUserCashByApplyId(int applyId) {
		return mapper.findUserCashByApplyId(applyId);
	}

	@Override
	public int insert(UserAccountVO record) {
		return mapper.insertSelective(record);
	}

	@Override
	public UserAccountPOJO selectByPrimaryKey(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateUserAccount(UserVO user) {
		if (StringUtils.isNotEmpty(user.getJzhloginid())) {
			// 查询余额
			QueryBalanceBean reqData = new QueryBalanceBean();
			reqData.setCust_no(user.getJzhloginid());
			QueryBalanceResp resp = capitalMgtServ.queryBalance(reqData);

			// 更新账户表
			UserAccountVO ua = new UserAccountVO();
			String respCode = resp.getResponse().getResp_code();
			if (respCode.equals(FyUtil.SUCCESS)) {
				resp = resp.getResponse().getRespList().get(0);// 返回金额单位为分
				ua.setUserId(user.getUserId());
				if (StringUtils.isNotEmpty(resp.getCt_balance())) {
					ua.setTotal(new BigDecimal(resp.getCt_balance()).divide(new BigDecimal(100)));
				}
				if (StringUtils.isNotEmpty(resp.getCf_balance())) {
					ua.setFrost(new BigDecimal(resp.getCf_balance()).divide(new BigDecimal(100)));
				}
				if (StringUtils.isNotEmpty(resp.getCa_balance())) {
					ua.setCash(new BigDecimal(resp.getCa_balance()).divide(new BigDecimal(100)));
				}
				mapper.updateByPrimaryKeySelective(ua);
			}
			
		}
	}

}
