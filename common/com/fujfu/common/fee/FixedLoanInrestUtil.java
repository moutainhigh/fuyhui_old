package com.fujfu.common.fee;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * 
 * @author peter
 *
 */

public class FixedLoanInrestUtil {
	
	
	/**
	 * 利息明细计划计算
	 * 
	 * @param fixedLoanInrestVo
	 *            
	 * @return 利息计划
	 */	
	public static FixedLoanInrestVo calulate(FixedLoanInrestVo fixedLoanInrestVo){
		//起始日期（yyyyMMdd）
		Date startDate = parseDate(fixedLoanInrestVo.getStartDate());
		
		// 结束日期（yyyyMMdd）
		//结束日期
		Date endDate = parseDate(fixedLoanInrestVo.getEndDate());
		
		//年利率
		BigDecimal yearReate = fixedLoanInrestVo.getRate();

		//总的本金金额
		BigDecimal totalCaptital = fixedLoanInrestVo.getTotalCaptital();
		

		//利息周期方式
		int perIntrestDuration = fixedLoanInrestVo.getPerIntrestDuration();
		
		
		//利息计划明细
		ArrayList<FixedLoanInrestSubVo> periodDetail = new ArrayList<FixedLoanInrestSubVo>();	
		
		//利息方式
		if (perIntrestDuration == 0){
			FixedLoanInrestSubVo fixedLoanInrestSubVo = new FixedLoanInrestSubVo();
			//利息期数
			fixedLoanInrestSubVo.setPeriod(1);
			//天数
			int days = caculateDays(startDate,endDate);
			
			
			BigDecimal intrest = caculateIntrest(totalCaptital,yearReate,days);
			//每期利息
			fixedLoanInrestSubVo.setPerIntrest(intrest);
			
			
			//当期开始日期
			fixedLoanInrestSubVo.setStartDate(fixedLoanInrestVo.getStartDate());			
			
			//当期还款日
			
			fixedLoanInrestSubVo.setEndDate(fixedLoanInrestVo.getEndDate());
			
			//剩余利息
			fixedLoanInrestSubVo.setRemainSum(new BigDecimal(0.00));
			
			//身故本息和
			fixedLoanInrestSubVo.setRemainSum(new BigDecimal(0.00));
			
			//本期应还金额
			fixedLoanInrestSubVo.setPerSum(totalCaptital.add(intrest));
			
			//还款本金
			fixedLoanInrestSubVo.setPerCapital(totalCaptital);			
			
			periodDetail.add(fixedLoanInrestSubVo);
			//还款利息明细
			fixedLoanInrestVo.setPeriodDetail(periodDetail);
			
			fixedLoanInrestVo.setTotalIntrest(intrest);
			
			//总的还款期数
			fixedLoanInrestVo.setTotalPeriod(1);
			

			
			//总的本息和
			fixedLoanInrestVo.setTotalRepayment(totalCaptital.add(intrest));
			
			return fixedLoanInrestVo;
			
		} else {
			//下个周期日
			Date perEndDate = null;
			
			
			Integer payDay = fixedLoanInrestVo.getPayDay();
			

			
			/*如果输入指定还款日为空，则还款日为实际放款日*/
			if(payDay == null || payDay == 0||fixedLoanInrestVo.getOffLineLoanDate()==null||"".equals(fixedLoanInrestVo.getOffLineLoanDate())){
				payDay = Integer.valueOf(fixedLoanInrestVo.getStartDate().substring(6, 8));
			}
			
			//上一周期还款日期
			Date prevEndDate = new Date();
			prevEndDate.setTime(startDate.getTime());			
			
			/**首次计算看是否足期*/
			//首期足期标志
			boolean fullFlag = false;
			
			
			//月末日
			String lastday  = parseDateToString(getCurrentMonthLastDay(prevEndDate)).substring(6, 8);
			
			//当前日
			String day  = parseDateToString(prevEndDate).substring(6, 8);
			
			
			
			/*利息间隔只有一个月*/
			if(perIntrestDuration == 1){
				/*还款日比月末日期大 */
				if(payDay > Integer.valueOf(lastday)){
					/*当前日等于月末日，足期，直接算下期*/
					
					if(Integer.valueOf(lastday) == Integer.valueOf(day)){
						fullFlag = true;
						perEndDate = calulateNextMonthDay(prevEndDate,perIntrestDuration,payDay);
						
					/*当前日小于月末日，不足期,下个还款日为月末*/	
					} else if (Integer.valueOf(lastday) > Integer.valueOf(day)){
						fullFlag = false;
						//月末
						perEndDate = getCurrentMonthLastDay(prevEndDate);
						
					}	
				/*还款日比月末日期小  */	
				} else if(payDay < Integer.valueOf(lastday)){
					
					
					/*当前日等于还款日，足期*/
					if(Integer.valueOf(day) == Integer.valueOf(payDay)){
						perEndDate = calulateNextMonthDay(prevEndDate,perIntrestDuration,payDay);
						fullFlag = true;
					
					/*当前日大于还款日，不足期  */
					} else  if(Integer.valueOf(day) > Integer.valueOf(payDay)){
						fullFlag = false;
						//下个周期为下个周期还款日
						
						Date temp = calulateNextDay(prevEndDate,Integer.valueOf(payDay) - Integer.valueOf(day));
						perEndDate = calulateNextMonthDay(temp,perIntrestDuration,payDay);
						
						
					/*当前日小于还款日，不足期*/	
					} else  if(Integer.valueOf(day) < Integer.valueOf(payDay)){
						fullFlag = false;
						//下个周期为当月还款日
						perEndDate = calulateNextDay(prevEndDate,Integer.valueOf(payDay) - Integer.valueOf(day));
					}
					
				/*还款日等于月末日期*/		
				} else if(payDay == Integer.valueOf(lastday)){
					
					/*当前日等于月末日，足期，直接算下期	*/
					if(Integer.valueOf(lastday) == Integer.valueOf(day)){
						perEndDate = calulateNextMonthDay(prevEndDate,perIntrestDuration,payDay);
						fullFlag = true;
						
					/*当前日小于月末日，不足期*/	
					} else if (Integer.valueOf(lastday) > Integer.valueOf(day)){
						fullFlag = false;
						//月末
						perEndDate = getCurrentMonthLastDay(prevEndDate);
					}	
				}
			} else{
				
				/*线下放款日期不为空，则为金桔系列*/
				if(fixedLoanInrestVo.getOffLineLoanDate()!=null&&!"".equals(fixedLoanInrestVo.getOffLineLoanDate())){
					/*利息间隔大于一个月  按照线下放款日计算大于或等于当前放款靠近的还款日期*/
					/*线下放款日日期的日替换成分期还款日后再开始计算*/
					String soffLineDate = fixedLoanInrestVo.getOffLineLoanDate().substring(0,6)+String.valueOf(payDay);
					Date doffLineDate = parseDate(soffLineDate);
					
					while(true){
						doffLineDate = calulateNextMonthDay(doffLineDate,perIntrestDuration,payDay);
						if(doffLineDate.compareTo(prevEndDate) == 1||doffLineDate.compareTo(prevEndDate) == 0){
							break;
						}
					}
					
					/*如果下个还款日和线上放款日期相等，足期，直接算下个周期*/
					if(doffLineDate.compareTo(prevEndDate) == 0){
						perEndDate = calulateNextMonthDay(perEndDate,perIntrestDuration,payDay);
					} else {
						/*如果月份相等直接按照单月周期逻辑算*/
						if(parseDateToString(prevEndDate).substring(4,6).equals(parseDateToString(doffLineDate).substring(4,6))){
	
							/*还款日比月末日期大 */
							if(payDay > Integer.valueOf(lastday)){
								/*当前日等于月末日，足期，直接算下棋*/
								
								if(Integer.valueOf(lastday) == Integer.valueOf(day)){
									fullFlag = true;
									perEndDate = calulateNextMonthDay(prevEndDate,perIntrestDuration,payDay);
									
								/*当前日小于月末日，不足期,下个还款日为月末*/	
								} else if (Integer.valueOf(lastday) > Integer.valueOf(day)){
									fullFlag = false;
									//月末
									perEndDate = getCurrentMonthLastDay(prevEndDate);
									
								}	
							/*还款日比月末日期小  */	
							} else if(payDay < Integer.valueOf(lastday)){
								
								
								/*当前日等于还款日，足期*/
								if(Integer.valueOf(day) == Integer.valueOf(payDay)){
									perEndDate = calulateNextMonthDay(perEndDate,perIntrestDuration,payDay);
									fullFlag = true;
								
								/*当前日大于还款日，不足期  */
								} else  if(Integer.valueOf(day) > Integer.valueOf(payDay)){
									fullFlag = false;
									//下个周期为下个周期还款日
									Date temp = calulateNextDay(prevEndDate,Integer.valueOf(payDay) - Integer.valueOf(day));
									perEndDate = calulateNextMonthDay(temp,perIntrestDuration,payDay);							
									
								/*当前日小于还款日，不足期*/	
								} else  if(Integer.valueOf(day) < Integer.valueOf(payDay)){
									fullFlag = false;
									//下个周期为当月还款日
									perEndDate = calulateNextDay(prevEndDate,Integer.valueOf(payDay) - Integer.valueOf(day));
								}
								
							/*还款日等于月末日期*/		
							} else if(payDay == Integer.valueOf(lastday)){
								
								/*当前日等于月末日，足期，直接算下期	*/
								if(Integer.valueOf(lastday) == Integer.valueOf(day)){
									perEndDate = calulateNextMonthDay(perEndDate,perIntrestDuration,payDay);
									fullFlag = true;
									
								/*当前日小于月末日，不足期*/	
								} else if (Integer.valueOf(lastday) > Integer.valueOf(day)){
									fullFlag = false;
									//月末
									perEndDate = getCurrentMonthLastDay(prevEndDate);
								}
							}
												
						} else {
							/*月份不等，直接取doffLineDate*/
							perEndDate = doffLineDate;
						}
					}	
				
				/*金猪系列直接算下期*/
				} else {
					perEndDate = calulateNextMonthDay(prevEndDate,perIntrestDuration,payDay);
				}
			}	
			//利息期数
			int i = 0;
			//总利息
			BigDecimal totalIntrest = new BigDecimal(0.00);
			//计算每期利息
			while(true){
				i++;
				FixedLoanInrestSubVo fixedLoanInrestSubVo = new FixedLoanInrestSubVo();
				//利息期数
				fixedLoanInrestSubVo.setPeriod(i);
				if(perEndDate.compareTo(endDate) == -1||perEndDate.compareTo(endDate) == 0){//没有到期或刚好到期
					
					BigDecimal Intrest = new BigDecimal("0");
					
					if(i==1){
						if(fullFlag){
							
							/*整期按照月季利率算*/
							Intrest = caculateIntrestMonths(totalCaptital,yearReate,perIntrestDuration);							
						} else {
							/*非整期按照实际天数计算*/
							 int days = caculateDays(prevEndDate,perEndDate);
							//每期利息
							 Intrest = caculateIntrest(totalCaptital,yearReate,days);						
						}
						
					} else {
						/*非第一期直接按照整期计算*/
						Intrest = caculateIntrestMonths(totalCaptital,yearReate,perIntrestDuration);
					}
					
					totalIntrest = totalIntrest.add(Intrest);
					//每期利息
					fixedLoanInrestSubVo.setPerIntrest(Intrest);
					
					//当期开始日期
					fixedLoanInrestSubVo.setStartDate(parseDateToString(prevEndDate));
					//当期还款日
					fixedLoanInrestSubVo.setEndDate(parseDateToString(perEndDate));
					
					//本期应还金额
					fixedLoanInrestSubVo.setPerSum(Intrest);
					
					//还款本金
					fixedLoanInrestSubVo.setPerCapital(new BigDecimal(0.00));
					
					//最后一期
					if(perEndDate.compareTo(endDate) == 0){
						fixedLoanInrestSubVo.setPerSum(Intrest.add(totalCaptital));		
						//还款本金
						fixedLoanInrestSubVo.setPerCapital(totalCaptital);
					}
					
					periodDetail.add(fixedLoanInrestSubVo);
					
					
					
					if(perEndDate.compareTo(endDate) == 0){
						break;
					}
					prevEndDate.setTime(perEndDate.getTime());
					perEndDate = calulateNextMonthDay(perEndDate,perIntrestDuration,payDay);
									
				} else if(perEndDate.compareTo(endDate) == 1){//最后一期不足一期按照实际天数算	
					//天数
					
					int days = 0;	
		
					days = caculateDays(prevEndDate,endDate);	
			
			
					//每期利息
					BigDecimal Intrest = caculateIntrest(totalCaptital,yearReate,days);
					fixedLoanInrestSubVo.setPerIntrest(Intrest);
					totalIntrest = totalIntrest.add(Intrest);
					//当期开始日期
					fixedLoanInrestSubVo.setStartDate(parseDateToString(prevEndDate));					
					//当期还款日为项目到期日
					fixedLoanInrestSubVo.setEndDate(parseDateToString(endDate));		
					
					//还款本金
					fixedLoanInrestSubVo.setPerCapital(totalCaptital);
					
					//本期应还金额
					fixedLoanInrestSubVo.setPerSum(Intrest);					
					
					//本期应还金额(最后一期)
					fixedLoanInrestSubVo.setPerSum(Intrest.add(totalCaptital));					
					
					periodDetail.add(fixedLoanInrestSubVo);
					break;
				}  else {
					break;
			    }		
				
			}

			fixedLoanInrestVo.setPeriodDetail(periodDetail);
			//总的利息
			fixedLoanInrestVo.setTotalIntrest(totalIntrest);
			//总的期数
			fixedLoanInrestVo.setTotalPeriod(i);
			BigDecimal total = totalCaptital.add(totalIntrest);
			//总的本息和
			fixedLoanInrestVo.setTotalRepayment(total);
			
			//每日每期还剩余利息
			for(FixedLoanInrestSubVo fixedLoanInrestSubVo:periodDetail){
				total = total.subtract(fixedLoanInrestSubVo.getPerSum());
				totalIntrest = totalIntrest.subtract(fixedLoanInrestSubVo.getPerIntrest());
				//剩余利息
				fixedLoanInrestSubVo.setRemainIntrest(totalIntrest);
				//剩余本息总和
				fixedLoanInrestSubVo.setRemainSum(total);
			}
						
		}
		
		return fixedLoanInrestVo;
	}
	
