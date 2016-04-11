package com.flamenco;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flamenco.model.ResGroup;
import com.flamenco.model.TeachRes;
import com.flamenco.service.ITeachService;
import com.flamenco.util.FileOperateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping(value="teachres")
public class TeachResController {

	private static final Logger logger = LoggerFactory.getLogger(TeachResController.class);
	
	@Resource
	private ITeachService teachService;
	
	@Resource(name = "fileOperateUtil")
	private FileOperateUtil fileOperateUtil;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String GetFavoriteList(Locale locale, Model model) {
		return "503";
	}
	
	@RequestMapping(value = "addTeachRes", method = RequestMethod.POST)
	public String addTeachRes(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			TeachRes teachRes = new TeachRes();
			System.out.println("key:"+request.getParameter("type"));
			
			teachRes.setType(Integer.valueOf(request.getParameter("type")));
			teachRes.setDifficulty(Integer.valueOf(request.getParameter("difficult")));
			teachRes.setGroupId(Integer.valueOf(request.getParameter("resGroupId")));
			teachRes.setAdminId(1);
			teachRes.setContent(fileOperateUtil.upLoadFile(request,false));
			teachService.save(teachRes);
		} catch (Exception e) {
			logger.debug("memberAddList:" + e.getMessage());
		}
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="teachResList", method=RequestMethod.GET)
	public JSONObject getTeachResList(int resGroupId) {
		
		List<TeachRes> teachReses = teachService.getAll(resGroupId);
		JSONArray userArray = JSONArray.fromObject(teachReses);
		JSONObject data = new JSONObject();
		data.put("array", userArray);
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteTeachRes", method=RequestMethod.GET)
	public JSONObject deleteTeachRes(int teachResId) {
		
		TeachRes teachRes = new TeachRes();
		teachRes.setId(teachResId);
		boolean flag = teachService.delete(teachRes);
		JSONObject data = new JSONObject();
		data.put("result", flag);
		return data;
	}
}
