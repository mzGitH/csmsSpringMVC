package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TConfig;
import model.TNews;
import model.VAdminUser;
import model.VNews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.NewsDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "news")
public class NewsController {
	@RequestMapping(value = "getallnewlist")
	public void getAllNesList(HttpServletRequest request, int page, int limit,
			String wherecondition, HttpServletResponse response, Model model) {
		NewsDAO ndao = DAOFactory.getNewsDAO();

		// 查询条件
		Expression exp = new Expression();

		if (wherecondition != null && !wherecondition.equals("")) {

			exp.andLeftBraLike("newstitle", wherecondition, String.class);
			exp.orRightBraLike("adminuserid", wherecondition, String.class);
		}

		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = ndao.getNewsAmount(opreation);

		List<VNews> newslist = ndao.getAllNewsNoContent(opreation, page, limit);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "执行成功";
		laydata.count = allcount;
		laydata.data = newslist;
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

	@RequestMapping("addnews")
	public void addNews(HttpServletRequest request, String newstitle,
			String newscontent, HttpServletResponse response, Model model) {

		NewsDAO ndao = DAOFactory.getNewsDAO();
		TNews news = new TNews();
		news.setNewstitle(newstitle);
		news.setNewscontent(newscontent);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		HttpSession session = request.getSession();
		TConfig config = (TConfig) session.getAttribute("config");
		VAdminUser loginuser = (VAdminUser) session.getAttribute("loginuser");
		news.setSportid(config.getSportid());
		news.setAdminuserid(loginuser.getUserid());
		LayuiData laydata = new LayuiData();

		if (ndao.addNews(news)) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("delnews")
	public void delNews(HttpServletRequest request, Integer newid,
			String newscontent, HttpServletResponse response, Model model) {

		NewsDAO ndao = DAOFactory.getNewsDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();

		if (ndao.deleteNewsById(newid)) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
