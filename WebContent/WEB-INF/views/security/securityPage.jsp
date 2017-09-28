    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
        <!DOCTYPE html>
        <html lang="en">
        <head lang="zh-cn">
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>安全保障-富元汇</title>
        <meta name="author" content="深圳市富之富信息技术有限公司"/>
        <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
        <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
        <!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
        <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
        <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
        
        <style type="text/css">
            .sec_banner
            {
                width: 100%;
                height: 662px;
                background: url(../../static/images/security/bannar.png) no-repeat center;
            }
            .risk_control_box
            {
                width: 100%;
                background: #fff;
            }
            .risk_control_w
            {
                width: 1170px;
                margin:0 auto;
            }
            .risk_control_w h3
            {
                padding:60px 0 53px 0;
                font-size: 45px;
                color: #323232;
                text-align: center;
            }
            .risk_icon
            {
                width: 100%;
                height: 172px;
                padding-bottom: 46px;
            }
            .risk_icon div
            {
                width: 148px;
                height: 172px;
            }
            .icon01
            {
                background: url(../../static/images/security/sec02.png) no-repeat center;
                margin:0 205px 0 158px;
            }
            .icon02
            {
                background: url(../../static/images/security/sec03.png) no-repeat center;
                margin: 0 205px 0 0;
            }
            .icon03
            {
                background: url(../../static/images/security/sec01.png) no-repeat center;
            }
            .rk_control_left
            {
                width: 260px;
                margin-left: 101px;
            }
            .rk_control_middle
            {
                width: 270px;
                margin-left: 91px;
            }
            .rk_control_right
            {
                width: 260px;
                margin-left: 88px;
            }
            .risk_control_text h6
            {
                font-size: 24px;
                color: #323232;
                text-align: center;
                margin-bottom: 20px;
            }
            .risk_control_text p
            {
                font-size: 16px;
                color: #666;
                line-height: 22px;
                text-align: center;
            }
            .credit_security_box
            {
                width: 100%;
                height: 670px;
                background: url(../../static/images/security/sec05.png) no-repeat center;
            }
            .credit_sec_w,.risk_rule_w,.money_host_w
            {
                width: 1170px;
                position: relative;
                margin: 0 auto;
            }
            .credit_sec_w h3
            {
                position: absolute;
                top: 144px;
                left: 494px;
                text-align: center;
                font-size: 45px;
                color: #fff;
            }
            .credit_txt
            {
                position: absolute;
                top: 523px;
                left: 241px;
                font-size: 20px;
                color: #fff;
                line-height: 32px;
                text-align: center;
            }
            .risk_rule_box
            {
                width: 100%;
                height: 700px;
                background: url(../../static/images/security/sec04.png) no-repeat center; 
                margin-top: -99px;
            }
            .risk_rule_w h6
            {
                position: absolute;
                top: 138px;
                left: 500px;
                font-size: 45px;
                color: #323232;
            }
            .risk_rule_txt
            {
                position: absolute;
                top: 540px;
                left: 183px;
                font-size: 20px;
                color: #666;
                line-height: 32px;
                text-align: center; 
            }
            .money_hosting_box
            {
                margin: -99px 0 21px 0;
                width: 100%;
                height: 670px;
                background: url(../../static/images/security/sec06.png) no-repeat center; 
            }
            .money_host_w h6
            {
                position: absolute;
                top: 144px;
                left: 494px;
                text-align: center;
                font-size: 45px;
                color: #fff;
            }
            .money_host_text
            {
                position: absolute;
                top: 523px;
                left: 190px;
                font-size: 20px;
                color: #fff;
                line-height: 32px;
                text-align: center;
            }
        </style>

        </head>
        <body>
            <!-- 公共头部Start -->
            <%@ include file="../layouts/header.jsp"%>
            <div class="sec_banner"></div>
            <!-- 专业风控Start -->
            <div class="risk_control_box">
                <div class="risk_control_w">
                    <h3>专业风控</h3>
                    <div class="risk_icon">
                        <div class="fl icon01"></div>
                        <div class="fl icon02"></div>
                        <div class="fl icon03"></div>
                        <div class="clear"></div>
                    </div>
                    <div class="risk_control_text">
                        <div class="fl rk_control_left">
                            <h6>产品发布前</h6>
                            <p>
                                组建专业风控团队通过实地、网络、电话等有效渠道对合作机构及交易产品进行全方位调查后，上报风险审核委员会审批。
                            </p>
                        </div>
                        <div class="fl rk_control_middle">
                            <h6>产品发布中</h6>
                            <p>
                                建立完善的监控、预警机制，定期对合作机构及交易产品进行全方位风险排查，交易产品到期前通过短信、电话或者登门的方式进行履约提醒。
                            </p>
                        </div>
                        <div class="fl rk_control_right">
                            <h6>产品发布后</h6>
                            <p>
                                多重防线，有效抵御风险，与多家资深催收公司与专业律师事务所建立长期合作关系，对交易产品违约采取及时、有效的手段防控。
                            </p>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>


            <!-- 增信保障Start -->
            <div class="credit_security_box">
                <div class="credit_sec_w">
                    <h3>增信保障</h3>
                    <div class="credit_txt">
                        信心之选，<br>
                        由第三方提供增信措施，包括票据质押、缴纳保证金和提供连带保证担保等，<br>
                        为用户的本金及收益提供安全保障，保驾护航。
                    </div>
                </div>
            </div>

            <!-- 风险机制Start -->
            <div class="risk_rule_box">
                <div class="risk_rule_w">
                    <h6>风险机制</h6>
                    <div class="risk_rule_txt">
                        安心之选，<br>
                        完善的信用风险承担机制，富元汇委托上海富友支付服务有限公司（富友支付）设立专用的<br>
                        风险缓释金托管账户，并从平台收入中计提风险缓释金，专款专用，保障用户的利益。
                    </div>
                </div>
            </div>

            <!-- 资金托管Start -->
            <div class="money_hosting_box">
                <div class="money_host_w">
                    <h6>资金托管</h6>
                    <div class="money_host_text">
                        放心之选，<br>
                        用户资金与平台实行隔离，用户的资金由富友支付进行托管，用户开设独立的托管账户，<br>
                        第三方监管下保障用户资金，透明安全。
                    </div>
                </div>
            </div>
       

            <!-- 公共底部Start -->
            <%@ include file="../layouts/footer.jsp"%>
        </body>
        </html>



