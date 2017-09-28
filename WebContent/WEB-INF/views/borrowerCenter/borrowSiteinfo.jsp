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
    <title>消息中心-账户中心-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/siteinfo.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/siteinfo.js'></script>
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
			<!-- 右边账户中心内容区域Start -->
			<div class="fl account_rightContent_box">
				<div class="acc_rigContent_name" style="height:26px;text-indent:-9999px;">站内信息</div>
				<!-- 内容盒子Start -->
				<div class="site_rigBotContent_box">
					<div class="sit_nav_box" apid =${sessionScope.user_inf.userId}>
						<p class="site_state">状态</p>
						<p class="site_theme">主题</p>
						<p class="site_sendTime">发送时间</p>
						<div class="clear"></div>
					</div>

					<!-- 站内信息内容Strart -->
					<div class="site_content_box">
						<!-- 每一条站内信息 -->
						<!-- 温馨提示：当状态是未读是样式是unread；当状态是已样式是read -->
						<!-- <div class="eachBox">
							<div class="each_sitInfos_box unread">
								<div class="fl ck_checkbox_grounp">
									<input type="checkbox" name="ck_box" value="" id="ck_box" class="ck_box" />
								</div>
								<div class="fl site_readState">未读</div>
								<div class="fl sit_theme_cont">小富提示：您投资的“短期周转”，债权编号小富提示：您投资的“短期周转”，债权编号小富提示：您投资的“短期周转”，债权编号小富提示：您投资的“短期周转”，债权编号小富提示：您投资的“短期周转”，债权编号小富提示：您投资的“短期周转”，债权编号小富提示：您投资的“短期周转”，债权编号小富提示：您投资的“短期周转”，债权编号</div>
								<div class="fl sit_send_time">2016-10-12 12:30</div> -->
								<!-- 温馨提示 点击时的样式是sit_active_close;默认时是sit_close-->
								<!-- <div class="fl sit_closebgBox">
									<div class="sit_closeImg sit_close"></div>
								</div>
								<div class="clear"></div>
							</div>
							<div class="sit_prompt_box"><div class="sit_prompt"></div><div class="prompt_close"></div></div>
						</div> -->
						

					</div>

					<!-- 全选按钮、删除选中信息按钮、标识为已读按钮 -->
					<!-- <div class="site_radio_grounp">
						<label for="check_all" class="sit_all">
							<input type="checkbox" value="" id="check_all" class="check_all" />全选
						</label>
						<label for="" class="sit_detele">删除选中信息</label>
						<label for="" class="sit_read">标识为已读</label>
					</div> -->
					<!-- 站内信息内容End -->

					<!-- 分页 -->
					<div class="page_box site_page" style="bottom:132px;">
						<ul id="siteInfo_page" class="siteInfo_page"></ul>
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



