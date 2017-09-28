$(function(){
    // 机构中心-担保项目页面分页js
    // 当页面一加载就去请求担保项目接口一次
	var hosts = getContextPaths()+'/myAccount/enterGuaranteeDetail?id=';
    var tto = 0;
    $.ajax({
        type:'post',
        url:getContextPaths()+'/account/enterMyIsn',
        dataType:'json',
        async: false,//同步
        data:{
            pageSize:9
        },
        success:function(json){
            tto = json.totalPage;
            // 当前担保总金额
            $('.getTotal').html(json.userGuarnatySum);
            //已垫付总额
            $('.getCash').html(json.ydiankSum);
            //待垫付总额
            $('.getFrost').html(json.wdiankSum);
        }
    });
    if(tto==0){
        $('.guar_page').hide();
        $('.guar_contents').html('没有数据！');

    }else if(tto==1){
        $('.guar_page').hide();
        $.ajax({
            type:'post',
            url:getContextPaths()+'/account/enterMyIsn',
            dataType:'json',
            data:{
                    pageSize:9
                },
            success:function(json){
                $('.guar_contents').html('');
                var str = '';
                for(var i=0,l=json.content.length;i<l;i++){
                    // 状态   -5 取消申请 -4 失败，-3 额度调整中；-2同意额度 
                    //  -1 草稿 ；0：预审（未审）；1：初审；2：终审。
                    //3：补件；4：实地；5：签单中；6签单完成；7投标中；8满标；9还款中；10以还清；20:流标
                    var bor_type = json.content[i].repay_status;
                    var bor_txt = '';
                    if(bor_type==-1){
                        bor_txt = '草稿';
                    }else if(bor_type==-2){
                        bor_txt = '同意额度 ';
                    }else if(bor_type==-3){
                        bor_txt = '额度调整中';
                    }else if(bor_type==-4){
                        bor_txt = '失败';
                    }else if(bor_type==-5){
                        bor_txt = '取消申请';
                    }else if(bor_type==0){
                        bor_txt = '预审（未审）';
                    }else if(bor_type==1){
                        bor_txt = '初审';
                    }else if(bor_type==2){
                        bor_txt = '终审';
                    }else if(bor_type==3){
                        bor_txt = '补件';
                    }else if(bor_type==4){
                        bor_txt = '实地';
                    }else if(bor_type==5){
                        bor_txt = '签单中';
                    }else if(bor_type==6){
                        bor_txt = '签单完成';
                    }else if(bor_type==7){
                        bor_txt = '投标中';
                    }else if(bor_type==8){
                        bor_txt = '满标';
                    }else if(bor_type==9){
                        bor_txt = '还款中';
                    }else if(bor_type==10){
                        bor_txt = '已还清';
                    }else if(bor_type==20){
                        bor_txt = '流标';
                    }

                    //已垫付金额
                    var relay_moneys = (json.content[i].ydiank ==null) ? 0 : json.content[i].ydiank;
                    // 待垫付金额
                    var dai_moneys = (json.content[i].wdiank ==null) ? 0 : json.content[i].wdiank;
                    for(var key in json.content[i]){
                        str = '<div class="earch_guarBox" onclick="window.location.href=\''+hosts+json.content[i].id+'\'"><p class="fl guar_num">'+json.content[i].order_number+
                            '</p><p class="fl guar_title">'+json.content[i].name+'</p><p class="fl">'+json.content[i].amount+
                            '元</p><p class="fl">'+json.content[i].period+'个月</p><p class="fl">'+relay_moneys+
                            '</p><p class="fl">'+dai_moneys+'</p><p class="fl repayment">'+bor_txt+'</p><div class="clear"></div></div>';
                            
                    }
                     $('.guar_contents').append(str);
                }
            }
        });
    }else{
        $('.guar_page').show();
        $('#guarante_page').remove();
        $('.guar_page').append('<ul id="guarante_page" class="guarante_page"></ul>');
        $('#guarante_page').twbsPagination({
            totalPages: tto,
            visiblePages: 4,
            first:'',
            last:'',
            prev:'<上一页',
            next:'下一页>',
            onPageClick: function (event, page) {
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/account/enterMyIsn',
                    dataType:'json',
                    data:{
                        pageSize:9,
                        pageNum:page  
                    },
                    success:function(json){
                        $('.guar_contents').html('');
                        var str = '';
                        for(var i=0,l=json.content.length;i<l;i++){
                            // 状态   -5 取消申请 -4 失败，-3 额度调整中；-2同意额度 
                            //  -1 草稿 ；0：预审（未审）；1：初审；2：终审。
                            //3：补件；4：实地；5：签单中；6签单完成；7投标中；8满标；9还款中；10以还清；20:流标
                            var bor_type = json.content[i].repay_status;
                            var bor_txt = '';
                            if(bor_type==-1){
                                bor_txt = '草稿';
                            }else if(bor_type==-2){
                                bor_txt = '同意额度 ';
                            }else if(bor_type==-3){
                                bor_txt = '额度调整中';
                            }else if(bor_type==-4){
                                bor_txt = '失败';
                            }else if(bor_type==-5){
                                bor_txt = '取消申请';
                            }else if(bor_type==0){
                                bor_txt = '预审（未审）';
                            }else if(bor_type==1){
                                bor_txt = '初审';
                            }else if(bor_type==2){
                                bor_txt = '终审';
                            }else if(bor_type==3){
                                bor_txt = '补件';
                            }else if(bor_type==4){
                                bor_txt = '实地';
                            }else if(bor_type==5){
                                bor_txt = '签单中';
                            }else if(bor_type==6){
                                bor_txt = '签单完成';
                            }else if(bor_type==7){
                                bor_txt = '投标中';
                            }else if(bor_type==8){
                                bor_txt = '满标';
                            }else if(bor_type==9){
                                bor_txt = '还款中';
                            }else if(bor_type==10){
                                bor_txt = '已还清';
                            }else if(bor_type==20){
                                bor_txt = '流标';
                            }

                            //已垫付金额
                            var relay_moneys = (json.content[i].ydiank ==null) ? 0 : json.content[i].ydiank;
                            // 待垫付金额
                            var dai_moneys = (json.content[i].wdiank ==null) ? 0 : json.content[i].wdiank;
                            for(var key in json.content[i]){
                                str = '<div class="earch_guarBox" onclick="window.location.href=\''+hosts+json.content[i].id+'\'"><p class="fl guar_num">'+json.content[i].order_number+
                                    '</p><p class="fl guar_title">'+json.content[i].name+'</p><p class="fl">'+json.content[i].amount+
                                    '元</p><p class="fl">'+json.content[i].period+'个月</p><p class="fl">'+relay_moneys+
                                    '</p><p class="fl">'+dai_moneys+'</p><p class="fl repayment">'+bor_txt+'</p><div class="clear"></div></div>';
                                    
                            }
                             $('.guar_contents').append(str);
                        }
                    }
                });
            }
        });
    }






  





});