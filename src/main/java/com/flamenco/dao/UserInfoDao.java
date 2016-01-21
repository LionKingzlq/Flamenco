package com.flamenco.dao;

import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.flamenco.model.User;

@Repository(value="userInfoDao")
public class UserInfoDao extends BaseDao {

	public Object get(User user){
		try {
			Session session = getSession();
			session.beginTransaction();
			Object object = session.get(User.class, (user).getId());
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
			List<User> list = session.createSQLQuery("SELECT * FROM user").addEntity(User.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}
	
}
