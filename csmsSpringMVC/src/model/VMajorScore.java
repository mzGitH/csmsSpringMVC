package model;

/**
 * VMajorScore entity. @author MyEclipse Persistence Tools
 */

public class VMajorScore implements java.io.Serializable {
	private Integer collegeid;
	private String collegename;
	private Integer majorid;
	private String majorname;
	private Integer sportid;
	private String sportname;
	private Double scorenumber;
	private Double allscore;

	// Constructors

	/** default constructor */
	public VMajorScore() {
	}

	/** full constructor */
	public VMajorScore(Integer collegeid, String collegename,
			Integer majorid, String majorname, Integer sportid,
			String sportname, Double scorenumber, Double allscore) {
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.majorid = majorid;
		this.majorname = majorname;
		this.sportid = sportid;
		this.sportname = sportname;
		this.scorenumber = scorenumber;
		this.allscore = allscore;
	}

	// Property accessors

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
}