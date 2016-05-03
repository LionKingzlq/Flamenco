package com.flamenco.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.flamenco.model.ResGroup;
import com.flamenco.model.TeachRes;

@Repository(value="resGroupDao")
public class ResGroupDao extends BaseDao {
	
	public Object get(ResGroup resGroup){
		try {
			Session session = getSession();
			session.beginTransaction();
			List list = session.createSQLQuery("SELECT * FROM resGroup LEFT JOIN (SELECT Id AS adminId, name AS adminName FROM admin) AS A ON A.adminId = resGroup.adminId WHERE resGroup.id = " + resGroup.getId()).addEntity(ResGroup.class).list();
			session.getTransaction().commit();
			releaseSession(session);
			return list.get(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public List getAll(){
		try {
			Session session = getSession();
			session.beginTransaction();
			List list = session.createSQLQuery("SELECT * FROM resGroup LEFT JOIN (SELECT Id AS adminId, name AS adminName FROM admin) AS A ON A.adminId = resGroup.adminId").addEntity(ResGroup.class).list();
			session.getTransaction().commit();
			releaseSession(session);
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public boolean save(ResGroup resGroup) {
		try {
			Session session = getSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("INSERT INTO resGroup (name, description, adminId) VALUES (?,?,?)");
			
			sqlQuery.setString(0, resGroup.getName());
			sqlQuery.setString(1, resGroup.getDescription());
			sqlQuery.setInteger(2, resGroup.getAdminId());
			sqlQuery.addEntity(ResGroup.class);
			
			int num = sqlQuery.executeUpdate();
			session.getTransaction().commit();
			releaseSession(session);
			if(num != 0){
				return true;
			}			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	
}
