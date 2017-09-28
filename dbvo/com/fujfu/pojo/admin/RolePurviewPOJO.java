package com.fujfu.pojo.admin;

public class RolePurviewPOJO {
	private Integer id;
	private Integer roleId;
	private Integer purviewId;
	private Integer created;
	
	private String rolename;
	
	private String purviewName;
	private String purviewFlag;
	private String describ;
	public Integer getId() {
		return id;
	}
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPurviewId() {
		return purviewId;
	}

	public void setPurviewId(Integer purviewId) {
		this.purviewId = purviewId;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getPurviewName() {
		return purviewName;
	}
	public void setPurviewName(String purviewName) {
		this.purviewName = purviewName;
	}
	public String getPurviewFlag() {
		return purviewFlag;
	}
	public void setPurviewFlag(String purviewFlag) {
		this.purviewFlag = purviewFlag;
	}
	public String getDescrib() {
		return describ;
	}
	public void setDescrib(String describ) {
		this.describ = describ;
	}
	
	
	
}
