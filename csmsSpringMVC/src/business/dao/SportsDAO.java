package business.dao;

import java.util.List;

import model.TConfig;
import model.TSportProject;
import model.VSportProject;
/**
 * 运动会配置业务接口类
 * @author Administrator
 *
 */
public interface SportsDAO {
	/**
	 * 添加运动会时间配置
	 * @param config 配置对象
	 * @return 添加结果，true为成功，false为失败
	 */
	public boolean insert(TConfig config);
	
	/**
	 * 更新运动会时间配置
	 * @param config 配置对象
	 * @return 更新结果，true为成功，false为失败
	 */
	public boolean update(TConfig config);

	/**
	 * 删除运动会时间配置
	 * @param sportid 配置对象id
	 * @return 更新结果，true为成功，false为失败
	 */
	public boolean delete(int sportid);
	
	/**
	 * 获取所有配置对象列表
	 * @return 配置对象列表
	 */
	public List<TConfig> select();

	/**
	 * 获取所有配置对象列表
	 * @param where 筛选条件
	 * @param startPage 开始页面
	 * @param pageSize 每页记录数
	 * @return 配置对象列表
	 */
	public List<TConfig> selectByPage(String where,int startPage,int pageSize);

	/**
	 * 获取数据记录数
	 * @param where 筛选条件
	 * @return 数据记录数
	 */
	public int getCount(String where);

	/**
	 * 获取所有运动会项目对象列表
	 * @param where 筛选条件
	 * @param startPage 开始页面
	 * @param pageSize 每页记录数
	 * @return 配置对象列表
	 */
	public List<VSportProject> selectTSP(String where,int startPage,int pageSize);

	/**
	 * 获取数据记录数
	 * @param where 筛选条件
	 * @return 数据记录数
	 */
	public int getTSPCount(String where);
	
	/**
	 * 获取未安排赛项的赛事列表
	 * @return
	 */
	public List<TConfig> getNotExistsConfig();
	

	/**
	 * 批量添加运动会项目配置
	 * @param tsp 运动会项目配置对象
	 * @return 添加结果，true为成功，false为失败
	 */
	public boolean insertTSP(List<TSportProject> list);

	/**
	 * 删除运动会某项目配置
	 * @param id 运动会项目配置id
	 * @return 删除结果，true为成功，false为失败
	 */
	public boolean deleteTSP(int id);
}
