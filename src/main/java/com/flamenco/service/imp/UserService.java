package com.flamenco.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.flamenco.dao.UserInfoDao;
import com.flamenco.model.User;
import com.flamenco.service.IUserService;


@Service(value="userService")
@Repository
public class UserService extends BaseService implements IUserService {
    
    private UserInfoDao userInfoDao;

    public UserInfoDao getuserInfoDao() {
        return userInfoDao;
    }

    @Resource(name="userInfoDao")
    public void setuserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

	@Override
	public Object get(Object object) {
		return userInfoDao.get((User)object);
	}

	@Override
	public List getAll() {
		return userInfoDao.getAll();
	}
}