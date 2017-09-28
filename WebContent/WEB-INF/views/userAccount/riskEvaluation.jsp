<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/datetag.tld" prefix="date"%>
<!DOCTYPE html>
<html lang="en">
<head lang="zh-cn">
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>账户设置-风险测评-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/jquery.inputbox.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/securityinfos.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/jquery.inputbox.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/jquery.ganged.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/provinces.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/personalbasicinfos.js'></script>
	<script type="text/javascript" src='../../static/scripts/user/md5.js'></script>

	<style type="text/css">
		.per_rigBotContent_box h1
		{
			font-size: 20px;
			margin-bottom: 35px;
			text-align: center; 
		}
		.each_risk
		{
			margin-bottom: 20px;
			font-size: 16px;
			color: #474e5d;
			line-height: 26px;
		}
		.each_risk input
		{
			margin-left: -1px;
		}
		.each_risk input:hover
		{
			cursor: pointer;
		}
		.risk_btns
		{
			display: block;
			width: 136px;
			height: 38px;
			line-height: 38px;
			text-align: center;
			margin: 70px auto 0 auto;
			font-size: 14px;
			color: #fff;
			border-radius: 5px;
			background: #0bf;
			/*cursor: no-drop;*/
			cursor: pointer;
			outline: none;
			border:0;
		}
		.risk_window
		{
			position: fixed;
			top: 50%;
			left: 50%;
			padding: 35px 30px;
			width: 540px;
			height: 310px;
			border-radius: 12px;
			background: #fff;
			margin-left: -300px;
			margin-top: -190px;
			z-index: 101;
			display: none;
		}
		.risk_window h3
		{
			font-size: 20px;
			padding-bottom: 10px;
			border-bottom: 1px solid #e0e0e0;
		}
		.rkw_div
		{
			font-size: 18px;
			color: #474e5d;
			text-align: center;
			margin: 50px 0 26px 0;
		}
		#risk_result
		{
			color: #0bf;
		}
		.rk_window_txt
		{
			font-size: 16px;
			color: #474e5d;
			text-align: center;
			margin-bottom: 50px;
			line-height: 26px;
		}
		.rk_bth_group p
		{
			width: 100px;
			height: 38px;
			line-height: 38px;
			text-align: center;
			font-size: 14px;
			border-radius: 5px;
			cursor: pointer;
		}
		.again_btn 
		{	
			color: #0bf;
			border:1px solid #0bf;
			margin-left: 104px;
		}
		.rk_confirm
		{
			color: #fff;
			background: #0bf;
			margin-left: 128px;
		}
	</style>

