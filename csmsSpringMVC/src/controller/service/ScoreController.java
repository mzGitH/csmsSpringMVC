package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TConfig;
import model.TProject;
import model.VScene;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import util.ResponseJSON;
import business.dao.ConfigDAO;
import business.dao.ProjectDAO;
import business.dao.SceneDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "score")
public class ScoreController {
	@RequestMapping(value = "getscore")
	public void getScore(Integer project, Integer page, Integer limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		SceneDAO scenedao = DAOFactory.getSceneDAO();

		Expression exp = new Expression();
		if (project != null && !project.equals("0") && project != 0) {
			exp.andEqu("proid", project, Integer.class);
		}
		String strwhere = exp.toString();
		List<VScene> list = scenedao.selectByPageFinish(strwhere, page, limit);
		int count = scenedao.selectByPageFinishCount(strwhere);
		LayuiData data = new LayuiData(0, "成功", count, list);
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "getsport")
	public void getSport(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		ConfigDAO cdao = DAOFactory.getConfigDAO();
		List<TConfig> list = cdao.getTConfig();
		ResponseJSON rj = new ResponseJSON();
		rj.flag = ResponseJSON.FLAG_SUCC;
		rj.msg = "查询成功，共查出" + list.size() + "条数据";
		rj.resultObject = list;
		out.write(JSON.toJSONString(rj));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "getproject")
	public void getProject(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		ProjectDAO pdao = DAOFactory.getProjectDAO();
		List<TProject> list = pdao.select();
		ResponseJSON rj = new ResponseJSON();
		rj.flag = ResponseJSON.FLAG_SUCC;
		rj.msg = "查询成功，共查出" + list.size() + "条数据";
		rj.resultObject = list;
		out.write(JSON.toJSONString(rj));
		out.flush();
		out.close();
	}

}
