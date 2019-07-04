package business.impl;

import java.util.List;

import model.TConfig;
import model.TProject;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ProjectDAO;

@Component("projectdao")
public class ProjectDaoImpl implements ProjectDAO {
	private iHibBaseDAO bdao;

	public ProjectDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public boolean insert(TProject project) {
		int res = (int) bdao.insert(project);
		if (res > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(TProject project) {
		TProject sqlproject = (TProject) bdao.findById(TProject.class,
				project.getProid());
		sqlproject.setProname(project.getProname());
		sqlproject.setScenelimit(project.getScenelimit());
		sqlproject.setCollegelimit(project.getCollegelimit());
		sqlproject.setTotallimit(project.getTotallimit());
		sqlproject.setProtype(project.getProtype());
		return bdao.update(sqlproject);

	}

	@Override
	public boolean delete(int projectid) {
		return bdao.delete(bdao.findById(TProject.class, projectid));
	}

	@Override
	public List<TProject> select() {
		String hql = "from TProject";
		return (List<TProject>) bdao.select(hql);
	}

	@Override
	public List<TProject> selectByType(int type) {
		String hql = "from TProject where protype=?";
		Object[] param = { type };
		return (List<TProject>) bdao.select(hql, param);
	}

	@Override
	public List<TProject> selectByPage(String where, int startPage, int pageSize) {
		String hql = null;
		hql = "from TProject" + where;
		List<TProject> list = bdao.selectByPage(hql, startPage, pageSize);
		return list;
	}

	@Override
	public int getProCount(String where) {
		String hql = null;
		hql = "select count(proid) from TProject" + where;
		int count = bdao.selectValue(hql);
		return count;
	}

	@Override
	public TProject getptoject(int projectid) {
		TProject pro = (TProject) bdao.findById(TProject.class, projectid);
		return pro;
	}

	@Override
	public List<TProject> select(int sportid) {
		String hql = "from VSportProject where sportid=?";
		Object[] para = { sportid };
		return (List<TProject>) bdao.select(hql, para);
	}

	// public static void main(String[] args) {
	// ProjectDAO pdao = new ProjectDaoImpl();
	// List<TProject> prolistList = pdao.select(1);
	// for (TProject p : prolistList) {
	// System.out.println(p.getProname());
	// }
	// }

	@Override
	public List<TProject> selectnow(TConfig cfg) {
		String hql = "from VSportProject where sportid=?";
		Object[] para = { cfg.getSportid() };
		return (List<TProject>) bdao.select(hql, para);
	}
}
