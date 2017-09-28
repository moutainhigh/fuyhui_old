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
    <title>优惠券-账户中心-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/myreward.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/coupons.js'></script>
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
				<div class="acc_rigContent_name" style="height:24px;text-indent:-9999px;">优惠卷</div>
				
				<!-- 内容盒子Start -->
				<div class="cou_rigBotContent_box">
					<!-- 导航栏盒子 -->
					<div class="cou_title_nav">
						<p class="cou_available active">可用的</p>
						<p class="cou_hasbeen_used">已使用</p>
						<p class="cou_expired">已过期</p>
						<div class="clear"></div>
					</div>


					<!-- 可用的Start -->
					<div class="cou_available_body">
						<div class="cou_avail_box">
							<!-- 每一个红包盒子 -->
							<!-- <div class="each_avail_reward">
								<ul class="avail_list">
									<li class="avail_item01">
										<div class="avail_item_bg"></div>
										<p class="avail_number">No.16052000</p>
									</li>
									<li class="avail_item02">
										<h3>注册送红包</h3>
										<p>投资期限<span class='cou_invest_mounth'>3</span>个月</p>
										<p>最低限额<span class='cou_limit'>5000</span>元</p>
										<div>2016-10-12 23:21</div>
									</li>
									<li class="avail_item03">
										<div class="avail_nums">50</div>
										<p>代金券</p>
									</li>
								</ul>
								<div class="clear"></div>
							</div> -->
							
							
							
							
							
							
						</div>
						<div class="clear"></div>
						<!-- 分页 -->
						<div class="page_box">
							<ul id="availe_page" class="availe_page"></ul>
						</div>
					</div>
					<!-- 可用的End -->


					<!-- 已使用Start -->
					<div class="cou_used_body" style="display:none;">
						<div class="cou_used_box">
							<div class="comtab">
								<div class="table_title">
									<div class="fl cou_num_title">编号</div>
									<div class="fl cou_invest_title">面值</div>
									<div class="fl cou_investDate_title">使用时间</div>
									<div class="fl cou_scope_title">使用范围</div>
									<div class="fl cou_type_title">类型</div>
									<div class="fl cou_source_title">来源</div>
									<div class="clear"></div>
								</div>
								
								<!-- 内容体 -->
								<div class="tab_tr_box real_use">
									<!-- <div class="each_tab_tr">
										<p class="cou_number">ZQ20160822</p>
										<p class="cou_amount">20元</p>
										<p class="cou_investTime">2016-10-01</p>
										<p class="cou_user_scope">
											<span>1.1.投资100以上</span>
											<span>2.投资期限至少3个月</span>
										</p>
										<p class="cou_type">加息劵</p>
										<p class="cou_source">注册赠送</p>
										<div class="clear"></div>
									</div> -->
								</div>
							</div>
						</div>
						<!-- 分页 -->
						<div class="page_box">
							<ul id="used_page" class="used_page"></ul>
						</div>
					</div>
					<!-- 已使用End -->

					<!-- 已过期Start -->
					<div class="cou_expired_body" style="display:none;">
						<div class="cou_expired_box">
							<div class="comtab">
								<div class="table_title">
									<div class="fl cou_num_title">编号</div>
									<div class="fl cou_invest_title">面值</div>
									<div class="fl cou_investDate_title">到期时间</div>
									<div class="fl cou_scope_title">使用范围</div>
									<div class="fl cou_type_title">类型</div>
									<div class="fl cou_source_title">来源</div>
									<div class="clear"></div>
								</div>
								
								<!-- 内容体 -->
								<div class="tab_tr_box user_guoqi">
									<!-- <div class="each_tab_tr">
										<p class="exp_number">ZQ20160822</p>
										<p class="exp_amount">20元</p>
										<p class="exp_investTime">2016-10-01</p>
										<p class="exp_user_scope">
											<span>1.1.投资100以上</span>
											<span>2.投资期限至少3个月</span>
										</p>
										<p class="exp_type">加息劵</p>
										<p class="exp_source">注册赠送</p>
										<div class="clear"></div>
									</div> -->
									

								</div>
							</div>
						</div>
						<!-- 分页 -->
						<div class="page_box">
							<ul id="expired_page" class="expired_page"></ul>
						</div>
					</div>
					<!-- 已过期End -->
				
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



