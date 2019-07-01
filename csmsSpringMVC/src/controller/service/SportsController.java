package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TConfig;
import model.TProject;
import model.VNews;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import business.dao.ProjectDAO;
import business.dao.SportsDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

import util.Expression;
import util.LayuiData;

@Controller
@RequestMapping(value = "sports")
public class SportsController {

	@RequestMapping(value = "getsportslist")
	public void getProject(HttpServletRequest request, HttpServletResponse response, 
			int page, int limit,String wherecondition, Model model){
		SportsDAO sdao = DAOFactory.getSportsDAO();
		// 查询条件
		Expression exp = new Expression();
		if (wherecondition != null && !wherecondition.equals("")) {
			exp.andLeftBraLike("newstitle", wherecondition, String.class);
			exp.orRightBraLike("adminuserid", wherecondition, String.class);
		}
		String opreation = exp.toString();
		int allcount = sdao.getCount(opreation);
		List<TConfig> sportlist = sdao.selectByPage(opreation, page, limit);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "执行成功";
		laydata.count = allcount;
		laydata.data = sportlist;
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "deletesports")
	public void deleteProject(HttpServletRequest request, HttpServletResponse response, 
			int sportid, Model model){
		SportsDAO sdao = DAOFactory.getSportsDAO();
		LayuiData laydata = new LayuiData();
		if(sdao.delete(sportid)){
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "删除成功";
		}else{
			laydata.code = LayuiData.ERRR;
			laydata.msg = "删除失败";
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "addsports")
	public void addProject(HttpServletRequest request, HttpServletResponse response, Model model,
			String sportname,String starttime,String endtime,String reportstart, String reportend){
		SportsDAO sdao = DAOFactory.getSportsDAO();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		TConfig sport = new TConfig();
		sport.setSportname(sportname);
		sport.setStarttime(starttime);
		sport.setEndtime(endtime);
		sport.setReportstart(reportstart);
		sport.setReportend(reportend);
		LayuiData laydata = new LayuiData();
		if(sdao.insert(sport)){
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "添加成功";
		}else{
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
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "editsports")
	public void editProject(HttpServletRequest request, HttpServletResponse response, Model model,
			int sportid,String sportname,String starttime,String endtime,String reportstart, String reportend){
		SportsDAO sdao = DAOFactory.getSportsDAO();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		TConfig sport = new TConfig();
		sport.setSportid(sportid);
		sport.setSportname(sportname);
		sport.setStarttime(starttime);
		sport.setEndtime(endtime);
		sport.setReportstart(reportstart);
		sport.setReportend(reportend);
		LayuiData laydata = new LayuiData();
		if(sdao.update(sport)){
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "修改成功";
		}else{
			laydata.code = LayuiData.ERRR;
			laydata.msg = "修改失败";
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
