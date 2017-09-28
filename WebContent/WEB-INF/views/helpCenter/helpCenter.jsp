    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
        <!DOCTYPE html>
        <html lang="en">
        <head lang="zh-cn">
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>帮助中心-富元汇</title>
        <meta name="author" content="深圳市富之富信息技术有限公司"/>
        <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
        <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
        <!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/helpCenter/helpCenter.css">
        <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
        <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
        <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
        <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
        <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/helpCenter/helpCenter.js'></script>
        <style>
        .active-a{color:#00BBFF !important; }
        </style>
        </head>
        <body class="pro-bg">
        <!-- 公共头部Start -->
        <%@ include file="../layouts/header.jsp"%>
        <%--帮助中心页面的开始--%>
        <div class="content aboutUs">
        <div class="containerA">
        <div class="left-con lfixed">
        <p>帮助中心
        </p>
        <ul class="about-ul">
        <li class="hli-6" style="border-left: 2px solid #00BBFF;">
        <a class="">
        账户
        </a>
        </li>
        <li class="hli-5">
        <a class="">
        注册
        </a>
        </li>
        <li class="hli-1">
        <a class="">
        充值
        </a>
        </li>
        <li class="hli-2">
        <a class="">
        提现
        </a>
        </li>
        <li class="hli-3">
        <a class="">
        认购
        </a>
        </li>
        <li class="hli-4">
        <a class="">
        风险缓释金
        </a>
        </li>
        <%--<li class="hli-4">--%>
        <%--<a class="">--%>
        <%--还款--%>
        <%--</a>--%>
        <%--</li>--%>
        </ul>
        </div>
        <div class="right-con">
        <p style="text-indent:-9999px;">
        常见问题
        </p>
        <div class="concen concenH" style="margin-top:-30px;">
        <div class="help-cen">
        <div id="account-con">
        <p class="sort-title">
        账户
        </p>
        <div class="tit-con">
        <h6 class="ques-tit">忘记密码怎么办？</h6>
        <p class="answ-con">点击登录页面的“忘记密码”按钮，通过注册的手机号即可找回登陆密码。</p>

        <h6 class="ques-tit">如何修改登录密码？</h6>
        <p class="answ-con">在富元汇首页打开【我的账户】--【账户信息】--【安全信息】页面，找到【登录密码】信息栏，点击【修改】，即可修改登陆密码。</p>
        </div>
        </div>
        <div id="register-con">
        <p class="sort-title">
        注册
        </p>
        <div class="tit-con">
        <h6 class="ques-tit">注册富元汇的条件是什么？</h6>
        <p class="answ-con">年龄在18周岁（含）以上、具有完全民事行为能力的中国公民（包括中国香港、澳门及台湾地区）和外国公民。
        </p>

        <h6 class="ques-tit">如何注册？</h6>
        <p class="answ-con">点击富元汇首页【立即注册】，填写注册信息，即可完成注册。</p>

        <h6 class="ques-tit">获取验证码失败怎么办？</h6>
        <p class="answ-con">通常可能是以下几种情况：</p>
        <p class="answ-con">（1）可咨询手机运营商是否有启用统一退订业务导致收不到验证码；</p>
        <p class="answ-con">（2）当验证码收取延迟，可等待几分钟后重新点击【获取验证码】；</p>
        <p class="answ-con">（3）请检查手机是否设置了信息或电话拦截功能。</p>
        <p class="answ-con">如无上述情况，请拨打客服热线4009-303-606进行咨询。</p>

        <h6 class="ques-tit">注册后可以随意更改信息吗？</h6>
        <p class="answ-con">为确保交易的真实性，注册信息无法自行修改。如在注册过程中出现错误，可拨打客服热线4009-303-606进行咨询。
        </p>

        <h6 class="ques-tit">证件号或手机号可以多次注册吗？</h6>
        <p class="answ-con">如果身份证号或手机号已被注册，则不能重复注册。用户已注册但忘记了注册信息，请不要尝试再次注册，可拨打客服热线4009-303-606核实身份信息，找回账号。
        </p>

        <h6 class="ques-tit">实名认证成功可以修改吗？</h6>
        <p class="answ-con">实名认证成功后不可以修改。每个人（同一身份证）仅认证一个账号，以确保用户更好的管理自己的资产，建议您谨慎填写您的认证信息。
        </p>


        </div>
        </div>
        <div id="recharge-con">
        <p class="sort-title">
        充值
        </p>
        <div class="tit-con">
        <h6 class="ques-tit">如何进行充值？</h6>
        <p class="answ-con">您可以通过网银支付或快捷支付进行充值。（目前只支持储蓄卡）</p>
        <%--<p class="answ-con">您可通过以下方式进行充值：</p>--%>
        <%--<p class="answ-con">电脑端：网银支付、快捷支付。</p>--%>


        <h6 class="ques-tit">关于充值流程？</h6>
        <p class="answ-con">登录富元汇平台，打开【我的账户】--【交易中心】--【充值】页面，选择充值方式【快捷充值】或【网银充值】，填写充值金额，点击【充值】跳转至第三方托管界面，按第三方托管要求操作，完成充值。</p>

        <h6 class="ques-tit">充值需要手续费吗？</h6>
        <p class="answ-con">投资用户免手续费，其它用户如通过企业网银充值按10元/笔收取，如通过个人网银充值则按充值金额的0.16%收取</p>

        <h6 class="ques-tit">充值到账时间？</h6>
        <p class="answ-con">实时到账。</p>

        <h6 class="ques-tit">可以绑定多张银行卡吗？</h6>
        <p class="answ-con">暂时不支持，目前仅支持修改银行账户。</p>


        <h6 class="ques-tit">银行已扣款，账户余额未显示是什么问题？</h6>
        <p class="answ-con"> (1) 银行已扣款，但可能由于银行系统原因，资金还未成功划转至您的托管账户。此种情况，待资金成功划转至您的托管账户后，余额即可变更。若银行未能将资金成功划转至您的托管账户，资金将自动退回充值的银行卡内;</p>
        <p class="answ-con"> (2) 第三方支付平台判断您的网络存在钓鱼风险，自动关闭交易，您的资金会自动退回您充值的银行卡内;</p>
        <p class="answ-con"> 如无上述情况，请拨打客服热线4009-303-606进行咨询。</p>


        <h6 class="ques-tit">充值是否有限额？</h6>
        <p class="answ-con">是的，不同充值方式、不同银行的充值限额均不同。单笔充值金额必须等于或大于100元，最高不能超过50万元（具体以银行充值限额为准）
        </p>
        </div>
        </div>
        <div id="Withdrawals-con">
        <p class="sort-title">
        提现
        </p>
        <div class="tit-con">
        <h6 class="ques-tit">提现需要支付哪些费用？</h6>
        <p class="answ-con">
        每笔需支付2元提现手续费。
        </p>

        <h6 class="ques-tit">提现金额有没有限制？</h6>
        <p class="answ-con">
        提现无金额上限限制。
        </p>

        <h6 class="ques-tit">提现多久能到账？</h6>
        <p class="answ-con">
        T+1到账，如遇节假日，则将在节假日后的第一个工作日到账；
        </p>

        <h6 class="ques-tit">为什么提现失败？</h6>
        <p class="answ-con" style="margin-bottom: 20px;">
        可能是以下原因：
        </p>
        <p class="answ-con" style="margin-bottom: 20px;">(1) 如发起提现后不能点击确认，请确认是否存在以下情况：</p>
        <lable class="la-li"></lable>提现金额大于可用余额；<br>
        <lable class="la-li"></lable>提现金额大于当日限额；<br>
        <lable class="la-li"></lable>提现金额小于最低提现金额；<br>
        <lable class="la-li"></lable>信息输入有误。<br>
        <p class="answ-con" style="margin-top:16px;">(2) 在第三方托管未完成交易操作，您重新发起提现申请。</p>
        <p class="answ-con">(3) 银行卡出现挂失、注销或信息变更等情况，会导致转账失败。请拨打客服热线4009-303-606进行咨询。</p>

        </div>
        </div>
        <div id="bid">
        <p class="sort-title">
        产品认购
        </p>
        <div class="tit-con">
        <h6 class="ques-tit">关于收益计算？</h6>
        <p class="answ-con">
        认购产品收益根据不同的产品，预期收益率也是不同的，请以实际认购产品为准。
        </p>
        <!-- <p class="answ-con">
        利息收益按照标的还款方式、标的利率和期限来具体计算。
        </p> -->

        <h6 class="ques-tit">认购产品后是否可以撤销？</h6>
        <p class="answ-con">
            不可以。为保证交易能公平、有序进行，申购后该笔资金会自动冻结，申购完成且审核通过后，该笔申购资金会自动划转到交易方账户。如果该产品未在认购期限内被募集成功，则会交易失败，交易失败后资金会自动解冻为可用金额，您可以再次认购平台其它产品。
        </p>

        <h6 class="ques-tit">如何查询交易记录？</h6>
        <p class="answ-con">
        登陆个人账户，点击进入【我的账户】--【账户中心】页面，即可查看您的历史交易记录。
        </p>

        <h6 class="ques-tit">资金托管模式</h6>
        <p class="answ-con">
            富元汇严守互联网金融操作规范，平台不设资金池。您的资金由上海富友支付服务有限公司（富友支付）进行托管，富友支付将为您开设独立的托管账户，您的资金只存在于托管账户里，与平台有效隔离，实现真正第三方资金托管与结算以保障您的资金安全。
        </p>

        <h6 class="ques-tit">费用</h6>
        <p class="answ-con">
            您成功认购产品后，在到期获取收益时，富元汇将收取交易服务费，按您收益的一定比例收取交易服务费，现暂定费率为10%。
        </p>

        
        </div>
        </div>
        <%--<div id="haikaun">--%>
        <%--<p class="sort-title">--%>
        <%--还款--%>
        <%--</p>--%>
        <%--<div class="tit-con">--%>
        <%--<h6 class="ques-tit">提现多久能到账？</h6>--%>
        <%--<p class="answ-con">--%>
        <%--T+1到账机制(T为交易当日)。发起提现后的第二个工作日到账，工作日不包括周六日，及法定节假日。--%>
        <%--</p>--%>

        <%--<h6 class="ques-tit">提现手续费怎么收取？</h6>--%>
        <%--<p class="answ-con">--%>
        <%--5万以下（包括5万） 1元/笔 5万-10万（包括10万）2元/笔 10万-50万（包括50万）3元/笔 50万-100万（包括100万）4元/笔--%>
        <%--100万以上按提现额的万分之零点零四收取，最高不超过40元 民生银行卡提现免费 每个月发起提现并成功的用户（不论次数），--%>
        <%--次月初会获得1张1元的现金券，可兑换1元账户余额......--%>
        <%--</p>--%>
        <%--</div>--%>
        <%--</div>--%>

        <!-- 风险缓释金Start -->
        <div id="risk_textBox">
            <p class="sort-title">风险缓释金</p>
            <div class="tit-con">
                <h6 class="ques-tit">风险缓释金机制定义</h6>
                <p class="answ-con">
                    风险缓释金机制是富元汇平台为了保护平台认购人的利益而建立的信用风险承担机制。富元汇通过上海富友支付服务有限公司设立专用托管账户，专款专用，用于保障受保障产品认购人的权利。
                </p>

                <h6 class="ques-tit">风险缓释金资金来源</h6>
                <p class="answ-con">
                    从富元汇平台对金猪系列和金桔系列产品发布人收取的服务费收入中计提50%作为风险缓释金
                </p>

                <h6 class="ques-tit">风险缓释金用途</h6>
                <p class="answ-con">
                    当受保障产品超过到期日30个自然日未足额兑付时，富元汇平台则于当日从风险缓释金账户提取相应资金用于偿付对应产品认购人逾期应收金额（含本金、收益和逾期收益）。
                </p>

                <h6 class="ques-tit">风险缓释金保障产品</h6>
                <p class="answ-con">
                    金猪系列产品和金桔系列产品
                </p>

                <h6 class="ques-tit">风险缓释金使用规则</h6>
                <p class="answ-con">
                    (1)、时间顺序规则：风险缓释金对受保障产品的认购人逾期应收金额的偿付按照该产品逾期的时间顺序进行偿付分配。先偿付逾期在先的产品，后偿付逾期在后的产品。
                </p>
                <p class="answ-con">
                    (2)、认购比例规则：风险缓释金对同一受保障产品的《产品合同》项下不同认购人逾期应收金额的偿付按照各认购金额占同协议内发生的产品规模的比例进行偿付分配；当风险缓释金当期余额不足以支付当日所有应享受风险缓释金账户资金赔付的受保障产品的认购人所对应的逾期应收金额总额时，则所有已达到赔付条件的受保障产品项下各认购人按照各自对应的逾期应收金额占当期所有该等认购人对应逾期应收金额总额的比例进行偿付分配。
                </p>
                <p class="answ-con">
                    (3)、有限偿付规则：风险缓释金对受保障产品的认购人逾期应收金额的偿付以风险缓释金账户资金总额为限。当风险缓释金账户余额为零时，自动停止对认购人逾期应收金额的偿付，直到该账户获得新的风险缓释金。
                </p>
                <p class="answ-con">
                    (4)、收益转移规则：当受保障产品的认购人享有了“风险缓释金账户”对某个受保障产品按照既定规则进行的偿付后，富元汇作为风险缓释金账户的主体，即取得对应权益。该产品对应的融资人其后为该受保障产品所偿还的全部本金、收益及逾期收益归属风险缓释金账户。
                </p>
                <p class="answ-con">
                    (5)、金额上限规则：风险缓释金金额超过届时平台上发生的对应保障产品的未兑付本金金额的6%时，富元汇有权将超出部分转出自行支配。
                </p>

                <h6 class="ques-tit">风险缓释金管理原则</h6>
                <p class="answ-con">
                    富元汇平台在上海富友支付服务有限公司开立风险缓释金账户，由富友支付进行托管，专款专用。
                </p>




            </div>
        </div>


        </div>
        </div>
        </div>
        </div>
        </div>

        <%--帮助中心页面的结束--%>
        <!-- 公共底部Start -->
        <%@ include file="../layouts/footer.jsp"%>
        </body>
        </html>







