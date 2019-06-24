package business.dao;

import java.util.List;

import model.*;

public interface CollegeDAO {
	/**
	 * ���ѧԺ
	 * @param college ѧԺ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TCollege college);
	
	/**
	 * ɾ��ѧԺ
	 * @param collegeid ѧԺid
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int collegeid);
	
	/**
	 * ����ѧԺid��ȡѧԺ����
	 * @param collegeid ѧԺid
	 * @return ѧԺ����
	 */
	public TCollege selectByid(int collegeid);
	
	/**
	 * ��ȡ����ѧԺ�����б�
	 * @return ѧԺ�����б�
	 */
	public List<TCollege> select();
	
	/**
	 * ��ҳ��ѯ����
	 * @return
	 */
	public List<TCollege> selectByPage(int startPage,int pageSize);
}
