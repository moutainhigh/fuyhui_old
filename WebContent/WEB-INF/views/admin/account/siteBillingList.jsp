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
	<form id="siteBillingListForm"
		action="${pageContext.request.contextPath }/backAccount/siteBillingList/index"
		class="form-inline definewidth m20" method="post">
		出账用户名： <input type="text" name="outUsername" id="outUsername"
			class="abc input-default" value="${outUsername }">&nbsp;&nbsp;入账用户名： <input type="text" name="inUsername" id="inUsername"
			class="abc input-default" value="${inUsername }">&nbsp;&nbsp;平台交易类型： <select id="siteBusiType" name="siteBusiType">
		<option value="" selected>请选择</option>
		<option value="充值">充值</option>
		<option value="提现">提现</option>
		<option value="平台充值">平台充值</option>
		<option value="充值手续费">充值手续费</option>
		<option value="提现手续费">提现手续费</option>
		<option value="融资服务费">融资服务费</option>
		<option value="投资服务费">投资服务费</option>
		<option value="提前还款服务费">提前还款服务费</option>
		<option value="还款">还款</option>
		<option value="提前还款">提前还款</option>
		<option value="投资冻结">投资冻结</option>
		<option value="放款冻结到冻结">放款冻结到冻结</option>
		<option value="放款解冻">放款解冻</option>
		
		</select>&nbsp;&nbsp;   交易请求时间：<input
			id="startTime" name="startTime" type="text" class="Wdate" value="${startTime }"
			onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd ',readOnly:'false',maxDate:'#F{$dp.$D(\'endTime\')||\'new Date()\'}'})">
		~~<input id="endTime" name="endTime" type="text" class="Wdate" value="${endTime }"
			onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd ',minDate:'#F{$dp.$D(\'startTime\')}',maxDate:new Date()})">
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
						style="font-size: 18px; margin-bottom: 10px;">平台订单编号</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">出账用户名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">出账真实姓名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">入账用户名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">入账真实姓名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">交易金额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">交易请求时间</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">平台交易类型</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">平台订单状态</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">订单交易结果</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">对账状态</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">备注</span></th>
				</tr>
			</thead>
			<c:forEach items="${siteBillingList.items }" var="siteBilling">
				<tr class="info" '>
					<td>${siteBilling.fySerialno }</td>
					<td>${siteBilling.outUsername }</td>
					<td>${siteBilling.outRealname }</td>
					<td>${siteBilling.inUsername }</td>
					<td>${siteBilling.inRealname }</td>
					<td>${siteBilling.amt }</td>
					<td>${siteBilling.createdStr }</td>
					<td>${siteBilling.siteBusiType }</td>
					<td><c:choose>
							<c:when test="${siteBilling.busiStatus == 0 }">成功</c:when>
							<c:when test="${siteBilling.busiStatus == 1 }">失败</c:when>
							<c:when test="${siteBilling.busiStatus == 2 }">未支付</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose></td>
					<td>${siteBilling.auditResults }</td>
						<td><c:choose>
							<c:when test="${siteBilling.auditStatus == 0 }">已对账</c:when>
							<c:when test="${siteBilling.auditStatus == 1 }">未对账</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose></td>
					<td>${siteBilling.siteBusiRem }</td>
					
				</tr>
			</c:forEach>
			<tr>
				<td colspan=10><page:Pager formName="siteBillingListForm"
						pageAttributeName="siteBillingList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>