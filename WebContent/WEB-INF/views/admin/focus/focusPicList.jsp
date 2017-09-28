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
<script>
	$(function() {
		$('#addnew')
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath }/focus/enterAdd";
						});
	});
</script>
</head>
<body>
	<c:if test="${msg != null}">
		<script type="text/javascript">
					alert("${param.msg}");
				</script>
	</c:if>
		<form id="focusPicListForm" action="${pageContext.request.contextPath }/focus/list" class="form-inline definewidth m20"  method="post">
			<!-- 显示设备： <select class="abc input-default">
				<option value="0">所有设备</option>
				<option value="1">P2P电脑端</option>	
				<option value="2">P2P移动端</option>
				<option value="3">富宝袋APP</option>
			</select>
		&nbsp;&nbsp;
		<button type="submit"  class="btn btn-primary">查询</button> -->
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新增</button>
			<table class="table table-bordered table-hover definewidth m10">
				<thead>
					<tr>
						<th width="10%">显示设备</th>
						<th width="7%">位置</th>
						<th width="20%">图片标题</th>
						<th width="26%">图片跳转地址</th>
						<th width="7%">状态</th>
						<th width="10%">更新时间</th>
						<th width="20%">操作</th>
					</tr>
				</thead>
				<c:forEach items="${focusPicList.items }" var="c">
					<tr>
						<td>
							<c:if test="${c.displayDevice==1 }">富元汇PC端</c:if>
							<c:if test="${c.displayDevice==2 }">富元汇APP端</c:if>
							<c:if test="${c.displayDevice==3 }">富宝袋APP端</c:if>
						</td>
						<td>${c.position }</td>
						<td>${c.title }</td>
						<td>${c.url }</td>
						<td>${c.status == 0 ? "显示" : "隐藏" }</td>
						<td><date:date pattern="yyyy-MM-dd HH:mm" value="${c.updated }"></date:date></td>
						<td>
							<a href="${pageContext.request.contextPath }/focus/edit?id=${c.id }">编辑</a>
							<a href="${pageContext.request.contextPath }/focus/delete?id=${c.id }" 
								onClick="return confirm('确定删除么?');">删除</a>
							</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan=7><page:Pager formName="focusPicListForm"
							pageAttributeName="focusPicList" styleClass="textfield"
							goStyleClass="gobutton" /></td>
				</tr>
			</table>
		</form>
</body>
</html>