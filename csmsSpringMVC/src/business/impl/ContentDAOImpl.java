package business.impl;

import java.util.List;

import model.TForumContent;
import model.VForum;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ContentDAO;

public class ContentDAOImpl implements ContentDAO {
	private iHibBaseDAO bdao;

	public void setBdao(iHibBaseDAOImpl bdao) {
		this.bdao = bdao;
	}

	@Override
	public boolean addContent(TForumContent fcontent) {
		int row = (Integer) bdao.insert(fcontent);
		if (row > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteContent(int id) {
		TForumContent content = (TForumContent) bdao.findById(
				TForumContent.class, id);
		return bdao.delete(content);
	}

	@Override
	public boolean updateForumContent(TForumContent fcontent) {
		return bdao.update(fcontent);
	}

	@Override
	public TForumContent getTContnentById(int id) {
		TForumContent content = (TForumContent) bdao.findById(
				TForumContent.class, id);
		return content;
	}

	@Override
	public List<VForum> getContentByForumid(int forumid) {
		String hql = "from VForum where forumid=?";
		Object[] para = { forumid };
		List<VForum> list = (List<VForum>) bdao.select(hql, para);
		return list;
	}

}
