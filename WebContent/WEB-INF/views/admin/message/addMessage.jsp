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
		var title = $("#title").val();
		var content = $("#content").val();
		if(title ==''){
			alert("请输入标题");
			return false;
		}
		if(title.length >254 ){
			alert("标题过长");
			return false;
		}
		if(content ==''){
			alert("请输入内容");
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
		<form action="${pageContext.request.contextPath }/message/add"
			id="addForm" name="addForm" method="post">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="20%" class="tableleft">标题：</td>
					<td><input value="" id="title" name="title" type="text" placeholder="请输入标题"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">内容：</td>
					<td><textarea rows="3" cols="20" id="content" name="content" placeholder="请输入内容"></textarea></td>
				</tr>
				<tr>
					<td colspan=2><button onclick="return check()" 
							class="btn btn-primary">添加</button>
					<a href="${pageContext.request.contextPath }/message/index" class="btn btn-success" style="float:right">返回</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>