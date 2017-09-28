<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交易处理中...</title>
</head>
	<body>
		<form id="forwardForm" name="forwardForm" action="${reqData.action}" method="post" >  
			<input value="${reqData.mchnt_cd}" name="mchnt_cd" type="hidden">
			<input value="${reqData.mchnt_txn_ssn}" name="mchnt_txn_ssn" type="hidden">
			<input value="${reqData.login_id}" name="login_id" type="hidden">
			<input value="${reqData.page_notify_url}" name="page_notify_url" type="hidden">
			<input value="${reqData.signature}" name="signature" type="hidden">
		</form>
			<script type="text/javascript">document.forwardForm.submit();</script>
	
	</body>
</html>