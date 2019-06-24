package business.impl;

import java.util.List;

import model.TAdminRole;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.AdminRoleDAO;

public class AdminRoleDaoImpl implements AdminRoleDAO {
	private iHibBaseDAO bdao;

	public void setBdao(iHibBaseDAOImpl bdao) {
		this.bdao = bdao;
	}

	@Override
	public List<TAdminRole> getaAdminUserList() {
		String hql = "from TAdminRole";
		List<TAdminRole> list = bdao.select(hql);
		return list;

	}
}
