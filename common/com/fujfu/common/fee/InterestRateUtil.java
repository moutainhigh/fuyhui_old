package com.fujfu.common.fee;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 利息计算类
 * @author dongsheng
 * @update 2016-6-22
 *
 */
public class InterestRateUtil {
	/**
	 * 按月结息，到期还本
	 * 每期利息=本金*月利率 
	 * 最后一次还本息=本金+当期利息
	 * @param invest 借款金额 
	 * @param yearRate 年利率
	 * @param totalmonth 期数
	 * @return 每期利息，最后次为本息
	 */
	public static Map<Integer, Double> monthlySavings(double invest,double yearRate,int totalmonth){
		double monthRate = yearRate / 12;
		Map<Integer, Double> monthlyRepayment = new HashMap<Integer, Double>();
		for(int i=0;i<totalmonth-1;i++){
			monthlyRepayment.put(i, invest*monthRate);
		}
		monthlyRepayment.put(totalmonth, invest+invest*monthRate);
		return monthlyRepayment;
	}
	/**按月结息，到期还本总额*/
	public static double totalMonthlySavings(double invest,double yearRate,int totalmonth){
		Map<Integer, Double> map = monthlySavings(invest,yearRate,totalmonth);
		double total = 0;
		for(Entry<Integer, Double> entry : map.entrySet()){
			total += entry.getValue();
		}
		return total;
	}
	
	/**
	 * 一次性还本息
	 * 本息=本金+本金*月利率*借款期数
	 * @param invest 借款金额
	 * @param yearRate 年利率
	 * @param days 天数
	 * @return 本息
	 */
	public static double noceSavings(double invest,double yearRate,int days){
		double dayRate = yearRate / 365;
		return invest+invest*dayRate*days;
	}
	
	public static void main(String[] args){
		//按月结息
		System.out.println(monthlySavings(300000, 0.0828, 5));
		System.out.println(totalMonthlySavings(300000, 0.0828, 5));
		
		System.out.println(monthlySavings(5000, 0.12, 3));
		System.out.println(totalMonthlySavings(5000, 0.12, 3));
		//一次性还本息
		System.out.println(noceSavings(300000, 0.0828, 150));
		System.out.println(noceSavings(5000, 0.12, 90));
	}
	
}
