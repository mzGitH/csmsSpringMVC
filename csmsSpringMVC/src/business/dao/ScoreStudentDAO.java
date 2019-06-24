package business.dao;

import java.util.List;

import model.VScore;
import model.VStudentScore;

/**
 * 个人成绩业务接口类
 * @author jock
 *
 */
public interface ScoreStudentDAO {
	/**
	 * 
	 * @param string 学生账号
	 * @return 学生成绩信息
	 */
	public VStudentScore getByUserid(String string);
	/**
	 * 查询某个学生/教师成绩
	 * @return List<ScoreStudent>数据集
	 */
	public List<VScore> getScoreStudent(String userid);
	/**
	 * 分页查询所有学生成绩
	 * @return List<ScoreStudent>数据集
	 * @param strwhere 查询条件（为空填写为""）
	 * @param startPage 需要的页数的数据
	 * @param pageSize 每页的记录数
	 * @return
	 */
	public List<VScore> getAllScoreByPage(String strwhere, int startPage,int pageSize);
	/**
	 * 获取某个学生的总分
	 * @return
	 */
	public double allScore(String userid);
	/**
	 * 获取某个学生的平均分
	 * @return
	 */
	public double avgScore(String userid);
}
