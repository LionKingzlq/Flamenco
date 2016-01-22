package com.flamenco;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flamenco.model.ResGroup;
import com.flamenco.model.User;
import com.flamenco.service.IResGroupService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="resgroup")
public class ResGroupController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Resource(name="resGroupService")
	private IResGroupService resGroupService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String GetFavoriteList(Locale locale, Model model) {
		return "503";
	}
	@RequestMapping(value="addCatalog", method=RequestMethod.POST)
	public String addCatalog(String catalogName, String catalogDescription) {
		ResGroup resGroup = new ResGroup();
		resGroup.setName(catalogName);
		resGroup.setDescription(catalogDescription);
		resGroupService.save(resGroup);
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="catalogListInPage", method=RequestMethod.GET)
	public JSONObject getCatalogList(int pageNum) {
		
		List<ResGroup> resGroups = resGroupService.getAll();
		JSONArray userArray = JSONArray.fromObject(resGroups);
		JSONObject data = new JSONObject();
		data.put("array", userArray);
		return data;
	}
}
