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
    <title>新用户福利-富元汇</title>
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
			height: 800px;
			background: url(../../static/images/activities/newWel01.jpg) no-repeat center;
		}
		.newWel_contents
		{
			width: 100%;
			padding: 80px 0;
			background: #e50112;
		}
		.newWel_1000
		{
			width: 1091px;
			height: 661px;
			margin: 0 auto;
		}
		.welImg01
		{
			width: 508px;
			height: 661px;
			background: url(../../static/images/activities/newWel02.png) no-repeat center;
		}
		.welImg02
		{
			width: 508px;
			height: 661px;
			margin-left: 75px;
			background: url(../../static/images/activities/newWel03.png) no-repeat center;
		}
    </style>
    
</head>
<body>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	<div class="reg_redpacket_wrap"></div>
	<div class="newWel_contents">
		<div class="newWel_1000">
			<div class="fl welImg01"></div>
			<div class="fr welImg02"></div>
			<div class="clear"></div>
		</div>
	</div>
	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>

	<!--JS部分  -->
	<script type="text/javascript">
		$(function(){
			var urls = window.location.pathname;
			if(urls == '/enterNewWelfare'){
		        $('.site').removeClass('active');
    		}



		});

	</script>




</body>
</html>