	/**
	 * 利息计算（按天计算），本金*天数*日利率 
	 * 
	 * @param capital
	 *            本金
	 * @param yearrate
	 *            年利率
	 * @param days
	 *            天数  
	 * @return 利息
	 */		
	public static BigDecimal caculateIntrest(BigDecimal capital,BigDecimal yearrate ,int days ){
		
		BigDecimal dayrate = yearrate.divide(new BigDecimal(36500),10,BigDecimal.ROUND_HALF_UP);

		return capital.multiply(dayrate).multiply(new BigDecimal(days)).setScale(10, BigDecimal.ROUND_HALF_UP);
		
	}
	/**
	 * 利息计算（月利率），本金*月利率*月份 
	 * 
	 * @param capital
	 *            本金
	 * @param yearrate
	 *            年利率
	 * @param days
	 *            月份数  
	 * @return 利息
	 */		
	
	
	public static BigDecimal caculateIntrestMonths(BigDecimal capital,BigDecimal yearrate,int months ){
		
		BigDecimal monthrate = yearrate.divide(new BigDecimal(1200),10,BigDecimal.ROUND_HALF_UP);

		return capital.multiply(monthrate).multiply(new BigDecimal(months)).setScale(10, BigDecimal.ROUND_HALF_UP);
		
	}	
	
