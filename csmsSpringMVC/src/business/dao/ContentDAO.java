package business.dao;

import java.util.List;

import model.TForumContent;
import model.VForum;

public interface ContentDAO {
	/**
	 * 添加博客文章的一条内容信息
	 * @param TForumContent对象
	 * @return 添加成功的文章编号，如<=0则表示添加失败
	 */
	public boolean addContent(TForumContent fcontent);
	
	/**
	 * 删除一个博客文章内容信息
	 * @param 内容编号
	 * @return 受影响的行数
	 */
	public boolean deleteContent(int id);
	/**
	 * 修改一个博客文章内容信息
	 * @param 文章内容对象
	 * @return 受影响的行数
	 */
	public boolean updateForumContent(TForumContent fcontent);
	
	/**
	 * 通过内容编号检索一条文章内容记录
	 * @param 内容编号
	 * @return TForumContent对象
	 */
	public TForumContent getTContnentById(int id);
	/**
	 * 通過文章編號檢索文章内容
	 * @param forumid 文章編號
	 * @return 返回TForumContent的list對象
	 */
	public List<VForum> getContentByForumid(int forumid);
}
