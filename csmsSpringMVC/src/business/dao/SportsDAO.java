package business.dao;

import java.util.List;

import model.TConfig;
import model.TSportProject;
import model.VSportProject;
/**
 * �˶�������ҵ��ӿ���
 * @author Administrator
 *
 */
public interface SportsDAO {
	/**
	 * ����˶���ʱ������
	 * @param config ���ö���
	 * @return ��ӽ����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TConfig config);
	
	/**
	 * �����˶���ʱ������
	 * @param config ���ö���
	 * @return ���½����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean update(TConfig config);

	/**
	 * ɾ���˶���ʱ������
	 * @param sportid ���ö���id
	 * @return ���½����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int sportid);
	
	/**
	 * ��ȡ�������ö����б�
	 * @return ���ö����б�
	 */
	public List<TConfig> select();

	/**
	 * ��ȡ�������ö����б�
	 * @param where ɸѡ����
	 * @param startPage ��ʼҳ��
	 * @param pageSize ÿҳ��¼��
	 * @return ���ö����б�
	 */
	public List<TConfig> selectByPage(String where,int startPage,int pageSize);

	/**
	 * ��ȡ���ݼ�¼��
	 * @param where ɸѡ����
	 * @return ���ݼ�¼��
	 */
	public int getCount(String where);

	/**
	 * ��ȡ�����˶�����Ŀ�����б�
	 * @param where ɸѡ����
	 * @param startPage ��ʼҳ��
	 * @param pageSize ÿҳ��¼��
	 * @return ���ö����б�
	 */
	public List<VSportProject> selectTSP(String where,int startPage,int pageSize);

	/**
	 * ��ȡ���ݼ�¼��
	 * @param where ɸѡ����
	 * @return ���ݼ�¼��
	 */
	public int getTSPCount(String where);
	
	/**
	 * ��ȡδ��������������б�
	 * @return
	 */
	public List<TConfig> getNotExistsConfig();
	

	/**
	 * ��������˶�����Ŀ����
	 * @param tsp �˶�����Ŀ���ö���
	 * @return ��ӽ����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insertTSP(List<TSportProject> list);

	/**
	 * ɾ���˶���ĳ��Ŀ����
	 * @param id �˶�����Ŀ����id
	 * @return ɾ�������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean deleteTSP(int id);
}