	/**
	 * 计算日期间隔天数
	 * 
	 * @param start
	 *            起始日期
	 * @param Dend
	 *            结束日期
	 * @return 间隔天数
	 */		
	
	
	public static int caculateDays(Date start ,Date end){

		 return (int) ((end.getTime() - start.getTime()) / 1000 / 60 / 60 / 24);
	}
	
	

	
	/**
	 * 通过字符串获取日期类型yyyyMMdd
	 * 
	 * @param date
	 *            日期
	 * @return 日期（日期类型）
	 */			
	public static  Date parseDate(String  date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date returnDate = null; 
		try {
			returnDate =  sdf.parse(date);
			return returnDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		return  returnDate;
		
	}
	
	/**
	 * 通过日期获字符串yyyyMMdd
	 * 
	 * @param date
	 *            日期
	 * @return 日期（字符串类型）
	 */		
	
	public static  String parseDateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String returnDate = null; 
		returnDate =  sdf.format(date);
		return returnDate;	
	}	
	
	/**
	 * 比较两日期大小
	 * 
	 * @param date
	 *            比较日期1
	 * @param date
	 *            比较日期2	            
	 * @return 结果（int 型）
	 */			
	
	public static int compareDate(Date date1 ,Date date2){
		if(date1.getTime() > date2.getTime()) {
			return 1;
		} else if (date1.getTime() > date2.getTime()){
			return -1;
		} else {
			return 0;
		}
	}
	
	
	/**
	 * 计算当前月末
	 * 
	 * 
	 * */
	public static Date getCurrentMonthLastDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.roll(Calendar.DAY_OF_MONTH, -1);
        return   cal.getTime(); 
	}
	
	

	
	/**
	 * 计算XX月后一个周期的日期
	 * 
	 * @param curDate
	 *            日期
	 * @param months
	 *            间隔月份数
	 * @param payDay
	 *            还款日        
	 * @return XX月后日期
	 */		
	
	public static Date calulateNextMonthDay(Date curDate,int months,Integer payDay){
		
		Date returnDate = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		
		try {
			cal.setTime(curDate);
			cal.add(Calendar.MONTH, months);
		
			returnDate =  sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}		

		//月末日
		String lastday  = parseDateToString(getCurrentMonthLastDay(returnDate)).substring(6, 8);
		
		//当前日
		String day  = parseDateToString(returnDate).substring(6, 8);
		
		/*还款日大于当前日  且 还款日小于等于月末日  调整日期到还款日*/
		if(payDay>Integer.valueOf(day) && payDay<= Integer.valueOf(lastday) ){
			cal.setTime(returnDate);
			cal.add(Calendar.DATE, payDay - Integer.valueOf(day) );
			try {
				returnDate =  sdf.parse(sdf.format(cal.getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}					
		
		
		return returnDate;
	}	
	
	
	/**
	 * 
	 * 
	 * 计算间隔天数的日期
	 * 
	 * */
	
	
	public static Date calulateNextDay(Date curDate,Integer days){
		Date returnDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();	
		cal.setTime(curDate);
		cal.add(Calendar.DATE, days );
		try {
			returnDate =  sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	   return 	returnDate;
		
	}
	
	
	/**
	 * 
	 * 
	 * */
	
	
public static void main(String[] s){
	
	
	
	
	// 生成还款计划表
	FixedLoanInrestVo fixedLoanInrestVo  = new FixedLoanInrestVo();
	//起始日期（yyyyMMdd）
	String startDate = "20170130";
	fixedLoanInrestVo.setStartDate(startDate);
	// 结束日期（yyyyMMdd）
	
	
	//结束日期
	String endDate = "20170530";
	
//	fixedLoanInrestVo.setOffLineLoanDate("20170128");
	
	
	//还款日期
	fixedLoanInrestVo.setPayDay(30);
	
	fixedLoanInrestVo.setEndDate(endDate);
	//总的本金金额
	fixedLoanInrestVo.setTotalCaptital(new BigDecimal(3000));
	//利息周期方式（1-按月，3-按季，0-一次性还本息）

	fixedLoanInrestVo.setPerIntrestDuration(1);
	//年利率
	fixedLoanInrestVo.setRate(new BigDecimal(7.5));
	//计算还款计划
	fixedLoanInrestVo = FixedLoanInrestUtil.calulate(fixedLoanInrestVo);
	//利息计划明细
	ArrayList<FixedLoanInrestSubVo> periodDetail = fixedLoanInrestVo.getPeriodDetail();

	
	
	for(FixedLoanInrestSubVo fixedLoanInrestSubVo:periodDetail){	
		
		// 当前还款期数
		System.out.println("还款期数：" + fixedLoanInrestSubVo.getPeriod());
		//还款总额？？？
		System.out.println("还款总额："+fixedLoanInrestVo.getTotalRepayment());

		
		// 还款金额
		System.out.println("当期当期还款金额："+fixedLoanInrestSubVo.getPerSum());
		
		//还款本金
		System.out.println("当期还款本金："+fixedLoanInrestSubVo.getPerCapital());
		
		// 还款利息
		System.out.println("当期当期还款利息："+fixedLoanInrestSubVo.getPerIntrest());
		// 应还时间

		System.out.println("当期开始时间："+fixedLoanInrestSubVo.getStartDate());
		
		// 应还时间

		System.out.println("当期应还时间："+fixedLoanInrestSubVo.getEndDate());

		
		// 借款人所剩还款
		System.out.println("当期所剩还款："+fixedLoanInrestSubVo.getRemainSum());	
		
		System.out.println("----------------------------------------------");	}
	
//	Date date = calulateNextDay(parseDate("20150218"),-1);
//	System.out.println(parseDateToString(date));
	
		//System.out.println(parseDateToString(getCurrentMonthLastDay( parseDate("20150123") )));
	
//	System.out.println("20150409".substring(6, 8));
	
}
	
}
