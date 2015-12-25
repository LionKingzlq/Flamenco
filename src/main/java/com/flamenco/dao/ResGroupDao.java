package com.flamenco.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.flamenco.model.ResGroup;

@Repository(value="resGroupDao")
public class ResGroupDao extends BaseDao {
	
	public Object get(ResGroup resGroup){
		try {
			Session session = getSession();
			session.beginTransaction();
			Object object = session.get(ResGroup.class, (resGroup).getId());
			session.getTransaction().commit();
			return object;	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public List getAll(){
		try {
			Session session = getSession();
			session.beginTransaction();
			List list = session.createSQLQuery("SELECT * FROM resgroup").addEntity(ResGroup.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}
}
