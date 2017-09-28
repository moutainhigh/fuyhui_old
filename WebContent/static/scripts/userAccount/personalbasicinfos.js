$(function(){
    var ie8s = false;//判断浏览器是否是ie8
    // 判断ie8
    if(navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion.match(/8./i)=="8."){
        ie8s = true;
    }else{
        ie8s = false;
    } 
    // 当点击‘头像-设置’按钮时触发
    $('.headSite').click(function(){
        openWindow('.head_window');
    });

    // 当点击‘用户名-设置’按钮时触发
    $('.unameSite').click(function(){
        openWindow('.uname_window');
    });

    // 当点击‘登录密码-设置’按钮时触发
    $('.pwdSite').click(function(){
        openWindow('.pwd_window');
    });

    // 当点击‘手机号-设置’按钮时触发
    // $('.iphoneSite').click(function(){
    //     openWindow('.iphones_window');
    // });

    // 当点击‘手机号-设置’按钮时触发
    $('.emailSite').click(function(){
        openWindow('.email_window');
    });

    // 当点击‘交易密码-设置’按钮时触发
    $('.tradePwdSite').click(function(){
        openWindow('.tradePwd_window');
        $('.t_iphone').text($('.per_iphoneBox .com_perTxt').text());
        var tImgCode = false,
            tIphone = false,
            oldTpwd = false,
            newTpwd = false,
            cTpwd = false;
            $('.timgError').html("");
            $('.tcodeError').html(""); 
        // 图形验证码
        $("#img_code").blur(function(){
            $('.timgError').html("");
            if (this.value==""){
                $('.timgError').html("验证码不能为空");
                tImgCode = false
            }else{
                // 检测验证码是否输入正确
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/user/checkcodeIsRight',
                    dataType:'json',
                    data:{
                        picCode:$("#img_code").val()
                    },
                    success:function(json){
                        if(json.flag=='1'){
                            tImgCode = true;
                        }else{
                            $('.timgError').html("验证码输入错误");
                            tImgCode = false;
                        }
                    }
                });
                
            }
        });

        //手机验证码判断
        $("#trade_code").blur(function(){ 
            var t_codeReg = /^\d{6}$/;
            $('.tcodeError').html("");  
            if (this.value==""){
                $('.tcodeError').html("手机验证码不能为空");
                tIphone = false;
                }else if(!t_codeReg.test(this.value)){
                    $('.tcodeError').html("请输入正确的手机验证码");  
                    tIphone = false;         
                }else{
                    // 检测短信验证码 1代表正确 0代不正确
                    // $.ajax({
                    //     type:'post',
                    //     url:getContextPaths()+'/user/signup/checkcode',
                    //     dataType:'json',
                    //     data:{
                    //         mobile:$("#t_iphone").val(),
                    //         authCode:$("#trade_code").val(),
                    //         type : 10,
                    //     },
                    //     success:function(json){
                    //         if(json.flag=='1'){
                    //             tIphone = true;
                    //         }else{
                    //             $('.tcodeError').html("手机验证码输入错误");
                    //             tIphone = false;
                    //         }
                    //     }
                    // });


                    //温馨提示，这里是为了做测试才把tIphone = true;变为true的
                    tIphone = true; 
                }

        });
        sendCode('.trade_codeBtn','.t_iphone');
        $('.trade_btns').click(function(){
            $(".modeify_site01 input").trigger("blur");
            if(tImgCode && tIphone){
                $('.modeify_site01').hide();
                $('.modeify_site02').show();
            }
        });

        // 旧交易密码
        $('#old_trade_pwd').blur(function(){
            var uPwd_reg = /(.|\d){6,}|([A-Z]+[a-z]+){6,16}/;
            $('.oldpwdError').html('');
            if(this.value  == ''){
                $('.oldpwdError').html('旧交易密码不能为空！');
                oldTpwd = false;
            }else if(!uPwd_reg.test(this.value)){
                $('.oldpwdError').html('请输入正确的密码格式！');
                oldTpwd = false;
            }else{
                oldTpwd = true;
            }
        });

        // 新交易密码
        $('#new_trade_pwd').blur(function(){
            var uPwd_reg = /(.|\d){6,}|([A-Z]+[a-z]+){6,16}/;
            $('.newpwdError').html('');
            if(this.value  == ''){
                $('.newpwdError').html('新交易密码不能为空！');
                newTpwd = false;
            }else if(!uPwd_reg.test(this.value)){
                $('.newpwdError').html('请输入正确的密码格式！');
                newTpwd = false;
            }else{
                newTpwd = true;
            }
        });

        // 确认新交易密码
        $('#confirm_newPwd').blur(function(){
            $('.conpwdError').html('');
            var pwd01 = $('#confirm_newPwd').val();
            var pwd02 = $('#new_trade_pwd').val();
            if(this.value  == ''){
                $('.conpwdError').html('确认新交易密码不能为空！');
                cTpwd = false;
            }else if(pwd02 != pwd01){
                $('.conpwdError').html('两次输入的密码不一致！');
                cTpwd = false;
            }else{
                cTpwd = true;
            }
        });

        $('.trade_confirm_btns').click(function(){
            $(".modeify_site02 input").trigger("blur");
            if(oldTpwd && newTpwd && cTpwd){
                $('#com_fade').remove();
                $('.tradePwd_window').hide(800);
                $('.tradePwdBox .com_perTxt').html('********');
                $('.tradePwdBox .com_perTips').removeClass('per_error_tips').addClass('per_success_tips');
                $('.tradePwdState').text('已设置');
                $('.tradePwdSite').html('<span class="tsp01">修改</span><span class="tsp02">找回密码</span>');
                $('.modeify_site01').show();
                $('.modeify_site02').hide();
                // 清空之前填写的数据
                $('#img_code').val('');
                $('#trade_code').val('');
                $('#old_trade_pwd').val('');
                $('#new_trade_pwd').val('');
                $('#confirm_newPwd').val('');
                $('.tsp02').click(function(){
                    window.location.href = '/user/forget';
                });
            }
        });

    });

    // 当点击‘常用地址-设置’按钮时触发
    $('.addressSite').click(function(){
        openWindow('.address_window');
        // 当点击常用地址弹框里的‘保存’按钮时触发
        var provine = false;
        var citys = false;
        var areas = false;
        var adrs = /^(?=.*?[\u4E00-\u9FA5])[\d\u4E00-\u9FA5]+/;
        // 打开地址弹窗之前首先把数据进行清空
        $('.provincess .selected').text('省');
        $('.cityess .selected').text('市');
        $('.areaess .selected').text('县/区');
        $("#adres_names").val('');
        $('.adress_btns').click(function(){
            if($('.provincess .selected').text()!=='省'){
                provine = true;
            }else{
                provine = false;
            }
            if($('.cityess .selected').text()!=='市'){
                citys = true;
            }else{
                citys = false;
            } 
            if($('.areaess .selected').text()!=='县/区'){
                areas = true;
            }else{
                areas = false;
            }  
            if(!provine || !citys || !areas){
                $('#adress_select').next('.com_werror').html('请选择地址信息！');
                setTimeout(function(){
                    $('#adress_select').next('.com_werror').html('');
                },2000);
            }else if($("#adres_names").val()==''){
                if(ie8s){
                    $("#adres_names").parent().parent().next('.com_werror').html('请输入具体的地址信息');
                    setTimeout(function(){
                        $("#adres_names").parent().parent().next('.com_werror').html('');
                    },2000);
                }else{
                    $("#adres_names").parent().next('.com_werror').html('请输入具体的地址信息');
                    setTimeout(function(){
                        $("#adres_names").parent().next('.com_werror').html('');
                    },2000);
                }
            }else if(!adrs.test($("#adres_names").val())){
                if(ie8s){
                    $("#adres_names").parent().parent().next('.com_werror').html('请输入正确的地址格式！');
                    setTimeout(function(){
                        $("#adres_names").parent().parent().next('.com_werror').html('');
                    },2000);
                }else{
                    $("#adres_names").parent().next('.com_werror').html('请输入正确的地址格式！');
                    setTimeout(function(){
                        $("#adres_names").parent().next('.com_werror').html('');
                    },2000);
                }
            }else{
                var provs = $('.provincess .selected').eq(0).text(),
                    cits = $('.cityess .selected').eq(0).text(),
                    ars = $('.areaess .selected').eq(0).text(),
                    ads = $("#adres_names").val();
                // var str = provs + cits + ars + ads;
                // $('.addressTxt').html(str);
                // $('.addressBox .com_perTips').removeClass('per_error_tips').addClass('per_success_tips');
                // $('.addressState').text('已设置');
                // $('.addressSite').text('修改');
                // console.log(provs);
                // console.log(cits);
                // console.log(ars);
                // console.log(ads);
                
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/user/updatedress',
                    dataType:'json',
                    data:{
                        countryCode1:provs,
                        countryCode2:cits,
                        countryCode3:ars,
                        address:ads
                    },
                    success:function(json){
                        if(json.flag=='1'){//删除成功
                            alert('恭喜您修改成功。');
                            $('#com_fade').remove();
                            $('.address_window').hide(800);
                            history.go(0);
                        }else{//删除失败
                             alert('修改失败。');
                             $('#com_fade').remove();
                             $('.address_window').hide(800);
                             history.go(0);
                        }
                    }
                });
                




            } 
        });
    });


    // 设置常用地址弹窗里的X关闭按钮功能重写
    $('.address_wClose').click(function(){
        history.go(0);
    });








    // 省市区三级联动js调用
    $('#adress_select').ganged({'data': data, 'width': 100, 'height': 40});

    //动态获取验证码的地址
    $('#imgCode').attr('src',getContextPaths()+'/user/checkcode');

    // 当点击验证码图片时触发
    $('#imgCode').click(function(){
        changeImg();
    });  


    // 修改密码部分
    var oldpFlag = false;//旧密码标识
    var newPwdFlag = false;//新登录密码标识
    var newConPwd = false;//确认新登录密码标识
    // 判断旧密码
    $('#per_old_pwd').blur(function(){
        var uPwd_reg = /(.|\d){6,}|([A-Z]+[a-z]+){6,16}/;
        $('.oldcodeError').html('');
        if(this.value  == ''){
            $('.oldcodeError').html('旧密码不能为空！');
            oldpFlag = false;
        }else if(!uPwd_reg.test(this.value)){
            $('.oldcodeError').html('请输入正确的密码格式！');
            oldpFlag = false;
        }else{
            oldpFlag = true;
        }
    });
    // 判断新登录密码
    $('#per_new_pwd').blur(function(){
        var uPwd_reg = /(.|\d){6,}|([A-Z]+[a-z]+){6,16}/;
        $('.newpwdError').html('');
        if(this.value  == ''){
            $('.newpwdError').html('新登录密码不能为空！');
            newPwdFlag = false;
        }else if(this.value.length<6){
            $('.newpwdError').html('请输入6-16位字符，可为大小写字母、数字或符号！');
            newPwdFlag = false;
        }else if(this.value.length>16){
            $('.newpwdError').html('密码长度不能大于16位！');
            newPwdFlag = false;
        }else if(!uPwd_reg.test(this.value)){
            $('.newpwdError').html('请输入正确的密码格式！');
            newPwdFlag = false;
        }else{
            newPwdFlag = true;
        }
    });

    // 判断确认新登录密码
    $('#per_confrim_pwd').blur(function(){
        var p1 = $('.per_new_pwd').val();
        var p2 = $('.per_confrim_pwd').val();
        $('.conpwdError').html('');
        if(this.value  == ''){
            $('.conpwdError').html('确认新登录密码不能为空！');
            newConPwd = false;
        }else if(p1 !=p2){
            $('.conpwdError').html('两次输入的密码不一致！');
            newConPwd = false;
        }else{
            newConPwd = true;
        }
    });
    
    //点击修改密码弹窗里的‘保存’按钮时触发
    $(".pwds_btns").click(function(){
        if(oldpFlag && newPwdFlag && newConPwd){
            // 向后台提交数据
            $.ajax({
                type:'post',
                url:getContextPaths()+'/user/updateUserPassWord',
                dataType:'json',
                data:{
                    userid:$('#per_userid').val(),
                    oldpwd: hex_md5($('#per_old_pwd').val()),
                    newpwd: hex_md5($('#per_new_pwd').val())            
                },
                beforeSend:function(){
                    $(".pwds_btns").html('发送中...');
                },
                success:function(json){
                    if(json.flag=='1'){//更新成功
                        // $('.conpwdError').html(json.msg);
                        if(confirm('恭喜您密码修改成功！')){
                            $('.pwd_window').hide(800);
                            $("#com_fade").hide();
                            history.go(0);
                        }
                        $(".pwds_btns").html('保存');
                        $(".pwds_btns").click(function(){
                            $('.pwd_window').hide(800);
                            $("#com_fade").hide();
                            history.go(0);
                        });
                    }else{//更新失败    
                        setTimeout(function(){
                            $(".pwds_btns").html('保存');
                        },1000);
                        $('.conpwdError').html(json.msg);
                    }
                },
                error:function(){
                    $(".pwds_btns").html('保存');
                }
            });
        }else{
            $("#pwd_wform input").trigger('blur');
        }
    	

    });
    
  
    // 修改手机号js
    // 手机验证码判断
    var per_ihoneFlag = false;
    $("#per_iphoneCode").blur(function(){ 
        var iphone_codeReg = /^\d{6}$/;
        $('.icodeError').html("");  
        if (this.value==""){
            $('.icodeError').html("手机验证码不能为空");
            per_ihoneFlag = false;
            }else if(!iphone_codeReg.test(this.value)){
                $('.icodeError').html("请输入正确的手机验证码");   
                per_ihoneFlag = false;       
            }else{
                // 检测短信验证码 1代表正确 0代不正确
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/user/signup/checkcode1',
                    dataType:'json',
                    data:{
                        userId:$('#per_userids').val(),
                        authCode:$("#per_iphoneCode").val(),
                        type : 34,
                    },
                    success:function(json){
                        if(json.flag=='1'){
                            per_ihoneFlag = true;
                        }else{
                            per_ihoneFlag = false;
                            $('.icodeError').html('验证码错误！');
                            
                        }
                    }
                });
                    
            }

    });

    // 点击'发送验证码'时触发
    var timer02 = null;
    $('.phone_codeBtn').click(function(){
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
        timer02 = setInterval(timeCountDown,1000);
        // 发送短信验证码 1代表成功 0代表失败
        $.ajax({
            type:'post',
            url:getContextPaths()+'/user/sendMsg',
            dataType:'json',
            data:{
                userId:$('#per_userids').val(),
                type:34
            },
            success:function(json){
                if(json.flag=='0'){
                    alert(json.msg);
                }
            }
        });


    });

    //更新手机号码发送ajax信息到后台
    $(".ip_codebtns").click(function(){
        if(per_ihoneFlag){
            $('.site01Box').hide();
            $('.site02Box').show();
        }else{
            $('#per_iphoneCode').trigger("blur");
        }
        

    });

    // 判断新手机号码
    var newFlag = false;
    $("#modify_iphone").blur(function(){  
        var iphone_reg = /^1[34578]\d{9}$/;
        $('.newcodeError').html("");  
        if (this.value==""){
            $('.newcodeError').html("新手机号码不能为空");
            newFlag = false;
        }else if(!iphone_reg.test(this.value)){
            $('.newcodeError').html("请输入正确的手机号码");    
                newFlag = false;       
        }else{
            newFlag = true;  
        }
    });

    $('.ip_btns').click(function(){
        if(newFlag){
            $('.iphones_window').hide();
            $('#com_fade').remove();
        }else{
            $("#modify_iphone").trigger("blur");
            return false;
        }
    });
    // 修改手机号弹窗里的X关闭按钮功能重写
    $('.iphone_wClose').click(function(){
        history.go(0);
    });



    // 设置邮箱部分
    var emailFlag = false;//邮箱标识
    var emailCodeFlag = false;//邮箱验证码标识
    // 判断邮箱
    $('#per_emails').blur(function(){
        var email_reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        $('.eAddresError').html('');
        if(this.value  == ''){
            $('.eAddresError').html('邮箱地址不能为空！');
            emailFlag = false;
        }else if(!email_reg.test(this.value)){
            $('.eAddresError').html('请输入正确的邮箱地址！');
            emailFlag = false;
        }else{
            emailFlag = true;
        }
    });

    // 判断邮箱验证码
    $('#per_emails_code').blur(function(){
        var email_reg = /(.|\d){6,}|([A-Z]+[a-z]+){6,16}/;
        $('.ecodeError').html('');
        if(this.value  == ''){
            $('.ecodeError').html('邮箱验证码不能为空！');
            emailCodeFlag = false;
        }else if(!email_reg.test(this.value)){
            $('.ecodeError').html('请输入正确的邮箱验证码！');
            emailCodeFlag = false;
        }else{
            // 向后台发请求判断邮箱验证码 1成功 0失败
            $.ajax({
                type:'post',
                url:getContextPaths()+'/user/checkEmailcode',
                dataType:'json',
                data:{
                    authCode:$('#per_emails_code').val()
                },
                success:function(json){
                    if(json.flag=='0'){
                        $('.ecodeError').html('邮箱验证码错误。');
                        emailCodeFlag = false;
                    }else{
                        emailCodeFlag = true;
                    }
                }
            });
            
        }
    });

    // 点击'发送验证码'时触发
    var timer03 = null;
    $('#email_codeBtn').click(function(){
        var time = 10;
        if(!emailFlag){
            alert('请输入正确的邮箱才能发送验证码。');
            return false;
        }
        function timeCountDown(){
            if(time==0){
                clearInterval(timer03);
                $('.email_codeBtn').css({'background':'#7ED321'});
                $('.email_codeBtn').val("发送验证码");
                $(".email_codeBtn").removeAttr("disabled");//启用按钮
                return true;
            }
                $('.email_codeBtn').val(time+"S后重发");
                $('.email_codeBtn').css({'background':'#c1c1c1','color':'#fff'});
                $(".email_codeBtn").attr("disabled",'disabled');
                time--;
                return false;
        }
        timeCountDown();
        timer03 = setInterval(timeCountDown,1000);
        // 发送邮箱验证码
        $.ajax({
            type:'post',
            url:getContextPaths()+'/user/sendEmail',
            dataType:'json',
            data:{
                email:$('#per_emails').val(), 
            },
            success:function(json){
                if(json.flag=='0'){
                    alert(json.msg);
                }
            }
        });


    });

    //当点击邮箱弹窗里的'确认'按钮时触发
    $('.emails_btns').click(function(){
        if(emailFlag && emailCodeFlag){
            $.ajax({
                type:'post',
                url:getContextPaths()+'/user/updateUserEmail',
                dataType:'json',
                data:{
                    email:$('#per_emails').val(), 
                },
                success:function(json){
                    if(json.flag=='0'){
                        alert(json.msg);
                    }else{
                        alert('恭喜您，邮箱设置成功。');
                       $('#com_fade').remove();
                       $('.email_window').hide(800);
                       history.go(0); 
                    }
                }
            });
            
        }else{
            $(".email_window input").trigger("blur");
            return false;
        }
    });


    






});

