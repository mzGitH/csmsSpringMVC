package business.dao;

import java.sql.ResultSet;
import java.util.List;

import model.VClassScore;
import model.VCollegeScore;
import model.VMajorScore;
import model.VScore;
import model.VUserScore;

/**
 * 学院成绩业务接口类
 * @author jock
 *
 */
public interface ScoreCollegeDAO {
	/**
	 * 
	 * @param collegeid 学院id
	 * @return 学院成绩信息
	 */
	public VCollegeScore getByCollegeid(int collegeid);
	/**
	 * 查询所有学院成绩
	 * @return List<ScoreCollege>数据集
	 */
	public List<VCollegeScore> getAllCollegeScore();
	
	/**
	 * 根据学院名称查询学院成绩(分页)
	 * @param cllegeName 学院名称
	 * @param pageSize 每页显示数量
	 * @param startPage 当前页
	 * @return List<ScoreCollege>数据集
	 */
	public List<VCollegeScore> getCollegeScoreBypage(String cllegeName,int pageSize,int startPage);
	/**
	 * 查询学院成绩
	 * @param collegeName 学院名称
	 * @return
	 */
	public List<VCollegeScore> getSearchCollege(String collegeName);
	/**
	 * 查询分页总页数
	 * @param pageSize 每页显示数量
	 */
	public int getpageAmount(int pageSize);
	
	/**
	 * 查询分页总页数（带条件）
	 * @param opraton 条件
	 * @param pageSize每页显示数量
	 * @return
	 */
	public int getpageAmountbysearch(String opraton,int pageSize); 
	/**
	 * 获取某个学院学生的总分
	 * @return
	 */
	public double allStuScore(int collegeid);
	/**
	 * 获取某个学院学生的平均分
	 * @return
	 */
	public double avgStuScore(int collegeid);
	/**
	 * 获取某个学院教师的总分
	 * @return
	 */
	public double allTeaScore(int collegeid);
	/**
	 * 获取某个学院教师的平均分
	 * @return
	 */
	public double avgTeaScore(int collegeid);

	/**
	 * 分页查询所有学院成绩
	 * @param strwhere 查询条件（为空填写为""）
	 * @param startPage 当前页
	 * @param pageSize 每页显示数量
	 * @return List<ScoreCollege>数据集
	 */
	public List<VCollegeScore> getCollegeByPage(String strwhere,int startPage,int pageSize);
	
	/**
	 * 查询学院数据总条数
	 * @param strwhere 查询条件（为空填写为""）
	 */
	public int getCollegeCount(String strwhere);

	/**
	 * 分页查询所有专业成绩
	 * @param strwhere 查询条件（为空填写为""）
	 * @param startPage 当前页
	 * @param pageSize 每页显示数量
	 * @return List<ScoreCollege>数据集
	 */
	public List<VMajorScore> getMajorByPage(String strwhere,int startPage,int pageSize);

	/**
	 * 查询专业数据总条数
	 * @param strwhere 查询条件（为空填写为""）
	 */
	public int getMajorCount(String strwhere);

	/**
	 * 分页查询所有班级成绩
	 * @param strwhere 查询条件（为空填写为""）
	 * @param startPage 当前页
	 * @param pageSize 每页显示数量
	 * @return List<ScoreCollege>数据集
	 */
	public List<VClassScore> getClassesByPage(String strwhere,int startPage,int pageSize);

	/**
	 * 查询班级数据总条数
	 * @param strwhere 查询条件（为空填写为""）
	 */
	public int getClassesCount(String strwhere);

	/**
	 * 分页查询所有运动员成绩
	 * @param strwhere 查询条件（为空填写为""）
	 * @param startPage 当前页
	 * @param pageSize 每页显示数量
	 * @return List<ScoreCollege>数据集
	 */
	public List<VUserScore> getUserByPage(String strwhere,int startPage,int pageSize);

	/**
	 * 查询运动员数据总条数
	 * @param strwhere 查询条件（为空填写为""）
	 */
	public int getUserCount(String strwhere);
}
