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
    <title>融资项目详情-账户中心-富元汇</title>
    <meta name="author" content="深圳市富之富有限公司"/>
    <meta name="keywords" content="富之富，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="富之富，专注于供应链金融的P2C平台，年化收益高达10%~13%，拥有第三方资金托管的正规理财平台。提供百元起投的稳健理财产品，产品对接上市企业供应链项目，本息安全保障，随时稳定赎回。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/borrowerCenter/borrowerProject.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/borrowerCenter/borrowerDetail.js'></script>
    <style type="text/css">
		.con
		{
			margin-right: 0 !important;
			width: 300px !important;
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
			<%@ include file="borrowerMenu.jsp"%>
			
			<!-- 右边借款项目详情内容区域Start -->
			<div class="fl account_rightContent_box">
				<div class="acc_rigContent_name" style="text-indent:-9999px;height:24px;">借款项目</div>
	<%--右边的主内容开始--%>
	<div class="loancon loancon-detail">
	<!-- <div class="loan-info">
	<p class="ploan">借款信息</p>
	<div class="bor-loan">
	</div>
	<div class="loaninfo-con">
	<div class="con1 con fl">
	<p>
	借款编号：<span class='bor_num'></span>
	</p>
	<p>
	借款金额：<span class='bor_money'>2000</span>元
	</p>
	<p>
	贷款期限：<span class='bor_month'>6</span>天
	</p>
	</div>
	<div class="con2 con fl">
	<p>
	借款利率：<span class='bor_rate'>10%</span>
	</p> -->
	<%--<p>--%>
	<%--借款用途：<span class='bor_use'>经营金周转</span>--%>
	<%--</p>--%>
	<!-- <p>
	真实姓名：<span class='bor_name'>刘晓龙</span>
	</p>
	</div>
	<div class="con3 con fl">
	<p style="width:230px">
	身份证号：<span class='bor_ID'>410000199005265569</span>
	</p>
	<p>
	手机号码：<span class='bor_iphone'>13886865959</span>
	</p>
	</div>
	</div>
	</div> -->
	<div class="repayment-con">
	<p class="ploan">还款计划表</p>
	<div class="bor-loan">
	</div>
	</div>
	<div class="money-sort">
	<span class="sort-con sort-con1" style="">
	已还金额：<span class='realy_money'>0.00</span>元
	</span>
	<span class="sort-con" style='width:175px;'>
	待还金额：<span class='no_money'>0.00</span>元
	</span>
	<span class="sort-con">
	逾期金额：<span class='yuqi_money'>0.00</span>元
	</span>
	</div>
	<table class="repayment-tab">
	<thead>
	<tr>
	<th>期数</th>
	<th>应还日期</th>
	<th>应还本金</th>
	<th>应还收益</th>
	<th>实还本金</th>
	<th>实还收益</th>
	<th>应还日期</th>
	<th>状态</th>
	</tr>
	</thead>
	<tbody class="bordet_body">
		<tr>
			<td>第一期</td>
			<td>2016-10-15</td>
			<td>0元</td>
			<td>30元</td>
			<td>待还</td>
		</tr>
		
	</tbody>
	<!-- 分页start -->
	<div class="page_box bor_detalPage" style="bottom:110px">
		<ul id="borDet_page" class="borDet_page"></ul>
	</div>

	</table>
	</div>



	<%--右边的主内容结束--%>

			</div>
			<!-- 右边借款项目详情内容区域End -->


			<div class="clear"></div>
		</div>


		
	</div>
	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>
</body>
</html>



