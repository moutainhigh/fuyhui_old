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
    <title>人脉优益计划-富元汇</title>
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
		.reg_redpacket_wrap
		{
			width: 100%;
			height: 520px;
			background: url(../../static/images/activities/contacts01.jpg) no-repeat center;
		}
		.con_contents
		{
			width: 100%;
			padding: 14px 0 150px 0;
			background: #eb0041;
		}
		.con_1000
		{
			width: 755px;
			margin: 0 auto;
		}
		.con_body
		{
			font-size: 14px;
			color: #fff;
			line-height: 24px;
		}
		.con_img02
		{
			width: 609px;
			height: 441px;
			margin: 60px auto;
			background: url(../../static/images/activities/con02.png) no-repeat center; 
		}
    </style>
    
</head>
<body>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	<div class="reg_redpacket_wrap"></div>
	<div class="con_contents">
		<div class="con_1000">
			<div class="con_body">
				<p>你还在说朋友多，到哪拉屎都有人给你送纸？</p>
				<p>为帮助富元汇平台投资人人脉变现，富元汇平台推出“人脉+“优益计划，该计划可帮助投资人在获得投资利息收益之外，</p>
				<p>本人+好友投资累积满相应数目还可再获最高180元/月的组团额外收益。</p>
				<div class="con_img02"></div>
				<p>1、邀请人可通过专属邀请码或链接邀请好友进行注册,投资，邀请人数不限制。</p>
				<p>2、现金收益发放每月结算一次，每月10日前统一打到个人投资账户中，可在平台“账户中心”查看，收益红包可用来继续<span style="display:inline-block;text-indent:20px;">投资也可提现。</span></p>
				<p>3、每个月第一日开始统计单月本人+好友投资额，根据当月最后一天24:00累计的投资总额计算收益奖励；平台数据月清，<span style="display:inline-block;text-indent:20px;">第二月数据重新开始统计。</span></p>
				<p>4、本活动法律允许范围内最终解释权归富元汇平台所有。</p>
			</div>
		</div>
	</div>
	
	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>

	<!--JS部分  -->
	<script type="text/javascript">
		$(function(){
			var urls = window.location.pathname;
			if(urls == '/enterContacts'){
		        $('.site').removeClass('active');
    		}



		});

	</script>




</body>
</html>



