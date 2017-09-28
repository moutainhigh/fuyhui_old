
package com.fujfu.web.account;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.common.payment.fuyou.pojo.CashRefundBean;
import com.fujfu.common.payment.fuyou.pojo.RechargeReportBean;
import com.fujfu.common.payment.fuyou.pojo.TransBmuBean;
import com.fujfu.common.payment.fuyou.pojo.response.RechargeReportResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBmuResp;
import com.fujfu.common.payment.fuyou.pojo.response.UserRechargeResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.payment.fuyou.util.SecurityUtils;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.FyReturnCode;
import com.fujfu.common.util.SmsTypeUtil;
import com.fujfu.common.util.StringUtil;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.common.util.XMLUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.PoundageInfoVO;
import com.fujfu.pojo.account.SiteAccountLogVO;
import com.fujfu.pojo.account.SiteAccountVO;
import com.fujfu.pojo.account.UserAccountLogVO;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.account.UserRechargeVO;
import com.fujfu.pojo.account.UserRechargeDTO;
import com.fujfu.pojo.account.UserWithdrawalVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.CapitalMgtServ;
import com.fujfu.service.account.FyReportServ;
import com.fujfu.service.account.PoundageInfoServ;
import com.fujfu.service.account.RechargeServ;
import com.fujfu.service.account.SiteAccountLogServ;
import com.fujfu.service.account.SiteAccountServ;
import com.fujfu.service.account.SiteBillingServ;
import com.fujfu.service.account.UserAccountLogServ;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.account.WithdrawalServ;
import com.fujfu.service.common.CommonServ;
import com.fujfu.service.fee.SiteFeeServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.web.BaseController;

/**
 * 通知直连接口（HTTP形式）- 控制器类
 * 
 * @author huangjizhong
 * @update 2016-07-13
 *
 */
@Controller
@RequestMapping("/rep/*")
public class FyReportCtrl extends BaseController {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(FyReportCtrl.class);
	@Autowired
	private FyReportServ fyReportServ;
	@Autowired
	private RechargeServ rechargeServ;
	@Autowired
	private WithdrawalServ withdrawalServ;
	@Autowired
	private UserServ userServ;
	@Autowired
	private SiteFeeServ siteFeeServ;
	@Autowired
	private CapitalMgtServ capitalMgtServ;
	@Autowired
	private PoundageInfoServ poundageInfoServ;
	@Resource
	private UserAccountServ userAccountServ;
	@Resource
	private UserAccountLogServ userAccountLogServ;
	@Resource
	private CommonServ commonServ;
	@Resource
	private SiteAccountLogServ siteAccountLogServ;
	@Resource
	private SiteAccountServ siteAccountServ;
	@Resource
	private SiteBillingServ siteBillingServ;

	/**
	 * 充值通知接口
	 * 
	 */

