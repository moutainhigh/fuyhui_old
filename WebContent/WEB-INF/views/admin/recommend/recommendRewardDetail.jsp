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
</head>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
	<form id="recommendRewardDetailForm" action="${pageContext.request.contextPath }/recommend/recommendRewardDetail?uid=${uid}" class="form-inline definewidth m20" method="post">
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">用户名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">真实姓名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">投资情况</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">首次投资金额</span></th>
						<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">首次投资时间</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">注册时间</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">奖励有效期至</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">我的推荐奖励</span></th>
				</tr>
			</thead>
			<c:forEach items="${recommendRewardDetail.items }" var="recommendReward">
				<tr class="info">
					<td>${recommendReward.userName }</td>
					<td>${recommendReward.realName }</td>
					<td><c:if test="${not empty recommendReward.investTime}">已投资</c:if>
					<c:if test="${empty recommendReward.investTime}">未投资</c:if>
					</td>
					<td><c:if test="${recommendReward.investAmount !='0.00'}">${recommendReward.investAmount }</c:if></td>
					<td><c:if test="${not empty recommendReward.investTime}">
					<date:date pattern="yyyy-MM-dd HH:mm"
							value="${recommendReward.investTime}"></date:date>
					</c:if></td>
					<td><c:if test="${not empty recommendReward.registTime}">
					<date:date pattern="yyyy-MM-dd HH:mm"
							value="${recommendReward.registTime}"></date:date>
					</c:if></td>
					<td><c:if test="${not empty recommendReward.rewardTerm}">
					<date:date pattern="yyyy-MM-dd HH:mm"
							value="${recommendReward.rewardTerm}"></date:date>
					</c:if></td>
					<td>${recommendReward.rewardAmount }元</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=8><page:Pager formName="recommendRewardDetailForm"
						pageAttributeName="recommendRewardDetail" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>