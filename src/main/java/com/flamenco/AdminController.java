package com.flamenco;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.flamenco.dao.UserInfoDao;
import com.flamenco.model.Admin;
import com.flamenco.model.User;
import com.flamenco.service.IAdminService;
import com.flamenco.service.imp.ResGroupService;
import com.flamenco.service.imp.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Resource(name="adminService")
	private IAdminService adminService;

	@Resource(name="resGroupService")
	private ResGroupService resGroupService;
	
	@Resource
	private UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
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
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String test(Locale locale, Model model, Admin admin){
		
		if (adminService.checkAdmin(admin)) {
			
			model.addAttribute("adminList", adminService.getAll());
			model.addAttribute("resGroupList",resGroupService.getAll());
			model.addAttribute("userList", userService.getAll());
			return "home";
		}
		return "404";
	}
//	@RequestMapping("/createData.do") 
//	public void createData(HttpServletResponse response) { 
//	   
//	    JSONObject json = new JSONObject(); 
//	    if (createDataServiceImpl.makeData() == false) { 
//	        json.element("isSuccess", true); 
//	    } else { 
//	        json.element("isSuccess", false); 
//	        json.element("errorInfo", "生成数据失败,请联系客服人员！"); 
//	    } 
//	       
//	    writeJSONStringToResponse(response, json.toString()); 
//	}
}
