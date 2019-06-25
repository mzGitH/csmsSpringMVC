package business.impl;

import java.util.List;

import model.TAdminUser;
import model.VAdminUser;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.AdminUserDAO;

@Component("adminuserdao")
public class AdminUserDaoImpl implements AdminUserDAO {
	private iHibBaseDAO hdao = null;

	public AdminUserDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<VAdminUser> getaAdminUserList(String wherecondition, int page,
			int pageSize) {
		String hql = "from VAdminUser";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		List<VAdminUser> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getAdaminUserAmount(String wherecondition) {
		String hql = "select count(userid) from VAdminUser";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);

	}

	// public static void main(String[] args) {
	//
	// AdminUserDaoImpl auDaoImpl = new AdminUserDaoImpl();
	//
	// List list = auDaoImpl.getaAdminUserList(null, 1, 20);
	// System.out.println(list.size());
	// }

	@Override
	public boolean addAdminUser(TAdminUser user) {
		String id = (String) hdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Override
	public TAdminUser login(TAdminUser user) {
		TAdminUser user2;

		user2 = (TAdminUser) hdao.findById(TAdminUser.class, user.getUserid());
		if (user2 != null) {
			if (user.getPwd().equals(user2.getPwd())) {
				return user2;
			}
		}

		return null;
	}

}
