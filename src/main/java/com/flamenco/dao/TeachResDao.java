package com.flamenco.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.flamenco.model.ResGroup;
import com.flamenco.model.TeachRes;

@Repository
public class TeachResDao extends BaseDao{

	public Object get(TeachRes teachRes){
		try {
			Session session = getSession();
			session.beginTransaction();
			Object object = session.get(ResGroup.class, (teachRes).getId());
			session.getTransaction().commit();
			return object;	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List getAll(int resGroupId){
		try {
			Session session = getSession();
			session.beginTransaction();
			List list = session.createSQLQuery("SELECT * FROM teachRes WHERE groupId="+resGroupId).addEntity(TeachRes.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
