package business.impl;

import java.util.List;

import model.TScene;
import model.VScene;
import model.VScoreSignIn;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.SceneDAO;

@Component("scenedao")
public class SceneDaoImpl implements SceneDAO {
	private iHibBaseDAO bdao;

	public SceneDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public boolean insert(TScene scene) {
		String res = (String) bdao.insert(scene);
		if (res != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<VScene> seleScenes() {
		String hql = "from VScene";
		return (List<VScene>) bdao.select(hql);
	}

	@Override
	public List<VScene> seleScenes(String userid) {
		String hql = "from VScene where userid=?";
		Object[] param = { userid };
		return (List<VScene>) bdao.select(hql, param);
	}

	@Override
	public List<VScene> seleOtherScenes(String userid) {
		String hql = "from VScene where userid=?";
		Object[] param = { userid };
		return (List<VScene>) bdao.select(hql, param);
	}

	@Override
	public List<VScoreSignIn> selectByPageFinish(String wherecondition,
			int page, int limit) {
		// TODO Auto-generated method stub
		String hql = "from VScoreSignIn";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		List<VScoreSignIn> list = bdao.selectByPage(hql, page, limit);
		return list;
	}

	@Override
	public int selectByPageFinishCount(String wherecondition) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from VScoreSignIn";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		int count = bdao.selectValue(hql);
		return count;
	}

}
