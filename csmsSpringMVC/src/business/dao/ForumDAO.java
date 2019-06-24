package business.dao;

import java.util.List;

import model.TForumTitle;

public interface ForumDAO {
	/**
	 * 添加一篇博客文章的基本信息
	 * @param TForum对象
	 * @return 添加成功的文章编号，如<=0则表示添加失败
	 */
	public boolean addForum(TForumTitle forum);
	
	/**
	 * 将博文以及博文相关内容从物理表中完全删除，包括删除评论表，内容表，文章表以及修改内容对应图片的图片状态，用户表中文章发表数量-1
	 * @param forumid 文章编号
	 * @return 受影响的行数
	 */
	public boolean deleteForum(int forumid);
	
	/**
	 * 修改一个博客文章信息
	 * @param Forum 文章信息对象
	 * @return 受影响的行数
	 */
	public boolean updateForum(TForumTitle Forum);
	/**
	 * 通过文章编号返回一条文章对象
	 * @param forumid 文章编号
	 * @return VForumTitle文章视图对象
	 */
//	public VForumTitle getVForumById(int forumid);
	
	/**
	 * 通过文章编号返回一条文章对象
	 * @param forumid 文章编号
	 * @return TForumTitle文章对象
	 */
	public TForumTitle getTForumById(int forumid);
	/**
	 * 獲取文章分頁數據
	 * @param startPage 開始頁
	 * @param pageSize 每頁數據
	 * @return
	 */
	public List<TForumTitle> getForumTitleByPages(int startPage,int pageSize);
	
	/**
	 * 获得按模糊查询实现的所有博客用户发表的文章对象列表
	 * @param likecondtion 模糊查询内容
	 * @param currentPage 当前页
	 * @param pageSize 每页最大数量
	 * @return 文章信息对象列表
	 */
//	public List<VForumTitle> getForumListByLike(String likecondtion,int currentPage, int pageSize);
	
	/**
	 * 获得基于文章标题的模糊查询实现的指定博客用户发表的文章对象列表
	 * @param 模糊查询内容，当前页，每页最大数量
	 * @return 文章信息对象列表
	 */
//	public List<VForumTitle> getBlogerUserForumListByTopicLike(String likecondtion,String userid,int currentPage, int pageSize);
	
	/**
	 * 根据用户名获得其最新的文章列表， 如果用户名为null，则返回所有用户的最新的文章列表
	 * @param userid 用户名
	 * @return 文章信息对象列表
	 */
//	public List<VForumTitle> getForumsByUser(String userid);
	
	/**
	 * 获取总记录数
	 * @return 总记录数
	 */
	public int getPageCount();
}
