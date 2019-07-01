package business.impl;

import java.util.List;

import model.TForumContent;
import model.TForumTitle;
import model.TPhoto;
import model.VForum;
import model.VForumTitle;

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
		String procname = "up_deleteForum(?)";
		Object[] para = { forumid };
		int row = (Integer) bdao.executeProduce(procname, para);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "修改文章标题")
	@Override
	public boolean updateForum(TForumTitle Forum) {
		TForumTitle forumsql = (TForumTitle) bdao.findById(TForumTitle.class,
				Forum.getForumid());
		forumsql.setAuthor(Forum.getAuthor());
		forumsql.setTitle(Forum.getTitle());

		return bdao.update(forumsql);
	}

	@Log(isSaveLog = false)
	@Override
	public VForumTitle getVForumById(int forumid) {
		VForumTitle forum = (VForumTitle) bdao.findById(VForumTitle.class,
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

	@Log(isSaveLog = false)
	@Override
	public List<VForum> getForumContent(int forumid){
		String hql = "from VForum where forumid=? order by contentid";
		Object[] param = {forumid};
		List<VForum> list = (List<VForum>) bdao.select(hql,param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Log(isSaveLog = true,operationType = OperType.ADD, operationName = "添加文章内容")
	@Override
	public boolean addContent(TForumContent content) {
		int row = (Integer)bdao.insert(content);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}

	@Log(isSaveLog = true,operationType = OperType.MODIFY, operationName = "编辑文章内容")
	@Override
	public boolean editContent(TForumContent content) {
		TForumContent newContent = (TForumContent)bdao.findById(TForumContent.class, content.getContentid());
		newContent.setPicid(content.getPicid());
		newContent.setTextcontent(content.getTextcontent());
		return bdao.update(newContent);
	}

	@Log(isSaveLog = true,operationType = OperType.DELETE, operationName = "删除文章内容")
	@Override
	public boolean delContent(int contentid) {
		Object[] param = {contentid};
		int row = (Integer)bdao.executeProduce("up_deleteContent(?)", param);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}

}
