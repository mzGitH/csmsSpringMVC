package model;

/**
 * TConfig entity. @author MyEclipse Persistence Tools
 */

public class TConfig implements java.io.Serializable {

	// Fields

	private Integer sportid;
	private String sportname;
	private String starttime;
	private String endtime;
	private String reportstart;
	private String reportend;
	private Boolean iscomplete;

	// Constructors

	/** default constructor */
	public TConfig() {
	}

	/** minimal constructor */
	public TConfig(String sportname, String starttime, String endtime,
			String reportstart, String reportend) {
		this.sportname = sportname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.reportstart = reportstart;
		this.reportend = reportend;
	}

	/** full constructor */
	public TConfig(String sportname, String starttime, String endtime,
			String reportstart, String reportend, Boolean iscomplete) {
		this.sportname = sportname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.reportstart = reportstart;
		this.reportend = reportend;
		this.iscomplete = iscomplete;
	}

	// Property accessors

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

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getReportstart() {
		return this.reportstart;
	}

	public void setReportstart(String reportstart) {
		this.reportstart = reportstart;
	}

	public String getReportend() {
		return this.reportend;
	}

	public void setReportend(String reportend) {
		this.reportend = reportend;
	}

	public Boolean getIscomplete() {
		return this.iscomplete;
	}

	public void setIscomplete(Boolean iscomplete) {
		this.iscomplete = iscomplete;
	}

}