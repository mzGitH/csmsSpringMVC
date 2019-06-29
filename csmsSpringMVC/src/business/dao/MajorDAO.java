package business.dao;

import java.util.List;

import model.TMajor;
import model.VMajor;

public interface MajorDAO {
	/**
	 * ���רҵ
	 * 
	 * @param major
	 *            רҵ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TMajor major);

	/**
	 * �������רҵ
	 * 
	 * @param majorlist
	 *            רҵ�����б�
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insertList(List<Object> majorlist);

	/**
	 * ɾ��רҵ
	 * 
	 * @param majorid
	 *            רҵid
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int majorid);

	/**
	 * �޸�רҵ
	 * 
	 * @param major
	 *            רҵ
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean update(TMajor major);

	/**
	 * ����רҵid��ȡרҵ����
	 * 
	 * @param majorid
	 *            רҵid
	 * @return רҵ����
	 */
	public VMajor selectByid(int majorid);

	/**
	 * ��ȡ����רҵ�����б�
	 * 
	 * @return רҵ�����б�
	 */
	public List<VMajor> select();

	/**
	 * ��ȡ����רҵ�����б�
	 * 
	 * @param collegeid
	 *            ѧԺid
	 * @return רҵ�����б�
	 */
	public List<VMajor> selectByColl(int collegeid);

	/**
	 * ��ȡ�ܼ�¼��
	 * 
	 * @return �ܼ�¼��
	 */
	public int getPageCount();

	/**
	 * ����������ѯ��������
	 * 
	 * @return
	 */
	public int getMajorAmount(String wherecondition);

	/**
	 * ��ҳ��ѯ����
	 * 
	 * @return
	 */
	public List<VMajor> selectByPage(String wherecondition, int page,
			int pageSize);

}
