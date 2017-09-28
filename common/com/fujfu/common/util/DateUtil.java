package com.fujfu.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * 日期格式的一些处理方法
 * 
 * @author hjz
 */
public class DateUtil {
	/**
	 * 计算两个时间戳之间相差的天数(2.1 =3)
	 * @param sDate 开始时间
	 * @param eDate 结束时间
	 * @return
	 */
	public static int getTimeDifference(int sDate,int eDate){
		return ((eDate - sDate) / 60 / 60 / 24)+1;
	}
	
	/**
	 * 获取指定日期n个月之后的日期
	 * @param date 指定日期
	 * @param n 月数
	 * @return
	 * @throws ParseException 
	 */
	public static int getMonthBefore(int date,int n) throws ParseException{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.timeMillisToDate(date));
		calendar.add(Calendar.MONTH, n);
		return (int) (calendar.getTime().getTime()/1000);
	}
	
	/**
	 * 获取指定日期n天之后的日期
	 * @param date 指定日期
	 * @param n 天
	 * @return
	 * @throws ParseException 
	 */
	public static int getDaysBefore(int date,int n) throws ParseException{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.timeMillisToDate(date));
		calendar.add(Calendar.DAY_OF_MONTH, n);
		return (int) (calendar.getTime().getTime()/1000);
	}
	
	/**
	 * 获取指定日期n小时之后的日期
	 * @param date 指定日期
	 * @param n 天
	 * @return
	 * @throws ParseException 
	 */
	public static int getHoursBefore(Integer date,int n) throws ParseException{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.timeMillisToDate(date));
		calendar.add(Calendar.HOUR, n);
		return (int) (calendar.getTime().getTime()/1000);
	}
	/**
	 * 将date转为unix时间戳
	 * @param date
	 * @return
	 */
	public static int dateFormatUnix(Date date){
		return (int) ((date.getTime())/1000);
	}
	
	/**
	 * 将String类型时间转成时间戳
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static int dateTimeStamp(String dateString) throws ParseException {
	    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
	    return (int) ((date.getTime())/1000);
	}
	
	/**
	 * 将String类型时间转成时间戳 yyyyMMdd
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static int dateTimeStampyyyyMMdd(String dateString) throws ParseException {
	    Date date = new SimpleDateFormat("yyyyMMdd").parse(dateString);
	    return (int) ((date.getTime())/1000);
	}
	
	/**
	 * 将String类型时间转成时间戳yyyy-MM-dd
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static int dateTimeStampyyyyMMdd1(String dateString) throws ParseException {
	    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
	    return (int) ((date.getTime())/1000);
	}	
	
	/**
	  * 获取当前时间
	  * @return
	  * 自定义字符串日期格式 ，例如 yyyy-MM-dd
	  */
	public static String getCurrentDate(String format) {
	   Date currentTime = new Date();
	   SimpleDateFormat formatter = new SimpleDateFormat(format);
	   String dateString = formatter.format(currentTime);
	   return dateString;
	}
	
	
	/**
	   * 获取系统currentTimeMillis（10位）
	   * unix时间戳
	   * @return
	   * long数值
	   */
	public static long currentTimeMillis() {
	   return (System.currentTimeMillis())/1000;
	}
	
	/**
	   * 获取系统currentTimeMillis（10位） 
	   * unix时间戳
	   * @return
	   * int数值
	   */
	public static int getUnixTime() {
	   return (int) ((System.currentTimeMillis())/1000);
	}
	/**
	   * currentTimeMillis（10位）转换为指定格式的字符串日期
	   * @param1  currentTimeMillis
	   * @param2   指定日期格式
	   * @return str
	   */
	public static String timeMillisToStr(long currentTimeMillis, String format) {
		   SimpleDateFormat sf = new SimpleDateFormat(format);
		   Date date = new Date(currentTimeMillis*1000);
		   return sf.format(date);
	}
	
	/**
	   * currentTimeMillis（10位）转换为年月日格式
	   * @param1  currentTimeMillis
	   * @param2   指定日期格式
	   * @return str
	   */
	public static String timeMillisToStrNew(long currentTimeMillis) {
		   SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		   Date date = new Date(currentTimeMillis*1000);
		   String str =sf.format(date);
		   String st[]= str.split("-");
		   String newstr =st[0]+"年"+st[1]+"月"+st[2]+"日";
		   return newstr;
	}
	
	/**
	 * 将unix时间戳转为date
	 * @param currentTimeMillis
	 * @return
	 */
	public static Date timeMillisToDate(long currentTimeMillis) {
		   Date date = new Date(currentTimeMillis*1000);
		   return date;
	}
	 /**
	  * 将日期格式的字符串转换为长整型
	  * 
	  * @param date
	  * @param format
	  * @return
	 * @throws ParseException 
	  */
	 public static long convert2long(String date, String format) throws ParseException {
	    SimpleDateFormat sf = new SimpleDateFormat(format);
	    return sf.parse(date).getTime();
	 }
	 
	 /**
	  * 将日期格式的字符串转换为int
	  * 
	  * @param date
	  * @param format
	  * @return
	  * @throws ParseException 
	  */
	 public static int convert2int(String date, String format) throws ParseException {
		 SimpleDateFormat sf = new SimpleDateFormat(format);
		 return (int)(sf.parse(date).getTime()/1000);
	 }
	 
	 public static String convert2String(long time, String format) {
		   SimpleDateFormat sf = new SimpleDateFormat(format);
		   Date date = new Date(time);
		   return sf.format(date);
		 }
	
	 public static String toYYYYMMDD(String dateStr) throws ParseException {

		 SimpleDateFormat sdf = new SimpleDateFormat(
		 "EEE MMM dd HH:mm:ss zzz yyyy", new Locale("ENGLISH"));
		 Date myDate = sdf.parse(dateStr);
		 SimpleDateFormat sdf2 = new SimpleDateFormat(
		 "yyyy-MM-dd HH:mm:ss", new Locale("CHINA"));
		 return sdf2.format(myDate);

	 }	 
	 
	 /**
		 * 计算时间差
		 */
		public static long calculateTimeDistances(String begin, String end) {
			SimpleDateFormat sDate = new SimpleDateFormat("yyyy/MM/dd");

			Date date_begin = null;
			Date date_end = null;

			try {
				date_begin = sDate.parse(begin);
				date_end = sDate.parse(end);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// date转成毫秒
			long beginTime = date_begin.getTime();
			long endTime = date_end.getTime();

			long TimeDistances = endTime - beginTime;

			 long days = TimeDistances / (1000 * 60 * 60 * 24);
			 long hours = (TimeDistances-days*(1000 * 60 * 60 * 24))/(1000* 60 *
			 60);
			 long minutes = (TimeDistances-days*(1000 * 60 * 60 * 24)-hours*(1000*
			 60 * 60))/(1000* 60);
			 long seconds = (TimeDistances-days*(1000 * 60 * 60 * 24)-hours*(1000*
			 60 * 60))/(1000* 60)-minutes*(1000*60)/1000;
			
			 String result = days+"天"+hours+"小时"+minutes+"分"+seconds+"秒";

			return days;

		}
		
		
   /**
    * 计算N天之后的时间unix时间戳
    * */		
		
	public static int getUnixTimeNextDays(Date date,int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return (int) ((cal.getTime().getTime())/1000);			
	}	
	
	
   /**
    * 计算N之后的时间unix时间戳
    * */		
			
	public static int getUnixTimeNextMonths(Date date,int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, days);
		return (int) ((cal.getTime().getTime())/1000);			
	}			
		
	 
	public static void main(String[] args) throws ParseException {
//		System.out.println(DateUtil.calculateTimeDistances("2015/08/04", "2016/01/13"));
//		System.out.println(FeeProperties.REPAYMENT_METHOD.get(1));
//		System.out.println(FeeProperties.REPAYMENT_METHOD.get("1"));
//
//		System.out.println(getMonthBefore(1469693800, 0));
//		System.out.println(dateFormatUnix(new Date()));
//		System.out.println(DateUtil.toYYYYMMDD("Thu Apr 14 11:16:46 CST 2016"));
//		System.out.println(new Date().getTime());
//		System.out.println(DateUtil.getCurrentDate("yyyy-MM-dd hh:mm"));
//		System.out.println(DateUtil.currentTimeMillis());
		System.out.println(DateUtil.timeMillisToStr(1491986958,"yyyy-MM-dd hh:mm:ss"));
//		System.out.println(DateUtil.timeMillisToStr(1489038761,"yyyy-MM-dd hh:mm:ss"));
//		System.out.println(DateUtil.convert2int("2016-05-06", "yyyy-MM-dd"));
//		System.out.println(DateUtil.timeMillisToStr(1462464000,"MM/dd"));
//		System.out.println(DateUtil.timeMillisToStrNew(1462464000));
		//DateUtil.
		System.out.println(DateUtil.currentTimeMillis());
		System.out.println(DateUtil.getUnixTime());
		System.out.println(DateUtil.getCurrentDate("yyyy-MM-dd hh:mm"));
//		Date date  = new Date();
//		Long time = System.currentTimeMillis();
//		
//		date.setTime(time);
//		
//		int time1  = DateUtil.getUnixTimeNextDays(date, 3);
//		
//		System.out.println(time1);
		
	}
}
