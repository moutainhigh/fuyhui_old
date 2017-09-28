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

<script type="text/javascript">
	function check(){
		var username = $("#username").val();
		var realname = $("#realname").val();
		var mobile = $("#mobile").val();
		var corpName = $("#corpName").val();
		var realname = $("#realname").val();
		var cardId = $("#cardId").val();
		var country_id = $("#country_id").val();
		var city_id = $("#city_id").val();
		var parent_bank_id = $("#parent_bank_id").val();
		var bank_nm = $("#bank_nm").val();
		var capAcntNo = $("#capAcntNo").val();
		var contactPerson = $("#contactPerson").val();
		var contactMobile = $("#contactMobile").val();
		var address = $("#address").val();
		if(username ==""){
			alert("请输入用户名");
			return false;
		}		
		if(mobile ==""){
			alert("请输入法人手机号码");
			return false;
		}
		if(corpName ==""){
			alert("请输入企业名称");
			return false;
		}
		if(realname ==""){
			alert("请输入法人姓名");
			return false;
		}
		if(cardId ==""){
			alert("请输入法人身份证号码");
			return false;
		}
		if(country_id ==""){
			alert("请输入企业开户行省");
			return false;
		}
		if(city_id ==""){
			alert("请输入企业开户行市");
			return false;
		}
		if(parent_bank_id ==""){
			alert("请输入企业开户行行别");
			return false;
		}
		if(bank_nm ==""){
			alert("请输入企业开户行支行名称");
			return false;
		}
		if(capAcntNo ==""){
			alert("请输入企业对公账户");
			return false;
		}
		if(contactPerson ==""){
			alert("请输入联系人姓名");
			return false;
		}
		if(contactMobile ==""){
			alert("请输入联系人手机号码");
			return false;
		}
		if(address ==""){
			alert("请输入企业详细地址");
			return false;
		}
		
	}
	function Change_Select(){
		 $.ajax({
		        type:'post',
		        url:'${pageContext.request.contextPath }'+'/admin/user/getcityidList',
		        dataType:'json',
		        data:{
		        	itemno:$("#country_id").val(),
		        	itemno1:$("#city_id").val()
				},
		        success:function(json){
		        	var data = json.citycodelist2;
		        	$("#city_id").html(data);
		        	
		        }
		    });
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
		<form action="${pageContext.request.contextPath }/fy/africregister"
			id="addForm" name="addForm" method="post" onsubmit="return check();">
			<table class="table table-bordered table-hover definewidth m10">
			
			   <tr>
					<td width="20%" style="display:none;" class="tableleft">用户类型：</td>
					<td style="display:none;"><input value="${userType}" id="userType" name="userType" type="text" placeholder=""></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">用户名：</td>
					<td><input value="" id="username" name="username" type="text" placeholder="请输入用户名"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">法人手机号码：</td>
					<td><input value="" id="mobile" name="mobile" type="text" placeholder="请输入法人手机号码"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">企业名称：</td>
					<td><input value="" id="corpName" name="corpName" type="text" placeholder="请输入企业名称"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">法人姓名：</td>
					<td><input value="" id="realname" name="realname" type="text" placeholder="请输入法人姓名"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">法人身份证号码：</td>
					<td><input value="" id="cardId" name="cardId" type="text" placeholder="请输入法人身份证号码"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">法人邮箱地址：</td>
					<td><input value="" id="email" name="email" type="text" placeholder="请输入法人邮箱地址"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">企业开户行省：</td>
					<td><select name="country_id" id ="country_id" onChange="Change_Select()">
				    <option value="" selected="selected">请选择省份</option>
				    <c:forEach items="${citycodelist1 }" var="selCode">
				     <option value="${selCode.itemno}" >${selCode.itemname}</option>
				    </c:forEach>
			         </select></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">企业开户行市县：</td>
					<td><select name="city_id" id ="city_id" >
				    <option value="" selected="selected">请选择市县</option>
				   
			         </select></td>
				</tr>
				
				<tr>
					<td width="20%" class="tableleft">企业开户行行别：</td>
					<td><select name="parent_bank_id" id ="parent_bank_id">
				    <option value="" selected="selected">请选择银行</option>
				    <c:forEach items="${bankcodelist }" var="selCode">
				     <option value="${selCode.itemno}" selected="selected">${selCode.itemname}</option>
				    </c:forEach>
			         </select></td>
					
				</tr>
				<tr>
					<td width="20%" class="tableleft">企业开户行支行名称：</td>
					<td><input value="" id="bank_nm" name="bank_nm" type="text" placeholder="请输入企业开户行支行名称"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">企业对公户账户：</td>
					<td><input value="" id="capAcntNo" name="capAcntNo" type="text" placeholder="请输入企业对公户账户"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">联系人姓名：</td>
					<td><input value="" id="contactPerson" name="contactPerson" type="text" placeholder="请输入联系人姓名"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">联系人手机号码：</td>
					<td><input value="" id="contactMobile" name="contactMobile" type="text" placeholder="请输入联系人手机号码"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">企业详细地址：</td>
					<td><input value="" id="address" name="address" type="text" placeholder="请输入企业详细地址"></td>
				</tr>

				<tr>
					<td colspan=2><button onclick="return check();"
							class="btn btn-primary">添加</button>
					<a href="${pageContext.request.contextPath }/admin/user/index?userType=${userType}" class="btn btn-success" style="float:right">返回</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>