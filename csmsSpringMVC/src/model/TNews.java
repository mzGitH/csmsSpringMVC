package model;

/**
 * TNews entity. @author MyEclipse Persistence Tools
 */

public class TNews implements java.io.Serializable {

	// Fields

	private Integer newid;
	private String newstitle;
	private String newscontent;
	private Integer teacerid;

	// Constructors

	/** default constructor */
	public TNews() {
	}

	/** full constructor */
	public TNews(String newstitle, String newscontent, Integer teacerid) {
		this.newstitle = newstitle;
		this.newscontent = newscontent;
		this.teacerid = teacerid;
	}

	// Property accessors

	public Integer getNewid() {
		return this.newid;
	}

	public void setNewid(Integer newid) {
		this.newid = newid;
	}

	public String getNewstitle() {
		return this.newstitle;
	}

	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}

	public String getNewscontent() {
		return this.newscontent;
	}

	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}

	public Integer getTeacerid() {
		return this.teacerid;
	}

	public void setTeacerid(Integer teacerid) {
		this.teacerid = teacerid;
	}

}