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
    <title>618破千万礼赞-富元汇</title>
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
		.ivt_item01_bg
		{
			width: 383px;
			height: 376px;
			background: url(../../static/images/activities/ivt01.png) no-repeat center;
		}
		.com_celeBox
		{
			width: 100%;
		}
		.celebate_banner01
		{
			height: 590px;
			background: url(../../static/images/activities/618img01.png) no-repeat center;
		}
		.celebate_banner02
		{
			height: 146px;
			background: url(../../static/images/activities/618img02.png) no-repeat center;
		}
		.celebate_banner03
		{
			height: 734px;
			background: url(../../static/images/activities/618img03.png) no-repeat center;
		}
		.celebate_banner04
		{
			height: 146px;
			background: url(../../static/images/activities/618img04.png) no-repeat center;
		}
		.celebate_banner05
		{
			height: 820px;
			background: url(../../static/images/activities/618img05.png) no-repeat center;
		}
		.celebate_banner06
		{
			height: 146px;
			background: url(../../static/images/activities/618img06.png) no-repeat center;
		}
		.celebate_banner07
		{
			height: 860px;
			background: url(../../static/images/activities/618img07.png) no-repeat center;
		}
		.celebate_rule_box
		{
			background: #6D00DF;
		}
		.cele_rule_body
		{
			width: 1170px;
			margin: 0 auto;
		}
		.cele_table
		{
			width: 841px;
			height: 455px;
			background: url(../../static/images/activities/table.png) no-repeat center;
			margin: 47px auto 57px auto;
		}
		.cele_title
		{
			padding-top: 113px;
			margin-left: 82px;
			font-size: 24px;
			color: #fff;
		}
		.cele_txt
		{
			padding-bottom: 70px;
			margin-left: 82px;
			font-size: 24px;
			color: #fff;
		}
		.cele_txt p
		{
			line-height: 40px;
		}
		.cele_last_txt
		{
			margin-top: 42px;
		}
    </style>
    
</head>
<body>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	<div class="com_celeBox celebate_banner01"></div>
	<div class="com_celeBox celebate_banner02"></div>
	<div class="com_celeBox celebate_banner03"></div>
	<div class="com_celeBox celebate_banner04"></div>
	<div class="com_celeBox celebate_banner05"></div>
	<div class="com_celeBox celebate_banner06"></div>
	<div class="com_celeBox celebate_banner07"></div>
	<div class="com_celeBox celebate_rule_box">
		<div class="cele_rule_body">
			<div class="cele_title">1、成功认购金额、邀请成功认购人数和邀请成功认购金额排名前五的用户，分别可获得现金奖励：</div>
			<div class="cele_table"></div>
			<div class="cele_txt">
				<p>2、此活动排名的金额和人数均指成功认购的金额和人数；</p>
				<p>3、此活动现金奖励直接发放至获奖用户的托管账户；</p>
				<p>4、此活动现金奖励可直接提现，或者用于认购产品；</p>
				<p>5、此活动截止时间为6月18日24点；</p>
				<p>6、此活动现金奖励发放时间为6月23日24点前；</p>
				<p>7、获奖结果请关注富元汇网站公告。</p>
				<p class="cele_last_txt">*本活动规则解释权归富元汇所有，如有疑问请拨打客服热线：4009-303-606。</p>
			</div>
		</div>
	</div>


	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>

	<!--JS部分  -->
	<script type="text/javascript">
		$(function(){
			var urls = window.location.pathname;
			if(urls == '/enterCelebrate'){
		        $('.site').removeClass('active');
    		}



		});

	</script>




</body>
</html>



