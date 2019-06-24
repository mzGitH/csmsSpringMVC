package business.dao;

import java.util.List;

import model.*;

public interface ClassesDAO {
	/**
	 * 添加班级
	 * @param classes 班级对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(TClass classes);
	
	/**
	 * 删除班级
	 * @param classid 班级id
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean delete(int classid);
	
	/**
	 * 根据班级id获取班级对象
	 * @param classid 班级id
	 * @return 班级对象
	 */
	public TClass selectByid(int classid);
	
	/**
	 * 获取所有班级对象列表
	 * @return 班级对象列表
	 */
	public List<TClass> select();

	/**
	 * 获取所有班级对象列表
	 * @param majorid 专业id
	 * @return 班级对象列表
	 */
	public List<TClass> selectByMajor(int majorid);
	/**
	 * 根据班级id获取班级视图对象
	 * @param classid 班级id
	 * @return 班级对象
	 */
	public VClass selectByidVclass(int classid);
	
	/**
	 * 获取所有班级视图对象列表
	 * @return 班级对象列表
	 */
	public List<VClass> selectVclass();

	/**
	 * 获取所有班级视图对象列表
	 * @param majorid 专业id
	 * @return 班级对象列表
	 */
	public List<VClass> selectByMajorVclass(int majorid);
	/**
	 * 根据学院获取所有班级视图对象列表
	 * @param majorid 专业id
	 * @return 班级对象列表
	 */
	public List<VClass> selectByCollegeVclass(int collegeid);
}
