package com.fujfu.common.util.tag;

import java.util.ArrayList;
import java.util.List;

public class Page {
	private int pageSize = 10; // 每页记录数

	  private long totalCount; // 记录总数

	  private int pageNum=1; // 当前页号

	  private List items = new ArrayList(); // 页数据
	  
	  private int startOfPage;
	  public Page() {}

	  /**
	   * @param currentPageNo 当前页号
	   */
	  public Page(int pageNum) {
	    this.pageNum = pageNum;
	  }

	  public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public Page(int currentPageNo, long totalCount) {
	    this(currentPageNo);
	    this.totalCount = totalCount;
	  }

	  /**
	   * @param currentPageNo 当前页号
	   * @param pageSize 页大小
	   */
	  public Page(int currentPageNo, int pageSize) {
	    this(currentPageNo);
	    this.pageSize = pageSize;
	  }

	  public Page(int currentPageNo, int pageSize, long totalCount) {
	    this(currentPageNo, pageSize);
	    this.totalCount = totalCount;
	  }

	  /**
	   * 是否有下一页
	   * @return
	   */
	  public boolean hasNextPage() {
	    return pageNum < getPageCount();
	  }

	  /**
	   * 是否有上一页
	   * @return
	   */
	  public boolean hasPreviousPage() {
	    return pageNum > 1;
	  }

	  /**
	   * 是否有分页
	   * @return
	   */
	  public boolean hasPage() {
	    return getPageCount() > 1;
	  }

	  /**
	   * 得到当前页号
	   * @return
	   */
	  public int getCurrentPageNo() {
	    int pageCount = getPageCount();
	    if(pageNum > pageCount) pageNum = pageCount;
	    if(pageCount == 0) pageNum = 1;
	    if(pageNum < 1) pageNum = 1;
	    return pageNum;
	  }

	  /**
	   * 得到页总数
	   * @return
	   */
	  public int getPageCount() {
	    return (int) ((totalCount + pageSize - 1) / pageSize);
	  }

	  /**
	   * 得到页大小
	   * @return
	   */
	  public int getPageSize() {
	    return pageSize;
	  }

	  /**
	   * 得到页内容
	   * @return
	   */
	  public List getItems() {
	    return items;
	  }

	  /**
	   * 设置页内容
	   * @param items
	   */
	  public void setItems(List items) {
	    this.items = items;
	  }

	  public void setTotalCount(long totalCount) {
	    this.totalCount = totalCount;
	  }

	  public long getTotalCount() {
	    return totalCount;
	  }

	  /**
	   * 计算起始索引号
	   * @param pageNo
	   * @param pageSize
	   * @return
	   */
	  public int getStartOfPage() {
	    return (getCurrentPageNo() - 1) * pageSize;
	  }
	}
