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
    <title>借款中心——申请中</title>
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
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/borrowDuring.js'></script>
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
				<div class="acc_rigContent_name">申请中</div>

				<div class="bor_apyDur_box">
					<div class="fl bor_apyDur_input">
						<input type="text" class="bor_apyIpt" id="bor_apyIpt" placeholder='借款编号' />
					</div>
					<div class="fl bor_apy_search">搜索</div>
					<div class="clear"></div>
				</div>
				<!-- 内容盒子Start -->
				<div class="acc_rigBotContent_box">
					<div class="comtab">
						<div class="table_title">
							<div class="fl borapy_num_title">借款编号</div>
							<div class="fl borapy_invest_title">申请金额</div>
							<div class="fl borapy_limit_title">借款期限</div>
							<div class="fl borapy_money_title">批复金额</div>
							<div class="fl borapy_time_title">申请日期</div>
							<div class="fl borapy_state_title">状态</div>
							<div class="fl borapy_opin_title">审核意见</div>
							<div class="fl borapy_opear_title">操作</div>
							<div class="clear"></div>
						</div>
						
						<!-- 内容体 -->
						<div class="tab_tr_box">
							<div class="each_tab_tr">
								<p class="borapy_number">ZQ20160822</p>
								<p class="borapy_Amount">2000元</p>
								<p class="borapy_month">1个月</p>
								<p class="borapy_money">1000元</p>
								<p class="borapy_time">2016-10-12</p>
								<p class="borapy_state">审核不通过</p>
								<p class="borapy_opin">材料不齐全</p>
								<p class="borapy_opear">
									<span onclick="window.location.href=''" class='borapy_again'>重新申请</span>
									<span onclick="window.location.href=''" class='borapy_progress'>申请进度</span>
								</p>
								<div class="clear"></div>
							</div>
							<div class="each_tab_tr">
								<p class="borapy_number">ZQ20160822</p>
								<p class="borapy_Amount">2000元</p>
								<p class="borapy_month">1个月</p>
								<p class="borapy_money">1000元</p>
								<p class="borapy_time">2016-10-12</p>
								<p class="borapy_state">筹款中</p>
								<p class="borapy_opin">材料不齐全</p>
								<p class="borapy_opear">
									<span onclick="window.location.href=''" class='bor_confirm'>确认申请</span>
								</p>
								<div class="clear"></div>
							</div>
							<div class="each_tab_tr">
								<p class="borapy_number">ZQ20160822</p>
								<p class="borapy_Amount">2000元</p>
								<p class="borapy_month">1个月</p>
								<p class="borapy_money">1000元</p>
								<p class="borapy_time">2016-10-12</p>
								<p class="borapy_state">审核通过</p>
								<p class="borapy_opin">材料不齐全</p>
								<p class="borapy_opear">
									<span onclick="window.location.href=''" class='bor_confirm'>确认申请</span>
								</p>
								<div class="clear"></div>
							</div>
							<div class="each_tab_tr">
								<p class="borapy_number">ZQ20160822</p>
								<p class="borapy_Amount">2000元</p>
								<p class="borapy_month">1个月</p>
								<p class="borapy_money">1000元</p>
								<p class="borapy_time">2016-10-12</p>
								<p class="borapy_state">审核通过</p>
								<p class="borapy_opin">材料不齐全</p>
								<p class="borapy_opear">
									<span onclick="window.location.href=''" class='bor_confirm'>确认申请</span>
								</p>
								<div class="clear"></div>
							</div>
							<div class="each_tab_tr">
								<p class="borapy_number">ZQ20160822</p>
								<p class="borapy_Amount">2000元</p>
								<p class="borapy_month">1个月</p>
								<p class="borapy_money">1000元</p>
								<p class="borapy_time">2016-10-12</p>
								<p class="borapy_state">筹款中</p>
								<p class="borapy_opin">材料不齐全</p>
								<p class="borapy_opear">
									<span onclick="window.location.href=''" class='bor_confirm bor_increment'>标的详情</span>
								</p>
								<div class="clear"></div>
							</div>
							<div class="each_tab_tr">
								<p class="borapy_number">ZQ20160822</p>
								<p class="borapy_Amount">2000元</p>
								<p class="borapy_month">1个月</p>
								<p class="borapy_money">1000元</p>
								<p class="borapy_time">2016-10-12</p>
								<p class="borapy_state">审核中</p>
								<p class="borapy_opin">材料不齐全</p>
								<p class="borapy_opear">
									<span onclick="window.location.href=''" class='bor_confirm bor_infos'>借款信息</span>
								</p>
								<div class="clear"></div>
							</div>
							<div class="each_tab_tr">
								<p class="borapy_number">ZQ20160822</p>
								<p class="borapy_Amount">2000元</p>
								<p class="borapy_month">1个月</p>
								<p class="borapy_money">1000元</p>
								<p class="borapy_time">2016-10-12</p>
								<p class="borapy_state">审核不通过</p>
								<p class="borapy_opin">材料不齐全</p>
								<p class="borapy_opear">
									<span onclick="window.location.href=''" class='borapy_again'>重新申请</span>
									<span onclick="window.location.href=''" class='borapy_progress'>申请进度</span>
								</p>
								<div class="clear"></div>
							</div>

						</div>
						<!-- 分页Start -->
						<div class="page_box">
							<ul id="bDuring" class="bDuring"></ul>
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



