<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<style type="text/css">
		.site_inside_info,.my_basic_info,.money_overview,.finan_center
		{
			font-size: 16px;
			font-weight: bold;
			color: #4a4a4a;
		}
	</style>
	<div class="fl account_leftMenu_box">
		<div class="aCenter_name">账户中心</div>
		<div class="acc_lMenuCont_body">
			<p class="aMenu_active money_overview active" onclick="window.location.href='/myAccount/enterUserAccount'">账户总览</p>

			<p class="aMenu_active finan_center" onclick="window.location.href='/myAccount/enterMycreditor'">资产管理</p>
			<p class="aMenu_active my_dbborrow" onclick="window.location.href='/myAccount/enterMycreditor'">&gt;金桔系列</p>
			<p class="aMenu_active apply_during" onclick="window.location.href='/myAccount/enterApplyDuring'">&gt;金猪系列</p>
			<!-- <p class="aMenu_active receivable_plan" onclick="window.location.href='/invest/user/ApplyRecoverList?userid=${sessionScope.user_inf.userId}'">&gt;回款计划</p> -->

			<!-- <p class="aMenu_Noactive borrow_center">借款中心</p>
			<p class="aMenu_active my_borrows" onclick="window.location.href='/account/enterMyborrow?userid=${sessionScope.user_inf.userId}'">&gt;我的借款</p>
			<p class="aMenu_active borrow_during" onclick="window.location.href='/myAccount/enterBorrowDuring'">&gt;申请中</p> -->

			<p class="aMenu_Noactive trad_center" onclick="window.location.href='/account/enterRecharge'">交易记录</p>
			<p class="aMenu_active top_up" onclick="window.location.href='/account/enterRecharge'">&gt;充值</p>
			<p class="aMenu_active withdrawal" onclick="window.location.href='/account/enterWithdrawal'">&gt;提现</p>
			<p class="aMenu_active trad_detail" onclick="window.location.href='/myAccount/enterTraderecord'">&gt;交易明细</p>

			<p class="aMenu_Noactive my_award" onclick="window.location.href='/myAccount/enterInvitefriend'">我的奖励</p>
			<p class="aMenu_active my_invite" onclick="window.location.href='/myAccount/enterInvitefriend'">&gt;邀请好友</p>
			<p class="aMenu_active my_coupons account_tips" onclick="window.location.href='/myAccount/enterCoupons'">
				&gt;优惠券
				<span class="aTips_box"><span class='coupons_aTips_nums'>0</span></span>	
			</p>

			<!-- <p class="aMenu_Noactive security_info">账户信息</p> -->
			<p class="aMenu_active my_basic_info" onclick="window.location.href='/myAccount/enterPersonalinfos'">账户设置</p>
			<!-- <p class="aMenu_active my_basic_info" onclick="window.location.href='/myAccount/enterPersonalinfos'">&gt;个人信息</p> -->
			<!-- <p class="aMenu_active bank_info" onclick="window.location.href=''">&gt;银行存管信息</p> -->
			<!-- <p class="aMenu_active site_inside_info" onclick="window.location.href='/myAccount/enterSiteinfo'">&gt;站内信</p> -->



			<p class="aMenu_active site_inside_info" onclick="window.location.href='/myAccount/enterSiteinfo'">消息中心</p>

			<!-- <p class="infos_center account_tips">
				消息中心
				<span class="info_aTips_box"><span class='info_aTips_nums'>10</span></span>
			</p>
			<p class="aMenu_active site_inside_info" onclick="window.location.href='/myAccount/enterSiteinfo'">&gt;站内信息</p>
			<p class="aMenu_active info_setup" onclick="window.location.href=''">&gt;信息设置</p> -->
		</div>
	</div>


	<script type="text/javascript">
		$(function(){
			// 当页面一加载就去请求可用的红包接口一次
		    var tto = 0;
		    $.ajax({
		        type:'post',
		        url:getContextPaths()+'/searchRedAward',
		        dataType:'json',
		        async: false,//同步
		        data:{
		            flag:1
		        },
		        success:function(json){
		            $('.coupons_aTips_nums').html(json.totalAccount);
		        }
		    });




		    //当点击账户设置按钮时就请求一下该接口
		    $('.my_basic_info').click(function(){
		    	$.ajax({
					type:'post',
					url:getContextPaths()+'/user/updateUserSession',
					dataType:'json',
					success:function(json){
					},
					error:function(){

					}
				});
		    });



		});



	</script>