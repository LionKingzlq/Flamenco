package com.flamenco;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flamenco.model.Admin;
import com.flamenco.model.Advice;
import com.flamenco.model.Set;
import com.flamenco.model.User;
import com.flamenco.service.IAdminService;
import com.flamenco.service.IFavoriteService;
import com.flamenco.service.IResGroupService;
import com.flamenco.service.ISetService;
import com.flamenco.service.ITeachService;
import com.flamenco.service.IUserService;
import com.flamenco.util.FileOperateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Resource(name="adminService")
	private IAdminService adminService;

	@Resource(name="resGroupService")
	private IResGroupService resGroupService;
	
	@Resource
	private IUserService userService;
	
	@Resource
	private IFavoriteService favoriteService;
	
	@Resource
	private ITeachService teachService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		FileOperateUtil.init(request);
		return "login";
	}
	
	@RequestMapping(value="index")
	public String Index(){
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public JSONObject check(Model model, Admin admin, HttpSession session){
		JSONObject result = new JSONObject();
		int adminId = adminService.checkAdmin(admin);
		result.put("result", adminId);
		session.setAttribute("adminId", adminId);
		return result;
	}
	
	@RequestMapping(value="json")
	@ResponseBody
	public Map testJson(){
		
		User user = new User();
		user.setName("admin");
		user.setPassword("password");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "admin");
		map.put("id", 1);
		map.put("flag", true);
		return map;
	}
	
	@Resource(name="setService")
	private ISetService settingService;
	
	@RequestMapping("/redis") 
	public void createData(HttpServletResponse response) { 	    
	    settingService.add(new Set("1","name","password"));
	    System.out.println(settingService.get("1").getName());
	}
	
	@ResponseBody
	@RequestMapping(value = "advice", method = RequestMethod.POST, headers={"content-type=application/json", "content-type=application/xml"})
	public JSONObject getAdvice(@RequestBody Advice advice) {
		Boolean falg = adminService.addAdivce(advice);
		JSONObject result = new JSONObject();
		if(falg){
			result.put("code", 200);
		}else {
			result.put("code", 404);			
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "adminsInPage", method = RequestMethod.GET)
	public JSONObject getAdminList(int pageNum) {
		List<Admin> admins = adminService.getAll();
		JSONArray userArray = JSONArray.fromObject(admins);
		JSONObject data = new JSONObject();
		data.put("array", userArray);
		return data;
	}
}
