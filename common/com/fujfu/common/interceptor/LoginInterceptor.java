package com.fujfu.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;  
   
  
/** 
 *  用户登录拦截器，对部分需要登录才能访问的URL实现拦截控制 , 只有登录才能访问
 *  
 */  
@Repository  
public class LoginInterceptor extends HandlerInterceptorAdapter {  
	
		private static Logger log = Logger.getLogger(LoginInterceptor.class);
		
		/**
		 * 需要过滤的url,在此列表下的url必须登录才能访问
		 */
        String[] filterUrl = new String[] {"/account/","/myAccount/"};  
        
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
        		Object handler) throws Exception {
        	request.setCharacterEncoding("UTF-8");
        	boolean flag = true;
            String url = request.getRequestURL().toString();
            log.info("Enter url is >>>: " + url);
            for (String s : filterUrl) {
                if (url.contains(s)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
            	 Object user = request.getSession().getAttribute("user_inf"); 
            	 if (user==null ){
            		String contextPath = request.getContextPath();
            		response.setContentType("text/html; charset=UTF-8");
            		response.getWriter().println("<script>");
          	        //response.getWriter().println("alert('您未登录或当前登录己过时,请重新登录.');window.parent.location.href ='"+contextPath+"/enterLogin';");
            		response.getWriter().println("window.parent.location.href ='"+contextPath+"/enterLogin';");
            		response.getWriter().println("</script>");
         	        return false;
         	        // 使用自定义异常跳转至登陆
//            		throw new AuthorizationException();
            	 } 
            }
            return true;
        }
     
        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response,
        		Object handler, ModelAndView modelAndView) throws Exception {
            super.postHandle(request, response, handler, modelAndView);
        }
}  