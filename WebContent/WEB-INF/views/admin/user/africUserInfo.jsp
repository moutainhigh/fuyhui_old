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
					<td width="20%" class="tableleft">用户名：</td>
					<td>${user.username }</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">法人手机号码：</td>
					<td>${user.mobile }</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">企业名称：</td>
					<td>${user.corpName }</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">法人姓名：</td>
					<td>${user.realname }</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">法人身份证号码：</td>
					<td>${user.cardId }</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">法人邮箱地址：</td>
					<td>${user.email }</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">企业开户行省：</td>
					<td><select disabled="disabled">
							<option value="${user.country_id}">${user.country_name }</option>
					</select></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">企业开户行市县：</td>
					<td><select disabled="disabled">
							<option value="${user.city_id}">${user.city_name}</option>
					</select></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">企业开户行行别：</td>
					<td><select disabled="disabled">
						<option value="${user.parent_bank_id}">${user.parent_bank_name}</option>
					</select></td>
					</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">企业开户行支行名称：</td>
					<td>${user.bank_nm }</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">企业对公户账户：</td>
					<td>${user.capAcntNo }</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">公司介绍：</td>
					<td><textarea rows="6" cols="20" id="corpIntro"
							name="corpIntro" readonly="readonly">${user.corpIntro }</textarea>
					</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">经营情况：</td>
					<td><textarea rows="3" cols="20" id="busSituation"
							name="busSituation"  readonly="readonly">${user.busSituation }</textarea>
					</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">联系人姓名：</td>
					<td>${user.contactPerson }</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">联系人手机号码：</td>
					<td>${user.contactMobile }</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">企业详细地址：</td>
					<td>${user.address }</td>
				</tr>
				
				<tr>
					<td colspan=2><a
						href="${pageContext.request.contextPath }/admin/user/index?userType=${user.userType}"
						class="btn btn-success" style="float: right">返回</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>