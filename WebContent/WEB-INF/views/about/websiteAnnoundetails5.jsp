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
        .tab
        {
            width: 560px;
            font-size: 14px;
            color: #323232;
            border: 1px solid #999;
            border-collapse: collapse;
            margin:0 auto;
        }
        tr, td, th 
        {
            text-align: center;
            border: 1px solid #999;
            height: 30px;
        }
        .det05_txt_box p 
        {
            font-size: 16px;
            color: #323232;
            line-height: 25px;
            text-indent: 33px;
        }
        .tab_body
        {
            margin-bottom: 20px;
        }
        .det05_title 
        {
            font-size: 18px;
            font-weight: bold;
            color: #323232;
            margin-top: 30px !important;
            text-indent: 0 !important;
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
            </ul>
        </div>
    <div class="right-con">
    <p style="text-indent:-9999px;">
    网站公告
    </p>
    <div class="concen concenA" style="margin-top:-30px;height:1930px !important;">
    <div class="website-smacen">
    <p class="p-tit" style="text-align:center;">618破千万礼赞活动获奖名单公告<label class="fr back" onclick="window.history.go(-1);" style="cursor:pointer;">返回></label></p>
     <div class="desc-1 det05_title">
        尊敬的用户：
    </div>
    <div class="det05_txt_box">
        <p>富元汇6.18破千万礼赞活动在大家的热情支持下已圆满结束，平台交易金额于2017年6月18日下午2时突破一千万大关，仅花了6个工作日时间。感谢大家的鼎力支持，现公布活动获奖名单如下：</p>
    </div>
    <div class="tab_body" style="margin-top:15px">
        <table class="tab">
            <thead>
                <th>排名</th>
                <th>注册手机号</th>
                <th>累计成功认购金额（元）</th>
                <th>奖励金额（元）</th>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>135*****162</td>
                    <td>338800</td>
                    <td>288</td>
                </tr>

                <tr>
                    <td>2</td>
                    <td>137*****189</td>
                    <td>208200</td>
                    <td>228</td>
                </tr>

                <tr>
                    <td>3</td>
                    <td>137*****189</td>
                    <td>180000</td>
                    <td>188</td>
                </tr>

                <tr>
                    <td>4</td>
                    <td>159*****307</td>
                    <td>156500</td>
                    <td>128</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>159*****134</td>
                    <td>150000</td>
                    <td>88</td>
                </tr>

            </tbody>
        </table>
    </div>

    <div class="tab_body">
        <table class="tab">
            <thead>
                <th>排名</th>
                <th>注册手机号</th>
                <th>邀请成功认购金额（元）</th>
                <th>奖励金额（元）</th>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>134*****683</td>
                    <td>251700</td>
                    <td>188</td>
                </tr>

                <tr>
                    <td>2</td>
                    <td>185*****047</td>
                    <td>200600</td>
                    <td>128</td>
                </tr>

                <tr>
                    <td>3</td>
                    <td>153*****292</td>
                    <td>195900</td>
                    <td>108</td>
                </tr>

                <tr>
                    <td>4</td>
                    <td>135*****871</td>
                    <td>161300</td>
                    <td>88</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>135*****162</td>
                    <td>156500</td>
                    <td>68</td>
                </tr>

            </tbody>
        </table>
    </div>

    <div class="tab_body">
        <table class="tab">
            <thead>
                <th>排名</th>
                <th>注册手机号</th>
                <th>邀请成功认购人数</th>
                <th>奖励金额（元）</th>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>134*****683</td>
                    <td>12</td>
                    <td>188</td>
                </tr>

                <tr>
                    <td>2</td>
                    <td>185*****047</td>
                    <td>7</td>
                    <td>128</td>
                </tr>

                <tr>
                    <td>3</td>
                    <td>135*****871</td>
                    <td>6</td>
                    <td>108</td>
                </tr>

                <tr>
                    <td>3</td>
                    <td>135*****947</td>
                    <td>6</td>
                    <td>108</td>
                </tr>

                <tr>
                    <td>4</td>
                    <td>153*****292</td>
                    <td>3</td>
                    <td>88</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>134*****991</td>
                    <td>2</td>
                    <td>68</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>135*****645</td>
                    <td>2</td>
                    <td>68</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>150*****472</td>
                    <td>2</td>
                    <td>68</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>139*****553</td>
                    <td>2</td>
                    <td>68</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>130*****053</td>
                    <td>2</td>
                    <td>68</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>158*****697</td>
                    <td>2</td>
                    <td>68</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>183*****387</td>
                    <td>2</td>
                    <td>68</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>158*****087</td>
                    <td>2</td>
                    <td>68</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>159*****363</td>
                    <td>2</td>
                    <td>68</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>187*****104</td>
                    <td>2</td>
                    <td>68</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>186*****765</td>
                    <td>2</td>
                    <td>68</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>189*****416</td>
                    <td>2</td>
                    <td>68</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>139*****946</td>
                    <td>2</td>
                    <td>68</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>176*****136</td>
                    <td>2</td>
                    <td>68</td>
                </tr>

            </tbody>
        </table>
    </div>

    <div class="det05_txt_box">
        <p>6.18破千万礼赞活动现金奖励将于2017年6月23日24时前发放，敬请关注！</p>
    </div>

    <div class="desc-1 det05_title">
        附：活动规则
    </div>
    <div class="det05_txt_box">
        <p>1、成功认购金额、邀请成功认购人数和邀请成功认购金额排名前五的用户，分别可获得现金奖励：</p>
    </div>
    <div class="tab_body" style="margin-top:15px">
        <table class="tab">
            <thead>
                <th>排名</th>
                <th>成功认购金额<br>奖励金额</th>
                <th>邀请成功认购人数<br>奖励金额</th>
                <th>邀请成功认购金额<br>奖励金额</th>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>288</td>
                    <td>188</td>
                    <td>188</td>
                </tr>

                <tr>
                    <td>2</td>
                    <td>228</td>
                    <td>128</td>
                    <td>128</td>
                </tr>

                <tr>
                    <td>3</td>
                    <td>188</td>
                    <td>108</td>
                    <td>108</td>
                </tr>

                <tr>
                    <td>4</td>
                    <td>128</td>
                    <td>88</td>
                    <td>88</td>
                </tr>

                <tr>
                    <td>5</td>
                    <td>88</td>
                    <td>68</td>
                    <td>68</td>
                </tr>

            </tbody>
        </table>
    </div>
    <div class="det05_txt_box">
        <p>2、此活动排名的金额和人数均指成功认购的金额和人数；</p>
        <p>3、此活动现金奖励直接发放至获奖用户的托管账户；</p>
        <p>4、此活动现金奖励可直接提现，或者用于认购产品；</p>
        <p>5、此活动截止时间为6月18日24时；</p>
        <p>6、此活动现金奖励发放时间为6月23日24时前；</p>
    </div>

    <div class="det04_last" style="margin:20px 0 0 32px;">*本活动解释权归富元汇所有，如有疑问请拨打客服热线：4009-303-606。</div>

    <div style="text-align:right;margin-top:60px;">富元汇团队</div>
    <div style="text-align:right;">2017年6月21日</div>
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







