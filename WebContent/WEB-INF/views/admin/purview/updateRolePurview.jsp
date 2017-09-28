<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/pagination.tld" prefix="fuerong"%>
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
$(document).ready(function(){  
	var roleId = $("#roleId").val();
	$.ajax({
        type: "post",
        url: "findNotOwnPurviewByRoleId",
        data: {roleId : roleId},
        dataType: "json",
        async: false,
        success: function(data){
        			/* console.log(data); */
        			if(data != undefined || data != null){
        				var purview = document.getElementById("purviewId");
        				for(var i=0;i<data.length;i++){
        					var option = document.createElement("option");
        					option.value = data[i].purviewId;
        					option.text = data[i].purviewName;
        					purview.appendChild(option);
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
				<form action="${pageContext.request.contextPath }/admin/rolePurview/update" id="updateForm" method="post">
					<input style="display: none;" value="${rolePurviewVo.id }" id="id" name="id" type="text">
					<input style="display: none;" value="${rolePurviewVo.roleId }" id="roleId" name="roleId" type="text">
					<table class="table table-bordered table-hover definewidth m10">
					<tr>
						<td width="20%" class="tableleft">角色名：</td>  
						<td><span>${rolePurviewVo.rolename }</span></td>
					</tr>
					<tr>
						<td width="20%" class="tableleft">权限：</td> 
						<td>
						<select name="purviewId" id="purviewId">
							<option value="${rolePurviewVo.purviewId }">${rolePurviewVo.purviewName }</option>
					</select>
						</td>
					</tr>
					<tr>
					<td colspan=2><button type="submit" class="btn btn-primary">修改</button>
						<a href="${pageContext.request.contextPath }/admin/rolePurview/listRolePurview?roleId=${rolePurviewVo.roleId }" class="btn btn-success" style="float:right">返回</a></td>
					</tr>
					</table>
				</form>
			</div>
</body>
</html>