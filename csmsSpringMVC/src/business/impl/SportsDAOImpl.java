package business.impl;

import java.util.List;

import model.TConfig;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.SportsDAO;

public class SportsDAOImpl implements SportsDAO {
	private iHibBaseDAO bdao;

	public void setBdao(iHibBaseDAOImpl bdao) {
		this.bdao = bdao;
	}

	@Override
	public boolean insert(TConfig config) {
		int row = (Integer) bdao.insert(config);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(TConfig config) {
		return bdao.update(config);
	}

	@Override
	public List<TConfig> select() {
		String hql = "from TConfig";
		return bdao.select(hql);
	}

}
