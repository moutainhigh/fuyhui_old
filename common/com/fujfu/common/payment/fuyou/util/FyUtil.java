package com.fujfu.common.payment.fuyou.util;

/**
 * 通用常量-富友
 * @author huangjizhong
 * @update 2016.06.24
 *
 */
public class FyUtil {
	
	/**	 版本号    */
	public static final String VERSION = "1.41";
	public static final String VER = "0.44";
	

	/**	商户号 测试 */
//	public static final String MCHNT_CD   = "0001200F0040016";//--jzh16/888888
	
	/**	商户号 生产 */
	public static final String MCHNT_CD   = "0005840F0365099";

	/**	金账户id 测试 */
//	public static final String MCHNT_USER_ID   = "jzh16";//--jzh16/888888
	
	/**	金账户id生产 */
	public static final String MCHNT_USER_ID   = "08J36509972b";
	
	/**	test url  */
//	public static final String URL = "https://jzh-test.fuiou.com/jzh/";
	
	/**	product url  */
	public static final String URL = "https://jzh.fuiou.com/";
	
	/**	成功 */
	public static final String SUCCESS = "0000";	
	
	/**	XML ROOT */
	public static final String XML_ROOT = "ap";	
	
	/** xml plain */
	public static final String XML_PLAIN = "plain";	
	
	/** xml sign */
	public static final String XML_SIGNATURE = "signature";	
	
	/** xml results */
	public static final String RESULTS = "results";
	
	/** xml result */
	public static final String RESULT = "result";	
	
	/** 回调地址  开发 */
//	public static final String RET_HOST = "http://127.0.0.1/";
//	public static final String RET_HOST = "http://localhost/";
	
	/** 回调地址  test */
//	public static final String RET_HOST = "http://tfuyhui.fujfu.com/";

	/** 回调地址  准生产 */
//	public static final String RET_HOST = "http://nfuyhui.fujfu.com/";
	
	/**回调地址  生产*/
	public static final String RET_HOST = "https://www.fuyhui.com/";
	
	
	/**	请求数据的编码  */
	public static final String CHAR_SET="UTF-8";
	
	/**	请求超时时间  */
	public static final String TIME_OUT ="20000";
	
	/**	开户注册  */
	public static final String REGISTER = URL + "reg.action";
	
	/**	法人开户注册  */
	public static final String ARTIFREGISTER = URL + "artifReg.action";
	
	/** 开户同步回调地址 */
	public static final String REGIST_RET_URL = RET_HOST + "fy/regIndex";
	
	/** 开户异步回调地址 */
	public static final String REGIST_BG_RET_URL = RET_HOST + "fy/regBehind";
	
	/**	用户信息查询接口 */
	public static final String QUERY_USER_INFO = URL + "queryUserInfs.action";
	
	/**	个人PC端更换手机号接口 */
	public static final String CHG_MOBILE = URL + "400101.action";
	
	/**	个人PC端更换手机号回调地址 */
	public static final String CHG_MOBILE_INDEX = RET_HOST + "fy/chgMobileIndex";
	
	/**	富友密码管理  */
	public static final String PWD_MGT = URL + "resetPassWord.action";
	
	/**	富友密码管理回调地址 */
	public static final String PWD_MGT_INDEX = RET_HOST + "fy/pwdMgtIndex";
	
	/**	更换银行卡  */
	public static final String CHG_CARD = URL + "changeCard2.action";
	
	/**	更换银行卡回调地址 */
	public static final String CHG_CARD_INDEX = RET_HOST + "fy/chgCardIndex";
	
	/**	更换银行卡查询接口  */
	public static final String QUERY_CHG_CARD = URL + "queryChangeCard.action";
	
	/**	余额查询  */
	public static final String QUERY_BALANCE = URL + "BalanceAction.action";

	/**	明细查询接口 */
	public static final String QUERY_DETAIL = URL + "query.action";
	
	/**	交易查询接口 */
	public static final String QUERY_TXN = URL + "queryTxn.action";
	
	/**	充值提现查询接口 */
	public static final String QUERY_CZTX = URL + "querycztx.action";
	
	/**	资金冻结 */
	public static final String FREEZE = URL + "freeze.action";
	
	/**	资金冻结到冻结 */
	public static final String FREEZE_2_F = URL + "transferBuAndFreeze2Freeze.action";
	
	/**	资金解冻 */
	public static final String UN_FREEZE = URL + "unFreeze.action";
	
	/**	转账(商户与个人之间) */
	public static final String TRANSFER_BMU = URL + "transferBmu.action";
	
	/**	划拨(个人与个人之间) */
	public static final String TRANSFER_BU = URL + "transferBu.action";
	
	/**	快速充值  */
	//public static final String FAST_RECHARGE = URL + "500001.action";
	
	/**	快捷充值  */
	public static final String FAST_RECHARGE = URL + "500405.action";
	
	/**	快捷充值同步回调  */
	public static final String FAST_INDEX = RET_HOST + "rep/fastIndex";
	
	/**	快捷充值异步回调  */
	public static final String FAST_BEHIND = RET_HOST + "account/fastBehind";
	
	/**	网银充值 */
	public static final String WEB_RECHARGE = URL + "500002.action";
	
	/**	网银充值同步回调  */
	public static final String WEB_INDEX = RET_HOST + "rep/WebIndex";
	
	/**	网银充值异步回调  */
	public static final String WEB_BEHIND = RET_HOST + "account/WebBehind";
	
	/**	网银充值（17接口 可选个人网银和个人网银） */
	public static final String WEB_RECHARGE1 = URL + "500012.action";
	
	/**	提现接口  */
	public static final String WITHDRAWAL = URL + "500003.action";

	/**	提现同步回调地址  */
	public static final String TX_INDEX = RET_HOST + "rep/txIndex";
	
	/**	提现异步回调地址 */
	public static final String TX_BEHIND = RET_HOST + "account/txBehind";
	
	/**	交易类型 */
	public static final String TYPE_RECHAR = "PW11";//充值
	/**交易类型*/
	public static final String TYPE_WITHDRAW ="PWTX";//提现
	
}

