// zhanganyi   2016-10-07
$(function(){
	// 点击‘项目信息’按钮时触发
	tapFunction('.project_info','.indet_project_infosBox','.indet_plan_infoBox','.indet_investRecord_box','.question_box_infos','.indet_projectCourse_box');
	// 点击‘还款计划’按钮时触发
	// tapFunction('.project_plan','.indet_plan_infoBox','.indet_project_infosBox','.indet_investRecord_box','.question_box_infos','.indet_projectCourse_box');
	// 点击‘投资记录’按钮时触发
	tapFunction('.indet_investRecord','.indet_investRecord_box','.indet_project_infosBox','.indet_plan_infoBox','.question_box_infos','.indet_projectCourse_box');
	// 点击‘常见问题’按钮时触发
	tapFunction('.pro_quersions','.question_box_infos','.indet_project_infosBox','.indet_plan_infoBox','.indet_investRecord_box','.indet_projectCourse_box');
	// 点击‘项目历程’按钮时触发
	tapFunction('.project_process','.indet_projectCourse_box','.indet_investRecord_box','.indet_plan_infoBox','.question_box_infos','.indet_project_infosBox');
	// 点击眼睛图片时触发

	$('.com_indet_eyeImg').click(function(){
		if($('.indet_avail_dis').css('display')=='none'){
		   $('.indet_avail_money').hide();
		   $('.indet_avail_dis').show();
		   $(this).addClass('no_indet_eyeImg').removeClass('indet_eyeImg');
		}else{
		   $('.indet_avail_money').show();
		   $('.indet_avail_dis').hide();
		   $(this).addClass('indet_eyeImg').removeClass('no_indet_eyeImg');
		}
	});

	// 判断投资金额
    var inv_detail_num = false;
    $('#avail_money').blur(function(){
        var rech_reg =  /^([1-9][\d]{0,16}|0)(\.[\d]{1,2})?$/;
        $('.inv_errorMsg').html('');
        if (this.value==""){
            $('.inv_errorMsg').html('认购金额不能为空！');
            inv_detail_num = false;
        }else if(!rech_reg.test(this.value)){
            $('.inv_errorMsg').html('请输入正确的认购金额！');
            inv_detail_num = false;
        }else if(parseFloat($('.qitouyuan').html()) < parseFloat($('.remaMoney').html()) && this.value < parseFloat($('.qitouyuan').html())){
    		var ketoumoney = parseFloat($('.qitouyuan').html());
        	$('.inv_errorMsg').html('该项目是'+ketoumoney+'元起投！');
            inv_detail_num = false;	
        }else if(parseFloat($('.qitouyuan').html()) >parseFloat($('.remaMoney').html()) && this.value < parseFloat($('.remaMoney').html())){
        	var as = $('.remaMoney').html();
        	$('.inv_errorMsg').html('项目剩余可投金额低于最低认购金额，您必须一次投满'+as+'元！');
	        inv_detail_num = false;
        }else if($('#avail_money').val()>parseFloat($('.remaMoney').html())){
        	$('.inv_errorMsg').html('认购金额不能大于剩余可投金额！');
            inv_detail_num = false;
        }else{
            inv_detail_num = true;
        }
    });



	//红包的查询接口
	$('#avail_money').keyup(function(){
		var sureAmmount=$("#avail_money").val();//文本框的输入的投资金额
		//判断起投金额的输入框是否为空
		//if(sureAmmount==""){
		//	$(".redPack_num").html(0);//赋值红包抵扣的金额
		//	$(".indet_payNum").html(0);//赋值红包付款的金额
		//}

		var investAmount = parseFloat($('.qitouyuan').html());//起投金额的数目
		var surplusAmount = parseFloat($('.remaMoney').html());//剩余可投金额
		var	availableAmount = parseFloat($('.indet_avail_money').html());//账户可用余额

		//判断起投金额的输入框是否满足需求
		if( sureAmmount < investAmount || sureAmmount > surplusAmount || sureAmmount > availableAmount || sureAmmount==""){//满足条件
			// $('.inv_errorMsg').html('请输入正确的投资金额！');
			$(".redPack_num").html(0);//赋值红包抵扣的金额
			$(".indet_payNum").html(0);//赋值红包付款的金额
		}else{//否则，进入接口调用请求
			$('.inv_errorMsg').html("");
			$.ajax({
				type:'post',
				url:getContextPaths()+'/availRedAward?'+'tranAmount='+sureAmmount,
				dataType:'json',
				data:{

				},

				success:function(json){
					if(json.flag == 1){
						//console.log("进去成功的标识");
						var redid=json.content.id;//红包抵扣的id

						//隐藏域的值
						$("#redid").val(redid);//1、隐藏的红包id

						//红包抵扣的id判断
						if(redid){//有id
							//console.log(json.content.initAmount);
							var red_envelopes = parseFloat(json.content.initAmount);//红包抵扣的金额
							var red_payment=(sureAmmount-red_envelopes);//实际付款的金额
							$(".redPack_num").html(red_envelopes);//赋值红包抵扣的金额
							$(".indet_payNum").html(red_payment);//赋值实际付款的金额
						}
						else{//无id
							$(".indet_payNum").html(sureAmmount);//赋值实际付款的金额
						}
					}
				}
			});
		}

	});

	
	// 查询风险测评结果接口
	var riskFlag = false;//定义是否风险测评过
	$.ajax({
		type:'post',
		url:getContextPaths()+'/user/getAssessmentResult',
		dataType:'json',
		success:function(json){
			if(json.flag==1){
				if(json.assessmentResultflag==1){
					riskFlag = true;
				}else{
					riskFlag = false;
				}
			}
		}
	});






    // 当点击‘立即投资’按钮时触发
  //   var flag01 = true;
  //   $('.real_ind_btn').click(function(){
  //   	 if($('#Ifagreement').is(':checked')){
  //   	 if(riskFlag){
	 //    	if(inv_detail_num){
		// 		var redAmmount_sub=$(".redPack_num").html();//获取红包金额的值
		// 		var redid_sub=$("#redid").val();//获取隐藏域的红包id
		// 		if(flag01){
		//     		$.ajax({
		// 				type:'post',
		// 				url:getContextPaths()+'/invest',
		// 				dataType:'json',
		// 				data:{
		// 					id:$('.indetail_name').attr('investid'),
		// 					investMoney:$('#avail_money').val(),
		// 					rewardId:redid_sub,//红包id
		// 					rewardMoney:redAmmount_sub//红包金额
		// 				},
		// 				beforeSend:function(){
		//                 flag01=false;
		//             	},
		// 				success:function(json){
		// 					if(json.flag == 1){
		// 						$('body').append("<div id='invest_fade'></div>");
		// 						$('.invest_window').show(800);
		// 						$('.investClose').click(function(){
		// 							$('#avail_money').val('');
		// 							$('#invest_fade').remove();
		// 							$('.invest_window').hide(800);
		// 							history.go(0);
		// 						});
		// 						$('.investTxt').text(json.msg);
		// 						$('.invest_window').append('<div class="inv_but">确定</div>');
		// 						$('.inv_but').click(function(){
		// 							window.location.href = '/enterInvest';
		// 						});
		// 					}else if(json.flag == 2){
		// 						window.location.href = '/enterLogin';
		// 					}else{
		// 						$('body').append("<div id='invest_fade'></div>");
		// 						$('.invest_window').show(800);
		// 						$('.investClose').click(function(){
		// 							$('#avail_money').val('');
		// 							$('#invest_fade').remove();
		// 							$('.invest_window').hide(800);
		// 							history.go(0);
		// 						});
		// 						$('.investTxt').text(json.msg);
		// 					}
		// 					flag01=true;
		// 				},
		// 				error:function(){
		// 					flag01=true;
		// 				}
		// 			});	
		// 		}


	 //    	}else{
	 //    		$("#avail_money").trigger("blur");
	 //    		return false;
	 //    	}
	 //     }else{
	 //     	var rk_id='';
		// 	if(window.location.search.indexOf("?")!= -1){
		// 		rk_id = window.location.search.substring((window.location.search.indexOf("=")+1));
		// 	}
		// 	var urls = '/enterRiskEvaluation?id='+rk_id;
	 //     	cWindowFunction01('您尚未进行风险测评','为全面了解您的风险承受能力，科学地投资。','立即测评',urls);
	 //     }
	 //    }else{
		// 	alert('请勾选产品合同协议');
		// 	return false;
		// }

  //   });


	// 当点击‘立即投资’按钮时触发（最新版）
    $('.real_ind_btn').click(function(){
      if(riskFlag){
         if(inv_detail_num){  
         	$(this).addClass('iDe_btns'); 
           var contractHref =$(this).attr('conhref');//把产品合同url带到确认投资页面
//            alert(contractHref);
            var ivt_id=$('.indetail_name').attr('investId');//把标的id带到确认投资页面
            var confirmMoney = $('#avail_money').val();//把用户输入的投资金额带到确认投资页面
            var urls = getContextPaths()+'/enterInvestWindow?id='+ivt_id+'&'+confirmMoney;
          $(this).attr('href',urls).attr('conhref02',contractHref);
         }else{
             $("#avail_money").trigger("blur");
             return false;
         }
      }else{
      	$(this).removeClass('iDe_btns');
         var rk_id='';
         if(window.location.search.indexOf("?")!= -1){
             rk_id = window.location.search.substring((window.location.search.indexOf("=")+1));
         }
         var urls = '/enterRiskEvaluation?id='+rk_id;
         cWindowFunction01('您尚未进行风险测评','为全面了解您的风险承受能力，科学地认购。','立即测评',urls);
      }
        

    });
	


	
	

	// 当页面一加载就去请求投资记录接口一次
	var tto = 0;
	// alert(tto);
	$.ajax({
		type:'post',
		url:getContextPaths()+'/invest/investRecord',
		dataType:'json',
		async: false,//同步
		data:{
			applyId:$('.indetail_name').attr('investid')	
		},
		success:function(json){
			tto = json.totalPage;
		}
	});
	// alert(tto);
	if(tto==0){
		$('.investRecordPage').hide();
		$('.inv_record_wrap').html('没有数据！');
	}else if(tto==1){
		$('.investRecordPage').hide();
		$.ajax({
			type:'post',
			url:getContextPaths()+'/invest/investRecord',
			dataType:'json',
			data:{
				applyId:$('.indetail_name').attr('investid')	
			},
			success:function(json){
				$('.inv_record_wrap').html('');
				var str = '';
				for(var i=0,l=json.content.length;i<l;i++){
					var inv_name = json.content[i].userName;
					var inv_time = json.content[i].investTime.substring(0,json.content[i].investTime.length-2);
					var inv_amout = json.content[i].amount;
			    	var inv_amouts = formatMoney(inv_amout,2) + '元';
				    for(var key in json.content[i]){
			    	  	str = '<div class="each_investRecord_infos"><div class="fl iRecord_div iName">'+inv_name+
			    	  		'</div><div class="fl iRecord_div iAmount"><span>'+inv_amouts+'</span></div><div class="fl iRecord_div iTime">'+
			    	  		inv_time+'</div><div class="clear"></div></div>';
				    }
				     $('.inv_record_wrap').append(str);
					}
			}
		});
	}else{
		$('.investRecordPage').show();
		$('#invest_page').remove();
		$('.investRecordPage').append('<ul id="invest_page" class="invest_page"></ul>');
		$('#invest_page').twbsPagination({
	        totalPages: tto,
	        visiblePages: 4,
	        first:'',
	        last:'',
	        prev:'<上一页',
	        next:'下一页>',
	        onPageClick: function (event, page) {
	        	$.ajax({
					type:'post',
					url:getContextPaths()+'/invest/investRecord',
					dataType:'json',
					data:{
						applyId:$('.indetail_name').attr('investid'),//定期理财的项目Id
						pageNum:page	
					},
					success:function(json){
						$('.inv_record_wrap').html('');
						var str = '';
						for(var i=0,l=json.content.length;i<l;i++){
							var inv_name = json.content[i].userName;
							var inv_time = json.content[i].investTime.substring(0,json.content[i].investTime.length-2);
							// var inv_amout = parseFloat(json.content[i].amount)/10000;
					  //   	var inv_amouts = '';
					  //   	if(inv_amout>0&&inv_amout<1){
					  //   	 	inv_amouts= (inv_amout*10000)+'元';
					  //   	}else{
					  //   	  	inv_amouts = inv_amout+'万';
					  //   	}
					  		var inv_amout = json.content[i].amount;
			    			var inv_amouts = formatMoney(inv_amout,2) + '元';
						    for(var key in json.content[i]){
						    	  str = '<div class="each_investRecord_infos"><div class="fl iRecord_div iName">'+inv_name+
			    	  					'</div><div class="fl iRecord_div iAmount"><span>'+inv_amouts+'</span></div><div class="fl iRecord_div iTime">'+
			    	  					inv_time+'</div><div class="clear"></div></div>';
						    }
						     $('.inv_record_wrap').append(str);
	 					}
					}
				});
	        }
		});
	}

	

	// 标的详情页-投资记录模块分页js
	// $('#invest_page').twbsPagination({
 //        totalPages: tto,
 //        visiblePages: 4,
 //        first:'',
 //        last:'',
 //        prev:'<上一页',
 //        next:'下一页>',
 //        onPageClick: function (event, page) {
 //            // $('#page-content').text('Page ' + page);
 //            $.ajax({
	// 				type:'post',
	// 				url:getContextPaths()+'/invest/investRecord',
	// 				dataType:'json',
	// 				data:{
	// 					applyId:$('.indetail_name').attr('investid'),
	// 					pageNum:page	
	// 				},
	// 				success:function(json){
	// 					$('.inv_record_wrap').html('');
	// 					var str = '';
	// 					for(var i=0,l=json.content.length;i<l;i++){
	// 						var inv_name = json.content[i].userName;
	// 						var inv_time = json.content[i].investTime;
	// 						var inv_amout = parseFloat(json.content[i].amount)/10000;
	// 				    	var inv_amouts = '';
	// 				    	if(inv_amout>0&&inv_amout<1){
	// 				    	 	inv_amouts= (inv_amout*10000)+'元';
	// 				    	}else{
	// 				    	  	inv_amouts = inv_amout+'万';
	// 				    	}
	// 					    for(var key in json.content[i]){
	// 					    	  str = '<div class="each_investRecord_infos"><div class="fl iRecord_div iName">'+inv_name+
	// 		    	  					'</div><div class="fl iRecord_div iAmount"><span>'+inv_amouts+'</span></div><div class="fl iRecord_div iTime">'+
	// 		    	  					inv_time+'</div><div class="clear"></div></div>';
	// 					    }
	// 					     $('.inv_record_wrap').append(str);
	//  					}
	// 				}
	// 			});
 //        }
 //    });




	// 还款计划分页js如下：
	var tti = 0;
	$('.project_plan').click(function(){
		if($(this).hasClass('active')){
			$(this).siblings().removeClass('active');
		}else{
			$(this).addClass('active');
			$(this).siblings().removeClass('active');
		}
		$('.indet_plan_infoBox').show();
		$('.indet_project_infosBox').hide();
		$('.indet_investRecord_box').hide();
		$('.question_box_infos').hide();
		$('.indet_projectCourse_box').hide();

		$.ajax({
			type:'post',
			url:getContextPaths()+'/getRepayPlan',
			dataType:'json',
			async: false,//同步
			data:{
				applyId:$('.indetail_name').attr('investid')	
			},
			success:function(json){
				tti = json.totalPage;
				if(json.flag == 0){
					$('.indet_planContBox').html('<div onclick="window.location.href=\'/enterLogin\'" style="cursor:pointer">'+json.msg+'</div>');
					return false;
				}
			
				// 已还金额
		    	var realy_amount = json.totalRepayed;
		    	

	            //待还金额
	            var daihai_amount = json.toatlRepaying;
		    	

	            $('.re_refund').html(formatMoney(realy_amount,2));
	            $('.dai_refund').html(formatMoney(daihai_amount,2));

			
			}
		});


	if(tti==0){
			$('.investPlanPage').hide();
			$('.indet_planContBox').html('没有数据！');
	}else if(tti==1){
			$('.investPlanPage').hide();
			$.ajax({
				type:'post',
				url:getContextPaths()+'/getRepayPlan',
				dataType:'json',
				data:{
					applyId:$('.indetail_name').attr('investid')	
				},
				success:function(json){
					$('.indet_planContBox').html('');
					var str = '';
					// 已还金额
			    	var realy_amount = json.totalRepayed;
			    	

	                //待还金额
	                var daihai_amount = json.toatlRepaying;
			    	
	                $('.re_refund').html(formatMoney(realy_amount,2));
	                $('.dai_refund').html(formatMoney(daihai_amount,2));

					for(var i=0,l=json.content.length;i<l;i++){
						var inv_qishu = json.content[i].repayPeriod;
						// 应还本金
						var invest_amout = formatMoney(json.content[i].repayCapital,2)+'元';

						// 实还本金
						// var invest_shijiamout = (json.content[i].repayDoneCapital == '-')? '-' : formatMoney(json.content[i].repayDoneCapital,2)+'元';
	                    
	                    // 实还利息
	                    // var shiji_rate = (json.content[i].repayDoneInterest == '-')? '-' : json.content[i].repayDoneInterest+'元';
				    	
	                    //状态
	                    var inv_state = (json.content[i].status == 1)? '已兑付' : '兑付中';

	                    
	            
					    for(var key in json.content[i]){
				    	  	str = '<div class="refund_infos"><div class="fl refund_div refund_date_num">第<span>'+inv_qishu+
				    	  		  '</span>期</div><div class="fl refund_div refund_time">'+json.content[i].repayReqTime+
				    	  		  '</div><div class="fl refund_div refund_beijin"><span>'+invest_amout+'</span></div><div class="fl refund_div refund_rate"><span>'+
				    	  		  json.content[i].repayInterest+'</span>元</div><div class="fl refund_div refund_state">'+inv_state+'</div><div class="clear"></div></div>'
					    }
					     $('.indet_planContBox').append(str);
						}
				}
			});
		}else{
			$('.investPlanPage').show();
			$('#plan_page').remove();
			$('.investPlanPage').append('<ul id="plan_page" class="plan_page"></ul>');
			$('#plan_page').twbsPagination({
		        totalPages: tti,
		        visiblePages: 4,
		        first:'',
		        last:'',
		        prev:'<上一页',
		        next:'下一页>',
		        onPageClick: function (event, page) {
		        	$.ajax({
						type:'post',
						url:getContextPaths()+'/getRepayPlan',
						dataType:'json',
						data:{
							applyId:$('.indetail_name').attr('investid'),
							pageNum:page	
						},
						success:function(json){
							$('.indet_planContBox').html('');
							var str = '';
							// 已还金额
					    	var realy_amount = json.totalRepayed;
					    	

			                //待还金额
			                var daihai_amount = json.toatlRepaying;
					    	
			                $('.re_refund').html(formatMoney(realy_amount,2));
			                $('.dai_refund').html(formatMoney(daihai_amount,2));
							for(var i=0,l=json.content.length;i<l;i++){
								var inv_qishu = json.content[i].repayPeriod;
								// 应还本金
								var invest_amout = formatMoney(json.content[i].repayCapital,2)+'元';

								// 实还本金
								// var invest_shijiamout = (json.content[i].repayDoneCapital == '-')? '-' : formatMoney(json.content[i].repayDoneCapital,2)+'元';
	                    
			                    // 实还利息
			                    // var shiji_rate = (json.content[i].repayDoneInterest == '-')? '-' : json.content[i].repayDoneInterest+'元';
			                    
						    	
			                    //状态
			                    var inv_state = (json.content[i].status == 1)? '已兑付' : '兑付中';



							    for(var key in json.content[i]){
						    	  	str = '<div class="refund_infos"><div class="fl refund_div refund_date_num">第<span>'+inv_qishu+
						    	  		  '</span>期</div><div class="fl refund_div refund_time">'+json.content[i].repayReqTime+
						    	  		  '</div><div class="fl refund_div refund_beijin"><span>'+invest_amout+'</span></div><div class="fl refund_div refund_rate"><span>'+
						    	  		  json.content[i].repayInterest+'</span>元</div><div class="fl refund_div refund_state">'+inv_state+'</div><div class="clear"></div></div>'
					    		}
							     $('.indet_planContBox').append(str);
								}
						}
					});
		        }
			});
		}







	});
	// 当页面一加载就去请求还款计划接口一次
	

	// alert(tto);
	
	
	






});

// 封装tab切换函数
function tapFunction(obj,class01,class02,class03,class04,class05){
	$(obj).click(function(obj01,obj02,obj03){
		if($(this).hasClass('active')){
			$(this).siblings().removeClass('active');
		}else{
			$(this).addClass('active');
			$(this).siblings().removeClass('active');
		}
		$(class01).show();
		$(class02).hide();
		$(class03).hide();
		$(class04).hide();
		$(class05).hide();
	});
}
 