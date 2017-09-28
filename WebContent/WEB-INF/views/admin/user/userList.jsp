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
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
	<form id="userListForm"
		action="${pageContext.request.contextPath }/user/index"
		class="form-inline definewidth m20" method="post">
		手机号码： <input type="text" name="mobile" id="mobile"
			class="abc input-default" value="${mobile}">&nbsp;&nbsp; 注册日期：<input
			id="startTime" name="startTime" value ="${startTime}" type="text" class="Wdate"
			onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:'false',maxDate:'#F{$dp.$D(\'endTime\')||\'new Date()\'}'})">
		~~<input id="endTime" name="endTime" value ="${endTime}" type="text" class="Wdate"
			onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}',maxDate:new Date()})">
		&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">
			<i class="icon-search"></i>&nbsp;查询
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
						style="font-size: 18px; margin-bottom: 10px;">手机号码</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">真实姓名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">证件类型</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">证件号码</span></th>
<!-- 					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">邮箱</span></th> -->
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">注册日期</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">锁定状态</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">是否内部用户</span></th>
				</tr>
			</thead>
			<c:forEach items="${userList.items }" var="user">
				<tr class="info" ondblclick='window.location.href="${pageContext.request.contextPath }/admin/user/InvenstUserInfo?userId=${user.userId }"'>
					<td>${user.userId }</td>
					<td>${user.username }</td>
					<td>${user.mobile }</td>
					<td>${user.realname }</td>
					<td><c:choose>
							<c:when test="${user.cardType == 1 }">身份证</c:when>
							<c:when test="${user.cardType == 2 }">台胞证</c:when>
							<c:when test="${user.cardType == 3 }">港澳通行证</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose></td>
					<td>${user.cardId }</td>
<%-- 					<td>${user.email }</td> --%>
					<td><date:date pattern="yyyy-MM-dd HH:mm" 
 							value="${user.created}"></date:date></td> 
					<td><c:choose>
							<c:when test="${user.isLock==0 }">未锁</c:when>
							<c:otherwise>
								<a
									href="${pageContext.request.contextPath }/user/changeLockStatus?userid=${user.userId }&target=P2P">解锁</a>
							</c:otherwise>
						</c:choose></td>
					<td>
					<c:choose>
					<c:when test="${user.isInside == 0}"><a onClick="return confirm('是否将该用户设置为内部用户?');" href="${pageContext.request.contextPath }/user/changeInsideStatus?userId=${user.userId }&isInside=1">否</a></c:when>
					<c:when test="${user.isInside == 1}"><a onClick="return confirm('是否将该用户更改为普通用户?');" href="${pageContext.request.contextPath }/user/changeInsideStatus?userId=${user.userId }&isInside=0">是</a></c:when>
					<c:otherwise></c:otherwise>
					</c:choose>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=9><page:Pager formName="userListForm"
						pageAttributeName="userList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>