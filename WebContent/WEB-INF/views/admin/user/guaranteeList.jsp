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
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/plugins/My97DatePicker/WdatePicker.js"></script>
<script>
	$(function() {
		$('#addnew')
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath }/admin/user/enterAdd?userType=${userType}";
						});
	});
</script>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
	<form id="GuaranteeListForm"
		action="${pageContext.request.contextPath }/admin/user/index?userType=${userType}"
		class="form-inline definewidth m20" method="post">
		用户名： <input type="text" name="userName" id="userName"
			class="abc input-default" value="">&nbsp;&nbsp; 公司名称： <input
			type="text" name="corpName" id="corpName" class="abc input-default"
			value="">&nbsp;&nbsp; 联系人电话： <input type="text" name="mobile"
			id="mobile" class="abc input-default" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">
			<i class="icon-search"></i>&nbsp;查询
		</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">
			<i class="icon-plus"></i>&nbsp;新增
		</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success">导出</button>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">担保公司</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">借款编号</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">借款标题</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">借款金额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">担保金额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">担保期限</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">担保时间</span></th>
					
				</tr>
			</thead>
			<c:forEach items="${guaranteeList.items }" var="guarantee">
				<tr class="info">
					<td>${guarantee.realName }</td>
					<td>${guarantee.applyid }</td>
					<td>${guarantee.applyName }</td>

					<td>${guarantee.amount }</td>
					<td>${guarantee.amount }</td>
					<td>${guarantee.period }</td>
					
					<td><date:date pattern="yyyy-MM-dd HH:mm"
							value="${guarantee.created}"></date:date></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=7><page:Pager formName="GuaranteeListForm"
						pageAttributeName="guaranteeList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>