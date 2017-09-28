$(function(){
    var hosts01 = getContextPaths()+'/invest/enterInvestDetail?id=';
    var hosts02 = getContextPaths()+'/invest/enterKumquatDetail?id=';
	//当首页一加载就要去请求产品专区标的展示接口
	// 金猪系列产品
	$.ajax({
        type:'post',
        url:getContextPaths()+'/user/getApplyLoanList',
        dataType:'json',
        data:{
            pageSize:3,
            loanType:'金猪'
        },
        success:function(json){
            var str = '';
            var ii = 1;
            for(var i=0,l=json.content.length;i<l;i++){
				//图片地址				
                ii++;
				if(ii==5){
					ii=1;
				}

                var urls = globalUrl +json.content[i].url;
                // console.log(json.content[i].url);
				// var urls = globalUrl +json.content[i].url;
				//筹款金额
                var status = json.content[i].status;
                var isloans = json.content[i].isLoans;
				var moneys =(parseFloat(json.content[i].amount)/10000+'').substring(0,(parseFloat(json.content[i].amount)/10000+'').indexOf('.')+3); 
                for(var key in json.content[i]){
                    str = '<li onclick="window.location.href=\''+hosts01+json.content[i].id+'\'" class=top_item0'+ii+'><img src=\''+urls+'\' alt="理财猪" class="pro_img" width="280px" height="208px"><h4 class="item_title">'+
                    	json.content[i].name+'</h4><div class="item_box"><div><span class="item_txt">'+json.content[i].apr+'%</span><span class="item_rate">'+
                    	json.content[i].period+'天</span></div><div><span class="item_txt_money">预期年化收益&nbsp;&nbsp;<span class="item_nums"></span></span><span class="item_time_limit">&nbsp;&nbsp;<span class="item_nums">预期产品期限</span></span></div></div><a sat=\''+status+'\' isl=\''+isloans+'\' href="javascript:void(0);" class="buy_btn lijiBtn">认购中</a></li>';
                        
                }
                 $('.top_pro_list').append(str);
            }
            investBtnFunction();
        }
    });
	

	// 金桔系列产品
    $.ajax({
        type:'post',
        url:getContextPaths()+'/user/getApplyLoanList',
        dataType:'json',
        data:{
            pageSize:3,
            loanType:'金桔'
        },
        success:function(json){
            var str = '';
            var ii = 1;
            for(var i=0,l=json.content.length;i<l;i++){
                //图片地址              
                ii++;
                if(ii==5){
                    ii=1;
                }

                var urls = globalUrl +json.content[i].url;
                // console.log(json.content[i].url);
                // var urls = globalUrl +json.content[i].url;
                //筹款金额
                var status = json.content[i].status;
                var isloans = json.content[i].isLoans;
                var moneys =(parseFloat(json.content[i].amount)/10000+'').substring(0,(parseFloat(json.content[i].amount)/10000+'').indexOf('.')+3); 
                for(var key in json.content[i]){
                    str = '<li onclick="window.location.href=\''+hosts02+json.content[i].id+'\'" class=top_item0'+ii+'><img src=\''+urls+'\' alt="理财猪" class="pro_img" width="280px" height="208px"><h4 class="item_title">'+
                        json.content[i].name+'</h4><div class="item_box"><div><span class="item_txt">'+json.content[i].apr+'%</span><span class="item_rate">'+
                        json.content[i].period+'天</span></div><div><span class="item_txt_money">预期年化收益&nbsp;&nbsp;<span class="item_nums"></span></span><span class="item_time_limit">&nbsp;&nbsp;<span class="item_nums">预期产品期限</span></span></div></div><a sat=\''+status+'\' isl=\''+isloans+'\' href="javascript:void(0);" class="buy_btn lijiBtn">认购中</a></li>';
                        
                }
                 $('.bot_pro_list').append(str);
            }
            investBtnFunction();
        }
    });



	// 首页一加载就去请求投资列表接口一次
	$.ajax({
        type:'post',
        url:getContextPaths()+'/invest/investList',
        dataType:'json',
        success:function(json){
            
        }
    });



	






});



// 立即投资按钮状态js
function investBtnFunction(){
    $('.buy_btn').each(function(){
        var _this = $(this);
        var status =parseFloat(_this.attr('sat'));
        var isl = parseFloat(_this.attr('isl'));
        if(status==7){
            _this.addClass('lijiBtn').removeClass('hasend_btn').removeClass('receivable_btn').removeClass('yuren_btn');
        }else if(status==8 && isl==0){
            _this.addClass('hasend_btn').removeClass('lijiBtn').removeClass('receivable_btn').removeClass('yuren_btn').html('已售罄');
        }else if(status==9 || (status==8&&(isl!=0))){
            _this.addClass('receivable_btn').removeClass('lijiBtn').removeClass('yuren_btn').removeClass('hasend_btn').html('回款中');
        }else if(status==10){
            _this.addClass('hasend_btn').removeClass('lijiBtn').removeClass('yuren_btn').removeClass('receivable_btn').html('已结束');
        }else if(status == 2){
            _this.addClass('yuren_btn').removeClass('lijiBtn').removeClass('hasend_btn').removeClass('receivable_btn').html('预热中');
        }     
     });
    
}