package business.impl;

import java.util.List;

import model.TUser;
import model.VUser;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.UserDAO;

import common.properties.OperType;

@Component("userdao")
public class UserDaoImpl implements UserDAO {
	private iHibBaseDAO bdao;

	public UserDaoImpl() {
		bdao = new iHibBaseDAOImpl();
	}

	@Override
	public TUser loginStu(String userid, String pwd) {
		TUser user2 = (TUser) bdao.findById(TUser.class, userid);
		if (user2 != null) {
			if (user2.getPwd().equals(pwd)) {
				return user2;
			}
		}

		return null;
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "����û�")
	@Override
	public boolean insert(TUser user) {
		String id = (String) bdao.insert(user);
		if (id != null && !id.equals("")) {

			return true;
		}
		return false;

	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "�޸��û�����")
	@Override
	public boolean updatePwd(String userid, String pwd) {

		TUser user = (TUser) bdao.findById(TUser.class, userid);
		user.setPwd(pwd);
		return bdao.update(user);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "�����û�id ɾ���û�")
	@Override
	public boolean delete(String userid) {
		TUser user = (TUser) bdao.findById(TUser.class, userid);

		return bdao.delete(user);
	}

	@Override
	public TUser getTUserByUserId(String userid) {
		// TODO Auto-generated method stub
		return (TUser) bdao.findById(TUser.class, userid);
	}

	@Override
	public List<VUser> selectUserByColl(String collegeid) {
		String hql = "from VUser where collegeid=?";
		Object[] param = { collegeid };

		return bdao.select(hql, param);
	}

	@Override
	public List<VUser> selectUserByMajor(String majorid) {
		String hql = "from VUser where majorid=?";
		Object[] param = { majorid };

		return bdao.select(hql, param);
	}

	@Override
	public List<VUser> selectUserByClass(String classid) {
		String hql = "from VUser where classid=?";
		Object[] param = { classid };

		return bdao.select(hql, param);
	}

	@Override
	public List<VUser> selectUserByClassPage(int classid, int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUserAmount(String opretion) {
		String hql = "from VUser ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		return bdao.selectValue(hql);
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "��������û�")
	@Override
	public boolean insertList(List<Object> classeslist) {
		return bdao.insertList(classeslist);
	}

	@Override
	public List<VUser> selectUserByPage(String opretion, int page, int limit) {
		String hql = "from VUser ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		hql += " order by userid";
		return bdao.selectByPage(hql, page, limit);
	}
}
