package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VMatch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.MatchDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "match")
public class MatchController {
	@RequestMapping(value = "getmatch")
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
		LayuiData data = new LayuiData(0, "", count, list, null);
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
	}
}
