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
	href="${pageContext.request.contextPath }/static/back/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/back/css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/back/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">

		
		function check(){
			
			var levelMinMount1 = $("#levelMinMount1").val();
			var levelMaxMount1 = $("#levelMaxMount1").val();
			var levelRewardMount1 = $("#levelRewardMount1").val();


			var levelMinMount2 = $("#levelMinMount2").val();
			var levelMaxMount2 = $("#levelMaxMount2").val();
			var levelRewardMount2 = $("#levelRewardMount2").val();
			
			var levelMinMount3 = $("#levelMinMount3").val();
			var levelMaxMount3 = $("#levelMaxMount3").val();
			var levelRewardMount3 = $("#levelRewardMount3").val();
			
			var levelMinMount4 = $("#levelMinMount4").val();
			var levelMaxMount4 = $("#levelMaxMount4").val();
			var levelRewardMount4 = $("#levelRewardMount4").val();
			
			var term = $("#term").val();
			var reg = new RegExp("^[0-9]+\.?[0-9]*$");
			if(!reg.test(levelMinMount1) || levelMinMount1 == ''){  
		        alert("档次金额1最小值格式不正确!");
		        return false;
			}
			if(!reg.test(levelMaxMount1) || levelMaxMount1 == ''){  
		        alert("档次金额1最小值格式不正确!");
		        return false;
			}
			if(!reg.test(levelRewardMount1) || levelRewardMount1 == ''){  
		        alert("档次1奖励格式不正确!");
		        return false;
			}			
			
			if(!reg.test(levelMinMount2) || levelMinMount2 == ''){  
		        alert("档次金额2最小值格式不正确!");
		        return false;
			}
			if(!reg.test(levelMaxMount2) || levelMaxMount2 == ''){  
		        alert("档次金额2最小值格式不正确!");
		        return false;
			}
			if(!reg.test(levelRewardMount2) || levelRewardMount2 == ''){  
		        alert("档次2奖励格式不正确!");
		        return false;
			}					
			
			if(!reg.test(levelMinMount3) || levelMinMount3 == ''){  
		        alert("档次金额2最小值格式不正确!");
		        return false;
			}
			if(!reg.test(levelMaxMount3) || levelMaxMount3 == ''){  
		        alert("档次金额2最小值格式不正确!");
		        return false;
			}
			if(!reg.test(levelRewardMount3) || levelRewardMount3 == ''){  
		        alert("档次2奖励格式不正确!");
		        return false;
			}					

			
			var reg1 = new RegExp("^[0-9]*[1-9][0-9]*$");
			if(!reg1.test(term) || term == ''){  
		        alert("有效期必须为整数!");
		        return false;
			}	
			
			if(parseFloat(levelMinMount1) > parseFloat(levelMaxMount3)){
		        alert("档次1最小金额不可大约档次最大金额!");
		        return false;
			}
			
			if(parseFloat(levelMinMount2) > parseFloat(levelMaxMount3)){
		        alert("档次2最小金额不可大约档次最大金额!");
		        return false;
			}
			
			if(parseFloat(levelMinMount3) > parseFloat(levelMaxMount3)){
		        alert("档次3最小金额不可大约档次最大金额!");
		        return false;
			}		
			
			if(parseFloat(levelMinMount4) > parseFloat(levelMaxMount4)){
		        alert("档次4最小金额不可大约档次最大金额!");
		        return false;
			}					
			
			if(parseFloat(levelMaxMount1) != parseFloat(levelMinMount2)){
		        alert("档次间金额大小必须连续!");
		        return false;
			}
			
			if(parseFloat(levelMaxMount2) != parseFloat(levelMinMount3)){
		        alert("档次间金额大小必须连续!");
		        return false;
			}	
			if(parseFloat(levelMaxMount3) != parseFloat(levelMinMount4)){
		        alert("档次间金额大小必须连续!");
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
		<form action="${pageContext.request.contextPath }/recommend/settingUpdate" id="addForm" enctype="multipart/form-data" method="post">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
				<input value="${recommendSettingUpdateVo.id}" id="id" name="id" type="hidden">
					<td width="20%" class="tableleft">奖励金额设置</td>
					<td width="30%"><center>大于等于</center></td>
					<td width="20%"><center>小于</center></td>
					<td width="30%"><center>奖励金额</center></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">档次一设置</td>
					<input value="${recommendSettingUpdateVo.id1}" id="id1" name="id1" type="hidden">
					<td width="30%"><center><input value="${recommendSettingUpdateVo.levelMinMount1 }" id="levelMinMount1" name="levelMinMount1" type="text"  >元~</center></td>
					<td width="20%"><center><input value="${recommendSettingUpdateVo.levelMaxMount1 }" id="levelMaxMount1" name="levelMaxMount1" type="text"  >元</center></td>
					<td width="30%"><center><input value="${recommendSettingUpdateVo.levelRewardMount1 }" id="levelRewardMount1" name="levelRewardMount1" type="text"  >元</center></td>
				</tr>
				
				<tr>
					<td width="20%" class="tableleft">档次二设置</td>
					<input value="${recommendSettingUpdateVo.id2}" id="id2" name="id2" type="hidden">
					<td width="30%"><center><input value="${recommendSettingUpdateVo.levelMinMount2 }" id="levelMinMount2" name="levelMinMount2" type="text"  >元~</center></td>
					<td width="20%"><center><input value="${recommendSettingUpdateVo.levelMaxMount2 }" id="levelMaxMount2" name="levelMaxMount2" type="text"  >元</center></td>
					<td width="30%"><center><input value="${recommendSettingUpdateVo.levelRewardMount2 }" id="levelRewardMount2" name="levelRewardMount2" type="text"  >元</center></td>
				</tr>	
				
				<tr>
					<td width="20%" class="tableleft">档次三设置</td>
					<input value="${recommendSettingUpdateVo.id3}" id="id3" name="id3" type="hidden">
					<td width="30%"><center><input value="${recommendSettingUpdateVo.levelMinMount3 }" id="levelMinMount3" name="levelMinMount3" type="text"  >元~</center></td>
					<td width="20%"><center><input value="${recommendSettingUpdateVo.levelMaxMount3 }" id="levelMaxMount3" name="levelMaxMount3" type="text"  >元</center></td>
					<td width="30%"><center><input value="${recommendSettingUpdateVo.levelRewardMount3 }" id="levelRewardMount3" name="levelRewardMount3" type="text"  >元</center></td>
				</tr>
				
				<tr>
					<td width="20%" class="tableleft">档次四设置</td>
					<input value="${recommendSettingUpdateVo.id4}" id="id4" name="id4" type="hidden">
					<td width="30%"><center><input value="${recommendSettingUpdateVo.levelMinMount4 }" id="levelMinMount4" name="levelMinMount4" type="text"  >元~</center></td>
					<td width="20%"><center><input value="${recommendSettingUpdateVo.levelMaxMount4 }" id="levelMaxMount4" name="levelMaxMount4" type="text"  >元</center></td>
					<td width="30%"><center><input value="${recommendSettingUpdateVo.levelRewardMount4 }" id="levelRewardMount4" name="levelRewardMount4" type="text"  >元</center></td>
				</tr>					
							
				<tr>
					<td width="20%" class="tableleft">奖励有效期</td>
					<td width="30%" colspan=3><input value="${recommendSettingUpdateVo.term }" id="term" name="term" type="text"  >个月</td>
				</tr>								
							

				<tr>
					<td colspan=4><center><button type="submit" onclick="return check()" class="btn btn-success" style="float:center" id='btn_insert'>保存</button></center></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>




