package com.fujfu.pojo.admin;

public class SidemenuVO {
    private Integer sidebarId;

    private Integer pid;

    private String cssClass;

    private String name;

    private String url;

    private String purviewFlag;

    private Integer created;

    public Integer getSidebarId() {
        return sidebarId;
    }

    public void setSidebarId(Integer sidebarId) {
        this.sidebarId = sidebarId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass == null ? null : cssClass.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPurviewFlag() {
        return purviewFlag;
    }

    public void setPurviewFlag(String purviewFlag) {
        this.purviewFlag = purviewFlag == null ? null : purviewFlag.trim();
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }
}