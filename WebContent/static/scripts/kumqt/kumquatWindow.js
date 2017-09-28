$(function(){
    // 外嵌调用投资确认页面
    $(this).on('click','.iDe_btns',function(e){
        if(e && e.preventDefault)//阻止默认行为
        {
            e.preventDefault();
        } 
        else//ie阻止默认行为
        {
            window.event.returnValue=false;
        }
        var url = $(this).attr("href");
        var h = $(this).attr("hight");
        var w = $(this).attr("width");
        var tle = $(this).attr("title");
        $('body').prepend('<div id="webox_fade"></div>');
        // console.log(url);
        $.webox({
            height:h,
            width:w,
            bgvisibel:true,
            title:tle,
            iframe:url
        });
        
    });

    




            



});




