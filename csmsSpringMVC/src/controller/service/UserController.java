package controller.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.EnCriptUtil;
import util.Expression;
import util.LayuiData;
import util.ReadExcelUtils;
import business.dao.UserDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "user")
public class UserController {
	@RequestMapping(value = "getuser")
	public void getUserList(HttpServletRequest request, int page, int limit,
			String opretion, Integer collegeid, Integer majorid,
			Integer classid, HttpServletResponse response, Model model) {

		UserDAO udao = DAOFactory.getUserDAO();
		// ��ѯ����
		Expression exp = new Expression();

		if (collegeid != null && !collegeid.equals("")) {

			exp.andEqu("collegeid", collegeid, Integer.class);
		}
		if (majorid != null && !majorid.equals("")) {

			exp.andEqu("majorid", majorid, Integer.class);
		}
		if (classid != null && !classid.equals("")) {

			exp.andEqu("classid", classid, Integer.class);
		}
		if (opretion != null && !opretion.equals("")) {
			exp.andLeftBraLike("username", opretion, String.class);
			exp.orLike("userid", opretion, String.class);
			exp.orLike("collegename", opretion, String.class);
			exp.orLike("majorname", opretion, String.class);
			exp.orRightBraLike("classname", opretion, String.class);
		}
		String opreation = exp.toString();
		System.out.println(opreation);
		int allcount = udao.getUserAmount(opreation);

		List list = udao.selectUserByPage(opreation, page, limit);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "ִ�гɹ�";
		laydata.count = allcount;
		laydata.data = list;
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

	@RequestMapping(value = "adduser")
	public void addUser(HttpServletRequest request, Integer classid,
			String userid, String pwd, Integer usertype,
			HttpServletResponse response, Model model) {

		UserDAO udao = DAOFactory.getUserDAO();
		String md5Str = EnCriptUtil.fix(userid, pwd);
		String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TUser user = new TUser();
		user.setUserid(userid);
		user.setPwd(endPwd);
		user.setUserregion(classid);
		user.setUsertype(usertype);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (udao.insert(user)) {
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

	@RequestMapping(value = "deluser")
	public void delUser(HttpServletRequest request, String userid,
			HttpServletResponse response, Model model) {

		UserDAO udao = DAOFactory.getUserDAO();

		LayuiData laydata = new LayuiData();

		if (udao.delete(userid)) {
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

	// ��������û�
	@RequestMapping(value = "addUserlist")
	public void addUserByList(HttpServletRequest request, String path,
			HttpServletResponse response, Model model) {
		UserDAO udao = DAOFactory.getUserDAO();

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		// ��Ϣ��ʾ
		LayuiData layui = new LayuiData();
		try {
			String filepath = path;// �ļ�·��
			ReadExcelUtils excelReader = new ReadExcelUtils(filepath);

			// ��ȡExcel�������
			List<Map<Integer, Object>> list = excelReader.readExcelContent();
			List<Object> userlist = new ArrayList<Object>();

			for (Map<Integer, Object> map : list) {
				TUser user = new TUser();
				for (Map.Entry<Integer, Object> m : map.entrySet()) {

					switch (m.getKey()) {
					case 0:
						user.setUserid((String) m.getValue());
						break;
					case 1:
						user.setUsername((String) m.getValue());
						break;
					case 2:
						String md5Str = EnCriptUtil.fix(user.getUserid(),
								(String) m.getValue());
						String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
						user.setPwd(endPwd);
						break;
					case 3:
						user.setUserregion((Integer) m.getValue());
						break;
					case 4:
						Integer usertype = null;
						if (((String) m.getValue()).equals("��ʦ")) {
							usertype = 1;
						} else {
							usertype = 0;
						}
						user.setUserregion(usertype);
						break;
					default:
						break;
					}
				}
				userlist.add(user);

			}
			if (udao.insertList(userlist)) {
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
