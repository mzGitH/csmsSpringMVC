package model;


/**
 * VScoreSignIn entity. @author MyEclipse Persistence Tools
 */

public class VScoreSignIn implements java.io.Serializable {

	private String id;
	private Integer arrid;
	private String arrname;
	private String starttime;
	private String endtime;
	private String addr;
	private Integer leveltype;
	private Integer state;
	private Integer proid;
	private String proname;
	private Integer protype;
	private Integer sportid;
	private String sportname;

	// Constructors

	/** default constructor */
	public VScoreSignIn() {
	}

	/** minimal constructor */
	public VScoreSignIn(Integer arrid, String arrname, String starttime,
			String endtime, String addr, Integer leveltype, Integer state) {
		this.arrid = arrid;
		this.arrname = arrname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.addr = addr;
		this.leveltype = leveltype;
		this.state = state;
	}

	/** full constructor */
	public VScoreSignIn(String id, Integer arrid, String arrname,
			String starttime, String endtime, String addr, Integer leveltype,
			Integer state, Integer proid, String proname, Integer protype,
			Integer sportid, String sportname) {
		this.id = id;
		this.arrid = arrid;
		this.arrname = arrname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.addr = addr;
		this.leveltype = leveltype;
		this.state = state;
		this.proid = proid;
		this.proname = proname;
		this.protype = protype;
		this.sportid = sportid;
		this.sportname = sportname;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public Integer getProtype() {
		return this.protype;
	}

	public void setProtype(Integer protype) {
		this.protype = protype;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VScoreSignIn))
			return false;
		VScoreSignIn castOther = (VScoreSignIn) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getArrid() == castOther.getArrid()) || (this
						.getArrid() != null && castOther.getArrid() != null && this
						.getArrid().equals(castOther.getArrid())))
				&& ((this.getArrname() == castOther.getArrname()) || (this
						.getArrname() != null && castOther.getArrname() != null && this
						.getArrname().equals(castOther.getArrname())))
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
				&& ((this.getProid() == castOther.getProid()) || (this
						.getProid() != null && castOther.getProid() != null && this
						.getProid().equals(castOther.getProid())))
				&& ((this.getProname() == castOther.getProname()) || (this
						.getProname() != null && castOther.getProname() != null && this
						.getProname().equals(castOther.getProname())))
				&& ((this.getProtype() == castOther.getProtype()) || (this
						.getProtype() != null && castOther.getProtype() != null && this
						.getProtype().equals(castOther.getProtype())))
				&& ((this.getSportid() == castOther.getSportid()) || (this
						.getSportid() != null && castOther.getSportid() != null && this
						.getSportid().equals(castOther.getSportid())))
				&& ((this.getSportname() == castOther.getSportname()) || (this
						.getSportname() != null
						&& castOther.getSportname() != null && this
						.getSportname().equals(castOther.getSportname())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getArrid() == null ? 0 : this.getArrid().hashCode());
		result = 37 * result
				+ (getArrname() == null ? 0 : this.getArrname().hashCode());
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
		result = 37 * result
				+ (getProid() == null ? 0 : this.getProid().hashCode());
		result = 37 * result
				+ (getProname() == null ? 0 : this.getProname().hashCode());
		result = 37 * result
				+ (getProtype() == null ? 0 : this.getProtype().hashCode());
		result = 37 * result
				+ (getSportid() == null ? 0 : this.getSportid().hashCode());
		result = 37 * result
				+ (getSportname() == null ? 0 : this.getSportname().hashCode());
		return result;
	}

}