package com.fujfu.service.common.impl;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujfu.common.information.MongateSmsUtil;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.SmsTypeUtil;
import com.fujfu.common.util.StringUtil;
import com.fujfu.dao.common.AuthCodeMapper;
import com.fujfu.dao.common.MessageMapper;
import com.fujfu.dao.user.UserMapper;
import com.fujfu.pojo.AuthCodeVO;
import com.fujfu.pojo.common.MessageVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.common.CommonServ;

/**
 * 公共服务实现类
 * 
 * @author hjz
 * 
 */

@Service
public class CommonServImpl implements CommonServ {

	/**
	 * 用户注册 验证码有效时间<br>
	 */
	public static final long EXPIRE_TIME = 60;

	private Logger log = Logger.getLogger(CommonServImpl.class);

	@Autowired
	private AuthCodeMapper commonMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private MessageMapper messageMapper;

	/**
	 * 检查验证码是否正确
	 * 
	 * @param authCode
	 *            - 验证码
	 * @return 正确 - 1 <br>
	 *         错误/过期 - 0
	 */
	@Override
	public int checkCode(String mobile, String code, String type) {
		/*if("000000".equals(code)) {
			return 1;
		} else {*/
			List<AuthCodeVO> codeList = commonMapper.checkCode(mobile, type);
			if (codeList.size() == 0) {
				return 0;
			}
			AuthCodeVO aCode = codeList.get(0);
			if (!code.equals(aCode.getContent())) {
				return 0;
			}
			int time = (int) (aCode.getExpire() - DateUtil.currentTimeMillis());
			if (time < 0) {
				return 0;
			}
			return 1;
		/*}*/
	}

	/**
	 * 发送短信验证码
	 * 
	 * @param --手机号码
	 * @param bean
	 * @return 失败 - 0 <br>
	 *         成功 - 1
	 */
	@Override
	public int sendMsg(String mobile, String type) {
		AuthCodeVO authCode = new AuthCodeVO();
		String randomNum = StringUtil.getRandom(6);
		String content = "您的验证码是：" + randomNum + "（60秒内有效），请尽快验证。如非本人操作请致电4009-303-606";
		String resp = "";
		if (SmsTypeUtil.REG.equals(type) || SmsTypeUtil.P2P_FIND_PWD.equals(type)||SmsTypeUtil.ADMIN_LOGIN.equals(type)) {
			resp = MongateSmsUtil.sendMsg(mobile, content);
		}
		int flag = 0;
		if (resp.length() > 6) {
			authCode.setUserId(0);
			authCode.setName(mobile);
			authCode.setContent(randomNum);
			authCode.setType(Integer.valueOf(type));
			authCode.setStatus(0);
			authCode.setAddTime(DateUtil.currentTimeMillis());
			authCode.setExpire(DateUtil.currentTimeMillis() + EXPIRE_TIME);
			flag = commonMapper.insertSmsCode(authCode);
		}
		return flag;
	}

	/**
	 * 发送通知短信
	 * 
	 * @param --手机号码
	 * @param str1变量1
	 *            str2变量2
	 * @return
	 */
	@Override
	public int sendRepMobiMsg(String mobile, String type, String str1, String str2, String str3, String str4) {
		MessageVO message = new MessageVO();
		UserVO user = userMapper.getUserByMobile(mobile);
		String content = "";

		switch (type) {
			// 充值, 35,p2p充值成功
			case SmsTypeUtil.P2P_REC_SUC:
				content = "您于" + str1 + "成功充值" + str2 + "元，感谢您对我们的关注与支持！详情可查看www.fuyhui.com";
				break;
			// 提现, 44,p2p提现申请
			case SmsTypeUtil.P2P_WITHDRAWAL_APPLY:
				content = "您于" + str1 + "的提现申请" + str2 + "元，如您的银行账户信息正确无误，您的资金将会于1-2个工作日内到账！详情可查看www.fuyhui.com";
				break;
			// 46,p2p提现失败
			case SmsTypeUtil.P2P_WITHDRAWAL_FAIL:
				content = "您于" + str1 + "申请提现" + str2 + "元未成功，资金已经退回账户，如有需要请您重新提交！详情可查看www.fuyhui.com";
				break;
			// 投标, 37投标成功
			case SmsTypeUtil.P2P_INVEST_SUC:
				content = "您于" + str1 + "购买的" + str2 + "产品，金额" + str3 + "元，审核通过后将开始计算收益！详情可查看www.fuyhui.com";
				break;
			// 债权转让
			// 放款
			// 发送给投资会员
			// 42,p2p借款人放款成功
			case SmsTypeUtil.P2P_PUTOUT_SUC_INV:
				content = "您于" + str1 + "购买的" + str2 + "产品已通过审核，开始计算收益！详情可查看www.fuyhui.com";
				break;
			// 发送给融资会员
			// 43,p2p借款人放款失败
			case SmsTypeUtil.P2P_PUTOUT_SUC_LOAN:
				content = "您于" + str1 + "发布的" + str2 + "产品已通过审核，募集资金已到账！详情可查看www.fuyhui.com";
				break;
			// 还款
			// 47,p2p投资人收到还款
			case SmsTypeUtil.P2P_RECOVERMONEY_SUC:
				content = "您已收到" + str1 + "回款总金额" + str2 + "元，其中本金" + str3 + "元,收益" + str4 + "元！详情可查看www.fuyhui.com";
				break;
			// 50,p2p借款人还款
			case SmsTypeUtil.P2P_REPAY_SUC:
				content = "您的" + str1 + "产品还款总金额" + str2 + "元，其中本金" + str3 + "元,收益" + str4 + "元！详情可查看www.fuyhui.com";
				break;
			// 56,p2p用户修改登录密码
			case SmsTypeUtil.P2P_PASSWORD_UPD:
				content = "您已于" + str1 + "成功修改登录密码，请您牢记。如非本人操作请致电4009-303-606";
				break;
		}
		String resp = "";
		resp = MongateSmsUtil.sendMsg(mobile, content);
		int flag = 0;
		if (resp.length() > 6) {
			message.setContent(content);
			message.setCreated(DateUtil.getUnixTime());
			message.setUserId(user.getUserId());
			message.setType(2);// 1站内信 2短信通知 3邮件
			message.setTitle("1");
			flag = messageMapper.insertSelective(message);
		}
		return flag;
	}

