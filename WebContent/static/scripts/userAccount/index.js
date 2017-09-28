
$(function(){
	// 头像上传js调用
	// new uploadPreview({ UpBtn: "up_img", DivShow: "imgdiv", ImgShow: "imgShow" });


    var hosts = getContextPaths()+'/invest/enterInvestDetail?id=';

    // 推荐项目接口start
    $.ajax({
        type:'post',
        url:getContextPaths()+'/user/getApplyLoanList',
        dataType:'json',
        data:{
            pageSize:3
        },
        success:function(json){
            var str = '';
            var ii = 0;
            for(var i=0,l=json.content.length;i<l;i++){
                //图片地址
                ii++;
                
                // var urls = getContextPaths() +'/fyh/productPic/'+json.content[i].url;
                var status = json.content[i].status;
                var isloans = json.content[i].isLoans;
                //筹款金额
                var moneys =(parseFloat(json.content[i].amount)/10000+'').substring(0,(parseFloat(json.content[i].amount)/10000+'').indexOf('.')+3); 
                for(var key in json.content[i]){
                    str = '<li class=iProject_item0'+ii+' onclick="window.location.href=\''+hosts+json.content[i].id+'\'"><div class="iProject_title">'+
                          json.content[i].name+'</div><div class="iPro_tList"><div class="fl tList_box01"><p>'+json.content[i].apr+
                          '%</p><div class="com_invite_pro">预期年化收益</div></div><div class="fl tList_box02"><p>'+moneys+
                          '<span>万</span></p><div class="com_invite_pro">产品规模</div></div><div class="fl tList_box03"><p>'+
                          json.content[i].period+'<span>天</span></p><div class="com_invite_pro">预期产品期限</div></div><div class="clear"></div></div><div class="iPro_btn lijiIpro" sat=\''+status+'\' isl=\''+isloans+'\'>认购中</div></li>';
                        
                }
                $('.acc_iProject_list').append(str);
            }
            investBtnFunction();
        }
    });



    // 资产总额金额格式化
    $('.tAccounts').html(formatMoney($('.tAccounts').text(),2));
    // 可用余额金额格式化
    $('.acc_remainMoney').html(formatMoney($('.acc_remainMoney').text(),2));
    //冻结金额格式化
    $('.acc_freezeMoney').html(formatMoney($('.acc_freezeMoney').text(),2));
    // 待收金额格式化
    $('.acc_collecteMoney').html(formatMoney($('.acc_collecteMoney').text(),2));
    // 累计收益格式化
    $('.acc_stillMoney').html(formatMoney($('.acc_stillMoney').text(),2));














	
});





// 账户中心-资产总览头像上传js封装
var uploadPreview = function(setting) {
    /*
    *work:this(当前对象)
    */
    var _self = this;
    /*
    *work:判断为null或者空值
    */
    _self.IsNull = function(value) {
        if (typeof (value) == "function") { return false; }
        if (value == undefined || value == null || value == "" || value.length == 0) {
            return true;
        }
        return false;
    }
    /*
    *work:默认配置
    */
    _self.DefautlSetting = {
        UpBtn: "",
        DivShow: "",
        ImgShow: "",
        Width: 72,
        Height: 72,
        ImgType: ["gif", "jpeg", "jpg", "bmp", "png"],
        ErrMsg: "选择文件错误,图片类型必须是(gif,jpeg,jpg,bmp,png)中的一种",
        callback: function() { }
    };
    /*
    *work:读取配置
    */
    _self.Setting = {
        UpBtn: _self.IsNull(setting.UpBtn) ? _self.DefautlSetting.UpBtn : setting.UpBtn,
        DivShow: _self.IsNull(setting.DivShow) ? _self.DefautlSetting.DivShow : setting.DivShow,
        ImgShow: _self.IsNull(setting.ImgShow) ? _self.DefautlSetting.ImgShow : setting.ImgShow,
        Width: _self.IsNull(setting.Width) ? _self.DefautlSetting.Width : setting.Width,
        Height: _self.IsNull(setting.Height) ? _self.DefautlSetting.Height : setting.Height,
        ImgType: _self.IsNull(setting.ImgType) ? _self.DefautlSetting.ImgType : setting.ImgType,
        ErrMsg: _self.IsNull(setting.ErrMsg) ? _self.DefautlSetting.ErrMsg : setting.ErrMsg,
        callback: _self.IsNull(setting.callback) ? _self.DefautlSetting.callback : setting.callback
    };
    /*
    *work:获取文本控件URL
    */
    _self.getObjectURL = function(file) {
        var url = null;
        if (window.createObjectURL != undefined) {
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) {
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) {
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }
    /*
    *work:绑定事件
    */
    _self.Bind = function() {
        document.getElementById(_self.Setting.UpBtn).onchange = function() {
            if (this.value) {
                if (!RegExp("\.(" + _self.Setting.ImgType.join("|") + ")$", "i").test(this.value.toLowerCase())) {
                    alert(_self.Setting.ErrMsg);
                    this.value = "";
                    return false;
                }
                if (navigator.userAgent.indexOf("MSIE") > -1) {
                    try {
                        document.getElementById(_self.Setting.ImgShow).src = _self.getObjectURL(this.files[0]);
                    } catch (e) {
                        var div = document.getElementById(_self.Setting.DivShow);
                        this.select();
                        top.parent.document.body.focus();
                        var src = document.selection.createRange().text;
                        document.selection.empty();
                        document.getElementById(_self.Setting.ImgShow).style.display = "none";
                        div.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                        div.style.width = _self.Setting.Width + "px";
                        div.style.height = _self.Setting.Height + "px";
                        div.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src;
                    }
                } else {
                    document.getElementById(_self.Setting.ImgShow).src = _self.getObjectURL(this.files[0]);
                }
                _self.Setting.callback();
            }
        }
    }
    /*
    *work:执行绑定事件
    */
    _self.Bind();
}






// 立即投资按钮状态js
function investBtnFunction(){
    $('.iPro_btn').each(function(){
        var _this = $(this);
        var status =parseInt(_this.attr('sat')); 
        var isLoans = parseInt(_this.attr('isl'));
        if(status==7){
            _this.addClass('lijiIpro').removeClass('hasend_btn').removeClass('receivable_btn').removeClass('yuren_btn');
        }else if(status==8 && isLoans==0){
            _this.addClass('hasend_btn').removeClass('lijiIpro').removeClass('receivable_btn').removeClass('yuren_btn').html('已售罄');
        }else if(status==9 || (status==8&&(isLoans!=0))){
            _this.addClass('receivable_btn').removeClass('lijiIpro').removeClass('yuren_btn').removeClass('hasend_btn').html('回款中');
        }else if(status==10){
            _this.addClass('hasend_btn').removeClass('lijiIpro').removeClass('yuren_btn').removeClass('receivable_btn').html('已结束');
        }else if(status==2){
            _this.addClass('yuren_btn').removeClass('lijiIpro').removeClass('hasend_btn').removeClass('receivable_btn').html('预热中');
        }   
     });
    
}