package com.fujfu.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class AdminLoginFilter implements Filter {
	/** 
	* 需要排除的页面 
	*/  
	private String[] excludedPageArray;
	
	public AdminLoginFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
        String servletPath = req.getServletPath();
        boolean flag=false;//正则匹配成功
       
        for(String str:excludedPageArray){
        	if(str.equals(servletPath))
        	flag=true;
        }
        
        Object user = req.getSession().getAttribute("admin");
        if(!flag&&user==null){
        	String contextPath = req.getContextPath();
        	response.setContentType("text/html; charset=UTF-8");
 	        response.getWriter().println("<script>");
 	        response.getWriter().println("alert('您未登录或当前登录己过时,请重新登录.');window.parent.location.href ='"+contextPath+"/admin/index';");
	        response.getWriter().println("</script>");
        }else{
        	chain.doFilter(request, response);
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		String  excludedPages= fConfig.getInitParameter("excludedPages");  
		if (StringUtils.isNotEmpty(excludedPages)) {  
		excludedPageArray = excludedPages.split(",");
		}
	}

}