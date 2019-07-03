package model;

/**
 * TScore entity. @author MyEclipse Persistence Tools
 */

public class TScore implements java.io.Serializable {

	// Fields

	private Integer scoreid;
	private Integer matchid;
	private Double scorenumber;
	private String scorerecord;

	// Constructors

	/** default constructor */
	public TScore() {
	}

	/** minimal constructor */
	public TScore(Integer matchid, Double scorenumber) {
		this.matchid = matchid;
		this.scorenumber = scorenumber;
	}

	/** full constructor */
	public TScore(Integer matchid, Double scorenumber, String scorerecord) {
		this.matchid = matchid;
		this.scorenumber = scorenumber;
		this.scorerecord = scorerecord;
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

	public String getScorerecord() {
		return this.scorerecord;
	}

	public void setScorerecord(String scorerecord) {
		this.scorerecord = scorerecord;
	}

}