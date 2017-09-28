package com.fujfu.common.util;

import java.awt.Color;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class PDFshiyan {
	// 模板存放的目录
	public static final String TEMPLATE_PDF_PATH = "D//";
	// 生成PDF存放路径
	public static final String PDF_PATH = "D//";
	
	public static void main(String[] args) throws Exception {

		PDFshiyan pdfDemo = new PDFshiyan();
		Map<String, String> baseInfo =new HashMap();
		baseInfo.put("policyCode", "12345678");
		baseInfo.put("companyName", "哈哈哈哈打");
		baseInfo.put("effectiveDate", "20170607");
		baseInfo.put("policyChangeId", "12222222");

		PDFshiyan.createPreservationListPDF(baseInfo);
		
	}
    public static String createPreservationListPDF( Map<String, String> baseInfo) throws Exception{
    	//Document doc = new Document(PageSize.B5);
    	String sysdate = GetSysdate();//获取系统当前时间
		String fullFileName = "d:\\test1.pdf";//文件全路径
		
		Rectangle rect = new Rectangle(842.0F, 595.0F);//设置页面大小,在源码中有PageSize.A4  = new Rectangle(595.0F, 842.0F)
        Document document = new Document(rect, 80, 80, 90, 25); //设置成A4纸大小,内容距左右上下的距离
        
        //String fullFileName = PDF_PATH + fileName+".pdf"; //文件全路径
        try {
        	PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(fullFileName));
           
            // 插入一个段落
            //设置中文字体
            BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            //1.标题字体
            Font headFont =  new  Font(baseFontChinese , 16 , Font.BOLD);;
            //2.正文字体
            Font contentFontSecond =  new  Font(baseFontChinese , 10 , Font.NORMAL);
            
            //设置页脚
            HeaderFooter footer=new HeaderFooter(new Phrase("保险公司盖章：                                               \n\n   ",contentFontSecond),false);  
            /** 
             * 0是靠左 
             * 1是居中 
             * 2是居右 
             */  
            footer.setBorderColor(Color.black);
            footer.setBorder(Rectangle.TOP);  
            footer.setAlignment(2);//设置右对齐
            document.setFooter(footer);  
            
            
            document.open();//打开PDF文件进行编辑
            //设置标题
            Paragraph head1 = new Paragraph("团险保全明细", headFont);
            head1.setAlignment(1);//设置段落居中
            head1.setSpacingAfter(30);  
            document.add(head1);
           
            //使用表格布局
            PdfPTable baseInfoTable = new PdfPTable(6); //设置表格有多少列
            int width[] = {6,14,8,50,8,14};//设置每列宽度比例   
            baseInfoTable.setWidths(width); 
            baseInfoTable.setWidthPercentage(100);//占页面宽度比例 
            //设置表格中单元格的属性,所有单元格都可以使用
            PdfPCell pdfPCell = new PdfPCell();//创建一个单元格
	       	//设置字体水平居中
            pdfPCell.setHorizontalAlignment(Rectangle.LEFT);//设置水平对齐
	       	//设置字体垂直对齐居中
            pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pdfPCell.setBorder(0);
            
            pdfPCell.setPhrase(new Phrase("保单号:" , contentFontSecond));
            baseInfoTable.addCell(pdfPCell);
            pdfPCell.setPhrase(new Phrase(baseInfo.get("policyCode"), contentFontSecond));
            baseInfoTable.addCell(pdfPCell);
            pdfPCell.setPhrase(new Phrase("投保单位:" , contentFontSecond));
            baseInfoTable.addCell(pdfPCell);
            pdfPCell.setPhrase(new Phrase(baseInfo.get("companyName"), contentFontSecond));
            baseInfoTable.addCell(pdfPCell);
            pdfPCell.setPhrase(new Phrase(""));//设置空白列
            baseInfoTable.addCell(pdfPCell);
            pdfPCell.setPhrase(new Phrase(""));//设置空白列
            baseInfoTable.addCell(pdfPCell);
            //第二行
            pdfPCell.setBorder(Rectangle.BOTTOM);//设置底部颜色，实现一条横线的效果
            pdfPCell.setBorderColor(Color.BLACK);
            pdfPCell.setPhrase(new Phrase("批单号:" , contentFontSecond));
            baseInfoTable.addCell(pdfPCell);
            pdfPCell.setPhrase(new Phrase(baseInfo.get("policyChangeId"), contentFontSecond));
            baseInfoTable.addCell(pdfPCell);
            pdfPCell.setPhrase(new Phrase("保全单位:" , contentFontSecond));
            baseInfoTable.addCell(pdfPCell);
            pdfPCell.setPhrase(new Phrase("团单短险批次增加被保人", contentFontSecond));
            baseInfoTable.addCell(pdfPCell);
            pdfPCell.setPhrase(new Phrase("生效日期:",contentFontSecond));
            baseInfoTable.addCell(pdfPCell);
            pdfPCell.setPhrase(new Phrase(baseInfo.get("effectiveDate"), contentFontSecond));
            baseInfoTable.addCell(pdfPCell);
            baseInfoTable.setSpacingAfter(30);//设置间距
            document.add(baseInfoTable);
            
            
            
            
//            //清单
//            PdfPTable presListTable = new PdfPTable(tableHeads.length); //设置表格有多少列
//            int presWidth[] = {16,16,17,17,17,17};//设置每列宽度比例   
//            presListTable.setWidths(presWidth); 
//            presListTable.setWidthPercentage(100);//占页面宽度比例 
//            //设置表格中单元格的属性,所有单元格都可以使用
//            //PdfPCell pdfPCell = new PdfPCell();//创建一个单元格
//	       	//设置字体水平居中
//            pdfPCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);//设置水平对齐
//	       	//设置字体垂直对齐居中
//            pdfPCell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
//            pdfPCell.setBorder(0);
//            //保险方案内容：
//            for(String head : tableHeads){
//            	 pdfPCell.setPhrase(new Phrase(head , contentFontSecond));
//            	 presListTable.addCell(pdfPCell);
//            }
//            presListTable.completeRow();
//            for(Preservation preservation : tableDataList){
//	           	pdfPCell.setPhrase(new Phrase(preservation.getInsuredName(), contentFontSecond));
//	           	presListTable.addCell(pdfPCell);
//	        	pdfPCell.setPhrase(new Phrase(preservation.getInsuredIdcard(), contentFontSecond));
//	           	presListTable.addCell(pdfPCell);
//	        	pdfPCell.setPhrase(new Phrase(preservation.getJobLevel(), contentFontSecond));
//	           	presListTable.addCell(pdfPCell);
//	        	pdfPCell.setPhrase(new Phrase(preservation.getPackageName(), contentFontSecond));
//	           	presListTable.addCell(pdfPCell);
//	        	pdfPCell.setPhrase(new Phrase(preservation.getPolicyFee(), contentFontSecond));
//	           	presListTable.addCell(pdfPCell);
//	        	pdfPCell.setPhrase(new Phrase(preservation.getEffectiveDate(), contentFontSecond));
//	           	presListTable.addCell(pdfPCell);
//	           	presListTable.completeRow();//完成行
//	           
//            }  
//            document.add(presListTable);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        return fullFileName;
    }


	public static String GetSysdate() {
		java.text.DateFormat df = new java.text.SimpleDateFormat("yyyyMMddhhmmssSSS");
		java.util.Date date = new java.util.Date();
		String sysdate = df.format(date);
		return sysdate;
	}
	// 获取pdf模板的全路径
	public static String GetPdfPath(String fileName) {
		String pdfpath = TEMPLATE_PDF_PATH + "\\"+ fileName + ".pdf";
		return pdfpath;
	}
}