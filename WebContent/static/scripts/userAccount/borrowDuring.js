$(function(){
	// 借款中心-申请中分页js
	$('#bDuring').twbsPagination({
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












// input输入框中placeholder兼容ie的js代码如下：
var JPlaceHolder = {
    //检测
    _check : function(){
        return 'placeholder' in document.createElement('input');
    },
    //初始化
    init : function(){
        if(!this._check()){
            this.fix();
        }
    },
    //修复
    fix : function(){
        jQuery(':input[placeholder]').each(function(index, element) {
            var self = $(this), txt = self.attr('placeholder');
            self.wrap($('<div></div>').css({position:'relative', zoom:'1', border:'none', background:'none', padding:'none', margin:'none'}));
            var pos = self.position(), h = self.outerHeight(true), paddingleft = self.css('padding-left');
            var holder = $('<span></span>').text(txt).css({position:'absolute', left:pos.left, top:15, height:h, lienHeight:h, paddingLeft:paddingleft, color:'#aaa'}).css('top','10px \0').appendTo(self.parent());
            self.focusin(function(e) {
                holder.hide();
            }).focusout(function(e) {
                if(!self.val()){
                    holder.show();
                }
            });
            holder.click(function(e) {
                holder.hide();
                self.focus();
            });
        });
    }
};
//执行
jQuery(function(){
    JPlaceHolder.init();    
});