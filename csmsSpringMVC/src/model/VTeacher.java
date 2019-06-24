package model;

/**
 * VTeacher entity. @author MyEclipse Persistence Tools
 */

public class VTeacher implements java.io.Serializable {

	private String userid;
	private String username;
	private String pwd;
	private String agend;
	private String mobile;
	private Integer collegeid;
	private Integer roleid;
	private String collegename;
	private String rolename;

	// Constructors

	/** default constructor */
	public VTeacher() {
	}

	/** full constructor */
	public VTeacher(String userid, String username, String pwd, String agend,
			String mobile, Integer collegeid, Integer roleid,
			String collegename, String rolename) {
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.agend = agend;
		this.mobile = mobile;
		this.collegeid = collegeid;
		this.roleid = roleid;
		this.collegename = collegename;
		this.rolename = rolename;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAgend() {
		return this.agend;
	}

	public void setAgend(String agend) {
		this.agend = agend;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getCollegeid() {
		return this.collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getCollegename() {
		return this.collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VTeacher))
			return false;
		VTeacher castOther = (VTeacher) other;

		return ((this.getUserid() == castOther.getUserid()) || (this
				.getUserid() != null && castOther.getUserid() != null && this
				.getUserid().equals(castOther.getUserid())))
				&& ((this.getUsername() == castOther.getUsername()) || (this
						.getUsername() != null
						&& castOther.getUsername() != null && this
						.getUsername().equals(castOther.getUsername())))
				&& ((this.getPwd() == castOther.getPwd()) || (this.getPwd() != null
						&& castOther.getPwd() != null && this.getPwd().equals(
						castOther.getPwd())))
				&& ((this.getAgend() == castOther.getAgend()) || (this
						.getAgend() != null && castOther.getAgend() != null && this
						.getAgend().equals(castOther.getAgend())))
				&& ((this.getMobile() == castOther.getMobile()) || (this
						.getMobile() != null && castOther.getMobile() != null && this
						.getMobile().equals(castOther.getMobile())))
				&& ((this.getCollegeid() == castOther.getCollegeid()) || (this
						.getCollegeid() != null
						&& castOther.getCollegeid() != null && this
						.getCollegeid().equals(castOther.getCollegeid())))
				&& ((this.getRoleid() == castOther.getRoleid()) || (this
						.getRoleid() != null && castOther.getRoleid() != null && this
						.getRoleid().equals(castOther.getRoleid())))
				&& ((this.getCollegename() == castOther.getCollegename()) || (this
						.getCollegename() != null
						&& castOther.getCollegename() != null && this
						.getCollegename().equals(castOther.getCollegename())))
				&& ((this.getRolename() == castOther.getRolename()) || (this
						.getRolename() != null
						&& castOther.getRolename() != null && this
						.getRolename().equals(castOther.getRolename())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserid() == null ? 0 : this.getUserid().hashCode());
		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getPwd() == null ? 0 : this.getPwd().hashCode());
		result = 37 * result
				+ (getAgend() == null ? 0 : this.getAgend().hashCode());
		result = 37 * result
				+ (getMobile() == null ? 0 : this.getMobile().hashCode());
		result = 37 * result
				+ (getCollegeid() == null ? 0 : this.getCollegeid().hashCode());
		result = 37 * result
				+ (getRoleid() == null ? 0 : this.getRoleid().hashCode());
		result = 37
				* result
				+ (getCollegename() == null ? 0 : this.getCollegename()
						.hashCode());
		result = 37 * result
				+ (getRolename() == null ? 0 : this.getRolename().hashCode());
		return result;
	}

}