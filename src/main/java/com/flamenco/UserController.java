package com.flamenco;

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flamenco.service.IUserService;

@Controller
@RequestMapping(value="user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Resource
	private IUserService userService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String GetFavoriteList(Locale locale, Model model)  {
		return "503";
	}
}
