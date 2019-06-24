package model;

/**
 * TScore entity. @author MyEclipse Persistence Tools
 */

public class TScore implements java.io.Serializable {

	// Fields

	private Integer scoreid;
	private Integer matchid;
	private Double scorenumber;

	// Constructors

	/** default constructor */
	public TScore() {
	}

	/** full constructor */
	public TScore(Integer matchid, Double scorenumber) {
		this.matchid = matchid;
		this.scorenumber = scorenumber;
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

}