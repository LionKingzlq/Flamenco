package com.flamenco.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.flamenco.model.TeachRes;

@Repository(value="teachResDao")
public class TeachResDao extends BaseDao{

	public Object get(TeachRes teachRes){
		try {
			Session session = getSession();
			session.beginTransaction();
			List list = session.createSQLQuery("SELECT * FROM teachRes INNER JOIN (SELECT id AS adminId,name as adminName from admin) AS A on teachRes.adminId = A.adminId WHERE teachRes.id="+teachRes.getId()).addEntity(TeachRes.class).list();
			session.getTransaction().commit();
			return list.get(0);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List getAll(int resGroupId){
		try {
			Session session = getSession();
			session.beginTransaction();
			List list = session.createSQLQuery("SELECT * FROM teachRes INNER JOIN (SELECT id AS adminId,name as adminName from admin) AS A on teachRes.adminId = A.adminId WHERE groupId="+resGroupId).addEntity(TeachRes.class).list();
			session.getTransaction().commit();
			releaseSession(session);
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public boolean save(TeachRes teachRes) {
		try {
			Session session = getSession();
			session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("INSERT INTO teachRes (groupId, content, type, difficulty, adminId) VALUES (?,?,?,?,?)");
			
			sqlQuery.setInteger(0, teachRes.getGroupId());
			sqlQuery.setString(1, teachRes.getContent());
			sqlQuery.setInteger(2, teachRes.getType());
			sqlQuery.setInteger(3, teachRes.getDifficulty());
			sqlQuery.setInteger(4, teachRes.getAdminId());
			sqlQuery.addEntity(TeachRes.class);
			
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
	
	public boolean delete(Object object) {
		try {
			Session session = getSession();
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
			releaseSession(session);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
}
