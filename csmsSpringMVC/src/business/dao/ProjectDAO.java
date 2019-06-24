package business.dao;

import java.util.List;

import model.TProject;

/**
 * 比赛项目业务接口类
 * 
 * @author Administrator
 *
 */
public interface ProjectDAO {
	/**
	 * 添加比赛项目
	 * 
	 * @param project
	 *            项目对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(TProject project);

	/**
	 * 修改比赛项目
	 * 
	 * @param project
	 *            项目对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean update(TProject project);

	/**
	 * 删除比赛项目
	 * 
	 * @param projectid
	 *            项目id
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean delete(int projectid);

	/**
	 * 根据项目id获取项目
	 * 
	 * @param projectid
	 * @return
	 */
	public TProject getptoject(int projectid);

	/**
	 * 获取所有项目对象列表
	 * 
	 * @return 项目对象列表
	 */
	public List<TProject> select();

	/**
	 * 通过项目类型获取项目对象列表
	 * 
	 * @param type
	 *            项目类型
	 * @return 项目对象列表
	 */
	public List<TProject> selectByType(int type);

	/**
	 * 根据角色类型分页获取比赛项目
	 * 
	 * @param startPage
	 * @param pagesize
	 * @return
	 */
	public List<TProject> selectByPage(int roletype, int startPage, int pageSize);

	/**
	 * 获取比赛项目数
	 * 
	 * @param roletype
	 *            角色类型
	 * @return 返回比赛项目数
	 */
	public int getProCount(int roletype);
}
