package com.flamenco.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.flamenco.dao.ResGroupDao;
import com.flamenco.model.ResGroup;
import com.flamenco.service.IResGroup;

@Service(value="resGroupService")
@Repository(value="resGroupService")
public class ResGroupService extends BaseService implements IResGroup{

	ResGroupDao resGroupDao;
	public ResGroupDao getResGroupDao() {
		return resGroupDao;
	}
	
	@Resource
	public void setResGroupDao(ResGroupDao resGroupDao) {
		this.resGroupDao = resGroupDao;
	}
	
	@Override
	public Object get(Object object) {
		return resGroupDao.get((ResGroup)object);
	}

	@Override
	public List getAll() {
		return resGroupDao.getAll();
	}

}
