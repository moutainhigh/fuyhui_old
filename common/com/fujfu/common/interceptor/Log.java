package com.fujfu.common.interceptor;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class Log{  
	
	private static Logger log = Logger.getLogger(Log.class);

   public void before(JoinPoint joinpoint){  
       log.info("Method start - ["+ joinpoint.getSignature().getDeclaringTypeName() + 
                 "." + joinpoint.getSignature().getName()+"]");
   }  
   
   public void after(JoinPoint joinpoint){  
	   	log.info("Method end - ["+ joinpoint.getSignature().getDeclaringTypeName() + 
               "." + joinpoint.getSignature().getName()+"]");
   }  
}