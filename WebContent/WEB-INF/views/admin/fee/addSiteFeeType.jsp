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
<script type="text/javascript">
	$(function() {
		$('.selct').change(function() {
			if ($('.selct option:selected').text() == '比例') {
				$('.jine').hide();
				$('.lilv').show();
			} else if ($('.selct option:selected').text() == '定额') {
				$('.jine').show();
				$('.lilv').hide();
			}
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
	<div>
		<form action="${pageContext.request.contextPath }/siteFeeType/add"
			id="addForm" method="post">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td class="tableleft">收费项目：</td>
					<td><select name="chargeItem">
							<option value="">所有项目</option>
							<c:forEach items="${loanTypeList }" var="loanType">
								<option value="${loanType.id }">${loanType.name }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="tableleft">收取费用：</td>
					<td><select name="chargeFeeId">
							<c:forEach items="${siteFeeList }" var="siteFee">
								<option value="${siteFee.feeId }">${siteFee.feeName }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="tableleft">收费用户：</td>
					<td><select name="userType">
							<option value="">所有用户</option>
							<c:forEach items="${userTypeList }" var="UserType">
								<option value="${UserType.key }">${UserType.value }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="tableleft">计算方式：</td>
					<td><select name="formulaType" class='selct'>
							<c:forEach items="${formulaTypeList }" var="formulaType">
								<option value="${formulaType.key }">${formulaType.value }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr class='jine' style='display: none'>
					<td class="tableleft">金额：</td>
					<td><input value="" name="amount" type="text"></td>
				</tr>
				<tr class='lilv'>
					<td class="tableleft">利率：</td>
					<td class='tabInput'><input value="" name="interestRate"
						type="text"></td>
				</tr>
				<tr>
					<td colspan=2><button type="submit" id="submit_btn"
							class="btn btn-primary">添加</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>