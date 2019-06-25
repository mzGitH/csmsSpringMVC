package business.impl;

import java.util.List;

import model.VScore;
import model.VStudentScore;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ScoreStudentDAO;

@Component("scorestudentdao")
public class ScoreStudentDaoImpl implements ScoreStudentDAO {
	private iHibBaseDAO bdao;

	public ScoreStudentDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public VStudentScore getByUserid(String userid) {
		String hql = "from VStudentScore where userid=?";
		Object[] param = { userid };
		List<VStudentScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			for (VStudentScore score : list) {
				VStudentScore newScore = score;
				return newScore;
			}
			return null;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getScoreStudent(String userid) {
		String hql = "from VScore where userid=?";
		Object[] param = { userid };
		List<VScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getAllScoreByPage(String strwhere, int startPage,
			int pageSize) {
		String hql = "from VScore" + strwhere;
		List<VScore> list = bdao.selectByPage(hql, startPage, pageSize);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public double allScore(String userid) {
		String hql = "select round(sum(scorenumber),2) as scorenumber from VScore where userid=?";
		Object[] param = { userid };
		List list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return (Double) list.get(0);
		} else {
			return 0;
		}
	}

	@Override
	public double avgScore(String userid) {
		String hql = "select round(avg(scorenumber),2) as scorenumber from VScore where userid=?";
		Object[] param = { userid };
		List list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return (Double) list.get(0);
		} else {
			return 0;
		}
	}

}
