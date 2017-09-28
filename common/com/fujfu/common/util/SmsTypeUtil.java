package com.fujfu.common.util;

public class SmsTypeUtil {

	public static final String REG = "10";		 	 // type=10,fbd,p2p注册验证码
	public static final String FBD_CARD = "11";	 	 // type=11,fbd绑卡验证码
	public static final String FBD_LENDER = "12";	 // type=12,fbd 分期支付
	public static final String FBD_FIND_PWD = "13";	 // type=13,fbd忘记密码
	
	public static final String ADMIN_LOGIN = "14";	 // type=13,fbd忘记密码
	
	public static final String P2P_FIND_PWD = "30";	 // type=30,p2p忘记密码
	public static final String P2P_GAI_PWD = "34";	 // type=34,p2p修改手机号码
	public static final String P2P_REC_SUC = "35";	 // type=35,p2p充值成功
	public static final String P2P_REC_FAIL = "36";	 // type=36,p2p充值失败
	public static final String P2P_INVEST_SUC = "37";	 // type=37,p2p投资人投标成功
	public static final String P2P_INVEST_FAIL = "38";	 // type=38,p2p投资人投标流标
	public static final String P2P_BUY_SUC = "39";	 // type=39,p2p投资人成功购买债权
	public static final String P2P_TRANSFER_SUC = "40";	 // type=40,p2p债权转让人转让债权成功
	public static final String P2P_TRANSFER_FAIL = "41";	 // type=41,p2p债权转让人转让债权失败
	public static final String P2P_PUTOUT_SUC_INV = "42";	 // type=42,p2p投资人放款成功
	public static final String P2P_PUTOUT_SUC_LOAN = "43";	 // type=43,p2p借款人放款成功
	public static final String P2P_WITHDRAWAL_APPLY = "44";	 // type=44,p2p所有人提现申请
	public static final String P2P_WITHDRAWAL_SUC = "45";	 // type=45,p2p所有人提现成功
	public static final String P2P_WITHDRAWAL_FAIL = "46";	 // type=46,p2p所有人提现失败
	public static final String P2P_RECOVERMONEY_SUC = "47";	 // type=47,p2p投资人收到还款
	public static final String P2P_RECOVERINTEREST_SUC = "48";	 // type=48,p2p投资人收到本金还款
	public static final String P2P_RECOVERREMAIN_SUC = "49";	 // type=49,p2p投资人收到利息还款
	public static final String P2P_REPAY_SUC = "50";	 // type=50,p2p借款人还款成功
	public static final String P2P_REPAY_WARN = "51";	 // type=51,p2p借款人还款提醒
	public static final String P2P_REPAY_ADVANCE = "52";	 // type=52,p2p借款人提前还款
	public static final String P2P_RECOVERREMAIN_OVERDUE = "53";	 // type=53,p2p借款人逾期
	public static final String P2P_ISN_ADVANCE = "54";	 // type=54,p2p机构垫款
	public static final String P2P_BORROWER_ADVANCE = "55";	 // type=55,p2p借款人被垫付
	public static final String P2P_PASSWORD_UPD = "56";	 // type=55,p2p修改密码
}
