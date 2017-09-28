/**
 * Created by weiyj on 2016/12/16.
 */
$(document).ready(function() {
    //左边菜单链接锚点跳转
    $(document).ready(function() {
        $(".hli-1").click(function() {
            $(this).css("border-left","2px solid #00BBFF");
            $(".hli-1 > a").addClass("active-a");
            $(this).siblings("li").children("a").removeClass("active-a");
            $(this).siblings("li").css("border-left","0");
            document.getElementById("recharge-con").scrollIntoView();
        });
        $(".hli-2").click(function() {
            $(this).css("border-left","2px solid #00BBFF");
            $(".hli-2 > a").addClass("active-a");
            $(this).siblings("li").children("a").removeClass("active-a");
            $(this).siblings("li").css("border-left","0");
            document.getElementById("Withdrawals-con").scrollIntoView();
        });
        $(".hli-3").click(function() {
            $(this).css("border-left","2px solid #00BBFF");
            $(".hli-3 > a").addClass("active-a");
            $(this).siblings("li").children("a").removeClass("active-a");
            $(this).siblings("li").css("border-left","0");
            document.getElementById("bid").scrollIntoView();
        });
        $(".hli-4").click(function() {
            $(this).css("border-left","2px solid #00BBFF");
            $(".hli-4 > a").addClass("active-a");
            $(this).siblings("li").children("a").removeClass("active-a");
            $(this).siblings("li").css("border-left","0");
            document.getElementById("risk_textBox").scrollIntoView();
        });

        $(".hli-6").click(function() {
            $(this).css("border-left","2px solid #00BBFF");
            $(".hli-6 > a").addClass("active-a");
            $(this).siblings("li").children("a").removeClass("active-a");
            $(this).siblings("li").css("border-left","0");
            document.getElementById("account-con").scrollIntoView();
        });
        $(".hli-5").click(function() {
            $(this).css("border-left","2px solid #00BBFF");
            $(".hli-5 > a").addClass("active-a");
            $(this).siblings("li").children("a").removeClass("active-a");
            $(this).siblings("li").css("border-left","0");
            document.getElementById("register-con").scrollIntoView();
        });
    });









});



