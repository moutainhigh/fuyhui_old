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
							window.location.href = "${pageContext.request.contextPath }/message/enterAdd";
						});
	});
</script>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
	<form id="messageListForm" action="${pageContext.request.contextPath }/message/index" class="form-inline definewidth m20" method="post">
		标题： <input type="text" name="title" id="title" class="abc input-default" value="">&nbsp;&nbsp;
		内容： <input type="text" name="content" id="content" class="abc input-default" value="">&nbsp;&nbsp;
		类型： <select id="type" name="type">
					<option selected="selected" value="0">站内信</option>
			</select>&nbsp;&nbsp;
			发送时间：<input id="startTime" name="startTime" type="text" class="Wdate"
					onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:'false',maxDate:'#F{$dp.$D(\'endTime\')||\'new Date()\'}'})">
		   ~~<input id="endTime" name="endTime" type="text" class="Wdate"
					onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}',maxDate:new Date()})">
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新增</button>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th width="5%">ID</th>
					<th width="5%">用户ID</th>
					<th width="5%">发件人ID</th>
					<th width="20%">标题</th>
					<th width="40%">内容</th>
					<!-- <th width="5%">状态</th> -->
					<th width="10%">发送状态</th>
					<th width="5%">是否删除</th>
					<th width="10%">创建时间</th>
				</tr>
			</thead>
			<c:forEach items="${messageList.items }" var="messageVo">
				<tr>
					<td>${messageVo.id }</td>
					<td>${messageVo.userId }</td>
					<td>${messageVo.senderId }</td>
					<td>${messageVo.title }</td>
					<td>${messageVo.content }</td>
					<%-- <td><c:choose>
					<c:when test="${messageVo.status }">已读</c:when>
					<c:otherwise>未读</c:otherwise>
					</c:choose></td> --%>
					<td><c:choose>
					<c:when test="${messageVo.sendStatus }">成功</c:when>
					<c:otherwise>失败</c:otherwise>
					</c:choose></td>
					<td><c:choose>
					<c:when test="${messageVo.deleted}">是</c:when>
					<c:otherwise>否</c:otherwise>
					</c:choose></td>
					<td><date:date pattern="yyyy-MM-dd HH:mm" value="${messageVo.created}"></date:date></td>
					</tr>
			</c:forEach>
			<tr>
				<td colspan=9><page:Pager formName="messageListForm"
						pageAttributeName="messageList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>