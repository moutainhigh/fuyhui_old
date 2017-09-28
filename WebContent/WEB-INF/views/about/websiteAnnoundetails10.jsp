<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head lang="zh-cn">
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>网站公告-关于我们-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
    <!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/about/aboutUs.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/product/projecttrack.js'></script>
    <style>
        /*邀请奖励表格*/
        .invite_role_h1{
            font-size: 16px;
            margin-bottom: 10px;
            color: #2a2a2a !important;
        }
        .invite_table
        {
            margin:0 auto;
            width: 350px;
            font-size: 16px;
        }
        .inv_tab01
        {
            width: 174.5px;
            height: 33.5px;
            line-height: 33.5px;
            text-align: center;
            margin-right: 1px;
            color: #fff;
            background: #95cfff;
        }
        .inv_tab02
        {
            width: 174.5px;
            height: 33.5px;
            line-height: 33.5px;
            text-align: center;
            color: #fff;
            background: #95cfff;
        }
        .left_inv_tab
        {
            width: 173px;
            height: 32.5px;
            line-height: 32.5px;
            text-align: center;
            border:1px solid #76c1ff;
            border-top:none;
            color: #396ea2;
        }
        .right_inv_tab
        {
            width: 174px;
            height: 32.5px;
            line-height: 32.5px;
            text-align: center;
            border-right: 1px solid #76c1ff;
            border-bottom:1px solid #76c1ff;
            color: #396ea2;
        }
        .det04_title
        {
            font-size: 18px;
            font-weight: bold;
            color: #323232;
            margin-top: 30px !important;
            text-indent: 0 !important;
        }
        .det04_txt_box p
        {
            font-size: 16px;
            color: #323232;
            line-height: 25px;
            text-indent: 33px;
        }
        .det04_last
        {
            margin-top: 30px;
            text-indent: 33px;
        }
    </style>
</head>
<body class="pro-bg">
<!-- 公共头部Start -->
<%@ include file="../layouts/header.jsp"%>
<%--网站公告的开始--%>
<div class="content aboutUs">
    <div class="containerA">
        <div class="left-con">
            <p>关于我们
            </p>
            <ul class="about-ul">
                <li>
                    <a href="${pageContext.request.contextPath }/enterCompanyIntroduction">
                        平台介绍
                    </a>
                </li>
                <%--<li>--%>
                <%--<a  href="${pageContext.request.contextPath }/enterTeamIntroduction">--%>
                    <%--团队介绍--%>
                    <%--</a>--%>
                <%--</li>--%>
                <li class="click-li" style="border-left: 2px solid #00BBFF;">
                    <a  class="hover-A" href="${pageContext.request.contextPath }/enterWebsiteAnnouncement">
                        网站公告
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath }/enterMediaCoverage">
                        媒体报道
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath }/enterContactUs">
                        联系我们
                    </a>
                </li>
                <%--<li>--%>
                <%--<a href="${pageContext.request.contextPath }/enterPerformanceReport">--%>
                    <%--业绩报告--%>
                    <%--</a>--%>
                <%--</li>--%>
            </ul>
        </div>
    <div class="right-con">
    <p style="text-indent:-9999px;">
    网站公告
    </p>
    <div class="concen concenA" style="margin-top:-30px;height:990px !important;">
    <div class="website-smacen">
    <p class="p-tit" style="text-align:center;">金桔系列-优质小额债权资产上线公告 <label class="fr back" onclick="window.history.go(-1);" style="cursor:pointer;">返回></label></p>
     <div class="desc-1 det04_title">
        尊敬的富元汇用户：
    </div>
    <div class="det04_txt_box">
        <p>您好！感谢您的耐心等待，富元汇回来了！富元汇这次归来，重磅推出全新产品——金桔系列-优质小额债权资产！产品额度小而分散，让每位投资人能购买不同期限和不同利率的产品，最大程度分散低降低风险，享受个人财富最大化增值。金桔系列-优质小额债权资产将于8月17日起开始上线，投资门槛低，同时我们诚意满满，红包依然派不停！还犹豫什么，赶快告知身边的亲朋好友，前来体验吧！</p>
    </div>
     <div class="desc-1 det04_title">
        什么是金桔系列-优质小额债权资产？
    </div>
    <div class="det04_txt_box">
        <p>金桔系列-优质小额债权资产来自持牌机构的优质白领客户群体的小额债权资产，额度小而分散，且有到期全额回购承诺保证。</p>
        <p>产品规模：50,000-200,000元</p>
        <p>预期产品收益：5.8%-8%</p>
        <p>预期产品期限：30天-360天</p>
        <p>回款方式：到期一次性还本付息或按季付息到期一次性还本</p>
    </div>
    <div class="desc-1 det04_title">
    回款来源
    </div>
     <div class="det04_txt_box">
        <p>1、原债务人的工资等收入；</p>
        <p>2、富士康科技集团旗下全资子公司深圳市富龙小额贷款有限公司全额回购；</p>
    </div> 

    <div class="desc-1 det04_title">
    风险提示：
    </div>
     <div class="det04_txt_box">
        <p>市场有风险，投资需谨慎！金桔系列产品虽然由持牌机构提供全额回购保证，但您仍有可能面临信用风险以及保证机构能力下降的风险等，您可能面临本金及收益的损失。富元汇特别提示您，请您根据自身的理财规划及风险承受能力进行决策。</p>
    </div>  
    

    <div class="det04_txt_box">
        <p>富元汇全新回归，感谢有您！</p>
    </div>


 

    <div style="text-align:right;margin-top:60px;">富元汇团队</div>
    <div style="text-align:right;">2017年8月16日</div>

    <!-- 分页start -->
    <!-- <div class="page-cen">
        <span class="prev page-btn">
            下一篇
        </span>
        <span class="next page-btn">
            上一篇
        </span>
    </div> -->
    <!-- 分页end -->

    </div>
    </div>
    </div>
    </div>
</div>

<%--网站公告的结束--%>
<!-- 公共底部Start -->
<%@ include file="../layouts/footer.jsp"%>
</body>
</html>







