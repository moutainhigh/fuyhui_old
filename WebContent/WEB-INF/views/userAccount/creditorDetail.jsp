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
    <title>债权详情-富元汇</title>
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
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/creditorDetail.js'></script>
</head>
<body>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	<!--  账户中心-->
	<div class="warp_account_center">
		<!-- 资产总览内容区域 -->
		<div class="user_account1000">
			<!-- 引入左边菜单导航栏 -->
			<%@ include file="leftMenu.jsp"%>
			<!-- 右边账户中心内容区域Start -->
			<div class="fl account_rightContent_box">
				<div class="acc_rigContent_name" style="height:24px;text-indent:-9999px;">项目查询</div>
				<!-- 内容盒子Start -->
				<div class="gurDetail_box">
					<div class="gur_borrow_infos">
						<p class="comtitle">借款信息</p>
						<p class="gur_hr"></p>
						<div class="gur_divs">
							<p class="fl gur_detailp01">借款编号：<span class='bor_num'>FXD201612208</span></p>
							<p class="fl gur_detailp02">真实姓名：<span class='bor_name'>刘晓龙</span></p>
							<p class="fl">身份证号：<span class='bor_ID'>410000000000000000</span></p>
							<div class="clear"></div>
						</div>
						<div class="gur_divs">
							<p class="fl gur_detailp01">手机号码：<span class='bor_iphone'>15812345678</span></p>
							<p class="fl gur_detailp02">借款金额：<span class='bor_money'>2000</span>元</p>
							<p class="fl">贷款期限：<span class='bor_month'>6</span>天</p>
							<div class="clear"></div>
						</div>
						<div class="gur_divs">
							<p class="fl gur_detailp01">借款利率：<span class='bor_rate'>10%</span></p>
							<p class="fl gur_detailp02">投资金额：<span class='invest_money'>2000</span>元</p>
							<div class="clear"></div>
						</div>
					</div>

					<div class="repayment_plan_table">
						<p class="comtitle" style="padding-left:29px !important;">还款计划表</p>
						<p class="gur_hr" style="margin-left:29px !important;"></p>
						<div class="repayBox">
							<p class="fl real_ment">已还金额：<span class='realMent'>0.00</span>元</p>
							<p class="fl dai_ment">待还金额：<span class='daiMent'>0.00</span>元</p>
							<!-- <p class="fl delay_ment">逾期金额：<span class='delayMent'>0.00</span>元</p> -->
							<div class="clear"></div>
						</div>
						<div class="repay_table">
							<div class="gur_table_title">
								<p class="fl">期数</p>
								<p class="fl">还款日期</p>
								<p class="fl">本金</p>
								<p class="fl">利息</p>
								<p class="fl">状态</p>
								<div class="clear"></div>
							</div>
							<div class="detail_contents">
								<!-- 每一条还款记录 -->
								<!-- <div class="earch_repayBox">
									<p class="fl">第一期</p>
									<p class="fl">2016-12-20</p>
									<p class="fl">0元</p>
									<p class="fl">30元</p>
									<p class="fl">待还</p>
									<div class="clear"></div>
								</div> -->
							</div>
							
							
							
						</div>

						<!-- 分页 -->
						<div class="page_box gurdet_page">
							<ul id="gur_detailPage" class="gur_detailPage"></ul>
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

<script type="text/javascript">
	$(function(){
		// 机构中心-担保项目页面分页js
		// $('#gur_detailPage').twbsPagination({
	 //        totalPages: 4,
	 //        visiblePages: 4,
	 //        first:'',
	 //        last:'',
	 //        prev:'<上一页',
	 //        next:'下一页>',
	 //        onPageClick: function (event, page) {
	 //            // $('#page-content').text('Page ' + page);
	            
	 //        }
	 //    });






	});
</script>



