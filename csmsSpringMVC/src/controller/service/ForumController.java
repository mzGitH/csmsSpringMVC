package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TConfig;
import model.TForumTitle;

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
			laydata.msg = "��ӳɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "���ʧ��";
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("getforumlist")
	public void getForumList(HttpServletRequest request, String wherecondition,
			int page, int limit, HttpServletResponse response, Model model) {
		ForumDAO fdao = DAOFactory.getForumDAO();

		// ��ѯ����
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
			laydata.msg = "��ѯ�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "������";
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
			laydata.msg = "ɾ���ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "ɾ��ʧ��";
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// �༭���±���
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
			laydata.msg = "�޸ĳɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "�޸�ʧ��";
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
