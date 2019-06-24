package business.impl;

import java.util.ArrayList;
import java.util.List;

import model.TSystemLog;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.SystemLogDAO;

import common.properties.OperType;

public class SystemLogDaoImpl implements SystemLogDAO {
	private iHibBaseDAO hdao = null;

	public SystemLogDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List getAllOperType() {
		List list = new ArrayList();
		for (String s : OperType.OPERTYPES) {
			list.add(s);
		}
		return list;
	}

	@Override
	public List<TSystemLog> getaAllSystemList(String wherecondition, int page,
			int pageSize) {
		String hql = "from TSystemLog";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		List<TSystemLog> list = hdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Override
	public int getSystemLogAmount(String wherecondition) {
		String hql = "select count(id) from TSystemLog";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return hdao.selectValue(hql);
	}

	// public static void main(String[] args) {
	// SystemLogDaoImpl sDaoImpl = new SystemLogDaoImpl();
	//
	// List<String> list = sDaoImpl.getAllOperType();
	// for (String s : list) {
	// System.out.println(s);
	// }
	//
	// }
}
