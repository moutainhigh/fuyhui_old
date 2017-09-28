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
    <title>机构中心-担保项目</title>
    <meta name="author" content="深圳市富之富有限公司"/>
    <meta name="keywords" content="富之富，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="富之富，专注于供应链金融的P2C平台，年化收益高达10%~13%，拥有第三方资金托管的正规理财平台。提供百元起投的稳健理财产品，产品对接上市企业供应链项目，本息安全保障，随时稳定赎回。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/siteinfo.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/institutionsCenter/guarantee.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/institutionsCenter/guarantee.js'></script>
</head>
<body>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	<!--  账户中心-->
	<div class="warp_account_center">
		<!-- 资产总览内容区域 -->
		<div class="user_account1000">
			<!-- 引入左边菜单导航栏 -->
			<%@ include file="instituteMenu.jsp"%>
			<!-- 右边账户中心内容区域Start -->
			<div class="fl account_rightContent_box">
				<div class="acc_rigContent_name">担保项目</div>
				<div class="tra_detailBox" style="margin: -24px 0 53px 0;">
					<ul class="tra_list">
						<li class="tra_item01" style="padding-left:0;width:325px;text-align:center;">
							<div><span class='money_tab'>￥</span><span class='getTotal'>0.00</span>元</div>
							<p class="tra_item_p">当前担保总金额</p>
						</li>
						<li class="tra_item02" style="border-left:0;padding-left:0;width:325px;text-align:center;">
							<div><span class='money_tab'>￥</span><span class='getCash'>0.00</span>元</div>
							<p class="tra_item_p">已垫付总额</p>
						</li>
						<li class="tra_item03" style="border-left:0;width:325px;">
							<div><span class='money_tab'>￥</span><span class='getFrost'>0.00</span>元</div>
							<p class="tra_item_p">待垫付总额</p>
						</li>
						<!-- <li class="tra_item04">
							银行存管账单
						</li> -->
					</ul>
					<div class="clear"></div>
				</div>
				<!-- 内容Start -->
				<div class="guarantee_box">
					<div class="guar_titleBox">
						<p class="fl guar_p01">借款编号</p>
						<p class="fl guar_p02">借款标题</p>
						<p class="fl guar_p03">借款金额</p>
						<p class="fl guar_p04">借款期限</p>
						<p class="fl guar_p05">已垫付金额</p>
						<p class="fl guar_p06">待垫付金额</p>
						<p class="fl guar_p07">状态</p>
						<div class="clear"></div>
					</div>
					<div class="guar_contents">
						<!-- 每一条记录 -->
						<!-- <div class="earch_guarBox">
							<p class="fl guar_num">FCD201612208</p>
							<p class="fl guar_title">金交1号</p>
							<p class="fl">50万</p>
							<p class="fl">5个月</p>
							<p class="fl">0</p>
							<p class="fl">0</p>
							<p class="fl repayment">还款中</p>
							<div class="clear"></div>
						</div> -->
						
					</div>

					<!-- 分页 -->
					<div class="page_box guar_page" style="bottom: 156px !important;">
						<ul id="guarante_page" class="guarante_page"></ul>
					</div>

				</div>
				<!-- 内容End -->
			</div>
			<!-- 右边账户中心内容区域End -->
			<div class="clear"></div>
		</div>


		
	</div>
		
	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>
</body>
</html>






