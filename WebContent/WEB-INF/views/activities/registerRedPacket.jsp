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
    <title>新手红包-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="富元汇，专注于供应链金融的P2C平台，年化收益高达10%~13%，拥有第三方资金托管的正规理财平台。提供百元起投的稳健理财产品，产品对接上市企业供应链项目，本息安全保障，随时稳定赎回。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <style type="text/css">
		.reg_packet_bg
		{
			width: 100%;
			height: 860px;
			background: url(../../static/images/activities/regPacketbg.png) no-repeat center;
		}
		.w1000
		{
			width: 1170px;
			height: 100%;
			margin:0 auto;
			position: relative;
		}
		.w1000 span
		{
			position: absolute;
			bottom: 21px;
			left:470px;
			font-size: 18px;
			color: #fff;
		}
		.red_packet_content
		{
			width: 100%;
			background:#f42c35;
			padding: 43px 0 191px 0;
		}
		.red_contentWidth
		{
			width: 1170px;
			margin:0 auto;
		}
		/*.red_content_list
		{
			height: 147px;
			padding-bottom: 81px;
		}*/
		.red_content_list li
		{
			width: 325px;
			height: 147px;
			background: url(../../static/images/activities/moneybg.png) no-repeat center;
			position: relative;
			margin-bottom: 57px;
		}
		.red_item01
		{
			margin:0 46px 0 50px;
		}
		.red_item02
		{
			margin-right: 46px;
		}
		.red_item04
		{
			margin:0 46px 0 230px;
		}
		.red_moneyBox
		{
			position: absolute;
		    left: 41px;
		    top: 58px;
		    color: #e2d376;
		    width: 82px;
		    height: 82px;
		}
		.red_money
		{
			font-size: 30px;
			text-align: center;
		}
		.red_money span
		{
			font-size: 12px;
		}
		.red_mTxt
		{
			font-size: 14px;
			margin-top: -4px;
			text-align: center;
		}
		.red_conditions
		{
			position: absolute;
			top: 29px;
			left: 174px;
			color: #ffd703;
			font-weight: bold;
		}
		.red_sTxt
		{
			font-size: 20px;
		}
		.red_condit_txt
		{
			font-size: 25px;
		}
		.red_money_num
		{
			position: absolute;
			bottom: 10px;
			left: 174px;
		}
		.red_money_num
		{
			position: absolute;
			left: 174px;
			bottom: 25px;
			font-size: 14px;
			color: #de0e1e;
			text-align: center;
		}
		.red_rule_content
		{
			font-size: 18px;
			color: #fff;
			margin-left: 130px;
		}
		.red_rule_content h3
		{
			margin-bottom: 25px;
			font-weight: normal;
			font-size: 18px;
		}
		.rule_contxt_box
		{
			line-height: 28px;
			font-size: 16px;
		}
		.last_txt
		{
			margin-top: 77px;
		}
    </style>
    
</head>
<body>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	<div class="reg_redpacket_wrap">
		<!-- banner Start -->
		<div class="reg_packet_bg">
			<div class="w1000">
				<span>活动日期：2017年6月5号起</span>
			</div>
		</div>
		<!-- banner End -->

		
		<div class="red_packet_content">
			<div class="red_contentWidth">
				<!--红包金额区域Start-->
				<ul class="red_content_list">
					<li class='fl red_item01'>
						<div class="red_moneyBox">
							<div class="red_money">28<span>元</span></div>
							<div class="red_mTxt">注册红包</div>
						</div>
						<div class="red_conditions">
							<div class="red_sTxt">红包无使用</div>
							<div class="red_condit_txt">金额限制</div>
						</div>
						<div class="red_money_num">无认购金额限制</div>
					</li>
					<li class='fl red_item02'>
						<div class="red_moneyBox">
							<div class="red_money">58<span>元</span></div>
							<div class="red_mTxt">注册红包</div>
						</div>
						<div class="red_conditions">
							<div class="red_sTxt">红包有使用</div>
							<div class="red_condit_txt">金额限制</div>
						</div>
						<div class="red_money_num">认购大于5000元可用</div>
					</li>
					<li class='fl red_item03'>
						<div class="red_moneyBox">
							<div class="red_money">88<span>元</span></div>
							<div class="red_mTxt">注册红包</div>
						</div>
						<div class="red_conditions">
							<div class="red_sTxt">红包有使用</div>
							<div class="red_condit_txt">金额限制</div>
						</div>
						<div class="red_money_num">认购大于10000元可用</div>
					</li>
					<li class='fl red_item04'>
						<div class="red_moneyBox">
							<div class="red_money">188<span>元</span></div>
							<div class="red_mTxt">注册红包</div>
						</div>
						<div class="red_conditions">
							<div class="red_sTxt">红包有使用</div>
							<div class="red_condit_txt">金额限制</div>
						</div>
						<div class="red_money_num">认购大于20000元可用</div>
					</li>
					<li class='fl red_item05'>
						<div class="red_moneyBox">
							<div class="red_money">288<span>元</span></div>
							<div class="red_mTxt">注册红包</div>
						</div>
						<div class="red_conditions">
							<div class="red_sTxt">红包有使用</div>
							<div class="red_condit_txt">金额限制</div>
						</div>
						<div class="red_money_num">认购大于50000元可用</div>
					</li>
				</ul>
				<div class="clear"></div>
				<!-- 红包金额区域End -->


				<!-- 活动规则区域Start -->
				<div class="red_rule_content">
					<h3>活动规则</h3>
					<div class="rule_contxt_box">
						<p>1、新手注册成功后，即可获得28元、58元、88元、188元和288元5个新手红包。</p>
						<p>2、新手红包有效期为2个月，只能在有效期内使用，过期无效。</p>
						<p>3、新手红包不可单独投资、不可直接提现，只能在认购产品时用于抵扣。</p>
						<p>4、用户每次认购产品只能使用1个红包。</p>
						<p>5、每个新手红包只能抵扣1次，且需1次抵扣完。</p>
						<p>6、新手红包抵扣产品回款成功后，即可用于提现或者认购新的产品。</p>
					</div>
					<div class="last_txt">* 本活动规则解释权归富元汇所有，如有疑问请拨打客服热线：4009-303-606</div>
				</div>

				<!-- 活动规则区域ENd -->


			</div>
			



		</div>
	</div>
	
	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>

	<!--JS部分  -->
	<script type="text/javascript">
		$(function(){
			var urls = window.location.pathname;
			if(urls == '/enterRegisterRedPacket'){
		        $('.site').removeClass('active');
    		}



		});

	</script>




</body>
</html>



