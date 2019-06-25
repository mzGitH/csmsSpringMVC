package business.impl;

import java.util.List;

import model.TConfig;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.SportsDAO;

@Component("sportsdao")
public class SportsDAOImpl implements SportsDAO {
	private iHibBaseDAO bdao;

	public SportsDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
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
