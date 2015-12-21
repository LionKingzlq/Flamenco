package com.flamenco.service.imp;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flamenco.dao.AdminInfoDao;
import com.flamenco.model.Admin;
import com.flamenco.service.IAdminService;

@Service(value = "adminService")
@Repository
public class AdminService extends BaseService implements IAdminService {

	private AdminInfoDao adminDao;

	public AdminInfoDao getUserDao() {
		return adminDao;
	}

	@Resource
	public void setUserDao(AdminInfoDao adminDao) {
		this.adminDao = adminDao;
	}

	@Transactional(readOnly = true, rollbackFor = Throwable.class)
	@Override
	public List<Admin> getAllAdmin() {
		return adminDao.getAllAdmin();
	}

	@Override
	public boolean checkAdmin(Admin admin) {
		return adminDao.checkAdmin(admin);
	}
	
	@Override
	public Object get(Object object) {
		return null;
	}
	@Override
	public List getAll() {
		return null;
	}
}
