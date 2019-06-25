package business.impl;

import java.util.List;

import model.TForumTitle;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ForumDAO;

@Component("forumdao")
public class ForumDAOImpl implements ForumDAO {
	private iHibBaseDAO bdao;

	public ForumDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public boolean addForum(TForumTitle forum) {
		int row = (Integer) bdao.insert(forum);
		if (row > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteForum(int forumid) {
		TForumTitle forum = (TForumTitle) bdao.findById(TForumTitle.class,
				forumid);
		return bdao.delete(forum);
	}

	@Override
	public boolean updateForum(TForumTitle Forum) {
		return bdao.update(Forum);
	}

	@Override
	public TForumTitle getTForumById(int forumid) {
		TForumTitle forum = (TForumTitle) bdao.findById(TForumTitle.class,
				forumid);
		return forum;
	}

	@Override
	public List<TForumTitle> getForumTitleByPages(int startPage, int pageSize) {
		String hql = "from TForumTitle";
		List<TForumTitle> list = (List<TForumTitle>) bdao.selectByPage(hql,
				startPage, pageSize);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public int getPageCount() {
		String hql = "select count(*) from TForumTitle";
		int count = bdao.selectValue(hql);
		return count;
	}

}
