package model;

/**
 * TPhoto entity. @author MyEclipse Persistence Tools
 */

public class TPhoto implements java.io.Serializable {

	// Fields

	private Integer picid;
	private String picpath;

	// Constructors

	/** default constructor */
	public TPhoto() {
	}

	/** full constructor */
	public TPhoto(String picpath) {
		this.picpath = picpath;
	}

	// Property accessors

	public Integer getPicid() {
		return this.picid;
	}

	public void setPicid(Integer picid) {
		this.picid = picid;
	}

	public String getPicpath() {
		return this.picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

}