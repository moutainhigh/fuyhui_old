package com.fujfu.pojo.common;

public class SelCodeVO {
    private Integer id;

    private String code;

	private String style;

    private String itemno;

    private String itemname;

    private String belongitemno;


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getItemno() {
		return itemno;
	}

	public void setItemno(String itemno) {
		this.itemno = itemno;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getBelongitemno() {
		return belongitemno;
	}

	public void setBelongitemno(String belongitemno) {
		this.belongitemno = belongitemno;
	}
}