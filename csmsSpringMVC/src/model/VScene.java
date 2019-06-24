package model;

/**
 * VScene entity. @author MyEclipse Persistence Tools
 */

public class VScene implements java.io.Serializable {

	private Integer sceneid;
	private Integer arrid;
	private String arrname;
	private String starttime;
	private String endtime;
	private String addr;
	private Integer leveltype;
	private Integer state;
	private Integer matchid;
	private Integer proid;
	private String proname;
	private Integer scenelimit;
	private Integer collegelimit;
	private Integer totallimit;
	private Integer protype;
	private String userid;
	private String username;
	private String mobile;
	private Integer classid;
	private Integer roleid;
	private String rolename;
	private String classname;
	private Integer majorid;
	private String majorname;
	private Integer collegeid;
	private String collegename;
	private String teausername;
	private String teamobile;
	private Integer teacollegeid;
	private Integer tearoleid;
	private String tearolename;
	private String teacollegename;
	private String pwd;
	private String agend;
	private String teapwd;
	private String teaagend;

	// Constructors

	/** default constructor */
	public VScene() {
	}

	/** minimal constructor */
	public VScene(Integer sceneid, Integer arrid, String arrname,
			String starttime, String endtime, String addr,
			Integer leveltype, Integer state, Integer matchid) {
		this.sceneid = sceneid;
		this.arrid = arrid;
		this.arrname = arrname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.addr = addr;
		this.leveltype = leveltype;
		this.state = state;
		this.matchid = matchid;
	}

	/** full constructor */
	public VScene(Integer sceneid, Integer arrid, String arrname,
			String starttime, String endtime, String addr,
			Integer leveltype, Integer state, Integer matchid, Integer proid,
			String proname, Integer scenelimit, Integer collegelimit,
			Integer totallimit, Integer protype, String userid,
			String username, String mobile, Integer classid, Integer roleid,
			String rolename, String classname, Integer majorid,
			String majorname, Integer collegeid, String collegename,
			String teausername, String teamobile, Integer teacollegeid,
			Integer tearoleid, String tearolename, String teacollegename,
			String pwd, String agend, String teapwd, String teaagend) {
		this.sceneid = sceneid;
		this.arrid = arrid;
		this.arrname = arrname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.addr = addr;
		this.leveltype = leveltype;
		this.state = state;
		this.matchid = matchid;
		this.proid = proid;
		this.proname = proname;
		this.scenelimit = scenelimit;
		this.collegelimit = collegelimit;
		this.totallimit = totallimit;
		this.protype = protype;
		this.userid = userid;
		this.username = username;
		this.mobile = mobile;
		this.classid = classid;
		this.roleid = roleid;
		this.rolename = rolename;
		this.classname = classname;
		this.majorid = majorid;
		this.majorname = majorname;
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.teausername = teausername;
		this.teamobile = teamobile;
		this.teacollegeid = teacollegeid;
		this.tearoleid = tearoleid;
		this.tearolename = tearolename;
		this.teacollegename = teacollegename;
		this.pwd = pwd;
		this.agend = agend;
		this.teapwd = teapwd;
		this.teaagend = teaagend;
	}

	// Property accessors

	public Integer getSceneid() {
		return this.sceneid;
	}

	public void setSceneid(Integer sceneid) {
		this.sceneid = sceneid;
	}

	public Integer getArrid() {
		return this.arrid;
	}

	public void setArrid(Integer arrid) {
		this.arrid = arrid;
	}

	public String getArrname() {
		return this.arrname;
	}

