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
	public boolean delete(int sportid) {
		return bdao.delete(TConfig.class, sportid);
	}

	@Override
	public List<TConfig> select() {
		String hql = "from TConfig";
		return bdao.select(hql);
	}

	@Override
	public List<TConfig> selectByPage(String where, int startPage, int pageSize) {
		String hql = "from TConfig"+where;
		return bdao.selectByPage(hql, startPage, pageSize);
	}

	@Override
	public int getCount(String where) {
		String hql = "from TConfig"+where;
		return bdao.selectValue(hql);
	}

}
