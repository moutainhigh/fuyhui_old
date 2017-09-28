<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>交易处理中……</title>
</head>
	<body>
		<form name="forwardForm" action="${data.action}" method="post" >  
			<input value="${data.mchnt_cd}" name="mchnt_cd" type="hidden"/>
			<input value="${data.mchnt_txn_ssn}" name="mchnt_txn_ssn" type="hidden"/>
			<input value="${data.back_notify_url}" name="back_notify_url" type="hidden"/>
			<input value="${data.page_notify_url}" name="page_notify_url" type="hidden"/>
			<input value="${data.amt}" name="amt" type="hidden"/>
			<input value="${data.login_id}" name="login_id" type="hidden"/>
			<input value="${data.signature}" name="signature" type="hidden"/>
		</form>
		<script type="text/javascript">document.forwardForm.submit();</script>
	</body>
</html>