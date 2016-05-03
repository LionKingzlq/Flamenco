package com.flamenco.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.flamenco.model.Admin;

@Repository(value="adminDao")
public class AdminDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmin() {
		try {
			Session session = getSession();
			session.beginTransaction();
			List<Admin> list = session.createSQLQuery("select * from admin").addEntity(Admin.class).list();
			session.getTransaction().commit();
			releaseSession(session);
			return list;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public boolean modifyAdmin(Admin admin) {
		try {
			Session session = getSession();
			session.beginTransaction();
			session.update(admin);
			session.getTransaction().commit();
			releaseSession(session);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean addAdmin(Admin admin) {
		try {
			Session session = getSession();
			session.beginTransaction();
			session.save(admin);
			session.getTransaction().commit();
			releaseSession(session);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean deleteAdmin(Admin admin) {
		try {
			Session session = getSession();
			session.beginTransaction();
			session.delete(admin);
			session.getTransaction().commit();
			releaseSession(session);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public int checkAdmin(Admin admin) {
		try {
			Session session = getSession();
			session.beginTransaction();

			Query query = session.createSQLQuery("SELECT id FROM admin where name = '" + admin.getName()
					+ "' and passWord = '" + admin.getPassWord() + "'");
			session.getTransaction().commit();
			Object object = query.uniqueResult();
			releaseSession(session);
			if(object!=null){
				return Integer.valueOf(object.toString());
			}
			return 0;
		} catch (Exception e) {
			System.err.println("checkAdmin:"+e.getMessage());
			return 0;
		}
	}
	
}
