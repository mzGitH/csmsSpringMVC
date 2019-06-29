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

		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(

		request.getSession().getServletContext());

		// 检查form中是否有enctype="multipart/form-data"
		// 消息提示
		LayuiData layui = new LayuiData();
		if (multipartResolver.isMultipart(request))

		{

			// 将request变成多部分request

			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

			// 获取multiRequest 中所有的文件名

			Iterator iter = multiRequest.getFileNames();

			while (iter.hasNext())

			{

				// 一次遍历所有文件

				MultipartFile file = multiRequest.getFile(iter.next()
						.toString());

				if (file != null) {

					String path = "M:/JSP/csmsSpringMVC/csmsSpringMVC/WebRoot/upload/file/"
							+ file.getOriginalFilename();

					// 上传

					try {
						file.transferTo(new File(path));
						layui.code = LayuiData.SUCCESS;
						layui.msg = path;
					} catch (Exception e) {
						layui.code = LayuiData.ERRR;
						layui.msg = "文件上传错误，请重试";
					}

				} else {
					layui.code = LayuiData.ERRR;
					layui.msg = "文件上传错误，请重试";
				}
			}

		}

		long endTime = System.currentTimeMillis();

		System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime)
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
