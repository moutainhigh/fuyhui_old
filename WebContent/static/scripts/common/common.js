$(function(){
    var urls = window.location.pathname;
    // // 公共头部导航栏tab切换
    if(urls == '/enterInvest'){
        $('.myfinancials').addClass('active');
        $('.site').removeClass('active');
        $(this).siblings().removeClass('active');
    }else if(urls == '/myAccount/enterUserAccount'){
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
    }else if(urls.indexOf('/enterInvestDetail') > -1){
        $('.myfinancials').addClass('active');
        $('.site').removeClass('active');
        $(this).siblings().removeClass('active');
    }else if(urls == '/enterKumquatList'){
        $('.site').removeClass('active');
        $('.mykumquat').addClass('active');
    }else if(urls.indexOf('/enterKumquatDetail') > -1){
        $('.mykumquat').addClass('active');
        $('.site').removeClass('active');
        $(this).siblings().removeClass('active');
    }else if(urls == '/myAccount/enterProduct'){
        $('.site').removeClass('active');
        $('.prozhuizong').addClass('active');
    }else if(urls == '/enterCompanyIntroduction'){
        $('.site').removeClass('active');
        $('.aboutswe').addClass('active');
    }else if(urls == '/enterSecurityPage'){
        $('.site').removeClass('active');
        $('.newGuide').addClass('active');
    }else if(urls == '/enterTeamIntroduction'){
        $('.site').removeClass('active');
        $('.aboutswe').addClass('active');
    }else if(urls == '/enterWebsiteAnnouncement'){
        $('.site').removeClass('active');
        $('.aboutswe').addClass('active');
    }else if(urls.indexOf('/enterWebsiteAnnoundetails') > -1){
        $('.aboutswe').addClass('active');
        $('.site').removeClass('active');
        $(this).siblings().removeClass('active');
    }else if(urls == '/enterMediaCoverage'){
        $('.site').removeClass('active');
        $('.aboutswe').addClass('active');
    }else if(urls.indexOf('/enterMediaCovedetail') > -1){
        $('.aboutswe').addClass('active');
        $('.site').removeClass('active');
        $(this).siblings().removeClass('active');
    }else if(urls == '/enterContactUs'){
        $('.site').removeClass('active');
        $('.aboutswe').addClass('active');
    }else if(urls == '/enterPerformanceReport'){
        $('.site').removeClass('active');
        $('.aboutswe').addClass('active');
    }





    // 账户中心左侧菜单栏tab切换
     if(urls == '/myAccount/enterMycreditor'){
        $('.my_dbborrow').addClass('active');
        $('.money_overview').removeClass('active');
        $(this).siblings('.aMenu_active').removeClass('active');
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
     } else if(urls == '/myAccount/enterBUserAccount'){
        $('.money_overview').addClass('active');
        $(this).siblings('.aMenu_active').removeClass('active');
        $('.myaccounts').addClass('active');
        $('.site').removeClass('active');
     }else if(urls.indexOf('/enterCreditorDetail') > -1){
        $('.my_dbborrow').addClass('active');
        $('.money_overview').removeClass('active');
        $(this).siblings('.aMenu_active').removeClass('active');
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
     }else if(urls == '/myAccount/enterApplyDuring'){
        $('.apply_during').addClass('active');
        $('.money_overview').removeClass('active');
        $(this).siblings('.aMenu_active').removeClass('active');
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
     }else if(urls == '/enterMyborrow'){
        $('.my_borrows').addClass('active');
        $('.money_overview').removeClass('active');
        $(this).siblings('.aMenu_active').removeClass('active');
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
     }else if(urls == '/myAccount/enterBorrowDuring'){
        $('.borrow_during').addClass('active');
        $('.money_overview').removeClass('active');
        $(this).siblings('.aMenu_active').removeClass('active');
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
     }else if(urls == '/myAccount/enterInvitefriend'){
        $('.my_invite').addClass('active');
        $('.money_overview').removeClass('active');
        $(this).siblings('.aMenu_active').removeClass('active');
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
     }else if(urls == '/myAccount/enterCoupons'){
        $('.my_coupons').addClass('active');
        $('.money_overview').removeClass('active');
        $(this).siblings('.aMenu_active').removeClass('active');
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
     }else if(urls == '/myAccount/enterTraderecord'){
        $('.trad_detail').addClass('active');
        $('.money_overview').removeClass('active');
        $(this).siblings('.aMenu_active').removeClass('active');
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
     }else if(urls == '/myAccount/enterSiteinfo'){
        $('.site_inside_info').addClass('active');
        $('.money_overview').removeClass('active');
        $(this).siblings('.aMenu_active').removeClass('active');
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
     }else if(urls == '/myAccount/enterPersonalinfos'){
        $('.my_basic_info').addClass('active');
        $('.money_overview').removeClass('active');
        $(this).siblings('.aMenu_active').removeClass('active');
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
     }else if(urls == '/account/enterRecharge'){
        $('.top_up').addClass('active');
        $('.money_overview').removeClass('active');
        $(this).siblings('.aMenu_active').removeClass('active');
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
     }else if(urls == '/account/enterWithdrawal'){
        $('.withdrawal').addClass('active');
        $('.money_overview').removeClass('active');
        $(this).siblings('.aMenu_active').removeClass('active');
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
     }else if(urls.indexOf('/enterRiskEvaluation') > -1){
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
     }else if(urls == '/myAccount/enterEscrowAccount'){
        $('.site').removeClass('active');
        $('.myaccounts').addClass('active');
     }

});
// 动态获取域名
function getContextPaths(){
//    var pathName = 'https://www.fuyhui.com';
	var pathName = 'http://'+window.location.host;
    return pathName;
}

