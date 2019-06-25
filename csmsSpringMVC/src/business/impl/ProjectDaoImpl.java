package business.impl;

import java.util.List;

import model.TProject;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ProjectDAO;

import common.properties.RoleType;

@Component("projectdao")
public class ProjectDaoImpl implements ProjectDAO {
	private iHibBaseDAO bdao;

	public ProjectDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public boolean insert(TProject project) {
		String res = (String) bdao.insert(project);
		if (res != null) {
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
	public List<TProject> selectByPage(int roletype, int startPage, int pageSize) {
		String hql = null;
		if (roletype == RoleType.Student || roletype == RoleType.Committee) {
			hql = "from TProject where protype=1 or protype=2";
		} else if (roletype == RoleType.Teacher
				|| roletype == RoleType.Organization) {
			hql = "from TProject where protype=3 or protype=4";
		}
		List<TProject> list = bdao.selectByPage(hql, startPage, pageSize);
		return list;
	}

	@Override
	public int getProCount(int roletype) {
		String hql = null;
		if (roletype == RoleType.Student || roletype == RoleType.Committee) {
			hql = "select count(proid) from TProject where protype=1 or protype=2";
		} else if (roletype == RoleType.Teacher
				|| roletype == RoleType.Organization) {
			hql = "select count(proid) from TProject where protype=3 or protype=4";
		}
		int count = bdao.selectValue(hql);
		return count;
	}

	@Override
	public TProject getptoject(int projectid) {
		TProject pro = (TProject) bdao.findById(TProject.class, projectid);
		return pro;
	}

	// public static void main(String[] args) {
	// ProjectDAO pdao = new ProjectDaoImpl();
	// // int row = pdao.getProCount(2);
	// List<TProject> list = pdao.selectByPage(1, 1, 3);
	// for (TProject p : list) {
	// System.out.println(p.getProname());
	// }
	// }
}
