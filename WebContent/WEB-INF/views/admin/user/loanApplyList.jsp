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
function check(){
	var applyid = $("#applyid").val();
	if(applyid!=''){
		var reg1 = new RegExp("^[0-9]*[1-9][0-9]*$");
		if(!reg1.test(applyid) ){  
	        alert("借款编号必须为整数!");
	        return false;
		}			
	}
}
</script>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
	<form id="applyListForm"
		action="${pageContext.request.contextPath }/admin/user/loanDoApplyList"
		class="form-inline definewidth m20" method="post">
		用户名： <input type="text" name="userName" id="userName"
			class="abc input-default" value="">&nbsp;&nbsp; 借款编号： <input
			type="text" name="applyid" id="applyid" class="abc input-default"
			value="">&nbsp;&nbsp; 债权编号： <input type="text" name="id"
			id="id" class="abc input-default" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary" onclick="return check()" >
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
						style="font-size: 18px; margin-bottom: 10px;">法人名称</span></th>
					
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">借款编号</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">债权编号</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">债权金额(元)</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">年化利率(%)</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">期限(天)</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">担保人名称</span></th>	
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">债权持有时间</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">状态</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">操作</span></th>
				</tr>
			</thead>
				<c:forEach items="${applyList.items }" var="applyy">
				<tr class="info">
				    <td>${applyy.userName }</td>
					<td>${applyy.realname }</td>
					<td>${applyy.id }</td>
					<td>${applyy.order_number }</td>					
                    <td>${applyy.amount}元</td>
					<td>${applyy.apr}%</td>
					<td><c:choose>
					<c:when test="${applyy.actPeriod>0}">${applyy.actPeriod}天</c:when>
					<c:otherwise>
					${applyy.period}天
					</c:otherwise>
					 </c:choose>
					 </td>
					<td>${applyy.guarantee_company_name }</td>
					<td>${applyy.loanTimeStr }</td>
                     <td><c:choose>
						<c:when test="${applyy.repay_status == -2}">
						已删除
						</c:when>
						<c:when test="${applyy.repay_status == -1 || applyy.repay_status == 0}">
						申请中
						</c:when>
						<c:when test="${applyy.repay_status == 1 || applyy.repay_status == 2}">
						审核中
						</c:when>
						<c:when test="${applyy.repay_status == 7}">
						投资中
						</c:when>
						<c:when test="${applyy.repay_status == 8 && applyy.isLoans == 0}">
						已满标
						</c:when>
						<c:when test="${applyy.repay_status== 9 || (applyy.repay_status == 8 && loan.isLoans != 0)}">
						还款中
						</c:when>
						<c:when test="${applyy.repay_status == 10}">
						已还款
						</c:when>
						<c:when test="${applyy.repay_status == 20}">
						流标
						</c:when>
						<c:otherwise></c:otherwise>
						</c:choose></td>
						
					<td><a
						href="${pageContext.request.contextPath }/admin/user/allApplyRepayList?apply_id=${applyy.id }" title="还款详情">还款详情</a>&nbsp;
						</tr>
			</c:forEach>
			<tr>
				<td colspan=9><page:Pager formName="applyListForm"
						pageAttributeName="applyList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>