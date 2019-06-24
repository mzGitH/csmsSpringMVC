package business.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.dao.AdminRoleDAO;
import business.dao.AdminUserDAO;
import business.dao.ForumDAO;
import business.dao.PhotoDAO;
import business.dao.SystemLogDAO;
import business.dao.SystemModelDAO;
import business.dao.UserDAO;

public class DAOFactory {
	private static ApplicationContext ctx = null;

	static {
		ctx = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
	}

	/**
	 * �õ�һ�����ڹ���Աҵ�������ForumDAOʵ�������
	 * 
	 * @return AdminUserDAO
	 */
	public static AdminUserDAO getAdminUserDAO() {
		return (AdminUserDAO) ctx.getBean("adminuserdao");
	}

	/**
	 * �õ�һ�����ڹ���Ա��ɫҵ�������ForumDAOʵ�������
	 * 
	 * @return AdminRoleDAO
	 */
	public static AdminRoleDAO getAdminRoleDAO() {
		return (AdminRoleDAO) ctx.getBean("adminroledao");
	}

	/**
	 * �õ�һ������ϵͳ�˵�����ҵ�������ForumDAOʵ�������
	 * 
	 * @return SystemModelDAO
	 */
	public static SystemModelDAO getSystemModelDAO() {
		return (SystemModelDAO) ctx.getBean("systemmodeldao");
	}

	/**
	 * �õ�һ������ϵͳ�˵�����ҵ�������ForumDAOʵ�������
	 * 
	 * @return SystemLogDAO
	 */
	public static SystemLogDAO getSystemLogDAO() {
		return (SystemLogDAO) ctx.getBean("systemlogdao");
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
	 * ����һ�����ڲ���ͼƬ��Դ��PhotoDAO����
	 * 
	 * @return PhotoDAO
	 */
	public static PhotoDAO getPhotoDAO() {
		return (PhotoDAO) ctx.getBean("photodao");
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
