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
    <title>账户总览-账户中心-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/index.js'></script>
</head>
<body>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
					// alert("${param.msg}");
				</script>
	</c:if>
	<!--  账户中心-->
	<div class="warp_account_center">
		<!-- 资产总览内容区域 -->
		<div class="user_account1000">
			<!-- 引入左边菜单导航栏 -->
			<%@ include file="leftMenu.jsp"%>
			<!-- 右边账户中心内容区域Start -->
			<div class="fl account_rightContent_box">
				<div class="acc_rigContent_name" style="height:24px;text-indent:-9999px;">我的资产</div>
				<!-- 内容盒子Start -->
				<div class="acc_rigBotContent_box" style="margin-top:-24px;">
					<div class="my_assets_box">
						<div class="fl user_account_infoBox">
							<!-- 用户头像 -->
							<div style="position:relative;">
								<div class="fl account_heads" id="imgdiv" onclick="window.location.href=getContextPaths()+'/myAccount/enterPersonalinfos'">
									<img id="imgShow" uavatar='${sessionScope.user_inf.avatar}'  width=100% height=auto border=0 src=''>
								</div>
								<!-- <input type="file" class='acc_upload' id="up_img"> -->
							</div>
							
							<div class="fl account_usInfos" style="margin-top:12px;">
								<p class="acc_userIphone" style="margin-top:14px;">${sessionScope.user_inf.mobile}</p>
								<!-- <p class="acc_dengji">
									<span>等级：<span class='acc_com_span dengji'>V1</span></span>
									<span>积分：<span class='acc_com_span jifen'>6666</span></span>
								</p> -->
								<!-- <p class="acc_set_up">
									<span class='uIphone_bgImg'></span>
									<span class='uHead_bgImg'></span>
									<span class='uSet_up'></span>
								</p> -->
							</div>
						</div>
						<div class="fl total_accountBox">
							<div class="fl total_accounts" style="margin-left:125px;">
								<div class="total_accNums">￥<span class='acc_com_span tAccounts'>${userAccount.total}</span></div>
								<p>资产总额</p>
							</div>
							<!-- <div class="fl total_award">
								<div>红包&nbsp;&nbsp;<span class='acc_com_span award_package'>2</span><span class='acc_com_span'>个</span></div>
								<p>加息劵&nbsp;&nbsp;<span class='acc_com_span award_juan'>1</span><span class='acc_com_span'>张</span></p>
							</div> -->
							<div class="clear"></div>
						</div>
						<div class="fl account_groupsBtnBox">
							<div class="fl top_up_btn acc_comBtn" onclick="window.location.href=getContextPaths()+'/account/enterRecharge'">充值</div>
							<div class="fl acc_invest acc_comBtn" onclick="window.location.href=getContextPaths()+'/enterInvest'">认购</div>
							<div class="fl withdrawal_btn acc_comBtn" onclick="window.location.href=getContextPaths()+'/account/enterWithdrawal'">提现</div>
							<div class="clear"></div>
						</div>
						<div class="clear"></div>
					</div>

					<!-- 账户资金明细Start -->
					<div class="account_details_box">
						<ul class="acc_details_list">
							<li class="acc_detItem01">
								<div><span class='com_moneyFuhao'>￥</span><span class='com_moneyStyle acc_remainMoney'>${userAccount.cash}</span></div>
								<p>可用余额</p>
							</li>
							<li class="acc_detItem02">
								<div><span class='com_moneyFuhao'>￥</span><span class='com_moneyStyle acc_freezeMoney'>${userAccount.frost}</span></div>
								<p>冻结金额</p>
							</li>
							<!-- <li class="acc_detItem03">
								<div><span class='com_moneyFuhao'>￥</span><span class='com_moneyStyle acc_collecteMoney'>${userAccount.awaitIncome}</span></div>
								<p>待收本金</p>
							</li> -->
							<li class="acc_detItem03">
								<div><span class='com_moneyFuhao'>￥</span><span class='com_moneyStyle acc_collecteMoney'>${userAccount.awaitIncome}</span></div>
								<p>待收金额</p>
							</li>
							<!-- <li class="acc_detItem04">
								<div><span class='com_moneyFuhao'>￥</span><span class='com_moneyStyle acc_stillMoney'>${userAccount.awaitRepay}</span></div>
								<p>待收利息</p>
							</li> -->
							<li class="acc_detItem04">
								<div><span class='com_moneyFuhao'>￥</span><span class='com_moneyStyle acc_stillMoney'>${userAccount.sumIncome}</span></div>
								<p>累计收益</p>
							</li>
						</ul>
						<div class="clear"></div>
					</div>
					<!-- 账户资金明细End -->
	
					<!-- 投资数据Start -->
					<!-- <div class="acc_invest_dataBox">
						<h5>投资数据</h5>
						<ul class="acc_investData_list">
							<li class="acc_iData_item01">
								<div class="fl iDate_item01_bg"></div>
								<div class="fl iDate_rateBox">
									<div><span class='com_moneyFuhao'>￥</span><span class="iDate_rate">12290.00</span></div>
									<p>累计收益</p>
									<h6>去理财</h6>
								</div>
								<div class="clear"></div>
							</li>
							<li class="acc_iData_item02">
								<div class="fl iDate_item02_bg"></div>
								<div class="fl iDate_todayRateBox">
									<div><span class='com_moneyFuhao'>￥</span><span class="iDate_todayRate">12290.00</span></div>
									<p>今日收益</p>
									<h6>如何提升收益？</h6>
								</div>
								<div class="clear"></div>
							</li>
							<li class="acc_iData_item03">
								<div class="fl iDate_item03_bg"></div>
								<div class="fl iDate_awardBox">
									<div><span class='com_moneyFuhao'>￥</span><span class="iDate_awards">12290.00</span></div>
									<p>推广奖励</p>
									<h6>马上邀请好友</h6>
								</div>
								<div class="clear"></div>
							</li>
						</ul>
						<div class="clear"></div>
					</div> -->
					<!-- 投资数据End -->

					<!-- 推荐项目Start -->
					<div class="acc_invite_projectBox">
						<h5>推荐产品</h5>
						<ul class="acc_iProject_list">
							<!-- <li class="iProject_item01">
								<div class="iProject_title">分期消费160822</div>
								<div class="iPro_tList">
									<div class="fl tList_box01">
										<p>10.0%</p>
										<div class="com_invite_pro">预计收益</div>
									</div>
									<div class="fl tList_box02">
										<p>50<span>万</span></p>
										<div class="com_invite_pro">筹款金额</div>
									</div>
									<div class="fl tList_box03">
										<p>3<span>个月</span></p>
										<div class="com_invite_pro">投资期限</div>
									</div>
									<div class="clear"></div>
								</div>
								<div class="iPro_btn">立即投资</div>
							</li> -->
							<!-- <li class="iProject_item02">
								<div class="iProject_title">分期消费160822</div>
								<div class="iPro_tList">
									<div class="fl tList_box01">
										<p>10.0%</p>
										<div class="com_invite_pro">预计收益</div>
									</div>
									<div class="fl tList_box02">
										<p>50<span>万</span></p>
										<div class="com_invite_pro">筹款金额</div>
									</div>
									<div class="fl tList_box03">
										<p>3<span>个月</span></p>
										<div class="com_invite_pro">投资期限</div>
									</div>
									<div class="clear"></div>
								</div>
								<div class="iPro_btn">立即投资</div>
							</li> -->
							<!-- <li class="iProject_item03">
								<div class="iProject_title">分期消费160822</div>
								<div class="iPro_tList">
									<div class="fl tList_box01">
										<p>10.0%</p>
										<div class="com_invite_pro">预计收益</div>
									</div>
									<div class="fl tList_box02">
										<p>50<span>万</span></p>
										<div class="com_invite_pro">筹款金额</div>
									</div>
									<div class="fl tList_box03">
										<p>3<span>个月</span></p>
										<div class="com_invite_pro">投资期限</div>
									</div>
									<div class="clear"></div>
								</div>
								<div class="iPro_btn">立即投资</div>
							</li> -->
							
						</ul>
						<div class="clear"></div>

						<!-- 推荐图片专区Start -->
						<!-- <div class="acc_invite_imgBox">
							<ul class="invite_img_list">
								<li class="invite_item01"></li>
								<li class="invite_item02"></li>
								<li class="invite_item03"></li>
							</ul>
							<div class="clear"></div>
						</div> -->
						<!-- 推荐图片专区End -->
					</div>
					<!-- 推荐项目End -->

				</div>
				<!-- 内容盒子End -->
			</div>
			<!-- 右边账户中心内容区域End -->
			<div class="clear"></div>
		</div>


		
	</div>
		
	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>

	<!--JS部分  -->
	<script type="text/javascript">
		$(function(){
			// 默认头像设置
			var uimgs = $('#imgShow').attr('uavatar');
			var imgurls = globalUrl+uimgs;
			// var imgurls = globalUrl+uimgs;
			if(uimgs==''){
				$('#imgShow').attr('src','${pageContext.request.contextPath }/static/images/userAccount/head_photos.png');
			}else{
				$('#imgShow').attr('src',imgurls);
			}



		});



	</script>




</body>
</html>



