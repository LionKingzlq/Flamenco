package com.flamenco.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.flamenco.dao.TeachResDao;
import com.flamenco.model.TeachRes;
import com.flamenco.service.ITeachService;
import com.flamenco.util.FileOperateUtil;

@Service(value="teachService")
public class TeachResService extends BaseService implements ITeachService {

	private static final Logger logger = LoggerFactory.getLogger(BaseService.class);
	
	@Resource
	private TeachResDao teachResDao;
	@Resource
	FileOperateUtil fileOperateUtil;
	
	@Override
	public Object get(Object object) {
		return teachResDao.get((TeachRes)object);
	}

	@Override
	public boolean delete(Object object) {
		TeachRes teachRes = (TeachRes)teachResDao.get((TeachRes)object);
		boolean flag = fileOperateUtil.deleteFile(teachRes.getContent());
		if(flag){
			return teachResDao.delete(teachRes);
		}
		return false; 
	}
	public List getAll(int resGroupId) {
		return teachResDao.getAll(resGroupId);
	}

	@Override
	public List getAll() {
		return null;
	}
	
	@Override
	public boolean save(Object object) {
		return teachResDao.save((TeachRes)object);
	}

}
