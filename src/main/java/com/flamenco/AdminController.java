package com.flamenco;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.flamenco.model.Admin;
import com.flamenco.service.imp.AdminService;

/**
 * Handles requests for the application home page.
 */
@RequestMapping(value="/")
@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Resource
	private AdminService adminService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@RequestMapping(value="/json")
	@ResponseBody
	public String testJson(){
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("username", "abraham");
		
		return map.toString();
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String test(Locale locale, Model model, Admin admin){
		
		System.out.println(admin.getPassWord());
		if (adminService.checkAdmin(admin)) {
			model.addAttribute("list", adminService.getAllAdmin());
			return "home";
		}
		return "404";
	}
	
	
}
