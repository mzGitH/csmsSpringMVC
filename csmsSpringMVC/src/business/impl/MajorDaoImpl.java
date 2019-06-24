package business.impl;

import java.util.List;

import model.TMajor;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.MajorDAO;

public class MajorDaoImpl implements MajorDAO {

	private iHibBaseDAO bdao;

	public void setBdao(iHibBaseDAOImpl bdao) {
		this.bdao = bdao;
	}

	@Override
	public boolean insert(TMajor major) {
		int row = (Integer) bdao.insert(major);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(int majorid) {
		TMajor major = (TMajor) bdao.findById(TMajor.class, majorid);
		return bdao.delete(major);
	}

	@Override
	public TMajor selectByid(int majorid) {
		return (TMajor) bdao.findById(TMajor.class, majorid);
	}

	@Override
	public List<TMajor> select() {
		String hql = "from TMajor";
		List<TMajor> list = (List<TMajor>) bdao.select(hql);
		return list;
	}

	@Override
	public List<TMajor> selectByColl(int collegeid) {
		String hql = "from TMajor where collegeid=?";
		Object[] para = { collegeid };
		List<TMajor> list = (List<TMajor>) bdao.select(hql, para);
		return list;
	}

	@Override
	public int getPageCount() {
		String hql = "select count(*) from TMajor";
		int count = bdao.selectValue(hql);
		return count;
	}

}
