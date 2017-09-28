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
	<c:if test="${msg ne null}">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
	
	<form id="payForListForm"  action="${pageContext.request.contextPath }/user/payfor" class="form-inline definewidth m20" method="post">
		担保公司： <input type="text" name="payForName" id="payForName" class="abc input-default" value="${payForListQueryVo.payForName }">&nbsp;&nbsp;
		借款编号：<input type="text" name="appyId" id="appyId" class="abc input-default" value="${payForListQueryVo.appyId }">&nbsp;&nbsp;  
		<button type="submit" class="btn btn-primary">
			<i class="icon-search"></i>&nbsp;查询
		</button>
		
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
						style="font-size: 18px; margin-bottom: 10px;">垫付期数</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">垫付金额</span></th>						
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">垫付日期</span></th>
				</tr>
			</thead>
			<c:forEach items="${userPayForList.items }" var="userPayFor">
				<tr class="info">
					<td>${userPayFor.payForName }</td>
					<td>${userPayFor.appyId }</td>
					<td>${userPayFor.appyName }</td>
					<td>${userPayFor.payForPeriod }</td>
					<td>${userPayFor.money }</td>
					<td>${userPayFor.payForTime }</td>					

				</tr>
			</c:forEach>
			<tr>
				<td colspan=10><page:Pager formName="payForListForm"
						pageAttributeName="userPayForList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>