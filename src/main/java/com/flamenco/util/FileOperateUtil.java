package com.flamenco.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component(value = "fileOperateUtil")
public class FileOperateUtil {
	public static String FILEDIR = null;

	@Resource(name = "poiExcelUtil")
	private POIExcelUtil poiExcelUtil;

	/**
	 * 
	 * @param request
	 * @throws IOException
	 */
	public String upLoadFile(HttpServletRequest request, boolean flag) throws IOException {
		init(request);

		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = mRequest.getFileMap();
		File file = new File(FILEDIR);
		if (!file.exists()) {
			file.mkdir();
		}
		Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet().iterator();

		String filePath = null;

		while (it.hasNext()) {
			Map.Entry<String, MultipartFile> entry = it.next();
			MultipartFile mFile = entry.getValue();
			if (mFile.getSize() != 0 && !"".equals(mFile.getName())) {
				filePath = initFilePath(mFile.getOriginalFilename());
				System.out.println("filePath:" + filePath);
				write(mFile.getInputStream(), new FileOutputStream(filePath));

			}
		}
		if (flag && filePath != null)
			poiExcelUtil.saveUsersToDataBase(filePath);

		return filePath;
	}

	/**
	 * 
	 * @param request
	 * @throws IOException
	 */
	public boolean downLoadFile(String fileName, HttpServletRequest request, HttpServletResponse response) {

		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

		try {
			init(request);
			
			File file = new File(FILEDIR  + "/" + fileName);
			if(!file.exists())
				file = new File(FILEDIR + new String(fileName.getBytes("iso-8859-1"), "utf-8"));
			if(!file.exists())
			{
				return false;
			}
			InputStream inputStream = new FileInputStream(file);
			OutputStream outputStream = response.getOutputStream();
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				outputStream.write(b, 0, length);
			}
			outputStream.close();
			inputStream.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static String initFilePath(String name) {
		File file = new File(FILEDIR);
		if (!file.exists()) {
			file.mkdir();
		}
		int num = 2;
		String filePath = (file.getPath() + "/" + name).replaceAll(" ", "-");
		File file2 = new File(filePath);
		while (file2.exists()) {
			filePath = (file.getPath() + "/" + num + name).replaceAll(" ", "-");
			file2 = new File(filePath);
			num++;
		}
		return filePath;
	}

	public static void download(String downloadfFileName, ServletOutputStream out) {
		try {
			FileInputStream in = new FileInputStream(
					new File(FILEDIR + "/" + downloadfFileName));
			write(in, out);
		} catch (FileNotFoundException e) {
			try {
				FileInputStream in = new FileInputStream(
						new File(FILEDIR + "/" + new String(downloadfFileName.getBytes("iso-8859-1"), "utf-8")));
				write(in, out);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static void write(InputStream in, OutputStream out) throws IOException {
		try {
			byte[] buffer = new byte[1024];
			int bytesRead = -1;
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
			out.flush();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException ex) {
			}
		}
	}

	public static void init(HttpServletRequest request) {
		if (FILEDIR == null) {
			FILEDIR = request.getSession().getServletContext().getRealPath("/") + "res/upload/";
		}
	}

	public boolean deleteFile(String fileName) {
		File file = new File(FILEDIR + "/" + fileName);
		if(!file.exists())
			try {
				file = new File(FILEDIR + "/" + new String(fileName.getBytes("iso-8859-1"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		if (file.exists()) {
			return file.delete();
		}
		return true;
	}
}