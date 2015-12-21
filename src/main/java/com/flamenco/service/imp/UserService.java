package com.flamenco.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.flamenco.dao.UserInfoDao;
import com.flamenco.service.IUserService;


@Service("userService")
@Repository
public class UserService extends BaseService implements IUserService {
//    private static final Log log = LogFactory.getLog(UserService.class);
    
    private UserInfoDao userDao;

    public UserInfoDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(UserInfoDao userDao) {
        this.userDao = userDao;
    }

	@Override
	public Object get(Object object) {
		return null;
	}

	@Override
	public List getAll() {
		return null;
	}
}