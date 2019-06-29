package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping(value = "compelition")
public class CompetitionController {
	/**
	 * 获取数据
	 * 
	 * @param wherecondition
	 * @param protype
	 * @param page
	 * @param limit
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "status")
	public void StatusManagement(String wherecondition, Integer protype,
			Integer page, Integer limit, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		ArrangeDAO arrdao = DAOFactory.getArrangDAO();

		Expression exp = new Expression();
		if (protype != null && !protype.equals("0")) {
			exp.andEqu("protype", protype, Integer.class);
		}
		if (wherecondition != null && !wherecondition.equals("")
				&& !wherecondition.equals("0")) {
			exp.andLeftBraLike("proname", wherecondition, String.class);
			exp.orLike("addr", wherecondition, String.class);
			exp.orRightBraLike("arrname", wherecondition, String.class);
		}

		String strwhere = exp.toString();
		List<VArrange> list = arrdao.selectByPage(strwhere, page, limit);
		int count = arrdao.getCount(strwhere);
		LayuiData data = new LayuiData(0, "成功", count, list);
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
	}

	@RequestMapping(value = "updatestate")
	public void updateState(Integer arrid, Integer state,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		ArrangeDAO adao = DAOFactory.getArrangDAO();
		boolean result = adao.updateState(arrid, state);
		LayuiData data = new LayuiData();
		if (result) {
			data.code = LayuiData.SUCCESS;
			data.msg = "修改成功";
		} else {
			data.code = LayuiData.ERRR;
			data.msg = "修改失败";
		}
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
	}
}