</head>
<body>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	<!--  账户中心-->
	<div class="warp_account_center">
		<!-- 资产总览内容区域 -->
		<div class="user_account1000">
			<!-- 引入左边菜单导航栏 -->
			<%@ include file="leftMenu.jsp"%>
			<!-- 右边账户中心内容区域Start -->
			<div class="fl account_rightContent_box">
				<div class="acc_rigContent_name" style="height:24px;text-indent:-9999px;">个人基本信息</div>
				<!-- 内容盒子Start -->
				<div class="per_rigBotContent_box">
					<h1>富元汇风险测评</h1>
					<div class="risk_contentBox">
						<!-- 第一道题start -->
						<div class="first_title each_risk">
							<div class="riskTitle">1、您目前的人生阶段：</div>
							<input name="first" class="fifst_input" type="radio" value="1" />A、退休期（已退休）<br>
							<input name="first" class="fifst_input" type="radio" value="2" />B、退休前期（未退休，子女已参加工作）<br>
							<input name="first" class="fifst_input" type="radio" value="3" />C、家庭成长期（子女出生到完成大学教育）<br>
							<input name="first" class="fifst_input" type="radio" value="4" />D、家庭形成期（结婚到子女出生前）<br> 
							<input name="first" class="fifst_input" type="radio" value="5" />E、单身期: (独身，无子女) 
						</div>

						<!-- 第二道题start -->
						<div class="two_title each_risk">
							<div class="riskTitle">2、您投资的目的是：</div>
							<input name="two" class="two_input" type="radio" value="1" />A、资产保值，我不愿意承担任何投资风险<br>       
							<input name="two" class="two_input" type="radio" value="2" />B、资产在保值的基础上，有小幅增长，我可以承担较低的投资风险 <br>    
							<input name="two" class="two_input" type="radio" value="3" />C、资产稳健增长，我可以承担一定的投资风险<br>   
							<input name="two" class="two_input" type="radio" value="4" />D、资产迅速增长，我愿意承担很大的投资风险  
						</div>

						<!-- 第三道题start -->
						<div class="three_title each_risk">
							<div class="riskTitle">3、您的家庭年收入为（折合人民币）？</div>
							<input name="three" class="three_input" type="radio" value="1" />A、10万元以下 <br>
							<input name="three" class="three_input" type="radio" value="2" />B、10-50万元 <br>    
							<input name="three" class="three_input" type="radio" value="3" />C、50-100万元 <br>   
							<input name="three" class="three_input" type="radio" value="4" />D、100-500万元 <br>
							<input name="three" class="three_input" type="radio" value="5" />E、500万元以上  
						</div>

						<!-- 第四道题start -->
						<div class="four_title each_risk">
							<div class="riskTitle">4、在您每年的家庭收入中，可用于金融投资的比例为？</div>
							<input name="four" class="four_input" type="radio" value="1" />A、小于10%  <br>    
							<input name="four" class="four_input" type="radio" value="2" />B、10%至25% <br>     
							<input name="four" class="four_input" type="radio" value="3" />C、25%至50% <br>    
							<input name="four" class="four_input" type="radio" value="4" />D、大于50%   
						</div>

						<!-- 第五道题start -->
						<div class="five_title each_risk">
							<div class="riskTitle">5、您期望的投资理财期限是：</div>
							<input name="five" class="five_input" type="radio" value="1" />A、6个月以下 <br>
							<input name="five" class="five_input" type="radio" value="2" />B、6个月-1年 <br>    
							<input name="five" class="five_input" type="radio" value="3" />C、1-3年<br>    
							<input name="five" class="five_input" type="radio" value="4" />D、3-5年<br> 
							<input name="five" class="five_input" type="radio" value="5" />E、5年以上  
						</div>

						<!-- 第六道题start -->
						<div class="six_title each_risk">
							<div class="riskTitle">6、您当前期望的投资理财收益大概是多少？</div>
							<input name="six" class="six_input" type="radio" value="1" />A、5%以内<br> 
							<input name="six" class="six_input" type="radio" value="2" />B、5%-10%<br>      
							<input name="six" class="six_input" type="radio" value="3" />C、10-20%<br>   
							<input name="six" class="six_input" type="radio" value="4" />D、20%-50%<br> 
							<input name="six" class="six_input" type="radio" value="5" />E、50%以上  
						</div>

						<!-- 第七道题start -->
						<div class="seven_title each_risk">
							<div class="riskTitle">7、以下哪项最能说明您的投资经验：</div>
							<input name="seven" class="seven_input" type="radio" value="1" />A、除存款、国债外，我几乎不投资其他金融产品<br>    
							<input name="seven" class="seven_input" type="radio" value="2" />B、大部分投资于存款、国债等，较少投资于股票、基金、P2P等风险产品<br>      
							<input name="seven" class="seven_input" type="radio" value="3" />C、资产均衡地分布于存款、国债、银行理财产品、信托产品、股票、基金、P2P等<br>     
							<input name="seven" class="seven_input" type="radio" value="4" />D、大部分投资于股票、基金、P2P、外汇等高风险产品，较少投资于存款、国债  
						</div>

						<!-- 第八道题start -->
						<div class="eight_title each_risk">
							<div class="riskTitle">8、您对理财产品的看法是：</div>
							<input name="eight" class="eight_input" type="radio" value="1" />A、理财产品无风险，类似存款<br>      
							<input name="eight" class="eight_input" type="radio" value="2" />B、理财产品应当保本，但收益不确定<br>      
							<input name="eight" class="eight_input" type="radio" value="3" />C、理财产品本金可能产生少量损失<br>     
							<input name="eight" class="eight_input" type="radio" value="4" />D、理财产品可能大幅亏损，应当仔细选择    
						</div>


						<!-- 第九道题start -->
						<div class="nine_title each_risk">
							<div class="riskTitle">9、如果您打算用部分资金做风险投资，投资A预期获得10%的收益，可能损失非常小；投资B预期获得30%的收益，但可能承担较大亏损。您会如何投资？</div>
							<input name="nine" class="nine_input" type="radio" value="1" />A、全部投资于收益较小且风险较小的A <br>
							<input name="nine" class="nine_input" type="radio" value="2" />B、同时投资于A和B，但大部分资金投资于收益较小且风险较小的A <br>     
							<input name="nine" class="nine_input" type="radio" value="3" />C、同时投资于A和B，且两种资产各占一半<br>    
							<input name="nine" class="nine_input" type="radio" value="4" />D、同时投资于A和B，但大部分资金投资于收益较大且风险较大的B<br>
							<input name="nine" class="nine_input" type="radio" value="5" />E、全部投资于收益较大且风险较大的B  
						</div>


						<!-- 第十道题start -->
						<div class="ten_title each_risk">
							<div class="riskTitle">10、除金融产品外，以下哪种资产状况符合您的实际情况。</div>
							<input name="ten" class="ten_input" type="radio" value="1" />A、有自有住房和私家车<br>     
							<input name="ten" class="ten_input" type="radio" value="2" />B、无自有住房，有私家车<br>      
							<input name="ten" class="ten_input" type="radio" value="3" />C、有自有住房，无私家车<br>     
							<input name="ten" class="ten_input" type="radio" value="4" />D、无自有住房和私家车    
						</div>

					</div>

					<!-- 提交按钮 -->
					<button class="risk_btns">提交</button>

				</div>
				<!-- 内容盒子End -->
			</div>
			<!-- 右边账户中心内容区域End -->
			<div class="clear"></div>
		</div>


		
	</div>


	
	<!-- 风险测评结果弹窗Start -->
	<div class="risk_window">
		<h3>风险测评结果</h3>
		<div class="rkw_div">您的风险测评结果：<span id="risk_result">保守型</span></div>
		<div class="rk_window_txt">
			根据测评结果，您能清晰地意识到风险，可以承受中度投资风险，愿意为获取较高收益而承担一定的损失。
		</div>
		<div class="rk_bth_group">
			<p class="again_btn fl">重新测评</p>
			<p class="fl rk_confirm">确认</p>
			<div class="clear"></div>
		</div>
	</div>


	<!-- 错误提示弹窗 -->
	<div class="one_contxt_window">
		<div class="error_txts"></div>
		<div class="error_btns">确认</div>
	</div>
	







		
	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>
