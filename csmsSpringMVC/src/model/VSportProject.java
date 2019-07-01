package model;

/**
 * VSportProject entity. @author MyEclipse Persistence Tools
 */

public class VSportProject  implements java.io.Serializable {
	private Integer id;
    private Integer sportid;
    private String sportname;
    private String starttime;
    private String endtime;
    private String reportstart;
    private String reportend;
    private Integer proid;
    private String proname;
    private Integer scenelimit;
    private Integer collegelimit;
    private Integer totallimit;
    private Integer protype;
    private Integer currentnum;
    private String record;
    private Integer collegeid;
    private String collegename;
    private Integer classid;
    private String classname;
    private Integer majorid;
    private String majorname;
    private Integer recordsportid;
    private String recordsportname;
    private String holderid;
    private String holdername;


   // Constructors

   /** default constructor */
   public VSportProject() {
   }

	/** minimal constructor */
   public VSportProject(Integer id, Integer sportid, String sportname, String starttime, String endtime, String reportstart, String reportend, Integer proid) {
       this.id = id;
       this.sportid = sportid;
       this.sportname = sportname;
       this.starttime = starttime;
       this.endtime = endtime;
       this.reportstart = reportstart;
       this.reportend = reportend;
       this.proid = proid;
   }
   
   /** full constructor */
   public VSportProject(Integer id, Integer sportid, String sportname, String starttime, String endtime, String reportstart, String reportend, Integer proid, String proname, Integer scenelimit, Integer collegelimit, Integer totallimit, Integer protype, Integer currentnum, String record, Integer collegeid, String collegename, Integer classid, String classname, Integer majorid, String majorname, Integer recordsportid, String recordsportname, String holderid, String holdername) {
       this.id = id;
       this.sportid = sportid;
       this.sportname = sportname;
       this.starttime = starttime;
       this.endtime = endtime;
       this.reportstart = reportstart;
       this.reportend = reportend;
       this.proid = proid;
       this.proname = proname;
       this.scenelimit = scenelimit;
       this.collegelimit = collegelimit;
       this.totallimit = totallimit;
       this.protype = protype;
       this.currentnum = currentnum;
       this.record = record;
       this.collegeid = collegeid;
       this.collegename = collegename;
       this.classid = classid;
       this.classname = classname;
       this.majorid = majorid;
       this.majorname = majorname;
       this.recordsportid = recordsportid;
       this.recordsportname = recordsportname;
       this.holderid = holderid;
       this.holdername = holdername;
   }

  
   // Property accessors

   public Integer getId() {
       return this.id;
   }
   
   public void setId(Integer id) {
       this.id = id;
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

   public Integer getCurrentnum() {
       return this.currentnum;
   }
   
   public void setCurrentnum(Integer currentnum) {
       this.currentnum = currentnum;
   }

   public String getRecord() {
       return this.record;
   }
   
   public void setRecord(String record) {
       this.record = record;
   }

   public Integer getCollegeid() {
       return this.collegeid;
   }
   
   public void setCollegeid(Integer collegeid) {
       this.collegeid = collegeid;
   }

   public String getCollegename() {
       return this.collegename;
   }
   
   public void setCollegename(String collegename) {
       this.collegename = collegename;
   }

   public Integer getClassid() {
       return this.classid;
   }
   
   public void setClassid(Integer classid) {
       this.classid = classid;
   }

   public String getClassname() {
       return this.classname;
   }
   
   public void setClassname(String classname) {
       this.classname = classname;
   }

   public Integer getMajorid() {
       return this.majorid;
   }
   
   public void setMajorid(Integer majorid) {
       this.majorid = majorid;
   }

   public String getMajorname() {
       return this.majorname;
   }
   
   public void setMajorname(String majorname) {
       this.majorname = majorname;
   }

   public Integer getRecordsportid() {
       return this.recordsportid;
   }
   
   public void setRecordsportid(Integer recordsportid) {
       this.recordsportid = recordsportid;
   }

   public String getRecordsportname() {
       return this.recordsportname;
   }
   
   public void setRecordsportname(String recordsportname) {
       this.recordsportname = recordsportname;
   }

   public String getHolderid() {
       return this.holderid;
   }
   
   public void setHolderid(String holderid) {
       this.holderid = holderid;
   }

   public String getHoldername() {
       return this.holdername;
   }
   
   public void setHoldername(String holdername) {
       this.holdername = holdername;
   }
}