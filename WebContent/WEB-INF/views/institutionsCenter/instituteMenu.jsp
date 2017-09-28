<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="fl account_leftMenu_box">
		<div class="aCenter_name">机构中心</div>
		<div class="acc_lMenuCont_body">
			<p class="aMenu_Noactive finan_center">我的担保</p>
			<p class="aMenu_active my_dbborrow" onclick="window.location.href='/myAccount/enterGuaranteeProject'">&gt;担保项目</p>
			<p class="aMenu_active apply_during" onclick="window.location.href='/myAccount/enterDaiAdvances'">&gt;待垫付</p>

			<p class="aMenu_Noactive borrow_center">我的资产</p>
			<p class="aMenu_active my_borrows" onclick="window.location.href='/myAccount/enterInsTraderecord'">&gt;交易明细</p>
			<p class="aMenu_active borrow_during as" onclick="window.location.href='/account/enterInsRecharge'">&gt;充值</p>
			<p class="aMenu_active borrow_during es" onclick="window.location.href='/account/enterInsWithdrawal'">&gt;提现</p>

			<p class="aMenu_Noactive trad_center">我的账户</p>
			<p class="aMenu_active top_up" onclick="window.location.href='/myAccount/enterInsPersonalinfos'">&gt;安全信息</p>
			<p class="aMenu_active withdrawal" onclick="window.location.href='/myAccount/enterInsSiteinfo'">&gt;站内信</p>
			
		</div>
	</div>



	<script type="text/javascript">
	$(function(){
		var urls = window.location.pathname;
	    if(urls == '/myAccount/enterUserAccount' || urls == '/myAccount/enterGuaranteeProject'){
	        $('.my_dbborrow').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }else if(urls == '/myAccount/enterDaiAdvances'){
	        $('.apply_during').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }else if(urls == '/myAccount/enterInsTraderecord'){
	        $('.my_borrows').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }else if(urls == '/account/enterInsRecharge'){
	        $('.as').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }else if(urls == '/account/enterInsWithdrawal'){
	        $('.es').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }else if(urls == '/myAccount/enterInsPersonalinfos'){
	        $('.top_up').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }else if(urls == '/myAccount/enterInsSiteinfo'){
	        $('.withdrawal').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }else if(urls.indexOf('/myAccount/enterGuaranteeDetail') > -1){
	    	$('.my_dbborrow').addClass('active');
	        $(this).siblings('.aMenu_active').removeClass('active');
	        $('.site').removeClass('active');
	        $('.myaccounts').addClass('active');
	    }


	});





	</script>