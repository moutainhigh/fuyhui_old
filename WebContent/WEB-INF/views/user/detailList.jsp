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

<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/back/assets/js/jquery-1.8.1.min.js"></script>
</head>
<script>
	$(function() {
		$('#addnew')
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath }/news/enterAdd";
						});
	});
</script>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
	<form id="detailListForm" action="${pageContext.request.contextPath }/popularize/userIndex?inviterId=${inviterId }" class="form-inline definewidth m20" method="post">
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th width="20%">推荐人</th>
					<th width="20%">被推荐人</th>
					<th width="20%">推荐时间</th>
					<th width="20%">投资金额</th>
					<th width="20%">借款金额</th>
				</tr>
			</thead>
			<c:forEach items="${detailList.items }" var="detail">
				<tr>
					<td>${detail.realname }</td>
					<td>${detail.username }</td>
					<td><date:date pattern="yyyy-MM-dd HH:mm" value="${detail.mtime}"></date:date></td>
					<td>${popularize.investTips }</td>
					<td>${popularize.investTips }</td>
					</tr>
			</c:forEach>
			<tr>
				<td colspan=5><page:Pager formName="detailListForm"
						pageAttributeName="detailList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>