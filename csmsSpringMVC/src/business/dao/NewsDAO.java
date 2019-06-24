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
	 * @return
	 */
	public List<TNews> getAllNews();

	/**
	 * �����l����id�@ȡ�����Ĺ��挦��
	 * 
	 * @param teaid
	 * @return
	 */
	public List<TNews> getNewsByTeaid(String teaid);
}
