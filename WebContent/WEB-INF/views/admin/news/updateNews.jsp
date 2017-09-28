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
<script src="${pageContext.request.contextPath }/static/plugins/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	    var editor = null;
	    $(function(){
	    editor = CKEDITOR.replace('content');
	    });
</script>
<script type="text/javascript">
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
        				var parent = document.getElementById("cid");
        				for(var i=0;i<data.length;i++){
        					var option = document.createElement("option");
        					option.value = data[i].id;
        					if(data[i].type == 1){
        						option.text = data[i].name + "(p2p)";
        					}
        					if(data[i].type == 2){
        						option.text = data[i].name + "(app)";
        					}
        					parent.appendChild(option);
        				}
        			}
                 }
    });  
});

function check(){
	var title = $("#title").val();
	var keywords = $("#keywords").val();
	var content = $("#content").val();
	
	if(title ==''){
		alert("请输入标题");
		return false;
	}
	if(title.length > 50 ){
		alert("标题过长");
		return false;
	}
	if(keywords ==''){
		alert("请输入搜索关键字");
		return false;
	}
	if(keywords.length > 128 ){
		alert("搜索关键字过长");
		return false;
	}
	if(content ==''){
		alert("请输入新闻内容");
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
			action="${pageContext.request.contextPath }/news/update"
			id="updateForm" method="post">
				<input style="display: none;" value="${newsVo.id }" name="id" type="text">
				<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="20%" class="tableleft">标题：</td>
					<td><input value="${newsVo.title }" id="title" name="title" placeholder="请输入标题"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">类别：</td>
					<td><select name="cid" id="cid">
							<option value="${newsVo.cid }">${newsVo.categoryName }</option>
					</select></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">搜索关键字：</td>
					<td><input value="${newsVo.keywords }" id="keywords" name="keywords" type="text" placeholder="请输入搜索关键字"></td>
				<tr>
				<tr><td colspan=2>
				<textarea name="content" id="content" rows="10" cols="100">
           		${newsVo.content }
           		</textarea>
				<tr>
					<td colspan=2><button onclick="return check()" class="btn btn-primary">修改</button>
						<a
						href="${pageContext.request.contextPath }/news/index"
						class="btn btn-success" style="float: right">返回</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>