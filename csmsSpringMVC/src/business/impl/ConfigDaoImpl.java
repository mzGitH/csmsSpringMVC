package business.impl;

import java.util.List;

import model.TConfig;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ConfigDAO;

@Component("configdao")
public class ConfigDaoImpl implements ConfigDAO {

	private iHibBaseDAO hdao = null;

	public ConfigDaoImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List<TConfig> getTConfig() {
		String hql = "from TConfig where iscomplete='true'";

		hql += " order by sportid asc";
		List<TConfig> list = hdao.select(hql);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public TConfig getNowTConfig() {
		String hql = "from TConfig where iscomplete='true' order by sportid asc";
		List<TConfig> list = hdao.select(hql);
		TConfig config = new TConfig();
		for (TConfig tConfig : list) {
			config = tConfig;
		}
		return config;
	}

	@Override
	public List<TConfig> getAllConfig() {
		// TODO Auto-generated method stub
		String hql = "from TConfig";
		List<TConfig> list = hdao.select(hql);
		return list;
	}

	@Override
	public List<TConfig> getAllConfigByid(int sportid) {
		String hql = "from TConfig where sportid=?";
		Object[] para = { sportid };
		List<TConfig> list = hdao.select(hql, para);
		return list;
	}
}
