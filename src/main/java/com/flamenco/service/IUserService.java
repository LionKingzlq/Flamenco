package com.flamenco.service;

import com.flamenco.model.User;

public interface IUserService extends IBaseService{

	public User login(User user);
}
