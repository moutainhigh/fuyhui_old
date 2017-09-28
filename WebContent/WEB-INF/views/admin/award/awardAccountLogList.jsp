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
	
	<form id="awardAccountLogListForm"  action="${pageContext.request.contextPath }/award/findAwardAccountLogList" class="form-inline definewidth m20" method="post">
		手机号码： <input type="text" name="mobile" id="mobile" class="abc input-default" value="${payForListQueryVo.payForName }">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">
			<i class="icon-search"></i>&nbsp;查询
		</button>
		
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">红包编号</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">红包类型</span></th>								
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">手机号码</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">真实姓名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">红包金额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">标的名称</span></th>						
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">投资金额</span></th>						
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">活动主题</span></th>						
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">发放来源</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">使用日期</span></th>
				</tr>
			</thead>
			<c:forEach items="${awardAccountLogList.items }" var="usersAwardAccountLog">
				<tr class="info">
					<td>${usersAwardAccountLog.vocherId }</td>
					<td>
						<c:choose>
						<c:when test="${usersAwardAccountLog.type == 1 }">红包</c:when>
						<c:otherwise>未知</c:otherwise>
						</c:choose>					
					</td>
					<td>${usersAwardAccountLog.mobile }</td>
					<td>${usersAwardAccountLog.username }</td>
					<td>${usersAwardAccountLog.initAmount }</td>
					<td>${usersAwardAccountLog.loanName }</td>
					<td>${usersAwardAccountLog.tranAmount }</td>
					<td>${usersAwardAccountLog.theme }</td>
					<td>
						<c:choose>
						<c:when test="${usersAwardAccountLog.origin == 1 }">注册发放</c:when>
						<c:otherwise>未知</c:otherwise>
						</c:choose>							
					</td>
					<td>
					<date:date pattern="yyyy-MM-dd HH:mm" value="${usersAwardAccountLog.created }"></date:date>
					
					</td>				
										

				</tr>
			</c:forEach>
			<tr>
				<td colspan=10><page:Pager formName="awardAccountLogListForm"
						pageAttributeName="awardAccountLogList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>