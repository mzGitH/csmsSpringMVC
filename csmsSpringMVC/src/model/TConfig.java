package model;


/**
 * TConfig entity. @author MyEclipse Persistence Tools
 */

public class TConfig implements java.io.Serializable {

	// Fields

	private Integer configid;
	private String starttime;
	private String endtime;
	private String reportstart;
	private String reportend;

	// Constructors

	/** default constructor */
	public TConfig() {
	}

	/** full constructor */
	public TConfig(String starttime, String endtime,
			String reportstart, String reportend) {
		this.starttime = starttime;
		this.endtime = endtime;
		this.reportstart = reportstart;
		this.reportend = reportend;
	}

	// Property accessors

	public Integer getConfigid() {
		return this.configid;
	}

	public void setConfigid(Integer configid) {
		this.configid = configid;
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

}