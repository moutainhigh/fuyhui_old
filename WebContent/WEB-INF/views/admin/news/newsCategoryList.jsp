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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/paging/default.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/back/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/back/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/back/css/style.css" />
<link href="${pageContext.request.contextPath }/static/back/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/static/back/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/plugins/My97DatePicker/WdatePicker.js"></script>
</head>
<script>
	$(function() {
		$('#addnew')
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath }/newsCategory/enterAdd";
						});
	});
</script>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
	<form id="newsCategoryListForm" action="${pageContext.request.contextPath }/newsCategory/index" class="form-inline definewidth m20" method="post">
		<input style="display: none;" value="fkd" name="target" type="text">
		类别名： <input type="text" name="name" id="name"
			class="abc input-default" value="">
		&nbsp;&nbsp;<button type="submit" class="btn btn-primary"><i class="icon-search"></i>&nbsp;查询</button>&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew"><i class="icon-plus"></i>&nbsp;新增</button>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th width="20%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">类别名</span></th>
					<th width="15%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">上级类别</span></th>
					<th width="15%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">类型</span></th>
					<th width="15%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">状态</span></th>
					<th width="15%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">创建时间</span></th>
					<th width="20%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">操作</span></th>
				</tr>
			</thead>
			<c:forEach items="${newsCategoryList.items }" var="newsCategory">
				<tr class="info">
					<td>${newsCategory.name }</td>
					<td>${newsCategory.parentName }</td>
					<td>
					<c:choose>
					<c:when test="${newsCategory.type == 1 }">p2p</c:when>
					<c:when test="${newsCategory.type == 2 }">app</c:when>
					<c:otherwise></c:otherwise>
					</c:choose>
					</td>
					<td>
					<c:choose>
					<c:when test="${newsCategory.status == 0 }">未审核(<a
						href="${pageContext.request.contextPath }/newsCategory/changeStatus?id=${newsCategory.id }">审核通过</a>)</c:when>
					<c:when test="${newsCategory.status == 1 }">已审核</c:when>
					<c:when test="${newsCategory.status == -1 }">已删除</c:when>
					<c:otherwise></c:otherwise>
					</c:choose>
					</td>
					<td><date:date pattern="yyyy-MM-dd HH:mm" value="${newsCategory.created}"></date:date></td>
					<td><a href="${pageContext.request.contextPath }/newsCategory/enterUpdate?id=${newsCategory.id }" title="编辑"><i class="icon-pencil"></i></a>&nbsp;
						<a href="${pageContext.request.contextPath }/newsCategory/delete?id=${newsCategory.id }" title="删除" onClick="return confirm('确定删除该类别么?');"><i class="icon-trash"></i></a></td>
					</tr>
			</c:forEach>
			<tr>
				<td colspan=10><page:Pager formName="newsCategoryListForm"
						pageAttributeName="newsCategoryList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>