package business.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.dao.AdminRoleDAO;
import business.dao.AdminUserDAO;
import business.dao.ArrangeDAO;
import business.dao.ClassesDAO;
import business.dao.CollegeDAO;
import business.dao.ConfigDAO;
import business.dao.ContentDAO;
import business.dao.ForumDAO;
import business.dao.MajorDAO;
import business.dao.MatchDAO;
import business.dao.NewsDAO;
import business.dao.PhotoDAO;
import business.dao.ProjectDAO;
import business.dao.SceneDAO;
import business.dao.ScoreClassesDAO;
import business.dao.ScoreCollegeDAO;
import business.dao.ScoreDAO;
import business.dao.ScoreStudentDAO;
import business.dao.SportsDAO;
import business.dao.SystemLogDAO;
import business.dao.SystemModelDAO;
import business.dao.UserDAO;

public class DAOFactory {
	private static ApplicationContext ctx = null;

	static {
		ctx = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
	}

	/**
	 * 得到一个用于管理员业务操作的AdminUserDAO实现类对象
	 * 
	 * @return AdminUserDAO
	 */
	public static AdminUserDAO getAdminUserDAO() {
		return (AdminUserDAO) ctx.getBean("adminuserdao");
	}

	/**
	 * 得到一个用于管理员角色业务操作的AdminRoleDAO实现类对象
	 * 
	 * @return AdminRoleDAO
	 */
	public static AdminRoleDAO getAdminRoleDAO() {
		return (AdminRoleDAO) ctx.getBean("adminroledao");
	}

	/**
	 * 得到一个用于比赛业务操作的AdminRoleDAO实现类对象
	 * 
	 * @return ArrangeDAO
	 */
	public static ArrangeDAO getArrangDAO() {
		return (ArrangeDAO) ctx.getBean("arrangedao");
	}

	/**
	 * 得到一个用于比赛业务操作的ClassesDAO实现类对象
	 * 
	 * @return ClassesDAO
	 */
	public static ClassesDAO getClassesDAO() {
		return (ClassesDAO) ctx.getBean("classesdao");
	}

	/**
	 * 得到一个学院业务操作的CollegeDAO实现类对象
	 * 
	 * @return CollegeDAO
	 */
	public static CollegeDAO getCollegeDAO() {
		return (CollegeDAO) ctx.getBean("collegedao");
	}

	/**
	 * 得到一个运动会业务操作的ConfigDAO实现类对象
	 * 
	 * @return ConfigDAO
	 */
	public static ConfigDAO getConfigDAO() {
		return (ConfigDAO) ctx.getBean("configdao");
	}

	/**
	 * 得到一个文章内容操作的ContentDAO实现类对象
	 * 
	 * @return ContentDAO
	 */
	public static ContentDAO getContentDAO() {
		return (ContentDAO) ctx.getBean("contentdao");
	}

	/**
	 * 得到一个用于文章业务操作的ForumDAO实现类对象
	 * 
	 * @return ForumDAO
	 */
	public static ForumDAO getForumDAO() {
		return (ForumDAO) ctx.getBean("forumdao");
	}

	/**
	 * 得到一个用于专业业务操作的MajorDAO实现类对象
	 * 
	 * @return MajorDAO
	 */
	public static MajorDAO getMajorDAO() {
		return (MajorDAO) ctx.getBean("majordao");
	}

	/**
	 * 得到一个用于专业业务操作的MatchDAO实现类对象
	 * 
	 * @return MatchDAO
	 */
	public static MatchDAO getMatchDAO() {
		return (MatchDAO) ctx.getBean("matchdao");
	}

	/**
	 * 得到一个用于专业业务操作的NewsDAO实现类对象
	 * 
	 * @return NewsDAO
	 */
	public static NewsDAO getNewsDAO() {
		return (NewsDAO) ctx.getBean("newsdao");
	}

	/**
	 * 返回一个用于操作图片资源的PhotoDAO对象
	 * 
	 * @return PhotoDAO
	 */
	public static PhotoDAO getPhotoDAO() {
		return (PhotoDAO) ctx.getBean("photodao");
	}

	/**
	 * 返回一个用于操作项目的ProjectDAO对象
	 * 
	 * @return ProjectDAO
	 */
	public static ProjectDAO getProjectDAO() {
		return (ProjectDAO) ctx.getBean("projectdao");
	}

	/**
	 * 返回一个用于操作比赛场次的SceneDAO对象
	 * 
	 * @return SceneDAO
	 */
	public static SceneDAO getSceneDAO() {
		return (SceneDAO) ctx.getBean("scenedao");
	}

	/**
	 * 返回一个用于操作比赛班级成绩的ScoreClassesDAO对象
	 * 
	 * @return ScoreClassesDAO
	 */
	public static ScoreClassesDAO getScoreClassesDAO() {
		return (ScoreClassesDAO) ctx.getBean("scoreclassesdao");
	}

	/**
	 * 返回一个用于操作比赛学院成绩的ScoreCollegeDAO对象
	 * 
	 * @return ScoreCollegeDAO
	 */
	public static ScoreCollegeDAO getScoreCollegeDAO() {
		return (ScoreCollegeDAO) ctx.getBean("scorecollegedao");
	}

	/**
	 * 返回一个用于操作比赛成绩的ScoreDAO对象
	 * 
	 * @return ScoreDAO
	 */
	public static ScoreDAO getScoreDAO() {
		return (ScoreDAO) ctx.getBean("scoredao");
	}

	/**
	 * 返回一个用于操作比赛学生成绩的ScoreStudentDAO对象
	 * 
	 * @return ScoreStudentDAO
	 */
	public static ScoreStudentDAO getScoreStudentDAO() {
		return (ScoreStudentDAO) ctx.getBean("scorestudentdao");
	}

	/**
	 * 返回一个用于操作比赛学生成绩的SportsDAO对象
	 * 
	 * @return SportsDAO
	 */
	public static SportsDAO getSportsDAO() {
		return (SportsDAO) ctx.getBean("sportsdao");
	}

	/**
	 * 得到一个用于系统菜单管理业务操作的SystemLogDAO实现类对象
	 * 
	 * @return SystemLogDAO
	 */
	public static SystemLogDAO getSystemLogDAO() {
		return (SystemLogDAO) ctx.getBean("systemlogdao");
	}

	/**
	 * 得到一个用于系统菜单管理业务操作的SystemModelDAO实现类对象
	 * 
	 * @return SystemModelDAO
	 */
	public static SystemModelDAO getSystemModelDAO() {
		return (SystemModelDAO) ctx.getBean("systemmodeldao");
	}

	/**
	 * 返回一个用于对用户信息操作的UserDAO对象
	 * 
	 * @return UserDAO
	 */
	public static UserDAO getUserDAO() {
		return (UserDAO) ctx.getBean("userdao");
	}

}
