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
    <title>借款中心——我的借款</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/borrowcenter.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/myborrow.js'></script>
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
				<div class="acc_rigContent_name">借款中心</div>
				<!-- 借款中心盒子 -->
				<div class="borrow_center_box">
					<div class="fl bor_left_box">
						<div class="stay_amount">待还总额<span class='com_bigMoneyFuhao' style='margin-left:21px;'>￥</span><span class='stay_amount_num'>3890.00</span></div>
						<ul class="stay_money_list">
							<li class="stay_item01">
								<div>
									<span class='com_smMoneyFuhao'>￥</span><span>2360.00</span>
								</div>
								<p>待还本金</p>
							</li>
							<li class="stay_item02">
								<div>
									<span class='com_smMoneyFuhao'>￥</span><span>2360.00</span>
								</div>
								<p>待还利息</p>
							</li>
							<li class="stay_item03">
								<div>
									<span class='com_smMoneyFuhao'>￥</span><span>2360.00</span>
								</div>
								<p>逾期金额</p>
							</li>
						</ul>
						<div class="clear"></div>
					</div>
					<div class="fl bor_right_box">
						<div class="bor_todayMoney_box">
							今日应还金额
							<span class='com_bigMoneyFuhao' style='margin-left:23px;'>￥</span><span class='bor_tdMoney'>3890.00</span>
						</div>
						<div class="bor_btns">立即还款</div>
					</div>
					<div class="clear"></div>
				</div>
				<!-- 内容盒子Start -->
				<div class="acc_rigBotContent_box">
					<div class="comtab">
						<div class="table_title">
							<div class="fl bor_num_title">债权编号</div>
							<div class="fl bor_invest_title">借款金额</div>
							<div class="fl bor_year_title">年化利率</div>
							<div class="fl bor_qishu_title">已还期数/借款期数</div>
							<div class="fl bor_time_title">放款日期</div>
							<div class="fl bor_daihai_title">待还金额</div>
							<div class="fl bor_state_title">状态</div>
							<div class="fl bor_opear_title">操作</div>
							<div class="clear"></div>
						</div>
						
						<!-- 内容体 -->
						<div class="tab_tr_box">
						<c:forEach items="${applyList.items }" var="apply">
							<div class="each_tab_tr">
							
								<p class="bor_number">${apply.order_number }</p>
								<p class="bor_amount">${apply.amount }</p>
								<p class="bor_rate">${apply.apr }</p>
								<p class="bor_qishu">${apply.repay_period }/${apply.period  }</p>
							
								<p class="bor_reimbuDate"><date:date pattern="yyyy-MM-dd HH:mm"
							value="${apply.loan_time}"></date:date></p>
								<p class="bor_daihai_money">${apply.repay_money }</p>
								<p class="bor_state">${apply.repay_status }</p>
								<p class="bor_opear">
									<span onclick="window.location.href=''" class='bor_plan'>还款计划</span>
									<span onclick="window.location.href=''" class='bor_contract'>查看合同</span>
								</p>
								</div>
								<div class="clear"></div>
								
							
							</c:forEach>

						</div>
						<!-- 分页Start -->
						<div class="page_box">
							<ul id="myborrow" class="myborrow"></ul>
						</div>
						<!-- 分页End -->
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



