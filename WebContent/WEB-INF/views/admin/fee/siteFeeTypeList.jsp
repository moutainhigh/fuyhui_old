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
							window.location.href = "${pageContext.request.contextPath }/siteFeeType/enterAdd";
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
	<form id="siteFeeTypeListForm" action=""
		class="form-inline definewidth m20">
		<button type="button" class="btn btn-success" id="addnew">新增</button>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">收费项目</span></th>
					<th><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">收取费用</span></th>
					<th><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">收费用户</span></th>
					<th><span class="badge badge-info" style="font-size: 18px;margin-bottom:10px;">金额</span></th>
					<th><span class="badge badge-info" style="font-size: 18px;margin-bottom:10px;">费率</span></th>
					<th><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">創建時間</span></th>
					<th><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">操作</span></th>
				</tr>
			</thead>
			<c:forEach items="${siteFeeTypeList.items }" var="siteFeeTypeVo">
				<tr class="info">
					<td><c:if test="${empty siteFeeTypeVo.chargeItem }">所有项目</c:if>
					<c:if test="${not empty siteFeeTypeVo.chargeItem }">${siteFeeTypeVo.chargeItem }</c:if></td>
					<td>${siteFeeTypeVo.feeName }</td>
					<td>
					<c:choose>
					<c:when test="${siteFeeTypeVo.userType == 1 }">个人用户</c:when>
					<c:when test="${siteFeeTypeVo.userType == 2 }">企业用户</c:when>
					<c:when test="${siteFeeTypeVo.userType == 3 }">担保公司</c:when>
					<c:otherwise>所有</c:otherwise>
					</c:choose>
					</td>
					<td>${siteFeeTypeVo.amount }</td>
					<td>${siteFeeTypeVo.interestRate }</td>
					<td><date:date pattern="yyyy-MM-dd HH:mm" value="${siteFeeTypeVo.created }"></date:date></td>
					<td><a
						href="${pageContext.request.contextPath }/siteFeeType/enterUpdate?id=${siteFeeTypeVo.id }" title="修改"><i class="icon-pencil"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a
						href="${pageContext.request.contextPath }/siteFeeType/delete?id=${siteFeeTypeVo.id }" title="删除" onClick="return confirm('确定删除该收费项么?');"><i class="icon-trash"></i></a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=7><page:Pager formName="siteFeeTypeListForm"
						pageAttributeName="siteFeeTypeList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>

	</form>
</body>
</html>