package business.dao;

import java.util.List;

import model.TConfig;
import model.TProject;
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
	 * @return ��ӽ����rowΪ����id��0Ϊʧ��
	 */
	public int insert(TConfig config);
	
	/**
	 * �����˶���ʱ������
	 * @param config ���ö���
	 * @return ���½����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean update(TConfig config);

	/**
	 * ɾ���˶���ʱ�估������������
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
	 * ��ȡָ���˶�����Ŀ�����б�
	 * @param sportid ����id
	 * @return ���ö����б�
	 */
	public List<TSportProject> selectTSPlist(int sportid);

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
	
	/**
	 * ��ȡδ��������δ���ŵ������б�
	 * @param sportid �˶�������id
	 * @return
	 */
	public List<TProject> getNotExistsProject(int sportid);

	/**
	 * ��ȡδ���������Ѱ��ŵ������б�
	 * @param sportid �˶�������id
	 * @return
	 */
	public List<TProject> getExistsProject(int sportid);
}
