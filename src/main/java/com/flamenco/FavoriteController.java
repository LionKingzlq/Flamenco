package com.flamenco;

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flamenco.model.Favorite;
import com.flamenco.model.User;
import com.flamenco.service.IFavoriteService;

import net.sf.json.JSONObject;


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
	
	@ResponseBody
	@RequestMapping(value="addFavorite", method=RequestMethod.POST, headers={"content-type=application/json", "content-type=application/xml"})
	public JSONObject addFavorite(@RequestBody Favorite favorite) {
		
		Boolean flag = favoriteService.save(favorite);
		JSONObject result = new JSONObject();
		if(flag){
			result.put("code", 200);
		}else {
			result.put("code", 404);
		}
		
		return result;
	}
	
}
