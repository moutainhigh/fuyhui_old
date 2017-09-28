<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/back/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/back/css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/back/assets/js/jquery-1.8.1.min.js"></script>
	
	<script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
<script type="text/javascript">

	function check(){
		var username = $("#username").val();
		var realname = $("#realname").val();
		if(username ==''){
			alert("请输入用户名");
			return false;
		}
	
		if(realname ==''){
			alert("请输入法人名称");
			return false;
		}
		
	}
</script>
</head>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
	<div>
		<form action="${pageContext.request.contextPath }/admin/user/update"
			id="updateForm" name="updateForm" method="post">
			<input style="display: none;" value="${user.userId }" name="userId"
				type="text">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<td width="10%" class="tableleft">真实姓名：</td>
					<td width="20%">${user.realname }</td>
					<td width="10%" class="tableleft">手机号码：</td>
					<td width="20%">${user.mobile }</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">证件类型：</td>
					<td width="20%"><c:choose>
							<c:when test="${user.cardType == 1 }">身份证</c:when>
							<c:when test="${user.cardType == 2 }">台胞证</c:when>
							<c:when test="${user.cardType == 3 }">港澳通行证</c:when>
							<c:when test="${user.cardType == 4 }">其他</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose></td>
					<td width="20%" class="tableleft">身份号码：</td>
					<td width="20%">${user.cardId }</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">银行卡号：</td>
					<td width="20%">${user.capAcntNo }</td>
					<td width="20%" class="tableleft">开户行所在地：</td>
					<td width="20%">${user.country_name }${user.city_name }</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">开户银行：</td>
					<td width="20%">${user.parent_bank_name }</td>
					<td width="20%" class="tableleft">常用地址：</td>
					<td width="20%">${user.address }</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">邮箱地址：</td>
					<td width="20%">${user.email }</td>
					<td width="20%" class="tableleft">风险等级：</td>
					<td width="20%">${user.assessmentResult }</td>
				</tr>
				<tr>
				<td width="20%" class="tableleft">是否内部会员：</td>
				<c:choose>
				<c:when test="${user.isInside == 1 }">
					<td width="20%">是</td>
					</c:when>
					<c:otherwise>
					<td width="20%">否</td>
							</c:otherwise>
				</c:choose>
				</tr>
				<tr>
				<c:choose>
				<c:when test="${user.cardType == 2 or user.cardType == 3 }">
					<td width="20%" class="tableleft">证件附件图：</td>
					
					<td><a class ='cardPic' href="javascript:void(0);" cardPicur ='${user.cardPic }'>手持证件正面附件图</a> , <a class ='cardPic' href="javascript:void(0);" cardPicur ='${user.card2Pic }'>手持证件正面附件图</a> , <a class ='bankPic' href="javascript:void(0);" bankPicur='${user.bankCardPic}'>银行卡正面图</a></td>
				</c:when>
				</c:choose>
				</tr>
				
				<tr>
					<td colspan=2><a
						href="${pageContext.request.contextPath }/user/index?userType=${user.userType}"
						class="btn btn-success" style="float: right">返回</a></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
 $(function(){
	 $('.cardPic').click(function(){
		 
			 var cardPic= $('.cardPic').attr('cardPicur');
			 console.log(cardPic);
			 var cardPicUrl =globalUrl+cardPic;
			 //alert("cardPicUrl=="+cardPicUrl);
			 if(cardPic!=""){
			 window.open(cardPicUrl,"newwindow","height=600, width=300, top=400, left=200, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");	
			 }
		 
     });
	 $('.bankPic').click(function(){
		
			 var cardPic= $('.bankPic').attr('bankPicur');
			 //console.log(cardPic);
			 var cardPicUrl =globalUrl+cardPic;
			 //alert("cardPicUrl=="+cardPicUrl);
			 if(cardPic!=""){
			 window.open(cardPicUrl,"newwindow","height=600, width=300, top=600, left=300, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");	
			 }
 
     });
 });
 </script>
</body>
</html>