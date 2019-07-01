package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TProject;
import model.VNews;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import business.dao.ProjectDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

import util.Expression;
import util.LayuiData;

@Controller
@RequestMapping(value = "project")
public class ProjectController {

	@RequestMapping(value = "getprojectlist")
	public void getProject(HttpServletRequest request, HttpServletResponse response, 
			int page, int limit, Model model){
		ProjectDAO pdao = DAOFactory.getProjectDAO();
		String protype = request.getParameter("protype");
		String proname = request.getParameter("proname");
		// 查询条件
		Expression exp = new Expression();
		if (protype != null && !protype.equals("")) {
			exp.andEqu("protype", protype, Integer.class);
		}
		if (proname != null && !proname.equals("")) {
			exp.andLike("proname", proname, String.class);
		}
		String opreation = exp.toString();
		int allcount = pdao.getProCount(opreation);
		List<TProject> prolist = pdao.selectByPage(opreation, page, limit);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "执行成功";
		laydata.count = allcount;
		laydata.data = prolist;
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
	
	@RequestMapping(value = "deleteproject")
	public void deleteProject(HttpServletRequest request, HttpServletResponse response, 
			int proid, Model model){
		ProjectDAO pdao = DAOFactory.getProjectDAO();
		LayuiData laydata = new LayuiData();
		if(pdao.delete(proid)){
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
	
	@RequestMapping(value = "addproject")
	public void addProject(HttpServletRequest request, HttpServletResponse response, 
			String proname,int scenelimit,int protype,int colllimit, int prolimit, Model model){
		ProjectDAO pdao = DAOFactory.getProjectDAO();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		TProject project = new TProject();
		project.setCollegelimit(colllimit);
		project.setProname(proname);
		project.setProtype(protype);
		project.setTotallimit(prolimit);
		project.setScenelimit(scenelimit);
		LayuiData laydata = new LayuiData();
		if(pdao.insert(project)){
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
	
	@RequestMapping(value = "editproject")
	public void editProject(HttpServletRequest request, HttpServletResponse response, 
			int proid,int scenelimit,String proname,int protype,int colllimit, int prolimit, Model model){
		ProjectDAO pdao = DAOFactory.getProjectDAO();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		TProject project = new TProject();
		project.setProid(proid);
		project.setCollegelimit(colllimit);
		project.setProname(proname);
		project.setProtype(protype);
		project.setTotallimit(prolimit);
		project.setScenelimit(scenelimit);
		LayuiData laydata = new LayuiData();
		if(pdao.update(project)){
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
	
	@RequestMapping(value = "getproject")
	public void getProject(HttpServletRequest request, HttpServletResponse response, Model model){
		ProjectDAO pdao = DAOFactory.getProjectDAO();
		LayuiData laydata = new LayuiData();
		Writer out;
		List<TProject> projectlist = pdao.select();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "执行成功";
		laydata.data = projectlist;
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
