package business.dao;

import java.util.List;

import model.TCollege;

public interface CollegeDAO {
	/**
	 * ���ѧԺ
	 * 
	 * @param college
	 *            ѧԺ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TCollege college);

	/**
	 * ɾ��ѧԺ
	 * 
	 * @param collegeid
	 *            ѧԺid
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int collegeid);

	/**
	 * ����ѧԺ
	 * 
	 * @param college
	 *            ѧԺ
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean update(TCollege college);

	/**
	 * ����ѧԺid��ȡѧԺ����
	 * 
	 * @param collegeid
	 *            ѧԺid
	 * @return ѧԺ����
	 */
	public TCollege selectByid(int collegeid);

	/**
	 * ��ȡ����ѧԺ�����б�
	 * 
	 * @return ѧԺ�����б�
	 */
	public List<TCollege> select();

	/**
	 * ��ҳ��ѯ����
	 * 
	 * @return
	 */
	public List<TCollege> selectByPage(String wherecondition, int page,
			int pageSize);

	/**
	 * ����������ѯ��������
	 * 
	 * @return
	 */
	public int getCollegeAmount(String wherecondition);

	/**
	 * ��������ѧԺ���ƻ�ȡѧԺid
	 * 
	 * @return
	 */
	public int getCollegeid(String collegename);

	/**
	 * �������
	 * 
	 * @param collegelist
	 *            ѧԺ�б�
	 * @return
	 */
	public boolean addcollegeByList(List<Object> collegelist);
}