	public void setArrname(String arrname) {
		this.arrname = arrname;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getLeveltype() {
		return this.leveltype;
	}

	public void setLeveltype(Integer leveltype) {
		this.leveltype = leveltype;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getMatchid() {
		return this.matchid;
	}

	public void setMatchid(Integer matchid) {
		this.matchid = matchid;
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

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

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

	public String getMajorname() {
		return this.majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public Integer getCollegeid() {
		return this.collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public String getCollegename() {
		return this.collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getTeausername() {
		return this.teausername;
	}

	public void setTeausername(String teausername) {
		this.teausername = teausername;
	}

	public String getTeamobile() {
		return this.teamobile;
	}

	public void setTeamobile(String teamobile) {
		this.teamobile = teamobile;
	}

	public Integer getTeacollegeid() {
		return this.teacollegeid;
	}

	public void setTeacollegeid(Integer teacollegeid) {
		this.teacollegeid = teacollegeid;
	}

	public Integer getTearoleid() {
		return this.tearoleid;
	}

	public void setTearoleid(Integer tearoleid) {
		this.tearoleid = tearoleid;
	}

	public String getTearolename() {
		return this.tearolename;
	}

	public void setTearolename(String tearolename) {
		this.tearolename = tearolename;
	}

	public String getTeacollegename() {
		return this.teacollegename;
	}

	public void setTeacollegename(String teacollegename) {
		this.teacollegename = teacollegename;
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

	public String getTeapwd() {
		return this.teapwd;
	}

	public void setTeapwd(String teapwd) {
		this.teapwd = teapwd;
	}

	public String getTeaagend() {
		return this.teaagend;
	}

	public void setTeaagend(String teaagend) {
		this.teaagend = teaagend;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VScene))
			return false;
		VScene castOther = (VScene) other;

		return ((this.getSceneid() == castOther.getSceneid()) || (this
				.getSceneid() != null && castOther.getSceneid() != null && this
				.getSceneid().equals(castOther.getSceneid())))
				&& ((this.getArrid() == castOther.getArrid()) || (this
						.getArrid() != null && castOther.getArrid() != null && this
						.getArrid().equals(castOther.getArrid())))
				&& ((this.getArrname() == castOther.getArrname()) || (this
						.getArrname() != null && castOther.getArrname() != null && this
						.getArrname().equals(castOther.getArrname())))
				&& ((this.getStarttime() == castOther.getStarttime()) || (this
						.getStarttime() != null
						&& castOther.getStarttime() != null && this
						.getStarttime().equals(castOther.getStarttime())))
				&& ((this.getEndtime() == castOther.getEndtime()) || (this
						.getEndtime() != null && castOther.getEndtime() != null && this
						.getEndtime().equals(castOther.getEndtime())))
				&& ((this.getAddr() == castOther.getAddr()) || (this.getAddr() != null
						&& castOther.getAddr() != null && this.getAddr()
						.equals(castOther.getAddr())))
				&& ((this.getLeveltype() == castOther.getLeveltype()) || (this
						.getLeveltype() != null
						&& castOther.getLeveltype() != null && this
						.getLeveltype().equals(castOther.getLeveltype())))
				&& ((this.getState() == castOther.getState()) || (this
						.getState() != null && castOther.getState() != null && this
						.getState().equals(castOther.getState())))
				&& ((this.getMatchid() == castOther.getMatchid()) || (this
						.getMatchid() != null && castOther.getMatchid() != null && this
						.getMatchid().equals(castOther.getMatchid())))
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
				&& ((this.getUserid() == castOther.getUserid()) || (this
						.getUserid() != null && castOther.getUserid() != null && this
						.getUserid().equals(castOther.getUserid())))
				&& ((this.getUsername() == castOther.getUsername()) || (this
						.getUsername() != null
						&& castOther.getUsername() != null && this
						.getUsername().equals(castOther.getUsername())))
				&& ((this.getMobile() == castOther.getMobile()) || (this
						.getMobile() != null && castOther.getMobile() != null && this
						.getMobile().equals(castOther.getMobile())))
				&& ((this.getClassid() == castOther.getClassid()) || (this
						.getClassid() != null && castOther.getClassid() != null && this
						.getClassid().equals(castOther.getClassid())))
				&& ((this.getRoleid() == castOther.getRoleid()) || (this
						.getRoleid() != null && castOther.getRoleid() != null && this
						.getRoleid().equals(castOther.getRoleid())))
				&& ((this.getRolename() == castOther.getRolename()) || (this
						.getRolename() != null
						&& castOther.getRolename() != null && this
						.getRolename().equals(castOther.getRolename())))
				&& ((this.getClassname() == castOther.getClassname()) || (this
						.getClassname() != null
						&& castOther.getClassname() != null && this
						.getClassname().equals(castOther.getClassname())))
				&& ((this.getMajorid() == castOther.getMajorid()) || (this
						.getMajorid() != null && castOther.getMajorid() != null && this
						.getMajorid().equals(castOther.getMajorid())))
				&& ((this.getMajorname() == castOther.getMajorname()) || (this
						.getMajorname() != null
						&& castOther.getMajorname() != null && this
						.getMajorname().equals(castOther.getMajorname())))
				&& ((this.getCollegeid() == castOther.getCollegeid()) || (this
						.getCollegeid() != null
						&& castOther.getCollegeid() != null && this
						.getCollegeid().equals(castOther.getCollegeid())))
				&& ((this.getCollegename() == castOther.getCollegename()) || (this
						.getCollegename() != null
						&& castOther.getCollegename() != null && this
						.getCollegename().equals(castOther.getCollegename())))
				&& ((this.getTeausername() == castOther.getTeausername()) || (this
						.getTeausername() != null
						&& castOther.getTeausername() != null && this
						.getTeausername().equals(castOther.getTeausername())))
				&& ((this.getTeamobile() == castOther.getTeamobile()) || (this
						.getTeamobile() != null
						&& castOther.getTeamobile() != null && this
						.getTeamobile().equals(castOther.getTeamobile())))
				&& ((this.getTeacollegeid() == castOther.getTeacollegeid()) || (this
						.getTeacollegeid() != null
						&& castOther.getTeacollegeid() != null && this
						.getTeacollegeid().equals(castOther.getTeacollegeid())))
				&& ((this.getTearoleid() == castOther.getTearoleid()) || (this
						.getTearoleid() != null
						&& castOther.getTearoleid() != null && this
						.getTearoleid().equals(castOther.getTearoleid())))
				&& ((this.getTearolename() == castOther.getTearolename()) || (this
						.getTearolename() != null
						&& castOther.getTearolename() != null && this
						.getTearolename().equals(castOther.getTearolename())))
				&& ((this.getTeacollegename() == castOther.getTeacollegename()) || (this
						.getTeacollegename() != null
						&& castOther.getTeacollegename() != null && this
						.getTeacollegename().equals(
								castOther.getTeacollegename())))
				&& ((this.getPwd() == castOther.getPwd()) || (this.getPwd() != null
						&& castOther.getPwd() != null && this.getPwd().equals(
						castOther.getPwd())))
				&& ((this.getAgend() == castOther.getAgend()) || (this
						.getAgend() != null && castOther.getAgend() != null && this
						.getAgend().equals(castOther.getAgend())))
				&& ((this.getTeapwd() == castOther.getTeapwd()) || (this
						.getTeapwd() != null && castOther.getTeapwd() != null && this
						.getTeapwd().equals(castOther.getTeapwd())))
				&& ((this.getTeaagend() == castOther.getTeaagend()) || (this
						.getTeaagend() != null
						&& castOther.getTeaagend() != null && this
						.getTeaagend().equals(castOther.getTeaagend())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSceneid() == null ? 0 : this.getSceneid().hashCode());
		result = 37 * result
				+ (getArrid() == null ? 0 : this.getArrid().hashCode());
		result = 37 * result
				+ (getArrname() == null ? 0 : this.getArrname().hashCode());
		result = 37 * result
				+ (getStarttime() == null ? 0 : this.getStarttime().hashCode());
		result = 37 * result
				+ (getEndtime() == null ? 0 : this.getEndtime().hashCode());
		result = 37 * result
				+ (getAddr() == null ? 0 : this.getAddr().hashCode());
		result = 37 * result
				+ (getLeveltype() == null ? 0 : this.getLeveltype().hashCode());
		result = 37 * result
				+ (getState() == null ? 0 : this.getState().hashCode());
		result = 37 * result
				+ (getMatchid() == null ? 0 : this.getMatchid().hashCode());
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
				+ (getUserid() == null ? 0 : this.getUserid().hashCode());
		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getMobile() == null ? 0 : this.getMobile().hashCode());
		result = 37 * result
				+ (getClassid() == null ? 0 : this.getClassid().hashCode());
		result = 37 * result
				+ (getRoleid() == null ? 0 : this.getRoleid().hashCode());
		result = 37 * result
				+ (getRolename() == null ? 0 : this.getRolename().hashCode());
		result = 37 * result
				+ (getClassname() == null ? 0 : this.getClassname().hashCode());
		result = 37 * result
				+ (getMajorid() == null ? 0 : this.getMajorid().hashCode());
		result = 37 * result
				+ (getMajorname() == null ? 0 : this.getMajorname().hashCode());
		result = 37 * result
				+ (getCollegeid() == null ? 0 : this.getCollegeid().hashCode());
		result = 37
				* result
				+ (getCollegename() == null ? 0 : this.getCollegename()
						.hashCode());
		result = 37
				* result
				+ (getTeausername() == null ? 0 : this.getTeausername()
						.hashCode());
		result = 37 * result
				+ (getTeamobile() == null ? 0 : this.getTeamobile().hashCode());
		result = 37
				* result
				+ (getTeacollegeid() == null ? 0 : this.getTeacollegeid()
						.hashCode());
		result = 37 * result
				+ (getTearoleid() == null ? 0 : this.getTearoleid().hashCode());
		result = 37
				* result
				+ (getTearolename() == null ? 0 : this.getTearolename()
						.hashCode());
		result = 37
				* result
				+ (getTeacollegename() == null ? 0 : this.getTeacollegename()
						.hashCode());
		result = 37 * result
				+ (getPwd() == null ? 0 : this.getPwd().hashCode());
		result = 37 * result
				+ (getAgend() == null ? 0 : this.getAgend().hashCode());
		result = 37 * result
				+ (getTeapwd() == null ? 0 : this.getTeapwd().hashCode());
		result = 37 * result
				+ (getTeaagend() == null ? 0 : this.getTeaagend().hashCode());
		return result;
	}

}