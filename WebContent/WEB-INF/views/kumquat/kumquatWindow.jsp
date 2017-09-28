<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/datetag.tld" prefix="date"%>
<!DOCTYPE html>
<html lang="en">
<head lang="zh-cn">
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>认购确认-金桔系列详情-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/webox.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/jquery-webox.js'></script>

  

	
	<style type="text/css">
		.webContent
		{
			font-size: 14px;
			color: #474e5d;
		}
		.web_group_content
		{
			margin-top: 20px;
		}
		.com_wlwidth
		{
			width: 132px;
			margin-right: 90px;
			text-align: right;
		}
		.row_read 
		{
			margin: 20px 0 0 120px;
		}
		.web_btn_group
		{
			margin-top: 10px;
			font-size: 14px;
		}
		.btns
		{
			width: 140px;
			height: 40px;
			line-height: 40px;
			text-align: center;
			cursor: pointer;
			border-radius: 6px;
			-webkit-border-radius:6px;
			-moz-border-radius: 6px;
		}
		.web_cancle_btn
		{
			height: 38px;
		    width: 138px;
		    border: 1px solid #0bf;
		    color: #0bf;
		    margin-left: 136px;
		    margin-right: 90px;
		}
		.web_confirm_ivtbtn
		{
			background: #0bf;
			color: #fff;
		}
		.web_error
		{
			height: 22px;
			line-height: 22px;
			color: #ff5600;
			margin-left: 144px;
		}
		#invest_fade
		{
			width: 100%;
			height: 1000px;
			position: fixed;
			top: 0;
			left: 0;
			background: #000;
			opacity: .25;
			filter:alpha(opacity=25);
			z-index: 5000;
		}
	</style>
</head>
<body>
	<div class="webContent">
		<div class="web_group_content" style="margin-top:30px;">
			<div class="fl com_wlwidth">产品名称：</div>
			<div class="fl web_projectName"></div>
			<div class="clear"></div>
		</div>

		<div class="web_group_content">
			<div class="fl com_wlwidth">预期产品期限：</div>
			<div class="fl web_invest_limit"></div>
			<div class="clear"></div>
		</div>

		<div class="web_group_content">
			<div class="fl com_wlwidth">预期年化收益：</div>
			<div class="fl web_rate"></div>
			<div class="clear"></div>
		</div>

		<div class="web_group_content">
			<div class="fl com_wlwidth">认购金额：</div>
			<div class="fl web_ivtMoney"></div>
			<div class="clear"></div>
		</div>

		<div class="web_group_content">
			<div class="fl com_wlwidth">预期收益金额：</div>
			<div class="fl web_shouyi"></div>
			<div class="clear"></div>
		</div>

		<div class="web_group_content">
		<input name="redid" class="redid" value="" type="hidden">
			<div class="fl com_wlwidth">优惠券：</div>
			<div class="fl web_selectBox" style="margin-left:-3px;">
				<!-- <input checked="checked" name="packages" id="packages" value="1" type="checkbox"> 
				<select id="web_selt">
					<option value="98">98元&nbsp;&nbsp;2017-03-30</option>
					<option value="58">58元&nbsp;&nbsp;2017-03-30</option>
					<option value="18">18元&nbsp;&nbsp;2017-03-30</option>
				</select> -->
			</div>
			<div class="clear"></div>
		</div>

		<div class="web_group_content">
			<div class="fl com_wlwidth">实际应付金额：</div>
			<div class="fl"><span class='web_payMoney'></span><span>元</span></div>
			<div class="clear"></div>
		</div>

		<div class="row_read success">
            <input name="Ifagreement" id="Ifagreement" value="1" type="checkbox">            
            <label for="Ifagreement">
            	<span class="hasRead">我已同意并阅读</span>
                <a href="javascript:void(0);" class="investagreement" style="color:#0bf;margin-left:0;">《产品合同》</a>
            </label>     
        </div>
		
		<div class="web_error"></div>
		<div class="web_btn_group">
			<div class="fl btns web_cancle_btn">取消</div>
			<div class="fl btns web_confirm_ivtbtn">确认认购</div>
			<div class="clear"></div>
		</div>


	</div>


	




</body>
</html>


