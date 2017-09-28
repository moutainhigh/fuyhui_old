package com.fujfu.common.payment.fuyou;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fujfu.common.payment.fuyou.http.WebUtils;
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
import com.fujfu.common.payment.fuyou.util.SecurityUtils;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.common.util.XMLUtil;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.SiteBillingServ;


/**
 * 富友支付接口类，资金管理类
 * @author 
 */
@Component
public class CapitalMgt {
	@Autowired 
	private  SiteBillingServ siteBillingServ;
	
	public SiteBillingServ getSiteBillingServ() {
		return siteBillingServ;
	}

	private static CapitalMgt capitalMgt; 
	 public void setSiteBillingServ(SiteBillingServ siteBillingServ) {  
	        this.siteBillingServ = siteBillingServ;  
	    }  
	 @PostConstruct 
	   public void init() { 
		 capitalMgt = this; 
		 capitalMgt.siteBillingServ = this.siteBillingServ; 
	    } 
	public static void main(String[] args) throws Exception{
		System.out.println("start !!");
		CapitalFreezeBean bean = new CapitalFreezeBean();
		bean.setAmt("1000");
		String inputStr = bean.regSignVal();
		//String signatureStr = SecurityUtils.sign(inputStr);
		//bean.setSignature(signatureStr);
		String backXML = WebUtils.sendHttp("http://localhost/rep/txRet2", bean);
		System.out.println("backXML = " + backXML);
		System.out.println("end !!");
		//CapitalFreezeResp respData = XMLUtil.toBean(CapitalFreezeResp.class, backXML);
	}
	
	private static Logger log = Logger.getLogger(CapitalMgt.class);
	
	/**
	 * 资金冻结记流水
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static CapitalFreezeResp capitalFreeze(CapitalFreezeBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem) throws Exception {
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
		reqData.setRem("");
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		
		System.out.println(signatureStr);
		//保存数据到对账表fu_site_billing
		capitalMgt.siteBillingServ.addSiteBilling(outUser, inUser, reqData.getMchnt_txn_ssn(), new BigDecimal(reqData.getAmt()).divide(new BigDecimal("100")),siteBusiType, siteBusiRem,reqData.regSignVal());
		
		String backXML = WebUtils.sendHttp(FyUtil.FREEZE, reqData);
		CapitalFreezeResp respData = XMLUtil.toBean(CapitalFreezeResp.class, backXML);
		boolean b=SecurityUtils.verifySign(XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
		System.out.println("capitalFreeze-=============="+b);
		log.info("capitalFreeze资金冻结验签结果-=============="+b);
		return respData;
		
	}
//	/**
//	 * 资金冻结
//	 * @param reqData
//	 * @return
//	 * @throws Exception
//	 */
//	public static CapitalFreezeResp capitalFreeze(CapitalFreezeBean reqData) throws Exception {
//		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
//		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
//		reqData.setRem("");
//		String inputStr = reqData.regSignVal();
//		String signatureStr = SecurityUtils.sign(inputStr);
//		reqData.setSignature(signatureStr);
//		
//		System.out.println(signatureStr);
//		
//		String backXML = WebUtils.sendHttp(FyUtil.FREEZE, reqData);
//		CapitalFreezeResp respData = XMLUtil.toBean(CapitalFreezeResp.class, backXML);
//		boolean b=SecurityUtils.verifySign(XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
//		System.out.println("capitalFreeze-=============="+b);
//		log.info("capitalFreeze资金冻结验签结果-=============="+b);
//		return respData;
//		
//	}
	
	/**
	 * 资金解冻(记流水)
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static CapitalUnFreezeResp capitalUnFreeze(CapitalUnFreezeBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem) throws Exception {		
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		//reqData.setContract_no("201607081706");//预授权合同号-付款用户为个人用户时该字段有效
		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		
		System.out.println(signatureStr);
		//保存数据到对账表fu_site_billing
		capitalMgt.siteBillingServ.addSiteBilling(outUser, inUser, reqData.getMchnt_txn_ssn(), new BigDecimal(reqData.getAmt()).divide(new BigDecimal("100")),siteBusiType, siteBusiRem,reqData.regSignVal());

		String backXML = WebUtils.sendHttp(FyUtil.UN_FREEZE, reqData);
		CapitalUnFreezeResp respData = XMLUtil.toBean(CapitalUnFreezeResp.class, backXML);
		boolean b=SecurityUtils.verifySign(XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
		System.out.println("capitalUnFreeze-=============="+b);
		log.info("capitalUnFreeze资金解冻验签结果-=============="+b);
		return respData;
	}
//	/**
//	 * 资金解冻
//	 * @param reqData
//	 * @return
//	 * @throws Exception
//	 */
//	public static CapitalUnFreezeResp capitalUnFreeze(CapitalUnFreezeBean reqData) throws Exception {		
//		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
//		//reqData.setContract_no("201607081706");//预授权合同号-付款用户为个人用户时该字段有效
//		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
//		String inputStr = reqData.regSignVal();
//		String signatureStr = SecurityUtils.sign(inputStr);
//		reqData.setSignature(signatureStr);
//		
//		System.out.println(signatureStr);
//		
//		String backXML = WebUtils.sendHttp(FyUtil.UN_FREEZE, reqData);
//		CapitalUnFreezeResp respData = XMLUtil.toBean(CapitalUnFreezeResp.class, backXML);
//		boolean b=SecurityUtils.verifySign(XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
//		System.out.println("capitalUnFreeze-=============="+b);
//		log.info("capitalUnFreeze资金解冻验签结果-=============="+b);
//		return respData;
//	}
	
