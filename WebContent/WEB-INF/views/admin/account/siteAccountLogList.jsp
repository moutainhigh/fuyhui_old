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
	<form id="siteAccountLogListForm" action="${pageContext.request.contextPath }/siteAccount/siteAccountLogIndex" class="form-inline definewidth m20" method="post">
		<input type="hidden" name="feeId" value="${feeId }">
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">ID</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">费用名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">用户名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">金额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">收取时间</span></th>
				</tr>
			</thead>
			<c:forEach items="${siteAccountLogList.items }" var="siteAccountLog">
				<tr class="info">
					<td>${siteAccountLog.id }</td>
					<td>${siteAccountLog.feeName }</td>
					<td>${siteAccountLog.userName }</td>
					<td>${siteAccountLog.money }</td>
					<td><date:date pattern="yyyy-MM-dd HH:mm"
							value="${siteAccountLog.created }"></date:date></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=5><page:Pager formName="siteAccountLogListForm"
						pageAttributeName="siteAccountLogList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
			<tr>
					<td colspan=5><a href="${pageContext.request.contextPath }/siteAccount/siteAccountIndex"
						class="btn btn-success" style="float: right">返回</a></td>
			</tr>
		</table>
	</form>
</body>
</html>