package business.dao;

import java.util.List;

import model.*;

public interface MajorDAO {
	/**
	 * ���רҵ
	 * @param major רҵ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TMajor major);
	
	/**
	 * ɾ��רҵ
	 * @param majorid רҵid
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int majorid);
	
	/**
	 * ����רҵid��ȡרҵ����
	 * @param majorid רҵid
	 * @return רҵ����
	 */
	public TMajor selectByid(int majorid);
	
	/**
	 * ��ȡ����רҵ�����б�
	 * @return רҵ�����б�
	 */
	public List<TMajor> select();
	
	/**
	 * ��ȡ����רҵ�����б�
	 * @param collegeid ѧԺid
	 * @return רҵ�����б�
	 */
	public List<TMajor> selectByColl(int collegeid);
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @return �ܼ�¼��
	 */
	public int getPageCount();
}
