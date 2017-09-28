package com.fujfu.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	/**
	 * 手机号校验
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String s){ 
		Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(s);
		return m.matches();
	}
	
	/** 
     * 电话号码验证 
     *  
     * @param  str 
     * @return 验证通过返回true 
     */  
    /*public static boolean isPhone(String str) {   
        Pattern p1 = null,p2 = null;  
        Matcher m = null;  
        boolean b = false;    
        p1 = Pattern.compile("^[0][0-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的  
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的  
        if(str.length() >9)  
        {   m = p1.matcher(str);  
            b = m.matches();    
        }else{  
            m = p2.matcher(str);  
            b = m.matches();   
        }    
        return b;  
    }*/
	public static boolean isPhone(String str) {   
        Pattern p1 = null;  
        Matcher m = null;  
        boolean b = false;    
        p1 = Pattern.compile("^[0][0-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的  
        m = p1.matcher(str);  
        b = m.matches();    
        return b;  
    }
	
	/**
	 * 邮箱校验
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String s) {
		String str = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(s);
		return m.matches();
	}
	
	/**
	 * 银行卡号校验
	 * @param account
	 * @return
	 */
	public static boolean isAccount(String s) {
		String str = "^[1-9][0-9]{11,18}$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(s);
		return m.matches();
	}
	
	/**
	 * 校验是否含特殊字符
	 * @param s true-不包含
	 * @return
	 */
	public static boolean isContainIllegal(String s){
		String str = "[a-zA-Z0-9\u4e00-\u9fa5]+";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(s);
		return m.matches();
	};
	/**
	 * 校验是否含汉字
	 * @param s true-不包含
	 * @return
	 */
	public static boolean isContainChinese(String s){
		String str = "[\u4E00 - \u9FA0]+";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(s);
		return m.matches();
	};
	
	/**
	 * 判断ＱＱ号是否合法
	 * @param str
	 * @return
	 */
	public static boolean isQQCorrect(String str) {
		String regex = "[1-9][0-9]{4,14}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		return m.matches();
	}

}
