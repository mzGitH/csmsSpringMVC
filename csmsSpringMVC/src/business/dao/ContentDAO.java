package business.dao;

import java.util.List;

import model.TForumContent;
import model.VForum;

public interface ContentDAO {
	/**
	 * ��Ӳ������µ�һ��������Ϣ
	 * @param TForumContent����
	 * @return ��ӳɹ������±�ţ���<=0���ʾ���ʧ��
	 */
	public boolean addContent(TForumContent fcontent);
	
	/**
	 * ɾ��һ����������������Ϣ
	 * @param ���ݱ��
	 * @return ��Ӱ�������
	 */
	public boolean deleteContent(int id);
	/**
	 * �޸�һ����������������Ϣ
	 * @param �������ݶ���
	 * @return ��Ӱ�������
	 */
	public boolean updateForumContent(TForumContent fcontent);
	
	/**
	 * ͨ�����ݱ�ż���һ���������ݼ�¼
	 * @param ���ݱ��
	 * @return TForumContent����
	 */
	public TForumContent getTContnentById(int id);
	/**
	 * ͨ�^���¾�̖�z����������
	 * @param forumid ���¾�̖
	 * @return ����TForumContent��list����
	 */
	public List<VForum> getContentByForumid(int forumid);
}
