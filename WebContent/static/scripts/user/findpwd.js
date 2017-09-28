var uIphone = false;//手机号码标识
var flag = false;// 检查手机号码是否存在的标识
$(function(){
	var uCode = false;//验证码标识
	var uPwd = false;//密码标识
	var iphone_code = false;//手机短信验证码标识
	// 判断手机号码
	$("#check_iphone").blur(function(){
		chenkIphone(this,'.ctips01');
	});

	//动态获取验证码的地址
	$('#rimgObj').attr('src',getContextPaths()+'/user/getcode');

	// 当点击验证码图片时触发
	$('#rimgObj').click(function(){
		changeImg();
	});	

	// 判断验证码
	$("#check_Code").blur(function(){	
		$('.ctips02').html("");	
		$(this).parent().find(".check_error").remove();
		$(this).parent().find(".check_success").remove();
		$(this).removeClass('error');
		if (this.value==""){
			$('.ctips02').html("验证码不能为空").css('color','#ff1c1c');
			var tipimg = $("<span class='check_error'></span>");
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
						picCode:$("#check_Code").val()
					},
					success:function(json){
						if(json.flag=='1'){
							var tipimg = $("<span class='check_success'></span>");
							$("#check_Code").parent().append(tipimg);
							uCode = true;
						}else{
							$('.ctips02').html("验证码输入错误").css('color','#ff1c1c');
							$("#check_Code").addClass('error');
							var tipimg = $("<span class='check_error'></span>");
							$("#check_Code").parent().append(tipimg);
							changeImg();
							uCode = false;
						}
					}
				});
				
			}
	});	

	//手机验证码判断
	$("#check_iCode").blur(function(){	
		var iphone_codeReg = /^\d{6}$/;
		var iphone = $('#check_iphone').val();
		var iphone_reg = /^1[34578]\d{9}$/;
		$('.ctips03').html("");	
		$(this).parent().find(".check_error").remove();
		$(this).parent().find(".check_success").remove();
		$(this).removeClass('error');
		if (this.value==""){
			$('.ctips03').html("手机验证码不能为空").css('color','#ff1c1c');
			var tipimg = $("<span class='check_error'></span>");
			$(this).parent().append(tipimg);
			$(this).addClass('error');
			iphone_code = false;
			}else if(!iphone_codeReg.test(this.value)){
				$('.ctips03').html("请输入正确的手机验证码").css('color','#ff1c1c');
				$(this).addClass('error');
				var tipimg = $("<span class='check_error'></span>");
				$(this).parent().append(tipimg);	
				iphone_code = false;		
			}else if(iphone=='' || !iphone_reg.test(iphone)){
				$('.ctips03').html("请输入正确的手机号码才能发送短信").css('color','#ff1c1c');
				$(this).addClass('error');
				var tipimg = $("<span class='check_error'></span>");
				$(this).parent().append(tipimg);	
				iphone_code = false;
			}else{
				// 检测短信验证码 1代表正确 0代不正确
				$.ajax({
					type:'post',
					url:getContextPaths()+'/user/signup/checkcode',
					dataType:'json',
					data:{
						mobile:$("#check_iphone").val(),
						authCode:$("#check_iCode").val(),
						type : 30
					},
					success:function(json){
						if(json.flag=='1'){
							var tipimg = $("<span class='check_success'></span>");
							$("#check_iCode").parent().append(tipimg);
							iphone_code = true;
						}else{
							$('.ctips03').html("手机验证码输入错误").css('color','#ff1c1c');
							$("#check_iCode").addClass('error');
							var tipimg = $("<span class='check_error'></span>");
							$("#check_iCode").parent().append(tipimg);
							iphone_code = false;
						}
					}
				});
					
			}

	});

	// 点击'发送验证码'时触发
	var timer = null;
	$('.phone_codeBtn').click(function(){
		var iphone = $('#check_iphone').val();
		var iphone_reg = /^1[34578]\d{9}$/;
		var tucode = $('#check_Code').val();
		if(iphone=='' || !iphone_reg.test(iphone)){
			alert('请输入正确的手机号码才能发送短信');
			return false;
		}
		if(tucode==''){
			changeImg();
			alert('请输入图像验证码');
			return false;
		}
		if(uCode==''){
			alert('请输入正确的图像验证码');
			return false;
		}
		if(flag){
			alert('该手机号码不存在');
			return false;
		}
		if(iphone_reg.test(iphone)){
			var time = 60;
			function timeCountDown(){
				if(time==0){
					clearInterval(timer);
					$('.phone_codeBtn').css({'background':'#7ED321'});
					$('.phone_codeBtn').val("发送验证码");
					$(".phone_codeBtn").removeAttr("disabled");//启用按钮
					return true;
				}
					$('.phone_codeBtn').val(time+"S后重发");
					$('.phone_codeBtn').css({'background':'#c1c1c1','color':'#fff'});
					$(".phone_codeBtn").attr("disabled",'disabled');
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
				mobile:$("#check_iphone").val(),
				type:30,
				code:$('#check_Code').val()
			},
			success:function(json){
				if(json.flag=='0'){
					// alert(json.msg);
					if(confirm(json.msg)){
						changeImg();
						history.go(0);
					}else{
						history.go(0);
					}
				}
			}
		});


	});
	
	// 当点击验证身份页面的'下一步'按钮时提交数据
	$('.next_btn').click(function(){
		$(".authen_box .check_txt").trigger("blur");
		if (uIphone && uCode && iphone_code){
			// 向后台提交数据
			$.ajax({
				type:'post',
				url:getContextPaths()+'/user/forget',
				dataType:'json',
				data:{
					mobile:$("#check_iphone").val(),
					picCode:$('#check_Code').val(),
					authCode:$('#check_iCode').val(),
					step:1
				},
				success:function(json){
					if(json.flag=='1'){//提交成功
						$('.check_success').remove();
						$('.phone_codeBtn').css({'background':'#7ED321','color':'#fff'}).val('发送验证码');
						clearInterval(timer);
						$('.authenticate').hide();
						$('.resetCode').show();
						$('#reset_iphone').val($("#check_iphone").val());
						//document.getElementById('register_form').reset();//注册成功时清空表单数据
						//alert(json.msg);
						//history.go(0); 
						// window.location.href=$basurl+'/index1';
					}else{
						alert(json.msg);
					}
				}
			});
		}else{
			return false;
		}
	});

	// $('#reset_iphone').blur(function(){
	// 	chenkIphone(this,'.rtips01');
	// });

	// 判断密码
	$("#reset_Code").blur(function(){	
		var uPwd_reg = /(.|\d){6,}|([A-Z]+[a-z]+){6,16}/;
		$('.rtips02').html("");	
		$(this).parent().find(".check_error").remove();
		$(this).parent().find(".check_success").remove();
		$(this).removeClass('error');
		if (this.value==""){
			$('.rtips02').html("密码不能为空").css('color','#ff1c1c');
			var tipimg = $("<span class='check_error'></span>");
			$(this).parent().append(tipimg);
			$(this).addClass('error');
			uPwd = false;
			}else if(!uPwd_reg.test(this.value)){
				$('.rtips02').html("请输入正确的密码").css('color','#ff1c1c');
				$(this).addClass('error');
				var tipimg = $("<span class='check_error'></span>");
				$(this).parent().append(tipimg);
				uPwd = false;			
			}else{
				var tipimg = $("<span class='check_success'></span>");
				$(this).parent().append(tipimg);
				uPwd = true;	
			}
	});

	// 当点击重置密码下面的'下一步'按钮时提交数据
	$('.reset_nextBtn').click(function(){
		$(".resetCode_box .check_txt").trigger("blur");
		if (uPwd){
			// 向后台提交数据
			$.ajax({
				type:'post',
				url:getContextPaths()+'/user/forget',
				dataType:'json',
				data:{
					mobile:$("#reset_iphone").val(),
					password:hex_md5($('#reset_Code').val()),
					authCode:$("#check_iCode").val(),
					step:2
				},
				success:function(json){
					if(json.flag=='1'){//提交成功
						$('.check_success').remove();
						$('.authenticate').hide();
						$('.resetCode').hide();
						$('.complete').show();
					}else{
						alert(json.msg);
					}
				}
			});
		}else{
			return false;
		}
	});

	// 当完成验证之后点击'完成'按钮跳转至登录页面
	$('.complete_btn').click(function(){
		window.location.href=getContextPaths()+'/enterLogin';
	});

});


