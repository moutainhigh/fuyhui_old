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
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/back/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
	function check(){
		var username = $("#username").val();
		var realname = $("#realname").val();
		if(username ==''){
			alert("请输入管理员名称");
			return false;
		}
		if(username.length >8 ){
			alert("管理员名称过长");
			return false;
		}
		if(realname ==''){
			alert("请输入真实姓名");
			return false;
		}
		if(realname.length >12 ){
			alert("真实姓名字符长度过长");
			return false;
		}
	}
</script>
</head>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
	<div>
		<form action="${pageContext.request.contextPath }/admin/member/update"
			id="updateForm" name="updateForm" method="post">
			<input style="display: none;" value="${admin.adminId }" name="adminId" type="text">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="20%" class="tableleft">管理员名称：</td>
					<td><input value="${admin.username }" id="username" name="username"
						type="text" placeholder="请输入管理员名称"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">真实姓名：</td>
					<td><input value="${admin.realname }" id="realname" name="realname"
						type="text" placeholder="请输入真实姓名"></td>
				</tr>
				<tr>
					<td colspan=2><button onclick="return update()"
							class="btn btn-primary">修改</button>
					<a href="${pageContext.request.contextPath }/admin/member/index" class="btn btn-success" style="float:right">返回</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>