<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <script type="text/javascript">
	$(function() {
		$.ajax({
	    	type: 'GET',
	        url : "enterLogin",
	        success : function(jsondata){
	            
	        }
	    });
	});
</script> -->
	<div id='header'>
		<!-- 头部顶部内容 -->
		<div class="top_nav">
			<div class="top_nav_inner">
				<div class="fl top_nav_left">
					<!-- <p class='fl top_site_bg'></p>
					<p><a href="${pageContext.request.contextPath }/">首页</a></p>
					<p><a href="javascript:void(0);">富元汇</a></p>
					<p><a href="javascript:void(0);">富分期</a></p>
					<p><a href="javascript:void(0);">富宝袋</a></p>
					<p><a href="javascript:void(0);">商城</a></p>
					<p><a href="javascript:void(0);">论坛</a></p> -->
					<p style="margin-left:6px">客服热线：4009-303-606</p>
					<div class="clear"></div>
				</div>
				<div class="fr top_nav_right">
					<ul class="nav_list">
					<c:if test="${not empty sessionScope.user_inf }">
						<li>您好&nbsp;<a href="javascript:void(0);" id="userName" onclick="window.location.href=getContextPaths()+'/myAccount/enterBUserAccount'">${sessionScope.user_inf.username}</a></li>
						<li class="nav_list_line">|</li>
						<li><a href="javascript:void(0);" onclick="window.location.href=getContextPaths()+'/user/logout'">退出</a></li>
					</c:if>
					<c:if test="${empty sessionScope.user_inf }">
						<li><a href="javascript:void(0);" onclick="window.location.href=getContextPaths()+'/user/register'">注册</a></li>
						<li class="nav_list_line">|</li>
						<li><a href="javascript:void(0);" onclick="window.location.href=getContextPaths()+'/enterLogin'">登录</a></li>
					</c:if>	
						<!-- <li class="nav_list_line">|</li>
						<li><a href="javascript:void(0);">APP下载</a></li> -->
						<li class="nav_list_line">|</li>
						<li><a href="javascript:void(0);" onclick="window.location.href=getContextPaths()+'/enterHelpCenter'">帮助中心</a></li>
						<li>
							<a href="javascript:void(0);" onclick="window.location.href=getContextPaths()+'/enterNewGuideline'">新手指引</a>
						</li>
						<!-- <li class="nav_list_line">|</li>
						<li><a href="javascript:void(0);">我的收藏</a></li>
						<li class="collect_bg"></li> -->
						<li class="clear"></li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<!-- 头部导航内容 -->
		<div class="top_main">
			<div class="top_main_inner">
				<div class="fl top_main_left">
					<div class="fl fujb_logo" onclick="window.location.href='${pageContext.request.contextPath }/'"></div>
					<div class="fl fujb_bg"></div>
					<div class="fl logo_txt">
						富士康科技集团<br>
						旗下互联网金融服务平台
					</div>
					<div class="clear"></div>
				</div>
				<div class="fr top_main_right">
					<ul class="main_list">
						<li class="com_li01 site active" onclick="window.location.href='${pageContext.request.contextPath }/'">首页</li>
						<li class="com_li myfinancials" onclick="window.location.href=getContextPaths()+'/enterInvest'">金猪系列</li>
						<li class="com_li mykumquat" onclick="window.location.href=getContextPaths()+'/enterKumquatList'">金桔系列</li>
						
						<!-- <li class="com_li myborrows" onclick="window.location.href=''">我要借款</li> -->
						<!-- <li class="com_li prozhuizong" onclick="window.location.href='/myAccount/enterProduct'">项目追踪</li> -->
						<li class="com_li aboutswe" onclick="window.location.href=getContextPaths()+'/enterCompanyIntroduction'">关于我们</li>
						<li class="com_li newGuide" onclick="window.location.href=getContextPaths()+'/enterSecurityPage'" style="margin-right:20px;">安全保障</li>
						<li class="account myaccounts" onclick="window.location.href=getContextPaths()+'/myAccount/enterUserAccount'">我的账户</li>
						<li class="clear"></li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>