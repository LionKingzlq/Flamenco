package com.flamenco.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.Aware;
import org.springframework.stereotype.Repository;

import com.flamenco.model.Admin;

@Repository
public class AdminInfoDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmin() {
		try {
			Session session = getSession();
			session.beginTransaction();
			List<Admin> list = session.createSQLQuery("select * from admin").addEntity(Admin.class).list();
			session.getTransaction().commit();
			System.out.println(list);
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
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean checkAdmin(Admin admin) {
		try {
			Session session = getSession();
			session.beginTransaction();

			Query query = session.createSQLQuery("SELECT count(*) FROM admin where admin = '" + admin.getAdmin()
					+ "' and password = '" + admin.getPassWord() + "'");
			session.getTransaction().commit();
			// BigInteger
			int num = Integer.valueOf(query.uniqueResult().toString());
			
			if (num > 0) {
				return true;
			}

			return false;
		} catch (Exception e) {
			System.err.println("checkAdmin:"+e.getMessage());
			return false;
		}
	}
}
