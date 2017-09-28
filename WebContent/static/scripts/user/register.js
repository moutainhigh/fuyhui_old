$(function(){
	var uIphone = false;
	var uPwd = false;
	var uCode = false;
	var iphone_code = false;
	var uRecommends_code = 0;
	var flag = false;// 检查手机号码是否存在的标识
	// 判断手机号码
	$("#uIphone").blur(function(){	
		var iphone_reg = /^1[34578]\d{9}$/;
		$('.tips01').html("");	
		$(this).parent().find(".register_error").remove();
		$(this).parent().find(".register_success").remove();
		$(this).removeClass('error');
		if (this.value==""){
			$('.tips01').html("手机号码不能为空").css('color','#ff1c1c');
			var tipimg = $("<span class='register_error'></span>");
			$(this).parent().append(tipimg);
			$(this).addClass('error');
			}else if(!iphone_reg.test(this.value)){
				$('.tips01').html("请输入正确的手机号码").css('color','#ff1c1c');
				$(this).addClass('error');
				var tipimg = $("<span class='register_error'></span>");
				$(this).parent().append(tipimg);			
			}else{
				// 检查手机号是否被注册过 1代表存在 0代表不存在
				$.ajax({
					type:'post',
					url:getContextPaths()+'/user/signup/checkisonly',
					dataType:'json',
					data:{
						value:$("#uIphone").val(),
						type:2
					},
					success:function(json){
						if(json.flag=='1'){
							$('.tips01').html("该手机号码已被注册").css('color','#ff1c1c');
							$("#uIphone").addClass('error');
							var tipimg = $("<span class='register_error'></span>");
							$("#uIphone").parent().append(tipimg);
							flag = true;
						}else{
							var tipimg = $("<span class='register_success'></span>");
							$("#uIphone").parent().append(tipimg);
							uIphone = true;	
							flag = false;
						}
					}
				});
				
			}
	});	


	// 判断密码
	$("#uPwd").blur(function(){	
		var uPwd_reg = /(.|\d){6,}|([A-Z]+[a-z]+){6,16}/;
		$('.tips02').html("");
		$(this).parent().find(".register_error").remove();
		$(this).parent().find(".register_success").remove();
		$(this).removeClass('error');
		if (this.value==""){
			$('.tips02').html("密码不能为空").css('color','#ff1c1c');
			var tipimg = $("<span class='register_error'></span>");
			$(this).parent().append(tipimg);
			$(this).addClass('error');
			uPwd = false;
		}
		else if(this.value.length<6){
			$('.tips02').html("6~16个字符，区分大小写。").css('color','#ff1c1c');
			$(this).addClass('error');
			var tipimg = $("<span class='register_error'></span>");
			$(this).parent().append(tipimg);
			uPwd = false;
		}
		else if(!uPwd_reg.test(this.value)){
				$('.tips02').html("请输入正确的密码").css('color','#ff1c1c');
				$(this).addClass('error');
				var tipimg = $("<span class='register_error'></span>");
				$(this).parent().append(tipimg);
				uPwd = false;			
			}else{
				var tipimg = $("<span class='register_success'></span>");
				$(this).parent().append(tipimg);
				uPwd = true;
			}
	});	

	// 判断验证码
	$("#uCode").blur(function(){	
		$('.tips03').html("");	
		$(this).parent().find(".register_error").remove();
		$(this).parent().find(".register_success").remove();
		$(this).removeClass('error');
		if (this.value==""){
			$('.tips03').html("验证码不能为空").css('color','#ff1c1c');
			var tipimg = $("<span class='register_error'></span>");
			$(this).parent().append(tipimg);
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
							$("#uCode").parent().append(tipimg);
							uCode = true;
						}else{
							$('.tips03').html("验证码输入错误").css('color','#ff1c1c');
							$("#uCode").addClass('error');
							var tipimg = $("<span class='register_error'></span>");
							$("#uCode").parent().append(tipimg);
							uCode = false;
							changeImg();
						}
					}
				});
				
			}
	});	

	//手机验证码判断
	$("#uIphone_code").keyup(function(){	
		$('.tips04').html("");	
		var iphone = $('#uIphone').val();
		var iphone_reg = /^1[34578]\d{9}$/;
		var iphone_codeReg = /^\d{6}$/;
		// if(iphone=='' || !iphone_reg.test(iphone)){
		// 	$('.tips04').html("请输入正确的手机号码才能发送短信").css('color','#ff1c1c');
		// 	return false;
		// }
		$(this).parent().find(".register_error").remove();
		$(this).parent().find(".register_success").remove();
		$(this).removeClass('error');
		if (this.value==""){
			$('.tips04').html("手机验证码不能为空").css('color','#ff1c1c');
			var tipimg = $("<span class='register_error'></span>");
			$(this).parent().append(tipimg);
			$(this).addClass('error');
			iphone_code = false;
			}else if(!iphone_codeReg.test(this.value)){
				$('.tips04').html("请输入正确的手机验证码").css('color','#ff1c1c');
				$(this).addClass('error');
				var tipimg = $("<span class='register_error'></span>");
				$(this).parent().append(tipimg);
				iphone_code = false;			
			}else if(iphone=='' || !iphone_reg.test(iphone)){
				$('.tips04').html("请输入正确的手机号码才能发送短信").css('color','#ff1c1c');
				$(this).addClass('error');
				var tipimg = $("<span class='register_error'></span>");
				$(this).parent().append(tipimg);
				iphone_code = false;
			}else{
				// 检测短信验证码 1代表正确 0代不正确
				$.ajax({
					type:'post',
					url:getContextPaths()+'/user/signup/checkcode',
					dataType:'json',
					data:{
						mobile:$("#uIphone").val(),
						authCode:$("#uIphone_code").val(),
						type : 10,
					},
					success:function(json){
						if(json.flag=='1'){
							var tipimg = $("<span class='register_success'></span>");
							$("#uIphone_code").parent().append(tipimg);
							iphone_code = true;
						}else{
							$('.tips04').html("手机验证码输入错误").css('color','#ff1c1c');
							$("#uIphone_code").addClass('error');
							var tipimg = $("<span class='register_error'></span>");
							$("#uIphone_code").parent().append(tipimg);
							iphone_code = false;
						}
					}
				});
					
			}

	});
	
	// 推荐码判断
	$("#uRecommend_code").blur(function(){
        var recommendCode = /^1[34578]\d{9}$/;
        $('.tips05').html('');  
        $(this).parent().find(".register_error").remove();
        $(this).parent().find(".register_success").remove();
        $(this).removeClass('error');
        if(!recommendCode.test(this.value) && this.value!=''){
            $('.tips05').html('推荐码格式不正确').css('color','#ff1c1c');
            $("#uRecommend_code").addClass('error');
            var tipimg = $("<span class='register_error'></span>");
            $("#uRecommend_code").parent().append(tipimg);
            // uRecommends_code = true;
            uRecommends_code = 1;
        }else if(this.value==''){
        	uRecommends_code = 0;
        }else if(recommendCode.test($("#uRecommend_code").val())){
            // 推荐码校验 1代表成功 0代表失败
            $.ajax({
                type:'post',
                url:getContextPaths()+'/user/checkReferees',
                dataType:'json',
                data:{
                    referees:$("#uRecommend_code").val()
                },
                success:function(json){
                    if(json.flag=='1'){
                        var tipimg = $("<span class='register_success'></span>");
                        $("#uRecommend_code").parent().append(tipimg);
                        uRecommends_code = 2;
                    }else if(json.flag=='0'){
                        $('.tips05').html(json.msg).css('color','#ff1c1c');
                        $("#uRecommend_code").addClass('error');
                        var tipimg = $("<span class='register_error'></span>");
                        $("#uRecommend_code").parent().append(tipimg);
                        uRecommends_code = 1;
                    }
                }
            });
        }
    });


	// 点击'发送验证码'时触发
	var timer = null;
	$('.code_btn').click(function(){
		var iphone = $('#uIphone').val();
		var iphone_reg = /^1[34578]\d{9}$/;
		var tuCode = $('#uCode').val();

		if(iphone=='' || !iphone_reg.test(iphone)){
			alert('请输入正确的手机号码才能发送短信');
			return false;
		}

		if(tuCode==''){
			changeImg();
			alert('请先输入图像验证码');
			return false;
		}

		if(!uCode){
			alert('请先输入正确的图像验证码');
			return false;
		}



		if(flag){
			alert('该手机号码已被注册');
			return false;
		}
		if(iphone_reg.test(iphone)){
			var time = 60;
			function timeCountDown(){
				if(time==0){
					clearInterval(timer);
					$('.code_btn').css({'background':'#7ED321'});
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
		}
		// 发送短信验证码 1代表成功 0代表失败
		$.ajax({
			type:'post',
			url:getContextPaths()+'/user/sendMsg',
			dataType:'json',
			data:{
				mobile:$("#uIphone").val(),
				type:10,
				code:$('#uCode').val()
			},
			success:function(json){
				if(json.flag=='0'){
					changeImg();
					alert(json.msg);
				}
			}
		});


	});
	
	
	//提交
	var reflag = true;
	$(".register_btn").click(function(){
		if($('#register_agreement').is(':checked')){
			if(uRecommends_code==2){
				rsSumbit();
			}else if(uRecommends_code==1){
				console.log(uRecommends_code);
				$("form :input").trigger("blur");
				$("#uIphone_code").trigger('keyup');
			}else{
				rsSumbit();
			}
			
		}else{
			alert('请同意协议！');
			return false;
		}



	});



	function rsSumbit(){
		$("form :input").trigger("blur");
		$("#uIphone_code").trigger('keyup');
			if (uIphone && uPwd && uCode && iphone_code){
				// 向后台提交数据
				if(reflag){
					$.ajax({
						type:'post',
						url:getContextPaths()+'/user/register',
						dataType:'json',
						data:{
							mobile:$("#uIphone").val(),
							password:hex_md5($('#uPwd').val()),
							picCode:$('#uCode').val(),
							authCode:$('#uIphone_code').val(),
							referees:$('#uRecommend_code').val()
						},
						beforeSend:function(){
		                	reflag=false;
		            	},
						success:function(json){
							if(json.flag=='1'){//提交成功
								$('.register_success').remove();
								$('.code_btn').css({'background':'#7ED321','color':'#fff'}).val('发送验证码');
								clearInterval(timer);
								document.getElementById('register_form').reset();//注册成功时清空表单数据
								$('body').append("<div class='regFade'></div>");
								$('.regSuccBox').show(800);
								$('.regSuc_txt').html('恭喜您'+json.msg);
								// $('.regSuc_btn').click(function(){
									if(navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion .split(";")[1].replace(/[ ]/g,"")=="MSIE8.0")
									{
										$('.regSuc_btn').click(function(){
											window.location.href='/myAccount/enterUserAccount';
										});	
									}else{
										$('.regSuc_btn').click(function(){

											window.location.href='/myAccount/enterUserAccount';
											changeImg();
											// history.go(0);
										});
									} 
								// });
							}else{
								// alert('注册失败');
								changeImg();
								$('body').append("<div class='regFade'></div>");
								$('.regSuccBox').show(800);
								$('.regSuc_txt').html('注册失败');
								$('.regSuc_btn').click(function(){
									$('.regFade').remove();
									$('.regSuccBox').hide(800);
								});
								
							}
							reflag = true;
						},
						error:function(){
							reflag = true;
						}
					});
				}
			}else{
				return false;
			}
	}



	// 邀请码
    if(window.location.search.indexOf("?")!= -1){
        var rdCode = window.location.search.substring((window.location.search.indexOf("=")+1));
        $('#uRecommend_code').val(rdCode).focus().attr('readonly','true');
    }







	//动态获取验证码的地址
	$('#imgObj').attr('src',getContextPaths()+'/user/getcode');

	// 当点击验证码图片时触发
	$('#imgObj').click(function(){
		changeImg();
	});

	// 当手机号码输入框得到焦点时触发
	$("#uIphone").focus(function(){
		$('.tips01').html('请输入大陆11位手机号码').css('color','#c2c2c2');
	});

	// 当密码输入框得到焦点时触发
	$("#uPwd").focus(function(){
		$('.tips02').html('请输入6-16位字符，可为大小写字母、数字或符号').css('color','#c2c2c2');
	});

	// 当手机验证码输入框得到焦点时触发
	$("#uIphone_code").focus(function(){
		$('.tips04').html('请输入您手机收到的6位验证码').css('color','#c2c2c2');
	});

	$("#uRecommend_code").focus(function(){
		$('.tips05').html('请输入推荐人手机号码').css('color','#c2c2c2');
	});
	// 当点击密码框旁的眼睛图标时触发
	$('.comeye').click(function(){
		if($('.comeye').hasClass('eyes')){
			//alert(1111);
			$('.comeye').removeClass('eyes').addClass('open_eyes');
			$('#uPwd').attr('type','text');
		}else{
			$('.comeye').removeClass('open_eyes').addClass('eyes');
			$('#uPwd').attr('type','password');
		}
	});
});

// 实时更新验证码
function changeImg()
{
   window.document.getElementById("imgObj").src=$('#imgObj').attr('src')+"?"+Math.random();  
}

