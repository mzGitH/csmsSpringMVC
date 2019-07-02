package model;


/**
 * TRoleSysModel entity. @author MyEclipse Persistence Tools
 */

public class TRoleSysModel implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleid;
	private Integer sysid;
	private Boolean isedit;
	private String createdate;

	// Constructors

	/** default constructor */
	public TRoleSysModel() {
	}

	/** full constructor */
	public TRoleSysModel(Integer roleid, Integer sysid, Boolean isedit,
			String createdate) {
		this.roleid = roleid;
		this.sysid = sysid;
		this.isedit = isedit;
		this.createdate = createdate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getSysid() {
		return this.sysid;
	}

	public void setSysid(Integer sysid) {
		this.sysid = sysid;
	}

	public Boolean getIsedit() {
		return this.isedit;
	}

	public void setIsedit(Boolean isedit) {
		this.isedit = isedit;
	}

	public String getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

}