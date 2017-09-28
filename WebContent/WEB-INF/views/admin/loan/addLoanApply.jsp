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
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
<script type="text/javascript">
		i = 1;
		$(function(){
			$('#addFile').click(
				function() {
					$('#addFileTd').append('<input type="file" id="file_'+i+'" name="file_'+i+'">');
					i = i + 1;
				}
			);
			
			
			$('.loanType').change(function(){
				if($('.loanType option:selected')){
					 $.ajax({
					    	type: 'POST',
					        url : "${pageContext.request.contextPath }/loanType/findLoanTypeById",
					        data : {
					            id : $('.loanType option:selected').val()
					        },
					        dataType:'json',
					        success : function(json){
					        	if(json.flag == 1){
					        		$('.proPic').html('');
					        		/* for(var i=0;i<json.content.length;i++){
					        			var srces = json.content[i];
					        			$('.proPic').append('<input type="radio" name="url" value='+json.content[i]+'><img src="${pageContext.request.contextPath }/fyh/productPic/'+
					        			json.content[i]+'"  width="80" height="80">'); 
					        		} */
					        		var l = json.content.length;
					        		var rand = parseInt(l*Math.random());
					        		$('.proPic').append('<input type="text" name="url" value='+json.content[rand]+'>');
					        	}
					        }
					    }); 
				}
			});
			
			
			$('#btn_save').click(function(){
				$('#status').val('-1');
			});
			
			$('#btn_insert').click(function(){
				$('#status').val('0');
			});
			
			
			$.ajax({
		    	type: 'POST',
		        url : "${pageContext.request.contextPath }/loanType/findLoanTypeById",
		        data : {
		            id : $('.loanType option:selected').val()
		        },
		        dataType:'json',
		        success : function(json){
		        	if(json.flag == 1){
		        		$('.proPic').html('');
		        		var l = json.content.length;
		        		var rand = parseInt(l*Math.random());
		        		$('.proPic').append('<input type="text" name="url" value='+json.content[rand]+'>');
		        	}
		        }
		    }); 
			
			var now = new Date(new Date().toLocaleDateString()).getTime();
			var endTime = '';
			$('#dTime').focus(function(){
				if($('#dTime').val().length!=0){
					endTime = new Date(Date.parse($('#dTime').val().replace(/-/g,"/"))).getTime();
					$('#period').val((endTime - now)/(1000*60*60*24));
				}
			});
		});
		
		function check(){
			var name = $("#name").val();
			var amount = $("#amount").val();
			var apr = $("#apr").val();
			var guaranteeMode = $("#guaranteeMode").val();
			var dTime = $("#dTime").val();
			var description = $("#description").val();
			var loanType =$(".loanType").find("option:selected").val();
			var reg =new RegExp("^[0-9]");
			var fileSize = $('#addFileTd').find(':file').length;
			var paymentOptions =  $("#paymentOptions").val();
			if(name == '' || name.length > 255){
				alert("输入的项目名称格式不正确");
				return false;
			}
			if(!reg.test(amount) || amount == '' || amount<=0){  
		        alert("输入的募集金额格式不正确!");
		        return false;
		    }
			if(!reg.test(apr) || apr == ''){
				alert("输入的预期年化收益格式不正确!");
		        return false;
			}
			if(guaranteeMode == '' || guaranteeMode.length > 100){
				alert("输入的保障方式格式不正确");
				return false;
			}
			
			if(fileSize == 0){
				alert("缺少附件");
				return false;
			}else{
				for(var i = 0;i<fileSize;i++){
					if($('#file_'+(i+1)).val() ==''){
						alert("缺少附件");
						return false;
					}
				}
			}

			if(dTime == ''){
				alert("请选择到期日");
				return false;
			}
			if(loanType=='51'){
				var installmentDate=$("#installmentDate").val();
				var  lDate=$("#lDate").val();
				var  signedNumber=$("#signedNumber").val();
				
			  
			  if (paymentOptions == '1' ||paymentOptions == '5'){
			  if(installmentDate == ''){
				  alert("分期还款日必输");
				  return false;
			  }else{
				  if(!reg.test(installmentDate)){
					  alert("分期还款日请输入数字");
					  return false;
				  }
				  if(installmentDate<1||installmentDate>31){
					  alert("分期还款日为1-31");
					  return false;
				  }
			  }
			  }
			  
			  if(lDate == ''){
					alert("请输入线下还款日");
					return false;
			  }
			  /* if(signedNumber == ''){
					alert("输入的原签订编号格式不正确");
					return false;
			  } */
			}else{
				var projectSource = $("#projectSource").val();
				var productManager = $("#productManager").val();
				var  recordSize=$("#recordSize").val();
				if(projectSource == '' || projectSource.length > 50){
					alert("输入的产品来源格式不正确");
					return false;
				}
				if(productManager == '' || productManager.length > 50){
					alert("输入的产品管理人格式不正确");
					return false;
				}
				if(recordSize == '' || !reg.test(recordSize) || recordSize<=0){
					alert("输入的备案规模格式不正确");
					return false;
			    }
			}
			if(description == ''){
				alert("请输入项目描述");
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
		<form action="${pageContext.request.contextPath }/loan/loanApply/add" id="addForm" enctype="multipart/form-data" method="post">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<th colspan=4><center>
							<b>项目信息</b>
						</center></th>
				</tr>
				<tr>
					<input value="" id="status" name="status" type="hidden">
					<td width="20%" class="tableleft">融资方名称：</td>
					<td width="30%"><select id="userId" name="userId">
							<c:forEach items="${borrowerList }" var="borrower">
								<option value="${borrower.userId }">${borrower.corpName }</option>
							</c:forEach>
					</select></td>
					<td width="20%" class="tableleft">项目名称：</td>
					<td width="30%"><input value="" id="name" name="name" type="text"  placeholder="请输入项目名称"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">产品名称：</td>
					<td width="30%"><select name="loanType" class='loanType'>
							<c:forEach items="${loanTypeList }" var="loanType">
								<option value="${loanType.id }">${loanType.name }</option>
							</c:forEach>
					</select></td>
					<td width="20%" class="tableleft">募集金额：</td>
					<td width="30%"><input value="" id="amount" name="amount" type="text"  placeholder="请输入募集金额">元</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">到期日：</td>
					<td width="30%"><input id="dTime" name="dTime" type="text" class="Wdate"  
			onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d'})"></td>
					<td width="20%" class="tableleft">起息日：</td>
					<td>放款日</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">回款方式：</td>
					<td width="30%"><select id="paymentOptions" name="paymentOptions">
							<c:forEach items="${repaymentMethod }" var="paymentOptions">
								<option value="${paymentOptions.key }">${paymentOptions.value }</option>
							</c:forEach>
					</select></td>
					<td width="20%" class="tableleft">预期年化收益：</td>
					<td width="30%"><input value="" id="apr" name="apr" type="text" placeholder="请输入预期年化收益"><span>%</span></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">保障方：</td>
					<td width="30%"><select id="guaranteeCompanyId" name="guaranteeCompanyId">
							<c:forEach items="${guaranteeCompanyList }"
								var="guaranteeCompany">
								<option value="${guaranteeCompany.userId }">${guaranteeCompany.corpName }</option>
							</c:forEach>
					</select></td>
					<td width="20%" class="tableleft">保障方式：</td>
					<td width="30%"><input value="" id="guaranteeMode" name="guaranteeMode" type="text"
						placeholder="请输入保障方式"></td>
				</tr>
				<tr class="xandc">
					<td width="20%" class="tableleft">项目来源：</td>
					<td width="30%"><input value="" id="projectSource" name="projectSource" type="text"
						placeholder="请输入项目来源"></td>
					<td width="20%" class="tableleft">产品管理人：</td>
					<td width="30%"><input value="" id="productManager" name="productManager" type="text"
						placeholder="请输入产品管理人"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">是否冻结：</td>
					<td width="30%"><input name="isFrozen" type="radio" value=0 />是&nbsp;
						<input name="isFrozen" type="radio"  checked="checked" value=1 />否&nbsp; </td>
					<td width="20%" class="tableleft">基础资产：</td>
					<td width="30%"><select id="underlyAssets" name="underlyAssets">
						<option value="小贷资产">小贷资产</option>
						<option value="保理资产">保理资产</option>
						<option value="融资租赁资产">融资租赁资产</option>
					</select></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">融资期限：</td>
					<td width="30%"><input readonly value="" id="period" name="period">天</td>
					<td width="20%" class="tableleft">合同附件：</td>
					<td width="30%" id="addFileTd">
					<input type="button" id="addFile" value="选择文件">
					<!-- <input type="file" id="file" name="file"> -->
					</td>
				</tr>
				<tr class = "beian">
					<td width="20%" class="tableleft">备案规模：</td>
					<td width="80%" colspan=3><input value="" id="recordSize" name="recordSize">元</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">项目描述：</td>
					<td width="80%" colspan=3><textarea rows="5" cols="200"
							id="description" name="description" placeholder="请输入项目描述"></textarea></td>
				</tr>
				<tr style="display: none;">
					<td width="20%" class="tableleft">项目图标：</td>
					<td width="80%" colspan=3 class='proPic'></td>
				</tr>
				<tr class = "fenqi" style="display:none;">
					<td width="20%" class="tableleft">分期还款日：</td>
					<td width="30%"><input id="installmentDate" name="installmentDate" type="text"  placeholder="请输入分期还款日"
			></td>
			
					<td width="20%" class="tableleft">线下放款日期：</td>
					<td width="30%"><input id="lDate" name="lDate" type="text" class="Wdate"  
			onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"></td>
			</tr>
			<!-- <tr class = "qianding" style="display:none;">
					<td width="20%" class="tableleft">签订编号：</td>
					<td width="80%" colspan=3><input value="" id="signedNumber" name="signedNumber"></td>
			</tr> -->
				<tr>
					<td colspan=4><button type="submit" class="btn btn-primary" id='btn_save' onclick="return check()">保存</button>
							<button type="submit" onclick="return check()" class="btn btn-success" style="float:right" id='btn_insert'>录入</button></td>
				</tr>
			</table>
		</form>
	</div>
	
	<script type="text/javascript">
	
	$(".loanType").on("change",function(){
		if ($("option:selected",this).val() == '51') {
			// 显示
			$(".fenqi").css("display","table-row");
			$(".beian").css("display","none");
			$(".xandc").css("display","none");
			$(".qianding").css("display","table-row");
		};
		
		if ($("option:selected",this).val() != '51') {
			$(".fenqi").css("display","none");
			$(".beian").css("display","table-row");
			$(".xandc").css("display","table-row");
			$(".qianding").css("display","none");
		};
	});
	
	</script>
	
	
</body>
</html>




