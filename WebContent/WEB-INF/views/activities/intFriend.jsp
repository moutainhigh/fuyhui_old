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
    <title>邀请好友-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <style type="text/css">
		.ivt_top_bg
		{
			width: 100%;
			height: 760px;
			background: url(../../static/images/activities/ivt_top_bg.png) no-repeat center;
		}
		.ivt_content_body
		{
			width: 100%;
			height: 722px;
			background: #396EA2;
			padding-bottom: 152px;
		}
		.ivt_content_w1000
		{
			width: 1082px;
			margin: 0 auto;
		}
		.ivt_style_bg
		{
			width: 504px;
			height: 106px;
			background: url(../../static/images/activities/ivt04.png) no-repeat center;
			margin: 0 auto 24px auto;
		}
		.ivt_list
		{
			position: relative;
			height: 464px;
		}
		.ivt_list li
		{
			float: left;
		}
		.ivt_item01
		{
			position: absolute;
			top: 0;
			left: 0;
		}
		.ivt_item01_bg
		{
			width: 383px;
			height: 376px;
			background: url(../../static/images/activities/ivt01.png) no-repeat center;
		}
		.ivt_item02
		{
			position: absolute;
			top: -18px;
    		left: 342px;
		}
		.ivt_item02_bg
		{
			width: 426px;
			height: 394px;
			background: url(../../static/images/activities/ivt02.png) no-repeat center;
		}
		.ivt_item03
		{
			position: absolute;
			top: -10px;
			right: 0;
		}
		.ivt_item03_bg
		{
			width: 383px;
			height: 376px;
			background: url(../../static/images/activities/ivt03.png) no-repeat center;
		}
		.item_txt
		{
			font-size: 20px;
			color: #fff;
			line-height: 32px;
			text-align: center;
			margin-top: 12px;
		}
		.ivt_btns
		{
			width: 514px;
			height: 88px;
			text-indent: -9999px;
			margin: 40px auto 0 auto;
			background: url(../../static/images/activities/ivt_btn.png) no-repeat center;
			cursor: pointer;
		}
		.ivt_rule_body
		{
			width: 100%;
			background: #396EA2;
			padding-bottom: 68px;
		}
		.ivt_rule_w1000
		{
			width: 964px;
			height: 876px;
			margin: 0 auto;
			background: url(../../static/images/activities/ivt_content_bg.png) no-repeat center;
		}
		.ivt_ruleContents
		{
			width: 810px;
			margin:0 auto;
			padding-top: 177px;
			font-size: 16px;
			color: #396ea2;
		}
		.ivt_ruleContents p
		{
			line-height: 40px;
		}
		.tabs
		{
			margin-left: 38px;
			margin-bottom: 40px;
		}
		.tabs_list li
		{
			float: left;
			width: 311px;
			height: 57px;
			line-height: 57px;
			text-align: center;
			border-left:1px solid #76c1ff;
			border-right:1px solid #76c1ff;
			border-bottom:1px solid #76c1ff;
			border-top:none;
		}
		.tabs_list_item01,.tabs_list_item02
		{
			border-left: none;
			border-right: none;
			border-bottom:none;
			background: #76c1ff;
			color:#fff;
		}
		.tabs_list_item03,.tabs_list_item05,.tabs_list_item07
		{
			border-left:1px solid #76c1ff;
			border-right:1px solid #76c1ff;
			border-bottom:1px solid #76c1ff;
		}
		.tabs_list_item04,.tabs_list_item06,.tabs_list_item08
		{
			border-right:1px solid #76c1ff;
			border-bottom:1px solid #76c1ff;
		}
    </style>
    
</head>
<body>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	<div class="ivt_top_bg"></div>

	<div class="ivt_content_body">
		<div class="ivt_content_w1000">
			<div class="ivt_style_bg"></div>
			<ul class="ivt_list">
				<li class="ivt_item01">
					<div class="ivt_item01_bg"></div>
					<div class="item_txt">分享专属链接或<br>邀请码给好友</div>
				</li>
				<li class="ivt_item02">
					<div class="ivt_item02_bg"></div>
					<div class="item_txt">好友注册成功</div>
				</li>
				<li class="ivt_item03">
					<div class="ivt_item03_bg"></div>
					<div class="item_txt" style="margin-top:24px;">好友首次成功认购您即可<br>获得相应奖励金额 </div>
				</li>
			</ul>
			<div class="clear"></div>
			<div class="ivt_btns" onclick="window.location.href=getContextPaths()+'/myAccount/enterInvitefriend'">立即邀请</div>
		</div>
	</div>


	<!-- 邀请规则Start -->
	<div class="ivt_rule_body">
		<div class="ivt_rule_w1000">
			<div class="ivt_ruleContents">
				<p>1、邀请人可通过专属邀请码或链接邀请好友进行注册。</p>
				<p>2、邀请好友获取奖励的有效期为三个月，被邀请人注册后在有效期内首次成功认购产品，且邀请人先于被邀请人成功认购产品，邀请人即可获得现金奖励。</p>
				<p style="margin:0 0 16px 38px;"> 首次成功认购金额对应奖励金额如下:</p>
				<div class="tabs">
					<ul class="tabs_list">
						<li class="tabs_list_item01" style="margin-right:1px;">首次成功认购金额</li>
						<li class="tabs_list_item02">奖励金额</li>
						<li class="tabs_list_item tabs_list_item03">10,000以下</li>
						<li class="tabs_list_item tabs_list_item04">¥18</li>
						<li class="tabs_list_item tabs_list_item05">10,000-19,999</li>
						<li class="tabs_list_item tabs_list_item06">¥28</li>
						<li class="tabs_list_item tabs_list_item07">20,000-49,999</li>
						<li class="tabs_list_item tabs_list_item08">¥58</li>
						<li class="tabs_list_item tabs_list_item09">50000及以上</li>
						<li class="tabs_list_item tabs_list_item10">¥128</li>
					</ul>
					<div class="clear"></div>
				</div>
				<p>3、奖励资金将在被邀请人首次认购成功当天发放至邀请人账户，奖励资金可用于认购产品或者提现。</p>
				<p>4、邀请人邀请奖励次数不受限制。</p>
				<p>5、本活动法律允许范围内的最终解释权归富元汇平台所有。</p>
			</div>
		</div>
	</div>
	<!-- 邀请规则end -->



	











	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>

	<!--JS部分  -->
	<script type="text/javascript">
		$(function(){
			var urls = window.location.pathname;
			if(urls == '/enterIntFriend'){
		        $('.site').removeClass('active');
    		}



		});

	</script>




</body>
</html>



