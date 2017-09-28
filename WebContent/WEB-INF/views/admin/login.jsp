<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>富金富后台管理系统-登录</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/login/admin_login.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/scripts/login/login.js"></script>
<script src="../../static/scripts/common/common.js"></script>
<style type="text/css">
	.uIphone_code
	{
		border-radius: 0 0 3px 3px;
	    border: 1px solid #a0a0a0;
	    border-top: 1px solid transparent;
	    width: 224px;
	    height: 50px;
	    line-height: 54px;
	    font-size: 16px;
	    padding-left: 56px;
	    outline: none;
	    color: #9e9e9e;
	}
	#code_btn
	{
		position: absolute;
		top: 12px;
		right: 10px;
		height: 30px;
		line-height: 25px;
		text-align: center;
		cursor: pointer;
		background: #fff;
	    border: 1px solid #c1c1c1;
	    border-radius: 6px;
		outline: none;
		color: #625548;
	}


</style>
</head>
<body>
<div class="page-container">
	<div class="main_box">
		<div class="login_box">
			<div class="login_logo">
				<img src="${pageContext.request.contextPath }/static/images/login/fujbao_logo.png" />
				<span>后台管理系统</span>
			</div>
			<div class="login_form">
				<span id="clear-username">×</span>
				<form>
					<div class="form-group fu-username">
						<div class="user-box">
							<input id="username" name="username" autocomplete="off" type="text" placeholder="用户名/邮箱" value ="">

						</div>

					</div>
					<div class="form-group">
						<input id="password" name="password" autocomplete="off" type="password" placeholder="密码" value ="" style="border-radius:0 !important;">
					</div>
					<div class="form-group fu-username" style="position:relative;">
						<input type="text" name='uIphone_code'  class='uIphone_code' id="uIphone_code" placeholder='手机验证码' maxlength="6" onkeyup="value=value.replace(/[^\d]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" style="ime-mode:disabled">
						<input type="button" class="code_btn" id="code_btn" value="发送验证码">
						<!-- 错误提示语 -->
						<div class="retister_error_tips tips04"></div>
					</div>
					<div class="form-group login-state">
						<div id="login-state-label">
							<div class="check-img">
								<img src="${pageContext.request.contextPath }/static/images/login/checkboxes0.png">
							</div>
							<input id="remember-login-state" type="checkbox"><span>记住登录状态</span>
						</div>
						<a href="#">忘记密码？</a>
					</div>
					<div class="form-group space">
						<input type="button" id="submit_btn" value="&nbsp;登&nbsp;录&nbsp">
					</div>
				</form>
			</div>
		</div>
		<div id="err-tips-box" class="login-err">
			<span></span>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
	 var timer = null;
	 $("#code_btn").click(function(){
		 var iphone = $('#username').val();
		 var iphone_reg = /^1[34578]\d{9}$/;
		 
		 if(iphone=='' || !iphone_reg.test(iphone)){
				alert('请输入正确的手机号码才能发送短信');
				return false;
			}

			var time = 60;
			function timeCountDown(){
				if(time==0){
					clearInterval(timer);
					$('.code_btn').css({'background':'#fff','color':'#625548'});
					$('.code_btn').val("发送验证码");
					$(".code_btn").removeAttr("disabled");//启用按钮
					return true;
				}
					$('.code_btn').val(time+"S后重发");
					$('.code_btn').css({'background':'#c1c1c1','color':'#fff'});
					$(".code_btn").attr("disabled",'disabled');
					time--;
					return false;
				}
			timeCountDown();
			timer = setInterval(timeCountDown,1000);
			// 发送短信验证码 1代表成功 0代表失败
			$.ajax({
				type:'post',
				url:getContextPaths()+'/user/sendMsg',
				dataType:'json',
				data:{
					mobile:$("#username").val(),
					type:14
				},
				success:function(json){
					if(json.flag=='0'){
						alert(json.msg);
					}
					if(json.flag=='1'){
						alert(json.msg);
					}
				}
			});
	    });
});

</script>
</body>
</html>