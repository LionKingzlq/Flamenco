package com.flamenco;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flamenco.model.User;
import com.flamenco.service.IUserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Resource(name = "userService")
	private IUserService userService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String GetFavoriteList(Locale locale, Model model) {
		return "503";
	}

	@RequestMapping(value = "usersInPage", method = RequestMethod.GET)
	public JSONObject GetFavoriteList(int pageNum) {
		System.out.println("pageNUm:" + pageNum);
		List<User> users = userService.getAll();

		JSONArray userArray = JSONArray.fromObject(users);
		JSONObject data = new JSONObject();
		data.put("array", userArray);
		return data;

	}
}
