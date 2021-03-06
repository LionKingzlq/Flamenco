package com.flamenco.service.imp;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.flamenco.AdminController;
import com.flamenco.dao.BaseDao;
import com.flamenco.service.IBaseService;

@Service(value = "baseService")
@Repository
public abstract class BaseService implements IBaseService {
	private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

	private BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	@Resource
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public boolean save(Object object) {
		try {
			Session session = baseDao.getSession();
			session.beginTransaction();
			session.save(object);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Object object) {
		try {
			Session session = baseDao.getSession();
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("keyword:delete:" + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean modify(Object object) {
		try {
			Session session = baseDao.getSession();
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
