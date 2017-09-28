<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/back/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/back/css/style.css" />
</head>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
					alert("${param.msg}");
				</script>
	</c:if>
	<div>
		<form
			action="${pageContext.request.contextPath }/admin/rolePurview/add"
			id="addForm" method="post">
			<input style="display: none;" value="${roleId }" name="roleId" type="text">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="20%" class="tableleft">角色名：</td>
					<td><span>${role.rolename }</span></td>
				<tr>
				<tr>
					<td width="20%" class="tableleft">权限：</td>
					<td><select name="purviewId">
							<c:forEach items="${purviewList }" var="purview">
								<option value="${purview.purviewId }">${purview.purviewName }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td colspan=2><button type="submit"
							class="btn btn-primary">添加</button>
					<a href="${pageContext.request.contextPath }/admin/rolePurview/listRolePurview?roleId=${roleId }" class="btn btn-success" style="float:right">返回</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>