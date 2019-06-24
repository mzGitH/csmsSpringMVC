package model;

/**
 * VStudentScore entity. @author MyEclipse Persistence Tools
 */

public class VStudentScore implements java.io.Serializable {

	private Integer scoreid;
	private Integer matchid;
	private Double scorenumber;
	private Integer proid;
	private String proname;
	private Integer scenelimit;
	private Integer collegelimit;
	private Integer totallimit;
	private Integer protype;
	private String rolename;
	private String userid;
	private String collegename;
	private Integer collegeid;
	private String majorname;
	private String classname;
	private Integer majorid;
	private String username;
	private Integer roleid;
	private Integer classid;
	private String mobile;
	private String agend;
	private String pwd;

	// Constructors

	/** default constructor */
	public VStudentScore() {
	}

	/** minimal constructor */
	public VStudentScore(Integer scoreid, Integer matchid,
			Double scorenumber, Integer proid, String userid,
			Integer collegeid, String majorname) {
		this.scoreid = scoreid;
		this.matchid = matchid;
		this.scorenumber = scorenumber;
		this.proid = proid;
		this.userid = userid;
		this.collegeid = collegeid;
		this.majorname = majorname;
	}

	/** full constructor */
	public VStudentScore(Integer scoreid, Integer matchid,
			Double scorenumber, Integer proid, String proname,
			Integer scenelimit, Integer collegelimit, Integer totallimit,
			Integer protype, String rolename, String userid,
			String collegename, Integer collegeid, String majorname,
			String classname, Integer majorid, String username, Integer roleid,
			Integer classid, String mobile, String agend, String pwd) {
		this.scoreid = scoreid;
		this.matchid = matchid;
		this.scorenumber = scorenumber;
		this.proid = proid;
		this.proname = proname;
		this.scenelimit = scenelimit;
		this.collegelimit = collegelimit;
		this.totallimit = totallimit;
		this.protype = protype;
		this.rolename = rolename;
		this.userid = userid;
		this.collegename = collegename;
		this.collegeid = collegeid;
		this.majorname = majorname;
		this.classname = classname;
		this.majorid = majorid;
		this.username = username;
		this.roleid = roleid;
		this.classid = classid;
		this.mobile = mobile;
		this.agend = agend;
		this.pwd = pwd;
	}

	// Property accessors

	public Integer getScoreid() {
		return this.scoreid;
	}

	public void setScoreid(Integer scoreid) {
		this.scoreid = scoreid;
	}

	public Integer getMatchid() {
		return this.matchid;
	}

	public void setMatchid(Integer matchid) {
		this.matchid = matchid;
	}

	public Double getScorenumber() {
		return this.scorenumber;
	}

	public void setScorenumber(Double scorenumber) {
		this.scorenumber = scorenumber;
	}

	public Integer getProid() {
		return this.proid;
	}

	public void setProid(Integer proid) {
		this.proid = proid;
	}

