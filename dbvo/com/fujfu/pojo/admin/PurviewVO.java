package com.fujfu.pojo.admin;

public class PurviewVO {
    private Integer purviewId;

    private String purviewName;

    private String purviewFlag;

    private String describ;

    private Integer created;

    public Integer getPurviewId() {
        return purviewId;
    }

    public void setPurviewId(Integer purviewId) {
        this.purviewId = purviewId;
    }

    public String getPurviewName() {
        return purviewName;
    }

    public void setPurviewName(String purviewName) {
        this.purviewName = purviewName == null ? null : purviewName.trim();
    }

    public String getPurviewFlag() {
        return purviewFlag;
    }

    public void setPurviewFlag(String purviewFlag) {
        this.purviewFlag = purviewFlag == null ? null : purviewFlag.trim();
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ == null ? null : describ.trim();
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }
}