package business.impl;

import java.util.List;

import model.TAdminRole;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.AdminRoleDAO;

@Component("adminroledao")
public class AdminRoleDaoImpl implements AdminRoleDAO {
	private iHibBaseDAO bdao;

	public AdminRoleDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<TAdminRole> getaAdminUserList() {
		String hql = "from TAdminRole";
		List<TAdminRole> list = bdao.select(hql);
		return list;

	}
}
