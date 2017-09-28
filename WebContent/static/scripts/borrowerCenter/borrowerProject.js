$(document).ready(function(){
    
    // 当点击逾期项目的按钮时触发
    $('.delay-tab .delay-link').click(function(){
        $(".hide-body").css("display","block");
        $(".hide-con").show(800);
    });


    $('.hide-con .close').click(function(){
        $(".hide-body").css("display","none");
        $(".hide-con").hide(800);
    });

    var hosts = getContextPaths()+'/myAccount/enterBorrowerDetail?id=';
    // 借款人账户中心-借款项目页面分页js
    // 当页面一加载就去请求借款记录接口一次
    var tto = 0;
    $.ajax({
        type:'post',
        url:getContextPaths()+'/account/enterMyborrow',
        dataType:'json',
        async: false,//同步
        success:function(json){
            tto = json.totalPage;
            // 融资总额
            $('.getTotal').html(formatMoney(json.sumMoney,2));
            //待还总额
            $('.getCash').html(formatMoney(json.sumStillMoney,2));
            //已还总额
            $('.getFrost').html(formatMoney(json.sumHasMoney,2));
        }
    });
    if(tto==0){
        $('.borPage').hide();
        $('.bor_table').html('没有数据！');

    }else if(tto==1){
        $('.borPage').hide();
        $.ajax({
            type:'post',
            url:getContextPaths()+'/account/enterMyborrow',
            dataType:'json',
            success:function(json){
                $('.bor_table').html('');
                var str = '';
                for(var i=0,l=json.content.length;i<l;i++){
                    var isl = json.content[i].isLoans;
                    // 状态   -5 取消申请 -4 失败，-3 额度调整中；-2同意额度 
                    //  -1 草稿 ；0：预审（未审）；1：初审；2：终审。
                    //3：补件；4：实地；5：签单中；6签单完成；7投标中；8满标；9还款中；10以还清；20:流标
                    var bor_type = json.content[i].repay_status;
                    var bor_txt = '';
                    if(bor_type==-1){
                        bor_txt = '草稿';
                    }else if(bor_type==-2){
                        bor_txt = '删除 ';
                    }else if(bor_type==-3){
                        bor_txt = '额度调整中';
                    }else if(bor_type==-4){
                        bor_txt = '失败';
                    }else if(bor_type==-5){
                        bor_txt = '取消申请';
                    }else if(bor_type==0){
                        //bor_txt = '预审（未审）';
                        bor_txt = '';
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
                        bor_txt = '认购中';
                    }else if(bor_type==8 && isl ==0){
                        bor_txt = '认购中';
                    }else if(bor_type==9 || (bor_type==8 && isl!=0)){
                        bor_txt = '还款中';
                    }else if(bor_type==10){
                        bor_txt = '已结束';
                    }else if(bor_type==20){
                        bor_txt = '流标';
                    }
                    //已还金额
                    var relay_moneys = (json.content[i].alreadyRepayMoney ==null) ? 0 : json.content[i].alreadyRepayMoney;
                    // 待还金额
                    var dai_moneys = (json.content[i].waiRepayMoney ==null) ? 0 : json.content[i].waiRepayMoney;
                    for(var key in json.content[i]){
                        str = '<tr class="bor_tr" onclick="window.location.href=\''+hosts+json.content[i].id+'\'" bor_id="\''+json.content[i].id+'\'"><td class="link-detai">'+json.content[i].order_number+'</td><td>'+
                              json.content[i].name+'</td><td>'+json.content[i].amount+'</td><td>'+
                              json.content[i].period+'天</td><td>'+relay_moneys+'</td><td>'+
                              dai_moneys+'</td><td class="status">'+bor_txt+'</td></tr>';
                            
                    }
                     $('.bor_table').append(str);
                }
            }
        });
    }else{
        $('.borPage').show();
        $('#borrow_page').remove();
        $('.borPage').append('<ul id="borrow_page" class="borrow_page"></ul>');
        $('#borrow_page').twbsPagination({
            totalPages: tto,
            visiblePages: 4,
            first:'',
            last:'',
            prev:'<上一页',
            next:'下一页>',
            onPageClick: function (event, page) {
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/account/enterMyborrow',
                    dataType:'json',
                    data:{
                        pageNum:page
                    },
                    success:function(json){
                        $('.bor_table').html('');
                        var str = '';
                        for(var i=0,l=json.content.length;i<l;i++){
                            var isl = json.content[i].isLoans;
                            // 状态   -5 取消申请 -4 失败，-3 额度调整中；-2同意额度 
                            //  -1 草稿 ；0：预审（未审）；1：初审；2：终审。
                            //3：补件；4：实地；5：签单中；6签单完成；7投标中；8满标；9还款中；10以还清；20:流标
                            var bor_type = json.content[i].repay_status;
                            var bor_txt = '';
                            if(bor_type==-1){
                                bor_txt = '草稿';
                            }else if(bor_type==-2){
                                bor_txt = '删除 ';
                            }else if(bor_type==-3){
                                bor_txt = '额度调整中';
                            }else if(bor_type==-4){
                                bor_txt = '失败';
                            }else if(bor_type==-5){
                                bor_txt = '取消申请';
                            }else if(bor_type==0){
                                //bor_txt = '预审（未审）';
                                bor_txt = '';
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
                                bor_txt = '认购中';
                            }else if(bor_type==8 && isl ==0){
                                bor_txt = '认购中';
                            }else if(bor_type==9 || (bor_type==8 && isl!=0)){
                                bor_txt = '还款中';
                            }else if(bor_type==10){
                                bor_txt = '已结束';
                            }else if(bor_type==20){
                                bor_txt = '流标';
                            }
                            //已还金额
                            var relay_moneys = (json.content[i].alreadyRepayMoney ==null) ? 0 : json.content[i].alreadyRepayMoney;
                            // 待还金额
                            var dai_moneys = (json.content[i].waiRepayMoney ==null) ? 0 : json.content[i].waiRepayMoney;
                            for(var key in json.content[i]){
                                str = '<tr class="bor_tr" onclick="window.location.href=\''+hosts+json.content[i].id+'\'" bor_id="\''+json.content[i].id+'\'"><td class="link-detai">'+json.content[i].order_number+'</td><td>'+
                                      json.content[i].name+'</td><td>'+json.content[i].amount+'</td><td>'+
                                      json.content[i].period+'天</td><td>'+relay_moneys+'</td><td>'+
                                      dai_moneys+'</td><td class="status">'+bor_txt+'</td></tr>';
                                    
                            }
                             $('.bor_table').append(str);
                        }
                    }
                });
            }
        });
    }



    














})
