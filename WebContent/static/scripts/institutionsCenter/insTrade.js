$(function(){
    // 时间空间调用
    $(".jcDate").jcDate({                          
        IcoClass : "jcDateIco",
        Event : "click",
        Speed : 100,
        Left : 0,
        Top : 28,
        format : "-",
        Timeout : 100
    });

    

    // 机构中心-交易明细页面分页js
    // 当页面一加载就去请求交易明细接口一次
    var tto = 0;
    $.ajax({
        type:'post',
        url:getContextPaths()+'/account/transactionRecordList',
        dataType:'json',
        async: false,//同步
        data:{
            type:0
        },
        success:function(json){
            tto = json.totalPage;
            // 账户总金额
            $('.getTotal').html(json.getTotal);
            // 账户余额
            $('.getCash').html(json.getCash);
            // 冻结金额
            $('.getFrost').html(json.getFrost);
        }
    });
    if(tto==0){
        $('.tradePage').hide();
        $('.tab_tr_box').html('没有数据！');

    }else if(tto==1){

        $('.tradePage').hide();
        $.ajax({
            type:'post',
            url:getContextPaths()+'/account/transactionRecordList',
            dataType:'json',
            data:{
                type:0
            },
            success:function(json){
                $('.tab_tr_box').html('');
                var str = '';
                for(var i=0,l=json.content.length;i<l;i++){
                    // 账户余额
                    var accounts = json.content[i].cash;

                    // 交易类型   4100充值成功 4101 充值手续费 4102 提现成功 4103提现手续费
                    var trade_type = json.content[i].type;
                    var trade_txt = '';
                    if(trade_type==4100){
                        trade_txt = '充值成功';
                    }else if(trade_type==4101){
                        trade_txt = '充值手续费';
                    }else if(trade_type==4102){
                        trade_txt = '提现成功';
                    }else if(trade_type==4103){
                        trade_txt = '提现手续费';
                    }else if(trade_type==4201){
                        trade_txt = '投资冻结';
                    }else if(trade_type==4202){
                        trade_txt = '投资成功';
                    }else if(trade_type==4203){
                        trade_txt = '回款成功';
                    }else if(trade_type==4204){
                        trade_txt = '投资服务费';
                    }else if(trade_type==4301){
                        trade_txt = '借款成功';
                    }else if(trade_type==4302){
                        trade_txt = '融资服务费';
                    }else if(trade_type==4303){
                        trade_txt = '还款成功';
                    }

                    // 交易金额
                    var trade_amout = '';
                    if(trade_type==4100 || trade_type==4202 || trade_type == 4203 || trade_type == 4301){
                        trade_amout = '<p class="tra_tixian">+'+json.content[i].money+'</p>';
                    }else if(trade_type==4204 || trade_type==4302 || trade_type==4303 || trade_type==4102 || trade_type==4103 || trade_type==4101){
                        trade_amout = '<p class="tra_tuikuan">-'+json.content[i].money+'</p>';
                    }else{
                        trade_amout = '<p style="width:195px;color:#555">'+json.content[i].money+'</p>';
                    }

                    //交易时间
                    var trade_time =json.content[i].addTime.substring(0,json.content[i].addTime.length-2); 
                    for(var key in json.content[i]){
                        str = '<div class="each_tab_tr"><p class="tra_number">'+json.content[i].id+
                              '</p>'+trade_amout+'<p class="tra_avail_money">'+accounts+'</p><p class="tra_type">'+
                              trade_txt+'</p><p class="tra_time">'+trade_time+'</p><div class="clear"></div></div>';
                            
                    }
                     $('.tab_tr_box').append(str);
                }
            }
        });
    }else{
        $('.tradePage').show();
        $('#trade_page').remove();
        $('.tradePage').append('<ul id="trade_page" class="trade_page"></ul>');
        $('#trade_page').twbsPagination({
            totalPages: tto,
            visiblePages: 4,
            first:'',
            last:'',
            prev:'<上一页',
            next:'下一页>',
            onPageClick: function (event, page) {
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/account/transactionRecordList',
                    dataType:'json',
                    data:{
                        pageNum:page,
                        type:0
                    },
                    success:function(json){
                        $('.tab_tr_box').html('');
                        var str = '';
                        for(var i=0,l=json.content.length;i<l;i++){
                            // 账户余额
                            var accounts = json.content[i].cash;

                            // 交易类型   4100充值成功 4101 充值手续费 4102 提现成功 4103提现手续费
                            var trade_type = json.content[i].type;
                            var trade_txt = '';
                            if(trade_type==4100){
                                trade_txt = '充值成功';
                            }else if(trade_type==4101){
                                trade_txt = '充值手续费';
                            }else if(trade_type==4102){
                                trade_txt = '提现成功';
                            }else if(trade_type==4103){
                                trade_txt = '提现手续费';
                            }else if(trade_type==4201){
                                trade_txt = '投资冻结';
                            }else if(trade_type==4202){
                                trade_txt = '投资成功';
                            }else if(trade_type==4203){
                                trade_txt = '回款成功';
                            }else if(trade_type==4204){
                                trade_txt = '投资服务费';
                            }else if(trade_type==4301){
                                trade_txt = '借款成功';
                            }else if(trade_type==4302){
                                trade_txt = '融资服务费';
                            }else if(trade_type==4303){
                                trade_txt = '还款成功';
                            }

                            // 交易金额
                            var trade_amout = '';
                            if(trade_type==4100 || trade_type==4202 || trade_type == 4203 || trade_type == 4301){
                                trade_amout = '<p class="tra_tixian">+'+json.content[i].money+'</p>';
                            }else if(trade_type==4204 || trade_type==4302 || trade_type==4303 || trade_type==4102 || trade_type==4103 || trade_type==4101){
                                trade_amout = '<p class="tra_tuikuan">-'+json.content[i].money+'</p>';
                            }else{
                                trade_amout = '<p style="width:195px;color:#555">'+json.content[i].money+'</p>';
                            }

                            //交易时间
                            var trade_time =json.content[i].addTime.substring(0,json.content[i].addTime.length-2); 
                            for(var key in json.content[i]){
                                str = '<div class="each_tab_tr"><p class="tra_number">'+json.content[i].id+
                                      '</p>'+trade_amout+'<p class="tra_avail_money">'+accounts+'</p><p class="tra_type">'+
                                      trade_txt+'</p><p class="tra_time">'+trade_time+'</p><div class="clear"></div></div>';
                                    
                            }
                             $('.tab_tr_box').append(str);
                        }
                    }
                });
            }
        });
    }

    






});