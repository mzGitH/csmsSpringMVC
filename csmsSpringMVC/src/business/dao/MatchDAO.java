package business.dao;

import java.util.List;

import model.TMatch;
import model.VMatch;

/**
 * 比赛报名业务接口类
 * 
 * @author Administrator
 *
 */
public interface MatchDAO {
	/**
	 * 添加比赛报名信息
	 * 
	 * @param match
	 *            报名对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(TMatch match);

	/**
	 * 判断是否报过改比赛
	 * 
	 * @param userid
	 *            用户id
	 * @param proid
	 *            项目id
	 * @return 操作结果，true为已报过，false为未报过
	 */
	public boolean isSignUp(String userid, int proid);

	/**
	 * 根据用户id查询报名对象列表
	 * 
	 * @param userid
	 *            用户id
	 * @return 报名对象列表
	 */
	public List<VMatch> selectByUser(String userid);

	/**
	 * 查询报名对象列表
	 * 
	 * @return 报名对象列表
	 */
	public List<VMatch> select();

	/**
	 * 分页查询报名对象列表
	 * 
	 * @param startPage
	 *            当前页
	 * @param pageSize
	 *            每页记录数
	 * @return 报名对象列表
	 */
	public List<VMatch> selectByPage(int startPage, int pageSize);

	/**
	 * 获取总记录数
	 * 
	 * @return 总记录数
	 */
	public int getPageCount();

	/**
	 * 获取报名情况
	 * 
	 * @return 数据集
	 */
	public List<VMatch> selectAll();

	/**
	 * 判断用户是否已经报过该项目
	 * 
	 * @param proid
	 * @param userid
	 * @return
	 */
	public int countUser(int proid, String userid);
}
