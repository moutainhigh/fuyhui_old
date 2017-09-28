var cType = '';//证件类型
var cNum = '';//证件号码
var z_handImg= '';//证件正面照
var f_handImg = '';//证件反面照
var bank_img = '';//银行卡正面照
$(function(){
    var rel_name = false,//真实姓名标识
        cardFlag = false,//证件号码标识
        bank_flag = false,//银行卡号标识
        province = false,//省市标识
        citys = false,//县标识
        bank_names = false,//开户银行标识
        wit_pwdss = false,//提现密码标识
        con_witPwds = false;//确认提现密码标识


        // 证件类型js
        if($("#escro_certificate option:selected").text()=='身份证'){      
            $('.id_card').show();
            $('.taiwan_infos').hide();
            $('.hk_infos').hide();
            $('.pt_infos').hide();
            $('.escro_idCard').attr('name','cardId');
            $('.escro_taiwan_idCard').attr('name','taiwan_carid');
            $('.escro_hk_idCard').attr('name','hk_carid');
            $('.escro_pt_idCard').attr('name','ptcardId');
            $('.chinaBoxName').show();
            $('.forginBoxName').hide();
            cType = 1;
        }
        $("#escro_certificate").change(function(){
            if($("#escro_certificate option:selected").text()=='身份证'){      
                $('.id_card').show();
                $('.taiwan_infos').hide();
                $('.pt_infos').hide();
                $('.hk_infos').hide();
                $('.escro_idCard').attr('name','cardId');
                $('.escro_taiwan_idCard').attr('name','taiwan_carid');
                $('.escro_hk_idCard').attr('name','hk_carid');
                $('.escro_pt_idCard').attr('name','ptcardId');
                $('.chinaBoxName').show();
                $('.forginBoxName').hide();
                cType = 1;
            }else if($("#escro_certificate option:selected").text()=='台胞证'){
                $('.id_card').hide();
                $('.pt_infos').hide();
                $('.taiwan_infos').show();
                $('.hk_infos').hide();
                $('.escro_taiwan_idCard').attr('name','cardId');
                $('.escro_hk_idCard').attr('name','hk_carid');
                $('.escro_idCard').attr('name','ch_carid');
                $('.escro_pt_idCard').attr('name','ptcardId');
                $('.chinaBoxName').show();
                $('.forginBoxName').hide();
                cType = 2;
            }else if($("#escro_certificate option:selected").text()=='港澳回乡证'){
                $('.id_card').hide(); 
                $('.taiwan_infos').hide();
                $('.pt_infos').hide();
                $('.hk_infos').show();
                $('.escro_hk_idCard').attr('name','cardId');
                $('.escro_idCard').attr('name','ch_carid');
                $('.escro_taiwan_idCard').attr('name','taiwan_carid');
                $('.escro_pt_idCard').attr('name','ptcardId');
                $('.chinaBoxName').show();
                $('.forginBoxName').hide();
                cType = 3;
            }else{
                $('.id_card').hide(); 
                $('.taiwan_infos').hide();
                $('.hk_infos').hide();
                $('.pt_infos').show();
                $('.escro_hk_idCard').attr('name','ptcardId');
                $('.escro_idCard').attr('name','ch_carid');
                $('.escro_taiwan_idCard').attr('name','taiwan_carid');
                $('.escro_pt_idCard').attr('name','cardId');
                $('.chinaBoxName').hide();
                $('.forginBoxName').show();
                cType = 4;
            }
        });

    // 判断（大陆、港澳台、台胞）真实姓名
    $('#escro_name1').blur(function(){
        var names = /^[\u4e00-\u9fa5 ]{2,15}$/;
        $('.name_error').html('');
        if (this.value==""){
            $('.name_error').html('真实姓名不能为空！');
            rel_name = false;
        }else if(!names.test(this.value)){
            $('.name_error').html('请输入正确的姓名格式！');
            rel_name = false;
        }else{
            rel_name = true;
        }
    });
    // 判断（外国）真实姓名
    $('#escro_name2').blur(function(){
        console.log('waiguoren');
        $('.forign_name_error').html('');
        if (this.value==""){
            $('.forign_name_error').html('真实姓名不能为空！');
            rel_name = false;
        }else if(this.value.length>=29){
            $('.forign_name_error').html('真实姓名过长！');
            rel_name = false;
        }else{
            rel_name = true;
        }
    });
    // 判断身份证号码
    $('#escro_idCard').blur(function(){
        var card_idss = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[A-Z])$/i;
        $('.idCard_error').html('');
        if (this.value==""){
            $('.idCard_error').html('身份证不能为空！');
            cardFlag = false;
        }else if(!card_idss.test(this.value)){
            $('.idCard_error').html('请输入正确身份证格式！');
            cardFlag = false;
        }else{
            cNum = $('#escro_idCard').val();//当身份证号码输入正确以后给证件号码变量赋值
            //查询用户证件号是否已注册
            $.ajax({
                type:'post',
                url:getContextPaths()+'/user/checkCardIdExist',
                dataType:'json',
                data:{
                    cardType:cType,
                    cardid:cNum
                },
                success:function(json){
                    if(json.flag==1){
                        if(json.countFlag==1){
                            $('.idCard_error').html('该身份证号码已存在！');
                            cardFlag = false;
                        }else{
                            cardFlag = true;
                        }
                    }
                }
            });

            
        }
    });
    // 台胞证判断
    $('#escro_taiwan_idCard').blur(function(){
        var tai_rex = /^[a-zA-Z0-9]{8}$/;
        $('.taiId_error').html('');
        if (this.value==""){
            $('.taiId_error').html('台胞证不能为空！');
            cardFlag = false;
        }else if(!tai_rex.test(this.value)){
            $('.taiId_error').html('请输入正确的台胞证格式！');
            cardFlag = false;
        }else{
            cNum = $('#escro_taiwan_idCard').val();//当台胞证号码输入正确以后给证件号码变量赋值
            //查询用户证件号是否已注册
            $.ajax({
                type:'post',
                url:getContextPaths()+'/user/checkCardIdExist',
                dataType:'json',
                data:{
                    cardType:cType,
                    cardid:cNum
                },
                success:function(json){
                    if(json.flag==1){
                        if(json.countFlag==1){
                            $('.taiId_error').html('该台胞证号码已存在！');
                            cardFlag = false;
                        }else if(json.countFlag==2){
                            $('.taiId_error').html('该台胞证号码正在审批中！');
                            cardFlag = false;
                        }else{
                            cardFlag = true;
                        }
                    }
                }
            });
            
        }
    });

    // 港澳通行证判断
    $('#escro_hk_idCard').blur(function(){
        var hk_rex = /^[a-zA-Z0-9]{11}$/;
        $('.hk_error').html('');
        if (this.value==""){
            $('.hk_error').html('港澳通行证不能为空！');
            cardFlag = false;
        }else if(!hk_rex.test(this.value)){
            $('.hk_error').html('请输入正确的港澳通行证格式！');
            cardFlag = false;
        }else{
            cNum = $('#escro_hk_idCard').val();
            //查询用户证件号是否已注册
            $.ajax({
                type:'post',
                url:getContextPaths()+'/user/checkCardIdExist',
                dataType:'json',
                data:{
                    cardType:cType,
                    cardid:cNum
                },
                success:function(json){
                    if(json.flag==1){
                        if(json.countFlag==1){
                            $('.hk_error').html('该港澳通行证号码已存在！');
                            cardFlag = false;
                        }else if(json.countFlag==2){
                            $('.hk_error').html('该港澳通行证号码正在审批中！');
                            cardFlag = false;
                        }else{
                            cardFlag = true;
                        }
                    }
                }
            });
            
        }
    });

    // 护照判断
    $('#escro_pt_idCard').blur(function(){
        $('.pt_error').html('');
        if (this.value==""){
            $('.pt_error').html('护照不能为空！');
            cardFlag = false;
        }else{
            cNum = $('#escro_pt_idCard').val();
            //查询用户证件号是否已注册
            $.ajax({
                type:'post',
                url:getContextPaths()+'/user/checkCardIdExist',
                dataType:'json',
                data:{
                    cardType:cType,
                    cardid:cNum
                },
                success:function(json){
                    if(json.flag==1){
                        if(json.countFlag==1){
                            $('.pt_error').html('该护照号码已存在！');
                            cardFlag = false;
                        }else if(json.countFlag==2){
                            $('.pt_error').html('该护照号码正在审批中！');
                            cardFlag = false;
                        }else{
                            cardFlag = true;
                        }
                    }
                }
            });
            
        }
    });

    // 银行卡号判断
    $('#bank_card').blur(function(){
        var bank_idrex = /^[1-9][0-9]{11,18}$/;
        $('.band_error').html('');
        if (this.value==""){
            $('.band_error').html('银行卡号不能为空！');
            bank_flag = false;
        }else if(!bank_idrex.test(this.value)){
            $('.band_error').html('银行卡号格式不对！');
            bank_flag = false;
        }else{
            $.ajax({
                type:'post',
                url:getContextPaths()+'/user/checkAcctNoExist',
                dataType:'json',
                data:{
                    acctNo:$('#bank_card').val()    
                },
                success:function(json){
                    if(json.flag==0){//0 已使用   1  未使用
                        $('.band_error').html('该银行卡号已被使用');
                        bank_flag = false;
                    }else{
                        bank_flag = true;
                    }
                },
                error:function(){

                }
            });
        }
    });

    // 提现密码判断
    $('#wit_pwd').blur(function(){
        var Pwd_reg = /(.|\d){6,}|([A-Z]+[a-z]+){6,16}/;
        $('.esc_wit_error').html('');
        if (this.value==""){
            $('.esc_wit_error').html('提现密码不能为空！').css('color','#ff5353');
            wit_pwdss = false;
        }else if(!Pwd_reg.test(this.value)){
            $('.esc_wit_error').html('提现密码格式不对！').css('color','#ff5353');
            wit_pwdss = false;
        }else{
            wit_pwdss = true;
            $('.esc_wit_error').html('该密码用于将托管账户资金提现至个人银行卡时使用').css('color','#b3b3b3');
        }
    });

    // 确认提现密码判断
    $('#confirm_witPwd').blur(function(){
        var old_witpwd = $('#wit_pwd').val();
        var con_witpwd = $('#confirm_witPwd').val();
        $('.conwit_error').html('');
        if (this.value==""){
            $('.conwit_error').html('确认提现密码不能为空！');
            con_witPwds = false;
        }else if(old_witpwd != con_witpwd){
            $('.conwit_error').html('两次密码不一致！');
            con_witPwds = false;
        }else{
            con_witPwds = true;
        }
    });

    if($('#esc_account_province option:selected').text()!='省份'){
        province = true;
        $('.adres_error').html('');
    }else{
        province = false;
        $('.adres_error').html('');
    }
    $("#esc_account_province").change(function(){
        if($('#esc_account_province option:selected').text()!='省份'){
            province = true;
            $('.adres_error').html('');
        }else{
            province = false;
            $('.adres_error').html('请选择开户行所在省份！');
        }
    });

    // if($('#esc_account_city option:selected').text()!='县'){
    //     citys = true;
    //     $('.adres_error').html('');
    // }else{
    //     citys = false;
    //     $('.adres_error').html('');
    // }

    // $("#esc_account_city").change(function(){
    //     if($('#esc_account_city option:selected').text()!='县'){
    //         citys = true;
    //         $('.adres_error').html('');
    //     }else{
    //         citys = false;
    //         $('.adres_error').html('请选择开户行所在省市！');
    //     }
    // });

    if($('#esc_act_bank option:selected').text()!='请选择银行'){
        bank_names = true;
        $('.bankName_error').html('');
    }else{
        bank_names = false;
        $('.bankName_error').html('');
    }

    $("#esc_act_bank").change(function(){
        if($('#esc_act_bank option:selected').text()!='请选择银行'){
            bank_names = true;
            $('.bankName_error').html('');
        }else{
            bank_names = false;
            $('.bankName_error').html('请选择开户银行！');
        }
    });

    // 页面加载就去请求省份、开户银行接口显示数据
    $.ajax({
        type:'post',
        url:getContextPaths()+'/user/enterEscrowbefore',
        dataType:'json',
        success:function(json){
            var str1 = '',
                str2 = '';
            // 省份遍历
            for(var i=0,l=json.citycodelist1.length;i<l;i++){
                for(var key in json.citycodelist1[i]){
                    str1 = '<option value='+json.citycodelist1[i].itemno+'>'+json.citycodelist1[i].itemname+'</option>';      
                }
                $('#esc_account_province').append(str1);
                    
            }
            // 银行遍历
            for(var i=0,l=json.bankcodelist.length;i<l;i++){
                for(var key in json.bankcodelist[i]){
                   str2 = '<option value='+json.bankcodelist[i].itemno+'>'+json.bankcodelist[i].itemname+'</option>';        
                }
                $('#esc_act_bank').append(str2);
                    
            }

        }
    });

    // 当选择开户所在省份时请求接口
    $('#esc_account_province').change(function(){
        if($('#esc_account_province option:selected')){
            $('#esc_account_city option').remove(); 
            $.ajax({
                type:'post',
                url:getContextPaths()+'/user/getcityidList1',
                dataType:'json',
                data:{
                    itemno:$('#esc_account_province option:selected').val()
                },
                success:function(json){
                    var str = '';
                    // 县区遍历
                    for(var i=0,l=json.citycodelist2.length;i<l;i++){
                        for(var key in json.citycodelist2[i]){
                           str = '<option value='+json.citycodelist2[i].itemno+'>'+json.citycodelist2[i].itemname+'</option>';        
                        }
                        $('#esc_account_city').append(str);   
                    }
                    
                }
            });
        }
    });


    
    

    // 兼容ie8的placeholder
    $('.escro_taiwan_idCard,.escro_hk_idCard').next('span').css({
        'padding-left':'115px'
    });




    var t_zimg= false,//台胞证手持证件正面照标识
        t_fimg= false,//台胞证手持证件反面照标识
        tbk_img = false,//台胞证银行卡照片标识
        hk_zimg= false,//港澳台手持证件正面照标识
        hk_fimg= false,//港澳台手持证件反面照标识
        hk_bk_img = false,//港澳台银行卡证件照标识
        pt_zimg= false,//护照个人信息页标识
        pt_fimg= false,//护照签名页标识
        pt_bk_img= false;//护照护照银行卡正面标识

    // 检查用户是否选择台胞证的正面照
    $('#taiwan_idCard').change(function(){
        var f = document.getElementById('taiwan_idCard');
        var fv = '';
        if(f.files && f.files[0]){
            fv = (f.files[0].size/1024/1024).toFixed(1);
        }
        
        if($('#taiwan_idCard').val()==''){
            t_zimg = false;
            $('.t_zmsg1').html('请选择手持证件照正面图');
            $('.t_zmsg').html('');
        }else if(!/\.(jpg|jpeg|png|JPG|PNG)$/.test($('#taiwan_idCard').val())){
            t_zimg = false;
            $('.t_zmsg1').html('图片类型必须是.jpeg,jpg,png中的一种');
            $('.t_zmsg').html('');
        }else if(fv>1){
            $('.t_zmsg1').html('图片不能大于1M，请重新选择');
            $('.t_zmsg').html('');
            t_zimg = false;
        }else{
            t_zimg = true;
            $('.t_zmsg1').html('');
            $('.t_zmsg').html($('#taiwan_idCard').val());
        }
    });

    // 检查用户是否选择台胞证的反面照
    $('#taiwan_idCard2').change(function(){
        var f = document.getElementById('taiwan_idCard2');
        var fv = '';
        if(f.files && f.files[0]){
            fv = (f.files[0].size/1024/1024).toFixed(1);
        }
        if($('#taiwan_idCard2').val()==''){
            t_fimg = false;
            $('.t_fmsg2').html('请选择手持证件照反面图');
            $('.t_fmsg').html('');
        }else if(!/\.(jpg|jpeg|png|JPG|PNG)$/.test($('#taiwan_idCard2').val())){
            t_fimg = false;
            $('.t_fmsg2').html('图片类型必须是.jpeg,jpg,png中的一种');
            $('.t_fmsg').html('');
        }else if(fv>1){
            $('.t_fmsg2').html('图片不能大于1M，请重新选择');
            $('.t_fmsg').html('');
            t_fimg = false;
        }else{
            t_fimg = true;
            $('.t_fmsg2').html('');
            $('.t_fmsg').html($('#taiwan_idCard2').val());
        }
    });
    

    // 检查用户是否选择台胞证的银行卡图片
    $('#taiwan_bankCard').change(function(){
        var f = document.getElementById('taiwan_bankCard');
        var fv = '';
        if(f.files && f.files[0]){
            fv = (f.files[0].size/1024/1024).toFixed(1);
        }
        if($('#taiwan_bankCard').val()==''){
            tbk_img = false;
            $('.t_bmsg').html('请选择银行卡正面图');
            $('.tb_zmsg').html('');
        }else if(!/\.(jpg|jpeg|png|JPG|PNG)$/.test($('#taiwan_bankCard').val())){
            tbk_img = false;
            $('.t_bmsg').html('图片类型必须是.jpeg,jpg,png中的一种');
            $('.tb_zmsg').html('');
        }else if(fv>1){
            $('.t_bmsg').html('图片不能大于1M，请重新选择');
            $('.tb_zmsg').html('');
            tbk_img = false;
        }else{
            tbk_img = true;
            $('.t_bmsg').html('');
            $('.tb_zmsg').html($('#taiwan_bankCard').val());
            

        }
    });
    

    // 检查用户是否选择港澳通行证正面照 
    $('#hk_idCard').change(function(){
        var f = document.getElementById('hk_idCard');
        var fv = '';
        if(f.files && f.files[0]){
            fv = (f.files[0].size/1024/1024).toFixed(1);
        }
        if($('#hk_idCard').val()==''){
            hk_zimg = false;
            $('.hk_zmsg1').html('请选择手持证件照正面图');
            $('.hk_zmsg').html('');
        }else if(!/\.(jpg|jpeg|png|JPG|PNG)$/.test($('#hk_idCard').val())){
            hk_zimg = false;
            $('.hk_zmsg1').html('图片类型必须是.jpeg,jpg,png中的一种');
            $('.hk_zmsg').html('');
        }else if(fv>1){
            $('.hk_zmsg1').html('图片不能大于1M，请重新选择');
            $('.hk_zmsg').html('');
            hk_zimg = false;
        }else{
            hk_zimg = true;
            $('.hk_zmsg1').html('');
            $('.hk_zmsg').html($('#hk_idCard').val());
        }
    });

     // 检查用户是否选择港澳通行证反面照 
    $('#hk_idCard2').change(function(){
        var f = document.getElementById('hk_idCard2');
        var fv = '';
        if(f.files && f.files[0]){
            fv = (f.files[0].size/1024/1024).toFixed(1);
        }
        if($('#hk_idCard2').val()==''){
            hk_fimg = false;
            $('.hk_fmsg2').html('请选择手持证件照反面图');
            $('.hk_fmsg').html('');
        }else if(!/\.(jpg|jpeg|png|JPG|PNG)$/.test($('#hk_idCard2').val())){
            hk_fimg = false;
            $('.hk_fmsg2').html('图片类型必须是.jpeg,jpg,png中的一种');
            $('.hk_fmsg').html('');
        }else if(fv>1){
            $('.hk_fmsg2').html('图片不能大于1M，请重新选择');
            $('.hk_fmsg').html('');
            hk_fimg = false;
        }else{
            hk_fimg = true;
            $('.hk_fmsg2').html('');
            $('.hk_fmsg').html($('#hk_idCard2').val());
        }
    });
    

    // 检查用户是否选择港澳通行证的银行卡正面图
    $('#hk_bankCard').change(function(){
        var f = document.getElementById('hk_bankCard');
        var fv = '';
        if(f.files && f.files[0]){
            fv = (f.files[0].size/1024/1024).toFixed(1);
        }
        if($('#hk_bankCard').val()==''){
            hk_bk_img = false;
            $('.hk_bmsg').html('请选择银行卡正面图');
            $('.hkb_zmsg').html('');
        }else if(!/\.(jpg|jpeg|png|JPG|PNG)$/.test($('#hk_bankCard').val())){
            hk_bk_img = false;
            $('.hk_bmsg').html('图片类型必须是.jpeg,jpg,png中的一种');
            $('.hkb_zmsg').html('');
        }else if(fv>1){
            $('.hk_bmsg').html('图片不能大于1M，请重新选择');
            $('.hkb_zmsg').html('');
            hk_bk_img = false;
        }else{
            hk_bk_img = true;
            $('.hk_bmsg').html('');
            $('.hkb_zmsg').html($('#hk_bankCard').val());
        }
    });

    // 检查用户是否选择护照的个人信息页面照
    $('#pt_idCard').change(function(){
        var f = document.getElementById('pt_idCard');
        var fv = '';
        if(f.files && f.files[0]){
            fv = (f.files[0].size/1024/1024).toFixed(1);
        }
        if($('#pt_idCard').val()==''){
            pt_zimg = false;
            $('.pt_zmsg1').html('请选择银行卡正面图');
            $('.pt_zmsg').html('');
        }else if(!/\.(jpg|jpeg|png|JPG|PNG)$/.test($('#pt_idCard').val())){
            pt_zimg = false;
            $('.pt_zmsg1').html('图片类型必须是.jpeg,jpg,png中的一种');
            $('.pt_zmsg').html('');
        }else if(fv>1){
            $('.pt_zmsg1').html('图片不能大于1M，请重新选择');
            $('.pt_zmsg').html('');
            pt_zimg = false;
        }else{
            pt_zimg = true;
            $('.pt_zmsg1').html('');
            $('.pt_zmsg').html($('#pt_idCard').val());
        }
    });

    // 检查用户是否选择护照签名页
    $('#pt_idCard2').change(function(){
        var f = document.getElementById('pt_idCard2');
        var fv = '';
        if(f.files && f.files[0]){
            fv = (f.files[0].size/1024/1024).toFixed(1);
        }
        if($('#pt_idCard2').val()==''){
            pt_fimg = false;
            $('.pt_fmsg2').html('请选择银行卡正面图');
            $('.pt_fmsg').html('');
        }else if(!/\.(jpg|jpeg|png|JPG|PNG)$/.test($('#pt_idCard2').val())){
            pt_fimg = false;
            $('.pt_fmsg2').html('图片类型必须是.jpeg,jpg,png中的一种');
            $('.pt_fmsg').html('');
        }else if(fv>1){
            $('.pt_fmsg2').html('图片不能大于1M，请重新选择');
            $('.pt_fmsg').html('');
            pt_fimg = false;
        }else{
            pt_fimg = true;
            $('.pt_fmsg2').html('');
            $('.pt_fmsg').html($('#pt_idCard2').val());
        }
    });

    // 检查用户是否选择护照银行卡正面照
    $('#pt_bankCard').change(function(){
        var f = document.getElementById('pt_bankCard');
        var fv = '';
        if(f.files && f.files[0]){
            fv = (f.files[0].size/1024/1024).toFixed(1);
        }
        if($('#pt_bankCard').val()==''){
            pt_bk_img = false;
            $('.pt_bmsg').html('请选择银行卡正面图');
            $('.ptb_zmsg').html('');
        }else if(!/\.(jpg|jpeg|png|JPG|PNG)$/.test($('#pt_bankCard').val())){
            pt_bk_img = false;
            $('.pt_bmsg').html('图片类型必须是.jpeg,jpg,png中的一种');
            $('.ptb_zmsg').html('');
        }else if(fv>1){
            $('.pt_bmsg').html('图片不能大于1M，请重新选择');
            $('.ptb_zmsg').html('');
            pt_bk_img = false;
        }else{
            pt_bk_img = true;
            $('.pt_bmsg').html('');
            $('.ptb_zmsg').html($('#pt_bankCard').val());
        }
    });

    


    var card_id_flag = true;
    $(".btn-primary").click(function(){
        if(cType==1){//用户选择的证件是身份证时
           if(rel_name && cardFlag && bank_flag && province && bank_names && wit_pwdss && con_witPwds){
                if(card_id_flag){
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/fy/registerjiekou',
                    dataType:'json',
                    data:{
                        mobile:$('#escro_iphone').val(),
                        realname:$('#escro_name1').val(),
                        cardType:cType,
                        cardId:cNum,
                        capAcntNo:$('#bank_card').val(),
                        country_id:$('#esc_account_province option:selected').val(),
                        city_id:$('#esc_account_city option:selected').val(),
                        parent_bank_id:$('#esc_act_bank option:selected').val(),
                        password:$('#wit_pwd').val()
                    },
                    beforeSend:function(){
                        $(".btn-primary").html('提交中...');
                        card_id_flag = false;
                    },
                    success:function(json){ 
                     if(json.flag==1){              
                          $('body').append("<div class='hide_body'></div>");
                            $('.alert-Con').show(800);
                            $('.alertText').html('恭喜您，富友账户开通成功。').css('color','#0bf');
                            $('.esc-accClose').click(function(){
                                window.location.href=getContextPaths()+'/myAccount/enterBUserAccount';
                            });
                       }else{
                            $('body').append("<div class='hide_body'></div>");
                            $('.alert-Con').show(800);
                            $('.alertText').html(json.msg);
                            //关闭加载时页面的弹出框
                            $('.esc-accClose').click(function(){
                                $('.hide_body').remove();
                                $('.hide-ale').hide(800);

                            });
                            card_id_flag = true;
                            $(".btn-primary").html('提交');
                       }
                        
                    },
                    error:function(){
                        card_id_flag = true;
                        $(".btn-primary").html('提交');
                    }
                });
            }

           }else{
                
                $(".escro_contentBox :input").trigger('blur');
                $(".esc_select").trigger('change');
                return false;
           }
        }else if(cType==2){
            if(t_zimg && t_fimg && tbk_img && rel_name && cardFlag && bank_flag && province && bank_names && wit_pwdss && con_witPwds){
                $("#gatForm").ajaxSubmit({
                    type : "post",//提交类型  
                    dataType : "json",//返回结果格式  
                    url : getContextPaths() + "/gatOpenAccount",//请求地址   
                    beforeSend:function(){
                        $(".btn-primary").html('提交中...').unbind('click');
                        // $(".btn-primary").html('提交中...').removeClass('btn-primary');
                    },
                    success : function(json){//请求成功后的函数 
                        if(json.flag==1){
                            z_handImg = json.idCardUrl;//正面照
                            f_handImg = json.idCard2Url;//反面照
                            bank_img = json.bankCardUrl;//银行卡正面照
                            //当点击提交按钮时触发
                            submitFunction($('#escro_name1').val());

                        }else if(json.flag ==0){
                            $(".btn-primary").html('提交').bind('click');
                            errorWindow(json.msg);
                        }
                    }
                });
            }else{
                
                $(".escro_contentBox :input").trigger('blur');
                $(".esc_select").trigger('change');
                $('.taiwan_id_cardImg :input').trigger('change');
                return false;
           }
              
        }else if(cType==3){
            if(hk_zimg && hk_fimg && hk_bk_img && rel_name && cardFlag && bank_flag && province && bank_names && wit_pwdss && con_witPwds){
                $("#hkForm").ajaxSubmit({
                    type : "post",//提交类型  
                    dataType : "json",//返回结果格式  
                    url : getContextPaths() + "/gatOpenAccount",//请求地址   
                    beforeSend:function(){
                         $(".btn-primary").html('提交中...').unbind('click');
                        // $(".btn-primary").html('提交中...').removeClass('btn-primary');
                    },
                    success : function(json){//请求成功后的函数 
                        if(json.flag==1){
                            z_handImg = json.idCardUrl;//正面照
                            f_handImg = json.idCard2Url;//反面照
                            bank_img = json.bankCardUrl;//银行卡正面照
                            //当点击提交按钮时触发
                            submitFunction($('#escro_name1').val());

                        }else if(json.flag ==0){
                            $(".btn-primary").html('提交').bind('click');
                            errorWindow(json.msg);
                        }
                    }
                });
            }else{
                
                $(".escro_contentBox :input").trigger('blur');
                $(".esc_select").trigger('change');
                $('.hk_id_cardImg :input').trigger('change');
                return false;
           }
            
        }else if(cType==4){
            if(pt_zimg && pt_fimg && pt_bk_img && rel_name && cardFlag && bank_flag && province && bank_names && wit_pwdss && con_witPwds){
                $("#passportForm").ajaxSubmit({
                    type : "post",//提交类型  
                    dataType : "json",//返回结果格式  
                    url : getContextPaths() + "/gatOpenAccount",//请求地址   
                    beforeSend:function(){
                         $(".btn-primary").html('提交中...').unbind('click');
                        // $(".btn-primary").html('提交中...').removeClass('btn-primary');
                    },
                    success : function(json){//请求成功后的函数 
                        if(json.flag==1){
                            z_handImg = json.idCardUrl;//正面照
                            f_handImg = json.idCard2Url;//反面照
                            bank_img = json.bankCardUrl;//银行卡正面照
                            //当点击提交按钮时触发
                            submitFunction($('#escro_name2').val());

                        }else if(json.flag ==0){
                            $(".btn-primary").html('提交').bind('click');
                            errorWindow(json.msg);
                        }
                    }
                });
            }else{  
                $(".escro_contentBox :input").trigger('blur');
                $(".esc_select").trigger('change');
                $('.pt_id_cardImg :input').trigger('change');
                return false;
           }
        }
            
    });
        


  


















});

 








