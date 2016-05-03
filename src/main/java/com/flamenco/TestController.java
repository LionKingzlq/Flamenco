package com.flamenco;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flamenco.model.Admin;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="test")
public class TestController {

	@ResponseBody
	@RequestMapping(value="", method=RequestMethod.GET)
	public JSONObject GetFavoriteList(Locale locale, Model model) {
		System.out.println("Abraham Zhang");
		Admin admin =  new Admin();
		admin.setId(2);
		admin.setName("abraham");
		admin.setPassWord("password");
		String object = "{'id':2,'name':'abraham','password':'pass'}";
		JSONObject jsonObject = new JSONObject().fromObject(object);
		return jsonObject;
		
	}
}
