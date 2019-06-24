package model;

/**
 * VArrange entity. @author MyEclipse Persistence Tools
 */

public class VArrange implements java.io.Serializable {

	private Integer arrid;
	private String arrname;
	private Integer proid;
	private String proname;
	private String starttime;
	private String endtime;
	private String addr;
	private Integer leveltype;
	private Integer state;
	private Integer scenelimit;
	private Integer collegelimit;
	private Integer totallimit;
	private Integer protype;

	// Constructors

	/** default constructor */
	public VArrange() {
	}

	/** full constructor */
	public VArrange(Integer arrid, String arrname, Integer proid,
			String proname, String starttime, String endtime,
			String addr, Integer leveltype, Integer state, Integer scenelimit,
			Integer collegelimit, Integer totallimit, Integer protype) {
		this.arrid = arrid;
		this.arrname = arrname;
		this.proid = proid;
		this.proname = proname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.addr = addr;
		this.leveltype = leveltype;
		this.state = state;
		this.scenelimit = scenelimit;
		this.collegelimit = collegelimit;
		this.totallimit = totallimit;
		this.protype = protype;
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

	public String getProname() {
		return this.proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
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

	public Integer getScenelimit() {
		return this.scenelimit;
	}

	public void setScenelimit(Integer scenelimit) {
		this.scenelimit = scenelimit;
	}

	public Integer getCollegelimit() {
		return this.collegelimit;
	}

	public void setCollegelimit(Integer collegelimit) {
		this.collegelimit = collegelimit;
	}

	public Integer getTotallimit() {
		return this.totallimit;
	}

	public void setTotallimit(Integer totallimit) {
		this.totallimit = totallimit;
	}

	public Integer getProtype() {
		return this.protype;
	}

	public void setProtype(Integer protype) {
		this.protype = protype;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VArrange))
			return false;
		VArrange castOther = (VArrange) other;

		return ((this.getArrid() == castOther.getArrid()) || (this.getArrid() != null
				&& castOther.getArrid() != null && this.getArrid().equals(
				castOther.getArrid())))
				&& ((this.getArrname() == castOther.getArrname()) || (this
						.getArrname() != null && castOther.getArrname() != null && this
						.getArrname().equals(castOther.getArrname())))
				&& ((this.getProid() == castOther.getProid()) || (this
						.getProid() != null && castOther.getProid() != null && this
						.getProid().equals(castOther.getProid())))
				&& ((this.getProname() == castOther.getProname()) || (this
						.getProname() != null && castOther.getProname() != null && this
						.getProname().equals(castOther.getProname())))
				&& ((this.getStarttime() == castOther.getStarttime()) || (this
						.getStarttime() != null
						&& castOther.getStarttime() != null && this
						.getStarttime().equals(castOther.getStarttime())))
				&& ((this.getEndtime() == castOther.getEndtime()) || (this
						.getEndtime() != null && castOther.getEndtime() != null && this
						.getEndtime().equals(castOther.getEndtime())))
				&& ((this.getAddr() == castOther.getAddr()) || (this.getAddr() != null
						&& castOther.getAddr() != null && this.getAddr()
						.equals(castOther.getAddr())))
				&& ((this.getLeveltype() == castOther.getLeveltype()) || (this
						.getLeveltype() != null
						&& castOther.getLeveltype() != null && this
						.getLeveltype().equals(castOther.getLeveltype())))
				&& ((this.getState() == castOther.getState()) || (this
						.getState() != null && castOther.getState() != null && this
						.getState().equals(castOther.getState())))
				&& ((this.getScenelimit() == castOther.getScenelimit()) || (this
						.getScenelimit() != null
						&& castOther.getScenelimit() != null && this
						.getScenelimit().equals(castOther.getScenelimit())))
				&& ((this.getCollegelimit() == castOther.getCollegelimit()) || (this
						.getCollegelimit() != null
						&& castOther.getCollegelimit() != null && this
						.getCollegelimit().equals(castOther.getCollegelimit())))
				&& ((this.getTotallimit() == castOther.getTotallimit()) || (this
						.getTotallimit() != null
						&& castOther.getTotallimit() != null && this
						.getTotallimit().equals(castOther.getTotallimit())))
				&& ((this.getProtype() == castOther.getProtype()) || (this
						.getProtype() != null && castOther.getProtype() != null && this
						.getProtype().equals(castOther.getProtype())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getArrid() == null ? 0 : this.getArrid().hashCode());
		result = 37 * result
				+ (getArrname() == null ? 0 : this.getArrname().hashCode());
		result = 37 * result
				+ (getProid() == null ? 0 : this.getProid().hashCode());
		result = 37 * result
				+ (getProname() == null ? 0 : this.getProname().hashCode());
		result = 37 * result
				+ (getStarttime() == null ? 0 : this.getStarttime().hashCode());
		result = 37 * result
				+ (getEndtime() == null ? 0 : this.getEndtime().hashCode());
		result = 37 * result
				+ (getAddr() == null ? 0 : this.getAddr().hashCode());
		result = 37 * result
				+ (getLeveltype() == null ? 0 : this.getLeveltype().hashCode());
		result = 37 * result
				+ (getState() == null ? 0 : this.getState().hashCode());
		result = 37
				* result
				+ (getScenelimit() == null ? 0 : this.getScenelimit()
						.hashCode());
		result = 37
				* result
				+ (getCollegelimit() == null ? 0 : this.getCollegelimit()
						.hashCode());
		result = 37
				* result
				+ (getTotallimit() == null ? 0 : this.getTotallimit()
						.hashCode());
		result = 37 * result
				+ (getProtype() == null ? 0 : this.getProtype().hashCode());
		return result;
	}
}