package business.impl;

import java.util.ArrayList;
import java.util.List;

import model.TMatch;
import model.VMatch;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.MatchDAO;

public class MatchDaoImpl implements MatchDAO {
	private iHibBaseDAO bdao;

	public void setBdao(iHibBaseDAOImpl bdao) {
		this.bdao = bdao;
	}

	// public MatchDaoImpl() {
	// bdao = new iHibBaseDAOImpl();
	// }

	@Override
	public boolean insert(TMatch match) {
		String proName = "up_AddMatch(?,?)";
		Object[] para = { match.getProid(), match.getUserid() };
		int result = (Integer) bdao.executeProduce("up_AddMatch(?,?)", para);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isSignUp(String userid, int proid) {
		String proName = "up_AddMatch(?,?)";
		Object[] para = { proid, userid };
		int row = (Integer) bdao.executeProduce(proName, para);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	// public static void main(String[] args) {
	// MatchDAO mdao = new MatchDaoImpl();
	// boolean result = mdao.isSignUp("10010", 1);
	// System.out.print(result);
	// }

	@Override
	public List<VMatch> selectByUser(String userid) {
		String hql = "from VMatch where userid=?";
		Object[] para = { userid };
		return bdao.select(hql, para);
	}

	// public static void main(String[] args) {
	// MatchDaoImpl impl = new MatchDaoImpl();
	// List<VMatch> list = impl.selectByUser("94005");
	// for (VMatch match : list) {
	// System.out.println(match.getProname() + match.getTeausername());
	// }
	// }

	@Override
	public List<VMatch> select() {
		String hql = "from VMatch";
		return bdao.select(hql);
	}

	@Override
	public List<VMatch> selectByPage(int startPage, int pageSize) {
		String hql = "from VMatch";
		List<VMatch> list = (List<VMatch>) bdao.selectByPage(hql, startPage,
				pageSize);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public int getPageCount() {
		String hql = "select count(*) from TMatch";
		int count = bdao.selectValue(hql);
		return count;
	}

	@Override
	public List<VMatch> selectAll() {
		String hql = "select proname,protype,currentnum,totallimit from VMatch  group by proname,currentnum,totallimit,protype order by proname";
		List<VMatch> matchlist = new ArrayList<VMatch>();
		List list = bdao.select(hql);
		for (Object obj : list) {
			Object[] objs = (Object[]) obj;
			VMatch match = new VMatch();
			match.setProname((String) objs[0]);
			match.setProtype((Integer) objs[1]);
			match.setCurrentnum((Integer) objs[2]);
			match.setTotallimit((Integer) objs[3]);
			matchlist.add(match);
		}
		return matchlist;
	}

	@Override
	public int countUser(int proid, String userid) {
		String hql = "select count(matchid) from TMatch where proid=? and userid=?";
		Object[] para = { proid, userid };
		int count = bdao.selectValue(hql, para);
		return count;
	}
}
