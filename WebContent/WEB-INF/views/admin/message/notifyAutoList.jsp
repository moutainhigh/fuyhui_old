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
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/plugins/My97DatePicker/WdatePicker.js"></script>
<script>
	$(function() {
		$('#addnew')
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath }/notifyAuto/enterAdd";
						});
	});
</script>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
	<form id="notifyAutoListForm" action="${pageContext.request.contextPath }/notifyAuto/index" class="form-inline definewidth m20" method="post">
		模板标题： <input type="text" name="name" id="name" class="abc input-default" value="">
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新增</button>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th width="10%">模板标题</th>
					<th width="10%">发送平台</th>
					<th width="10%">发送类型</th>
					<th width="30%">模板内容</th>
					<th width="10%">发送时间</th>
					<th width="10%">状态</th>
					<th width="10%">添加时间</th>
					<th width="10%">操作</th>
				</tr>
			</thead>
			<c:forEach items="${notifyAutoList.items }" var="notifyAuto">
				<tr>
					<td>${notifyAuto.name }</td>
					<td><c:choose>
					<c:when test="${notifyAuto.sendPlatform == 1 }">PC</c:when>
					<c:when test="${notifyAuto.sendPlatform == 2 }">APP</c:when>
					<c:otherwise></c:otherwise>
					</c:choose></td>
					<td><c:choose>
					<c:when test="${notifyAuto.sendType == 1 }">短信</c:when>
					<c:when test="${notifyAuto.sendType == 2 }">站内信</c:when>
					<c:otherwise></c:otherwise>
					</c:choose></td>
					<td>${notifyAuto.template }</td>
					<td>${notifyAuto.sendTime }</td>
					<td><c:choose>
					<c:when test="${notifyAuto.status == 0 }">开启</c:when>
					<c:when test="${notifyAuto.status == 1 }">关闭</c:when>
					<c:otherwise></c:otherwise>
					</c:choose></td>
					<td><date:date pattern="yyyy-MM-dd HH:mm" value="${notifyAuto.ctime }"></date:date></td>
					<td><a href="${pageContext.request.contextPath }/notifyAuto/enterUpdate?id=${notifyAuto.id }">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/notifyAuto/delete?id=${notifyAuto.id }" onClick="return confirm('确定删除该消息模板么?');">删除</a></td>
					</tr>
			</c:forEach>
			<tr>
				<td colspan=9><page:Pager formName="notifyAutoListForm"
						pageAttributeName="notifyAutoList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>