// 当点击头部的'登录'按钮时触发
function enter_login(){
    $.ajax({
        type:'post',
        url:getContextPaths()+'/enterLogin',
        dataType:'json',
        success:function(json){
        	alert(json.url);
            if(json.flag=='1'){
                window.location.href=json.url;
            }
        }
    });
}


//时间戳转换成正常的yyyy-mm-rr h:m:s格式
function showTime(num){
    var date_now = new Date(num*1000);
    var year = date_now.getFullYear();
    var month = date_now.getMonth()+1;
    var day = date_now.getDate();   //getDate获得日期,getDay()获得星期几,0周末
    var hours = date_now.getHours();
    var minutes = date_now.getMinutes();
    var seconds = date_now.getSeconds();
    month = check(month);
    day = check(day);
    hours = check(hours);
    minutes = check(minutes);
    seconds = check(seconds);
    var result = year + "-" + month + "-" + day + ' ' +hours + ':'+minutes + ':'+seconds;
    return result;
}
// 日期小于10,前面补0填充
function check(t){
    if (t<10) {
        t =  "0"+ t;
    }
    return t;
}

// 四舍五入精度处理问题
function round2(number,fractionDigits){  
    with(Math){  
        return round(number*pow(10,fractionDigits))/pow(10,fractionDigits);  
    }  
} 


// JS格式化数字金额用逗号隔开保留两位小数
function formatMoney(s,n){
    n = n>0 && n<=20 ? n : 2;
    s = parseFloat((s+"").replace(/[^\d\.-]/g,"")).toFixed(n)+"";
    var l = s.split(".")[0].split("").reverse(),
    r = s.split(".")[1];
    t = "";
    for(i = 0;i<l.length;i++){
    t+=l[i]+((i+1)%3==0 && (i+1) != l.length ? "," : "");
    }
    return t.split("").reverse().join("")+"."+r;
}

// 只有一段话的错误提示弹框js
function errorWindow(txt){
    $('body').append('<div id="fuyhui_fade"></div>');
    $('.one_contxt_window').show(800);
    $('.error_txts').html(txt);
    // 当点击'确认'按钮进行关闭操作
    $(".error_btns").click(function(){
        $("#fuyhui_fade").remove();
        $('.one_contxt_window').hide();
    });
}


// 图片+2行内容+1个按钮的弹窗js
function cWindowFunction01(txt1,txt2,btnContent,url){
    $('body').append('<div id="fuyhui_fade"></div>');
    $('.img_window03').show(800);
    $('.wTxt').html(txt1);
    $('.wIncrement').html(txt2);
    $('.only_wBtn').html(btnContent);
    // 当点击'确认'按钮进行关闭操作
    $(".only_wBtn").click(function(){
        $("#fuyhui_fade").remove();
        $('.img_window03').hide();
        window.location.href = getContextPaths()+url;
    });
    //当点击关闭按钮时触发的操作
    $(".r_close").click(function(){
        $("#fuyhui_fade").remove();
        $('.img_window03').hide();
    });
}

// 图片+2行内容+2个按钮的弹窗js
function cWindowFunction02(txt1,btnContent1,btnContent2,url){
    $('body').append('<div id="fuyhui_fade"></div>');
    $('.img_window').show(800);
    $('.wTxt').html(txt1);
    $('.wBtn01').html(btnContent1);
    $('.wBtn02').html(btnContent2);
    // 当点击'确认'按钮进行关闭操作
    $(".wBtn01").click(function(){
        $("#fuyhui_fade").remove();
        $('.img_window').hide();
    });

    $(".wBtn02").click(function(){
        $("#fuyhui_fade").remove();
        $('.img_window').hide();
        window.location.href = getContextPaths()+url;
    });
    //当点击关闭按钮时触发的操作
    $(".r_close").click(function(){
        $("#fuyhui_fade").remove();
        $('.img_window').hide();
    });
}

/**
 * 本地服务器访问文件路径
 */
//var globalUrl = 'http://localhost/fyh';
/**
 * 测试服务器访问文件路径
 */
//var globalUrl = 'http://tresource.fujfu.com';

/**
 * 内测服务器访问文件路径
 */
//var globalUrl = 'http://resource.fujfu.com';

var globalUrl = 'https://fuyhui.com/fyh_sc/';
