package com.fujfu.common.util;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fujfu.pojo.apply.ApplyRecoverVO;
import com.fujfu.pojo.invest.LoanInvestmentVO;
import com.fujfu.pojo.loan.LoanApplyVO;
import com.fujfu.pojo.user.UserVO;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CreContrPdftemplate extends PDFDemo{
	/*
	 * 生成投资产品合同
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
       //正文标题
       Font f10 = new Font(bfChinese, 10, bold, black);
       // 正文字体
       Font ff10 = new Font(bfChinese, 10, Font.NORMAL, black);
       //Font fff10 = new Font(bfChinese, 10, bold, black);
       Font f8 = new Font(bfChinese, 8, Font.NORMAL, black);
      
       document.open();
		//标题     
       Paragraph head1 = convertParToChinese1("投资人开户申请", f15,0);
       head1.setAlignment(1);//设置段落居中
       head1.setSpacingAfter(10);  
       document.add(head1);
       
       document.add(convertParToChinese1("致：青岛国富金融资产交易中心有限公司", f10,0));
       
       Paragraph p = convertParToChinese1("本人已通过【深圳市富之富信息技术有限公司】相关测试或调研，确认自己具备青岛国富金融资产交易中心有限公司（下称“贵中心”）参与交易的投资人资格，特申请开设投资交易账户。", ff10,setting);
       p.setAlignment(0);//设置段落居左
       p.setFirstLineIndent(setting); // 首行缩进参数
       document.add(p);
       
       p=convertParToChinese1("一、本人在此申请成为贵中心参与交易的合格投资者。", f10,setting);
       document.add(p);
       p=convertParToChinese1("二、本申请人在此申明及承诺：", f10,setting);
       document.add(p);
       p=convertParToChinese1("1.本申请是本人真实意思表示，同意按照贵中心要求提交申请所需资料，并确认所提交材料及本申请中的内容不存在虚假记载、误导性陈述或重大遗漏，本人对其真实性、准确性、完整性、有效性承担相应的法律责任；",ff10,setting);
       document.add(p);
       p=convertParToChinese1("2.本人承诺自觉遵守法律、法规、规章及贵中心相关业务的各项规则和制度；",ff10,setting);
       document.add(p);
       p=convertParToChinese1("3.【深圳市富之富信息技术有限公司】已向本人告知贵中心的各项规则和制度，本人确认已充分理解贵中心挂牌的相关产品投资可能蕴含的各种风险。本人确认：参与在贵中心挂牌产品的认购和交易，无论盈利或亏损均由本人自行承担；",ff10,setting);
       document.add(p);
       p=convertParToChinese1("4.本人同意，为适应法律、法规、规章及监管政策的调整、变化，贵中心有权对相关投资者管理规定及交易规则进行变更；",ff10,setting);
       document.add(p);
       p=convertParToChinese1("5.本人承诺因密码失密、操作不当、决策失误等原因可能到时的亏损，或委托他人代理操作可能造成的损失，都由本人自行承担。",ff10,setting);
       document.add(p);
       p=convertParToChinese1("本人保证遵守上述声明与承诺，在本人作为贵交易中心的合格投资者期间持续有效。如违反上述承诺或有违法、违规行为，给交易相关方或贵交易中心造成损失的，本人愿意承担法律责任及相应的经济赔偿责任。",ff10,setting);
       document.add(p);
       p=convertParToChinese1("三、权利与义务：", f10,setting);
       document.add(p);
       p=convertParToChinese1("本人已理解并认可本次拟认购产品相关需签署协议约定的投资者所享有的权利和应履行的义务，承诺执行相关约定及贵中心相关规范性文件。",ff10,setting);
       document.add(p);
       p=convertParToChinese1("四、开设交易账户申请", f10,setting);
       document.add(p);
       p=convertParToChinese1("本人同意签署《投资者开户申请》，同意并理解《投资者开户申请》中本人所作出的声明和承诺。",ff10,setting);
       document.add(p);
       p=convertParToChinese1("注：本人对上述未提出疑义视为同意加入并已成为青金所可参与交易的合格投资者。", f10,setting);
       document.add(p);
       document.add(new Chunk("\n\n"));// 换行
       
       //风险认知书--------------------------------------------------------------------------------------
     //标题     
       head1 = convertParToChinese1("青岛国富金融资产交易中心有限公司合格投资者风险认知书", f15,0);
       head1.setAlignment(1);//设置段落居中
       head1.setSpacingAfter(10);  
       document.add(head1);
       //加入参数全称产品
       p=convertParToChinese2("投资者在参与投资认购产品","前，应当仔细核对自身是否符合当前产品要求的合格投资者资格条件，并充分了解拟投资认购产品的特点及风险，审慎评估自身的经济状况和财务能力，考虑是否适合参与投资认购，具体包括:","                       ",ff10,setting);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       p=convertParToChinese1("一、产品在青岛国富金融资产交易中心有限公司（以下简称“本交易中心”）备案登记、信息披露、挂牌发行、投资交易，交易结算，（上述事项本交易中心可委托相应渠道或服务机构代为处理，受托机构在委托事项范围内产生的一切行为及后果由本交易所负责）但本交易中心并不对产品的基础资产可产生的未来现金流进行任何形式的保证与承诺，亦不对发行人的经营风险、偿付风险、诉讼风险以及产品的投资风险或收益等作出任何判断或保证。", ff10,setting);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       p=convertParToChinese1("二、投资者投资交易前，应当认真阅读拟投资认购产品的相关产品募集说明书及有关的产品信息披露文件，对拟投资认购的产品信息披露的真实性、准确性、完整性和及时性进行独立分析，并据以独立判断产品的投资价值，自行承担投资风险。", ff10,setting);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       p=convertParToChinese1("三、投资者应当认真阅读拟投资认购产品的相关产品募集说明书，充分关注拟投资认购产品的基础资产状况、实际融资人的经营风险以及可能的兑付风险。如相关产品募集说明书约定产品为可交易转让产品，由于产品的转让可能不活跃，投资者应当充分关注并知晓产品可能存在无法转让或无法随时转让的风险。", ff10,setting);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       p=convertParToChinese1("四、投资者应当充分了解产品可能存在因投资者自身认购资格、投资者逾期缴付认购款项、以及产品认购额度届满等因素导致投资者未能认购成功的风险。", ff10,setting);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       p=convertParToChinese1("五、投资者应当理解并同意，本交易中心作为产品相关交易的结算机构，如投资者认购产品的相应渠道所披露的信息中约定投资者需要向相关产品交易服务机构支付相关服务费用的，本交易中心在向投资者划付产品兑付款项时，可预先从兑付款项中扣除上述服务费用。", ff10,setting);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       p=convertParToChinese1("六、投资者应当充分关注产品可能存在的法律风险，如产品协议内容包括的法律关系及资产交易模式对应的与此相关的法律、法规和配套制度尚待完善，并且投资者持有该产品期间相关的法律、法规和配套制度发生修改、变化或制定并颁布新的法律法规及配套规章制度，可能会对产品投资者的权益产生影响。", ff10,setting);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       p=convertParToChinese1("七、本风险认知书的风险揭示事项未能详尽列明投资者拟投资认购产品的投资交易可能产生的所有风险，投资者应对其它相关风险因素也有所了解和掌握，并确信已做好足够的风险评估与财务安排，避免因参与投资认购产品而遭受难以承受的损失。", ff10,setting);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       p=convertParToChinese1(" 投资者签署栏:", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       //加入投资人姓名
       p=convertParToChinese2("本人","对上述《青岛国富金融资产交易中心有限公司合格投资者风险认知书》的内容已经充分理解，承诺本人已阅读产品披露的相关信息，并充分理解和认识产品存在的相关风险，且具备当前拟投资认购产品的合格投资者资格条件。", "                       ",ff10,setting);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       p=convertParToChinese1("本人愿意参与产品的投资认购，并愿意独立承担产品的投资认购风险。", ff10,setting);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       p=convertParToChinese1("特此声明", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       //加入投资人姓名
       p=convertParToChinese2("投资者全称：","","                       ", ff10,250);
       document.add(p);
       //加入投资日期
       p=convertParToChinese2("日      期：  ","","    年       月       日", ff10,250);
       document.add(p);
       document.add(new Chunk("\n"));// 换行 
     //金融产品认购协议--------------------------------------------------------------------------------------
       //标题     
       head1 = convertParToChinese1("金融产品认购协议", f15,0);
       head1.setAlignment(1);//设置段落居中
       head1.setSpacingAfter(10);  
       document.add(head1);
       //加入产品全称
       p=convertParToChinese2("为了明确产品","（以下简称“本产品”）的发行人、认购人的权利义务，保护本产品认购人的合法权益，依据《中华人民共和国民法通则》、《中华人民共和国合同法》、及其他法律法规的有关规定，发行人与认购人本着诚实守信、平等互利、意思表示真实的原则，就本产品认购的有关事宜达成如下协议：","                       ", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       head1 = convertParToChinese1("认购协议通用条款", ff10,0);
       head1.setAlignment(1);//设置段落居中
       head1.setSpacingAfter(10);  
       document.add(head1);
       p=convertParToChinese1("一、定义", ff10,0);
       document.add(p);
       p=convertParToChinese1("在本产品认购协议中，下列术语具有如下含义：", ff10,0);
       document.add(p);
       p=convertParToChinese1("1、“本协议”指本产品认购协议，本协议包括“认购协议通用条款”、 “产品募集说明书”、“合格投资者风险认知书”等。", ff10,0);
       document.add(p);
       //此处加入发行人机构全称（对应我们平台的融资方字段）
       p=convertParToChinese2("2、“发行人”指","。发行人是在中国境内依法成立的企业法人，并根据其公司章程的规定，经其有权机构相关授权，同意发行人通过青岛国富金融资产交易中心有限公司（以下简称“青金所”）备案、挂牌发行本产品。","                       ", ff10,0);
       document.add(p);
       p=convertParToChinese1("3、“基础资产”指发行人依法持有的资产，并有权转让、处置该等资产及其相关权利。发行人以基础资产的未来现金流（下称“预期收益”）为偿付支持发行本产品。", ff10,0);
       document.add(p);
       p=convertParToChinese1("4、“认购人”指按照青金所资产支持类收益权产品发行业务交易细则规定以及产品募集说明书等规定的认购规则，认购本产品的合格投资者。认购人应在青金所或青金所指定产品认购渠道合作方平台注册登记，拥有青金所交易账户。", ff10,0);
       document.add(p);
       p=convertParToChinese1("5、“持有人”指按照资产支持类收益权产品发行业务交易细则以及产品募集说明书，在本产品成立后认购及/或最终持有本产品的合格投资者。", ff10,0);
       document.add(p);
       //此处加入产品管理人全称
       p=convertParToChinese2("6、“产品管理人”指受发行人委托，为本产品持有人之利益，在本产品整个产品周期内对本产品进行管理、监督并履行其他法定及约定职责的具备资产管理能力的专业机构。发行人已聘请","为本产品的产品管理人并签订相关受托管理或服务协议。","                       ", ff10,0);
       document.add(p);
       p=convertParToChinese1("7、“收益起算日”指本产品成立后，按照一定利率开始计算持有人持有产品利益收益的时间。", ff10,0);
       document.add(p);
       p=convertParToChinese1("8、青金所交易平台：全称“青金所资产交易平台”，是指青金所为合格投资者开展投资交易活动提供的交易系统。", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       p=convertParToChinese1("二、本产品的基本概况", ff10,0);
       document.add(p);
       p=convertParToChinese1("本产品的基本概况以认购人通过青金所指定认购渠道（以下简称“指定认购渠道”）获得的发行人向其披露的《产品募集说明书》（以下简称“《产品募集说明书》”）载明的内容及本产品相关认购信息为准。认购人在认购本产品并签订本协议之前，应当认真阅读并已充分了解《产品募集说明书》全部内容。", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       p=convertParToChinese1("三、认购方式及持有确认", ff10,0);
       document.add(p);
       p=convertParToChinese1("1、认购人应按指定认购渠道披露或规定的认购期间、认购起点金额等认购规则进行本产品的认购。", ff10,0);
       document.add(p);
       p=convertParToChinese1("2、认购人同意并授权青金所于收益起算日起对认购人持有的本产品予以登记托管。", ff10,0);
       document.add(p);
       p=convertParToChinese1("3、本产品发行成功后，认购人成功认购的金额以收益起算日认购人于交易账户中经青金所或指定认购渠道登记的本产品实际交易金额为准。认购人可通过指定认购渠道查看其持有的本产品信息或向青金所申请出具持有凭证。", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行
       p=convertParToChinese1("四、声明与承诺", ff10,0);
       document.add(p);
       p=convertParToChinese1("1、发行人已取得发行本产品及签署（或发出不可撤销的本协议要约）、履行本协议的一切必要的授权和批准，同意签署（或发出不可撤销的本协议要约）并履行本协议。", ff10,0);
       document.add(p);
       p=convertParToChinese1("2、认购人若为机构的，则已取得了签署（或对于本协议要约做出承诺）、履行本协议的一切内部外部授权和批准，同意签署（或对于本协议要约做出承诺）并履行本协议；认购人若为自然人的，则其应具有完全的民事权利能力和民事行为能力，并完全基于本人真实意思表示签署（或对于本协议要约做出承诺）并履行本协议。", ff10,0);
       document.add(p);
       p=convertParToChinese1("3、发行人承诺对本产品发行所依托的基础资产享有合法权利，且发行行为属于其权利范围。", ff10,0);
       document.add(p);
       p=convertParToChinese1("4、发行人承诺，根据相关法律法规、监管部门及青金所相关规定，本产品基础资产具备发行金融产品的全部条件。", ff10,0);
       document.add(p);
       p=convertParToChinese1("5、发行人和认购人承诺并保证本协议的签署(或发出不可撤销的本协议要约／对本协议要约做出承诺)和履行不违反任何现行中国法律、法规的规定，上述行为不损害其他第三方的合法权益，并不与任何法律或一方所承担的义务和责任相冲突。", ff10,0);
       document.add(p);
       p=convertParToChinese1("6、发行人和认购人承诺提供给对方及青金所的所有材料及相关信息资料均真实、完整、准确、合法。", ff10,0);
       document.add(p);
       p=convertParToChinese1("7、认购人承诺具备青金所资产支持类收益权产品发行业务交易细则和产品募集说明书规定的合格投资者条件，其用于认购本产品的资金来源合法合规。", ff10,0);
       document.add(p);
       p=convertParToChinese1("8、认购人认可发行人为本产品所聘任的产品管理人，同意并授权产品管理人代其监督、管理本产品存续期内发行人对基础资产的运营及对本产品的管理。", ff10,0);
       document.add(p);
       p=convertParToChinese1("9、发行人承诺本产品基础资产所产生的全部预期收益应根据《产品募集说明书》的约定优先用于按时足额兑付本产品持有人的本金及到期收益，如预期收益不足以按时足额兑付时，发行人应以其自有资金或其他资金、资产等予以补足应兑付的本产品的本金及收益部分。", ff10,0);
       document.add(p);
       p=convertParToChinese1("10、本协议可采用纸质文本制成或电子文本生成，并具有同等效力，认购人签署或确认本协议即视为已认真阅读本协议通用条款、产品募集说明书及合格投资者风险认知书，并同意本协议及产品募集说明书中关于本产品及本产品认购人/持有人的所有约定，并对本产品的客观投资风险有明确的认知及承受能力。", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行

       p=convertParToChinese1("五、发行人的权利和义务", ff10,0);
       document.add(p);
       p=convertParToChinese1("1、根据法律法规规定、本协议及其他相关协议的约定享有使用本产品所募集认购资金的权利。", ff10,0);
       document.add(p);
       p=convertParToChinese1("2、发行人应本着最大诚信原则，维护基础资产及基础资产预期收益的安全，保证本协议约定本金及利息按时足额兑付。", ff10,0);
       document.add(p);
       p=convertParToChinese1("3、本产品对应的基础资产预期收益不足以兑付或不能按时兑付利息及本金时，按本协议的约定以发行人其他自有资金向本产品持有人履行兑付义务。", ff10,0);
       document.add(p);
       p=convertParToChinese1("4、按照青金所资产支持类收益权产品发行业务相关管理规定，对在本产品存续期间发生的可能影响基础资产价值、基础资产预期收益或发行人偿债能力的重大事项，及时委托产品管理人通过青金所交易平台或其他青金所指定的认购渠道向本产品持有人进行披露并根据青金所要求提供相关真实、完整、准确、合法的书面文件。", ff10,0);
       document.add(p);
       p=convertParToChinese1("5、依据法律法规、青金所资产支持类收益权产品发行业务管理规定、本协议及其他与本产品发行相关协议的约定，自行承担因发行本产品需缴纳的各项税费。", ff10,0);
       document.add(p);
       p=convertParToChinese1("6、依据法律法规、青金所资产支持类收益权产品发行业务管理规定、本协议及其他与本产品发行相关协议的约定，享有或承担的其他权利或义务。", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行

       p=convertParToChinese1("六、认购人的权利和义务", ff10,0);
       document.add(p);
       p=convertParToChinese1("1、根据本协议约定的认购规则认购本产品；", ff10,0);
       document.add(p);
       p=convertParToChinese1("2、根据本协议约定其成功认购本产品后投资到期回收本金和相应预期收益的权利；", ff10,0);
       document.add(p);
       p=convertParToChinese1("3、根据本协议约定进行本产品转让交易的权利；", ff10,0);
       document.add(p);
       p=convertParToChinese1("4、当发生利益可能受到损害的事项时，有权依据法律、法规的规定以及本协议约定行使本产品持有人的权利；", ff10,0);
       document.add(p);
       p=convertParToChinese1("5、依据法律法规、青金所资产支持类收益权产品发行业务相关管理规定、本协议的相关约定，自行承担因认购和转让本产品需缴纳的各项税费。", ff10,0);
       document.add(p);
       p=convertParToChinese1("6、依据法律法规及青金所相关业务管理规定、本协议约定，享有或承担的其他权利或义务。", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行        
       p=convertParToChinese1("七、违约责任", ff10,0);
       document.add(p);
       p=convertParToChinese1("本产品对应的基础资产预期收益不足以兑付或不能按时兑付本产品认购人到期收益或本金时，或发行人未能按约定偿付本产品到期收益及本金的，或发行人发生其他违约情况时，发行人应承担违约责任。发行人承担的违约责任范围包括偿付本产品持有人的本金及收益、支付罚息、赔偿本产品持有人因发行人违约受到的损失、以及本产品持有人为主张权利发生的全部费用（包括但不限于：律师费、诉讼费、执行费用等）和其他应支付的费用。任何一方违反本协议项下的约定，应负责消除不利影响，并赔偿由此给对方及青金所造成的全部损失（包括但不限于：主张权利时发生的律师费、诉讼费、执行费用等）。", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行        
       p=convertParToChinese1("八、保密", ff10,0);
       document.add(p);
       p=convertParToChinese1("发行人和认购人对因本协议的签署和履行获得的对方信息均负有保密义务，未经信息持有方同意，信息获取方不得向第三方泄露，但中国现行法律、法规另有规定的或对方书面同意的或按本协议约定向青金所披露的除外。", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行        
       p=convertParToChinese1("九、不可抗力", ff10,0);
       document.add(p);
       p=convertParToChinese1("1、任何一方因受不可抗力影响致使全部或部分不能履行本协议或延迟履行本协议，应自不可抗力事件发生之日起三个工作日内，将事件情况以书面形式通知另一方，并自事件发生之日起三十个工作日内，向另一方提交导致其全部或部分不能履行或迟延履行的有效证明。", ff10,0);
       document.add(p);
       p=convertParToChinese1("2、如果发生不可抗力事件，影响一方履行其在本协议项下的义务，则在不可抗力造成的延误期内中止履行，而不视为违约。", ff10,0);
       document.add(p);
       p=convertParToChinese1("3、遭受不可抗力的—方应采取一切必要措施减少损失，能继续履行的，在事件消除后立即恢复本协议的履行。不能履行的，经发行人和认购人协商一致后，可以终止本协议。", ff10,0);
       document.add(p);
       p=convertParToChinese1("4、本条所称“不可抗力”是指不能预见、不能克服、不能避免的客观事件，包括但不限于国家政策的重大变化、洪水、地震、火灾、风暴、瘟疫、战争、民众骚乱、罢工及银行划款系统失效等。", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行        
       p=convertParToChinese1("十、争议的解决", ff10,0);
       document.add(p);
       p=convertParToChinese1("凡因本产品的发行、认购、转让、受让、兑付等事项引起的或与本产品有关的任何争议，应首先通过协商解决。如果在接到要求解决争议的书面通知之日起30日内仍不能通过协商解决争议，任何一方均应向被告所在地有管辖权的人民法院提起诉讼。", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行        
       p=convertParToChinese1("十一、权利的保留", ff10,0);
       document.add(p);
       p=convertParToChinese1("1、任何一方没有行使其权利或没有就对方的违约行为采取任何行动，不应被视为对权利的放弃或对追究违约责任的放弃。任何一方放弃针对对方的任何权利或放弃追究对方的任何责任，不应视为放弃对对方任何其他权利或任何其他责任的追究。所有放弃应书面做出。", ff10,0);
       document.add(p);
       p=convertParToChinese1("2、如果本协议任何约定依现行法律被确定为无效或无法实施，本协议的其他条款将继续有效。此种情况下，发行人和认购人将以新的有效的约定替换被确定无效或无法实施的约定，且新的有效约定应尽可能接近原约定和本协议相应的精神和宗旨。", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行        
       p=convertParToChinese1("十二、生效条件", ff10,0);
       document.add(p);
       p=convertParToChinese1("本协议为发行人不可撤销的要约，认购人于本产品指定认购渠道披露的约定募集期届满前，实施下述任一行为即视为做出承诺，本协议于认购人做出承诺时生效：", ff10,0);
       document.add(p);
       p=convertParToChinese1("1、认购人通过指定认购渠道以网络在线点击的方式确认接受本协议内容；", ff10,0);
       document.add(p);
       p=convertParToChinese1("2、认购人线下单方签署本协议。", ff10,0);
       document.add(p);
       p=convertParToChinese1("本协议双方委托青金所或指定认购渠道保管所有与本协议有关的书面文件或在服务器上保存本协议相关的电子文本；本协议双方同意并确认由青金所提供的与本协议有关的书面文件或电子文本在无明显错误的情况下应作为本协议有关事项的终局证明。", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行               
       p=convertParToChinese1("十三、其他", ff10,0);
       document.add(p);
       p=convertParToChinese1("1、本协议双方同意并确认，本协议一方向另一方提供信息时均应同时将信息提供给青金所及指定认购渠道的服务机构（以下简称“服务机构”）。本协议双方授权青金所及服务机构根据本协议任何一方的合理要求向其提供本协议另一方向青金所或服务机构提供的所有信息。", ff10,0);
       document.add(p);
       p=convertParToChinese1("2、本协议双方同意并确认，发行人和认购人通过其交易/结算账户或认购人在指定认购渠道通过交易/认购账户采取的行为所产生的法律后果和法律责任归属于发行人和认购人本人；发行人和认购人授权并委托青金所根据本协议所采取的全部行动和措施的法律后果均归属于发行人和认购人本人，与青金所、指定认购渠道及服务机构无关，青金所、指定认购渠道及服务机构也不因此承担任何责任。", ff10,0);
       document.add(p);
       p=convertParToChinese1("3、本协议双方同意并确认，青金所有权按照青金所交易平台或指定认购渠道披露的本产品收费标准就其为发行人和认购人提供的服务收取交易服务费。发行人同意并授权青金所可以直接从本产品募集款项中扣收前述服务费，认购人同意并授权青金所可以直接从本产品兑付款项中扣收前述服务费。", ff10,0);
       document.add(p);
       p=convertParToChinese1("4、本产品计算应还本金及收益时，对人民币“分”以下（含“分”）金额采用截位法处理，即对“分”及分以下金额直接截除。", ff10,0);
       document.add(p);
       document.add(new Chunk("\n"));// 换行 
       //加入投资人姓名
       p=convertParToChinese2("认购人：  ","","                       ", ff10,250);
       document.add(p);
       //加入投资日期
       p=convertParToChinese2("协议生成日期：","","     年         月         日", ff10,250);
       document.add(p);
       document.add(new Chunk("\n"));// 换行 
       p=convertParToChinese1("", ff10,0);
       document.add(p);
       
       document.add(new Chunk("\n"));// 换行 
       
       //表格1---------------------------------------------------------------------------------
       p=convertParToChinese1("附件一：", ff10,0);
       document.add(p);
       p = convertParToChinese1("认购资产基本信息表", f10,0);
       p.setAlignment(1);//设置段落居中
       document.add(p);
       document.add(new Chunk("\n"));// 换行 
       PdfPTable table = new PdfPTable(2); // 设置表格有多少列
       table.setWidthPercentage(80); // 设置每一列所占的长度
       table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.setWidths(new float[] { 20f, 50f});
		PdfPCell cell = new PdfPCell();
		cell.setHorizontalAlignment(Element.ALIGN_LEFT); 
       // 表格标题
       cell.setPhrase(new Paragraph("产品名称", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("产品规模", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("预期年化收益", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("回款方式", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("产品期限", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("收益起算日", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("到期日", ff10));
       table.addCell(cell);
       cell.setPhrase(new Paragraph("", ff10));
       table.addCell(cell);
		document.add(table);
		
		 //表格2---------------------------------------------------------------------------------
		
		document.add(new Chunk("\n"));// 换行 
		p=convertParToChinese1("附件二：", ff10,0);
	    document.add(p);
	    p = convertParToChinese1("认购人资产份额登记表", f10,0);
       p.setAlignment(1);//设置段落居中
       document.add(p);
       document.add(new Chunk("\n"));// 换行 
       table = new PdfPTable(5); // 设置表格有多少列
       table.setWidthPercentage(80); // 设置每一列所占的长度
       table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.setWidths(new float[] { 20f, 20f,40f,60f,30f});
		
		cell.setHorizontalAlignment(Element.ALIGN_LEFT); 
		cell.setPhrase(new Paragraph("平台用户ID", ff10));
	    table.addCell(cell);
	    cell.setPhrase(new Paragraph("姓名", ff10));
	    table.addCell(cell);
	    cell.setPhrase(new Paragraph("证件号码", ff10));
	    table.addCell(cell);
	    cell.setPhrase(new Paragraph("产品名称", ff10));
	    table.addCell(cell);
	    cell.setPhrase(new Paragraph("持有资产总额", ff10));
	    table.addCell(cell);
	    
		    cell.setPhrase(new Paragraph("  ", ff10));
		    table.addCell(cell);
		    cell.setPhrase(new Paragraph("  ", ff10));
		    table.addCell(cell);
		    cell.setPhrase(new Paragraph("  ", ff10));
		    table.addCell(cell);
		    cell.setPhrase(new Paragraph("  ", ff10));
		    table.addCell(cell);
		    cell.setPhrase(new Paragraph("  ", ff10));
		    table.addCell(cell);
		document.add(table);

		//表格3---------------------------------------------------------------------------------
		document.add(new Chunk("\n"));// 换行 
		p=convertParToChinese1("附件三：", ff10,0);
	    document.add(p);
	    p = convertParToChinese1("回款计划表", f10,0);
       p.setAlignment(1);//设置段落居中
       document.add(p);
       document.add(new Chunk("\n"));// 换行 
       table = new PdfPTable(4); // 设置表格有多少列
       table.setWidthPercentage(80); // 设置每一列所占的长度
       table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.setWidths(new float[] { 20f, 20f,40f,20f});
		
		cell.setHorizontalAlignment(Element.ALIGN_LEFT); 
		cell.setPhrase(new Paragraph("回款日期", ff10));
	    table.addCell(cell);
	    cell.setPhrase(new Paragraph("应收本金", ff10));
	    table.addCell(cell);
	    cell.setPhrase(new Paragraph("应收收益", ff10));
	    table.addCell(cell);
	    cell.setPhrase(new Paragraph("应收总金额", ff10));
	    table.addCell(cell);
	    
	    	cell.setPhrase(new Paragraph("  ", ff10));
		    table.addCell(cell);
		    cell.setPhrase(new Paragraph("  ", ff10));
		    table.addCell(cell);
		    cell.setPhrase(new Paragraph("  ", ff10));
		    table.addCell(cell);
		    cell.setPhrase(new Paragraph("  ", ff10));
		    table.addCell(cell);
	    
	    
	    document.add(table);
       
       
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
       chunk = convertChunkByChinesexiahua("http://fuyhui.com/", ff10);
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
       document.add(p);      
       document.add(new Chunk("\n"));// 换行
       
       p = convertParToChinese1("乙方：", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);       
       document.add(new Chunk("\n"));// 换行
       
       

       
       p = convertParToChinese1("丙方：深圳富之富信息技术有限公司", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);    
       document.add(new Chunk("\n"));// 换行
       
       p = convertParToChinese1("日期： 年  月 日", ff10,0);
       p.setAlignment(0);//设置段落居左
       document.add(p);           
       
	   document.close();
			
	}
	
	public static void main(String[] args) throws Exception {

		CreContrPdftemplate creContrPdf = new CreContrPdftemplate();
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
		loanApply.setName("黄瓜姑姑哼唧哼i唧");
		loanApply.setDueTime(1489663560);
		UserVO investuser=new UserVO();
		investuser.setUserId(10000010);
		investuser.setRealname("范坚强");
		investuser.setCardId("4231231451234123123123412");
		UserVO loadApplyUser = new UserVO();
		loadApplyUser.setRealname("金华有限公司");
		loadApplyUser.setCorpName("广发胡歌");
		
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
		
		
		creContrPdf.writePdf2("D://all1.pdf","安心投",loanApply,loadApplyUser,GuaranUser);
	}

}
