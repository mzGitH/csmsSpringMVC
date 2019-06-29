package business.dao;

import java.util.List;

import model.TUser;
import model.VUser;

/**
 * �û�ҵ��ӿ���
 * 
 * @author Administrator
 *
 */
public interface UserDAO {
	// ѧ������
	/**
	 * ѧ���û���¼
	 * 
	 * @param userid
	 *            �û�id
	 * @param pwd
	 *            �û�����
	 * @return user�û�����
	 */
	public TUser loginStu(String userid, String pwd);

	// public boolean insert(String userid,String username,String pwd,String
	// agend,String mobile,Classes classes,College college,Role role);
	/**
	 * ���ѧ���û�����
	 * 
	 * @param user
	 *            �û�����
	 * @return ��ӽ����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TUser user);

	/**
	 * �޸�ѧ������
	 * 
	 * @param userid
	 *            �û�id
	 * @param pwd
	 *            ������
	 * @return ���½����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean updatePwd(String userid, String pwd);

	/**
	 * ɾ���û�����
	 * 
	 * @param userid
	 *            �û�id
	 * @return ɾ�������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(String userid);

	/**
	 * ��ȡ�û�����
	 * 
	 * @param userid
	 *            �û�id
	 * @return �û�����
	 */
	public TUser getTUserByUserId(String userid);

	/**
	 * ����ѧԺid��ȡ�û������б�
	 * 
	 * @param collegeid
	 *            ѧԺid
	 * @return �û������б�
	 */
	public List<VUser> selectUserByColl(String collegeid);

	/**
	 * ����רҵid��ȡ�û������б�
	 * 
	 * @param majorid
	 *            רҵid
	 * @return �û������б�
	 */
	public List<VUser> selectUserByMajor(String majorid);

	/**
	 * ���ݰ༶id��ȡ�û������б�
	 * 
	 * @param classid
	 *            �༶id
	 * @return �û������б�
	 */
	public List<VUser> selectUserByClass(String classid);

	/**
	 * ���ݰ༶��ҳ��ȡѧ����Ϣ
	 * 
	 * @param classid
	 *            �༶id
	 * @param page
	 *            ��ǰҳ
	 * @param limit
	 *            ÿҳ����
	 * @return
	 */
	public List<VUser> selectUserByClassPage(int classid, int page, int limit);

	/**
	 * ���ݲ�ѯ��ҳ��ȡ�û���Ϣ
	 * 
	 * @param classid
	 *            �༶id
	 * @param page
	 *            ��ǰҳ
	 * @param limit
	 *            ÿҳ����
	 * @return
	 */
	public List<VUser> selectUserByPage(String opretion, int page, int limit);

	/**
	 * �༶ѧ������
	 * 
	 * @param classid
	 * @return
	 */
	public int getUserAmount(String opretion);

	/**
	 * ��������û�
	 * 
	 * @param classeslist
	 *            �û��б�
	 * @return
	 */
	public boolean insertList(List<Object> classeslist);

}
