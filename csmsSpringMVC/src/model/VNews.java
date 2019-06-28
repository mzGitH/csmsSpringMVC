package model;


/**
 * VNews entity. @author MyEclipse Persistence Tools
 */

public class VNews implements java.io.Serializable {

	// Fields

	private Integer newid;
	private String newstitle;
	private String newscontent;
	private String datetime;
	private Integer sportid;
	private String adminuserid;
	private String realname;
	private String mobile;
	private Integer userstatus;
	private Integer roleId;
	private String name;

	// Constructors

	/** default constructor */
	public VNews() {
	}

	/** minimal constructor */
	public VNews(Integer newid, String newstitle, String newscontent,
			String datetime, String adminuserid, String realname,
			Integer userstatus, Integer roleId, String name) {
		this.newid = newid;
		this.newstitle = newstitle;
		this.newscontent = newscontent;
		this.datetime = datetime;
		this.adminuserid = adminuserid;
		this.realname = realname;
		this.userstatus = userstatus;
		this.roleId = roleId;
		this.name = name;
	}

	/** full constructor */
	public VNews(Integer newid, String newstitle, String newscontent,
			String datetime, Integer sportid, String adminuserid,
			String realname, String mobile, Integer userstatus, Integer roleId,
			String name) {
		this.newid = newid;
		this.newstitle = newstitle;
		this.newscontent = newscontent;
		this.datetime = datetime;
		this.sportid = sportid;
		this.adminuserid = adminuserid;
		this.realname = realname;
		this.mobile = mobile;
		this.userstatus = userstatus;
		this.roleId = roleId;
		this.name = name;
	}

	// Property accessors

	public Integer getNewid() {
		return this.newid;
	}

	public void setNewid(Integer newid) {
		this.newid = newid;
	}

	public String getNewstitle() {
		return this.newstitle;
	}

	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}

	public String getNewscontent() {
		return this.newscontent;
	}

	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}

	public String getDatetime() {
		return this.datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public Integer getSportid() {
		return this.sportid;
	}

	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}

	public String getAdminuserid() {
		return this.adminuserid;
	}

	public void setAdminuserid(String adminuserid) {
		this.adminuserid = adminuserid;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getUserstatus() {
		return this.userstatus;
	}

	public void setUserstatus(Integer userstatus) {
		this.userstatus = userstatus;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}