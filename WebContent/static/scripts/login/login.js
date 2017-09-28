var jsondata;
function login(){
    var username = $("#username").val();
    var password = $("#password").val();
    var code=$("#uIphone_code").val();
    $.ajax({
    	type: 'POST',
        url : "login",
        data : {
            username : username,
            password : password,
            code:code
        },
        success : function(jsondata){
            if(jsondata != undefined || jsondata != null){
//            	console.log(jsondata);
                if(jsondata.url == null){
                    $(".login-err span").text(jsondata.msg);
                }else {
//                	console.log(jsondata.url);
                    window.location.href = jsondata.url;
                }
            }
        }
    });
}
$(document).ready(function(){
    var $img = $(".check-img img");
    $("#login-state-label").click(function(e){
        var $state = $("#remember-login-state");
        $state.trigger("click");
        if($state.is(":checked")) {
            $img.attr("src", "../images/login/checkboxes1.png");
        }else {
            $img.attr("src", "../images/login/checkboxes0.png");
        }
    });
    $("#username").focus(function(){
        $("#clear-username").css("visibility","visible");
    }).blur(function(){
        $("#clear-username").css("visibility","hidden");
    });

    $("#clear-username").click(function(){
        $("#username").val("");
    });

    $("#submit_btn").click(function(){
        login();
    });

    $("body").keydown(function(e){
        if(e.keyCode == 13){
            $("#submit_btn").trigger("click");
        }
    });
});