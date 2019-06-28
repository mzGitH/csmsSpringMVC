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
	 * �õ�һ�����ڹ���Աҵ�������AdminUserDAOʵ�������
	 * 
	 * @return AdminUserDAO
	 */
	public static AdminUserDAO getAdminUserDAO() {
		return (AdminUserDAO) ctx.getBean("adminuserdao");
	}

	/**
	 * �õ�һ�����ڹ���Ա��ɫҵ�������AdminRoleDAOʵ�������
	 * 
	 * @return AdminRoleDAO
	 */
	public static AdminRoleDAO getAdminRoleDAO() {
		return (AdminRoleDAO) ctx.getBean("adminroledao");
	}

	/**
	 * �õ�һ�����ڱ���ҵ�������AdminRoleDAOʵ�������
	 * 
	 * @return ArrangeDAO
	 */
	public static ArrangeDAO getArrangDAO() {
		return (ArrangeDAO) ctx.getBean("arrangedao");
	}

	/**
	 * �õ�һ�����ڱ���ҵ�������ClassesDAOʵ�������
	 * 
	 * @return ClassesDAO
	 */
	public static ClassesDAO getClassesDAO() {
		return (ClassesDAO) ctx.getBean("classesdao");
	}

	/**
	 * �õ�һ��ѧԺҵ�������CollegeDAOʵ�������
	 * 
	 * @return CollegeDAO
	 */
	public static CollegeDAO getCollegeDAO() {
		return (CollegeDAO) ctx.getBean("collegedao");
	}

	/**
	 * �õ�һ���˶���ҵ�������ConfigDAOʵ�������
	 * 
	 * @return ConfigDAO
	 */
	public static ConfigDAO getConfigDAO() {
		return (ConfigDAO) ctx.getBean("configdao");
	}

	/**
	 * �õ�һ���������ݲ�����ContentDAOʵ�������
	 * 
	 * @return ContentDAO
	 */
	public static ContentDAO getContentDAO() {
		return (ContentDAO) ctx.getBean("contentdao");
	}

	/**
	 * �õ�һ����������ҵ�������ForumDAOʵ�������
	 * 
	 * @return ForumDAO
	 */
	public static ForumDAO getForumDAO() {
		return (ForumDAO) ctx.getBean("forumdao");
	}

	/**
	 * �õ�һ������רҵҵ�������MajorDAOʵ�������
	 * 
	 * @return MajorDAO
	 */
	public static MajorDAO getMajorDAO() {
		return (MajorDAO) ctx.getBean("majordao");
	}

	/**
	 * �õ�һ������רҵҵ�������MatchDAOʵ�������
	 * 
	 * @return MatchDAO
	 */
	public static MatchDAO getMatchDAO() {
		return (MatchDAO) ctx.getBean("matchdao");
	}

	/**
	 * �õ�һ������רҵҵ�������NewsDAOʵ�������
	 * 
	 * @return NewsDAO
	 */
	public static NewsDAO getNewsDAO() {
		return (NewsDAO) ctx.getBean("newsdao");
	}

	/**
	 * ����һ�����ڲ���ͼƬ��Դ��PhotoDAO����
	 * 
	 * @return PhotoDAO
	 */
	public static PhotoDAO getPhotoDAO() {
		return (PhotoDAO) ctx.getBean("photodao");
	}

	/**
	 * ����һ�����ڲ�����Ŀ��ProjectDAO����
	 * 
	 * @return ProjectDAO
	 */
	public static ProjectDAO getProjectDAO() {
		return (ProjectDAO) ctx.getBean("projectdao");
	}

	/**
	 * ����һ�����ڲ����������ε�SceneDAO����
	 * 
	 * @return SceneDAO
	 */
	public static SceneDAO getSceneDAO() {
		return (SceneDAO) ctx.getBean("scenedao");
	}

	/**
	 * ����һ�����ڲ��������༶�ɼ���ScoreClassesDAO����
	 * 
	 * @return ScoreClassesDAO
	 */
	public static ScoreClassesDAO getScoreClassesDAO() {
		return (ScoreClassesDAO) ctx.getBean("scoreclassesdao");
	}

	/**
	 * ����һ�����ڲ�������ѧԺ�ɼ���ScoreCollegeDAO����
	 * 
	 * @return ScoreCollegeDAO
	 */
	public static ScoreCollegeDAO getScoreCollegeDAO() {
		return (ScoreCollegeDAO) ctx.getBean("scorecollegedao");
	}

	/**
	 * ����һ�����ڲ��������ɼ���ScoreDAO����
	 * 
	 * @return ScoreDAO
	 */
	public static ScoreDAO getScoreDAO() {
		return (ScoreDAO) ctx.getBean("scoredao");
	}

	/**
	 * ����һ�����ڲ�������ѧ���ɼ���ScoreStudentDAO����
	 * 
	 * @return ScoreStudentDAO
	 */
	public static ScoreStudentDAO getScoreStudentDAO() {
		return (ScoreStudentDAO) ctx.getBean("scorestudentdao");
	}

	/**
	 * ����һ�����ڲ�������ѧ���ɼ���SportsDAO����
	 * 
	 * @return SportsDAO
	 */
	public static SportsDAO getSportsDAO() {
		return (SportsDAO) ctx.getBean("sportsdao");
	}

	/**
	 * �õ�һ������ϵͳ�˵�����ҵ�������SystemLogDAOʵ�������
	 * 
	 * @return SystemLogDAO
	 */
	public static SystemLogDAO getSystemLogDAO() {
		return (SystemLogDAO) ctx.getBean("systemlogdao");
	}

	/**
	 * �õ�һ������ϵͳ�˵�����ҵ�������SystemModelDAOʵ�������
	 * 
	 * @return SystemModelDAO
	 */
	public static SystemModelDAO getSystemModelDAO() {
		return (SystemModelDAO) ctx.getBean("systemmodeldao");
	}

	/**
	 * ����һ�����ڶ��û���Ϣ������UserDAO����
	 * 
	 * @return UserDAO
	 */
	public static UserDAO getUserDAO() {
		return (UserDAO) ctx.getBean("userdao");
	}

}
