package business.dao;

import java.util.List;

import model.VClassScore;


/**
 * 班级成绩业务接口类
 * @author jock
 *
 */
public interface ScoreClassesDAO {
	/**
	 * 获取某个班级的成绩信息
	 * @param classid 班级id
	 * @return 班级成绩信息
	 */
	public VClassScore getByClassid(int classid);
	/**
	 * 查询所有班级成绩
	 * @return List<VClass>数据集
	 */
	public List<VClassScore> getAllScoreClasses();
	/**
	 * 分页查询班级成绩
	 * @param strwhere 查询条件（为空是填写为""）
	 * @param startPage 获取的页面数据
	 * @param pagesize 每页的记录数
	 * @return
	 */
	public List<VClassScore> getAllScoreByPage(String strwhere,int startPage,int pagesize);
	/**
	 * 获取所有班级成绩数量
	 * @param strwhere 查询条件（为空是填写为""）
	 * @return
	 */
	public int allScoreCount(String strwhere);
	/**
	 * 获取某个班级的总分
	 * @param classid 班级id
	 * @return
	 */
	public double allScore(int classid);
	/**
	 * 获取某个班级的平均分
	 * @param classid 班级id
	 * @return
	 */
	public double avgScore(int classid);
}
