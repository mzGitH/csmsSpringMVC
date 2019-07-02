package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TConfig;
import model.TProject;
import model.TSportProject;
import model.VSportProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import business.dao.SportsDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

import util.Expression;
import util.LayuiData;

@Controller
@RequestMapping(value = "sports")
public class SportsController {

	@RequestMapping(value = "getsportslist")
	public void getSportList(HttpServletRequest request, HttpServletResponse response, 
			int page, int limit, Model model){
		SportsDAO sdao = DAOFactory.getSportsDAO();
		// ��ѯ����
		Expression exp = new Expression();
		exp.orderByDesc("sportid");
		String opreation = exp.toString();
		int allcount = sdao.getCount("");
		List<TConfig> sportlist = sdao.selectByPage(opreation, page, limit);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "ִ�гɹ�";
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
	
	@RequestMapping(value = "addsports")
	public void addSport(HttpServletRequest request, HttpServletResponse response, Model model,
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
		int row = sdao.insert(sport);
		if(row>0){
			laydata.code = LayuiData.SUCCESS;
			laydata.result = ""+row;
			laydata.msg = "��ӳɹ�";
		}else{
			laydata.code = LayuiData.ERRR;
			laydata.msg = "���ʧ��";
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
	public void editSport(HttpServletRequest request, HttpServletResponse response, Model model,
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
			laydata.msg = "�޸ĳɹ�";
		}else{
			laydata.code = LayuiData.ERRR;
			laydata.msg = "�޸�ʧ��";
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
	
	@RequestMapping(value = "deletesports")
	public void deleteSport(HttpServletRequest request, HttpServletResponse response, 
			int sportid, Model model){
		SportsDAO sdao = DAOFactory.getSportsDAO();
		LayuiData laydata = new LayuiData();
		if(sdao.delete(sportid)){
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "ɾ���ɹ�";
		}else{
			laydata.code = LayuiData.ERRR;
			laydata.msg = "ɾ��ʧ��";
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
	
	@RequestMapping(value = "getTSP")
	public void getTSP(HttpServletRequest request, HttpServletResponse response, 
			int page, int limit, Model model){
		SportsDAO sdao = DAOFactory.getSportsDAO();
		String sportid = request.getParameter("sportid");
		String proid = request.getParameter("proid");
		// ��ѯ����
		Expression exp = new Expression();
		if (sportid != null && !sportid.equals("") && !sportid.equals("0")) {
			exp.andEqu("sportid", sportid, Integer.class);
		}
		if (proid != null && !proid.equals("") && !proid.equals("0")) {
			exp.andEqu("proid", proid, Integer.class);
		}
		String notorder = exp.toString();
		exp.orderByDesc("id");
		String opreation = exp.toString();
		int allcount = sdao.getTSPCount(notorder);
		List<VSportProject> sportlist = sdao.selectTSP(opreation, page, limit);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "ִ�гɹ�";
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
	
	@RequestMapping(value = "getsport")
	public void getSport(HttpServletRequest request, HttpServletResponse response, Model model){
		SportsDAO sdao = DAOFactory.getSportsDAO();
		List<TConfig> sportlist = sdao.select();
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "ִ�гɹ�";
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
	
	@RequestMapping(value = "getnotexitsTSP")
	public void getNotExistsSport(HttpServletRequest request, HttpServletResponse response, Model model){
		SportsDAO sdao = DAOFactory.getSportsDAO();
		List<TConfig> sportlist = sdao.getNotExistsConfig();
		LayuiData laydata = new LayuiData();
		if(sportlist!=null&&sportlist.size()>0){
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "ִ�гɹ�";
			laydata.data = sportlist;
		}else{
			laydata.code = LayuiData.ERRR;
			laydata.msg = "����Ҫ��������";
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
	
	@RequestMapping(value = "addTSP")
	public void addSportProject(HttpServletRequest request, HttpServletResponse response, Model model,
			int sportid,String prolist){
		SportsDAO sdao = DAOFactory.getSportsDAO();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		List<Integer> prolists = JSON.parseArray(prolist, Integer.class);
		List<TSportProject> sportprolist = new ArrayList<TSportProject>();
		for(int proid:prolists){
			TSportProject tsp = new TSportProject();
			tsp.setSportid(sportid);
			tsp.setProid(proid);
			sportprolist.add(tsp);
		}
		LayuiData laydata = new LayuiData();
		if(sdao.insertTSP(sportprolist)){
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "��ӳɹ�";
		}else{
			laydata.code = LayuiData.ERRR;
			laydata.msg = "���ʧ��";
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
	
	@RequestMapping(value = "deleteTSP")
	public void deleteTSP(HttpServletRequest request, HttpServletResponse response, 
			int id, Model model){
		SportsDAO sdao = DAOFactory.getSportsDAO();
		LayuiData laydata = new LayuiData();
		if(sdao.deleteTSP(id)){
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "ɾ���ɹ�";
		}else{
			laydata.code = LayuiData.ERRR;
			laydata.msg = "ɾ��ʧ��";
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
	

	@RequestMapping(value = "getproject")
	public void getNotOrExistsProject(HttpServletRequest request, HttpServletResponse response, Model model,
			int sportid){
		SportsDAO sdao = DAOFactory.getSportsDAO();
		List<TProject> notProject = sdao.getNotExistsProject(sportid);
		List<TProject> existsProject = sdao.getExistsProject(sportid);
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "ִ�гɹ�";
		laydata.data = notProject;
		laydata.data1 = existsProject;
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
