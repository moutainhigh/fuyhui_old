$(function(){
	var uIphone = false;
	var uPwd = false;
	var uCode = false;
	var showFlag = false;//判断是否显示图形验证码
	// 判断登录的手机号码
	$("#login_iphone").blur(function(){	
		var iphone_reg = /^1[34578]\d{9}$/;
		$('.tps01').html("");	
		$(this).removeClass('error');
		if (this.value==""){
			$('.tps01').html("手机号码不能为空").css('color','#ff1c1c');
			$(this).addClass('error');
			uIphone = false;
			}else if(!iphone_reg.test(this.value)){
				$('.tps01').html("请输入正确的手机号码").css('color','#ff1c1c');
				$(this).addClass('error');
				uIphone = false;		
			}else{
				uIphone = true;
			}
	});	

	// 判断登录的密码
	$("#login_pwd").blur(function(){	
		var uPwd_reg = /(.|\d){6,}|([A-Z]+[a-z]+){6,16}/;
		$('.tps02').html("");	
		$(this).removeClass('error');
		if (this.value==""){
			$('.tps02').html("密码不能为空").css('color','#ff1c1c');
			$(this).addClass('error');
			uPwd = false;
			}else if(!uPwd_reg.test(this.value)){
				$('.tps02').html("请输入正确的密码").css('color','#ff1c1c');
				$(this).addClass('error');
				uPwd = false;			
			}else{
				uPwd = true;
			}
	});


	// 判断验证码
	$("#uCode").blur(function(){	
		$('.tps03').html("");	
		$(this).removeClass('error');
		if (this.value==""){
			$('.tps03').html("验证码不能为空").css('color','#ff1c1c');
			$(this).addClass('error');
			uCode = false;
			}else{
				// 检测验证码是否输入正确
				$.ajax({
					type:'post',
					url:getContextPaths()+'/user/checkcodeIsRight',
					dataType:'json',
					data:{
						picCode:$("#uCode").val()
					},
					success:function(json){
						if(json.flag=='1'){
							var tipimg = $("<span class='register_success'></span>");
							uCode = true;
						}else{
							$('.tps03').html("验证码输入错误").css('color','#ff1c1c');
							$("#uCode").addClass('error');
							uCode = false;
							changeImg();
						}
					}
				});
				
			}
	});	

	//动态获取验证码的地址
	$('#imgObj').attr('src',getContextPaths()+'/user/getcode');

	// 当点击验证码图片时触发
	$('#imgObj').click(function(){
		changeImg();
	});



	//提交
	$(".login_btn").click(function(){
		// 向后台提交数据
		if(showFlag){
			if(uIphone && uPwd && uCode){
				$('.login_code').css('display','block');
				$('.login_box').css('top','15px');
				$.ajax({
					type:'post',
					url:getContextPaths()+'/user/login',
					dataType:'json',
					data:{
						mobile:$("#login_iphone").val(),
//						password:hex_md5($('#login_pwd').val()),
						password:$('#login_pwd').val(),
						code:$('#uCode').val()
					},
					beforeSend:function(){
						$(".login_btn").html('发送中...');
					},
					success:function(json){
						if(json.flag=='1'){//登录成功
							setTimeout(function(){
							  document.getElementById('login_form').reset();//登录成功时清空表单数据
							  if(json.url==''){
								  window.location.href = getContextPaths();
							  }else{
								  window.location.href = json.url;
							  }
							},1000);
						}else{//登录失败
							$('.tps01').html(json.msg);
							changeImg();
							$('#uCode').focus();
							$(".login_btn").html('立即登录');
							setTimeout(function(){
								$('.tps01').html('');
							},2500);
							
						}
						
						
					}
				});
			}else{
				$("form :input").trigger("blur");
			}
		}else{
			if(uIphone && uPwd){
				$.ajax({
					type:'post',
					url:getContextPaths()+'/user/login',
					dataType:'json',
					data:{
						mobile:$("#login_iphone").val(),
//						password:hex_md5($('#login_pwd').val())
						password:$('#login_pwd').val()
					},
					beforeSend:function(){
						$(".login_btn").html('发送中...');
					},
					success:function(json){
						if(json.flag=='1'){//登录成功
							setTimeout(function(){
							  document.getElementById('login_form').reset();//登录成功时清空表单数据
							  if(json.url==''){
								  window.location.href = getContextPaths();
							  }else{
								  window.location.href = json.url;
							  }
							},1000);
						}else{//登录失败
							$('.tps01').html(json.msg);
							$(".login_btn").html('立即登录');
							setTimeout(function(){
								$('.tps01').html('');
							},2500);
							
						}
						if(json.isneedCode=='1'){
							showFlag = true;//显示图像验证码
							$('.login_code').css('display','block');
							$('.login_box').css('top','15px');
						}else{
							showFlag = false;//显示图像验证码
							$('.login_code').css('display','none');
							$('.login_box').css('top','40px');
						}
					}
				});
			}else{
				$(".login_iphone").trigger("blur");
				$(".login_pwd").trigger("blur");
			}
		}
			

	});

	
	
	
			


	

	$("body").keydown(function(e){
        if(e.keyCode == 13){
            $(".login_btn").trigger("click");
            $(".login_btn").trigger("click");
        }
    });



});







// 实时更新验证码
function changeImg()
{
   window.document.getElementById("imgObj").src=$('#imgObj').attr('src')+"?"+Math.random();  
}