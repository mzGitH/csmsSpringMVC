package business.dao;

import java.util.List;

import model.TScore;
import model.VScore;
/**
 * 比赛成绩业务接口类
 * @author Administrator
 *
 */
public interface ScoreDAO {
	/**
	 * 添加成绩信息
	 * @param score 成绩对象
	 * @return 添加结果，true为成功，false为失败
	 */
	public boolean insert(TScore score);
	
	/**
	 * 更新成绩对象
	 * @param score 成绩对象
	 * @return 更新结果，true为成功，false为失败
	 */
	public boolean update(TScore score);
	
	/**
	 * 查询用户的详细成绩列表
	 * @param userid 用户id
	 * @return 用户成绩列表
	 */
	public List<VScore> getByUser(String userid);

	/**
	 * 查询用户的详细成绩列表
	 * @param collegeid 学院id
	 * @return 学院成绩列表
	 */
	public List<VScore> getByCollege(int collegeid);
	
	/**
	 * 查询用户的详细成绩列表
	 * @param classid 班级id
	 * @return 班级成绩列表
	 */
	public List<VScore> getByClass(int classid);
	/**
	 * 查询各个学院的成绩排名
	 * @return 成绩列表
	 */
	public List<VScore> getCollegeScoreOrder();
	/**
	 * 查询成绩列表
	 * @param strwhere 查询条件（为空时填写为""）
	 * @param startPage 获取的页面数据
	 * @param limit 每页的记录数
	 * @return 成绩列表
	 */
	public List<VScore> getScoreByPage(String strwhere,int startPage,int limit);
	/**
	 * 查询指定项目的个人赛成绩列表
	 * @param proid 项目id
	 * @return 成绩列表
	 */
	public List<VScore> getScoreByProSingle(int proid);
	/**
	 * 查询指定项目的团体赛成绩列表
	 * @param proid 项目id
	 * @return 成绩列表
	 */
	public List<VScore> getScoreByProTeam(int proid);
	/**
	 * 查询成绩列表
	 * @param strwhere 查询条件（为空时填写为""）
	 * @param startPage 获取的页面数据
	 * @param limit 每页的记录数
	 * @return 成绩列表
	 */
	public List<VScore> getScore(String strwhere);
	/**
	 * 查询成绩总记录数
	 * @param strwhere 查询条件（为空时填写为""）
	 * @return 成绩列表
	 */
	public int allScoreCount(String strwhere);
}
