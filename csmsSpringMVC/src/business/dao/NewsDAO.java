package business.dao;

import java.util.List;

import model.TNews;
import model.VNews;

public interface NewsDAO {
	/**
	 * ��ӹ���
	 * 
	 * @param news
	 * @return ����ֵ>0��ʾ�ɹ���<0��ʾʧ��
	 */
	public boolean addNews(TNews news);

	/**
	 * ��������id�@ȡ����
	 * 
	 * @param newid
	 * @return boolean
	 */
	public VNews getNewsById(int newid);

	/**
	 * �@ȡ���й���
	 * 
	 * @param wherecondition
	 *            ��ѯ����
	 * @param page
	 *            ��ǰҳ
	 * @param pageSize
	 *            ҳ������
	 * @return
	 */
	public List<VNews> getAllNews(String wherecondition, int page, int pageSize);

	/**
	 * �@ȡ���й���(����������)
	 * 
	 * @param wherecondition
	 *            ��ѯ����
	 * @param page
	 *            ��ǰҳ
	 * @param pageSize
	 *            ҳ������
	 * @return
	 */
	public List<VNews> getAllNewsNoContent(String wherecondition, int page,
			int pageSize);

	/**
	 * �����l����id�@ȡ�����Ĺ��挦��
	 * 
	 * @param teaid
	 * @return
	 */
	public List<VNews> getNewsByTeaid(String teaid);

	/**
	 * ��������ɾ������
	 * 
	 * @param news
	 *            ����
	 * @return
	 */
	public Boolean deleteNewsById(Integer newid);

	/**
	 * ����������ȡ���������Ĺ��������
	 * 
	 * @param wherecondition
	 *            ����
	 * 
	 * @return
	 */
	public int getNewsAmount(String wherecondition);

}
