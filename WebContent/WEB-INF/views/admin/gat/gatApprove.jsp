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
	<script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/plugins/My97DatePicker/WdatePicker.js"></script>
<body>
	<c:if test="${msg ne null}">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
	
	<form id="gatApproveListForm"  action="${pageContext.request.contextPath }/gat/searchGatList" class="form-inline definewidth m20" method="post">
		用户名： <input type="text" name="mobile" id="mobile" class="abc input-default" value="${mobile }">&nbsp;&nbsp;
		审批状态：
 		<select id="approveStatus" name="approveStatus" value = "${approveStatus}">
 		<option value="" selected>请选择</option>
		<option value="1" >未审批</option>
		<option value="2">审批通过</option>
		<option value="3">审批拒绝</option>
		</select>		
		
		<button type="submit" class="btn btn-primary">
			<i class="icon-search"></i>&nbsp;查询
		</button>
		
		<table class="table table-bordered table-hover definewidth m10">
			<thead>
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">用户名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">真实姓名</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">证件类型</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">证件号码</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">银行卡号</span></th>						
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">开户行</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">开户省</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">开户市</span></th>	
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">审批状态</span></th>												
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">附件图</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">操作</span></th>													
				</tr>
			</thead>
			<c:forEach items="${gatApproveList.items }" var="gatApprove">
				<tr class="info">
				     
					<td>${gatApprove.mobile }</td>
					<td>${gatApprove.realname }</td>
					<td>${gatApprove.cardTypeName }</td>
					<td>${gatApprove.cardId }</td>
					<td>${gatApprove.cardNumber }</td>
					<td>${gatApprove.bankName }</td>
					<td>${gatApprove.provinceName }</td>
					<td>${gatApprove.cityName }</td>
					<td>
					
						<c:choose>
							<c:when test="${gatApprove.approveStatus == 1 }">未审批</c:when>
							<c:when test="${gatApprove.approveStatus == 2 }">审批通过</c:when>
							<c:when test="${gatApprove.approveStatus == 3 }">审批拒绝</c:when>
							<c:otherwise>
							未知
							</c:otherwise>					
					</c:choose>
					</td>
<%-- 					<td><a class ='jiekouceshi' href="javascript:void(0);">接口测试</a>${gatApprove.cardIdPic }${gatApprove.bankCardPic }</td>		 --%>
					<td><a class ='cardPic' href="javascript:void(0);" cardPicur ='${gatApprove.cardIdPic }'>手持证件正面附件图</a>,<a class ='card2Pic' href="javascript:void(0);" card2Picur ='${gatApprove.card2Pic }'>手持证件反面附件图</a>,<a class ='bankPic' href="javascript:void(0);" bankPicur='${gatApprove.bankCardPic}'>银行卡正面图</a></td>					
					<c:choose>
							<c:when test="${gatApprove.approveStatus == 1 }">
					<td><a href="${pageContext.request.contextPath }/gat/approve?id=${gatApprove.id }&flag=1">通过</a>
					<a href="${pageContext.request.contextPath }/gat/approve?id=${gatApprove.id }&flag=2">不通过</a></td>
					</c:when>
					</c:choose>
				</tr>
			</c:forEach>
			<tr>
				<td colspan=10><page:Pager formName="gatApproveListForm"
						pageAttributeName="gatApproveList" styleClass="textfield"
						goStyleClass="gobutton" /></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
 $(function(){
	 $('.cardPic').each(function(){
		 $(this).click(function(){
			 var cardPic= $(this).attr('cardPicur');
			 //console.log(cardPic);
			 var cardPicUrl =globalUrl+cardPic;
			 //alert("cardPicUrl=="+cardPicUrl);
			 if(cardPic!=""){
			 window.open(cardPicUrl,"newwindow","height=600, width=300, top=400, left=200, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");	
			 }
		 }); 
     });
	 $('.bankPic').each(function(){
		 $(this).click(function(){
			 var cardPic= $(this).attr('bankPicur');
			 //console.log(cardPic);
			 var cardPicUrl =globalUrl+cardPic;
			 //alert("cardPicUrl=="+cardPicUrl);
			 if(cardPic!=""){
			 window.open(cardPicUrl,"newwindow","height=600, width=300, top=600, left=300, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");	
			 }
		 }); 
     });
	 $('.card2Pic').each(function(){
		 $(this).click(function(){
			 var cardPic= $(this).attr('card2Picur');
			 //console.log(cardPic);
			 var cardPicUrl =globalUrl+cardPic;
			 //alert("cardPicUrl=="+cardPicUrl);
			 if(cardPic!=""){
			 window.open(cardPicUrl,"newwindow","height=600, width=300, top=600, left=300, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");	
			 }
		 }); 
     });
 });
 </script>
</body>
</html>