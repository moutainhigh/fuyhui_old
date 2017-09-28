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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/paging/default.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/back/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/back/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/back/css/style.css" />
<link href="${pageContext.request.contextPath }/static/back/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/static/back/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/plugins/My97DatePicker/WdatePicker.js"></script>
<script>
	$(function() {
		$('#addnew')
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath }/award/enterAwardTypeAdd";
						});
	});
</script>
</head>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
		<form id="awardTypeListForm" action="${pageContext.request.contextPath }/award/awardTypeIndex" class="form-inline definewidth m20"  method="post">
			活动主题： <input type="text" name="theme" id="theme"
			class="abc input-default" value="">&nbsp;&nbsp;
		&nbsp;&nbsp;<button type="submit" class="btn btn-primary"><i class="icon-search"></i>&nbsp;查询</button>&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew"><i class="icon-plus"></i>&nbsp;新增</button>
			<table class="table table-bordered table-hover definewidth m10">
				<thead>
					<tr>
						<th width="20%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">活动主题</span></th>
						<th width="10%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">开始时间</span></th>
						<th width="10%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">结束时间</span></th>
						<th width="10%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">红包类型</span></th>
						<th width="10%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">红包金额</span></th>
						<th width="10%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">发放方式</span></th>
						<th width="10%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">最小投资金额</span></th>
						<th width="10%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">有效期</span></th>
						<th width="10%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">活动有效状态</span></th>
						<th width="10%"><span class="badge badge-info" style="font-size:18px;margin-bottom:10px;">操作</span></th>
					</tr>
				</thead>
				<c:forEach items="${awardTypeList.items }" var="awardType">
					<tr class="info">
						<td>${awardType.theme }</td>
						<td><date:date pattern="yyyy-MM-dd HH:mm" value="${awardType.startTime }"></date:date></td>
						<td><date:date pattern="yyyy-MM-dd HH:mm" value="${awardType.endTime }"></date:date></td>
						<td>
						<c:choose>
						<c:when test="${awardType.type == 1 }">红包</c:when>
						<c:when test="${awardType.type == 2 }">代金券</c:when>
						<c:when test="${awardType.type == 3 }">体验金</c:when>
						<c:otherwise></c:otherwise>
						</c:choose>
						</td>
						<td>${awardType.amount }元</td>
						<td>
						<c:choose>
						<c:when test="${awardType.origin == 1 }">注册发放</c:when>
						<c:otherwise>未知</c:otherwise>
						</c:choose>						
						</td>
						
						<td>
							${awardType.minAmount }元
						</td>
						
						<td><c:if test="${not empty awardType.term }">${awardType.term }天</c:if></td>
						<td>
						
						<c:choose>
						<c:when test="${awardType.dueStatus == 0 }">未生效</c:when>
						<c:when test="${awardType.dueStatus == 1 }">已生效</c:when>
						<c:when test="${awardType.dueStatus == 2 }">已过期</c:when>
						<c:otherwise>未知</c:otherwise>
						</c:choose>
						</td>						
						
						<td>
						<c:if test="${awardType.dueStatus != 2 }">
						<c:choose>
						<c:when test="${awardType.status == 0 }"><a href="${pageContext.request.contextPath }/award/updateAwardType?id=${awardType.id }&status=1">关闭</a></c:when>
						<c:when test="${awardType.status == 1 }"><a href="${pageContext.request.contextPath }/award/updateAwardType?id=${awardType.id }&status=0">开启</a></c:when>
						<c:otherwise></c:otherwise>
						</c:choose>
						</c:if>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan=9><page:Pager formName="awardTypeListForm"
							pageAttributeName="awardTypeList" styleClass="textfield"
							goStyleClass="gobutton" /></td>
				</tr>
			</table>
		</form>
</body>
</html>