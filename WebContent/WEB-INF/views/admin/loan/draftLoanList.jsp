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
		<form id="draftLoanListForm" action="" class="form-inline definewidth m20">
			<a class="btn btn-success" href="${pageContext.request.contextPath }/loan/loanApply/enterAdd"><i class="icon-plus"></i>&nbsp;新增</a>
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">项目名称</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">项目来源</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">融资方</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">募集金额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">投资期限</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">预期年化收益</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">回款方式</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">操作</span></th>
				</tr>
				<c:forEach items="${draftLoanList.items }" var="loan">
					<tr class="info" ondblclick='window.location.href="${pageContext.request.contextPath }/loan/loanApply/enterLoanApplyUpdate?id=${loan.id }"'>
						<td>${loan.loanName }</td>
						<td>${loan.projectSource }</td>
						<td>${loan.companyName }</td>
						<td>${loan.amount }元</td>
						<td>${loan.period }天</td>
						<td>${loan.apr }%</td>
						<td><c:choose>
						<c:when test="${loan.paymentOptions == 1}">
						按月付息，到期一次性还本
						</c:when>
						<c:when test="${loan.paymentOptions == 2}">
						到期一次性还本付息
						</c:when>
						<c:when test="${loan.paymentOptions == 3}">
						等额本息
						</c:when>
						<c:when test="${loan.paymentOptions == 4}">
						等额本金
						</c:when>
						<c:when test="${loan.paymentOptions == 5}">
						按季付息，到期一次性还本
						</c:when>
						<c:otherwise></c:otherwise>
						</c:choose></td>
						<td><a href="${pageContext.request.contextPath }/loan/loanApply/del?id=${loan.id }" title="删除" onClick="return confirm('确定删除该项目么?');"><i class="icon-trash"></i></a></td>
					</tr>
				</c:forEach>
				<tr>
				<td colspan=8><page:Pager formName="draftLoanListForm"
						pageAttributeName="draftLoanList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
			</table>
		</form>
	</div>
</body>
</html>