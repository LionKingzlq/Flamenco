package com.flamenco;

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flamenco.service.IFavoriteService;


@Controller
@RequestMapping(value="favorite")
public class FavoriteController {

	private static final Logger logger = LoggerFactory.getLogger(FavoriteController.class);
	
	@Resource
	private IFavoriteService favoriteService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String GetFavoriteList(Locale locale, Model model) {
		return "503";
	}
}
