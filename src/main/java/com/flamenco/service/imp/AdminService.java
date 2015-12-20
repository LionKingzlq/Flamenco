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

@Service(value="adminService")
@Repository
public class AdminService implements IAdminService{

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
		
		Session session = adminDao.getSession();
		session.beginTransaction();
		List<Admin> list = session.createSQLQuery("select * from admin").addEntity(Admin.class).list();
		session.getTransaction().commit();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getAdmin());
		}
		return null;
	}

}
