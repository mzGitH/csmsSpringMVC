package controller;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TPhoto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import util.LayuiData;
import business.dao.PhotoDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "file")
public class FileUploadController {
	@RequestMapping("springUpload")
	public void springUpload(HttpServletRequest request,
			HttpServletResponse response, Model model)
			throws IllegalStateException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		long startTime = System.currentTimeMillis();
		// ����ǰ�����ĳ�ʼ���� CommonsMutipartResolver ���ಿ�ֽ�������
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// ���form���Ƿ���enctype="multipart/form-data"
		// ��Ϣ��ʾ
		LayuiData layui = new LayuiData();
		if (multipartResolver.isMultipart(request)) {
			// ��request��ɶಿ��request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// ��ȡmultiRequest �����е��ļ���
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// һ�α��������ļ�
				MultipartFile file = multiRequest.getFile(iter.next()
						.toString());
				if (file != null) {
					/*
					 * String path =
					 * "M:/JSP/csmsSpringMVC/csmsSpringMVC/WebRoot/upload/file/"
					 * + file.getOriginalFilename();
					 */
					String filename = file.getOriginalFilename();
					// TODO ����·��
					String path = "M:/JSP/csmsSpringMVC/csmsSpringMVC/WebRoot/upload/image/"
							+ filename;
					// �ϴ�
					try {
						file.transferTo(new File(path));
						// ͼƬ��Դ�ϴ��ɹ��󣬽���T_Photo���д���һ��ͼƬ��Դ�Ĺ����¼
						PhotoDAO pdao = DAOFactory.getPhotoDAO();
						TPhoto photo = new TPhoto();
						photo.setPicpath("../upload/image/" + filename);
						int photoid = pdao.addPhoto(photo);
						layui.code = LayuiData.SUCCESS;
						layui.count = photoid;
						layui.msg = "�ϴ��ɹ�";
					} catch (Exception e) {
						layui.code = LayuiData.ERRR;
						layui.msg = "�ļ��ϴ�����������";
						e.printStackTrace();
					}
				} else {
					layui.code = LayuiData.ERRR;
					layui.msg = "�ļ��ϴ�����������";
				}
			}
		}
		// long endTime = System.currentTimeMillis();
		// System.out.println("������������ʱ�䣺" + String.valueOf(endTime - startTime)+
		// "ms");
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(layui));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("springimport")
	public void springImport(HttpServletRequest request,
			HttpServletResponse response, Model model)
			throws IllegalStateException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		long startTime = System.currentTimeMillis();

		// ����ǰ�����ĳ�ʼ���� CommonsMutipartResolver ���ಿ�ֽ�������
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(

		request.getSession().getServletContext());
		// ���form���Ƿ���enctype="multipart/form-data"
		// ��Ϣ��ʾ
		LayuiData layui = new LayuiData();
		if (multipartResolver.isMultipart(request)) {
			// ��request��ɶಿ��request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// ��ȡmultiRequest �����е��ļ���
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
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
