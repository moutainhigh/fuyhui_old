$(function(){
	// 借款-我的借款分页js
	$('#myborrow').twbsPagination({
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