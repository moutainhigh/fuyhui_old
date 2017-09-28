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
<script type="text/javascript" src="${pageContext.request.contextPath }/static/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function get_unix_time(dateStr){
	    var newstr = dateStr.replace(/-/g,'/'); 
	    var date =  new Date(newstr); 
	    var time_str = date.getTime().toString();
	    return time_str.substr(0, 10);
	}
	$(function(){
		// 限投产品全选,全不选
		$('#product_check_all').on('click',function(){
		    if(this.checked){ 
		    	$("input[name='limitProduct']").each(function(){this.checked=true;}); 
		    }else{ 
		    	$("input[name='limitProduct']").each(function(){this.checked=false;}); 
		    }
		}); 
		// 限投产品选择和取消选择
		$("input[name='limitProduct']").each(function(){
			$(this).click(function(){
				var allLength = $("input[name='limitProduct']").length;
	            var selectedLength = $("input[name='limitProduct']:checked").length;
	            if(allLength == selectedLength){
	            	$('#product_check_all').prop("checked",true);
                }else{
                    $('#product_check_all').prop("checked",false);
                }
	        });
		});
		// 限投资期限全选,全不选
		$('#term_check_all').on('click',function(){
		    if(this.checked){ 
		    	$("input[name='limitTerm']").each(function(){this.checked=true;}); 
		    }else{ 
		    	$("input[name='limitTerm']").each(function(){this.checked=false;}); 
		    }
		}); 
		// 限投资期限选择和取消选择
		$("input[name='limitTerm']").each(function(){
			$(this).click(function(){
				var allLength = $("input[name='limitTerm']").length;
	            var selectedLength = $("input[name='limitTerm']:checked").length;
	            if(allLength == selectedLength){
	            	$('#term_check_all').prop("checked",true);
                }else{
                    $('#term_check_all').prop("checked",false);
                }
	        });
		});
	});	
	
	function add(){
		var theme = $("#theme").val();
		var term = $("#term").val();
		var startTimeStr = $("#startTime").val();
		var endTimeStr = $("#endTime").val();
		var startTime = get_unix_time(startTimeStr);
		var endTime = get_unix_time(endTimeStr);
		var amount = $("#amount").val();
		var minAmount = $("#minAmount").val();
		var type = $("#type").val();
		var origin = $("#origin").val();
		var limitProduct = '';
		var limitTerm = '';
		if(theme ==''){
			alert("请输入活动主题");
			return false;
		}
		if(startTime ==''){
			alert("请选择开始时间");
			return false;
		}
		if(endTime ==''){
			alert("请选择结束时间");
			return false;
		}
		if(amount ==''){
			alert("输入红包金额");
			return false;
		}
		if(term ==''){
			alert("请输入投资期限");
			return false;
		}
		if(minAmount ==''){
			alert("请输入最小投资金额");
			return false;
		}
		if(type ==''){
			alert("请选择红包类型");
			return false;
		}
		if(origin ==''){
			alert("请选择发放方式");
			return false;
		}
		/*
		$('input[name="limitProduct"]:checked').each(function(){ 
			limitProduct+=$(this).val()+',';
		}); 
		$('input[name="limitTerm"]:checked').each(function(){ 
			limitTerm+=$(this).val()+','; 
		});
		*/
		$.ajax({
	    	type: 'POST',
	        url : getContextPaths()+"/award/addAwardType",
	        data : {
	        	theme : theme,
	        	term : term,
	        	startTime : startTime,
	        	endTime : endTime,
	        	amount : amount,
	        	minAmount : minAmount,
	        	type : type,
	        	origin : origin
	        },
	        success : function(jsondata){
	            if(jsondata != undefined || jsondata != null){
	                if(jsondata.flag == "1"){
	                    alert("添加红包成功");
	                }else{
	                	alert("添加红包失败");
	                }
	                window.location.href = getContextPaths()+'/award/awardTypeIndex';
	            }
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
			<table class="table table-bordered table-hover definewidth m10">
				<tr><th colspan=2><center><b>活动内容</b></center></th></tr>
				<tr>
					<td width="20%" class="tableleft">活动主题：</td>
					<td><input value="" id="theme" name="theme" type="text" placeholder="20字以内"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">活动时间：</td>
					<td><input id="startTime" name="startTime" type="text" placeholder="开始时间" class="Wdate"
					onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:'false',minDate:'%y-%M-%d'})">
		   ~~<input id="endTime" name="endTime" type="text" placeholder="结束时间" class="Wdate"
					onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}',maxDate:new Date()})"></td>
				</tr>
<!-- 				<tr>
					<td width="20%" class="tableleft">活动对象：</td>
					<td><select id="activeObject" name="activeObject">
					<option value="">所有人</option>
					<option value="1">对象1</option>
					<option value="2">对象2</option>
					</select></td>
				</tr> -->
				<tr>
					<td width="20%" class="tableleft">红包类型：</td>
					<td><select id="type" name="type">
					<option value="1">红包</option>
					</select></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">发放方式：</td>
					<td><select id="origin" name="origin">
					<option value="1">注册红包发放</option>
					</select></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">红包金额：</td>
					<td><input value="" id="amount" name="amount" type="text" placeholder="请输入红包金额"></td>
				</tr>
				<tr>
					<td width="20%" class="tableleft">有效期：</td>
					<td><input value="" id="term" name="term" type="text" placeholder="请输入红包有效期">天</td>
				</tr>
				<tr><th colspan=2><center><b>使用条件</b></center></th></tr>
				<tr>
					<td width="20%" class="tableleft">最小投资金额：</td>
					<td><input value="" id="minAmount" name="minAmount" type="text" placeholder="请输入最小投资金额">元</td>
				</tr>
<!-- 				<tr>
					<td width="20%" class="tableleft">限投产品：</td>
					<td><input type="checkbox" value="" id="product_check_all">全部产品&nbsp;&nbsp;
					<input type="checkbox" name="limitProduct" value="1">富薪贷&nbsp;&nbsp;
					<input type="checkbox" name="limitProduct" value="2">富车贷</td>
				</tr> -->
				
<!-- 				<tr>
					<td width="20%" class="tableleft">限投资期限：</td>
					<td><input type="checkbox" id="term_check_all" value="0">全部期限
					<input type="checkbox" name="limitTerm" value="3">3&nbsp;&nbsp;
					<input type="checkbox" name="limitTerm" value="6">6&nbsp;&nbsp;
					<input type="checkbox" name="limitTerm" value="12">12&nbsp;&nbsp;
					<input type="checkbox" name="limitTerm" value="24">24</td>
				</tr> -->
				
				<tr>
					<td colspan=2><button onclick="add()" 
							class="btn btn-primary">添加</button>
					<a href="${pageContext.request.contextPath }/award/awardTypeIndex" class="btn btn-success" style="float:right">返回</a></td>
				</tr>
			</table>
	</div>
</body>
</html>