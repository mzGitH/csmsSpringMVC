package business.dao;

import java.util.List;

import model.TSystemLog;

public interface SystemLogDAO {
	/**
	 * 获取所有的日志类型
	 */
	public List getAllOperType();

	/**
	 * 根据条件获取系统日志列表
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<TSystemLog> getaAllSystemList(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据条件获取符合条件的系统日志的数量
	 * 
	 * @param wherecondition
	 *            如："userRole = '超级管理员' and userid = 'zhangjs'"
	 * @return
	 */
	public int getSystemLogAmount(String wherecondition);

}
