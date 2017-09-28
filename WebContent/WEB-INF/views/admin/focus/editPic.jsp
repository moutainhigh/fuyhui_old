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
	href="${pageContext.request.contextPath }/static/back/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/back/css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/back/assets/js/jquery-1.8.1.min.js"></script>

<script type="text/javascript">

	function check(){
		var title = $("#title").val();
		var url = $("#url").val();
		var imgurl = $("#imgurl").val();
		var position = $("#position").val();
		
		if(title ==''){
			alert("请输入标题");
			$("#title").focus();
			return false;
		}
		if(position ==''){
			alert("请输入图片位置");
			$("#position").focus();
			return false;
		}		
		if(isNaN(position)){
			  alert("图片位置必须是数字");
			  $("#position").focus();
			  return false;
			}
		if(url ==''){
			alert("请输入跳转地址");
			$("#url").focus();
			return false;
		}

		if ($.trim(pic) == "") {
			alert("请选择图片文件！");
			return false;
		}

	}
</script>
</head>
<body>	
	<c:if test="${msg != null}">
		<script type="text/javascript">
					alert("${msg}");
				</script>
	</c:if>
	
	<div>
		<form action="${pageContext.request.contextPath }/focus/confirmEdit"
			id="editForm" name="editForm" method="post" enctype="multipart/form-data">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="20%" class="tableleft">标题：</td>
					<td>
					<input value="${focusPic.id}" name="id" type="hidden" />
					<input value="${focusPic.title}" id="title" name="title" type="text" /></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">显示设备：</td>
					<td>
					<select id="displayDevice" name="displayDevice">
						<option value="1">富元汇PC端</option>
						<option value="2">富元汇APP端</option>
						<option value="3">富宝袋 APP端</option>
					</select>
					<script type="text/javascript">
						var val = ${focusPic.displayDevice};
						$("#displayDevice option[value="+val+"]").attr("selected", true)
					</script>
				</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">位置：</td>
					<td><input value="${focusPic.position}" id="position" name="position" type="text"></td>
				</tr>

				<tr>
					<td width="20%" class="tableleft">图片跳转地址：</td>
					<td><input value="${focusPic.url}" id="url" name="url" type="text"/></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">显示状态：</td>
					<td>
					<select id="status" name="status">
						<option value="0">显示</option>
						<option value="1">隐藏</option>
					</select>
					<script type="text/javascript">
						var val = ${focusPic.status};
						$("#status option[value="+val+"]").attr("selected", true)
					</script>
					</td>
				</tr>
				<tr>
					<td colspan=2><button onclick="return check()" 
							class="btn btn-primary">保存</button>
					<a href="${pageContext.request.contextPath }/focus/list" class="btn btn-success" style="float:right">返回</a></td>
				</tr>
			</table>
		</form>
		
	</div>
</body>
</html>