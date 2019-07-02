package business.dao;

import java.util.List;

import model.TConfig;
import model.TProject;

/**
 * ������Ŀҵ��ӿ���
 * 
 * @author Administrator
 *
 */
public interface ProjectDAO {
	/**
	 * ��ӱ�����Ŀ
	 * 
	 * @param project
	 *            ��Ŀ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TProject project);

	/**
	 * �޸ı�����Ŀ
	 * 
	 * @param project
	 *            ��Ŀ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean update(TProject project);

	/**
	 * ɾ��������Ŀ
	 * 
	 * @param projectid
	 *            ��Ŀid
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int projectid);

	/**
	 * ������Ŀid��ȡ��Ŀ
	 * 
	 * @param projectid
	 * @return
	 */
	public TProject getptoject(int projectid);

	/**
	 * ��ȡ������Ŀ�����б�
	 * 
	 * @return ��Ŀ�����б�
	 */
	public List<TProject> select();

	/**
	 * ͨ����Ŀ���ͻ�ȡ��Ŀ�����б�
	 * 
	 * @param type
	 *            ��Ŀ����
	 * @return ��Ŀ�����б�
	 */
	public List<TProject> selectByType(int type);

	/**
	 * ���ݽ�ɫ���ͷ�ҳ��ȡ������Ŀ
	 * 
	 * @param startPage
	 * @param pagesize
	 * @return
	 */
	public List<TProject> selectByPage(String where, int startPage, int pageSize);

	/**
	 * ��ȡ������Ŀ��
	 * 
	 * @param roletype
	 *            ��ɫ����
	 * @return ���ر�����Ŀ��
	 */
	public int getProCount(String where);

	/**
	 * �����˶���id��ȡ������Ŀ
	 * 
	 * @param sportid
	 *            �˶���id
	 * @return
	 */
	public List<TProject> select(int sportid);

	/**
	 * ��ȡ�����ѡ��Ŀ
	 * 
	 * @param sportid
	 *            �˶���id
	 * @return
	 */
	public List<TProject> selectnow(TConfig cfg);
}
