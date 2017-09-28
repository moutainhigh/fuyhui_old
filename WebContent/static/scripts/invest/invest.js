// zhanganyi  2016-09-29
$(function(){
	var inselectFlag = false;//是否点击下拉框选项值
	var inyRateUp = false;//年化利率升序
	var inyRateDown = false;//年化利率降序
	var inLimiteUp = false;//借款期限升序
	var inLimiteDown = false;//借款期限降序
	var inPage = false;//是否点击页码

	// 当点击'投资列表'按钮时触发
	$('.borrow_tab_box .borrow_itemBtn').click(function(){
		$('.dbborrow_itemBtn').removeClass('active');
		$(this).addClass('active');
		$('.invest_item_box').show();
		$('.dbborrow_item_box').hide();
	});

	// 当点击'债权转让'按钮时触发
	$('.borrow_tab_box .dbborrow_itemBtn').click(function(){
		$('.borrow_itemBtn').removeClass('active');
		$(this).addClass('active');
		$('.dbborrow_item_box').show();
		$('.invest_item_box').hide();
	});
	var host = getContextPaths();
	var investTpage = 0;//投资列表总的页数
	var investCpage = 0;//当前页
	$.ajax({
		type:'post',
		url:getContextPaths()+'/invest/investList',
		dataType:'json',
		async: false,//同步
		success:function(json){
			investTpage = json.totalPage;
		}
	});
	var hosts = getContextPaths()+'/invest/enterInvestDetail?id=';


	// 当页面一加载就去请求投资列表接口一次
	var tto = 0;
	$.ajax({
		type:'post',
		url:getContextPaths()+'/invest/investList',
		dataType:'json',
		async: false,
		data:{
			type:1,
            pageSize:6
        },
		success:function(json){
			tto = json.totalPage;
		}
	});
	if(tto==0){
		$('.invest_pages_box').hide();
		$('.invest_item_body').html('没有数据！').css('height','500px');
	}else if(tto==1){
		$('.invest_pages_box').hide();
		$.ajax({
			type:'post',
			url:getContextPaths()+'/invest/investList',
			dataType:'json',
			data:{
				type:1,
	            pageSize:6
        	},
			success:function(json){
				$('.invest_item_body').html('');
				var str = '';
				for(var i=0,l=json.content.length;i<l;i++){
					var invest_pro = json.content[i].investProgress+'%';
			    	  // var invest_amouts = '';
			    	  // if(invest_amout>0&&invest_amout<1){
			    	  // 	invest_amouts= (invest_amout*10000)+'元';
			    	  // }else{
			    	  // 	invest_amouts = invest_amout+'万';
			    	  // }
			    	if(json.content.length>4){
			    		$('.invest_item_body').css('height','1100px');
			    	}else{
			    		$('.invest_item_body').css('height','832px');
			    	}
				    for(var key in json.content[i]){
				    	  str = '<div class="each_item_contents" onclick="window.location.href=\''+hosts+json.content[i].id+'\'"><div class="each_ivst_title">'+
				    	        json.content[i].loanName+'</div><div class="fl each_rates_box"><div class="each_rates">'+json.content[i].apr+
				    	        '%</div><div class="each_txts">预期年化收益</div></div><div class="fl each_divs"><div class="each_num">'+
				    	        json.content[i].period+'天</div><div class="each_txts">预期产品期限</div></div><div class="fl each_divs"><div class="each_num">'+
				    	        formatMoney(json.content[i].amount,2)+'元</div><div class="each_txts">产品规模</div></div><div class="fl each_divs"><div class="each_num">'+
				    	        formatMoney(json.content[i].investMin,2)+'元</div><div class="each_txts">认购起点</div></div><div class="fl invest_progress"><div class="inveset_progress_num"><div class="borrow_proNum">'+
				    	        invest_pro+'</div></div></div><div class="fl invest_group_btns"><div isl=\''+json.content[i].isLoans+'\' class="subscribe_btn" status=\''+json.content[i].status+'\'>认购中</div></div><div class="clear"></div></div>';
				    }
				     $('.invest_item_body').append(str);
					}
					progressFunction();
					investBtnFunction();
			}
		});
	}else{
		$('.invest_pages_box').show();
		$('#invest_page01').remove();
		$('.invest_pages_box').append('<ul id="invest_page01" class="invest_page_ul"></ul>');
		$('#invest_page01').twbsPagination({
	        totalPages: tto,
	        visiblePages: 4,
	        first:'',
	        last:'',
	        prev:'<上一页',
	        next:'下一页>',
	        onPageClick: function (event, page) {
	        	$.ajax({
					type:'post',
					url:getContextPaths()+'/invest/investList',
					dataType:'json',
					data:{
						type:1,
	            		pageSize:6,
                		pageNum:page
            		},
					success:function(json){
						$('.invest_item_body').html('');
						var str = '';
						for(var i=0,l=json.content.length;i<l;i++){
							var invest_pro = json.content[i].investProgress+'%';
							var invest_amout = json.content[i].amount;
					    	  // var invest_amouts = '';
					    	  // if(invest_amout>0&&invest_amout<1){
					    	  // 	invest_amouts= (invest_amout*10000)+'元';
					    	  // }else{
					    	  // 	invest_amouts = invest_amout+'万';
					    	  // }
				    	  if(json.content.length>4){
					    	$('.invest_item_body').css('height','1100px');
					      }else{
					    	$('.invest_item_body').css('height','832px');
					      }
						    for(var key in json.content[i]){
					    	  str = '<div class="each_item_contents" onclick="window.location.href=\''+hosts+json.content[i].id+'\'"><div class="each_ivst_title">'+
					    	        json.content[i].loanName+'</div><div class="fl each_rates_box"><div class="each_rates">'+json.content[i].apr+
					    	        '%</div><div class="each_txts">预期年化收益</div></div><div class="fl each_divs"><div class="each_num">'+
					    	        json.content[i].period+'天</div><div class="each_txts">预期产品期限</div></div><div class="fl each_divs"><div class="each_num">'+
					    	        formatMoney(json.content[i].amount,2)+'元</div><div class="each_txts">产品规模</div></div><div class="fl each_divs"><div class="each_num">'+
					    	        formatMoney(json.content[i].investMin,2)+'元</div><div class="each_txts">认购起点</div></div><div class="fl invest_progress"><div class="inveset_progress_num"><div class="borrow_proNum">'+
					    	        invest_pro+'</div></div></div><div class="fl invest_group_btns"><div isl=\''+json.content[i].isLoans+'\' class="subscribe_btn" status=\''+json.content[i].status+'\'>认购中</div></div><div class="clear"></div></div>';
					    	}
						    $('.invest_item_body').append(str);
	 					}
	 					progressFunction();
	 					investBtnFunction();
					}
				});
	        }
		});
	}




	
	


	// 投资列表-页面加载时就请求获取全部产品
	$.ajax({
		type:'post',
		url:getContextPaths()+'/invest/investTypeList',
		dataType:'json',
		success:function(json){
			for(var i=0,l=json.content.length;i<l;i++){
				var str = '';
			    for(var key in json.content[i]){
			    	 str = '<option value='+json.content[i]+'>'+json.content[i]+'</option>';
			    }
			    $('.invest_select').append(str);
 			}
		}
	});

	// 点击‘全部产品’下拉框选择相应的产品时触发
	var tts = 0;
	//var s = 0;
	$(".invest_item_box .invest_select").change(function(){
		if($(".invest_item_box .invest_select option:selected")){
		$.ajax({
			type:'post',
			url:getContextPaths()+'/invest/investList',
			dataType:'json',
			async: false,
			data:{
					loanType:$(".invest_item_box .invest_select option:selected").val()
				},//同步
			success:function(json){
				tts = json.totalPage;
				//s = $(".invest_item_box .invest_select option:selected").val();
			}
		});
		if(tts==0){
			$('.invest_pages_box').hide();
			$('.invest_item_body').html('没有数据！');	
		}else if(tts==1){
			$('.invest_pages_box').hide();
			$.ajax({
					type:'post',
					url:getContextPaths()+'/invest/investList',
					dataType:'json',
					data:{
							loanType:$(".invest_item_box .invest_select option:selected").val()
						},
					success:function(json){
						$('.invest_item_body').html('');
						var str = '';
						for(var i=0,l=json.content.length;i<l;i++){
							var invest_pro = json.content[i].investProgress+'%';
							var invest_amout = json.content[i].amount;
					    	  // var invest_amouts = '';
					    	  // if(invest_amout>0&&invest_amout<1){
					    	  // 	invest_amouts= (invest_amout*10000)+'元';
					    	  // }else{
					    	  // 	invest_amouts = invest_amout+'万';
					    	  // }
						    for(var key in json.content[i]){
						    	  str = '<div class="each_item_contents" onclick="window.location.href=\''+hosts+json.content[i].id+'\'"><div class="fl invest_name">'+json.content[i].loanName+'</div><div class="fl invest_rate com_invest">'+json.content[i].apr+'%'+
						    	  '</div><div class="fl borrow_limite com_invest"><span class="borrow_litime_moutn">'+json.content[i].period+'</span>'+'天'+'</div><div class="fl borrow_money com_invest"><span class="borrow_amoutn_num">'+
						    	  invest_amout+'元</span>'+'</div><div class="fl invest_progress"><div class="inveset_progress_num"><div class="borrow_proNum">'+invest_pro+'</div></div></div><div class="fl invest_opear"><div isl=\''+json.content[i].isLoans+'\' class="invest_btn" status='+json.content[i].status+'>'+
						    	  '立即投资'+'</div>'+'</div><div class="clear">'+'</div>'+'</div>';
						    }
						     $('.invest_item_body').append(str);
	 					}
	 					progressFunction();
	 					investBtnFunction();
					}
				});
		}else{
			$('.invest_pages_box').show();
			$('#invest_page01').remove();
			$('.invest_pages_box').append('<ul id="invest_page01" class="invest_page_ul"></ul>');
			// $('#invest_page0'+s).remove();
			// $('.invest_pages_box').append('<ul class="invest_page_ul" id=invest_page0'+s+'></ul>');
			$('#invest_page01').twbsPagination({
		        totalPages: tts,
		        visiblePages: 4,
		        first:'',
		        last:'',
		        prev:'<上一页',
		        next:'下一页>',
		        onPageClick: function (event, page) {
		        	$.ajax({
						type:'post',
						url:getContextPaths()+'/invest/investList',
						dataType:'json',
						data:{
								loanType:$(".invest_item_box .invest_select option:selected").val(),
								pageNum:page
							},
						success:function(json){
							$('.invest_item_body').html('');
							var str = '';
							for(var i=0,l=json.content.length;i<l;i++){
								var invest_pro = json.content[i].investProgress+'%';
								var invest_amout = json.content[i].amount;
						    	  // var invest_amouts = '';
						    	  // if(invest_amout>0&&invest_amout<1){
						    	  // 	invest_amouts= (invest_amout*10000)+'元';
						    	  // }else{
						    	  // 	invest_amouts = invest_amout+'万';
						    	  // }
							    for(var key in json.content[i]){
							    	  str = '<div class="each_item_contents" onclick="window.location.href=\''+hosts+json.content[i].id+'\'"><div class="fl invest_name">'+json.content[i].loanName+'</div><div class="fl invest_rate com_invest">'+json.content[i].apr+'%'+
							    	  '</div><div class="fl borrow_limite com_invest"><span class="borrow_litime_moutn">'+json.content[i].period+'</span>'+'天'+'</div><div class="fl borrow_money com_invest"><span class="borrow_amoutn_num">'+
							    	  invest_amout+'元</span>'+'</div><div class="fl invest_progress"><div class="inveset_progress_num"><div class="borrow_proNum">'+invest_pro+'</div></div></div><div class="fl invest_opear"><div isl=\''+json.content[i].isLoans+'\' class="invest_btn" status='+json.content[i].status+'>'+
							    	  '立即投资'+'</div>'+'</div><div class="clear">'+'</div>'+'</div>';
							    }
							     $('.invest_item_body').append(str);
		 					}
		 					progressFunction();
		 					investBtnFunction();
						}
					});
		        }
	       });
		}
			
				
	}
		
	
});
	

	// 点击‘借款期限’下拉框选择相应的产品时触发
	var tti = 0;
	$(".invest_item_box .borrowLimit_select").change(function(){
		if($(".invest_item_box .borrowLimit_select option:selected")){
			$.ajax({
				type:'post',
				url:getContextPaths()+'/invest/investList',
				dataType:'json',
				async: false,
				data:{
						period:$(".invest_item_box .borrowLimit_select option:selected").val()
					},//同步
				success:function(json){
					tti = json.totalPage;
				}
			});
			if(tti==0){
				$('.invest_pages_box').hide();
				$('.invest_item_body').html('没有数据！');
			}else if(tti==1){
				$('.invest_pages_box').hide();
				$.ajax({
					type:'post',
					url:getContextPaths()+'/invest/investList',
					dataType:'json',
					data:{
							period:$(".invest_item_box .borrowLimit_select option:selected").val()
						},
					success:function(json){
						$('.invest_item_body').html('');
						var str = '';
						for(var i=0,l=json.content.length;i<l;i++){
							var invest_pro = json.content[i].investProgress+'%';
							var invest_amout = json.content[i].amount;
					    	  // var invest_amouts = '';
					    	  // if(invest_amout>0&&invest_amout<1){
					    	  // 	invest_amouts= (invest_amout*10000)+'元';
					    	  // }else{
					    	  // 	invest_amouts = invest_amout+'万';
					    	  // }

						    for(var key in json.content[i]){
						    	  str = '<div class="each_item_contents" onclick="window.location.href=\''+hosts+json.content[i].id+'\'"><div class="fl invest_name">'+json.content[i].loanName+'</div><div class="fl invest_rate com_invest">'+json.content[i].apr+'%'+
						    	  '</div><div class="fl borrow_limite com_invest"><span class="borrow_litime_moutn">'+json.content[i].period+'</span>'+'天'+'</div><div class="fl borrow_money com_invest"><span class="borrow_amoutn_num">'+
						    	  invest_amout+'元</span>'+'</div><div class="fl invest_progress"><div class="inveset_progress_num"><div class="borrow_proNum">'+invest_pro+'</div></div></div><div class="fl invest_opear"><div isl=\''+json.content[i].isLoans+'\' class="invest_btn" status='+json.content[i].status+'>'+
						    	  '立即投资'+'</div>'+'</div><div class="clear">'+'</div>'+'</div>';
						    }
						     $('.invest_item_body').append(str);
	 					}
	 					progressFunction();
	 					investBtnFunction();
					}
				});
			}else{
				$('.invest_pages_box').show();
				$('#invest_page01').remove();
				$('.invest_pages_box').append('<ul id="invest_page01" class="invest_page_ul"></ul>');
				$('#invest_page01').twbsPagination({
			        totalPages: tti,
			        visiblePages: 4,
			        first:'',
			        last:'',
			        prev:'<上一页',
			        next:'下一页>',
			        onPageClick: function (event, page) {
			        	$.ajax({
							type:'post',
							url:getContextPaths()+'/invest/investList',
							dataType:'json',
							data:{
									period:$(".invest_item_box .borrowLimit_select option:selected").val(),
									pageNum:page
								},
							success:function(json){
								$('.invest_item_body').html('');
								var str = '';
								for(var i=0,l=json.content.length;i<l;i++){
									var invest_pro = json.content[i].investProgress+'%';
									var invest_amout = json.content[i].amount;
							    	  // var invest_amouts = '';
							    	  // if(invest_amout>0&&invest_amout<1){
							    	  // 	invest_amouts= (invest_amout*10000)+'元';
							    	  // }else{
							    	  // 	invest_amouts = invest_amout+'万';
							    	  // }
								    for(var key in json.content[i]){
								    	  str = '<div class="each_item_contents" onclick="window.location.href=\''+hosts+json.content[i].id+'\'"><div class="fl invest_name">'+json.content[i].loanName+'</div><div class="fl invest_rate com_invest">'+json.content[i].apr+'%'+
								    	  '</div><div class="fl borrow_limite com_invest"><span class="borrow_litime_moutn">'+json.content[i].period+'</span>'+'天'+'</div><div class="fl borrow_money com_invest"><span class="borrow_amoutn_num">'+
								    	  invest_amout+'元</span>'+'</div><div class="fl invest_progress"><div class="inveset_progress_num"><div class="borrow_proNum">'+invest_pro+'</div></div></div><div class="fl invest_opear"><div isl=\''+json.content[i].isLoans+'\' class="invest_btn" status='+json.content[i].status+'>'+
								    	  '立即投资'+'</div>'+'</div><div class="clear">'+'</div>'+'</div>';
								    }
								     $('.invest_item_body').append(str);
			 					}
			 					progressFunction();
			 					investBtnFunction();
							}
						});
			        }
		    	});
			}
			
				
		}
		
	
	});







				

		
	



 //    // 债权转让分页调用
	// $('#dbinvest_page').twbsPagination({
 //        totalPages: 35,
 //        visiblePages: 4,
 //        first:'',
 //        last:'',
 //        prev:'上一页>',
 //        next:'下一页>',
 //        onPageClick: function (event, page) {
 //            // $('#page-content').text('Page ' + page);
            
 //        }
 //    });
});





