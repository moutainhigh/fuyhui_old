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
	<form id="recommendedListForm" action="${pageContext.request.contextPath }/recommend/getRecommendedList"
		class="form-inline definewidth m20" method="post">
		被推荐人用户名： <input type="text" name="busername" id="busername"
			class="abc input-default" value="">&nbsp;&nbsp; 奖励时间：<input
			id="startTime" name="startTime" type="text" class="Wdate"
			onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:'false',maxDate:'#F{$dp.$D(\'endTime\')||\'new Date()\'}'})">
		至<input id="endTime" name="endTime" type="text" class="Wdate"
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
						style="font-size: 18px; margin-bottom: 10px;">被推荐人用户名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">被推荐人姓名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">推荐人用户名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">推荐人姓名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">被推荐人注册时间</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">奖励截止时间</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">首次投资金额(元)</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">奖励金额(元)</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">奖励时间</span></th>
				</tr>
			</thead>
			<c:forEach items="${recommendedList.items }" var="recommended">
				<tr class="info">
					<td>${recommended.busername }</td>
					<td>${recommended.brealname }</td>
					<td>${recommended.ausername }</td>
					<td>${recommended.arealname }</td>
					<td>
					<c:if test="${recommended.registTime ne null}">
					<date:date pattern="yyyy-MM-dd HH:mm" value="${recommended.registTime }"></date:date>
					</c:if>
					</td>
					<td>
					<c:if test="${recommended.rewardTerm ne null}">
					<date:date pattern="yyyy-MM-dd HH:mm" value="${recommended.rewardTerm }"></date:date>
					</c:if>
					</td>
					<td>${recommended.investAmount }</td>
					<td>${recommended.rewardAmount }</td>
					<td>
					<c:if test="${recommended.rewardTime ne null}">
					<date:date pattern="yyyy-MM-dd HH:mm" value="${recommended.rewardTime }"></date:date>
					</c:if>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=9><page:Pager formName="recommendedListForm"
						pageAttributeName="recommendedList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>