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
		var name = $("#name").val();
		var template = $("#template").val();
		if(name ==''){
			alert("请输入标题");
			return false;
		}
		if(name.length >100 ){
			alert("标题过长");
			return false;
		}
		if(template ==''){
			alert("请输入内容");
			return false;
		}
		if(template.length >2048 ){
			alert("内容过长");
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
		<form action="${pageContext.request.contextPath }/notifyAuto/update"
			id="updateForm" name="updateForm" method="post">
			<input value="${notifyAuto.id }" name="id" style="display:none;">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="20%" class="tableleft">模板标题：</td>
					<td><input value="${notifyAuto.name }" id="name" name="name" type="text" placeholder="请输入模板标题"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">发送平台：</td>
					<td><select name="sendPlatform">
						<option value="${notifyAuto.sendPlatform }">${notifyAuto.sendPlatform }</option>
						<option value="1">PC</option>
						<option value="2">APP</option>
					</select></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">发送类型：</td>
					<td><select name="sendType">
						<option value="${notifyAuto.sendType }">${notifyAuto.sendType }</option>
						<option value="1">站内信</option>
						<option value="2">短信</option>
					</select></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">发送时间点：</td>
					<td><select name="sendTime">
						<c:forEach items="${sendTimeList }" var="sendTime">
							<option value="${sendTime.key }">${sendTime.value }</option>
						</c:forEach>
						</select></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">内容：</td>
					<td><textarea rows="3" cols="20" id="template" name="template" placeholder="请输入内容">${notifyAuto.template }</textarea></td>
				</tr>
				<tr>
					<td colspan=2><button onclick="return check()" 
							class="btn btn-primary">修改</button>
					<a href="${pageContext.request.contextPath }/notifyAuto/index" class="btn btn-success" style="float:right">返回</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>