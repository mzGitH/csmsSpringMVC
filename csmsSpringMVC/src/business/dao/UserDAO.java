package business.dao;

import java.util.List;

import model.VStudent;
import model.VTeacher;
/**
 * �û�ҵ��ӿ���
 * @author Administrator
 *
 */
public interface UserDAO {
	//ѧ������
	/**
	 * ѧ���û���¼
	 * @param userid �û�id
	 * @param pwd �û�����
	 * @return user�û�����
	 */
	public VStudent loginStu(String userid,String pwd);
	
	//public boolean insert(String userid,String username,String pwd,String agend,String mobile,Classes classes,College college,Role role);
	/**
	 * ���ѧ���û�����
	 * @param user �û�����
	 * @return ��ӽ����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insertStu(VStudent user);
	
	/**
	 * �޸�ѧ������
	 * @param userid �û�id
	 * @param pwd ������
	 * @return ���½����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean updateStuPwd(String userid,String pwd);
	
	/**
	 * ɾ���û�����
	 * @param userid �û�id
	 * @return ɾ�������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean deleteStu(String userid);
	
	/**
	 * ��ȡ�û�����
	 * @param userid �û�id
	 * @return �û�����
	 */
	public VStudent getStudent(String userid);
	
	/**
	 * ����ѧԺid��ȡ�û������б�
	 * @param collegeid ѧԺid
	 * @return �û������б�
	 */
	public List<VStudent> selectStuByColl(String collegeid);
	
	/**
	 * ����רҵid��ȡ�û������б�
	 * @param majorid רҵid
	 * @return �û������б�
	 */
	public List<VStudent> selectStuByMajor(String majorid);
	
	/**
	 * ���ݰ༶id��ȡ�û������б�
	 * @param classid �༶id
	 * @return �û������б�
	 */
	public List<VStudent> selectStuByClass(String classid);
	/**
	 * ���ݰ༶��ҳ��ȡѧ����Ϣ
	 * @param classid �༶id
	 * @param page ��ǰҳ
	 * @param limit ÿҳ����
	 * @return
	 */
	public List<VStudent> selectStuByClassPage(int classid,int page,int limit);
	/**
	 * �༶ѧ������
	 * @param classid
	 * @return
	 */
	public int stucount(int classid);
	//��ʦ����
	
	/**
	 * ��ʦ�û���¼
	 * @param userid �û�id
	 * @param pwd �û�����
	 * @return user�û�����
	 */
	public VTeacher loginTea(String userid,String pwd);
	
	/**
	 * ��ӽ�ʦ�û�����
	 * @param user �û�����
	 * @return ��ӽ����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insertTea(VTeacher user);
	
	/**
	 * �޸�ѧ������
	 * @param userid �û�id
	 * @param pwd ������
	 * @return ���½����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean updateTeaPwd(String userid,String pwd);
	
	/**
	 * ɾ���û�����
	 * @param userid �û�id
	 * @return ɾ�������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean deleteTea(String userid);
	
	/**
	 * ��ȡ�û�����
	 * @param userid �û�id
	 * @return �û�����
	 */
	public VTeacher getTeacher(String userid);
	
	/**
	 * ����ѧԺid��ȡ��ʦ�����б�
	 * @param collegeid ѧԺid
	 * @return ��ʦ�����б�
	 */
	public List<VTeacher> selectTeaByColl(String collegeid);
	/**
	 * ����ѧԺid��ҳ��ȡ��ʦ�����б�
	 * @param collegeid
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<VTeacher> selectTeaByCollPage(int collegeid,int page,int limit);
	/**
	 * ѧԺ��ʦ����
	 * @param collegeid
	 * @return
	 */
	public int teacount(int collegeid);
}