// 项目进度js
function progressFunction(){
	$('.borrow_proNum').each(function(){
	var invest_proNum = parseInt($(this).text()) / 100*100;
	 if(invest_proNum==0){
	 	$(this).parent().css('background-position','0 0');
	 }
	  if(invest_proNum>0&&invest_proNum<=10){
	 	$(this).parent().css('background-position','-70px 0');
	 }
	 if(invest_proNum>10&&invest_proNum<=20){
	 	$(this).parent().css('background-position','-138px 0');
	 }
	 if(invest_proNum>20&&invest_proNum<=30){
	 	$(this).parent().css('background-position','-208px 0');
	 }
	  if(invest_proNum>30&&invest_proNum<=40){
	 	$(this).parent().css('background-position','-276px 0');
	 }
	 if(invest_proNum>40&&invest_proNum<=50){
	 	$(this).parent().css('background-position','-346px 0');
	 }
	 if(invest_proNum>50&&invest_proNum<=60){
	 	$(this).parent().css('background-position','-414px 0');
	 }
	 if(invest_proNum>60&&invest_proNum<=70){
	 	$(this).parent().css('background-position','-484px 0');
	 }
	 if(invest_proNum>70&&invest_proNum<=80){
	 	$(this).parent().css('background-position','-552px 0');
	 }
	 if(invest_proNum>80&&invest_proNum<100){
	 	$(this).parent().css('background-position','-621px 0');
	 }
	 if(invest_proNum==100){
	 	$(this).parent().css('background-position','-690px 0');
	 }
	});
}

