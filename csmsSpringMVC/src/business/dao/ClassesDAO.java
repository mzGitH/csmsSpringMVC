package business.dao;

import java.util.List;

import model.TClass;
import model.VClass;

public interface ClassesDAO {
	/**
	 * ��Ӱ༶
	 * 
	 * @param classes
	 *            �༶����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TClass classes);

	/**
	 * ������Ӱ༶
	 * 
	 * @param classes
	 *            �༶�����б�
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insertList(List<Object> classeslist);

	/**
	 * ɾ���༶
	 * 
	 * @param classid
	 *            �༶id
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int classid);

	/**
	 * �޸İ༶
	 * 
	 * @param classid
	 *            �༶
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean update(TClass classes);

	/**
	 * ���ݰ༶id��ȡ�༶����
	 * 
	 * @param classid
	 *            �༶id
	 * @return �༶����
	 */
	public TClass selectByid(int classid);

	/**
	 * ��ȡ���а༶�����б�
	 * 
	 * @return �༶�����б�
	 */
	public List<TClass> select();

	/**
	 * ��ȡ���а༶�����б�
	 * 
	 * @param majorid
	 *            רҵid
	 * @return �༶�����б�
	 */
	public List<TClass> selectByMajor(int majorid);

	/**
	 * ���ݰ༶id��ȡ�༶��ͼ����
	 * 
	 * @param classid
	 *            �༶id
	 * @return �༶����
	 */
	public VClass selectByidVclass(int classid);

	/**
	 * ��ȡ���а༶��ͼ�����б�
	 * 
	 * @return �༶�����б�
	 */
	public List<VClass> selectVclass();

	/**
	 * ����רҵid��ȡ���а༶��ͼ�����б�
	 * 
	 * @param majorid
	 *            רҵid
	 * @return �༶�����б�
	 */
	public List<VClass> selectByMajorVclass(int majorid);

	/**
	 * ����רҵid��ȡ���а༶��ͼ�����б�
	 * 
	 * @param collegeid
	 *            ѧԺid
	 * @return �༶�����б�
	 */
	public List<VClass> selectByCollegeid(int collegeid);

	/**
	 * ����ѧԺid��ȡ���а༶��ͼ�����б�
	 * 
	 * @param majorid
	 *            רҵid
	 * @return �༶�����б�
	 */
	public List<VClass> selectByCollegeVclass(int collegeid);

	/**
	 * ����������ѯ��������
	 * 
	 * @return
	 */
	public int getclassAmount(String wherecondition);

	/**
	 * ��ҳ��ѯ����
	 * 
	 * @return
	 */
	public List<VClass> selectByPage(String wherecondition, int page,
			int pageSize);
}
