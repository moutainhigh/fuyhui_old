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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/styles/paging/default.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/back/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/back/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/back/css/style.css" />
<link
	href="${pageContext.request.contextPath }/static/back/assets/css/dpl-min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/back/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/plugins/My97DatePicker/WdatePicker.js"></script>
<script>
	$(function() {
		$('#addnew')
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath }/loanType/enterAdd";
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
	<form id="loanTypeListForm"
		action="${pageContext.request.contextPath }/loanType/index"
		class="form-inline definewidth m20" method="post">
		<button type="button" class="btn btn-success" id="addnew">
			<i class="icon-plus"></i>&nbsp;新增
		</button>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">产品名称</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">产品类型</span></th>
					<!-- <th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">投资范围</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">递投金额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">状态</span></th> -->
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">创建时间</span></th>
					<!-- <th><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">有效期</span></th> -->
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">操作</span></th>
				</tr>
			</thead>
			<c:forEach items="${loanTypeList.items }" var="loanType">
				<tr class="info">
					<td>${loanType.name }</td>
					<td>${loanType.category }</td>
					<%-- <td>${loanType.quotaMin }- ${loanType.quotaMax }</td>
					<td>${loanType.proAmount }</td>
					<td><c:choose>
							<c:when test="${loanType.status == 0 }">开启</c:when>
							<c:when test="${loanType.status == 1 }">关闭</c:when>
							<c:otherwise></c:otherwise>
						</c:choose></td> --%>
					<td><date:date pattern="yyyy-MM-dd HH:mm"
							value="${loanType.created }"></date:date></td>
					<%-- <td>${loanType.validity }</td> --%>
					<td><a
						href="${pageContext.request.contextPath }/loanType/enterUpdate?id=${loanType.id }"
						title="修改"><i class="icon-pencil"></i></a>&nbsp;&nbsp; <a
						href="${pageContext.request.contextPath }/loanType/delete?id=${loanType.id }"
						title="删除" onClick="return confirm('确定删除该产品配置么?');"><i
							class="icon-trash"></i></a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=9><page:Pager formName="loanTypeListForm"
						pageAttributeName="loanTypeList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>