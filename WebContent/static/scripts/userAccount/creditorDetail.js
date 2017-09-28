$(function(){
    // 债权ID和借款人ID   
    var creditorId,invID;
    if(window.location.search.indexOf("?")!= -1){
        creditorId = window.location.search.substring((window.location.search.indexOf("=")+1),(window.location.search.indexOf("&")));
        invID = window.location.search.substring((window.location.search.indexOf("&")+5));
    }
    // 机构中心-担保项目详情页面分页js
    // 当页面一加载就去请求担保项目详情页接口一次
    var tto = 0;
    $.ajax({
        type:'post',
        url:getContextPaths()+'/invest/loanInvestRecoverInfo',
        dataType:'json',
        async: false,//同步
        data:{
            applyId:creditorId,
            investId:invID,
            pageSize:6
        },
        success:function(json){
            tto = json.totalPage;
            // 借款编号
            $('.bor_num').html(json.orderNumber);
            // 真实姓名
            $('.bor_name').html(json.realname);
            // 身份证号码
            $('.bor_ID').html(json.card_id);
            // 手机号码
            $('.bor_iphone').html(json.mobile);
            // 借款金额
            $('.bor_money').html((json.amount == '') ? 0 : json.amount);
            // 贷款期限
            $('.bor_month').html((json.period == '') ? 0 : json.period);
            // 借款利率
            $('.bor_rate').html(json.apr+'%');
            // 投资金额
            $('.invest_money').html((json.getInvestMoney == '') ? 0.00 : json.getInvestMoney);
            // 已还金额
            $('.realMent').html((json.getSumReceipts == '') ? 0.00 : json.getSumReceipts);
            // 待还金额
            $('.daiMent').html((json.getSumReceipts1 == '') ? 0.00 : json.getSumReceipts1);
        }
    });
    if(tto==0){
        $('.gurdet_page').hide();
        $('.detail_contents').html('没有数据！');

    }else if(tto==1){
        $('.gurdet_page').hide();
        $.ajax({
            type:'post',
            url:getContextPaths()+'/invest/loanInvestRecoverInfo',
            dataType:'json',
            data:{
                applyId:creditorId,
                investId:invID,
                pageSize:6
            },
            success:function(json){
                $('.detail_contents').html('');
                var str = '';
                for(var i=0,l=json.content.length;i<l;i++){
                    // 状态   0 未还 1已还
                    var borDet_type = json.content[i].status;
                    var borDet_txt = '';
                    if(borDet_type==0){
                        borDet_txt = '未还';
                    }else{
                        borDet_txt = '已还';
                    }

                    var borDet_time =(json.content[i].recoverDoneTimeStr == null) ? '' : json.content[i].recoverDoneTimeStr.substring(0,json.content[i].recoverDoneTimeStr.length-10);

                    for(var key in json.content[i]){
                        str = '<div class="earch_repayBox"><p class="fl">第'+json.content[i].recoverPeriod+
                            '期</p><p class="fl">'+borDet_time+'</p><p class="fl">'+json.content[i].recoverCapital+
                            '元</p><p class="fl">'+json.content[i].recoverInterest+'元</p><p class="fl">'+borDet_txt+
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
                    url:getContextPaths()+'/invest/loanInvestRecoverInfo',
                    dataType:'json',
                    data:{
                        applyId:creditorId,
                        investId:invID,
                        pageSize:6,
                        pageNum:page
                    },
                    success:function(json){
                        $('.detail_contents').html('');
                        var str = '';
                        for(var i=0,l=json.content.length;i<l;i++){
                            // 状态   0 未还 1已还
                            var borDet_type = json.content[i].status;
                            var borDet_txt = '';
                            if(borDet_type==0){
                                borDet_txt = '未还';
                            }else{
                                borDet_txt = '已还';
                            }

                            var borDet_time =(json.content[i].recoverDoneTimeStr == null) ? '' : json.content[i].recoverDoneTimeStr.substring(0,json.content[i].recoverDoneTimeStr.length-10); 

                            for(var key in json.content[i]){
                                str = '<div class="earch_repayBox"><p class="fl">第'+json.content[i].recoverPeriod+
                                    '期</p><p class="fl">'+borDet_time+'</p><p class="fl">'+json.content[i].recoverCapital+
                                    '元</p><p class="fl">'+json.content[i].recoverInterest+'元</p><p class="fl">'+borDet_txt+
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
