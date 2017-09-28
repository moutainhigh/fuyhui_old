package com.fujfu.pojo.common;

public class MessageVO {
    private Integer id;

    private Integer userId;

    private Integer senderId;

    private String title;

    private Integer type;

    private Integer objId;

    private Integer status;

    private Integer sendStatus;

    private Integer deleted;

    private Integer created;

    private String content;
    
    private String created1;

    public String getCreated1() {
		return created1;
	}

	public void setCreated1(String created1) {
		this.created1 = created1;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(Integer sendStatus) {
		this.sendStatus = sendStatus;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}