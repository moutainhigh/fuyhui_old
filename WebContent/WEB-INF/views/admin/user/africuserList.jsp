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
	<form id="userListForm"
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
						style="font-size: 18px; margin-bottom: 10px;">用户ID</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">用户名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">公司名称</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">法人姓名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">联系人电话</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">注册日期</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">状态</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">操作</span></th>
				</tr>
			</thead>
			<c:forEach items="${userList.items }" var="user">
				<tr class="info">
					<td>${user.userId }</td>
					<td>${user.username }</td>
					<td>${user.corpName }</td>

					<td>${user.realname }</td>
					<td>${user.contactMobile }</td>
					<td><date:date pattern="yyyy-MM-dd HH:mm"
							value="${user.created}"></date:date></td>
					<td><c:choose>
							<c:when test="${user.isLock==0 }">未锁</c:when>
							<c:otherwise>
								<a
									href="${pageContext.request.contextPath }/user/changeLockStatus?mobile=${user.mobile }&target=P2P">解锁</a>
							</c:otherwise>
						</c:choose></td>
					<td>&nbsp;<a
						href="${pageContext.request.contextPath }/admin/user/enterUserInfo?userId=${user.userId }" title="查看"><i class="icon-search"></i></a>&nbsp;
						<a
						href="${pageContext.request.contextPath }/admin/user/enterUpdate?userId=${user.userId }" title="修改"><i class="icon-pencil"></i></a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=10><page:Pager formName="userListForm"
						pageAttributeName="userList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>