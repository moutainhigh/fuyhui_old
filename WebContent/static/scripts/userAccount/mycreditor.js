$(function(){
    // 用户id
    uId = $('.repayUId').attr('apid');
    var hosts = getContextPaths()+'/invest/enterInvestDetail?id=';
    // 理财中心-申请中页面'投资中和流标'按钮切换js
    $('.aply_invet_nav').click(function(){
        $('.aply_liubiao_nav ').removeClass('active');
        $('.aply_repay_nav').removeClass('active');
        $(this).addClass('active');
        $('.apy_invest_during').show();
        $('.apy_liu_biao').hide();
        $('.real_pay').hide();
    });

    $('.aply_liubiao_nav').click(function(){
        $('.aply_invet_nav').removeClass('active');
        $('.aply_repay_nav').removeClass('active');
        $(this).addClass('active');
        $('.apy_liu_biao').show();
        $('.apy_invest_during').hide();
        $('.real_pay').hide();
    });

    $('.aply_repay_nav').click(function(){
        $('.aply_invet_nav').removeClass('active');
        $('.aply_liubiao_nav').removeClass('active');
        $(this).addClass('active');
        $('.real_pay').show();
        $('.apy_liu_biao').hide();
        $('.apy_invest_during').hide();
    });


    // 投资中分页js Start
    // 当页面一加载就去请求投资记录接口一次
    var tto = 0;
    // alert(tto);
    $.ajax({
        type:'post',
        url:getContextPaths()+'/invest/loanInvestList',
        dataType:'json',
        async: false,//同步
        data:{
            userid:$('.apy_invest_during').attr('apid'),
            status:'7A',
            busitype:2   
        },
        success:function(json){
            tto = json.totalPage;
        }
    });
    if(tto==0){
        $('.page_box01').hide();
        $('.touzizhong').html('没有数据！');

    }else if(tto==1){

        $('.page_box01').hide();
        $.ajax({
            type:'post',
            url:getContextPaths()+'/invest/loanInvestList',
            dataType:'json',
            data:{
                userid:$('.apy_invest_during').attr('apid'),
                status:'7A',
                busitype:2 
            },
            success:function(json){
                $('.touzizhong').html('');
                var str = '';
                for(var i=0,l=json.content.length;i<l;i++){
                    var invest_apr = json.content[i].apr+'%';
                    var pro = json.content[i].investProgress+'%';
                    var invest_amouts = json.content[i].money;
                    var mthones = json.content[i].period+'天';
                    // var invest_amouts = '';
                    // if(invest_amout>0&&invest_amout<1){
                    //   invest_amouts= (invest_amout*10000)+'元';
                    // }else{
                    //   invest_amouts = invest_amout+'万';
                    // }
                    var times =json.content[i].start_time.substring(0,json.content[i].start_time.length-2);
                    for(var key in json.content[i]){
                        str = '<div class="each_tab_tr" onclick="window.location.href=\''+hosts+json.content[i].id+'\'"><p class="apy_number" style="width:162px;">'+json.content[i].name+'</p><p class="apy_investAmount" style="width:162px;">'+
                             formatMoney(invest_amouts,2)+'元</p><p class="apy_yearRate" style="width:162px;">'+invest_apr+'</p><p class="apy_qishu" style="width:162px;">'+mthones+
                             '</p><p class="apy_investTime" style="width:162px;">'+times+'</p><p class="apy_proProgress" style="width:162px;">'+
                             pro+'</p><div class="clear"></div></div>';
                    }
                     $('.touzizhong').append(str);
                }
            }
        });
    }else{
        $('.page_box01').show();
        $('#apyduring').remove();
        $('.page_box01').append('<ul id="apyduring" class="mycredit"></ul>');
        $('#apyduring').twbsPagination({
            totalPages: tto,
            visiblePages: 4,
            first:'',
            last:'',
            prev:'<上一页',
            next:'下一页>',
            onPageClick: function (event, page) {
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/invest/loanInvestList',
                    dataType:'json',
                    data:{
                        userid:$('.apy_invest_during').attr('apid'),
                        pageNum:page, 
                        status:'7A',
                        busitype:2      
                    },
                    success:function(json){
                        $('.touzizhong').html('');
                        var str = '';
                        for(var i=0,l=json.content.length;i<l;i++){
                            var invest_apr = json.content[i].apr+'%';
                            var pro = json.content[i].investProgress+'%';
                            var invest_amouts = json.content[i].money;
                            var mthones = json.content[i].period+'天';
                            // var invest_amouts = '';
                            // if(invest_amout>0&&invest_amout<1){
                            //   invest_amouts= (invest_amout*10000)+'元';
                            // }else{
                            //   invest_amouts = invest_amout+'万';
                            // }
                            var times =json.content[i].start_time.substring(0,json.content[i].start_time.length-2);   
                            for(var key in json.content[i]){
                                str = '<div class="each_tab_tr" onclick="window.location.href=\''+hosts+json.content[i].id+'\'"><p class="apy_number" style="width:162px;">'+json.content[i].name+'</p><p class="apy_investAmount" style="width:162px;">'+
                                     formatMoney(invest_amouts,2)+'元</p><p class="apy_yearRate" style="width:162px;">'+invest_apr+'</p><p class="apy_qishu" style="width:162px;">'+mthones+
                                     '</p><p class="apy_investTime" style="width:162px;">'+times+'</p><p class="apy_proProgress" style="width:162px;">'+
                                     pro+'</p><div class="clear"></div></div>';
                            }
                             $('.touzizhong').append(str);
                        }
                    }
                });
            }
        });
    }
    // 投资中分页js End


    // 还款中分页js 接口Start
    var tt02=0;
    $.ajax({
        type:'post',
        url:getContextPaths()+'/invest/loanInvestRecoverList',
        dataType:'json',
        async: false,//同步
        data:{
            userid:uId,
            status:'8A',
            busitype:2
        },
        success:function(json){
            tt02 = json.totalPage;
        }
    });
    
    if(tt02==0){
        $('.page_box02').hide();
        $('.repay_durBox').html('没有数据！');

    }else if(tt02==1){
        $('.page_box02').hide();
        $.ajax({
            type:'post',
            url:getContextPaths()+'/invest/loanInvestRecoverList',
            dataType:'json',
            data:{
                userid:uId,
                status:'8A',
                busitype:2
            },
            success:function(json){
                var contractHref = '';
                $('.repay_durBox').html('');
                var str = '';
                for(var i=0,l=json.content.length;i<l;i++){
                    // 投资金额
                    var invest_amout = (json.content[i].money == null) ? 0 : json.content[i].money;
                    // 待收本息
                    var benxi = (json.content[i].sumReMoney == null) ? 0 : json.content[i].sumReMoney +'元';
                    // 已还期数
                    var realy_period = (json.content[i].hasPeriod == null) ? 0 : json.content[i].hasPeriod;
                    // 总期数
                    var total_period = (json.content[i].period == null) ? 0 : json.content[i].period;
                    var period_txt = realy_period+'/'+total_period;
                    // 下个还款日  
                    var times = (json.content[i].nestRepayDate == null) ? '' : json.content[i].nestRepayDate.substring(0,json.content[i].nestRepayDate.length-8);
                    var investID = (json.content[i].invest_id == null) ? '' : json.content[i].invest_id;
                    contractHref ='/pdf/'+json.content[i].loan_date+'/'+json.content[i].order_number+uId+'.pdf';

                    for(var key in json.content[i]){
                        str = '<div class="each_tab_tr"><p class="credit_number" onclick="window.location.href=\''+hosts+json.content[i].id+'\'" style="width:162px;">'+
                            json.content[i].name+'</p><p class="cre_investAmount" onclick="window.location.href=\''+hosts+json.content[i].id+'\'" style="width:162px;">'+
                            formatMoney(invest_amout,2)+'元</p><p class="cre_rate" onclick="window.location.href=\''+hosts+json.content[i].id+'\'" style="width:162px;">'+
                            benxi+'</p><p class="cre_qishu" onclick="window.location.href=\''+hosts+json.content[i].id+'\'" style="width:162px;">'+
                            period_txt+'</p><p class="cre_reimbuDate" onclick="window.location.href=\''+hosts+json.content[i].id+'\'" style="width:162px;">'+
                            times+'</p><p class="cre_contract" style="cursor:pointer;width:162px;"><a style="color:#474e5d" class="contract_href01" href="javaScript:void(0);" hf=\''+contractHref+'\'>查看合同</a></p><div class="clear"></div></div>';
                            
                    }
                    $('.repay_durBox').append(str);
                    
                }
                $('.contract_href01').each(function(){
                    $(this).click(function(){   
                        var hf = $(this).attr('hf');
                        $.ajax({
                            type:'post',
                            url:getContextPaths()+'/user/checkContactPdf',
                            dataType:'json',
                            data:{
                                contactFile:hf
                            },
                            success:function(json){
                                if(json.flag == 1){
                                   $(this).attr('target','_blank');
                                   window.location.href=globalUrl + hf;
                                }else{
                                    alert('合同不存在');
                                }
                            }
                        });
                    });
                    
                });

            }
        });
    }else{
        $('.page_box02').show();
        $('#invt_pages').remove();
        $('.page_box02').append('<ul id="invt_pages" class="invt_pages"></ul>');
        $('#invt_pages').twbsPagination({
            totalPages: tt02,
            visiblePages: 4,
            first:'',
            last:'',
            prev:'<上一页',
            next:'下一页>',
            onPageClick: function (event, page) {
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/invest/loanInvestRecoverList',
                    dataType:'json',
                    data:{
                        userid:uId,
                        pageNum:page,
                        status:'8A',
                        busitype:2
                    },
                    success:function(json){
                        var contractHref = '';
                        $('.repay_durBox').html('');
                        var str = '';
                        for(var i=0,l=json.content.length;i<l;i++){
                            // 投资金额
                            var invest_amout = (json.content[i].money == null) ? 0 : json.content[i].money;
                            // 待收本息
                            var benxi = (json.content[i].sumReMoney == null) ? 0 : json.content[i].sumReMoney +'元';
                            // 已还期数
                            var realy_period = (json.content[i].hasPeriod == null) ? 0 : json.content[i].hasPeriod;
                            // 总期数
                            var total_period = (json.content[i].period == null) ? 0 : json.content[i].period;
                            var period_txt = realy_period+'/'+total_period;
                            // 下一个还款日  
                            var times = (json.content[i].nestRepayDate == null) ? '' : json.content[i].nestRepayDate.substring(0,json.content[i].nestRepayDate.length-8);
                            var investID = (json.content[i].invest_id == null) ? '' : json.content[i].invest_id;
                            contractHref ='/pdf/'+json.content[i].loan_date+'/'+json.content[i].order_number+uId+'.pdf';

                            for(var key in json.content[i]){
                                str = '<div class="each_tab_tr"><p class="credit_number" onclick="window.location.href=\''+hosts+json.content[i].id+'\'" style="width:162px;">'+
                                    json.content[i].name+'</p><p class="cre_investAmount" onclick="window.location.href=\''+hosts+json.content[i].id+'\'" style="width:162px;">'+
                                    formatMoney(invest_amout,2)+'元</p><p class="cre_rate" onclick="window.location.href=\''+hosts+json.content[i].id+'\'" style="width:162px;">'+
                                    benxi+'</p><p class="cre_qishu" onclick="window.location.href=\''+hosts+json.content[i].id+'\'" style="width:162px;">'+
                                    period_txt+'</p><p class="cre_reimbuDate" onclick="window.location.href=\''+hosts+json.content[i].id+'\'" style="width:162px;">'+
                                    times+'</p><p class="cre_contract" style="cursor:pointer;width:162px;"><a style="color:#474e5d" class="contract_href01" href="javaScript:void(0);" hf=\''+contractHref+'\'>查看合同</a></p><div class="clear"></div></div>';
                            

                            }
                            $('.repay_durBox').append(str);
                        }


                        $('.contract_href01').each(function(){
                            $(this).click(function(){
                                var hf = $(this).attr('hf');
                                $.ajax({
                                    type:'post',
                                    url:getContextPaths()+'/user/checkContactPdf',
                                    dataType:'json',
                                    data:{
                                        contactFile:hf
                                    },
                                    success:function(json){
                                        if(json.flag == 1){
                                           $(this).attr('target','_blank');
                                           window.location.href = globalUrl + hf;
                                        }else{
                                            alert('合同不存在');
                                        }
                                    }
                                });
                            });
                    
                        });
                    }
                });
            }
        });
    }

    
    // 还款中分页js 接口End



    // 已还款分页js 接口Start

    var tt03=0;
    $.ajax({
        type:'post',
        url:getContextPaths()+'/invest/loanInvestRecoverList',
        dataType:'json',
        async: false,//同步
        data:{
            userid:uId,
            status:10,
            busitype:2
        },
        success:function(json){
            tt03 = json.totalPage;
        }
    });

    if(tt03==0){
        $('.page_box03').hide();
        $('.repay_cptBox').html('没有数据！');

    }else if(tt03==1){
        $('.page_box03').hide();
        $.ajax({
            type:'post',
            url:getContextPaths()+'/invest/loanInvestRecoverList',
            dataType:'json',
            data:{
                userid:uId,
                status:10,
                busitype:2
            },
            success:function(json){
                var contractHref ='';
                $('.repay_cptBox').html('');
                var str = '';
                for(var i=0,l=json.content.length;i<l;i++){
                    // 投资金额
                    var invest_amout = (json.content[i].money == null) ? 0 : json.content[i].money;
                    // 待收本息
                    var benxi = (json.content[i].sumReMoney == null) ? 0 : json.content[i].sumReMoney +'元';
                    // 已还期数
                    var realy_period = (json.content[i].hasPeriod == null) ? 0 : json.content[i].hasPeriod;
                    // 总期数
                    var total_period = (json.content[i].period == null) ? 0 : json.content[i].period;
                    var period_txt = realy_period+'/'+total_period;
                    // 下个还款日  
                    var times = (json.content[i].nestRepayDate == null) ? '' : json.content[i].nestRepayDate.substring(0,json.content[i].nestRepayDate.length-8);
                    var investID = (json.content[i].invest_id == null) ? '' : json.content[i].invest_id;
                    contractHref ='/pdf/'+json.content[i].loan_date+'/'+json.content[i].order_number+uId+'.pdf';
                    for(var key in json.content[i]){
                        str = '<div class="each_tab_tr"><p class="credit_number" style="width:195px;" onclick="window.location.href=\''+hosts+json.content[i].id+'\'">'+
                            json.content[i].name+'</p><p class="cre_investAmount" style="width:195px;" onclick="window.location.href=\''+hosts+json.content[i].id+'\'">'+
                            formatMoney(invest_amout,2)+'元</p><p class="cre_rate" style="width:195px;" onclick="window.location.href=\''+hosts+json.content[i].id+'\'">'+
                            benxi+'</p><p class="cre_qishu" style="width:195px;" onclick="window.location.href=\''+hosts+json.content[i].id+'\'">'+
                            period_txt+'</p><p class="cre_contract" style="cursor:pointer;width:195px;"><a style="color:#474e5d" class="contract_href02" href="javascript:void(0);" hfs=\''+contractHref+'\'>查看合同</a></p><div class="clear"></div></div>';
                            
                    }
                    $('.repay_cptBox').append(str);
                }


                $('.contract_href02').each(function(){
                    $(this).click(function(){
                        var hfs = $(this).attr('hfs');
                        $.ajax({
                            type:'post',
                            url:getContextPaths()+'/user/checkContactPdf',
                            dataType:'json',
                            data:{
                                contactFile:hfs
                            },
                            success:function(json){
                                if(json.flag == 1){
                                   $(this).attr('target','_blank');
                                   window.location.href = globalUrl + hfs;
                                }else{
                                    alert('合同不存在');
                                }
                            }
                        });
                    });
            
                });
            }
        });
    }else{
        $('.page_box03').show();
        $('#repay_during').remove();
        $('.page_box03').append('<ul id="repay_during" class="repay_during"></ul>');
        $('#repay_during').twbsPagination({
            totalPages: tt03,
            visiblePages: 4,
            first:'',
            last:'',
            prev:'<上一页',
            next:'下一页>',
            onPageClick: function (event, page) {
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/invest/loanInvestRecoverList',
                    dataType:'json',
                    data:{
                        userid:uId,
                        pageNum:page,
                        status:10,
                        busitype:2
                    },
                    success:function(json){
                        var contractHref = '';
                        $('.repay_cptBox').html('');
                        var str = '';
                        for(var i=0,l=json.content.length;i<l;i++){
                            // 投资金额
                            var invest_amout = (json.content[i].money == null) ? 0 : json.content[i].money;
                            // 待收本息
                            var benxi = (json.content[i].sumReMoney == null) ? 0 : json.content[i].sumReMoney +'元';
                            // 已还期数
                            var realy_period = (json.content[i].hasPeriod == null) ? 0 : json.content[i].hasPeriod;
                            // 总期数
                            var total_period = (json.content[i].period == null) ? 0 : json.content[i].period;
                            var period_txt = realy_period+'/'+total_period;
                            // 下一个还款日  
                            // var times = (json.content[i].nestRepayDate == null) ? '' : json.content[i].nestRepayDate.substring(0,json.content[i].nestRepayDate.length-8);
                            var investID = (json.content[i].invest_id == null) ? '' : json.content[i].invest_id;
                            var contractHref ='/pdf/'+json.content[i].loan_date+'/'+json.content[i].order_number+uId+'.pdf';
                            for(var key in json.content[i]){
                                str = '<div class="each_tab_tr"><p class="credit_number" style="width:195px;" onclick="window.location.href=\''+hosts+json.content[i].id+'\'">'+
                                    json.content[i].name+'</p><p class="cre_investAmount" style="width:195px;" onclick="window.location.href=\''+hosts+json.content[i].id+'\'">'+
                                    formatMoney(invest_amout,2)+'元</p><p class="cre_rate" style="width:195px;" onclick="window.location.href=\''+hosts+json.content[i].id+'\'">'+
                                    benxi+'</p><p class="cre_qishu" style="width:195px;" onclick="window.location.href=\''+hosts+json.content[i].id+'\'">'+
                                    period_txt+'</p><p class="cre_contract" style="cursor:pointer;width:195px;"><a style="color:#474e5d" class="contract_href02" href="javascript:void(0);" hfs=\''+contractHref+'\'>查看合同</a></p><div class="clear"></div></div>';
                            
                            }
                            $('.repay_cptBox').append(str);
                        }

                        $('.contract_href02').each(function(){
                            $(this).click(function(){
                                var hfs = $(this).attr('hfs');
                                $.ajax({
                                    type:'post',
                                    url:getContextPaths()+'/user/checkContactPdf',
                                    dataType:'json',
                                    data:{
                                        contactFile:hfs
                                    },
                                    success:function(json){
                                        if(json.flag == 1){
                                           $(this).attr('target','_blank');
                                           window.location.href = globalUrl + hfs;
                                        }else{
                                            alert('合同不存在');
                                        }
                                    }
                                });
                            });
                    
                        });
                    }
                });
            }
        });
    }





    // 已还款分页js 接口End







































});