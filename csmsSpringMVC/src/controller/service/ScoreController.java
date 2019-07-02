package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TConfig;
import model.TProject;
import model.TScore;
import model.VScene;
import model.VScoreSignIn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import util.ResponseJSON;
import business.dao.ConfigDAO;
import business.dao.ProjectDAO;
import business.dao.SceneDAO;
import business.dao.ScoreDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "score")
public class ScoreController {
	@RequestMapping(value = "getscore")
	public void getScore(Integer project, Integer sport, Integer page,
			Integer limit, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		SceneDAO scenedao = DAOFactory.getSceneDAO();

		Expression exp = new Expression();
		exp.andEqu("state", 2, Integer.class);
		if (sport != null && !sport.equals("0") && sport != 0) {
			exp.andEqu("sportid", sport, Integer.class);
		}
		if (project != null && !project.equals("0") && project != 0) {
			exp.andEqu("proid", project, Integer.class);
		}
		String strwhere = exp.toString();
		List<VScoreSignIn> list = null;
		int count = 0;
		list = scenedao.selectByPageFinish(strwhere, page, limit);
		count = scenedao.selectByPageFinishCount(strwhere);
		LayuiData data = new LayuiData(0, "成功", count, list,null);
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
		List<TConfig> list = cdao.getAllConfig();
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

	@RequestMapping(value = "addscore")
	public void InsertScore(Double scorenum, Integer matchid,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		ScoreDAO sdao = DAOFactory.getScoreDAO();
		TScore score = new TScore();
		score.setMatchid(matchid);
		score.setScorenumber(scorenum);
		LayuiData data = new LayuiData();
		TScore isScore = sdao.isInScore(matchid);
		if (isScore != null) {
			boolean result = sdao.insert(score);
			if (result) {
				data.code = LayuiData.SUCCESS;
				data.msg = "录入成绩成功";
			} else {
				data.code = LayuiData.ERRR;
				data.msg = "录入成绩失败";
			}
		} else {
			data.code = LayuiData.ERRR;
			data.msg = "该运动员已记录过成绩";
		}
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "getuser")
	public void GetUser(Integer arrid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		SceneDAO sdao = DAOFactory.getSceneDAO();
		List<VScene> list = sdao.getSceneUser(arrid);
		LayuiData data = new LayuiData();
		if (list != null) {
			data.code = LayuiData.SUCCESS;
			data.msg = "查询成功，共查出" + list.size() + "条数据";
			data.data = list;
		} else {
			data.code = LayuiData.ERRR;
			data.msg = "该场次无运动员";
		}
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
	}
}
