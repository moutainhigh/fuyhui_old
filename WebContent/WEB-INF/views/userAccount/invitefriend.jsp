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
    <title>邀请好友-账户中心-富元汇</title>
    <meta name="author" content="深圳市富之富有限公司"/>
    <meta name="keywords" content="富之富，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="富之富，专注于供应链金融的P2C平台，年化收益高达10%~13%，拥有第三方资金托管的正规理财平台。提供百元起投的稳健理财产品，产品对接上市企业供应链项目，本息安全保障，随时稳定赎回。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/myreward.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/invitefriend.js'></script>
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
				<div class="acc_rigContent_name" style="height:24px;text-indent:-9999px;">邀请好友</div>
				<!-- 内容盒子Start -->
				<div class="rew_rigBotContent_box">
					<div class="reward_nav_box">
						<div class="fl recommend_overview active">邀请详情</div>
						<div class="fl friend_detail">好友详情</div>
						<div class="clear"></div>
					</div>
					


					<!-- 推荐总览内容盒子 -->
					<div class="recommend_body">
						<!-- 获得的奖励内容盒子Start -->
						<div class="get_reward_box">
						<ul class="reward_list">
							<li class="reward_itme01">
								<!-- <div class="fl rew_item01_bg"></div> -->
								<div class="fl rew_item01_content">
									<p class="yes_reward">￥68.81</p>
								<div>昨日发放奖励</div>
								</div>
								<div class="clear"></div>
							</li>
							<li class="reward_itme02">
								<!-- <div class="fl rew_item02_bg"></div> -->
								<div class="fl rew_item02_content">
									<p class="addUp_reward">￥68.81</p>
								<div>累计奖励</div>
								</div>
								<div class="clear"></div>
							</li>
							<%--<li class="reward_itme03">--%>
								<%--<div class="fl rew_item03_bg"></div>--%>
								<%--<div class="fl rew_item03_content">--%>
								<%--<p>￥68.81</p>--%>
								<%--<div>推广奖励总额</div>--%>
								<%--</div>--%>
								<%--<div class="clear"></div>--%>
							<%--</li>--%>
							</ul>
						</div>
						<!-- 获得的奖励内容盒子End -->
						<!-- 推荐方式Start -->
						<div class="recommend_style_box">
							<div class="recomemnd_title">
								<span class="recom_title">邀请方式</span>
							</div>
							<div class="recommend_speciesBox">
								<%--<div class="fl recom_wx">--%>
									<%--<div class="recon_wx_bg"></div>--%>
									<%--<p>微信</p>--%>
								<%--</div>--%>
								<!-- <div class="fl recom_code">
									<div class="recon_code_bg"></div>
									<p>推荐码</p>
								</div> -->

								<!-- 复制推荐码start -->
								<div class="recon_div_group">
									<div class="rec_group_first">
										<div class="fl recon_cirle">1</div>
										<div class="fl recon_cirle_txt">邀请码</div>
										<div class="clear"></div>
									</div>
									<div class="rec_group_second">复制邀请码给好友</div>
									<div class="rec_group_third recom_hrefCode">
										<div class='rec_btn rec_copyCode_btn' onClick="recon_code_bg.select();document.execCommand('Copy')">复制邀请码</div>
										<input type="text" class="recon_code_bg" id="recon_code_bg">
									</div>
								</div>
								<!-- 复制推荐码end -->
								

								<!-- 复制链接Start -->
								<div class="recon_div_group">
									<div class="rec_group_first">
										<div class="fl recon_cirle">2</div>
										<div class="fl recon_cirle_txt">复制链接</div>
										<div class="clear"></div>
									</div>
									<div class="rec_group_second">复制链接给好友</div>
									<div class="rec_group_third recom_href">
										<div class='rec_btn rec_copyUrl_btn' onClick="copyURL.select();document.execCommand('Copy')">复制链接</div>
										<input type="text" class="copyURL" id="copyURL">
									</div>
								</div>
								<!-- 复制链接end -->
							</div>
						</div>

						<!-- 推荐方式End -->


						<!-- 推荐规则Start -->
						<div class="recommend_rule_box invite_rule_box">
							<h3>奖励规则</h3>
							<div class="recom_rule_content">

								<!-- <p class="invite_role_h1">奖励说明:</p> -->
							   <div class="invite_table">
									<div class="fl inv_tab01">本人+好友，一个月投资累计满</div>
									<div class="fl inv_tab02">额外现金收益</div>
									<div class="fl left_inv_tab">10000</div>
									<div class="fl right_inv_tab">10</div>
									<div class="fl left_inv_tab">20000</div>
									<div class="fl right_inv_tab">20</div>
									<div class="fl left_inv_tab">40000</div>
									<div class="fl right_inv_tab">40</div>
									<div class="fl left_inv_tab">60000</div>
									<div class="fl right_inv_tab">60</div>
									<div class="fl left_inv_tab">80000</div>
									<div class="fl right_inv_tab">80</div>
									<div class="fl left_inv_tab">100000</div>
									<div class="fl right_inv_tab">100</div>
									<div class="fl left_inv_tab">100000以上</div>
									<div class="fl right_inv_tab">180</div>
									<div class="clear"></div>
                               </div>
								
								<p class="mar_top">1、邀请人可通过专属邀请码或链接邀请好友进行注册，投资，邀请人数不限制。</p>
								<p>2、现金收益发放每月结算一次，每月10日前统一打到个人投资账户中，可在平台“账户中心”查看，收益红包可用来继续投资也可提现。</p>
								<p>3、每个月第一日开始统计单月本人+好友投资额，根据当月最后一天24:00累计的投资总额计算收益奖励；平台数据月清，第二月数据重新开始统计。</p>
								<p>4、本活动法律允许范围内的最终解释权归富元汇平台所有。</p>

							</div>
						</div>
						<!-- 推荐规则End -->
					</div>


					<!-- 好友详情内容盒子 -->
					<div class="friends_body" style="display:none;">
						<div class="friends_tab_box">
							<div class="friend_titleBox">
								<p class="p1">用户名</p>
								<p class="p2">真实姓名</p>
								<p class="p3">认购情况</p>
								<p class="p4">首次认购金额</p>
								<p class="p5">首次认购时间</p>
								<p class="p6">注册时间</p>
								<p class="p7">奖励有效期至</p>
								<p class="p8">我的邀请奖励</p>
								<div class="clear"></div>
							</div>
							<div class="friends_tab_content">
								<!-- 每一条邀请好友信息 -->
								<div class="earch_friend_infos">
									<p class="friend_iphone">136****9867</p>
									<p class="real_name_regist">*晓得</p>
									<p class="friend_invest_situation">已投资</p>
									<p class="friend_register_time">3000.00</p>
									<p class="friend_invest_money">2016-01-02</p>
									<p class="friend_invest_money">2016-02-03</p>
									<p class="friend_invest_money">2016-05-03</p>
									<p class="friend_invest_money">5</p>
									<div class="clear"></div>
								</div>
								<%--<!-- 每一条邀请好友信息 -->--%>
								<%--<div class="earch_friend_infos">--%>
									<%--<p class="friend_iphone">136****9867</p>--%>
									<%--<p class="real_name_regist">*晓得</p>--%>
									<%--<p class="friend_invest_situation">已投资</p>--%>
									<%--<p class="friend_register_time">3000.00</p>--%>
									<%--<p class="friend_invest_money">2016-01-02</p>--%>
									<%--<p class="friend_invest_money">2016-02-03</p>--%>
									<%--<p class="friend_invest_money">2016-05-03</p>--%>
									<%--<p class="friend_invest_money">5</p>--%>
									<%--<div class="clear"></div>--%>
								<%--</div>--%>
								<%--<!-- 每一条邀请好友信息 -->--%>
								<%--<div class="earch_friend_infos">--%>
									<%--<p class="friend_iphone">136****9867</p>--%>
									<%--<p class="real_name_regist">*晓得</p>--%>
									<%--<p class="friend_invest_situation">已投资</p>--%>
									<%--<p class="friend_register_time">3000.00</p>--%>
									<%--<p class="friend_invest_money">2016-01-02</p>--%>
									<%--<p class="friend_invest_money">2016-02-03</p>--%>
									<%--<p class="friend_invest_money">2016-05-03</p>--%>
									<%--<p class="friend_invest_money">5</p>--%>
									<%--<div class="clear"></div>--%>
								<%--</div>--%>
								<%--<!-- 每一条邀请好友信息 -->--%>
								<%--<div class="earch_friend_infos">--%>
									<%--<p class="friend_iphone">136****9867</p>--%>
									<%--<p class="real_name_regist">*晓得</p>--%>
									<%--<p class="friend_invest_situation">已投资</p>--%>
									<%--<p class="friend_register_time">3000.00</p>--%>
									<%--<p class="friend_invest_money">2016-01-02</p>--%>
									<%--<p class="friend_invest_money">2016-02-03</p>--%>
									<%--<p class="friend_invest_money">2016-05-03</p>--%>
									<%--<p class="friend_invest_money">5</p>--%>
									<%--<div class="clear"></div>--%>
								<%--</div>--%>
								<%--<!-- 每一条邀请好友信息 -->--%>
								<%--<div class="earch_friend_infos">--%>
									<%--<p class="friend_iphone">136****9867</p>--%>
									<%--<p class="real_name_regist">*晓得</p>--%>
									<%--<p class="friend_invest_situation">已投资</p>--%>
									<%--<p class="friend_register_time">3000.00</p>--%>
									<%--<p class="friend_invest_money">2016-01-02</p>--%>
									<%--<p class="friend_invest_money">2016-02-03</p>--%>
									<%--<p class="friend_invest_money">2016-05-03</p>--%>
									<%--<p class="friend_invest_money">5</p>--%>
									<%--<div class="clear"></div>--%>
								<%--</div>--%>
								<%--<!-- 每一条邀请好友信息 -->--%>
								<%--<div class="earch_friend_infos">--%>
									<%--<p class="friend_iphone">136****9867</p>--%>
									<%--<p class="real_name_regist">*晓得</p>--%>
									<%--<p class="friend_invest_situation">已投资</p>--%>
									<%--<p class="friend_register_time">3000.00</p>--%>
									<%--<p class="friend_invest_money">2016-01-02</p>--%>
									<%--<p class="friend_invest_money">2016-02-03</p>--%>
									<%--<p class="friend_invest_money">2016-05-03</p>--%>
									<%--<p class="friend_invest_money">5</p>--%>
									<%--<div class="clear"></div>--%>
								<%--</div>--%>
								<%--<!-- 每一条邀请好友信息 -->--%>
								<%--<div class="earch_friend_infos">--%>
									<%--<p class="friend_iphone">136****9867</p>--%>
									<%--<p class="real_name_regist">*晓得</p>--%>
									<%--<p class="friend_invest_situation">已投资</p>--%>
									<%--<p class="friend_register_time">3000.00</p>--%>
									<%--<p class="friend_invest_money">2016-01-02</p>--%>
									<%--<p class="friend_invest_money">2016-02-03</p>--%>
									<%--<p class="friend_invest_money">2016-05-03</p>--%>
									<%--<p class="friend_invest_money">5</p>--%>
									<%--<div class="clear"></div>--%>
								<%--</div>--%>
							</div>
						</div>
						<!-- 分页 -->
						<div class="page_box invitefriend">
							<ul id="invite_friend" class="invite_friend"></ul>
						</div>
					</div>

				</div>
				<!-- 内容盒子End -->
				
			</div>
			<!-- 右边账户中心内容区域End -->
			<div class="clear"></div>
		</div>


		
	</div>


	<!-- 错误提示弹窗 -->
	<div class="one_contxt_window">
		<div class="error_txts"></div>
		<div class="error_btns">确认</div>
	</div>

	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>
</body>
</html>



