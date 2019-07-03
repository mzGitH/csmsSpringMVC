package business.impl;

import java.util.List;

import model.TScore;
import model.VScore;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ScoreDAO;

@Component("scoredao")
public class ScoreDaoImpl implements ScoreDAO {
	private iHibBaseDAO bdao;

	public ScoreDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public boolean insert(TScore score) {
		int row = (Integer) bdao.insert(score);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(TScore score) {
		return bdao.update(score);
	}

	@Override
	public List<VScore> getByUser(String userid) {
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
	public List<VScore> getByCollege(int collegeid) {
		String hql = "from VScore where collegeid=?";
		Object[] param = { collegeid };
		List<VScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getByClass(int classid) {
		String hql = "from VScore where classid=?";
		Object[] param = { classid };
		List<VScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getCollegeScoreOrder() {
		String sql = "select top 10 a.collegename,Round(AVG(a.score),2) as scorenumber from (select top 100 collegename,Round(AVG(scorenumber),2) as score from V_Score where collegename!='' group by collegename order by score desc union  select top 100 teacollegename,Round(AVG(scorenumber),2) as score from V_Score where teacollegename !=''  group by teacollegename order by score desc) as a group by a.collegename order by scorenumber desc";
		List<VScore> scorelist = bdao.select(sql);
		return scorelist;
	}

	public static void main(String[] args) {
		ScoreDAO dao = new ScoreDaoImpl();
		List<VScore> list = dao.getCollegeScoreOrder();
		System.out.println(list.size());
	}

	@Override
	public List<VScore> getScoreByPage(String strwhere, int startPage, int limit) {
		String hql = "from VScore" + strwhere;
		List<VScore> list = bdao.selectByPage(hql, startPage, limit);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getScore(String strwhere) {
		String hql = "from VScore s1 where scorenumber = (select max(s2.scorenumber) from VScore s2 group by s2.proid having s1.proid=s2.proid)"
				+ strwhere;
		List<VScore> list = bdao.select(hql);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public int allScoreCount(String strwhere) {
		String hql = "select count(*) from VScore" + strwhere;
		int count = bdao.selectValue(hql);
		return count;
	}

	@Override
	public List<VScore> getScoreByProSingle(int proid) {
		String hql = "from VScore where proid=? and (protype=1 or protype=3) order by scorenumber desc";
		Object[] param = { proid };
		List<VScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getScoreByProTeam(int proid) {
		String hql = "from VScore where proid=? and (protype=2 or protype=3) group by sceneid,teacollegeid,collegeid,classid order by scorenumber desc";
		Object[] param = { proid };
		List<VScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public TScore isInScore(int matchid) {
		// TODO Auto-generated method stub
		TScore score = (TScore) bdao.findById(TScore.class, matchid);
		if (score != null && score.getScorenumber().equals("")) {
			return score;
		}
		return null;
	}
}
