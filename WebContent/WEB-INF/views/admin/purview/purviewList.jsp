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
<script>
	$(function() {
		$('#addnew')
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath }/admin/purview/enterAdd";
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
		<form id="purviewListForm" action="${pageContext.request.contextPath }/admin/purview/index" class="form-inline definewidth m20"  method="post">
			权限名： <input type="text" name="purviewName" id="purviewName"
			class="abc input-default" value="">&nbsp;&nbsp;
		&nbsp;&nbsp;<button type="submit" class="btn btn-primary"><i class="icon-search"></i>&nbsp;查询</button>&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew"><i class="icon-plus"></i>&nbsp;新增</button>
			<table class="table table-bordered table-hover definewidth m10">
				<thead>
					<tr>
						<th width="20%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">权限名</span></th>
						<th width="20%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">权限标识</span></th>
						<th width="30%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">描述</span></th>
						<th width="10%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">创建时间</span></th>
						<th width="20%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">操作</span></th>
					</tr>
				</thead>
				<c:forEach items="${purviewList.items }" var="purview">
					<tr class="info">
						<td>${purview.purviewName }</td>
						<td>${purview.purviewFlag }</td>
						<td>${purview.describ }</td>
						<td><date:date pattern="yyyy-MM-dd HH:mm" value="${purview.created }"></date:date></td>
						<td><a
							href="${pageContext.request.contextPath }/admin/purview/enterUpdate?purviewId=${purview.purviewId }" title="修改"><i class="icon-pencil"></i></a>&nbsp;
							<a
							href="${pageContext.request.contextPath }/admin/purview/delete?purviewId=${purview.purviewId }" title="删除" onClick="return confirm('确定删除该权限么?');"><i class="icon-trash"></i></a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan=5><page:Pager formName="purviewListForm"
							pageAttributeName="purviewList" styleClass="textfield"
							goStyleClass="gobutton" /></td>
				</tr>
			</table>
		</form>
</body>
</html>