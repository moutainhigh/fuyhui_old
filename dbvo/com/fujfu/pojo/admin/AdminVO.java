package com.fujfu.pojo.admin;

public class AdminVO {
    private Integer adminId;

    private String username;

    private String realname;

    private String password;

    private String uniqid;

    private Integer status;

    private Integer created;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUniqid() {
        return uniqid;
    }

    public void setUniqid(String uniqid) {
        this.uniqid = uniqid == null ? null : uniqid.trim();
    }

    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }
}