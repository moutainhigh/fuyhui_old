<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/pagination.tld" prefix="page"%>
<%@ taglib uri="/WEB-INF/tld/datetag.tld" prefix="date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/styles/paging/default.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/back/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/back/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/back/css/style.css" />
<link
	href="${pageContext.request.contextPath }/static/back/assets/css/dpl-min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/back/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/plugins/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
	<form id="userAccountListForm" action="${pageContext.request.contextPath }/backAccount/institution/index" class="form-inline definewidth m20" method="post">
		用户名： <input type="text" name="userName" id="userName"
			class="abc input-default" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary"><i class="icon-search"></i>&nbsp;查询</button>&nbsp;&nbsp;
		<button type="button" class="btn btn-success">导出</button>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">用户名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">真实姓名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">资产总额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">可用余额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">冻结金额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">待收</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">待还</span></th>
				</tr>
			</thead>
			<c:forEach items="${userAccountList.items }" var="userAccount">
				<tr class="info">
					<td>${userAccount.userName }</td>
					<td>${userAccount.realName }</td>
					<td>${userAccount.total }</td>
					<td>${userAccount.cash }</td>
					<td>${userAccount.frost }</td>
					<td>${userAccount.awaitIncome }</td>
					<td>${userAccount.awaitRepay }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=7><page:Pager formName="userAccountListForm"
						pageAttributeName="userAccountList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>