	@RequestMapping("recharge")
	public void recharge(HttpServletRequest request, HttpServletResponse response, RechargeReportBean reqData,
			RechargeReportResp respData, Model model) throws IOException {
		// 富友成功后才会进行通知

		respData = fyReportServ.rechargeReport(reqData);
		String inputStr = reqData.regSignVal();
		log.info("inputStr = " + inputStr);
		log.info("系统加密后密文inputStrjiami = " + SecurityUtils.sign(inputStr));
		log.info("富友返回的密文 = " + reqData.getSignature());

		boolean flag = SecurityUtils.verifySign(inputStr, reqData.getSignature());// 验签结果
		log.info("充值通知验签结果recharge = " + flag);

		if (flag) {
			log.info("yanqianjieguo = 成功");
		} else {
			log.info("yanqianjieguo = 失败");
		}

		// 根据手机号码查询本系统的用户信息
		UserVO user = userServ.getUserByMobile(reqData.getMobile_no());
		if (flag) {
			// 验签成功进行更新数据库
			// 1根据流水号查出充值记录号

			UserRechargeVO userRecharge = null;
			try {
				userRecharge = rechargeServ.selectBybillno(reqData.getMchnt_txn_ssn());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			PoundageInfoVO poundageInfo = poundageInfoServ.selectByPrimaryTxnSsn(reqData.getMchnt_txn_ssn());
			if (userRecharge == null && poundageInfo != null) {// 判断是否有充值记录，
																// 没有则新加
				// 充值成功修改 对账表信息
			    siteBillingServ.updateBusiStatus(0, reqData.getMchnt_txn_ssn());
				log.info("掉单充值通知进行数据的更新");
				user = userServ.getUserByUserId(user.getUserId());
				// 1： 新增-用户充值表
				Integer userId = Integer.valueOf(user.getUserId());
				userRecharge = new UserRechargeVO();
				userRecharge.setUserId(userId);
				userRecharge.setBillno(reqData.getMchnt_txn_ssn());
				userRecharge.setMoney(new BigDecimal(reqData.getAmt()).divide(new BigDecimal(100)));
				userRecharge.setStatus(1);// 1为已生效
				userRecharge.setCreateTime(DateUtil.getUnixTime());

				userRecharge.setFee(poundageInfo.getPoundageatm());
				// 生成充值编号
				String rechargeNumber = "";
				String oldMaxRechargeNumber = rechargeServ
						.findMaxRechargeNumber("CZ" + DateUtil.getCurrentDate("yyyyMMdd"));
				System.out.println("oldMaxRechargeNumber==" + oldMaxRechargeNumber);
				if ("".equals(oldMaxRechargeNumber) || oldMaxRechargeNumber == null) {
					rechargeNumber = "CZ" + DateUtil.getCurrentDate("yyyyMMdd") + "00001";
				} else {
					rechargeNumber = UserAccountUtil.getRechargeNumber(oldMaxRechargeNumber);
				}
				System.out.println("rechargeNumber==" + rechargeNumber);
				userRecharge.setRechargeNumber(rechargeNumber);
				rechargeServ.addUserRecharge(userRecharge);
				// 保存充值产生的账户明细信息
				updateUserAccount(user);// 更新本地账户信息
				// 修改状态
				UserAccountLogVO userAccountLog = new UserAccountLogVO();
				// 保存充值明细信息到userAccountLog表
				// 3： 保存一条实时账户信息到 userAccountLog 表，
				UserAccountVO userAccount = userAccountServ.selectByUserId(userId);// 查询本地账户信息
				userAccountLog.setUserId(userId);
				userAccountLog.setType(4100);
				userAccountLog.setMoney(userRecharge.getMoney());
				userAccountLog.setTotal(userAccount.getTotal());
				userAccountLog.setFrost(userAccount.getFrost());
				userAccountLog.setCash(userAccount.getCash());
				userAccountLog.setAddTime(DateUtil.getUnixTime());
				userAccountLog.setApplyId(userRecharge.getRechargeId());
				userAccountLog.setStatus(0);
				// userAccountLog.setFrom(user.getUserId());
				// userAccountLog.setTo();
				userAccountLog.setMemo("");
				userAccountLog.setBusiNumber(userRecharge.getRechargeNumber());
				userAccountLogServ.insertSelective(userAccountLog);

				// 4： 发送站内通知

				// 发送站内通知充值成功
				commonServ.sendall(user.getMobile(), SmsTypeUtil.P2P_REC_SUC,
						DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"), userRecharge.getMoney().toString(), "", "");

				if (userRecharge.getFee().doubleValue() > 0) {// 充值手续费
					// 发送转账接口到富友
					TransBmuBean transBmuBean = new TransBmuBean();
					BigDecimal amt2 = userRecharge.getFee().multiply(new BigDecimal("100"));
					BigDecimal amt3 = amt2.divide(new BigDecimal("1"), 0, BigDecimal.ROUND_HALF_UP);
					transBmuBean.setAmt(amt3.toString());// 金额
					transBmuBean.setOut_cust_no(user.getJzhloginid());// 转出账户
					transBmuBean.setIn_cust_no(FyUtil.MCHNT_USER_ID);// 转入账户
					String transBmuRespCode = "";
					TransBmuResp transBmuRespData = new TransBmuResp();
					try {
						// 转账时传入入账用户信息，平台交易类型，平台交易备注
						transBmuRespData = capitalMgtServ.transferBmu(transBmuBean, user, null, "充值手续费",
								userRecharge.getRechargeNumber());
						transBmuRespCode = transBmuRespData.getResponse().getResp_code();
					} catch (Exception e) {
						log.info("收取充值手续费时系统异常！流水号：" + transBmuBean.getMchnt_txn_ssn() + ",充值编号："
								+ userRecharge.getRechargeId());
						e.printStackTrace();
					}
					if (FyUtil.SUCCESS.equals(transBmuRespCode)) {
						log.info("transBmuRespCode = " + transBmuRespCode + "转账成功,从" + user.getJzhloginid() + "转出"
								+ userRecharge.getFee() + "到" + FyUtil.MCHNT_USER_ID);
						// 转账成功修改 对账表信息
						siteBillingServ.updateBusiStatus(0, transBmuRespData.getResponse().getMchnt_txn_ssn());
						updateUserAccount(user);
						userAccount = userAccountServ.selectByUserId(user.getUserId());
						// 保存信息到账户信息记录表
						userAccountLog = new UserAccountLogVO();
						userAccountLog.setUserId(user.getUserId());
						userAccountLog.setType(4101);
						userAccountLog.setMoney(userRecharge.getFee());
						userAccountLog.setTotal(userAccount.getTotal());
						userAccountLog.setFrost(userAccount.getFrost());
						userAccountLog.setCash(userAccount.getCash());
						userAccountLog.setAddTime(DateUtil.getUnixTime());
						userAccountLog.setApplyId(userRecharge.getRechargeId());
						userAccountLog.setFrom(user.getUserId());
						userAccountLog.setTo(FyUtil.MCHNT_USER_ID);
						userAccountLog.setMemo("");

						// 生成充值手续费编号

						String oldMaxBusiNumber = userAccountLogServ
								.findMaxBusiNumber("CZF" + DateUtil.getCurrentDate("yyyyMMdd"));
						log.info("oldMaxBusiNumber==" + oldMaxBusiNumber);
						String busiNumber = UserAccountUtil.getBusiNumber(oldMaxBusiNumber, "CZF");
						log.info("busiNumber==" + busiNumber);
						userAccountLog.setBusiNumber(busiNumber);
						userAccountLogServ.insertSelective(userAccountLog);
						// 更新平台收益相关记录
						// 平台收益记录
						SiteAccountLogVO siteAccountLog = new SiteAccountLogVO();
						siteAccountLog.setFeeId(poundageInfo.getFeeid());
						siteAccountLog.setUserId(user.getUserId());
						siteAccountLog.setMoney(userRecharge.getFee());
						siteAccountLog.setCreated(DateUtil.getUnixTime());
						siteAccountLogServ.addSiteAccountLog(siteAccountLog);
						SiteAccountVO siteAccount = null;

						siteAccount = siteAccountServ.findSiteAccountByFeeId(poundageInfo.getFeeid());
						siteAccount.setIncome(siteAccount.getIncome().add(userRecharge.getFee()));
						siteAccountServ.updateSiteAccount(siteAccount);
					} else {
						// 转账失败修改 对账表信息
						siteBillingServ.updateBusiStatus(1, transBmuRespData.getResponse().getMchnt_txn_ssn());
					}
				}

			}
		}

		// 更新用户账户
		// updateUserAccount(user);

		// 组装返回数据xml
		String respxml = XMLUtil.bToXml(respData, FyUtil.CHAR_SET);// 根据返回bean生产xml；
		String respxmlStr = XMLUtil.getSignData(respxml);// 截取部分xml进行签名
		String signatureStr = SecurityUtils.sign(respxmlStr);
		respData.setSignature(signatureStr);
		String returnrespxml = XMLUtil.bToXml(respData, FyUtil.CHAR_SET);// 根据返回bean生产xml；
		log.info("returnrespxml = " + returnrespxml);
		response.getOutputStream().write(returnrespxml.getBytes());
		response.getOutputStream().flush();
		response.getOutputStream().close();

	}

	/**
	 * 提现通知接口
	 * 
	 * @throws IOException
	 * 
	 */
	@RequestMapping("withdrawal")
	public void withdrawal(HttpServletRequest request, HttpServletResponse response, RechargeReportBean reqData,
			RechargeReportResp respData, Model model) throws IOException {
		// 富友成功后才会进行通知

		respData = fyReportServ.rechargeReport(reqData);
		String inputStr = reqData.regSignVal();
		log.info("inputStr = " + inputStr);

		boolean flag = SecurityUtils.verifySign(inputStr, reqData.getSignature());// 验签结果
		log.info("提现通知验签结果withdrawal = " + flag);

		// 根据手机号码查询本系统的用户信息
		UserVO user = userServ.getUserByMobile(reqData.getMobile_no());
		if (flag) {
			// 验签成功进行更新数据库
			UserWithdrawalVO userWithdrawal = null;
			try {
				userWithdrawal = withdrawalServ.selectBybillno(reqData.getMchnt_txn_ssn());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			PoundageInfoVO poundageInfo = poundageInfoServ.selectByPrimaryTxnSsn(reqData.getMchnt_txn_ssn());
			if (userWithdrawal == null && poundageInfo != null) {// 判断状态是否已经更新
				// 提现成功修改 对账表信息
			    siteBillingServ.updateBusiStatus(0, reqData.getMchnt_txn_ssn());
				// 1 组装实体类并保存到数据库提现记录表
				userWithdrawal = new UserWithdrawalVO();
				userWithdrawal.setUserId(user.getUserId());
				userWithdrawal.setBillno(reqData.getMchnt_txn_ssn());
				userWithdrawal.setAmount(new BigDecimal(reqData.getAmt()).divide(new BigDecimal(100)));
				userWithdrawal.setStatus(1);
				userWithdrawal.setCreateTime(DateUtil.getUnixTime());
				userWithdrawal.setFee(poundageInfo.getPoundageatm().toString());
				// 生成提现编号
				String withdrawalNumber = "";
				String oldMaxWithdrawalNumber = withdrawalServ
						.findMaxWithdrawalNumber("TX" + DateUtil.getCurrentDate("yyyyMMdd"));
				System.out.println("oldMaxWithdrawalNumber==" + oldMaxWithdrawalNumber);
				if ("".equals(oldMaxWithdrawalNumber) || oldMaxWithdrawalNumber == null) {
					withdrawalNumber = "TX" + DateUtil.getCurrentDate("yyyyMMdd") + "00001";
				} else {
					withdrawalNumber = UserAccountUtil.getWithdrawalNumber(oldMaxWithdrawalNumber);
				}
				System.out.println("withdrawalNumber==" + withdrawalNumber);
				userWithdrawal.setWithdrawalNumber(withdrawalNumber);
				withdrawalServ.addUserWithdrawal(userWithdrawal);
				model.addAttribute("tx", "提现成功，金额" + reqData.getAmt() + "元");

				// 保存提现产生的账户明细信息
				updateUserAccount(user);// 更新本地账户信息
				UserAccountVO userAccount = userAccountServ.selectByUserId(user.getUserId());// 查询本地账户信息
				// 修改状态

				// 保存提现产生的账户明细信息
				updateUserAccount(user);// 更新本地账户信息
				userAccount = userAccountServ.selectByUserId(user.getUserId());// 查询本地账户信息

				UserAccountLogVO userAccountLog = new UserAccountLogVO();
				userAccountLog.setUserId(user.getUserId());
				userAccountLog.setType(4102);
				userAccountLog.setMoney(userWithdrawal.getAmount());
				userAccountLog.setTotal(userAccount.getTotal());
				userAccountLog.setFrost(userAccount.getFrost());
				userAccountLog.setCash(userAccount.getCash());
				userAccountLog.setAddTime(DateUtil.getUnixTime());
				userAccountLog.setApplyId(userWithdrawal.getWithdrawalId());
				// userAccountLog.setFrom(user.getUserId());
				// userAccountLog.setTo();
				userAccountLog.setStatus(0);
				userAccountLog.setMemo("");
				userAccountLog.setBusiNumber(userWithdrawal.getWithdrawalNumber());
				userAccountLog.setApplyId(userWithdrawal.getWithdrawalId());
				userAccountLogServ.insertSelective(userAccountLog);
				// 提现申请成功发送站内通知和短信
				commonServ.sendall(user.getMobile(), SmsTypeUtil.P2P_WITHDRAWAL_APPLY,
						DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"),
						userWithdrawal.getAmount().add(new BigDecimal(userWithdrawal.getFee())).toString(), "", "");

				// 收取手续费
				// 收取手续费String chargeItem, String feeName, String userType

				if (Double.parseDouble(userWithdrawal.getFee()) > 0) {// 提现手续费要大于0
					// 发送转账接口到富友
					TransBmuBean transBmuBean = new TransBmuBean();
					BigDecimal amt2 = new BigDecimal(userWithdrawal.getFee()).multiply(new BigDecimal("100"));
					BigDecimal amt3 = amt2.divide(new BigDecimal("1"), 0, BigDecimal.ROUND_HALF_UP);
					transBmuBean.setAmt(amt3.toString());// 金额
					transBmuBean.setOut_cust_no(user.getJzhloginid());// 转出账户
					transBmuBean.setIn_cust_no(FyUtil.MCHNT_USER_ID);// 转入账户
					TransBmuResp transBmuRespData = new TransBmuResp();
					String transBmuRespCode = "";
					try {
						// 转账时传入入账用户信息，平台交易类型，平台交易备注
						transBmuRespData = capitalMgtServ.transferBmu(transBmuBean, user, null, "提现手续费",
								userWithdrawal.getWithdrawalNumber());
						transBmuRespCode = transBmuRespData.getResponse().getResp_code();
					} catch (Exception e) {
						log.info("收取提现手续费时系统异常！流水号：" + transBmuBean.getMchnt_txn_ssn() + ",提现编号："
								+ userWithdrawal.getWithdrawalId());
						e.printStackTrace();
					}
					if (FyUtil.SUCCESS.equals(transBmuRespCode)) {
						log.info("transBmuRespCode = " + transBmuRespCode + "转账成功,从" + "user.getJzhloginid()" + "转出3到"
								+ FyUtil.MCHNT_USER_ID);
						// 转账成功修改 对账表信息
					    siteBillingServ.updateBusiStatus(0, transBmuRespData.getResponse().getMchnt_txn_ssn());
						// 保存信息到手续费记录表
						// 更新账户表
						updateUserAccount(user);
						userAccount = userAccountServ.selectByUserId(user.getUserId());
						// 保存信息到账户信息记录表
						userAccountLog.setUserId(user.getUserId());
						userAccountLog.setType(4103);
						userAccountLog.setMoney(new BigDecimal(userWithdrawal.getFee()));
						userAccountLog.setTotal(userAccount.getTotal());
						userAccountLog.setFrost(userAccount.getFrost());
						userAccountLog.setCash(userAccount.getCash());
						userAccountLog.setAddTime(DateUtil.getUnixTime());
						userAccountLog.setApplyId(userWithdrawal.getWithdrawalId());
						userAccountLog.setFrom(user.getUserId());
						userAccountLog.setTo(FyUtil.MCHNT_USER_ID);
						userAccountLog.setMemo("");
						// 生成提现手续费编号
						String oldMaxBusiNumber = userAccountLogServ
								.findMaxBusiNumber("TXF" + DateUtil.getCurrentDate("yyyyMMdd"));
						log.info("oldMaxBusiNumber==" + oldMaxBusiNumber);
						String busiNumber = UserAccountUtil.getBusiNumber(oldMaxBusiNumber, "TXF");
						log.info("busiNumber==" + busiNumber);
						userAccountLog.setBusiNumber(busiNumber);
						userAccountLogServ.insertSelective(userAccountLog);

						// 更新平台收益相关记录
						// 平台收益记录
						SiteAccountLogVO siteAccountLog = new SiteAccountLogVO();
						if ("1".equals(user.getUserType())) {
							siteAccountLog
									.setFeeId(siteFeeServ.queryChageMode(null, "投资人提现手续费", null).getChargeFeeId());
						} else if ("2".equals(user.getUserType())) {
							siteAccountLog
									.setFeeId(siteFeeServ.queryChageMode(null, "借款人提现手续费", null).getChargeFeeId());
						} else {
							siteAccountLog.setFeeId(siteFeeServ.queryChageMode(null, "机构提现手续费", null).getChargeFeeId());
						}
						siteAccountLog.setUserId(user.getUserId());
						siteAccountLog.setMoney(new BigDecimal(userWithdrawal.getFee()));
						siteAccountLog.setCreated(DateUtil.getUnixTime());
						siteAccountLogServ.addSiteAccountLog(siteAccountLog);
						SiteAccountVO siteAccount = null;
						// 总收益更新
						if ("1".equals(user.getUserType())) {
							siteAccount = siteAccountServ.findSiteAccountByFeeName("投资人提现手续费");
						} else if ("2".equals(user.getUserType())) {
							siteAccount = siteAccountServ.findSiteAccountByFeeName("借款人提现手续费");
						} else {
							siteAccount = siteAccountServ.findSiteAccountByFeeName("机构提现手续费");
						}
						siteAccount.setIncome(siteAccount.getIncome().add(new BigDecimal(userWithdrawal.getFee())));
						siteAccountServ.updateSiteAccount(siteAccount);
					}else{
						// 转账失败修改 对账表信息
					    siteBillingServ.updateBusiStatus(1, transBmuRespData.getResponse().getMchnt_txn_ssn());
					}
				}

			}
			
		}
		// 更新用户账户
		updateUserAccount(user);

		// 组装返回数据xml
		String respxml = XMLUtil.bToXml(respData, FyUtil.CHAR_SET);// 根据返回bean生产xml；
		String respxmlStr = XMLUtil.getSignData(respxml);// 截取部分xml进行签名
		String signatureStr = SecurityUtils.sign(respxmlStr);
		respData.setSignature(signatureStr);
		String returnrespxml = XMLUtil.bToXml(respData, FyUtil.CHAR_SET);// 根据返回bean生产xml；
		log.info("returnrespxml = " + returnrespxml);
		// response.getWriter();
		response.getOutputStream().write(returnrespxml.getBytes());
		response.getOutputStream().flush();
		response.getOutputStream().close();

	}

	/**
	 * 提现退票通知接口
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * 
	 */
	@RequestMapping("cashRefund")
	public void cashRefund(HttpServletRequest request, HttpServletResponse response, CashRefundBean reqData)
			throws UnsupportedEncodingException, IOException {

		String ss = request.getParameter("userId");
		String inputStr = reqData.regSignVal();
		log.info("inputStr = " + inputStr);

		boolean flag = SecurityUtils.verifySign(inputStr, reqData.getSignature());// 验签结果
		log.info("提现退票通知验签结果withdrawal = " + flag);

		if (flag) {
			// 验签成功进行业务逻辑判断
			UserWithdrawalVO userWithdrawal = null;
			try {
				userWithdrawal = withdrawalServ.selectBybillno(reqData.getMchnt_txn_ssn());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (userWithdrawal != null && userWithdrawal.getStatus() == 1) {// 判断状态是否已经更新
				// 1,更新提现表状态为3
				UserVO user = userServ.getUserByMobile(reqData.getMobile_no());
				withdrawalServ.updateUserWithdrawalBySSN(userWithdrawal.getBillno(), "3");
				// 2,新增一条提现退票交易明细
				updateUserAccount(user);// 更新本地账户信息
				UserAccountVO userAccount = userAccountServ.selectByUserId(user.getUserId());// 查询本地账户信息

				UserAccountLogVO userAccountLog = new UserAccountLogVO();
				userAccountLog.setUserId(user.getUserId());
				userAccountLog.setType(3001);
				userAccountLog.setMoney(userWithdrawal.getAmount());
				userAccountLog.setTotal(userAccount.getTotal());
				userAccountLog.setFrost(userAccount.getFrost());
				userAccountLog.setCash(userAccount.getCash());
				userAccountLog.setAddTime(DateUtil.getUnixTime());
				userAccountLog.setApplyId(userWithdrawal.getWithdrawalId());
				// userAccountLog.setFrom(user.getUserId());
				// userAccountLog.setTo();
				userAccountLog.setStatus(0);
				userAccountLog.setMemo("");
				userAccountLog.setBusiNumber(userWithdrawal.getWithdrawalNumber());
				userAccountLog.setApplyId(userWithdrawal.getWithdrawalId());
				userAccountLogServ.insertSelective(userAccountLog);
				if (Double.parseDouble(userWithdrawal.getFee()) > 0) {// 提现手续费要大于0
					// 发送转账接口到富友
					TransBmuBean transBmuBean = new TransBmuBean();
					BigDecimal amt2 = new BigDecimal(userWithdrawal.getFee()).multiply(new BigDecimal("100"));
					BigDecimal amt3 = amt2.divide(new BigDecimal("1"), 0, BigDecimal.ROUND_HALF_UP);
					transBmuBean.setAmt(amt3.toString());// 金额
					transBmuBean.setOut_cust_no(FyUtil.MCHNT_USER_ID);// 转出账户
					transBmuBean.setIn_cust_no(user.getJzhloginid());// 转入账户
					TransBmuResp transBmuRespData = new TransBmuResp();
					String transBmuRespCode = "";
					try {
						// 转账时传入入账用户信息，平台交易类型，平台交易备注
						transBmuRespData = capitalMgtServ.transferBmu(transBmuBean, null, user, "提现退票返还手续费",
								userWithdrawal.getWithdrawalNumber());
						transBmuRespCode = transBmuRespData.getResponse().getResp_code();
					} catch (Exception e) {
						log.info("提现退票时退还提现手续费时系统异常！流水号：" + transBmuBean.getMchnt_txn_ssn() + ",提现编号："
								+ userWithdrawal.getWithdrawalId());
						e.printStackTrace();
					}
					if (FyUtil.SUCCESS.equals(transBmuRespCode)) {
						log.info("transBmuRespCode = " + transBmuRespCode + "转账成功,从" + "FyUtil.MCHNT_USER_ID" + "转出3到"
								+ user.getJzhloginid());
						// 转账成功修改 对账表信息
					    siteBillingServ.updateBusiStatus(0, transBmuRespData.getResponse().getMchnt_txn_ssn());
						// 保存信息到手续费记录表
						// 更新用户账户
						updateUserAccount(user);
						userAccount = userAccountServ.selectByUserId(user.getUserId());
						// 保存信息到账户信息记录表
						userAccountLog.setUserId(user.getUserId());
						userAccountLog.setType(3002);
						userAccountLog.setMoney(new BigDecimal(userWithdrawal.getFee()));
						userAccountLog.setTotal(userAccount.getTotal());
						userAccountLog.setFrost(userAccount.getFrost());
						userAccountLog.setCash(userAccount.getCash());
						userAccountLog.setAddTime(DateUtil.getUnixTime());
						userAccountLog.setApplyId(userWithdrawal.getWithdrawalId());
						userAccountLog.setFrom(user.getUserId());
						userAccountLog.setTo(FyUtil.MCHNT_USER_ID);
						userAccountLog.setMemo("");
						// 生成提现手续费编号
						String oldMaxBusiNumber = userAccountLogServ
								.findMaxBusiNumber("TXTPF" + DateUtil.getCurrentDate("yyyyMMdd"));
						log.info("oldMaxBusiNumber==" + oldMaxBusiNumber);
						String busiNumber = UserAccountUtil.getBusiNumber(oldMaxBusiNumber, "TXTPF");
						log.info("busiNumber==" + busiNumber);
						userAccountLog.setBusiNumber(busiNumber);
						userAccountLogServ.insertSelective(userAccountLog);

						// 平台收益记录
						SiteAccountLogVO siteAccountLog = new SiteAccountLogVO();
						if ("1".equals(user.getUserType())) {
							siteAccountLog
									.setFeeId(siteFeeServ.queryChageMode(null, "投资人提现手续费", null).getChargeFeeId());
						} else if ("2".equals(user.getUserType())) {
							siteAccountLog
									.setFeeId(siteFeeServ.queryChageMode(null, "借款人提现手续费", null).getChargeFeeId());
						} else {
							siteAccountLog.setFeeId(siteFeeServ.queryChageMode(null, "机构提现手续费", null).getChargeFeeId());
						}
						siteAccountLog.setUserId(user.getUserId());
						siteAccountLog.setMoney(new BigDecimal(userWithdrawal.getFee()).multiply(new BigDecimal(-1)));
						siteAccountLog.setCreated(DateUtil.getUnixTime());
						siteAccountLogServ.addSiteAccountLog(siteAccountLog);
						SiteAccountVO siteAccount = null;
						// 总收益更新
						if ("1".equals(user.getUserType())) {
							siteAccount = siteAccountServ.findSiteAccountByFeeName("投资人提现手续费");
						} else if ("2".equals(user.getUserType())) {
							siteAccount = siteAccountServ.findSiteAccountByFeeName("借款人提现手续费");
						} else {
							siteAccount = siteAccountServ.findSiteAccountByFeeName("机构提现手续费");
						}
						siteAccount
								.setIncome(siteAccount.getIncome().subtract(new BigDecimal(userWithdrawal.getFee())));
						siteAccountServ.updateSiteAccount(siteAccount);

					}
				}

				// 发送站内通知
				commonServ.sendall(user.getMobile(), SmsTypeUtil.P2P_WITHDRAWAL_FAIL,
						DateUtil.timeMillisToStr(userWithdrawal.getCreateTime(), "yyyy-MM-dd HH:mm:ss"),
						userWithdrawal.getAmount().add(new BigDecimal(userWithdrawal.getFee())).toString(), "", "");
			}
		}
		// 更新用户账户
		// updateUserAccount(user);

		String returnrespxml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ap>SUCCESS</ap>";// 根据返回bean生产xml；
		log.info("returnrespxml = " + returnrespxml);
		// response.getWriter();
		response.getOutputStream().write(returnrespxml.getBytes());
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

	/**
	 * 快捷同步回调地址 此时是充值成功，如果掉单，富友会另行进行通知
	 */
	@RequestMapping("fastIndex")
	public String index(Model model, UserRechargeResp resp, String resp_code, String mchnt_cd, String amt,
			String mchnt_txn_ssn, String login_id, String rem, String signature) {
		try {
			UserVO user_Inf = (UserVO) getSession("user_inf");
			PoundageInfoVO poundageInfo = poundageInfoServ.selectByPrimaryTxnSsn(mchnt_txn_ssn);
			String inputStr = resp.regSignVal();
			log.info("inputStr = " + inputStr);
			log.info("系统加密后密文inputStrjiami = " + SecurityUtils.sign(inputStr));
			log.info("富友返回的密文 = " + resp.getSignature());
			boolean flag = SecurityUtils.verifySign(inputStr, resp.getSignature());// 验签结果
			log.info("快捷同步验签结果recharge = " + flag);
			if (!flag) {
				// 转账失败修改 对账表信息
				siteBillingServ.updateBusiStatus(1, mchnt_txn_ssn);
				model.addAttribute("code", "验签失败");
				return "fail.jsp";
			}
			UserVO userInf = new UserVO();
			if (user_Inf == null) {
				// 如果session为空则重新放入session
				userInf = userServ.getUserByUserId(poundageInfo.getUserId());
				userInf.setRealname(StringUtil.handleName(userInf.getRealname()));
				userInf.setCardId(StringUtil.handleCardId(userInf.getCardId()));
				if (userInf.getUsername().equals(userInf.getMobile())) {// 用户名
					userInf.setUsername(StringUtil.handlePhone(userInf.getMobile()));
				} else {
					userInf.setUsername(StringUtil.getHandleUserName(userInf.getUsername()));
				}
				userInf.setCapAcntNo(StringUtil.handleBankNo1(userInf.getCapAcntNo()));
				userInf.setMobile(StringUtil.handlePhone(userInf.getMobile()));// 手机号
				addSession("user_inf", userInf);
				userInf = userServ.getUserByUserId(poundageInfo.getUserId());
			} else {
				userInf = userServ.getUserByUserId(user_Inf.getUserId());
			}
			if (FyUtil.SUCCESS.equals(resp_code)) {
				// 充值成功修改 对账表信息
				siteBillingServ.updateBusiStatus(0, mchnt_txn_ssn);
				UserRechargeVO userRecharge = null;
				try {
					userRecharge = rechargeServ.selectBybillno(mchnt_txn_ssn);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (userRecharge == null) {
					// 1： 更新-用户充值表
					Integer userId = Integer.valueOf(userInf.getUserId());
					userRecharge = new UserRechargeVO();
					userRecharge.setUserId(userId);
					userRecharge.setBillno(mchnt_txn_ssn);
					userRecharge.setMoney(new BigDecimal(amt).divide(new BigDecimal(100)));
					userRecharge.setStatus(1);
					userRecharge.setCreateTime(DateUtil.getUnixTime());

					userRecharge.setFee(poundageInfo.getPoundageatm());
					// 生成充值编号
					String rechargeNumber = "";
					String oldMaxRechargeNumber = rechargeServ
							.findMaxRechargeNumber("CZ" + DateUtil.getCurrentDate("yyyyMMdd"));
					System.out.println("oldMaxRechargeNumber==" + oldMaxRechargeNumber);
					if ("".equals(oldMaxRechargeNumber) || oldMaxRechargeNumber == null) {
						rechargeNumber = "CZ" + DateUtil.getCurrentDate("yyyyMMdd") + "00001";
					} else {
						rechargeNumber = UserAccountUtil.getRechargeNumber(oldMaxRechargeNumber);
					}
					System.out.println("rechargeNumber==" + rechargeNumber);
					userRecharge.setRechargeNumber(rechargeNumber);
					rechargeServ.addUserRecharge(userRecharge);
					// 2：根据流水号查出充值记录号

					userRecharge = rechargeServ.selectBybillno(mchnt_txn_ssn);
					// 更新对账表信息

					// 3： 保存一条实时账户信息到 userAccountLog 表，
					updateUserAccount(userInf);
					UserAccountVO userAccount = userAccountServ.selectByUserId(userInf.getUserId());// 查询本地账户信息
					UserAccountLogVO userAccountLog = new UserAccountLogVO();
					userAccountLog.setUserId(userInf.getUserId());
					userAccountLog.setType(4100);
					userAccountLog.setMoney(userRecharge.getMoney());
					userAccountLog.setTotal(userAccount.getTotal());
					userAccountLog.setFrost(userAccount.getFrost());
					userAccountLog.setCash(userAccount.getCash());
					userAccountLog.setAddTime(DateUtil.getUnixTime());
					userAccountLog.setApplyId(userRecharge.getRechargeId());
					userAccountLog.setStatus(0);
					// userAccountLog.setFrom(user.getUserId());
					// userAccountLog.setTo();
					userAccountLog.setMemo("");
					userAccountLog.setBusiNumber(userRecharge.getRechargeNumber());
					userAccountLogServ.insertSelective(userAccountLog);

					// 4： 发送站内通知
					commonServ.sendall(userInf.getMobile(), SmsTypeUtil.P2P_REC_SUC,
							DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"), userRecharge.getMoney().toString(), "", "");

					// 5：发送转账接口到富友扣除手续费
					if (userRecharge.getFee().doubleValue() > 0) {// 充值手续费
						// 发送转账接口到富友
						TransBmuBean transBmuBean = new TransBmuBean();
						BigDecimal amt2 = userRecharge.getFee().multiply(new BigDecimal("100"));
						BigDecimal amt3 = amt2.divide(new BigDecimal("1"), 0, BigDecimal.ROUND_HALF_UP);
						transBmuBean.setAmt(amt3.toString());// 金额
						transBmuBean.setOut_cust_no(userInf.getJzhloginid());// 转出账户
						transBmuBean.setIn_cust_no(FyUtil.MCHNT_USER_ID);// 转入账户
						String transBmuRespCode = "";
						TransBmuResp transBmuRespData = new TransBmuResp();
						try {
							// 转账时传入入账用户信息，平台交易类型，平台交易备注
							transBmuRespData = capitalMgtServ.transferBmu(transBmuBean, userInf, null, "充值手续费",
									userRecharge.getRechargeNumber());
							transBmuRespCode = transBmuRespData.getResponse().getResp_code();
						} catch (Exception e) {
							log.info("收取充值手续费时系统异常！流水号：" + transBmuBean.getMchnt_txn_ssn() + ",充值编号："
									+ userRecharge.getRechargeId());
							e.printStackTrace();
							throw e;
						}
						if (FyUtil.SUCCESS.equals(transBmuRespCode)) {
							log.info("transBmuRespCode = " + transBmuRespCode + "转账成功,从" + userInf.getJzhloginid()
									+ "转出" + userRecharge.getFee() + "到" + FyUtil.MCHNT_USER_ID);
							// 转账成功修改 对账表信息
							siteBillingServ.updateBusiStatus(0, transBmuRespData.getResponse().getMchnt_txn_ssn());
							updateUserAccount(userInf);
							userAccount = userAccountServ.selectByUserId(userInf.getUserId());
							// 保存信息到账户信息记录表
							userAccountLog = new UserAccountLogVO();
							userAccountLog.setUserId(userInf.getUserId());
							userAccountLog.setType(4101);
							userAccountLog.setMoney(userRecharge.getFee());
							userAccountLog.setTotal(userAccount.getTotal());
							userAccountLog.setFrost(userAccount.getFrost());
							userAccountLog.setCash(userAccount.getCash());
							userAccountLog.setAddTime(DateUtil.getUnixTime());
							userAccountLog.setApplyId(userRecharge.getRechargeId());
							userAccountLog.setFrom(userInf.getUserId());
							userAccountLog.setTo(FyUtil.MCHNT_USER_ID);
							userAccountLog.setMemo("");

							// 生成充值手续费编号

							String oldMaxBusiNumber = userAccountLogServ
									.findMaxBusiNumber("CZF" + DateUtil.getCurrentDate("yyyyMMdd"));
							log.info("oldMaxBusiNumber==" + oldMaxBusiNumber);
							String busiNumber = UserAccountUtil.getBusiNumber(oldMaxBusiNumber, "CZF");
							log.info("busiNumber==" + busiNumber);
							userAccountLog.setBusiNumber(busiNumber);
							userAccountLogServ.insertSelective(userAccountLog);
							// 更新平台收益相关记录
							// 平台收益记录
							SiteAccountLogVO siteAccountLog = new SiteAccountLogVO();

							siteAccountLog.setFeeId(poundageInfo.getFeeid());
							siteAccountLog.setUserId(userInf.getUserId());
							siteAccountLog.setMoney(userRecharge.getFee());
							siteAccountLog.setCreated(DateUtil.getUnixTime());
							siteAccountLogServ.addSiteAccountLog(siteAccountLog);
							SiteAccountVO siteAccount = null;

							siteAccount = siteAccountServ.findSiteAccountByFeeId(poundageInfo.getFeeid());
							siteAccount.setIncome(siteAccount.getIncome().add(userRecharge.getFee()));
							siteAccountServ.updateSiteAccount(siteAccount);
						
						} else {
							// 转账失败修改 对账表信息
							siteBillingServ.updateBusiStatus(1, transBmuRespData.getResponse().getMchnt_txn_ssn());
						}
					}
				}
				// // 更新用户账户
				// updateUserAccount(userInf);
				return "redirect:/myAccount/enterUserAccount";
			} else {
				// 充值失败修改 对账表信息
				siteBillingServ.updateBusiStatus(1, mchnt_txn_ssn);
				model.addAttribute("code", FyReturnCode.codeType.get(resp_code) + resp_code);
				return "fail.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 转账失败修改 对账表信息
			siteBillingServ.updateBusiStatus(1, mchnt_txn_ssn);
			e.printStackTrace();
			model.addAttribute("code", "系统异常");
			return "fail.jsp";
		}

	}

	/**
	 * 网银同步回调地址 此时是充值成功，如果掉单，富友会另行进行通知
	 */
	@RequestMapping("WebIndex")
	public String webIndex(Model model, UserRechargeResp resp, String resp_code, String mchnt_cd, String amt,
			String mchnt_txn_ssn, String login_id, String rem, String signature) {
		//int i = 9/0;
		UserVO user_Inf = (UserVO) getSession("user_inf");
		String inputStr = resp.regWebSignVal();
		log.info("inputStr = " + inputStr);
		log.info("系统加密后密文inputStrjiami = " + SecurityUtils.sign(inputStr));
		log.info("富友返回的密文 = " + resp.getSignature());
		UserVO userInf = new UserVO();
		boolean flag = SecurityUtils.verifySign(inputStr, resp.getSignature());// 验签结果
		log.info("快捷同步验签结果recharge = " + flag);
		if (!flag) {
			// 充值失败修改 对账表信息
			siteBillingServ.updateBusiStatus(1, mchnt_txn_ssn);
			model.addAttribute("code", "验签失败");
			return "fail.jsp";
		}
		if (FyUtil.SUCCESS.equals(resp_code)) {
			// 充值成功修改 对账表信息
			siteBillingServ.updateBusiStatus(0, mchnt_txn_ssn);
			UserRechargeVO userRecharge = null;
			try {
				userRecharge = rechargeServ.selectBybillno(mchnt_txn_ssn);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if (userRecharge == null) {
				PoundageInfoVO poundageInfo = poundageInfoServ.selectByPrimaryTxnSsn(mchnt_txn_ssn);
				if (user_Inf == null) {
					userInf = userServ.getUserByUserId(poundageInfo.getUserId());
					userInf.setRealname(StringUtil.handleName(userInf.getRealname()));
					userInf.setCardId(StringUtil.handleCardId(userInf.getCardId()));
					if (userInf.getUsername().equals(userInf.getMobile())) {// 用户名
						userInf.setUsername(StringUtil.handlePhone(userInf.getMobile()));
					} else {
						userInf.setUsername(StringUtil.getHandleUserName(userInf.getUsername()));
					}
					userInf.setCapAcntNo(StringUtil.handleBankNo1(userInf.getCapAcntNo()));
					userInf.setMobile(StringUtil.handlePhone(userInf.getMobile()));// 手机号
					addSession("user_inf", userInf);
					userInf = userServ.getUserByUserId(poundageInfo.getUserId());
				} else {
					userInf = userServ.getUserByUserId(user_Inf.getUserId());
				}
				// 1： 更新-用户充值表
				Integer userId = Integer.valueOf(userInf.getUserId());
				userRecharge = new UserRechargeVO();
				userRecharge.setUserId(userId);
				userRecharge.setBillno(mchnt_txn_ssn);
				userRecharge.setMoney(new BigDecimal(amt).divide(new BigDecimal(100)));
				userRecharge.setStatus(1);
				userRecharge.setCreateTime(DateUtil.getUnixTime());

				userRecharge.setFee(poundageInfo.getPoundageatm());
				// 生成充值编号
				String rechargeNumber = "";
				String oldMaxRechargeNumber = rechargeServ
						.findMaxRechargeNumber("CZ" + DateUtil.getCurrentDate("yyyyMMdd"));
				System.out.println("oldMaxRechargeNumber==" + oldMaxRechargeNumber);
				if ("".equals(oldMaxRechargeNumber) || oldMaxRechargeNumber == null) {
					rechargeNumber = "CZ" + DateUtil.getCurrentDate("yyyyMMdd") + "00001";
				} else {
					rechargeNumber = UserAccountUtil.getRechargeNumber(oldMaxRechargeNumber);
				}
				System.out.println("rechargeNumber==" + rechargeNumber);
				userRecharge.setRechargeNumber(rechargeNumber);
				rechargeServ.addUserRecharge(userRecharge);

				// 1根据流水号查出充值记录号
				UserRechargeDTO userRechargeQuery = new UserRechargeDTO();
				userRechargeQuery.setBillno(mchnt_txn_ssn);
				Page page = new Page();
				page = rechargeServ.findUserRechargeByCondition(userRechargeQuery, page);
				userRecharge = (UserRechargeVO) page.getItems().get(0);

				// 保存一条账户信息到 userAccountLog 表
				UserAccountVO userAccount = userAccountServ.selectByUserId(userInf.getUserId());// 查询本地账户信息
				UserAccountLogVO userAccountLog = new UserAccountLogVO();
				userAccountLog.setUserId(userInf.getUserId());
				userAccountLog.setType(4100);
				userAccountLog.setMoney(userRecharge.getMoney());
				userAccountLog.setTotal(userAccount.getTotal().add(userRecharge.getMoney()));
				userAccountLog.setFrost(userAccount.getFrost());
				userAccountLog.setCash(userAccount.getCash().add(userRecharge.getMoney()));
				userAccountLog.setAddTime(DateUtil.getUnixTime());
				userAccountLog.setApplyId(userRecharge.getRechargeId());
				userAccountLog.setStatus(0);
				// userAccountLog.setFrom(user.getUserId());
				// userAccountLog.setTo();
				userAccountLog.setMemo("");
				userAccountLog.setBusiNumber(userRecharge.getRechargeNumber());
				userAccountLogServ.insertSelective(userAccountLog);

				// 4： 发送站内通知
				commonServ.sendall(userInf.getMobile(), SmsTypeUtil.P2P_REC_SUC,
						DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"), userRecharge.getMoney().toString(), "", "");

				// 5：发送转账接口到富友扣除手续费
				if (userRecharge.getFee().doubleValue() > 0) {// 充值手续费
					// 发送转账接口到富友
					TransBmuBean transBmuBean = new TransBmuBean();
					BigDecimal amt2 = userRecharge.getFee().multiply(new BigDecimal("100"));
					BigDecimal amt3 = amt2.divide(new BigDecimal("1"), 0, BigDecimal.ROUND_HALF_UP);
					transBmuBean.setAmt(amt3.toString());// 金额
					transBmuBean.setOut_cust_no(userInf.getJzhloginid());// 转出账户
					transBmuBean.setIn_cust_no(FyUtil.MCHNT_USER_ID);// 转入账户
					String transBmuRespCode = "";
					TransBmuResp transBmuRespData = new TransBmuResp();
					try {
						// 转账时传入入账用户信息，平台交易类型，平台交易备注
						transBmuRespData = capitalMgtServ.transferBmu(transBmuBean, userInf, null, "充值手续费",
								userRecharge.getRechargeNumber());
						transBmuRespCode = transBmuRespData.getResponse().getResp_code();
					} catch (Exception e) {
						log.info("收取充值手续费时系统异常！流水号：" + transBmuBean.getMchnt_txn_ssn() + ",充值编号："
								+ userRecharge.getRechargeId());
						e.printStackTrace();
					}
					if (FyUtil.SUCCESS.equals(transBmuRespCode)) {
						log.info("transBmuRespCode = " + transBmuRespCode + "转账成功,从" + userInf.getJzhloginid() + "转出"
								+ userRecharge.getFee() + "到" + FyUtil.MCHNT_USER_ID);
						// 转账成功修改 对账表信息
						siteBillingServ.updateBusiStatus(0, transBmuRespData.getResponse().getMchnt_txn_ssn());
						updateUserAccount(userInf);
						userAccount = userAccountServ.selectByUserId(userInf.getUserId());
						// 保存信息到账户信息记录表
						userAccountLog = new UserAccountLogVO();
						userAccountLog.setUserId(userInf.getUserId());
						userAccountLog.setType(4101);
						userAccountLog.setMoney(userRecharge.getFee());
						userAccountLog.setTotal(userAccount.getTotal());
						userAccountLog.setFrost(userAccount.getFrost());
						userAccountLog.setCash(userAccount.getCash());
						userAccountLog.setAddTime(DateUtil.getUnixTime());
						userAccountLog.setApplyId(userRecharge.getRechargeId());
						userAccountLog.setFrom(userInf.getUserId());
						userAccountLog.setTo(FyUtil.MCHNT_USER_ID);
						userAccountLog.setMemo("");

						// 生成充值手续费编号

						String oldMaxBusiNumber = userAccountLogServ
								.findMaxBusiNumber("CZF" + DateUtil.getCurrentDate("yyyyMMdd"));
						log.info("oldMaxBusiNumber==" + oldMaxBusiNumber);
						String busiNumber = UserAccountUtil.getBusiNumber(oldMaxBusiNumber, "CZF");
						log.info("busiNumber==" + busiNumber);
						userAccountLog.setBusiNumber(busiNumber);
						userAccountLogServ.insertSelective(userAccountLog);
						// 更新平台收益相关记录
						// 平台收益记录
						SiteAccountLogVO siteAccountLog = new SiteAccountLogVO();

						siteAccountLog.setFeeId(poundageInfo.getFeeid());
						siteAccountLog.setUserId(userInf.getUserId());
						siteAccountLog.setMoney(userRecharge.getFee());
						siteAccountLog.setCreated(DateUtil.getUnixTime());
						siteAccountLogServ.addSiteAccountLog(siteAccountLog);
						SiteAccountVO siteAccount = null;

						siteAccount = siteAccountServ.findSiteAccountByFeeId(poundageInfo.getFeeid());
						siteAccount.setIncome(siteAccount.getIncome().add(userRecharge.getFee()));
						siteAccountServ.updateSiteAccount(siteAccount);
						
					} else {
						// 转账失败修改 对账表信息
						siteBillingServ.updateBusiStatus(1, transBmuRespData.getResponse().getMchnt_txn_ssn());
					}
				}
			}
			
			// // 更新用户账户
			updateUserAccount(userInf);
			model.addAttribute("msg", "充值成功");
			return "redirect:/myAccount/enterUserAccount";
		} else {
			// 充值失败修改 对账表信息
			siteBillingServ.updateBusiStatus(1, mchnt_txn_ssn);
			model.addAttribute("code", FyReturnCode.codeType.get(resp_code) + resp_code);
			return "fail.jsp";
		}

	}

	/**
	 * 提现同步回调地址
	 * 
	 */
	@RequestMapping("txIndex")
	public String index(HttpServletRequest request, HttpServletResponse response, UserRechargeResp respData,
			Model model) {
		UserVO user_inf = (UserVO) getSession("user_inf");
		String code = request.getParameter("resp_code");
		String mchnt_txn_ssn = request.getParameter("mchnt_txn_ssn");
		Double amt = Double.valueOf(request.getParameter("amt"));
		UserVO userInf = new UserVO();
		if (FyUtil.SUCCESS.equals(code)) {
			// 验签
			String inputStr = respData.regTxSignVal();
			log.info("提现验签inputStr = " + inputStr);
			boolean flag = SecurityUtils.verifySign(inputStr, respData.getSignature());// 验签结果
			log.info("提现验签结果recharge = " + flag);
			if (!flag) {
				// 提现失败修改 对账表信息
				siteBillingServ.updateBusiStatus(1, mchnt_txn_ssn);
				model.addAttribute("code", "验签失败");
				return "fail.jsp";
			}
			// 提现成功修改 对账表信息
			siteBillingServ.updateBusiStatus(0, mchnt_txn_ssn);
			PoundageInfoVO poundageInfo = poundageInfoServ.selectByPrimaryTxnSsn(respData.getMchnt_txn_ssn());
			if (user_inf == null) {
				userInf = userServ.getUserByUserId(poundageInfo.getUserId());
				userInf.setRealname(StringUtil.handleName(userInf.getRealname()));
				userInf.setCardId(StringUtil.handleCardId(userInf.getCardId()));
				if (userInf.getUsername().equals(userInf.getMobile())) {// 用户名
					userInf.setUsername(StringUtil.handlePhone(userInf.getMobile()));
				} else {
					userInf.setUsername(StringUtil.getHandleUserName(userInf.getUsername()));
				}
				userInf.setCapAcntNo(StringUtil.handleBankNo1(userInf.getCapAcntNo()));
				userInf.setMobile(StringUtil.handlePhone(userInf.getMobile()));// 手机号
				addSession("user_inf", userInf);
				userInf = userServ.getUserByUserId(poundageInfo.getUserId());
			} else {
				userInf = userServ.getUserByUserId(user_inf.getUserId());
			}

			// 1 组装实体类并保存到数据库提现记录表
			UserWithdrawalVO userWithdrawal = new UserWithdrawalVO();
			userWithdrawal.setUserId(userInf.getUserId());
			userWithdrawal.setBillno(respData.getMchnt_txn_ssn());
			userWithdrawal.setAmount(new BigDecimal(amt).divide(new BigDecimal(100)));
			userWithdrawal.setStatus(1);
			userWithdrawal.setCreateTime(DateUtil.getUnixTime());
			userWithdrawal.setFee(poundageInfo.getPoundageatm().toString());
			// 生成提现编号
			String withdrawalNumber = "";
			String oldMaxWithdrawalNumber = withdrawalServ
					.findMaxWithdrawalNumber("TX" + DateUtil.getCurrentDate("yyyyMMdd"));
			System.out.println("oldMaxWithdrawalNumber==" + oldMaxWithdrawalNumber);
			if ("".equals(oldMaxWithdrawalNumber) || oldMaxWithdrawalNumber == null) {
				withdrawalNumber = "TX" + DateUtil.getCurrentDate("yyyyMMdd") + "00001";
			} else {
				withdrawalNumber = UserAccountUtil.getWithdrawalNumber(oldMaxWithdrawalNumber);
			}
			System.out.println("withdrawalNumber==" + withdrawalNumber);
			userWithdrawal.setWithdrawalNumber(withdrawalNumber);
			withdrawalServ.addUserWithdrawal(userWithdrawal);
			model.addAttribute("tx", "提现成功，金额" + amt + "元");

			// 2 查询提现记录
			try {
				userWithdrawal = withdrawalServ.selectBybillno(respData.getMchnt_txn_ssn());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 保存提现产生的账户明细信息
			updateUserAccount(userInf);// 更新本地账户信息
			UserAccountVO userAccount = userAccountServ.selectByUserId(userInf.getUserId());// 查询本地账户信息

			UserAccountLogVO userAccountLog = new UserAccountLogVO();
			userAccountLog.setUserId(userInf.getUserId());
			userAccountLog.setType(4102);
			userAccountLog.setMoney(userWithdrawal.getAmount());
			userAccountLog.setTotal(userAccount.getTotal());
			userAccountLog.setFrost(userAccount.getFrost());
			userAccountLog.setCash(userAccount.getCash());
			userAccountLog.setAddTime(DateUtil.getUnixTime());
			userAccountLog.setApplyId(userWithdrawal.getWithdrawalId());
			// userAccountLog.setFrom(user.getUserId());
			// userAccountLog.setTo();
			userAccountLog.setStatus(0);
			userAccountLog.setMemo("");
			userAccountLog.setBusiNumber(userWithdrawal.getWithdrawalNumber());
			userAccountLog.setApplyId(userWithdrawal.getWithdrawalId());
			userAccountLogServ.insertSelective(userAccountLog);
			// 发送站内通知
			commonServ.sendall(userInf.getMobile(), SmsTypeUtil.P2P_WITHDRAWAL_APPLY,
					DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"),
					userWithdrawal.getAmount().add(new BigDecimal(userWithdrawal.getFee())).toString(), "", "");

			// 收取手续费
			// 收取手续费String chargeItem, String feeName, String userType

			if (Double.parseDouble(userWithdrawal.getFee()) > 0) {// 提现手续费要大于0
				// 发送转账接口到富友
				TransBmuBean transBmuBean = new TransBmuBean();
				BigDecimal amt2 = new BigDecimal(userWithdrawal.getFee()).multiply(new BigDecimal("100"));
				BigDecimal amt3 = amt2.divide(new BigDecimal("1"), 0, BigDecimal.ROUND_HALF_UP);
				transBmuBean.setAmt(amt3.toString());// 金额
				transBmuBean.setOut_cust_no(userInf.getJzhloginid());// 转出账户
				transBmuBean.setIn_cust_no(FyUtil.MCHNT_USER_ID);// 转入账户
				TransBmuResp transBmuRespData = new TransBmuResp();
				String transBmuRespCode = "";
				try {
					// 转账时传入入账用户信息，平台交易类型，平台交易备注
					transBmuRespData = capitalMgtServ.transferBmu(transBmuBean, userInf, null, "提现手续费",
							userWithdrawal.getWithdrawalNumber());
					transBmuRespCode = transBmuRespData.getResponse().getResp_code();
				} catch (Exception e) {
					log.info("收取提现手续费时系统异常！流水号：" + transBmuBean.getMchnt_txn_ssn() + ",提现编号："
							+ userWithdrawal.getWithdrawalId());
					e.printStackTrace();
				}
				if (FyUtil.SUCCESS.equals(transBmuRespCode)) {
					log.info("transBmuRespCode = " + transBmuRespCode + "转账成功,从" + "user.getJzhloginid()" + "转出3到"
							+ FyUtil.MCHNT_USER_ID);
					// 转账成功修改 对账表信息
					siteBillingServ.updateBusiStatus(0, transBmuRespData.getResponse().getMchnt_txn_ssn());
					// 保存信息到手续费记录表
					// 更新账户表
					updateUserAccount(userInf);
					userAccount = userAccountServ.selectByUserId(userInf.getUserId());
					// 保存信息到账户信息记录表
					userAccountLog = new UserAccountLogVO();
					userAccountLog.setUserId(userInf.getUserId());
					userAccountLog.setType(4103);
					userAccountLog.setMoney(new BigDecimal(userWithdrawal.getFee()));
					userAccountLog.setTotal(userAccount.getTotal());
					userAccountLog.setFrost(userAccount.getFrost());
					userAccountLog.setCash(userAccount.getCash());
					userAccountLog.setAddTime(DateUtil.getUnixTime());
					userAccountLog.setApplyId(userWithdrawal.getWithdrawalId());
					userAccountLog.setFrom(userInf.getUserId());
					userAccountLog.setTo(FyUtil.MCHNT_USER_ID);
					userAccountLog.setMemo("");
					// 生成提现手续费编号
					String oldMaxBusiNumber = userAccountLogServ
							.findMaxBusiNumber("TXF" + DateUtil.getCurrentDate("yyyyMMdd"));
					log.info("oldMaxBusiNumber==" + oldMaxBusiNumber);
					String busiNumber = UserAccountUtil.getBusiNumber(oldMaxBusiNumber, "TXF");
					log.info("busiNumber==" + busiNumber);
					userAccountLog.setBusiNumber(busiNumber);
					userAccountLogServ.insertSelective(userAccountLog);

					// 更新平台收益相关记录
					// 平台收益记录
					SiteAccountLogVO siteAccountLog = new SiteAccountLogVO();
					if ("1".equals(userInf.getUserType())) {
						siteAccountLog.setFeeId(siteFeeServ.queryChageMode(null, "投资人提现手续费", null).getChargeFeeId());
					} else if ("2".equals(userInf.getUserType())) {
						siteAccountLog.setFeeId(siteFeeServ.queryChageMode(null, "借款人提现手续费", null).getChargeFeeId());
					} else {
						siteAccountLog.setFeeId(siteFeeServ.queryChageMode(null, "机构提现手续费", null).getChargeFeeId());
					}
					siteAccountLog.setUserId(userInf.getUserId());
					siteAccountLog.setMoney(new BigDecimal(userWithdrawal.getFee()));
					siteAccountLog.setCreated(DateUtil.getUnixTime());
					siteAccountLogServ.addSiteAccountLog(siteAccountLog);
					SiteAccountVO siteAccount = null;
					// 总收益更新
					if ("1".equals(userInf.getUserType())) {
						siteAccount = siteAccountServ.findSiteAccountByFeeName("投资人提现手续费");
					} else if ("2".equals(userInf.getUserType())) {
						siteAccount = siteAccountServ.findSiteAccountByFeeName("借款人提现手续费");
					} else {
						siteAccount = siteAccountServ.findSiteAccountByFeeName("机构提现手续费");
					}
					siteAccount.setIncome(siteAccount.getIncome().add(new BigDecimal(userWithdrawal.getFee())));
					siteAccountServ.updateSiteAccount(siteAccount);
				}else{
					// 转账失败修改 对账表信息
					siteBillingServ.updateBusiStatus(1,transBmuRespData.getResponse().getMchnt_txn_ssn());
				}
			}
			
			return "redirect:/myAccount/enterUserAccount";

		} else {
			// 提现失败修改 对账表信息
			siteBillingServ.updateBusiStatus(1, mchnt_txn_ssn);
			model.addAttribute("code", code);
			return "fail.jsp";
		}

	}

}
