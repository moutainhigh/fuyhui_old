package com.fujfu.common.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import com.fujfu.pojo.fee.SiteFeeTypePOJO;

public class UserAccountUtil {
	private static Logger log = Logger.getLogger(UserAccountUtil.class);

	// 计算手续费
	public static BigDecimal getPoundageAmt(SiteFeeTypePOJO siteFeeTypeVo, BigDecimal money) {
		BigDecimal fee = new BigDecimal("0");
		if (siteFeeTypeVo != null) {
			if (siteFeeTypeVo.getFormulaType() == 1) {
				fee = money.multiply(siteFeeTypeVo.getInterestRate().divide(new BigDecimal("100")));
			} else {
				fee = siteFeeTypeVo.getAmount();
			}
		} else {
		}
		return fee;
		// 收取手续费
	}

	// 生成投资债权编号
	
	public static String getInvestmentClaimNumber(String oldMaxclaimNumber,String name) {
		String newclaimNumber = "";
		int i=0;
		if(StringUtils.isNotEmpty(name)){
		i =name.length();
		}
		String s = oldMaxclaimNumber.substring(0,11+i);
		String s1 = oldMaxclaimNumber.substring(11+i);
		if (s1.length() >= 3) {
			newclaimNumber = getFomatString(s1, 3, 10);
		}
		return s + newclaimNumber;
	}

	// 生成借款编号
	public static String getApplyOrderNumber(String oldMaxOrderNumber,String name) {
		String newOrderNumber = "";
		int i=0;
		if(StringUtils.isNotEmpty(name)){
		i =name.length();
		}
		String s = oldMaxOrderNumber.substring(0, i+8);
		String s1 = oldMaxOrderNumber.substring(i+8);
		if (s1.length() >= 3) {
			newOrderNumber = getFomatString(s1, 3, 10);
		}
		return s + newOrderNumber;
	}

	// 生成充值编号
	public static String getRechargeNumber(String oldMaxRechargeNumber) {
		String newRechargeNumber = "";
		String s = oldMaxRechargeNumber.substring(0, 10);
		String s1 = oldMaxRechargeNumber.substring(10);
		if (s1.length() >= 3) {
			newRechargeNumber = getFomatString(s1, 5, 10);
		}
		return s + newRechargeNumber;
	}

	// 生成提现编号
	public static String getWithdrawalNumber(String oldMaxWithdrawalNumber) {
		String newWithdrawalNumber = "";
		String s = oldMaxWithdrawalNumber.substring(0, 10);
		String s1 = oldMaxWithdrawalNumber.substring(10);
		if (s1.length() >= 3) {
			newWithdrawalNumber = getFomatString(s1, 5, 10);
		}
		return s + newWithdrawalNumber;
	}
	
	// 生成手续费编号
	public static String getBusiNumber(String oldMaxbusiNumber,String str) {
		String busiNumber="";
		if ("".equals(oldMaxbusiNumber) || oldMaxbusiNumber == null) {
			busiNumber = str + DateUtil.getCurrentDate("yyyyMMdd") + "00001";
		} else {
			String newbusiNumber = "";
			String s = oldMaxbusiNumber.substring(0, 10);
			String s1 = oldMaxbusiNumber.substring(10);
			if (s1.length() >= 3) {
				newbusiNumber = getFomatString(s1, 5, 10);
			}
			busiNumber=s + newbusiNumber;
		}
			return busiNumber;
		}

	// 生成4位随机数
	public static String getManyNumber(int weishu) {
		String str = "";
		Random random = new Random();
		int i = random.nextInt(1000);
		str = String.valueOf(i);
		str = getFomatString(str, weishu, weishu);
		return str;
	}

	public static String getFomatString(String str1, int minsize, int maxsize) {
		NumberFormat nf = NumberFormat.getInstance();
		// 设置是否使用分组
		nf.setGroupingUsed(false);
		// 设置最大整数位数
		nf.setMaximumIntegerDigits(maxsize);
		// 设置最小整数位数
		nf.setMinimumIntegerDigits(minsize);
		Integer intHao = Integer.parseInt(str1);
		intHao++;
		String newStr = nf.format(intHao);
		log.info("newStr===" + newStr);
		return newStr;
	}
	public static void main(String [] args){
		String s =getApplyOrderNumber("jjjjjj20170803001","嘎哈地方jj");
		System.out.println(s);
	}
}
