package model;

/**
 * VMajorScoreId entity. @author MyEclipse Persistence Tools
 */

public class VMajorScoreId implements java.io.Serializable {

	// Fields

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
	public VMajorScoreId() {
	}

	/** full constructor */
	public VMajorScoreId(Integer collegeid, String collegename,
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VMajorScoreId))
			return false;
		VMajorScoreId castOther = (VMajorScoreId) other;

		return ((this.getCollegeid() == castOther.getCollegeid()) || (this
				.getCollegeid() != null && castOther.getCollegeid() != null && this
				.getCollegeid().equals(castOther.getCollegeid())))
				&& ((this.getCollegename() == castOther.getCollegename()) || (this
						.getCollegename() != null
						&& castOther.getCollegename() != null && this
						.getCollegename().equals(castOther.getCollegename())))
				&& ((this.getMajorid() == castOther.getMajorid()) || (this
						.getMajorid() != null && castOther.getMajorid() != null && this
						.getMajorid().equals(castOther.getMajorid())))
				&& ((this.getMajorname() == castOther.getMajorname()) || (this
						.getMajorname() != null
						&& castOther.getMajorname() != null && this
						.getMajorname().equals(castOther.getMajorname())))
				&& ((this.getSportid() == castOther.getSportid()) || (this
						.getSportid() != null && castOther.getSportid() != null && this
						.getSportid().equals(castOther.getSportid())))
				&& ((this.getSportname() == castOther.getSportname()) || (this
						.getSportname() != null
						&& castOther.getSportname() != null && this
						.getSportname().equals(castOther.getSportname())))
				&& ((this.getScorenumber() == castOther.getScorenumber()) || (this
						.getScorenumber() != null
						&& castOther.getScorenumber() != null && this
						.getScorenumber().equals(castOther.getScorenumber())))
				&& ((this.getAllscore() == castOther.getAllscore()) || (this
						.getAllscore() != null
						&& castOther.getAllscore() != null && this
						.getAllscore().equals(castOther.getAllscore())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCollegeid() == null ? 0 : this.getCollegeid().hashCode());
		result = 37
				* result
				+ (getCollegename() == null ? 0 : this.getCollegename()
						.hashCode());
		result = 37 * result
				+ (getMajorid() == null ? 0 : this.getMajorid().hashCode());
		result = 37 * result
				+ (getMajorname() == null ? 0 : this.getMajorname().hashCode());
		result = 37 * result
				+ (getSportid() == null ? 0 : this.getSportid().hashCode());
		result = 37 * result
				+ (getSportname() == null ? 0 : this.getSportname().hashCode());
		result = 37
				* result
				+ (getScorenumber() == null ? 0 : this.getScorenumber()
						.hashCode());
		result = 37 * result
				+ (getAllscore() == null ? 0 : this.getAllscore().hashCode());
		return result;
	}

}