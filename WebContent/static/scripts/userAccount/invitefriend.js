$(function(){
    // 我的奖励-邀请好友页面'推荐总览和好友详情'按钮切换js
    $('.recommend_overview').click(function(){
        $('.friend_detail').removeClass('active');
        $(this).addClass('active');
        $('.recommend_body').show();
        $('.friends_body').hide();
    });

    $('.friend_detail').click(function(){
        $('.recommend_overview').removeClass('active');
        $(this).addClass('active');
        $('.friends_body').show();
        $('.recommend_body').hide();
    });


    //“推荐方式”的请求接口
    $.ajax({
        type:'post',
        url:getContextPaths()+'/user/getRecommenFriendsShow',
        dataType:'json',
        data:{

        },
        success:function(json){
            if(json.flag=='1'){
                var CopyUrl=json.loginUrl+'?rcode='+json.mobil;
                $("#copyURL").val(CopyUrl);
                $(".yes_reward").html('¥ '+json.aWardYesterday);//昨日发放奖励（元）
                $(".addUp_reward").html('¥ '+json.aWardSum);//累计奖励（元）
                $("#recon_code_bg").val(json.mobil);//推荐码
                // 复制推荐码
                $(".rec_copyCode_btn").click(function(){
                    errorWindow('推荐码已复制到剪贴板！');
                    $("#recon_code_bg").css("background","#FFFFFF");
                })//放URL的链接背景设置白色
                // 复制链接
                $(".rec_copyUrl_btn").click(function(){
                    errorWindow('链接已复制到剪贴板！');
                    $("#copyURL").css("background","#FFFFFF");
                })//放URL的链接背景设置白色
            }else{

            }
        }
    });




    //“好有详情”分页js如下：
    $('.friend_detail').click(function(){
        var ttf = 0;
        $.ajax({
            type:'post',
            url:getContextPaths()+'/user/getRecommenFriendsListByUserid',
            dataType:'json',
            async: false,
            data:{
                pageSize:6
            },
            success:function(json){
                if(json.flag == 1) {
                    ttf = json.totalPage;
                }
            }
        });

        if(ttf==0){
            $('.invitefriend').hide();
            $('.friends_tab_content').html('没有数据！');
        }else if(ttf==1){
            $('.invitefriend').hide();
            $.ajax({
                type:'post',
                url:getContextPaths()+'/user/getRecommenFriendsListByUserid',
                dataType:'json',
                data:{
                    pageSize:6
                },
                success:function(json){
                    $('.friends_tab_content').html('');
                    var str = '';

                    for(var i=0,l=json.content.length;i<l;i++){

                        for(var key in json.content[i]){
                            var investState = (json.content[i].investAmount > 0) ? '已认购' : '未认购';//投资情况
                            var fPhone = json.content[i].userName;//用户名
                            //var fPhoneSub = fPhone.replace(/^(\d{3})\d{5}(\d+)/,"$1*****$2");//用户名的中间部分隐藏

                            //var fName=(json.content[i].realName == null) ? "" : json.content[i].realName;//真实姓名

                            var fName = json.content[i].realName;
                            //if(fName== null){
                            //    fNameSub= "";
                            //}else{
                            //    fName= json.content[i].realName;
                            //    var fNameSub= fName.replace(/([\u4e00-\u9fa5])/, '*');//真实姓名的姓氏隐藏
                            //}

                            //if(fName){
                            //    var fNameSub= fName.replace(/([\u4e00-\u9fa5])/, '*');//真实姓名的姓氏隐藏
                            //}

                            str = '<div class="earch_friend_infos"><p class="friend_iphone">'+fPhone+'</p>'+
                                '<p class="real_name_regist">'+fName+'</p><p class="friend_invest_situation">'+investState+'</p>'+
                                '<p class="friend_register_time">'+json.content[i].investAmount+'</p><p class="friend_invest_money">'+json.content[i].investTimeStr+'</p>'+
                                '<p class="friend_invest_money">'+json.content[i].registTimeStr+'</p><p class="friend_invest_money">'+json.content[i].rewardTermStr+'</p>'+
                                '<p class="friend_invest_money">'+json.content[i].rewardAmount+'</p><div class="clear"></div></div>'
                        }
                        $('.friends_tab_content').append(str);
                    }
                }
            });
        }else{
            $('.invitefriend').show();
            $('#invite_friend').remove();
            $('.invitefriend').append('<ul id="invite_friend" class="invite_friend"></ul>');
            $('#invite_friend').twbsPagination({
                totalPages: ttf,
                visiblePages: 4,
                first:'',
                last:'',
                prev:'<上一页',
                next:'下一页>',
                onPageClick: function (event, page) {
                    $.ajax({
                        type:'post',
                        url:getContextPaths()+'/user/getRecommenFriendsListByUserid',
                        dataType:'json',
                        data:{
                            pageNum:page,
                            pageSize:6,
                        },
                        success:function(json){
                            $('.friends_tab_content').html('');
                            var str = '';
                            for(var i=0,l=json.content.length;i<l;i++){

                                for(var key in json.content[i]){
                                    var investState = (json.content[i].investAmount > 0) ? '已认购' : '未认购';//投资情况
                                    var fPhone = json.content[i].userName;//用户名
                                    //var fPhoneSub = fPhone.replace(/^(\d{3})\d{5}(\d+)/,"$1*****$2");//用户名的中间部分隐藏

                                    var fName=json.content[i].realName;//真实姓名
                                    //if(fName == null){
                                    //    var fNameSub='';
                                    //}else{
                                    //    var fNameSub= fName.replace(/([\u4e00-\u9fa5])/, '*');//真实姓名的姓氏隐藏
                                    //}

                                    str = '<div class="earch_friend_infos"><p class="friend_iphone">'+fPhone+'</p>'+
                                        '<p class="real_name_regist">'+fName+'</p><p class="friend_invest_situation">'+investState+'</p>'+
                                        '<p class="friend_register_time">'+json.content[i].investAmount+'</p><p class="friend_invest_money">'+json.content[i].investTimeStr+'</p>'+
                                        '<p class="friend_invest_money">'+json.content[i].registTimeStr+'</p><p class="friend_invest_money">'+json.content[i].rewardTermStr+'</p>'+
                                        '<p class="friend_invest_money">'+json.content[i].rewardAmount+'</p><div class="clear"></div></div>'
                                }
                                $('.friends_tab_content').append(str);
                            }
                        }
                    });
                }
            });
        }
    });











	// 借款-我的借款分页js
	$('#invite_friend').twbsPagination({
        totalPages: 1,
        visiblePages: 4,
        first:'',
        last:'',
        prev:'<上一页',
        next:'下一页>',
        onPageClick: function (event, page) {
            // $('#page-content').text('Page ' + page);
            
        }
    });



});