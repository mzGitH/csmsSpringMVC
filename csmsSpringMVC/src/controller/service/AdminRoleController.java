package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.LayuiData;
import business.dao.AdminRoleDAO;
import business.impl.AdminRoleDaoImpl;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "adminrole")
public class AdminRoleController {
	@RequestMapping(value = "getrole")
	public void getAdminUserList(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		AdminRoleDAO ardao = new AdminRoleDaoImpl();
		List list = ardao.getaAdminUserList();

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (list != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "查询成功，共查出" + list.size() + "条记录";
			laydata.data = list;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "查询失败";
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
		// return "";
	}
}