	/**
	 * 转账(商户与个人之间  计流水)
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static TransBmuResp transferBmu(TransBmuBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem) throws Exception {
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		//reqData.setContract_no("201607081706");//预授权合同号-付款用户为个人用户时该字段有效
		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		
		//保存对账信息
		//保存数据到对账表fu_site_billing
		capitalMgt.siteBillingServ.addSiteBilling(outUser, inUser, reqData.getMchnt_txn_ssn(), new BigDecimal(reqData.getAmt()).divide(new BigDecimal("100")),siteBusiType, siteBusiRem,reqData.regSignVal());
		
		
		String backXML = WebUtils.sendHttp(FyUtil.TRANSFER_BMU, reqData);
		log.info("backXMLjiequ = "+XMLUtil.getSignData(backXML));
		log.info("inputStrjiami = "+SecurityUtils.sign(XMLUtil.getSignData(backXML)));
		TransBmuResp respData = XMLUtil.toBean(TransBmuResp.class, backXML);
		log.info("respDatagetSignature = "+respData.getSignature());

		boolean b=SecurityUtils.verifySign(XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
		System.out.println("transferBmu-=============="+b);
		log.info("transferBmu资金转账验签结果-=============="+b);
		return respData;
	}
//	/**
//	 * 转账(商户与个人之间)
//	 * @param reqData
//	 * @return
//	 * @throws Exception
//	 */
//	public static TransBmuResp transferBmu(TransBmuBean reqData) throws Exception {
//		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
//		//reqData.setContract_no("201607081706");//预授权合同号-付款用户为个人用户时该字段有效
//		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
//		String inputStr = reqData.regSignVal();
//		String signatureStr = SecurityUtils.sign(inputStr);
//		reqData.setSignature(signatureStr);
//				
//		String backXML = WebUtils.sendHttp(FyUtil.TRANSFER_BMU, reqData);
//		log.info("backXMLjiequ = "+XMLUtil.getSignData(backXML));
//		log.info("inputStrjiami = "+SecurityUtils.sign(XMLUtil.getSignData(backXML)));
//		TransBmuResp respData = XMLUtil.toBean(TransBmuResp.class, backXML);
//		log.info("respDatagetSignature = "+respData.getSignature());
//
//		boolean b=SecurityUtils.verifySign(XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
//		System.out.println("transferBmu-=============="+b);
//		log.info("transferBmu资金转账验签结果-=============="+b);
//		return respData;
//	}
	
	/**
	 * 划拨记流水(个人与个人之间)
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static TransBuResp transferBu(TransBuBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem) throws Exception {
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		//保存对账信息
		//保存数据到对账表fu_site_billing
		capitalMgt.siteBillingServ.addSiteBilling(outUser, inUser, reqData.getMchnt_txn_ssn(), new BigDecimal(reqData.getAmt()).divide(new BigDecimal("100")),siteBusiType, siteBusiRem,reqData.regSignVal());

		String backXML = WebUtils.sendHttp(FyUtil.TRANSFER_BU, reqData);
		TransBuResp respData = XMLUtil.toBean(TransBuResp.class, backXML);
		boolean b=SecurityUtils.verifySign(XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
		System.out.println("transferBu-=============="+b);
		log.info("transferBu资金划拨验签结果-=============="+b);
		return respData;
	}
//	/**
//	 * 划拨(个人与个人之间)
//	 * @param reqData
//	 * @return
//	 * @throws Exception
//	 */
//	public static TransBuResp transferBu(TransBuBean reqData) throws Exception {
//		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
//		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
//		String inputStr = reqData.regSignVal();
//		String signatureStr = SecurityUtils.sign(inputStr);
//		reqData.setSignature(signatureStr);
//		
//		String backXML = WebUtils.sendHttp(FyUtil.TRANSFER_BU, reqData);
//		TransBuResp respData = XMLUtil.toBean(TransBuResp.class, backXML);
//		boolean b=SecurityUtils.verifySign(XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
//		System.out.println("transferBu-=============="+b);
//		log.info("transferBu资金划拨验签结果-=============="+b);
//		return respData;
//	}
	
