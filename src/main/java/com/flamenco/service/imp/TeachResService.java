package com.flamenco.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flamenco.dao.TeachResDao;
import com.flamenco.model.TeachRes;
import com.flamenco.service.ITeachService;
import com.flamenco.util.FileOperateUtil;

@Service(value="teachService")
public class TeachResService extends BaseService implements ITeachService {

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
		return fileOperateUtil.deleteFile(teachRes.getContent());
	}
	public List getAll(int resGroupId) {
		return teachResDao.getAll(resGroupId);
	}

	@Override
	public List getAll() {
		return null;
	}

}
