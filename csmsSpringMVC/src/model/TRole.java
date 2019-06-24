package model;

/**
 * TRole entity. @author MyEclipse Persistence Tools
 */

public class TRole implements java.io.Serializable {

	// Fields

	private Integer roleid;
	private String rolename;

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** full constructor */
	public TRole(String rolename) {
		this.rolename = rolename;
	}

	// Property accessors

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}