//封装点击'提交'按钮时的ajax接口请求
function submitFunction(names){
    $.ajax({
        type:'post',
        url:getContextPaths()+'/fy/registerjiekou',
        dataType:'json',
        data:{
            mobile:$('#escro_iphone').val(),
            realname:names,
            cardType:cType,
            cardId:cNum,
            capAcntNo:$('#bank_card').val(),
            country_id:$('#esc_account_province option:selected').val(),
            city_id:$('#esc_account_city option:selected').val(),
            parent_bank_id:$('#esc_act_bank option:selected').val(),
            password:$('#wit_pwd').val(),
            cardPic:z_handImg,
            card2Pic:f_handImg,
            bankCardPic:bank_img
        },
        success:function(json){ 
         if(json.flag==1){              
              $('body').append("<div class='hide_body'></div>");
                $('.alert-Con').show(800);
                $('.alertText').html('恭喜您，富友账户开通成功。').css('color','#0bf');
                $('.esc-accClose').click(function(){
                    window.location.href=getContextPaths()+'/myAccount/enterBUserAccount';
                });
           }else{
                $('body').append("<div class='hide_body'></div>");
                $('.alert-Con').show(800);
                $('.alertText').html(json.msg);
                //关闭加载时页面的弹出框
                $('.esc-accClose').click(function(){
                    window.location.href=getContextPaths()+'/myAccount/enterBUserAccount';
                });
           }
            
        },
        error:function(){
            // console.log(10);
        }
    });
}