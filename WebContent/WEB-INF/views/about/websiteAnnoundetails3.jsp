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
    <div class="concen concenA" style="margin-top:-30px;height:900px !important;">
    <div class="website-smacen">
    <p class="p-tit" style="text-align:center;">富元汇邀请好友拿现金奖励 <label class="fr back" onclick="window.history.go(-1);" style="cursor:pointer;">返回></label></p>
   <!--  <p class="p-time">
    2017-03-23
    </p> -->
  <!--   <div class="desc-1">
        富元汇是由世界百强企业鸿海富士康科技集团打造的互联网金融服务平台，2017年在中国深圳正式启动运营。
    </div>
    <div class="desc-1">
        富元汇作为富士康集团旗下综合金融服务平台，专注于互联网大数据分析和金融科技研发，携手行业内具备多年资产管理服务和专业领域机构，富友集团、广东银华律师事务所、贤方律师事务所、金城同达律师事务所等成为战略合作伙伴，致力于为投资用户提供多元化、稳健、高效的互联网金融服务，未来将并肩前进，合作共赢。
    </div> -->
     <div class="desc-1" style="text-indent:0;margin-top:30px;">
    尊敬的用户：</br>
    </div>
    <div class="desc-1" style="text-indent:0;margin-top:30px;">
        富元汇平台正式上线，上线期间惊喜活动享不停。邀请好友，好友注册成功，首次成功认购产品您即可获得现金奖励。
    </div>
     <div class="desc-1" style="text-indent:0;margin-top:30px; " >
        邀请方式:<br/>
        分享专属链接/邀请码给好友 - 好友注册成功 - 好友首次成功认购您即可获得奖励。
    </div>
    <div class="desc-1" style="text-indent:0;margin-top:30px;">
    邀请规则：
    </div>
        <p style="color:#323232;">1、邀请人成功认购产品后通过专属邀请码或链接邀请好友注册，视为邀请成功。</p>
        <p style="margin-top:10px;color:#323232;">
            <p>2、邀请好友获取奖励的有效期为三个月，受邀的新用户注册后在有效期内首次成功认购产品，邀请人即可获得邀请奖<br><span style='margin-left:25px;'>励。</span></p>
            <p class="invite_role_h1" style="margin-bottom:20px;margin-left:25px;">首次成功认购金额对应奖励金额如下:</p>
                 <div class="invite_table">
                    <div class="fl inv_tab01">首次成功认购金额</div>
                    <div class="fl inv_tab02">奖励金额</div>
                    <div class="fl left_inv_tab">10,000以下</div>
                    <div class="fl right_inv_tab">¥18</div>
                    <div class="fl left_inv_tab">10,000-19,999</div>
                    <div class="fl right_inv_tab">¥28</div>
                    <div class="fl left_inv_tab">20,000-49,999</div>
                    <div class="fl right_inv_tab">¥58</div>
                    <div class="fl left_inv_tab">50000及以上</div>
                    <div class="fl right_inv_tab">¥128</div>
                    <div class="clear"></div>
                </div>
        </p>
        <p style="margin-top:20px;color:#323232;">3、奖励资金将在被邀请人首次认购成功当天发放至邀请人账户，奖励资金可用于认购产品或者提现。</p>
        <p style="margin-top:10px;color:#323232;">4、邀请人每月邀请奖励次数不受限制。</p>
        <p style="margin-top:10px;color:#323232;">5、本活动法律允许范围内的最终解释权归富元汇平台所有。</p>
 

    <div style="text-align:right;margin-top:60px;">富元汇团队</div>
    <div style="text-align:right;">2017年6月5日</div>

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







