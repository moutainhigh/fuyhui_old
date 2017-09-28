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
		var purviewName = $("#purviewName").val();
		var purviewFlag = $("#purviewFlag").val();
		var describ = $("#describ").val();
		if(purviewName ==''){
			alert("请输入权限名称");
			return false;
		}
		if(purviewName.length >12 ){
			alert("权限名称过长");
			return false;
		}
		if(purviewFlag ==''){
			alert("请输入权限标识");
			return false;
		}
		if(purviewFlag.length >30 ){
			alert("权限标识字符长度过长");
			return false;
		}
		if(describ ==''){
			alert("请输入权限描叙");
			return false;
		}
		if(describ.length >30 ){
			alert("权限描叙字符长度过长");
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
		<form
			action="${pageContext.request.contextPath }/admin/purview/update"
			id="updateForm" method="post">
			<input style="display: none;" value="${purview.purviewId }" name="purviewId" type="text">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td  width="20%" class="tableleft">权限名称：</td>
					<td><input value="${purview.purviewName }" id="purviewName" name="purviewName"
						type="text" placeholder="请输入权限名称"></td>
				</tr>
				<tr>
					<td  width="20%" class="tableleft">权限标识：</td>
					<td><input value="${purview.purviewFlag }" id="purviewFlag" name="purviewFlag"
						type="text" placeholder="请输入权限标识"></td>
				</tr>
				<tr>
					<td  width="20%" class="tableleft">描述：</td>
					<td>
					<textarea rows="3" cols="20" id="describ" name="describ" placeholder="请输入描述">${purview.describ }</textarea>
					</td>
				</tr>
				<tr>
					<td colspan=2><button onclick="return check()"
							class="btn btn-primary">修改</button>
							<a href="${pageContext.request.contextPath }/admin/purview/index" class="btn btn-success" style="float:right">返回</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>