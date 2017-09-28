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
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
</head>
<script type="text/javascript">
	function openWin(id,status,isLoans) { 
		if(status==9 || (status==8 && isLoans==3)){
       var url=getContextPaths()+'/repay/prepaymentDetail?id='+id; //转向网页的地址; 
       var name='';                            //网页名称，可为空; 
       var iWidth=888;                          //弹出窗口的宽度; 
       var iHeight=500;                         //弹出窗口的高度; 
       //获得窗口的垂直位置 
       var iTop = (window.screen.availHeight - 30 - iHeight) / 2; 
       //获得窗口的水平位置 
       var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; 
       window.open(url, name, 'height=' + iHeight + ',innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no'); 
		}else{
			alert("该项目不处于还款中状态或未解冻，无法进行提前还款！");
		}
	}

</script>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
	<div style="background: #fafafa; padding: 10px;">
		<form id="loanApplyListForm"  action="${pageContext.request.contextPath }/loan/loanApply/findLoanByCondition" class="form-inline definewidth m20">
			项目状态:<select name="status">
				<option value="">请选择</option>
				<option value="-2">已删除</option>
				<option value="-1">草稿</option>
				<option value="0">未审核</option>
				<option value="1">初审通过</option>
				<option value="2">终审通过</option>
				<option value="7">投资中</option>
				<option value="8">满标</option>
				<option value="9">还款中</option>
				<option value="10">已还清</option>
				<option value="20">流标</option>
			</select>
			&nbsp;&nbsp;<button type="submit" class="btn btn-primary"><i class="icon-search"></i>&nbsp;查询</button>
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">项目名称</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">项目来源</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">融资方</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">募集金额</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">投资期限</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">预期年化收益</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">回款方式</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">申请时间</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">放款时间</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">到期日</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">状态</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">导出投资记录Excel</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">详情</span></th>
				</tr>
				<c:forEach items="${loanApplyList.items }" var="loan">
					<tr class="info" 
					ondblclick="openWin(${loan.id },${loan.status },${loan.isLoans });">
						<td>${loan.loanName }</td>
						<td>${loan.projectSource }</td>
						<td>${loan.companyName }</td>
						<td>${loan.amount }元</td>
											<td><c:choose>
					<c:when test="${loan.actPeriod>0}">${loan.actPeriod}天</c:when>
					<c:otherwise>
					${loan.period}天
					</c:otherwise>
					 </c:choose>
					 </td>
						<td>${loan.apr }%</td>
						<td><c:choose>
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
						</c:choose></td>
						<td><c:if test="${not empty loan.created}"><date:date pattern="yyyy-MM-dd HH:mm" value="${loan.created}"></date:date></c:if></td>
						<td><c:if test="${not empty loan.loanTime}"><date:date pattern="yyyy-MM-dd HH:mm" value="${loan.loanTime}"></date:date></c:if></td>
						<td><c:if test="${not empty loan.dueTime}"><date:date pattern="yyyy-MM-dd" value="${loan.dueTime}"></date:date></c:if></td>
						<td><c:choose>
						<c:when test="${loan.status == -2}">
						已删除
						</c:when>
						<c:when test="${loan.status == -1 || loan.status == 0}">
						申请中
						</c:when>
						<c:when test="${loan.status == 1 || loan.status == 2}">
						审核中
						</c:when>
						<c:when test="${loan.status == 7}">
						投资中
						</c:when>
						<c:when test="${loan.status == 8 && loan.isLoans == 0}">
						已满标
						</c:when>
						<c:when test="${loan.status == 9 || (loan.status == 8 && loan.isLoans != 0)}">
						还款中
						</c:when>
						<c:when test="${loan.status == 10}">
						已还款
						</c:when>
						<c:when test="${loan.status == 20}">
						流标
						</c:when>
						<c:otherwise></c:otherwise>
						</c:choose></td>
						<td>
						<c:choose>
						<c:when test="${loan.status <7}">
						 <p style="text-align:right;margin-right:7px;">导出投资记录Excel</p>						
						</c:when>
						<c:otherwise>
						<p style="text-align:right;margin-right:7px;"><a href="/ImportExcel/ImportExcelInvest?id=${loan.id }" class="down">导出投资记录Excel</a></p>
						
						</c:otherwise>
						</c:choose></td>
						<td><a href="${pageContext.request.contextPath }/loan/loanApply/enterLoanConfirm2?id=${loan.id }">详情</a></td>
					</tr>
				</c:forEach>
				<tr>
				<td colspan=13><page:Pager formName="loanApplyListForm"
						pageAttributeName="loanApplyList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
			</table>
		</form>
	</div>
</body>
</html>