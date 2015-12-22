package com.flamenco.service.imp;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flamenco.dao.AdminDao;
import com.flamenco.model.Admin;
import com.flamenco.service.IAdminService;

@Service(value = "adminService")
@Repository(value="adminService")
public class AdminService extends BaseService implements IAdminService {

	private AdminDao adminDao;

	public AdminDao getUserDao() {
		return adminDao;
	}

	@Resource
	public void setUserDao(AdminDao adminDao) {
		this.adminDao = adminDao;
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
		return adminDao.getAllAdmin();
	}
}