</body>
</html>




<script type="text/javascript">
	$(function(){
		var totalScore=0;//总分数
		var firstScore = 0;
		$('.first_title input').each(function(){
			$(this).click(function(){
				firstScore = parseFloat($(this).val());
			});
		});
		var towScore = 0;
		$('.two_title input').each(function(){
			$(this).click(function(){
				towScore = parseFloat($(this).val());
			});
		});
		var threeScore = 0;
		$('.three_title input').each(function(){
			$(this).click(function(){
				threeScore = parseFloat($(this).val());
			});
		});
		var fourScore = 0;
		$('.four_title input').each(function(){
			$(this).click(function(){
				fourScore = parseFloat($(this).val());
			});
		});
		var fiveScore = 0;
		$('.five_title input').each(function(){
			$(this).click(function(){
				fiveScore = parseFloat($(this).val());
			});
		});
		var sixScore = 0;
		$('.six_title input').each(function(){
			$(this).click(function(){
				sixScore = parseFloat($(this).val());
			});
		});
		var sevenScore = 0;
		$('.seven_title input').each(function(){
			$(this).click(function(){
				sevenScore = parseFloat($(this).val());
			});
		});
		var eightScore = 0;
		$('.eight_title input').each(function(){
			$(this).click(function(){
				eightScore = parseFloat($(this).val());
			});
		});
		var nineScore = 0;
		$('.nine_title input').each(function(){
			$(this).click(function(){
				nineScore = parseFloat($(this).val());
			});
		});
		var tenScore = 0;
		$('.ten_title input').each(function(){
			$(this).click(function(){
				tenScore = parseFloat($(this).val());
			});
		});


		


		
		// 当点击提交按钮时触发
		$('.risk_btns').click(function(){
			var ipLenght = $("input:checked").length;//判断用户是否全部把题选完
			totalScore = firstScore+towScore+threeScore+fourScore+fiveScore+sixScore+sevenScore+eightScore+nineScore+tenScore;
			var rk_rtTxt = '';//风险等级
			var rk_rtContxt = '';//风险等级内容

			if(totalScore>9&&totalScore<17){
				rk_rtTxt = '保守型';
				rk_rtContxt = '根据测评结果，您对风险非常敏感，十分关注本金安全，可能放弃因承受风险而带来的收益。';
			}else if(totalScore>16&&totalScore<24){
				rk_rtTxt = '稳健型';
				rk_rtContxt = '根据测评结果，您对风险有一定的认识，愿意承受轻度投资风险，可以接受收益小幅波动。';
			}else if(totalScore>23&&totalScore<31){
				rk_rtTxt = '平衡型';
				rk_rtContxt = '根据测评结果，您能清晰地意识到风险，可以承受中度投资风险，愿意为获取较高收益而承担一定的损失。';
			}else if(totalScore>30&&totalScore<38){
				rk_rtTxt = '成长型';
				rk_rtContxt = '根据测评结果，您能清晰地意识到风险，可以承受中度投资风险，愿意为获取较高收益而承担一定损失。';
			}else if(totalScore>37){
				rk_rtTxt = '进取型';
				rk_rtContxt = '根据测评结果，您能充分认识风险与收益的关系，愿意主动承担投资风险，并寻求资产快速增值。';
			}
			if(ipLenght==10){
				// $(".risk_btns").removeAttr("disabled").css('background','#0bf').css('cursor','pointer');//启用按钮
				$('body').append('<div id="fuyhui_fade"></div>');
				$('.risk_window').show(800);
				$('#risk_result').html(rk_rtTxt);
				$('.rk_window_txt').html(rk_rtContxt);
				//点击'重新测评'按钮时触发
				$('.again_btn').click(function(){
					againFunction();
				});
				$('.rk_confirm').click(function(){
					$.ajax({
						type:'post',
						url:getContextPaths()+'/user/updateAssessmentResult',
						dataType:'json',
						data:{
							assessmentResult:rk_rtTxt
						},
						success:function(json){
							if(json.flag==1){
								//点击'确认'按钮时触发
								rkconfirmFunciton();
							}else{
								errorWindow('提交失败！');
							}
						}
					});	
				});

			}else{
				// $(".risk_btns").attr("disabled",'disabled').css('background','#c1c1c1').css('cursor','no-drop');
				errorWindow('请完成所有选项才能提交！');
			}
			


			

		});


		




	});

var rk_id='';
if(window.location.search.indexOf("?")!= -1){
	rk_id = window.location.search.substring((window.location.search.indexOf("=")+1));
}


//点击'重新测评'按钮时调用
function againFunction(){
	$('#fuyhui_fade').remove();
	$('.risk_window').hide(800);
	// window.history.go(0);
	location.reload(true);
}


//点击'确认'按钮时调用
function rkconfirmFunciton(){
	if(rk_id==1){
		window.location.href = getContextPaths()+'/myAccount/enterPersonalinfos';
	}else{
		window.location.href = getContextPaths()+'/invest/enterInvestDetail?id='+rk_id;
	}
	
}
	
	
</script>
