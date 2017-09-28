package com.fujfu.service.util;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/**
 * 等额本金工具类
 * @author Administrator
 * 等额本金是指一种贷款的还款方式，是在还款期内把贷款数总额等分，每月偿还同等数额的本金和剩余贷款在该月所产生的利息，这样由于每月的还款本金额固定，
 * 而利息越来越少，借款人起初还款压力较大，但是随时间的推移每月还款数也越来越少。
 */
public class AverageCapitalUtils {
	/**
	 * 等额本金计算获取还款方式为等额本金的每月偿还本金和利息
	 * 
	 * 公式：每月偿还本金=(贷款本金÷还款月数)+(贷款本金-已归还本金累计额)×月利率
	 * 
	 * @param invest
	 *            总借款额（贷款本金）
	 * @param yearRate
	 *            年利率
	 * @param month
	 *            还款总月数
	 * @return 每月偿还本金和利息,不四舍五入，直接截取小数点最后两位
	 */
	public static Map<Integer, Double> calculatePerMonthPrincipalInterest(double invest, double yearRate, int totalMonth) {
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		// 每月本金
		double monthPri = calculatePerMonthPrincipal(invest, totalMonth);
		// 获取月利率
		double monthRate = yearRate / 12;
		monthRate = new BigDecimal(monthRate).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
		for (int i = 1; i <= totalMonth; i++) {
			double monthRes = monthPri + (invest - monthPri * (i - 1)) * monthRate;
			monthRes = new BigDecimal(monthRes).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			map.put(i, monthRes);
		}
		return map;
	}

	/**
	 * 等额本金计算获取还款方式为等额本金的每月偿还利息
	 * 
	 * 公式：每月应还利息=剩余本金×月利率=(贷款本金-已归还本金累计额)×月利率
	 * 
	 * @param invest
	 *            总借款额（贷款本金）
	 * @param yearRate
	 *            年利率
	 * @param month
	 *            还款总月数
	 * @return 每月偿还利息
	 */
	public static Map<Integer, Double> calculatePerMonthInterest(double invest, double yearRate, int totalMonth) {
		Map<Integer, Double> inMap = new HashMap<Integer, Double>();
		double principal = calculatePerMonthPrincipal(invest, totalMonth);
		Map<Integer, Double> map = calculatePerMonthPrincipalInterest(invest, yearRate, totalMonth);
		for (Map.Entry<Integer, Double> entry : map.entrySet()) {
			BigDecimal principalBigDecimal = new BigDecimal(principal);
			BigDecimal principalInterestBigDecimal = new BigDecimal(entry.getValue());
			BigDecimal interestBigDecimal = principalInterestBigDecimal.subtract(principalBigDecimal);
			interestBigDecimal = interestBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
			inMap.put(entry.getKey(), interestBigDecimal.doubleValue());
		}
		return inMap;
	}

	/**
	 * 等额本金计算获取还款方式为等额本金的每月偿还本金
	 * 
	 * 公式：每月应还本金=贷款本金÷还款月数
	 * 
	 * @param invest
	 *            总借款额（贷款本金）
	 * @param yearRate
	 *            年利率
	 * @param month
	 *            还款总月数
	 * @return 每月偿还本金
	 */
	public static double calculatePerMonthPrincipal(double invest, int totalMonth) {
		BigDecimal monthIncome = new BigDecimal(invest).divide(new BigDecimal(totalMonth), 2, BigDecimal.ROUND_HALF_UP);
		return monthIncome.doubleValue();
	}

	/**
	 * 等额本金计算获取还款方式为等额本金的总利息
	 * 
	 * @param invest
	 *            总借款额（贷款本金）
	 * @param yearRate
	 *            年利率
	 * @param month
	 *            还款总月数
	 * @return 总利息
	 */
	public static double calculateInterestCount(double invest, double yearRate, int totalMonth) {
		BigDecimal count = new BigDecimal(0);
		Map<Integer, Double> mapInterest = calculatePerMonthInterest(invest, yearRate, totalMonth);

		for (Map.Entry<Integer, Double> entry : mapInterest.entrySet()) {
			count = count.add(new BigDecimal(entry.getValue()));
		}
		return count.doubleValue();
	}
	
	/**
	 * 应还本息总和
	 * @param invest
	 * @param yearRate
	 * @param totalMonth
	 * @return
	 */
	public static double calculatePrincipalInterestCount(double invest, double yearRate, int totalMonth){
		Map<Integer, Double> map = calculatePerMonthPrincipalInterest(invest, yearRate, totalMonth);
		double total = 0;
		for(Entry<Integer, Double> entry : map.entrySet()){
			total += entry.getValue();
		}
		return total;
	}
	
	/**	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double invest = 3000; // 本金
		int month = 6;
		double yearRate = 0.12; // 年利率
		Map<Integer, Double> getPerMonthPrincipalInterest = calculatePerMonthPrincipalInterest(invest, yearRate, month);
		System.out.println("等额本金---每月本息：" + getPerMonthPrincipalInterest);
		double benjin = calculatePerMonthPrincipal(invest, month);
		System.out.println("等额本金---每月本金:" + benjin);
		Map<Integer, Double> mapInterest = calculatePerMonthInterest(invest, yearRate, month);
		System.out.println("等额本金---每月利息:" + mapInterest);
		double count = calculateInterestCount(invest, yearRate, month);
		System.out.println("等额本金---总利息：" + count);
		System.out.println("等额本金---应还本息总和：" + calculatePrincipalInterestCount(invest, yearRate, month));
	}
}
