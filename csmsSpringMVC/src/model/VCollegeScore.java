package model;

/**
 * VCollegeScore entity. @author MyEclipse Persistence Tools
 */

public class VCollegeScore implements java.io.Serializable {

	private Integer collegeid;
	private String collegename;
	private Double scorenumber;

	// Constructors

	/** default constructor */
	public VCollegeScore() {
	}

	/** full constructor */
	public VCollegeScore(Integer collegeid, String collegename,
			Double scorenumber) {
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.scorenumber = scorenumber;
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
		if (!(other instanceof VCollegeScore))
			return false;
		VCollegeScore castOther = (VCollegeScore) other;

		return ((this.getCollegeid() == castOther.getCollegeid()) || (this
				.getCollegeid() != null && castOther.getCollegeid() != null && this
				.getCollegeid().equals(castOther.getCollegeid())))
				&& ((this.getCollegename() == castOther.getCollegename()) || (this
						.getCollegename() != null
						&& castOther.getCollegename() != null && this
						.getCollegename().equals(castOther.getCollegename())))
				&& ((this.getScorenumber() == castOther.getScorenumber()) || (this
						.getScorenumber() != null
						&& castOther.getScorenumber() != null && this
						.getScorenumber().equals(castOther.getScorenumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCollegeid() == null ? 0 : this.getCollegeid().hashCode());
		result = 37
				* result
				+ (getCollegename() == null ? 0 : this.getCollegename()
						.hashCode());
		result = 37
				* result
				+ (getScorenumber() == null ? 0 : this.getScorenumber()
						.hashCode());
		return result;
	}

}