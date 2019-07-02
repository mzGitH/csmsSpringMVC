package model;

/**
 * TSportProject entity. @author MyEclipse Persistence Tools
 */

public class TSportProject implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer sportid;
	private Integer proid;

	// Constructors

	/** default constructor */
	public TSportProject() {
	}

	/** full constructor */
	public TSportProject(Integer sportid, Integer proid) {
		this.sportid = sportid;
		this.proid = proid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSportid() {
		return this.sportid;
	}

	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}

	public Integer getProid() {
		return this.proid;
	}

	public void setProid(Integer proid) {
		this.proid = proid;
	}

}