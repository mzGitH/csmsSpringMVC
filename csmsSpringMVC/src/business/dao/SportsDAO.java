package business.dao;

import java.util.List;

import model.TConfig;
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
	 * ��ȡ�������ö����б�
	 * @return ���ö����б�
	 */
	public List<TConfig> select();
}
