package model;



/**
 * VForum entity. @author MyEclipse Persistence Tools
 */

public class VForum  implements java.io.Serializable {

	private String id;
    private Integer forumid;
    private String title;
    private Integer contentid;
    private String textcontent;
    private Integer picid;
    private String picpath;
    private String author;
    private String createtime;


   // Constructors

   /** default constructor */
   public VForum() {
   }

	/** minimal constructor */
   public VForum(Integer forumid, String title, Integer contentid, String textcontent, String author, String createtime) {
       this.forumid = forumid;
       this.title = title;
       this.contentid = contentid;
       this.textcontent = textcontent;
       this.author = author;
       this.createtime = createtime;
   }
   
   /** full constructor */
   public VForum(String id, Integer forumid, String title, Integer contentid, String textcontent, Integer picid, String picpath, String author, String createtime) {
       this.id = id;
       this.forumid = forumid;
       this.title = title;
       this.contentid = contentid;
       this.textcontent = textcontent;
       this.picid = picid;
       this.picpath = picpath;
       this.author = author;
       this.createtime = createtime;
   }

  
   // Property accessors

   public String getId() {
       return this.id;
   }
   
   public void setId(String id) {
       this.id = id;
   }

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

   public Integer getContentid() {
       return this.contentid;
   }
   
   public void setContentid(Integer contentid) {
       this.contentid = contentid;
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

   public String getPicpath() {
       return this.picpath;
   }
   
   public void setPicpath(String picpath) {
       this.picpath = picpath;
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
  



  public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VForum) ) return false;
		 VForum castOther = ( VForum ) other; 
        
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
&& ( (this.getForumid()==castOther.getForumid()) || ( this.getForumid()!=null && castOther.getForumid()!=null && this.getForumid().equals(castOther.getForumid()) ) )
&& ( (this.getTitle()==castOther.getTitle()) || ( this.getTitle()!=null && castOther.getTitle()!=null && this.getTitle().equals(castOther.getTitle()) ) )
&& ( (this.getContentid()==castOther.getContentid()) || ( this.getContentid()!=null && castOther.getContentid()!=null && this.getContentid().equals(castOther.getContentid()) ) )
&& ( (this.getTextcontent()==castOther.getTextcontent()) || ( this.getTextcontent()!=null && castOther.getTextcontent()!=null && this.getTextcontent().equals(castOther.getTextcontent()) ) )
&& ( (this.getPicid()==castOther.getPicid()) || ( this.getPicid()!=null && castOther.getPicid()!=null && this.getPicid().equals(castOther.getPicid()) ) )
&& ( (this.getPicpath()==castOther.getPicpath()) || ( this.getPicpath()!=null && castOther.getPicpath()!=null && this.getPicpath().equals(castOther.getPicpath()) ) )
&& ( (this.getAuthor()==castOther.getAuthor()) || ( this.getAuthor()!=null && castOther.getAuthor()!=null && this.getAuthor().equals(castOther.getAuthor()) ) )
&& ( (this.getCreatetime()==castOther.getCreatetime()) || ( this.getCreatetime()!=null && castOther.getCreatetime()!=null && this.getCreatetime().equals(castOther.getCreatetime()) ) );
  }
  
  public int hashCode() {
        int result = 17;
        
        result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
        result = 37 * result + ( getForumid() == null ? 0 : this.getForumid().hashCode() );
        result = 37 * result + ( getTitle() == null ? 0 : this.getTitle().hashCode() );
        result = 37 * result + ( getContentid() == null ? 0 : this.getContentid().hashCode() );
        result = 37 * result + ( getTextcontent() == null ? 0 : this.getTextcontent().hashCode() );
        result = 37 * result + ( getPicid() == null ? 0 : this.getPicid().hashCode() );
        result = 37 * result + ( getPicpath() == null ? 0 : this.getPicpath().hashCode() );
        result = 37 * result + ( getAuthor() == null ? 0 : this.getAuthor().hashCode() );
        result = 37 * result + ( getCreatetime() == null ? 0 : this.getCreatetime().hashCode() );
        return result;
  }
}