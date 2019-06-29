package business.impl;

import java.util.List;

import model.TArrange;
import model.VArrange;
import model.VScene;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ArrangeDAO;

@Component("arrangedao")
public class ArrangeDaoImpl implements ArrangeDAO {
	private iHibBaseDAO bdao;

	public ArrangeDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public boolean insert(TArrange arrange) {
		int row = (Integer) bdao.insert(arrange);
		if (row > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int arrangeid) {
		TArrange arrange = (TArrange) bdao.findById(TArrange.class, arrangeid);
		return bdao.delete(arrange);
	}

	@Override
	public List<VArrange> selectByPage(String strWhere, int page, int limit) {
		String hql = "from VArrange";
		if (strWhere != null && !strWhere.equals("")) {
			hql += strWhere;
		}
		List<VArrange> list = bdao.selectByPage(hql, page, limit);
		return list;
	}

	@Override
	public int getCount(String strWhere) {
		String hql = "select count(*) from VArrange";
		if (strWhere != null && !strWhere.equals("")) {
			hql += strWhere;
		}
		int count = bdao.selectValue(hql);
		return count;
	}

	@Override
	public List<VScene> selectById(int arrid) {
		String hql = "from VScene where arrid=?";
		Object[] param = { arrid };
		List<VScene> list = bdao.select(hql, param);
		return list;
	}

	@Override
	public int getProType(int arrid) {
		String hql = "select protype from VArrange where arrid=?";
		Object[] param = { arrid };
		int count = bdao.selectValue(hql, param);
		return count;
	}

	@Override
	public boolean updateState(int arrid, int state) {
		// TODO Auto-generated method stub
		TArrange arrange = (TArrange) bdao.findById(TArrange.class, arrid);
		arrange.setState(state);
		boolean count = bdao.update(arrange);
		return count;
	}

}