	/**
	 * 发送站内通知
	 * 
	 * @param --
	 * @param str1变量1
	 *            str2变量2 str3变量3 依次传
	 * @return
	 */
	@Override
	public int sendRepMsg(String mobile, String type, String str1, String str2, String str3, String str4) {
		MessageVO message = new MessageVO();
		UserVO user = userMapper.getUserByMobile(mobile);
		String content = "";

		switch (type) {
			// 充值
			// 35,p2p充值成功
			case SmsTypeUtil.P2P_REC_SUC:
				content = "您于" + str1 + "成功充值" + str2 + "元，感谢您对我们的关注与支持！";
				break;
			// 提现
			// 44,p2p提现申请				
			case SmsTypeUtil.P2P_WITHDRAWAL_APPLY:
				content = "您于" + str1 + "的提现申请" + str2 + "元，如您的银行账户信息正确无误，您的资金将会于1-2个工作日内到账。";
				break;
			// 46,p2p提现失败		
			case SmsTypeUtil.P2P_WITHDRAWAL_FAIL:
				content = "您于" + str1 + "申请提现" + str2 + "元未成功，资金已经退回账户，如有需要请您重新提交。";
				break;
			// 投标
			// 37投标成功				
			case SmsTypeUtil.P2P_INVEST_SUC:
				content = "您于" + str1 + "购买的" + str2 + "产品，金额" + str3 + "元，审核通过后将开始计算收益！";
				break;
			// 债权转让
			// 放款
			// 发送给投资会员
			// 42,p2p投资人放款成功				
			case SmsTypeUtil.P2P_PUTOUT_SUC_INV:
				content = "您于" + str1 + "购买的" + str2 + "产品已通过审核，开始计算收益！";
				break;
			// 发送给融资会员	
			case SmsTypeUtil.P2P_PUTOUT_SUC_LOAN:
				content = "您于" + str1 + "发布的" + str2 + "产品已通过审核，募集资金已到账";
				break;
			// 还款
			// 47,p2p投资人收到还款				
			case SmsTypeUtil.P2P_RECOVERMONEY_SUC:
				content = "您已收到" + str1 + "回款总金额" + str2 + "元，其中本金" + str3 + "元,收益" + str4 + "元!";
				break;
			// 50,p2p投资人收到还款			
			case SmsTypeUtil.P2P_REPAY_SUC:
				content = "您的" + str1 + "产品还款总金额" + str2 + "元，其中本金" + str3 + "元,收益" + str4 + "元!";
				break;				
		}
		int flag = 0;
		message.setContent(content);
		message.setCreated(DateUtil.getUnixTime());
		message.setUserId(user.getUserId());
		message.setType(1); // 1站内信 2短信通知 3邮件
		message.setTitle("1");
		flag = messageMapper.insertSelective(message);
		return flag;
	}

	@Override
	public int sendall(String mobile, String type, String str1, String str2, String str3, String str4) {
		sendRepMsg(mobile, type, str1, str2, str3, str4);
		sendRepMobiMsg(mobile, type, str1, str2, str3, str4);
		return 0;

	}

	/**
	 * 检查手机号注册时当天已发短信次数
	 */
	@Override
	public int regSendTimes(String mobile, String type) {
		String today = DateUtil.getCurrentDate("yyyy-MM-dd");
		int startDate = 0;
		int endDate = 0;
		try {
			startDate = DateUtil.convert2int(today, "yyyy-MM-dd");
		} catch (ParseException e) {
			startDate = 0;
			log.info("regSendTimes error = " + e.getMessage());
		}
		endDate = startDate + 60 * 60 * 24;
		return commonMapper.regSendTimes(mobile, type, startDate, endDate);
	}
}
