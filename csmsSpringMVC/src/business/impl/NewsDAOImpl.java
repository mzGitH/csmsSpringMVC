package business.impl;

import java.util.ArrayList;
import java.util.List;

import model.TNews;
import model.VNews;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.NewsDAO;

import common.properties.OperType;

@Component("newsdao")
public class NewsDAOImpl implements NewsDAO {
	private iHibBaseDAO bdao;

	public NewsDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加公告")
	@Override
	public boolean addNews(TNews news) {
		String res = bdao.insert(news).toString();
		if (res != null) {

			return true;
		}
		return false;
	}

	@Log(isSaveLog = false)
	@Override
	public VNews getNewsById(int newid) {
		VNews news = (VNews) bdao.findById(VNews.class, newid);
		return news;
	}

	@Override
	@Log(isSaveLog = false)
	public List<VNews> getAllNews(String wherecondition, int page, int pageSize) {
		String hql = "from VNews";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += " order by datetime desc";
		return bdao.selectByPage(hql, page, pageSize);
	}

	@Override
	@Log(isSaveLog = false)
	public List<VNews> getAllNewsNoContent(String wherecondition, int page,
			int pageSize) {
		String hql = "from VNews";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += " order by datetime desc";
		List<VNews> list = bdao.selectByPage(hql, page, pageSize);
		List<VNews> returnlist = new ArrayList<VNews>();
		for (VNews vNews : list) {
			VNews news = new VNews();
			news = vNews;
			news.setNewscontent("");
			returnlist.add(news);
		}

		return returnlist;
	}

	@Log(isSaveLog = false)
	@Override
	public List<VNews> getNewsByTeaid(String teaid) {
		String hql = "from VNews where adminuserid=?";
		Object[] para = { teaid };
		return bdao.select(hql, para);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除公告")
	@Override
	public Boolean deleteNewsById(Integer newid) {
		TNews news = (TNews) bdao.findById(TNews.class, newid);
		return bdao.delete(news);
	}

	@Log(isSaveLog = false)
	@Override
	public int getNewsAmount(String wherecondition) {
		String hql = "select count(newid) from VNews";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return bdao.selectValue(hql);
	}

}
