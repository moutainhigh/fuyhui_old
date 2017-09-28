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
	var name = $("#name").val();
	if(name ==''){
		alert("请输入类别名");
		return false;
	}
	if(name.length > 20 ){
		alert("类别名过长");
		return false;
	}
}

$(document).ready(function(){  
	$.ajax({
        type: "post",
        url: "listAllNewsCategory",
        data: {},
        dataType: "json",
        async: false,
        success: function(data){
        			console.log(data);
        			if(data != undefined || data != null){
        				var parent = document.getElementById("parent");
        				for(var i=0;i<data.length;i++){
        					var option = document.createElement("option");
        					option.value = data[i].id;
        					option.text = data[i].name;
        					parent.appendChild(option);
        				}
        			}
                 }
    });  
});
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
			action="${pageContext.request.contextPath }/newsCategory/update"
			id="updateForm" method="post">
				<input style="display: none;" value="${newsCategory.id }" name="id" type="text">
				<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="20%" class="tableleft">类别名：</td>
					<td><input value="${newsCategory.name }" id="name" name="name" placeholder="请输入类别名"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">父类别名：</td>
					<td><select name="parent" id="parent">
							<option value="${newsCategory.parent }">${newsCategory.parentName }</option>
					</select></td>
				</tr>
				<tr>
					<td colspan=2><button onclick="return check()" class="btn btn-primary">修改</button>
						<a
						href="${pageContext.request.contextPath }/newsCategory/index"
						class="btn btn-success" style="float: right">返回</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>