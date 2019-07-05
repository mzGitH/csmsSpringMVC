package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TClass;
import model.TCollege;
import model.TConfig;
import model.TProject;
import model.VClass;
import model.VMajor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.LayuiData;
import business.dao.ClassesDAO;
import business.dao.CollegeDAO;
import business.dao.ConfigDAO;
import business.dao.MajorDAO;
import business.dao.ProjectDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

/**
 * ѧԺ��רҵ���꼶�������ȡ����
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "select")
public class SelectController {
	/*
	 * ѧԺ������
	 */
	@RequestMapping("selectcollege")
	public void selectCollege(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		CollegeDAO cdao = DAOFactory.getCollegeDAO();
		List<TCollege> collegelist = cdao.select();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (collegelist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.data = collegelist;
			laydata.msg = "��ѯ�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��ѯʧ��";

		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * רҵ������
	 */
	@RequestMapping("selectmajor")
	public void selectMajor(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		MajorDAO mdao = DAOFactory.getMajorDAO();
		List<VMajor> majorlist = mdao.select();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (majorlist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.data = majorlist;
			laydata.msg = "��ѯ�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��ѯʧ��";

		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �༶������
	 */
	@RequestMapping("selectclasses")
	public void selectClasses(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		ClassesDAO cdao = DAOFactory.getClassesDAO();
		List<TClass> classlist = cdao.select();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (classlist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.data = classlist;
			laydata.msg = "��ѯ�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��ѯʧ��";

		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ����ѧԺid��ȡרҵ������
	 */
	@RequestMapping("selectmajorbycollegeid")
	public void selectMajorByCollegeid(HttpServletRequest request,
			Integer collegeid, HttpServletResponse response, Model model) {
		MajorDAO mdao = DAOFactory.getMajorDAO();
		List<VMajor> majorlist = null;
		if (collegeid == null || collegeid.equals("")) {
			majorlist = mdao.select();
		} else {
			majorlist = mdao.selectByColl(collegeid);
		}

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (majorlist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.data = majorlist;
			laydata.msg = "��ѯ�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��ѯʧ��";

		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ����רҵid��ȡ�༶������
	 */
	@RequestMapping("selectclassesbymajor")
	public void selectClassesByMajor(HttpServletRequest request,
			Integer majorid, HttpServletResponse response, Model model) {
		ClassesDAO cdao = DAOFactory.getClassesDAO();

		List<TClass> classlist = null;
		if (majorid == null || majorid.equals("")) {
			classlist = cdao.select();
		} else {
			classlist = cdao.selectByMajor(majorid);
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (classlist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.data = classlist;
			laydata.msg = "��ѯ�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��ѯʧ��";

		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ����ѧԺid��ȡ�༶������
	 */
	@RequestMapping("selectclassesbycollegeid")
	public void selectClassesByCollegeId(HttpServletRequest request,
			Integer collegeid, HttpServletResponse response, Model model) {
		ClassesDAO cdao = DAOFactory.getClassesDAO();
		List<VClass> vclasslist = null;
		List<TClass> classlist = null;
		if (collegeid == null || collegeid.equals("")) {
			classlist = cdao.select();
		} else {
			vclasslist = cdao.selectByCollegeid(collegeid);
		}

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (classlist != null || vclasslist != null) {
			laydata.code = LayuiData.SUCCESS;
			if (vclasslist != null) {
				laydata.data = vclasslist;
			} else {
				laydata.data = classlist;
			}

			laydata.msg = "��ѯ�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��ѯʧ��";

		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ������Ŀ������
	 */
	@RequestMapping("selectproject")
	public void selectProject(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		ProjectDAO cdao = DAOFactory.getProjectDAO();
		List<TProject> prolist = cdao.select();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (prolist != null) {
			laydata.code = LayuiData.SUCCESS;

			laydata.data = prolist;

			laydata.msg = "��ѯ�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "����Ŀ����";

		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �����˶���id ��ȡ��ǰ�������Ŀ������
	 */
	@RequestMapping("selectprojectbysportid")
	public void selectProjectBySportid(HttpServletRequest request,
			Integer sportid, HttpServletResponse response, Model model) {
		ProjectDAO cdao = DAOFactory.getProjectDAO();
		List<TProject> prolist = cdao.select(sportid);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (prolist != null) {
			laydata.code = LayuiData.SUCCESS;

			laydata.data = prolist;

			laydata.msg = "��ѯ�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "����Ŀ����";

		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �����˶���id ��ȡ��ǰ�������Ŀ������
	 */
	@RequestMapping("selectprojectnow")
	public void selectProjectBySportid(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		ProjectDAO cdao = DAOFactory.getProjectDAO();

		HttpSession session = request.getSession();
		TConfig config = (TConfig) session.getAttribute("config");
		List<TProject> prolist = cdao.selectnow(config);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (prolist != null) {
			laydata.code = LayuiData.SUCCESS;

			laydata.data = prolist;

			laydata.msg = "��ѯ�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "����Ŀ����";

		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �˶��� ������
	 */
	@RequestMapping("selectsport")
	public void selectSport(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		ConfigDAO cdao = DAOFactory.getConfigDAO();
		List<TConfig> prolist = cdao.getAllConfig();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (prolist != null) {
			laydata.code = LayuiData.SUCCESS;

			laydata.data = prolist;

			laydata.msg = "��ѯ�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "����Ŀ����";

		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ�����˶��� ������
	 */
	@RequestMapping("selectsportnow")
	public void selectSportNow(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		ConfigDAO cdao = DAOFactory.getConfigDAO();

		HttpSession session = request.getSession();
		TConfig config = (TConfig)session.getAttribute("config");
		List<TConfig> list = new ArrayList<TConfig>();
		list.add(config);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.data = list;
		laydata.msg = "��ѯ�ɹ�";
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
