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
import model.VMatch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.ArrangeDAO;
import business.dao.MatchDAO;
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
			Integer sportid,String addr, Integer leveltype, HttpServletRequest request,
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
		arrange.setSportid(sportid);
		
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

	@RequestMapping(value = "searchmatch")
	public void getMatchList(String wherecondition, String userid,
			String roletype, Integer sportid, Integer collegeid,
			Integer classid, Integer majorid, Integer page, Integer limit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		MatchDAO mdao = DAOFactory.getMatchDAO();

		Expression exp = new Expression();
		if (sportid != null && sportid != 0 && !sportid.equals("")) {
			exp.andEqu("sportid", sportid, Integer.class);
		}
		if (userid != null && !userid.equals("")) {
			exp.andEqu("userid", userid, String.class);
		}
		if (collegeid != null && collegeid != 0 && !collegeid.equals("")) {
			exp.andEqu("collegeid", collegeid, Integer.class);
		}
		if (majorid != null && majorid != 0 && !majorid.equals("")) {
			exp.andEqu("majorid", majorid, Integer.class);
		}
		if (classid != null && classid != 0 && !classid.equals("")) {
			exp.andEqu("classid", classid, Integer.class);
		}
		if (wherecondition != null && !wherecondition.equals("")
				&& !wherecondition.equals("0")) {
			exp.andLeftBraLike("proname", wherecondition, String.class);
			exp.orRightBraLike("username", wherecondition, String.class);
		}
		if (roletype != "" && roletype != null) {
			if (roletype.equals("教职工")) {
				exp.andLeftBraAnd("protype", 3, Integer.class);
				exp.orRightBraAnd("protype", 4, Integer.class);
			}
			if (roletype.equals("学生")) {
				exp.andLeftBraAnd("protype", 1, Integer.class);
				exp.orRightBraAnd("protype", 2, Integer.class);
			}
		}
		String strwhere = exp.toString();
		List<VMatch> list = mdao.selectByPage(strwhere, page, limit);
		int count = mdao.getPageCount(strwhere);
		LayuiData data = new LayuiData(0, null, count, list, null);
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
	}
}
