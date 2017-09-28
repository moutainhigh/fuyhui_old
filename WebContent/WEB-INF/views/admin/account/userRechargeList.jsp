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
	<form id="userRechargeListForm"
		action="${pageContext.request.contextPath }/admin/recharge/index"
		class="form-inline definewidth m20" method="post">
		用户名： <input type="text" name="username" id="username"
			class="abc input-default" value="">&nbsp;&nbsp;流水号： <input type="text" name="billno" id="billno"
			class="abc input-default" value="">&nbsp;&nbsp; 充值时间：<input
			id="startTime" name="startTime" type="text" class="Wdate"
			onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:'false',maxDate:'#F{$dp.$D(\'endTime\')||\'new Date()\'}'})">
		~~<input id="endTime" name="endTime" type="text" class="Wdate"
			onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}',maxDate:new Date()})">
		&nbsp;&nbsp;状态： <select id="status" name="status">
		<option value="" selected>请选择</option>
		<option value="0">充值中</option>
		<option value="1">成功</option>
		<option value="2">失败</option>
		</select>&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">
			<i class="icon-search"></i>&nbsp;查询
		</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success">导出</button>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">订单号</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">用户名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">充值金额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">充值时间</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">状态</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">流水号</span></th>
				</tr>
			</thead>
			<c:forEach items="${userRechargeList.items }" var="userRecharge">
				<tr class="info">
					<td>${userRecharge.rechargeId }</td>
					<td>${userRecharge.username }</td>
					<td>${userRecharge.money }</td>
					<td><date:date pattern="yyyy-MM-dd HH:mm"
							value="${userRecharge.createTime }"></date:date></td>
					<td><c:choose>
							<c:when test="${userRecharge.status == 0 }">充值中</c:when>
							<c:when test="${userRecharge.status == 1 }">充值成功</c:when>
							<c:when test="${userRecharge.status == 2 }">充值失败</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose></td>
					<td>${userRecharge.billno }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=6><page:Pager formName="userRechargeListForm"
						pageAttributeName="userRechargeList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>