<script type="text/javascript">
	$(function(){
		//判断产品合同是否存在接口 
	    $('.investagreement').click(function(){
	        var contractHref = $('.real_ind_btn', parent.document).attr('conhref02');//带过来的合同url
	        console.log(contractHref);
	        $.ajax({
	            type:'post',
	            url:getContextPaths()+'/user/checkContactPdf',
	            dataType:'json',
	            data:{
	                contactFile:contractHref
	            },
	            success:function(json){
	                if(json.flag == 1){
	                	var urls = globalUrl + contractHref; 
		                window.parent.parent.location.href= urls;

	                }else{
	                    $('.web_error').html('合同不存在');
	                    setTimeout(function(){
	                        $('.web_error').html('');
	                    },1500);

	                }
	            }
	        });
	    });
		
		
	    



    	// 获取带过来的标id
	    var mark_id='';
	    if(window.location.search.indexOf("?")!= -1){
	        mark_id = window.location.search.substring((window.location.search.indexOf("=")+1),window.location.search.indexOf("&"));
	    }
	    // 获取带过来的用户投资金额
	    var web_ivstMoey ='';
	    if(window.location.search.indexOf("&")!= -1){
	        web_ivstMoey = window.location.search.substring((window.location.search.indexOf("&")+1));
	    }

	    // 投资金额显示
	    $('.web_ivtMoney').html(formatMoney(web_ivstMoey,2)+'元');


	    // 请求项目名称、预计投资期限、预计年化收益、预期收益金额接口
	    $.ajax({
            type:'get',
            url:getContextPaths()+'/calulateIntrest',
            dataType:'json',
            data:{
                id:mark_id,//标id
                InvestMoney:web_ivstMoey//用户投资金额
            },
            success:function(json){
                if(json.flag==1){
                	$('.web_projectName').html(json.content.loanName);
                	$('.web_invest_limit').html(json.content.term+'天');
                	$('.web_rate').html(json.content.rate+'%');
                	$('.web_shouyi').html(json.content.totalIntrest+'元');
                }
            }
	     });

	    // 优惠券接口
	    var redidFlag = '';// 红包id标识
	    var redPacks = '';//被选中的红包金额
	    $.ajax({
            type:'post',
            url:getContextPaths()+'/availRedAward',
            dataType:'json',
            data:{
                tranAmount:web_ivstMoey//用户投资金额
            },
            success:function(json){
                if(json.flag==1){
                	$('.web_selectBox').html('');
     				$('.web_selectBox').append('<input checked="checked" name="packages" id="packages" value="1" type="checkbox">');
     				$('.web_selectBox').append('<select id="web_selt"></select>');
     				$('#web_selt').html('');
	                var str = '';
	                for(var i=0,l=json.content.length;i<l;i++){
	                    // 到期时间
	                    var dueToTime = showTime(json.content[i].term).substring(0,10);
	                    // 红包金额
	                    var redPacket = json.content[i].initAmount;
	                    for(var key in json.content[i]){
	                        str = '<option value='+redPacket+' redid='+json.content[i].id+'>'+redPacket+'元&nbsp;&nbsp;'+dueToTime+'</option>';      
	                    }
	                    $('#web_selt').append(str);
	                    
	                }
	                selectPacket();//一开始默认就要调用一下
	                $('#packages').click(function(){//当点击选择框时又要调用一下
	                	if($(this).is(':checked')){
			                selectPacket();
						}else{
							$("#web_selt").change(function(){
								 selectedVla = $(this).find('option:selected').val();
								 //应付金额显示
								 $('.web_payMoney').html(web_ivstMoey);
								 redidFlag = '';
								 redPacks = '';
							});
							//应付金额显示
							$('.web_payMoney').html(web_ivstMoey);
							redidFlag = '';
							redPacks = '';
						}
	                });

                }
                if(json.size==0){
                	$('.web_selectBox').html(0+'元');
                	//当用户不存在红包时
	    			$('.web_payMoney').html(web_ivstMoey);
                }
            }
	     });


		// 判断用户是否有勾选红包
		function selectPacket(){
			if($('#packages').is(':checked')){
				var selectedVla = $("#web_selt option:selected").val();
	            redidFlag = $("#web_selt option:selected").attr('redid');
	            redPacks = $("#web_selt option:selected").val();
				$("#web_selt").change(function(){
					 selectedVla = $(this).find('option:selected').val();
					 //应付金额显示
					 $('.web_payMoney').html(web_ivstMoey-selectedVla);
					 redidFlag = $("#web_selt option:selected").attr('redid');
					 redPacks = $("#web_selt option:selected").val();
				});
				//应付金额显示
				$('.web_payMoney').html(web_ivstMoey-selectedVla);
			}else{
				$("#web_selt").change(function(){
					 selectedVla = $(this).find('option:selected').val();
					 //应付金额显示
					 $('.web_payMoney').html(web_ivstMoey);
					 redidFlag = '';
					 redPacks = '';
				});
				//应付金额显示
				$('.web_payMoney').html(web_ivstMoey);
				redidFlag = '';
				redPacks = '';
			}
		}
		
		
		
	
		

	    // 当点击取消按钮时触发
	    $('.web_cancle_btn').click(function(){
	        returnInvestDetail();
	    });

	    // 点击确认投资按钮时触发redPacks   redidFlag
	    var flag01 = true;
	    $('.web_confirm_ivtbtn').click(function(){
    	 	if($('#Ifagreement').is(':checked')){
				if(flag01){
		    		$.ajax({
						type:'post',
						url:getContextPaths()+'/invest',
						dataType:'json',
						data:{
							id:mark_id,
							investMoney:web_ivstMoey,
							rewardId:redidFlag,//红包id
							rewardMoney:redPacks//红包金额
						},
						beforeSend:function(){
		                	flag01=false;
		            	},
						success:function(json){
							if(json.flag == 1){
								$('#webox_fade', parent.document).remove();
    							$('.webox', parent.document).hide(); 
    							cWindowFunction01(json.msg,'返回产品详情','去账户中心','/myAccount/enterBUserAccount');
								flag01=true;
							}else if(json.flag == 2){
								top.window.location.href= '/enterLogin';
							}else{
								$('#webox_fade', parent.document).remove();
    							$('.webox', parent.document).hide(); 
    							cWindowFunction02(json.msg,'返回产品详情','去账户中心','/myAccount/enterBUserAccount');
								flag01=false;
							}
							
						},
						error:function(){
							flag01=true;
						}
					});	
				}
    
		    }else{
				$('.web_error').html('请勾选产品合同协议');
				setTimeout(function(){
					$('.web_error').html('');
				},1500);
				return false;
			}

 
	        
	    });




	});










