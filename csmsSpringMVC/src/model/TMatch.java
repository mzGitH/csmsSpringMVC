package model;

/**
 * TMatch entity. @author MyEclipse Persistence Tools
 */

public class TMatch implements java.io.Serializable {

	// Fields

	private Integer matchid;
	private Integer proid;
	private String userid;

	// Constructors

	/** default constructor */
	public TMatch() {
	}

	/** full constructor */
	public TMatch(Integer proid, String userid) {
		this.proid = proid;
		this.userid = userid;
	}

	// Property accessors

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

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}