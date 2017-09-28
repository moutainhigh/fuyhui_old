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
<body>
	<c:if test="${msg ne null}">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
	<div style="background: #fafafa; padding: 10px;">
			<form id="rolePurviewListForm" action="" class="form-inline definewidth m20">
			<a class="btn btn-success" href="${pageContext.request.contextPath }/admin/rolePurview/enterAdd?roleId=${roleId }"><i class="icon-plus"></i>&nbsp;新增角色权限</a>
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<th width="20%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">角色名</span></th>
					<th width="20%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">权限名</span></th>
					<th width="25%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">描述</span></th>
					<th width="15%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">创建时间</span></th>
					<th width="20%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">操作</span></th>
				</tr>
				<c:forEach items="${rolePurviewList.items }" var="rolePurview">
					<tr class="info">
						<td>${rolePurview.rolename }</td>
						<td>${rolePurview.purviewName }</td>
						<td>${rolePurview.describ }</td>
						<td><date:date pattern="yyyy-MM-dd HH:mm" value="${rolePurview.created }"></date:date></td>
						<td><a href="${pageContext.request.contextPath }/admin/rolePurview/enterUpdate?id=${rolePurview.id }" title="编辑"><i class="icon-pencil"></i></a>&nbsp;
						<a href="${pageContext.request.contextPath }/admin/rolePurview/delete?id=${rolePurview.id }&roleId=${rolePurview.roleId }" title="删除" onClick="return confirm('确定删除角色该权限么？');"><i class="icon-trash"></i></a></td>
					</tr>
				</c:forEach>
				<tr><td colspan=5><page:Pager formName="rolePurviewListForm"
				pageAttributeName="rolePurviewList" styleClass="textfield"
				goStyleClass="gobutton" /></td></tr>
			</table>
			</form>
	</div>
</body>
</html>