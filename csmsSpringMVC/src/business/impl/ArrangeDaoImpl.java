package business.impl;

import java.util.List;

import model.TArrange;
import model.VArrange;
import model.VScene;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ArrangeDAO;

public class ArrangeDaoImpl implements ArrangeDAO {
	private iHibBaseDAO bdao;

	public void setBdao(iHibBaseDAOImpl bdao) {
		this.bdao = bdao;
	}

	// public ArrangeDaoImpl(){
	// bdao = new iHibBaseDAOImpl();
	// }
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
	public List<VArrange> selectByPage(String strWhere, int pageSize,
			int startPage) {
		String hql = "from VArrange" + strWhere;
		List<VArrange> list = bdao.selectByPage(hql, startPage, pageSize);
		return list;
	}

	@Override
	public int getCount(String strWhere) {
		String hql = "select count(*) from VArrange" + strWhere;
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

}
