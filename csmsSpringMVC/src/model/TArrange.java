package model;


/**
 * TArrange entity. @author MyEclipse Persistence Tools
 */

public class TArrange implements java.io.Serializable {

	// Fields

	private Integer arrid;
	private String arrname;
	private Integer proid;
	private String starttime;
	private String endtime;
	private String addr;
	private Integer leveltype;
	private Integer state;

	// Constructors

	/** default constructor */
	public TArrange() {
	}

	/** full constructor */
	public TArrange(String arrname, Integer proid, String starttime,
			String endtime, String addr, Integer leveltype, Integer state) {
		this.arrname = arrname;
		this.proid = proid;
		this.starttime = starttime;
		this.endtime = endtime;
		this.addr = addr;
		this.leveltype = leveltype;
		this.state = state;
	}

	// Property accessors

	public Integer getArrid() {
		return this.arrid;
	}

	public void setArrid(Integer arrid) {
		this.arrid = arrid;
	}

	public String getArrname() {
		return this.arrname;
	}

	public void setArrname(String arrname) {
		this.arrname = arrname;
	}

	public Integer getProid() {
		return this.proid;
	}

	public void setProid(Integer proid) {
		this.proid = proid;
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

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getLeveltype() {
		return this.leveltype;
	}

	public void setLeveltype(Integer leveltype) {
		this.leveltype = leveltype;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}