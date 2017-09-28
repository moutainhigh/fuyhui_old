<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html>
<html>
 <head> 
 	<title>账户中心</title>
 </head> 
 <body> 
 <c:if test="${userInfo.realname == null}"> 
  	<form action="<%=request.getContextPath() %>/fy/regist" method="post">
	  	<input type="submit" value="实名认证"/>
  	</form>
  </c:if>
  		账户信息：<br/>
  	<c:if test="${userInfo != null}">
		真实姓名：${userInfo.realname} <br/>
		手机：${userInfo.mobile} <br/>
	</c:if><br/>
  	<c:if test="${userAccount != null}">
		总余额：${userAccount.total} 元<br/>
		可用余额：${userAccount.cash} 元<br/>
		冻结余额：${userAccount.frost} 元<br/>
		待收余额：${userAccount.awaitIncome} 元<br/>
	</c:if>
	<form action="<%=request.getContextPath() %>/account/fastRecharge" method="post">
	<input type="hidden" name="login_id" value="${user_inf.mobile }"/>
	充值金额：<input type="text" name="amt"/>
	<input type="submit" value="快捷充值">
	</form>
 </body>
</html>