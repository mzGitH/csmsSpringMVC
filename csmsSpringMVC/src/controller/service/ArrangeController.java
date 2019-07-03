package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TScene;
import model.VArrange;
import model.VMatch;
import model.VScene;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.ArrangeDAO;
import business.dao.MatchDAO;
import business.dao.SceneDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "arrange")
public class ArrangeController {
	@RequestMapping(value = "getarrange")
	public void getArrangeData(Integer sportid, Integer projectid,
			String wherecondition, HttpServletRequest request,
			HttpServletResponse response, int page, int limit, Model model)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		ArrangeDAO adao = DAOFactory.getArrangDAO();
		String strWhere = null;
		LayuiData data = new LayuiData();
		if (sportid == null || sportid == 0) {
			data.code = LayuiData.ERRR;
			data.msg = "请先选择要查询的运动会名称";
		} else {
			Expression exp = new Expression();
			if (sportid != null && !sportid.equals("0") && sportid != 0) {
				exp.andEqu("sportid", sportid, Integer.class);
			}
			if (projectid != null && !projectid.equals("0") && projectid != 0) {
				exp.andEqu("proid", projectid, Integer.class);
			}
			if (wherecondition != null && !wherecondition.equals("")) {
				exp.andLike("arrname", wherecondition, String.class);
				exp.orLike("addr", wherecondition, String.class);
			}
			strWhere = exp.toString();
			System.out.println(strWhere);
			List<VArrange> list = adao.selectByPage(strWhere, page, limit);
			int count = adao.getCount(strWhere);
			data.code = LayuiData.SUCCESS;
			data.count = count;
			data.data = list;
		}
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "getarruser")
	public void getArrUser(Integer proid, Integer arrid,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		MatchDAO mdao = DAOFactory.getMatchDAO();
		List<VMatch> list = mdao.getMatchByProid(proid, arrid);
		LayuiData data = new LayuiData(0, "", 0, list, null);
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "addscene", produces = "application/json; charset=utf-8")
	public void AddScene(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String arrid = request.getParameter("arrid");
		String userinfo = request.getParameter("userid");

		String a[] = userinfo.split(",");
		List<Object> list = new ArrayList<Object>();
		// System.out.println(arrid + ";" + userinfo);
		System.out.println(arrid);
		SceneDAO sdao = DAOFactory.getSceneDAO();
		for (int i = 0; i < a.length; i++) {
			TScene scene = new TScene();
			scene.setArrid(Integer.parseInt(arrid));
			scene.setMatchid(Integer.parseInt(a[i]));
			list.add(scene);
		}
		boolean result = sdao.insertScene(list);
		LayuiData data = new LayuiData();
		if (result) {
			data.code = LayuiData.SUCCESS;
			data.msg = "添加成功";
		} else {
			data.code = LayuiData.ERRR;
			data.msg = "添加失败";
		}
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "searchuser")
	public void SearchUser(Integer arrid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		SceneDAO sdao = DAOFactory.getSceneDAO();
		List<VScene> list = sdao.getSceneUser(arrid);
		LayuiData data = new LayuiData();
		data.code = LayuiData.SUCCESS;
		data.data = list;
		data.count = 0;
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
	}
}
