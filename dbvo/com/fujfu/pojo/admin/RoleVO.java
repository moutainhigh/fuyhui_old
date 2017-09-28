
package com.fujfu.pojo.admin;

public class RoleVO {
    private Integer roleId;

    private String rolename;

    private String describ;

    private Integer created;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
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