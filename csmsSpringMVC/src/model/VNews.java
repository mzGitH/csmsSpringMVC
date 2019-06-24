package model;

/**
 * VNews entity. @author MyEclipse Persistence Tools
 */

public class VNews implements java.io.Serializable {

	private Integer newid;
	private String newstitle;
	private String newscontent;
	private String teacerid;
	private String datetime;
	private String userid;
	private String username;
	private String pwd;
	private String agend;
	private String mobile;
	private Integer collegeid;
	private Integer roleid;

	// Constructors

	/** default constructor */
	public VNews() {
	}

	/** full constructor */
	public VNews(Integer newid, String newstitle, String newscontent,
			String teacerid, String datetime, String userid, String username,
			String pwd, String agend, String mobile, Integer collegeid,
			Integer roleid) {
		this.newid = newid;
		this.newstitle = newstitle;
		this.newscontent = newscontent;
		this.teacerid = teacerid;
		this.datetime = datetime;
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.agend = agend;
		this.mobile = mobile;
		this.collegeid = collegeid;
		this.roleid = roleid;
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

	public String getTeacerid() {
		return this.teacerid;
	}

	public void setTeacerid(String teacerid) {
		this.teacerid = teacerid;
	}

	public String getDatetime() {
		return this.datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VNews))
			return false;
		VNews castOther = (VNews) other;

		return ((this.getNewid() == castOther.getNewid()) || (this.getNewid() != null
				&& castOther.getNewid() != null && this.getNewid().equals(
				castOther.getNewid())))
				&& ((this.getNewstitle() == castOther.getNewstitle()) || (this
						.getNewstitle() != null
						&& castOther.getNewstitle() != null && this
						.getNewstitle().equals(castOther.getNewstitle())))
				&& ((this.getNewscontent() == castOther.getNewscontent()) || (this
						.getNewscontent() != null
						&& castOther.getNewscontent() != null && this
						.getNewscontent().equals(castOther.getNewscontent())))
				&& ((this.getTeacerid() == castOther.getTeacerid()) || (this
						.getTeacerid() != null
						&& castOther.getTeacerid() != null && this
						.getTeacerid().equals(castOther.getTeacerid())))
				&& ((this.getDatetime() == castOther.getDatetime()) || (this
						.getDatetime() != null
						&& castOther.getDatetime() != null && this
						.getDatetime().equals(castOther.getDatetime())))
				&& ((this.getUserid() == castOther.getUserid()) || (this
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
						.getRoleid().equals(castOther.getRoleid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNewid() == null ? 0 : this.getNewid().hashCode());
		result = 37 * result
				+ (getNewstitle() == null ? 0 : this.getNewstitle().hashCode());
		result = 37
				* result
				+ (getNewscontent() == null ? 0 : this.getNewscontent()
						.hashCode());
		result = 37 * result
				+ (getTeacerid() == null ? 0 : this.getTeacerid().hashCode());
		result = 37 * result
				+ (getDatetime() == null ? 0 : this.getDatetime().hashCode());
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
		return result;
	}

}