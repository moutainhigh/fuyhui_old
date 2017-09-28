<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/datetag.tld" prefix="date"%>
<!DOCTYPE html>
<html lang="en">
<head lang="zh-cn">
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>安全信息——个人基本信息提示页面</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/jquery.inputbox.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/securityinfos.css">
    <style>
    	
    	#pfade
    	{
    		    width: 100%;
			    height: 1000px;
			    position: fixed;
			    top: 0;
			    left: 0;
			    background: #000;
			    opacity: .5;
			    filter: alpha(opacity=50);
			    z-index: 11;
    	}
    
    
    
    </style>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/jquery.inputbox.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/jquery.ganged.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/provinces.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/personalbasicinfos.js'></script>
	<script type="text/javascript" src='../../static/scripts/user/md5.js'></script>
</head>
<body>
	
	
	<!-- 手机号弹窗Start -->
	<div class="com_window iphones_window" style="display:block;">
		<div class="com_wTitle" style="margin-bottom:36px;">
			<p class="fl com_window_title">修改手机号</p>
			<p class="fr com_window_close head_wClose"></p>
			<div class="clear"></div>
		</div>
		<!-- 完成start -->
		<div class="site03Box">
			<div class="siteImg site03_bg"></div>
			<p class="siteInfos">
				恭喜您成功绑定了新的手机号码！
			</p>
		
			<div class="com_wBtn completes_btns">完成</div>
		</div>

	</div>

	
	
</body>
</html>
<script type="text/javascript">
	$(function(){
		$('body').append("<div id='pfade'></div>");
		$('.head_wClose,.completes_btns').click(function(){
			$("#pfade").remove();
			$('.iphones_window').hide(800);
			window.location.href = getContextPaths()+'/myAccount/enterPersonalinfos';
		});
	});
</script>



