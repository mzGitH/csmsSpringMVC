package controller;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import util.LayuiData;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "file")
public class FileUploadController {
	@RequestMapping("springUpload")
	public void springUpload(HttpServletRequest request,
			HttpServletResponse response, Model model)
			throws IllegalStateException, IOException

	{
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		long startTime = System.currentTimeMillis();

		// ����ǰ�����ĳ�ʼ���� CommonsMutipartResolver ���ಿ�ֽ�������

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(

		request.getSession().getServletContext());

		// ���form���Ƿ���enctype="multipart/form-data"
		// ��Ϣ��ʾ
		LayuiData layui = new LayuiData();
		if (multipartResolver.isMultipart(request))

		{

			// ��request��ɶಿ��request

			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

			// ��ȡmultiRequest �����е��ļ���

			Iterator iter = multiRequest.getFileNames();

			while (iter.hasNext())

			{

				// һ�α��������ļ�

				MultipartFile file = multiRequest.getFile(iter.next()
						.toString());

				if (file != null) {

					String path = "M:/JSP/csmsSpringMVC/csmsSpringMVC/WebRoot/upload/file/"
							+ file.getOriginalFilename();

					// �ϴ�

					try {
						file.transferTo(new File(path));
						layui.code = LayuiData.SUCCESS;
						layui.msg = path;
					} catch (Exception e) {
						layui.code = LayuiData.ERRR;
						layui.msg = "�ļ��ϴ�����������";
					}

				} else {
					layui.code = LayuiData.ERRR;
					layui.msg = "�ļ��ϴ�����������";
				}
			}

		}

		long endTime = System.currentTimeMillis();

		System.out.println("������������ʱ�䣺" + String.valueOf(endTime - startTime)
				+ "ms");

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
	}
}
