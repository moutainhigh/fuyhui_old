$(function(){
    // 截取担保项目ID
    var guaranteeId;
    if(window.location.search.indexOf("?")!= -1){
        guaranteeId = window.location.search.substring((window.location.search.indexOf("=")+1));
    }
    // 机构中心-担保项目详情页面分页js
    // 当页面一加载就去请求担保项目详情页接口一次
    var tto = 0;
    $.ajax({
        type:'post',
        url:getContextPaths()+'/account/enterMyborrowInfo',
        dataType:'json',
        async: false,//同步
        data:{
            applyId:guaranteeId,
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
            $('.realMent').html(json.restAmount);
            $('.daiMent').html(json.prePayAmount);
            $('.delayMent').html(json.overdueAmount);
        }
    });
    if(tto==0){
        $('.gurdet_page').hide();
        $('.detail_contents').html('没有数据！');

    }else if(tto==1){
        $('.gurdet_page').hide();
        $.ajax({
            type:'post',
            url:getContextPaths()+'/account/enterMyborrowInfo',
            dataType:'json',
            data:{
                applyId:guaranteeId,
                pageSize:6
            },
            success:function(json){
                $('.detail_contents').html('');
                var str = '';
                for(var i=0,l=json.content.length;i<l;i++){
                    // 状态   1正常,2提前还款，3逾期已还，4逾期末还，5垫付末还, 6垫付已还
                    var borDet_type = json.content[i].repayStatus;
                    var borDet_txt = '';
                    if(borDet_type==1){
                        borDet_txt = '正常';
                    }else if(borDet_type==2){
                        borDet_txt = '提前还款';
                    }else if(borDet_type==3){
                        borDet_txt = '逾期已还';
                    }else if(borDet_type==4){
                        borDet_txt = '逾期末还';
                    }else if(borDet_type==5){
                        borDet_txt = '垫付末还';
                    }else if(borDet_type==6){
                        borDet_txt = '垫付已还';
                    }

                    var borDet_time =json.content[i].repay_req_time.substring(0,json.content[i].repay_req_time.length-2); 

                    for(var key in json.content[i]){
                        str = '<div class="earch_repayBox"><p class="fl">第'+json.content[i].repayPeriod+
                            '期</p><p class="fl">'+borDet_time+'</p><p class="fl">'+json.content[i].repayCapital+
                            '元</p><p class="fl">'+json.content[i].repayInterest+'元</p><p class="fl">'+borDet_txt+
                            '</p><div class="clear"></div></div>';
                            
                    }
                     $('.detail_contents').append(str);
                }
            }
        });
    }else{
        $('.gurdet_page').show();
        $('#gur_detailPage').remove();
        $('.gurdet_page').append('<ul id="gur_detailPage" class="gur_detailPage"></ul>');
        $('#gur_detailPage').twbsPagination({
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
                        applyId:guaranteeId,
                        pageSize:6,
                        pageNum:page
                    },
                    success:function(json){
                        $('.detail_contents').html('');
                        var str = '';
                        for(var i=0,l=json.content.length;i<l;i++){
                            // 状态   1正常,2提前还款，3逾期已还，4逾期末还，5垫付末还, 6垫付已还
                            var borDet_type = json.content[i].repayStatus;
                            var borDet_txt = '';
                            if(borDet_type==1){
                                borDet_txt = '正常';
                            }else if(borDet_type==2){
                                borDet_txt = '提前还款';
                            }else if(borDet_type==3){
                                borDet_txt = '逾期已还';
                            }else if(borDet_type==4){
                                borDet_txt = '逾期末还';
                            }else if(borDet_type==5){
                                borDet_txt = '垫付末还';
                            }else if(borDet_type==6){
                                borDet_txt = '垫付已还';
                            }

                            var borDet_time =json.content[i].repay_req_time.substring(0,json.content[i].repay_req_time.length-2); 

                            for(var key in json.content[i]){
                                str = '<div class="earch_repayBox"><p class="fl">第'+json.content[i].repayPeriod+
                                    '期</p><p class="fl">'+borDet_time+'</p><p class="fl">'+json.content[i].repayCapital+
                                    '元</p><p class="fl">'+json.content[i].repayInterest+'元</p><p class="fl">'+borDet_txt+
                                    '</p><div class="clear"></div></div>';
                                    
                            }
                            $('.detail_contents').append(str);
                        }
                    }
                });
            }
        });
    }











});
