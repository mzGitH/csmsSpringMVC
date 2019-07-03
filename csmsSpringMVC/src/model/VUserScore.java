package model;

/**
 * VUserScore entity. @author MyEclipse Persistence Tools
 */

public class VUserScore implements java.io.Serializable {
	private String userid;
	private String username;
	private Integer collegeid;
	private String collegename;
	private Integer majorid;
	private String majorname;
	private Integer classid;
	private String classname;
	private Integer sportid;
	private String sportname;
	private Double scorenumber;
	private Double allscore;
	private String scorerecord;

	// Constructors

	/** default constructor */
	public VUserScore() {
	}

	/** minimal constructor */
	public VUserScore(String userid) {
		this.userid = userid;
	}

	/** full constructor */
	public VUserScore(String userid, String username, Integer collegeid,
			String collegename, Integer majorid, String majorname,
			Integer classid, String classname, Integer sportid,
			String sportname, Double scorenumber, Double allscore,
			String scorerecord) {
		this.userid = userid;
		this.username = username;
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.majorid = majorid;
		this.majorname = majorname;
		this.classid = classid;
		this.classname = classname;
		this.sportid = sportid;
		this.sportname = sportname;
		this.scorenumber = scorenumber;
		this.allscore = allscore;
		this.scorerecord = scorerecord;
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

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Integer getSportid() {
		return this.sportid;
	}

	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}

	public String getSportname() {
		return this.sportname;
	}

	public void setSportname(String sportname) {
		this.sportname = sportname;
	}

	public Double getScorenumber() {
		return this.scorenumber;
	}

	public void setScorenumber(Double scorenumber) {
		this.scorenumber = scorenumber;
	}

	public Double getAllscore() {
		return this.allscore;
	}

	public void setAllscore(Double allscore) {
		this.allscore = allscore;
	}

	public String getScorerecord() {
		return this.scorerecord;
	}

	public void setScorerecord(String scorerecord) {
		this.scorerecord = scorerecord;
	}
}