	/**
	 * 余额查询
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static QueryBalanceResp queryBalance(QueryBalanceBean reqData) throws Exception {
		
		//请求明文
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		log.info("signature = " + signatureStr);
		
		String backXML = WebUtils.sendHttp(FyUtil.QUERY_BALANCE, reqData);
		QueryBalanceResp respData= XMLUtil.toBean(QueryBalanceResp.class, backXML);
		boolean b=SecurityUtils.verifySign(XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
		System.out.println("queryBalance-=============="+b);
		log.info("queryBalance余额查询验签结果-=============="+b);
		return respData;
		}
	
	/**
	 * 冻结到冻结接口记流水
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static TransBuFreeze2FreezeResp freeze2freeze(TransBuFreeze2FreezeBean reqData,UserVO outUser,UserVO inUser,String siteBusiType, String siteBusiRem) 
			throws Exception {
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		//保存对账信息
				//保存数据到对账表fu_site_billing
		capitalMgt.siteBillingServ.addSiteBilling(outUser, inUser, reqData.getMchnt_txn_ssn(), new BigDecimal(reqData.getAmt()).divide(new BigDecimal("100")),siteBusiType, siteBusiRem,reqData.regSignVal());

		String backXML = WebUtils.sendHttp(FyUtil.FREEZE_2_F, reqData);
		TransBuFreeze2FreezeResp respData = 
					XMLUtil.toBean(TransBuFreeze2FreezeResp.class, backXML);
		boolean b=SecurityUtils.verifySign(XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
		System.out.println("freeze2freeze-=============="+b);
		log.info("freeze2freeze冻结到冻结接口验签结果-=============="+b);
		return respData;
	}
	/**
	 * 冻结到冻结接口
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
//	public static TransBuFreeze2FreezeResp freeze2freeze(TransBuFreeze2FreezeBean reqData) 
//			throws Exception {
//		reqData.setMchnt_cd(FyUtil.MCHNT_CD);
//		reqData.setMchnt_txn_ssn(DateUtil.getCurrentDate("yyyyMMddHHmmss")+UserAccountUtil.getManyNumber(4));
//		String inputStr = reqData.regSignVal();
//		String signatureStr = SecurityUtils.sign(inputStr);
//		reqData.setSignature(signatureStr);
//		
//		String backXML = WebUtils.sendHttp(FyUtil.FREEZE_2_F, reqData);
//		TransBuFreeze2FreezeResp respData = 
//					XMLUtil.toBean(TransBuFreeze2FreezeResp.class, backXML);
//		boolean b=SecurityUtils.verifySign(XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
//		System.out.println("freeze2freeze-=============="+b);
//		log.info("freeze2freeze冻结到冻结接口验签结果-=============="+b);
//		return respData;
//	}
	
	/**
	 * 充值提现交易明细查询
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static QueryReOrWithDetailsBeanResp queryReOrWithDetails(QueryReOrWithDetailsBean reqData) throws Exception {
		
		//请求明文
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		log.info("signature = " + signatureStr);		
		String backXML = WebUtils.sendHttp(FyUtil.QUERY_CZTX, reqData);
		QueryReOrWithDetailsBeanResp respData = XMLUtil.toBean(QueryReOrWithDetailsBeanResp.class, backXML);
		boolean b=SecurityUtils.verifySign(XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
		System.out.println("queryReOrWithDetails-=============="+b);
		log.info("queryReOrWithDetails充值提现交易明细验签结果-=============="+b);
		return respData;
		}
	
	/**
	 * 交易明细查询
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	public static QueryTransactionDetailsBeanResp queryTransactionDetails(QueryTransactionDetailsBean reqData) throws Exception {
		
		//请求明文
		String inputStr = reqData.regSignVal();
		String signatureStr = SecurityUtils.sign(inputStr);
		reqData.setSignature(signatureStr);
		log.info("signature = " + signatureStr);		
		String backXML = WebUtils.sendHttp(FyUtil.QUERY_TXN, reqData);
		System.out.println("11111===="+backXML);
		QueryTransactionDetailsBeanResp respData = XMLUtil.toBean(QueryTransactionDetailsBeanResp.class, backXML);
		boolean b=SecurityUtils.verifySign(XMLUtil.getSignData(backXML),respData.getSignature());//验签结果
		System.out.println("queryTransactionDetails-=============="+b);
		log.info("queryTransactionDetails交易明细查询验签结果-=============="+b);
		return respData;
		}
}
