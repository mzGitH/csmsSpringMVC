package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TConfig;
import model.TProject;
import model.TScore;
import model.VClassScore;
import model.VCollegeScore;
import model.VMajorScore;
import model.VScene;
import model.VScore;
import model.VScoreSignIn;
import model.VUserScore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import util.ResponseJSON;
import business.dao.ConfigDAO;
import business.dao.ProjectDAO;
import business.dao.SceneDAO;
import business.dao.ScoreCollegeDAO;
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
		LayuiData data = new LayuiData(0, "成功", count, list, null);
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
	public void InsertScore(String data, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		System.out.println(data);
		ScoreDAO sdao = DAOFactory.getScoreDAO();
		TScore score = new TScore();
		List<Object> dellist = new ArrayList<Object>();
		List<TScore> scorelist = JSON.parseArray(data, TScore.class);
		for (TScore tScore : scorelist) {
			dellist.add(tScore);
		}

		LayuiData datalayui = new LayuiData();
		if (sdao.insert(dellist)) {
			datalayui.data = LayuiData.SUCCESS;
			datalayui.msg = "录入成绩成功";
		} else {
			datalayui.code = LayuiData.ERRR;
			datalayui.msg = "该运动员已记录过成绩";
		}
		out.write(JSON.toJSONString(datalayui));
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

	@RequestMapping(value = "getprojectscore")
	public void getProjectScore(HttpServletRequest request,
			HttpServletResponse response, Model model, Integer sport,
			Integer project, Integer college, Integer major, Integer classes,
			String username, Integer page, Integer limit) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ScoreCollegeDAO dao = DAOFactory.getScoreCollegeDAO();
		Expression exp = new Expression();
		exp.andEqu("ranks", "1", Integer.class);
		if (sport != null && !sport.equals("0") && !sport.equals("")
				&& sport != 0) {
			exp.andEqu("sportid", sport, Integer.class);
		}
		if (project != null && !project.equals("0") && !project.equals("")
				&& project != 0) {
			exp.andEqu("proid", project, Integer.class);
		}
		String strwhere = exp.toString();
		List<VScore> list = dao.getProjectByPage(strwhere, page, limit);
		int count = dao.getProjectCount(strwhere);
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.count = count;
		laydata.data = list;
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "getcollegescore")
	public void getCollegeScore(HttpServletRequest request,
			HttpServletResponse response, Model model, Integer sport,
			Integer project, Integer college, Integer major, Integer classes,
			String username, Integer page, Integer limit) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		Expression exp = new Expression();
		if (sport != null && !sport.equals("0") && !sport.equals("")
				&& sport != 0) {
			exp.andEqu("sportid", sport, Integer.class);
		}
		if (college != null && !college.equals("0") && !college.equals("")
				&& college != 0) {
			exp.andEqu("collegeid", college, Integer.class);
		}
		String strwhere = exp.toString();
		ScoreCollegeDAO dao = DAOFactory.getScoreCollegeDAO();
		List<VCollegeScore> list = dao.getCollegeByPage(strwhere, page, limit);
		int count = dao.getCollegeCount(strwhere);
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.count = count;
		laydata.data = list;
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "getmajorscore")
	public void getMajorScore(HttpServletRequest request,
			HttpServletResponse response, Model model, Integer sport,
			Integer project, Integer college, Integer major, Integer classes,
			String username, Integer page, Integer limit) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		Expression exp = new Expression();
		exp.andNotEqu("majorid", "0", Integer.class);
		if (sport != null && !sport.equals("0") && !sport.equals("")
				&& sport != 0) {
			exp.andEqu("sportid", sport, Integer.class);
		}
		if (college != null && !college.equals("0") && !college.equals("")
				&& college != 0) {
			exp.andEqu("collegeid", college, Integer.class);
		}
		if (major != null && !major.equals("0") && !major.equals("")
				&& major != 0) {
			exp.andEqu("majorid", major, Integer.class);
		}
		String strwhere = exp.toString();
		ScoreCollegeDAO dao = DAOFactory.getScoreCollegeDAO();
		List<VMajorScore> list = dao.getMajorByPage(strwhere, page, limit);
		int count = dao.getMajorCount(strwhere);
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.count = count;
		laydata.data = list;
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "getclassesscore")
	public void getClassesScore(HttpServletRequest request,
			HttpServletResponse response, Model model, Integer sport,
			Integer project, Integer college, Integer major, Integer classes,
			String username, Integer page, Integer limit) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		Expression exp = new Expression();
		exp.andNotEqu("classid", "0", Integer.class);
		if (sport != null && !sport.equals("0") && !sport.equals("")
				&& sport != 0) {
			exp.andEqu("sportid", sport, Integer.class);
		}
		if (college != null && !college.equals("0") && !college.equals("")
				&& college != 0) {
			exp.andEqu("collegeid", college, Integer.class);
		}
		if (major != null && !major.equals("0") && !major.equals("")
				&& major != 0) {
			exp.andEqu("majorid", major, Integer.class);
		}
		if (classes != null && !classes.equals("0") && !classes.equals("")
				&& classes != 0) {
			exp.andEqu("classid", classes, Integer.class);
		}
		String strwhere = exp.toString();
		ScoreCollegeDAO dao = DAOFactory.getScoreCollegeDAO();
		List<VClassScore> list = dao.getClassesByPage(strwhere, page, limit);
		int count = dao.getClassesCount(strwhere);
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.count = count;
		laydata.data = list;
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "getuserscore")
	public void getUserScore(HttpServletRequest request,
			HttpServletResponse response, Model model, Integer sport,
			Integer project, Integer college, Integer major, Integer classes,
			String username, Integer page, Integer limit) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		Expression exp = new Expression();
		if (sport != null && !sport.equals("0") && !sport.equals("")
				&& sport != 0) {
			exp.andEqu("sportid", sport, Integer.class);
		}
		if (college != null && !college.equals("0") && !college.equals("")
				&& college != 0) {
			exp.andEqu("collegeid", college, Integer.class);
		}
		if (major != null && !major.equals("0") && !major.equals("")
				&& major != 0) {
			exp.andEqu("majorid", major, Integer.class);
		}
		if (classes != null && !classes.equals("0") && !classes.equals("")
				&& classes != 0) {
			exp.andEqu("classid", classes, Integer.class);
		}
		if (username != null && !username.equals("")) {
			exp.andLeftBraLike("username", username, String.class);
			exp.orRightBraLike("userid", username, String.class);
		}
		String strwhere = exp.toString();
		ScoreCollegeDAO dao = DAOFactory.getScoreCollegeDAO();
		List<VUserScore> list = dao.getUserByPage(strwhere, page, limit);
		int count = dao.getUserCount(strwhere);
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.count = count;
		laydata.data = list;
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "getdetail")
	public void getDetail(HttpServletRequest request,
			HttpServletResponse response, Model model, Integer sportid,
			Integer typeid, String type, Integer page, Integer limit)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		Expression exp = new Expression();
		exp.andEqu("sportid", sportid, Integer.class);
		if (type.equals("project")) {
			exp.andEqu("proid", typeid, Integer.class);
		} else if (type.equals("college")) {
			exp.andEqu("collegeid", typeid, Integer.class);
		} else if (type.equals("major")) {
			exp.andEqu("majorid", typeid, Integer.class);
		} else if (type.equals("classes")) {
			exp.andEqu("classid", typeid, Integer.class);
		} else if (type.equals("user")) {
			exp.andEqu("userid", typeid, Integer.class);
		}
		String strwhere = exp.toString();
		ScoreCollegeDAO dao = DAOFactory.getScoreCollegeDAO();
		List<VScore> list = dao.getScoreByPage(strwhere, page, limit);
		int count = dao.getScoreCount(strwhere);
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.count = count;
		laydata.data = list;
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();
	}
}
