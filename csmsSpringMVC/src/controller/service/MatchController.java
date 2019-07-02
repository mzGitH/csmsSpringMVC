package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TArrange;
import model.TConfig;
import model.VArrange;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.ArrangeDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "match")
public class MatchController {
	@RequestMapping(value = "getmatch")
	public void getMatchList(String wherecondition, Integer proid,
			Integer sportid, Integer page, Integer limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		ArrangeDAO mdao = DAOFactory.getArrangDAO();

		Expression exp = new Expression();
		if (sportid != null && !sportid.equals("")) {
			exp.andEqu("sportid", sportid, Integer.class);
		}
		if (proid != null && !proid.equals("")) {
			exp.andEqu("proid", proid, Integer.class);
		}

		if (wherecondition != null && !wherecondition.equals("")) {
			exp.andLeftBraLike("proname", wherecondition, String.class);
			exp.orLike("arrname", wherecondition, String.class);
			exp.orRightBraLike("addr", wherecondition, String.class);
		}
		String strwhere1 = exp.toString();
		exp.orderByAsc("leveltype");
		String strwhere = exp.toString();
		List<VArrange> list = mdao.selectByPage(strwhere, page, limit);
		int count = mdao.getCount(strwhere1);
		LayuiData data = new LayuiData(0, "", count, list, null);
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "addmatch")
	public void addMatch(String start, String end, String name, Integer proid,
			String addr, Integer leveltype, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		HttpSession session = request.getSession();
		TConfig config = (TConfig) session.getAttribute("config");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		ArrangeDAO mdao = DAOFactory.getArrangDAO();
		TArrange arrange = new TArrange();
		arrange.setArrname(name);
		arrange.setProid(proid);
		arrange.setStarttime(start);
		arrange.setEndtime(end);
		arrange.setAddr(addr);
		arrange.setLeveltype(leveltype);
		arrange.setState(0);

		LayuiData data = new LayuiData();

		if (mdao.insert(arrange)) {
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
}
