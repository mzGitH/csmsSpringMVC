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
import business.basic.iHibBaseDAOImpl;
import business.impl.UserDaoImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "student")
public class StudentController {
	@RequestMapping(value = "getstudent")
	public void getStudent(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		UserDaoImpl udao = new UserDaoImpl();
		udao.setBdao(new iHibBaseDAOImpl());

		VStudent student = udao.getStudent("1001");
		// 传回json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ResponseJSON rj = new ResponseJSON();
		if (student != null) {
			rj.flag = ResponseJSON.FLAG_SUCC;
			rj.msg = "查询成功";
			rj.resultObject = student;
		} else {
			rj.flag = ResponseJSON.FLAG_FAIL;
			rj.msg = "查询失败";
		}
		out.write(JSON.toJSONString(rj));
		out.flush();
		out.close();
	}
}
