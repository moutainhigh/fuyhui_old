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
    <title>待还项目-账户中心-富元汇</title>
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
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/borrowerCenter/borrowerProject.js'></script>
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
			
			<!-- 右边逾期项目内容区域Start -->
			<div class="fl account_rightContent_box">
				<div class="acc_rigContent_name" style="height:26px;text-indent:-9999px;margin-top:-2px;">逾期项目</div>
	<%--右边的主内容开始--%>
	<!-- <div class="delay-con">
		<label class="label1">借款编号</label>
		<input class="" style="">
		<label class="label2">借款人</label>
		<input class="">
		<span class="export-btn" style="">导出</span>
	</div> -->
	<div class="delay-tabcon" >
	<table class="delay-tab">
	<thead>
	<tr>
		<th>项目编号</th>
		<th>项目名称</th>
		<th>融资金额</th>
		<th>融资期限</th>
		<th>已还金额</th>
		<th>待还金额</th>
		<th>状态</th>
	</tr>
	</thead>
	<tbody>
	<tr>
	<td class=“”>FCD201612208</td>
	<td>金交1号</td>
	<td>50万</td>
	<td>5个月</td>
	<td>0</td>
	<td>0</td>
	<td class="status delay-link">还款中</td>
	</tr>
	<tr>
	<td class=“delay-link”>FCD201612208</td>
	<td>金交1号</td>
	<td>50万</td>
	<td>5个月</td>
	<td>0</td>
	<td>0</td>
	<td class="status delay-link">还款中</td>
	</tr>
	<tr>
	<td class=“delay-link”>FCD201612208</td>
	<td>金交1号</td>
	<td>50万</td>
	<td>5个月</td>
	<td>0</td>
	<td>0</td>
	<td class="status delay-link">逾期</td>
	</tr>
	<tr>
	<td class=“delay-link”>FCD201612208</td>
	<td>金交1号</td>
	<td>50万</td>
	<td>5个月</td>
	<td>0</td>
	<td>0</td>
	<td class="status delay-link">逾期</td>
	</tr>
	<tr>
	<td class=“delay-link”>FCD201612208</td>
	<td>金交1号</td>
	<td>50万</td>
	<td>5个月</td>
	<td>0</td>
	<td>0</td>
	<td class="status delay-link">逾期</td>
	</tr>
	<tr class="">
	<td class=“delay-link”>FCD201612208</td>
	<td>金交1号</td>
	<td>50万</td>
	<td>5个月</td>
	<td>0</td>
	<td>0</td>
	<td class="status delay-link">逾期</td>
	</tr>
	</tbody>
	</table>
	</div>

	<%--右边的主内容结束--%>
			</div>
			<!-- 右边逾期项目内容区域End -->


			<div class="clear"></div>
		</div>


		
	</div>

	<!--隐藏的大DIV层开始-->
	<div class="hide-body" style="">
	</div>
	<!--隐藏的大DIV层结束-->

	<!--隐藏的内容开始-->
	<div class="hide-con" style="">
	<div class="top-head">
	<label class="tit-delay">逾期</label>
	<em class="close">
	<%--<img src="">--%>
	</em>
	</div>
	<div class="con-cen" style="width: 358px;height: 96px;margin-top: 14px;margin-left: 74px;">
	<p>
	借款编号：<label>FCD1611202202</label>
	</p>
	<p>
	逾期金额：<label>1000 元</label>   <span class="span-ri">逾期罚息：<label class="">200 元</label></span>
	</p>
	<p>
	需还金额：<label>1200 元</label>
	</p>
	</div>
	<div class="btn-con" style="height: 86px;line-height: 86px;text-align: center;width: 100%;">
	<span class="btn-submit">
	确认还款
	</span>
	</div>
	</div>
	<!--隐藏的内容结束-->



		
	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>
</body>
</html>



