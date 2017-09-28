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
    <title>提现-账户中心-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富之富，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/witrecharge.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/witrecharge.js'></script>
</head>
<body>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	<!--  账户中心-->
	<div class="warp_account_center">
		<!-- 资产总览内容区域 -->
		<div class="user_account1000">
			<!-- 引入左边菜单导航栏 -->
			<%@ include file="borrowerMenu.jsp"%>
			<!-- 右边账户中心内容区域Start -->
			<div class="fl account_rightContent_box">
				<div class="acc_rigContent_name" style="height:26px;text-indent:-9999px;">提现</div>
				<!-- 内容盒子Start -->
				<div class="wit_rigBotContent_box">
					<div class="tup_up_area">
						<div id="wit_content">
							<!-- 未开通托管账户时显示此部分内容 -->
							<c:if test="${empty userAccountInfo.capAcntNo}">
							<div class="wit_bank_increment" style="padding-top:93px;">
								<p class="fl">银行卡号</p>
								<div class="fl open_accmount" onclick="window.location.href=getContextPaths()+'/myAccount/enterEscrowAccount'">+&nbsp;&nbsp;绑定银行卡</div>
								<div class="clear"></div>
							</div>
							</c:if>	
							<!-- 已开通托管账户时显示此部分内容 -->
							<c:if test="${not empty userAccountInfo.capAcntNo}">
							<div class='witBank' style="padding-top:93px;">
								<div class="witBind_bank_top">
									<div class="fl com_bank_icon"></div>
									<div class="fl witbank_title" bankCode = ${userAccountInfo.parent_bank_id}>${bankName }</div>
									<div class="fl bank_hr"></div>
									<div class="fl witbank_infose">
										<p class="witbank_ids">${userAccountInfo.capAcntNo }</p>
										<p class="witbank_id_name">${userAccountInfo.realname }</p>
									</div>
									<div class="fl bank_right"></div>
									<div class="clear"></div>
								</div>
							</div>
							</c:if>
                          <form action="${pageContext.request.contextPath }/account/withdrawal" method="post">
							<div class="witbind_bank_box">
								<div class="eb_balance" style="margin: 50px 0 38px 0;">
									<span>可用余额</span>
									<span class='eb_balance_amount avumoney' ams='${userAccountamt }'>${userAccountamt }</span>
									<span style='color:#ff5353;'>元</span>
								</div>
								<div class="relbind_bank_bot">
									<p class="fl">提现金额</p>
									<input type="text" name='amt' class="fl withdrawal_amount" id="withdrawal_amount" placeholder='请输入100元以上的金额' onkeyup="clearNoNum(this)">
									<div class="fl bot_infos">
										<span class='wit_fee' ebformulaType =${formulaType}>手续费</span>
										<span class='wit_cost' ebinterestRate=${interestRate}>0</span>
										<span class='wit_fees' style='color:#ff5353;' ebfee=${fee}>元</span>
									</div>
									<div class="clear"></div>
								</div>
								<div class="wit_error"></div>

								<div class="relbind_bank_middle">
									<span>到账金额</span>
									<span class='bank_balance'>0</span>
									<span style='color:#ff5353;'>元</span>
								</div>

								<div class="confirm_withdrawal" ><input type="submit" id='wit_input' value="确认提现"></div>

							</div>
							</form>
						</div>

						<!-- 温馨提示内容 -->
						<div class="bank_comment_box">
							<h3>温馨提示</h3>
							<div class="bank_txtes">
								<p class="bank_txt_item">
									1、为了您的账户安全，请在提现前进行身份认证、手机绑定以及提现密码设置。 
								</p>
								<p class="bank_txt_item">
									2、您的账户资金将由第三方托管平台管理。 
								</p>
								<p class="bank_txt_item">
									3、请注意您的银行卡充值限制，以免造成不便。 
								</p>
								<p class="bank_txt_item">
									4、禁止洗钱、信用卡套现、虚假交易等行为，一经发现并确认，将终止该账户的使用。 
								</p>
								<p class="bank_txt_item">
									5、如果充值金额没有及时到账，请联系客服：4009-303-606 
								</p>
							</div>
						</div>
					</div>
				</div>
				<!-- 内容盒子End -->
			</div>
			<!-- 右边账户中心内容区域End -->
			<div class="clear"></div>
		</div>


		
	</div>
		
	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>
