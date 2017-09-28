$(function(){
    // 充值页面'快捷充值和网银充值'按钮切换js
    $('.quick_top_up').click(function(){
        $('.ebank_top_up').removeClass('active');
        $(this).addClass('active');
        $('.quick_box').show();
        $('.eBank_box').hide();
        $('#ebtop_up_amount').val('');
        $('.ebhand_cost').html('0');
    });

    $('.ebank_top_up').click(function(){
        $('.quick_top_up').removeClass('active');
        $(this).addClass('active');
        $('.eBank_box').show();
        $('.quick_box').hide();
        $('#top_up_amount').val('');
        $('.hand_cost').html('0');
    });

    // 兼容ie8 placeholder
    $('#ebtop_up_amount').next('span').css({
        'padding-left':'90px',
        'top':'10px'
    });

    // 快捷充值页面点击"确认充值"按钮触发window.open('你所要跳转的页面')
    // $('.kuaijie_btn').click(function(){
    //     $('body').append('<div id="rec_fade"></div>');
    //     $('.recharge_window').fadeIn(800);
    //     $('.rec_closes').click(function(){
    //         $('.recharge_window').fadeOut(500);
    //         $('#rec_fade').remove();
    //     });
    // });
    

    // 判断快捷充值里的充值金额
    var recharge_num = false;
    $('#top_up_amount').blur(function(){
        // var rech_reg =  /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/;/^d+$/
        var rech_reg = /^d+$/;
        $('.re_error').html('');
        if (this.value==""){
            $('.re_error').html('充值金额不能为空！');
            recharge_num = false;
        }else if(this.value<=99){
            $('.re_error').html('充值金额不能少于100！');
            recharge_num = false;
        }else{
            recharge_num = true;
        }
    });
    // 当点击快捷充值里的“确认充值”时触发
    $('.confirm_top_up input').click(function(){
        if(recharge_num){
            // $('#queck_form').attr('target','_blank');
            // $('body').append('<div id="rec_fade"></div>');
            // $('.recharge_window').fadeIn(800);
            // $('.rec_closes,.rec_success,.rec_question').click(function(){
            //     $('.recharge_window').fadeOut(500);
            //     $('#rec_fade').remove();
            //     history.go(0);
            // });
            return true;
        }else{
            $("#top_up_amount").trigger("blur");
            return false;
        }
    });


    // 判断网银充值里的充值金额
    var ebank_num = false;
    $('#ebtop_up_amount').blur(function(){
        // var e_reg =  /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/;
        var e_reg = /^d+$/;
        $('.eb_error').html('');
        if (this.value==""){
            $('.eb_error').html('充值金额不能为空！');
            ebank_num = false;
        }else if(this.value<=99){
            $('.eb_error').html('充值金额不能少于100！');
            ebank_num = false;
        }else{
            ebank_num = true;
        }
    });
    // 当点击快捷充值里的“确认充值”时触发
    $('.eb_top_upBtn').click(function(){
        if(ebank_num){
            return true;
        }else{
            $("#ebtop_up_amount").trigger("blur");
            return false;
        }
    });

    // 判断提现金额
    var witre_num = false;
    $('#withdrawal_amount').blur(function(){
        // var w_reg =  /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/;
        // var w_reg = /[^\d\.]/g;
        $('.wit_error').html('');
        if (this.value==""){
            $('.wit_error').html('提现不能为空！');
            witre_num = false;
        }else if(this.value<=99){
            $('.wit_error').html('提现金额不能少于100！');
            witre_num = false;
        }else{
            witre_num = true;
        }
    });
    

    // 当点击提现页面里的“确认提现”时触发
    $('#wit_input').click(function(){
        // 判断提现金额和可用余额的关系，如果提现金额大于或者小于可用余额，则不用跳转至富友页面进行提现操作
        if(parseFloat($('#withdrawal_amount').val())>parseFloat($('.avumoney').attr('ams'))){
            // alert('可用金额不足,不能进行提现！'+$('.avumoney').attr('ams'));
            alert('可用金额不足,不能进行提现！');
            return false;
        }
        if(witre_num){
            return true;
        }else{
            $("#withdrawal_amount").trigger("blur");
            return false;
        }
    });

    // 快捷充值
    // 获取收费类型
    var fee_type = $('.hand_fee').attr('formulatype');
    // 固定的手续费
    var fees = $('.feees').attr('fee');
    // 手续费的比例
    var hand_rate = $('.hand_cost').attr('interestRate');

    if(fee_type==1){
        $('#top_up_amount').keyup(function(){
            if($(this).val()){
                var money = $(this).val()*hand_rate;
                $('.hand_cost').html(round2(money,2));
            }else{
                $('.hand_cost').html('0');
            }
        });
    }else if(fee_type==2){
        $('#top_up_amount').keyup(function(){
            if($(this).val()){
                $('.hand_cost').html(fees);
            }else{
                $('.hand_cost').html('0');
            }
        });
    }



    // 网银充值
    // 获取收费类型
    var ebfee_type = $('.ebhand_fee').attr('ebformulatype');
    // 固定的手续费
    var ebfees = $('.ebfees').attr('ebfee');
    // 手续费的比例
    var ebhand_rate = $('.ebhand_cost').attr('ebinterestrate');

    if(ebfee_type==1){
        $('#ebtop_up_amount').keyup(function(){
            if($(this).val()){
                var money = $(this).val()*ebhand_rate;
                $('.ebhand_cost').html(round2(money,2));
            }else{
                 $('.ebhand_cost').html('0');
            }
        });
    }else if(ebfee_type==2){
        $('#ebtop_up_amount').keyup(function(){
            if($(this).val()){
                $('.ebhand_cost').html(ebfees);
            }else{
                $('.ebhand_cost').html('0');
            }
        });
    }




    
    












});



// 判断输入框只能输入数字并且是两位小数
function clearNoNum(obj)
{
   obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符
   obj.value = obj.value.replace(/^\./g,"");  //验证第一个字符是数字而不是.
   obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的.   ^\\d+.\\d{2
   obj.value = obj.value.replace(/\.\d{3,}/g,obj.value.substring(obj.value.indexOf('.'),obj.value.length-1));//只保留两位小数
   obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
}

 