// 投资成功js弹窗
function cWindowFunction01(txt1,btnContent1,btnContent2,url){
    $('body',parent.document).append('<div id="fuyhui_fade"></div>');
    $('.img_window',parent.document).css('display','block');
    $('.wTxt',parent.document).html(txt1);
    $('.wBtn01',parent.document).html(btnContent1);
    $('.wBtn02',parent.document).html(btnContent2);
    // 当点击'确认'按钮进行关闭操作
    $(".wBtn01",parent.document).click(function(){
        $("#fuyhui_fade",parent.document).remove();
        $('.img_window',parent.document).hide();
        parent.location.reload(true);
    });

    $(".wBtn02",parent.document).click(function(){
        $("#fuyhui_fade",parent.document).remove();
        $('.img_window',parent.document).hide();
        parent.location.href = getContextPaths()+url;
    });
    //当点击关闭按钮时触发的操作
    $(".r_close",parent.document).click(function(){
        $("#fuyhui_fade",parent.document).remove();
        $('.img_window',parent.document).hide();
        parent.location.reload(true);
    });
}



// 投资失败js弹窗
function cWindowFunction02(txt1,btnContent1,btnContent2,url){
    $('body',parent.document).append('<div id="fuyhui_fade"></div>');
    $('.img_window02',window.parent.document).css('display','block');
    $('.wTxt',parent.document).html(txt1);
    $('.wBtn01',parent.document).html(btnContent1);
    $('.wBtn02',parent.document).html(btnContent2);
    // 当点击'确认'按钮进行关闭操作
    $(".wBtn01",parent.document).click(function(){
        $("#fuyhui_fade",parent.document).remove();
        $('.img_window02',parent.document).hide();
        parent.location.reload(true);
    });

    $(".wBtn02",parent.document).click(function(){
        $("#fuyhui_fade",parent.document).remove();
        $('.img_window02',parent.document).hide();
        parent.window.location.href = getContextPaths()+url;
    });
    //当点击关闭按钮时触发的操作
    $(".r_close",parent.document).click(function(){
        $("#fuyhui_fade",parent.document).remove();
        $('.img_window02',parent.document).hide();
        parent.location.reload(true);
    });
}



//返回项目页面js函数
function returnInvestDetail(){
    $('#avail_money', parent.document).val('').focus();
    $('#webox_fade', parent.document).remove();
    $('.webox', parent.document).remove();      
}



</script>











