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
		if ($('.selct option').first().val()==1) {
			$('.jine').hide();
			$('.lilv').show();
		} 
		if ($('.selct option').first().val()==2) {
			$('.jine').show();
			$('.lilv').hide();
		}
		$('.selct').change(function() {
			if ($('.selct option:selected').text() == '比例') {
				$('.jine').hide();
				$('.lilv').show();
			} else if ($('.selct option:selected').text() == '定额') {
				$('.jine').show();
				$('.lilv').hide();
			}
		});
		// $('document').trigger('change');

		
		var rd = $('.chargeI').attr('seleid');
		var rd_num = $('.chargeItem option').length;
		var rd_arr = $('.chargeItem option');
		for(var i=0;i<rd_num;i++){
			if(rd_arr[i].value == rd){
				rd_arr[i].selected = 'selected';
			}
		}
		
		var rd2 = $('.chargeFee').attr('selid');
		var rd_num2 = $('.chargeFeeId option').length;
		var rd_arr2 = $('.chargeFeeId option');
		for(var i=0;i<rd_num2;i++){
			if(rd_arr2[i].value == rd2){
				rd_arr2[i].selected = 'selected';
			}
		}
		
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
		<form action="${pageContext.request.contextPath }/siteFeeType/update"
			id="addForm" method="post">
			<input value="${siteFeeType.chargeTypeId }" name="chargeTypeId"
				style="display: none;">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td class="tableleft">收费项目：</td>
					<td seleid=${siteFeeType.chargeItem } class='chargeI'><select name="chargeItem" class='chargeItem'>
							<option value="">所有项目</option>
							<c:forEach items="${loanTypeList }" var="loanType">
								<option value="${loanType.id }">${loanType.name }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="tableleft">收取费用：</td>
					<td selid=${siteFeeType.chargeFeeId } class='chargeFee'><select name="chargeFeeId" class='chargeFeeId'>
							<c:forEach items="${siteFeeList }" var="siteFee">
								<option value="${siteFee.feeId }">${siteFee.feeName }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="tableleft">用户类型：</td>
					<td><select name="userType">
							<option value="${siteFeeType.userType}"><c:if test="${empty siteFeeType.userType}">所有</c:if><c:if test="${siteFeeType.userType == 1 }">个人用户</c:if>
							<c:if test="${siteFeeType.userType == 2 }">企业用户</c:if><c:if test="${siteFeeType.userType == 3 }">担保公司</c:if></option>
							<c:forEach items="${userTypeList }" var="UserType">
								<option value="${UserType.key }">${UserType.value }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="tableleft">计算方式：</td>
					<td>
					<select name="formulaType" class='selct'>
							<option value="${siteFeeType.formulaType}"><c:if test="${siteFeeType.formulaType == 1 }">比例</c:if>
							<c:if test="${siteFeeType.formulaType == 2 }">定额</c:if></option>
							<c:forEach items="${formulaTypeList }" var="formulaType">
								<option value="${formulaType.key }">${formulaType.value }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr class='jine' style='display: none'>
					<td class="tableleft">金额：</td>
					<td><input value="${siteFeeType.amount }" name="amount"
						type="text"></td>
				</tr>
				<tr class='lilv'>
					<td class="tableleft">利率：</td>
					<td class='tabInput'><input value="${siteFeeType.interestRate }"
						name="interestRate" type="text">%</td>
						
				</tr>
				<tr>
					<td colspan=2><button type="submit" id="submit_btn"
							class="btn btn-primary">修改</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>