</body>
</html>

<script type="text/javascript">
	$(function(){
		// 提现页面的银行code
	    var witre_code = parseFloat($('.witbank_title').attr('bankCode')); 
	    // 根据不同的银行显示不同的icon图片
	    if(witre_code == 102){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/gongshang.png) no-repeat center'
	        });
	    }else if(witre_code == 103){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/nonghang.png) no-repeat center'
	        });
	    }else if(witre_code == 104){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/zhonghang.png) no-repeat center'
	        });
	    }else if(witre_code == 105){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/jianhang.png) no-repeat center'
	        });
	    }else if(witre_code == 301){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/jiaohang.png) no-repeat center'
	        });
	    }else if(witre_code == 302){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/zhongxin.png) no-repeat center'
	        });
	    }else if(witre_code == 303){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/guangda.png) no-repeat center'
	        });
	    }else if(witre_code == 304){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/huaxia.png) no-repeat center'
	        });
	    }else if(witre_code == 305){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/mingsheng.png) no-repeat center'
	        });
	    }else if(witre_code == 306){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/guangfa.png) no-repeat center'
	        });
	    }else if(witre_code == 307){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/pingan.png) no-repeat center'
	        });
	    }else if(witre_code == 308){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/zhaohang.png) no-repeat center'
	        });
	    }else if(witre_code == 309){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/xingye.png) no-repeat center'
	        });
	    }else if(witre_code == 310){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/pufa.png) no-repeat center'
	        });
	    }else if(witre_code == 319){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/weishang.png) no-repeat center'
	        });
	    }else if(witre_code == 313){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/otherhang.png) no-repeat center'
	        });
	    }else if(witre_code == 314){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/otherhang.png) no-repeat center'
	        });
	    }else if(witre_code == 315){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/henghang.png) no-repeat center'
	        });
	    }


	    // 获取提现收费类型
	    var ebfee_type = $('.wit_fee').attr('ebformulatype');
	    // 固定的手续费
	    var ebfees = $('.wit_fees').attr('ebfee');
	    // 手续费的比例
	    var ebhand_rate = $('.wit_cost').attr('ebinterestrate');

	    if(ebfee_type==1){
	        $('#withdrawal_amount').keyup(function(){
	        	if($(this).val()){
	        		var money = $(this).val()*ebhand_rate;
		            $('.wit_cost').html(round2(money,2));
		            // 到账金额计算
				    var txmoney = $('.withdrawal_amount').val();
				    var handmoney = $('.wit_cost').html();
				    $('.bank_balance').html(round2((txmoney - handmoney),2));
				    //若提现金额小于等于手续费，则到账金额显示为0
				    if(Number(txmoney)<=Number(handmoney)){
				    	$('.bank_balance').html('0');
				    }
				}else{
					$('.wit_cost').html('0');
					$('.bank_balance').html('0');
				}
	        });
	    }else if(ebfee_type==2){
	        $('#withdrawal_amount').keyup(function(){
	            if($(this).val()){
	            	$('.wit_cost').html(ebfees);
		            // 到账金额计算
				    var txmoney = $('.withdrawal_amount').val();
				    var sxf = $('.wit_cost').html();
				    $('.bank_balance').html(round2((txmoney-sxf),2));
				    //若提现金额小于等于手续费，则到账金额显示为0
				    if(Number(txmoney)<=Number(sxf)){
				    	$('.bank_balance').html('0');
				    }
	            }else{
	            	$('.wit_cost').html('0');
	            	$('.bank_balance').html('0');
	            }
	        });
	    }

	    $('.avumoney').html(formatMoney($('.avumoney').text(),2));




	});

</script>



