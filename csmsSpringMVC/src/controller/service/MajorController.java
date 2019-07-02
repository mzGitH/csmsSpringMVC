package controller.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TMajor;
import model.VMajor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import util.ReadExcelUtils;
import business.dao.CollegeDAO;
import business.dao.MajorDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "major")
public class MajorController {
	// ��ȡרҵ�б�
	@RequestMapping(value = "getmajor")
	public void getMajorList(HttpServletRequest request, Integer page,
			Integer limit, Integer collegeid, String wherecondition,
			HttpServletResponse response, Model model) {
		// ��ѯ����
		Expression exp = new Expression();
		if (collegeid != null) {
			exp.andEqu("collegeid", collegeid, Integer.class);
		}
		if (wherecondition != null && !wherecondition.equals("")) {
			exp.andLike("majorname", wherecondition, String.class);
		}
		String opreation = exp.toString();
		MajorDAO mdao = DAOFactory.getMajorDAO();
		int allcount = mdao.getMajorAmount(opreation);
		List<VMajor> majorlist = mdao.selectByPage(opreation, page, limit);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		if (majorlist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "ִ�гɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "������";
		}
		laydata.count = allcount;
		laydata.data = majorlist;
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

	// ��ȡ����רҵ�б�
	@RequestMapping(value = "getallmajor")
	public void getAllMajor(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		MajorDAO mdao = DAOFactory.getMajorDAO();
		List<VMajor> majorlist = mdao.select();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		if (majorlist != null) {
			laydata.data = majorlist;
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "ִ�гɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "������";
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
		
	// ���רҵ
	@RequestMapping(value = "addmajor")
	public void addcollege(HttpServletRequest request, Integer collegeid,
			String majorname, HttpServletResponse response, Model model) {
		MajorDAO mdao = DAOFactory.getMajorDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		TMajor major = new TMajor();
		major.setCollegeid(collegeid);
		major.setMajorname(majorname);

		LayuiData laydata = new LayuiData();
		if (mdao.insert(major)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "��ӳɹ�";
		} else {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ɾ��רҵ
	@RequestMapping(value = "delmajor")
	public void delMajor(HttpServletRequest request, Integer majorid,
			HttpServletResponse response, Model model) {
		MajorDAO mdao = DAOFactory.getMajorDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (mdao.delete(majorid)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "ɾ���ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "ɾ��ʧ��";

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

	// �༭רҵ
	@RequestMapping(value = "edmajor")
	public void edMajor(HttpServletRequest request, Integer collegeid,
			Integer majorid, String majorname, HttpServletResponse response,
			Model model) {
		MajorDAO mdao = DAOFactory.getMajorDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		TMajor major = new TMajor();
		major.setMajorid(majorid);
		major.setCollegeid(collegeid);
		major.setMajorname(majorname);

		LayuiData laydata = new LayuiData();
		if (mdao.update(major)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "�༭�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "�༭ʧ��";

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

	// �������רҵ
	@RequestMapping(value = "addmajorlist")
	public void addMajorByList(HttpServletRequest request, String path,
			HttpServletResponse response, Model model) {
		MajorDAO mdao = DAOFactory.getMajorDAO();

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		// ��Ϣ��ʾ
		LayuiData layui = new LayuiData();
		try {
			String filepath = path;// �ļ�·��
			ReadExcelUtils excelReader = new ReadExcelUtils(filepath);

			// ��ȡExcel�������
			List<Map<Integer, Object>> list = excelReader.readExcelContent();
			List<Object> majorlist = new ArrayList<Object>();

			for (Map<Integer, Object> map : list) {
				TMajor major = new TMajor();
				for (Map.Entry<Integer, Object> m : map.entrySet()) {

					switch (m.getKey()) {
					case 0:
						CollegeDAO cdao = DAOFactory.getCollegeDAO();
						Integer collegeid = cdao.getCollegeid((String) m
								.getValue());
						major.setCollegeid(collegeid);
						break;
					case 1:
						major.setMajorname((String) m.getValue());
						break;
					default:
						break;
					}
				}
				majorlist.add(major);

			}
			if (mdao.insertList(majorlist)) {
				layui.code = 0;
				layui.msg = "����ɹ�";
			} else {
				layui.code = 1;
				layui.msg = "�������";
			}
			Writer out;
			try {
				out = response.getWriter();
				out.write(JSON.toJSONString(layui));
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("δ�ҵ�ָ��·�����ļ�!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
