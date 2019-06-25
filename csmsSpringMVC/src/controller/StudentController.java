package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VStudent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ResponseJSON;
import business.dao.UserDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "student")
public class StudentController {
	@RequestMapping(value = "getstudent")
	public void getStudent(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		UserDAO udao = DAOFactory.getUserDAO();

		VStudent student = udao.getStudent("1001");
		// ����json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ResponseJSON rj = new ResponseJSON();
		if (student != null) {
			rj.flag = ResponseJSON.FLAG_SUCC;
			rj.msg = "��ѯ�ɹ�";
			rj.resultObject = student;
		} else {
			rj.flag = ResponseJSON.FLAG_FAIL;
			rj.msg = "��ѯʧ��";
		}
		out.write(JSON.toJSONString(rj));
		out.flush();
		out.close();
	}
}
