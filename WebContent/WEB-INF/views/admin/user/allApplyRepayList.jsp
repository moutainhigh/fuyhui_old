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
<script>
	
</script>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
	<form id="applyRepayListForm"
		action="${pageContext.request.contextPath }/admin/user/allApplyRepayList"
		class="form-inline definewidth m20" method="post">
		用户名： <input type="text" name="userName" id="userName"
			class="abc input-default" value="">&nbsp;&nbsp; 债权编号： <input
			type="text" name="id" id="id" class="abc input-default"
			value="">&nbsp;&nbsp; 借款编号： <input type="text" name="apply_id"
			id="apply_id" class="abc input-default" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">
			<i class="icon-search"></i>&nbsp;查询
		</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success">导出</button>
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">用户名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">企业名称</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">公司名称</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">借款编号</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">还款方式</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">还款金额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">剩余还款总额</span></th>
<!-- 					<th><span class="badge badge-info" -->
<!-- 						style="font-size: 18px; margin-bottom: 10px;">手续费</span></th>	 -->
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">实际还款时间</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">状态</span></th>
				</tr>
			</thead>
				<c:forEach items="${applyRepayList.items }" var="applyRepay">
				<tr class="info">
				    <td>${applyRepay.userName }</td>
				    <td>${applyRepay.corpName }</td>
					<td>${applyRepay.realname }</td>
					<td>${applyRepay.applyId }</td>					
                    <td>${applyRepay.repayType}</td>
					<td>${applyRepay.repayMoney}</td>
					<td>${applyRepay.repayRemain  }</td>
<%-- 					<td>${applyRepay.repayFee }</td> --%>
					<td>${applyRepay.repayDoneTime}</td>
					<td><c:choose>
                     <c:when test="${applyRepay.status  ==0}">正常未还 </c:when>
                     <c:when test="${applyRepay.status  ==1}">正常已还</c:when>
                      <c:when test="${applyRepay.status  ==2}">投资服务费未收取</c:when>
               </c:choose>
                     </td>
                 
					</tr>
			</c:forEach>
			<tr>
				<td colspan=10><page:Pager formName="applyRepayListForm"
						pageAttributeName="applyRepayList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>