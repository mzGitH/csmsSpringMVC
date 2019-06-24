package model;

/**
 * TForumContent entity. @author MyEclipse Persistence Tools
 */

public class TForumContent implements java.io.Serializable {

	// Fields

	private Integer contentid;
	private Integer forumid;
	private String textcontent;
	private Integer picid;

	// Constructors

	/** default constructor */
	public TForumContent() {
	}

	/** minimal constructor */
	public TForumContent(Integer forumid, String textcontent) {
		this.forumid = forumid;
		this.textcontent = textcontent;
	}

	/** full constructor */
	public TForumContent(Integer forumid, String textcontent, Integer picid) {
		this.forumid = forumid;
		this.textcontent = textcontent;
		this.picid = picid;
	}

	// Property accessors

	public Integer getContentid() {
		return this.contentid;
	}

	public void setContentid(Integer contentid) {
		this.contentid = contentid;
	}

	public Integer getForumid() {
		return this.forumid;
	}

	public void setForumid(Integer forumid) {
		this.forumid = forumid;
	}

	public String getTextcontent() {
		return this.textcontent;
	}

	public void setTextcontent(String textcontent) {
		this.textcontent = textcontent;
	}

	public Integer getPicid() {
		return this.picid;
	}

	public void setPicid(Integer picid) {
		this.picid = picid;
	}

}