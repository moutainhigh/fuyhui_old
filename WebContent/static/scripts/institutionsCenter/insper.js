$(function(){
    insTab('.account_title','.accountInfos','.enterpriseInfos');
    insTab('.enterprise_title','.enterpriseInfos','.accountInfos');
    

    // 修改密码部分
    





















});



// 标题tab切换函数封装
function insTab(obj,class01,class02){
    $(obj).click(function(){
        $(this).addClass('active');
        $(this).siblings().removeClass('active');
        $(class01).show();
        $(class02).hide();
    });
}