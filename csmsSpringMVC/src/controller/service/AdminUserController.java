package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TAdminUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.EnCriptUtil;
import util.Expression;
import util.LayuiData;
import business.dao.AdminUserDAO;
import business.impl.AdminUserDaoImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "admin")
public class AdminUserController {

	@RequestMapping(value = "getuser")
	public void getAdminUserList(HttpServletRequest request, int page,
			int limit, String realname, Integer roleid,
			HttpServletResponse response, Model model) {

		AdminUserDAO audao = new AdminUserDaoImpl();
		// ��ѯ����
		Expression exp = new Expression();

		if (realname != null && !realname.equals("")) {

			exp.andLeftBraLike("realname", realname, String.class);
			exp.orRightBraLike("userid", realname, String.class);
		}
		if (roleid != null && roleid != 0) {
			exp.andEqu("roleid", roleid, Integer.class);
		}
		String opreation = exp.toString();
		System.out.println(opreation);
		int allcount = audao.getAdaminUserAmount(opreation);

		List list = audao.getaAdminUserList(opreation, page, limit);

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
		// return "";
	}

	/**
	 * ʵ��һ������Ա�û��ĵ�½
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/adminlogin")
	public void AdminUserLogin(String userid, String pwd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {

		AdminUserDAO audao = new AdminUserDaoImpl();
		LayuiData laydata = new LayuiData();

		TAdminUser user = new TAdminUser();
		user.setUserid((String) userid);
		user.setPwd(pwd);
		TAdminUser loginuser = audao.login(user);
		if (loginuser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginuser", loginuser);
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "��½�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��½ʧ��";
		}

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * ʵ��һ������Ա�û������
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addadminuser")
	public void addAdminUser(String userid, String realname, String mobile,
			String pwd, String roleid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		System.out.println(userid + "," + realname + "," + roleid);

		AdminUserDAO audao = new AdminUserDaoImpl();
		LayuiData laydata = new LayuiData();
		String md5Str = EnCriptUtil.fix(userid, pwd);
		String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TAdminUser user = new TAdminUser();
		user.setUserid(userid);
		user.setRealname(realname);
		user.setMobile(mobile);
		user.setRoleId(Integer.parseInt(roleid));
		user.setPwd(pwd);
		user.setUserstatus(0);

		if (audao.addAdminUser(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "����Ա�û���ӳɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "����Ա�û����ʧ��";
		}

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * ʵ��һ���û����˳�
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/logoutsystem")
	public void logoutsystem(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		LayuiData laydata = new LayuiData();
		HttpSession session = request.getSession();

		session.removeAttribute("loginuser");
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "��½�ɹ�";
		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

}
