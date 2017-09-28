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
		<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<th colspan=8>
							<b>项目还款情况</b>
					</th>
				</tr>
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">借款用户</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">借款编号</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">还款方式</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">应还金额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">利息</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">本金</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">当前期数</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">应还时间</span></th>
				</tr>
				<tr><td>${applyRepay.companyName }</td>
				<td>${applyRepay.applyNo }</td>
				<td>${applyRepay.repayType }</td>
				<td>${applyRepay.repayMoney }</td>
				<td>${applyRepay.repayInterest }</td>
				<td>${applyRepay.repayCapital }</td>
				<td>${applyRepay.repayPeriod }</td>
				<td><c:if test="${not empty applyRepay.repayReqTime}"><date:date pattern="yyyy-MM-dd HH:mm"
							value="${applyRepay.repayReqTime }"></date:date></c:if></td>
				</tr>
			</table>
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<th colspan=8>
							<b>扣款情况确认</b>
					</th>
				</tr>
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">角色</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">借款用户</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">担保机构</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">平台风险备付金</span></th>
				</tr>
				<tr><td>公司名称</td><td>${applyRepay.companyName }</td><td>${loan.guaranteeCompany }</td><td>富之富</td></tr>
				<tr><td>余额</td><td>${lenderRemain}</td><td>${guaranteeCompanyRemain}</td><td>${platformRemain }</td></tr>
				<tr><td>扣款金额</td><td>${lenderRepay}</td><td>${guaranteeRepay}</td><td>${platformRepay}</td></tr>
				<tr>
					<td colspan=4><a href="${pageContext.request.contextPath }/repay/advanceRepayment?id=${id }&per=${applyRepay.repayPeriod }"
						class="btn btn-primary" style="float: left">确认还款</a><span style="color:red;">&nbsp;&nbsp;确认还款之前请仔细查看资金扣款情况</span><a href="${pageContext.request.contextPath }/repay/advanceRepay"
						class="btn btn-success" style="float: right">返回</a></td>
				</tr>
			</table>
	</div>
</body>
</html>