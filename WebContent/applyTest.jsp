<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js"></script>
<script type="text/javascript">
function add(){
	var data = { 
			userId:'23450',
			operation:'add'
	}
	
	$.ajax( {
	    url : 'app/fkd/apply/add',
	    type : "POST", 
	    data:data,
	    dataType:"json",
	    //contentType:'application/json;charset=UTF-8',
	    success : function(data) {
	    	console.log(data);   
	    },
			error:function(e){
	    	alert("err");   
	    }   
	});
}
function add1(){
	var data = { 
			step:'1',
			operation:'update',
			id:'8',
			userId:'23450',  
			aMarried:'1',  
			aDegree:'本科',
			aAddress1:'广东省深圳市龙华新区',
			aAddress2:'富士康南二门',
			aAddresscode:'123456'
	}
	
	$.ajax( {
	    url : 'app/fkd/apply/add',
	    type : "POST", 
	    data:data,
	    dataType:"json",
	    //contentType:'application/json;charset=UTF-8',
	    success : function(data) {
	    	console.log(data);   
	    },
			error:function(e){
	    	alert("err");   
	    }   
	});
}
function add2(){
	var data = { 
			step:'2',
			operation:'update',
			id:'6',
			userId:'23450',  
			bCompany:'xx技术公司',  
			bIndustry:'农业',
			bIndustrycode:'0102',
			bTelephone:'1234567890',
			bCompanyaddress1:'广东省深圳市南山区',
			bCompanyaddress2:'科技园',
			bDepartment:'技术部',
			bDepartmentcode:'0001',
			bPosition:'开发工程师',
			bPositioncode:'0002',
			bEntrydate:'1470192345'
	}
	
	$.ajax( {
	    url : 'app/fkd/apply/add',
	    type : "POST", 
	    data:data,
	    dataType:"json",
	    //contentType:'application/json;charset=UTF-8',
	    success : function(data) {
	    	console.log(data);   
	    },
			error:function(e){
	    	alert("err");   
	    }   
	});
}
function add3(){
	var data = { 
			step:'5',
			operation:'upload',
			userId:'100023'
	}
	
	$.ajax( {
	    url : 'app/fkd/apply/add',
	    type : "POST", 
	    data:data,
	    dataType:"json",
	    //contentType:'application/json;charset=UTF-8',
	    success : function(data) {
	    	console.log(data);   
	    },
			error:function(e){
	    	alert("err");   
	    }   
	});
}
</script>
</head>
<body>
	<button onclick="add()">申请</button>
	<button onclick="add1()">下一步1</button>
	<button onclick="add2()">下一步2</button>
	<button onclick="add3()">下一步文件3</button>
	<button onclick="add4()">下一步4</button>
	<button onclick="add5()">下一步5</button>
</body>
</html>