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
	<form id="recommendRewardListForm" action="${pageContext.request.contextPath }/recommend/recommendRewardList" class="form-inline definewidth m20" method="post">
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">推荐人用户名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">推荐人姓名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">推荐用户总数(个)</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">当前有效好友数(个)</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">推荐总奖励(元)</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">操作</span></th>
				</tr>
			</thead>
			<c:forEach items="${recommendRewardList.items }" var="recommendReward">
				<tr class="info">
					<td>${recommendReward.userName }</td>
					<td>${recommendReward.realName }</td>
					<td>${recommendReward.totalNum}</td>
					<td>${recommendReward.effectNum }</td>
					<td>${recommendReward.totalMoney }</td>
					<td><a href="${pageContext.request.contextPath }/recommend/recommendRewardDetail?uid=${recommendReward.recommendUserId}">查看好友详情</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=6><page:Pager formName="recommendRewardListForm"
						pageAttributeName="recommendRewardList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>