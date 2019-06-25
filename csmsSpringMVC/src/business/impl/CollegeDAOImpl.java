package business.impl;

import java.util.List;

import model.TCollege;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.CollegeDAO;

@Component("collegedao")
public class CollegeDAOImpl implements CollegeDAO {
	private iHibBaseDAO bdao;

	public CollegeDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public boolean insert(TCollege college) {
		int row = (Integer) bdao.insert(college);
		if (row > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int collegeid) {
		TCollege college = (TCollege) bdao.findById(TCollege.class, collegeid);
		return bdao.delete(college);
	}

	@Override
	public TCollege selectByid(int collegeid) {
		TCollege college = (TCollege) bdao.findById(TCollege.class, collegeid);
		return college;
	}

	@Override
	public List<TCollege> select() {
		String hql = "from TCollege";
		List<TCollege> list = (List<TCollege>) bdao.select(hql);
		return list;
	}

	@Override
	public List<TCollege> selectByPage(int startPage, int pageSize) {
		String hql = "from TCollege";
		List<TCollege> list = (List<TCollege>) bdao.selectByPage(hql,
				startPage, pageSize);
		return list;
	}
}
