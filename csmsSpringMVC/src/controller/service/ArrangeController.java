package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VArrange;
import model.VMatch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.LayuiData;
import business.dao.ArrangeDAO;
import business.dao.MatchDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "arrange")
public class ArrangeController {
	@RequestMapping(value = "getarrange")
	public void getArrangeData(HttpServletRequest request,
			HttpServletResponse response, int page, int limit, Model model)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		ArrangeDAO adao = DAOFactory.getArrangDAO();
		String strWhere = null;
		List<VArrange> list = adao.selectByPage(strWhere, page, limit);
		int count = adao.getCount(strWhere);
		LayuiData data = new LayuiData(LayuiData.SUCCESS, "", count, list, null);
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "getarruser")
	public void getArrUser(Integer proid, Integer sportid,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		MatchDAO mdao = DAOFactory.getMatchDAO();
		List<VMatch> list = mdao.getMatchByProid(proid);
		LayuiData data = new LayuiData(0, "", 0, list, null);
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
	}
}
