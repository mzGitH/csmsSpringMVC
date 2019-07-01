package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TConfig;
import model.TForumContent;
import model.TForumTitle;
import model.VForum;
import model.VForumTitle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.ForumDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "forum")
public class ForumController {
	@RequestMapping("addforum")
	public void addForum(HttpServletRequest request, String author,
			String title, HttpServletResponse response, Model model) {
		ForumDAO fdao = DAOFactory.getForumDAO();
		TForumTitle forum = new TForumTitle();
		forum.setAuthor(author);
		forum.setTitle(title);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		HttpSession session = request.getSession();
		TConfig config = (TConfig) session.getAttribute("config");
		forum.setSportid(config.getSportid());
		LayuiData laydata = new LayuiData();
		if (fdao.addForum(forum)) {

			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "添加成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "添加失败";
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("getforumlist")
	public void getForumList(HttpServletRequest request, String wherecondition,
			int page, int limit, HttpServletResponse response, Model model) {
		ForumDAO fdao = DAOFactory.getForumDAO();

		// 查询条件
		Expression exp = new Expression();

		if (wherecondition != null && !wherecondition.equals("")) {

			exp.andLeftBraLike("author", wherecondition, String.class);
			exp.orRightBraLike("title", wherecondition, String.class);
		}

		String opreation = exp.toString();
		List<TForumTitle> forumlist = fdao.getForumTitleByPages(opreation,
				page, limit);
		int allcount = fdao.getForumAmount(opreation);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (forumlist != null) {
			laydata.count = allcount;
			laydata.data = forumlist;
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "查询成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "无数据";
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("delforum")
	public void delForumList(HttpServletRequest request, Integer forumid,
			HttpServletResponse response, Model model) {
		ForumDAO fdao = DAOFactory.getForumDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (fdao.deleteForum(forumid)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "删除成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "删除失败";
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 编辑文章标题
	@RequestMapping("edlforum")
	public void edlForumList(HttpServletRequest request, Integer forumid,
			String title, String author, HttpServletResponse response,
			Model model) {
		ForumDAO fdao = DAOFactory.getForumDAO();
		TForumTitle forum = new TForumTitle();
		forum.setForumid(forumid);
		forum.setAuthor(author);
		forum.setTitle(title);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (fdao.updateForum(forum)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "修改成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "修改失败";
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("getforum")
	public String getForumTitle(HttpServletRequest request,int forumid,
			HttpServletResponse response, Model model){
		ForumDAO fdao = DAOFactory.getForumDAO();
		VForumTitle forum = fdao.getVForumById(forumid);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		model.addAttribute("forum", forum);
		return "html/addForumcontent";
	}
	
	@RequestMapping("getcontentlist")
	public void getContentList(HttpServletRequest request,int forumid,
			HttpServletResponse response, Model model) {
		ForumDAO fdao = DAOFactory.getForumDAO();
		List<VForum> forumlist = fdao.getForumContent(forumid);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (forumlist != null) {
			laydata.data = forumlist;
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "查询成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "无数据";
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("addcontent")
	public void addContent(HttpServletRequest request,HttpServletResponse response,
			int forumid,int photoid,String textcontent,Model model) {
		ForumDAO fdao = DAOFactory.getForumDAO();
		TForumContent content = new TForumContent();
		content.setForumid(forumid);
		content.setPicid(photoid);
		content.setTextcontent(textcontent);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		if (fdao.addContent(content)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "添加成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "添加失败";
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("editcontent")
	public void editContent(HttpServletRequest request,HttpServletResponse response,
			int contentid,int photoid,String textcontent,Model model) {
		ForumDAO fdao = DAOFactory.getForumDAO();
		TForumContent content = new TForumContent();
		content.setContentid(contentid);
		content.setPicid(photoid);
		content.setTextcontent(textcontent);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		if (fdao.editContent(content)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "修改成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "修改失败";
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("delcontent")
	public void delContent(HttpServletRequest request,HttpServletResponse response,
			int contentid,Model model) {
		ForumDAO fdao = DAOFactory.getForumDAO();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		if (fdao.delContent(contentid)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "删除成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "删除失败";
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
