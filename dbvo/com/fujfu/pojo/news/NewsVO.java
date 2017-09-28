package com.fujfu.pojo.news;

public class NewsVO {
    private Integer id;

    private Short cid;

    private String title;

    private Integer updated;

    private Integer created;

    private Short status;

    private String keywords;

    private String content;
    
    private String url;
    private String createdString;

    public String getCreatedString() {
		return createdString;
	}

	public void setCreatedString(String createdString) {
		this.createdString = createdString;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Short getCid() {
        return cid;
    }

    public void setCid(Short cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}