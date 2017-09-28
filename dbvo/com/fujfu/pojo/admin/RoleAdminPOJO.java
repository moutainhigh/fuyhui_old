package com.fujfu.pojo.admin;

public class RoleAdminPOJO {
	private Integer id;
	private Integer roleId;
	private Integer adminId;
	private Integer created;
	
	private String roleName;
	private String describ;
	
	private String username;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getCreate() {
		return created;
	}

	public void setCreate(Integer created) {
		this.created = created;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescrib() {
		return describ;
	}

	public void setDescrib(String describ) {
		this.describ = describ;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
