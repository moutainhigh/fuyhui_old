package com.fujfu.pojo.common;

public class NotifyAutoVO {
    private Integer id;

    private String name;

    private Short sendPlatform;

    private Short sendType;

    private String sendTime;

    private Short status;

    private Integer ctime;

    private String template;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getSendPlatform() {
		return sendPlatform;
	}

	public void setSendPlatform(Short sendPlatform) {
		this.sendPlatform = sendPlatform;
	}

	public Short getSendType() {
		return sendType;
	}

	public void setSendType(Short sendType) {
		this.sendType = sendType;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
    }

    public Integer getCtime() {
        return ctime;
    }

    public void setCtime(Integer ctime) {
        this.ctime = ctime;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template == null ? null : template.trim();
    }
}