package com.fujfu.pojo.news;

public class NewsCategoryVO {
    private Short id;

    private String name;

    private Short parent;

    private Short type;
    
    private Short status;

    private Integer created;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getParent() {
        return parent;
    }

    public void setParent(Short parent) {
        this.parent = parent;
    }

    public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}
    
}