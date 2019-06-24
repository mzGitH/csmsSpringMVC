package business.dao;

import java.util.List;

import model.*;

public interface ClassesDAO {
	/**
	 * ��Ӱ༶
	 * @param classes �༶����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TClass classes);
	
	/**
	 * ɾ���༶
	 * @param classid �༶id
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int classid);
	
	/**
	 * ���ݰ༶id��ȡ�༶����
	 * @param classid �༶id
	 * @return �༶����
	 */
	public TClass selectByid(int classid);
	
	/**
	 * ��ȡ���а༶�����б�
	 * @return �༶�����б�
	 */
	public List<TClass> select();

	/**
	 * ��ȡ���а༶�����б�
	 * @param majorid רҵid
	 * @return �༶�����б�
	 */
	public List<TClass> selectByMajor(int majorid);
	/**
	 * ���ݰ༶id��ȡ�༶��ͼ����
	 * @param classid �༶id
	 * @return �༶����
	 */
	public VClass selectByidVclass(int classid);
	
	/**
	 * ��ȡ���а༶��ͼ�����б�
	 * @return �༶�����б�
	 */
	public List<VClass> selectVclass();

	/**
	 * ��ȡ���а༶��ͼ�����б�
	 * @param majorid רҵid
	 * @return �༶�����б�
	 */
	public List<VClass> selectByMajorVclass(int majorid);
	/**
	 * ����ѧԺ��ȡ���а༶��ͼ�����б�
	 * @param majorid רҵid
	 * @return �༶�����б�
	 */
	public List<VClass> selectByCollegeVclass(int collegeid);
}
