package model;

/**
 * TScene entity. @author MyEclipse Persistence Tools
 */

public class TScene implements java.io.Serializable {

	// Fields

	private Integer sceneid;
	private Integer arrid;
	private Integer matchid;

	// Constructors

	/** default constructor */
	public TScene() {
	}

	/** full constructor */
	public TScene(Integer arrid, Integer matchid) {
		this.arrid = arrid;
		this.matchid = matchid;
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

	public Integer getMatchid() {
		return this.matchid;
	}

	public void setMatchid(Integer matchid) {
		this.matchid = matchid;
	}

}