package business.dao;

import java.util.List;

import model.TArrange;
import model.VArrange;
import model.VScene;

/**
 * �������ΰ��Žӿ���
 * @author Administrator
 *
 */
public interface ArrangeDAO {
	/**
	 * ��ӳ��ΰ���
	 * @param arrange ���ΰ��Ŷ���
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TArrange arrange);
	
	/**
	 * ɾ�����ΰ���
	 * @param arrangeid ����id
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int arrangeid);

	/**
	 * ��ȡ���г����е���Ա��Ϣ
	 * @param arrid ���ΰ���id
	 * @return �����е���Ա��Ϣ�б�
	 */
	public List<VScene> selectById(int arrid);
	
	/**
	 * ��ȡ���г��ΰ����б�
	 * @param strWhere ��ѯ������Ϊ������дΪ""��
	 * @param startPage ��ȡ����ҳ��
	 * @param pageSize ÿҳ�ļ�¼��
	 * @return ���ΰ����б�
	 */
	public List<VArrange> selectByPage(String strWhere,int pageSize,int startPage);

	/**
	 * ��ȡ���г��ΰ����б�������
	 * @param strWhere ��ѯ������Ϊ������дΪ""��
	 * @return �б�������
	 */
	public int getCount(String strWhere);
	/**
	 * ��ȡ���α�������
	 * @param strWhere ��ѯ������Ϊ������дΪ""��
	 * @return �б�������
	 */
	public int getProType(int arrid);
}
