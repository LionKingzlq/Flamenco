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
import org.springframework.web.bind.annotation.ResponseBody;

import com.flamenco.model.ResGroup;
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
	
	//添加分组
	@RequestMapping(value="addResGroup", method=RequestMethod.POST)
	public String addCatalog(String catalogName, String catalogDescription) {
		
		System.out.println(catalogName+":key");
		
		ResGroup resGroup = new ResGroup();
		resGroup.setName(catalogName);
		resGroup.setDescription(catalogDescription);
		resGroup.setAdminId(1);
		
		resGroupService.save(resGroup);
		return "index";
	}
	
	//获取分组列表
	@ResponseBody
	@RequestMapping(value="resGroupList", method=RequestMethod.GET)
	public JSONObject getResGroupList() {
		
		List<ResGroup> resGroups = resGroupService.getAll();
		JSONArray userArray = JSONArray.fromObject(resGroups);
		JSONObject data = new JSONObject();
		data.put("array", userArray);
		return data;
	}
	
	//分页刷新处理，占时用不到吧
	@ResponseBody
	@RequestMapping(value="resGroupListInPage", method=RequestMethod.GET)
	public JSONObject getCatalogList(int pageNum) {
		
		List<ResGroup> resGroups = resGroupService.getAll();
		JSONArray userArray = JSONArray.fromObject(resGroups);
		JSONObject data = new JSONObject();
		data.put("array", userArray);
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteResGroup", method=RequestMethod.GET)
	public JSONObject deleteCatalog(int resGroupId) {
		ResGroup resGroup = new ResGroup();
		resGroup.setId(resGroupId);
		JSONObject data = new JSONObject();
		data.put("result",resGroupService.delete(resGroup));
		return data;
	}
	
	//获取单个分组的信息
	@ResponseBody
	@RequestMapping(value="getResGroup", method=RequestMethod.GET)
	public JSONObject getResGroup(int resGroupId) {
		ResGroup resGroup = new ResGroup();
		resGroup.setId(resGroupId);
		JSONObject data = new JSONObject();
		data.put("data",(ResGroup)resGroupService.get(resGroup));
		return data;
	}
}
