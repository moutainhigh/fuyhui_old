package com.fujfu.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fujfu.pojo.apply.ApplyRecoverVO;
import com.fujfu.pojo.invest.LoanInvestmentVO;
import com.fujfu.pojo.loan.LoanApplyVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.web.constant.FeeProperties;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CreProductPdf extends PDFDemo{
	/*
	 * 生成产品募集书
	 * param  
	 */
	public void writePdf2(String path,String productName, LoanApplyVO loanApply, UserVO loadApplyUser, UserVO GuaranUser) throws Exception {
		Document document = new Document();
		 // 生成字体
		PdfWriter.getInstance(document, new FileOutputStream(path));
        
        // 生成字体
        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
        // 标题字体
        Font f15 = new Font(bfChinese, 15, bold, black);
        Font f18 = new Font(bfChinese, 18, Font.NORMAL, black);
        //正文标题
        Font f10 = new Font(bfChinese, 10, bold, black);
        // 正文字体
        Font ff10 = new Font(bfChinese, 10, Font.NORMAL, black);
        Font f12 = new Font(bfChinese, 12, Font.NORMAL, black);
        //Font fff10 = new Font(bfChinese, 10, bold, black);
        Font f8 = new Font(bfChinese, 8, Font.NORMAL, black);
       
        document.open();
        document.add(new Chunk("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"));// 换行
        document.add(new Chunk("\n\n"));// 换行

		//标题     
        Paragraph head1 = convertParToChinese2("","号",loanApply.getName(), f18,0);
        head1.setAlignment(1);//设置段落居中
        head1.setSpacingBefore(260);
        document.add(head1);
         head1 = convertParToChinese1("资产支持类收益权产品", f18,0);
        head1.setAlignment(1);//设置段落居中
        document.add(head1);
         head1 = convertParToChinese1("产品募集说明书", f18,0);
        head1.setAlignment(1);//设置段落居中
        document.add(head1);
        document.newPage();
        document.add(new Chunk("\n\n"));// 换行

        Paragraph p=convertParToChinese2("发行人：","",loadApplyUser.getCorpName(),f12,0);
        document.add(p);
        p=convertParToChinese2("产品管理人：","",loanApply.getProductManager(),f12,0);
        document.add(p);
//        p=convertParToChinese2("","",DateUtil.timeMillisToStrNew(loanApply.getStartTime()),f12,0);
//        document.add(p);
        document.add(new Chunk("\n\n"));// 换行

      //标题     
        head1 = convertParToChinese1("承诺与声明", f15,0);
        head1.setAlignment(1);//设置段落居中
        head1.setSpacingAfter(10);  
        document.add(head1);
        
        p=convertParToChinese1("发行人通过青金所备案的产品，产品管理人均以履行青金所要求，履行对产品发行人、基础资产的尽调和披露等义务，并严格按照发行人要求发行申请备案及挂牌本产品。",f12,0);
        document.add(p);
        p=convertParToChinese1("产品发行的所有法律文件是依据《中华人民共和国公司法》及其他现行法律、法规以及青岛国富金融资产交易中心有限公司的有关规定，并结合发行人的实际情况由产品管理人编制。",f12,0);
        document.add(p);
        p=convertParToChinese1("发行人全体高管人员承诺本次募集资金用途合法合规、发行程序合规，不存在虚假记载、误导性陈述或重大遗漏，并保证所披露信息的真实、准确、完整。",f12,0);
        document.add(p);
        p=convertParToChinese1("本次资产收益权产品经青岛国富金融资产交易中心有限公司（简称“青金所”）受理备案，本产品的发行通过青金所指定的交易平台进行。青金所对本产品的发行所作的任何决定，均不表明青金所对本产品的投资价值或者投资者的收益作出实质性判断或保证。任何与之相反的声明或提示均属虚假陈述。",f12,0);
        document.add(p);
        p=convertParToChinese1("凡欲购买、受让本次资产收益权产品的投资者，请认真阅读本募集说明书及其有关信息披露文件，并进行独立投资判断。",f12,0);
        document.add(p);
        p=convertParToChinese1("凡认购、受让并持有本次收益权产品的投资者，均视同自愿接受本募集说明书对本次收益权产品各项权利义务的约定。本次收益权产品依法发行后，投资者自行承担投资风险。",f12,0);
        document.add(p);
        p=convertParToChinese1("投资者在评价、认购、受让本次收益权产品时，应特别审慎地考虑本募集说明书中所述的各项风险因素。",f12,0);
        document.add(p);
        p=convertParToChinese1("本募集说明书及本次收益权产品的基础资产备案文件置备于青金所住所处，投资者有权随时查阅。",f12,0);
        document.add(p);
        document.add(new Chunk("\n"));// 换行

        //标题     
        head1 = convertParToChinese1("释义", f15,0);
        head1.setAlignment(1);//设置段落居中
        head1.setSpacingAfter(10);  
        document.add(head1);
        
        p=convertParToChinese1("除非本文另有所指，下列词语具有的含义如下：",f12,0);
        document.add(p);
        p=convertParToChinese2("发行人、本公司、公司：指","",loadApplyUser.getCorpName(),f12,0);
        document.add(p);
        p=convertParToChinese2("产品、本产品：指","号资产支持类收益权产品",loanApply.getName(),f12,0);
        document.add(p);
        p=convertParToChinese1("募集说明书、本募集说明书：指资产支持类收益权产品募集说明书：",f12,0);
        document.add(p);
        p=convertParToChinese1("认购：指在本产品认购期间，认购人按照本产品的认购协议约定购买本产品的行为",f12,0);
        document.add(p);
        p=convertParToChinese1("工作日：指中华人民共和国的法定节假日或公休日以外的日期",f12,0);
        document.add(p);
        p=convertParToChinese1("产品存续期间：指产品自计息日至全部兑付结清为止的期间",f12,0);
        document.add(p);
        p=convertParToChinese1("产品备案挂牌服务机构、青金所：指青岛国富金融资产交易中心有限公司",f12,0);
        document.add(p);
        p=convertParToChinese2("产品管理人：指","",loanApply.getProductManager(),f12,0);
        document.add(p);
        p=convertParToChinese1("投资顾问：指深圳市富之富信息技术有限公司",f12,0);
        document.add(p);
        p=convertParToChinese1("元：指人民币元",f12,0);
        document.add(p);
        document.add(new Chunk("\n\n"));// 换行
        
        //标题     
        head1 = convertParToChinese1("第一节 产品基本情况", f15,0);
        head1.setAlignment(1);//设置段落居中
        head1.setSpacingAfter(10);  
        document.add(head1);
        
        p=convertParToChinese1("一、	产品概要",f12,0);
        document.add(p);
        p=convertParToChinese2("（一） 发行人：","",loadApplyUser.getCorpName(),f12,5);
        document.add(p);
        p=convertParToChinese2("（二）产品名称：","",loanApply.getName(),f12,5);
        document.add(p);
        p=convertParToChinese2("（三）基础资产类型：","",loanApply.getUnderlyAssets(),f12,5);
        document.add(p); 
        p=convertParToChinese2("（四）备案规模：","元",StringUtil.insertComma(loanApply.getRecordSize().toString(),2),f12,5);
        document.add(p);
        p=convertParToChinese2("（五）还本付息方式：","",FeeProperties.REPAYMENT_METHOD.get(loanApply.getPaymentOptions()),f12,5);
        document.add(p);
        p=convertParToChinese2("（六） 预期年化收益率：","%",StringUtil.handleApr(loanApply.getApr().toString()),f12,5);
        document.add(p);
        p=convertParToChinese2("（七）产品发行方式：","","本产品一次备案",f12,5);
        document.add(p);
        p=convertParToChinese1("（八）产品发行类型：单项资产支持类之收益单项发行——合约期固定且不替换",f12,5);
        document.add(p);
        p=convertParToChinese1("（九）交易类型：第一手认购可再交易式",f12,5);
        document.add(p);
        p=convertParToChinese1("（十）认购方式：场外认购，即本产品在青金所的资产交易系统平台（网址：http://ats.qdfae.com）公告发行后，认购人在青金所资产交易系统平台外的其他平台或场所认购本产品。",f12,5);
        document.add(p);
        p=convertParToChinese1("（十一）投资人数上限：每期产品的投资者人数上限不超过200人",f12,5);
        document.add(p);
        p=convertParToChinese2("（十二）产品管理人：","",loanApply.getProductManager(),f12,5);
        document.add(p);
        p=convertParToChinese1("（十三）产品投资顾问：深圳市富之富信息技术有限公司",f12,5);
        document.add(p);
        p=convertParToChinese1("（十四）产品备案挂牌交易机构：青岛国富金融资产交易中心 ",f12,5);
        document.add(p);
        
        p=convertParToChinese1("二、产品清偿及保障措施",f12,0);
        document.add(p);
        p=convertParToChinese1("（一）收益起算日：本产品的收益起算日以产品挂牌交易申请书的预计收益起算日（法定节假日除外）为准。",f12,5);
        document.add(p);
        p=convertParToChinese1("（二）到期日：本产品的到期日以产品挂牌交易申请书的到期日（法定节假日除外）为准。",f12,5);
        document.add(p);
        p=convertParToChinese1("（三）兑付资金来源：本产品到期时清偿分配的资金来源于本产品所对应“基础资产”清偿分配的资金，即对于基础交易合同项下的“基础资产”投资与收益清偿分配收入的合理预期。产品的投资本金及投资收益清偿分配时间与对应“基础资产”产品的投资本金和/或投资收益清偿分配款项预定给付到账时间对应。",f12,5);
        document.add(p);
        p=convertParToChinese1("（四）其他说明：投资者认购款项自到达本产品资金结算账户起至本产品发行款项划转至发行人指定账户之日止，期间不计利息。",f12,5);
        document.add(p);
        p=convertParToChinese2("（五）本产品的兑付保障方式为：由","负责提供","，可覆盖产品到期兑付本息全额资金款项。",GuaranUser.getCorpName(),loanApply.getGuaranteeMode(),f12,5);
        document.add(p);
        
        p=convertParToChinese1("三、	投资者适合性及相关事项要求",f12,0);
        document.add(p);
        p=convertParToChinese1("（一）本产品将在青金所挂牌交易，向通过青金所注册的投资者定向发行。",f12,5);
        document.add(p);
        p=convertParToChinese1("（二）适合投资者类型：产品适合投资者类型为投资者风险承受能力测试及以上风险承受能力类型的投资者，包括机构投资者、自然人投资者，每期产品合计不超过200人。",f12,5);
        document.add(p);
        p=convertParToChinese1("（三）税务事项：根据国家有关税收法律、法规的规定，投资者投资本期产品应缴纳的税款由投资者自行负责。税种可能会包括但不限于增值税、营业税、所得税、合约性文件印花税等，具体税种应以税务机关最终征收要求为准。",f12,5);
        document.add(p);
        p=convertParToChinese1("（四）投资者的权利主张方式及途径认购本产品的投资者，相关权利按相关认购约定的方式主张权利。",f12,5);        
        document.add(p);        
        p=convertParToChinese1("四、合约构成及其生效",f12,0);
        document.add(p);
        p=convertParToChinese1("（一）合约条款由以下法律文件构成：《产品备案/挂牌交易申请书》、《资产支持类收益权产品募集说明书》、《金融产品认购协议》三部分组成。",f12,5);
        document.add(p);
        p=convertParToChinese1("（二）签署及生效：当产品管理人受发行人委托向青金所提交产品备案及挂牌交易申请，青金所审核通过备案及挂牌申请后，该产品即告成立。交易参与方共同签署上述认购合同，合约产品的相关条款即对交易的双方正式生效。",f12,5);
        document.add(p);

        
      //标题     
        head1 = convertParToChinese1("第二节 资产支持类收益权产品基础资产构成", f15,0);
        head1.setAlignment(1);//设置段落居中
        head1.setSpacingAfter(10);  
        document.add(head1);
        p=convertParToChinese2("一、基础资产概述：","",loanApply.getDescription(),f12,5);
        document.add(p);
        p=convertParToChinese2("二、基础资产权属：","",loadApplyUser.getCorpName(),f12,5);
        document.add(p);
        //标题     
        head1 = convertParToChinese1("第三节 产品风险因素", f15,0);
        head1.setAlignment(1);//设置段落居中
        head1.setSpacingAfter(10);  
        document.add(head1);
        p=convertParToChinese1("下文总结了本产品及其投资中可能存在的部分风险，每一种风险都可能对部分或全部本产品投资者的收益预期及实现产生“不利影响”，因此，投资者在评价和购买本产品时，应特别认真地考虑下述各项风险因素。",f12,0);
        document.add(p);
        p=convertParToChinese1("一、宏观经济风险：由于我国宏观经济形势的变化以及周边国家、地区宏观经济环境的变化，可引起市场的波动，从而导致产品价格变化。",f12,0);
        document.add(p);
        p=convertParToChinese1("二、政策风险：有关金融市场的法律、法规及相关政策、规则发生变化，可能引起市场价格波动，从而导致产品价格变化甚至提前终止。",f12,0);
        document.add(p);
        p=convertParToChinese1("三、发行方履行兑付义务风险：如果发行方未能及时足额将产品到期时应分配给投资者的资金划转至指定的清算账户，可能影响该产品到期时投资本金和收益的按时偿还。",f12,0);
        document.add(p);
        p=convertParToChinese1("四、产品的早偿风险：如果基础资产债务人提前还款，或者发行人提前回购基础资产，本产品可能提前宣布到期，并将还款的本金及收益支付到指定清算账户，可能影响到本产品的投资人的收益部分的收取。",f12,0);
        document.add(p);
        p=convertParToChinese1("五、“基础资产”债务人兑付能力下降的风险：第一还款来源为融资方/资金使用人承担第一债务人义务。与此相关，在该“基础资产”的存续期内，如遇政策、法规和行业、市场等不可控因素对融资方/资金使用人的经营活动产生重大负面影响，从而导致产品所对应“基础资产”的债务人的经营状况和盈利水平下降，这可能影响产品所对应“基础资产”合同——“基础资产”合同文件项下的“基础资产”投资合同中投资者权益的实现，进而可能进一步影响到该产品投资者按时、按预期收益率获得产品到期时清偿分配资金。",f12,0);
        document.add(p);
        p=convertParToChinese1("六、技术风险：由于交易及行情揭示是通过电子通讯技术和电脑技术来实现的，这些技术存在着被网络黑客和计算机病毒攻击的可能，这将会导致投资者的交易无法顺利进行，进而造成投资收益的损失。",f12,0);
        document.add(p);
        p=convertParToChinese1("七、不可抗力因素导致的风险：诸如地震、火灾、水灾、战争等不可抗力因素可能导致交易系统的瘫痪；无法控制和不可预测的系统故障、设备故障、通讯故障、电力故障等也可能导致交易系统非正常运行甚至瘫痪，这些都可能使投资者的交易无法正常进行，从而导致投资收益的损失。",f12,0);
        document.add(p);
        p=convertParToChinese1("八、其他风险：",f12,0);
        document.add(p);
        p=convertParToChinese1("（一）由于投资者密码失密、操作不当、投资决策失误等原因可能会使投资者发生亏损，该损失将由投资者自行承担；在投资者进行交易中他人给予投资者的保证获利或不会发生亏损的任何承诺都是没有根据的，类似的承诺不会减少投资者发生亏损的可能。",f12,5);        
        document.add(p); 
        p=convertParToChinese1("（二）网上交易、热键操作完毕，未及时退出，他人进行恶意操作而造成的损失；其中网上交易未及时退出还可能遭遇黑客攻击，从而造成损失。",f12,5);        
        document.add(p); 
        p=convertParToChinese1("（三）委托他人代理产品交易，且不时常关注帐户变化，致使他人恶意操作而造成的损失。",f12,5);        
        document.add(p); 
        p=convertParToChinese1("以上并不能揭示交易的全部风险及市场的全部情形。投资者在做出交易决策前，应通过青金所公布的信息及其他相关公告了解拟交易产品的风险及收益特征，并根据自身的交易目标、风险承受能力和资产状况等谨慎决策，自行承担风险。",f12,0);        
        document.add(p);
        
      //标题     
        head1 = convertParToChinese1("第四节 信息披露", f15,0);
        head1.setAlignment(1);//设置段落居中
        head1.setSpacingAfter(10);  
        document.add(head1);
        p=convertParToChinese1("一、信息披露方式",f12,0);
        document.add(p);
        p=convertParToChinese1("（一）信息披露义务人：本公司及其全体股东、监事及高级管理人员将严格按照《中华人民共和国公司法》和《交易细则》等相关法律法规的规定，指定专人负责信息披露相关事务，并保证所披露的信息真实、准确、完整、及时，不得虚假记载、误导性陈述或重大遗漏。董事、监事及高级管理人员若对所披露信息的真实性、准确性、完整性、及时性存在异议的，将按照青金所的规定单独发表意见并陈述理由。",f12,5);        
        document.add(p);
        p=convertParToChinese1("（二）信息披露渠道：本企业将在青金所或青金所指定的其他渠道进行信息披露。",f12,5);
        document.add(p);
        p=convertParToChinese1("二、信息披露主要内容",f12,0);
        document.add(p);
        p=convertParToChinese1("（一）本次资产收益权产品发行情况：本公司应在本次资产收益权产品在青金所受理同意挂牌后通过青金所或青金所指定的其他渠道及时披露本次投资收益权产品的名称、代码、期限、发行金额、收益及本企业的联系方式等内容。",f12,5);
        document.add(p);
        p=convertParToChinese1("主要披露包括但不限于以下文件：",f12,5);
        document.add(p);
        p=convertParToChinese1("1、本次资产收益权产品产品募集说明书、风险揭示书等；",f12,8);
        document.add(p);
        p=convertParToChinese1("2、青金所规定的其他文件。",f12,8);
        document.add(p);
        p=convertParToChinese1("（二）本次资产收益权产品存续期内重大事项的信息披露：本公司将及时披露可能发生的影响其兑付能力的重大事项，包括但不限于：",f12,0);
        document.add(p);
        p=convertParToChinese1("1、本公司的经营方针和经营范围的重大变化；",f12,8);
        document.add(p);
        p=convertParToChinese1("2、本公司的重大投资行为、重大对外担保行为、重大融资行为和重大购置财产决定、重大财务决定；",f12,8);
        document.add(p);
        p=convertParToChinese1("3、本公司发生重大债务和未能清偿到期债务的违约情况；",f12,8);
        document.add(p);
        p=convertParToChinese1("4、本公司做出减资、合并、分立、解散及申请破产的决定；",f12,8);
        document.add(p);
        p=convertParToChinese1("5、本公司涉及重大诉讼、仲裁事项或受到重大行政处罚；",f12,8);
        document.add(p);
        p=convertParToChinese1("6、本公司涉嫌犯罪被司法机关立案调查，董事、监事、高级管理人员、负责人涉及重大民事或刑事诉讼，或已就重大经济事件接受有关部门调查；",f12,8);
        document.add(p);
        p=convertParToChinese1("7、青金所规定的其他重大事项。",f12,8);
        document.add(p);
        p=convertParToChinese1("第六节 法律适用及争议解决机制",f12,0);
        document.add(p);
        p=convertParToChinese1("一、	本次资产收益权产品产品募集说明书及其他相关文件受中国法律管辖，并按中国法律解释。",f12,0);
        document.add(p);
        p=convertParToChinese1("二、	本公司未按约定兑付本次资产收益权产品本金及收益，或发生其他违约情况时，本公司应承担违约责任，产品持有人有权直接依法向本公司进行追索。",f12,0);
        document.add(p);
        p=convertParToChinese1("三、	凡因本次资产收益权产品的发行、认购、转让、受让、兑付等事项引起的或与本次资产收益权产品有关的任何争议，应首先通过协商解决。如果在接到要求解决争议的书面通知之日起第 30日内仍不能通过协商解决争议，任何一方可向被告所在地人民法院提起诉讼。",f12,0);
        document.add(p);
		document.close();

	}
	
	/**
	 * 
	 * 生成金桔系列协议模版
	 * */
	public void writePdf3(String path,String productName, LoanApplyVO loanApply, UserVO loadApplyUser, UserVO GuaranUser) throws Exception {

		Document document = new Document();
		 // 生成字体
		PdfWriter.getInstance(document, new FileOutputStream(path));
       
       // 生成字体
       BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);	
       
       // 标题字体
       Font f15 = new Font(bfChinese, 15, bold, black);
       //正文标题
       Font f10 = new Font(bfChinese, 10, bold, black);
       // 正文字体
       Font ff10 = new Font(bfChinese, 10, Font.NORMAL, black);
       //Font fff10 = new Font(bfChinese, 10, bold, black);
       Font f8 = new Font(bfChinese, 8, Font.NORMAL, black);
      
       document.open();       
		//标题     
       Paragraph p = convertParToChinese1("债权转让协议", f15,0);
       p.setAlignment(1);//设置段落居中
       p.setSpacingAfter(10);  
       document.add(p); 
       
       
       p = convertParToChinese1("协议编号：                                                 ", f10,0);
       p.setAlignment(2);//设置段落居右
       document.add(p);
       
       p = convertParToChinese1("甲方（转让人）:", f10,0);
       Chunk chunk = convertChunkByChinesexiahua("                                   ", f10);
       p.add(chunk);
       p.setAlignment(0);//设置段落居左
       document.add(p);
       
       p = convertParToChinese1("乙方（受让人）:", f10,0);
       chunk = convertChunkByChinesexiahua("                             ", f10);
       p.add(chunk);
       p.add(chunk);       
       p.setAlignment(0);//设置段落居左  
       document.add(p);
       
       p = convertParToChinese1("富元汇用户名:", f10,0);
       chunk = convertChunkByChinesexiahua("                            ", f10);
       p.add(chunk);
       p.setAlignment(0);//设置段落居左
       document.add(p);      
       
       p = convertParToChinese1("身份证号码:", f10,0);
       chunk = convertChunkByChinesexiahua("                           ", f10);
       p.add(chunk);
       p.setAlignment(0);//设置段落居左
       document.add(p);

       
       p = convertParToChinese1("丙方（居间服务人）：", f10,0);
       chunk = convertChunkByChinesexiahua("深圳富之富信息技术有限公司", f10);
       p.add(chunk);
       p.setAlignment(0);//设置段落居左
       document.add(p);
       
       
       p = convertParToChinese1("客服电话：", f10,0);
       chunk = convertChunkByChinesexiahua("4009-303-606", f10);
       p.add(chunk);
       p.setAlignment(0);//设置段落居左
       document.add(p);
       
       p = convertParToChinese1("鉴于：", f10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);       
       
       p = convertParToChinese1("1、甲方作为贷款人以其合法资金向借款人提供贷款，签订编号为", ff10,0);
       chunk = convertChunkByChinesexiahua("                              ", ff10);
       p.add(chunk);
       chunk = convertChunkByChinese1("《借款合同》，对借款人享有《借款合同》项下的债权。", ff10);
       p.add(chunk);       
       p.setAlignment(0);//设置段落       
       
       p.setAlignment(0);//设置段落居左
       document.add(p);   
       
       p = convertParToChinese1("2、乙方系居住在中华人民共和国境内、具有完全民事行为能力的自然人,已在“富元汇网站”注册成为用户。乙方拟受让上述债权以获得债权相应的收益。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);   
       
       p = convertParToChinese1("3、 丙方是一家在中国深圳市合法成立并有效存续的有限责任公司，运营管理“富元汇”网站，网址: ", ff10,0);
       chunk = convertChunkByChinesexiahua("http://tfuyhui.fujfu.com/", ff10);
       p.add(chunk);
       chunk = convertChunkByChinese1("（以下简称“富元汇网站”），为本次债权转让交易提供居间服务。", ff10);
       p.add(chunk);       
       p.setAlignment(0);//设置段落居左
       document.add(p);       
       
       p = convertParToChinese1("4、甲方拟通过丙方的居间服务向乙方转让债权,甲、乙、丙三方本着平等自愿、诚实信用的原则，根据《中华人民共和国合同法》等相关法律法规及其他规范性文件的规定，就甲方向乙方转让上述债权，丙方为债权转让事宜提供居间服务等订立本协议，以兹共同遵守。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);             

       
       document.add(new Chunk("\n"));// 换行
       p = convertParToChinese1("第一条  释义", f10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);              

       p = convertParToChinese1("1.1  转让人：指本协议的甲方，其愿意将合法持有的债权转让给乙方。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);                 
       
       p = convertParToChinese1("1.2  受让人：指本协议中的乙方，其愿意以自有资金购买甲方转让的债权。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);     
       
       p = convertParToChinese1("1.3  居间人：指本协议中的丙方，为本债权转让交易提供居间服务。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);         
       
       p = convertParToChinese1("1.4  原债权：指作为本协议标的转让的债权、担保权利以及由此派生或与此相关的其他权益的统称。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);  
       
       p = convertParToChinese1("1.5  担保权利：指与原债权相关的保证担保权、抵押权、质押权等附属权利。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);
       
       p = convertParToChinese1("1.6  债权转让金额：指乙方受让甲方债权所应支付的款项金额。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);   
       
       p = convertParToChinese1("1.7  债权转让日期：指债权转移之日，以乙方受让债权的资金到达甲方在第三方支付托管户为准。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);   
       
       p = convertParToChinese1("1.8  债权回购：指在本协议约定条件下，甲方将乙方受让之债权购回。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);     
       
       p = convertParToChinese1("1.9  债权回购日：指甲方将乙方受让之债权购回之日，在债权回购之日起3个自然日（含）内甲方向乙方支付回购款的不视为违约，在此期间乙方同意甲方无需支付期间利息及违约金。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);      
       
       p = convertParToChinese1("1.10 预期年化收益：指乙方因受让甲方债权而预测未来获得的回报，该回报换算成年收益来计算。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);              
       
       p = convertParToChinese1("1.11 风险：指乙方受让债权后，由于各种主观、客观原因、导致预期收益不能实现的可能性。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);          
       
       
       document.add(new Chunk("\n"));// 换行
       p = convertParToChinese1("第二条  转让债权明细", f10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p); 

       p = convertParToChinese1("2.1  债权转让信息", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);    
       
       document.add(new Chunk("\n"));// 换行 
       PdfPTable table = new PdfPTable(2); // 设置表格有多少列
       table.setWidthPercentage(80); // 设置每一列所占的长度
       table.setHorizontalAlignment(Element.ALIGN_CENTER);
	   table.setWidths(new float[] { 20f, 50f});
	   PdfPCell cell = new PdfPCell();
	   cell.setHorizontalAlignment(Element.ALIGN_LEFT); 
       // 表格标题
       cell.setPhrase(new Paragraph("债权转让金额", f10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("债权转让期限", f10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("预期年化收益", f10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("收益起算日", f10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("", ff10));
       table.addCell(cell);
	   document.add(table);   
       

       p = convertParToChinese1("2.2 回购列表", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p); 
       
       document.add(new Chunk("\n"));// 换行 
       table = new PdfPTable(4); // 设置表格有多少列
       table.setWidthPercentage(80); // 设置每一列所占的长度
       table.setHorizontalAlignment(Element.ALIGN_CENTER);
	   table.setWidths(new float[] { 40f, 40f,40f,40f});
		
	   cell.setHorizontalAlignment(Element.ALIGN_LEFT); 
	   cell.setPhrase(new Paragraph("回购期数", f10));
	   table.addCell(cell);
	   cell.setPhrase(new Paragraph("回购日期", f10));
	   table.addCell(cell);
	   cell.setPhrase(new Paragraph("回购本金", f10));
	   table.addCell(cell);
	   cell.setPhrase(new Paragraph("预期收益金额", f10));
	   table.addCell(cell);
	   cell.setPhrase(new Paragraph(" ", f10));
	   table.addCell(cell);
	   cell.setPhrase(new Paragraph(" ", f10));
	   table.addCell(cell);
	   cell.setPhrase(new Paragraph(" ", f10));
	   table.addCell(cell);
	   cell.setPhrase(new Paragraph(" ", f10));
	   table.addCell(cell);	   
	   document.add(table); 
       
       document.add(new Chunk("\n"));// 换行
       p = convertParToChinese1("第三条  债权的转让", f10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);                
       
       p = convertParToChinese1("3.2  除本协议另有约定外，自债权转让日起（包括该转让日），甲方基于原债权所享有的债权及其附属的一切权利、利益均转让给乙方，该等权利、利益包括但不限于：", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);  
       
       p = convertParToChinese1("  (1)  原债权的全部所有权和相关权益（包括但不限于担保权益以及其他权利或利益）；", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);          

       p = convertParToChinese1("  (2)  原债权相关的滞纳金、违约金及延期补偿金等的权利；", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);                 

       
       p = convertParToChinese1("  (3)  获得原债权被转让、被出售、被拍卖、被变卖或者被以其他方式处置所获得的全部款项的权利；", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);   
       
       p = convertParToChinese1("  (4)  以诉讼或其他形式请求、收回、接受与原债权相关的全部应偿付款项的权利；", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);  
       
       p = convertParToChinese1("  3.3  甲乙双方一致确认，乙方根据本协议约定受让债权，按《借款合同》约定与原债权有关的任何义务和责任（如有）均由乙方承担，甲方对此不再承担任何责任。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);           
       
       p = convertParToChinese1("  3.4  甲乙双方不可撤销地授权第三方支付机构提交本债权交易资金划转结算等服务，本协议项下提供前述服务的第三方支付机构为上海富友支付服务有限公司。乙方授权第三方支付机构将本协议第2.1条所列的“债权转让金额”同等金额划转、支付至甲方的第三方支付账户，上述债权款项划转完成即视为本协议生效且债权转让成功。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);    
       
       document.add(new Chunk("\n"));// 换行
       p = convertParToChinese1("第四条  债权回购", f10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);       
       
       
       p = convertParToChinese1("4.1  债权转让成功后，甲方按本协议2.2条约定的回购日期、回购金额等对转让给乙方的债权予以回购。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p); 
       
       p = convertParToChinese1("4.2  乙方同意并确认，本协议2.2条约定的回购日期之日起三个自然日（含）内甲方向乙方支付回购本金及收益的不视为逾期，上述期间甲方无须向乙方支付收益、逾期费用等款项。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);   
       
       p = convertParToChinese1("4.3  甲方按本协议约定对转让债权予以回购，并向乙方支付回购本金及收益后视为乙方将受让债权重新转让回给甲方，甲方即成为债权的权利人，乙方不得再向甲方提出任何请求和主张，并配合甲方完成对债务人的相关通知义务。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p); 
       
       document.add(new Chunk("\n"));// 换行
       p = convertParToChinese1("第五条  各方权利和义务", f10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);       
              
       p = convertParToChinese1("5.1   甲方权利和义务", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);        
       
       p = convertParToChinese1("5.1.1 甲方有权通过富元汇网站将债权转让且与乙方签订债权转让协议，将所持有的债权转让给乙方。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p); 
       
       p = convertParToChinese1("5.1.2 甲方保证本协议项下转让的债权真实、合法、有效，不存在任何权利瑕疵、转让限制。否则，甲方承担由此而引起的所有经济和法律责任。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);       

       p = convertParToChinese1("5.1.3 甲方转让的债权的债务人提前偿还债务的,则乙方有权要求甲方按本协议约定的条件提前回购债权,向乙方支付的收益截止至回购当日。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);   
       
       p = convertParToChinese1("5.1.4 甲方应履行本协议第4.1条约定之回购义务，除4.2条约定外逾期则按逾期金额的每日万分之三之标准向乙方支付逾期费用。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);         
       
       p = convertParToChinese1("5.1.5 甲方按富元汇网站的相关规则、公告向丙方支付服务费。甲方不可撤销的授权第三方支付机构可从甲方的第三方支付账户中直接划扣服务费对应金额至丙方第三方支付账户。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p); 

       
       
       p = convertParToChinese1("5.2   乙方权利和义务", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);  
       
       p = convertParToChinese1("5.2.1 乙方保证其受让债权的资金来源合法，且是该资金的合法所有人，如果第三人对资金归属、合法性问题发生争议，由乙方负责解决。如乙方未能解决，则一切后果自行承担。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);        
       
       p = convertParToChinese1("5.2.2 乙方保证其具有独立的风险承受能力，对本次债权的转让结构和可能存在的风险已经理解并表示认可。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);               

       p = convertParToChinese1("5.2.3 自债权转让之日起，乙方有权依法行使原债权中甲方享有的一切主、从权利，包括但不限于转让债权请求权，与债权有关的担保权益及相应的受偿权、收益权等。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);           
       
       p = convertParToChinese1("5.2.4 乙方应主动缴纳因收益产生的可能的税费。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);  
       
       p = convertParToChinese1("5.2.5 乙方按富元汇网站的相关规则、公告向丙方支付服务费。乙方不可撤销的授权第三方支付机构可从乙方的第三方支付账户中直接划扣服务费对应金额至丙方第三方支付账户。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);         

       p = convertParToChinese1("5.3   丙方权利和义务", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p); 
       
       p = convertParToChinese1("5.3.1 丙方应按照本协议的约定，格尽职守，以诚信、严瑾、有效管理的原则为甲方、乙方提供服务。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);              

       p = convertParToChinese1("5.3.2 丙方有权为所提供的服务向甲方、乙方收取服务费，各项费用收费标准以富元汇网站的规则、公告为准，丙方有权随时调整本服务至各项费用，调整后将于富元汇网站公布，自发布之日起生效。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);
       
       p = convertParToChinese1("5.3.3 丙方对富元汇网站上发布债权转让项目，均以转让人提供信息的合法性及真实性为前提，并不对债权转让项目的瑕疵及最终风险向任何人承担任何责任。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);    
       
       p = convertParToChinese1("5.3.4 丙方受甲乙双方委托，为其提供债权转让服务，其行为产生的一切后果均由委托方承担，丙方不承担任何责任。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);  
       
       p = convertParToChinese1("5.3.5 受各方委托，丙方负责保管债权凭证及相关文件资料。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);
       
       document.add(new Chunk("\n"));// 换行
       p = convertParToChinese1("第六条  债权转让通知", f10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);         
       
       p = convertParToChinese1("经充分了解本债权转让交易的特性及风险，本协议各方同意债权转让通知在甲方未按本协议4.1条约定进行债权回购的次日由甲方或甲方授权丙方向原债权的债务人发送债权转让通知书。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);       
       
       
       document.add(new Chunk("\n"));// 换行
       p = convertParToChinese1("第七条  违约", f10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p); 
       
       p = convertParToChinese1("7.1  在本协议有效期内，一方违反本协议之任何条款，致使相关方遭受损失时，违约方须赔偿相关损失方因此遭受的一切经济损失（包括但不限于诉讼/仲裁费用、律师费用、交通费、差旅费、公证费及其他实现债权所产生的费用等）。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);     
       
       p = convertParToChinese1("7.2  各方均有过错的，应根据实际过错程度，分别承担各自的违约责任。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);

       
       document.add(new Chunk("\n"));// 换行
       p = convertParToChinese1("第八条  适用法律和争议解决", f10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);    
       
       p = convertParToChinese1("8.1  本协议的订立、变更、执行和解释，以及与本协议有关的争议解决，均应适用中华人民共和国法律。如与本协议有关的某一特定事项没有法律规定或规定不明确，则应参照通用的国际商业惯例和行业惯例。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p); 
       
       p = convertParToChinese1("8.2  如因本协议履行过程中各方发生的任何争议，如协商不成，应向丙方所在地有管辖权的法院起诉。争议期间，各方仍应继续履行本协议未涉争议的条款义务。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);  
       
       document.add(new Chunk("\n"));// 换行
       p = convertParToChinese1("第九条 其他", f10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);          
       
       p = convertParToChinese1("9.1  各方均确认通过富元汇网站对本协议相关条款进行确认以勾选的方式签署，各方认可其效力，并同意无需加盖电子签章。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p); 
       
       p = convertParToChinese1("9.2  富元汇网站债权转让相关规则为本协议的有益补充，与本协议具有同等法律效力,甲乙双方均表示已阅读并同意上述规则。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);     
       
       p = convertParToChinese1("9.3  各方委托丙方保管所有与本协议有关的书面文件或电子信息。若甲、乙方出示的书面文件或电子信息与丙方提供的书面文件或电子信息不一致，均以丙方提供的书面文件或电子信息为准。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);  
       
       p = convertParToChinese1("9.4  本协议与原债权《借款合同》不可分割，任何本协议无约定之事项均应适用《借款合同》之约定。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);                
       
       p = convertParToChinese1("9.5  本协议中部分条款根据相关法律法规的规定成为无效，或部分无效时，该等无效不影响本协议项下其他条款的效力，各方仍应履行其在本协议项下的义务。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);    
       
       p = convertParToChinese1("9.5  本协议中部分条款根据相关法律法规的规定成为无效，或部分无效时，该等无效不影响本协议项下其他条款的效力，各方仍应履行其在本协议项下的义务。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);   
       
       p = convertParToChinese1("9.6   丙方对本协议享有最终的解释权。", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);     
       
       document.add(new Chunk("\n"));// 换行       
       p = convertParToChinese1("签署方：", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);                
       document.add(new Chunk("\n"));// 换行
       
       p = convertParToChinese1("甲方：深圳市富龙小额贷款有限公司", ff10,0);
       p.setAlignment(0);//设置段落居左 
       
       
       String absolutePath = PropertyFileUtil.getProperty("filePath")+File.separator+"stamp/";
       
       Image image = writeImg(absolutePath + "407699692726245986.png");
       p.add(image);
       document.add(p);      
          
       
       document.add(new Chunk("\n"));// 换行
       
       p = convertParToChinese1("乙方：", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);       
       document.add(new Chunk("\n"));// 换行
       
       
       p = convertParToChinese1("丙方：深圳富之富信息技术有限公司", ff10,0);
       p.setAlignment(0);//设置段落居左
       image = writeImg(absolutePath+"195914838390966555.png");
       p.add(image);
       document.add(p);         
       
       
       document.add(new Chunk("\n"));// 换行
       
       p = convertParToChinese1("日期： 年  月 日", ff10,0);
       p.setAlignment(0);//设置段落居左
       
       
       
       
       document.add(p);           
       
	   document.close();
			
	}	
	
	
	public static void main(String[] args) throws Exception {

		CreProductPdf creContrPdf = new CreProductPdf();
		LoanApplyVO loanApply =new LoanApplyVO();
		loanApply.setLoanTime(1462464000);
		loanApply.setAmount(new BigDecimal("10000"));
		loanApply.setApr(10f);
		loanApply.setPaymentOptions(1);
		loanApply.setPeriod(3);
		loanApply.setStartTime(1462464000);
		loanApply.setEndTime(1462464000);
		loanApply.setMtime(1462464000);
		loanApply.setProductManager("阿虎发怒给");
		loanApply.setGuaranteeMode("afsd");
		loanApply.setDescription("很好的公司哦");
		UserVO investuser=new UserVO();
		investuser.setUserId(10000010);
		investuser.setRealname("范坚强");
		investuser.setCardId("4231231451234123123123412");
		UserVO loadApplyUser = new UserVO();
		loadApplyUser.setRealname("金华有限公司");
		LoanInvestmentVO invest=new LoanInvestmentVO();
		invest.setUserId(10000010);
		invest.setMoney(new BigDecimal("10000"));
		UserVO GuaranUser = new UserVO();
		GuaranUser.setUsername("担保公司1");
		ApplyRecoverVO applyRecover =new ApplyRecoverVO();
		List<ApplyRecoverVO> applyRecoverList = new ArrayList<ApplyRecoverVO>();
		for(int i=0;i<8;i++){
			applyRecover.setRecoverReqTime(1462464000);
			applyRecover.setRecoverCapital(new BigDecimal("10000"));
			applyRecover.setRecoverInterest(new BigDecimal("10"));
			applyRecover.setRecoverMoney(new BigDecimal("10010"));
			applyRecoverList.add(applyRecover);
		}
		
		creContrPdf.writePdf2("D://all.pdf","安心投",loanApply,loadApplyUser,GuaranUser);
	}

}
