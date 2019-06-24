package business.dao;

import java.util.List;

import model.TAdminRole;

public interface AdminRoleDAO {
	/**
	 * 根据条件获取管理员角色列表
	 * 
	 * @return List
	 */
	public List<TAdminRole> getaAdminUserList();
}
