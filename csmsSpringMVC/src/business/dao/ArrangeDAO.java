package business.dao;

import java.util.List;

import model.TArrange;
import model.VArrange;
import model.VScene;

/**
 * 比赛场次安排接口类
 * @author Administrator
 *
 */
public interface ArrangeDAO {
	/**
	 * 添加场次安排
	 * @param arrange 场次安排对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(TArrange arrange);
	
	/**
	 * 删除场次安排
	 * @param arrangeid 安排id
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean delete(int arrangeid);

	/**
	 * 获取所有场次中的人员信息
	 * @param arrid 场次安排id
	 * @return 场次中的人员信息列表
	 */
	public List<VScene> selectById(int arrid);
	
	/**
	 * 获取所有场次安排列表
	 * @param strWhere 查询条件（为空是填写为""）
	 * @param startPage 获取数据页面
	 * @param pageSize 每页的记录数
	 * @return 场次安排列表
	 */
	public List<VArrange> selectByPage(String strWhere,int pageSize,int startPage);

	/**
	 * 获取所有场次安排列表数据量
	 * @param strWhere 查询条件（为空是填写为""）
	 * @return 列表数据量
	 */
	public int getCount(String strWhere);
	/**
	 * 获取场次比赛类型
	 * @param strWhere 查询条件（为空是填写为""）
	 * @return 列表数据量
	 */
	public int getProType(int arrid);
}
