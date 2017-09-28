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
	<form id="applyRecoverListListForm"
		action="${pageContext.request.contextPath }/admin/user/allApplyRecoverList"
		class="form-inline definewidth m20" method="post">
		用户名： <input type="text" name="userName" id="userName"
			class="abc input-default" value="">&nbsp;&nbsp; 借款编号： <input type="text" name="apply_id"
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
						style="font-size: 18px; margin-bottom: 10px;">收款人编号</span></th>					
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">借款编号</span></th>					
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">收款金额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">剩余收款总额</span></th>
<!-- 					<th><span class="badge badge-info" -->
<!-- 						style="font-size: 18px; margin-bottom: 10px;">手续费</span></th>	 -->
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">实际收款时间</span></th>
					
				</tr>
			</thead>
				<c:forEach items="${applyRecoverList.items }" var="applyRecover">
				<tr class="info">
				    
					<td>${applyRecover.userId }</td>
					<td>${applyRecover.applyId }</td>					
                    <td>${applyRecover.recoverMoney}</td>
					<td>${applyRecover.recoverRemain}</td>
<%-- 					<td>${applyRecover.recoverFee  }</td> --%>
					 <td><c:choose>
                     <c:when test="${applyRecover.recoverDoneTime>0 }"><date:date pattern="yyyy-MM-dd HH:mm"
							value="${applyRecover.recoverDoneTime }"></date:date> </c:when>
                     <c:otherwise>
					
					</c:otherwise>
                    
               </c:choose>
                     </td>
					
					
			</c:forEach>
			<tr>
				<td colspan=10><page:Pager formName="applyRecoverListListForm"
						pageAttributeName="applyRecoverList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>