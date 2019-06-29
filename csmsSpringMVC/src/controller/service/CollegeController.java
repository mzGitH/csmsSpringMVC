package controller.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TCollege;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import util.ReadExcelUtils;
import business.dao.CollegeDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "college")
public class CollegeController {
	// ��ȡѧԺ�б�
	@RequestMapping(value = "getcollege")
	public void getCollegeList(HttpServletRequest request, Integer page,
			Integer limit, String wherecondition, HttpServletResponse response,
			Model model) {

		// ��ѯ����
		Expression exp = new Expression();

		if (wherecondition != null && !wherecondition.equals("")) {

			exp.andLike("collegename", wherecondition, String.class);
		}

		String opreation = exp.toString();

		CollegeDAO cdao = DAOFactory.getCollegeDAO();
		int allcount = cdao.getCollegeAmount(opreation);
		List<TCollege> collegelist = cdao.selectByPage(opreation, page, limit);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (collegelist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "ִ�гɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "������";

		}

		laydata.count = allcount;
		laydata.data = collegelist;
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

	// ���ѧԺ
	@RequestMapping(value = "addcollege")
	public void addcollege(HttpServletRequest request, String collegename,
			HttpServletResponse response, Model model) {
		CollegeDAO cdao = DAOFactory.getCollegeDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		TCollege college = new TCollege();
		college.setCollegename(collegename);

		LayuiData laydata = new LayuiData();
		if (cdao.insert(college)) {
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

	// ɾ��ѧԺ
	@RequestMapping(value = "delcollege")
	public void delcollege(HttpServletRequest request, Integer collegeid,
			HttpServletResponse response, Model model) {
		CollegeDAO cdao = DAOFactory.getCollegeDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (cdao.delete(collegeid)) {
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

	// �༭ѧԺ
	@RequestMapping(value = "edcollege")
	public void edcollege(HttpServletRequest request, Integer collegeid,
			String collegename, HttpServletResponse response, Model model) {
		CollegeDAO cdao = DAOFactory.getCollegeDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		TCollege college = new TCollege();
		college.setCollegename(collegename);
		college.setCollegeid(collegeid);

		LayuiData laydata = new LayuiData();
		if (cdao.update(college)) {
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

	// �������ѧԺ
	@RequestMapping(value = "addcollegelist")
	public void addcollegeByList(HttpServletRequest request, String path,
			HttpServletResponse response, Model model) {
		CollegeDAO cdao = DAOFactory.getCollegeDAO();

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		// ��Ϣ��ʾ
		LayuiData layui = new LayuiData();
		try {
			String filepath = path;// �ļ�·��
			ReadExcelUtils excelReader = new ReadExcelUtils(filepath);

			// ��ȡExcel�������
			List<Map<Integer, Object>> list = excelReader.readExcelContent();
			List<Object> collegelist = new ArrayList<Object>();

			for (Map<Integer, Object> map : list) {
				TCollege college = new TCollege();
				for (Map.Entry<Integer, Object> m : map.entrySet()) {

					switch (m.getKey()) {
					case 0:
						college.setCollegename((String) m.getValue());
						break;
					default:
						break;
					}
				}
				collegelist.add(college);

			}
			if (cdao.addcollegeByList(collegelist)) {
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
