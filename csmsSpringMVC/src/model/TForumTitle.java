package model;


/**
 * TForumTitle entity. @author MyEclipse Persistence Tools
 */

public class TForumTitle implements java.io.Serializable {

	// Fields

	private Integer forumid;
	private String title;
	private String author;
	private String createtime;

	// Constructors

	/** default constructor */
	public TForumTitle() {
	}

	/** full constructor */
	public TForumTitle(String title, String author, String createtime) {
		this.title = title;
		this.author = author;
		this.createtime = createtime;
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

}