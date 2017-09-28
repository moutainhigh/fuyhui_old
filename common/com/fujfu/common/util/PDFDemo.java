package com.fujfu.common.util;

import java.awt.Color;

import java.io.File;

import java.io.FileOutputStream;
import com.lowagie.text.Chapter;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;

import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.RectangleReadOnly;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PDFDemo {

	protected Color black = new Color(0, 0, 0); // 黑色

	protected Color red = new Color(255, 0, 0); // 红色

	protected Color blue = new Color(0, 0, 255); // 蓝色

	protected int bold = Font.BOLD; // 粗体

	protected int normal = Font.NORMAL; // 正常字体

	protected int italic = Font.ITALIC; // 斜体

	protected int boldItalic = Font.BOLDITALIC; // 粗斜体

	protected float setting = 20; // 首行缩进参数

	public Document createDoc(String filename) throws Exception {

		// 新建document对象

		// 第一个参数是页面大小。接下来的参数分别是左、右、上和下页边距。
		Rectangle A42 = new RectangleReadOnly(842, 595);

		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		document.setPageSize(A42);
		// 建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。

		// 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。

		PdfWriter.getInstance(document, new FileOutputStream(filename));

		return document;

	}

	public void writePdf(String filename, String imgPath) throws Exception {

		Document document = createDoc(filename); // 打开文档

		document.open(); // 文档里写入

		document.add(convertParToChinese("红色字体", 20, bold, red));

		document.add(new Paragraph("\n"));

		document.add(convertParToChinese("黑色", 18, boldItalic, black));

		document.add(new Paragraph("\n"));

		document.add(convertParToChinese("蓝色", 14, normal, blue));

		document.add(new Paragraph("\n"));

		// 文档写入图片

		if (checkFile(imgPath)) {

			Image image = writeImg(imgPath);

			document.add(image);

			document.add(new Paragraph("\n"));

		}

		document.add(new Paragraph("\n"));

		document.add(new Paragraph("\n")); // 生成三列表格

		PdfPTable table = new PdfPTable(3); // 设置表格具体宽度

		table.setTotalWidth(90); // 设置每一列所占的长度

		table.setWidths(new float[] { 50f, 15f, 25f });

		PdfPCell cell1 = new PdfPCell();

		Paragraph para = new Paragraph("aaaaa");

		cell1.setPhrase(para);

		table.addCell(cell1);

		table.addCell(new PdfPCell(new Phrase("IText")));

		table.addCell(new PdfPCell(new Phrase("IText")));

		document.add(table);

		document.add(new Paragraph("\n"));

		document.add(new Paragraph("\n")); // PDF同行显示

		Paragraph par = new Paragraph();

		Chunk chunk1 = new Chunk(convertChunkByChinese("考试分数：", 20, bold, black));

		Chunk chunk2 = new Chunk(convertChunkByChinese("93", 20, bold, red));

		par.add(chunk1);

		par.add(chunk2); // 设置整体缩进

		par.setFirstLineIndent(setting); // 居中

		Paragraph centerPar = convertParToChinese("剧中测试", 16, italic, black);

		centerPar.setAlignment(Element.ALIGN_CENTER);

		document.add(par); // 新建章节

		// //

		// 章节标题

		Paragraph chapterTitle = new Paragraph(convertParToChinese("章节标题", 18, boldItalic, blue));

		Chapter chapter1 = new Chapter(chapterTitle, 1);

		chapter1.setNumberDepth(0);

		for (int i = 0; i < 20; i++)

		{

			Paragraph p = new Paragraph((i + 1) + "test!!!!!");

			chapter1.add(p);

		}

		document.add(chapter1); // 5.关闭文档

		document.close();

	}

	public void writePdf1(String filename, String imgPath, String test) throws Exception {

		Document document = createDoc(filename); // 打开文档

		document.open(); // 文档里写入

		document.add(convertParToChinese(test, 14, bold, black));

		document.close();

	}

	public Image writeImg(String imgPath) throws Exception {

		Image img = Image.getInstance(imgPath); // 控制图片大小

		img.scaleAbsolute(100, 100);

		return img;

	}

	public boolean checkFile(String path) {

		File file = new File(path);

		if (file.exists()) {

			return true;

		}

		return false;

	}

	public static Paragraph convertParToChinese(String text, int fontsize, int fontStyle, Color color)

			throws Exception {

		BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);

		Font fontChinese = new Font(baseFontChinese, fontsize, fontStyle, color);

		Paragraph graph = new Paragraph(text, fontChinese);

		return graph;

	}

	// 三个参数 ，text 文本内容 ， fontChinese样式,setting段落首行缩进
	public static Paragraph convertParToChinese1(String text, Font fontChinese, float setting)

			throws Exception {

		BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
		Paragraph graph = new Paragraph(text, fontChinese);
		if (setting > 0) {
			graph.setFirstLineIndent(setting);
		}
		return graph;

	}

	/*
	 * 动态数据加入 param text1 前面部分 text2后面部分 str动态数据
	 */
	public static Paragraph convertParToChinese2(String text1, String text2, String str, Font fontChinese,
			float setting)

					throws Exception {

		BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
		Paragraph graph = new Paragraph();
		Chunk chunk1 = convertChunkByChinese1(text1, fontChinese);
		Chunk chunk2 = convertChunkByChinese1(text2, fontChinese);
		Chunk chunk3 = convertChunkByChinesexiahua(str, fontChinese);
		graph.add(chunk1);
		graph.add(chunk3);
		graph.add(chunk2);
		if (setting > 0) {
			graph.setFirstLineIndent(setting);
		}
		return graph;

	}
	/*
	 * 动态数据加入 param text1 前面部分 text2后面部分 str动态数据
	 */
	public static Paragraph convertParToChinese2(String text1, String text2,String text3,  String str, String str1, Font fontChinese,
			float setting)

					throws Exception {

		BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
		Paragraph graph = new Paragraph();
		Chunk chunk1 = convertChunkByChinese1(text1, fontChinese);
		Chunk chunk2 = convertChunkByChinese1(text2, fontChinese);
		Chunk chunk3 = convertChunkByChinese1(text3, fontChinese);
		Chunk chunk4 = convertChunkByChinesexiahua(str, fontChinese);
		Chunk chunk5 = convertChunkByChinesexiahua(str1, fontChinese);
		graph.add(chunk1);
		graph.add(chunk4);
		graph.add(chunk2);
		graph.add(chunk5);
		graph.add(chunk3);
		if (setting > 0) {
			graph.setFirstLineIndent(setting);
		}
		return graph;

	}

	// 设置下划线
	public static Chunk convertChunkByChinesexiahua(String text, Font fontChinese) throws Exception {

		BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
		Chunk chunk = new Chunk(text, fontChinese);
		chunk.setUnderline(1f, -1f);
		return chunk;

	}

	// 不设置下划线
	public static Chunk convertChunkByChinese1(String text, Font fontChinese) throws Exception {

		BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);

		Chunk chunk = new Chunk(text, fontChinese);

		return chunk;

	}

	public Chunk convertChunkByChinese(String text, int fontsize, int fontStyle, Color color) throws Exception {

		BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);

		Font fontChinese = new Font(baseFontChinese, fontsize, fontStyle, color);

		Chunk chunk = new Chunk(text, fontChinese);

		return chunk;

	}

	public void GenerateAllParts() {
		Document document = new Document();

		try {
			String filename = "d:\\all1.pdf";
			document = createDoc(filename); // 打开文档
			PdfWriter.getInstance(document, new FileOutputStream("d:\\all1.pdf"));
			// 生成字体
			BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
			// 标题字体
			Font f30 = new Font(bfChinese, 30, Font.NORMAL, Color.BLACK);
			// 正文字体
			Font f12 = new Font(bfChinese, 12, Font.NORMAL, Color.BLACK);
			Font f6 = new Font(bfChinese, 6, Font.NORMAL, Color.BLACK);
			Font f8 = new Font(bfChinese, 8, Font.NORMAL, Color.BLACK);

			document.open();

			// 添加table实例
			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(100);
			table.setHorizontalAlignment(Element.ALIGN_LEFT);
			PdfPCell cell = new PdfPCell();
			cell.setBackgroundColor(new Color(213, 141, 69));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);

			// 表格标题
			cell.setPhrase(new Paragraph("标题一", f8));
			table.addCell(cell);
			cell.setPhrase(new Paragraph("标题二", f8));
			table.addCell(cell);
			cell.setPhrase(new Paragraph("标题三", f8));
			table.addCell(cell);
			cell.setPhrase(new Paragraph("标题四", f8));
			table.addCell(cell);
			cell.setPhrase(new Paragraph("标题五", f8));
			table.addCell(cell);

			// 表格数据
			PdfPCell newcell = new PdfPCell();
			newcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			newcell.setPhrase(new Paragraph("数据一", f8));
			table.addCell(newcell);
			newcell.setPhrase(new Paragraph("数据二", f8));
			table.addCell(newcell);
			newcell.setPhrase(new Paragraph("数据三", f8));
			table.addCell(newcell);
			newcell.setPhrase(new Paragraph("数据四", f8));
			table.addCell(newcell);
			newcell.setPhrase(new Paragraph("数据五", f8));
			table.addCell(newcell);

			document.add(table);
			////////////////////////////////////////////////////////

			//////////////////////////////////////////////////////////

			//////////////////////////////////////////////////////////

			document.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}