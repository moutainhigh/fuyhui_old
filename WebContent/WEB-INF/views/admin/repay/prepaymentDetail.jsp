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
<script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-form.js'></script>
<script type="text/javascript">
function prepayment(){
$("#prepaymentForm").ajaxSubmit({
    type : "post",//提交类型  
    async: false,
    dataType : "json",//返回结果格式  
    url : getContextPaths() + "/repay/prepayment",//请求地址   
    success : function(json){//请求成功后的函数 
    	if(json.flag==1){
    		alert(json.msg);
    		window.opener.location.reload();
    		window.close();
        }else if(json.flag==0){
        	alert(json.msg);
        	window.opener.location.reload();
        	window.close();
        } 
    }
});
}
</script>
</head>
<body>
	<c:if test="${not empty msg}">
		<script type="text/javascript">
			alert("${msg}");
			window.close();
		</script>
	</c:if>
	<div style="background: #fafafa; padding: 10px;">
		
		<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<th colspan=3>
							<b>提前还款</b>
					</th>
				</tr>
				<tr><td>项目名称：${loan.name }</td><td>融资方：${corpName }</td><td>募集金额：${loan.amount }元</td></tr>
				<tr><td>回款方式：<c:choose>
						<c:when test="${loan.paymentOptions == 1}">
						按月付息，到期一次性还本
						</c:when>
						<c:when test="${loan.paymentOptions == 2}">
						到期一次性还本付息
						</c:when>
						<c:when test="${loan.paymentOptions == 3}">
						等额本息
						</c:when>
						<c:when test="${loan.paymentOptions == 4}">
						等额本金
						</c:when>
						<c:when test="${loan.paymentOptions == 5}">
						按季付息，到期一次性还本
						</c:when>
						<c:otherwise></c:otherwise>
						</c:choose></td><td>放款时间：
						<date:date pattern="yyyy-MM-dd HH:mm" value="${loan.loanTime}"></date:date></td><td>募集期限：${loan.actPeriod }天</td></tr>
				<tr><td colspan=3>融资方可用余额：${balance }</td></tr>
			</table>
			<form id="prepaymentForm">
				<table class="table table-bordered table-hover definewidth m10">
					<input value="${loan.id }" name="id" type="hidden">
					<tr><td width="60%">提前还款费用名称</td><td>金额(元)</td></tr>
					<tr><td>待还本金</td><td><input name="repayMoney" readonly value="${prepaymentDetail.repayMoney }"></td></tr>
					<tr><td>当期预计收益</td><td><input name="profit" readonly value="${prepaymentDetail.profit }"></td></tr>
					<tr><td>提前还款服务费</td><td><input name="pSerFee" readonly value="${prepaymentDetail.pSerFee }"></td></tr>
					<tr><td>当期融资服务费</td><td><input name="financeSerfee" readonly value="${prepaymentDetail.financeSerfee }"></td></tr>
					<tr><td>提前还款总额</td><td><input name="totalRepay" readonly value="${prepaymentDetail.totalRepay }"></td></tr>
					<tr>
						<td colspan=2><button onclick="window.close();" class="btn btn-primary" style="float: left">取消</button>
						<button id="prepaymentBtn" onclick="prepayment();" class="btn btn-success" style="float: right">提前还款</button></td>
					</tr>
				</table>
			</form>
	</div>
</body>
</html>