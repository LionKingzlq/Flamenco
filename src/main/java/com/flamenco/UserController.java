package com.flamenco;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flamenco.model.User;
import com.flamenco.service.IUserService;
import com.flamenco.util.FileOperateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "userService")
	private IUserService userService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String GetFavoriteList(Locale locale, Model model) {
		return "503";
	}

	@ResponseBody
	@RequestMapping(value = "usersInPage", method = RequestMethod.GET)
	public JSONObject GetUserList(int pageNum) {
		System.out.println("pageNUm:" + pageNum);
		List<User> users = userService.getAll();
		System.out.println(users);
		JSONArray userArray = JSONArray.fromObject(users);
		JSONObject data = new JSONObject();
		data.put("array", userArray);
		return data;
	}

	@Resource(name = "fileOperateUtil")
	private FileOperateUtil fileOperateUtil;

	@RequestMapping(value = "memberAddList", method = RequestMethod.POST)
	public String memberAddList(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			fileOperateUtil.upLoadFile(request, true);
			System.out.println("abraham memberAddlist");
		} catch (Exception e) {
			logger.debug("memberAddList:" + e.getMessage());
		}
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "deleteUser", method = RequestMethod.GET)
	public JSONObject deleteUser(int userId) {
		User user = new User();
		user.setId(userId);
		boolean result = userService.delete(user);
		JSONObject data = new JSONObject();
		data.put("result", result);
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST, headers={"content-type=application/json", "content-type=application/xml"})
	public JSONObject login(@RequestBody User user) {
		User userInfo = userService.login(user);
		JSONObject result = new JSONObject();
		if(userInfo != null){
			result.put("code", 200);
			result.put("userData", JSONObject.fromObject(user));
		}else {
			result.put("code", 404);			
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.POST, headers={"content-type=application/json", "content-type=application/xml"})
	public JSONObject modify(@RequestBody User user) {
		Boolean falg = userService.modify(user);
		JSONObject result = new JSONObject();
		if(falg){
			result.put("code", 200);
		}else {
			result.put("code", 404);			
		}
		return result;
	}
	
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public String getResource(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String fileName = request.getParameter("fileName");
		fileOperateUtil.downLoadFile(fileName, request, response);
		return null;
	}
}
