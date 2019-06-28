package business.impl;

import java.util.List;

import model.TForumTitle;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ForumDAO;

import common.properties.OperType;

@Component("forumdao")
public class ForumDAOImpl implements ForumDAO {
	private iHibBaseDAO bdao;

	public ForumDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加文章标题")
	@Override
	public boolean addForum(TForumTitle forum) {
		int row = (Integer) bdao.insert(forum);
		if (row > 0) {
			return true;
		}
		return false;
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除文章")
	@Override
	public boolean deleteForum(int forumid) {
		TForumTitle forum = (TForumTitle) bdao.findById(TForumTitle.class,
				forumid);
		return bdao.delete(forum);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "修改文章标题")
	@Override
	public boolean updateForum(TForumTitle Forum) {
		return bdao.update(Forum);
	}

	@Log(isSaveLog = false)
	@Override
	public TForumTitle getTForumById(int forumid) {
		TForumTitle forum = (TForumTitle) bdao.findById(TForumTitle.class,
				forumid);
		return forum;
	}

	@Log(isSaveLog = false)
	@Override
	public List<TForumTitle> getForumTitleByPages(String wherecondition,
			int page, int pageSize) {
		String hql = "from TForumTitle";

		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += " order by createtime desc";

		List<TForumTitle> list = (List<TForumTitle>) bdao.selectByPage(hql,
				page, pageSize);

		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}

	}

	@Log(isSaveLog = false)
	@Override
	public int getPageCount() {
		String hql = "select count(*) from TForumTitle";
		int count = bdao.selectValue(hql);
		return count;
	}

	@Log(isSaveLog = false)
	@Override
	public int getForumAmount(String wherecondition) {
		String hql = "select count(forumid) from TForumTitle";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return bdao.selectValue(hql);
	}

}
