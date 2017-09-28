$(function(){
    // 截取借款ID
    var borrowId;
    if(window.location.search.indexOf("?")!= -1){
        borrowId = window.location.search.substring((window.location.search.indexOf("=")+1));
    }

    // 借款人账户中心-借款项目详情页面分页js
    // 当页面一加载就去请求借款项目详情页接口一次
    var tto = 0;
    $.ajax({
        type:'post',
        url:getContextPaths()+'/account/enterMyborrowInfo',
        dataType:'json',
        async: false,//同步
        data:{
            applyId:borrowId,
            pageSize:6
        },
        success:function(json){
            tto = json.totalPage;
            $('.bor_num').html(json.orderNumber);
            $('.bor_rate').html(json.apr+'%');
            $('.bor_ID').html(json.card_id);
            $('.bor_money').html(json.amount);
            $('.bor_use').html(json.purpose);
            $('.bor_iphone').html(json.mobile);
            $('.bor_month').html(json.period);
            $('.bor_name').html(json.realname);
            $('.realy_money').html(json.restAmount);
            $('.no_money').html(json.prePayAmount);
            $('.yuqi_money').html(json.overdueAmount);
        }
    });
    if(tto==0){
        $('.bor_detalPage').hide();
        $('.bordet_body').html('没有数据！');

    }else if(tto==1){
        $('.bor_detalPage').hide();
        $.ajax({
            type:'post',
            url:getContextPaths()+'/account/enterMyborrowInfo',
            dataType:'json',
            data:{
                applyId:borrowId,
                pageSize:6
            },
            success:function(json){
                $('.bordet_body').html('');
                var str = '';
                for(var i=0,l=json.content.length;i<l;i++){
                    // 状态   1已还 0未还
                    var borDet_type = json.content[i].status;
                    var borDet_txt = '';
                    if(borDet_type==1){
                        borDet_txt = '已结束';
                    }else if(borDet_type==0){
                        borDet_txt = '还款中';
                    }

                    //还款日期
                    var borDet_time =json.content[i].repay_req_time; 

                    for(var key in json.content[i]){
                        str = '<tr><td>第'+json.content[i].repayPeriod+'期</td><td>'+borDet_time+
                            '</td><td>'+json.content[i].repayCapital+'元</td><td>'+json.content[i].repayInterest+
                            '元</td><td>'+json.content[i].repayDoneCapital+'元</td><td>'+json.content[i].repayDoneInterest+
                            '元</td><td>'+json.content[i].repayDoneTime+'</td><td>'+borDet_txt+'</td></tr>';
                            
                    }
                     $('.bordet_body').append(str);
                }
            }
        });
    }else{
        $('.bor_detalPage').show();
        $('#trade_page').remove();
        $('.bor_detalPage').append('<ul id="borDet_page" class="borDet_page"></ul>');
        $('#borDet_page').twbsPagination({
            totalPages: tto,
            visiblePages: 4,
            first:'',
            last:'',
            prev:'<上一页',
            next:'下一页>',
            onPageClick: function (event, page) {
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/account/enterMyborrowInfo',
                    dataType:'json',
                    data:{
                        applyId:borrowId,
                        pageSize:6,
                        pageNum:page
                    },
                    success:function(json){
                        $('.bordet_body').html('');
                        var str = '';
                        for(var i=0,l=json.content.length;i<l;i++){
                            // 状态   1已还 0未还
                            var borDet_type = json.content[i].status;
                            var borDet_txt = '';
                            if(borDet_type==1){
                                borDet_txt = '已结束';
                            }else if(borDet_type==0){
                                borDet_txt = '还款中';
                            }

                            //还款日期
                            var borDet_time =json.content[i].repay_req_time; 

                            for(var key in json.content[i]){
                                str = '<tr><td>第'+json.content[i].repayPeriod+'期</td><td>'+borDet_time+
                            '</td><td>'+json.content[i].repayCapital+'元</td><td>'+json.content[i].repayInterest+
                            '元</td><td>'+json.content[i].repayDoneCapital+'元</td><td>'+json.content[i].repayDoneInterest+
                            '元</td><td>'+json.content[i].repayDoneTime+'</td><td>'+borDet_txt+'</td></tr>';
                                    
                            }
                             $('.bordet_body').append(str);
                        }
                    }
                });
            }
        });
    }











});