// 实时更新验证码
function changeImg()
{
   window.document.getElementById("rimgObj").src=$('#rimgObj').attr('src')+"?"+Math.random();  
}
//检查手机号码
function chenkIphone(obj,tips){
	var iphone_reg = /^1[34578]\d{9}$/;
	$(tips).html("");	
	$(obj).parent().find(".check_success").remove();
	$(obj).parent().find(".check_error").remove();
	$(obj).removeClass('error');
	if (obj.value==""){
		$(tips).html("手机号码不能为空").css('color','#ff1c1c');
		var tipimg = $("<span class='check_error'></span>");
		$(obj).parent().append(tipimg);
		$(obj).addClass('error');
		}else if(!iphone_reg.test(obj.value)){
			$(tips).html("请输入正确的手机号码").css('color','#ff1c1c');
			$(obj).addClass('error');
			var tipimg = $("<span class='check_error'></span>");
			$(obj).parent().append(tipimg);			
		}else{
		// 检查手机号是否被注册过 1代表存在 0代表不存在
		$.ajax({
			type:'post',
			url:getContextPaths()+'/user/signup/checkisonly',
			dataType:'json',
			data:{
				value:$(obj).val(),
				type:2
			},
			success:function(json){
				if(json.flag=='1'){
					var tipimg = $("<span class='check_success'></span>");
					$(obj).parent().append(tipimg);
					uIphone = true;
					flag = false;
				}else{
					$(tips).html("该手机号码不存在").css('color','#ff1c1c');
					$(obj).addClass('error');
					var tipimg = $("<span class='check_error'></span>");
					$(obj).parent().append(tipimg);
					flag = true;
				}
			}
		});
		
	}
}