package com.flamenco.service.imp;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.flamenco.dao.UserInfoDao;
import com.flamenco.service.IUserService;


@Service("userService")
@Repository
public class UserService implements IUserService {
    private static final Log log = LogFactory.getLog(UserService.class);
    private UserInfoDao userDao;

    public UserInfoDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(UserInfoDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public int addUser(String userName) throws Exception {
        log.info("----------------addUser---------------");
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserName(userName);
//        userDao.getSession().save(userInfo);
        return 1;
    }
}