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
		$(function(){
			var ss =$(".loanType").val()
			if(ss=='51'){
				$(".fenqi").css("display","table-row");
				$(".beian").css("display","none");
				$(".xandc").css("display","none");
				$(".qianding").css("display","table-row");
			}
			var amount = parseFloat($("#amount").val());
			if($("#financeServiceFee").val()!=''){
				var financeServiceFee = parseFloat($("#financeServiceFee").val());
				$("#sfee").val(Math.floor(amount*financeServiceFee)/100);
			}
			/* $.ajax({
		    	type: 'POST',
		        url : "${pageContext.request.contextPath }/loanType/findLoanTypeById",
		        data : {
		            id : $('.loanType option:selected').val()
		        },
		        async:false,
		        dataType:'json',
		        success : function(json){
		        	if(json.flag == 1){
		        		$('.proPic').html('');
		        		for(var i=0;i<json.content.length;i++){
		        			var srces = json.content[i];
		        			$('.proPic').append('<input type="radio" name="url" value='+json.content[i]+' disabled><img src="${pageContext.request.contextPath }/fyh/productPic/'+
		        			json.content[i]+'"  width="80" height="80">'); 
		        		}
		        		
		        	}
		        }
		    });  */
			
			$('#btn_save').click(function(){
				$('#status').val('4');
			});
			
			$('#btn_insert').click(function(){
				$('#status').val('2');
			});
			
			$('#btn_exit').click(function(){
				var lastAdvice = $("#lastAdvice").val();
				if(lastAdvice == ''){
					alert("请输入复审意见!");
					return false;
				}
				$('#status').val('5');
				return confirm('确定退回么?');
			});
			
			$('#btn_delete').click(function(){
				var lastAdvice = $("#lastAdvice").val();
				if(lastAdvice == ''){
					alert("请输入复审意见!");
					return false;
				}
				$('#status').val('-2');
				return confirm('确定取消么?');
			});
			
			$("#financeServiceFee").keyup(function(){
				if($("#financeServiceFee").val() !=''){
					var amount = parseFloat($("#amount").val());
					var financeServiceFee = parseFloat($("#financeServiceFee").val());
					$("#sfee").val(Math.floor(amount*financeServiceFee)/100);
				}
			});
			
			var frozenRd = $('.frozenRadio').attr('isFrozen');
			var frozenRd_num = $('.frozenRadio input').length;
			var frozenRd_arr = $('.frozenRadio input');
			for(var i=0;i<frozenRd_num;i++){
				if(frozenRd_arr[i].value == frozenRd){
					frozenRd_arr[i].checked = 'checked';
				}
			}
			
			var rd = $('.radioNmu').attr('radioid');
			var rd_num = $('.radioNmu input').length;
			var rd_arr = $('.radioNmu input');
			for(var i=0;i<rd_num;i++){
				if(rd_arr[i].value == rd){
					rd_arr[i].checked = 'checked';
				}
			}
			
			var rd2 = $('.radioNmu2').attr('radioid2');
			var rd_num2 = $('.radioNmu2 input').length;
			var rd_arr2 = $('.radioNmu2 input');
			for(var i=0;i<rd_num2;i++){
				if(rd_arr2[i].value == rd2){
					rd_arr2[i].checked = 'checked';
				}
			}
			
			var picRd = $('.proPic').attr('picradioid');
			var picRd_num = $('.proPic input').length;
			var picRd_arr = $('.proPic input');
			for(var i=0;i<picRd_num;i++){
				if(picRd_arr[i].value == picRd){
					picRd_arr[i].checked = 'checked';
				}

			}
			
			var endTime = '';
			$('#sTime').focus(function(){
				var startTime = new Date($("#sTime").val().substring(0,$("#sTime").val().indexOf(' ')).replace(/-/g,"/")).getTime();
				if($('#sTime').val().length!=0){
					endTime = new Date(Date.parse($('#dTime').val().replace(/-/g,"/"))).getTime();
					$('#period').val((endTime - startTime)/(1000*60*60*24));
				}
			});
		});
		
		function check(){
			var financeServiceFee = $("#financeServiceFee").val();
			var investMin = $("#investMin").val();
			var proAmount = $("#proAmount").val();
			var sTime = $("#sTime").val();
			var eTime = $("#eTime").val();
			var lastAdvice = $("#lastAdvice").val();
			var reg = new RegExp("^[0-9]+\.?[0-9]*$");
			if(!reg.test(financeServiceFee) || financeServiceFee == ''){  
		        alert("输入的融资服务费比例格式不正确!");
		        return false;
		    }
			if(!reg.test(investMin) || investMin == ''){  
		        alert("输入的起投金额格式不正确!");
		        return false;
		    }
			if(!reg.test(proAmount) || proAmount == ''){  
		        alert("输入的递投金额格式不正确!");
		        return false;
		    }
			if(sTime == ''){  
		        alert("请选择投资开始时间!");
		        return false;
		    }
			if(eTime == ''){  
		        alert("请选择投资结束时间!");
		        return false;
		    }
			if(lastAdvice == '' || lastAdvice.length >200 ){  
		        alert("输入的终审意见格式不正确！");
		        return false;
		    }
			return confirm('确定审核通过么?');
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
		<form action="${pageContext.request.contextPath }/loan/loanApply/update?isUpdate=0"
			id="updateForm" method="post">
			<input type="hidden" value="${loanApply.id }" name="id"
				type="text">
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<th colspan=4><center>
							<b>项目信息</b>
						</center></th>
				</tr>
				<input value="${loanApply.status }" name="status" type="hidden" id='status'>
				<tr>
					<td width="20%" class="tableleft">融资方名称：</td>
					<td width="30%"><select disabled>
							<option value="${loanApply.userId }">${borrower }</option>
					</select></td>
					<td width="20%" class="tableleft">项目名称：</td>
					<td width="30%"><input value="${loanApply.name }" type="text" placeholder="请输入项目名称" readonly></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">产品名称：</td>
					<td width="30%"><select class='loanType' disabled>
							<option value="${loanApply.loanType }">${loanType }</option>
					</select></td>
					<td width="20%" class="tableleft">募集金额：</td>
					<td width="30%"><input value="${loanApply.amount }" id="amount" type="text" placeholder="请输入募集金额" readonly>元</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">到期日：</td>
					<td width="30%"><input id="dTime" disabled type="text" value="${dueTime}" class="Wdate"  
			onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"></td>
					<td width="20%" class="tableleft">起息日：</td>
					<td>放款日</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">回款方式：</td>
					<td width="30%"><select disabled>
							<option value="${loanApply.paymentOptions }">${repayment }</option>
					</select></td>
					<td width="20%" class="tableleft">预期年化收益：</td>
					<td width="30%"><input value="${loanApply.apr }" type="text" placeholder="请输入预期年化收益" readonly><span>%</span></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">保障方：</td>
					<td width="30%"><select disabled>
							<option value="${loanApply.guaranteeCompanyId }">${guaranteeCompany }</option>
					</select></td>
					<td width="20%" class="tableleft">保障方式：</td>
					<td width="30%"><input value="${loanApply.guaranteeMode }" type="text"
						placeholder="请输入保障方式" readonly></td>
				</tr>
				<tr class="xandc">
					<td width="20%" class="tableleft">项目来源：</td>
					<td width="30%"><input value="${loanApply.projectSource }" type="text"
						placeholder="请输入项目来源" readonly></td>
					<td width="20%" class="tableleft">产品管理人：</td>
					<td width="30%"><input value="${loanApply.productManager }" type="text"
						placeholder="请输入产品管理人" readonly></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">是否冻结：</td>
					<td width="30%" class='frozenRadio' isFrozen=${loanApply.isFrozen}><input type="radio" value=0 disabled />是&nbsp;
						<input type="radio" value=1 disabled />否&nbsp; </td>
					<td width="20%" class="tableleft">基础资产：</td>
					<td width="30%"><select name="underlyAssets" disabled>
						<option value="${loanApply.underlyAssets }">${loanApply.underlyAssets }</option>
						<option value="小贷资产">小贷资产</option>
						<option value="保理资产">保理资产</option>
						<option value="融资租赁资产">融资租赁资产</option>
					</select></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">融资期限：</td>
					<td width="30%"><input readonly  id="period" name="period" value="${loanApply.period }">天</td>
					<td width="20%" class="tableleft contract" contract="${loanApply.contract }">合同附件：</td>
					<td width="30%" class="addFile"><span class="addFileTd"></span></td>
				</tr>
				<tr class = "beian">
					<td width="20%" class="tableleft">备案规模：</td>
					<td width="80%" colspan=3><input value="${loanApply.recordSize }" id="recordSize" name="recordSize" readonly>元</td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">项目描述：</td>
					<td width="30%" colspan=3><textarea rows="3" cols="20"
						 placeholder="请输入项目描述" readonly>${loanApply.description }</textarea></td>
				</tr>
				<tr class = "fenqi" style="display:none;">
					<td width="20%" class="tableleft">分期还款日：</td>
					<td width="30%"><input id="installdate" readonly name="installdate" type="text"  value="${loanApply.installmentDate}"></td>
			
					<td width="20%" class="tableleft">线下放款日期：</td>
					<td width="30%"><input id="lDate" name="lDate" disabled type="text"  value="${lDate }" class="Wdate"  
			onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"></td>
			</tr>
			<%-- <tr class = "qianding" style="display:none;">
					<td width="20%" class="tableleft">签订编号：</td>
					<td width="80%" colspan=3><input value="${loanApply.signedNumber }" id="signedNumber" name="signedNumber" readonly></td>
			</tr> --%>
				<!-- <tr>
					<td>标的图标：</td>
					<td colspan=3 class='proPic' picRadioid=${loanApply.url}></td>
				</tr> -->
			</table>
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<th colspan=4><center>
							<b>费用事项</b>
						</center></th>
				</tr>
				<tr>
					<td class="tableleft">收费项目</td>
					<td class="tableleft">收取比例</td>
					<td style="display:none" class="tableleft">金额</td>
					<td class="tableleft">收取方式</td>
				</tr>
				<tr>
					<td>融资服务费</td>
					<td><input value="${loanApply.financeServiceFee }" id="financeServiceFee" name="financeServiceFee" type="text"
						placeholder="请输入融资服务费比例">%</td>
					<td style="display:none"><input id="sfee" name="sfee" value="" readonly></td>
					<td><select name="">
							<option value="">放款时一次性收取</option>
							</select></td>
				</tr>
				<%-- <tr>
					<td width="30%">投资服务费</td>
					<td width="30%"><input value="${loanApply.investServiceFee }" id="investServiceFee" name="investServiceFee" type="text"
						placeholder="请输入投资服务费比例">%</td>
					<td width="40%"><select name="">
							<option value="">放款前一次性收取</option>
							</select></td>
				</tr> --%>
			</table>
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<th colspan=4><center>
							<b>发标设置</b>
						</center></th>
				</tr>
				<tr>
					<td width="20%">发送端：</td>
					<td width="30%" radioid=${loanApply.transmitted} class='radioNmu'><input checked="checked" name="transmitted" type="radio" value=0 />PC+APP&nbsp;
						<input name="transmitted" type="radio" value=1 />PC&nbsp; <input
						 name="transmitted" type="radio" value=2 />APP&nbsp;</td>
					<td width="20%">是否内部项目：</td>
					<td width="30%" radioid2=${loanApply.isInside} class='radioNmu2'><input checked="checked" name="isInside" type="radio" value=0 />否&nbsp;
						<input name="isInside" type="radio" value=1 />是</td>
				</tr>
				<tr>
					<td width="20%">起投金额：</td>
					<td width="30%"><input value="${loanApply.investMin }" id="investMin" name="investMin" type="text"
						placeholder="请输入起投金额">元</td>
					<td width="20%">递投金额：</td>
					<td width="30%"><input value="${loanApply.proAmount }" id="proAmount" name="proAmount" type="text"
						placeholder="请输入递投金额">元</td>
				</tr>
				<tr><td width="20%">投资开始时间：</td>
				<td width="30%"><input id="sTime" name="sTime" type="text" class="Wdate" value="${startTime }" 
			onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d',maxDate:'${dueTime}'})"></td>
					<td width="20%">投资结束时间：</td>
				<td width="30%"><input id="eTime" name="eTime" type="text" class="Wdate" value="${endTime }" 
			onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'sTime\')}',maxDate:'${dueTime}'})"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">初审意见：</td>
					<td width="30%" colspan=3><textarea rows="3" cols="20" readonly 
							placeholder="请输入审核意见">${loanApply.fristAdvice }</textarea></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">复审意见：</td>
					<td width="30%" colspan=3><textarea rows="3" cols="20"
							id="lastAdvice" name="lastAdvice" placeholder="请输入审核意见">${loanApply.lastAdvice }</textarea></td>
				</tr>
				<tr>
					<td colspan=4><button type="submit" class="btn btn-primary" id='btn_save'>保存</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="submit" class="btn btn-primary" id='btn_exit'>退回</button>
					<button type="submit" class="btn btn-primary" id='btn_delete'>取消</button>
							<button type="submit" onclick="return check()" class="btn btn-success" style="float:right" id='btn_insert' onClick="">审核通过</button></td>
				</tr>
			</table>
			<table class="table table-bordered table-hover definewidth m10">
				<tr>
					<th colspan=5><center>
							<b>审核记录</b>
						</center></th>
				</tr>
				<tr>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">审核时间</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">审核人</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">审核结果</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">审核意见</span></th>
					<th><span class="badge badge-info"
						style="font-size: 18px; margin-bottom: 10px;">审核环节</span></th>
				</tr>
				<c:forEach items="${auditRecordList }" var="auditRecord">
					<tr class="info">
						<td><date:date pattern="yyyy-MM-dd HH:mm" value="${auditRecord.auditTime }"></date:date></td>
						<td>${auditRecord.auditPerson }</td>
						<td>
						<c:choose>
						<c:when test="${auditRecord.auditResult == 1}">
						通过
						</c:when>
						<c:when test="${auditRecord.auditResult == 0}">
						退回
						</c:when>
						<c:otherwise></c:otherwise>
						</c:choose></td>
						<td>${auditRecord.auditAdvice }</td>
						<td>${auditRecord.auditLink }</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<br>
		</form>
	</div>
</body>
<script>
$(function(){
	var contract = $(".contract").attr('contract');
	if(contract!=''){
		var contractArr = contract.split(',');
		for(var i=0;i<contractArr.length;i++){
			var srces = contractArr[i];
			$('.addFileTd').append('<a href="'+globalUrl+srces+'">合同'+(i+1)+'</a>&nbsp;&nbsp;&nbsp;&nbsp;'); 
		}
	}
});
</script>
</html>