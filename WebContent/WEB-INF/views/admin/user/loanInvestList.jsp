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
	<form id="InvestListForm"
		action="${pageContext.request.contextPath }/admin/user/loanInvestList"
		class="form-inline definewidth m20" method="post">
		用户名： <input type="text" name="username" id="username"
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
						style="font-size: 18px; margin-bottom: 10px;">用户名称</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">债权编号</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">借款编号</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">债权金额(元)</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">年化利率(%)</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">期限</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">债权持有时间</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">状态</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">操作</span></th>
				</tr>
			</thead>
			<c:forEach items="${InvestList.items }" var="Invest">
				<tr class="info">
				    
					<td>${Invest.username }</td>
					<td>${Invest.order_number}</td>
					<td>${Invest.id }</td>
					
					
					
                      <td>${Invest.money}</td>
					<td>${Invest.apr}</td>
						<td><c:choose>
					<c:when test="${Invest.actPeriod>0}">${Invest.actPeriod}天</c:when>
					<c:otherwise>
					${Invest.period}天
					</c:otherwise>
					 </c:choose>
					 </td>
					<td><date:date pattern="yyyy-MM-dd HH:mm"
							value="${Invest.start_time  }"></date:date></td>
                    <td><c:choose>
                     <c:when test="${Invest.status==-2}">删除 </c:when>
                     <c:when test="${Invest.status==-1}">草稿</c:when>
                     <c:when test="${Invest.status==0}">预审（未审）</c:when>
                     <c:when test="${Invest.status==1}">终审 </c:when>
                     <c:when test="${Invest.status==7}">投标中 </c:when>
                     <c:when test="${Invest.status==8}">满标 </c:when>
                     <c:when test="${Invest.status==9}">还款中 </c:when>
                     <c:when test="${Invest.status==10}">已还清 </c:when>
                     <c:when test="${Invest.status==20}">流标 </c:when>
               </c:choose>
                     </td>
					<td><a
						href="${pageContext.request.contextPath }/admin/user/allApplyRecoverList?applyid=${Invest.id  }&userid=${Invest.userId  }" title="">回款详情</a>&nbsp;
						</tr>
			</c:forEach>
			<tr>
				<td colspan=9><page:Pager formName="InvestListForm"
						pageAttributeName="InvestList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
</body>
</html>