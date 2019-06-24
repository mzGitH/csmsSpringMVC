package model;

/**
 * VClassScore entity. @author MyEclipse Persistence Tools
 */

public class VClassScore implements java.io.Serializable {

	private Integer classid;
	private String collegename;
	private String majorname;
	private String classname;
	private Double scorenumber;

	// Constructors

	/** default constructor */
	public VClassScore() {
	}

	/** minimal constructor */
	public VClassScore(String majorname) {
		this.majorname = majorname;
	}

	/** full constructor */
	public VClassScore(Integer classid, String collegename, String majorname,
			String classname, Double scorenumber) {
		this.classid = classid;
		this.collegename = collegename;
		this.majorname = majorname;
		this.classname = classname;
		this.scorenumber = scorenumber;
	}

	// Property accessors

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public String getCollegename() {
		return this.collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
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

	public Double getScorenumber() {
		return this.scorenumber;
	}

	public void setScorenumber(Double scorenumber) {
		this.scorenumber = scorenumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VClassScore))
			return false;
		VClassScore castOther = (VClassScore) other;

		return ((this.getClassid() == castOther.getClassid()) || (this
				.getClassid() != null && castOther.getClassid() != null && this
				.getClassid().equals(castOther.getClassid())))
				&& ((this.getCollegename() == castOther.getCollegename()) || (this
						.getCollegename() != null
						&& castOther.getCollegename() != null && this
						.getCollegename().equals(castOther.getCollegename())))
				&& ((this.getMajorname() == castOther.getMajorname()) || (this
						.getMajorname() != null
						&& castOther.getMajorname() != null && this
						.getMajorname().equals(castOther.getMajorname())))
				&& ((this.getClassname() == castOther.getClassname()) || (this
						.getClassname() != null
						&& castOther.getClassname() != null && this
						.getClassname().equals(castOther.getClassname())))
				&& ((this.getScorenumber() == castOther.getScorenumber()) || (this
						.getScorenumber() != null
						&& castOther.getScorenumber() != null && this
						.getScorenumber().equals(castOther.getScorenumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getClassid() == null ? 0 : this.getClassid().hashCode());
		result = 37
				* result
				+ (getCollegename() == null ? 0 : this.getCollegename()
						.hashCode());
		result = 37 * result
				+ (getMajorname() == null ? 0 : this.getMajorname().hashCode());
		result = 37 * result
				+ (getClassname() == null ? 0 : this.getClassname().hashCode());
		result = 37
				* result
				+ (getScorenumber() == null ? 0 : this.getScorenumber()
						.hashCode());
		return result;
	}
}