// 立即投资按钮状态js
function investBtnFunction(){
	$('.invest_group_btns').each(function(){
		var _this = $(this);
		var status =parseInt(_this.find('div').attr('status'));
		var isl = parseInt(_this.find('div').attr('isl'));
		// console.log(status);
    	if(status==7){
    		_this.find('div').first().addClass('subscribe_btn').removeClass('receivable_btn').removeClass('yuren_btn').removeClass('hasend_btn');
    	}else if(status==8 && isl ==0){
    		_this.find('div').first().addClass('hasend_btn').removeClass('hasend_btn').removeClass('receivable_btn').removeClass('yuren_btn').html('已售罄');
    	}else if(status==9 || (status==8&&(isl!=0))){
    		_this.find('div').first().addClass('receivable_btn').removeClass('subscribe_btn').removeClass('yuren_btn').removeClass('hasend_btn').html('回款中');
    	}else if(status==10){
    		_this.find('div').first().addClass('hasend_btn').removeClass('subscribe_btn').removeClass('yuren_btn').removeClass('receivable_btn').html('已结束');
    	}else if(status==2){
			_this.find('div').first().addClass('yuren_btn').removeClass('subscribe_btn').removeClass('receivable_btn').removeClass('hasend_btn').html('预热中');
    	}else{
    		_this.find('div').first().addClass('hasend_btn').removeClass('subscribe_btn').removeClass('yuren_btn').removeClass('receivable_btn').html('流标');
    	}	  
	 });
	
}