//点击图像设置时触发
$('.address_wClose').click(function(){
    history.go(0);
});





// 对打开弹窗功能进行函数封装
function openWindow(obj){
    $(obj).stop().show(800);
    $('body').append('<div id="com_fade"></div>');
    $('.com_window_close,#com_fade').click(function(){
        $(obj).stop().hide(800);
        $('#com_fade').remove();
        $('.w_inputTxt').val('');
        $('.pwd_window .com_werror').html('');
        history.go(0);
    });
}


// 实时更新验证码
function changeImg()
{
   window.document.getElementById("imgCode").src=$('#imgCode').attr('src')+"?"+Math.random();  
}


// 点击'发送验证码'函数封装
// obj指的是发送验证码按钮，obj02指的是手机号,obj03指的是传递的手机号码

function sendCode(obj,obj02,obj03){
    var timer = null;
    $(obj).click(function(){
        var iphone = $(obj02).val();
        var iphone_reg = /^1[34578]\d{9}$/;
        if(obj03){
            if(iphone=='' || !iphone_reg.test(iphone)){
                alert('请输入正确的手机号码才能发送短信');
                return false;
            }
        }
        // if(iphone_reg.test(iphone)){
            var time = 60;
            function timeCountDown(){
                if(time==0){
                    clearInterval(timer);
                    $(obj).css({'background':'#7ED321'});
                    $(obj).val("发送验证码");
                    $(obj).removeAttr("disabled");//启用按钮
                    return true;
                }
                    $(obj).val(time+"S后重发");
                    $(obj).css({'background':'#c1c1c1','color':'#fff'});
                    $(obj).attr("disabled",'disabled');
                    time--;
                    return false;
                }
                timeCountDown();
                timer = setInterval(timeCountDown,1000);
        // }
        // 发送短信验证码 1代表成功 0代表失败
        // $.ajax({
        //     type:'post',
        //     url:getContextPaths()+'/user/sendMsg',
        //     dataType:'json',
        //     data:{
        //         mobile:$(obj02).val(),
        //         type:30
        //     },
        //     success:function(json){
        //         if(json.flag=='0'){
        //             alert(json.msg);
        //         }
        //     }
        // });


    });
 
}
