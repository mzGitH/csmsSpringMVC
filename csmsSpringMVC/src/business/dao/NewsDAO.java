package business.dao;

import java.util.List;

import model.TNews;
import model.VNews;

public interface NewsDAO {
	/**
	 * 添加公告
	 * 
	 * @param news
	 * @return 返回值>0表示成功，<0表示失敗
	 */
	public boolean addNews(TNews news);

	/**
	 * 根據公告id獲取公告
	 * 
	 * @param newid
	 * @return boolean
	 */
	public VNews getNewsById(int newid);

	/**
	 * 獲取所有公告
	 * 
	 * @param wherecondition
	 *            查询条件
	 * @param page
	 *            当前页
	 * @param pageSize
	 *            页数限制
	 * @return
	 */
	public List<VNews> getAllNews(String wherecondition, int page, int pageSize);

	/**
	 * 獲取所有公告(不包含内容)
	 * 
	 * @param wherecondition
	 *            查询条件
	 * @param page
	 *            当前页
	 * @param pageSize
	 *            页数限制
	 * @return
	 */
	public List<VNews> getAllNewsNoContent(String wherecondition, int page,
			int pageSize);

	/**
	 * 根據發佈人id獲取對應的公告對象
	 * 
	 * @param teaid
	 * @return
	 */
	public List<VNews> getNewsByTeaid(String teaid);

	/**
	 * 根據公告删除公告
	 * 
	 * @param news
	 *            公告
	 * @return
	 */
	public Boolean deleteNewsById(Integer newid);

	/**
	 * 根据条件获取符合条件的公告的数量
	 * 
	 * @param wherecondition
	 *            条件
	 * 
	 * @return
	 */
	public int getNewsAmount(String wherecondition);

}
