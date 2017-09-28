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
    <title>机构中心——交易明细</title>
    <meta name="author" content="深圳市富之富有限公司"/>
    <meta name="keywords" content="富之富，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="富之富，专注于供应链金融的P2C平台，年化收益高达10%~13%，拥有第三方资金托管的正规理财平台。提供百元起投的稳健理财产品，产品对接上市企业供应链项目，本息安全保障，随时稳定赎回。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/institutionsCenter/jcDate.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/siteinfo.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/institutionsCenter/guarantee.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/institutionsCenter/jquery.min.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/jQuery-jcDate.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/institutionsCenter/insTrade.js"></script>
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
				<div class="acc_rigContent_name">交易明细</div>
				<!-- 内容盒子Start -->
				<div class="tra_rigBotContent_box">
					<!-- 交易明细Start -->
					<div class="tra_detailBox">
						<ul class="tra_list">
							<li class="tra_item01" style="padding-left:0;width:325px;text-align:center;">
								<div><span class='money_tab'>￥</span><span class='getTotal'>0.00</span>元</div>
								<p class="tra_item_p">账户总金额</p>
							</li>
							<li class="tra_item02" style="border-left:0;padding-left:0;width:325px;text-align:center;">
								<div><span class='money_tab'>￥</span><span class='getCash'>0.00</span>元</div>
								<p class="tra_item_p">账户余额</p>
							</li>
							<li class="tra_item03" style="border-left:0;width:325px;">
								<div><span class='money_tab'>￥</span><span class='getFrost'>0.00</span>元</div>
								<p class="tra_item_p">冻结金额</p>
							</li>
							<!-- <li class="tra_item04">
								<div class="fl instra_chonzhi" onclick="window.location.href='/myAccount/enterInsRecharge'">充值</div>
								<div class="fl instra_witrecharge" onclick="window.location.href='/myAccount/enterInsWithdrawal'">提现</div>
								<div class="clear"></div>
							</li> -->
						</ul>
						<div class="clear"></div>
					</div>
					<!-- 交易明细End -->
					<!-- <div class="tra_area"> -->
						<!--  交易类型Start-->
						<!-- <div class="tra_typeBox">
							<div class="tra_type_title">
								<p>交易类型</p>
								<p class="com_trap all_type active">全部</p>
								<p class="com_trap tra_top_up">充值</p>
								<p class="com_trap tra_withdrawal">提现</p>
								<p class="com_trap tra_invest">投资</p>
								<p class="com_trap tra_alsoMoney">还款</p>
								<div class="clear"></div>
							</div>
						</div> -->
						<!--  交易类型End-->

						<!-- 交易日期Start -->
						<!-- <div class="tra_timeBox">
							<div class="fl timeBox_left">
								<p class="fl">交易日期</p>
								
								<input class="fl jcDate time_controls01" />
							
								<h6 class="fl">至</h6>
								
								<input class="fl jcDate time_controls02" />
								
								<p class="fl time_month">1个月</p>
								<p class="fl time_month">3个月</p>
								<p class="fl time_month">半年</p>
								<div class="clear"></div>
							</div>
							<div class="fl timeBox_right">
								<div class="fl time_btn time_query">查询</div>
								<div class="fl time_btn time_export">导出</div>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
						</div> -->
						<!-- 交易日期End -->
					<!-- </div> -->

					<!-- 交易明细Start -->
					<div class="comtab" style="margin-top:30px;">
						<div class="table_title">
							<div class="fl tra_num_title">交易编号</div>
							<div class="fl tra_accont_title">交易金额</div>
							<div class="fl tra_avial_title">账户余额</div>
							<div class="fl tra_types_title">交易类型</div>
							<div class="fl tra_time_title">交易时间</div>
							<div class="clear"></div>
						</div>
						
						<!-- 内容体 -->
						<div class="tab_tr_box">
							<!-- <div class="each_tab_tr">
								<p class="tra_number">ZQ20160822</p> -->
								<!-- 温馨提示：当交易类型为'退款'时，交易金额的样式是tra_tuikuan;当交易类型为'提现'时，交易金额的样式为tra_tixian -->
								<!-- <p class="tra_tixian">+200.00</p>
								<p class="tra_avail_money">40000</p>
								<p class="tra_type">提现</p>
								<p class="tra_time">2016-01-04 10:30</p>
								<div class="clear"></div> -->
							<!-- </div> -->
							

						</div>
						
						<!-- 分页 -->
						<div class="page_box tradePage">
							<ul id="trade_page" class="trade_page"></ul>
						</div>
					</div>
					<!-- 交易明细End -->

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






