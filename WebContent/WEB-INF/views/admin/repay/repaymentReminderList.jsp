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
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/back/assets/js/jquery-1.8.1.min.js"></script>
</head>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
		<div style="background: #fafafa; padding: 10px;">
			<form id="repayListForm" action="" class="form-inline definewidth m20">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">融资方</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">项目编号</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">回款方式</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">应还金额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">利息</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">本金</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">还需还款</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">当前期数</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">应还时间</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">还款时间</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">还款总额</span></th>
					<!-- <th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">操作</span></th> -->
				</tr>
				<c:forEach items="${repayList.items }" var="repay">
					<tr class="info">
						<td>${repay.companyName }</td>
						<td>${repay.applyNo }</td>
						<td>${repay.repayType }</td>
						<td>${repay.repayMoney }</td>
						<td>${repay.repayInterest }</td>
						<td>${repay.repayCapital }</td>
						<td>${repay.repayRemain }</td>
						<td>${repay.repayPeriod }</td>
						<td><c:if test="${not empty repay.repayReqTime}"><date:date pattern="yyyy-MM-dd HH:mm"
							value="${repay.repayReqTime }"></date:date></c:if></td>
						<td><c:if test="${not empty repay.repayDoneTime}"><date:date pattern="yyyy-MM-dd HH:mm"
							value="${repay.repayDoneTime }"></date:date></c:if></td>
						<td>${repay.repayTotal }</td>
						<%-- <td><c:if test="${empty repay.repayDoneTime}">
						<a href="${pageContext.request.contextPath }/repay/detail?id=${repay.id }&per=${repay.repayPeriod }">详情</a>
						</c:if>
						<c:if test="${not empty repay.repayDoneTime}">已还</c:if></td> --%>
					</tr>
				</c:forEach>
				<tr>
				<td colspan=11><page:Pager formName="repayListForm"
						pageAttributeName="repayList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
			</table>
			</form>
	</div>
</body>
</html>