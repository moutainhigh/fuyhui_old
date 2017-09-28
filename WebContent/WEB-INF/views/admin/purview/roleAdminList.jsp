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
		<form id="roleAdminListForm" action=""
			class="form-inline definewidth m20">
			<a class="btn btn-success" id="addnew" href="${pageContext.request.contextPath }/admin/roleAdmin/enterAdd?adminId=${adminId }"><i class="icon-plus"></i>&nbsp;新增管理员角色</a>
			<table class="table table-bordered table-hover definewidth m10">
				<thead>
					<tr>
						<th width="20%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">管理员名称</span></th>
						<th width="20%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">角色名</span></th>
						<th width="25%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">角色描述</span></th>
						<th width="15%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">创建时间</span></th>
						<th width="20%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">操作</span></th>
					</tr>
				</thead>
				<c:forEach items="${roleAdminList.items }" var="roleAdmin">
					<tr class="info">
						<td>${roleAdmin.username }</td>
						<td>${roleAdmin.roleName }</td>
						<td>${roleAdmin.describ }</td>
						<td><date:date pattern="yyyy-MM-dd HH:mm" value="${roleAdmin.create }"></date:date></td>
						<td><a
							href="${pageContext.request.contextPath }/admin/roleAdmin/enterUpdate?id=${roleAdmin.id }" title="编辑"><i class="icon-pencil"></i></a>&nbsp;
							<a
							href="${pageContext.request.contextPath }/admin/roleAdmin/delete?id=${roleAdmin.id }&adminId=${roleAdmin.adminId }"  title="删除" onClick="return confirm('确定删除管理员该角色么？');"><i class="icon-trash"></i></a></td>
					</tr>
				</c:forEach>
				<tr>
					<td  colspan=5><page:Pager formName="roleAdminListForm"
							pageAttributeName="roleAdminList" styleClass="textfield"
							goStyleClass="gobutton" /></td>
				</tr>
			</table>
		</form>
</body>
</html>