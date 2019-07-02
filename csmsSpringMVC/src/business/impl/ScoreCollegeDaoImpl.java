package business.impl;

import java.util.List;

import model.VClassScore;
import model.VCollegeScore;
import model.VMajorScore;
import model.VScore;
import model.VUserScore;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ScoreCollegeDAO;

@Component("scorecollegedao")
public class ScoreCollegeDaoImpl implements ScoreCollegeDAO {
	private iHibBaseDAO bdao;

	public ScoreCollegeDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public VCollegeScore getByCollegeid(int collegeid) {
		VCollegeScore score = (VCollegeScore) bdao.findById(
				VCollegeScore.class, collegeid);
		if (score != null && score.getCollegeid() != 0) {
			return score;
		} else {
			return null;
		}
	}

	@Override
	public List<VCollegeScore> getAllCollegeScore() {
		String hql = "from VCollegeScore";
		List<VCollegeScore> list = bdao.select(hql);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VCollegeScore> getCollegeScoreBypage(String collegeName,
			int pageSize, int currpage) {
		String hql = "from VCollegeScore where collegeName=?";
		Object[] param = { collegeName };
		List<VCollegeScore> list = bdao.selectByPage(hql, param, currpage,
				pageSize);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VCollegeScore> getSearchCollege(String collegeName) {
		String hql = "from VCollegeScore where collegeName=?";
		Object[] param = { collegeName };
		List<VCollegeScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public int getpageAmount(int pageSize) {
		String sql = "select count(*) from VCollegeScore";
		return bdao.selectPages(sql, pageSize);
	}

	@Override
	public int getpageAmountbysearch(String opraton, int pageSize) {
		String sql = "select count(*) from VCollegeScore where collegeName=?";
		Object[] param = { opraton };
		return bdao.selectPages(sql, param, pageSize);
	}

	@Override
	public double allStuScore(int collegeid) {
		String hql = "select round(sum(scorenumber),2) as scorenumber from VScore where collegeid=?";
		Object[] param = { collegeid };
		List list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			if (list.get(0) != null) {
				return (Double) list.get(0);
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	@Override
	public double avgStuScore(int collegeid) {
		String hql = "select round(avg(scorenumber),2) as scorenumber from VScore where collegeid=?";
		Object[] param = { collegeid };
		List list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			if (list.get(0) != null) {
				return (Double) list.get(0);
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	@Override
	public double allTeaScore(int collegeid) {
		String hql = "select round(sum(scorenumber),2) as scorenumber from VScore where teacollegeid=?";
		Object[] param = { collegeid };
		List list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			if (list.get(0) != null) {
				return (Double) list.get(0);
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	@Override
	public double avgTeaScore(int collegeid) {
		String hql = "select round(avg(scorenumber),2) as scorenumber from VScore where teacollegeid=?";
		Object[] param = { collegeid };
		List list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			if (list.get(0) != null) {
				return (Double) list.get(0);
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
	

	@Override
	public List<VCollegeScore> getCollegeByPage(String strwhere,
			int startPage, int pageSize) {
		String hql = "from VCollegeScore" + strwhere;
		List<VCollegeScore> list = bdao.selectByPage(hql, startPage, pageSize);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public int getCollegeCount(String strwhere) {
		String sql = "select count(*) from VCollegeScore" + strwhere;
		return bdao.selectValue(sql);
	}
	
	@Override
	public List<VMajorScore> getMajorByPage(String strwhere, int startPage,
			int pageSize) {
		String hql = "from VMajorScore" + strwhere;
		List<VMajorScore> list = bdao.selectByPage(hql, startPage, pageSize);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public int getMajorCount(String strwhere) {
		String sql = "select count(*) from VMajorScore" + strwhere;
		return bdao.selectValue(sql);
	}

	@Override
	public List<VClassScore> getClassesByPage(String strwhere, int startPage,
			int pageSize) {
		String hql = "from VClassScore" + strwhere;
		List<VClassScore> list = bdao.selectByPage(hql, startPage, pageSize);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public int getClassesCount(String strwhere) {
		String sql = "select count(*) from VClassScore" + strwhere;
		return bdao.selectValue(sql);
	}

	@Override
	public List<VUserScore> getUserByPage(String strwhere, int startPage,
			int pageSize) {
		String hql = "from VUserScore" + strwhere;
		List<VUserScore> list = bdao.selectByPage(hql, startPage, pageSize);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public int getUserCount(String strwhere) {
		String sql = "select count(*) from VUserScore" + strwhere;
		return bdao.selectValue(sql);
	}
}
