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
	href="${pageContext.request.contextPath }/static/back/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/back/css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/back/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	i = 1;
	$(function() {
		$('#addIcon')
				.click(
						function() {
							$('#addIconTd')
									.append(
											'<input type="file" id="file_'+i+'" name="file_'+i+'">');
							i = i + 1;
						});
	});
	function check(){
		var name = $("#name").val();
		if(name == ''){
			alert("请输入产品名");
			return false;
		}
		if($(':file').length==0){
			alert("请上传标的图标");
			return false;
		}
		for(j=1;j<=$(':file').length;j++){
			if($("#file_"+j).val() == ''){
				alert("未选择标的图标");
				return false;
			}
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
		<form action="${pageContext.request.contextPath }/loanType/add"
			id="addForm" enctype="multipart/form-data" method="post">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<th colspan=2><center>
							<b>产品名称</b>
						</center></th>
				</tr>
				<tr>
					<td width="20%" class="tableleft">产品名：</td>
					<td><input value="" id="name" name="name" type="text"
						placeholder="20字以内"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">标的类型：</td>
					<td><select name="category">
							<c:forEach items="${categoryList }" var="category">
								<option value="${category }">${category }</option>
							</c:forEach>
					</select></td>
				</tr>
				<%-- <tr>
					<td width="20%" class="tableleft">产品来源：</td>
					<td><select name="productSource">
							<c:forEach items="${productSourceList }" var="productSource">
								<option value="${productSource }">${productSource }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<th colspan=2><center>
							<b>投资条件</b>
						</center></th>
				</tr>
				<tr>
					<td width="20%" class="tableleft">投资金额范围：</td>
					<td><input value="" id="quotaMin" name="quotaMin" type="text">-<input
						value="" id="quotaMax" name="quotaMax" type="text">元</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">递投金额：</td>
					<td><input value="" id="proAmount" name="proAmount"
						type="text">元</td>
				</tr> --%>
				<tr>
					<th colspan=2><center>
							<b>标的图标</b>
						</center></th>
				</tr>
				<tr>
					<td colspan=2 id="addIconTd"><input type="button" id="addIcon"
						value="选择图片"></td>
				</tr>
				<tr>
					<td colspan=2><button type="submit"  onclick="return check()" id="submit_btn"
							class="btn btn-primary">添加</button> <a
						href="${pageContext.request.contextPath }/loanType/index"
						class="btn btn-success" style="float: right">返回</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>