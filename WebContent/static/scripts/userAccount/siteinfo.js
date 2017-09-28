$(function(){
    // 消息中心-站内信息页面分页js
    // 当页面加载完就去请求接口一次
    var tto = 0;
    $.ajax({
        type:'post',
        url:getContextPaths()+'/message/userMsgList',
        dataType:'json',
        async: false,//同步
        data:{
            userId:$('.sit_nav_box').attr('apid'),
            pageSize:8
        },
        success:function(json){
            tto = json.totalPage;
        }
    });
    if(tto==0){
        $('.site_page').hide();
        $('.site_content_box').html('没有数据！');

    }else if(tto==1){
        $('.site_page').hide();
        $.ajax({
            type:'post',
            url:getContextPaths()+'/message/userMsgList',
            dataType:'json',
            data:{
                userId:$('.sit_nav_box').attr('apid'),
                pageSize:8
            },
            success:function(json){
                $('.site_content_box').html('');
                var str = '';
                for(var i=0,l=json.content.length;i<l;i++){
                    var status = json.content[i].status;
                    var status_txt = '';
                    var flag = 0;
                    if(status==0){
                        status_txt = '未读';
                    }else{
                        status_txt = '已读';
                    }
                    var send_time = json.content[i].created1.substring(0,json.content[i].created1.length-2);
 
                    for(var key in json.content[i]){
                        if(status==0){
                            str = '<div class="eachBox"><div class="each_sitInfos_box unread"><div class="fl ck_checkbox_grounp"><input type="checkbox" name="ck_box" value="" id="ck_box" class="ck_box" ids=\''+json.content[i].id+'\'/></div><div class="fl site_readState">'+
                                status_txt+'</div><div class="fl sit_theme_cont">'+json.content[i].content+'</div><div class="fl sit_send_time">'+
                                send_time+'</div><div class="fl sit_closebgBox"><div class="sit_closeImg sit_close"></div></div><div class="clear"></div></div><div class="sit_prompt_box"><div class="sit_prompt"></div><div class="prompt_close"></div></div></div>';
                        }else{
                            str = '<div class="eachBox"><div class="each_sitInfos_box read"><div class="fl ck_checkbox_grounp"><input type="checkbox" name="ck_box" value="" id="ck_box" class="ck_box" ids=\''+json.content[i].id+'\'/></div><div class="fl site_readState">'+
                                status_txt+'</div><div class="fl sit_theme_cont">'+json.content[i].content+'</div><div class="fl sit_send_time">'+
                                send_time+'</div><div class="fl sit_closebgBox"><div class="sit_closeImg sit_close"></div></div><div class="clear"></div></div><div class="sit_prompt_box"><div class="sit_prompt"></div><div class="prompt_close"></div></div></div>';
                        }
                        
                            
                    }
                    $('.site_content_box').append(str);
                    
                }
                $('.site_content_box').append('<div class="site_radio_grounp"><label for="check_all" class="sit_all"><input type="checkbox" value="" id="check_all" class="check_all" />全选</label><label for="" class="sit_detele">删除选中信息</label><label for="" class="sit_read">标识为已读</label></div>');

                // 当点击消息前面的'多选框按钮'时触发   
                var checkeds = '';
                var icks='';  
                $('.ck_box').each(function() {
                    $(this).click(function(){
                        if ($(this).is(':checked')) {
                            var ts = $(this);
                            $(this).parent().parent().addClass('active');
                            $(this).parent().parent().find('.sit_closeImg').addClass('sit_active_close').removeClass('sit_close');
                            flag++;
                            if(flag == 8){
                                $('.check_all').prop('checked',true);
                            }
                            checkeds += $(this).attr('ids')+',';
                            icks = (checkeds.substring(0,checkeds.length-1));
                            // console.log(icks);
                            // 删除站内信
                            $('.sit_closeImg,.sit_closebgBox').click(function(){
                                $.ajax({
                                    type:'post',
                                    url:getContextPaths()+'/message/deleteMessage',
                                    dataType:'json',
                                    data:{
                                        ids:icks
                                    },
                                    success:function(json){
                                        if(json.flag=='1'){//删除成功
                                            history.go(0);

                                        }else{//删除失败
                                            // alert('注册失败');
                                        }
                                    }
                                });
                            });

                            // 把站内信设置为已读状态
                            $('.sit_theme_cont').click(function(){
                                $.ajax({
                                    type:'post',
                                    url:getContextPaths()+'/message/updateStatu',
                                    dataType:'json',
                                    data:{
                                        ids:icks
                                    },
                                    success:function(json){
                                        if(json.flag=='1'){//删除成功
                                            // history.go(0);
                                            

                                        }else{//删除失败
                                            // alert('注册失败');
                                            
                                        }
                                    }
                                });
                            });
                            $('.sit_read').click(function(){
                                $.ajax({
                                    type:'post',
                                    url:getContextPaths()+'/message/updateStatu',
                                    dataType:'json',
                                    data:{
                                        ids:icks
                                    },
                                    success:function(json){
                                        if(json.flag=='1'){//删除成功
                                             // history.go(0);
                                             ts.parent().next().html('已读').parent().removeClass('unread').addClass('read'); 
                                        }else{//删除失败
                                            // alert('注册失败');
                                        }
                                    }
                                });
                            });

                            
                        }else{
                            $('.check_all').removeAttr('checked');
                            $(this).parent().parent().removeClass('active');
                            $(this).parent().parent().find('.sit_closeImg').addClass('sit_close').removeClass('sit_active_close');
                            flag--;
                            icks = '';
                        }
                    });
                    
                });
                // 当没有选中某条信息时直接点击X按钮删除信息
                $('.sit_closebgBox').click(function(){
                    var _close = $(this).parent().find('.ck_box').attr('ids');
                    console.log(_close);
                    $.ajax({
                        type:'post',
                        url:getContextPaths()+'/message/deleteMessage',
                        dataType:'json',
                        data:{
                            ids:_close
                        },
                        success:function(json){
                            if(json.flag=='1'){//删除成功
                                history.go(0);
                            }else{//删除失败
                                // alert('注册失败');
                            }
                        }
                    });
                });
                // 当点击站内信内容时把该条站内信设置为已读状态
                $('.sit_theme_cont').click(function(){
                    var _icks = $(this).prev().prev().find('.ck_box').attr('ids');
                    $.ajax({
                        type:'post',
                        url:getContextPaths()+'/message/updateStatu',
                        dataType:'json',
                        data:{
                            ids:_icks
                        },
                        success:function(json){
                            if(json.flag=='1'){//删除成功
                                // history.go(0);
                               
                            }else{//删除失败
                                // alert('注册失败');
                                
                            }
                        }
                    });
                });
                // 全选功能实现
                $('.check_all').on('click',function(){
                    if(this.checked){ 
                         icks = '';
                        $('.ck_box').each(function() {    
                            $(".ck_box").prop('checked',true);
                             $(this).parent().parent().addClass('active'); 
                             $(this).parent().parent().find('.sit_closeImg').addClass('sit_active_close').removeClass('sit_close');
                             if($(this).prop('checked')==true){
                                 checkeds += $(this).attr('ids')+',';
                                // checkeds.push($(this).attr('ids'));
                            }
                        });
                        icks = (checkeds.substring(0,checkeds.length-1));
                        // console.log(icks);
                        flag = 8;



                        
                    }else{    
                        $('.ck_box').each(function() {    
                            $(".ck_box").removeAttr('checked'); 
                            $(this).parent().parent().removeClass('active');
                            $(this).parent().parent().find('.sit_closeImg').addClass('sit_close').removeClass('sit_active_close'); 
                        }); 
                        flag = 0; 
                        icks = ''; 
                    } 




                }); 
                // 删除站内信
                $('.sit_detele').click(function(){
                     // console.log(icks);
                    if(icks!=''){
                        $.ajax({
                            type:'post',
                            url:getContextPaths()+'/message/deleteMessage',
                            dataType:'json',
                            data:{
                                ids:icks
                            },
                            success:function(json){
                                if(json.flag=='1'){//删除成功
                                    history.go(0);
                                }else{//删除失败
                                    // alert('注册失败');
                                    // alert(json.msg);
                                }
                            }
                        });
                    }else{
                        alert('未选中任何信息。');
                    }
                });



                // 把站内信设置为已读状态
                        
                $('.sit_read').click(function(){
                    
                        if(icks!=''){
                            if(flag==8){
                                $.ajax({
                                    type:'post',
                                    url:getContextPaths()+'/message/updateStatu',
                                    dataType:'json',
                                    data:{
                                        ids:icks
                                    },
                                    success:function(json){
                                        if(json.flag=='1'){//删除成功
                                             // history.go(0);
                                             $(".ck_box").parent().next().html('已读').parent().removeClass('unread').addClass('read'); 
                                        }else{//删除失败
                                            // alert('注册失败');
                                        }
                                    }
                                });
                            }
                        }else{
                            alert('未选中任何信息。');
                        }
                    
                });



                //点击信息栏是触发
                $('.sit_theme_cont').each(function(){
                    $(this).click(function(){
                        if($(this).parent().parent().find('.sit_prompt_box').css('display') == 'none'){
                            var txt = $(this).text();
                            $(this).parent().parent().find('.sit_prompt').html(txt);
                            $(this).parent().parent().find('.sit_prompt_box').slideDown(800);
                            $(this).parent().parent().siblings().find('.sit_prompt_box').slideUp(800);
                            $(this).prev().html('已读').parent().removeClass('unread').addClass('read');   
                         }else{
                             $(this).parent().parent().find('.sit_prompt_box').slideUp(800);
                        }
                       
                    });
                    
                }); 
                $('.prompt_close').click(function(){
                    $(this).parent().slideUp(800);
                });










            }
        });
    }else{
        $('.site_page').show();
        $('#siteInfo_page').remove();
        $('.site_page').append('<ul id="siteInfo_page" class="siteInfo_page"></ul>');
        $('#siteInfo_page').twbsPagination({
            totalPages: tto,
            visiblePages: 4,
            first:'',
            last:'',
            prev:'<上一页',
            next:'下一页>',
            onPageClick: function (event, page) {
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/message/userMsgList',
                    dataType:'json',
                    data:{
                        userId:$('.sit_nav_box').attr('apid'),
                        pageSize:8,
                        pageNum:page
                    },
                    success:function(json){
                        $('.site_content_box').html('');
                        var str = '';
                        var flag = 0;
                        for(var i=0,l=json.content.length;i<l;i++){
                            var status = json.content[i].status;
                            var status_txt = '';
                            if(status==0){
                                status_txt = '未读';
                            }else{
                                status_txt = '已读';
                            }
                            var send_time = json.content[i].created1.substring(0,json.content[i].created1.length-2);
         
                            for(var key in json.content[i]){
                                if(status==0){
                                    str = '<div class="eachBox"><div class="each_sitInfos_box unread"><div class="fl ck_checkbox_grounp"><input type="checkbox" name="ck_box" value="" id="ck_box" class="ck_box" ids=\''+json.content[i].id+'\'/></div><div class="fl site_readState">'+
                                        status_txt+'</div><div class="fl sit_theme_cont">'+json.content[i].content+'</div><div class="fl sit_send_time">'+
                                        send_time+'</div><div class="fl sit_closebgBox"><div class="sit_closeImg sit_close"></div></div><div class="clear"></div></div><div class="sit_prompt_box"><div class="sit_prompt"></div><div class="prompt_close"></div></div></div>';
                                }else{
                                    str = '<div class="eachBox"><div class="each_sitInfos_box read"><div class="fl ck_checkbox_grounp"><input type="checkbox" name="ck_box" value="" id="ck_box" class="ck_box" ids=\''+json.content[i].id+'\'/></div><div class="fl site_readState">'+
                                        status_txt+'</div><div class="fl sit_theme_cont">'+json.content[i].content+'</div><div class="fl sit_send_time">'+
                                        send_time+'</div><div class="fl sit_closebgBox"><div class="sit_closeImg sit_close"></div></div><div class="clear"></div></div><div class="sit_prompt_box"><div class="sit_prompt"></div><div class="prompt_close"></div></div></div>';
                                }
                                
                                    
                            }
                            $('.site_content_box').append(str); 
                            
                        }
                        $('.site_content_box').append('<div class="site_radio_grounp"><label for="check_all" class="sit_all"><input type="checkbox" value="" id="check_all" class="check_all" />全选</label><label for="" class="sit_detele">删除选中信息</label><label for="" class="sit_read">标识为已读</label></div>');

                        // 当点击消息前面的'多选框按钮'时触发 
                        var checkeds = '';
                        var icks='';   
                        $('.ck_box').each(function() {
                            $(this).click(function(){
                                if ($(this).is(':checked')) {
                                    var ts = $(this);
                                    $(this).parent().parent().addClass('active');
                                    $(this).parent().parent().find('.sit_closeImg').addClass('sit_active_close').removeClass('sit_close');
                                    flag++;
                                    if(flag == 8){
                                        $('.check_all').prop('checked',true);
                                    }
                                   
                                    checkeds += $(this).attr('ids')+',';
                                    icks = (checkeds.substring(0,checkeds.length-1));
                                    // console.log(icks);
                                    // 删除站内信
                                    $('.sit_closeImg,.sit_closebgBox,sit_detele').click(function(){
                                        $.ajax({
                                            type:'post',
                                            url:getContextPaths()+'/message/deleteMessage',
                                            dataType:'json',
                                            data:{
                                                ids:icks
                                            },
                                            success:function(json){
                                                if(json.flag=='1'){//删除成功
                                                    history.go(0);
                                                }else{//删除失败
                                                    // alert('注册失败');
                                                }
                                            }
                                        });
                                    });
                                    // 把站内信设置为已读状态
                                    $('.sit_theme_cont').click(function(){
                                        $.ajax({
                                            type:'post',
                                            url:getContextPaths()+'/message/updateStatu',
                                            dataType:'json',
                                            data:{
                                                ids:icks
                                            },
                                            success:function(json){
                                                if(json.flag=='1'){//删除成功
                                                    // history.go(0);
                                                    
                                                }else{//删除失败
                                                    // alert('注册失败');
                                                    
                                                }
                                            }
                                        });
                                    });
                                    $('.sit_read').click(function(){
                                        $.ajax({
                                            type:'post',
                                            url:getContextPaths()+'/message/updateStatu',
                                            dataType:'json',
                                            data:{
                                                ids:icks
                                            },
                                            success:function(json){
                                                if(json.flag=='1'){//删除成功
                                                     // history.go(0);
                                                     ts.parent().next().html('已读').parent().removeClass('unread').addClass('read'); 
                                                }else{//删除失败
                                                    // alert('注册失败');
                                                }
                                            }
                                        });
                                    });
                                    
                                }else{
                                    $('.check_all').removeAttr('checked');
                                    $(this).parent().parent().removeClass('active');
                                    $(this).parent().parent().find('.sit_closeImg').addClass('sit_close').removeClass('sit_active_close');
                                    flag--;
                                    icks = '';
                                }
                            });
                            
                        });
                        // 当没有选中某条信息时直接点击X按钮删除信息
                        $('.sit_closebgBox').click(function(){
                            var _close = $(this).parent().find('.ck_box').attr('ids');
                            console.log(_close);
                            $.ajax({
                                type:'post',
                                url:getContextPaths()+'/message/deleteMessage',
                                dataType:'json',
                                data:{
                                    ids:_close
                                },
                                success:function(json){
                                    if(json.flag=='1'){//删除成功
                                        history.go(0);
                                    }else{//删除失败
                                        // alert('注册失败');
                                    }
                                }
                            });
                        });
                        // 当点击站内信内容时把该条站内信设置为已读状态
                        $('.sit_theme_cont').click(function(){
                            var _icks = $(this).prev().prev().find('.ck_box').attr('ids');
                            $.ajax({
                                type:'post',
                                url:getContextPaths()+'/message/updateStatu',
                                dataType:'json',
                                data:{
                                    ids:_icks
                                },
                                success:function(json){
                                    if(json.flag=='1'){//删除成功
                                        // history.go(0);
                                        
                                    }else{//删除失败
                                        // alert('注册失败');
                                        
                                    }
                                }
                            });
                        });
                        // 全选功能实现
                        $('.check_all').on('click',function(){
                            if(this.checked){ 

                                // var checkeds = new Array();
                                icks = '';
                                $('.ck_box').each(function() {    
                                    $(".ck_box").prop('checked',true);
                                     $(this).parent().parent().addClass('active'); 
                                     $(this).parent().parent().find('.sit_closeImg').addClass('sit_active_close').removeClass('sit_close');
                                     
                                    if($(this).prop('checked')==true){
                                         checkeds += $(this).attr('ids')+',';
                                        // checkeds.push($(this).attr('ids'));
                                    }
                                });
                                icks = (checkeds.substring(0,checkeds.length-1));
                                // console.log(icks);
                                flag = 8;

                                





                            }else{    
                                $('.ck_box').each(function() {    
                                    $(".ck_box").removeAttr('checked'); 
                                    $(this).parent().parent().removeClass('active');
                                    $(this).parent().parent().find('.sit_closeImg').addClass('sit_close').removeClass('sit_active_close'); 
                                }); 
                                flag = 0;  
                                icks = '';
                            } 

                            
                        }); 
                        // 删除站内信
                        $('.sit_detele').click(function(){
                             // console.log(icks);
                            if(icks!=''){
                                $.ajax({
                                    type:'post',
                                    url:getContextPaths()+'/message/deleteMessage',
                                    dataType:'json',
                                    data:{
                                        ids:icks
                                    },
                                    success:function(json){
                                        if(json.flag=='1'){//删除成功
                                            history.go(0);
                                        }else{//删除失败
                                            // alert('注册失败');
                                            // alert(json.msg);
                                        }
                                    }
                                });
                            }else{
                                alert('未选中任何信息。');
                            }
                        });



                        // 把站内信设置为已读状态
                        
                        $('.sit_read').click(function(){
                            if(icks!=''){
                                if(flag==8){
                                    $.ajax({
                                        type:'post',
                                        url:getContextPaths()+'/message/updateStatu',
                                        dataType:'json',
                                        data:{
                                            ids:icks
                                        },
                                        success:function(json){
                                            if(json.flag=='1'){//删除成功
                                                 // history.go(0);
                                                 $(".ck_box").parent().next().html('已读').parent().removeClass('unread').addClass('read'); 
                                            }else{//删除失败
                                                // alert('注册失败');
                                            }
                                        }
                                    });
                                }
                            }else{
                                alert('未选中任何信息。');
                            }
                    
                        });
                        
                        

                        //点击信息栏是触发
                        $('.sit_theme_cont').each(function(){
                            $(this).click(function(){
                                if($(this).parent().parent().find('.sit_prompt_box').css('display') == 'none'){
                                    var txt = $(this).text();
                                    $(this).parent().parent().find('.sit_prompt').html(txt);
                                    $(this).parent().parent().find('.sit_prompt_box').slideDown(800);
                                    $(this).parent().parent().siblings().find('.sit_prompt_box').slideUp(800);
                                    $(this).prev().html('已读').parent().removeClass('unread').addClass('read');
                                }else{
                                    $(this).parent().parent().find('.sit_prompt_box').slideUp(800);
                                }
                            });
                            
                        }); 
                        $('.prompt_close').click(function(){
                            $(this).parent().slideUp(800);
                        });










                    }
                });
            }
        });
    }



    
    

    
    
















    






});




