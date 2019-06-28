package model;


/**
 * TNews entity. @author MyEclipse Persistence Tools
 */

public class TNews implements java.io.Serializable {

	// Fields

	private Integer newid;
	private String newstitle;
	private String newscontent;
	private String adminuserid;
	private String datetime;
	private Integer sportid;

	// Constructors

	/** default constructor */
	public TNews() {
	}

	/** minimal constructor */
	public TNews(String newstitle, String newscontent, String adminuserid,
			String datetime) {
		this.newstitle = newstitle;
		this.newscontent = newscontent;
		this.adminuserid = adminuserid;
		this.datetime = datetime;
	}

	/** full constructor */
	public TNews(String newstitle, String newscontent, String adminuserid,
			String datetime, Integer sportid) {
		this.newstitle = newstitle;
		this.newscontent = newscontent;
		this.adminuserid = adminuserid;
		this.datetime = datetime;
		this.sportid = sportid;
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

	public String getAdminuserid() {
		return this.adminuserid;
	}

	public void setAdminuserid(String adminuserid) {
		this.adminuserid = adminuserid;
	}

	public String getDatetime() {
		return this.datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public Integer getSportid() {
		return this.sportid;
	}

	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}

}