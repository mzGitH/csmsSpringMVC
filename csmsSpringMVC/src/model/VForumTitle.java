package model;

/**
 * VForumTitle entity. @author MyEclipse Persistence Tools
 */

public class VForumTitle implements java.io.Serializable {
	private Integer forumid;
	private String title;
	private String author;
	private String createtime;
	private Integer sportid;
	private String sportname;

	// Constructors

	/** default constructor */
	public VForumTitle() {
	}

	/** full constructor */
	public VForumTitle(Integer forumid, String title, String author,
			String createtime, Integer sportid, String sportname) {
		this.forumid = forumid;
		this.title = title;
		this.author = author;
		this.createtime = createtime;
		this.sportid = sportid;
		this.sportname = sportname;
	}

	// Property accessors

	public Integer getForumid() {
		return this.forumid;
	}

	public void setForumid(Integer forumid) {
		this.forumid = forumid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
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
}