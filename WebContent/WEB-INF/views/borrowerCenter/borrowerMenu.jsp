<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<style type="text/css">
		

	</style>
	<div class="fl account_leftMenu_box">
		<div class="aCenter_name">账户中心</div>
		<div class="acc_lMenuCont_body">
			<p class="aMenu_Noactive finan_center" onclick="window.location.href='/myAccount/enterBorrowerProject'">产品管理</p>
			<p class="aMenu_active my_dbborrow" onclick="window.location.href='/myAccount/enterBorrowerProject'">&gt;融资产品</p>
			<!-- <p class="aMenu_active apply_during" onclick="window.location.href='/myAccount/enterDelayProject'">&gt;待还项目</p> -->


			
			<p class="aMenu_Noactive borrow_center" onclick="window.location.href='/myAccount/enterBorrowTraderecord'">交易记录</p>
			<p class="aMenu_active my_borrows" onclick="window.location.href='/myAccount/enterBorrowTraderecord'">&gt;交易明细</p>
			<p class="aMenu_active borrow_during" onclick="window.location.href='/account/enterBorrowRecharge'">&gt;充值</p>
			<p class="aMenu_active borrow_duringes" onclick="window.location.href='/account/enterBorrowWithdrawal'">&gt;提现</p>
			

			<!-- <p class="aMenu_Noactive trad_center">我的账户</p> -->
			<p class="aMenu_active aMenu_Noactive act_site" onclick="window.location.href='/myAccount/enterBorrowPersonalinfos'">账户设置</p>
			<!-- <p class="aMenu_active top_up" onclick="window.location.href='/myAccount/enterBorrowPersonalinfos'">&gt;安全信息</p> -->
			<p class="aMenu_active aMenu_Noactive site_centers" onclick="window.location.href='/myAccount/enterBorrowSiteinfo'">消息中心</p>

		</div>
	</div>



	<script type="text/javascript">
	$(function(){
		var urls = window.location.pathname;
	    if(urls == '/myAccount/enterUserAccount' || urls == '/myAccount/enterBorrowTraderecord'){
	        $('.my_borrows').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }else if(urls == '/myAccount/enterDelayProject'){
	        $('.apply_during').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }else if(urls == '/myAccount/enterBorrowerProject'){
	        $('.my_dbborrow').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }else if(urls == '/account/enterBorrowRecharge'){
	        $('.borrow_during').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }else if(urls == '/account/enterBorrowWithdrawal' || urls=='/myAccount/enterBorrowWithdrawal'){
	        $('.borrow_duringes').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }else if(urls == '/myAccount/enterBorrowPersonalinfos'){
	        $('.act_site').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }else if(urls == '/myAccount/enterBorrowSiteinfo'){
	        $('.site_centers').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }else if(urls.indexOf('/myAccount/enterBorrowerDetail') > -1){
	    	$('.my_dbborrow').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }


	});





	</script>