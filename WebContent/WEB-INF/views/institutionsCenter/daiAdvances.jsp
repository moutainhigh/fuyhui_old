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
    <title>机构中心——待垫付</title>
    <meta name="author" content="深圳市富之富有限公司"/>
    <meta name="keywords" content="富之富，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="富之富，专注于供应链金融的P2C平台，年化收益高达10%~13%，拥有第三方资金托管的正规理财平台。提供百元起投的稳健理财产品，产品对接上市企业供应链项目，本息安全保障，随时稳定赎回。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
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
				<!-- 内容盒子Start -->
				<div class="daiadvanceBox">
					<div class="advance_searchBox">
						<div class="fl search_grounp">
							<div class="fl search_div">借款编号</div>
							<input type="text" class="fl search_ip01" id="search_ip01" name="search_ip01">
							<div class="clear"></div>
						</div>
						<div class="fl search_grounp">
							<div class="fl search_div">借款人</div>
							<input type="text" class="fl search_ip02" id="search_ip02" name="search_ip02">
							<div class="clear"></div>
						</div>
						<div class="fr advan_exportBtn">导出</div>
						<div class="clear"></div>
					</div>

					<div class="advan_contentBox">
						<div class="advan_title">
							<p class="fl">借款编号</p>
							<p class="fl">借款人</p>
							<p class="fl">借款标题</p>
							<p class="fl">借款金额</p>
							<p class="fl">借款期限</p>
							<p class="fl">待垫付金额</p>
							<p class="fl">垫付</p>
							<div class="clear"></div>
						</div>

						<!-- 每一条记录 -->
						<div class="each_advanBox">
							<p class="fl advan_borrow_num">FCD201612208</p>
							<p class="fl">刘晓东</p>
							<p class="fl advan_borrow_title">金交1号</p>
							<p class="fl">50万</p>
							<p class="fl">5个月</p>
							<p class="fl">0</p>
							<p class="fl advan_state">垫付</p>
							<div class="clear"></div>
						</div>

						<!-- 每一条记录 -->
						<div class="each_advanBox">
							<p class="fl advan_borrow_num">FCD201612208</p>
							<p class="fl">刘晓东</p>
							<p class="fl advan_borrow_title">金交1号</p>
							<p class="fl">50万</p>
							<p class="fl">5个月</p>
							<p class="fl">0</p>
							<p class="fl advan_state">垫付</p>
							<div class="clear"></div>
						</div>

						<!-- 每一条记录 -->
						<div class="each_advanBox">
							<p class="fl advan_borrow_num">FCD201612208</p>
							<p class="fl">刘晓东</p>
							<p class="fl advan_borrow_title">金交1号</p>
							<p class="fl">50万</p>
							<p class="fl">5个月</p>
							<p class="fl">0</p>
							<p class="fl advan_state">垫付</p>
							<div class="clear"></div>
						</div>

						<!-- 每一条记录 -->
						<div class="each_advanBox">
							<p class="fl advan_borrow_num">FCD201612208</p>
							<p class="fl">刘晓东</p>
							<p class="fl advan_borrow_title">金交1号</p>
							<p class="fl">50万</p>
							<p class="fl">5个月</p>
							<p class="fl">0</p>
							<p class="fl advan_state">垫付</p>
							<div class="clear"></div>
						</div>

						<!-- 每一条记录 -->
						<div class="each_advanBox">
							<p class="fl advan_borrow_num">FCD201612208</p>
							<p class="fl">刘晓东</p>
							<p class="fl advan_borrow_title">金交1号</p>
							<p class="fl">50万</p>
							<p class="fl">5个月</p>
							<p class="fl">0</p>
							<p class="fl advan_state">垫付</p>
							<div class="clear"></div>
						</div>

						<!-- 每一条记录 -->
						<div class="each_advanBox">
							<p class="fl advan_borrow_num">FCD201612208</p>
							<p class="fl">刘晓东</p>
							<p class="fl advan_borrow_title">金交1号</p>
							<p class="fl">50万</p>
							<p class="fl">5个月</p>
							<p class="fl">0</p>
							<p class="fl advan_state">垫付</p>
							<div class="clear"></div>
						</div>

						<!-- 每一条记录 -->
						<div class="each_advanBox">
							<p class="fl advan_borrow_num">FCD201612208</p>
							<p class="fl">刘晓东</p>
							<p class="fl advan_borrow_title">金交1号</p>
							<p class="fl">50万</p>
							<p class="fl">5个月</p>
							<p class="fl">0</p>
							<p class="fl advan_state">垫付</p>
							<div class="clear"></div>
						</div>

						<!-- 每一条记录 -->
						<div class="each_advanBox">
							<p class="fl advan_borrow_num">FCD201612208</p>
							<p class="fl">刘晓东</p>
							<p class="fl advan_borrow_title">金交1号</p>
							<p class="fl">50万</p>
							<p class="fl">5个月</p>
							<p class="fl">0</p>
							<p class="fl advan_state">垫付</p>
							<div class="clear"></div>
						</div>


						<!-- 分页 -->
						<div class="page_box advan_page">
							<ul id="advan_page" class="advan_page"></ul>
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



