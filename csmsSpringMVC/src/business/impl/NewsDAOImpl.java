package business.impl;

import java.util.List;

import model.TNews;
import model.VNews;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.NewsDAO;

@Component("newsdao")
public class NewsDAOImpl implements NewsDAO {
	private iHibBaseDAO bdao;

	public NewsDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public boolean addNews(TNews news) {
		String res = (String) bdao.insert(news);
		if (res != null) {

			return true;
		}
		return false;
	}

	@Override
	public VNews getNewsById(int newid) {
		VNews news = (VNews) bdao.findById(VNews.class, newid);
		return news;
	}

	@Override
	public List<TNews> getAllNews() {
		String hql = "from TNews";
		return bdao.select(hql);
	}

	@Override
	public List<TNews> getNewsByTeaid(String teaid) {
		String hql = "from TNews where teacerid=?";
		Object[] para = { teaid };
		return bdao.select(hql, para);
	}

}