	public String getProname() {
		return this.proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public Integer getScenelimit() {
		return this.scenelimit;
	}

	public void setScenelimit(Integer scenelimit) {
		this.scenelimit = scenelimit;
	}

	public Integer getCollegelimit() {
		return this.collegelimit;
	}

	public void setCollegelimit(Integer collegelimit) {
		this.collegelimit = collegelimit;
	}

	public Integer getTotallimit() {
		return this.totallimit;
	}

	public void setTotallimit(Integer totallimit) {
		this.totallimit = totallimit;
	}

	public Integer getProtype() {
		return this.protype;
	}

	public void setProtype(Integer protype) {
		this.protype = protype;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCollegename() {
		return this.collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public Integer getCollegeid() {
		return this.collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public String getMajorname() {
		return this.majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Integer getMajorid() {
		return this.majorid;
	}

	public void setMajorid(Integer majorid) {
		this.majorid = majorid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAgend() {
		return this.agend;
	}

	public void setAgend(String agend) {
		this.agend = agend;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VStudentScore))
			return false;
		VStudentScore castOther = (VStudentScore) other;

		return ((this.getScoreid() == castOther.getScoreid()) || (this
				.getScoreid() != null && castOther.getScoreid() != null && this
				.getScoreid().equals(castOther.getScoreid())))
				&& ((this.getMatchid() == castOther.getMatchid()) || (this
						.getMatchid() != null && castOther.getMatchid() != null && this
						.getMatchid().equals(castOther.getMatchid())))
				&& ((this.getScorenumber() == castOther.getScorenumber()) || (this
						.getScorenumber() != null
						&& castOther.getScorenumber() != null && this
						.getScorenumber().equals(castOther.getScorenumber())))
				&& ((this.getProid() == castOther.getProid()) || (this
						.getProid() != null && castOther.getProid() != null && this
						.getProid().equals(castOther.getProid())))
				&& ((this.getProname() == castOther.getProname()) || (this
						.getProname() != null && castOther.getProname() != null && this
						.getProname().equals(castOther.getProname())))
				&& ((this.getScenelimit() == castOther.getScenelimit()) || (this
						.getScenelimit() != null
						&& castOther.getScenelimit() != null && this
						.getScenelimit().equals(castOther.getScenelimit())))
				&& ((this.getCollegelimit() == castOther.getCollegelimit()) || (this
						.getCollegelimit() != null
						&& castOther.getCollegelimit() != null && this
						.getCollegelimit().equals(castOther.getCollegelimit())))
				&& ((this.getTotallimit() == castOther.getTotallimit()) || (this
						.getTotallimit() != null
						&& castOther.getTotallimit() != null && this
						.getTotallimit().equals(castOther.getTotallimit())))
				&& ((this.getProtype() == castOther.getProtype()) || (this
						.getProtype() != null && castOther.getProtype() != null && this
						.getProtype().equals(castOther.getProtype())))
				&& ((this.getRolename() == castOther.getRolename()) || (this
						.getRolename() != null
						&& castOther.getRolename() != null && this
						.getRolename().equals(castOther.getRolename())))
				&& ((this.getUserid() == castOther.getUserid()) || (this
						.getUserid() != null && castOther.getUserid() != null && this
						.getUserid().equals(castOther.getUserid())))
				&& ((this.getCollegename() == castOther.getCollegename()) || (this
						.getCollegename() != null
						&& castOther.getCollegename() != null && this
						.getCollegename().equals(castOther.getCollegename())))
				&& ((this.getCollegeid() == castOther.getCollegeid()) || (this
						.getCollegeid() != null
						&& castOther.getCollegeid() != null && this
						.getCollegeid().equals(castOther.getCollegeid())))
				&& ((this.getMajorname() == castOther.getMajorname()) || (this
						.getMajorname() != null
						&& castOther.getMajorname() != null && this
						.getMajorname().equals(castOther.getMajorname())))
				&& ((this.getClassname() == castOther.getClassname()) || (this
						.getClassname() != null
						&& castOther.getClassname() != null && this
						.getClassname().equals(castOther.getClassname())))
				&& ((this.getMajorid() == castOther.getMajorid()) || (this
						.getMajorid() != null && castOther.getMajorid() != null && this
						.getMajorid().equals(castOther.getMajorid())))
				&& ((this.getUsername() == castOther.getUsername()) || (this
						.getUsername() != null
						&& castOther.getUsername() != null && this
						.getUsername().equals(castOther.getUsername())))
				&& ((this.getRoleid() == castOther.getRoleid()) || (this
						.getRoleid() != null && castOther.getRoleid() != null && this
						.getRoleid().equals(castOther.getRoleid())))
				&& ((this.getClassid() == castOther.getClassid()) || (this
						.getClassid() != null && castOther.getClassid() != null && this
						.getClassid().equals(castOther.getClassid())))
				&& ((this.getMobile() == castOther.getMobile()) || (this
						.getMobile() != null && castOther.getMobile() != null && this
						.getMobile().equals(castOther.getMobile())))
				&& ((this.getAgend() == castOther.getAgend()) || (this
						.getAgend() != null && castOther.getAgend() != null && this
						.getAgend().equals(castOther.getAgend())))
				&& ((this.getPwd() == castOther.getPwd()) || (this.getPwd() != null
						&& castOther.getPwd() != null && this.getPwd().equals(
						castOther.getPwd())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getScoreid() == null ? 0 : this.getScoreid().hashCode());
		result = 37 * result
				+ (getMatchid() == null ? 0 : this.getMatchid().hashCode());
		result = 37
				* result
				+ (getScorenumber() == null ? 0 : this.getScorenumber()
						.hashCode());
		result = 37 * result
				+ (getProid() == null ? 0 : this.getProid().hashCode());
		result = 37 * result
				+ (getProname() == null ? 0 : this.getProname().hashCode());
		result = 37
				* result
				+ (getScenelimit() == null ? 0 : this.getScenelimit()
						.hashCode());
		result = 37
				* result
				+ (getCollegelimit() == null ? 0 : this.getCollegelimit()
						.hashCode());
		result = 37
				* result
				+ (getTotallimit() == null ? 0 : this.getTotallimit()
						.hashCode());
		result = 37 * result
				+ (getProtype() == null ? 0 : this.getProtype().hashCode());
		result = 37 * result
				+ (getRolename() == null ? 0 : this.getRolename().hashCode());
		result = 37 * result
				+ (getUserid() == null ? 0 : this.getUserid().hashCode());
		result = 37
				* result
				+ (getCollegename() == null ? 0 : this.getCollegename()
						.hashCode());
		result = 37 * result
				+ (getCollegeid() == null ? 0 : this.getCollegeid().hashCode());
		result = 37 * result
				+ (getMajorname() == null ? 0 : this.getMajorname().hashCode());
		result = 37 * result
				+ (getClassname() == null ? 0 : this.getClassname().hashCode());
		result = 37 * result
				+ (getMajorid() == null ? 0 : this.getMajorid().hashCode());
		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getRoleid() == null ? 0 : this.getRoleid().hashCode());
		result = 37 * result
				+ (getClassid() == null ? 0 : this.getClassid().hashCode());
		result = 37 * result
				+ (getMobile() == null ? 0 : this.getMobile().hashCode());
		result = 37 * result
				+ (getAgend() == null ? 0 : this.getAgend().hashCode());
		result = 37 * result
				+ (getPwd() == null ? 0 : this.getPwd().hashCode());
		return result;
	}

}