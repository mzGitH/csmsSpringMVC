package business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.TConfig;
import model.TProject;
import model.TSportProject;
import model.VSportProject;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import business.basic.HibSessionFactory;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.SportsDAO;
import business.factory.DAOFactory;

@Component("sportsdao")
public class SportsDAOImpl implements SportsDAO {
	private iHibBaseDAO bdao;

	public SportsDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public int insert(TConfig config) {
		Object row = bdao.insert(config);
		if (row != null && !row.equals("0")) {
			return (Integer)row;
		} else {
			return 0;
		}
	}

	@Override
	public boolean update(TConfig config) {
		return bdao.update(config);
	}
	
	@Override
	public boolean delete(int sportid) {
		Session session = HibSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();// 开始事务
			//获取赛事赛项列表
			List<TSportProject> tsplist = (List<TSportProject>)DAOFactory.getSportsDAO().selectTSPlist(sportid);
			//获取赛事对象
			TConfig sport = (TConfig)bdao.findById(TConfig.class, sportid);
			for (TSportProject tsp : tsplist) {
				session.delete(tsp);
			}
			session.delete(sport);
			tx.commit();// 持久化操作
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// 撤销
			if (session != null)
				session.close();
		}
		return false;
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
		String hql = "select count(sportid) from TConfig"+where;
		return bdao.selectValue(hql);
	}

	@Override
	public List<VSportProject> selectTSP(String where, int startPage,
			int pageSize) {
		String hql = "from VSportProject"+where;
		return bdao.selectByPage(hql, startPage, pageSize);
	}

	@Override
	public List<TSportProject> selectTSPlist(int sportid) {
		String hql = "from TSportProject where sportid=?";
		Object[] param = {sportid};
		return bdao.select(hql,param);
	}
	
	@Override
	public int getTSPCount(String where) {
		String hql = "select count(sportid) from VSportProject"+where;
		return bdao.selectValue(hql);
	}

	@Override
	public List<TConfig> getNotExistsConfig() {
		String sql = "select sportid,sportname from T_Config where not exists(select * from T_SportProject where sportid = T_Config.sportid)";
		List<HashMap<String, Object>> list = bdao.selectBysql(sql);
		List<TConfig> newlist = new ArrayList<TConfig>();
		if(list!=null && list.size()>0){
			for(HashMap<String, Object> hashMap:list){
				Object sportid = hashMap.get("sportid");
				Object sportname = hashMap.get("sportname");
				TConfig config = new TConfig();
				config.setSportid((Integer)sportid);
				config.setSportname((String)sportname);
				newlist.add(config);
			}
			return newlist;
		}else{
			return null;
		}
	}

	@Override
	public boolean insertTSP(List<TSportProject> list) {
		Session session = HibSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();// 开始事务
			for (TSportProject tsp : list) {
				session.save(tsp);
			}
			tx.commit();// 持久化操作
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();// 撤销
			if (session != null)
				session.close();
		}
		return false;
	}

	@Override
	public boolean deleteTSP(int id) {
		return bdao.delete(TSportProject.class, id);
	}

	@Override
	public List<TProject> getNotExistsProject(int sportid) {
		String sql = "select proid,proname,protype from T_Project where not exists(select * from T_SportProject where proid=T_Project.proid and sportid = "+sportid+")";
		List<HashMap<String, Object>> list = bdao.selectBysql(sql);
		List<TProject> newlist = new ArrayList<TProject>();
		if(list!=null && list.size()>0){
			for(HashMap<String, Object> hashMap:list){
				Object proid = hashMap.get("proid");
				Object proname = hashMap.get("proname");
				Object protype = hashMap.get("protype");
				TProject project = new TProject();
				project.setProid((Integer)proid);
				project.setProname((String)proname);
				project.setProtype((Integer)protype);
				newlist.add(project);
			}
			return newlist;
		}else{
			return null;
		}
	}

	@Override
	public List<TProject> getExistsProject(int sportid) {
		String sql = "select proid,proname,protype from T_Project where exists(select * from T_SportProject where proid=T_Project.proid and sportid = "+sportid+")";
		List<HashMap<String, Object>> list = bdao.selectBysql(sql);
		List<TProject> newlist = new ArrayList<TProject>();
		if(list!=null && list.size()>0){
			for(HashMap<String, Object> hashMap:list){
				Object proid = hashMap.get("proid");
				Object proname = hashMap.get("proname");
				Object protype = hashMap.get("protype");
				TProject project = new TProject();
				project.setProid((Integer)proid);
				project.setProname((String)proname);
				project.setProtype((Integer)protype);
				newlist.add(project);
			}
			return newlist;
		}else{
			return null;
		}
	}

}
