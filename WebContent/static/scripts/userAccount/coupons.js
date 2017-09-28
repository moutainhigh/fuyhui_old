$(function(){
    // 我的奖励-优惠卷页面'可用的和已使用以及已过期'按钮切换js
    $('.cou_available').click(function(){
        $(this).siblings().removeClass('active');
        $(this).addClass('active');
        $('.cou_available_body').show();
        $('.cou_used_body').hide();
        $('.cou_expired_body').hide();
    });

    $('.cou_hasbeen_used').click(function(){
        $(this).siblings().removeClass('active');
        $(this).addClass('active');
        $('.cou_used_body').show();
        $('.cou_available_body').hide();
        $('.cou_expired_body').hide();
    });

    $('.cou_expired').click(function(){
        $(this).siblings().removeClass('active');
        $(this).addClass('active');
        $('.cou_expired_body').show();
        $('.cou_available_body').hide();
        $('.cou_used_body').hide();
    });


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
            tto = json.totalAccount;
        }
    });
    // 可用的红包接口
    if(tto == 0){
        $('.cou_avail_box').html('没有数据！');
    }else{
        $.ajax({
            type:'post',
            url:getContextPaths()+'/searchRedAward',
            dataType:'json',
            data:{
                flag:1
            },
            success:function(json){
                $('.cou_avail_box').html('');
                var str = '';
                for(var i=0,l=json.content.length;i<l;i++){
                    // 使用时间
                    var user_zhuanhuan = showTime(json.content[i].term);
                    var use_time = user_zhuanhuan.substring(0,10);
                    //使用范围
                    var use_fanwei = json.content[i].minAmount;
                    // 红包类型
                    var pk_type = json.content[i].type;
                    var pk_typeTxt = '';
                    if(pk_type==1){
                        pk_typeTxt = '抵扣券';
                    }else if(pk_type==2){
                        pk_typeTxt = '代金券';
                    }else if(pk_type==3){
                        pk_typeTxt = '体验金';
                    }

                    //红包来源
                    // var originTxt = (json.content[i].origin ==1) ? '注册红包' : '未知来源' ;
                    if(json.content[i].origin ==1){
                        originTxt = '注册红包';
                    }else if(json.content[i].origin ==2){
                        originTxt = '投资红包';
                    }else{
                        originTxt = '未知来源';
                    }
                    for(var key in json.content[i]){
                        str = '<div class="each_avail_reward"><ul class="avail_list"><li class="avail_item01"><div class="avail_item_bg"></div><p class="avail_number">'+
                              json.content[i].id+'</p></li><li class="avail_item02"><h3>'+originTxt+'</h3><p>最低认购限额<span class="cou_limit">'+
                              use_fanwei+'</span>元</p><div>有效期至：'+use_time+'</div></li><li class="avail_item03"><div class="avail_nums">'+
                              json.content[i].initAmount+'</div><p>'+pk_typeTxt+'</p></li></ul><div class="clear"></div></div>';
                            
                    }
                    $('.cou_avail_box').append(str);
                }
            }
        });
    }





    // 当页面一加载就去请求已使用红包接口一次
    var tto02 = 0;
    $.ajax({
        type:'post',
        url:getContextPaths()+'/searchRedAward',
        dataType:'json',
        async: false,//同步
        data:{
            flag:2
        },
        success:function(json){
            tto02 = json.totalAccount;
        }
    });
    
    // 已使用红包接口
    if(tto02 == 0){
        $('.real_use').html('没有数据！');
    }else{
        $.ajax({
            type:'post',
            url:getContextPaths()+'/searchRedAward',
            dataType:'json',
            data:{
                flag:2
            },
            success:function(json){
                $('.real_use').html('');
                var str = '';
                for(var i=0,l=json.content.length;i<l;i++){
                    // 使用时间
                    var use_time = showTime(json.content[i].updated);
                    //使用范围
                    var use_fanwei = '最低认购限额'+json.content[i].minAmount+'元';
                    // 红包类型
                    var pk_type = json.content[i].type;
                    var pk_typeTxt = '';
                    if(pk_type==1){
                        pk_typeTxt = '抵扣券';
                    }else if(pk_type==2){
                        pk_typeTxt = '代金券';
                    }else if(pk_type==3){
                        pk_typeTxt = '体验金';
                    }

                    //红包来源
                    if(json.content[i].origin ==1){
                        originTxt = '注册红包';
                    }else if(json.content[i].origin ==2){
                        originTxt = '投资红包';
                    }else{
                        originTxt = '未知来源';
                    }
                    for(var key in json.content[i]){
                        str = '<div class="each_tab_tr"><p class="cou_number">'+json.content[i].id+'</p><p class="cou_amount">'+
                            json.content[i].initAmount+'元</p><p class="cou_investTime">'+use_time+'</p><p class="cou_user_scope">'+
                            use_fanwei+'</p><p class="cou_type">'+pk_typeTxt+'</p><p class="cou_source">'+originTxt+'</p><div class="clear"></div></div>';
                            
                    }
                    $('.real_use').append(str);
                }
            }
        });
    }



    // 当页面一加载就去请求已过期红包接口一次
    var tto03 = 0;
    $.ajax({
        type:'post',
        url:getContextPaths()+'/searchRedAward',
        dataType:'json',
        async: false,//同步
        data:{
            flag:3
        },
        success:function(json){
            tto03 = json.totalAccount;
        }
    });
    
    // 已过期红包接口
    if(tto03 == 0){
        $('.user_guoqi').html('没有数据！');
    }else{
        $.ajax({
            type:'post',
            url:getContextPaths()+'/searchRedAward',
            dataType:'json',
            data:{
                flag:3
            },
            success:function(json){
                $('.user_guoqi').html('');
                var str = '';
                for(var i=0,l=json.content.length;i<l;i++){
                    // 使用时间
                    var use_time = showTime(json.content[i].term);
                    //使用范围
                    var use_fanwei = '最低认购限额'+json.content[i].minAmount+'元';
                    // 红包类型
                    var pk_type = json.content[i].type;
                    var pk_typeTxt = '';
                    if(pk_type==1){
                        pk_typeTxt = '抵扣券';
                    }else if(pk_type==2){
                        pk_typeTxt = '代金券';
                    }else if(pk_type==3){
                        pk_typeTxt = '体验金';
                    }

                    //红包来源
                    // var originTxt = (json.content[i].origin ==1) ? '注册红包' : '未知来源' ;
                    if(json.content[i].origin ==1){
                        originTxt = '注册红包';
                    }else if(json.content[i].origin ==2){
                        originTxt = '投资红包';
                    }else{
                        originTxt = '未知来源';
                    }
                    for(var key in json.content[i]){
                        str = '<div class="each_tab_tr"><p class="cou_number">'+json.content[i].id+'</p><p class="cou_amount">'+
                            json.content[i].initAmount+'元</p><p class="cou_investTime">'+use_time+'</p><p class="cou_user_scope">'+
                            use_fanwei+'</p><p class="cou_type">'+pk_typeTxt+'</p><p class="cou_source">'+originTxt+'</p><div class="clear"></div></div>';
                            
                    }
                    $('.user_guoqi').append(str);
                }
            }
        });
    }















	// 可用的分页js
	$('#availe_page').twbsPagination({
        totalPages: 1,
        visiblePages: 4,
        first:'',
        last:'',
        prev:'<上一页',
        next:'下一页>',
        onPageClick: function (event, page) {
            // $('#page-content').text('Page ' + page);
            
        }
    });





    // 已使用分页js
    $('#used_page').twbsPagination({
        totalPages: 1,
        visiblePages: 4,
        first:'',
        last:'',
        prev:'<上一页',
        next:'下一页>',
        onPageClick: function (event, page) {
            // $('#page-content').text('Page ' + page);
            
        }
    });







    // 已过期分页js
    $('#expired_page').twbsPagination({
        totalPages: 1,
        visiblePages: 4,
        first:'',
        last:'',
        prev:'<上一页',
        next:'下一页>',
        onPageClick: function (event, page) {
            // $('#page-content').text('Page ' + page);
            
        }
    });


});