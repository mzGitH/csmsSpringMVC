package business.dao;

import java.util.List;

import model.TForumTitle;

public interface ForumDAO {
	/**
	 * ���һƪ�������µĻ�����Ϣ
	 * 
	 * @param TForum����
	 * @return ��ӳɹ������±�ţ���<=0���ʾ���ʧ��
	 */
	public boolean addForum(TForumTitle forum);

	/**
	 * �������Լ�����������ݴ����������ȫɾ��������ɾ�����۱����ݱ����±��Լ��޸����ݶ�ӦͼƬ��ͼƬ״̬���û��������·�������-1
	 * 
	 * @param forumid
	 *            ���±��
	 * @return ��Ӱ�������
	 */
	public boolean deleteForum(int forumid);

	/**
	 * �޸�һ������������Ϣ
	 * 
	 * @param Forum
	 *            ������Ϣ����
	 * @return ��Ӱ�������
	 */
	public boolean updateForum(TForumTitle Forum);

	/**
	 * ͨ�����±�ŷ���һ�����¶���
	 * 
	 * @param forumid
	 *            ���±��
	 * @return VForumTitle������ͼ����
	 */
	// public VForumTitle getVForumById(int forumid);

	/**
	 * ͨ�����±�ŷ���һ�����¶���
	 * 
	 * @param forumid
	 *            ���±��
	 * @return TForumTitle���¶���
	 */
	public TForumTitle getTForumById(int forumid);

	/**
	 * �@ȡ���·�퓔���
	 * 
	 * @param startPage
	 *            �_ʼ�
	 * @param pageSize
	 *            ÿ퓔���
	 * @return
	 */
	public List<TForumTitle> getForumTitleByPages(String wherecondition,
			int page, int pageSize);

	/**
	 * ��ð�ģ����ѯʵ�ֵ����в����û���������¶����б�
	 * 
	 * @param likecondtion
	 *            ģ����ѯ����
	 * @param currentPage
	 *            ��ǰҳ
	 * @param pageSize
	 *            ÿҳ�������
	 * @return ������Ϣ�����б�
	 */
	// public List<VForumTitle> getForumListByLike(String likecondtion,int
	// currentPage, int pageSize);

	/**
	 * ��û������±����ģ����ѯʵ�ֵ�ָ�������û���������¶����б�
	 * 
	 * @param ģ����ѯ����
	 *            ����ǰҳ��ÿҳ�������
	 * @return ������Ϣ�����б�
	 */
	// public List<VForumTitle> getBlogerUserForumListByTopicLike(String
	// likecondtion,String userid,int currentPage, int pageSize);

	/**
	 * �����û�����������µ������б� ����û���Ϊnull���򷵻������û������µ������б�
	 * 
	 * @param userid
	 *            �û���
	 * @return ������Ϣ�����б�
	 */
	// public List<VForumTitle> getForumsByUser(String userid);

	/**
	 * ��ȡ�ܼ�¼��
	 * 
	 * @return �ܼ�¼��
	 */
	public int getPageCount();

	/**
	 * ����������ȡ�������������µ�����
	 * 
	 * @param wherecondition
	 *            ����
	 * 
	 * @return
	 */
	public int getForumAmount(String wherecondition);
}
