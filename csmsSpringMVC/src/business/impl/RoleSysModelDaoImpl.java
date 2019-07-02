package business.impl;

import java.util.List;

import model.TRoleSysModel;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.RoleSysModelDAO;

import common.properties.OperType;

@Component("rolesysmodeldao")
public class RoleSysModelDaoImpl implements RoleSysModelDAO {
	private iHibBaseDAO bdao;

	public RoleSysModelDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加一条权限记录")
	@Override
	public boolean addRoleModel(TRoleSysModel rolemodel) {

		String id = (String) bdao.insert(rolemodel);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "批量添加权限记录")
	@Override
	public boolean addRoleModel(List<Object> rolemodellist) {

		return bdao.insertList(rolemodellist);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "更新权限一条记录")
	@Override
	public boolean updataRoleModel(int rolemodelid) {
		TRoleSysModel rolemodelsql = (TRoleSysModel) bdao.findById(
				TRoleSysModel.class, rolemodelid);
		if (rolemodelsql.getIsedit()) {
			rolemodelsql.setIsedit(false);
		} else {
			rolemodelsql.setIsedit(true);
		}
		return bdao.update(rolemodelsql);
	}

}
