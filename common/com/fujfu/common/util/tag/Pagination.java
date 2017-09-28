package com.fujfu.common.util.tag;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.fujfu.common.util.htmlbuilder.HtmlBuilder;


public class Pagination extends TagSupport{
	private static final long serialVersionUID = 3616521642381290343L;

	  private String scope; // 生存周期

	  /**
	   * 分页属性名称
	   */
	  private String pageAttributeName;

	  /**
	   * HTML代码
	   */
	  private transient HtmlBuilder htmlStr;

	  /**
	   * 提交对象
	   */
	  private String formName;

	  /**
	   * 样式表支持
	   */
	  private String styleClass;

	  /**
	   * 跳转按钮样式表
	   */
	  private String goStyleClass;

	  /**
	   * 分页属性
	   */
	  private transient Page page;

	  @Override
	public int doStartTag() throws JspException {
	    htmlStr = new HtmlBuilder();
	    if ("session".equals(this.getScope())) {
	      HttpSession session = pageContext.getSession();
	      if (!"".equals(pageAttributeName)) {
	        page = (Page) session.getAttribute(pageAttributeName);
	      }
	    } else {
	      ServletRequest request = pageContext.getRequest();
	      if (!"".equals(pageAttributeName)) {
	        page = (Page) request.getAttribute(pageAttributeName);
	      }
	    }
	    if (page == null) return SKIP_BODY;

	    return SKIP_BODY;
	  }
	  @Override
	public int doEndTag() throws JspException {
	    if(page == null) return EVAL_PAGE;
	    try {
	      if(page.hasPreviousPage()) writePrePage();
	      if(page.hasPage()) writeGoPage();
	      writePageInfo();
	      if(page.hasNextPage()) writeNextPage();
	      pageContext.getOut().write(htmlStr.toString());
	      htmlStr = null;
	    } catch (IOException ex) {
	      throw new JspException(ex);
	    }
	    return EVAL_PAGE;
	  }

	  private String getHtmlLinkOnClick(int curPage) {
	    StringBuilder sbClick = new StringBuilder();
	    sbClick.append("javascript:var form = document.getElementById('").append(this.getFormName()).append("');");
	    sbClick.append("document.getElementById('pageNum').value=")
	           .append(curPage).append(";")
	           .append("if(typeof foxconn_paginationCheckForm=='function'){foxconn_paginationCheckForm();}")
	           .append("form.submit();")
	           .append("return false;");
	    return sbClick.toString();
	  }

	  private void writeHtmlLink(int curPage, String label) {
	    htmlStr.a("");
	    htmlStr.style("text-decoration:none;font-size:14px;font-color:blue;padding:3px 8px;border:1px solid #CCC;backgroud:#FFF");
	    htmlStr.onclick(getHtmlLinkOnClick(curPage));
	    htmlStr.close();
	    htmlStr.appendString(label);
	    htmlStr.aEnd();
	    htmlStr.nbsp();
	  }
	  
	  private void writePrePage() {
	    writeHtmlLink(page.getCurrentPageNo() - 1, "<上一页");
	  }

	  private void writeNextPage() {
	    writeHtmlLink(page.getCurrentPageNo() + 1, "下一页>");
	  }

	  private void writeGoPage() {
	    StringBuilder sbClick = new StringBuilder();
	    sbClick.append("javascript:var form = document.getElementById('").append(this.getFormName()).append("');");
	    sbClick.append("var pageNum = document.getElementById('pageNum');")
	           .append("var num = pageNum.value;")
	           .append("reg = /^[-+]?\\d*$/;")
	           .append("if(reg.test(num) && num != '') {pageNum.value = num;")
	    	   .append("if(typeof foxconn_paginationCheckForm=='function'){foxconn_paginationCheckForm();}")
	    	   .append("form.submit();}")
	           .append("else alert('页号不能为空，而且必须是正整数!');");

	    htmlStr.input("text");
	    htmlStr.styleClass(this.styleClass);
	    htmlStr.id("pageNum");
	    htmlStr.name("pageNum");
	    htmlStr.value(String.valueOf(page.getCurrentPageNo()));
	    htmlStr.close();

	    htmlStr.input("button");
	    htmlStr.styleClass(this.goStyleClass);
	    htmlStr.onclick(sbClick.toString());
	    htmlStr.close();
	    htmlStr.nbsp();
	  }

	  // 写分页信息
	  private void writePageInfo() {
		htmlStr.span();
		htmlStr.style("font-size:12px");
		htmlStr.close();
	    htmlStr.appendString("共" + page.getTotalCount()).appendString("条记录/");
	    htmlStr.appendString("共" + page.getPageCount()).appendString("页  ");
	    htmlStr.spanEnd();
	  }
	  public void realse() {
	    this.htmlStr = null;
	    this.page = null;
	  }

	  public String getStyleClass() {
	    return styleClass;
	  }

	  public void setStyleClass(String styleClass) {
	    this.styleClass = styleClass;
	  }

	  public String getPageAttributeName() {
	    return pageAttributeName;
	  }

	  public void setPageAttributeName(String pageAttributeName) {
	    this.pageAttributeName = pageAttributeName;
	  }

	  public String getFormName() {
	    return formName;
	  }

	  public void setFormName(String formName) {
	    this.formName = formName;
	  }

	  public String getGoStyleClass() {
	    return goStyleClass;
	  }

	  public void setGoStyleClass(String goStyleClass) {
	    this.goStyleClass = goStyleClass;
	  }

	  public String getScope() {
	    return scope;
	  }

	  public void setScope(String scope) {
	    this.scope = scope;
	  }
	}